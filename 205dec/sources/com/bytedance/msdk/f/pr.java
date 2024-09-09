package com.bytedance.msdk.f;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class pr implements Thread.UncaughtExceptionHandler {

    /* renamed from: c  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f28349c = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: w  reason: collision with root package name */
    private String f28350w;

    private pr() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        w();
    }

    public static pr c() {
        return new pr();
    }

    private void w() {
        File c4;
        Context context = com.bytedance.msdk.core.c.getContext();
        if (context == null) {
            return;
        }
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && (c4 = com.bytedance.sdk.openadsdk.api.plugin.w.c(context, "TTCache")) != null) {
                c4.mkdirs();
                this.f28350w = c4.getPath();
            }
            if (TextUtils.isEmpty(this.f28350w)) {
                File file = new File(com.bytedance.sdk.openadsdk.api.plugin.w.c(context), "TTCache");
                file.mkdirs();
                this.f28350w = file.getPath();
            }
        } catch (Throwable unused) {
        }
    }

    private void xv() {
        try {
            com.bytedance.msdk.core.c.w().n();
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (com.bytedance.sdk.openadsdk.core.k.sr().ia()) {
            return;
        }
        boolean z3 = false;
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            if (stringWriter2 != null) {
                z3 = stringWriter2.contains("com.bytedance.msdk");
            }
        } catch (Throwable unused) {
        }
        if (z3) {
            c(thread, th);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f28349c;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0123 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.Properties] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(java.lang.Thread r19, java.lang.Throwable r20) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.f.pr.c(java.lang.Thread, java.lang.Throwable):void");
    }
}
