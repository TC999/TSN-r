package com.kwad.sdk.core.adlog.p387b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* renamed from: com.kwad.sdk.core.adlog.b.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9907d extends AbstractC9822a {
    public int aoM;
    public String aoO;
    public int apG;
    public int retryCount;
    public int status;

    /* renamed from: Bq */
    public static C9907d m27364Bq() {
        return new C9907d();
    }

    @Override // com.kwad.sdk.commercial.p374c.AbstractC9822a
    /* renamed from: bT */
    public final C9907d setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    /* renamed from: cA */
    public final C9907d m27362cA(int i) {
        this.apG = 1;
        return this;
    }

    /* renamed from: cB */
    public final C9907d m27361cB(int i) {
        this.retryCount = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.p374c.AbstractC9822a
    /* renamed from: cC */
    public final C9907d setErrorCode(int i) {
        super.setErrorCode(i);
        return this;
    }

    /* renamed from: cy */
    public final C9907d m27359cy(int i) {
        this.status = i;
        return this;
    }

    /* renamed from: cz */
    public final C9907d m27358cz(int i) {
        this.aoM = i;
        return this;
    }

    /* renamed from: da */
    public final C9907d m27357da(String str) {
        this.aoO = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.p374c.AbstractC9822a
    /* renamed from: db */
    public final C9907d setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }
}
