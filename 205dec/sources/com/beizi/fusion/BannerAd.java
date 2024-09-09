package com.beizi.fusion;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.beizi.fusion.d.d;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BannerAd {

    /* renamed from: a  reason: collision with root package name */
    private d f14395a;

    public BannerAd(Context context, String str, BannerAdListener bannerAdListener, long j4) {
        Log.d("BeiZis", " request BannerAd adUnitId:" + str);
        this.f14395a = new d(context, str, bannerAdListener, j4);
    }

    public void destroy() {
        d dVar = this.f14395a;
        if (dVar != null) {
            dVar.c();
        }
    }

    public int getECPM() {
        d dVar = this.f14395a;
        if (dVar != null) {
            return dVar.b();
        }
        return -1;
    }

    public void loadAd(float f4, float f5, ViewGroup viewGroup) {
        d dVar = this.f14395a;
        if (dVar != null) {
            dVar.a(f4, f5, viewGroup);
        }
    }
}
