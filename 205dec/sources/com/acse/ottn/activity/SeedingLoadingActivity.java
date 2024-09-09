package com.acse.ottn.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import com.acse.ottn.t3;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class SeedingLoadingActivity extends com.acse.ottn.z {

    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class a extends FrameLayout {
        public a(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private class b extends WebChromeClient {
        private b() {
        }

        /* synthetic */ b(SeedingLoadingActivity seedingLoadingActivity, D d4) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i4) {
            super.onProgressChanged(webView, i4);
        }
    }

    static {
        StubApp.interface11(4679);
    }

    @Override // com.acse.ottn.z, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        t3.a().c();
    }

    @Override // com.acse.ottn.z, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // com.acse.ottn.z, androidx.fragment.app.FragmentActivity, android.app.Activity
    @RequiresApi(api = 21)
    public void onPause() {
        super.onPause();
        finishAndRemoveTask();
        finish();
    }
}
