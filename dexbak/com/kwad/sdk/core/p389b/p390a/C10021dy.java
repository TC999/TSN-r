package com.kwad.sdk.core.p389b.p390a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.config.item.C10260h;
import com.kwad.sdk.core.config.item.C10263j;
import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import com.kwad.sdk.core.response.model.C10492a;
import com.kwad.sdk.core.response.model.SdkConfigData;

/* renamed from: com.kwad.sdk.core.b.a.dy */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10021dy {
    @InvokeBy(invokerClass = C10070ft.class, methodId = "registerHolder")
    /* renamed from: Dz */
    public static void m27040Dz() {
        C10070ft.m26948DA().put(C10263j.C10264a.class, new C10053fc());
        C10070ft.m26948DA().put(C10492a.class, new C10125hu());
        C10070ft.m26948DA().put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new C10054fd());
        C10070ft.m26948DA().put(SdkConfigData.CouponActiveConfig.class, new C9984co());
        C10070ft.m26948DA().put(SdkConfigData.TemplateConfigMap.class, new C10184jz());
        C10070ft.m26948DA().put(C10260h.C10261a.class, new C10049ez());
        C10070ft.m26948DA().put(ActivityInfo.class, new C10050f());
    }
}
