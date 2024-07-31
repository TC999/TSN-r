package io.netty.handler.codec.socksx.p605v5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.CharsetUtil;
import java.nio.charset.Charset;
import java.util.List;

/* renamed from: io.netty.handler.codec.socksx.v5.Socks5PasswordAuthRequestDecoder */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Socks5PasswordAuthRequestDecoder extends ReplayingDecoder<State> {

    /* renamed from: io.netty.handler.codec.socksx.v5.Socks5PasswordAuthRequestDecoder$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C139081 {

        /* renamed from: $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5PasswordAuthRequestDecoder$State */
        static final /* synthetic */ int[] f40263xa51101bd;

        static {
            int[] iArr = new int[State.values().length];
            f40263xa51101bd = iArr;
            try {
                iArr[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40263xa51101bd[State.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40263xa51101bd[State.FAILURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.socksx.v5.Socks5PasswordAuthRequestDecoder$State */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum State {
        INIT,
        SUCCESS,
        FAILURE
    }

    public Socks5PasswordAuthRequestDecoder() {
        super(State.INIT);
    }

    private void fail(List<Object> list, Throwable th) {
        if (!(th instanceof DecoderException)) {
            th = new DecoderException(th);
        }
        checkpoint(State.FAILURE);
        DefaultSocks5PasswordAuthRequest defaultSocks5PasswordAuthRequest = new DefaultSocks5PasswordAuthRequest("", "");
        defaultSocks5PasswordAuthRequest.setDecoderResult(DecoderResult.failure(th));
        list.add(defaultSocks5PasswordAuthRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        try {
            int i = C139081.f40263xa51101bd[state().ordinal()];
            if (i == 1) {
                int readerIndex = byteBuf.readerIndex();
                byte b = byteBuf.getByte(readerIndex);
                if (b == 1) {
                    short unsignedByte = byteBuf.getUnsignedByte(readerIndex + 1);
                    int i2 = readerIndex + 2;
                    short unsignedByte2 = byteBuf.getUnsignedByte(i2 + unsignedByte);
                    byteBuf.skipBytes(unsignedByte + unsignedByte2 + 3);
                    Charset charset = CharsetUtil.US_ASCII;
                    list.add(new DefaultSocks5PasswordAuthRequest(byteBuf.toString(i2, unsignedByte, charset), byteBuf.toString(readerIndex + 3 + unsignedByte, unsignedByte2, charset)));
                    checkpoint(State.SUCCESS);
                } else {
                    throw new DecoderException("unsupported subnegotiation version: " + ((int) b) + " (expected: 1)");
                }
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                byteBuf.skipBytes(actualReadableBytes());
                return;
            }
            int actualReadableBytes = actualReadableBytes();
            if (actualReadableBytes > 0) {
                list.add(byteBuf.readRetainedSlice(actualReadableBytes));
            }
        } catch (Exception e) {
            fail(list, e);
        }
    }
}
