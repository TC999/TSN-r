package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.interfaces.IPoiSearchV2;
import com.amap.api.services.poisearch.PoiResultV2;
import com.amap.api.services.poisearch.PoiSearchV2;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: PoiSearchCoreV2.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class r0 implements IPoiSearchV2 {

    /* renamed from: j  reason: collision with root package name */
    private static HashMap<Integer, PoiResultV2> f10133j;

    /* renamed from: a  reason: collision with root package name */
    private PoiSearchV2.SearchBound f10134a;

    /* renamed from: b  reason: collision with root package name */
    private PoiSearchV2.Query f10135b;

    /* renamed from: c  reason: collision with root package name */
    private Context f10136c;

    /* renamed from: d  reason: collision with root package name */
    private PoiSearchV2.OnPoiSearchListener f10137d;

    /* renamed from: e  reason: collision with root package name */
    private String f10138e = "zh-CN";

    /* renamed from: f  reason: collision with root package name */
    private PoiSearchV2.Query f10139f;

    /* renamed from: g  reason: collision with root package name */
    private PoiSearchV2.SearchBound f10140g;

    /* renamed from: h  reason: collision with root package name */
    private int f10141h;

    /* renamed from: i  reason: collision with root package name */
    private Handler f10142i;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: PoiSearchCoreV2.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            u4.k kVar;
            Message obtainMessage = r0.this.f10142i.obtainMessage();
            obtainMessage.arg1 = 19;
            obtainMessage.what = MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_BUFLEN;
            Bundle bundle = new Bundle();
            PoiResultV2 poiResultV2 = null;
            try {
                try {
                    poiResultV2 = r0.this.searchPOI();
                    bundle.putInt("errorCode", 1000);
                    kVar = new u4.k();
                } catch (AMapException e4) {
                    bundle.putInt("errorCode", e4.getErrorCode());
                    kVar = new u4.k();
                }
                kVar.f10307b = r0.this.f10137d;
                kVar.f10306a = poiResultV2;
                obtainMessage.obj = kVar;
                obtainMessage.setData(bundle);
                r0.this.f10142i.sendMessage(obtainMessage);
            } catch (Throwable th) {
                u4.k kVar2 = new u4.k();
                kVar2.f10307b = r0.this.f10137d;
                kVar2.f10306a = poiResultV2;
                obtainMessage.obj = kVar2;
                obtainMessage.setData(bundle);
                r0.this.f10142i.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: PoiSearchCoreV2.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10144a;

        b(String str) {
            this.f10144a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u4.i iVar;
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.arg1 = 19;
            obtainMessage.what = MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_VIDEO_BUFLEN;
            Bundle bundle = new Bundle();
            PoiItemV2 poiItemV2 = null;
            try {
                try {
                    poiItemV2 = r0.this.searchPOIId(this.f10144a);
                    bundle.putInt("errorCode", 1000);
                    iVar = new u4.i();
                } catch (AMapException e4) {
                    j4.i(e4, "PoiSearch", "searchPOIIdAsyn");
                    bundle.putInt("errorCode", e4.getErrorCode());
                    iVar = new u4.i();
                }
                iVar.f10303b = r0.this.f10137d;
                iVar.f10302a = poiItemV2;
                obtainMessage.obj = iVar;
                obtainMessage.setData(bundle);
                r0.this.f10142i.sendMessage(obtainMessage);
            } catch (Throwable th) {
                u4.i iVar2 = new u4.i();
                iVar2.f10303b = r0.this.f10137d;
                iVar2.f10302a = poiItemV2;
                obtainMessage.obj = iVar2;
                obtainMessage.setData(bundle);
                r0.this.f10142i.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    public r0(Context context, PoiSearchV2.Query query) throws AMapException {
        this.f10142i = null;
        h1 a4 = cf.a(context, i4.a(false));
        if (a4.f9876a == cf.c.SuccessCode) {
            this.f10136c = StubApp.getOrigApplicationContext(context.getApplicationContext());
            setQuery(query);
            this.f10142i = u4.a();
            return;
        }
        String str = a4.f9877b;
        throw new AMapException(str, 1, str, a4.f9876a.a());
    }

    private PoiResultV2 b(int i4) {
        if (g(i4)) {
            return f10133j.get(Integer.valueOf(i4));
        }
        throw new IllegalArgumentException("page out of range");
    }

    private void c(PoiResultV2 poiResultV2) {
        int i4;
        f10133j = new HashMap<>();
        PoiSearchV2.Query query = this.f10135b;
        if (query == null || poiResultV2 == null || (i4 = this.f10141h) <= 0 || i4 <= query.getPageNum()) {
            return;
        }
        f10133j.put(Integer.valueOf(this.f10135b.getPageNum()), poiResultV2);
    }

    private boolean d() {
        PoiSearchV2.Query query = this.f10135b;
        if (query == null) {
            return false;
        }
        return (j4.j(query.getQueryString()) && j4.j(this.f10135b.getCategory())) ? false : true;
    }

    private boolean f() {
        PoiSearchV2.SearchBound bound = getBound();
        return bound != null && bound.getShape().equals("Bound");
    }

    private boolean g(int i4) {
        return i4 <= this.f10141h && i4 >= 0;
    }

    private boolean h() {
        PoiSearchV2.SearchBound bound = getBound();
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

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiSearchV2.SearchBound getBound() {
        return this.f10134a;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final String getLanguage() {
        return this.f10138e;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiSearchV2.Query getQuery() {
        return this.f10135b;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiResultV2 searchPOI() throws AMapException {
        try {
            s4.d(this.f10136c);
            if (!f() && !d()) {
                throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
            }
            if (h()) {
                PoiSearchV2.Query query = this.f10135b;
                if (query != null) {
                    if ((!query.queryEquals(this.f10139f) && this.f10134a == null) || (!this.f10135b.queryEquals(this.f10139f) && !this.f10134a.equals(this.f10140g))) {
                        this.f10141h = 0;
                        this.f10139f = this.f10135b.m38clone();
                        PoiSearchV2.SearchBound searchBound = this.f10134a;
                        if (searchBound != null) {
                            this.f10140g = searchBound.m39clone();
                        }
                        HashMap<Integer, PoiResultV2> hashMap = f10133j;
                        if (hashMap != null) {
                            hashMap.clear();
                        }
                    }
                    PoiSearchV2.SearchBound searchBound2 = this.f10134a;
                    PoiSearchV2.SearchBound m39clone = searchBound2 != null ? searchBound2.m39clone() : null;
                    q.a().f(this.f10135b.getQueryString());
                    this.f10135b.setPageNum(q.a().B(this.f10135b.getPageNum()));
                    this.f10135b.setPageSize(q.a().C(this.f10135b.getPageSize()));
                    if (this.f10141h == 0) {
                        PoiResultV2 O = new h(this.f10136c, new l(this.f10135b.m38clone(), m39clone)).O();
                        c(O);
                        return O;
                    }
                    PoiResultV2 b4 = b(this.f10135b.getPageNum());
                    if (b4 == null) {
                        PoiResultV2 O2 = new h(this.f10136c, new l(this.f10135b.m38clone(), m39clone)).O();
                        f10133j.put(Integer.valueOf(this.f10135b.getPageNum()), O2);
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

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void searchPOIAsyn() {
        try {
            y.a().b(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiItemV2 searchPOIId(String str) throws AMapException {
        s4.d(this.f10136c);
        PoiSearchV2.Query query = this.f10135b;
        return new f(this.f10136c, str, query != null ? query.m38clone() : null).O();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void searchPOIIdAsyn(String str) {
        y.a().b(new b(str));
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setBound(PoiSearchV2.SearchBound searchBound) {
        this.f10134a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setLanguage(String str) {
        if ("en".equals(str)) {
            this.f10138e = "en";
        } else {
            this.f10138e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setOnPoiSearchListener(PoiSearchV2.OnPoiSearchListener onPoiSearchListener) {
        this.f10137d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setQuery(PoiSearchV2.Query query) {
        this.f10135b = query;
    }
}
