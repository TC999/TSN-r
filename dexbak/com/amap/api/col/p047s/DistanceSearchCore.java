package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p047s.C2033cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IDistanceSearch;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.autonavi.base.p048ae.gmap.glyph.FontStyle;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* renamed from: com.amap.api.col.s.l0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DistanceSearchCore implements IDistanceSearch {

    /* renamed from: d */
    private static final String f6259d = "l0";

    /* renamed from: a */
    private Context f6260a;

    /* renamed from: b */
    private Handler f6261b;

    /* renamed from: c */
    private DistanceSearch.OnDistanceSearchListener f6262c;

    /* compiled from: DistanceSearchCore.java */
    /* renamed from: com.amap.api.col.s.l0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2088a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DistanceSearch.DistanceQuery f6263a;

        RunnableC2088a(DistanceSearch.DistanceQuery distanceQuery) {
            this.f6263a = distanceQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.what = FontStyle.WEIGHT_NORMAL;
            obtainMessage.arg1 = 16;
            Bundle bundle = new Bundle();
            DistanceResult distanceResult = null;
            try {
                try {
                    distanceResult = DistanceSearchCore.this.calculateRouteDistance(this.f6263a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = DistanceSearchCore.this.f6262c;
                bundle.putParcelable(CommonNetImpl.RESULT, distanceResult);
                obtainMessage.setData(bundle);
                DistanceSearchCore.this.f6261b.sendMessage(obtainMessage);
            }
        }
    }

    public DistanceSearchCore(Context context) throws AMapException {
        C2066h1 m53127a = C2033cf.m53127a(context, C2077i4.m52895a(false));
        if (m53127a.f6148a == C2033cf.EnumC2036c.SuccessCode) {
            this.f6260a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f6261b = MessageHandler.m52418a();
            return;
        }
        String str = m53127a.f6149b;
        throw new AMapException(str, 1, str, m53127a.f6148a.m53102a());
    }

    /* renamed from: b */
    private static boolean m52778b(DistanceSearch.DistanceQuery distanceQuery) {
        return distanceQuery.getDestination() == null || distanceQuery.getOrigins() == null || distanceQuery.getOrigins().size() <= 0;
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public DistanceResult calculateRouteDistance(DistanceSearch.DistanceQuery distanceQuery) throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6260a);
            if (distanceQuery != null) {
                if (!m52778b(distanceQuery)) {
                    DistanceSearch.DistanceQuery m60119clone = distanceQuery.m60119clone();
                    DistanceResult m53251O = new DistanceSearchHandler(this.f6260a, m60119clone).m53251O();
                    if (m53251O != null) {
                        m53251O.setDistanceQuery(m60119clone);
                    }
                    return m53251O;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C2082j4.m52825i(e, f6259d, "calculateWalkRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void calculateRouteDistanceAsyn(DistanceSearch.DistanceQuery distanceQuery) {
        ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2088a(distanceQuery));
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void setDistanceSearchListener(DistanceSearch.OnDistanceSearchListener onDistanceSearchListener) {
        this.f6262c = onDistanceSearchListener;
    }
}
