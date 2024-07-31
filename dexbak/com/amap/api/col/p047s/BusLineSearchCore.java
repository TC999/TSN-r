package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p047s.C2033cf;
import com.amap.api.col.p047s.MessageHandler;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;
import com.stub.StubApp;
import java.util.ArrayList;

/* renamed from: com.amap.api.col.s.i0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class BusLineSearchCore implements IBusLineSearch {

    /* renamed from: a */
    private Context f6179a;

    /* renamed from: b */
    private BusLineSearch.OnBusLineSearchListener f6180b;

    /* renamed from: c */
    private BusLineQuery f6181c;

    /* renamed from: d */
    private BusLineQuery f6182d;

    /* renamed from: e */
    private int f6183e;

    /* renamed from: f */
    private ArrayList<BusLineResult> f6184f = new ArrayList<>();

    /* renamed from: g */
    private Handler f6185g;

    /* compiled from: BusLineSearchCore.java */
    /* renamed from: com.amap.api.col.s.i0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2072a implements Runnable {
        RunnableC2072a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 3;
                    obtainMessage.what = 1000;
                    MessageHandler.C2167b c2167b = new MessageHandler.C2167b();
                    obtainMessage.obj = c2167b;
                    c2167b.f6561b = BusLineSearchCore.this.f6180b;
                    c2167b.f6560a = BusLineSearchCore.this.searchBusLine();
                } catch (AMapException e) {
                    obtainMessage.what = e.getErrorCode();
                }
            } finally {
                BusLineSearchCore.this.f6185g.sendMessage(obtainMessage);
            }
        }
    }

    public BusLineSearchCore(Context context, BusLineQuery busLineQuery) throws AMapException {
        this.f6185g = null;
        C2066h1 m53127a = C2033cf.m53127a(context, C2077i4.m52895a(false));
        if (m53127a.f6148a == C2033cf.EnumC2036c.SuccessCode) {
            this.f6179a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f6181c = busLineQuery;
            if (busLineQuery != null) {
                this.f6182d = busLineQuery.m60110clone();
            }
            this.f6185g = MessageHandler.m52418a();
            return;
        }
        String str = m53127a.f6149b;
        throw new AMapException(str, 1, str, m53127a.f6148a.m53102a());
    }

    /* renamed from: b */
    private void m52926b(BusLineResult busLineResult) {
        int i;
        this.f6184f = new ArrayList<>();
        int i2 = 0;
        while (true) {
            i = this.f6183e;
            if (i2 >= i) {
                break;
            }
            this.f6184f.add(null);
            i2++;
        }
        if (i < 0 || !m52924d(this.f6181c.getPageNumber())) {
            return;
        }
        this.f6184f.set(this.f6181c.getPageNumber(), busLineResult);
    }

    /* renamed from: c */
    private boolean m52925c() {
        BusLineQuery busLineQuery = this.f6181c;
        return (busLineQuery == null || C2082j4.m52824j(busLineQuery.getQueryString())) ? false : true;
    }

    /* renamed from: d */
    private boolean m52924d(int i) {
        return i < this.f6183e && i >= 0;
    }

    /* renamed from: f */
    private BusLineResult m52922f(int i) {
        if (m52924d(i)) {
            return this.f6184f.get(i);
        }
        throw new IllegalArgumentException("page out of range");
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final BusLineQuery getQuery() {
        return this.f6181c;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final BusLineResult searchBusLine() throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6179a);
            if (this.f6182d != null && m52925c()) {
                if (!this.f6181c.weakEquals(this.f6182d)) {
                    this.f6182d = this.f6181c.m60110clone();
                    this.f6183e = 0;
                    ArrayList<BusLineResult> arrayList = this.f6184f;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                }
                if (this.f6183e == 0) {
                    BusLineResult busLineResult = (BusLineResult) new BusSearchServerHandler(this.f6179a, this.f6181c.m60110clone()).m53251O();
                    m52926b(busLineResult);
                    return busLineResult;
                }
                BusLineResult m52922f = m52922f(this.f6181c.getPageNumber());
                if (m52922f == null) {
                    BusLineResult busLineResult2 = (BusLineResult) new BusSearchServerHandler(this.f6179a, this.f6181c).m53251O();
                    this.f6184f.set(this.f6181c.getPageNumber(), busLineResult2);
                    return busLineResult2;
                }
                return m52922f;
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C2082j4.m52825i(e, "BusLineSearch", "searchBusLine");
            throw new AMapException(e.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void searchBusLineAsyn() {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2072a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void setOnBusLineSearchListener(BusLineSearch.OnBusLineSearchListener onBusLineSearchListener) {
        this.f6180b = onBusLineSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void setQuery(BusLineQuery busLineQuery) {
        if (this.f6181c.weakEquals(busLineQuery)) {
            return;
        }
        this.f6181c = busLineQuery;
        this.f6182d = busLineQuery.m60110clone();
    }
}
