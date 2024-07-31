package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.beizi.fusion.p066d.FullScreenVideoManager;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FullScreenVideoAd {

    /* renamed from: a */
    private FullScreenVideoManager f10838a;

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener, long j) {
        Log.d("BeiZis", " request FullScreenVideoAd adUnitId:" + str);
        this.f10838a = new FullScreenVideoManager(context, str, fullScreenVideoAdListener, j);
    }

    public void destroy() {
        FullScreenVideoManager fullScreenVideoManager = this.f10838a;
        if (fullScreenVideoManager != null) {
            fullScreenVideoManager.m48643C();
        }
    }

    public int getECPM() {
        FullScreenVideoManager fullScreenVideoManager = this.f10838a;
        if (fullScreenVideoManager != null) {
            return fullScreenVideoManager.m48644B();
        }
        return -1;
    }

    public boolean isLoaded() {
        FullScreenVideoManager fullScreenVideoManager = this.f10838a;
        if (fullScreenVideoManager != null) {
            return fullScreenVideoManager.m48641b();
        }
        return false;
    }

    public void loadAd() {
        FullScreenVideoManager fullScreenVideoManager = this.f10838a;
        if (fullScreenVideoManager != null) {
            fullScreenVideoManager.m48639c();
        }
    }

    public void setAdVersion(int i) {
        FullScreenVideoManager fullScreenVideoManager = this.f10838a;
        if (fullScreenVideoManager != null) {
            fullScreenVideoManager.m48640b(i);
        }
    }

    public void showAd(@NonNull Activity activity) {
        FullScreenVideoManager fullScreenVideoManager = this.f10838a;
        if (fullScreenVideoManager != null) {
            fullScreenVideoManager.m48642a(activity);
        }
    }
}
