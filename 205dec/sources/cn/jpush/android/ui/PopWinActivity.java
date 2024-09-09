package cn.jpush.android.ui;

import android.app.Activity;
import android.os.Bundle;
import cn.jpush.android.local.ProxyActivityAction;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class PopWinActivity extends Activity {
    private static final String TAG = "PopWinActivity";
    private ProxyActivityAction activityAction;

    static {
        StubApp.interface11(4544);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        ProxyActivityAction proxyActivityAction = this.activityAction;
        if (proxyActivityAction != null) {
            proxyActivityAction.onBackPressed(this);
        }
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    protected void onDestroy() {
        ProxyActivityAction proxyActivityAction = this.activityAction;
        if (proxyActivityAction != null) {
            proxyActivityAction.onDestroy(this);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        ProxyActivityAction proxyActivityAction = this.activityAction;
        if (proxyActivityAction != null) {
            proxyActivityAction.onResume(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        ProxyActivityAction proxyActivityAction = this.activityAction;
        if (proxyActivityAction != null) {
            proxyActivityAction.onResume(this);
        }
    }

    public void startPushActivity(String str) {
        if (this.activityAction != null) {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            this.activityAction.onEvent(this, "start_push_activity", bundle);
        }
    }
}
