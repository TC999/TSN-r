package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: GeocodeSearchCore.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class n0 implements IGeocodeSearch {

    /* renamed from: a  reason: collision with root package name */
    private Context f10032a;

    /* renamed from: b  reason: collision with root package name */
    private GeocodeSearch.OnGeocodeSearchListener f10033b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f10034c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GeocodeSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RegeocodeQuery f10035a;

        a(RegeocodeQuery regeocodeQuery) {
            this.f10035a = regeocodeQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 2;
                    obtainMessage.what = 201;
                    u4.l lVar = new u4.l();
                    lVar.f10309b = n0.this.f10033b;
                    obtainMessage.obj = lVar;
                    lVar.f10308a = new RegeocodeResult(this.f10035a, n0.this.getFromLocation(this.f10035a));
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e4) {
                    obtainMessage.arg2 = e4.getErrorCode();
                }
            } finally {
                n0.this.f10034c.sendMessage(obtainMessage);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GeocodeSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GeocodeQuery f10037a;

        b(GeocodeQuery geocodeQuery) {
            this.f10037a = geocodeQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            try {
                try {
                    obtainMessage.what = 200;
                    obtainMessage.arg1 = 2;
                    obtainMessage.arg2 = 1000;
                    u4.f fVar = new u4.f();
                    fVar.f10297b = n0.this.f10033b;
                    obtainMessage.obj = fVar;
                    fVar.f10296a = new GeocodeResult(this.f10037a, n0.this.getFromLocationName(this.f10037a));
                } catch (AMapException e4) {
                    obtainMessage.arg2 = e4.getErrorCode();
                }
            } finally {
                n0.this.f10034c.sendMessage(obtainMessage);
            }
        }
    }

    public n0(Context context) throws AMapException {
        h1 a4 = cf.a(context, i4.a(false));
        if (a4.f9876a == cf.c.SuccessCode) {
            this.f10032a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f10034c = u4.a();
            return;
        }
        String str = a4.f9877b;
        throw new AMapException(str, 1, str, a4.f9876a.a());
    }

    private static boolean b(RegeocodeQuery regeocodeQuery) {
        return (regeocodeQuery == null || regeocodeQuery.getPoint() == null || regeocodeQuery.getLatLonType() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) throws AMapException {
        try {
            s4.d(this.f10032a);
            if (b(regeocodeQuery)) {
                return new r(this.f10032a, regeocodeQuery).O();
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (AMapException e4) {
            j4.i(e4, "GeocodeSearch", "getFromLocationAsyn");
            throw e4;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationAsyn(RegeocodeQuery regeocodeQuery) {
        try {
            y.a().b(new a(regeocodeQuery));
        } catch (Throwable th) {
            j4.i(th, "GeocodeSearch", "getFromLocationAsyn_threadcreate");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException {
        try {
            s4.d(this.f10032a);
            if (geocodeQuery != null) {
                return new p4(this.f10032a, geocodeQuery).O();
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (AMapException e4) {
            j4.i(e4, "GeocodeSearch", "getFromLocationName");
            throw e4;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationNameAsyn(GeocodeQuery geocodeQuery) {
        try {
            y.a().b(new b(geocodeQuery));
        } catch (Throwable th) {
            j4.i(th, "GeocodeSearch", "getFromLocationNameAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void setOnGeocodeSearchListener(GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener) {
        this.f10033b = onGeocodeSearchListener;
    }
}
