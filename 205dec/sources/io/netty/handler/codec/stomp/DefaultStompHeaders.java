package io.netty.handler.codec.stomp;

import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.HeadersUtils;
import io.netty.util.AsciiString;
import io.netty.util.HashingStrategy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultStompHeaders extends DefaultHeaders<CharSequence, CharSequence, StompHeaders> implements StompHeaders {
    public DefaultStompHeaders() {
        super(AsciiString.CASE_SENSITIVE_HASHER, CharSequenceValueConverter.INSTANCE);
    }

    @Override // io.netty.handler.codec.stomp.StompHeaders
    public List<String> getAllAsString(CharSequence charSequence) {
        return HeadersUtils.getAllAsString(this, charSequence);
    }

    @Override // io.netty.handler.codec.stomp.StompHeaders
    public String getAsString(CharSequence charSequence) {
        return HeadersUtils.getAsString(this, charSequence);
    }

    @Override // io.netty.handler.codec.stomp.StompHeaders
    public Iterator<Map.Entry<String, String>> iteratorAsString() {
        return HeadersUtils.iteratorAsString(this);
    }

    @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
    public boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        return contains(charSequence, charSequence2, false);
    }

    @Override // io.netty.handler.codec.stomp.StompHeaders
    public boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z3) {
        return contains((DefaultStompHeaders) charSequence, charSequence2, (HashingStrategy<? super CharSequence>) (z3 ? AsciiString.CASE_INSENSITIVE_HASHER : AsciiString.CASE_SENSITIVE_HASHER));
    }
}
