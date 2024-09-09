package com.kwad.components.ad.splashscreen.b;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.p;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public static k CM = new k("splashTimeOutMilliSecond", 5000);
    public static p CN = new p("splashTimerTips", "");
    public static p CO = new p("splashBtnText", "\u70b9\u51fb\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528");
    public static d CP = new d("splashCropNewSwitch", true);
    public static d CQ = new d("splashAdLoadProcessChange", false);
    public static k CR = new k("splashMaterialDownloadTimeMs", 500);

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void init() {
    }
}
