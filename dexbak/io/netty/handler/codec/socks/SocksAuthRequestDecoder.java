package io.netty.handler.codec.socks;

import io.netty.handler.codec.ReplayingDecoder;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SocksAuthRequestDecoder extends ReplayingDecoder<State> {
    private int fieldLength;
    private SocksRequest msg;
    private String password;
    private String username;
    private SocksSubnegotiationVersion version;

    /* renamed from: io.netty.handler.codec.socks.SocksAuthRequestDecoder$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C138911 {

        /* renamed from: $SwitchMap$io$netty$handler$codec$socks$SocksAuthRequestDecoder$State */
        static final /* synthetic */ int[] f40244xb63b32bc;

        static {
            int[] iArr = new int[State.values().length];
            f40244xb63b32bc = iArr;
            try {
                iArr[State.CHECK_PROTOCOL_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40244xb63b32bc[State.READ_USERNAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40244xb63b32bc[State.READ_PASSWORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    enum State {
        CHECK_PROTOCOL_VERSION,
        READ_USERNAME,
        READ_PASSWORD
    }

    public SocksAuthRequestDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
        this.msg = SocksCommonUtils.UNKNOWN_SOCKS_REQUEST;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r0 != 3) goto L8;
     */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void decode(io.netty.channel.ChannelHandlerContext r3, io.netty.buffer.ByteBuf r4, java.util.List<java.lang.Object> r5) throws java.lang.Exception {
        /*
            r2 = this;
            int[] r0 = io.netty.handler.codec.socks.SocksAuthRequestDecoder.C138911.f40244xb63b32bc
            java.lang.Object r1 = r2.state()
            io.netty.handler.codec.socks.SocksAuthRequestDecoder$State r1 = (io.netty.handler.codec.socks.SocksAuthRequestDecoder.State) r1
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L18
            r1 = 2
            if (r0 == r1) goto L2c
            r1 = 3
            if (r0 == r1) goto L3d
            goto L54
        L18:
            byte r0 = r4.readByte()
            io.netty.handler.codec.socks.SocksSubnegotiationVersion r0 = io.netty.handler.codec.socks.SocksSubnegotiationVersion.valueOf(r0)
            r2.version = r0
            io.netty.handler.codec.socks.SocksSubnegotiationVersion r1 = io.netty.handler.codec.socks.SocksSubnegotiationVersion.AUTH_PASSWORD
            if (r0 == r1) goto L27
            goto L54
        L27:
            io.netty.handler.codec.socks.SocksAuthRequestDecoder$State r0 = io.netty.handler.codec.socks.SocksAuthRequestDecoder.State.READ_USERNAME
            r2.checkpoint(r0)
        L2c:
            byte r0 = r4.readByte()
            r2.fieldLength = r0
            java.lang.String r0 = io.netty.handler.codec.socks.SocksCommonUtils.readUsAscii(r4, r0)
            r2.username = r0
            io.netty.handler.codec.socks.SocksAuthRequestDecoder$State r0 = io.netty.handler.codec.socks.SocksAuthRequestDecoder.State.READ_PASSWORD
            r2.checkpoint(r0)
        L3d:
            byte r0 = r4.readByte()
            r2.fieldLength = r0
            java.lang.String r4 = io.netty.handler.codec.socks.SocksCommonUtils.readUsAscii(r4, r0)
            r2.password = r4
            io.netty.handler.codec.socks.SocksAuthRequest r4 = new io.netty.handler.codec.socks.SocksAuthRequest
            java.lang.String r0 = r2.username
            java.lang.String r1 = r2.password
            r4.<init>(r0, r1)
            r2.msg = r4
        L54:
            io.netty.channel.ChannelPipeline r3 = r3.pipeline()
            r3.remove(r2)
            io.netty.handler.codec.socks.SocksRequest r3 = r2.msg
            r5.add(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socks.SocksAuthRequestDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }
}
