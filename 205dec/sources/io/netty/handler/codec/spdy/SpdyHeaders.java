package io.netty.handler.codec.spdy;

import io.netty.handler.codec.Headers;
import io.netty.util.AsciiString;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface SpdyHeaders extends Headers<CharSequence, CharSequence, SpdyHeaders> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
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

    boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z3);

    List<String> getAllAsString(CharSequence charSequence);

    String getAsString(CharSequence charSequence);

    Iterator<Map.Entry<String, String>> iteratorAsString();
}
