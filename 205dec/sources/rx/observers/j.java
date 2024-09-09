package rx.observers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.CompositeException;
import rx.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: TestSubscriber.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class j<T> extends l<T> {

    /* renamed from: h  reason: collision with root package name */
    private static final rx.f<Object> f64196h = new a();

    /* renamed from: a  reason: collision with root package name */
    private final rx.f<T> f64197a;

    /* renamed from: b  reason: collision with root package name */
    private final List<T> f64198b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Throwable> f64199c;

    /* renamed from: d  reason: collision with root package name */
    private int f64200d;

    /* renamed from: e  reason: collision with root package name */
    private final CountDownLatch f64201e;

    /* renamed from: f  reason: collision with root package name */
    private volatile int f64202f;

    /* renamed from: g  reason: collision with root package name */
    private volatile Thread f64203g;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: TestSubscriber.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class a implements rx.f<Object> {
        a() {
        }

        @Override // rx.f
        public void onCompleted() {
        }

        @Override // rx.f
        public void onError(Throwable th) {
        }

        @Override // rx.f
        public void onNext(Object obj) {
        }
    }

    public j(long j4) {
        this(f64196h, j4);
    }

    private void I(T t3, int i4) {
        T t4 = this.f64198b.get(i4);
        if (t3 == null) {
            if (t4 != null) {
                U("Value at index: " + i4 + " expected: [null] but was: [" + t4 + "]\n");
            }
        } else if (t3.equals(t4)) {
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Value at index: ");
            sb.append(i4);
            sb.append(" expected: [");
            sb.append(t3);
            sb.append("] (");
            sb.append(t3.getClass().getSimpleName());
            sb.append(") but was: [");
            sb.append(t4);
            sb.append("] (");
            sb.append(t4 != null ? t4.getClass().getSimpleName() : "null");
            sb.append(")\n");
            U(sb.toString());
        }
    }

    public static <T> j<T> Z() {
        return new j<>();
    }

    public static <T> j<T> a0(long j4) {
        return new j<>(j4);
    }

    public static <T> j<T> b0(rx.f<T> fVar) {
        return new j<>(fVar);
    }

    public static <T> j<T> c0(rx.f<T> fVar, long j4) {
        return new j<>(fVar, j4);
    }

    public static <T> j<T> d0(l<T> lVar) {
        return new j<>((l) lVar);
    }

    public final int B() {
        return this.f64200d;
    }

    public void F() {
        int i4 = this.f64200d;
        if (i4 == 0) {
            U("Not completed!");
        } else if (i4 > 1) {
            U("Completed multiple times: " + i4);
        }
    }

    public void G(Class<? extends Throwable> cls) {
        List<Throwable> list = this.f64199c;
        if (list.isEmpty()) {
            U("No errors");
        } else if (list.size() <= 1) {
            if (cls.isInstance(list.get(0))) {
                return;
            }
            AssertionError assertionError = new AssertionError("Exceptions differ; expected: " + cls + ", actual: " + list.get(0));
            assertionError.initCause(list.get(0));
            throw assertionError;
        } else {
            AssertionError assertionError2 = new AssertionError("Multiple errors: " + list.size());
            assertionError2.initCause(new CompositeException(list));
            throw assertionError2;
        }
    }

    public void H(Throwable th) {
        List<Throwable> list = this.f64199c;
        if (list.isEmpty()) {
            U("No errors");
        } else if (list.size() > 1) {
            U("Multiple errors");
        } else if (th.equals(list.get(0))) {
        } else {
            U("Exceptions differ; expected: " + th + ", actual: " + list.get(0));
        }
    }

    public void J() {
        if (k().isEmpty()) {
            return;
        }
        U("Unexpected onError events");
    }

    public void K() {
        List<Throwable> list = this.f64199c;
        int i4 = this.f64200d;
        if (!list.isEmpty() || i4 > 0) {
            if (list.isEmpty()) {
                U("Found " + list.size() + " errors and " + i4 + " completion events instead of none");
            } else if (list.size() == 1) {
                U("Found " + list.size() + " errors and " + i4 + " completion events instead of none");
            } else {
                U("Found " + list.size() + " errors and " + i4 + " completion events instead of none");
            }
        }
    }

    public void L() {
        int size = this.f64198b.size();
        if (size != 0) {
            U("No onNext events expected yet some received: " + size);
        }
    }

    public void M() {
        int i4 = this.f64200d;
        if (i4 == 1) {
            U("Completed!");
        } else if (i4 > 1) {
            U("Completed multiple times: " + i4);
        }
    }

    public void N(List<T> list) {
        if (this.f64198b.size() != list.size()) {
            U("Number of items does not match. Provided: " + list.size() + "  Actual: " + this.f64198b.size() + ".\nProvided values: " + list + "\nActual values: " + this.f64198b + "\n");
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            I(list.get(i4), i4);
        }
    }

    public void O() {
        if (this.f64199c.size() > 1) {
            U("Too many onError events: " + this.f64199c.size());
        }
        if (this.f64200d > 1) {
            U("Too many onCompleted events: " + this.f64200d);
        }
        if (this.f64200d == 1 && this.f64199c.size() == 1) {
            U("Received both an onError and onCompleted. Should be one or the other.");
        }
        if (this.f64200d == 0 && this.f64199c.isEmpty()) {
            U("No terminal events received.");
        }
    }

    public void P() {
        if (isUnsubscribed()) {
            return;
        }
        U("Not unsubscribed.");
    }

    public void Q(T t3) {
        N(Collections.singletonList(t3));
    }

    public void R(int i4) {
        int size = this.f64198b.size();
        if (size != i4) {
            U("Number of onNext events differ; expected: " + i4 + ", actual: " + size);
        }
    }

    public void S(T... tArr) {
        N(Arrays.asList(tArr));
    }

    public final void T(T t3, T... tArr) {
        R(tArr.length + 1);
        int i4 = 0;
        I(t3, 0);
        while (i4 < tArr.length) {
            T t4 = tArr[i4];
            i4++;
            I(t4, i4);
        }
        this.f64198b.clear();
    }

    final void U(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 32);
        sb.append(str);
        sb.append(" (");
        int i4 = this.f64200d;
        sb.append(i4);
        sb.append(" completion");
        if (i4 != 1) {
            sb.append('s');
        }
        sb.append(')');
        if (!this.f64199c.isEmpty()) {
            int size = this.f64199c.size();
            sb.append(" (+");
            sb.append(size);
            sb.append(" error");
            if (size != 1) {
                sb.append('s');
            }
            sb.append(')');
        }
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.f64199c.isEmpty()) {
            if (this.f64199c.size() == 1) {
                assertionError.initCause(this.f64199c.get(0));
            } else {
                assertionError.initCause(new CompositeException(this.f64199c));
            }
        }
        throw assertionError;
    }

    public void V() {
        try {
            this.f64201e.await();
        } catch (InterruptedException e4) {
            throw new IllegalStateException("Interrupted", e4);
        }
    }

    public void W(long j4, TimeUnit timeUnit) {
        try {
            this.f64201e.await(j4, timeUnit);
        } catch (InterruptedException e4) {
            throw new IllegalStateException("Interrupted", e4);
        }
    }

    public void X(long j4, TimeUnit timeUnit) {
        try {
            if (this.f64201e.await(j4, timeUnit)) {
                return;
            }
            unsubscribe();
        } catch (InterruptedException unused) {
            unsubscribe();
        }
    }

    public final boolean Y(int i4, long j4, TimeUnit timeUnit) {
        while (j4 != 0 && this.f64202f < i4) {
            try {
                timeUnit.sleep(1L);
                j4--;
            } catch (InterruptedException e4) {
                throw new IllegalStateException("Interrupted", e4);
            }
        }
        return this.f64202f >= i4;
    }

    public Thread e() {
        return this.f64203g;
    }

    @Deprecated
    public List<Notification<T>> e0() {
        int i4 = this.f64200d;
        ArrayList arrayList = new ArrayList(i4 != 0 ? i4 : 1);
        for (int i5 = 0; i5 < i4; i5++) {
            arrayList.add(Notification.b());
        }
        return arrayList;
    }

    public void f0(long j4) {
        request(j4);
    }

    public List<Throwable> k() {
        return this.f64199c;
    }

    public final int m() {
        return this.f64202f;
    }

    @Override // rx.f
    public void onCompleted() {
        try {
            this.f64200d++;
            this.f64203g = Thread.currentThread();
            this.f64197a.onCompleted();
        } finally {
            this.f64201e.countDown();
        }
    }

    @Override // rx.f
    public void onError(Throwable th) {
        try {
            this.f64203g = Thread.currentThread();
            this.f64199c.add(th);
            this.f64197a.onError(th);
        } finally {
            this.f64201e.countDown();
        }
    }

    @Override // rx.f
    public void onNext(T t3) {
        this.f64203g = Thread.currentThread();
        this.f64198b.add(t3);
        this.f64202f = this.f64198b.size();
        this.f64197a.onNext(t3);
    }

    public List<T> v() {
        return this.f64198b;
    }

    public j(rx.f<T> fVar, long j4) {
        this.f64201e = new CountDownLatch(1);
        fVar.getClass();
        this.f64197a = fVar;
        if (j4 >= 0) {
            request(j4);
        }
        this.f64198b = new ArrayList();
        this.f64199c = new ArrayList();
    }

    public j(l<T> lVar) {
        this(lVar, -1L);
    }

    public j(rx.f<T> fVar) {
        this(fVar, -1L);
    }

    public j() {
        this(-1L);
    }
}
