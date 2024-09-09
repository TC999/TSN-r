package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.kwad.sdk.api.loader.ApiReflect;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class r {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                Resources resources2 = (Resources) ApiReflect.a(resources.getClass()).a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            } catch (Exception unused) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return c(resources, assetManager);
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources c(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) ApiReflect.cg("android.content.res.HwResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    static final class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return e(resources, assetManager);
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources e(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) ApiReflect.cg("android.content.res.MiuiResourcesImpl").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    static final class d {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                try {
                    return g(resources, assetManager);
                } catch (Exception unused) {
                    return a.a(resources, assetManager);
                }
            } catch (Exception unused2) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
        }

        private static Resources g(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) ApiReflect.cg("android.content.res.MiuiResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    static final class e {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return i(resources, assetManager);
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources i(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) ApiReflect.cg("android.content.res.NubiaResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    static final class f {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Context context, Resources resources, AssetManager assetManager) {
            try {
                return b(context, resources, assetManager);
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources b(Context context, Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) ApiReflect.cg("android.content.res.VivoResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                try {
                    ApiReflect.g(resources2).a("init", new Class[]{String.class}, context.getPackageName());
                } catch (ApiReflect.ReflectException e4) {
                    e4.printStackTrace();
                }
                try {
                    ApiReflect.g(resources2).b("mThemeValues", ApiReflect.g(resources).get("mThemeValues"));
                } catch (ApiReflect.ReflectException e5) {
                    e5.printStackTrace();
                }
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    public static boolean a(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().equals(s.getFileMD5(file).toLowerCase());
    }

    public static boolean k(File file) {
        return file != null && file.exists() && file.length() > 0 && file.getName().endsWith(".apk");
    }
}
