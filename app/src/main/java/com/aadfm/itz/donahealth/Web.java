package com.aadfm.itz.donahealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Web extends AppCompatActivity {

    private WebView myWebView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);


        myWebView = (WebView) this.findViewById(R.id.webView);
        // myWebView.setWebViewClient(new WebViewClient());
        // myWebView.getSettings().setJavaScriptEnabled(true);

        //habilitamos javascript y el zoom
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setBuiltInZoomControls(true);

        //habilitamos los plugins (flash)
        //  myWebView.getSettings().setPluginsEnabled(true);

        myWebView.loadUrl("http://asociacionale.org/index.php/es/");

        myWebView.setWebViewClient(new WebViewClient()
        {
            // evita que los enlaces se abran fuera nuestra app en el navegador de android
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                return false;
            }

        });

        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        myWebView.setWebChromeClient(new WebChromeClient()
        {
            @Override
            public void onProgressChanged(WebView view, int progress)
            {
                progressBar.setProgress(0);
                progressBar.setVisibility(view.VISIBLE);
                Web.this.setProgress(progress * 1000);

                progressBar.incrementProgressBy(progress);

                if(progress == 100)
                {
                    progressBar.setVisibility(view.GONE);
                }
            }
        });


    }
}
