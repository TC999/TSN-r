package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class RouteException extends RuntimeException {

    /* renamed from: b */
    private static final Method f979b;

    /* renamed from: a */
    private IOException f980a;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            method = null;
        }
        f979b = method;
    }

    public RouteException(IOException iOException) {
        super(iOException);
        this.f980a = iOException;
    }

    /* renamed from: a */
    public IOException m58718a() {
        return this.f980a;
    }

    /* renamed from: a */
    public void m58717a(IOException iOException) {
        m58716a(iOException, this.f980a);
        this.f980a = iOException;
    }

    /* renamed from: a */
    private void m58716a(IOException iOException, IOException iOException2) {
        Method method = f979b;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
