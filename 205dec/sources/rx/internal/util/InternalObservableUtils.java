package rx.internal.util;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.e;
import rx.exceptions.OnErrorNotImplementedException;
import rx.internal.operators.m1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new h();
    public static final f OBJECT_EQUALS = new f();
    public static final q TO_ARRAY = new q();
    static final o RETURNS_VOID = new o();
    public static final g COUNTER = new g();
    static final e ERROR_EXTRACTOR = new e();
    public static final rx.functions.b<Throwable> ERROR_NOT_IMPLEMENTED = new rx.functions.b<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        @Override // rx.functions.b
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final e.b<Boolean, Object> IS_EMPTY = new m1(rx.internal.util.n.b(), true);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class a<T, R> implements rx.functions.q<R, T, R> {

        /* renamed from: a  reason: collision with root package name */
        final rx.functions.c<R, ? super T> f63861a;

        public a(rx.functions.c<R, ? super T> cVar) {
            this.f63861a = cVar;
        }

        @Override // rx.functions.q
        public R call(R r3, T t3) {
            this.f63861a.call(r3, t3);
            return r3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class b implements rx.functions.p<Object, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final Object f63862a;

        public b(Object obj) {
            this.f63862a = obj;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.p
        public Boolean call(Object obj) {
            Object obj2 = this.f63862a;
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class d implements rx.functions.p<Object, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final Class<?> f63863a;

        public d(Class<?> cls) {
            this.f63863a = cls;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.p
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.f63863a.isInstance(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class e implements rx.functions.p<Notification<?>, Throwable> {
        e() {
        }

        @Override // rx.functions.p
        public Throwable call(Notification<?> notification) {
            return notification.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class f implements rx.functions.q<Object, Object, Boolean> {
        f() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.q
        public Boolean call(Object obj, Object obj2) {
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class g implements rx.functions.q<Integer, Object, Integer> {
        g() {
        }

        @Override // rx.functions.q
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class h implements rx.functions.q<Long, Object, Long> {
        h() {
        }

        @Override // rx.functions.q
        public Long call(Long l4, Object obj) {
            return Long.valueOf(l4.longValue() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class i implements rx.functions.p<rx.e<? extends Notification<?>>, rx.e<?>> {

        /* renamed from: a  reason: collision with root package name */
        final rx.functions.p<? super rx.e<? extends Void>, ? extends rx.e<?>> f63864a;

        public i(rx.functions.p<? super rx.e<? extends Void>, ? extends rx.e<?>> pVar) {
            this.f63864a = pVar;
        }

        @Override // rx.functions.p
        public rx.e<?> call(rx.e<? extends Notification<?>> eVar) {
            return this.f63864a.call(eVar.b3(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class j<T> implements rx.functions.o<rx.observables.c<T>> {

        /* renamed from: a  reason: collision with root package name */
        private final rx.e<T> f63865a;

        /* renamed from: b  reason: collision with root package name */
        private final int f63866b;

        j(rx.e<T> eVar, int i4) {
            this.f63865a = eVar;
            this.f63866b = i4;
        }

        @Override // rx.functions.o, java.util.concurrent.Callable
        public rx.observables.c<T> call() {
            return this.f63865a.u4(this.f63866b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class k<T> implements rx.functions.o<rx.observables.c<T>> {

        /* renamed from: a  reason: collision with root package name */
        private final TimeUnit f63867a;

        /* renamed from: b  reason: collision with root package name */
        private final rx.e<T> f63868b;

        /* renamed from: c  reason: collision with root package name */
        private final long f63869c;

        /* renamed from: d  reason: collision with root package name */
        private final rx.h f63870d;

        k(rx.e<T> eVar, long j4, TimeUnit timeUnit, rx.h hVar) {
            this.f63867a = timeUnit;
            this.f63868b = eVar;
            this.f63869c = j4;
            this.f63870d = hVar;
        }

        @Override // rx.functions.o, java.util.concurrent.Callable
        public rx.observables.c<T> call() {
            return this.f63868b.z4(this.f63869c, this.f63867a, this.f63870d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class l<T> implements rx.functions.o<rx.observables.c<T>> {

        /* renamed from: a  reason: collision with root package name */
        private final rx.e<T> f63871a;

        l(rx.e<T> eVar) {
            this.f63871a = eVar;
        }

        @Override // rx.functions.o, java.util.concurrent.Callable
        public rx.observables.c<T> call() {
            return this.f63871a.t4();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class m<T> implements rx.functions.o<rx.observables.c<T>> {

        /* renamed from: a  reason: collision with root package name */
        private final long f63872a;

        /* renamed from: b  reason: collision with root package name */
        private final TimeUnit f63873b;

        /* renamed from: c  reason: collision with root package name */
        private final rx.h f63874c;

        /* renamed from: d  reason: collision with root package name */
        private final int f63875d;

        /* renamed from: e  reason: collision with root package name */
        private final rx.e<T> f63876e;

        m(rx.e<T> eVar, int i4, long j4, TimeUnit timeUnit, rx.h hVar) {
            this.f63872a = j4;
            this.f63873b = timeUnit;
            this.f63874c = hVar;
            this.f63875d = i4;
            this.f63876e = eVar;
        }

        @Override // rx.functions.o, java.util.concurrent.Callable
        public rx.observables.c<T> call() {
            return this.f63876e.w4(this.f63875d, this.f63872a, this.f63873b, this.f63874c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class n implements rx.functions.p<rx.e<? extends Notification<?>>, rx.e<?>> {

        /* renamed from: a  reason: collision with root package name */
        final rx.functions.p<? super rx.e<? extends Throwable>, ? extends rx.e<?>> f63877a;

        public n(rx.functions.p<? super rx.e<? extends Throwable>, ? extends rx.e<?>> pVar) {
            this.f63877a = pVar;
        }

        @Override // rx.functions.p
        public rx.e<?> call(rx.e<? extends Notification<?>> eVar) {
            return this.f63877a.call(eVar.b3(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class o implements rx.functions.p<Object, Void> {
        o() {
        }

        @Override // rx.functions.p
        public Void call(Object obj) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class p<T, R> implements rx.functions.p<rx.e<T>, rx.e<R>> {

        /* renamed from: a  reason: collision with root package name */
        final rx.functions.p<? super rx.e<T>, ? extends rx.e<R>> f63878a;

        /* renamed from: b  reason: collision with root package name */
        final rx.h f63879b;

        public p(rx.functions.p<? super rx.e<T>, ? extends rx.e<R>> pVar, rx.h hVar) {
            this.f63878a = pVar;
            this.f63879b = hVar;
        }

        @Override // rx.functions.p
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((rx.e) ((rx.e) obj));
        }

        public rx.e<R> call(rx.e<T> eVar) {
            return this.f63878a.call(eVar).H3(this.f63879b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class q implements rx.functions.p<List<? extends rx.e<?>>, rx.e<?>[]> {
        q() {
        }

        @Override // rx.functions.p
        public rx.e<?>[] call(List<? extends rx.e<?>> list) {
            return (rx.e[]) list.toArray(new rx.e[list.size()]);
        }
    }

    public static <T, R> rx.functions.q<R, T, R> createCollectorCaller(rx.functions.c<R, ? super T> cVar) {
        return new a(cVar);
    }

    public static rx.functions.p<rx.e<? extends Notification<?>>, rx.e<?>> createRepeatDematerializer(rx.functions.p<? super rx.e<? extends Void>, ? extends rx.e<?>> pVar) {
        return new i(pVar);
    }

    public static <T, R> rx.functions.p<rx.e<T>, rx.e<R>> createReplaySelectorAndObserveOn(rx.functions.p<? super rx.e<T>, ? extends rx.e<R>> pVar, rx.h hVar) {
        return new p(pVar, hVar);
    }

    public static <T> rx.functions.o<rx.observables.c<T>> createReplaySupplier(rx.e<T> eVar) {
        return new l(eVar);
    }

    public static rx.functions.p<rx.e<? extends Notification<?>>, rx.e<?>> createRetryDematerializer(rx.functions.p<? super rx.e<? extends Throwable>, ? extends rx.e<?>> pVar) {
        return new n(pVar);
    }

    public static rx.functions.p<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static rx.functions.p<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> rx.functions.o<rx.observables.c<T>> createReplaySupplier(rx.e<T> eVar, int i4) {
        return new j(eVar, i4);
    }

    public static <T> rx.functions.o<rx.observables.c<T>> createReplaySupplier(rx.e<T> eVar, long j4, TimeUnit timeUnit, rx.h hVar) {
        return new k(eVar, j4, timeUnit, hVar);
    }

    public static <T> rx.functions.o<rx.observables.c<T>> createReplaySupplier(rx.e<T> eVar, int i4, long j4, TimeUnit timeUnit, rx.h hVar) {
        return new m(eVar, i4, j4, timeUnit, hVar);
    }
}
