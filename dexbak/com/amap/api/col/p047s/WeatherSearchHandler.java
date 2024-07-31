package com.amap.api.col.p047s;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.amap.api.col.s.f0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class WeatherSearchHandler<T, V> extends BasicLBSRestHandler<T, V> {
    public WeatherSearchHandler(Context context, T t) {
        super(context, t);
    }

    /* renamed from: U */
    public T mo53011U() {
        return this.f5880n;
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public String mo52180h() {
        return C2077i4.m52894b() + "/weather/weatherInfo?";
    }
}
