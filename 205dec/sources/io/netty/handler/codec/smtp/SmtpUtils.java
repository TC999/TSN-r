package io.netty.handler.codec.smtp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
final class SmtpUtils {
    private SmtpUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<CharSequence> toUnmodifiableList(CharSequence... charSequenceArr) {
        if (charSequenceArr != null && charSequenceArr.length != 0) {
            return Collections.unmodifiableList(Arrays.asList(charSequenceArr));
        }
        return Collections.emptyList();
    }
}
