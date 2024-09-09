package com.bytedance.sdk.component.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class i {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static Context f30192c;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f30193f;
    private static String sr;
    private static boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private static String f30194w;
    private static Resources xv;

    private static int c(Context context, String str, String str2) {
        int identifier = c(context).getIdentifier(str, str2, xv(context));
        if (identifier == 0) {
            if (!ux) {
                w(context);
                return c(context).getIdentifier(str, str2, xv(context));
            }
            return context.getResources().getIdentifier(str, str2, xv(context));
        }
        return identifier;
    }

    public static int ev(Context context, String str) {
        return c(context, str, "color");
    }

    public static int f(Context context, String str) {
        return c(context, str, "dimen");
    }

    public static int gd(Context context, String str) {
        return c(context, str, "anim");
    }

    public static int r(Context context, String str) {
        return c(context).getColor(ev(context, str));
    }

    public static int sr(Context context, String str) {
        return c(context, str, "drawable");
    }

    public static int ux(Context context, String str) {
        return c(context, str, "style");
    }

    public static int w(Context context, String str) {
        return c(context, str, "string");
    }

    private static String xv(Context context) {
        if (sr == null) {
            sr = context.getPackageName();
        }
        return sr;
    }

    public static synchronized void w(Context context) {
        synchronized (i.class) {
            try {
            } finally {
            }
            if (TextUtils.isEmpty(f30194w)) {
                return;
            }
            Resources resources = context.getResources();
            xv = new Resources(w(resources.getAssets(), f30194w + "/apk/base-1.apk"), resources.getDisplayMetrics(), resources.getConfiguration());
            sr = context.getPackageName();
            ux = true;
        }
    }

    public static Drawable xv(Context context, String str) {
        return c(context).getDrawable(sr(context, str));
    }

    public static String c(Context context, String str) {
        return c(context).getString(w(context, str));
    }

    public static Resources c(Context context) {
        Resources resources = xv;
        if (resources == null) {
            resources = null;
        }
        Context context2 = f30192c;
        if (context2 != null) {
            resources = context2.getResources();
        }
        return resources == null ? context.getResources() : resources;
    }

    public static void c(String str, boolean z3, Context context) {
        if (!TextUtils.isEmpty(str)) {
            f30194w = str;
        }
        f30193f = z3;
        if (z3) {
            w(context);
        }
    }

    private static AssetManager w(AssetManager assetManager, String str) {
        AssetManager assetManager2;
        try {
            if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                assetManager2 = (AssetManager) AssetManager.class.newInstance();
            }
            c(assetManager2, str);
            assetManager = assetManager2;
        } catch (Exception unused) {
            c(assetManager, str);
        }
        try {
            ck.c(assetManager, "ensureStringBlocks", new Object[0]);
        } catch (Exception unused2) {
        }
        return assetManager;
    }

    public static boolean c(AssetManager assetManager, String str) {
        Method c4 = ck.c((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        if (c4 == null) {
            c4 = ck.c((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        }
        if (c4 != null) {
            int i4 = 3;
            while (true) {
                int i5 = i4 - 1;
                if (i4 < 0) {
                    break;
                } else if (((Integer) c4.invoke(assetManager, str)).intValue() != 0) {
                    return true;
                } else {
                    i4 = i5;
                }
            }
        }
        return false;
    }
}
