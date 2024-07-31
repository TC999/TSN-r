package com.kwad.components.p208ad.reward.p254g;

import androidx.annotation.Nullable;
import com.kwad.components.core.p330s.C8941f;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.components.p208ad.reward.monitor.InterfaceC8030a;
import com.kwad.components.p208ad.reward.monitor.RewardLoadCallbackType;
import com.kwad.components.p208ad.reward.monitor.RewardMonitorInfo;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p434g.InterfaceC10761a;
import java.util.List;

/* renamed from: com.kwad.components.ad.reward.g.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7930c {

    /* renamed from: gv */
    private long f26620gv;

    /* renamed from: rL */
    private KsLoadManager.RewardVideoAdListener f26621rL;

    public C7930c(long j, KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        this.f26620gv = j;
        this.f26621rL = rewardVideoAdListener;
    }

    /* renamed from: c */
    public final void m31978c(AdTemplate adTemplate, @Nullable List<KsRewardVideoAd> list) {
        C8032c.m31765a(true, adTemplate, (InterfaceC8030a) RewardLoadCallbackType.LOAD_SUCCESS_BEFORE, this.f26620gv, (InterfaceC10761a<RewardMonitorInfo>) null);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 3 && adTemplate != null) {
            adTemplate.mDataLoadTraceElement = C8941f.m29558a(stackTrace[2]);
        }
        KsLoadManager.RewardVideoAdListener rewardVideoAdListener = this.f26621rL;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onRewardVideoResult(list);
        }
        C8032c.m31765a(true, adTemplate, (InterfaceC8030a) RewardLoadCallbackType.LOAD_SUCCESS, this.f26620gv, (InterfaceC10761a<RewardMonitorInfo>) null);
    }

    /* renamed from: d */
    public final void m31977d(AdTemplate adTemplate, @Nullable List<KsRewardVideoAd> list) {
        C8032c.m31765a(true, adTemplate, (InterfaceC8030a) RewardLoadCallbackType.LOAD_CACHE_SUCCESS_BEFORE, this.f26620gv, (InterfaceC10761a<RewardMonitorInfo>) null);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 3 && adTemplate != null) {
            adTemplate.mDataCacheTraceElement = C8941f.m29558a(stackTrace[2]);
        }
        KsLoadManager.RewardVideoAdListener rewardVideoAdListener = this.f26621rL;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onRewardVideoAdLoad(list);
        }
        C8032c.m31765a(true, adTemplate, (InterfaceC8030a) RewardLoadCallbackType.LOAD_CACHE_SUCCESS, this.f26620gv, (InterfaceC10761a<RewardMonitorInfo>) null);
    }

    public final void onError(int i, String str) {
        KsLoadManager.RewardVideoAdListener rewardVideoAdListener = this.f26621rL;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onError(i, str);
        }
        C8032c.m31765a(true, (AdTemplate) null, (InterfaceC8030a) RewardLoadCallbackType.LOAD_ERROR, this.f26620gv, (InterfaceC10761a<RewardMonitorInfo>) null);
    }
}
