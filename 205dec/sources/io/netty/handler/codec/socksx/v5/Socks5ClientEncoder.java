package io.netty.handler.codec.socksx.v5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.StringUtil;
import java.util.List;
import java.util.RandomAccess;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
@ChannelHandler.Sharable
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class Socks5ClientEncoder extends MessageToByteEncoder<Socks5Message> {
    public static final Socks5ClientEncoder DEFAULT = new Socks5ClientEncoder();
    private final Socks5AddressEncoder addressEncoder;

    protected Socks5ClientEncoder() {
        this(Socks5AddressEncoder.DEFAULT);
    }

    private static void encodeAuthMethodRequest(Socks5InitialRequest socks5InitialRequest, ByteBuf byteBuf) {
        byteBuf.writeByte(socks5InitialRequest.version().byteValue());
        List<Socks5AuthMethod> authMethods = socks5InitialRequest.authMethods();
        int size = authMethods.size();
        byteBuf.writeByte(size);
        if (!(authMethods instanceof RandomAccess)) {
            for (Socks5AuthMethod socks5AuthMethod : authMethods) {
                byteBuf.writeByte(socks5AuthMethod.byteValue());
            }
            return;
        }
        for (int i4 = 0; i4 < size; i4++) {
            byteBuf.writeByte(authMethods.get(i4).byteValue());
        }
    }

    private void encodeCommandRequest(Socks5CommandRequest socks5CommandRequest, ByteBuf byteBuf) throws Exception {
        byteBuf.writeByte(socks5CommandRequest.version().byteValue());
        byteBuf.writeByte(socks5CommandRequest.type().byteValue());
        byteBuf.writeByte(0);
        Socks5AddressType dstAddrType = socks5CommandRequest.dstAddrType();
        byteBuf.writeByte(dstAddrType.byteValue());
        this.addressEncoder.encodeAddress(dstAddrType, socks5CommandRequest.dstAddr(), byteBuf);
        byteBuf.writeShort(socks5CommandRequest.dstPort());
    }

    private static void encodePasswordAuthRequest(Socks5PasswordAuthRequest socks5PasswordAuthRequest, ByteBuf byteBuf) {
        byteBuf.writeByte(1);
        String username = socks5PasswordAuthRequest.username();
        byteBuf.writeByte(username.length());
        ByteBufUtil.writeAscii(byteBuf, username);
        String password = socks5PasswordAuthRequest.password();
        byteBuf.writeByte(password.length());
        ByteBufUtil.writeAscii(byteBuf, password);
    }

    protected final Socks5AddressEncoder addressEncoder() {
        return this.addressEncoder;
    }

    public Socks5ClientEncoder(Socks5AddressEncoder socks5AddressEncoder) {
        if (socks5AddressEncoder != null) {
            this.addressEncoder = socks5AddressEncoder;
            return;
        }
        throw new NullPointerException("addressEncoder");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Socks5Message socks5Message, ByteBuf byteBuf) throws Exception {
        if (socks5Message instanceof Socks5InitialRequest) {
            encodeAuthMethodRequest((Socks5InitialRequest) socks5Message, byteBuf);
        } else if (socks5Message instanceof Socks5PasswordAuthRequest) {
            encodePasswordAuthRequest((Socks5PasswordAuthRequest) socks5Message, byteBuf);
        } else if (socks5Message instanceof Socks5CommandRequest) {
            encodeCommandRequest((Socks5CommandRequest) socks5Message, byteBuf);
        } else {
            throw new EncoderException("unsupported message type: " + StringUtil.simpleClassName(socks5Message));
        }
    }
}
