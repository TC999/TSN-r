package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IActivityImpl {
    boolean dispatchKeyEvent(KeyEvent keyEvent);

    boolean dispatchTouchEvent(MotionEvent motionEvent);

    void onActivityResult(int i4, int i5, Intent intent);

    void onAttachedToWindow();

    boolean onBackPressed();

    void onConfigurationChanged(Configuration configuration);

    void onCreate(Bundle bundle);

    void onDestroy();

    void onDetachedFromWindow();

    boolean onKeyDown(int i4, KeyEvent keyEvent);

    boolean onKeyUp(int i4, KeyEvent keyEvent);

    void onNewIntent(Intent intent);

    void onPause();

    void onRestoreInstanceState(Bundle bundle);

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();

    boolean onTouchEvent(MotionEvent motionEvent);

    void onWindowFocusChanged(boolean z3);

    void overridePendingTransition(int i4, int i5);

    void setActivity(Activity activity);

    void setLpBussParam(JSONObject jSONObject);
}
