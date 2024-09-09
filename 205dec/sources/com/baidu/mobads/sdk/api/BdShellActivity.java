package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.mobads.sdk.internal.bv;
import com.stub.StubApp;
import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BdShellActivity extends Activity {
    private static boolean canShowWhenLock;
    private static ActionBarColorTheme mSActionBarColorTheme;
    private bv mAdLogger = bv.a();
    private ClassLoader mLoader;
    private IActivityImpl mProxyActivity;

    static {
        StubApp.interface11(8453);
        mSActionBarColorTheme = ActionBarColorTheme.ACTION_BAR_WHITE_THEME;
    }

    public static void canLpShowWhenLocked(boolean z3) {
        canShowWhenLock = z3;
    }

    public static ActionBarColorTheme getActionBarColorTheme() {
        return mSActionBarColorTheme;
    }

    public static Class<?> getActivityClass() {
        return BdShellActivity.class;
    }

    public static boolean getLpShowWhenLocked() {
        return canShowWhenLock;
    }

    public static void setActionBarColor(int i4, int i5, int i6, int i7) {
        mSActionBarColorTheme = new ActionBarColorTheme(i4, i5, i6, i7);
    }

    public static void setActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
        if (actionBarColorTheme != null) {
            mSActionBarColorTheme = new ActionBarColorTheme(actionBarColorTheme);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.dispatchKeyEvent(keyEvent) : false) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.dispatchTouchEvent(motionEvent) : false) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i4, int i5, Intent intent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onActivityResult(i4, i5, intent);
        }
        super.onActivityResult(i4, i5, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onAttachedToWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onConfigurationChanged(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    protected void onDestroy() {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onDestroy();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.onKeyDown(i4, keyEvent) : false) {
            return true;
        }
        return super.onKeyDown(i4, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i4, KeyEvent keyEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.onKeyUp(i4, keyEvent) : false) {
            return true;
        }
        return super.onKeyUp(i4, keyEvent);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onNewIntent(intent);
        }
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onRestoreInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onStart();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onStop();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.onTouchEvent(motionEvent) : false) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onWindowFocusChanged(z3);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i4, int i5) {
        super.overridePendingTransition(i4, i5);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.overridePendingTransition(i4, i5);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class ActionBarColorTheme implements Serializable {
        public int backgroundColor;
        public int closeColor;
        public int progressColor;
        public int titleColor;
        public static final ActionBarColorTheme ACTION_BAR_WHITE_THEME = new ActionBarColorTheme(-5987164, -6842473, -11113262, -328966);
        public static final ActionBarColorTheme ACTION_BAR_RED_THEME = new ActionBarColorTheme(-1, -1, -12510, -1294276);
        public static final ActionBarColorTheme ACTION_BAR_GREEN_THEME = new ActionBarColorTheme(-1, -1, -11113262, -14303071);
        public static final ActionBarColorTheme ACTION_BAR_NAVYBLUE_THEME = new ActionBarColorTheme(-1, -1, 16764706, -14210226);
        public static final ActionBarColorTheme ACTION_BAR_BLUE_THEME = new ActionBarColorTheme(-1, -1, -12510, -13870424);
        public static final ActionBarColorTheme ACTION_BAR_COFFEE_THEME = new ActionBarColorTheme(-1, -1, -12510, -11255230);
        public static final ActionBarColorTheme ACTION_BAR_BLACK_THEME = new ActionBarColorTheme(-1, -1, -12510, -13749450);

        public ActionBarColorTheme(int i4, int i5, int i6, int i7) {
            this.closeColor = i4;
            this.titleColor = i5;
            this.progressColor = i6;
            this.backgroundColor = i7;
        }

        public boolean equals(Object obj) {
            ActionBarColorTheme actionBarColorTheme = (ActionBarColorTheme) obj;
            return this.backgroundColor == actionBarColorTheme.backgroundColor && this.titleColor == actionBarColorTheme.titleColor && this.closeColor == actionBarColorTheme.closeColor && this.progressColor == actionBarColorTheme.progressColor;
        }

        public int getBackgroundColor() {
            return this.backgroundColor;
        }

        public int getCloseColor() {
            return this.closeColor;
        }

        public int getProgressColor() {
            return this.progressColor;
        }

        public int getTitleColor() {
            return this.titleColor;
        }

        public void setBackgroundColor(int i4) {
            this.backgroundColor = i4;
        }

        public void setCloseColor(int i4) {
            this.closeColor = i4;
        }

        public void setProgressColor(int i4) {
            this.progressColor = i4;
        }

        public void setTitleColor(int i4) {
            this.titleColor = i4;
        }

        public ActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
            this.closeColor = actionBarColorTheme.closeColor;
            this.titleColor = actionBarColorTheme.titleColor;
            this.progressColor = actionBarColorTheme.progressColor;
            this.backgroundColor = actionBarColorTheme.backgroundColor;
        }
    }
}
