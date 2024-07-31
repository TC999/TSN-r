package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpHeaders;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class HttpPostBodyUtil {
    public static final String DEFAULT_BINARY_CONTENT_TYPE = "application/octet-stream";
    public static final String DEFAULT_TEXT_CONTENT_TYPE = "text/plain";
    public static final int chunkSize = 8096;

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class SeekAheadNoBackArrayException extends Exception {
        private static final long serialVersionUID = -630418804938699495L;

        SeekAheadNoBackArrayException() {
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class SeekAheadOptimize {
        ByteBuf buffer;
        byte[] bytes;
        int limit;
        int origPos;
        int pos;
        int readerIndex;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SeekAheadOptimize(ByteBuf byteBuf) throws SeekAheadNoBackArrayException {
            if (byteBuf.hasArray()) {
                this.buffer = byteBuf;
                this.bytes = byteBuf.array();
                this.readerIndex = byteBuf.readerIndex();
                int arrayOffset = byteBuf.arrayOffset() + this.readerIndex;
                this.pos = arrayOffset;
                this.origPos = arrayOffset;
                this.limit = byteBuf.arrayOffset() + byteBuf.writerIndex();
                return;
            }
            throw new SeekAheadNoBackArrayException();
        }

        void clear() {
            this.buffer = null;
            this.bytes = null;
            this.limit = 0;
            this.pos = 0;
            this.readerIndex = 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getReadPosition(int i) {
            return (i - this.origPos) + this.readerIndex;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setReadPosition(int i) {
            int i2 = this.pos - i;
            this.pos = i2;
            int readPosition = getReadPosition(i2);
            this.readerIndex = readPosition;
            this.buffer.readerIndex(readPosition);
        }
    }

    private HttpPostBodyUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int findEndOfString(String str) {
        int length = str.length();
        while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }
        return length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int findNonWhitespace(String str, int i) {
        while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return i;
    }

    static int findWhitespace(String str, int i) {
        while (i < str.length() && !Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return i;
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum TransferEncodingMechanism {
        BIT7("7bit"),
        BIT8("8bit"),
        BINARY(HttpHeaders.Values.BINARY);
        
        private final String value;

        TransferEncodingMechanism(String str) {
            this.value = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        TransferEncodingMechanism() {
            this.value = name();
        }
    }
}
