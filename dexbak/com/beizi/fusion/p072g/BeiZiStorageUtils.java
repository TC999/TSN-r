package com.beizi.fusion.p072g;

import android.content.Context;
import android.os.Build;
import java.io.File;

/* renamed from: com.beizi.fusion.g.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiStorageUtils {
    /* renamed from: a */
    public static File m48244a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                return context.getFilesDir();
            }
            return context.getFilesDir();
        } catch (Exception unused) {
            return context.getFilesDir();
        }
    }

    /* renamed from: b */
    public static File m48243b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                return context.getCacheDir();
            }
            return context.getCacheDir();
        } catch (Exception unused) {
            return context.getCacheDir();
        }
    }
}
