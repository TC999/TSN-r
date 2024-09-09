package cn.jpush.android.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.jpush.android.local.ActionHelper;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class JNotifyActivity extends Activity {
    private static final String TAG = "JNotifyActivity";

    static {
        StubApp.interface11(4516);
    }

    private void handleIntent(Intent intent) {
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
            handleIntent(intent);
        } catch (Throwable unused) {
        }
    }
}
