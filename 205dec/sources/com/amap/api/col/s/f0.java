package com.amap.api.col.s;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: WeatherSearchHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class f0<T, V> extends b4<T, V> {
    public f0(Context context, T t3) {
        super(context, t3);
    }

    public T U() {
        return this.f9630n;
    }

    @Override // com.amap.api.col.s.dz
    public String h() {
        return i4.b() + "/weather/weatherInfo?";
    }
}
