package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import java.io.File;
import java.lang.Thread;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.v */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TTMediationCrashHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private Thread.UncaughtExceptionHandler f685a = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: b */
    private String f686b;

    private TTMediationCrashHandler() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        m59108b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x012b A[Catch: all -> 0x012e, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x012e, blocks: (B:55:0x0115, B:67:0x012b), top: B:95:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.Properties] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.Properties] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m59109a(java.lang.Thread r19, java.lang.Throwable r20) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TTMediationCrashHandler.m59109a(java.lang.Thread, java.lang.Throwable):void");
    }

    /* renamed from: b */
    private void m59108b() {
        File externalFilesDir;
        Context m59945d = InternalContainer.m59945d();
        if (m59945d == null) {
            return;
        }
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalFilesDir = m59945d.getExternalFilesDir("TTCache")) != null) {
                externalFilesDir.mkdirs();
                this.f686b = externalFilesDir.getPath();
            }
            if (TextUtils.isEmpty(this.f686b)) {
                File file = new File(m59945d.getFilesDir(), "TTCache");
                file.mkdirs();
                this.f686b = file.getPath();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public static TTMediationCrashHandler m59107c() {
        return new TTMediationCrashHandler();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void uncaughtException(java.lang.Thread r3, java.lang.Throwable r4) {
        /*
            r2 = this;
            java.io.StringWriter r0 = new java.io.StringWriter     // Catch: java.lang.Throwable -> L1a
            r0.<init>()     // Catch: java.lang.Throwable -> L1a
            java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch: java.lang.Throwable -> L1a
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L1a
            r4.printStackTrace(r1)     // Catch: java.lang.Throwable -> L1a
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L1a
            java.lang.String r1 = "com.bytedance.msdk"
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L1a
            goto L1b
        L1a:
            r0 = 0
        L1b:
            if (r0 == 0) goto L20
            r2.m59109a(r3, r4)
        L20:
            java.lang.Thread$UncaughtExceptionHandler r0 = r2.f685a
            if (r0 == 0) goto L29
            if (r0 == r2) goto L29
            r0.uncaughtException(r3, r4)
        L29:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TTMediationCrashHandler.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }

    /* renamed from: a */
    private void m59110a() {
        try {
            InternalContainer.m59943f().m59758b();
        } catch (Throwable unused) {
        }
    }
}