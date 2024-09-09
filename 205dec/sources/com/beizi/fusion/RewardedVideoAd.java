package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.beizi.fusion.d.s;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RewardedVideoAd {

    /* renamed from: a  reason: collision with root package name */
    private s f14410a;

    /* renamed from: b  reason: collision with root package name */
    private String f14411b;

    /* renamed from: c  reason: collision with root package name */
    private String f14412c;

    public RewardedVideoAd(Context context, String str, RewardedVideoAdListener rewardedVideoAdListener, long j4, int i4) {
        Log.d("BeiZis", " request RewardedVideoAd adUnitId:" + str);
        this.f14410a = new s(context, str, rewardedVideoAdListener, j4, i4);
    }

    public void destroy() {
        s sVar = this.f14410a;
        if (sVar != null) {
            sVar.E();
        }
    }

    public int getECPM() {
        s sVar = this.f14410a;
        if (sVar != null) {
            return sVar.D();
        }
        return -1;
    }

    public String getExtra() {
        return this.f14412c;
    }

    public String getUserId() {
        return this.f14411b;
    }

    public boolean isLoaded() {
        s sVar = this.f14410a;
        if (sVar != null) {
            return sVar.B();
        }
        return false;
    }

    public void loadAd() {
        s sVar = this.f14410a;
        if (sVar != null) {
            sVar.C();
        }
    }

    public void setExtra(String str) {
        s sVar = this.f14410a;
        if (sVar != null) {
            sVar.h(str);
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        s sVar = this.f14410a;
        if (sVar != null) {
            sVar.a(rewardedVideoAdListener);
        }
    }

    public void setUserId(String str) {
        s sVar = this.f14410a;
        if (sVar != null) {
            sVar.g(str);
        }
    }

    public void showAd(@NonNull Activity activity) {
        s sVar = this.f14410a;
        if (sVar != null) {
            sVar.a(activity);
        }
    }
}
