package com.amap.api.col.p0463l;

import android.content.Context;
import com.amap.api.maps.AMapException;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.x3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AbstractBasicHandler<T, V> extends AbstractAMapRequest {

    /* renamed from: i */
    protected T f5671i;

    /* renamed from: k */
    protected Context f5673k;

    /* renamed from: p */
    protected String f5674p;

    /* renamed from: j */
    protected int f5672j = 1;

    /* renamed from: q */
    protected boolean f5675q = false;

    public AbstractBasicHandler(Context context, T t) {
        m53537g(context, t);
    }

    /* renamed from: g */
    private void m53537g(Context context, T t) {
        this.f5673k = context;
        this.f5671i = t;
        this.f5672j = 1;
        setSoTimeout(30000);
        setConnectionTimeout(30000);
    }

    /* renamed from: h */
    private V m53536h(ResponseEntity responseEntity) throws AMapException {
        return mo53539c(responseEntity);
    }

    /* renamed from: i */
    private V m53535i(byte[] bArr) throws AMapException {
        return mo53538f(bArr);
    }

    /* renamed from: o */
    private V m53533o() throws AMapException {
        V v = null;
        int i = 0;
        while (i < this.f5672j) {
            try {
                setProxy(ProxyUtil.m54440c(this.f5673k));
                if (this.f5675q) {
                    v = m53536h(makeHttpRequestNeedHeader());
                } else {
                    v = m53535i(makeHttpRequest());
                }
                i = this.f5672j;
            } catch (AMapException e) {
                i++;
                if (i >= this.f5672j) {
                    throw new AMapException(e.m55010a());
                }
            } catch (AMapCoreException e2) {
                i++;
                if (i < this.f5672j) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException unused) {
                        if (!AMapException.ERROR_CONNECTION.equals(e2.getMessage()) && !AMapException.ERROR_SOCKET.equals(e2.getMessage()) && !AMapException.ERROR_UNKNOW_SERVICE.equals(e2.getMessage())) {
                            throw new AMapException(e2.m55008a());
                        }
                        throw new AMapException(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
                    }
                } else if (!AMapException.ERROR_CONNECTION.equals(e2.getMessage()) && !AMapException.ERROR_SOCKET.equals(e2.getMessage()) && !AMapException.ERROR_UNKNOWN.equals(e2.m55008a()) && !AMapException.ERROR_UNKNOW_SERVICE.equals(e2.getMessage())) {
                    throw new AMapException(e2.m55008a());
                } else {
                    throw new AMapException(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
                }
            }
        }
        return v;
    }

    /* renamed from: c */
    protected V mo53539c(ResponseEntity responseEntity) throws AMapException {
        return null;
    }

    /* renamed from: e */
    protected abstract V mo53402e(String str) throws AMapException;

    /* renamed from: f */
    protected V mo53538f(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        if (str == null || "".equals(str)) {
            return null;
        }
        CoreUtil.m53333c(str);
        return mo53402e(str);
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public Map<String, String> getRequestHead() {
        SDKInfo m55691s = C1732a3.m55691s();
        String m54396e = m55691s != null ? m55691s.m54396e() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", ConfigableConst.f3943c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", m54396e, "3dmap"));
        hashtable.put("X-INFO", ClientInfo.m54925i(this.f5673k));
        hashtable.put(DomainCampaignEx.LOOPBACK_KEY, C1780e4.m55240j(this.f5673k));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    /* renamed from: m */
    protected abstract String mo53401m();

    /* renamed from: n */
    public final V m53534n() throws AMapException {
        if (this.f5671i != null) {
            try {
                return m53533o();
            } catch (AMapException e) {
                C1732a3.m55741D(e);
                throw e;
            }
        }
        return null;
    }
}
