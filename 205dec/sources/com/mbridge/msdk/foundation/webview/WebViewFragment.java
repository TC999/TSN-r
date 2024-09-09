package com.mbridge.msdk.foundation.webview;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.fragment.BaseFragment;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class WebViewFragment extends BaseFragment {
    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BrowserView browserView = new BrowserView(getActivity());
        browserView.loadUrl(getActivity().getIntent().getExtras().getString("msg"));
        browserView.setListener(new BrowserView.a() { // from class: com.mbridge.msdk.foundation.webview.WebViewFragment.1
            @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
            public final void a() {
                WebViewFragment.this.getActivity().finish();
            }

            @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
            public final boolean a(WebView webView, String str) {
                return false;
            }

            @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
            public final void a(WebView webView, String str, Bitmap bitmap) {
                if (ab.a.a(str) && ab.a.a(StubApp.getOrigApplicationContext(WebViewFragment.this.getActivity().getApplicationContext()), str, null)) {
                    WebViewFragment.this.getActivity().finish();
                }
            }
        });
        return browserView;
    }
}
