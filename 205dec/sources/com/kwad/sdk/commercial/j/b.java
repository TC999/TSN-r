package com.kwad.sdk.commercial.j;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int aoM;
    public String aoN;
    public String aoO;
    public int aoP;
    public int status;

    public static b AX() {
        return new b();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bC */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b cM(String str) {
        this.aoN = str;
        return this;
    }

    public final b cN(String str) {
        this.aoO = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cO */
    public final b setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    public final b cn(int i4) {
        this.status = i4;
        return this;
    }

    public final b co(int i4) {
        this.aoM = i4;
        return this;
    }

    public final b cp(int i4) {
        this.aoP = i4;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cq */
    public final b setErrorCode(int i4) {
        super.setErrorCode(i4);
        return this;
    }
}
