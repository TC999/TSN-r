package com.amap.api.col.s;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ThreadTask.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class z3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    a f10552a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ThreadTask.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a(z3 z3Var);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        try {
            if (Thread.interrupted()) {
                return;
            }
            a();
            if (Thread.interrupted() || (aVar = this.f10552a) == null) {
                return;
            }
            aVar.a(this);
        } catch (Throwable th) {
            g2.o(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
