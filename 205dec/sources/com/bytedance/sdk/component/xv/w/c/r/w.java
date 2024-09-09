package com.bytedance.sdk.component.xv.w.c.r;

import com.bytedance.sdk.component.xv.w.ls;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class w extends ux {

    /* renamed from: c  reason: collision with root package name */
    final Method f30797c;

    /* renamed from: w  reason: collision with root package name */
    final Method f30798w;

    w(Method method, Method method2) {
        this.f30797c = method;
        this.f30798w = method2;
    }

    @Override // com.bytedance.sdk.component.xv.w.c.r.ux
    public void c(SSLSocket sSLSocket, String str, List<ls> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> c4 = ux.c(list);
            this.f30797c.invoke(sSLParameters, c4.toArray(new String[c4.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e4) {
            throw com.bytedance.sdk.component.xv.w.c.xv.c("unable to set ssl parameters", (Exception) e4);
        }
    }

    @Override // com.bytedance.sdk.component.xv.w.c.r.ux
    public String c(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f30798w.invoke(sSLSocket, new Object[0]);
            if (str != null) {
                if (str.equals("")) {
                    return null;
                }
                return str;
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException e4) {
            throw com.bytedance.sdk.component.xv.w.c.xv.c("unable to get selected protocols", (Exception) e4);
        }
    }

    public static w c() {
        try {
            return new w(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
