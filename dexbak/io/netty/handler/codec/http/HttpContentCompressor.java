package io.netty.handler.codec.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;
import io.netty.handler.codec.http.HttpContentEncoder;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class HttpContentCompressor extends HttpContentEncoder {
    private final int compressionLevel;
    private ChannelHandlerContext ctx;
    private final int memLevel;
    private final int windowBits;

    /* renamed from: io.netty.handler.codec.http.HttpContentCompressor$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C138041 {
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
            int i = C138041.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[determineWrapper.ordinal()];
            if (i == 1) {
                str2 = "gzip";
            } else if (i != 2) {
                throw new Error();
            } else {
                str2 = "deflate";
            }
            return new HttpContentEncoder.Result(str2, new EmbeddedChannel(this.ctx.channel().mo12693id(), this.ctx.channel().metadata().hasDisconnect(), this.ctx.channel().config(), ZlibCodecFactory.newZlibEncoder(determineWrapper, this.compressionLevel, this.windowBits, this.memLevel)));
        }
        return null;
    }

    protected ZlibWrapper determineWrapper(String str) {
        String[] split = str.split(",");
        int length = split.length;
        int i = 0;
        float f = -1.0f;
        float f2 = -1.0f;
        float f3 = -1.0f;
        while (true) {
            float f4 = 0.0f;
            if (i >= length) {
                break;
            }
            String str2 = split[i];
            int indexOf = str2.indexOf(61);
            if (indexOf != -1) {
                try {
                    f4 = Float.parseFloat(str2.substring(indexOf + 1));
                } catch (NumberFormatException unused) {
                }
            } else {
                f4 = 1.0f;
            }
            if (str2.contains("*")) {
                f3 = f4;
            } else if (str2.contains("gzip") && f4 > f) {
                f = f4;
            } else if (str2.contains("deflate") && f4 > f2) {
                f2 = f4;
            }
            i++;
        }
        if (f > 0.0f || f2 > 0.0f) {
            if (f >= f2) {
                return ZlibWrapper.GZIP;
            }
            return ZlibWrapper.ZLIB;
        } else if (f3 > 0.0f) {
            if (f == -1.0f) {
                return ZlibWrapper.GZIP;
            }
            if (f2 == -1.0f) {
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

    public HttpContentCompressor(int i) {
        this(i, 15, 8);
    }

    public HttpContentCompressor(int i, int i2, int i3) {
        if (i < 0 || i > 9) {
            throw new IllegalArgumentException("compressionLevel: " + i + " (expected: 0-9)");
        } else if (i2 < 9 || i2 > 15) {
            throw new IllegalArgumentException("windowBits: " + i2 + " (expected: 9-15)");
        } else if (i3 >= 1 && i3 <= 9) {
            this.compressionLevel = i;
            this.windowBits = i2;
            this.memLevel = i3;
        } else {
            throw new IllegalArgumentException("memLevel: " + i3 + " (expected: 1-9)");
        }
    }
}
