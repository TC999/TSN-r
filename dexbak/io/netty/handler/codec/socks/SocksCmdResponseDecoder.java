package io.netty.handler.codec.socks;

import io.netty.handler.codec.ReplayingDecoder;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SocksCmdResponseDecoder extends ReplayingDecoder<State> {
    private SocksAddressType addressType;
    private SocksCmdStatus cmdStatus;
    private int fieldLength;
    private String host;
    private SocksResponse msg;
    private int port;
    private byte reserved;
    private SocksProtocolVersion version;

    /* renamed from: io.netty.handler.codec.socks.SocksCmdResponseDecoder$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C138961 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksAddressType;

        /* renamed from: $SwitchMap$io$netty$handler$codec$socks$SocksCmdResponseDecoder$State */
        static final /* synthetic */ int[] f40249x5919eb68;

        static {
            int[] iArr = new int[State.values().length];
            f40249x5919eb68 = iArr;
            try {
                iArr[State.CHECK_PROTOCOL_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40249x5919eb68[State.READ_CMD_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40249x5919eb68[State.READ_CMD_ADDRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[SocksAddressType.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksAddressType = iArr2;
            try {
                iArr2[SocksAddressType.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.DOMAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.IPv6.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    enum State {
        CHECK_PROTOCOL_VERSION,
        READ_CMD_HEADER,
        READ_CMD_ADDRESS
    }

    public SocksCmdResponseDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
        this.msg = SocksCommonUtils.UNKNOWN_SOCKS_RESPONSE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void decode(io.netty.channel.ChannelHandlerContext r6, io.netty.buffer.ByteBuf r7, java.util.List<java.lang.Object> r8) throws java.lang.Exception {
        /*
            r5 = this;
            int[] r0 = io.netty.handler.codec.socks.SocksCmdResponseDecoder.C138961.f40249x5919eb68
            java.lang.Object r1 = r5.state()
            io.netty.handler.codec.socks.SocksCmdResponseDecoder$State r1 = (io.netty.handler.codec.socks.SocksCmdResponseDecoder.State) r1
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 3
            r2 = 2
            r3 = 1
            if (r0 == r3) goto L19
            if (r0 == r2) goto L2e
            if (r0 == r1) goto L4d
            goto Lc2
        L19:
            byte r0 = r7.readByte()
            io.netty.handler.codec.socks.SocksProtocolVersion r0 = io.netty.handler.codec.socks.SocksProtocolVersion.valueOf(r0)
            r5.version = r0
            io.netty.handler.codec.socks.SocksProtocolVersion r4 = io.netty.handler.codec.socks.SocksProtocolVersion.SOCKS5
            if (r0 == r4) goto L29
            goto Lc2
        L29:
            io.netty.handler.codec.socks.SocksCmdResponseDecoder$State r0 = io.netty.handler.codec.socks.SocksCmdResponseDecoder.State.READ_CMD_HEADER
            r5.checkpoint(r0)
        L2e:
            byte r0 = r7.readByte()
            io.netty.handler.codec.socks.SocksCmdStatus r0 = io.netty.handler.codec.socks.SocksCmdStatus.valueOf(r0)
            r5.cmdStatus = r0
            byte r0 = r7.readByte()
            r5.reserved = r0
            byte r0 = r7.readByte()
            io.netty.handler.codec.socks.SocksAddressType r0 = io.netty.handler.codec.socks.SocksAddressType.valueOf(r0)
            r5.addressType = r0
            io.netty.handler.codec.socks.SocksCmdResponseDecoder$State r0 = io.netty.handler.codec.socks.SocksCmdResponseDecoder.State.READ_CMD_ADDRESS
            r5.checkpoint(r0)
        L4d:
            int[] r0 = io.netty.handler.codec.socks.SocksCmdResponseDecoder.C138961.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType
            io.netty.handler.codec.socks.SocksAddressType r4 = r5.addressType
            int r4 = r4.ordinal()
            r0 = r0[r4]
            if (r0 == r3) goto La3
            if (r0 == r2) goto L81
            if (r0 == r1) goto L5e
            goto Lc2
        L5e:
            r0 = 16
            byte[] r0 = new byte[r0]
            r7.readBytes(r0)
            java.lang.String r0 = io.netty.handler.codec.socks.SocksCommonUtils.ipv6toStr(r0)
            r5.host = r0
            int r7 = r7.readUnsignedShort()
            r5.port = r7
            io.netty.handler.codec.socks.SocksCmdResponse r7 = new io.netty.handler.codec.socks.SocksCmdResponse
            io.netty.handler.codec.socks.SocksCmdStatus r0 = r5.cmdStatus
            io.netty.handler.codec.socks.SocksAddressType r1 = r5.addressType
            java.lang.String r2 = r5.host
            int r3 = r5.port
            r7.<init>(r0, r1, r2, r3)
            r5.msg = r7
            goto Lc2
        L81:
            byte r0 = r7.readByte()
            r5.fieldLength = r0
            java.lang.String r0 = io.netty.handler.codec.socks.SocksCommonUtils.readUsAscii(r7, r0)
            r5.host = r0
            int r7 = r7.readUnsignedShort()
            r5.port = r7
            io.netty.handler.codec.socks.SocksCmdResponse r7 = new io.netty.handler.codec.socks.SocksCmdResponse
            io.netty.handler.codec.socks.SocksCmdStatus r0 = r5.cmdStatus
            io.netty.handler.codec.socks.SocksAddressType r1 = r5.addressType
            java.lang.String r2 = r5.host
            int r3 = r5.port
            r7.<init>(r0, r1, r2, r3)
            r5.msg = r7
            goto Lc2
        La3:
            int r0 = r7.readInt()
            java.lang.String r0 = io.netty.handler.codec.socks.SocksCommonUtils.intToIp(r0)
            r5.host = r0
            int r7 = r7.readUnsignedShort()
            r5.port = r7
            io.netty.handler.codec.socks.SocksCmdResponse r7 = new io.netty.handler.codec.socks.SocksCmdResponse
            io.netty.handler.codec.socks.SocksCmdStatus r0 = r5.cmdStatus
            io.netty.handler.codec.socks.SocksAddressType r1 = r5.addressType
            java.lang.String r2 = r5.host
            int r3 = r5.port
            r7.<init>(r0, r1, r2, r3)
            r5.msg = r7
        Lc2:
            io.netty.channel.ChannelPipeline r6 = r6.pipeline()
            r6.remove(r5)
            io.netty.handler.codec.socks.SocksResponse r6 = r5.msg
            r8.add(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socks.SocksCmdResponseDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }
}
