package com.amap.api.col.p0003l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ThreadTask.java */
/* renamed from: com.amap.api.col.3l.a8  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class a8 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    a f7119f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: ThreadTask.java */
    /* renamed from: com.amap.api.col.3l.a8$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a(a8 a8Var);

        void b(a8 a8Var);
    }

    public final void cancelTask() {
        try {
            a aVar = this.f7119f;
            if (aVar != null) {
                aVar.a(this);
            }
        } catch (Throwable th) {
            u5.p(th, "ThreadTask", "cancelTask");
            th.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        try {
            if (Thread.interrupted()) {
                return;
            }
            runTask();
            if (Thread.interrupted() || (aVar = this.f7119f) == null) {
                return;
            }
            aVar.b(this);
        } catch (Throwable th) {
            u5.p(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }

    public abstract void runTask();
}
