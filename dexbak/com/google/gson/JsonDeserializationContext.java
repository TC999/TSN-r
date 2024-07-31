package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface JsonDeserializationContext {
    <T> T deserialize(JsonElement jsonElement, Type type) throws JsonParseException;
}
