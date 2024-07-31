package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p047s.C2033cf;
import com.amap.api.col.p047s.MessageHandler;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;
import com.stub.StubApp;

/* renamed from: com.amap.api.col.s.w0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class WeatherSearchCore implements IWeatherSearch {

    /* renamed from: a */
    private Context f6621a;

    /* renamed from: b */
    private WeatherSearchQuery f6622b;

    /* renamed from: c */
    private WeatherSearch.OnWeatherSearchListener f6623c;

    /* renamed from: d */
    private LocalWeatherLiveResult f6624d;

    /* renamed from: e */
    private LocalWeatherForecastResult f6625e;

    /* renamed from: f */
    private Handler f6626f;

    /* compiled from: WeatherSearchCore.java */
    /* renamed from: com.amap.api.col.s.w0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2191a implements Runnable {
        RunnableC2191a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.arg1 = 13;
            Bundle bundle = new Bundle();
            if (WeatherSearchCore.this.f6622b != null) {
                if (WeatherSearchCore.this.f6622b.getType() == 1) {
                    try {
                        try {
                            WeatherSearchCore weatherSearchCore = WeatherSearchCore.this;
                            weatherSearchCore.f6624d = weatherSearchCore.m52373b();
                            bundle.putInt("errorCode", 1000);
                            return;
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                            C2082j4.m52825i(e, "WeatherSearch", "searchWeatherAsyn");
                            return;
                        } catch (Throwable th) {
                            C2082j4.m52825i(th, "WeatherSearch", "searchWeatherAnsyThrowable");
                            return;
                        }
                    } finally {
                        MessageHandler.C2180o c2180o = new MessageHandler.C2180o();
                        obtainMessage.what = 1301;
                        c2180o.f6587b = WeatherSearchCore.this.f6623c;
                        c2180o.f6586a = WeatherSearchCore.this.f6624d;
                        obtainMessage.obj = c2180o;
                        obtainMessage.setData(bundle);
                        WeatherSearchCore.this.f6626f.sendMessage(obtainMessage);
                    }
                } else if (WeatherSearchCore.this.f6622b.getType() == 2) {
                    try {
                        try {
                            WeatherSearchCore weatherSearchCore2 = WeatherSearchCore.this;
                            weatherSearchCore2.f6625e = weatherSearchCore2.m52370e();
                            bundle.putInt("errorCode", 1000);
                            return;
                        } catch (AMapException e2) {
                            bundle.putInt("errorCode", e2.getErrorCode());
                            C2082j4.m52825i(e2, "WeatherSearch", "searchWeatherAsyn");
                            return;
                        } catch (Throwable th2) {
                            C2082j4.m52825i(th2, "WeatherSearch", "searchWeatherAnsyThrowable");
                            return;
                        }
                    } finally {
                        MessageHandler.C2179n c2179n = new MessageHandler.C2179n();
                        obtainMessage.what = 1302;
                        c2179n.f6585b = WeatherSearchCore.this.f6623c;
                        c2179n.f6584a = WeatherSearchCore.this.f6625e;
                        obtainMessage.obj = c2179n;
                        obtainMessage.setData(bundle);
                        WeatherSearchCore.this.f6626f.sendMessage(obtainMessage);
                    }
                } else {
                    return;
                }
            }
            try {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } catch (AMapException e3) {
                C2082j4.m52825i(e3, "WeatherSearch", "searchWeatherAsyn");
            }
        }
    }

    public WeatherSearchCore(Context context) throws AMapException {
        this.f6626f = null;
        C2066h1 m53127a = C2033cf.m53127a(context, C2077i4.m52895a(false));
        if (m53127a.f6148a == C2033cf.EnumC2036c.SuccessCode) {
            this.f6621a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f6626f = MessageHandler.m52418a();
            return;
        }
        String str = m53127a.f6149b;
        throw new AMapException(str, 1, str, m53127a.f6148a.m53102a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public LocalWeatherLiveResult m52373b() throws AMapException {
        ManifestConfig.m52460d(this.f6621a);
        WeatherSearchQuery weatherSearchQuery = this.f6622b;
        if (weatherSearchQuery != null) {
            WeatherLiveHandler weatherLiveHandler = new WeatherLiveHandler(this.f6621a, weatherSearchQuery);
            return LocalWeatherLiveResult.createPagedResult((WeatherSearchQuery) weatherLiveHandler.mo53011U(), weatherLiveHandler.m53251O());
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public LocalWeatherForecastResult m52370e() throws AMapException {
        ManifestConfig.m52460d(this.f6621a);
        WeatherSearchQuery weatherSearchQuery = this.f6622b;
        if (weatherSearchQuery != null) {
            WeatherForecastHandler weatherForecastHandler = new WeatherForecastHandler(this.f6621a, weatherSearchQuery);
            return LocalWeatherForecastResult.createPagedResult((WeatherSearchQuery) weatherForecastHandler.mo53011U(), weatherForecastHandler.m53251O());
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final WeatherSearchQuery getQuery() {
        return this.f6622b;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void searchWeatherAsyn() {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2191a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener onWeatherSearchListener) {
        this.f6623c = onWeatherSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setQuery(WeatherSearchQuery weatherSearchQuery) {
        this.f6622b = weatherSearchQuery;
    }
}
