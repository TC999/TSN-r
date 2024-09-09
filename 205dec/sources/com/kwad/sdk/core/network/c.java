package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    public int avq = -1;
    public Exception avr;
    public String avs;
    public int code;

    public final boolean DM() {
        return this.code == 200;
    }

    @NonNull
    public final String toString() {
        return "BaseResponse{code=" + this.code + ", rawCode=" + this.avq + ", rawException=" + this.avr + ", body='" + this.avs + "'}";
    }
}
