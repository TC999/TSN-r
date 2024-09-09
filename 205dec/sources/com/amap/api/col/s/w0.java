package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: WeatherSearchCore.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class w0 implements IWeatherSearch {

    /* renamed from: a  reason: collision with root package name */
    private Context f10349a;

    /* renamed from: b  reason: collision with root package name */
    private WeatherSearchQuery f10350b;

    /* renamed from: c  reason: collision with root package name */
    private WeatherSearch.OnWeatherSearchListener f10351c;

    /* renamed from: d  reason: collision with root package name */
    private LocalWeatherLiveResult f10352d;

    /* renamed from: e  reason: collision with root package name */
    private LocalWeatherForecastResult f10353e;

    /* renamed from: f  reason: collision with root package name */
    private Handler f10354f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: WeatherSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.arg1 = 13;
            Bundle bundle = new Bundle();
            if (w0.this.f10350b != null) {
                if (w0.this.f10350b.getType() == 1) {
                    try {
                        try {
                            w0 w0Var = w0.this;
                            w0Var.f10352d = w0Var.b();
                            bundle.putInt("errorCode", 1000);
                            return;
                        } catch (AMapException e4) {
                            bundle.putInt("errorCode", e4.getErrorCode());
                            j4.i(e4, "WeatherSearch", "searchWeatherAsyn");
                            return;
                        } catch (Throwable th) {
                            j4.i(th, "WeatherSearch", "searchWeatherAnsyThrowable");
                            return;
                        }
                    } finally {
                        u4.o oVar = new u4.o();
                        obtainMessage.what = 1301;
                        oVar.f10315b = w0.this.f10351c;
                        oVar.f10314a = w0.this.f10352d;
                        obtainMessage.obj = oVar;
                        obtainMessage.setData(bundle);
                        w0.this.f10354f.sendMessage(obtainMessage);
                    }
                } else if (w0.this.f10350b.getType() == 2) {
                    try {
                        try {
                            w0 w0Var2 = w0.this;
                            w0Var2.f10353e = w0Var2.e();
                            bundle.putInt("errorCode", 1000);
                            return;
                        } catch (AMapException e5) {
                            bundle.putInt("errorCode", e5.getErrorCode());
                            j4.i(e5, "WeatherSearch", "searchWeatherAsyn");
                            return;
                        } catch (Throwable th2) {
                            j4.i(th2, "WeatherSearch", "searchWeatherAnsyThrowable");
                            return;
                        }
                    } finally {
                        u4.n nVar = new u4.n();
                        obtainMessage.what = 1302;
                        nVar.f10313b = w0.this.f10351c;
                        nVar.f10312a = w0.this.f10353e;
                        obtainMessage.obj = nVar;
                        obtainMessage.setData(bundle);
                        w0.this.f10354f.sendMessage(obtainMessage);
                    }
                } else {
                    return;
                }
            }
            try {
                throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
            } catch (AMapException e6) {
                j4.i(e6, "WeatherSearch", "searchWeatherAsyn");
            }
        }
    }

    public w0(Context context) throws AMapException {
        this.f10354f = null;
        h1 a4 = cf.a(context, i4.a(false));
        if (a4.f9876a == cf.c.SuccessCode) {
            this.f10349a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f10354f = u4.a();
            return;
        }
        String str = a4.f9877b;
        throw new AMapException(str, 1, str, a4.f9876a.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocalWeatherLiveResult b() throws AMapException {
        s4.d(this.f10349a);
        WeatherSearchQuery weatherSearchQuery = this.f10350b;
        if (weatherSearchQuery != null) {
            e0 e0Var = new e0(this.f10349a, weatherSearchQuery);
            return LocalWeatherLiveResult.createPagedResult((WeatherSearchQuery) e0Var.U(), e0Var.O());
        }
        throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocalWeatherForecastResult e() throws AMapException {
        s4.d(this.f10349a);
        WeatherSearchQuery weatherSearchQuery = this.f10350b;
        if (weatherSearchQuery != null) {
            d0 d0Var = new d0(this.f10349a, weatherSearchQuery);
            return LocalWeatherForecastResult.createPagedResult((WeatherSearchQuery) d0Var.U(), d0Var.O());
        }
        throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final WeatherSearchQuery getQuery() {
        return this.f10350b;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void searchWeatherAsyn() {
        try {
            y.a().b(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener onWeatherSearchListener) {
        this.f10351c = onWeatherSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setQuery(WeatherSearchQuery weatherSearchQuery) {
        this.f10350b = weatherSearchQuery;
    }
}
