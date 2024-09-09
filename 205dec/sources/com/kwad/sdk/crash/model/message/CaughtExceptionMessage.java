package com.kwad.sdk.crash.model.message;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class CaughtExceptionMessage extends JavaExceptionMessage implements Serializable {
    private static final long serialVersionUID = -4220068453451250185L;

    @Override // com.kwad.sdk.crash.model.message.JavaExceptionMessage, com.kwad.sdk.crash.model.message.ExceptionMessage
    protected final String getTypePrefix() {
        return "CAUGHT_";
    }
}
