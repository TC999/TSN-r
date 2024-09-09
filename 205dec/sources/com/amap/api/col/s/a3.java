package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.dz;
import com.amap.api.col.s.n;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BasicHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class a3<T, V> extends f1 {

    /* renamed from: n  reason: collision with root package name */
    protected T f9630n;

    /* renamed from: q  reason: collision with root package name */
    protected Context f9633q;

    /* renamed from: m  reason: collision with root package name */
    protected boolean f9629m = true;

    /* renamed from: o  reason: collision with root package name */
    protected int f9631o = 1;

    /* renamed from: p  reason: collision with root package name */
    protected String f9632p = "";

    /* renamed from: r  reason: collision with root package name */
    private int f9634r = 1;

    /* renamed from: s  reason: collision with root package name */
    protected String f9635s = "";

    public a3(Context context, T t3) {
        K(context, t3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V H() throws AMapException {
        V v3;
        n nVar;
        n.c a4;
        Object obj;
        try {
            n.b P = P();
            boolean h4 = n.b().h(P);
            boolean z3 = false;
            int i4 = 0;
            V v4 = null;
            boolean z4 = false;
            while (i4 < this.f9631o) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    try {
                        try {
                            int protocol = ServiceSettings.getInstance().getProtocol();
                            e1.a().c(this.f9633q);
                            z2 l4 = z2.l();
                            if (h4 && (a4 = n.b().a(P)) != null && (obj = a4.f10030a) != 0) {
                                try {
                                    x.e(this.f9633q, P.f10028a, a4.f10031b);
                                    v4 = obj;
                                    z4 = true;
                                } catch (bv e4) {
                                    e = e4;
                                    v4 = obj;
                                    z4 = true;
                                    x.d(this.f9633q, R(), System.currentTimeMillis() - currentTimeMillis, z3);
                                    i4++;
                                    if (i4 < this.f9631o) {
                                        try {
                                            Thread.sleep(this.f9634r * 1000);
                                            if (h4 && !z4) {
                                                n.b().e(P, v4);
                                            }
                                            z3 = false;
                                        } catch (InterruptedException unused) {
                                            if (!"http\u8fde\u63a5\u5931\u8d25 - ConnectionException".equals(e.getMessage()) && !"socket \u8fde\u63a5\u5f02\u5e38 - SocketException".equals(e.getMessage()) && !"\u670d\u52a1\u5668\u8fde\u63a5\u5931\u8d25 - UnknownServiceException".equals(e.getMessage())) {
                                                throw new AMapException(e.a(), 1, e.c());
                                            }
                                            throw new AMapException("http\u6216socket\u8fde\u63a5\u5931\u8d25 - ConnectionException", 1, e.c());
                                        }
                                    } else {
                                        if (!"http\u8fde\u63a5\u5931\u8d25 - ConnectionException".equals(e.getMessage()) && !"socket \u8fde\u63a5\u5f02\u5e38 - SocketException".equals(e.getMessage()) && !"\u672a\u77e5\u7684\u9519\u8bef".equals(e.a()) && !"\u670d\u52a1\u5668\u8fde\u63a5\u5931\u8d25 - UnknownServiceException".equals(e.getMessage())) {
                                            throw new AMapException(e.a(), 1, e.c());
                                        }
                                        throw new AMapException("http\u6216socket\u8fde\u63a5\u5931\u8d25 - ConnectionException", 1, e.c());
                                    }
                                } catch (AMapException e5) {
                                    e = e5;
                                    v4 = obj;
                                    z4 = true;
                                    x.d(this.f9633q, R(), System.currentTimeMillis() - currentTimeMillis, z3);
                                    i4++;
                                    if (i4 >= this.f9631o) {
                                        throw e;
                                    }
                                    if (h4 && !z4) {
                                        nVar = n.b();
                                        nVar.e(P, v4);
                                    }
                                    z3 = false;
                                } catch (Throwable th) {
                                    th = th;
                                    v3 = obj;
                                    z4 = true;
                                    if (h4) {
                                        n.b().e(P, v3);
                                    }
                                    throw th;
                                }
                            }
                            if (v4 == null) {
                                byte[] L2 = L(protocol, l4, this);
                                long currentTimeMillis2 = System.currentTimeMillis();
                                v4 = N(L2);
                                x.d(this.f9633q, R(), currentTimeMillis2 - currentTimeMillis, true);
                            }
                            i4 = this.f9631o;
                        } catch (bv e6) {
                            e = e6;
                        } catch (AMapException e7) {
                            e = e7;
                        }
                        if (h4 && !z4) {
                            nVar = n.b();
                            nVar.e(P, v4);
                        }
                        z3 = false;
                    } catch (Throwable th2) {
                        th = th2;
                        v3 = v4;
                        if (h4 && !z4) {
                            n.b().e(P, v3);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    v3 = null;
                }
            }
            return v4;
        } catch (AMapException e8) {
            throw e8;
        } catch (Throwable th4) {
            th4.printStackTrace();
            throw new AMapException("\u672a\u77e5\u9519\u8bef");
        }
    }

    private void K(Context context, T t3) {
        this.f9633q = context;
        this.f9630n = t3;
        this.f9631o = 1;
        j(ServiceSettings.getInstance().getSoTimeOut());
        d(ServiceSettings.getInstance().getConnectionTimeOut());
    }

    private byte[] L(int i4, z2 z2Var, f1 f1Var) throws bv {
        b3 n4;
        g(i4 == 1 ? dz.c.HTTP : dz.c.HTTPS);
        if (this.f9629m) {
            n4 = u2.d(f1Var);
        } else {
            n4 = z2.n(f1Var);
        }
        if (n4 != null) {
            byte[] bArr = n4.f9643a;
            this.f9635s = n4.f9646d;
            return bArr;
        }
        return null;
    }

    private V N(byte[] bArr) throws AMapException {
        return J(bArr);
    }

    private String Q() {
        return this.f9635s;
    }

    private String R() {
        String a4 = a();
        if (a4 != null) {
            try {
                int indexOf = a4.indexOf(".com/");
                int indexOf2 = a4.indexOf("?");
                if (indexOf2 == -1) {
                    return a4.substring(indexOf + 5);
                }
                return a4.substring(indexOf + 5, indexOf2);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    protected abstract V I(String str) throws AMapException;

    protected V J(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e4) {
            j4.i(e4, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        j4.l(str);
        return I(str);
    }

    protected abstract String M();

    public final V O() throws AMapException {
        if (this.f9630n != null) {
            try {
                return H();
            } catch (AMapException e4) {
                x.f(R(), Q(), e4);
                throw e4;
            }
        }
        return null;
    }

    protected n.b P() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public final String m() {
        return "sea";
    }

    @Override // com.amap.api.col.s.dz
    public Map<String, String> o() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public Map<String, String> p() {
        return null;
    }
}
