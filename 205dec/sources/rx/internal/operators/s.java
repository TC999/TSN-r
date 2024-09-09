package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.b;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CompletableOnSubscribeTimeout.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class s implements b.j0 {

    /* renamed from: a  reason: collision with root package name */
    final rx.b f63244a;

    /* renamed from: b  reason: collision with root package name */
    final long f63245b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f63246c;

    /* renamed from: d  reason: collision with root package name */
    final rx.h f63247d;

    /* renamed from: e  reason: collision with root package name */
    final rx.b f63248e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CompletableOnSubscribeTimeout.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f63249a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.b f63250b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.d f63251c;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: CompletableOnSubscribeTimeout.java */
        /* renamed from: rx.internal.operators.s$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class C1296a implements rx.d {
            C1296a() {
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                a.this.f63250b.a(mVar);
            }

            @Override // rx.d
            public void onCompleted() {
                a.this.f63250b.unsubscribe();
                a.this.f63251c.onCompleted();
            }

            @Override // rx.d
            public void onError(Throwable th) {
                a.this.f63250b.unsubscribe();
                a.this.f63251c.onError(th);
            }
        }

        a(AtomicBoolean atomicBoolean, rx.subscriptions.b bVar, rx.d dVar) {
            this.f63249a = atomicBoolean;
            this.f63250b = bVar;
            this.f63251c = dVar;
        }

        @Override // rx.functions.a
        public void call() {
            if (this.f63249a.compareAndSet(false, true)) {
                this.f63250b.c();
                rx.b bVar = s.this.f63248e;
                if (bVar == null) {
                    this.f63251c.onError(new TimeoutException());
                } else {
                    bVar.G0(new C1296a());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CompletableOnSubscribeTimeout.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b implements rx.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.b f63254a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f63255b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.d f63256c;

        b(rx.subscriptions.b bVar, AtomicBoolean atomicBoolean, rx.d dVar) {
            this.f63254a = bVar;
            this.f63255b = atomicBoolean;
            this.f63256c = dVar;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f63254a.a(mVar);
        }

        @Override // rx.d
        public void onCompleted() {
            if (this.f63255b.compareAndSet(false, true)) {
                this.f63254a.unsubscribe();
                this.f63256c.onCompleted();
            }
        }

        @Override // rx.d
        public void onError(Throwable th) {
            if (this.f63255b.compareAndSet(false, true)) {
                this.f63254a.unsubscribe();
                this.f63256c.onError(th);
                return;
            }
            rx.plugins.c.I(th);
        }
    }

    public s(rx.b bVar, long j4, TimeUnit timeUnit, rx.h hVar, rx.b bVar2) {
        this.f63244a = bVar;
        this.f63245b = j4;
        this.f63246c = timeUnit;
        this.f63247d = hVar;
        this.f63248e = bVar2;
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        rx.subscriptions.b bVar = new rx.subscriptions.b();
        dVar.a(bVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        h.a a4 = this.f63247d.a();
        bVar.a(a4);
        a4.e(new a(atomicBoolean, bVar, dVar), this.f63245b, this.f63246c);
        this.f63244a.G0(new b(bVar, atomicBoolean, dVar));
    }
}
