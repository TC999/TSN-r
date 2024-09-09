package cn.jpush.android.local;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class ProxyActivityAction {
    public abstract void onBackPressed(Activity activity);

    public abstract void onConfigurationChanged(Activity activity, Configuration configuration);

    public abstract void onCreate(Activity activity, Bundle bundle);

    public abstract boolean onCreateOptionsMenu(Activity activity, Menu menu);

    public abstract void onDestroy(Activity activity);

    public abstract void onEvent(Activity activity, String str, Bundle bundle);

    public abstract boolean onKeyDown(Activity activity, int i4, KeyEvent keyEvent);

    public abstract void onNewIntent(Activity activity, Intent intent);

    public abstract void onPause(Activity activity);

    public abstract void onRestart(Activity activity);

    public abstract void onResume(Activity activity);

    public abstract void onStart(Activity activity, Intent intent);

    public abstract void onStop(Activity activity);
}
