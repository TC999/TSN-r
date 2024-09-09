package com.acse.ottn.activity;

import android.os.Bundle;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class WhiteActivity extends com.acse.ottn.z {

    /* renamed from: e  reason: collision with root package name */
    public static String f4732e = "ExcessActivity";

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WhiteActivity.this.finish();
        }
    }

    static {
        StubApp.interface11(4689);
    }

    @Override // com.acse.ottn.z, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);
}
