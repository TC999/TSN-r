package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.beizi.fusion.d.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class InterstitialAd {

    /* renamed from: a  reason: collision with root package name */
    private l f14404a;

    public InterstitialAd(Context context, String str, InterstitialAdListener interstitialAdListener, long j4) {
        this.f14404a = new l(context, str, interstitialAdListener, j4, 0);
    }

    public void destroy() {
        l lVar = this.f14404a;
        if (lVar != null) {
            lVar.C();
        }
    }

    public int getECPM() {
        l lVar = this.f14404a;
        if (lVar != null) {
            return lVar.B();
        }
        return -1;
    }

    public boolean isLoaded() {
        l lVar = this.f14404a;
        if (lVar != null) {
            return lVar.b();
        }
        return false;
    }

    public void loadAd() {
        l lVar = this.f14404a;
        if (lVar != null) {
            lVar.c();
        }
    }

    public void setAdVersion(int i4) {
        l lVar = this.f14404a;
        if (lVar != null) {
            lVar.b(i4);
        }
    }

    public void showAd(@NonNull Activity activity) {
        l lVar = this.f14404a;
        if (lVar != null) {
            lVar.a(activity);
        }
    }

    public InterstitialAd(Context context, String str, InterstitialAdListener interstitialAdListener, long j4, int i4) {
        Log.d("BeiZis", " request InterstitialAd adUnitId:" + str);
        this.f14404a = new l(context, str, interstitialAdListener, j4, i4);
    }
}
