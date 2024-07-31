package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class SocksAuthRequest extends SocksRequest {
    private final String password;
    private final String username;
    private static final CharsetEncoder asciiEncoder = CharsetUtil.encoder(CharsetUtil.US_ASCII);
    private static final SocksSubnegotiationVersion SUBNEGOTIATION_VERSION = SocksSubnegotiationVersion.AUTH_PASSWORD;

    public SocksAuthRequest(String str, String str2) {
        super(SocksRequestType.AUTH);
        if (str == null) {
            throw new NullPointerException("username");
        }
        if (str2 != null) {
            CharsetEncoder charsetEncoder = asciiEncoder;
            if (charsetEncoder.canEncode(str) && charsetEncoder.canEncode(str2)) {
                if (str.length() <= 255) {
                    if (str2.length() <= 255) {
                        this.username = str;
                        this.password = str2;
                        return;
                    }
                    throw new IllegalArgumentException("password: **** exceeds 255 char limit");
                }
                throw new IllegalArgumentException("username: " + str + " exceeds 255 char limit");
            }
            throw new IllegalArgumentException("username: " + str + " or password: **** values should be in pure ascii");
        }
        throw new NullPointerException("username");
    }

    @Override // io.netty.handler.codec.socks.SocksMessage
    public void encodeAsByteBuf(ByteBuf byteBuf) {
        byteBuf.writeByte(SUBNEGOTIATION_VERSION.byteValue());
        byteBuf.writeByte(this.username.length());
        String str = this.username;
        Charset charset = CharsetUtil.US_ASCII;
        byteBuf.writeBytes(str.getBytes(charset));
        byteBuf.writeByte(this.password.length());
        byteBuf.writeBytes(this.password.getBytes(charset));
    }

    public String password() {
        return this.password;
    }

    public String username() {
        return this.username;
    }
}
