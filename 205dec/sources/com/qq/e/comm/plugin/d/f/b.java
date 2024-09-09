package com.qq.e.comm.plugin.d.f;

import android.os.Process;
import com.qq.e.comm.plugin.d.g.c;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f42184a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f42185b = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f42184a = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (this.f42185b.compareAndSet(false, true)) {
            c.a(thread, th);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f42184a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
}
