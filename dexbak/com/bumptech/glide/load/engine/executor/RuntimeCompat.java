package com.bumptech.glide.load.engine.executor;

import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* renamed from: com.bumptech.glide.load.engine.executor.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class RuntimeCompat {

    /* renamed from: a */
    private static final String f13704a = "GlideRuntimeCompat";

    /* renamed from: b */
    private static final String f13705b = "cpu[0-9]+";

    /* renamed from: c */
    private static final String f13706c = "/sys/devices/system/cpu/";

    /* compiled from: RuntimeCompat.java */
    /* renamed from: com.bumptech.glide.load.engine.executor.b$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3615a implements FilenameFilter {

        /* renamed from: a */
        final /* synthetic */ Pattern f13707a;

        C3615a(Pattern pattern) {
            this.f13707a = pattern;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.f13707a.matcher(str).matches();
        }
    }

    private RuntimeCompat() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m45284a() {
        return Runtime.getRuntime().availableProcessors();
    }

    /* renamed from: b */
    private static int m45283b() {
        File[] fileArr;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            fileArr = new File(f13706c).listFiles(new C3615a(Pattern.compile(f13705b)));
        } catch (Throwable th) {
            try {
                if (Log.isLoggable(f13704a, 6)) {
                    Log.e(f13704a, "Failed to calculate accurate cpu count", th);
                }
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                fileArr = null;
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        return Math.max(1, fileArr != null ? fileArr.length : 0);
    }
}
