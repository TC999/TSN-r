package p640rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import p640rx.functions.Func0;
import p640rx.internal.util.RxThreadFactory;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.schedulers.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
enum GenericScheduledExecutorServiceFactory {
    ;
    

    /* renamed from: a */
    static final String f46369a = "RxScheduledExecutorPool-";

    /* renamed from: b */
    static final RxThreadFactory f46370b = new RxThreadFactory(f46369a);

    /* renamed from: a */
    public static ScheduledExecutorService m947a() {
        Func0<? extends ScheduledExecutorService> m540j = RxJavaHooks.m540j();
        if (m540j == null) {
            return m946b();
        }
        return m540j.call();
    }

    /* renamed from: b */
    static ScheduledExecutorService m946b() {
        return Executors.newScheduledThreadPool(1, m945c());
    }

    /* renamed from: c */
    static ThreadFactory m945c() {
        return f46370b;
    }
}
