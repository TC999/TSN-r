package com.amap.api.col.p0003l;

import android.content.Context;
import java.lang.Thread;
import java.util.concurrent.RejectedExecutionException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BasicLogHandler.java */
/* renamed from: com.amap.api.col.3l.q5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class q5 {

    /* renamed from: c  reason: collision with root package name */
    protected static q5 f8830c;

    /* renamed from: a  reason: collision with root package name */
    protected Thread.UncaughtExceptionHandler f8831a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f8832b = true;

    /* compiled from: Log.java */
    /* renamed from: com.amap.api.col.3l.q5$a */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class a extends z7 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f8833a;

        a(Context context) {
            this.f8833a = context;
        }

        public final void runTask() {
            try {
                u5.o(this.f8833a);
                u5.q(this.f8833a);
                u5.p(this.f8833a);
                g7.b(this.f8833a);
                e7.d(this.f8833a);
            } catch (RejectedExecutionException unused) {
            } catch (Throwable th) {
                t5.p(th, "Lg", "proL");
            }
        }
    }

    public static void e(Throwable th, String str, String str2) {
        q5 q5Var = f8830c;
        if (q5Var != null) {
            q5Var.d(th, 1, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(p4 p4Var, String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(p4 p4Var, boolean z3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(Throwable th, int i4, String str, String str2) {
    }
}
