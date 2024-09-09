package rx.plugins;

import java.util.concurrent.ThreadFactory;
import rx.internal.util.RxThreadFactory;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: RxJavaSchedulersHook.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final g f64235a = new g();

    public static rx.h a() {
        return b(new RxThreadFactory("RxComputationScheduler-"));
    }

    public static rx.h b(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new rx.internal.schedulers.b(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    public static rx.h c() {
        return d(new RxThreadFactory("RxIoScheduler-"));
    }

    public static rx.h d(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new rx.internal.schedulers.a(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    public static rx.h e() {
        return f(new RxThreadFactory("RxNewThreadScheduler-"));
    }

    public static rx.h f(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new rx.internal.schedulers.g(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    public static g h() {
        return f64235a;
    }

    public rx.h g() {
        return null;
    }

    public rx.h i() {
        return null;
    }

    public rx.h j() {
        return null;
    }

    @Deprecated
    public rx.functions.a k(rx.functions.a aVar) {
        return aVar;
    }
}
