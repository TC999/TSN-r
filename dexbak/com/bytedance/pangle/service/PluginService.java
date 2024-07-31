package com.bytedance.pangle.service;

import android.app.Service;
import android.content.ComponentName;
import androidx.annotation.Keep;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.service.p125a.BinderC6224a;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Keep
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class PluginService extends Service implements InterfaceC6223a {
    private static final String TAG = "PluginService";

    @Override // com.bytedance.pangle.service.InterfaceC6223a
    public void attach(Plugin plugin) {
        attachBaseContext(ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName));
        try {
            FieldUtils.writeField(this, "mActivityManager", createActivityManagerProxy());
            FieldUtils.writeField(this, "mClassName", getClass().getName());
            FieldUtils.writeField(this, "mApplication", Zeus.getAppApplication());
            FieldUtils.writeField(this, "mStartCompatibility", Boolean.valueOf(getApplicationInfo().targetSdkVersion < 5));
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "hook activityManager failed!", e);
        }
    }

    protected Object createActivityManagerProxy() {
        return Proxy.newProxyInstance(getClassLoader(), new Class[]{Class.forName("android.app.IActivityManager")}, new InvocationHandler() { // from class: com.bytedance.pangle.service.PluginService.1
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                String name = method.getName();
                name.hashCode();
                if (name.equals("getForegroundServiceType")) {
                    return 0;
                }
                if (name.equals("stopServiceToken")) {
                    BinderC6224a m36952b = BinderC6224a.m36952b();
                    PluginService pluginService = PluginService.this;
                    return Boolean.valueOf(m36952b.m36960a(new ComponentName(pluginService, pluginService.getClass().getName())));
                }
                return null;
            }
        });
    }
}
