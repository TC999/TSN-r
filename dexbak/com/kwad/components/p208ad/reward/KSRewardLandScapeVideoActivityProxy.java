package com.kwad.components.p208ad.reward;

import androidx.annotation.Keep;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.service.C10973b;

@KsAdSdkDynamicImpl(KSRewardLandScapeVideoActivity.class)
@Keep
/* renamed from: com.kwad.components.ad.reward.KSRewardLandScapeVideoActivityProxy */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KSRewardLandScapeVideoActivityProxy extends KSRewardVideoActivityProxy {
    @InvokeBy(invokerClass = C10973b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        C10973b.m24291a(KSRewardLandScapeVideoActivity.class, KSRewardLandScapeVideoActivityProxy.class);
    }
}
