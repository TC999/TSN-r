package rx.exceptions;

import java.util.HashSet;
import java.util.List;
import rx.f;
import rx.k;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Exceptions.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f62220a = 25;

    private a() {
        throw new IllegalStateException("No instances!");
    }

    public static void a(Throwable th, Throwable th2) {
        HashSet hashSet = new HashSet();
        int i4 = 0;
        while (th.getCause() != null) {
            int i5 = i4 + 1;
            if (i4 >= 25) {
                return;
            }
            th = th.getCause();
            if (!hashSet.contains(th.getCause())) {
                hashSet.add(th.getCause());
                i4 = i5;
            }
        }
        try {
            th.initCause(th2);
        } catch (Throwable unused) {
        }
    }

    public static Throwable b(Throwable th) {
        int i4 = 0;
        while (th.getCause() != null) {
            int i5 = i4 + 1;
            if (i4 >= 25) {
                return new RuntimeException("Stack too deep to get final cause");
            }
            th = th.getCause();
            i4 = i5;
        }
        return th;
    }

    public static RuntimeException c(Throwable th) {
        if (!(th instanceof RuntimeException)) {
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
        throw ((RuntimeException) th);
    }

    public static void d(List<? extends Throwable> list) {
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

    public static void e(Throwable th) {
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

    public static void f(Throwable th, f<?> fVar) {
        e(th);
        fVar.onError(th);
    }

    public static void g(Throwable th, f<?> fVar, Object obj) {
        e(th);
        fVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
    }

    public static void h(Throwable th, k<?> kVar) {
        e(th);
        kVar.onError(th);
    }

    public static void i(Throwable th, k<?> kVar, Object obj) {
        e(th);
        kVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
    }
}
