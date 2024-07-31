package com.umeng.socialize.p571c.p573b;

import android.content.Context;
import com.umeng.socialize.utils.SLog;
import java.io.File;

/* renamed from: com.umeng.socialize.c.b.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CacheUtil {
    /* renamed from: a */
    public static void m13299a() {
    }

    /* renamed from: a */
    public static void m13298a(Context context) {
        try {
            m13297b(context);
        } catch (Exception e) {
            SLog.error(e);
        }
    }

    /* renamed from: b */
    private static void m13297b(Context context) {
        File[] listFiles = new File(context.getExternalFilesDir(null), ImageConstants.f39404a).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        for (File file : listFiles) {
            file.delete();
        }
    }
}
