package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.util.UUID;

/* compiled from: SameSDCardTool.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class aa {

    /* renamed from: a  reason: collision with root package name */
    static boolean f39738a = false;

    /* renamed from: b  reason: collision with root package name */
    static String f39739b = "";

    /* renamed from: c  reason: collision with root package name */
    public static char[] f39740c = {'P', 'a', 'c', 'k', 'a', 'g', 'e', 'M', 'a', 'n', 'a', 'g', 'e', 'r'};

    /* renamed from: d  reason: collision with root package name */
    private static boolean f39741d = false;

    /* renamed from: e  reason: collision with root package name */
    private static int f39742e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static int f39743f = -1;

    /* renamed from: g  reason: collision with root package name */
    private static int f39744g = -1;

    /* renamed from: h  reason: collision with root package name */
    private static int f39745h = -1;

    public static void a(Context context) {
        if (f39741d) {
            return;
        }
        try {
            try {
                f39739b = context.getFilesDir().getAbsolutePath() + File.separator;
                f39738a = false;
                b(context);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            f39739b = context.getFilesDir().getAbsolutePath() + File.separator;
            b(context);
        }
        f39741d = true;
    }

    private static void b(Context context) {
        com.mbridge.msdk.foundation.same.b.e.a(new com.mbridge.msdk.foundation.same.b.d(c(context)));
        com.mbridge.msdk.foundation.same.b.e.a().b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
        if ((d() > 31457280) == false) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String c(android.content.Context r7) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 18
            if (r0 < r2) goto L1a
            java.io.File r0 = r7.getExternalFilesDir(r1)     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L1a
            java.io.File r0 = a(r0)     // Catch: java.lang.Throwable -> L12
            goto L1b
        L12:
            r0 = move-exception
            java.lang.String r2 = "common-exception"
            java.lang.String r3 = "hasSDCard is failed"
            com.mbridge.msdk.foundation.tools.x.b(r2, r3, r0)
        L1a:
            r0 = r1
        L1b:
            boolean r2 = com.mbridge.msdk.foundation.tools.aa.f39738a
            if (r2 == 0) goto L6b
            if (r0 != 0) goto L5a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r2 = r2.getPath()
            r0.append(r2)
            java.lang.String r2 = java.io.File.separator
            r0.append(r2)
            java.lang.String r3 = "Android"
            r0.append(r3)
            r0.append(r2)
            java.lang.String r3 = "data"
            r0.append(r3)
            r0.append(r2)
            java.lang.String r2 = r7.getPackageName()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r0)
            java.io.File r0 = a(r2)
        L5a:
            long r2 = d()
            r4 = 31457280(0x1e00000, double:1.55419614E-316)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L67
            r2 = 1
            goto L68
        L67:
            r2 = 0
        L68:
            if (r2 != 0) goto L6b
            goto L6c
        L6b:
            r1 = r0
        L6c:
            if (r1 == 0) goto L74
            boolean r0 = r1.exists()
            if (r0 != 0) goto L7c
        L74:
            java.io.File r7 = r7.getFilesDir()
            java.io.File r1 = r7.getAbsoluteFile()
        L7c:
            java.lang.String r7 = r1.getAbsolutePath()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.aa.c(android.content.Context):java.lang.String");
    }

    private static long d() {
        if (c()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return 0L;
    }

    private static long e() {
        if (c()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return 0L;
    }

    public static int b() {
        if (f39742e == -1) {
            try {
                f39742e = new Long((e() / 1000) / 1000).intValue();
            } catch (Throwable th) {
                x.b("SameSDCardTool", th.getMessage(), th);
            }
        }
        return f39742e;
    }

    private static File a(File file) {
        File file2 = new File(file, UUID.randomUUID() + "");
        if (file2.exists()) {
            file2.delete();
        }
        if (file2.mkdirs()) {
            file2.delete();
            return file.getAbsoluteFile();
        }
        return null;
    }

    private static boolean c() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception unused) {
            x.d("", "hasSDCard is failed");
            return false;
        }
    }

    public static int a() {
        try {
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            long longValue = ((Long) ae.b(j4, "freeExternalSize", 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 1800000 || f39743f == -1) {
                f39743f = Long.valueOf((d() / 1000) / 1000).intValue();
                ae.a(j4, "freeExternalSize", Long.valueOf(currentTimeMillis));
            }
        } catch (Throwable th) {
            x.b("SameSDCardTool", th.getMessage(), th);
        }
        return f39743f;
    }
}
