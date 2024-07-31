package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p047s.C2033cf;
import com.amap.api.col.p047s.MessageHandler;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.amap.api.col.s.q0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class PoiSearchCore implements IPoiSearch {

    /* renamed from: j */
    private static HashMap<Integer, PoiResult> f6386j;

    /* renamed from: a */
    private PoiSearch.SearchBound f6387a;

    /* renamed from: b */
    private PoiSearch.Query f6388b;

    /* renamed from: c */
    private Context f6389c;

    /* renamed from: d */
    private PoiSearch.OnPoiSearchListener f6390d;

    /* renamed from: e */
    private String f6391e = "zh-CN";

    /* renamed from: f */
    private PoiSearch.Query f6392f;

    /* renamed from: g */
    private PoiSearch.SearchBound f6393g;

    /* renamed from: h */
    private int f6394h;

    /* renamed from: i */
    private Handler f6395i;

    /* compiled from: PoiSearchCore.java */
    /* renamed from: com.amap.api.col.s.q0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2118a implements Runnable {
        RunnableC2118a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageHandler.C2175j c2175j;
            Message obtainMessage = PoiSearchCore.this.f6395i.obtainMessage();
            obtainMessage.arg1 = 6;
            obtainMessage.what = 600;
            Bundle bundle = new Bundle();
            PoiResult poiResult = null;
            try {
                try {
                    poiResult = PoiSearchCore.this.searchPOI();
                    bundle.putInt("errorCode", 1000);
                    c2175j = new MessageHandler.C2175j();
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                    c2175j = new MessageHandler.C2175j();
                }
                c2175j.f6577b = PoiSearchCore.this.f6390d;
                c2175j.f6576a = poiResult;
                obtainMessage.obj = c2175j;
                obtainMessage.setData(bundle);
                PoiSearchCore.this.f6395i.sendMessage(obtainMessage);
            } catch (Throwable th) {
                MessageHandler.C2175j c2175j2 = new MessageHandler.C2175j();
                c2175j2.f6577b = PoiSearchCore.this.f6390d;
                c2175j2.f6576a = poiResult;
                obtainMessage.obj = c2175j2;
                obtainMessage.setData(bundle);
                PoiSearchCore.this.f6395i.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    /* compiled from: PoiSearchCore.java */
    /* renamed from: com.amap.api.col.s.q0$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2119b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f6397a;

        RunnableC2119b(String str) {
            this.f6397a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageHandler.C2173h c2173h;
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.arg1 = 6;
            obtainMessage.what = 602;
            Bundle bundle = new Bundle();
            PoiItem poiItem = null;
            try {
                try {
                    poiItem = PoiSearchCore.this.searchPOIId(this.f6397a);
                    bundle.putInt("errorCode", 1000);
                    c2173h = new MessageHandler.C2173h();
                } catch (AMapException e) {
                    C2082j4.m52825i(e, "PoiSearch", "searchPOIIdAsyn");
                    bundle.putInt("errorCode", e.getErrorCode());
                    c2173h = new MessageHandler.C2173h();
                }
                c2173h.f6573b = PoiSearchCore.this.f6390d;
                c2173h.f6572a = poiItem;
                obtainMessage.obj = c2173h;
                obtainMessage.setData(bundle);
                PoiSearchCore.this.f6395i.sendMessage(obtainMessage);
            } catch (Throwable th) {
                MessageHandler.C2173h c2173h2 = new MessageHandler.C2173h();
                c2173h2.f6573b = PoiSearchCore.this.f6390d;
                c2173h2.f6572a = poiItem;
                obtainMessage.obj = c2173h2;
                obtainMessage.setData(bundle);
                PoiSearchCore.this.f6395i.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    public PoiSearchCore(Context context, PoiSearch.Query query) throws AMapException {
        this.f6395i = null;
        C2066h1 m53127a = C2033cf.m53127a(context, C2077i4.m52895a(false));
        if (m53127a.f6148a == C2033cf.EnumC2036c.SuccessCode) {
            this.f6389c = StubApp.getOrigApplicationContext(context.getApplicationContext());
            setQuery(query);
            this.f6395i = MessageHandler.m52418a();
            return;
        }
        String str = m53127a.f6149b;
        throw new AMapException(str, 1, str, m53127a.f6148a.m53102a());
    }

    /* renamed from: b */
    private PoiResult m52660b(int i) {
        if (m52655g(i)) {
            return f6386j.get(Integer.valueOf(i));
        }
        throw new IllegalArgumentException("page out of range");
    }

    /* renamed from: c */
    private void m52659c(PoiResult poiResult) {
        int i;
        f6386j = new HashMap<>();
        PoiSearch.Query query = this.f6388b;
        if (query == null || poiResult == null || (i = this.f6394h) <= 0 || i <= query.getPageNum()) {
            return;
        }
        f6386j.put(Integer.valueOf(this.f6388b.getPageNum()), poiResult);
    }

    /* renamed from: d */
    private boolean m52658d() {
        PoiSearch.Query query = this.f6388b;
        if (query == null) {
            return false;
        }
        return (C2082j4.m52824j(query.getQueryString()) && C2082j4.m52824j(this.f6388b.getCategory())) ? false : true;
    }

    /* renamed from: f */
    private boolean m52656f() {
        PoiSearch.SearchBound bound = getBound();
        return bound != null && bound.getShape().equals("Bound");
    }

    /* renamed from: g */
    private boolean m52655g(int i) {
        return i <= this.f6394h && i >= 0;
    }

    /* renamed from: h */
    private boolean m52654h() {
        PoiSearch.SearchBound bound = getBound();
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

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiSearch.SearchBound getBound() {
        return this.f6387a;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final String getLanguage() {
        return this.f6391e;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiSearch.Query getQuery() {
        return this.f6388b;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiResult searchPOI() throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6389c);
            if (!m52656f() && !m52658d()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (m52654h()) {
                PoiSearch.Query query = this.f6388b;
                if (query != null) {
                    if ((!query.queryEquals(this.f6392f) && this.f6387a == null) || (!this.f6388b.queryEquals(this.f6392f) && !this.f6387a.equals(this.f6393g))) {
                        this.f6394h = 0;
                        this.f6392f = this.f6388b.m60115clone();
                        PoiSearch.SearchBound searchBound = this.f6387a;
                        if (searchBound != null) {
                            this.f6393g = searchBound.m60116clone();
                        }
                        HashMap<Integer, PoiResult> hashMap = f6386j;
                        if (hashMap != null) {
                            hashMap.clear();
                        }
                    }
                    PoiSearch.SearchBound searchBound2 = this.f6387a;
                    PoiSearch.SearchBound m60116clone = searchBound2 != null ? searchBound2.m60116clone() : null;
                    RequestConfig.m52687a().m52682f(this.f6388b.getQueryString());
                    this.f6388b.setPageNum(RequestConfig.m52687a().m52689B(this.f6388b.getPageNum()));
                    this.f6388b.setPageSize(RequestConfig.m52687a().m52688C(this.f6388b.getPageSize()));
                    if (this.f6394h == 0) {
                        PoiResult m53251O = new PoiSearchKeywordsHandler(this.f6389c, new QueryInternal(this.f6388b.m60115clone(), m60116clone)).m53251O();
                        m52659c(m53251O);
                        return m53251O;
                    }
                    PoiResult m52660b = m52660b(this.f6388b.getPageNum());
                    if (m52660b == null) {
                        PoiResult m53251O2 = new PoiSearchKeywordsHandler(this.f6389c, new QueryInternal(this.f6388b.m60115clone(), m60116clone)).m53251O();
                        f6386j.put(Integer.valueOf(this.f6388b.getPageNum()), m53251O2);
                        return m53251O2;
                    }
                    return m52660b;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C2082j4.m52825i(e, "PoiSearch", "searchPOI");
            throw new AMapException(e.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIAsyn() {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2118a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiItem searchPOIId(String str) throws AMapException {
        ManifestConfig.m52460d(this.f6389c);
        PoiSearch.Query query = this.f6388b;
        return new PoiSearchIdHandler(this.f6389c, str, query != null ? query.m60115clone() : null).m53251O();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIIdAsyn(String str) {
        ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2119b(str));
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setBound(PoiSearch.SearchBound searchBound) {
        this.f6387a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setLanguage(String str) {
        if ("en".equals(str)) {
            this.f6391e = "en";
        } else {
            this.f6391e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setOnPoiSearchListener(PoiSearch.OnPoiSearchListener onPoiSearchListener) {
        this.f6390d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setQuery(PoiSearch.Query query) {
        this.f6388b = query;
    }
}
