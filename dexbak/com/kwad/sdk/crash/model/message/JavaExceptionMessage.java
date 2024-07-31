package com.kwad.sdk.crash.model.message;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class JavaExceptionMessage extends ExceptionMessage {
    private static final long serialVersionUID = -2410125079234148135L;

    public JavaExceptionMessage() {
        this.mExceptionType = 1;
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    protected String getTypePrefix() {
        return "";
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.InterfaceC9914b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.InterfaceC9914b
    public JSONObject toJson() {
        return super.toJson();
    }
}
