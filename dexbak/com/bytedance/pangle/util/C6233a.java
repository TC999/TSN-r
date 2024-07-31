package com.bytedance.pangle.util;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import com.bytedance.pangle.activity.IPluginActivity;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.p115b.p117b.C6068a;
import com.bytedance.pangle.wrapper.InterfaceC6261a;

/* renamed from: com.bytedance.pangle.util.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6233a {
    /* renamed from: a */
    public static void m36939a(InterfaceC6261a interfaceC6261a, Activity activity) {
        try {
            FieldUtils.writeField(interfaceC6261a, "mTheme", (Object) null);
            FieldUtils.writeField((Object) interfaceC6261a, "mThemeResource", (Object) 0);
            int[] m36941a = m36941a(activity);
            if (m36941a == null) {
                return;
            }
            for (int i : m36941a) {
                if (i != 0) {
                    interfaceC6261a.setWrapperActivityTheme(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static int[] m36941a(Activity activity) {
        Resources.Theme theme = activity.getTheme();
        if (theme == null) {
            return null;
        }
        try {
            if (C6253i.m36880h()) {
                Object readField = FieldUtils.readField(theme, "mThemeImpl");
                if (readField == null) {
                    return null;
                }
                try {
                    Object invokeMethod = MethodUtils.invokeMethod(readField, "getKey", new Object[0]);
                    if (invokeMethod != null) {
                        return (int[]) FieldUtils.readField(invokeMethod, "mResId");
                    }
                } catch (Exception unused) {
                }
                Object invoke = C6068a.m37258a(readField.getClass(), "getKey", new Class[0]).invoke(readField, new Object[0]);
                if (invoke == null) {
                    ZeusLogger.m37083d(ZeusLogger.TAG_ACTIVITY, "getKey failed!");
                    return null;
                }
                ZeusLogger.m37083d(ZeusLogger.TAG_ACTIVITY, "getKey success by doubleReflector!");
                return (int[]) C6068a.m37259a(invoke.getClass(), "mResId").get(invoke);
            }
            if (Build.VERSION.SDK_INT > 22) {
                Object invokeMethod2 = MethodUtils.invokeMethod(theme, "getKey", new Object[0]);
                if (invokeMethod2 == null) {
                    return null;
                }
                return (int[]) FieldUtils.readField(invokeMethod2, "mResId");
            }
            String str = (String) MethodUtils.invokeMethod(theme, "getKey", new Object[0]);
            if (str == null) {
                return null;
            }
            String[] split = str.trim().replace("!", "").split(" ");
            int[] iArr = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                iArr[i] = Integer.parseInt(split[i], 16);
            }
            return iArr;
        } catch (Throwable th) {
            ZeusLogger.m37083d(ZeusLogger.TAG_ACTIVITY, "getKey exception!" + th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static void m36940a(IPluginActivity iPluginActivity, Activity activity) {
        try {
            FieldUtils.writeField(iPluginActivity, "mTheme", (Object) null);
            FieldUtils.writeField((Object) iPluginActivity, "mThemeResource", (Object) 0);
            int[] m36941a = m36941a(activity);
            if (m36941a == null) {
                return;
            }
            for (int i : m36941a) {
                if (i != 0) {
                    iPluginActivity.setProxyTheme2Plugin(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
