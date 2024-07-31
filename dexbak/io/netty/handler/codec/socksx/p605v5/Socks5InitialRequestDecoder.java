package io.netty.handler.codec.socksx.p605v5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.socksx.SocksVersion;
import java.util.List;

/* renamed from: io.netty.handler.codec.socksx.v5.Socks5InitialRequestDecoder */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Socks5InitialRequestDecoder extends ReplayingDecoder<State> {

    /* renamed from: io.netty.handler.codec.socksx.v5.Socks5InitialRequestDecoder$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C139061 {

        /* renamed from: $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5InitialRequestDecoder$State */
        static final /* synthetic */ int[] f40261x266223ae;

        static {
            int[] iArr = new int[State.values().length];
            f40261x266223ae = iArr;
            try {
                iArr[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40261x266223ae[State.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40261x266223ae[State.FAILURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.socksx.v5.Socks5InitialRequestDecoder$State */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum State {
        INIT,
        SUCCESS,
        FAILURE
    }

    public Socks5InitialRequestDecoder() {
        super(State.INIT);
    }

    private void fail(List<Object> list, Throwable th) {
        if (!(th instanceof DecoderException)) {
            th = new DecoderException(th);
        }
        checkpoint(State.FAILURE);
        DefaultSocks5InitialRequest defaultSocks5InitialRequest = new DefaultSocks5InitialRequest(Socks5AuthMethod.NO_AUTH);
        defaultSocks5InitialRequest.setDecoderResult(DecoderResult.failure(th));
        list.add(defaultSocks5InitialRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        try {
            int i = C139061.f40261x266223ae[state().ordinal()];
            if (i == 1) {
                byte readByte = byteBuf.readByte();
                SocksVersion socksVersion = SocksVersion.SOCKS5;
                if (readByte == socksVersion.byteValue()) {
                    int readUnsignedByte = byteBuf.readUnsignedByte();
                    if (actualReadableBytes() < readUnsignedByte) {
                        return;
                    }
                    Socks5AuthMethod[] socks5AuthMethodArr = new Socks5AuthMethod[readUnsignedByte];
                    for (int i2 = 0; i2 < readUnsignedByte; i2++) {
                        socks5AuthMethodArr[i2] = Socks5AuthMethod.valueOf(byteBuf.readByte());
                    }
                    list.add(new DefaultSocks5InitialRequest(socks5AuthMethodArr));
                    checkpoint(State.SUCCESS);
                } else {
                    throw new DecoderException("unsupported version: " + ((int) readByte) + " (expected: " + ((int) socksVersion.byteValue()) + ')');
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
