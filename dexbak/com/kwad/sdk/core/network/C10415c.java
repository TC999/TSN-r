package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;

/* renamed from: com.kwad.sdk.core.network.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10415c {
    public int avq = -1;
    public Exception avr;
    public String avs;
    public int code;

    /* renamed from: DM */
    public final boolean m26112DM() {
        return this.code == 200;
    }

    @NonNull
    public final String toString() {
        return "BaseResponse{code=" + this.code + ", rawCode=" + this.avq + ", rawException=" + this.avr + ", body='" + this.avs + "'}";
    }
}
