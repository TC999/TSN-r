package com.amap.api.col.p0003l;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AbstractBasicHandler.java */
/* renamed from: com.amap.api.col.3l.x3  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class x3<T, V> extends f2 {

    /* renamed from: i  reason: collision with root package name */
    protected T f9402i;

    /* renamed from: k  reason: collision with root package name */
    protected Context f9404k;

    /* renamed from: p  reason: collision with root package name */
    protected String f9405p;

    /* renamed from: j  reason: collision with root package name */
    protected int f9403j = 1;

    /* renamed from: q  reason: collision with root package name */
    protected boolean f9406q = false;

    public x3(Context context, T t3) {
        g(context, t3);
    }

    private void g(Context context, T t3) {
        this.f9404k = context;
        this.f9402i = t3;
        this.f9403j = 1;
        setSoTimeout(30000);
        setConnectionTimeout(30000);
    }

    private V h(y6 y6Var) throws fc {
        return c(y6Var);
    }

    private V i(byte[] bArr) throws fc {
        return f(bArr);
    }

    private V o() throws fc {
        V v3 = null;
        int i4 = 0;
        while (i4 < this.f9403j) {
            try {
                setProxy(o4.c(this.f9404k));
                if (this.f9406q) {
                    v3 = h(makeHttpRequestNeedHeader());
                } else {
                    v3 = i(makeHttpRequest());
                }
                i4 = this.f9403j;
            } catch (fc e4) {
                i4++;
                if (i4 >= this.f9403j) {
                    throw new fc(e4.a());
                }
            } catch (fk e5) {
                i4++;
                if (i4 < this.f9403j) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException unused) {
                        if (!"http\u8fde\u63a5\u5931\u8d25 - ConnectionException".equals(e5.getMessage()) && !"socket \u8fde\u63a5\u5f02\u5e38 - SocketException".equals(e5.getMessage()) && !"\u670d\u52a1\u5668\u8fde\u63a5\u5931\u8d25 - UnknownServiceException".equals(e5.getMessage())) {
                            throw new fc(e5.a());
                        }
                        throw new fc("http\u6216socket\u8fde\u63a5\u5931\u8d25 - ConnectionException");
                    }
                } else if (!"http\u8fde\u63a5\u5931\u8d25 - ConnectionException".equals(e5.getMessage()) && !"socket \u8fde\u63a5\u5f02\u5e38 - SocketException".equals(e5.getMessage()) && !"\u672a\u77e5\u7684\u9519\u8bef".equals(e5.a()) && !"\u670d\u52a1\u5668\u8fde\u63a5\u5931\u8d25 - UnknownServiceException".equals(e5.getMessage())) {
                    throw new fc(e5.a());
                } else {
                    throw new fc("http\u6216socket\u8fde\u63a5\u5931\u8d25 - ConnectionException");
                }
            }
        }
        return v3;
    }

    protected V c(y6 y6Var) throws fc {
        return null;
    }

    protected abstract V e(String str) throws fc;

    protected V f(byte[] bArr) throws fc {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e4) {
            e4.printStackTrace();
            str = null;
        }
        if (str == null || "".equals(str)) {
            return null;
        }
        z3.c(str);
        return e(str);
    }

    @Override // com.amap.api.col.p0003l.Cif
    public Map<String, String> getRequestHead() {
        p4 s3 = a3.s();
        String e4 = s3 != null ? s3.e() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", fa.f7732c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", e4, "3dmap"));
        hashtable.put("X-INFO", h4.i(this.f9404k));
        hashtable.put(DomainCampaignEx.LOOPBACK_KEY, e4.j(this.f9404k));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    protected abstract String m();

    public final V n() throws fc {
        if (this.f9402i != null) {
            try {
                return o();
            } catch (fc e4) {
                a3.D(e4);
                throw e4;
            }
        }
        return null;
    }
}
