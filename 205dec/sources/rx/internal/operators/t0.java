package rx.internal.operators;

import rx.b;
import rx.exceptions.AssemblyStackTraceException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeOnAssemblyCompletable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t0<T> implements b.j0 {

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f63316c;

    /* renamed from: a  reason: collision with root package name */
    final b.j0 f63317a;

    /* renamed from: b  reason: collision with root package name */
    final String f63318b = s0.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeOnAssemblyCompletable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements rx.d {

        /* renamed from: a  reason: collision with root package name */
        final rx.d f63319a;

        /* renamed from: b  reason: collision with root package name */
        final String f63320b;

        public a(rx.d dVar, String str) {
            this.f63319a = dVar;
            this.f63320b = str;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f63319a.a(mVar);
        }

        @Override // rx.d
        public void onCompleted() {
            this.f63319a.onCompleted();
        }

        @Override // rx.d
        public void onError(Throwable th) {
            new AssemblyStackTraceException(this.f63320b).attachTo(th);
            this.f63319a.onError(th);
        }
    }

    public t0(b.j0 j0Var) {
        this.f63317a = j0Var;
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        this.f63317a.call(new a(dVar, this.f63318b));
    }
}
