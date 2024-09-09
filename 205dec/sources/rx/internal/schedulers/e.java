package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import rx.functions.o;
import rx.internal.util.RxThreadFactory;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: GenericScheduledExecutorServiceFactory.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
enum e {
    ;
    

    /* renamed from: a  reason: collision with root package name */
    static final String f63800a = "RxScheduledExecutorPool-";

    /* renamed from: b  reason: collision with root package name */
    static final RxThreadFactory f63801b = new RxThreadFactory("RxScheduledExecutorPool-");

    public static ScheduledExecutorService a() {
        o<? extends ScheduledExecutorService> j4 = rx.plugins.c.j();
        if (j4 == null) {
            return b();
        }
        return j4.call();
    }

    static ScheduledExecutorService b() {
        return Executors.newScheduledThreadPool(1, c());
    }

    static ThreadFactory c() {
        return f63801b;
    }
}
