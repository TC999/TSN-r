package io.netty.handler.codec.http.cookie;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class CookieEncoder {
    protected final boolean strict;

    /* JADX INFO: Access modifiers changed from: protected */
    public CookieEncoder(boolean z) {
        this.strict = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void validateCookie(String str, String str2) {
        if (this.strict) {
            int firstInvalidCookieNameOctet = CookieUtil.firstInvalidCookieNameOctet(str);
            if (firstInvalidCookieNameOctet < 0) {
                CharSequence unwrapValue = CookieUtil.unwrapValue(str2);
                if (unwrapValue != null) {
                    int firstInvalidCookieValueOctet = CookieUtil.firstInvalidCookieValueOctet(unwrapValue);
                    if (firstInvalidCookieValueOctet < 0) {
                        return;
                    }
                    throw new IllegalArgumentException("Cookie value contains an invalid char: " + str2.charAt(firstInvalidCookieValueOctet));
                }
                throw new IllegalArgumentException("Cookie value wrapping quotes are not balanced: " + str2);
            }
            throw new IllegalArgumentException("Cookie name contains an invalid char: " + str.charAt(firstInvalidCookieNameOctet));
        }
    }
}
