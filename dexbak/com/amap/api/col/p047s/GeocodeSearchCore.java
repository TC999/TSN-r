package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p047s.C2033cf;
import com.amap.api.col.p047s.MessageHandler;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.interfaces.IGeocodeSearch;
import com.stub.StubApp;
import java.util.List;

/* renamed from: com.amap.api.col.s.n0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class GeocodeSearchCore implements IGeocodeSearch {

    /* renamed from: a */
    private Context f6304a;

    /* renamed from: b */
    private GeocodeSearch.OnGeocodeSearchListener f6305b;

    /* renamed from: c */
    private Handler f6306c;

    /* compiled from: GeocodeSearchCore.java */
    /* renamed from: com.amap.api.col.s.n0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2099a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RegeocodeQuery f6307a;

        RunnableC2099a(RegeocodeQuery regeocodeQuery) {
            this.f6307a = regeocodeQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 2;
                    obtainMessage.what = 201;
                    MessageHandler.C2177l c2177l = new MessageHandler.C2177l();
                    c2177l.f6581b = GeocodeSearchCore.this.f6305b;
                    obtainMessage.obj = c2177l;
                    c2177l.f6580a = new RegeocodeResult(this.f6307a, GeocodeSearchCore.this.getFromLocation(this.f6307a));
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                GeocodeSearchCore.this.f6306c.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: GeocodeSearchCore.java */
    /* renamed from: com.amap.api.col.s.n0$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2100b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ GeocodeQuery f6309a;

        RunnableC2100b(GeocodeQuery geocodeQuery) {
            this.f6309a = geocodeQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            try {
                try {
                    obtainMessage.what = 200;
                    obtainMessage.arg1 = 2;
                    obtainMessage.arg2 = 1000;
                    MessageHandler.C2171f c2171f = new MessageHandler.C2171f();
                    c2171f.f6569b = GeocodeSearchCore.this.f6305b;
                    obtainMessage.obj = c2171f;
                    c2171f.f6568a = new GeocodeResult(this.f6309a, GeocodeSearchCore.this.getFromLocationName(this.f6309a));
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                GeocodeSearchCore.this.f6306c.sendMessage(obtainMessage);
            }
        }
    }

    public GeocodeSearchCore(Context context) throws AMapException {
        C2066h1 m53127a = C2033cf.m53127a(context, C2077i4.m52895a(false));
        if (m53127a.f6148a == C2033cf.EnumC2036c.SuccessCode) {
            this.f6304a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f6306c = MessageHandler.m52418a();
            return;
        }
        String str = m53127a.f6149b;
        throw new AMapException(str, 1, str, m53127a.f6148a.m53102a());
    }

    /* renamed from: b */
    private static boolean m52748b(RegeocodeQuery regeocodeQuery) {
        return (regeocodeQuery == null || regeocodeQuery.getPoint() == null || regeocodeQuery.getLatLonType() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6304a);
            if (m52748b(regeocodeQuery)) {
                return new ReverseGeocodingHandler(this.f6304a, regeocodeQuery).m53251O();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C2082j4.m52825i(e, "GeocodeSearch", "getFromLocationAsyn");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationAsyn(RegeocodeQuery regeocodeQuery) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2099a(regeocodeQuery));
        } catch (Throwable th) {
            C2082j4.m52825i(th, "GeocodeSearch", "getFromLocationAsyn_threadcreate");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6304a);
            if (geocodeQuery != null) {
                return new GeocodingHandler(this.f6304a, geocodeQuery).m53251O();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C2082j4.m52825i(e, "GeocodeSearch", "getFromLocationName");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationNameAsyn(GeocodeQuery geocodeQuery) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2100b(geocodeQuery));
        } catch (Throwable th) {
            C2082j4.m52825i(th, "GeocodeSearch", "getFromLocationNameAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void setOnGeocodeSearchListener(GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener) {
        this.f6305b = onGeocodeSearchListener;
    }
}
