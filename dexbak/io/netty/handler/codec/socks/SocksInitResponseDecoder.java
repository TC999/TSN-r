package io.netty.handler.codec.socks;

import io.netty.handler.codec.ReplayingDecoder;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SocksInitResponseDecoder extends ReplayingDecoder<State> {
    private SocksAuthScheme authScheme;
    private SocksResponse msg;
    private SocksProtocolVersion version;

    /* renamed from: io.netty.handler.codec.socks.SocksInitResponseDecoder$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C138981 {

        /* renamed from: $SwitchMap$io$netty$handler$codec$socks$SocksInitResponseDecoder$State */
        static final /* synthetic */ int[] f40253x7a2ae92e;

        static {
            int[] iArr = new int[State.values().length];
            f40253x7a2ae92e = iArr;
            try {
                iArr[State.CHECK_PROTOCOL_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40253x7a2ae92e[State.READ_PREFFERED_AUTH_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    enum State {
        CHECK_PROTOCOL_VERSION,
        READ_PREFFERED_AUTH_TYPE
    }

    public SocksInitResponseDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
        this.msg = SocksCommonUtils.UNKNOWN_SOCKS_RESPONSE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r0 != 2) goto L6;
     */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void decode(io.netty.channel.ChannelHandlerContext r3, io.netty.buffer.ByteBuf r4, java.util.List<java.lang.Object> r5) throws java.lang.Exception {
        /*
            r2 = this;
            int[] r0 = io.netty.handler.codec.socks.SocksInitResponseDecoder.C138981.f40253x7a2ae92e
            java.lang.Object r1 = r2.state()
            io.netty.handler.codec.socks.SocksInitResponseDecoder$State r1 = (io.netty.handler.codec.socks.SocksInitResponseDecoder.State) r1
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L15
            r1 = 2
            if (r0 == r1) goto L29
            goto L3a
        L15:
            byte r0 = r4.readByte()
            io.netty.handler.codec.socks.SocksProtocolVersion r0 = io.netty.handler.codec.socks.SocksProtocolVersion.valueOf(r0)
            r2.version = r0
            io.netty.handler.codec.socks.SocksProtocolVersion r1 = io.netty.handler.codec.socks.SocksProtocolVersion.SOCKS5
            if (r0 == r1) goto L24
            goto L3a
        L24:
            io.netty.handler.codec.socks.SocksInitResponseDecoder$State r0 = io.netty.handler.codec.socks.SocksInitResponseDecoder.State.READ_PREFFERED_AUTH_TYPE
            r2.checkpoint(r0)
        L29:
            byte r4 = r4.readByte()
            io.netty.handler.codec.socks.SocksAuthScheme r4 = io.netty.handler.codec.socks.SocksAuthScheme.valueOf(r4)
            r2.authScheme = r4
            io.netty.handler.codec.socks.SocksInitResponse r0 = new io.netty.handler.codec.socks.SocksInitResponse
            r0.<init>(r4)
            r2.msg = r0
        L3a:
            io.netty.channel.ChannelPipeline r3 = r3.pipeline()
            r3.remove(r2)
            io.netty.handler.codec.socks.SocksResponse r3 = r2.msg
            r5.add(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socks.SocksInitResponseDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }
}
