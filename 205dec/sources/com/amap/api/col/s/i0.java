package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;
import com.stub.StubApp;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BusLineSearchCore.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class i0 implements IBusLineSearch {

    /* renamed from: a  reason: collision with root package name */
    private Context f9907a;

    /* renamed from: b  reason: collision with root package name */
    private BusLineSearch.OnBusLineSearchListener f9908b;

    /* renamed from: c  reason: collision with root package name */
    private BusLineQuery f9909c;

    /* renamed from: d  reason: collision with root package name */
    private BusLineQuery f9910d;

    /* renamed from: e  reason: collision with root package name */
    private int f9911e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<BusLineResult> f9912f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private Handler f9913g;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BusLineSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 3;
                    obtainMessage.what = 1000;
                    u4.b bVar = new u4.b();
                    obtainMessage.obj = bVar;
                    bVar.f10289b = i0.this.f9908b;
                    bVar.f10288a = i0.this.searchBusLine();
                } catch (AMapException e4) {
                    obtainMessage.what = e4.getErrorCode();
                }
            } finally {
                i0.this.f9913g.sendMessage(obtainMessage);
            }
        }
    }

    public i0(Context context, BusLineQuery busLineQuery) throws AMapException {
        this.f9913g = null;
        h1 a4 = cf.a(context, i4.a(false));
        if (a4.f9876a == cf.c.SuccessCode) {
            this.f9907a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f9909c = busLineQuery;
            if (busLineQuery != null) {
                this.f9910d = busLineQuery.m31clone();
            }
            this.f9913g = u4.a();
            return;
        }
        String str = a4.f9877b;
        throw new AMapException(str, 1, str, a4.f9876a.a());
    }

    private void b(BusLineResult busLineResult) {
        int i4;
        this.f9912f = new ArrayList<>();
        int i5 = 0;
        while (true) {
            i4 = this.f9911e;
            if (i5 >= i4) {
                break;
            }
            this.f9912f.add(null);
            i5++;
        }
        if (i4 < 0 || !d(this.f9909c.getPageNumber())) {
            return;
        }
        this.f9912f.set(this.f9909c.getPageNumber(), busLineResult);
    }

    private boolean c() {
        BusLineQuery busLineQuery = this.f9909c;
        return (busLineQuery == null || j4.j(busLineQuery.getQueryString())) ? false : true;
    }

    private boolean d(int i4) {
        return i4 < this.f9911e && i4 >= 0;
    }

    private BusLineResult f(int i4) {
        if (d(i4)) {
            return this.f9912f.get(i4);
        }
        throw new IllegalArgumentException("page out of range");
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final BusLineQuery getQuery() {
        return this.f9909c;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final BusLineResult searchBusLine() throws AMapException {
        try {
            s4.d(this.f9907a);
            if (this.f9910d != null && c()) {
                if (!this.f9909c.weakEquals(this.f9910d)) {
                    this.f9910d = this.f9909c.m31clone();
                    this.f9911e = 0;
                    ArrayList<BusLineResult> arrayList = this.f9912f;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                }
                if (this.f9911e == 0) {
                    BusLineResult busLineResult = (BusLineResult) new e4(this.f9907a, this.f9909c.m31clone()).O();
                    b(busLineResult);
                    return busLineResult;
                }
                BusLineResult f4 = f(this.f9909c.getPageNumber());
                if (f4 == null) {
                    BusLineResult busLineResult2 = (BusLineResult) new e4(this.f9907a, this.f9909c).O();
                    this.f9912f.set(this.f9909c.getPageNumber(), busLineResult2);
                    return busLineResult2;
                }
                return f4;
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (AMapException e4) {
            j4.i(e4, "BusLineSearch", "searchBusLine");
            throw new AMapException(e4.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void searchBusLineAsyn() {
        try {
            y.a().b(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void setOnBusLineSearchListener(BusLineSearch.OnBusLineSearchListener onBusLineSearchListener) {
        this.f9908b = onBusLineSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void setQuery(BusLineQuery busLineQuery) {
        if (this.f9909c.weakEquals(busLineQuery)) {
            return;
        }
        this.f9909c = busLineQuery;
        this.f9910d = busLineQuery.m31clone();
    }
}
