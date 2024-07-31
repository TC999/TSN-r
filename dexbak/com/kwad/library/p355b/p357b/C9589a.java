package com.kwad.library.p355b.p357b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.C9603a;
import com.kwad.sdk.utils.C11124s;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.kwad.library.b.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9589a {
    private static Map<String, Resources> aiH = new HashMap();
    private static final Object aiI = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.library.b.b.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9590a {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public static Resources m28297a(Resources resources, AssetManager assetManager) {
            try {
                Resources resources2 = (Resources) C11124s.m23708a(resources.getClass(), assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
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
    /* renamed from: com.kwad.library.b.b.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9591b {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public static Resources m28295a(Resources resources, AssetManager assetManager) {
            try {
                return m28294c(resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return C9590a.m28297a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        /* renamed from: c */
        private static Resources m28294c(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) C11124s.m23687h("android.content.res.HwResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.library.b.b.a$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9592c {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public static Resources m28292a(Resources resources, AssetManager assetManager) {
            try {
                return m28291e(resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return C9590a.m28297a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        /* renamed from: e */
        private static Resources m28291e(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) C11124s.m23687h("android.content.res.MiuiResourcesImpl", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.library.b.b.a$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9593d {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public static Resources m28289a(Resources resources, AssetManager assetManager) {
            try {
                try {
                    return m28288g(resources, assetManager);
                } catch (Exception unused) {
                    return C9590a.m28297a(resources, assetManager);
                }
            } catch (Exception unused2) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
        }

        /* renamed from: g */
        private static Resources m28288g(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) C11124s.m23687h("android.content.res.MiuiResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.library.b.b.a$e */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9594e {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public static Resources m28286a(Resources resources, AssetManager assetManager) {
            try {
                return m28285i(resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return C9590a.m28297a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        /* renamed from: i */
        private static Resources m28285i(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) C11124s.m23687h("android.content.res.NubiaResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.library.b.b.a$f */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9595f {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public static Resources m28283a(Context context, Resources resources, AssetManager assetManager) {
            try {
                return m28282b(context, resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return C9590a.m28297a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        /* renamed from: b */
        private static Resources m28282b(Context context, Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) C11124s.m23687h("android.content.res.VivoResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                try {
                    C11124s.m23689f(resources2, "init", context.getPackageName());
                } catch (Exception e) {
                    C9603a.m28251e("ResourcesManager", "createVivoResources init failed", e);
                }
                try {
                    C11124s.m23698b(resources2, "mThemeValues", C11124s.m23690f(resources, "mThemeValues"));
                } catch (Exception e2) {
                    C9603a.m28251e("ResourcesManager", "createVivoResources set mThemeValues failed", e2);
                }
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    @NonNull
    /* renamed from: a */
    public static Resources m28307a(Context context, Resources resources, String str) {
        Resources resources2;
        synchronized (aiI) {
            resources2 = aiH.get(str);
            if (resources2 == null) {
                resources2 = m28304b(context, resources, str);
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
    private static int m28303b(AssetManager assetManager, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                C11124s.m23689f(assetManager, "addAssetPathAsSharedLibrary", str);
            } else {
                C11124s.m23689f(assetManager, "addAssetPath", str);
            }
        } catch (Throwable unused) {
            C11124s.m23689f(assetManager, "addAssetPath", str);
        }
        return 0;
    }

    /* renamed from: c */
    private static boolean m28301c(Resources resources) {
        return "android.content.res.VivoResources".equals(resources.getClass().getName());
    }

    /* renamed from: d */
    private static boolean m28300d(Resources resources) {
        return "android.content.res.NubiaResources".equals(resources.getClass().getName());
    }

    /* renamed from: e */
    private static boolean m28299e(Resources resources) {
        return "android.content.res.HwResources".equals(resources.getClass().getName());
    }

    /* renamed from: f */
    private static boolean m28298f(Resources resources) {
        return !"android.content.res.Resources".equals(resources.getClass().getName());
    }

    /* renamed from: b */
    private static Resources m28304b(Context context, Resources resources, String str) {
        AssetManager assetManager = (AssetManager) C11124s.m23686i(AssetManager.class);
        C11124s.m23689f(assetManager, "addAssetPath", str);
        if (Build.VERSION.SDK_INT >= 21) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            try {
                Object field = C11124s.getField(applicationInfo, "resourceDirs");
                if (field != null && field.getClass().isArray()) {
                    Object[] objArr = (Object[]) field;
                    if (objArr.length > 0) {
                        for (Object obj : objArr) {
                            if (obj instanceof String) {
                                m28306a(assetManager, (String) obj);
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
                            m28303b(assetManager, str2);
                        }
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return m28308a(context, assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    /* renamed from: a */
    private static void m28306a(AssetManager assetManager, String str) {
        try {
            C11124s.m23689f(assetManager, "addOverlayPath", str);
        } catch (Throwable unused) {
            C11124s.m23689f(assetManager, "addAssetPath", str);
        }
    }

    /* renamed from: a */
    private static Resources m28308a(Context context, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        Resources resources = context.getResources();
        if (m28305a(resources)) {
            return C9593d.m28289a(resources, assetManager);
        }
        if (m28302b(resources)) {
            return C9592c.m28292a(resources, assetManager);
        }
        if (m28299e(resources)) {
            return C9591b.m28295a(resources, assetManager);
        }
        if (m28301c(resources)) {
            return C9595f.m28283a(context, resources, assetManager);
        }
        if (m28300d(resources)) {
            return C9594e.m28286a(resources, assetManager);
        }
        if (m28298f(resources)) {
            return C9590a.m28297a(resources, assetManager);
        }
        return new Resources(assetManager, displayMetrics, configuration);
    }

    /* renamed from: a */
    private static boolean m28305a(Resources resources) {
        return "android.content.res.MiuiResources".equals(resources.getClass().getName());
    }

    /* renamed from: b */
    private static boolean m28302b(Resources resources) {
        return "android.content.res.MiuiResourcesImpl".equals(resources.getClass().getName());
    }
}
