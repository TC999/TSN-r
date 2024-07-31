package io.netty.handler.codec.socksx.p605v5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.socksx.SocksVersion;
import java.util.List;

/* renamed from: io.netty.handler.codec.socksx.v5.Socks5CommandRequestDecoder */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Socks5CommandRequestDecoder extends ReplayingDecoder<State> {
    private final Socks5AddressDecoder addressDecoder;

    /* renamed from: io.netty.handler.codec.socksx.v5.Socks5CommandRequestDecoder$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C139041 {

        /* renamed from: $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5CommandRequestDecoder$State */
        static final /* synthetic */ int[] f40259x1b816235;

        static {
            int[] iArr = new int[State.values().length];
            f40259x1b816235 = iArr;
            try {
                iArr[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40259x1b816235[State.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40259x1b816235[State.FAILURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.socksx.v5.Socks5CommandRequestDecoder$State */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum State {
        INIT,
        SUCCESS,
        FAILURE
    }

    public Socks5CommandRequestDecoder() {
        this(Socks5AddressDecoder.DEFAULT);
    }

    private void fail(List<Object> list, Throwable th) {
        if (!(th instanceof DecoderException)) {
            th = new DecoderException(th);
        }
        checkpoint(State.FAILURE);
        DefaultSocks5CommandRequest defaultSocks5CommandRequest = new DefaultSocks5CommandRequest(Socks5CommandType.CONNECT, Socks5AddressType.IPv4, "0.0.0.0", 1);
        defaultSocks5CommandRequest.setDecoderResult(DecoderResult.failure(th));
        list.add(defaultSocks5CommandRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        try {
            int i = C139041.f40259x1b816235[state().ordinal()];
            if (i == 1) {
                byte readByte = byteBuf.readByte();
                SocksVersion socksVersion = SocksVersion.SOCKS5;
                if (readByte == socksVersion.byteValue()) {
                    Socks5CommandType valueOf = Socks5CommandType.valueOf(byteBuf.readByte());
                    byteBuf.skipBytes(1);
                    Socks5AddressType valueOf2 = Socks5AddressType.valueOf(byteBuf.readByte());
                    list.add(new DefaultSocks5CommandRequest(valueOf, valueOf2, this.addressDecoder.decodeAddress(valueOf2, byteBuf), byteBuf.readUnsignedShort()));
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

    public Socks5CommandRequestDecoder(Socks5AddressDecoder socks5AddressDecoder) {
        super(State.INIT);
        if (socks5AddressDecoder != null) {
            this.addressDecoder = socks5AddressDecoder;
            return;
        }
        throw new NullPointerException("addressDecoder");
    }
}
