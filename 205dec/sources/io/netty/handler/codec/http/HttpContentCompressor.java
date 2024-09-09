package io.netty.handler.codec.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;
import io.netty.handler.codec.http.HttpContentEncoder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class HttpContentCompressor extends HttpContentEncoder {
    private final int compressionLevel;
    private ChannelHandlerContext ctx;
    private final int memLevel;
    private final int windowBits;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: io.netty.handler.codec.http.HttpContentCompressor$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper;

        static {
            int[] iArr = new int[ZlibWrapper.values().length];
            $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper = iArr;
            try {
                iArr[ZlibWrapper.GZIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public HttpContentCompressor() {
        this(6);
    }

    @Override // io.netty.handler.codec.http.HttpContentEncoder
    protected HttpContentEncoder.Result beginEncode(HttpResponse httpResponse, String str) throws Exception {
        ZlibWrapper determineWrapper;
        String str2;
        String str3 = httpResponse.headers().get(HttpHeaderNames.CONTENT_ENCODING);
        if ((str3 == null || HttpHeaderValues.IDENTITY.contentEqualsIgnoreCase(str3)) && (determineWrapper = determineWrapper(str)) != null) {
            int i4 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[determineWrapper.ordinal()];
            if (i4 == 1) {
                str2 = "gzip";
            } else if (i4 != 2) {
                throw new Error();
            } else {
                str2 = "deflate";
            }
            return new HttpContentEncoder.Result(str2, new EmbeddedChannel(this.ctx.channel().id(), this.ctx.channel().metadata().hasDisconnect(), this.ctx.channel().config(), ZlibCodecFactory.newZlibEncoder(determineWrapper, this.compressionLevel, this.windowBits, this.memLevel)));
        }
        return null;
    }

    protected ZlibWrapper determineWrapper(String str) {
        String[] split = str.split(",");
        int length = split.length;
        int i4 = 0;
        float f4 = -1.0f;
        float f5 = -1.0f;
        float f6 = -1.0f;
        while (true) {
            float f7 = 0.0f;
            if (i4 >= length) {
                break;
            }
            String str2 = split[i4];
            int indexOf = str2.indexOf(61);
            if (indexOf != -1) {
                try {
                    f7 = Float.parseFloat(str2.substring(indexOf + 1));
                } catch (NumberFormatException unused) {
                }
            } else {
                f7 = 1.0f;
            }
            if (str2.contains("*")) {
                f6 = f7;
            } else if (str2.contains("gzip") && f7 > f4) {
                f4 = f7;
            } else if (str2.contains("deflate") && f7 > f5) {
                f5 = f7;
            }
            i4++;
        }
        if (f4 > 0.0f || f5 > 0.0f) {
            if (f4 >= f5) {
                return ZlibWrapper.GZIP;
            }
            return ZlibWrapper.ZLIB;
        } else if (f6 > 0.0f) {
            if (f4 == -1.0f) {
                return ZlibWrapper.GZIP;
            }
            if (f5 == -1.0f) {
                return ZlibWrapper.ZLIB;
            }
            return null;
        } else {
            return null;
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
    }

    public HttpContentCompressor(int i4) {
        this(i4, 15, 8);
    }

    public HttpContentCompressor(int i4, int i5, int i6) {
        if (i4 < 0 || i4 > 9) {
            throw new IllegalArgumentException("compressionLevel: " + i4 + " (expected: 0-9)");
        } else if (i5 < 9 || i5 > 15) {
            throw new IllegalArgumentException("windowBits: " + i5 + " (expected: 9-15)");
        } else if (i6 >= 1 && i6 <= 9) {
            this.compressionLevel = i4;
            this.windowBits = i5;
            this.memLevel = i6;
        } else {
            throw new IllegalArgumentException("memLevel: " + i6 + " (expected: 1-9)");
        }
    }
}
