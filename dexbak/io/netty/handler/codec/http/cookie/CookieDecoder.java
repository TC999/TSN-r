package io.netty.handler.codec.http.cookie;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.CharBuffer;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class CookieDecoder {
    private final InternalLogger logger = InternalLoggerFactory.getInstance(getClass());
    private final boolean strict;

    /* JADX INFO: Access modifiers changed from: protected */
    public CookieDecoder(boolean z) {
        this.strict = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DefaultCookie initCookie(String str, int i, int i2, int i3, int i4) {
        int firstInvalidCookieValueOctet;
        int firstInvalidCookieNameOctet;
        if (i == -1 || i == i2) {
            this.logger.debug("Skipping cookie with null name");
            return null;
        } else if (i3 == -1) {
            this.logger.debug("Skipping cookie with null value");
            return null;
        } else {
            CharBuffer wrap = CharBuffer.wrap(str, i3, i4);
            CharSequence unwrapValue = CookieUtil.unwrapValue(wrap);
            if (unwrapValue == null) {
                this.logger.debug("Skipping cookie because starting quotes are not properly balanced in '{}'", wrap);
                return null;
            }
            String substring = str.substring(i, i2);
            if (this.strict && (firstInvalidCookieNameOctet = CookieUtil.firstInvalidCookieNameOctet(substring)) >= 0) {
                if (this.logger.isDebugEnabled()) {
                    this.logger.debug("Skipping cookie because name '{}' contains invalid char '{}'", substring, Character.valueOf(substring.charAt(firstInvalidCookieNameOctet)));
                }
                return null;
            }
            boolean z = unwrapValue.length() != i4 - i3;
            if (this.strict && (firstInvalidCookieValueOctet = CookieUtil.firstInvalidCookieValueOctet(unwrapValue)) >= 0) {
                if (this.logger.isDebugEnabled()) {
                    this.logger.debug("Skipping cookie because value '{}' contains invalid char '{}'", unwrapValue, Character.valueOf(unwrapValue.charAt(firstInvalidCookieValueOctet)));
                }
                return null;
            }
            DefaultCookie defaultCookie = new DefaultCookie(substring, unwrapValue.toString());
            defaultCookie.setWrap(z);
            return defaultCookie;
        }
    }
}
