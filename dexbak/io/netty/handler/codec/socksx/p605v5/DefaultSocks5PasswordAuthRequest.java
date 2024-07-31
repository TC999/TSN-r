package io.netty.handler.codec.socksx.p605v5;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.StringUtil;

/* renamed from: io.netty.handler.codec.socksx.v5.DefaultSocks5PasswordAuthRequest */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DefaultSocks5PasswordAuthRequest extends AbstractSocks5Message implements Socks5PasswordAuthRequest {
    private final String password;
    private final String username;

    public DefaultSocks5PasswordAuthRequest(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("username");
        }
        if (str2 != null) {
            if (str.length() <= 255) {
                if (str2.length() <= 255) {
                    this.username = str;
                    this.password = str2;
                    return;
                }
                throw new IllegalArgumentException("password: **** (expected: less than 256 chars)");
            }
            throw new IllegalArgumentException("username: **** (expected: less than 256 chars)");
        }
        throw new NullPointerException("password");
    }

    @Override // io.netty.handler.codec.socksx.p605v5.Socks5PasswordAuthRequest
    public String password() {
        return this.password;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (!decoderResult.isSuccess()) {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", username: ");
        } else {
            sb.append("(username: ");
        }
        sb.append(username());
        sb.append(", password: ****)");
        return sb.toString();
    }

    @Override // io.netty.handler.codec.socksx.p605v5.Socks5PasswordAuthRequest
    public String username() {
        return this.username;
    }
}
