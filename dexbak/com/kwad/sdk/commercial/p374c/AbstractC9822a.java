package com.kwad.sdk.commercial.p374c;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.C9825d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.response.p409b.C10487e;

@KsJson
/* renamed from: com.kwad.sdk.commercial.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC9822a extends C10482a {
    public long creativeId;
    public int errorCode;
    public String errorMsg;
    public long llsid;
    public long posId;
    public String templateId;
    public String templateVersion;

    public AbstractC9822a setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return this;
        }
        this.creativeId = C10487e.m25631ea(adTemplate);
        this.llsid = C10487e.m25644dN(adTemplate);
        this.posId = C10487e.m25648dJ(adTemplate);
        AdMatrixInfo.MatrixTemplate m27623aT = C9825d.m27623aT(adTemplate);
        if (m27623aT != null) {
            this.templateId = m27623aT.templateId;
            this.templateVersion = m27623aT.templateVersion;
        }
        return this;
    }

    public AbstractC9822a setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }

    public AbstractC9822a setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public AbstractC9822a setLlsid(long j) {
        this.llsid = j;
        return this;
    }

    public AbstractC9822a setPosId(long j) {
        this.posId = j;
        return this;
    }
}
