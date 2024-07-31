package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11028au;
import com.kwad.sdk.utils.C11029av;

@KsJson
/* renamed from: com.kwad.sdk.core.request.model.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10478d extends C10482a {
    public String azF;
    public String azG;
    public int azH;
    public int azI;

    /* renamed from: Fc */
    public static C10478d m25986Fc() {
        C10478d c10478d = new C10478d();
        try {
            Context m24363KO = ServiceProvider.m24363KO();
            c10478d.azF = C11029av.m24031cx(m24363KO);
            c10478d.azG = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24335yt();
            c10478d.azH = C11013ag.m24132ck(m24363KO);
            c10478d.azI = C11013ag.m24131d(m24363KO, C11029av.m24045cA(m24363KO), C11028au.m24066Mq());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return c10478d;
    }

    /* renamed from: Fd */
    public static C10478d m25985Fd() {
        C10478d c10478d = new C10478d();
        c10478d.azH = C11013ag.m24132ck(ServiceProvider.getContext());
        return c10478d;
    }
}
