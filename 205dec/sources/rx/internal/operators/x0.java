package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeReduce.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class x0<T> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<T> f63561a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.q<T, T, T> f63562b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeReduce.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63563a;

        a(b bVar) {
            this.f63563a = bVar;
        }

        @Override // rx.g
        public void request(long j4) {
            this.f63563a.g(j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeReduce.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> extends rx.l<T> {

        /* renamed from: e  reason: collision with root package name */
        static final Object f63565e = new Object();

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f63566a;

        /* renamed from: b  reason: collision with root package name */
        final rx.functions.q<T, T, T> f63567b;

        /* renamed from: c  reason: collision with root package name */
        T f63568c = (T) f63565e;

        /* renamed from: d  reason: collision with root package name */
        boolean f63569d;

        public b(rx.l<? super T> lVar, rx.functions.q<T, T, T> qVar) {
            this.f63566a = lVar;
            this.f63567b = qVar;
            request(0L);
        }

        void g(long j4) {
            if (j4 >= 0) {
                if (j4 != 0) {
                    request(Long.MAX_VALUE);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j4);
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f63569d) {
                return;
            }
            this.f63569d = true;
            T t3 = this.f63568c;
            if (t3 != f63565e) {
                this.f63566a.onNext(t3);
                this.f63566a.onCompleted();
                return;
            }
            this.f63566a.onError(new NoSuchElementException());
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (!this.f63569d) {
                this.f63569d = true;
                this.f63566a.onError(th);
                return;
            }
            rx.plugins.c.I(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f63569d) {
                return;
            }
            T t4 = this.f63568c;
            if (t4 == f63565e) {
                this.f63568c = t3;
                return;
            }
            try {
                this.f63568c = this.f63567b.call(t4, t3);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(th);
            }
        }
    }

    public x0(rx.e<T> eVar, rx.functions.q<T, T, T> qVar) {
        this.f63561a = eVar;
        this.f63562b = qVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        b bVar = new b(lVar, this.f63562b);
        lVar.add(bVar);
        lVar.setProducer(new a(bVar));
        this.f63561a.I6(bVar);
    }
}
