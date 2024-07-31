package io.netty.handler.codec.http.multipart;

import io.netty.util.ReferenceCounted;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceHttpData extends Comparable<InterfaceHttpData>, ReferenceCounted {

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum HttpDataType {
        Attribute,
        FileUpload,
        InternalAttribute
    }

    HttpDataType getHttpDataType();

    String getName();

    InterfaceHttpData retain();

    InterfaceHttpData retain(int i);

    InterfaceHttpData touch();

    InterfaceHttpData touch(Object obj);
}
