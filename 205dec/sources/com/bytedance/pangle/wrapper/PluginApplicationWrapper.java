package com.bytedance.pangle.wrapper;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.i;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@Keep
@SuppressLint({"MissingSuperCall", "NewApi"})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class PluginApplicationWrapper extends Application {
    public Application mOriginApplication;
    public PluginContext mPluginContext;

    public PluginApplicationWrapper(Application application, PluginContext pluginContext) {
        this.mOriginApplication = application;
        this.mPluginContext = pluginContext;
        try {
            FieldUtils.writeField(this, "mBase", pluginContext);
            if (i.a()) {
                return;
            }
            FieldUtils.writeField(FieldUtils.getField(ContextWrapper.class, "mBase"), this, pluginContext);
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        return this.mPluginContext.getDataDir();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        this.mOriginApplication.onConfigurationChanged(configuration);
    }

    @Override // android.app.Application
    public void onCreate() {
        this.mOriginApplication.onCreate();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mOriginApplication.onLowMemory();
    }

    @Override // android.app.Application
    public void onTerminate() {
        this.mOriginApplication.onTerminate();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i4) {
        this.mOriginApplication.onTrimMemory(i4);
    }

    @Override // android.app.Application
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mOriginApplication.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Application
    public void registerOnProvideAssistDataListener(Application.OnProvideAssistDataListener onProvideAssistDataListener) {
        this.mOriginApplication.registerOnProvideAssistDataListener(onProvideAssistDataListener);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i4) {
        this.mOriginApplication.setTheme(i4);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        this.mOriginApplication.startActivities(intentArr);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        this.mOriginApplication.startActivity(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i4, int i5, int i6) {
        this.mOriginApplication.startIntentSender(intentSender, intent, i4, i5, i6);
    }

    @Override // android.app.Application
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mOriginApplication.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Application
    public void unregisterOnProvideAssistDataListener(Application.OnProvideAssistDataListener onProvideAssistDataListener) {
        this.mOriginApplication.unregisterOnProvideAssistDataListener(onProvideAssistDataListener);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        this.mOriginApplication.startActivities(intentArr, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        this.mOriginApplication.startActivity(intent, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        this.mOriginApplication.startIntentSender(intentSender, intent, i4, i5, i6, bundle);
    }
}
