package p640rx.schedulers;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Scheduler;
import p640rx.internal.schedulers.ExecutorScheduler;
import p640rx.internal.schedulers.GenericScheduledExecutorService;
import p640rx.internal.schedulers.ImmediateScheduler;
import p640rx.internal.schedulers.SchedulerLifecycle;
import p640rx.internal.schedulers.TrampolineScheduler;
import p640rx.plugins.RxJavaHooks;
import p640rx.plugins.RxJavaPlugins;
import p640rx.plugins.RxJavaSchedulersHook;

/* renamed from: rx.schedulers.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Schedulers {

    /* renamed from: d */
    private static final AtomicReference<Schedulers> f46968d = new AtomicReference<>();

    /* renamed from: a */
    private final Scheduler f46969a;

    /* renamed from: b */
    private final Scheduler f46970b;

    /* renamed from: c */
    private final Scheduler f46971c;

    private Schedulers() {
        RxJavaSchedulersHook m504f = RxJavaPlugins.m507c().m504f();
        Scheduler m490g = m504f.m490g();
        if (m490g != null) {
            this.f46969a = m490g;
        } else {
            this.f46969a = RxJavaSchedulersHook.m496a();
        }
        Scheduler m488i = m504f.m488i();
        if (m488i != null) {
            this.f46970b = m488i;
        } else {
            this.f46970b = RxJavaSchedulersHook.m494c();
        }
        Scheduler m487j = m504f.m487j();
        if (m487j != null) {
            this.f46971c = m487j;
        } else {
            this.f46971c = RxJavaSchedulersHook.m492e();
        }
    }

    /* renamed from: a */
    public static Scheduler m479a() {
        return RxJavaHooks.m580E(m477c().f46969a);
    }

    /* renamed from: b */
    public static Scheduler m478b(Executor executor) {
        return new ExecutorScheduler(executor);
    }

    /* renamed from: c */
    private static Schedulers m477c() {
        while (true) {
            AtomicReference<Schedulers> atomicReference = f46968d;
            Schedulers schedulers = atomicReference.get();
            if (schedulers != null) {
                return schedulers;
            }
            Schedulers schedulers2 = new Schedulers();
            if (atomicReference.compareAndSet(null, schedulers2)) {
                return schedulers2;
            }
            schedulers2.m471i();
        }
    }

    /* renamed from: d */
    public static Scheduler m476d() {
        return ImmediateScheduler.f46372a;
    }

    /* renamed from: e */
    public static Scheduler m475e() {
        return RxJavaHooks.m575J(m477c().f46970b);
    }

    /* renamed from: f */
    public static Scheduler m474f() {
        return RxJavaHooks.m574K(m477c().f46971c);
    }

    /* renamed from: g */
    public static void m473g() {
        Schedulers andSet = f46968d.getAndSet(null);
        if (andSet != null) {
            andSet.m471i();
        }
    }

    /* renamed from: h */
    public static void m472h() {
        Schedulers m477c = m477c();
        m477c.m471i();
        synchronized (m477c) {
            GenericScheduledExecutorService.f46366d.shutdown();
        }
    }

    /* renamed from: j */
    public static void m470j() {
        Schedulers m477c = m477c();
        m477c.m469k();
        synchronized (m477c) {
            GenericScheduledExecutorService.f46366d.start();
        }
    }

    /* renamed from: l */
    public static TestScheduler m468l() {
        return new TestScheduler();
    }

    /* renamed from: m */
    public static Scheduler m467m() {
        return TrampolineScheduler.f46420a;
    }

    /* renamed from: i */
    synchronized void m471i() {
        Scheduler scheduler = this.f46969a;
        if (scheduler instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) scheduler).shutdown();
        }
        Scheduler scheduler2 = this.f46970b;
        if (scheduler2 instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) scheduler2).shutdown();
        }
        Scheduler scheduler3 = this.f46971c;
        if (scheduler3 instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) scheduler3).shutdown();
        }
    }

    /* renamed from: k */
    synchronized void m469k() {
        Scheduler scheduler = this.f46969a;
        if (scheduler instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) scheduler).start();
        }
        Scheduler scheduler2 = this.f46970b;
        if (scheduler2 instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) scheduler2).start();
        }
        Scheduler scheduler3 = this.f46971c;
        if (scheduler3 instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) scheduler3).start();
        }
    }
}
