package com.kwad.sdk.core.adlog.p387b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* renamed from: com.kwad.sdk.core.adlog.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9905b extends AbstractC9822a {
    public int aoM;
    public int apD;
    public int apE;
    public long apF;
    public int apt;
    public String apu;
    public int retryCount;
    public int status;

    /* renamed from: Bp */
    public static C9905b m27382Bp() {
        return new C9905b();
    }

    /* renamed from: ae */
    public final C9905b m27381ae(long j) {
        this.apF = j;
        return this;
    }

    @Override // com.kwad.sdk.commercial.p374c.AbstractC9822a
    /* renamed from: bS */
    public final C9905b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    /* renamed from: cZ */
    public final C9905b m27379cZ(String str) {
        this.apu = str;
        return this;
    }

    /* renamed from: cs */
    public final C9905b m27378cs(int i) {
        this.status = i;
        return this;
    }

    /* renamed from: ct */
    public final C9905b m27377ct(int i) {
        this.aoM = i;
        return this;
    }

    /* renamed from: cu */
    public final C9905b m27376cu(int i) {
        this.retryCount = i;
        return this;
    }

    /* renamed from: cv */
    public final C9905b m27375cv(int i) {
        this.apt = i;
        return this;
    }

    /* renamed from: cw */
    public final C9905b m27374cw(int i) {
        this.apD = i;
        return this;
    }

    /* renamed from: cx */
    public final C9905b m27373cx(int i) {
        this.apE = i;
        return this;
    }
}
