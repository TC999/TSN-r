package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.interfaces.IDistrictSearch;
import com.stub.StubApp;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DistrictSearchCore.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class m0 implements IDistrictSearch {

    /* renamed from: g  reason: collision with root package name */
    private static HashMap<Integer, DistrictResult> f10002g;

    /* renamed from: a  reason: collision with root package name */
    private Context f10003a;

    /* renamed from: b  reason: collision with root package name */
    private DistrictSearchQuery f10004b;

    /* renamed from: c  reason: collision with root package name */
    private DistrictSearch.OnDistrictSearchListener f10005c;

    /* renamed from: d  reason: collision with root package name */
    private DistrictSearchQuery f10006d;

    /* renamed from: e  reason: collision with root package name */
    private int f10007e;

    /* renamed from: f  reason: collision with root package name */
    private Handler f10008f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DistrictSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            DistrictResult districtResult = new DistrictResult();
            districtResult.setQuery(m0.this.f10004b);
            try {
                try {
                    districtResult = m0.this.searchDistrict();
                    if (districtResult != null) {
                        districtResult.setAMapException(new AMapException());
                    }
                } catch (AMapException e4) {
                    districtResult.setAMapException(e4);
                    obtainMessage.arg1 = 4;
                    obtainMessage.obj = m0.this.f10005c;
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("result", districtResult);
                    obtainMessage.setData(bundle);
                    if (m0.this.f10008f != null) {
                        m0.this.f10008f.sendMessage(obtainMessage);
                    }
                } catch (Throwable th) {
                    j4.i(th, "DistrictSearch", "searchDistrictAnsyThrowable");
                    obtainMessage.arg1 = 4;
                    obtainMessage.obj = m0.this.f10005c;
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("result", districtResult);
                    obtainMessage.setData(bundle2);
                    if (m0.this.f10008f != null) {
                        m0.this.f10008f.sendMessage(obtainMessage);
                    }
                }
            } finally {
                obtainMessage.arg1 = 4;
                obtainMessage.obj = m0.this.f10005c;
                Bundle bundle3 = new Bundle();
                bundle3.putParcelable("result", districtResult);
                obtainMessage.setData(bundle3);
                if (m0.this.f10008f != null) {
                    m0.this.f10008f.sendMessage(obtainMessage);
                }
            }
        }
    }

    public m0(Context context) throws AMapException {
        h1 a4 = cf.a(context, i4.a(false));
        if (a4.f9876a == cf.c.SuccessCode) {
            this.f10003a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f10008f = u4.a();
            return;
        }
        String str = a4.f9877b;
        throw new AMapException(str, 1, str, a4.f9876a.a());
    }

    private DistrictResult a(int i4) throws AMapException {
        if (f(i4)) {
            return f10002g.get(Integer.valueOf(i4));
        }
        throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
    }

    private void c(DistrictResult districtResult) {
        int i4;
        f10002g = new HashMap<>();
        DistrictSearchQuery districtSearchQuery = this.f10004b;
        if (districtSearchQuery == null || districtResult == null || (i4 = this.f10007e) <= 0 || i4 <= districtSearchQuery.getPageNum()) {
            return;
        }
        f10002g.put(Integer.valueOf(this.f10004b.getPageNum()), districtResult);
    }

    private boolean d() {
        return this.f10004b != null;
    }

    private boolean f(int i4) {
        return i4 < this.f10007e && i4 >= 0;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final DistrictSearchQuery getQuery() {
        return this.f10004b;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final DistrictResult searchDistrict() throws AMapException {
        DistrictResult a4;
        int i4;
        try {
            DistrictResult districtResult = new DistrictResult();
            s4.d(this.f10003a);
            if (!d()) {
                this.f10004b = new DistrictSearchQuery();
            }
            districtResult.setQuery(this.f10004b.m35clone());
            if (!this.f10004b.weakEquals(this.f10006d)) {
                this.f10007e = 0;
                this.f10006d = this.f10004b.m35clone();
                HashMap<Integer, DistrictResult> hashMap = f10002g;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            if (this.f10007e == 0) {
                a4 = new l4(this.f10003a, this.f10004b.m35clone()).O();
                if (a4 == null) {
                    return a4;
                }
                this.f10007e = a4.getPageCount();
                c(a4);
            } else {
                a4 = a(this.f10004b.getPageNum());
                if (a4 == null) {
                    a4 = new l4(this.f10003a, this.f10004b.m35clone()).O();
                    DistrictSearchQuery districtSearchQuery = this.f10004b;
                    if (districtSearchQuery != null && a4 != null && (i4 = this.f10007e) > 0 && i4 > districtSearchQuery.getPageNum()) {
                        f10002g.put(Integer.valueOf(this.f10004b.getPageNum()), a4);
                    }
                }
            }
            return a4;
        } catch (AMapException e4) {
            j4.i(e4, "DistrictSearch", "searchDistrict");
            throw e4;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAnsy() {
        searchDistrictAsyn();
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAsyn() {
        try {
            y.a().b(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setOnDistrictSearchListener(DistrictSearch.OnDistrictSearchListener onDistrictSearchListener) {
        this.f10005c = onDistrictSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f10004b = districtSearchQuery;
    }
}
