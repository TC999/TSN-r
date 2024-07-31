package com.kwad.sdk.core.report;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.response.p409b.C10487e;

@KsJson
/* renamed from: com.kwad.sdk.core.report.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10458h extends C10482a {
    public int axF;
    public long creativeId;
    public long llsid;
    public int score;
    public String source = "union";

    /* renamed from: bW */
    public static C10458h m26022bW(AdTemplate adTemplate) {
        C10458h c10458h = new C10458h();
        c10458h.creativeId = C10487e.m25631ea(adTemplate);
        c10458h.llsid = C10487e.m25644dN(adTemplate);
        int m25627ee = C10487e.m25627ee(adTemplate);
        c10458h.score = m25627ee;
        c10458h.axF = m25627ee > 0 ? 1 : 0;
        return c10458h;
    }

    /* renamed from: EL */
    public final String m26023EL() {
        return toJson().toString();
    }
}
