package com.kwad.sdk.commercial.p376e;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* renamed from: com.kwad.sdk.commercial.e.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9831b extends AbstractC9822a {
    public String aoA;
    public String aoB;

    /* renamed from: AN */
    public static C9831b m27576AN() {
        return new C9831b();
    }

    @Override // com.kwad.sdk.commercial.p374c.AbstractC9822a
    /* renamed from: bB */
    public final C9831b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    /* renamed from: cB */
    public final C9831b m27574cB(String str) {
        this.aoA = str;
        return this;
    }

    /* renamed from: cC */
    public final C9831b m27573cC(String str) {
        this.aoB = str;
        return this;
    }
}
