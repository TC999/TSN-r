package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p047s.C2033cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.interfaces.IDistrictSearch;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;

/* renamed from: com.amap.api.col.s.m0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DistrictSearchCore implements IDistrictSearch {

    /* renamed from: g */
    private static HashMap<Integer, DistrictResult> f6274g;

    /* renamed from: a */
    private Context f6275a;

    /* renamed from: b */
    private DistrictSearchQuery f6276b;

    /* renamed from: c */
    private DistrictSearch.OnDistrictSearchListener f6277c;

    /* renamed from: d */
    private DistrictSearchQuery f6278d;

    /* renamed from: e */
    private int f6279e;

    /* renamed from: f */
    private Handler f6280f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DistrictSearchCore.java */
    /* renamed from: com.amap.api.col.s.m0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC2092a implements Runnable {
        RunnableC2092a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            DistrictResult districtResult = new DistrictResult();
            districtResult.setQuery(DistrictSearchCore.this.f6276b);
            try {
                try {
                    districtResult = DistrictSearchCore.this.searchDistrict();
                    if (districtResult != null) {
                        districtResult.setAMapException(new AMapException());
                    }
                } catch (AMapException e) {
                    districtResult.setAMapException(e);
                    obtainMessage.arg1 = 4;
                    obtainMessage.obj = DistrictSearchCore.this.f6277c;
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(CommonNetImpl.RESULT, districtResult);
                    obtainMessage.setData(bundle);
                    if (DistrictSearchCore.this.f6280f != null) {
                        DistrictSearchCore.this.f6280f.sendMessage(obtainMessage);
                    }
                } catch (Throwable th) {
                    C2082j4.m52825i(th, "DistrictSearch", "searchDistrictAnsyThrowable");
                    obtainMessage.arg1 = 4;
                    obtainMessage.obj = DistrictSearchCore.this.f6277c;
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable(CommonNetImpl.RESULT, districtResult);
                    obtainMessage.setData(bundle2);
                    if (DistrictSearchCore.this.f6280f != null) {
                        DistrictSearchCore.this.f6280f.sendMessage(obtainMessage);
                    }
                }
            } finally {
                obtainMessage.arg1 = 4;
                obtainMessage.obj = DistrictSearchCore.this.f6277c;
                Bundle bundle3 = new Bundle();
                bundle3.putParcelable(CommonNetImpl.RESULT, districtResult);
                obtainMessage.setData(bundle3);
                if (DistrictSearchCore.this.f6280f != null) {
                    DistrictSearchCore.this.f6280f.sendMessage(obtainMessage);
                }
            }
        }
    }

    public DistrictSearchCore(Context context) throws AMapException {
        C2066h1 m53127a = C2033cf.m53127a(context, C2077i4.m52895a(false));
        if (m53127a.f6148a == C2033cf.EnumC2036c.SuccessCode) {
            this.f6275a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f6280f = MessageHandler.m52418a();
            return;
        }
        String str = m53127a.f6149b;
        throw new AMapException(str, 1, str, m53127a.f6148a.m53102a());
    }

    /* renamed from: a */
    private DistrictResult m52773a(int i) throws AMapException {
        if (m52768f(i)) {
            return f6274g.get(Integer.valueOf(i));
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    /* renamed from: c */
    private void m52771c(DistrictResult districtResult) {
        int i;
        f6274g = new HashMap<>();
        DistrictSearchQuery districtSearchQuery = this.f6276b;
        if (districtSearchQuery == null || districtResult == null || (i = this.f6279e) <= 0 || i <= districtSearchQuery.getPageNum()) {
            return;
        }
        f6274g.put(Integer.valueOf(this.f6276b.getPageNum()), districtResult);
    }

    /* renamed from: d */
    private boolean m52770d() {
        return this.f6276b != null;
    }

    /* renamed from: f */
    private boolean m52768f(int i) {
        return i < this.f6279e && i >= 0;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final DistrictSearchQuery getQuery() {
        return this.f6276b;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final DistrictResult searchDistrict() throws AMapException {
        DistrictResult m52773a;
        int i;
        try {
            DistrictResult districtResult = new DistrictResult();
            ManifestConfig.m52460d(this.f6275a);
            if (!m52770d()) {
                this.f6276b = new DistrictSearchQuery();
            }
            districtResult.setQuery(this.f6276b.m60114clone());
            if (!this.f6276b.weakEquals(this.f6278d)) {
                this.f6279e = 0;
                this.f6278d = this.f6276b.m60114clone();
                HashMap<Integer, DistrictResult> hashMap = f6274g;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            if (this.f6279e == 0) {
                m52773a = new DistrictServerHandler(this.f6275a, this.f6276b.m60114clone()).m53251O();
                if (m52773a == null) {
                    return m52773a;
                }
                this.f6279e = m52773a.getPageCount();
                m52771c(m52773a);
            } else {
                m52773a = m52773a(this.f6276b.getPageNum());
                if (m52773a == null) {
                    m52773a = new DistrictServerHandler(this.f6275a, this.f6276b.m60114clone()).m53251O();
                    DistrictSearchQuery districtSearchQuery = this.f6276b;
                    if (districtSearchQuery != null && m52773a != null && (i = this.f6279e) > 0 && i > districtSearchQuery.getPageNum()) {
                        f6274g.put(Integer.valueOf(this.f6276b.getPageNum()), m52773a);
                    }
                }
            }
            return m52773a;
        } catch (AMapException e) {
            C2082j4.m52825i(e, "DistrictSearch", "searchDistrict");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAnsy() {
        searchDistrictAsyn();
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAsyn() {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2092a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setOnDistrictSearchListener(DistrictSearch.OnDistrictSearchListener onDistrictSearchListener) {
        this.f6277c = onDistrictSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f6276b = districtSearchQuery;
    }
}
