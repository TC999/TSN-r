package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.WeatherSearchQuery;

/* renamed from: com.amap.api.col.s.e0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class WeatherLiveHandler extends WeatherSearchHandler<WeatherSearchQuery, LocalWeatherLive> {

    /* renamed from: t */
    private LocalWeatherLive f6082t;

    public WeatherLiveHandler(Context context, WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
        this.f6082t = new LocalWeatherLive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: V */
    public LocalWeatherLive mo52183I(String str) throws AMapException {
        LocalWeatherLive m52503l0 = JSONHelper.m52503l0(str);
        this.f6082t = m52503l0;
        return m52503l0;
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String city = ((WeatherSearchQuery) this.f5880n).getCity();
        if (!JSONHelper.m52489s0(city)) {
            String m53218i = BasicLBSRestHandler.m53218i(city);
            stringBuffer.append("&city=");
            stringBuffer.append(m53218i);
        }
        stringBuffer.append("&extensions=base");
        stringBuffer.append("&key=" + C2199x0.m52327i(this.f5883q));
        return stringBuffer.toString();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.amap.api.services.weather.WeatherSearchQuery] */
    @Override // com.amap.api.col.p047s.WeatherSearchHandler
    /* renamed from: U */
    public final /* bridge */ /* synthetic */ WeatherSearchQuery mo53011U() {
        return super.mo53011U();
    }

    @Override // com.amap.api.col.p047s.WeatherSearchHandler, com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final /* bridge */ /* synthetic */ String mo52180h() {
        return super.mo52180h();
    }
}
