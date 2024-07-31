package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.beizi.fusion.p066d.RewardedVideoManager;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RewardedVideoAd {

    /* renamed from: a */
    private RewardedVideoManager f10846a;

    /* renamed from: b */
    private String f10847b;

    /* renamed from: c */
    private String f10848c;

    public RewardedVideoAd(Context context, String str, RewardedVideoAdListener rewardedVideoAdListener, long j, int i) {
        Log.d("BeiZis", " request RewardedVideoAd adUnitId:" + str);
        this.f10846a = new RewardedVideoManager(context, str, rewardedVideoAdListener, j, i);
    }

    public void destroy() {
        RewardedVideoManager rewardedVideoManager = this.f10846a;
        if (rewardedVideoManager != null) {
            rewardedVideoManager.m48607E();
        }
    }

    public int getECPM() {
        RewardedVideoManager rewardedVideoManager = this.f10846a;
        if (rewardedVideoManager != null) {
            return rewardedVideoManager.m48608D();
        }
        return -1;
    }

    public String getExtra() {
        return this.f10848c;
    }

    public String getUserId() {
        return this.f10847b;
    }

    public boolean isLoaded() {
        RewardedVideoManager rewardedVideoManager = this.f10846a;
        if (rewardedVideoManager != null) {
            return rewardedVideoManager.m48610B();
        }
        return false;
    }

    public void loadAd() {
        RewardedVideoManager rewardedVideoManager = this.f10846a;
        if (rewardedVideoManager != null) {
            rewardedVideoManager.m48609C();
        }
    }

    public void setExtra(String str) {
        RewardedVideoManager rewardedVideoManager = this.f10846a;
        if (rewardedVideoManager != null) {
            rewardedVideoManager.m48602h(str);
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        RewardedVideoManager rewardedVideoManager = this.f10846a;
        if (rewardedVideoManager != null) {
            rewardedVideoManager.m48750a(rewardedVideoAdListener);
        }
    }

    public void setUserId(String str) {
        RewardedVideoManager rewardedVideoManager = this.f10846a;
        if (rewardedVideoManager != null) {
            rewardedVideoManager.m48603g(str);
        }
    }

    public void showAd(@NonNull Activity activity) {
        RewardedVideoManager rewardedVideoManager = this.f10846a;
        if (rewardedVideoManager != null) {
            rewardedVideoManager.m48606a(activity);
        }
    }
}
