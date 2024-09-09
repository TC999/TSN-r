package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.w;
import com.acse.ottn.f3;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JdkWithJettyBootPlatform.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class c extends e {

    /* renamed from: c  reason: collision with root package name */
    private final Method f1213c;

    /* renamed from: d  reason: collision with root package name */
    private final Method f1214d;

    /* renamed from: e  reason: collision with root package name */
    private final Method f1215e;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f1216f;

    /* renamed from: g  reason: collision with root package name */
    private final Class<?> f1217g;

    /* compiled from: JdkWithJettyBootPlatform.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f1218a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1219b;

        /* renamed from: c  reason: collision with root package name */
        String f1220c;

        a(List<String> list) {
            this.f1218a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1227b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f1219b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f1218a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        if (this.f1218a.contains(list.get(i4))) {
                            String str = (String) list.get(i4);
                            this.f1220c = str;
                            return str;
                        }
                    }
                    String str2 = this.f1218a.get(0);
                    this.f1220c = str2;
                    return str2;
                } else if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                    this.f1220c = (String) objArr[0];
                    return null;
                } else {
                    return method.invoke(this, objArr);
                }
            }
        }
    }

    c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f1213c = method;
        this.f1214d = method2;
        this.f1215e = method3;
        this.f1216f = cls;
        this.f1217g = cls2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        try {
            this.f1213c.invoke(null, sSLSocket, Proxy.newProxyInstance(e.class.getClassLoader(), new Class[]{this.f1216f, this.f1217g}, new a(e.a(list))));
        } catch (IllegalAccessException | InvocationTargetException e4) {
            throw bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("unable to set alpn", (Exception) e4);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e
    public String b(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f1214d.invoke(null, sSLSocket));
            boolean z3 = aVar.f1219b;
            if (!z3 && aVar.f1220c == null) {
                e.b().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (z3) {
                return null;
            } else {
                return aVar.f1220c;
            }
        } catch (IllegalAccessException | InvocationTargetException e4) {
            throw bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("unable to get selected protocol", (Exception) e4);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e
    public void a(SSLSocket sSLSocket) {
        try {
            this.f1215e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e4) {
            throw bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("unable to remove alpn", (Exception) e4);
        }
    }

    public static e a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider");
            return new c(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod(f3.f5657f, SSLSocket.class), cls.getMethod("remove", SSLSocket.class), cls3, Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }
}
