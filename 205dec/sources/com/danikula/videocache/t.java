package com.danikula.videocache;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: StorageUtils.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
final class t {

    /* renamed from: a  reason: collision with root package name */
    private static final org.slf4j.c f36825a = org.slf4j.d.j("StorageUtils");

    /* renamed from: b  reason: collision with root package name */
    private static final String f36826b = "video-cache";

    t() {
    }

    private static File a(Context context, boolean z3) {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        File b4 = (z3 && "mounted".equals(str)) ? b(context) : null;
        if (b4 == null) {
            b4 = context.getCacheDir();
        }
        if (b4 == null) {
            String str2 = "/data/data/" + context.getPackageName() + "/cache/";
            f36825a.warn("Can't define system cache directory! '" + str2 + "%s' will be used.");
            return new File(str2);
        }
        return b4;
    }

    private static File b(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        f36825a.warn("Unable to create external cache directory");
        return null;
    }

    public static File c(Context context) {
        return new File(a(context, true), "video-cache");
    }
}
