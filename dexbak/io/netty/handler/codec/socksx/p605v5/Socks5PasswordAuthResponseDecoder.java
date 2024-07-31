package io.netty.handler.codec.socksx.p605v5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

/* renamed from: io.netty.handler.codec.socksx.v5.Socks5PasswordAuthResponseDecoder */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Socks5PasswordAuthResponseDecoder extends ReplayingDecoder<State> {

    /* renamed from: io.netty.handler.codec.socksx.v5.Socks5PasswordAuthResponseDecoder$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C139091 {

        /* renamed from: $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5PasswordAuthResponseDecoder$State */
        static final /* synthetic */ int[] f40264xa7450b5;

        static {
            int[] iArr = new int[State.values().length];
            f40264xa7450b5 = iArr;
            try {
                iArr[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40264xa7450b5[State.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40264xa7450b5[State.FAILURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.socksx.v5.Socks5PasswordAuthResponseDecoder$State */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum State {
        INIT,
        SUCCESS,
        FAILURE
    }

    public Socks5PasswordAuthResponseDecoder() {
        super(State.INIT);
    }

    private void fail(List<Object> list, Throwable th) {
        if (!(th instanceof DecoderException)) {
            th = new DecoderException(th);
        }
        checkpoint(State.FAILURE);
        DefaultSocks5PasswordAuthResponse defaultSocks5PasswordAuthResponse = new DefaultSocks5PasswordAuthResponse(Socks5PasswordAuthStatus.FAILURE);
        defaultSocks5PasswordAuthResponse.setDecoderResult(DecoderResult.failure(th));
        list.add(defaultSocks5PasswordAuthResponse);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        try {
            int i = C139091.f40264xa7450b5[state().ordinal()];
            if (i == 1) {
                byte readByte = byteBuf.readByte();
                if (readByte == 1) {
                    list.add(new DefaultSocks5PasswordAuthResponse(Socks5PasswordAuthStatus.valueOf(byteBuf.readByte())));
                    checkpoint(State.SUCCESS);
                } else {
                    throw new DecoderException("unsupported subnegotiation version: " + ((int) readByte) + " (expected: 1)");
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
