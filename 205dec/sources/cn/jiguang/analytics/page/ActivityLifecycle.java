package cn.jiguang.analytics.page;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JAnalyticsAction;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bq.d;
import cn.jiguang.bs.f;
import cn.jiguang.cm.b;
import cn.jiguang.d.a;
import cn.jiguang.internal.JConstants;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@TargetApi(14)
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ActivityLifecycle implements Application.ActivityLifecycleCallbacks {
    private static final String SAVE_KEY = "save_key";
    private static final String TAG = "ActivityLifecycle";
    public static final long WAKE_VIOLATION_COUNT = 5;
    public static final long WAKE_VIOLATION_DURATION = 50;
    public static int activityTaskCount;
    public static long lastWakeTime;
    private WeakReference<Activity> mWeakReference;
    private List<Application.ActivityLifecycleCallbacks> mActivityCallbacks = new ArrayList();
    private boolean isFromSync = false;
    private boolean aidlBuildSuccess = false;

    private void cacheBeforeInit(Activity activity) {
        try {
            if (this.aidlBuildSuccess) {
                clearLocal();
            } else {
                clearLocal();
                this.mWeakReference = new WeakReference<>(activity);
            }
        } catch (Throwable unused) {
        }
    }

    private void clearLocal() {
        WeakReference<Activity> weakReference = this.mWeakReference;
        if (weakReference != null) {
            weakReference.clear();
            this.mWeakReference = null;
        }
    }

    private boolean isTranslucentNotitleTheme(Activity activity) {
        try {
            TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{16842838, 16842841, 16842836, 16842840, 16843435});
            boolean z3 = obtainStyledAttributes.getBoolean(0, false);
            Drawable drawable = obtainStyledAttributes.getDrawable(1);
            int color = obtainStyledAttributes.getColor(2, -1);
            boolean z4 = obtainStyledAttributes.getBoolean(3, false);
            Drawable drawable2 = obtainStyledAttributes.getDrawable(4);
            d.c(TAG, "notitle:" + z3 + ", overlay:" + drawable + ", color:" + color + ", translucent:" + z4 + "background:" + drawable2);
            obtainStyledAttributes.recycle();
            if (z3 && z4 && drawable == null && drawable2 == null) {
                if (color == activity.getResources().getColor(17170445)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            d.i(TAG, "check TranslucentNotitleTheme failed :" + th);
        }
        return false;
    }

    private boolean isWakeActivity(Activity activity) {
        if (activity != null) {
            try {
                if (activity.getIntent() == null || TextUtils.isEmpty(activity.getIntent().getAction())) {
                    return false;
                }
                return "cn.jpush.android.intent.DActivity".equals(activity.getIntent().getAction());
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    private void reportWakeViolation(final Context context) {
        cn.jiguang.cm.d.a("FUTURE_TASK", new b() { // from class: cn.jiguang.analytics.page.ActivityLifecycle.1
            @Override // cn.jiguang.cm.b
            public void a() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    a.a(context, jSONObject, "wake_violation");
                    f.a(context, jSONObject);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void addActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks != null) {
            try {
                if (this.mActivityCallbacks == null) {
                    this.mActivityCallbacks = new ArrayList();
                }
                this.mActivityCallbacks.add(activityLifecycleCallbacks);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            JAnalyticsAction jAnalyticsAction = JConstants.jAnalyticsAction;
            if (jAnalyticsAction != null) {
                jAnalyticsAction.dispatchStatus(activity, "onCreate");
            }
            if (this.aidlBuildSuccess) {
                for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.mActivityCallbacks) {
                    activityLifecycleCallbacks.onActivityCreated(activity, bundle);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        try {
            if (this.aidlBuildSuccess) {
                for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.mActivityCallbacks) {
                    activityLifecycleCallbacks.onActivityDestroyed(activity);
                }
            }
            if (activityTaskCount == 0 && activity != null && JConstants.isCallInit.get()) {
                JCoreManager.onEvent(StubApp.getOrigApplicationContext(activity.getApplicationContext()), JConstants.SDK_TYPE, 110, null, null, new Object[0]);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        try {
            JAnalyticsAction jAnalyticsAction = JConstants.jAnalyticsAction;
            if (jAnalyticsAction != null) {
                jAnalyticsAction.dispatchPause(activity);
            }
            if (this.aidlBuildSuccess) {
                for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.mActivityCallbacks) {
                    activityLifecycleCallbacks.onActivityPaused(activity);
                }
            }
            if (JConstants.isInstrumentationHookFailed || !JConstants.isCallInit.get()) {
                return;
            }
            PushSA.getInstance().onPause(activity);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        try {
            JAnalyticsAction jAnalyticsAction = JConstants.jAnalyticsAction;
            if (jAnalyticsAction != null) {
                jAnalyticsAction.dispatchResume(activity);
            }
            if (this.aidlBuildSuccess) {
                for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.mActivityCallbacks) {
                    activityLifecycleCallbacks.onActivityResumed(activity);
                }
            }
            if (JConstants.isInstrumentationHookFailed || !JConstants.isCallInit.get()) {
                return;
            }
            PushSA.getInstance().onResume(activity);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        try {
            if (this.aidlBuildSuccess) {
                for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.mActivityCallbacks) {
                    activityLifecycleCallbacks.onActivitySaveInstanceState(activity, bundle);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        try {
            JAnalyticsAction jAnalyticsAction = JConstants.jAnalyticsAction;
            if (jAnalyticsAction != null) {
                jAnalyticsAction.dispatchStatus(activity, "onStart");
            }
            if (this.aidlBuildSuccess) {
                for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.mActivityCallbacks) {
                    activityLifecycleCallbacks.onActivityStarted(activity);
                }
            }
            cacheBeforeInit(activity);
            if (activityTaskCount == 0 && JConstants.isCallInit.get()) {
                d.c(TAG, "isForeground");
                if (activity != null) {
                    JCoreManager.onEvent(StubApp.getOrigApplicationContext(activity.getApplicationContext()), JConstants.SDK_TYPE, 66, null, null, 1);
                }
            }
            if (this.isFromSync) {
                return;
            }
            activityTaskCount++;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        try {
            if (this.aidlBuildSuccess) {
                for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.mActivityCallbacks) {
                    activityLifecycleCallbacks.onActivityStopped(activity);
                }
            }
            int i4 = activityTaskCount;
            if (i4 > 0) {
                activityTaskCount = i4 - 1;
            }
            d.c(TAG, "onActivityStopped activityTaskCount:" + activityTaskCount);
            if (activityTaskCount == 0 && JConstants.isCallInit.get()) {
                d.c(TAG, "is not Foreground");
                JCoreManager.onEvent(StubApp.getOrigApplicationContext(activity.getApplicationContext()), JConstants.SDK_TYPE, 66, null, null, 0);
            }
        } catch (Throwable unused) {
        }
    }

    public void removeActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks != null) {
            try {
                this.mActivityCallbacks.remove(activityLifecycleCallbacks);
            } catch (Throwable unused) {
            }
        }
    }

    public void sendCurrentState() {
        Activity activity;
        try {
            this.aidlBuildSuccess = true;
            Application a4 = cn.jiguang.f.f.a();
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(activityTaskCount == 0 ? 0 : 1);
            JCoreManager.onEvent(a4, JConstants.SDK_TYPE, 66, null, null, objArr);
            if (activityTaskCount <= 0) {
                return;
            }
            WeakReference<Activity> weakReference = this.mWeakReference;
            if (weakReference != null && (activity = weakReference.get()) != null && !activity.isFinishing()) {
                this.isFromSync = true;
                onActivityCreated(activity, null);
                onActivityStarted(activity);
                onActivityResumed(activity);
                this.isFromSync = false;
            }
            clearLocal();
        } catch (Throwable unused) {
        }
    }
}
