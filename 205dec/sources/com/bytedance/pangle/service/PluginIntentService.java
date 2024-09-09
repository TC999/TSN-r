package com.bytedance.pangle.service;

import android.app.IntentService;
import android.content.ComponentName;
import androidx.annotation.Keep;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class PluginIntentService extends IntentService implements a {
    private static final String TAG = "PluginService";

    public PluginIntentService(String str) {
        super(str);
    }

    @Override // com.bytedance.pangle.service.a
    public void attach(Plugin plugin) {
        attachBaseContext(ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName));
        try {
            FieldUtils.writeField(this, "mActivityManager", createActivityManagerProxy());
            FieldUtils.writeField(this, "mClassName", getClass().getName());
            FieldUtils.writeField(this, "mApplication", Zeus.getAppApplication());
            FieldUtils.writeField(this, "mStartCompatibility", Boolean.valueOf(getApplicationInfo().targetSdkVersion < 5));
        } catch (Exception e4) {
            ZeusLogger.errReport("Zeus/service_pangle", "hook activityManager failed!", e4);
        }
    }

    protected Object createActivityManagerProxy() {
        return Proxy.newProxyInstance(getClassLoader(), new Class[]{Class.forName("android.app.IActivityManager")}, new InvocationHandler() { // from class: com.bytedance.pangle.service.PluginIntentService.1
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                String name = method.getName();
                name.hashCode();
                if (name.equals("getForegroundServiceType")) {
                    return 0;
                }
                if (name.equals("stopServiceToken")) {
                    com.bytedance.pangle.service.a.a b4 = com.bytedance.pangle.service.a.a.b();
                    PluginIntentService pluginIntentService = PluginIntentService.this;
                    return Boolean.valueOf(b4.a(new ComponentName(pluginIntentService, pluginIntentService.getClass().getName())));
                }
                return null;
            }
        });
    }
}
