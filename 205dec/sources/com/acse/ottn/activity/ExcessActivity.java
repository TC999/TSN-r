package com.acse.ottn.activity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ExcessActivity extends com.acse.ottn.z {

    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private class a extends WebChromeClient {
        private a() {
        }

        /* synthetic */ a(ExcessActivity excessActivity, x xVar) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i4) {
            super.onProgressChanged(webView, i4);
        }
    }

    static {
        StubApp.interface11(4670);
    }

    @Override // com.acse.ottn.z, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);
}
