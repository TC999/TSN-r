package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.e;
import rx.internal.producers.SingleProducer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorSingle.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a3<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f62330a;

    /* renamed from: b  reason: collision with root package name */
    private final T f62331b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSingle.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final a3<?> f62332a = new a3<>();

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSingle.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        private final rx.l<? super T> f62333a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f62334b;

        /* renamed from: c  reason: collision with root package name */
        private final T f62335c;

        /* renamed from: d  reason: collision with root package name */
        private T f62336d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f62337e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f62338f;

        b(rx.l<? super T> lVar, boolean z3, T t3) {
            this.f62333a = lVar;
            this.f62334b = z3;
            this.f62335c = t3;
            request(2L);
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f62338f) {
                return;
            }
            if (this.f62337e) {
                this.f62333a.setProducer(new SingleProducer(this.f62333a, this.f62336d));
            } else if (this.f62334b) {
                this.f62333a.setProducer(new SingleProducer(this.f62333a, this.f62335c));
            } else {
                this.f62333a.onError(new NoSuchElementException("Sequence contains no elements"));
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f62338f) {
                rx.plugins.c.I(th);
            } else {
                this.f62333a.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f62338f) {
                return;
            }
            if (this.f62337e) {
                this.f62338f = true;
                this.f62333a.onError(new IllegalArgumentException("Sequence contains too many elements"));
                unsubscribe();
                return;
            }
            this.f62336d = t3;
            this.f62337e = true;
        }
    }

    a3() {
        this(false, null);
    }

    public static <T> a3<T> a() {
        return (a3<T>) a.f62332a;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public a3(T t3) {
        this(true, t3);
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        b bVar = new b(lVar, this.f62330a, this.f62331b);
        lVar.add(bVar);
        return bVar;
    }

    private a3(boolean z3, T t3) {
        this.f62330a = z3;
        this.f62331b = t3;
    }
}
