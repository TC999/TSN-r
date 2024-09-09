package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.WeatherSearchQuery;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: WeatherLiveHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e0 extends f0<WeatherSearchQuery, LocalWeatherLive> {

    /* renamed from: t  reason: collision with root package name */
    private LocalWeatherLive f9810t;

    public e0(Context context, WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
        this.f9810t = new LocalWeatherLive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    /* renamed from: V */
    public LocalWeatherLive I(String str) throws AMapException {
        LocalWeatherLive l02 = r4.l0(str);
        this.f9810t = l02;
        return l02;
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String city = ((WeatherSearchQuery) this.f9630n).getCity();
        if (!r4.s0(city)) {
            String i4 = b4.i(city);
            stringBuffer.append("&city=");
            stringBuffer.append(i4);
        }
        stringBuffer.append("&extensions=base");
        stringBuffer.append("&key=" + x0.i(this.f9633q));
        return stringBuffer.toString();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.amap.api.services.weather.WeatherSearchQuery] */
    @Override // com.amap.api.col.s.f0
    public final /* bridge */ /* synthetic */ WeatherSearchQuery U() {
        return super.U();
    }

    @Override // com.amap.api.col.s.f0, com.amap.api.col.s.dz
    public final /* bridge */ /* synthetic */ String h() {
        return super.h();
    }
}
