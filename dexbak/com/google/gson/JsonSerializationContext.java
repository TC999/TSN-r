package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface JsonSerializationContext {
    JsonElement serialize(Object obj);

    JsonElement serialize(Object obj, Type type);
}
