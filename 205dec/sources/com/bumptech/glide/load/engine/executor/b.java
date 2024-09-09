package com.bumptech.glide.load.engine.executor;

import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RuntimeCompat.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f17027a = "GlideRuntimeCompat";

    /* renamed from: b  reason: collision with root package name */
    private static final String f17028b = "cpu[0-9]+";

    /* renamed from: c  reason: collision with root package name */
    private static final String f17029c = "/sys/devices/system/cpu/";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RuntimeCompat.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Pattern f17030a;

        a(Pattern pattern) {
            this.f17030a = pattern;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.f17030a.matcher(str).matches();
        }
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        return Runtime.getRuntime().availableProcessors();
    }

    private static int b() {
        File[] fileArr;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            fileArr = new File("/sys/devices/system/cpu/").listFiles(new a(Pattern.compile("cpu[0-9]+")));
        } catch (Throwable th) {
            try {
                if (Log.isLoggable("GlideRuntimeCompat", 6)) {
                    Log.e("GlideRuntimeCompat", "Failed to calculate accurate cpu count", th);
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
