package cn.jpush.android.webview.bridge;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private ProgressBar f4506a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f4507b;

    public a(String str, Class cls, ProgressBar progressBar, TextView textView) {
        super(str, cls);
        this.f4506a = progressBar;
        this.f4507b = textView;
        if (progressBar != null) {
            progressBar.setMax(100);
        }
        TextView textView2 = this.f4507b;
        if (textView2 != null) {
            textView2.setSingleLine(true);
            this.f4507b.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    @Override // cn.jpush.android.webview.bridge.b, android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // cn.jpush.android.webview.bridge.b, android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // cn.jpush.android.webview.bridge.b, android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i4) {
        super.onProgressChanged(webView, i4);
        ProgressBar progressBar = this.f4506a;
        boolean z3 = false;
        if (progressBar != null) {
            if (100 == i4) {
                progressBar.setVisibility(8);
            } else {
                progressBar.setVisibility(0);
                this.f4506a.setProgress(i4);
            }
        }
        if (this.f4507b == null || webView.getTitle() == null || webView.getTitle().equals(this.f4507b.getText())) {
            return;
        }
        String title = webView.getTitle();
        if ((title.startsWith("http") || title.startsWith("android-app://") || title.startsWith("file://")) ? true : true) {
            return;
        }
        this.f4507b.setText(webView.getTitle());
    }
}
