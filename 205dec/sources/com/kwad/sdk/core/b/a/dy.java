package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import com.kwad.sdk.core.config.item.h;
import com.kwad.sdk.core.config.item.j;
import com.kwad.sdk.core.response.model.SdkConfigData;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class dy {
    @InvokeBy(invokerClass = ft.class, methodId = "registerHolder")
    public static void Dz() {
        ft.DA().put(j.a.class, new fc());
        ft.DA().put(com.kwad.sdk.core.response.model.a.class, new hu());
        ft.DA().put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new fd());
        ft.DA().put(SdkConfigData.CouponActiveConfig.class, new co());
        ft.DA().put(SdkConfigData.TemplateConfigMap.class, new jz());
        ft.DA().put(h.a.class, new ez());
        ft.DA().put(ActivityInfo.class, new f());
    }
}
