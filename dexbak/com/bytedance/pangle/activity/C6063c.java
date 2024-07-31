package com.bytedance.pangle.activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatViewInflater;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.bytedance.pangle.activity.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6063c {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m37268a(InterfaceC6062b interfaceC6062b, Bundle bundle) {
        List<String> list;
        if (!Zeus.hasInit()) {
            Log.e(ZeusLogger.TAG_INIT, "ProxyActivityUtils.onCreate finish. AppApplication == null.");
            interfaceC6062b.zeusSuperOnCreate(null);
            interfaceC6062b.finish();
            return;
        }
        Intent intent = interfaceC6062b.getIntent();
        String pluginPkgName = interfaceC6062b.getPluginPkgName();
        Plugin plugin = interfaceC6062b.getPlugin();
        if (plugin == null) {
            Log.e(ZeusLogger.TAG_INIT, "ProxyActivityUtils.onCreate finish. plugin == null");
            interfaceC6062b.zeusSuperOnCreate(null);
            interfaceC6062b.finish();
            return;
        }
        intent.setExtrasClassLoader(plugin.mClassLoader);
        IntentUtils.m37274a(intent);
        String stringExtra = intent.getStringExtra("targetPlugin");
        if (TextUtils.isEmpty(stringExtra) && (list = ComponentManager.stubActivity2TargetActivities.get(interfaceC6062b.getClass().getName())) != null && list.size() == 1) {
            stringExtra = list.get(0);
            intent.putExtra("targetPlugin", stringExtra);
        }
        if (plugin.isLoaded() && !TextUtils.isEmpty(stringExtra)) {
            ActivityInfo activityInfo = plugin.pluginActivities.get(stringExtra);
            if (activityInfo == null) {
                ZeusLogger.m37077w(ZeusLogger.TAG_ACTIVITY, "Have you declared " + stringExtra + " in plugin's AndroidManifest.xml!");
                interfaceC6062b.zeusSuperOnCreate(null);
                interfaceC6062b.finish();
            }
            int i = -1;
            try {
                IPluginActivity iPluginActivity = (IPluginActivity) plugin.mClassLoader.loadClass(stringExtra).newInstance();
                FieldUtils.writeField(iPluginActivity, "mApplication", interfaceC6062b.getApplication());
                interfaceC6062b.setTargetActivity(iPluginActivity);
                iPluginActivity.setPluginProxyActivity(interfaceC6062b, plugin);
                i = activityInfo.theme;
                interfaceC6062b.zeusSuperSetTheme(i);
                TypedArray obtainStyledAttributes = ((Activity) interfaceC6062b).getTheme().obtainStyledAttributes(new int[]{16842840});
                if (obtainStyledAttributes.getBoolean(obtainStyledAttributes.getIndex(0), false)) {
                    m37271a((Activity) interfaceC6062b);
                }
                obtainStyledAttributes.recycle();
                iPluginActivity.attachBaseContext(interfaceC6062b.getBaseContext());
                try {
                    int requestedOrientation = ((Activity) interfaceC6062b).getRequestedOrientation();
                    int i2 = activityInfo.screenOrientation;
                    if (requestedOrientation != i2) {
                        ((Activity) interfaceC6062b).setRequestedOrientation(i2);
                    }
                } catch (IllegalStateException unused) {
                }
                iPluginActivity.onCreate(bundle);
                return;
            } catch (Exception e) {
                throw new RuntimeException(e instanceof IllegalStateException ? "activityTheme:".concat(String.valueOf(i)) : "", e);
            }
        }
        try {
            interfaceC6062b.zeusSuperOnCreate(null);
            ZeusLogger.m37077w(ZeusLogger.TAG_ACTIVITY, "Cant start pluginActivity, plugin load failed! pluginPkgName: " + pluginPkgName + " targetActivity: " + stringExtra);
            interfaceC6062b.finish();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m37269a(InterfaceC6062b interfaceC6062b, Context context) {
        if (!Zeus.hasInit()) {
            Log.e(ZeusLogger.TAG_INIT, "ProxyActivityUtils.attachBaseContext. AppApplication == null.");
            interfaceC6062b.zeusSuperAttachBaseContext(context);
            return;
        }
        String pluginPkgName = interfaceC6062b.getPluginPkgName();
        boolean loadPlugin = PluginManager.getInstance().loadPlugin(pluginPkgName);
        try {
            interfaceC6062b.setPlugin(PluginManager.getInstance().getPlugin(pluginPkgName));
            if (loadPlugin) {
                interfaceC6062b.zeusSuperAttachBaseContext(ZeusTransformUtils.wrapperContext(context, pluginPkgName));
                FieldUtils.writeField(interfaceC6062b, "mResources", (Object) null);
                return;
            }
            interfaceC6062b.zeusSuperAttachBaseContext(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m37270a(Activity activity, View view) {
        Object readField;
        if (view == null) {
            return;
        }
        try {
            Object readField2 = FieldUtils.readField(view, "mListenerInfo");
            if (readField2 != null && (readField = FieldUtils.readField(readField2, "mOnClickListener")) != null) {
                String name = readField.getClass().getName();
                if (name.startsWith(AppCompatViewInflater.class.getName()) || name.startsWith(View.class.getName())) {
                    view.setOnClickListener(new View$OnClickListenerC6061a(activity, view.getId(), (String) FieldUtils.readField(readField, "mMethodName")));
                }
            }
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_ACTIVITY, "checkOnClickListener failed!".concat(String.valueOf(view)));
            e.printStackTrace();
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            m37270a(activity, viewGroup.getChildAt(i));
            i++;
        }
    }

    /* renamed from: a */
    private static Class m37272a() {
        Class<?>[] declaredClasses;
        Class<?> cls = null;
        for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
            if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                cls = cls2;
            }
        }
        return cls;
    }

    /* renamed from: a */
    private static void m37271a(Activity activity) {
        try {
            MethodUtils.getAccessibleMethod(Activity.class, "convertToTranslucent", m37272a(), ActivityOptions.class).invoke(activity, null, MethodUtils.getAccessibleMethod(Activity.class, "getActivityOptions", new Class[0]).invoke(activity, new Object[0]));
        } catch (Throwable unused) {
        }
    }
}
