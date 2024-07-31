package com.kwad.components.p208ad.splashscreen.p277b;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.config.item.C10256d;
import com.kwad.sdk.core.config.item.C10265k;
import com.kwad.sdk.core.config.item.C10271p;

/* renamed from: com.kwad.components.ad.splashscreen.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8363a {

    /* renamed from: CM */
    public static C10265k f27624CM = new C10265k("splashTimeOutMilliSecond", 5000);

    /* renamed from: CN */
    public static C10271p f27625CN = new C10271p("splashTimerTips", "");

    /* renamed from: CO */
    public static C10271p f27626CO = new C10271p("splashBtnText", "点击跳转详情页或第三方应用");

    /* renamed from: CP */
    public static C10256d f27627CP = new C10256d("splashCropNewSwitch", true);

    /* renamed from: CQ */
    public static C10256d f27628CQ = new C10256d("splashAdLoadProcessChange", false);

    /* renamed from: CR */
    public static C10265k f27629CR = new C10265k("splashMaterialDownloadTimeMs", 500);

    @InvokeBy(invokerClass = C10251d.class, methodId = "initConfigList")
    public static void init() {
    }
}
