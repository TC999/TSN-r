package com.kwad.sdk.commercial.p381j;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* renamed from: com.kwad.sdk.commercial.j.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9847b extends AbstractC9822a {
    public int aoM;
    public String aoN;
    public String aoO;
    public int aoP;
    public int status;

    /* renamed from: AX */
    public static C9847b m27523AX() {
        return new C9847b();
    }

    @Override // com.kwad.sdk.commercial.p374c.AbstractC9822a
    /* renamed from: bC */
    public final C9847b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    /* renamed from: cM */
    public final C9847b m27521cM(String str) {
        this.aoN = str;
        return this;
    }

    /* renamed from: cN */
    public final C9847b m27520cN(String str) {
        this.aoO = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.p374c.AbstractC9822a
    /* renamed from: cO */
    public final C9847b setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    /* renamed from: cn */
    public final C9847b m27518cn(int i) {
        this.status = i;
        return this;
    }

    /* renamed from: co */
    public final C9847b m27517co(int i) {
        this.aoM = i;
        return this;
    }

    /* renamed from: cp */
    public final C9847b m27516cp(int i) {
        this.aoP = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.p374c.AbstractC9822a
    /* renamed from: cq */
    public final C9847b setErrorCode(int i) {
        super.setErrorCode(i);
        return this;
    }
}
