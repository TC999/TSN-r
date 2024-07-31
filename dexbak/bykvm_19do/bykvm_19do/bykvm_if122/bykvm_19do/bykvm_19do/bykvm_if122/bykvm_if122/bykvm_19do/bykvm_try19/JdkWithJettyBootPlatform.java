package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Protocol;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class JdkWithJettyBootPlatform extends Platform {

    /* renamed from: c */
    private final Method f1220c;

    /* renamed from: d */
    private final Method f1221d;

    /* renamed from: e */
    private final Method f1222e;

    /* renamed from: f */
    private final Class<?> f1223f;

    /* renamed from: g */
    private final Class<?> f1224g;

    /* compiled from: JdkWithJettyBootPlatform.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.c$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private static class C1060a implements InvocationHandler {

        /* renamed from: a */
        private final List<String> f1225a;

        /* renamed from: b */
        boolean f1226b;

        /* renamed from: c */
        String f1227c;

        C1060a(List<String> list) {
            this.f1225a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = C1061c.f1234b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f1226b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f1225a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f1225a.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.f1227c = str;
                            return str;
                        }
                    }
                    String str2 = this.f1225a.get(0);
                    this.f1227c = str2;
                    return str2;
                } else if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                    this.f1227c = (String) objArr[0];
                    return null;
                } else {
                    return method.invoke(this, objArr);
                }
            }
        }
    }

    JdkWithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f1220c = method;
        this.f1221d = method2;
        this.f1222e = method3;
        this.f1223f = cls;
        this.f1224g = cls2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.Platform
    /* renamed from: a */
    public void mo58487a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            this.f1220c.invoke(null, sSLSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.f1223f, this.f1224g}, new C1060a(Platform.m58489a(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C1061c.m58466a("unable to set alpn", (Exception) e);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.Platform
    /* renamed from: b */
    public String mo58482b(SSLSocket sSLSocket) {
        try {
            C1060a c1060a = (C1060a) Proxy.getInvocationHandler(this.f1221d.invoke(null, sSLSocket));
            boolean z = c1060a.f1226b;
            if (!z && c1060a.f1227c == null) {
                Platform.m58485b().mo58493a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (z) {
                return null;
            } else {
                return c1060a.f1227c;
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C1061c.m58466a("unable to get selected protocol", (Exception) e);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.Platform
    /* renamed from: a */
    public void mo58488a(SSLSocket sSLSocket) {
        try {
            this.f1222e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C1061c.m58466a("unable to remove alpn", (Exception) e);
        }
    }

    /* renamed from: a */
    public static Platform m58502a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider");
            return new JdkWithJettyBootPlatform(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), cls3, Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }
}
