package cn.jiguang.an;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.nio.charset.Charset;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f2309a = Charset.forName("UTF-8");

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f2310f = {15, 106, 113, 101, 101, 85, 77, 54, 112, 116, 120, 94, 15, 110, 96, Byte.MAX_VALUE, 114, 88};

    /* renamed from: b  reason: collision with root package name */
    private final Context f2311b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f2312c;

    /* renamed from: d  reason: collision with root package name */
    private final String[] f2313d;

    /* renamed from: e  reason: collision with root package name */
    private final Runtime f2314e;

    public c(Context context) {
        this(context, new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su", "/su/bin", "/system/xbin/daemonsu"}, new String[]{"com.devadvance.rootcloak", "com.devadvance.rootcloakplus", "com.koushikdutta.superuser", "com.thirdparty.superuser", "eu.chainfire.supersu", "com.noshufou.android.su"}, Runtime.getRuntime());
    }

    c(Context context, String[] strArr, String[] strArr2, Runtime runtime) {
        this.f2311b = context;
        this.f2312c = strArr;
        this.f2313d = strArr2;
        this.f2314e = runtime;
    }

    private boolean b() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    private boolean c() {
        String[] strArr;
        for (String str : this.f2312c) {
            try {
            } catch (RuntimeException unused) {
                cn.jiguang.w.a.f("RootChecker", String.format("Error when trying to check if root file %s exists.", str));
            }
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:
        if (0 == 0) goto L31;
     */
    @android.annotation.TargetApi(19)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d() {
        /*
            r8 = this;
            java.lang.String r0 = "RootChecker"
            r1 = 2
            java.lang.String[] r1 = new java.lang.String[r1]
            byte[] r2 = cn.jiguang.an.c.f2310f
            java.lang.String r2 = cn.jiguang.ao.c.b(r2)
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "su"
            r4 = 1
            r1[r4] = r2
            r2 = 0
            java.lang.Process r2 = cn.jiguang.ao.g.a(r1)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40 java.io.IOException -> L5c
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40 java.io.IOException -> L5c
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40 java.io.IOException -> L5c
            java.io.InputStream r6 = r2.getInputStream()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40 java.io.IOException -> L5c
            java.nio.charset.Charset r7 = cn.jiguang.an.c.f2309a     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40 java.io.IOException -> L5c
            r5.<init>(r6, r7)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40 java.io.IOException -> L5c
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40 java.io.IOException -> L5c
            java.lang.String r5 = r1.readLine()     // Catch: java.lang.Throwable -> L37
            if (r5 == 0) goto L2f
            goto L30
        L2f:
            r4 = 0
        L30:
            r1.close()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40 java.io.IOException -> L5c
            r2.destroy()
            return r4
        L37:
            r4 = move-exception
            throw r4     // Catch: java.lang.Throwable -> L39
        L39:
            r4 = move-exception
            r1.close()     // Catch: java.lang.Throwable -> L3d
        L3d:
            throw r4     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40 java.io.IOException -> L5c
        L3e:
            r0 = move-exception
            goto L7b
        L40:
            r1 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3e
            r4.<init>()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r5 = "Error when trying to check if SU exists."
            r4.append(r5)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L3e
            r4.append(r1)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L3e
            cn.jiguang.w.a.f(r0, r1)     // Catch: java.lang.Throwable -> L3e
            if (r2 == 0) goto L7a
            goto L77
        L5c:
            r1 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3e
            r4.<init>()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r5 = "SU isn't found on this Device."
            r4.append(r5)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L3e
            r4.append(r1)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L3e
            cn.jiguang.w.a.f(r0, r1)     // Catch: java.lang.Throwable -> L3e
            if (r2 == 0) goto L7a
        L77:
            r2.destroy()
        L7a:
            return r3
        L7b:
            if (r2 == 0) goto L80
            r2.destroy()
        L80:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.an.c.d():boolean");
    }

    public boolean a() {
        return b() || c() || d();
    }
}
