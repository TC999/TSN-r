package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.col.p047s.AbstractC2044dz;
import com.amap.api.col.p047s.RequestCacheControl;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import java.util.Map;

/* renamed from: com.amap.api.col.s.a3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class BasicHandler<T, V> extends AbstractC2054f1 {

    /* renamed from: n */
    protected T f5880n;

    /* renamed from: q */
    protected Context f5883q;

    /* renamed from: m */
    protected boolean f5879m = true;

    /* renamed from: o */
    protected int f5881o = 1;

    /* renamed from: p */
    protected String f5882p = "";

    /* renamed from: r */
    private int f5884r = 1;

    /* renamed from: s */
    protected String f5885s = "";

    public BasicHandler(Context context, T t) {
        m53254K(context, t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: H */
    private V m53255H() throws AMapException {
        V v;
        RequestCacheControl requestCacheControl;
        RequestCacheControl.C2098c m52765a;
        Object obj;
        try {
            RequestCacheControl.C2097b mo52642P = mo52642P();
            boolean m52758h = RequestCacheControl.m52764b().m52758h(mo52642P);
            boolean z = false;
            int i = 0;
            V v2 = null;
            boolean z2 = false;
            while (i < this.f5881o) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    try {
                        try {
                            int protocol = ServiceSettings.getInstance().getProtocol();
                            C2048e1.m53039a().m53037c(this.f5883q);
                            C2227z2 m52174l = C2227z2.m52174l();
                            if (m52758h && (m52765a = RequestCacheControl.m52764b().m52765a(mo52642P)) != null && (obj = m52765a.f6302a) != 0) {
                                try {
                                    C2198x.m52337e(this.f5883q, mo52642P.f6300a, m52765a.f6303b);
                                    v2 = obj;
                                    z2 = true;
                                } catch (C2022bv e) {
                                    e = e;
                                    v2 = obj;
                                    z2 = true;
                                    C2198x.m52338d(this.f5883q, m53249R(), System.currentTimeMillis() - currentTimeMillis, z);
                                    i++;
                                    if (i < this.f5881o) {
                                        try {
                                            Thread.sleep(this.f5884r * 1000);
                                            if (m52758h && !z2) {
                                                RequestCacheControl.m52764b().m52761e(mo52642P, v2);
                                            }
                                            z = false;
                                        } catch (InterruptedException unused) {
                                            if (!com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_SOCKET.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(e.getMessage())) {
                                                throw new AMapException(e.m53217a(), 1, e.m53213c());
                                            }
                                            throw new AMapException(AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, e.m53213c());
                                        }
                                    } else {
                                        if (!com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_SOCKET.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_UNKNOWN.equals(e.m53217a()) && !com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(e.getMessage())) {
                                            throw new AMapException(e.m53217a(), 1, e.m53213c());
                                        }
                                        throw new AMapException(AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, e.m53213c());
                                    }
                                } catch (AMapException e2) {
                                    e = e2;
                                    v2 = obj;
                                    z2 = true;
                                    C2198x.m52338d(this.f5883q, m53249R(), System.currentTimeMillis() - currentTimeMillis, z);
                                    i++;
                                    if (i >= this.f5881o) {
                                        throw e;
                                    }
                                    if (m52758h && !z2) {
                                        requestCacheControl = RequestCacheControl.m52764b();
                                        requestCacheControl.m52761e(mo52642P, v2);
                                    }
                                    z = false;
                                } catch (Throwable th) {
                                    th = th;
                                    v = obj;
                                    z2 = true;
                                    if (m52758h) {
                                        RequestCacheControl.m52764b().m52761e(mo52642P, v);
                                    }
                                    throw th;
                                }
                            }
                            if (v2 == null) {
                                byte[] m53253L = m53253L(protocol, m52174l, this);
                                long currentTimeMillis2 = System.currentTimeMillis();
                                v2 = m53252N(m53253L);
                                C2198x.m52338d(this.f5883q, m53249R(), currentTimeMillis2 - currentTimeMillis, true);
                            }
                            i = this.f5881o;
                        } catch (C2022bv e3) {
                            e = e3;
                        } catch (AMapException e4) {
                            e = e4;
                        }
                        if (m52758h && !z2) {
                            requestCacheControl = RequestCacheControl.m52764b();
                            requestCacheControl.m52761e(mo52642P, v2);
                        }
                        z = false;
                    } catch (Throwable th2) {
                        th = th2;
                        v = v2;
                        if (m52758h && !z2) {
                            RequestCacheControl.m52764b().m52761e(mo52642P, v);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    v = null;
                }
            }
            return v2;
        } catch (AMapException e5) {
            throw e5;
        } catch (Throwable th4) {
            th4.printStackTrace();
            throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }

    /* renamed from: K */
    private void m53254K(Context context, T t) {
        this.f5883q = context;
        this.f5880n = t;
        this.f5881o = 1;
        m53059j(ServiceSettings.getInstance().getSoTimeOut());
        m53064d(ServiceSettings.getInstance().getConnectionTimeOut());
    }

    /* renamed from: L */
    private byte[] m53253L(int i, C2227z2 c2227z2, AbstractC2054f1 abstractC2054f1) throws C2022bv {
        C2021b3 m52172n;
        m53061g(i == 1 ? AbstractC2044dz.EnumC2047c.HTTP : AbstractC2044dz.EnumC2047c.HTTPS);
        if (this.f5879m) {
            m52172n = C2163u2.m52427d(abstractC2054f1);
        } else {
            m52172n = C2227z2.m52172n(abstractC2054f1);
        }
        if (m52172n != null) {
            byte[] bArr = m52172n.f5893a;
            this.f5885s = m52172n.f5896d;
            return bArr;
        }
        return null;
    }

    /* renamed from: N */
    private V m53252N(byte[] bArr) throws AMapException {
        return mo53006J(bArr);
    }

    /* renamed from: Q */
    private String m53250Q() {
        return this.f5885s;
    }

    /* renamed from: R */
    private String m53249R() {
        String mo52200a = mo52200a();
        if (mo52200a != null) {
            try {
                int indexOf = mo52200a.indexOf(".com/");
                int indexOf2 = mo52200a.indexOf("?");
                if (indexOf2 == -1) {
                    return mo52200a.substring(indexOf + 5);
                }
                return mo52200a.substring(indexOf + 5, indexOf2);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: I */
    protected abstract V mo52183I(String str) throws AMapException;

    /* renamed from: J */
    protected V mo53006J(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e) {
            C2082j4.m52825i(e, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        C2082j4.m52822l(str);
        return mo52183I(str);
    }

    /* renamed from: M */
    protected abstract String mo52182M();

    /* renamed from: O */
    public final V m53251O() throws AMapException {
        if (this.f5880n != null) {
            try {
                return m53255H();
            } catch (AMapException e) {
                C2198x.m52336f(m53249R(), m53250Q(), e);
                throw e;
            }
        }
        return null;
    }

    /* renamed from: P */
    protected RequestCacheControl.C2097b mo52642P() {
        return null;
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: m */
    public final String mo52630m() {
        return "sea";
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: o */
    public Map<String, String> mo52383o() {
        return null;
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: p */
    public Map<String, String> mo52199p() {
        return null;
    }
}
