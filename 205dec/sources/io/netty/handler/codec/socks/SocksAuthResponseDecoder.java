package io.netty.handler.codec.socks;

import io.netty.handler.codec.ReplayingDecoder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SocksAuthResponseDecoder extends ReplayingDecoder<State> {
    private SocksAuthStatus authStatus;
    private SocksResponse msg;
    private SocksSubnegotiationVersion version;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: io.netty.handler.codec.socks.SocksAuthResponseDecoder$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksAuthResponseDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksAuthResponseDecoder$State = iArr;
            try {
                iArr[State.CHECK_PROTOCOL_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAuthResponseDecoder$State[State.READ_AUTH_RESPONSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    enum State {
        CHECK_PROTOCOL_VERSION,
        READ_AUTH_RESPONSE
    }

    public SocksAuthResponseDecoder() {
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
            int[] r0 = io.netty.handler.codec.socks.SocksAuthResponseDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAuthResponseDecoder$State
            java.lang.Object r1 = r2.state()
            io.netty.handler.codec.socks.SocksAuthResponseDecoder$State r1 = (io.netty.handler.codec.socks.SocksAuthResponseDecoder.State) r1
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L15
            r1 = 2
            if (r0 == r1) goto L29
            goto L3c
        L15:
            byte r0 = r4.readByte()
            io.netty.handler.codec.socks.SocksSubnegotiationVersion r0 = io.netty.handler.codec.socks.SocksSubnegotiationVersion.valueOf(r0)
            r2.version = r0
            io.netty.handler.codec.socks.SocksSubnegotiationVersion r1 = io.netty.handler.codec.socks.SocksSubnegotiationVersion.AUTH_PASSWORD
            if (r0 == r1) goto L24
            goto L3c
        L24:
            io.netty.handler.codec.socks.SocksAuthResponseDecoder$State r0 = io.netty.handler.codec.socks.SocksAuthResponseDecoder.State.READ_AUTH_RESPONSE
            r2.checkpoint(r0)
        L29:
            byte r4 = r4.readByte()
            io.netty.handler.codec.socks.SocksAuthStatus r4 = io.netty.handler.codec.socks.SocksAuthStatus.valueOf(r4)
            r2.authStatus = r4
            io.netty.handler.codec.socks.SocksAuthResponse r4 = new io.netty.handler.codec.socks.SocksAuthResponse
            io.netty.handler.codec.socks.SocksAuthStatus r0 = r2.authStatus
            r4.<init>(r0)
            r2.msg = r4
        L3c:
            io.netty.channel.ChannelPipeline r3 = r3.pipeline()
            r3.remove(r2)
            io.netty.handler.codec.socks.SocksResponse r3 = r2.msg
            r5.add(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socks.SocksAuthResponseDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }
}
