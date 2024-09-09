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
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(b bVar, Bundle bundle) {
        List<String> list;
        if (!Zeus.hasInit()) {
            Log.e("Zeus/init_pangle", "ProxyActivityUtils.onCreate finish. AppApplication == null.");
            bVar.zeusSuperOnCreate(null);
            bVar.finish();
            return;
        }
        Intent intent = bVar.getIntent();
        String pluginPkgName = bVar.getPluginPkgName();
        Plugin plugin = bVar.getPlugin();
        if (plugin == null) {
            Log.e("Zeus/init_pangle", "ProxyActivityUtils.onCreate finish. plugin == null");
            bVar.zeusSuperOnCreate(null);
            bVar.finish();
            return;
        }
        intent.setExtrasClassLoader(plugin.mClassLoader);
        IntentUtils.a(intent);
        String stringExtra = intent.getStringExtra("targetPlugin");
        if (TextUtils.isEmpty(stringExtra) && (list = ComponentManager.stubActivity2TargetActivities.get(bVar.getClass().getName())) != null && list.size() == 1) {
            stringExtra = list.get(0);
            intent.putExtra("targetPlugin", stringExtra);
        }
        if (plugin.isLoaded() && !TextUtils.isEmpty(stringExtra)) {
            ActivityInfo activityInfo = plugin.pluginActivities.get(stringExtra);
            if (activityInfo == null) {
                ZeusLogger.w("Zeus/activity_pangle", "Have you declared " + stringExtra + " in plugin's AndroidManifest.xml!");
                bVar.zeusSuperOnCreate(null);
                bVar.finish();
            }
            int i4 = -1;
            try {
                IPluginActivity iPluginActivity = (IPluginActivity) plugin.mClassLoader.loadClass(stringExtra).newInstance();
                FieldUtils.writeField(iPluginActivity, "mApplication", bVar.getApplication());
                bVar.setTargetActivity(iPluginActivity);
                iPluginActivity.setPluginProxyActivity(bVar, plugin);
                i4 = activityInfo.theme;
                bVar.zeusSuperSetTheme(i4);
                TypedArray obtainStyledAttributes = ((Activity) bVar).getTheme().obtainStyledAttributes(new int[]{16842840});
                if (obtainStyledAttributes.getBoolean(obtainStyledAttributes.getIndex(0), false)) {
                    a((Activity) bVar);
                }
                obtainStyledAttributes.recycle();
                iPluginActivity.attachBaseContext(bVar.getBaseContext());
                try {
                    int requestedOrientation = ((Activity) bVar).getRequestedOrientation();
                    int i5 = activityInfo.screenOrientation;
                    if (requestedOrientation != i5) {
                        ((Activity) bVar).setRequestedOrientation(i5);
                    }
                } catch (IllegalStateException unused) {
                }
                iPluginActivity.onCreate(bundle);
                return;
            } catch (Exception e4) {
                throw new RuntimeException(e4 instanceof IllegalStateException ? "activityTheme:".concat(String.valueOf(i4)) : "", e4);
            }
        }
        try {
            bVar.zeusSuperOnCreate(null);
            ZeusLogger.w("Zeus/activity_pangle", "Cant start pluginActivity, plugin load failed! pluginPkgName: " + pluginPkgName + " targetActivity: " + stringExtra);
            bVar.finish();
        } catch (Exception e5) {
            throw new RuntimeException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(b bVar, Context context) {
        if (!Zeus.hasInit()) {
            Log.e("Zeus/init_pangle", "ProxyActivityUtils.attachBaseContext. AppApplication == null.");
            bVar.zeusSuperAttachBaseContext(context);
            return;
        }
        String pluginPkgName = bVar.getPluginPkgName();
        boolean loadPlugin = PluginManager.getInstance().loadPlugin(pluginPkgName);
        try {
            bVar.setPlugin(PluginManager.getInstance().getPlugin(pluginPkgName));
            if (loadPlugin) {
                bVar.zeusSuperAttachBaseContext(ZeusTransformUtils.wrapperContext(context, pluginPkgName));
                FieldUtils.writeField(bVar, "mResources", (Object) null);
                return;
            }
            bVar.zeusSuperAttachBaseContext(context);
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Activity activity, View view) {
        Object readField;
        if (view == null) {
            return;
        }
        try {
            Object readField2 = FieldUtils.readField(view, "mListenerInfo");
            if (readField2 != null && (readField = FieldUtils.readField(readField2, "mOnClickListener")) != null) {
                String name = readField.getClass().getName();
                if (name.startsWith(AppCompatViewInflater.class.getName()) || name.startsWith(View.class.getName())) {
                    view.setOnClickListener(new a(activity, view.getId(), (String) FieldUtils.readField(readField, "mMethodName")));
                }
            }
        } catch (Exception e4) {
            ZeusLogger.errReport("Zeus/activity_pangle", "checkOnClickListener failed!".concat(String.valueOf(view)));
            e4.printStackTrace();
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i4 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i4 >= viewGroup.getChildCount()) {
                return;
            }
            a(activity, viewGroup.getChildAt(i4));
            i4++;
        }
    }

    private static Class a() {
        Class<?>[] declaredClasses;
        Class<?> cls = null;
        for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
            if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                cls = cls2;
            }
        }
        return cls;
    }

    private static void a(Activity activity) {
        try {
            MethodUtils.getAccessibleMethod(Activity.class, "convertToTranslucent", a(), ActivityOptions.class).invoke(activity, null, MethodUtils.getAccessibleMethod(Activity.class, "getActivityOptions", new Class[0]).invoke(activity, new Object[0]));
        } catch (Throwable unused) {
        }
    }
}
