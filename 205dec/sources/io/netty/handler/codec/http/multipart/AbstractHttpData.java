package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelException;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.AbstractReferenceCounted;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class AbstractHttpData extends AbstractReferenceCounted implements HttpData {
    private boolean completed;
    protected long definedSize;
    private final String name;
    protected long size;
    private static final Pattern STRIP_PATTERN = Pattern.compile("(?:^\\s+|\\s+$|\\n)");
    private static final Pattern REPLACE_PATTERN = Pattern.compile("[\\r\\t]");
    private Charset charset = HttpConstants.DEFAULT_CHARSET;
    private long maxSize = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractHttpData(String str, Charset charset, long j4) {
        if (str != null) {
            String replaceAll = STRIP_PATTERN.matcher(REPLACE_PATTERN.matcher(str).replaceAll(" ")).replaceAll("");
            if (!replaceAll.isEmpty()) {
                this.name = replaceAll;
                if (charset != null) {
                    setCharset(charset);
                }
                this.definedSize = j4;
                return;
            }
            throw new IllegalArgumentException("empty name");
        }
        throw new NullPointerException("name");
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void checkSize(long j4) throws IOException {
        long j5 = this.maxSize;
        if (j5 >= 0 && j4 > j5) {
            throw new IOException("Size exceed allowed maximum capacity");
        }
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        try {
            return getByteBuf();
        } catch (IOException e4) {
            throw new ChannelException(e4);
        }
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        delete();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public long definedLength() {
        return this.definedSize;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public Charset getCharset() {
        return this.charset;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public long getMaxSize() {
        return this.maxSize;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData
    public String getName() {
        return this.name;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean isCompleted() {
        return this.completed;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public long length() {
        return this.size;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setCharset(Charset charset) {
        if (charset != null) {
            this.charset = charset;
            return;
        }
        throw new NullPointerException("charset");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCompleted() {
        this.completed = true;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setMaxSize(long j4) {
        this.maxSize = j4;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public abstract HttpData touch();

    @Override // io.netty.util.ReferenceCounted
    public abstract HttpData touch(Object obj);

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HttpData retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HttpData retain(int i4) {
        super.retain(i4);
        return this;
    }
}
