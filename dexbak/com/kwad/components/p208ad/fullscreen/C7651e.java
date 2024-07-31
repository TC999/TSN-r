package com.kwad.components.p208ad.fullscreen;

import androidx.annotation.Nullable;
import com.kwad.components.core.p330s.C8941f;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.components.p208ad.reward.monitor.InterfaceC8030a;
import com.kwad.components.p208ad.reward.monitor.RewardLoadCallbackType;
import com.kwad.components.p208ad.reward.monitor.RewardMonitorInfo;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p434g.InterfaceC10761a;
import java.util.List;

/* renamed from: com.kwad.components.ad.fullscreen.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7651e {

    /* renamed from: gv */
    private long f25940gv;

    /* renamed from: gw */
    private KsLoadManager.FullScreenVideoAdListener f25941gw;

    public C7651e(long j, KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.f25940gv = j;
        this.f25941gw = fullScreenVideoAdListener;
    }

    /* renamed from: a */
    public final void m32717a(AdTemplate adTemplate, @Nullable List<KsFullScreenVideoAd> list) {
        C8032c.m31765a(false, adTemplate, (InterfaceC8030a) RewardLoadCallbackType.LOAD_SUCCESS_BEFORE, this.f25940gv, (InterfaceC10761a<RewardMonitorInfo>) null);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 3 && adTemplate != null) {
            adTemplate.mDataLoadTraceElement = C8941f.m29558a(stackTrace[2]);
        }
        KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener = this.f25941gw;
        if (fullScreenVideoAdListener != null) {
            fullScreenVideoAdListener.onFullScreenVideoResult(list);
        }
        C8032c.m31765a(false, adTemplate, (InterfaceC8030a) RewardLoadCallbackType.LOAD_SUCCESS, this.f25940gv, (InterfaceC10761a<RewardMonitorInfo>) null);
    }

    /* renamed from: b */
    public final void m32716b(AdTemplate adTemplate, @Nullable List<KsFullScreenVideoAd> list) {
        C8032c.m31765a(false, adTemplate, (InterfaceC8030a) RewardLoadCallbackType.LOAD_CACHE_SUCCESS_BEFORE, this.f25940gv, (InterfaceC10761a<RewardMonitorInfo>) null);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 3 && adTemplate != null) {
            adTemplate.mDataCacheTraceElement = C8941f.m29558a(stackTrace[2]);
        }
        KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener = this.f25941gw;
        if (fullScreenVideoAdListener != null) {
            fullScreenVideoAdListener.onFullScreenVideoAdLoad(list);
        }
        C8032c.m31765a(false, adTemplate, (InterfaceC8030a) RewardLoadCallbackType.LOAD_CACHE_SUCCESS, this.f25940gv, (InterfaceC10761a<RewardMonitorInfo>) null);
    }

    public final void onError(int i, String str) {
        KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener = this.f25941gw;
        if (fullScreenVideoAdListener != null) {
            fullScreenVideoAdListener.onError(i, str);
        }
        C8032c.m31765a(false, (AdTemplate) null, (InterfaceC8030a) RewardLoadCallbackType.LOAD_ERROR, this.f25940gv, (InterfaceC10761a<RewardMonitorInfo>) null);
    }
}
