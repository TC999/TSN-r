package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface HttpData extends InterfaceHttpData, ByteBufHolder {
    void addContent(ByteBuf byteBuf, boolean z3) throws IOException;

    void checkSize(long j4) throws IOException;

    HttpData copy();

    long definedLength();

    void delete();

    HttpData duplicate();

    byte[] get() throws IOException;

    ByteBuf getByteBuf() throws IOException;

    Charset getCharset();

    ByteBuf getChunk(int i4) throws IOException;

    File getFile() throws IOException;

    long getMaxSize();

    String getString() throws IOException;

    String getString(Charset charset) throws IOException;

    boolean isCompleted();

    boolean isInMemory();

    long length();

    boolean renameTo(File file) throws IOException;

    HttpData replace(ByteBuf byteBuf);

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData, io.netty.util.ReferenceCounted
    HttpData retain();

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData, io.netty.util.ReferenceCounted
    HttpData retain(int i4);

    HttpData retainedDuplicate();

    void setCharset(Charset charset);

    void setContent(ByteBuf byteBuf) throws IOException;

    void setContent(File file) throws IOException;

    void setContent(InputStream inputStream) throws IOException;

    void setMaxSize(long j4);

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData, io.netty.util.ReferenceCounted
    HttpData touch();

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData, io.netty.util.ReferenceCounted
    HttpData touch(Object obj);
}
