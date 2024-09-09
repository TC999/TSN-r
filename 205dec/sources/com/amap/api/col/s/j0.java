package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;
import com.stub.StubApp;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BusStationSearchCore.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class j0 implements IBusStationSearch {

    /* renamed from: a  reason: collision with root package name */
    private Context f9939a;

    /* renamed from: b  reason: collision with root package name */
    private BusStationSearch.OnBusStationSearchListener f9940b;

    /* renamed from: c  reason: collision with root package name */
    private BusStationQuery f9941c;

    /* renamed from: d  reason: collision with root package name */
    private BusStationQuery f9942d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<BusStationResult> f9943e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private int f9944f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f9945g;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BusStationSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 7;
                    u4.c cVar = new u4.c();
                    cVar.f10291b = j0.this.f9940b;
                    obtainMessage.obj = cVar;
                    BusStationResult searchBusStation = j0.this.searchBusStation();
                    obtainMessage.what = 1000;
                    cVar.f10290a = searchBusStation;
                } catch (AMapException e4) {
                    obtainMessage.what = e4.getErrorCode();
                }
            } finally {
                j0.this.f9945g.sendMessage(obtainMessage);
            }
        }
    }

    public j0(Context context, BusStationQuery busStationQuery) throws AMapException {
        h1 a4 = cf.a(context, i4.a(false));
        if (a4.f9876a == cf.c.SuccessCode) {
            this.f9939a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f9941c = busStationQuery;
            this.f9945g = u4.a();
            return;
        }
        String str = a4.f9877b;
        throw new AMapException(str, 1, str, a4.f9876a.a());
    }

    private void b(BusStationResult busStationResult) {
        int i4;
        this.f9943e = new ArrayList<>();
        int i5 = 0;
        while (true) {
            i4 = this.f9944f;
            if (i5 > i4) {
                break;
            }
            this.f9943e.add(null);
            i5++;
        }
        if (i4 > 0) {
            this.f9943e.set(this.f9941c.getPageNumber(), busStationResult);
        }
    }

    private boolean c() {
        BusStationQuery busStationQuery = this.f9941c;
        return (busStationQuery == null || j4.j(busStationQuery.getQueryString())) ? false : true;
    }

    private boolean d(int i4) {
        return i4 <= this.f9944f && i4 >= 0;
    }

    private BusStationResult f(int i4) {
        if (d(i4)) {
            return this.f9943e.get(i4);
        }
        throw new IllegalArgumentException("page out of range");
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final BusStationQuery getQuery() {
        return this.f9941c;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final BusStationResult searchBusStation() throws AMapException {
        try {
            s4.d(this.f9939a);
            if (c()) {
                if (!this.f9941c.weakEquals(this.f9942d)) {
                    this.f9942d = this.f9941c.m32clone();
                    this.f9944f = 0;
                    ArrayList<BusStationResult> arrayList = this.f9943e;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                }
                if (this.f9944f == 0) {
                    BusStationResult busStationResult = (BusStationResult) new e4(this.f9939a, this.f9941c).O();
                    this.f9944f = busStationResult.getPageCount();
                    b(busStationResult);
                    return busStationResult;
                }
                BusStationResult f4 = f(this.f9941c.getPageNumber());
                if (f4 == null) {
                    BusStationResult busStationResult2 = (BusStationResult) new e4(this.f9939a, this.f9941c).O();
                    this.f9943e.set(this.f9941c.getPageNumber(), busStationResult2);
                    return busStationResult2;
                }
                return f4;
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (AMapException e4) {
            j4.i(e4, "BusStationSearch", "searchBusStation");
            throw new AMapException(e4.getErrorMessage());
        } catch (Throwable th) {
            j4.i(th, "BusStationSearch", "searchBusStation");
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void searchBusStationAsyn() {
        try {
            y.a().b(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setOnBusStationSearchListener(BusStationSearch.OnBusStationSearchListener onBusStationSearchListener) {
        this.f9940b = onBusStationSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setQuery(BusStationQuery busStationQuery) {
        if (busStationQuery.weakEquals(this.f9941c)) {
            return;
        }
        this.f9941c = busStationQuery;
    }
}
