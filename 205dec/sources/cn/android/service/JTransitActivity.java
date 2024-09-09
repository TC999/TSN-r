package cn.android.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.jpush.android.local.ActionHelper;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class JTransitActivity extends Activity {
    static {
        StubApp.interface11(3399);
    }

    private void a(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            ActionHelper.getInstance().handleNotificationIntent(StubApp.getOrigApplicationContext(getApplicationContext()), intent);
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        try {
            super.onNewIntent(intent);
            a(intent);
        } catch (Throwable unused) {
        }
    }
}
