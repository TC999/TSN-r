package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface JsonSerializer<T> {
    JsonElement serialize(T t, Type type, JsonSerializationContext jsonSerializationContext);
}
