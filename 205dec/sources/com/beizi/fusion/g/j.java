package com.beizi.fusion.g;

import android.content.Context;
import android.os.Build;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BeiZiStorageUtils.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class j {
    public static File a(Context context) {
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

    public static File b(Context context) {
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
