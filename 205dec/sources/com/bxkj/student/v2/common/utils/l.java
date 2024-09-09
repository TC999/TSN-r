package com.bxkj.student.v2.common.utils;

import android.os.Build;
import java.io.File;
import kotlin.Metadata;
import kotlin.text.x;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: RootCheckUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002R\u0011\u0010\b\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/bxkj/student/v2/common/utils/l;", "", "", "a", "b", "c", "d", "()Z", "isDeviceRooted", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class l {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final l f23373a = new l();

    private l() {
    }

    private final boolean a() {
        boolean V2;
        String str = Build.TAGS;
        if (str != null) {
            V2 = x.V2(str, "test-keys", false, 2, null);
            return V2;
        }
        return false;
    }

    private final boolean b() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        int i4 = 0;
        while (i4 < 10) {
            String str = strArr[i4];
            i4++;
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0030, code lost:
        if (r1 != null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean c() {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L2f
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L2f
            java.lang.String r4 = "/system/xbin/which"
            r3[r0] = r4     // Catch: java.lang.Throwable -> L2f
            java.lang.String r4 = "su"
            r5 = 1
            r3[r5] = r4     // Catch: java.lang.Throwable -> L2f
            java.lang.Process r1 = r2.exec(r3)     // Catch: java.lang.Throwable -> L2f
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2f
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L2f
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Throwable -> L2f
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L2f
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r2 = r2.readLine()     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L2b
            r0 = 1
        L2b:
            r1.destroy()
            goto L32
        L2f:
            if (r1 != 0) goto L2b
        L32:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.common.utils.l.c():boolean");
    }

    public final boolean d() {
        return a() || b() || c();
    }
}
