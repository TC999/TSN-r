package com.bytedance.pangle.wrapper;

import android.app.Activity;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.Keep;
import com.bytedance.pangle.C6057a;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.util.C6233a;
import com.bytedance.pangle.util.C6253i;
import com.bytedance.pangle.util.FieldUtils;

@Keep
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PluginActivityWrapper extends GenerateActivityWrapper {
    private static final int OBJECT_TAG = Integer.MAX_VALUE;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:19:0x0030). Please submit an issue!!! */
    public PluginActivityWrapper(Activity activity, PluginContext pluginContext) {
        this.mOriginActivity = activity;
        this.pluginContext = pluginContext;
        try {
            if (!activity.isDestroyed()) {
                if (Build.VERSION.SDK_INT >= 29) {
                    this.mOriginActivity.registerActivityLifecycleCallbacks(new C6057a() { // from class: com.bytedance.pangle.wrapper.PluginActivityWrapper.1
                    });
                } else {
                    setTag();
                }
            }
        } catch (Exception unused) {
            Zeus.getAppApplication().registerActivityLifecycleCallbacks(new C6057a() { // from class: com.bytedance.pangle.wrapper.PluginActivityWrapper.2
                @Override // com.bytedance.pangle.C6057a, android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityDestroyed(Activity activity2) {
                    super.onActivityDestroyed(activity2);
                    if (activity2 == PluginActivityWrapper.this.mOriginActivity) {
                        Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this);
                    }
                }
            });
        }
        try {
            FieldUtils.writeField(this, "mBase", pluginContext);
            if (!C6253i.m36887a()) {
                FieldUtils.writeField(FieldUtils.getField(ContextWrapper.class, "mBase"), this, pluginContext);
            }
        } catch (IllegalAccessException unused2) {
        }
        try {
            FieldUtils.writeField(this, "mApplication", activity.getApplication());
        } catch (IllegalAccessException unused3) {
        }
        C6233a.m36939a(this, activity);
    }

    private void setTag() {
        View decorView;
        String pluginPackageName;
        Window window = this.mOriginActivity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null || (pluginPackageName = this.pluginContext.getPluginPackageName()) == null) {
            return;
        }
        decorView.setTag(pluginPackageName.hashCode(), new C6057a() { // from class: com.bytedance.pangle.wrapper.PluginActivityWrapper.3
        });
    }
}
