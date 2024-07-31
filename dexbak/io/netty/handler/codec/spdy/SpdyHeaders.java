package io.netty.handler.codec.spdy;

import io.netty.handler.codec.Headers;
import io.netty.util.AsciiString;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface SpdyHeaders extends Headers<CharSequence, CharSequence, SpdyHeaders> {

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class HttpNames {
        public static final AsciiString HOST = new AsciiString(":host");
        public static final AsciiString METHOD = new AsciiString(":method");
        public static final AsciiString PATH = new AsciiString(":path");
        public static final AsciiString SCHEME = new AsciiString(":scheme");
        public static final AsciiString STATUS = new AsciiString(":status");
        public static final AsciiString VERSION = new AsciiString(":version");

        private HttpNames() {
        }
    }

    boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z);

    List<String> getAllAsString(CharSequence charSequence);

    String getAsString(CharSequence charSequence);

    Iterator<Map.Entry<String, String>> iteratorAsString();
}
