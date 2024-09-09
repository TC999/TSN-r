package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: RouteException.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class e extends RuntimeException {

    /* renamed from: b  reason: collision with root package name */
    private static final Method f972b;

    /* renamed from: a  reason: collision with root package name */
    private IOException f973a;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            method = null;
        }
        f972b = method;
    }

    public e(IOException iOException) {
        super(iOException);
        this.f973a = iOException;
    }

    public IOException a() {
        return this.f973a;
    }

    public void a(IOException iOException) {
        a(iOException, this.f973a);
        this.f973a = iOException;
    }

    private void a(IOException iOException, IOException iOException2) {
        Method method = f972b;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
