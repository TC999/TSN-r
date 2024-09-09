package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.splashscreen.SplashPreloadManager;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.ad.splashscreen.monitor.SplashWebMonitorInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ck {
    @InvokeBy(invokerClass = ft.class, methodId = "registerHolder")
    public static void Dz() {
        ft.DA().put(com.kwad.components.ad.splashscreen.local.a.class, new jd());
        ft.DA().put(SplashSkipViewModel.class, new ji());
        ft.DA().put(SplashPreloadManager.PreLoadItem.class, new hw());
        ft.DA().put(SplashMonitorInfo.class, new je());
        ft.DA().put(SplashWebMonitorInfo.class, new jl());
    }
}
