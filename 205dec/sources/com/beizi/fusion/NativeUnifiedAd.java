package com.beizi.fusion;

import android.content.Context;
import android.util.Log;
import com.beizi.fusion.d.r;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class NativeUnifiedAd {

    /* renamed from: a  reason: collision with root package name */
    private r f14408a;

    public NativeUnifiedAd(Context context, String str, NativeUnifiedAdListener nativeUnifiedAdListener, long j4, int i4) {
        Log.d("BeiZis", " request NativeUnifiedAd adUnitId:" + str);
        this.f14408a = new r(context, str, nativeUnifiedAdListener, j4, i4);
    }

    public void destroy() {
        r rVar = this.f14408a;
        if (rVar != null) {
            rVar.C();
        }
    }

    public int getECPM() {
        r rVar = this.f14408a;
        if (rVar != null) {
            return rVar.B();
        }
        return -1;
    }

    public boolean isLoaded() {
        r rVar = this.f14408a;
        if (rVar != null) {
            return rVar.c();
        }
        return false;
    }

    public void loadAd() {
        r rVar = this.f14408a;
        if (rVar != null) {
            rVar.b();
        }
    }

    public void resume() {
        r rVar = this.f14408a;
        if (rVar != null) {
            rVar.D();
        }
    }

    public void setHideAdLogo(boolean z3) {
        r rVar = this.f14408a;
        if (rVar != null) {
            rVar.b(z3);
        }
    }
}
