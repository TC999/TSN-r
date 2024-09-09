package io.netty.handler.codec.socks;

import io.netty.handler.codec.ReplayingDecoder;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SocksInitRequestDecoder extends ReplayingDecoder<State> {
    private byte authSchemeNum;
    private final List<SocksAuthScheme> authSchemes;
    private SocksRequest msg;
    private SocksProtocolVersion version;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: io.netty.handler.codec.socks.SocksInitRequestDecoder$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksInitRequestDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksInitRequestDecoder$State = iArr;
            try {
                iArr[State.CHECK_PROTOCOL_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksInitRequestDecoder$State[State.READ_AUTH_SCHEMES.ordinal()] = 2;
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
        READ_AUTH_SCHEMES
    }

    public SocksInitRequestDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
        this.authSchemes = new ArrayList();
        this.msg = SocksCommonUtils.UNKNOWN_SOCKS_REQUEST;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r0 != 2) goto L11;
     */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void decode(io.netty.channel.ChannelHandlerContext r4, io.netty.buffer.ByteBuf r5, java.util.List<java.lang.Object> r6) throws java.lang.Exception {
        /*
            r3 = this;
            int[] r0 = io.netty.handler.codec.socks.SocksInitRequestDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksInitRequestDecoder$State
            java.lang.Object r1 = r3.state()
            io.netty.handler.codec.socks.SocksInitRequestDecoder$State r1 = (io.netty.handler.codec.socks.SocksInitRequestDecoder.State) r1
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L15
            r1 = 2
            if (r0 == r1) goto L29
            goto L52
        L15:
            byte r0 = r5.readByte()
            io.netty.handler.codec.socks.SocksProtocolVersion r0 = io.netty.handler.codec.socks.SocksProtocolVersion.valueOf(r0)
            r3.version = r0
            io.netty.handler.codec.socks.SocksProtocolVersion r1 = io.netty.handler.codec.socks.SocksProtocolVersion.SOCKS5
            if (r0 == r1) goto L24
            goto L52
        L24:
            io.netty.handler.codec.socks.SocksInitRequestDecoder$State r0 = io.netty.handler.codec.socks.SocksInitRequestDecoder.State.READ_AUTH_SCHEMES
            r3.checkpoint(r0)
        L29:
            java.util.List<io.netty.handler.codec.socks.SocksAuthScheme> r0 = r3.authSchemes
            r0.clear()
            byte r0 = r5.readByte()
            r3.authSchemeNum = r0
            r0 = 0
        L35:
            byte r1 = r3.authSchemeNum
            if (r0 >= r1) goto L49
            java.util.List<io.netty.handler.codec.socks.SocksAuthScheme> r1 = r3.authSchemes
            byte r2 = r5.readByte()
            io.netty.handler.codec.socks.SocksAuthScheme r2 = io.netty.handler.codec.socks.SocksAuthScheme.valueOf(r2)
            r1.add(r2)
            int r0 = r0 + 1
            goto L35
        L49:
            io.netty.handler.codec.socks.SocksInitRequest r5 = new io.netty.handler.codec.socks.SocksInitRequest
            java.util.List<io.netty.handler.codec.socks.SocksAuthScheme> r0 = r3.authSchemes
            r5.<init>(r0)
            r3.msg = r5
        L52:
            io.netty.channel.ChannelPipeline r4 = r4.pipeline()
            r4.remove(r3)
            io.netty.handler.codec.socks.SocksRequest r4 = r3.msg
            r6.add(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socks.SocksInitRequestDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }
}
