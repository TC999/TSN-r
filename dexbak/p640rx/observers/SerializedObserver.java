package p640rx.observers;

import p640rx.Observer;
import p640rx.exceptions.C15575a;
import p640rx.internal.operators.NotificationLite;

/* renamed from: rx.observers.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SerializedObserver<T> implements Observer<T> {

    /* renamed from: a */
    private final Observer<? super T> f46907a;

    /* renamed from: b */
    private boolean f46908b;

    /* renamed from: c */
    private volatile boolean f46909c;

    /* renamed from: d */
    private C16129a f46910d;

    /* compiled from: SerializedObserver.java */
    /* renamed from: rx.observers.f$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C16129a {

        /* renamed from: a */
        Object[] f46911a;

        /* renamed from: b */
        int f46912b;

        C16129a() {
        }

        /* renamed from: a */
        public void m637a(Object obj) {
            int i = this.f46912b;
            Object[] objArr = this.f46911a;
            if (objArr == null) {
                objArr = new Object[16];
                this.f46911a = objArr;
            } else if (i == objArr.length) {
                Object[] objArr2 = new Object[(i >> 2) + i];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                this.f46911a = objArr2;
                objArr = objArr2;
            }
            objArr[i] = obj;
            this.f46912b = i + 1;
        }
    }

    public SerializedObserver(Observer<? super T> observer) {
        this.f46907a = observer;
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        if (this.f46909c) {
            return;
        }
        synchronized (this) {
            if (this.f46909c) {
                return;
            }
            this.f46909c = true;
            if (this.f46908b) {
                C16129a c16129a = this.f46910d;
                if (c16129a == null) {
                    c16129a = new C16129a();
                    this.f46910d = c16129a;
                }
                c16129a.m637a(NotificationLite.m1051b());
                return;
            }
            this.f46908b = true;
            this.f46907a.onCompleted();
        }
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        C15575a.m1474e(th);
        if (this.f46909c) {
            return;
        }
        synchronized (this) {
            if (this.f46909c) {
                return;
            }
            this.f46909c = true;
            if (this.f46908b) {
                C16129a c16129a = this.f46910d;
                if (c16129a == null) {
                    c16129a = new C16129a();
                    this.f46910d = c16129a;
                }
                c16129a.m637a(NotificationLite.m1050c(th));
                return;
            }
            this.f46908b = true;
            this.f46907a.onError(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x002d, code lost:
        continue;
     */
    @Override // p640rx.Observer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onNext(T r7) {
        /*
            r6 = this;
            boolean r0 = r6.f46909c
            if (r0 == 0) goto L5
            return
        L5:
            monitor-enter(r6)
            boolean r0 = r6.f46909c     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto Lc
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L6f
            return
        Lc:
            boolean r0 = r6.f46908b     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L24
            rx.observers.f$a r0 = r6.f46910d     // Catch: java.lang.Throwable -> L6f
            if (r0 != 0) goto L1b
            rx.observers.f$a r0 = new rx.observers.f$a     // Catch: java.lang.Throwable -> L6f
            r0.<init>()     // Catch: java.lang.Throwable -> L6f
            r6.f46910d = r0     // Catch: java.lang.Throwable -> L6f
        L1b:
            java.lang.Object r7 = p640rx.internal.operators.NotificationLite.m1043j(r7)     // Catch: java.lang.Throwable -> L6f
            r0.m637a(r7)     // Catch: java.lang.Throwable -> L6f
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L6f
            return
        L24:
            r0 = 1
            r6.f46908b = r0     // Catch: java.lang.Throwable -> L6f
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L6f
            rx.f<? super T> r1 = r6.f46907a     // Catch: java.lang.Throwable -> L66
            r1.onNext(r7)     // Catch: java.lang.Throwable -> L66
        L2d:
            monitor-enter(r6)
            rx.observers.f$a r1 = r6.f46910d     // Catch: java.lang.Throwable -> L63
            r2 = 0
            if (r1 != 0) goto L37
            r6.f46908b = r2     // Catch: java.lang.Throwable -> L63
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L63
            return
        L37:
            r3 = 0
            r6.f46910d = r3     // Catch: java.lang.Throwable -> L63
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L63
            java.lang.Object[] r1 = r1.f46911a
            int r3 = r1.length
        L3e:
            if (r2 >= r3) goto L2d
            r4 = r1[r2]
            if (r4 != 0) goto L45
            goto L2d
        L45:
            rx.f<? super T> r5 = r6.f46907a     // Catch: java.lang.Throwable -> L53
            boolean r4 = p640rx.internal.operators.NotificationLite.m1052a(r5, r4)     // Catch: java.lang.Throwable -> L53
            if (r4 == 0) goto L50
            r6.f46909c = r0     // Catch: java.lang.Throwable -> L53
            return
        L50:
            int r2 = r2 + 1
            goto L3e
        L53:
            r1 = move-exception
            r6.f46909c = r0
            p640rx.exceptions.C15575a.m1474e(r1)
            rx.f<? super T> r0 = r6.f46907a
            java.lang.Throwable r7 = p640rx.exceptions.OnErrorThrowable.addValueAsLastCause(r1, r7)
            r0.onError(r7)
            return
        L63:
            r7 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L63
            throw r7
        L66:
            r1 = move-exception
            r6.f46909c = r0
            rx.f<? super T> r0 = r6.f46907a
            p640rx.exceptions.C15575a.m1472g(r1, r0, r7)
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
        throw new UnsupportedOperationException("Method not decompiled: p640rx.observers.SerializedObserver.onNext(java.lang.Object):void");
    }
}
