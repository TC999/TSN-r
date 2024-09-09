package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.beizi.fusion.d.j;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FullScreenVideoAd {

    /* renamed from: a  reason: collision with root package name */
    private j f14403a;

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener, long j4) {
        Log.d("BeiZis", " request FullScreenVideoAd adUnitId:" + str);
        this.f14403a = new j(context, str, fullScreenVideoAdListener, j4);
    }

    public void destroy() {
        j jVar = this.f14403a;
        if (jVar != null) {
            jVar.C();
        }
    }

    public int getECPM() {
        j jVar = this.f14403a;
        if (jVar != null) {
            return jVar.B();
        }
        return -1;
    }

    public boolean isLoaded() {
        j jVar = this.f14403a;
        if (jVar != null) {
            return jVar.b();
        }
        return false;
    }

    public void loadAd() {
        j jVar = this.f14403a;
        if (jVar != null) {
            jVar.c();
        }
    }

    public void setAdVersion(int i4) {
        j jVar = this.f14403a;
        if (jVar != null) {
            jVar.b(i4);
        }
    }

    public void showAd(@NonNull Activity activity) {
        j jVar = this.f14403a;
        if (jVar != null) {
            jVar.a(activity);
        }
    }
}
