package com.kwad.components.ad.d;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.config.item.p;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public static p bJ = new p("kwaiLogoUrl", null);
    public static p bK = new p("attentionTips", "\u53bb\u5173\u6ce8TA");
    public static p bL = new p("viewHomeTips", "\u67e5\u770bTA\u7684\u4e3b\u9875");
    public static p bM = new p("buyNowTips", "\u7acb\u5373\u62a2\u8d2d");

    @InvokeBy(invokerClass = d.class, methodId = "initConfigList")
    public static void init() {
    }
}
