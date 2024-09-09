package com.kwai.adclient.kscommerciallogger.snapshot;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str) {
        super(str, 0);
    }

    @Override // com.kwai.adclient.kscommerciallogger.snapshot.c
    public final synchronized d hn(String str) {
        return new b("empty");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kwai.adclient.kscommerciallogger.snapshot.c
    public final JSONObject ho(String str) {
        return new JSONObject();
    }
}
