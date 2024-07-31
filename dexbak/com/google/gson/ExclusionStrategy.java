package com.google.gson;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface ExclusionStrategy {
    boolean shouldSkipClass(Class<?> cls);

    boolean shouldSkipField(FieldAttributes fieldAttributes);
}
