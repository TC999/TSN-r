package xyz.adscope.common.network;

import java.io.OutputStream;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface Content {
    long contentLength();

    String contentType();

    void writeTo(OutputStream outputStream);
}
