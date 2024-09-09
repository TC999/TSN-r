package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.PrematureChannelClosureException;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.AppendableCharSequence;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class HttpObjectDecoder extends ByteToMessageDecoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String EMPTY_VALUE = "";
    private long chunkSize;
    private final boolean chunkedSupported;
    private long contentLength;
    private State currentState;
    private final HeaderParser headerParser;
    private final LineParser lineParser;
    private final int maxChunkSize;
    private HttpMessage message;
    private CharSequence name;
    private volatile boolean resetRequested;
    private LastHttpContent trailer;
    protected final boolean validateHeaders;
    private CharSequence value;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: io.netty.handler.codec.http.HttpObjectDecoder$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State = iArr;
            try {
                iArr[State.SKIP_CONTROL_CHARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_SIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_INITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_HEADER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_VARIABLE_LENGTH_CONTENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_FIXED_LENGTH_CONTENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNKED_CONTENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_DELIMITER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_FOOTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.BAD_MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.UPGRADED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class HeaderParser implements ByteProcessor {
        private final int maxLength;
        private final AppendableCharSequence seq;
        private int size;

        HeaderParser(AppendableCharSequence appendableCharSequence, int i4) {
            this.seq = appendableCharSequence;
            this.maxLength = i4;
        }

        protected TooLongFrameException newException(int i4) {
            return new TooLongFrameException("HTTP header is larger than " + i4 + " bytes.");
        }

        public AppendableCharSequence parse(ByteBuf byteBuf) {
            int i4 = this.size;
            this.seq.reset();
            int forEachByte = byteBuf.forEachByte(this);
            if (forEachByte == -1) {
                this.size = i4;
                return null;
            }
            byteBuf.readerIndex(forEachByte + 1);
            return this.seq;
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b4) throws Exception {
            char c4 = (char) b4;
            if (c4 == '\r') {
                return true;
            }
            if (c4 == '\n') {
                return false;
            }
            int i4 = this.size + 1;
            this.size = i4;
            int i5 = this.maxLength;
            if (i4 <= i5) {
                this.seq.append(c4);
                return true;
            }
            throw newException(i5);
        }

        public void reset() {
            this.size = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class LineParser extends HeaderParser {
        LineParser(AppendableCharSequence appendableCharSequence, int i4) {
            super(appendableCharSequence, i4);
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder.HeaderParser
        protected TooLongFrameException newException(int i4) {
            return new TooLongFrameException("An HTTP line is larger than " + i4 + " bytes.");
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder.HeaderParser
        public AppendableCharSequence parse(ByteBuf byteBuf) {
            reset();
            return super.parse(byteBuf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum State {
        SKIP_CONTROL_CHARS,
        READ_INITIAL,
        READ_HEADER,
        READ_VARIABLE_LENGTH_CONTENT,
        READ_FIXED_LENGTH_CONTENT,
        READ_CHUNK_SIZE,
        READ_CHUNKED_CONTENT,
        READ_CHUNK_DELIMITER,
        READ_CHUNK_FOOTER,
        BAD_MESSAGE,
        UPGRADED
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpObjectDecoder() {
        this(4096, 8192, 8192, true);
    }

    private long contentLength() {
        if (this.contentLength == Long.MIN_VALUE) {
            this.contentLength = HttpUtil.getContentLength(this.message, -1L);
        }
        return this.contentLength;
    }

    private static int findEndOfString(AppendableCharSequence appendableCharSequence) {
        for (int length = appendableCharSequence.length() - 1; length > 0; length--) {
            if (!Character.isWhitespace(appendableCharSequence.charAtUnsafe(length))) {
                return length + 1;
            }
        }
        return 0;
    }

    private static int findNonWhitespace(AppendableCharSequence appendableCharSequence, int i4) {
        while (i4 < appendableCharSequence.length()) {
            if (!Character.isWhitespace(appendableCharSequence.charAtUnsafe(i4))) {
                return i4;
            }
            i4++;
        }
        return appendableCharSequence.length();
    }

    private static int findWhitespace(AppendableCharSequence appendableCharSequence, int i4) {
        while (i4 < appendableCharSequence.length()) {
            if (Character.isWhitespace(appendableCharSequence.charAtUnsafe(i4))) {
                return i4;
            }
            i4++;
        }
        return appendableCharSequence.length();
    }

    private static int getChunkSize(String str) {
        String trim = str.trim();
        for (int i4 = 0; i4 < trim.length(); i4++) {
            char charAt = trim.charAt(i4);
            if (charAt == ';' || Character.isWhitespace(charAt) || Character.isISOControl(charAt)) {
                trim = trim.substring(0, i4);
                break;
            }
        }
        return Integer.parseInt(trim, 16);
    }

    private HttpContent invalidChunk(ByteBuf byteBuf, Exception exc) {
        this.currentState = State.BAD_MESSAGE;
        byteBuf.skipBytes(byteBuf.readableBytes());
        DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER);
        defaultLastHttpContent.setDecoderResult(DecoderResult.failure(exc));
        this.message = null;
        this.trailer = null;
        return defaultLastHttpContent;
    }

    private HttpMessage invalidMessage(ByteBuf byteBuf, Exception exc) {
        this.currentState = State.BAD_MESSAGE;
        byteBuf.skipBytes(byteBuf.readableBytes());
        HttpMessage httpMessage = this.message;
        if (httpMessage != null) {
            httpMessage.setDecoderResult(DecoderResult.failure(exc));
        } else {
            HttpMessage createInvalidMessage = createInvalidMessage();
            this.message = createInvalidMessage;
            createInvalidMessage.setDecoderResult(DecoderResult.failure(exc));
        }
        HttpMessage httpMessage2 = this.message;
        this.message = null;
        return httpMessage2;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private io.netty.handler.codec.http.HttpObjectDecoder.State readHeaders(io.netty.buffer.ByteBuf r10) {
        /*
            r9 = this;
            io.netty.handler.codec.http.HttpMessage r0 = r9.message
            io.netty.handler.codec.http.HttpHeaders r1 = r0.headers()
            io.netty.handler.codec.http.HttpObjectDecoder$HeaderParser r2 = r9.headerParser
            io.netty.util.internal.AppendableCharSequence r2 = r2.parse(r10)
            r3 = 0
            if (r2 != 0) goto L10
            return r3
        L10:
            int r4 = r2.length()
            r5 = 0
            if (r4 <= 0) goto L6c
        L17:
            char r4 = r2.charAt(r5)
            java.lang.CharSequence r6 = r9.name
            if (r6 == 0) goto L53
            r7 = 32
            if (r4 == r7) goto L27
            r8 = 9
            if (r4 != r8) goto L53
        L27:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.CharSequence r6 = r9.value
            int r6 = r6.length()
            int r8 = r2.length()
            int r6 = r6 + r8
            int r6 = r6 + 1
            r4.<init>(r6)
            java.lang.CharSequence r6 = r9.value
            r4.append(r6)
            r4.append(r7)
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.trim()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r9.value = r2
            goto L5d
        L53:
            if (r6 == 0) goto L5a
            java.lang.CharSequence r4 = r9.value
            r1.add(r6, r4)
        L5a:
            r9.splitHeader(r2)
        L5d:
            io.netty.handler.codec.http.HttpObjectDecoder$HeaderParser r2 = r9.headerParser
            io.netty.util.internal.AppendableCharSequence r2 = r2.parse(r10)
            if (r2 != 0) goto L66
            return r3
        L66:
            int r4 = r2.length()
            if (r4 > 0) goto L17
        L6c:
            java.lang.CharSequence r10 = r9.name
            if (r10 == 0) goto L75
            java.lang.CharSequence r2 = r9.value
            r1.add(r10, r2)
        L75:
            r9.name = r3
            r9.value = r3
            boolean r10 = r9.isContentAlwaysEmpty(r0)
            if (r10 == 0) goto L85
            io.netty.handler.codec.http.HttpUtil.setTransferEncodingChunked(r0, r5)
            io.netty.handler.codec.http.HttpObjectDecoder$State r10 = io.netty.handler.codec.http.HttpObjectDecoder.State.SKIP_CONTROL_CHARS
            goto L9d
        L85:
            boolean r10 = io.netty.handler.codec.http.HttpUtil.isTransferEncodingChunked(r0)
            if (r10 == 0) goto L8e
            io.netty.handler.codec.http.HttpObjectDecoder$State r10 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_CHUNK_SIZE
            goto L9d
        L8e:
            long r0 = r9.contentLength()
            r2 = 0
            int r10 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r10 < 0) goto L9b
            io.netty.handler.codec.http.HttpObjectDecoder$State r10 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_FIXED_LENGTH_CONTENT
            goto L9d
        L9b:
            io.netty.handler.codec.http.HttpObjectDecoder$State r10 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_VARIABLE_LENGTH_CONTENT
        L9d:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.HttpObjectDecoder.readHeaders(io.netty.buffer.ByteBuf):io.netty.handler.codec.http.HttpObjectDecoder$State");
    }

    private LastHttpContent readTrailingHeaders(ByteBuf byteBuf) {
        AppendableCharSequence parse = this.headerParser.parse(byteBuf);
        if (parse == null) {
            return null;
        }
        if (parse.length() > 0) {
            LastHttpContent lastHttpContent = this.trailer;
            if (lastHttpContent == null) {
                lastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER, this.validateHeaders);
                this.trailer = lastHttpContent;
            }
            CharSequence charSequence = null;
            do {
                char charAt = parse.charAt(0);
                if (charSequence != null && (charAt == ' ' || charAt == '\t')) {
                    List<String> all = lastHttpContent.trailingHeaders().getAll(charSequence);
                    if (!all.isEmpty()) {
                        int size = all.size() - 1;
                        String trim = parse.toString().trim();
                        String str = all.get(size);
                        StringBuilder sb = new StringBuilder(str.length() + trim.length());
                        sb.append((CharSequence) str);
                        sb.append(trim);
                        all.set(size, sb.toString());
                    }
                } else {
                    splitHeader(parse);
                    CharSequence charSequence2 = this.name;
                    if (!HttpHeaderNames.CONTENT_LENGTH.contentEqualsIgnoreCase(charSequence2) && !HttpHeaderNames.TRANSFER_ENCODING.contentEqualsIgnoreCase(charSequence2) && !HttpHeaderNames.TRAILER.contentEqualsIgnoreCase(charSequence2)) {
                        lastHttpContent.trailingHeaders().add(charSequence2, this.value);
                    }
                    charSequence = this.name;
                    this.name = null;
                    this.value = null;
                }
                parse = this.headerParser.parse(byteBuf);
                if (parse == null) {
                    return null;
                }
            } while (parse.length() > 0);
            this.trailer = null;
            return lastHttpContent;
        }
        return LastHttpContent.EMPTY_LAST_CONTENT;
    }

    private void resetNow() {
        HttpResponse httpResponse;
        HttpMessage httpMessage = this.message;
        this.message = null;
        this.name = null;
        this.value = null;
        this.contentLength = Long.MIN_VALUE;
        this.lineParser.reset();
        this.headerParser.reset();
        this.trailer = null;
        if (!isDecodingRequest() && (httpResponse = (HttpResponse) httpMessage) != null && httpResponse.status().code() == 101) {
            this.currentState = State.UPGRADED;
        } else {
            this.currentState = State.SKIP_CONTROL_CHARS;
        }
    }

    private static boolean skipControlCharacters(ByteBuf byteBuf) {
        boolean z3;
        int writerIndex = byteBuf.writerIndex();
        int readerIndex = byteBuf.readerIndex();
        while (true) {
            if (writerIndex <= readerIndex) {
                z3 = false;
                break;
            }
            int i4 = readerIndex + 1;
            short unsignedByte = byteBuf.getUnsignedByte(readerIndex);
            if (!Character.isISOControl(unsignedByte) && !Character.isWhitespace(unsignedByte)) {
                readerIndex = i4 - 1;
                z3 = true;
                break;
            }
            readerIndex = i4;
        }
        byteBuf.readerIndex(readerIndex);
        return z3;
    }

    private void splitHeader(AppendableCharSequence appendableCharSequence) {
        char charAt;
        int length = appendableCharSequence.length();
        int findNonWhitespace = findNonWhitespace(appendableCharSequence, 0);
        int i4 = findNonWhitespace;
        while (i4 < length && (charAt = appendableCharSequence.charAt(i4)) != ':' && !Character.isWhitespace(charAt)) {
            i4++;
        }
        int i5 = i4;
        while (true) {
            if (i5 >= length) {
                break;
            } else if (appendableCharSequence.charAt(i5) == ':') {
                i5++;
                break;
            } else {
                i5++;
            }
        }
        this.name = appendableCharSequence.subStringUnsafe(findNonWhitespace, i4);
        int findNonWhitespace2 = findNonWhitespace(appendableCharSequence, i5);
        if (findNonWhitespace2 == length) {
            this.value = "";
        } else {
            this.value = appendableCharSequence.subStringUnsafe(findNonWhitespace2, findEndOfString(appendableCharSequence));
        }
    }

    private static String[] splitInitialLine(AppendableCharSequence appendableCharSequence) {
        int findNonWhitespace = findNonWhitespace(appendableCharSequence, 0);
        int findWhitespace = findWhitespace(appendableCharSequence, findNonWhitespace);
        int findNonWhitespace2 = findNonWhitespace(appendableCharSequence, findWhitespace);
        int findWhitespace2 = findWhitespace(appendableCharSequence, findNonWhitespace2);
        int findNonWhitespace3 = findNonWhitespace(appendableCharSequence, findWhitespace2);
        int findEndOfString = findEndOfString(appendableCharSequence);
        String[] strArr = new String[3];
        strArr[0] = appendableCharSequence.subStringUnsafe(findNonWhitespace, findWhitespace);
        strArr[1] = appendableCharSequence.subStringUnsafe(findNonWhitespace2, findWhitespace2);
        strArr[2] = findNonWhitespace3 < findEndOfString ? appendableCharSequence.subStringUnsafe(findNonWhitespace3, findEndOfString) : "";
        return strArr;
    }

    protected abstract HttpMessage createInvalidMessage();

    protected abstract HttpMessage createMessage(String[] strArr) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0106 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0126 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0127 A[Catch: Exception -> 0x01ab, TryCatch #1 {Exception -> 0x01ab, blocks: (B:65:0x011e, B:68:0x0127, B:70:0x012f, B:72:0x0134), top: B:109:0x011e }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0144 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0145 A[Catch: Exception -> 0x01a2, TryCatch #3 {Exception -> 0x01a2, blocks: (B:73:0x013e, B:76:0x0145, B:80:0x0153, B:84:0x0161, B:87:0x0168, B:89:0x0171, B:91:0x0174, B:93:0x0182, B:95:0x0186, B:97:0x018c, B:98:0x0193, B:99:0x0194), top: B:111:0x013e }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void decode(io.netty.channel.ChannelHandlerContext r8, io.netty.buffer.ByteBuf r9, java.util.List<java.lang.Object> r10) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.HttpObjectDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        super.decodeLast(channelHandlerContext, byteBuf, list);
        if (this.resetRequested) {
            resetNow();
        }
        HttpMessage httpMessage = this.message;
        if (httpMessage != null) {
            boolean isTransferEncodingChunked = HttpUtil.isTransferEncodingChunked(httpMessage);
            if (this.currentState == State.READ_VARIABLE_LENGTH_CONTENT && !byteBuf.isReadable() && !isTransferEncodingChunked) {
                list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                resetNow();
            } else if (this.currentState == State.READ_HEADER) {
                list.add(invalidMessage(Unpooled.EMPTY_BUFFER, new PrematureChannelClosureException("Connection closed before received headers")));
                resetNow();
            } else {
                boolean z3 = true;
                if (!isDecodingRequest() && !isTransferEncodingChunked && contentLength() <= 0) {
                    z3 = false;
                }
                if (!z3) {
                    list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                }
                resetNow();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
        if (httpMessage instanceof HttpResponse) {
            HttpResponse httpResponse = (HttpResponse) httpMessage;
            int code = httpResponse.status().code();
            if (code >= 100 && code < 200) {
                return (code == 101 && !httpResponse.headers().contains(HttpHeaderNames.SEC_WEBSOCKET_ACCEPT) && httpResponse.headers().contains((CharSequence) HttpHeaderNames.UPGRADE, (CharSequence) HttpHeaderValues.WEBSOCKET, true)) ? false : true;
            } else if (code == 204 || code == 205 || code == 304) {
                return true;
            }
        }
        return false;
    }

    protected abstract boolean isDecodingRequest();

    public void reset() {
        this.resetRequested = true;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        int i4;
        if ((obj instanceof HttpExpectationFailedEvent) && ((i4 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[this.currentState.ordinal()]) == 2 || i4 == 5 || i4 == 6)) {
            reset();
        }
        super.userEventTriggered(channelHandlerContext, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpObjectDecoder(int i4, int i5, int i6, boolean z3) {
        this(i4, i5, i6, z3, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpObjectDecoder(int i4, int i5, int i6, boolean z3, boolean z4) {
        this(i4, i5, i6, z3, z4, 128);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpObjectDecoder(int i4, int i5, int i6, boolean z3, boolean z4, int i7) {
        this.contentLength = Long.MIN_VALUE;
        this.currentState = State.SKIP_CONTROL_CHARS;
        if (i4 <= 0) {
            throw new IllegalArgumentException("maxInitialLineLength must be a positive integer: " + i4);
        } else if (i5 <= 0) {
            throw new IllegalArgumentException("maxHeaderSize must be a positive integer: " + i5);
        } else if (i6 > 0) {
            AppendableCharSequence appendableCharSequence = new AppendableCharSequence(i7);
            this.lineParser = new LineParser(appendableCharSequence, i4);
            this.headerParser = new HeaderParser(appendableCharSequence, i5);
            this.maxChunkSize = i6;
            this.chunkedSupported = z3;
            this.validateHeaders = z4;
        } else {
            throw new IllegalArgumentException("maxChunkSize must be a positive integer: " + i6);
        }
    }
}
