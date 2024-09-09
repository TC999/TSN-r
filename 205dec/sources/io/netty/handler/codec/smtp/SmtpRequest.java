package io.netty.handler.codec.smtp;

import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface SmtpRequest {
    SmtpCommand command();

    List<CharSequence> parameters();
}
