package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultSpdyHeadersFrame extends DefaultSpdyStreamFrame implements SpdyHeadersFrame {
    private final SpdyHeaders headers;
    private boolean invalid;
    private boolean truncated;

    public DefaultSpdyHeadersFrame(int i4) {
        this(i4, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void appendHeaders(StringBuilder sb) {
        for (Map.Entry<CharSequence, CharSequence> entry : headers()) {
            sb.append("    ");
            sb.append(entry.getKey());
            sb.append(": ");
            sb.append(entry.getValue());
            sb.append(StringUtil.NEWLINE);
        }
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame
    public SpdyHeaders headers() {
        return this.headers;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame
    public boolean isInvalid() {
        return this.invalid;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame
    public boolean isTruncated() {
        return this.truncated;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame
    public SpdyHeadersFrame setInvalid() {
        this.invalid = true;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame
    public SpdyHeadersFrame setTruncated() {
        this.truncated = true;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append("(last: ");
        sb.append(isLast());
        sb.append(')');
        String str = StringUtil.NEWLINE;
        sb.append(str);
        sb.append("--> Stream-ID = ");
        sb.append(streamId());
        sb.append(str);
        sb.append("--> Headers:");
        sb.append(str);
        appendHeaders(sb);
        sb.setLength(sb.length() - str.length());
        return sb.toString();
    }

    public DefaultSpdyHeadersFrame(int i4, boolean z3) {
        super(i4);
        this.headers = new DefaultSpdyHeaders(z3);
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdyHeadersFrame setLast(boolean z3) {
        super.setLast(z3);
        return this;
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdyHeadersFrame setStreamId(int i4) {
        super.setStreamId(i4);
        return this;
    }
}
