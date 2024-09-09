package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.util.HashMap;

/* renamed from: G  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public abstract class G {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap f22a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object[][] f23b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object[][] f24c;

    /* renamed from: d  reason: collision with root package name */
    public static final Object[][] f25d;

    /* renamed from: e  reason: collision with root package name */
    public static final Object[][] f26e;

    static {
        HashMap hashMap = new HashMap();
        f22a = hashMap;
        Object[][] objArr = {new Object[]{"android.app.Instrumentation", "newApplication", ClassLoader.class, String.class, Context.class}, new Object[]{"android.app.Instrumentation", "newApplication", ClassLoader.class, Context.class}, new Object[]{"android.app.ContextImpl", "getSharedPreferencesPath", String.class}};
        f23b = objArr;
        Object[][] objArr2 = {new Object[]{"android.content.res.MiuiResources", "init", String.class}, new Object[]{"android.content.res.MiuiResources", "updateMiuiImpl"}, new Object[]{"android.content.res.MiuiResources", "setImpl", "android.content.res.ResourcesImpl"}, new Object[]{"android.content.res.MiuiResources", "loadOverlayValue", TypedValue.class, Integer.TYPE}, new Object[]{"android.content.res.MiuiResources", "getThemeString", CharSequence.class}, new Object[]{"android.content.res.MiuiResources", "<init>", ClassLoader.class}, new Object[]{"android.content.res.MiuiResources", "<init>"}, new Object[]{"android.content.res.MiuiResources", "<init>", AssetManager.class, DisplayMetrics.class, Configuration.class}, new Object[]{"android.miui.ResourcesManager", "initMiuiResource", Resources.class, String.class}, new Object[]{"android.app.LoadedApk", "getResources", Resources.class}, new Object[]{"android.content.res.Resources", "getSystem", Resources.class}, new Object[]{"android.app.ApplicationPackageManager", "getResourcesForApplication", ApplicationInfo.class}, new Object[]{"android.app.ContextImpl", "setResources", Resources.class}};
        f24c = objArr2;
        Object[][] objArr3 = new Object[0];
        f25d = objArr3;
        Object[][] objArr4 = new Object[0];
        f26e = objArr4;
        hashMap.put("boot_image", objArr);
        hashMap.put("boot_image_miui_res", objArr2);
        hashMap.put("system_server", objArr3);
        hashMap.put("com.android.systemui", objArr4);
    }
}
