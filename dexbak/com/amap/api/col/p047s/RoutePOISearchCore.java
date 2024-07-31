package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p047s.C2033cf;
import com.amap.api.col.p047s.MessageHandler;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;

/* renamed from: com.amap.api.col.s.s0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class RoutePOISearchCore implements IRoutePOISearch {

    /* renamed from: a */
    private RoutePOISearchQuery f6461a;

    /* renamed from: b */
    private Context f6462b;

    /* renamed from: c */
    private RoutePOISearch.OnRoutePOISearchListener f6463c;

    /* renamed from: d */
    private Handler f6464d;

    /* compiled from: RoutePOISearchCore.java */
    /* renamed from: com.amap.api.col.s.s0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2138a implements Runnable {
        RunnableC2138a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageHandler.C2178m c2178m;
            Message obtainMessage = RoutePOISearchCore.this.f6464d.obtainMessage();
            obtainMessage.arg1 = 14;
            Bundle bundle = new Bundle();
            RoutePOISearchResult routePOISearchResult = null;
            try {
                try {
                    routePOISearchResult = RoutePOISearchCore.this.searchRoutePOI();
                    bundle.putInt("errorCode", 1000);
                    c2178m = new MessageHandler.C2178m();
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                    c2178m = new MessageHandler.C2178m();
                }
                c2178m.f6583b = RoutePOISearchCore.this.f6463c;
                c2178m.f6582a = routePOISearchResult;
                obtainMessage.obj = c2178m;
                obtainMessage.setData(bundle);
                RoutePOISearchCore.this.f6464d.sendMessage(obtainMessage);
            } catch (Throwable th) {
                MessageHandler.C2178m c2178m2 = new MessageHandler.C2178m();
                c2178m2.f6583b = RoutePOISearchCore.this.f6463c;
                c2178m2.f6582a = routePOISearchResult;
                obtainMessage.obj = c2178m2;
                obtainMessage.setData(bundle);
                RoutePOISearchCore.this.f6464d.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    public RoutePOISearchCore(Context context, RoutePOISearchQuery routePOISearchQuery) throws AMapException {
        this.f6464d = null;
        C2066h1 m53127a = C2033cf.m53127a(context, C2077i4.m52895a(false));
        if (m53127a.f6148a == C2033cf.EnumC2036c.SuccessCode) {
            this.f6462b = context;
            this.f6461a = routePOISearchQuery;
            this.f6464d = MessageHandler.m52418a();
            return;
        }
        String str = m53127a.f6149b;
        throw new AMapException(str, 1, str, m53127a.f6148a.m53102a());
    }

    /* renamed from: b */
    private boolean m52472b() {
        RoutePOISearchQuery routePOISearchQuery = this.f6461a;
        if (routePOISearchQuery == null || routePOISearchQuery.getSearchType() == null) {
            return false;
        }
        return (this.f6461a.getFrom() == null && this.f6461a.getTo() == null && this.f6461a.getPolylines() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final RoutePOISearchQuery getQuery() {
        return this.f6461a;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final RoutePOISearchResult searchRoutePOI() throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6462b);
            if (m52472b()) {
                return new RoutePOISearchHandler(this.f6462b, this.f6461a.m60132clone()).m53251O();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C2082j4.m52825i(e, "RoutePOISearchCore", "searchRoutePOI");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void searchRoutePOIAsyn() {
        ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2138a());
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void setQuery(RoutePOISearchQuery routePOISearchQuery) {
        this.f6461a = routePOISearchQuery;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void setRoutePOISearchListener(RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener) {
        this.f6463c = onRoutePOISearchListener;
    }
}
