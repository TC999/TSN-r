package cn.jpush.android.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.jiguang.bq.d;
import cn.jiguang.d.a;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class DownloadActivity extends Activity {
    private static final String TAG = "DownloadActivity";

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.c(TAG, "DownloadActivity onCreate");
        try {
            a.a(StubApp.getOrigApplicationContext(getApplicationContext()), getIntent());
        } catch (Throwable unused) {
        }
        finish();
    }

    @Override // android.app.Activity
    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        d.c(TAG, "DownloadActivity onNewIntent");
        try {
            a.a(StubApp.getOrigApplicationContext(getApplicationContext()), intent);
        } catch (Throwable unused) {
        }
        finish();
    }

    @Override // android.app.Activity
    protected final void onRestart() {
        super.onRestart();
    }

    @Override // android.app.Activity
    protected final void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected final void onStart() {
        super.onStart();
    }
}
