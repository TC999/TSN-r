package p640rx.internal.util;

import java.io.PrintStream;
import java.util.Queue;
import p640rx.Observer;
import p640rx.Subscription;
import p640rx.exceptions.MissingBackpressureException;
import p640rx.internal.operators.NotificationLite;
import p640rx.internal.util.unsafe.C16092z;
import p640rx.internal.util.unsafe.SpmcArrayQueue;
import p640rx.internal.util.unsafe.UnsafeAccess;

/* renamed from: rx.internal.util.j */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class RxRingBuffer implements Subscription {

    /* renamed from: d */
    public static final int f46509d;

    /* renamed from: a */
    private Queue<Object> f46510a;

    /* renamed from: b */
    private final int f46511b;

    /* renamed from: c */
    public volatile Object f46512c;

    static {
        int i = PlatformDependent.m838b() ? 16 : 128;
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i = Integer.parseInt(property);
            } catch (NumberFormatException e) {
                PrintStream printStream = System.err;
                printStream.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e.getMessage());
            }
        }
        f46509d = i;
    }

    private RxRingBuffer(Queue<Object> queue, int i) {
        this.f46510a = queue;
        this.f46511b = i;
    }

    /* renamed from: H */
    public static RxRingBuffer m834H() {
        if (UnsafeAccess.m759f()) {
            return new RxRingBuffer(true, f46509d);
        }
        return new RxRingBuffer();
    }

    /* renamed from: I */
    public static RxRingBuffer m833I() {
        if (UnsafeAccess.m759f()) {
            return new RxRingBuffer(false, f46509d);
        }
        return new RxRingBuffer();
    }

    /* renamed from: F */
    public int m836F() {
        return this.f46511b;
    }

    /* renamed from: G */
    public int m835G() {
        Queue<Object> queue = this.f46510a;
        if (queue == null) {
            return 0;
        }
        return queue.size();
    }

    /* renamed from: J */
    public Object m832J(Object obj) {
        return NotificationLite.m1048e(obj);
    }

    /* renamed from: K */
    public boolean m831K(Object obj) {
        return NotificationLite.m1047f(obj);
    }

    /* renamed from: L */
    public boolean m830L() {
        Queue<Object> queue = this.f46510a;
        return queue == null || queue.isEmpty();
    }

    /* renamed from: M */
    public boolean m829M(Object obj) {
        return NotificationLite.m1046g(obj);
    }

    /* renamed from: N */
    public void m828N() {
        if (this.f46512c == null) {
            this.f46512c = NotificationLite.m1051b();
        }
    }

    /* renamed from: O */
    public void m827O(Throwable th) {
        if (this.f46512c == null) {
            this.f46512c = NotificationLite.m1050c(th);
        }
    }

    /* renamed from: P */
    public void m826P(Object obj) throws MissingBackpressureException {
        boolean z;
        boolean z2;
        synchronized (this) {
            Queue<Object> queue = this.f46510a;
            z = true;
            z2 = false;
            if (queue != null) {
                z2 = !queue.offer(NotificationLite.m1043j(obj));
                z = false;
            }
        }
        if (z) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        }
        if (z2) {
            throw new MissingBackpressureException();
        }
    }

    /* renamed from: Q */
    public Object m825Q() {
        synchronized (this) {
            Queue<Object> queue = this.f46510a;
            if (queue == null) {
                return null;
            }
            Object peek = queue.peek();
            Object obj = this.f46512c;
            if (peek == null && obj != null && queue.peek() == null) {
                peek = obj;
            }
            return peek;
        }
    }

    /* renamed from: R */
    public Object m824R() {
        synchronized (this) {
            Queue<Object> queue = this.f46510a;
            if (queue == null) {
                return null;
            }
            Object poll = queue.poll();
            Object obj = this.f46512c;
            if (poll == null && obj != null && queue.peek() == null) {
                this.f46512c = null;
                poll = obj;
            }
            return poll;
        }
    }

    /* renamed from: S */
    public synchronized void m823S() {
    }

    /* renamed from: a */
    public boolean m822a(Object obj, Observer observer) {
        return NotificationLite.m1052a(observer, obj);
    }

    /* renamed from: b */
    public Throwable m821b(Object obj) {
        return NotificationLite.m1049d(obj);
    }

    /* renamed from: d */
    public int m820d() {
        return this.f46511b - m835G();
    }

    @Override // p640rx.Subscription
    public boolean isUnsubscribed() {
        return this.f46510a == null;
    }

    @Override // p640rx.Subscription
    public void unsubscribe() {
        m823S();
    }

    private RxRingBuffer(boolean z, int i) {
        this.f46510a = z ? new SpmcArrayQueue<>(i) : new C16092z<>(i);
        this.f46511b = i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    RxRingBuffer() {
        /*
            r2 = this;
            rx.internal.util.atomic.d r0 = new rx.internal.util.atomic.d
            int r1 = p640rx.internal.util.RxRingBuffer.f46509d
            r0.<init>(r1)
            r2.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p640rx.internal.util.RxRingBuffer.<init>():void");
    }
}
