package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.exceptions.OnErrorThrowable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorReplay.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t2<T> extends rx.observables.c<T> implements rx.m {

    /* renamed from: e  reason: collision with root package name */
    static final rx.functions.o f63329e = new a();

    /* renamed from: b  reason: collision with root package name */
    final rx.e<? extends T> f63330b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<l<T>> f63331c;

    /* renamed from: d  reason: collision with root package name */
    final rx.functions.o<? extends k<T>> f63332d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorReplay.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a implements rx.functions.o {
        a() {
        }

        @Override // rx.functions.o, java.util.concurrent.Callable
        public Object call() {
            return new o(16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorReplay.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class b<R> implements e.a<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.o f63333a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.functions.p f63334b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorReplay.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.functions.b<rx.m> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.l f63335a;

            a(rx.l lVar) {
                this.f63335a = lVar;
            }

            @Override // rx.functions.b
            public void call(rx.m mVar) {
                this.f63335a.add(mVar);
            }
        }

        b(rx.functions.o oVar, rx.functions.p pVar) {
            this.f63333a = oVar;
            this.f63334b = pVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.l) ((rx.l) obj));
        }

        public void call(rx.l<? super R> lVar) {
            try {
                rx.observables.c cVar = (rx.observables.c) this.f63333a.call();
                ((rx.e) this.f63334b.call(cVar)).q5(lVar);
                cVar.z7(new a(lVar));
            } catch (Throwable th) {
                rx.exceptions.a.f(th, lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorReplay.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class c implements e.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.e f63337a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorReplay.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a extends rx.l<T> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.l f63338a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(rx.l lVar, rx.l lVar2) {
                super(lVar);
                this.f63338a = lVar2;
            }

            @Override // rx.f
            public void onCompleted() {
                this.f63338a.onCompleted();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                this.f63338a.onError(th);
            }

            @Override // rx.f
            public void onNext(T t3) {
                this.f63338a.onNext(t3);
            }
        }

        c(rx.e eVar) {
            this.f63337a = eVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.l) ((rx.l) obj));
        }

        public void call(rx.l<? super T> lVar) {
            this.f63337a.I6(new a(lVar, lVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorReplay.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class d extends rx.observables.c<T> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.observables.c f63340b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(e.a aVar, rx.observables.c cVar) {
            super(aVar);
            this.f63340b = cVar;
        }

        @Override // rx.observables.c
        public void z7(rx.functions.b<? super rx.m> bVar) {
            this.f63340b.z7(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorReplay.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class e implements rx.functions.o<k<T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f63341a;

        e(int i4) {
            this.f63341a = i4;
        }

        @Override // rx.functions.o, java.util.concurrent.Callable
        public k<T> call() {
            return new n(this.f63341a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorReplay.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class f implements rx.functions.o<k<T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f63342a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f63343b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.h f63344c;

        f(int i4, long j4, rx.h hVar) {
            this.f63342a = i4;
            this.f63343b = j4;
            this.f63344c = hVar;
        }

        @Override // rx.functions.o, java.util.concurrent.Callable
        public k<T> call() {
            return new m(this.f63342a, this.f63343b, this.f63344c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorReplay.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class g implements e.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicReference f63345a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.functions.o f63346b;

        g(AtomicReference atomicReference, rx.functions.o oVar) {
            this.f63345a = atomicReference;
            this.f63346b = oVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.l) ((rx.l) obj));
        }

        public void call(rx.l<? super T> lVar) {
            l lVar2;
            while (true) {
                lVar2 = (l) this.f63345a.get();
                if (lVar2 != null) {
                    break;
                }
                l lVar3 = new l((k) this.f63346b.call());
                lVar3.x();
                if (this.f63345a.compareAndSet(lVar2, lVar3)) {
                    lVar2 = lVar3;
                    break;
                }
            }
            i<T> iVar = new i<>(lVar2, lVar);
            lVar2.g(iVar);
            lVar.add(iVar);
            lVar2.f63361a.a(iVar);
            lVar.setProducer(iVar);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorReplay.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class h<T> extends AtomicReference<j> implements k<T> {
        private static final long serialVersionUID = 2346567790059478686L;

        /* renamed from: a  reason: collision with root package name */
        j f63347a;

        /* renamed from: b  reason: collision with root package name */
        int f63348b;

        /* renamed from: c  reason: collision with root package name */
        long f63349c;

        public h() {
            j jVar = new j(null, 0L);
            this.f63347a = jVar;
            set(jVar);
        }

        @Override // rx.internal.operators.t2.k
        public final void a(i<T> iVar) {
            rx.l<? super T> lVar;
            j jVar;
            synchronized (iVar) {
                if (iVar.f63355e) {
                    iVar.f63356f = true;
                    return;
                }
                iVar.f63355e = true;
                while (!iVar.isUnsubscribed()) {
                    j jVar2 = (j) iVar.b();
                    if (jVar2 == null) {
                        jVar2 = e();
                        iVar.f63353c = jVar2;
                        iVar.a(jVar2.f63358b);
                    }
                    if (iVar.isUnsubscribed() || (lVar = iVar.f63352b) == null) {
                        return;
                    }
                    long j4 = iVar.get();
                    long j5 = 0;
                    while (j5 != j4 && (jVar = jVar2.get()) != null) {
                        Object h4 = h(jVar.f63357a);
                        try {
                            if (v.a(lVar, h4)) {
                                iVar.f63353c = null;
                                return;
                            }
                            j5++;
                            if (iVar.isUnsubscribed()) {
                                return;
                            }
                            jVar2 = jVar;
                        } catch (Throwable th) {
                            iVar.f63353c = null;
                            rx.exceptions.a.e(th);
                            iVar.unsubscribe();
                            if (v.g(h4) || v.f(h4)) {
                                return;
                            }
                            lVar.onError(OnErrorThrowable.addValueAsLastCause(th, v.e(h4)));
                            return;
                        }
                    }
                    if (j5 != 0) {
                        iVar.f63353c = jVar2;
                        if (j4 != Long.MAX_VALUE) {
                            iVar.c(j5);
                        }
                    }
                    synchronized (iVar) {
                        if (!iVar.f63356f) {
                            iVar.f63355e = false;
                            return;
                        }
                        iVar.f63356f = false;
                    }
                }
            }
        }

        final void b(j jVar) {
            this.f63347a.set(jVar);
            this.f63347a = jVar;
            this.f63348b++;
        }

        final void c(Collection<? super T> collection) {
            j e4 = e();
            while (true) {
                e4 = e4.get();
                if (e4 == null) {
                    return;
                }
                Object h4 = h(e4.f63357a);
                if (v.f(h4) || v.g(h4)) {
                    return;
                }
                collection.add((Object) v.e(h4));
            }
        }

        @Override // rx.internal.operators.t2.k
        public final void complete() {
            Object d4 = d(v.b());
            long j4 = this.f63349c + 1;
            this.f63349c = j4;
            b(new j(d4, j4));
            m();
        }

        Object d(Object obj) {
            return obj;
        }

        j e() {
            return get();
        }

        @Override // rx.internal.operators.t2.k
        public final void error(Throwable th) {
            Object d4 = d(v.c(th));
            long j4 = this.f63349c + 1;
            this.f63349c = j4;
            b(new j(d4, j4));
            m();
        }

        boolean f() {
            Object obj = this.f63347a.f63357a;
            return obj != null && v.f(h(obj));
        }

        boolean g() {
            Object obj = this.f63347a.f63357a;
            return obj != null && v.g(h(obj));
        }

        Object h(Object obj) {
            return obj;
        }

        final void i() {
            j jVar = get().get();
            if (jVar != null) {
                this.f63348b--;
                k(jVar);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }

        final void j(int i4) {
            j jVar = get();
            while (i4 > 0) {
                jVar = jVar.get();
                i4--;
                this.f63348b--;
            }
            k(jVar);
        }

        final void k(j jVar) {
            set(jVar);
        }

        void l() {
        }

        void m() {
        }

        @Override // rx.internal.operators.t2.k
        public final void next(T t3) {
            Object d4 = d(v.j(t3));
            long j4 = this.f63349c + 1;
            this.f63349c = j4;
            b(new j(d4, j4));
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorReplay.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class i<T> extends AtomicLong implements rx.g, rx.m {

        /* renamed from: g  reason: collision with root package name */
        static final long f63350g = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;

        /* renamed from: a  reason: collision with root package name */
        final l<T> f63351a;

        /* renamed from: b  reason: collision with root package name */
        rx.l<? super T> f63352b;

        /* renamed from: c  reason: collision with root package name */
        Object f63353c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicLong f63354d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        boolean f63355e;

        /* renamed from: f  reason: collision with root package name */
        boolean f63356f;

        public i(l<T> lVar, rx.l<? super T> lVar2) {
            this.f63351a = lVar;
            this.f63352b = lVar2;
        }

        void a(long j4) {
            long j5;
            long j6;
            do {
                j5 = this.f63354d.get();
                j6 = j5 + j4;
                if (j6 < 0) {
                    j6 = Long.MAX_VALUE;
                }
            } while (!this.f63354d.compareAndSet(j5, j6));
        }

        <U> U b() {
            return (U) this.f63353c;
        }

        public long c(long j4) {
            long j5;
            long j6;
            if (j4 > 0) {
                do {
                    j5 = get();
                    if (j5 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    j6 = j5 - j4;
                    if (j6 < 0) {
                        throw new IllegalStateException("More produced (" + j4 + ") than requested (" + j5 + ")");
                    }
                } while (!compareAndSet(j5, j6));
                return j6;
            }
            throw new IllegalArgumentException("Cant produce zero or less");
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.g
        public void request(long j4) {
            long j5;
            long j6;
            if (j4 < 0) {
                return;
            }
            do {
                j5 = get();
                if (j5 == Long.MIN_VALUE) {
                    return;
                }
                if (j5 >= 0 && j4 == 0) {
                    return;
                }
                j6 = j5 + j4;
                if (j6 < 0) {
                    j6 = Long.MAX_VALUE;
                }
            } while (!compareAndSet(j5, j6));
            a(j4);
            this.f63351a.J(this);
            this.f63351a.f63361a.a(this);
        }

        @Override // rx.m
        public void unsubscribe() {
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.f63351a.L(this);
            this.f63351a.J(this);
            this.f63352b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorReplay.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class j extends AtomicReference<j> {
        private static final long serialVersionUID = 245354315435971818L;

        /* renamed from: a  reason: collision with root package name */
        final Object f63357a;

        /* renamed from: b  reason: collision with root package name */
        final long f63358b;

        public j(Object obj, long j4) {
            this.f63357a = obj;
            this.f63358b = j4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorReplay.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface k<T> {
        void a(i<T> iVar);

        void complete();

        void error(Throwable th);

        void next(T t3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorReplay.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class l<T> extends rx.l<T> implements rx.m {

        /* renamed from: p  reason: collision with root package name */
        static final i[] f63359p = new i[0];

        /* renamed from: q  reason: collision with root package name */
        static final i[] f63360q = new i[0];

        /* renamed from: a  reason: collision with root package name */
        final k<T> f63361a;

        /* renamed from: b  reason: collision with root package name */
        boolean f63362b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f63363c;

        /* renamed from: f  reason: collision with root package name */
        volatile long f63366f;

        /* renamed from: g  reason: collision with root package name */
        long f63367g;

        /* renamed from: i  reason: collision with root package name */
        boolean f63369i;

        /* renamed from: j  reason: collision with root package name */
        boolean f63370j;

        /* renamed from: k  reason: collision with root package name */
        long f63371k;

        /* renamed from: l  reason: collision with root package name */
        long f63372l;

        /* renamed from: m  reason: collision with root package name */
        volatile rx.g f63373m;

        /* renamed from: n  reason: collision with root package name */
        List<i<T>> f63374n;

        /* renamed from: o  reason: collision with root package name */
        boolean f63375o;

        /* renamed from: d  reason: collision with root package name */
        final rx.internal.util.h<i<T>> f63364d = new rx.internal.util.h<>();

        /* renamed from: e  reason: collision with root package name */
        i<T>[] f63365e = f63359p;

        /* renamed from: h  reason: collision with root package name */
        final AtomicBoolean f63368h = new AtomicBoolean();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorReplay.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.functions.a {
            a() {
            }

            @Override // rx.functions.a
            public void call() {
                if (l.this.f63363c) {
                    return;
                }
                synchronized (l.this.f63364d) {
                    if (!l.this.f63363c) {
                        l.this.f63364d.h();
                        l.this.f63366f++;
                        l.this.f63363c = true;
                    }
                }
            }
        }

        public l(k<T> kVar) {
            this.f63361a = kVar;
            request(0L);
        }

        void I(long j4, long j5) {
            long j6 = this.f63372l;
            rx.g gVar = this.f63373m;
            long j7 = j4 - j5;
            if (j7 == 0) {
                if (j6 == 0 || gVar == null) {
                    return;
                }
                this.f63372l = 0L;
                gVar.request(j6);
                return;
            }
            this.f63371k = j4;
            if (gVar == null) {
                long j8 = j6 + j7;
                if (j8 < 0) {
                    j8 = Long.MAX_VALUE;
                }
                this.f63372l = j8;
            } else if (j6 != 0) {
                this.f63372l = 0L;
                gVar.request(j6 + j7);
            } else {
                gVar.request(j7);
            }
        }

        void J(i<T> iVar) {
            i<T>[] v3;
            long j4;
            List<i<T>> list;
            boolean z3;
            long j5;
            i<T>[] v4;
            if (isUnsubscribed()) {
                return;
            }
            synchronized (this) {
                if (this.f63369i) {
                    if (iVar != null) {
                        List list2 = this.f63374n;
                        if (list2 == null) {
                            list2 = new ArrayList();
                            this.f63374n = list2;
                        }
                        list2.add(iVar);
                    } else {
                        this.f63375o = true;
                    }
                    this.f63370j = true;
                    return;
                }
                this.f63369i = true;
                long j6 = this.f63371k;
                if (iVar != null) {
                    j4 = Math.max(j6, iVar.f63354d.get());
                } else {
                    long j7 = j6;
                    for (i<T> iVar2 : v()) {
                        if (iVar2 != null) {
                            j7 = Math.max(j7, iVar2.f63354d.get());
                        }
                    }
                    j4 = j7;
                }
                I(j4, j6);
                while (!isUnsubscribed()) {
                    synchronized (this) {
                        if (!this.f63370j) {
                            this.f63369i = false;
                            return;
                        }
                        this.f63370j = false;
                        list = this.f63374n;
                        this.f63374n = null;
                        z3 = this.f63375o;
                        this.f63375o = false;
                    }
                    long j8 = this.f63371k;
                    if (list != null) {
                        j5 = j8;
                        for (i<T> iVar3 : list) {
                            j5 = Math.max(j5, iVar3.f63354d.get());
                        }
                    } else {
                        j5 = j8;
                    }
                    if (z3) {
                        for (i<T> iVar4 : v()) {
                            if (iVar4 != null) {
                                j5 = Math.max(j5, iVar4.f63354d.get());
                            }
                        }
                    }
                    I(j5, j8);
                }
            }
        }

        void L(i<T> iVar) {
            if (this.f63363c) {
                return;
            }
            synchronized (this.f63364d) {
                if (this.f63363c) {
                    return;
                }
                this.f63364d.f(iVar);
                if (this.f63364d.c()) {
                    this.f63365e = f63359p;
                }
                this.f63366f++;
            }
        }

        void M() {
            i<T>[] iVarArr = this.f63365e;
            if (this.f63367g != this.f63366f) {
                synchronized (this.f63364d) {
                    iVarArr = this.f63365e;
                    i<T>[] i4 = this.f63364d.i();
                    int length = i4.length;
                    if (iVarArr.length != length) {
                        iVarArr = new i[length];
                        this.f63365e = iVarArr;
                    }
                    System.arraycopy(i4, 0, iVarArr, 0, length);
                    this.f63367g = this.f63366f;
                }
            }
            k<T> kVar = this.f63361a;
            for (i<T> iVar : iVarArr) {
                if (iVar != null) {
                    kVar.a(iVar);
                }
            }
        }

        boolean g(i<T> iVar) {
            iVar.getClass();
            if (this.f63363c) {
                return false;
            }
            synchronized (this.f63364d) {
                if (this.f63363c) {
                    return false;
                }
                this.f63364d.a(iVar);
                this.f63366f++;
                return true;
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f63362b) {
                return;
            }
            this.f63362b = true;
            try {
                this.f63361a.complete();
                M();
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f63362b) {
                return;
            }
            this.f63362b = true;
            try {
                this.f63361a.error(th);
                M();
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f63362b) {
                return;
            }
            this.f63361a.next(t3);
            M();
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            if (this.f63373m == null) {
                this.f63373m = gVar;
                J(null);
                M();
                return;
            }
            throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
        }

        i<T>[] v() {
            i<T>[] iVarArr;
            synchronized (this.f63364d) {
                i<T>[] i4 = this.f63364d.i();
                int length = i4.length;
                iVarArr = new i[length];
                System.arraycopy(i4, 0, iVarArr, 0, length);
            }
            return iVarArr;
        }

        void x() {
            add(rx.subscriptions.f.a(new a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorReplay.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class m<T> extends h<T> {
        private static final long serialVersionUID = 3457957419649567404L;

        /* renamed from: d  reason: collision with root package name */
        final rx.h f63377d;

        /* renamed from: e  reason: collision with root package name */
        final long f63378e;

        /* renamed from: f  reason: collision with root package name */
        final int f63379f;

        public m(int i4, long j4, rx.h hVar) {
            this.f63377d = hVar;
            this.f63379f = i4;
            this.f63378e = j4;
        }

        @Override // rx.internal.operators.t2.h
        Object d(Object obj) {
            return new rx.schedulers.f(this.f63377d.b(), obj);
        }

        @Override // rx.internal.operators.t2.h
        j e() {
            j jVar;
            long b4 = this.f63377d.b() - this.f63378e;
            j jVar2 = get();
            j jVar3 = jVar2.get();
            while (true) {
                j jVar4 = jVar3;
                jVar = jVar2;
                jVar2 = jVar4;
                if (jVar2 == null) {
                    break;
                }
                Object obj = jVar2.f63357a;
                Object h4 = h(obj);
                if (v.f(h4) || v.g(h4) || ((rx.schedulers.f) obj).a() > b4) {
                    break;
                }
                jVar3 = jVar2.get();
            }
            return jVar;
        }

        @Override // rx.internal.operators.t2.h
        Object h(Object obj) {
            return ((rx.schedulers.f) obj).b();
        }

        @Override // rx.internal.operators.t2.h
        void l() {
            j jVar;
            long b4 = this.f63377d.b() - this.f63378e;
            j jVar2 = get();
            j jVar3 = jVar2.get();
            int i4 = 0;
            while (true) {
                j jVar4 = jVar3;
                jVar = jVar2;
                jVar2 = jVar4;
                if (jVar2 != null) {
                    int i5 = this.f63348b;
                    if (i5 > this.f63379f) {
                        i4++;
                        this.f63348b = i5 - 1;
                        jVar3 = jVar2.get();
                    } else if (((rx.schedulers.f) jVar2.f63357a).a() > b4) {
                        break;
                    } else {
                        i4++;
                        this.f63348b--;
                        jVar3 = jVar2.get();
                    }
                } else {
                    break;
                }
            }
            if (i4 != 0) {
                k(jVar);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
            k(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
            return;
         */
        @Override // rx.internal.operators.t2.h
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void m() {
            /*
                r10 = this;
                rx.h r0 = r10.f63377d
                long r0 = r0.b()
                long r2 = r10.f63378e
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                rx.internal.operators.t2$j r2 = (rx.internal.operators.t2.j) r2
                java.lang.Object r3 = r2.get()
                rx.internal.operators.t2$j r3 = (rx.internal.operators.t2.j) r3
                r4 = 0
            L16:
                r9 = r3
                r3 = r2
                r2 = r9
                if (r2 == 0) goto L3a
                int r5 = r10.f63348b
                r6 = 1
                if (r5 <= r6) goto L3a
                java.lang.Object r5 = r2.f63357a
                rx.schedulers.f r5 = (rx.schedulers.f) r5
                long r7 = r5.a()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L3a
                int r4 = r4 + 1
                int r3 = r10.f63348b
                int r3 = r3 - r6
                r10.f63348b = r3
                java.lang.Object r3 = r2.get()
                rx.internal.operators.t2$j r3 = (rx.internal.operators.t2.j) r3
                goto L16
            L3a:
                if (r4 == 0) goto L3f
                r10.k(r3)
            L3f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.t2.m.m():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorReplay.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class n<T> extends h<T> {
        private static final long serialVersionUID = -5898283885385201806L;

        /* renamed from: d  reason: collision with root package name */
        final int f63380d;

        public n(int i4) {
            this.f63380d = i4;
        }

        @Override // rx.internal.operators.t2.h
        void l() {
            if (this.f63348b > this.f63380d) {
                i();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorReplay.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class o<T> extends ArrayList<Object> implements k<T> {
        private static final long serialVersionUID = 7063189396499112664L;

        /* renamed from: a  reason: collision with root package name */
        volatile int f63381a;

        public o(int i4) {
            super(i4);
        }

        @Override // rx.internal.operators.t2.k
        public void a(i<T> iVar) {
            synchronized (iVar) {
                if (iVar.f63355e) {
                    iVar.f63356f = true;
                    return;
                }
                iVar.f63355e = true;
                while (!iVar.isUnsubscribed()) {
                    int i4 = this.f63381a;
                    Integer num = (Integer) iVar.b();
                    int intValue = num != null ? num.intValue() : 0;
                    rx.l<? super T> lVar = iVar.f63352b;
                    if (lVar == null) {
                        return;
                    }
                    long j4 = iVar.get();
                    long j5 = 0;
                    while (j5 != j4 && intValue < i4) {
                        Object obj = get(intValue);
                        try {
                            if (v.a(lVar, obj) || iVar.isUnsubscribed()) {
                                return;
                            }
                            intValue++;
                            j5++;
                        } catch (Throwable th) {
                            rx.exceptions.a.e(th);
                            iVar.unsubscribe();
                            if (v.g(obj) || v.f(obj)) {
                                return;
                            }
                            lVar.onError(OnErrorThrowable.addValueAsLastCause(th, v.e(obj)));
                            return;
                        }
                    }
                    if (j5 != 0) {
                        iVar.f63353c = Integer.valueOf(intValue);
                        if (j4 != Long.MAX_VALUE) {
                            iVar.c(j5);
                        }
                    }
                    synchronized (iVar) {
                        if (!iVar.f63356f) {
                            iVar.f63355e = false;
                            return;
                        }
                        iVar.f63356f = false;
                    }
                }
            }
        }

        @Override // rx.internal.operators.t2.k
        public void complete() {
            add(v.b());
            this.f63381a++;
        }

        @Override // rx.internal.operators.t2.k
        public void error(Throwable th) {
            add(v.c(th));
            this.f63381a++;
        }

        @Override // rx.internal.operators.t2.k
        public void next(T t3) {
            add(v.j(t3));
            this.f63381a++;
        }
    }

    private t2(e.a<T> aVar, rx.e<? extends T> eVar, AtomicReference<l<T>> atomicReference, rx.functions.o<? extends k<T>> oVar) {
        super(aVar);
        this.f63330b = eVar;
        this.f63331c = atomicReference;
        this.f63332d = oVar;
    }

    public static <T> rx.observables.c<T> B7(rx.e<? extends T> eVar) {
        return F7(eVar, f63329e);
    }

    public static <T> rx.observables.c<T> C7(rx.e<? extends T> eVar, int i4) {
        if (i4 == Integer.MAX_VALUE) {
            return B7(eVar);
        }
        return F7(eVar, new e(i4));
    }

    public static <T> rx.observables.c<T> D7(rx.e<? extends T> eVar, long j4, TimeUnit timeUnit, rx.h hVar) {
        return E7(eVar, j4, timeUnit, hVar, Integer.MAX_VALUE);
    }

    public static <T> rx.observables.c<T> E7(rx.e<? extends T> eVar, long j4, TimeUnit timeUnit, rx.h hVar, int i4) {
        return F7(eVar, new f(i4, timeUnit.toMillis(j4), hVar));
    }

    static <T> rx.observables.c<T> F7(rx.e<? extends T> eVar, rx.functions.o<? extends k<T>> oVar) {
        AtomicReference atomicReference = new AtomicReference();
        return new t2(new g(atomicReference, oVar), eVar, atomicReference, oVar);
    }

    public static <T, U, R> rx.e<R> G7(rx.functions.o<? extends rx.observables.c<U>> oVar, rx.functions.p<? super rx.e<U>, ? extends rx.e<R>> pVar) {
        return rx.e.H6(new b(oVar, pVar));
    }

    public static <T> rx.observables.c<T> H7(rx.observables.c<T> cVar, rx.h hVar) {
        return new d(new c(cVar.H3(hVar)), cVar);
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        l<T> lVar = this.f63331c.get();
        return lVar == null || lVar.isUnsubscribed();
    }

    @Override // rx.m
    public void unsubscribe() {
        this.f63331c.lazySet(null);
    }

    @Override // rx.observables.c
    public void z7(rx.functions.b<? super rx.m> bVar) {
        l<T> lVar;
        while (true) {
            lVar = this.f63331c.get();
            if (lVar != null && !lVar.isUnsubscribed()) {
                break;
            }
            l<T> lVar2 = new l<>(this.f63332d.call());
            lVar2.x();
            if (this.f63331c.compareAndSet(lVar, lVar2)) {
                lVar = lVar2;
                break;
            }
        }
        boolean z3 = true;
        z3 = (lVar.f63368h.get() || !lVar.f63368h.compareAndSet(false, true)) ? false : false;
        bVar.call(lVar);
        if (z3) {
            this.f63330b.I6(lVar);
        }
    }
}
