package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IDistanceSearch;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DistanceSearchCore.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class l0 implements IDistanceSearch {

    /* renamed from: d  reason: collision with root package name */
    private static final String f9987d = "l0";

    /* renamed from: a  reason: collision with root package name */
    private Context f9988a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f9989b;

    /* renamed from: c  reason: collision with root package name */
    private DistanceSearch.OnDistanceSearchListener f9990c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DistanceSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DistanceSearch.DistanceQuery f9991a;

        a(DistanceSearch.DistanceQuery distanceQuery) {
            this.f9991a = distanceQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 400;
            obtainMessage.arg1 = 16;
            Bundle bundle = new Bundle();
            DistanceResult distanceResult = null;
            try {
                try {
                    distanceResult = l0.this.calculateRouteDistance(this.f9991a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e4) {
                    bundle.putInt("errorCode", e4.getErrorCode());
                }
            } finally {
                obtainMessage.obj = l0.this.f9990c;
                bundle.putParcelable("result", distanceResult);
                obtainMessage.setData(bundle);
                l0.this.f9989b.sendMessage(obtainMessage);
            }
        }
    }

    public l0(Context context) throws AMapException {
        h1 a4 = cf.a(context, i4.a(false));
        if (a4.f9876a == cf.c.SuccessCode) {
            this.f9988a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f9989b = u4.a();
            return;
        }
        String str = a4.f9877b;
        throw new AMapException(str, 1, str, a4.f9876a.a());
    }

    private static boolean b(DistanceSearch.DistanceQuery distanceQuery) {
        return distanceQuery.getDestination() == null || distanceQuery.getOrigins() == null || distanceQuery.getOrigins().size() <= 0;
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public DistanceResult calculateRouteDistance(DistanceSearch.DistanceQuery distanceQuery) throws AMapException {
        try {
            s4.d(this.f9988a);
            if (distanceQuery != null) {
                if (!b(distanceQuery)) {
                    DistanceSearch.DistanceQuery m40clone = distanceQuery.m40clone();
                    DistanceResult O = new k4(this.f9988a, m40clone).O();
                    if (O != null) {
                        O.setDistanceQuery(m40clone);
                    }
                    return O;
                }
                throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (AMapException e4) {
            j4.i(e4, f9987d, "calculateWalkRoute");
            throw e4;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void calculateRouteDistanceAsyn(DistanceSearch.DistanceQuery distanceQuery) {
        y.a().b(new a(distanceQuery));
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void setDistanceSearchListener(DistanceSearch.OnDistanceSearchListener onDistanceSearchListener) {
        this.f9990c = onDistanceSearchListener;
    }
}
