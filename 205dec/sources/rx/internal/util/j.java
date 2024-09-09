package rx.internal.util;

import java.io.PrintStream;
import java.util.Queue;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.v;
import rx.internal.util.unsafe.n0;
import rx.internal.util.unsafe.r;
import rx.internal.util.unsafe.z;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: RxRingBuffer.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class j implements rx.m {

    /* renamed from: d  reason: collision with root package name */
    public static final int f63940d;

    /* renamed from: a  reason: collision with root package name */
    private Queue<Object> f63941a;

    /* renamed from: b  reason: collision with root package name */
    private final int f63942b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Object f63943c;

    static {
        int i4 = i.b() ? 16 : 128;
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i4 = Integer.parseInt(property);
            } catch (NumberFormatException e4) {
                PrintStream printStream = System.err;
                printStream.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e4.getMessage());
            }
        }
        f63940d = i4;
    }

    private j(Queue<Object> queue, int i4) {
        this.f63941a = queue;
        this.f63942b = i4;
    }

    public static j H() {
        if (n0.f()) {
            return new j(true, f63940d);
        }
        return new j();
    }

    public static j I() {
        if (n0.f()) {
            return new j(false, f63940d);
        }
        return new j();
    }

    public int F() {
        return this.f63942b;
    }

    public int G() {
        Queue<Object> queue = this.f63941a;
        if (queue == null) {
            return 0;
        }
        return queue.size();
    }

    public Object J(Object obj) {
        return v.e(obj);
    }

    public boolean K(Object obj) {
        return v.f(obj);
    }

    public boolean L() {
        Queue<Object> queue = this.f63941a;
        return queue == null || queue.isEmpty();
    }

    public boolean M(Object obj) {
        return v.g(obj);
    }

    public void N() {
        if (this.f63943c == null) {
            this.f63943c = v.b();
        }
    }

    public void O(Throwable th) {
        if (this.f63943c == null) {
            this.f63943c = v.c(th);
        }
    }

    public void P(Object obj) throws MissingBackpressureException {
        boolean z3;
        boolean z4;
        synchronized (this) {
            Queue<Object> queue = this.f63941a;
            z3 = true;
            z4 = false;
            if (queue != null) {
                z4 = !queue.offer(v.j(obj));
                z3 = false;
            }
        }
        if (z3) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        }
        if (z4) {
            throw new MissingBackpressureException();
        }
    }

    public Object Q() {
        synchronized (this) {
            Queue<Object> queue = this.f63941a;
            if (queue == null) {
                return null;
            }
            Object peek = queue.peek();
            Object obj = this.f63943c;
            if (peek == null && obj != null && queue.peek() == null) {
                peek = obj;
            }
            return peek;
        }
    }

    public Object R() {
        synchronized (this) {
            Queue<Object> queue = this.f63941a;
            if (queue == null) {
                return null;
            }
            Object poll = queue.poll();
            Object obj = this.f63943c;
            if (poll == null && obj != null && queue.peek() == null) {
                this.f63943c = null;
                poll = obj;
            }
            return poll;
        }
    }

    public synchronized void S() {
    }

    public boolean a(Object obj, rx.f fVar) {
        return v.a(fVar, obj);
    }

    public Throwable b(Object obj) {
        return v.d(obj);
    }

    public int d() {
        return this.f63942b - G();
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f63941a == null;
    }

    @Override // rx.m
    public void unsubscribe() {
        S();
    }

    private j(boolean z3, int i4) {
        this.f63941a = z3 ? new r<>(i4) : new z<>(i4);
        this.f63942b = i4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    j() {
        /*
            r2 = this;
            rx.internal.util.atomic.d r0 = new rx.internal.util.atomic.d
            int r1 = rx.internal.util.j.f63940d
            r0.<init>(r1)
            r2.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.j.<init>():void");
    }
}
