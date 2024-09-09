package cn.jpush.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.jpush.android.local.ProxyActivityAction;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class PushActivity extends Activity {
    public static final String FROM_OTHER_WAY = "from_way";
    public static final String FROM_UNION_AD = "from_union_ad";
    private static final String TAG = "PushActivity";
    private ProxyActivityAction activityAction;

    static {
        StubApp.interface11(4545);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
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
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ProxyActivityAction proxyActivityAction = this.activityAction;
        if (proxyActivityAction != null) {
            proxyActivityAction.onNewIntent(this, intent);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        ProxyActivityAction proxyActivityAction = this.activityAction;
        if (proxyActivityAction != null) {
            proxyActivityAction.onPause(this);
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

    public void showTitleBar() {
        ProxyActivityAction proxyActivityAction = this.activityAction;
        if (proxyActivityAction != null) {
            proxyActivityAction.onEvent(this, "push_show_titlebar", null);
        }
    }
}
