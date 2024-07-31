package com.kwad.sdk.crash.handler;

import android.content.Context;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.crash.p427b.C10666a;
import java.lang.Thread;

/* renamed from: com.kwad.sdk.crash.handler.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10689d implements Thread.UncaughtExceptionHandler {
    private volatile boolean aGa = false;
    private Thread.UncaughtExceptionHandler aGb = Thread.getDefaultUncaughtExceptionHandler();
    private Context context;

    public C10689d(Context context) {
        this.context = context;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            if (this.aGa) {
                C10331c.m26254d("AdExceptionCollector", "SDK捕获 uncaughtException 正在处理 ex=" + th.getMessage());
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.aGb;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                    return;
                }
                return;
            }
            this.aGa = true;
            C10331c.m26254d("AdExceptionCollector", "thread=" + thread + " ex=" + th.getMessage());
            if (C10666a.m25204o(th)) {
                JavaExceptionMessage javaExceptionMessage = new JavaExceptionMessage();
                javaExceptionMessage.mCrashSource = 1;
                C10687c.m25109HK().m25108a(th, javaExceptionMessage, this.context);
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.aGb;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
        } catch (Throwable unused) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.aGb;
            if (uncaughtExceptionHandler3 != null) {
                uncaughtExceptionHandler3.uncaughtException(thread, th);
            }
        }
    }
}
