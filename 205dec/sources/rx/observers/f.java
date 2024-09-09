package rx.observers;

import rx.internal.operators.v;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SerializedObserver.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class f<T> implements rx.f<T> {

    /* renamed from: a  reason: collision with root package name */
    private final rx.f<? super T> f64176a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f64177b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f64178c;

    /* renamed from: d  reason: collision with root package name */
    private a f64179d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SerializedObserver.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        Object[] f64180a;

        /* renamed from: b  reason: collision with root package name */
        int f64181b;

        a() {
        }

        public void a(Object obj) {
            int i4 = this.f64181b;
            Object[] objArr = this.f64180a;
            if (objArr == null) {
                objArr = new Object[16];
                this.f64180a = objArr;
            } else if (i4 == objArr.length) {
                Object[] objArr2 = new Object[(i4 >> 2) + i4];
                System.arraycopy(objArr, 0, objArr2, 0, i4);
                this.f64180a = objArr2;
                objArr = objArr2;
            }
            objArr[i4] = obj;
            this.f64181b = i4 + 1;
        }
    }

    public f(rx.f<? super T> fVar) {
        this.f64176a = fVar;
    }

    @Override // rx.f
    public void onCompleted() {
        if (this.f64178c) {
            return;
        }
        synchronized (this) {
            if (this.f64178c) {
                return;
            }
            this.f64178c = true;
            if (this.f64177b) {
                a aVar = this.f64179d;
                if (aVar == null) {
                    aVar = new a();
                    this.f64179d = aVar;
                }
                aVar.a(v.b());
                return;
            }
            this.f64177b = true;
            this.f64176a.onCompleted();
        }
    }

    @Override // rx.f
    public void onError(Throwable th) {
        rx.exceptions.a.e(th);
        if (this.f64178c) {
            return;
        }
        synchronized (this) {
            if (this.f64178c) {
                return;
            }
            this.f64178c = true;
            if (this.f64177b) {
                a aVar = this.f64179d;
                if (aVar == null) {
                    aVar = new a();
                    this.f64179d = aVar;
                }
                aVar.a(v.c(th));
                return;
            }
            this.f64177b = true;
            this.f64176a.onError(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x002d, code lost:
        continue;
     */
    @Override // rx.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onNext(T r7) {
        /*
            r6 = this;
            boolean r0 = r6.f64178c
            if (r0 == 0) goto L5
            return
        L5:
            monitor-enter(r6)
            boolean r0 = r6.f64178c     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto Lc
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L6f
            return
        Lc:
            boolean r0 = r6.f64177b     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L24
            rx.observers.f$a r0 = r6.f64179d     // Catch: java.lang.Throwable -> L6f
            if (r0 != 0) goto L1b
            rx.observers.f$a r0 = new rx.observers.f$a     // Catch: java.lang.Throwable -> L6f
            r0.<init>()     // Catch: java.lang.Throwable -> L6f
            r6.f64179d = r0     // Catch: java.lang.Throwable -> L6f
        L1b:
            java.lang.Object r7 = rx.internal.operators.v.j(r7)     // Catch: java.lang.Throwable -> L6f
            r0.a(r7)     // Catch: java.lang.Throwable -> L6f
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L6f
            return
        L24:
            r0 = 1
            r6.f64177b = r0     // Catch: java.lang.Throwable -> L6f
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L6f
            rx.f<? super T> r1 = r6.f64176a     // Catch: java.lang.Throwable -> L66
            r1.onNext(r7)     // Catch: java.lang.Throwable -> L66
        L2d:
            monitor-enter(r6)
            rx.observers.f$a r1 = r6.f64179d     // Catch: java.lang.Throwable -> L63
            r2 = 0
            if (r1 != 0) goto L37
            r6.f64177b = r2     // Catch: java.lang.Throwable -> L63
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L63
            return
        L37:
            r3 = 0
            r6.f64179d = r3     // Catch: java.lang.Throwable -> L63
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L63
            java.lang.Object[] r1 = r1.f64180a
            int r3 = r1.length
        L3e:
            if (r2 >= r3) goto L2d
            r4 = r1[r2]
            if (r4 != 0) goto L45
            goto L2d
        L45:
            rx.f<? super T> r5 = r6.f64176a     // Catch: java.lang.Throwable -> L53
            boolean r4 = rx.internal.operators.v.a(r5, r4)     // Catch: java.lang.Throwable -> L53
            if (r4 == 0) goto L50
            r6.f64178c = r0     // Catch: java.lang.Throwable -> L53
            return
        L50:
            int r2 = r2 + 1
            goto L3e
        L53:
            r1 = move-exception
            r6.f64178c = r0
            rx.exceptions.a.e(r1)
            rx.f<? super T> r0 = r6.f64176a
            java.lang.Throwable r7 = rx.exceptions.OnErrorThrowable.addValueAsLastCause(r1, r7)
            r0.onError(r7)
            return
        L63:
            r7 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L63
            throw r7
        L66:
            r1 = move-exception
            r6.f64178c = r0
            rx.f<? super T> r0 = r6.f64176a
            rx.exceptions.a.g(r1, r0, r7)
            return
        L6f:
            r7 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L6f
            goto L73
        L72:
            throw r7
        L73:
            goto L72
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.observers.f.onNext(java.lang.Object):void");
    }
}
