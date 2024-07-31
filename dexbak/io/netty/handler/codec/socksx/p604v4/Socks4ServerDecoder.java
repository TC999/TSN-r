package io.netty.handler.codec.socksx.p604v4;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.CharsetUtil;
import java.util.List;

/* renamed from: io.netty.handler.codec.socksx.v4.Socks4ServerDecoder */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Socks4ServerDecoder extends ReplayingDecoder<State> {
    private static final int MAX_FIELD_LENGTH = 255;
    private String dstAddr;
    private int dstPort;
    private Socks4CommandType type;
    private String userId;

    /* renamed from: io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C139011 {

        /* renamed from: $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State */
        static final /* synthetic */ int[] f40258xc9960af6;

        static {
            int[] iArr = new int[State.values().length];
            f40258xc9960af6 = iArr;
            try {
                iArr[State.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40258xc9960af6[State.READ_USERID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40258xc9960af6[State.READ_DOMAIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f40258xc9960af6[State.SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f40258xc9960af6[State.FAILURE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum State {
        START,
        READ_USERID,
        READ_DOMAIN,
        SUCCESS,
        FAILURE
    }

    public Socks4ServerDecoder() {
        super(State.START);
        setSingleDecode(true);
    }

    private void fail(List<Object> list, Throwable th) {
        if (!(th instanceof DecoderException)) {
            th = new DecoderException(th);
        }
        Socks4CommandType socks4CommandType = this.type;
        if (socks4CommandType == null) {
            socks4CommandType = Socks4CommandType.CONNECT;
        }
        String str = this.dstAddr;
        if (str == null) {
            str = "";
        }
        int i = this.dstPort;
        if (i == 0) {
            i = 65535;
        }
        String str2 = this.userId;
        DefaultSocks4CommandRequest defaultSocks4CommandRequest = new DefaultSocks4CommandRequest(socks4CommandType, str, i, str2 != null ? str2 : "");
        defaultSocks4CommandRequest.setDecoderResult(DecoderResult.failure(th));
        list.add(defaultSocks4CommandRequest);
        checkpoint(State.FAILURE);
    }

    private static String readString(String str, ByteBuf byteBuf) {
        int bytesBefore = byteBuf.bytesBefore(256, (byte) 0);
        if (bytesBefore >= 0) {
            String byteBuf2 = byteBuf.readSlice(bytesBefore).toString(CharsetUtil.US_ASCII);
            byteBuf.skipBytes(1);
            return byteBuf2;
        }
        throw new DecoderException("field '" + str + "' longer than 255 chars");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0097 A[Catch: Exception -> 0x00b6, TryCatch #0 {Exception -> 0x00b6, blocks: (B:2:0x0000, B:13:0x001f, B:24:0x0091, B:26:0x0097, B:18:0x0060, B:20:0x006a, B:22:0x0074, B:23:0x007c, B:17:0x0053, B:14:0x0028, B:16:0x0034, B:27:0x009f, B:28:0x00b5), top: B:32:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void decode(io.netty.channel.ChannelHandlerContext r5, io.netty.buffer.ByteBuf r6, java.util.List<java.lang.Object> r7) throws java.lang.Exception {
        /*
            r4 = this;
            int[] r5 = io.netty.handler.codec.socksx.p604v4.Socks4ServerDecoder.C139011.f40258xc9960af6     // Catch: java.lang.Exception -> Lb6
            java.lang.Object r0 = r4.state()     // Catch: java.lang.Exception -> Lb6
            io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r0 = (io.netty.handler.codec.socksx.p604v4.Socks4ServerDecoder.State) r0     // Catch: java.lang.Exception -> Lb6
            int r0 = r0.ordinal()     // Catch: java.lang.Exception -> Lb6
            r5 = r5[r0]     // Catch: java.lang.Exception -> Lb6
            r0 = 1
            if (r5 == r0) goto L28
            r0 = 2
            if (r5 == r0) goto L53
            r0 = 3
            if (r5 == r0) goto L60
            r0 = 4
            if (r5 == r0) goto L91
            r0 = 5
            if (r5 == r0) goto L1f
            goto Lba
        L1f:
            int r5 = r4.actualReadableBytes()     // Catch: java.lang.Exception -> Lb6
            r6.skipBytes(r5)     // Catch: java.lang.Exception -> Lb6
            goto Lba
        L28:
            short r5 = r6.readUnsignedByte()     // Catch: java.lang.Exception -> Lb6
            io.netty.handler.codec.socksx.SocksVersion r0 = io.netty.handler.codec.socksx.SocksVersion.SOCKS4a     // Catch: java.lang.Exception -> Lb6
            byte r0 = r0.byteValue()     // Catch: java.lang.Exception -> Lb6
            if (r5 != r0) goto L9f
            byte r5 = r6.readByte()     // Catch: java.lang.Exception -> Lb6
            io.netty.handler.codec.socksx.v4.Socks4CommandType r5 = io.netty.handler.codec.socksx.p604v4.Socks4CommandType.valueOf(r5)     // Catch: java.lang.Exception -> Lb6
            r4.type = r5     // Catch: java.lang.Exception -> Lb6
            int r5 = r6.readUnsignedShort()     // Catch: java.lang.Exception -> Lb6
            r4.dstPort = r5     // Catch: java.lang.Exception -> Lb6
            int r5 = r6.readInt()     // Catch: java.lang.Exception -> Lb6
            java.lang.String r5 = io.netty.util.NetUtil.intToIpAddress(r5)     // Catch: java.lang.Exception -> Lb6
            r4.dstAddr = r5     // Catch: java.lang.Exception -> Lb6
            io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r5 = io.netty.handler.codec.socksx.p604v4.Socks4ServerDecoder.State.READ_USERID     // Catch: java.lang.Exception -> Lb6
            r4.checkpoint(r5)     // Catch: java.lang.Exception -> Lb6
        L53:
            java.lang.String r5 = "userid"
            java.lang.String r5 = readString(r5, r6)     // Catch: java.lang.Exception -> Lb6
            r4.userId = r5     // Catch: java.lang.Exception -> Lb6
            io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r5 = io.netty.handler.codec.socksx.p604v4.Socks4ServerDecoder.State.READ_DOMAIN     // Catch: java.lang.Exception -> Lb6
            r4.checkpoint(r5)     // Catch: java.lang.Exception -> Lb6
        L60:
            java.lang.String r5 = "0.0.0.0"
            java.lang.String r0 = r4.dstAddr     // Catch: java.lang.Exception -> Lb6
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Exception -> Lb6
            if (r5 != 0) goto L7c
            java.lang.String r5 = r4.dstAddr     // Catch: java.lang.Exception -> Lb6
            java.lang.String r0 = "0.0.0."
            boolean r5 = r5.startsWith(r0)     // Catch: java.lang.Exception -> Lb6
            if (r5 == 0) goto L7c
            java.lang.String r5 = "dstAddr"
            java.lang.String r5 = readString(r5, r6)     // Catch: java.lang.Exception -> Lb6
            r4.dstAddr = r5     // Catch: java.lang.Exception -> Lb6
        L7c:
            io.netty.handler.codec.socksx.v4.DefaultSocks4CommandRequest r5 = new io.netty.handler.codec.socksx.v4.DefaultSocks4CommandRequest     // Catch: java.lang.Exception -> Lb6
            io.netty.handler.codec.socksx.v4.Socks4CommandType r0 = r4.type     // Catch: java.lang.Exception -> Lb6
            java.lang.String r1 = r4.dstAddr     // Catch: java.lang.Exception -> Lb6
            int r2 = r4.dstPort     // Catch: java.lang.Exception -> Lb6
            java.lang.String r3 = r4.userId     // Catch: java.lang.Exception -> Lb6
            r5.<init>(r0, r1, r2, r3)     // Catch: java.lang.Exception -> Lb6
            r7.add(r5)     // Catch: java.lang.Exception -> Lb6
            io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r5 = io.netty.handler.codec.socksx.p604v4.Socks4ServerDecoder.State.SUCCESS     // Catch: java.lang.Exception -> Lb6
            r4.checkpoint(r5)     // Catch: java.lang.Exception -> Lb6
        L91:
            int r5 = r4.actualReadableBytes()     // Catch: java.lang.Exception -> Lb6
            if (r5 <= 0) goto Lba
            io.netty.buffer.ByteBuf r5 = r6.readRetainedSlice(r5)     // Catch: java.lang.Exception -> Lb6
            r7.add(r5)     // Catch: java.lang.Exception -> Lb6
            goto Lba
        L9f:
            io.netty.handler.codec.DecoderException r6 = new io.netty.handler.codec.DecoderException     // Catch: java.lang.Exception -> Lb6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb6
            r0.<init>()     // Catch: java.lang.Exception -> Lb6
            java.lang.String r1 = "unsupported protocol version: "
            r0.append(r1)     // Catch: java.lang.Exception -> Lb6
            r0.append(r5)     // Catch: java.lang.Exception -> Lb6
            java.lang.String r5 = r0.toString()     // Catch: java.lang.Exception -> Lb6
            r6.<init>(r5)     // Catch: java.lang.Exception -> Lb6
            throw r6     // Catch: java.lang.Exception -> Lb6
        Lb6:
            r5 = move-exception
            r4.fail(r7, r5)
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socksx.p604v4.Socks4ServerDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }
}
