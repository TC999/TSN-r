package com.google.gson;

import java.lang.reflect.Type;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface JsonSerializer<T> {
    JsonElement serialize(T t3, Type type, JsonSerializationContext jsonSerializationContext);
}
