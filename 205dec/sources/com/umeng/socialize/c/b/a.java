package com.umeng.socialize.c.b;

import android.content.Context;
import com.umeng.socialize.utils.SLog;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: CacheUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    public static void a() {
    }

    public static void a(Context context) {
        try {
            b(context);
        } catch (Exception e4) {
            SLog.error(e4);
        }
    }

    private static void b(Context context) {
        File[] listFiles = new File(context.getExternalFilesDir(null), "umeng_cache").listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        for (File file : listFiles) {
            file.delete();
        }
    }
}
