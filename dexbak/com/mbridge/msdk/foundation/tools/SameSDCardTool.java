package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirContext;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager;
import java.io.File;
import java.util.UUID;

/* renamed from: com.mbridge.msdk.foundation.tools.aa */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SameSDCardTool {

    /* renamed from: a */
    static boolean f30965a = false;

    /* renamed from: b */
    static String f30966b = "";

    /* renamed from: c */
    public static char[] f30967c = {'P', 'a', 'c', 'k', 'a', 'g', 'e', 'M', 'a', 'n', 'a', 'g', 'e', 'r'};

    /* renamed from: d */
    private static boolean f30968d = false;

    /* renamed from: e */
    private static int f30969e = -1;

    /* renamed from: f */
    private static int f30970f = -1;

    /* renamed from: g */
    private static int f30971g = -1;

    /* renamed from: h */
    private static int f30972h = -1;

    /* renamed from: a */
    public static void m22041a(Context context) {
        if (f30968d) {
            return;
        }
        try {
            try {
                f30966b = context.getFilesDir().getAbsolutePath() + File.separator;
                f30965a = false;
                m22038b(context);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            f30966b = context.getFilesDir().getAbsolutePath() + File.separator;
            m22038b(context);
        }
        f30968d = true;
    }

    /* renamed from: b */
    private static void m22038b(Context context) {
        MBridgeDirManager.m22350a(new MBridgeDirContext(m22036c(context)));
        MBridgeDirManager.m22352a().m22348b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
        if ((m22035d() > 31457280) == false) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m22036c(android.content.Context r7) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 18
            if (r0 < r2) goto L1a
            java.io.File r0 = r7.getExternalFilesDir(r1)     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L1a
            java.io.File r0 = m22040a(r0)     // Catch: java.lang.Throwable -> L12
            goto L1b
        L12:
            r0 = move-exception
            java.lang.String r2 = "common-exception"
            java.lang.String r3 = "hasSDCard is failed"
            com.mbridge.msdk.foundation.tools.SameLogTool.m21735b(r2, r3, r0)
        L1a:
            r0 = r1
        L1b:
            boolean r2 = com.mbridge.msdk.foundation.tools.SameSDCardTool.f30965a
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
            java.io.File r0 = m22040a(r2)
        L5a:
            long r2 = m22035d()
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
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.SameSDCardTool.m22036c(android.content.Context):java.lang.String");
    }

    /* renamed from: d */
    private static long m22035d() {
        if (m22037c()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    /* renamed from: e */
    private static long m22034e() {
        if (m22037c()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    /* renamed from: b */
    public static int m22039b() {
        if (f30969e == -1) {
            try {
                f30969e = new Long((m22034e() / 1000) / 1000).intValue();
            } catch (Throwable th) {
                SameLogTool.m21735b("SameSDCardTool", th.getMessage(), th);
            }
        }
        return f30969e;
    }

    /* renamed from: a */
    private static File m22040a(File file) {
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

    /* renamed from: c */
    private static boolean m22037c() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception unused) {
            SameLogTool.m21733d("", "hasSDCard is failed");
            return false;
        }
    }

    /* renamed from: a */
    public static int m22042a() {
        try {
            Context m22861j = MBSDKContext.m22865f().m22861j();
            long longValue = ((Long) C11400ae.m21961b(m22861j, "freeExternalSize", 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 1800000 || f30970f == -1) {
                f30970f = Long.valueOf((m22035d() / 1000) / 1000).intValue();
                C11400ae.m21963a(m22861j, "freeExternalSize", Long.valueOf(currentTimeMillis));
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("SameSDCardTool", th.getMessage(), th);
        }
        return f30970f;
    }
}
