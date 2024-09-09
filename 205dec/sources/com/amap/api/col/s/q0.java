package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: PoiSearchCore.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class q0 implements IPoiSearch {

    /* renamed from: j  reason: collision with root package name */
    private static HashMap<Integer, PoiResult> f10114j;

    /* renamed from: a  reason: collision with root package name */
    private PoiSearch.SearchBound f10115a;

    /* renamed from: b  reason: collision with root package name */
    private PoiSearch.Query f10116b;

    /* renamed from: c  reason: collision with root package name */
    private Context f10117c;

    /* renamed from: d  reason: collision with root package name */
    private PoiSearch.OnPoiSearchListener f10118d;

    /* renamed from: e  reason: collision with root package name */
    private String f10119e = "zh-CN";

    /* renamed from: f  reason: collision with root package name */
    private PoiSearch.Query f10120f;

    /* renamed from: g  reason: collision with root package name */
    private PoiSearch.SearchBound f10121g;

    /* renamed from: h  reason: collision with root package name */
    private int f10122h;

    /* renamed from: i  reason: collision with root package name */
    private Handler f10123i;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: PoiSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            u4.j jVar;
            Message obtainMessage = q0.this.f10123i.obtainMessage();
            obtainMessage.arg1 = 6;
            obtainMessage.what = 600;
            Bundle bundle = new Bundle();
            PoiResult poiResult = null;
            try {
                try {
                    poiResult = q0.this.searchPOI();
                    bundle.putInt("errorCode", 1000);
                    jVar = new u4.j();
                } catch (AMapException e4) {
                    bundle.putInt("errorCode", e4.getErrorCode());
                    jVar = new u4.j();
                }
                jVar.f10305b = q0.this.f10118d;
                jVar.f10304a = poiResult;
                obtainMessage.obj = jVar;
                obtainMessage.setData(bundle);
                q0.this.f10123i.sendMessage(obtainMessage);
            } catch (Throwable th) {
                u4.j jVar2 = new u4.j();
                jVar2.f10305b = q0.this.f10118d;
                jVar2.f10304a = poiResult;
                obtainMessage.obj = jVar2;
                obtainMessage.setData(bundle);
                q0.this.f10123i.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: PoiSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10125a;

        b(String str) {
            this.f10125a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u4.h hVar;
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.arg1 = 6;
            obtainMessage.what = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN;
            Bundle bundle = new Bundle();
            PoiItem poiItem = null;
            try {
                try {
                    poiItem = q0.this.searchPOIId(this.f10125a);
                    bundle.putInt("errorCode", 1000);
                    hVar = new u4.h();
                } catch (AMapException e4) {
                    j4.i(e4, "PoiSearch", "searchPOIIdAsyn");
                    bundle.putInt("errorCode", e4.getErrorCode());
                    hVar = new u4.h();
                }
                hVar.f10301b = q0.this.f10118d;
                hVar.f10300a = poiItem;
                obtainMessage.obj = hVar;
                obtainMessage.setData(bundle);
                q0.this.f10123i.sendMessage(obtainMessage);
            } catch (Throwable th) {
                u4.h hVar2 = new u4.h();
                hVar2.f10301b = q0.this.f10118d;
                hVar2.f10300a = poiItem;
                obtainMessage.obj = hVar2;
                obtainMessage.setData(bundle);
                q0.this.f10123i.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    public q0(Context context, PoiSearch.Query query) throws AMapException {
        this.f10123i = null;
        h1 a4 = cf.a(context, i4.a(false));
        if (a4.f9876a == cf.c.SuccessCode) {
            this.f10117c = StubApp.getOrigApplicationContext(context.getApplicationContext());
            setQuery(query);
            this.f10123i = u4.a();
            return;
        }
        String str = a4.f9877b;
        throw new AMapException(str, 1, str, a4.f9876a.a());
    }

    private PoiResult b(int i4) {
        if (g(i4)) {
            return f10114j.get(Integer.valueOf(i4));
        }
        throw new IllegalArgumentException("page out of range");
    }

    private void c(PoiResult poiResult) {
        int i4;
        f10114j = new HashMap<>();
        PoiSearch.Query query = this.f10116b;
        if (query == null || poiResult == null || (i4 = this.f10122h) <= 0 || i4 <= query.getPageNum()) {
            return;
        }
        f10114j.put(Integer.valueOf(this.f10116b.getPageNum()), poiResult);
    }

    private boolean d() {
        PoiSearch.Query query = this.f10116b;
        if (query == null) {
            return false;
        }
        return (j4.j(query.getQueryString()) && j4.j(this.f10116b.getCategory())) ? false : true;
    }

    private boolean f() {
        PoiSearch.SearchBound bound = getBound();
        return bound != null && bound.getShape().equals("Bound");
    }

    private boolean g(int i4) {
        return i4 <= this.f10122h && i4 >= 0;
    }

    private boolean h() {
        PoiSearch.SearchBound bound = getBound();
        if (bound != null) {
            if (bound.getShape().equals("Bound")) {
                return bound.getCenter() != null;
            } else if (bound.getShape().equals("Polygon")) {
                List<LatLonPoint> polyGonList = bound.getPolyGonList();
                if (polyGonList == null || polyGonList.size() == 0) {
                    return false;
                }
                for (int i4 = 0; i4 < polyGonList.size(); i4++) {
                    if (polyGonList.get(i4) == null) {
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
        return this.f10115a;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final String getLanguage() {
        return this.f10119e;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiSearch.Query getQuery() {
        return this.f10116b;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiResult searchPOI() throws AMapException {
        try {
            s4.d(this.f10117c);
            if (!f() && !d()) {
                throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
            }
            if (h()) {
                PoiSearch.Query query = this.f10116b;
                if (query != null) {
                    if ((!query.queryEquals(this.f10120f) && this.f10115a == null) || (!this.f10116b.queryEquals(this.f10120f) && !this.f10115a.equals(this.f10121g))) {
                        this.f10122h = 0;
                        this.f10120f = this.f10116b.m36clone();
                        PoiSearch.SearchBound searchBound = this.f10115a;
                        if (searchBound != null) {
                            this.f10121g = searchBound.m37clone();
                        }
                        HashMap<Integer, PoiResult> hashMap = f10114j;
                        if (hashMap != null) {
                            hashMap.clear();
                        }
                    }
                    PoiSearch.SearchBound searchBound2 = this.f10115a;
                    PoiSearch.SearchBound m37clone = searchBound2 != null ? searchBound2.m37clone() : null;
                    q.a().f(this.f10116b.getQueryString());
                    this.f10116b.setPageNum(q.a().B(this.f10116b.getPageNum()));
                    this.f10116b.setPageSize(q.a().C(this.f10116b.getPageSize()));
                    if (this.f10122h == 0) {
                        PoiResult O = new g(this.f10117c, new k(this.f10116b.m36clone(), m37clone)).O();
                        c(O);
                        return O;
                    }
                    PoiResult b4 = b(this.f10116b.getPageNum());
                    if (b4 == null) {
                        PoiResult O2 = new g(this.f10117c, new k(this.f10116b.m36clone(), m37clone)).O();
                        f10114j.put(Integer.valueOf(this.f10116b.getPageNum()), O2);
                        return O2;
                    }
                    return b4;
                }
                throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (AMapException e4) {
            j4.i(e4, "PoiSearch", "searchPOI");
            throw new AMapException(e4.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIAsyn() {
        try {
            y.a().b(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiItem searchPOIId(String str) throws AMapException {
        s4.d(this.f10117c);
        PoiSearch.Query query = this.f10116b;
        return new e(this.f10117c, str, query != null ? query.m36clone() : null).O();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIIdAsyn(String str) {
        y.a().b(new b(str));
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setBound(PoiSearch.SearchBound searchBound) {
        this.f10115a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setLanguage(String str) {
        if ("en".equals(str)) {
            this.f10119e = "en";
        } else {
            this.f10119e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setOnPoiSearchListener(PoiSearch.OnPoiSearchListener onPoiSearchListener) {
        this.f10118d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setQuery(PoiSearch.Query query) {
        this.f10116b = query;
    }
}
