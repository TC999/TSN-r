package com.kwad.components.ad.reward.g;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.monitor.RewardLoadCallbackType;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.kwad.components.core.s.f;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    private long gv;
    private KsLoadManager.RewardVideoAdListener rL;

    public c(long j4, KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        this.gv = j4;
        this.rL = rewardVideoAdListener;
    }

    public final void c(AdTemplate adTemplate, @Nullable List<KsRewardVideoAd> list) {
        com.kwad.components.ad.reward.monitor.c.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_SUCCESS_BEFORE, this.gv, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 3 && adTemplate != null) {
            adTemplate.mDataLoadTraceElement = f.a(stackTrace[2]);
        }
        KsLoadManager.RewardVideoAdListener rewardVideoAdListener = this.rL;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onRewardVideoResult(list);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_SUCCESS, this.gv, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    public final void d(AdTemplate adTemplate, @Nullable List<KsRewardVideoAd> list) {
        com.kwad.components.ad.reward.monitor.c.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_CACHE_SUCCESS_BEFORE, this.gv, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 3 && adTemplate != null) {
            adTemplate.mDataCacheTraceElement = f.a(stackTrace[2]);
        }
        KsLoadManager.RewardVideoAdListener rewardVideoAdListener = this.rL;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onRewardVideoAdLoad(list);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_CACHE_SUCCESS, this.gv, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    public final void onError(int i4, String str) {
        KsLoadManager.RewardVideoAdListener rewardVideoAdListener = this.rL;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onError(i4, str);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (AdTemplate) null, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_ERROR, this.gv, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }
}
