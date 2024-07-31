package com.kwad.sdk.core.p389b.p390a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.p208ad.splashscreen.SplashPreloadManager;
import com.kwad.components.p208ad.splashscreen.local.C8493a;
import com.kwad.components.p208ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.p208ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.p208ad.splashscreen.monitor.SplashWebMonitorInfo;

/* renamed from: com.kwad.sdk.core.b.a.ck */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9980ck {
    @InvokeBy(invokerClass = C10070ft.class, methodId = "registerHolder")
    /* renamed from: Dz */
    public static void m27118Dz() {
        C10070ft.m26948DA().put(C8493a.class, new C10162jd());
        C10070ft.m26948DA().put(SplashSkipViewModel.class, new C10167ji());
        C10070ft.m26948DA().put(SplashPreloadManager.PreLoadItem.class, new C10127hw());
        C10070ft.m26948DA().put(SplashMonitorInfo.class, new C10163je());
        C10070ft.m26948DA().put(SplashWebMonitorInfo.class, new C10170jl());
    }
}
