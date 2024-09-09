package com.qq.e.comm.plugin.util;

import android.content.SharedPreferences;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.utils.AVErrorInfo;
import java.io.File;
import java.lang.Thread;
import java.util.concurrent.TimeUnit;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    private static long f46706a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemClock.sleep(1000L);
            x.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements Thread.UncaughtExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Thread.UncaughtExceptionHandler f46707a;

        b(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f46707a = uncaughtExceptionHandler;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            x.c(th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f46707a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
                return;
            }
            Process.killProcess(Process.myPid());
            System.exit(1);
        }
    }

    public static void b(Throwable th) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("data", th.getMessage());
        dVar.a("msg", Log.getStackTraceString(th));
        com.qq.e.comm.plugin.n0.v.b(9730000, new com.qq.e.comm.plugin.n0.c(), 0, dVar);
        d1.a("reportCaughtException", th);
    }

    public static void c() {
        if (com.qq.e.comm.plugin.d0.a.d().f().a("rece", 0) == 0) {
            return;
        }
        f46706a = System.currentTimeMillis();
        d0.f46410f.schedule(new a(), 1000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        Thread.setDefaultUncaughtExceptionHandler(new b(Thread.getDefaultUncaughtExceptionHandler()));
        e();
    }

    private static void e() {
        File b4 = b();
        if (b4 == null || !b4.exists()) {
            return;
        }
        String d4 = b1.d(b4);
        b4.delete();
        if (TextUtils.isEmpty(d4)) {
            return;
        }
        d1.a("report crash " + d4);
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("msg", d4);
        dVar.a("azd", com.qq.e.comm.plugin.m.b.f44640f.b().b(com.qq.e.comm.plugin.d0.a.d().a()));
        com.qq.e.comm.plugin.n0.v.b(9120017, new com.qq.e.comm.plugin.n0.c(), 0, dVar);
    }

    private static void f() {
        d1.a("save start crash");
        SharedPreferences sharedPreferences = com.qq.e.comm.plugin.d0.a.d().a().getSharedPreferences("start_crash", 0);
        sharedPreferences.edit().putInt("crash_count", sharedPreferences.getInt("crash_count", 0) + 1).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Throwable th) {
        File b4 = b();
        if (b4 == null) {
            return;
        }
        String stackTraceString = Log.getStackTraceString(th);
        if (!TextUtils.isEmpty(stackTraceString) && stackTraceString.contains("com.qq.e")) {
            b1.c(b4, stackTraceString);
        }
        if (System.currentTimeMillis() - f46706a <= 3000) {
            f();
        }
    }

    private static File b() {
        File file = new File(com.qq.e.comm.plugin.d0.a.d().a().getCacheDir(), "gdt_crash");
        if (file.exists() || !file.mkdirs()) {
            return new File(file, AVErrorInfo.CRASH);
        }
        return null;
    }
}
