package io.netty.handler.codec.smtp;

import java.util.Collections;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class DefaultSmtpResponse implements SmtpResponse {
    private final int code;
    private final List<CharSequence> details;

    public DefaultSmtpResponse(int i4) {
        this(i4, (List<CharSequence>) null);
    }

    @Override // io.netty.handler.codec.smtp.SmtpResponse
    public int code() {
        return this.code;
    }

    @Override // io.netty.handler.codec.smtp.SmtpResponse
    public List<CharSequence> details() {
        return this.details;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DefaultSmtpResponse) {
            if (obj == this) {
                return true;
            }
            DefaultSmtpResponse defaultSmtpResponse = (DefaultSmtpResponse) obj;
            return code() == defaultSmtpResponse.code() && details().equals(defaultSmtpResponse.details());
        }
        return false;
    }

    public int hashCode() {
        return (this.code * 31) + this.details.hashCode();
    }

    public String toString() {
        return "DefaultSmtpResponse{code=" + this.code + ", details=" + this.details + '}';
    }

    public DefaultSmtpResponse(int i4, CharSequence... charSequenceArr) {
        this(i4, SmtpUtils.toUnmodifiableList(charSequenceArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultSmtpResponse(int i4, List<CharSequence> list) {
        if (i4 >= 100 && i4 <= 599) {
            this.code = i4;
            if (list == null) {
                this.details = Collections.emptyList();
                return;
            } else {
                this.details = Collections.unmodifiableList(list);
                return;
            }
        }
        throw new IllegalArgumentException("code must be 100 <= code <= 599");
    }
}
