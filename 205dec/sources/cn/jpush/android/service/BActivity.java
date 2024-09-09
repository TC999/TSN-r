package cn.jpush.android.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.jiguang.af.g;
import cn.jiguang.ah.d;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import cn.jiguang.w.a;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class BActivity extends Activity {
    private static final String TAG = "BActivity";

    private void handleStart() {
        try {
            g.a(StubApp.getOrigApplicationContext(getApplicationContext()), getIntent() != null ? getIntent().getExtras() : null, 8);
        } catch (Throwable th) {
            a.b(TAG, "handle start error#" + th);
        }
        try {
            finish();
        } catch (Throwable th2) {
            a.b(TAG, "finish error#" + th2);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.b(TAG, "BActivity oncreate");
        if (d.c(StubApp.getOrigApplicationContext(getApplicationContext())) > 0 && JConstants.isInstrumentationHookFailed) {
            JCoreManager.init(StubApp.getOrigApplicationContext(getApplicationContext()));
        }
        handleStart();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a.b(TAG, "BActivity onNewIntent");
        handleStart();
    }
}
