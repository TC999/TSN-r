package p640rx.plugins;

import java.util.concurrent.ThreadFactory;
import p640rx.Scheduler;
import p640rx.functions.Action0;
import p640rx.internal.schedulers.CachedThreadScheduler;
import p640rx.internal.schedulers.EventLoopsScheduler;
import p640rx.internal.schedulers.NewThreadScheduler;
import p640rx.internal.util.RxThreadFactory;

/* renamed from: rx.plugins.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class RxJavaSchedulersHook {

    /* renamed from: a */
    private static final RxJavaSchedulersHook f46966a = new RxJavaSchedulersHook();

    /* renamed from: a */
    public static Scheduler m496a() {
        return m495b(new RxThreadFactory("RxComputationScheduler-"));
    }

    /* renamed from: b */
    public static Scheduler m495b(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new EventLoopsScheduler(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    /* renamed from: c */
    public static Scheduler m494c() {
        return m493d(new RxThreadFactory("RxIoScheduler-"));
    }

    /* renamed from: d */
    public static Scheduler m493d(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new CachedThreadScheduler(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    /* renamed from: e */
    public static Scheduler m492e() {
        return m491f(new RxThreadFactory("RxNewThreadScheduler-"));
    }

    /* renamed from: f */
    public static Scheduler m491f(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new NewThreadScheduler(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    /* renamed from: h */
    public static RxJavaSchedulersHook m489h() {
        return f46966a;
    }

    /* renamed from: g */
    public Scheduler m490g() {
        return null;
    }

    /* renamed from: i */
    public Scheduler m488i() {
        return null;
    }

    /* renamed from: j */
    public Scheduler m487j() {
        return null;
    }

    @Deprecated
    /* renamed from: k */
    public Action0 m486k(Action0 action0) {
        return action0;
    }
}
