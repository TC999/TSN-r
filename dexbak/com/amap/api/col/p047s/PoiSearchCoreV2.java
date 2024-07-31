package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p047s.C2033cf;
import com.amap.api.col.p047s.MessageHandler;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.interfaces.IPoiSearchV2;
import com.amap.api.services.poisearch.PoiResultV2;
import com.amap.api.services.poisearch.PoiSearchV2;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.amap.api.col.s.r0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class PoiSearchCoreV2 implements IPoiSearchV2 {

    /* renamed from: j */
    private static HashMap<Integer, PoiResultV2> f6405j;

    /* renamed from: a */
    private PoiSearchV2.SearchBound f6406a;

    /* renamed from: b */
    private PoiSearchV2.Query f6407b;

    /* renamed from: c */
    private Context f6408c;

    /* renamed from: d */
    private PoiSearchV2.OnPoiSearchListener f6409d;

    /* renamed from: e */
    private String f6410e = "zh-CN";

    /* renamed from: f */
    private PoiSearchV2.Query f6411f;

    /* renamed from: g */
    private PoiSearchV2.SearchBound f6412g;

    /* renamed from: h */
    private int f6413h;

    /* renamed from: i */
    private Handler f6414i;

    /* compiled from: PoiSearchCoreV2.java */
    /* renamed from: com.amap.api.col.s.r0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2126a implements Runnable {
        RunnableC2126a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageHandler.C2176k c2176k;
            Message obtainMessage = PoiSearchCoreV2.this.f6414i.obtainMessage();
            obtainMessage.arg1 = 19;
            obtainMessage.what = 603;
            Bundle bundle = new Bundle();
            PoiResultV2 poiResultV2 = null;
            try {
                try {
                    poiResultV2 = PoiSearchCoreV2.this.searchPOI();
                    bundle.putInt("errorCode", 1000);
                    c2176k = new MessageHandler.C2176k();
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                    c2176k = new MessageHandler.C2176k();
                }
                c2176k.f6579b = PoiSearchCoreV2.this.f6409d;
                c2176k.f6578a = poiResultV2;
                obtainMessage.obj = c2176k;
                obtainMessage.setData(bundle);
                PoiSearchCoreV2.this.f6414i.sendMessage(obtainMessage);
            } catch (Throwable th) {
                MessageHandler.C2176k c2176k2 = new MessageHandler.C2176k();
                c2176k2.f6579b = PoiSearchCoreV2.this.f6409d;
                c2176k2.f6578a = poiResultV2;
                obtainMessage.obj = c2176k2;
                obtainMessage.setData(bundle);
                PoiSearchCoreV2.this.f6414i.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    /* compiled from: PoiSearchCoreV2.java */
    /* renamed from: com.amap.api.col.s.r0$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2127b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f6416a;

        RunnableC2127b(String str) {
            this.f6416a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageHandler.C2174i c2174i;
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.arg1 = 19;
            obtainMessage.what = 604;
            Bundle bundle = new Bundle();
            PoiItemV2 poiItemV2 = null;
            try {
                try {
                    poiItemV2 = PoiSearchCoreV2.this.searchPOIId(this.f6416a);
                    bundle.putInt("errorCode", 1000);
                    c2174i = new MessageHandler.C2174i();
                } catch (AMapException e) {
                    C2082j4.m52825i(e, "PoiSearch", "searchPOIIdAsyn");
                    bundle.putInt("errorCode", e.getErrorCode());
                    c2174i = new MessageHandler.C2174i();
                }
                c2174i.f6575b = PoiSearchCoreV2.this.f6409d;
                c2174i.f6574a = poiItemV2;
                obtainMessage.obj = c2174i;
                obtainMessage.setData(bundle);
                PoiSearchCoreV2.this.f6414i.sendMessage(obtainMessage);
            } catch (Throwable th) {
                MessageHandler.C2174i c2174i2 = new MessageHandler.C2174i();
                c2174i2.f6575b = PoiSearchCoreV2.this.f6409d;
                c2174i2.f6574a = poiItemV2;
                obtainMessage.obj = c2174i2;
                obtainMessage.setData(bundle);
                PoiSearchCoreV2.this.f6414i.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    public PoiSearchCoreV2(Context context, PoiSearchV2.Query query) throws AMapException {
        this.f6414i = null;
        C2066h1 m53127a = C2033cf.m53127a(context, C2077i4.m52895a(false));
        if (m53127a.f6148a == C2033cf.EnumC2036c.SuccessCode) {
            this.f6408c = StubApp.getOrigApplicationContext(context.getApplicationContext());
            setQuery(query);
            this.f6414i = MessageHandler.m52418a();
            return;
        }
        String str = m53127a.f6149b;
        throw new AMapException(str, 1, str, m53127a.f6148a.m53102a());
    }

    /* renamed from: b */
    private PoiResultV2 m52637b(int i) {
        if (m52632g(i)) {
            return f6405j.get(Integer.valueOf(i));
        }
        throw new IllegalArgumentException("page out of range");
    }

    /* renamed from: c */
    private void m52636c(PoiResultV2 poiResultV2) {
        int i;
        f6405j = new HashMap<>();
        PoiSearchV2.Query query = this.f6407b;
        if (query == null || poiResultV2 == null || (i = this.f6413h) <= 0 || i <= query.getPageNum()) {
            return;
        }
        f6405j.put(Integer.valueOf(this.f6407b.getPageNum()), poiResultV2);
    }

    /* renamed from: d */
    private boolean m52635d() {
        PoiSearchV2.Query query = this.f6407b;
        if (query == null) {
            return false;
        }
        return (C2082j4.m52824j(query.getQueryString()) && C2082j4.m52824j(this.f6407b.getCategory())) ? false : true;
    }

    /* renamed from: f */
    private boolean m52633f() {
        PoiSearchV2.SearchBound bound = getBound();
        return bound != null && bound.getShape().equals("Bound");
    }

    /* renamed from: g */
    private boolean m52632g(int i) {
        return i <= this.f6413h && i >= 0;
    }

    /* renamed from: h */
    private boolean m52631h() {
        PoiSearchV2.SearchBound bound = getBound();
        if (bound != null) {
            if (bound.getShape().equals("Bound")) {
                return bound.getCenter() != null;
            } else if (bound.getShape().equals("Polygon")) {
                List<LatLonPoint> polyGonList = bound.getPolyGonList();
                if (polyGonList == null || polyGonList.size() == 0) {
                    return false;
                }
                for (int i = 0; i < polyGonList.size(); i++) {
                    if (polyGonList.get(i) == null) {
                        return false;
                    }
                }
                return true;
            } else if (bound.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = bound.getLowerLeft();
                LatLonPoint upperRight = bound.getUpperRight();
                return lowerLeft != null && upperRight != null && lowerLeft.getLatitude() < upperRight.getLatitude() && lowerLeft.getLongitude() < upperRight.getLongitude();
            } else {
                return true;
            }
        }
        return true;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiSearchV2.SearchBound getBound() {
        return this.f6406a;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final String getLanguage() {
        return this.f6410e;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiSearchV2.Query getQuery() {
        return this.f6407b;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiResultV2 searchPOI() throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6408c);
            if (!m52633f() && !m52635d()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (m52631h()) {
                PoiSearchV2.Query query = this.f6407b;
                if (query != null) {
                    if ((!query.queryEquals(this.f6411f) && this.f6406a == null) || (!this.f6407b.queryEquals(this.f6411f) && !this.f6406a.equals(this.f6412g))) {
                        this.f6413h = 0;
                        this.f6411f = this.f6407b.m60117clone();
                        PoiSearchV2.SearchBound searchBound = this.f6406a;
                        if (searchBound != null) {
                            this.f6412g = searchBound.m60118clone();
                        }
                        HashMap<Integer, PoiResultV2> hashMap = f6405j;
                        if (hashMap != null) {
                            hashMap.clear();
                        }
                    }
                    PoiSearchV2.SearchBound searchBound2 = this.f6406a;
                    PoiSearchV2.SearchBound m60118clone = searchBound2 != null ? searchBound2.m60118clone() : null;
                    RequestConfig.m52687a().m52682f(this.f6407b.getQueryString());
                    this.f6407b.setPageNum(RequestConfig.m52687a().m52689B(this.f6407b.getPageNum()));
                    this.f6407b.setPageSize(RequestConfig.m52687a().m52688C(this.f6407b.getPageSize()));
                    if (this.f6413h == 0) {
                        PoiResultV2 m53251O = new PoiSearchKeywordsHandlerV2(this.f6408c, new QueryInternalV2(this.f6407b.m60117clone(), m60118clone)).m53251O();
                        m52636c(m53251O);
                        return m53251O;
                    }
                    PoiResultV2 m52637b = m52637b(this.f6407b.getPageNum());
                    if (m52637b == null) {
                        PoiResultV2 m53251O2 = new PoiSearchKeywordsHandlerV2(this.f6408c, new QueryInternalV2(this.f6407b.m60117clone(), m60118clone)).m53251O();
                        f6405j.put(Integer.valueOf(this.f6407b.getPageNum()), m53251O2);
                        return m53251O2;
                    }
                    return m52637b;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C2082j4.m52825i(e, "PoiSearch", "searchPOI");
            throw new AMapException(e.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void searchPOIAsyn() {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2126a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiItemV2 searchPOIId(String str) throws AMapException {
        ManifestConfig.m52460d(this.f6408c);
        PoiSearchV2.Query query = this.f6407b;
        return new PoiSearchIdHandlerV2(this.f6408c, str, query != null ? query.m60117clone() : null).m53251O();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void searchPOIIdAsyn(String str) {
        ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2127b(str));
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setBound(PoiSearchV2.SearchBound searchBound) {
        this.f6406a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setLanguage(String str) {
        if ("en".equals(str)) {
            this.f6410e = "en";
        } else {
            this.f6410e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setOnPoiSearchListener(PoiSearchV2.OnPoiSearchListener onPoiSearchListener) {
        this.f6409d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setQuery(PoiSearchV2.Query query) {
        this.f6407b = query;
    }
}
