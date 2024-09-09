package com.bytedance.sdk.component.xv.c;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface ux extends fz, ReadableByteChannel {
    int a() throws IOException;

    long bk() throws IOException;

    long c(byte b4) throws IOException;

    String c(Charset charset) throws IOException;

    void c(long j4) throws IOException;

    void c(byte[] bArr) throws IOException;

    boolean c(long j4, f fVar) throws IOException;

    byte ev() throws IOException;

    void ev(long j4) throws IOException;

    InputStream f();

    String fp() throws IOException;

    short gd() throws IOException;

    byte[] ia() throws IOException;

    short k() throws IOException;

    int p() throws IOException;

    byte[] r(long j4) throws IOException;

    String ux(long j4) throws IOException;

    boolean ux() throws IOException;

    f xv(long j4) throws IOException;

    @Deprecated
    xv xv();
}
