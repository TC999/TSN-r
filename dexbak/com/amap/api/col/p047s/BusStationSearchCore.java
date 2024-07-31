package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p047s.C2033cf;
import com.amap.api.col.p047s.MessageHandler;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;
import com.stub.StubApp;
import java.util.ArrayList;

/* renamed from: com.amap.api.col.s.j0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class BusStationSearchCore implements IBusStationSearch {

    /* renamed from: a */
    private Context f6211a;

    /* renamed from: b */
    private BusStationSearch.OnBusStationSearchListener f6212b;

    /* renamed from: c */
    private BusStationQuery f6213c;

    /* renamed from: d */
    private BusStationQuery f6214d;

    /* renamed from: e */
    private ArrayList<BusStationResult> f6215e = new ArrayList<>();

    /* renamed from: f */
    private int f6216f;

    /* renamed from: g */
    private Handler f6217g;

    /* compiled from: BusStationSearchCore.java */
    /* renamed from: com.amap.api.col.s.j0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2078a implements Runnable {
        RunnableC2078a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 7;
                    MessageHandler.C2168c c2168c = new MessageHandler.C2168c();
                    c2168c.f6563b = BusStationSearchCore.this.f6212b;
                    obtainMessage.obj = c2168c;
                    BusStationResult searchBusStation = BusStationSearchCore.this.searchBusStation();
                    obtainMessage.what = 1000;
                    c2168c.f6562a = searchBusStation;
                } catch (AMapException e) {
                    obtainMessage.what = e.getErrorCode();
                }
            } finally {
                BusStationSearchCore.this.f6217g.sendMessage(obtainMessage);
            }
        }
    }

    public BusStationSearchCore(Context context, BusStationQuery busStationQuery) throws AMapException {
        C2066h1 m53127a = C2033cf.m53127a(context, C2077i4.m52895a(false));
        if (m53127a.f6148a == C2033cf.EnumC2036c.SuccessCode) {
            this.f6211a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f6213c = busStationQuery;
            this.f6217g = MessageHandler.m52418a();
            return;
        }
        String str = m53127a.f6149b;
        throw new AMapException(str, 1, str, m53127a.f6148a.m53102a());
    }

    /* renamed from: b */
    private void m52886b(BusStationResult busStationResult) {
        int i;
        this.f6215e = new ArrayList<>();
        int i2 = 0;
        while (true) {
            i = this.f6216f;
            if (i2 > i) {
                break;
            }
            this.f6215e.add(null);
            i2++;
        }
        if (i > 0) {
            this.f6215e.set(this.f6213c.getPageNumber(), busStationResult);
        }
    }

    /* renamed from: c */
    private boolean m52885c() {
        BusStationQuery busStationQuery = this.f6213c;
        return (busStationQuery == null || C2082j4.m52824j(busStationQuery.getQueryString())) ? false : true;
    }

    /* renamed from: d */
    private boolean m52884d(int i) {
        return i <= this.f6216f && i >= 0;
    }

    /* renamed from: f */
    private BusStationResult m52882f(int i) {
        if (m52884d(i)) {
            return this.f6215e.get(i);
        }
        throw new IllegalArgumentException("page out of range");
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final BusStationQuery getQuery() {
        return this.f6213c;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final BusStationResult searchBusStation() throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6211a);
            if (m52885c()) {
                if (!this.f6213c.weakEquals(this.f6214d)) {
                    this.f6214d = this.f6213c.m60111clone();
                    this.f6216f = 0;
                    ArrayList<BusStationResult> arrayList = this.f6215e;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                }
                if (this.f6216f == 0) {
                    BusStationResult busStationResult = (BusStationResult) new BusSearchServerHandler(this.f6211a, this.f6213c).m53251O();
                    this.f6216f = busStationResult.getPageCount();
                    m52886b(busStationResult);
                    return busStationResult;
                }
                BusStationResult m52882f = m52882f(this.f6213c.getPageNumber());
                if (m52882f == null) {
                    BusStationResult busStationResult2 = (BusStationResult) new BusSearchServerHandler(this.f6211a, this.f6213c).m53251O();
                    this.f6215e.set(this.f6213c.getPageNumber(), busStationResult2);
                    return busStationResult2;
                }
                return m52882f;
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C2082j4.m52825i(e, "BusStationSearch", "searchBusStation");
            throw new AMapException(e.getErrorMessage());
        } catch (Throwable th) {
            C2082j4.m52825i(th, "BusStationSearch", "searchBusStation");
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void searchBusStationAsyn() {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2078a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setOnBusStationSearchListener(BusStationSearch.OnBusStationSearchListener onBusStationSearchListener) {
        this.f6212b = onBusStationSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setQuery(BusStationQuery busStationQuery) {
        if (busStationQuery.weakEquals(this.f6213c)) {
            return;
        }
        this.f6213c = busStationQuery;
    }
}
