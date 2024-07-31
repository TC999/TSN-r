package p640rx.plugins;

import p640rx.exceptions.C15575a;

/* renamed from: rx.plugins.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class RxJavaErrorHandler {

    /* renamed from: a */
    protected static final String f46935a = ".errorRendering";

    @Deprecated
    /* renamed from: a */
    public void m587a(Throwable th) {
    }

    /* renamed from: b */
    public final String m586b(Object obj) {
        try {
            return m585c(obj);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + f46935a;
        } catch (Throwable th) {
            C15575a.m1474e(th);
            return obj.getClass().getName() + f46935a;
        }
    }

    /* renamed from: c */
    protected String m585c(Object obj) throws InterruptedException {
        return null;
    }
}
