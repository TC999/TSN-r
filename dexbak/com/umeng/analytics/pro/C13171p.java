package com.umeng.analytics.pro;

import com.umeng.analytics.AnalyticsConfig;
import java.lang.Thread;

/* compiled from: CrashHandler.java */
/* renamed from: com.umeng.analytics.pro.p */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13171p implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private Thread.UncaughtExceptionHandler f38436a;

    /* renamed from: b */
    private OnAppCrashHandler f38437b;

    public C13171p() {
        if (Thread.getDefaultUncaughtExceptionHandler() == this) {
            return;
        }
        this.f38436a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* renamed from: a */
    public void m14217a(OnAppCrashHandler onAppCrashHandler) {
        this.f38437b = onAppCrashHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        m14216a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f38436a;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == Thread.getDefaultUncaughtExceptionHandler()) {
            return;
        }
        this.f38436a.uncaughtException(thread, th);
    }

    /* renamed from: a */
    private void m14216a(Throwable th) {
        if (AnalyticsConfig.CATCH_EXCEPTION) {
            this.f38437b.mo14189a(th);
        } else {
            this.f38437b.mo14189a(null);
        }
    }
}
