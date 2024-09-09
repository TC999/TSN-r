package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RoutePOISearchCore.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class s0 implements IRoutePOISearch {

    /* renamed from: a  reason: collision with root package name */
    private RoutePOISearchQuery f10189a;

    /* renamed from: b  reason: collision with root package name */
    private Context f10190b;

    /* renamed from: c  reason: collision with root package name */
    private RoutePOISearch.OnRoutePOISearchListener f10191c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f10192d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: RoutePOISearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            u4.m mVar;
            Message obtainMessage = s0.this.f10192d.obtainMessage();
            obtainMessage.arg1 = 14;
            Bundle bundle = new Bundle();
            RoutePOISearchResult routePOISearchResult = null;
            try {
                try {
                    routePOISearchResult = s0.this.searchRoutePOI();
                    bundle.putInt("errorCode", 1000);
                    mVar = new u4.m();
                } catch (AMapException e4) {
                    bundle.putInt("errorCode", e4.getErrorCode());
                    mVar = new u4.m();
                }
                mVar.f10311b = s0.this.f10191c;
                mVar.f10310a = routePOISearchResult;
                obtainMessage.obj = mVar;
                obtainMessage.setData(bundle);
                s0.this.f10192d.sendMessage(obtainMessage);
            } catch (Throwable th) {
                u4.m mVar2 = new u4.m();
                mVar2.f10311b = s0.this.f10191c;
                mVar2.f10310a = routePOISearchResult;
                obtainMessage.obj = mVar2;
                obtainMessage.setData(bundle);
                s0.this.f10192d.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    public s0(Context context, RoutePOISearchQuery routePOISearchQuery) throws AMapException {
        this.f10192d = null;
        h1 a4 = cf.a(context, i4.a(false));
        if (a4.f9876a == cf.c.SuccessCode) {
            this.f10190b = context;
            this.f10189a = routePOISearchQuery;
            this.f10192d = u4.a();
            return;
        }
        String str = a4.f9877b;
        throw new AMapException(str, 1, str, a4.f9876a.a());
    }

    private boolean b() {
        RoutePOISearchQuery routePOISearchQuery = this.f10189a;
        if (routePOISearchQuery == null || routePOISearchQuery.getSearchType() == null) {
            return false;
        }
        return (this.f10189a.getFrom() == null && this.f10189a.getTo() == null && this.f10189a.getPolylines() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final RoutePOISearchQuery getQuery() {
        return this.f10189a;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final RoutePOISearchResult searchRoutePOI() throws AMapException {
        try {
            s4.d(this.f10190b);
            if (b()) {
                return new u(this.f10190b, this.f10189a.m53clone()).O();
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (AMapException e4) {
            j4.i(e4, "RoutePOISearchCore", "searchRoutePOI");
            throw e4;
        }
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void searchRoutePOIAsyn() {
        y.a().b(new a());
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void setQuery(RoutePOISearchQuery routePOISearchQuery) {
        this.f10189a = routePOISearchQuery;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void setRoutePOISearchListener(RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener) {
        this.f10191c = onRoutePOISearchListener;
    }
}
