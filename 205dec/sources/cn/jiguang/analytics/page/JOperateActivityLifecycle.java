package cn.jiguang.analytics.page;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bq.d;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.local.JPushConstants;
import com.stub.StubApp;

@TargetApi(14)
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class JOperateActivityLifecycle implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "JOperateActivityLifecycle";
    private static JOperateActivityLifecycle mJOperateActivityLifecycle;

    private static final void activityLifecycle(String str, Activity activity) {
        String name = activity.getClass().getName();
        d.c(TAG, "activityLifecycle:" + str + ",activity:" + name);
        Bundle bundle = new Bundle();
        bundle.putString("lifecycle_name", str);
        bundle.putString("activity_name", name);
        bundle.putInt("activity_hash", activity.hashCode());
        Intent intent = activity.getIntent();
        if (intent != null) {
            bundle.putParcelable("activity_intent", intent);
        }
        if (JConstants.isCallInit.get()) {
            JCoreManager.onEvent(StubApp.getOrigApplicationContext(activity.getApplicationContext()), JPushConstants.SDK_TYPE, 89, "activity_lifecycle", bundle, new Object[0]);
        }
    }

    public static JOperateActivityLifecycle getInstance() {
        if (mJOperateActivityLifecycle == null) {
            synchronized (JOperateActivityLifecycle.class) {
                if (mJOperateActivityLifecycle == null) {
                    mJOperateActivityLifecycle = new JOperateActivityLifecycle();
                }
            }
        }
        return mJOperateActivityLifecycle;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        activityLifecycle("onActivityCreated", activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        activityLifecycle("onActivityDestroyed", activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        activityLifecycle("onActivityPaused", activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        activityLifecycle("onActivityResumed", activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        activityLifecycle("onActivitySaveInstanceState", activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        activityLifecycle("onActivityStarted", activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        activityLifecycle("onActivityStopped", activity);
    }
}
