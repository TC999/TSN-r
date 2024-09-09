package com.bytedance.sdk.component.xv.w.c.w;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class ux extends RuntimeException {

    /* renamed from: c  reason: collision with root package name */
    private static final Method f30928c;

    /* renamed from: w  reason: collision with root package name */
    private IOException f30929w;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            method = null;
        }
        f30928c = method;
    }

    public ux(IOException iOException) {
        super(iOException);
        this.f30929w = iOException;
    }

    public IOException c() {
        return this.f30929w;
    }

    public void c(IOException iOException) {
        c(iOException, this.f30929w);
        this.f30929w = iOException;
    }

    private void c(IOException iOException, IOException iOException2) {
        Method method = f30928c;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
