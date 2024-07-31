package com.amap.api.col.p0463l;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;

/* renamed from: com.amap.api.col.3l.u2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ResourcesUtil {

    /* renamed from: a */
    private static boolean f5434a = new File("/system/framework/amap.jar").exists();

    /* renamed from: a */
    public static int m53806a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: b */
    public static AssetManager m53805b(Context context) {
        if (context == null) {
            return null;
        }
        AssetManager assets = context.getAssets();
        if (f5434a) {
            try {
                assets.getClass().getDeclaredMethod("addAssetPath", String.class).invoke(assets, "/system/framework/amap.jar");
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "ResourcesUtil", "getSelfAssets");
            }
        }
        return assets;
    }
}
