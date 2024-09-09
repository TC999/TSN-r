package com.beizi.fusion;

import android.content.Context;
import android.util.Log;
import com.beizi.fusion.d.o;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class NativeAd {

    /* renamed from: a  reason: collision with root package name */
    private o f14405a;

    public NativeAd(Context context, String str, NativeAdListener nativeAdListener, long j4, int i4) {
        Log.d("BeiZis", " request NativeAd adUnitId:" + str);
        this.f14405a = new o(context, str, nativeAdListener, j4, i4);
    }

    public void destroy() {
        o oVar = this.f14405a;
        if (oVar != null) {
            oVar.c();
        }
    }

    public int getECPM() {
        o oVar = this.f14405a;
        if (oVar != null) {
            return oVar.b();
        }
        return -1;
    }

    public void loadAd(float f4, float f5) {
        o oVar = this.f14405a;
        if (oVar != null) {
            oVar.a(f4, f5);
        }
    }

    public void resume() {
        o oVar = this.f14405a;
        if (oVar != null) {
            oVar.B();
        }
    }
}
