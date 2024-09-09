package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ResourcesUtil.java */
/* renamed from: com.amap.api.col.3l.u2  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class u2 {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f9139a = new File("/system/framework/amap.jar").exists();

    public static int a(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static AssetManager b(Context context) {
        if (context == null) {
            return null;
        }
        AssetManager assets = context.getAssets();
        if (f9139a) {
            try {
                assets.getClass().getDeclaredMethod("addAssetPath", String.class).invoke(assets, "/system/framework/amap.jar");
            } catch (Throwable th) {
                u5.p(th, "ResourcesUtil", "getSelfAssets");
            }
        }
        return assets;
    }
}
