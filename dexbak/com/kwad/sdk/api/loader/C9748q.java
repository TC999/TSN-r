package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.loader.Reflect;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.kwad.sdk.api.loader.q */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C9748q {
    private static Map<String, Resources> aiH = new HashMap();
    private static final Object aiI = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.api.loader.q$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9749a {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public static Resources m27867a(Resources resources, AssetManager assetManager) {
            try {
                Resources resources2 = (Resources) Reflect.m27998a(resources.getClass()).m27989a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            } catch (Exception unused) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.api.loader.q$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9750b {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public static Resources m27865a(Resources resources, AssetManager assetManager) {
            try {
                return m27864c(resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return C9749a.m27867a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        /* renamed from: c */
        private static Resources m27864c(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.m27983cg("android.content.res.HwResources").m27989a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.api.loader.q$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9751c {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public static Resources m27862a(Resources resources, AssetManager assetManager) {
            try {
                return m27861e(resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return C9749a.m27867a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        /* renamed from: e */
        private static Resources m27861e(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.m27983cg("android.content.res.MiuiResourcesImpl").m27989a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.api.loader.q$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9752d {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public static Resources m27859a(Resources resources, AssetManager assetManager) {
            try {
                try {
                    return m27858g(resources, assetManager);
                } catch (Exception unused) {
                    return C9749a.m27867a(resources, assetManager);
                }
            } catch (Exception unused2) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
        }

        /* renamed from: g */
        private static Resources m27858g(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.m27983cg("android.content.res.MiuiResources").m27989a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.api.loader.q$e */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9753e {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public static Resources m27856a(Resources resources, AssetManager assetManager) {
            try {
                return m27855i(resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return C9749a.m27867a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        /* renamed from: i */
        private static Resources m27855i(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.m27983cg("android.content.res.NubiaResources").m27989a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.api.loader.q$f */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9754f {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public static Resources m27853a(Context context, Resources resources, AssetManager assetManager) {
            try {
                return m27852b(context, resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return C9749a.m27867a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        /* renamed from: b */
        private static Resources m27852b(Context context, Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.m27983cg("android.content.res.VivoResources").m27989a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                try {
                    Reflect.m27978h(resources2).m27995a("init", new Class[]{String.class}, context.getPackageName());
                } catch (Reflect.ReflectException e) {
                    e.printStackTrace();
                }
                try {
                    Reflect.m27978h(resources2).m27987b("mThemeValues", Reflect.m27978h(resources).get("mThemeValues"));
                } catch (Reflect.ReflectException e2) {
                    e2.printStackTrace();
                }
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: a */
    public static Resources m27877a(Context context, Resources resources, String str) {
        Resources resources2;
        synchronized (aiI) {
            resources2 = aiH.get(str);
            if (resources2 == null) {
                resources2 = m27874b(context, resources, str);
                if (resources2 != null) {
                    aiH.put(str, resources);
                } else {
                    throw new RuntimeException("Can not createResources for " + str);
                }
            }
        }
        return resources2;
    }

    /* renamed from: b */
    private static int m27873b(AssetManager assetManager, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                Reflect.m27978h(assetManager).m27995a("addAssetPathAsSharedLibrary", new Class[]{String.class}, str);
            } else {
                Reflect.m27978h(assetManager).m27995a("addAssetPath", new Class[]{String.class}, str);
            }
        } catch (Throwable unused) {
            Reflect.m27978h(assetManager).m27995a("addAssetPath", new Class[]{String.class}, str);
        }
        return 0;
    }

    /* renamed from: c */
    private static boolean m27871c(Resources resources) {
        return "android.content.res.VivoResources".equals(resources.getClass().getName());
    }

    /* renamed from: d */
    private static boolean m27870d(Resources resources) {
        return "android.content.res.NubiaResources".equals(resources.getClass().getName());
    }

    /* renamed from: e */
    private static boolean m27869e(Resources resources) {
        return "android.content.res.HwResources".equals(resources.getClass().getName());
    }

    /* renamed from: f */
    private static boolean m27868f(Resources resources) {
        return !"android.content.res.Resources".equals(resources.getClass().getName());
    }

    /* renamed from: b */
    private static Resources m27874b(Context context, Resources resources, String str) {
        AssetManager assetManager = (AssetManager) Reflect.m27998a(AssetManager.class).m27999Ak().get();
        Reflect.m27978h(assetManager).m27995a("addAssetPath", new Class[]{String.class}, str);
        if (Build.VERSION.SDK_INT >= 21) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            try {
                Object obj = Reflect.m27978h(applicationInfo).get("resourceDirs");
                if (obj != null && obj.getClass().isArray()) {
                    Object[] objArr = (Object[]) obj;
                    if (objArr.length > 0) {
                        for (Object obj2 : objArr) {
                            if (obj2 instanceof String) {
                                m27876a(assetManager, (String) obj2);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                String[] strArr = applicationInfo.sharedLibraryFiles;
                if (strArr != null && strArr.length > 0) {
                    for (String str2 : strArr) {
                        if (str2 != null && str2.endsWith(".apk")) {
                            m27873b(assetManager, str2);
                        }
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return m27878a(context, assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    /* renamed from: a */
    private static void m27876a(AssetManager assetManager, String str) {
        try {
            Reflect.m27978h(assetManager).m27995a("addOverlayPath", new Class[]{String.class}, str);
        } catch (Throwable unused) {
            Reflect.m27978h(assetManager).m27995a("addAssetPath", new Class[]{String.class}, str);
        }
    }

    /* renamed from: a */
    private static Resources m27878a(Context context, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        Resources resources = context.getResources();
        if (m27875a(resources)) {
            return C9752d.m27859a(resources, assetManager);
        }
        if (m27872b(resources)) {
            return C9751c.m27862a(resources, assetManager);
        }
        if (m27869e(resources)) {
            return C9750b.m27865a(resources, assetManager);
        }
        if (m27871c(resources)) {
            return C9754f.m27853a(context, resources, assetManager);
        }
        if (m27870d(resources)) {
            return C9753e.m27856a(resources, assetManager);
        }
        if (m27868f(resources)) {
            return C9749a.m27867a(resources, assetManager);
        }
        return new Resources(assetManager, displayMetrics, configuration);
    }

    /* renamed from: a */
    private static boolean m27875a(Resources resources) {
        return "android.content.res.MiuiResources".equals(resources.getClass().getName());
    }

    /* renamed from: b */
    private static boolean m27872b(Resources resources) {
        return "android.content.res.MiuiResourcesImpl".equals(resources.getClass().getName());
    }
}
