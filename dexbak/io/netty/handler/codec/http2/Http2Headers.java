package io.netty.handler.codec.http2;

import io.netty.handler.codec.Headers;
import io.netty.util.AsciiString;
import java.util.Iterator;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface Http2Headers extends Headers<CharSequence, CharSequence, Http2Headers> {

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum PseudoHeaderName {
        METHOD(":method"),
        SCHEME(":scheme"),
        AUTHORITY(":authority"),
        PATH(":path"),
        STATUS(":status");
        
        private static final CharSequenceMap<AsciiString> PSEUDO_HEADERS = new CharSequenceMap<>();
        private final AsciiString value;

        static {
            for (PseudoHeaderName pseudoHeaderName : values()) {
                PSEUDO_HEADERS.add((CharSequenceMap<AsciiString>) pseudoHeaderName.value(), AsciiString.EMPTY_STRING);
            }
        }

        PseudoHeaderName(String str) {
            this.value = new AsciiString(str);
        }

        public static boolean isPseudoHeader(CharSequence charSequence) {
            return PSEUDO_HEADERS.contains(charSequence);
        }

        public AsciiString value() {
            return this.value;
        }
    }

    Http2Headers authority(CharSequence charSequence);

    CharSequence authority();

    @Override // io.netty.handler.codec.Headers, java.lang.Iterable
    Iterator<Map.Entry<CharSequence, CharSequence>> iterator();

    Http2Headers method(CharSequence charSequence);

    CharSequence method();

    Http2Headers path(CharSequence charSequence);

    CharSequence path();

    Http2Headers scheme(CharSequence charSequence);

    CharSequence scheme();

    Http2Headers status(CharSequence charSequence);

    CharSequence status();
}
