package p640rx.exceptions;

import java.util.HashSet;
import java.util.List;
import p640rx.Observer;
import p640rx.SingleSubscriber;

/* compiled from: Exceptions.java */
/* renamed from: rx.exceptions.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15575a {

    /* renamed from: a */
    private static final int f44789a = 25;

    private C15575a() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static void m1478a(Throwable th, Throwable th2) {
        HashSet hashSet = new HashSet();
        int i = 0;
        while (th.getCause() != null) {
            int i2 = i + 1;
            if (i >= 25) {
                return;
            }
            th = th.getCause();
            if (!hashSet.contains(th.getCause())) {
                hashSet.add(th.getCause());
                i = i2;
            }
        }
        try {
            th.initCause(th2);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public static Throwable m1477b(Throwable th) {
        int i = 0;
        while (th.getCause() != null) {
            int i2 = i + 1;
            if (i >= 25) {
                return new RuntimeException("Stack too deep to get final cause");
            }
            th = th.getCause();
            i = i2;
        }
        return th;
    }

    /* renamed from: c */
    public static RuntimeException m1476c(Throwable th) {
        if (!(th instanceof RuntimeException)) {
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
        throw ((RuntimeException) th);
    }

    /* renamed from: d */
    public static void m1475d(List<? extends Throwable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (list.size() == 1) {
            Throwable th = list.get(0);
            if (!(th instanceof RuntimeException)) {
                if (th instanceof Error) {
                    throw ((Error) th);
                }
                throw new RuntimeException(th);
            }
            throw ((RuntimeException) th);
        }
        throw new CompositeException(list);
    }

    /* renamed from: e */
    public static void m1474e(Throwable th) {
        if (!(th instanceof OnErrorNotImplementedException)) {
            if (!(th instanceof OnErrorFailedException)) {
                if (!(th instanceof OnCompletedFailedException)) {
                    if (!(th instanceof VirtualMachineError)) {
                        if (!(th instanceof ThreadDeath)) {
                            if (th instanceof LinkageError) {
                                throw ((LinkageError) th);
                            }
                            return;
                        }
                        throw ((ThreadDeath) th);
                    }
                    throw ((VirtualMachineError) th);
                }
                throw ((OnCompletedFailedException) th);
            }
            throw ((OnErrorFailedException) th);
        }
        throw ((OnErrorNotImplementedException) th);
    }

    /* renamed from: f */
    public static void m1473f(Throwable th, Observer<?> observer) {
        m1474e(th);
        observer.onError(th);
    }

    /* renamed from: g */
    public static void m1472g(Throwable th, Observer<?> observer, Object obj) {
        m1474e(th);
        observer.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
    }

    /* renamed from: h */
    public static void m1471h(Throwable th, SingleSubscriber<?> singleSubscriber) {
        m1474e(th);
        singleSubscriber.onError(th);
    }

    /* renamed from: i */
    public static void m1470i(Throwable th, SingleSubscriber<?> singleSubscriber, Object obj) {
        m1474e(th);
        singleSubscriber.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
    }
}
