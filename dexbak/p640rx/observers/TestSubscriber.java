package p640rx.observers;

import com.snail.antifake.deviceid.ShellAdbUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p640rx.Notification;
import p640rx.Observer;
import p640rx.Subscriber;
import p640rx.exceptions.CompositeException;

/* renamed from: rx.observers.j */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class TestSubscriber<T> extends Subscriber<T> {

    /* renamed from: h */
    private static final Observer<Object> f46927h = new C16136a();

    /* renamed from: a */
    private final Observer<T> f46928a;

    /* renamed from: b */
    private final List<T> f46929b;

    /* renamed from: c */
    private final List<Throwable> f46930c;

    /* renamed from: d */
    private int f46931d;

    /* renamed from: e */
    private final CountDownLatch f46932e;

    /* renamed from: f */
    private volatile int f46933f;

    /* renamed from: g */
    private volatile Thread f46934g;

    /* compiled from: TestSubscriber.java */
    /* renamed from: rx.observers.j$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16136a implements Observer<Object> {
        C16136a() {
        }

        @Override // p640rx.Observer
        public void onCompleted() {
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
        }

        @Override // p640rx.Observer
        public void onNext(Object obj) {
        }
    }

    public TestSubscriber(long j) {
        this(f46927h, j);
    }

    /* renamed from: I */
    private void m619I(T t, int i) {
        T t2 = this.f46929b.get(i);
        if (t == null) {
            if (t2 != null) {
                m607U("Value at index: " + i + " expected: [null] but was: [" + t2 + "]\n");
            }
        } else if (t.equals(t2)) {
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Value at index: ");
            sb.append(i);
            sb.append(" expected: [");
            sb.append(t);
            sb.append("] (");
            sb.append(t.getClass().getSimpleName());
            sb.append(") but was: [");
            sb.append(t2);
            sb.append("] (");
            sb.append(t2 != null ? t2.getClass().getSimpleName() : "null");
            sb.append(")\n");
            m607U(sb.toString());
        }
    }

    /* renamed from: Z */
    public static <T> TestSubscriber<T> m602Z() {
        return new TestSubscriber<>();
    }

    /* renamed from: a0 */
    public static <T> TestSubscriber<T> m601a0(long j) {
        return new TestSubscriber<>(j);
    }

    /* renamed from: b0 */
    public static <T> TestSubscriber<T> m600b0(Observer<T> observer) {
        return new TestSubscriber<>(observer);
    }

    /* renamed from: c0 */
    public static <T> TestSubscriber<T> m599c0(Observer<T> observer, long j) {
        return new TestSubscriber<>(observer, j);
    }

    /* renamed from: d0 */
    public static <T> TestSubscriber<T> m598d0(Subscriber<T> subscriber) {
        return new TestSubscriber<>((Subscriber) subscriber);
    }

    /* renamed from: B */
    public final int m623B() {
        return this.f46931d;
    }

    /* renamed from: F */
    public void m622F() {
        int i = this.f46931d;
        if (i == 0) {
            m607U("Not completed!");
        } else if (i > 1) {
            m607U("Completed multiple times: " + i);
        }
    }

    /* renamed from: G */
    public void m621G(Class<? extends Throwable> cls) {
        List<Throwable> list = this.f46930c;
        if (list.isEmpty()) {
            m607U("No errors");
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

    /* renamed from: H */
    public void m620H(Throwable th) {
        List<Throwable> list = this.f46930c;
        if (list.isEmpty()) {
            m607U("No errors");
        } else if (list.size() > 1) {
            m607U("Multiple errors");
        } else if (th.equals(list.get(0))) {
        } else {
            m607U("Exceptions differ; expected: " + th + ", actual: " + list.get(0));
        }
    }

    /* renamed from: J */
    public void m618J() {
        if (m594k().isEmpty()) {
            return;
        }
        m607U("Unexpected onError events");
    }

    /* renamed from: K */
    public void m617K() {
        List<Throwable> list = this.f46930c;
        int i = this.f46931d;
        if (!list.isEmpty() || i > 0) {
            if (list.isEmpty()) {
                m607U("Found " + list.size() + " errors and " + i + " completion events instead of none");
            } else if (list.size() == 1) {
                m607U("Found " + list.size() + " errors and " + i + " completion events instead of none");
            } else {
                m607U("Found " + list.size() + " errors and " + i + " completion events instead of none");
            }
        }
    }

    /* renamed from: L */
    public void m616L() {
        int size = this.f46929b.size();
        if (size != 0) {
            m607U("No onNext events expected yet some received: " + size);
        }
    }

    /* renamed from: M */
    public void m615M() {
        int i = this.f46931d;
        if (i == 1) {
            m607U("Completed!");
        } else if (i > 1) {
            m607U("Completed multiple times: " + i);
        }
    }

    /* renamed from: N */
    public void m614N(List<T> list) {
        if (this.f46929b.size() != list.size()) {
            m607U("Number of items does not match. Provided: " + list.size() + "  Actual: " + this.f46929b.size() + ".\nProvided values: " + list + ShellAdbUtils.f33810d + "Actual values: " + this.f46929b + ShellAdbUtils.f33810d);
        }
        for (int i = 0; i < list.size(); i++) {
            m619I(list.get(i), i);
        }
    }

    /* renamed from: O */
    public void m613O() {
        if (this.f46930c.size() > 1) {
            m607U("Too many onError events: " + this.f46930c.size());
        }
        if (this.f46931d > 1) {
            m607U("Too many onCompleted events: " + this.f46931d);
        }
        if (this.f46931d == 1 && this.f46930c.size() == 1) {
            m607U("Received both an onError and onCompleted. Should be one or the other.");
        }
        if (this.f46931d == 0 && this.f46930c.isEmpty()) {
            m607U("No terminal events received.");
        }
    }

    /* renamed from: P */
    public void m612P() {
        if (isUnsubscribed()) {
            return;
        }
        m607U("Not unsubscribed.");
    }

    /* renamed from: Q */
    public void m611Q(T t) {
        m614N(Collections.singletonList(t));
    }

    /* renamed from: R */
    public void m610R(int i) {
        int size = this.f46929b.size();
        if (size != i) {
            m607U("Number of onNext events differ; expected: " + i + ", actual: " + size);
        }
    }

    /* renamed from: S */
    public void m609S(T... tArr) {
        m614N(Arrays.asList(tArr));
    }

    /* renamed from: T */
    public final void m608T(T t, T... tArr) {
        m610R(tArr.length + 1);
        int i = 0;
        m619I(t, 0);
        while (i < tArr.length) {
            T t2 = tArr[i];
            i++;
            m619I(t2, i);
        }
        this.f46929b.clear();
    }

    /* renamed from: U */
    final void m607U(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 32);
        sb.append(str);
        sb.append(" (");
        int i = this.f46931d;
        sb.append(i);
        sb.append(" completion");
        if (i != 1) {
            sb.append('s');
        }
        sb.append(')');
        if (!this.f46930c.isEmpty()) {
            int size = this.f46930c.size();
            sb.append(" (+");
            sb.append(size);
            sb.append(" error");
            if (size != 1) {
                sb.append('s');
            }
            sb.append(')');
        }
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.f46930c.isEmpty()) {
            if (this.f46930c.size() == 1) {
                assertionError.initCause(this.f46930c.get(0));
            } else {
                assertionError.initCause(new CompositeException(this.f46930c));
            }
        }
        throw assertionError;
    }

    /* renamed from: V */
    public void m606V() {
        try {
            this.f46932e.await();
        } catch (InterruptedException e) {
            throw new IllegalStateException("Interrupted", e);
        }
    }

    /* renamed from: W */
    public void m605W(long j, TimeUnit timeUnit) {
        try {
            this.f46932e.await(j, timeUnit);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Interrupted", e);
        }
    }

    /* renamed from: X */
    public void m604X(long j, TimeUnit timeUnit) {
        try {
            if (this.f46932e.await(j, timeUnit)) {
                return;
            }
            unsubscribe();
        } catch (InterruptedException unused) {
            unsubscribe();
        }
    }

    /* renamed from: Y */
    public final boolean m603Y(int i, long j, TimeUnit timeUnit) {
        while (j != 0 && this.f46933f < i) {
            try {
                timeUnit.sleep(1L);
                j--;
            } catch (InterruptedException e) {
                throw new IllegalStateException("Interrupted", e);
            }
        }
        return this.f46933f >= i;
    }

    /* renamed from: e */
    public Thread m597e() {
        return this.f46934g;
    }

    @Deprecated
    /* renamed from: e0 */
    public List<Notification<T>> m596e0() {
        int i = this.f46931d;
        ArrayList arrayList = new ArrayList(i != 0 ? i : 1);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Notification.m2005b());
        }
        return arrayList;
    }

    /* renamed from: f0 */
    public void m595f0(long j) {
        request(j);
    }

    /* renamed from: k */
    public List<Throwable> m594k() {
        return this.f46930c;
    }

    /* renamed from: m */
    public final int m593m() {
        return this.f46933f;
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        try {
            this.f46931d++;
            this.f46934g = Thread.currentThread();
            this.f46928a.onCompleted();
        } finally {
            this.f46932e.countDown();
        }
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        try {
            this.f46934g = Thread.currentThread();
            this.f46930c.add(th);
            this.f46928a.onError(th);
        } finally {
            this.f46932e.countDown();
        }
    }

    @Override // p640rx.Observer
    public void onNext(T t) {
        this.f46934g = Thread.currentThread();
        this.f46929b.add(t);
        this.f46933f = this.f46929b.size();
        this.f46928a.onNext(t);
    }

    /* renamed from: v */
    public List<T> m592v() {
        return this.f46929b;
    }

    public TestSubscriber(Observer<T> observer, long j) {
        this.f46932e = new CountDownLatch(1);
        observer.getClass();
        this.f46928a = observer;
        if (j >= 0) {
            request(j);
        }
        this.f46929b = new ArrayList();
        this.f46930c = new ArrayList();
    }

    public TestSubscriber(Subscriber<T> subscriber) {
        this(subscriber, -1L);
    }

    public TestSubscriber(Observer<T> observer) {
        this(observer, -1L);
    }

    public TestSubscriber() {
        this(-1L);
    }
}
