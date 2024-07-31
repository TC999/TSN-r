package io.netty.util;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface AttributeMap {
    <T> Attribute<T> attr(AttributeKey<T> attributeKey);

    <T> boolean hasAttr(AttributeKey<T> attributeKey);
}
