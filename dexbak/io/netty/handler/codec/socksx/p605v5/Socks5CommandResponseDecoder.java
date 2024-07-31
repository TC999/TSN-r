package io.netty.handler.codec.socksx.p605v5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.socksx.SocksVersion;
import java.util.List;

/* renamed from: io.netty.handler.codec.socksx.v5.Socks5CommandResponseDecoder */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Socks5CommandResponseDecoder extends ReplayingDecoder<State> {
    private final Socks5AddressDecoder addressDecoder;

    /* renamed from: io.netty.handler.codec.socksx.v5.Socks5CommandResponseDecoder$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C139051 {

        /* renamed from: $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5CommandResponseDecoder$State */
        static final /* synthetic */ int[] f40260x620fff3d;

        static {
            int[] iArr = new int[State.values().length];
            f40260x620fff3d = iArr;
            try {
                iArr[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40260x620fff3d[State.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40260x620fff3d[State.FAILURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.socksx.v5.Socks5CommandResponseDecoder$State */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum State {
        INIT,
        SUCCESS,
        FAILURE
    }

    public Socks5CommandResponseDecoder() {
        this(Socks5AddressDecoder.DEFAULT);
    }

    private void fail(List<Object> list, Throwable th) {
        if (!(th instanceof DecoderException)) {
            th = new DecoderException(th);
        }
        checkpoint(State.FAILURE);
        DefaultSocks5CommandResponse defaultSocks5CommandResponse = new DefaultSocks5CommandResponse(Socks5CommandStatus.FAILURE, Socks5AddressType.IPv4, null, 0);
        defaultSocks5CommandResponse.setDecoderResult(DecoderResult.failure(th));
        list.add(defaultSocks5CommandResponse);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        try {
            int i = C139051.f40260x620fff3d[state().ordinal()];
            if (i == 1) {
                byte readByte = byteBuf.readByte();
                SocksVersion socksVersion = SocksVersion.SOCKS5;
                if (readByte == socksVersion.byteValue()) {
                    Socks5CommandStatus valueOf = Socks5CommandStatus.valueOf(byteBuf.readByte());
                    byteBuf.skipBytes(1);
                    Socks5AddressType valueOf2 = Socks5AddressType.valueOf(byteBuf.readByte());
                    list.add(new DefaultSocks5CommandResponse(valueOf, valueOf2, this.addressDecoder.decodeAddress(valueOf2, byteBuf), byteBuf.readUnsignedShort()));
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

    public Socks5CommandResponseDecoder(Socks5AddressDecoder socks5AddressDecoder) {
        super(State.INIT);
        if (socks5AddressDecoder != null) {
            this.addressDecoder = socks5AddressDecoder;
            return;
        }
        throw new NullPointerException("addressDecoder");
    }
}
