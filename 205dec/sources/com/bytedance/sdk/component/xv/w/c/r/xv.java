package com.bytedance.sdk.component.xv.w.c.r;

import com.acse.ottn.f3;
import com.bytedance.sdk.component.xv.w.ls;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends ux {

    /* renamed from: c  reason: collision with root package name */
    private final Method f30799c;
    private final Class<?> sr;
    private final Class<?> ux;

    /* renamed from: w  reason: collision with root package name */
    private final Method f30800w;
    private final Method xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class c implements InvocationHandler {

        /* renamed from: c  reason: collision with root package name */
        boolean f30801c;

        /* renamed from: w  reason: collision with root package name */
        String f30802w;
        private final List<String> xv;

        c(List<String> list) {
            this.xv = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = com.bytedance.sdk.component.xv.w.c.xv.f30947w;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f30801c = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.xv;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        if (this.xv.contains(list.get(i4))) {
                            String str = (String) list.get(i4);
                            this.f30802w = str;
                            return str;
                        }
                    }
                    String str2 = this.xv.get(0);
                    this.f30802w = str2;
                    return str2;
                } else if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                    this.f30802w = (String) objArr[0];
                    return null;
                } else {
                    return method.invoke(this, objArr);
                }
            }
        }
    }

    xv(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f30799c = method;
        this.f30800w = method2;
        this.xv = method3;
        this.sr = cls;
        this.ux = cls2;
    }

    @Override // com.bytedance.sdk.component.xv.w.c.r.ux
    public void c(SSLSocket sSLSocket, String str, List<ls> list) {
        try {
            this.f30799c.invoke(null, sSLSocket, Proxy.newProxyInstance(ux.class.getClassLoader(), new Class[]{this.sr, this.ux}, new c(ux.c(list))));
        } catch (IllegalAccessException | InvocationTargetException e4) {
            throw com.bytedance.sdk.component.xv.w.c.xv.c("unable to set alpn", (Exception) e4);
        }
    }

    @Override // com.bytedance.sdk.component.xv.w.c.r.ux
    public void w(SSLSocket sSLSocket) {
        try {
            this.xv.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e4) {
            throw com.bytedance.sdk.component.xv.w.c.xv.c("unable to remove alpn", (Exception) e4);
        }
    }

    @Override // com.bytedance.sdk.component.xv.w.c.r.ux
    public String c(SSLSocket sSLSocket) {
        try {
            c cVar = (c) Proxy.getInvocationHandler(this.f30800w.invoke(null, sSLSocket));
            boolean z3 = cVar.f30801c;
            if (!z3 && cVar.f30802w == null) {
                ux.w().c(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (z3) {
                return null;
            } else {
                return cVar.f30802w;
            }
        } catch (IllegalAccessException | InvocationTargetException e4) {
            throw com.bytedance.sdk.component.xv.w.c.xv.c("unable to get selected protocol", (Exception) e4);
        }
    }

    public static ux c() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider");
            return new xv(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod(f3.f5657f, SSLSocket.class), cls.getMethod("remove", SSLSocket.class), cls3, Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }
}
