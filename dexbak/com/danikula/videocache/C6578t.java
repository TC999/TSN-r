package com.danikula.videocache;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import org.slf4j.InterfaceC15424c;
import org.slf4j.LoggerFactory;

/* compiled from: StorageUtils.java */
/* renamed from: com.danikula.videocache.t */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
final class C6578t {

    /* renamed from: a */
    private static final InterfaceC15424c f23158a = LoggerFactory.m2655j("StorageUtils");

    /* renamed from: b */
    private static final String f23159b = "video-cache";

    C6578t() {
    }

    /* renamed from: a */
    private static File m35827a(Context context, boolean z) {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        File m35826b = (z && "mounted".equals(str)) ? m35826b(context) : null;
        if (m35826b == null) {
            m35826b = context.getCacheDir();
        }
        if (m35826b == null) {
            String str2 = "/data/data/" + context.getPackageName() + "/cache/";
            f23158a.warn("Can't define system cache directory! '" + str2 + "%s' will be used.");
            return new File(str2);
        }
        return m35826b;
    }

    /* renamed from: b */
    private static File m35826b(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        f23158a.warn("Unable to create external cache directory");
        return null;
    }

    /* renamed from: c */
    public static File m35825c(Context context) {
        return new File(m35827a(context, true), f23159b);
    }
}
