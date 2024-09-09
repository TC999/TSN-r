package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.AsciiString;
import io.netty.util.internal.AppendableCharSequence;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class StompSubframeDecoder extends ReplayingDecoder<State> {
    private static final int DEFAULT_CHUNK_SIZE = 8132;
    private static final int DEFAULT_MAX_LINE_LENGTH = 1024;
    private int alreadyReadChunkSize;
    private long contentLength;
    private LastStompContentSubframe lastContent;
    private final int maxChunkSize;
    private final int maxLineLength;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: io.netty.handler.codec.stomp.StompSubframeDecoder$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State = iArr;
            try {
                iArr[State.SKIP_CONTROL_CHARACTERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State[State.READ_HEADERS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State[State.BAD_FRAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State[State.READ_CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State[State.FINALIZE_FRAME_READ.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum State {
        SKIP_CONTROL_CHARACTERS,
        READ_HEADERS,
        READ_CONTENT,
        FINALIZE_FRAME_READ,
        BAD_FRAME,
        INVALID_CHUNK
    }

    public StompSubframeDecoder() {
        this(1024, 8132);
    }

    private static long getContentLength(StompHeaders stompHeaders, long j4) {
        AsciiString asciiString = StompHeaders.CONTENT_LENGTH;
        long j5 = stompHeaders.getLong(asciiString, j4);
        if (j5 >= 0) {
            return j5;
        }
        throw new DecoderException(((Object) asciiString) + " must be non-negative");
    }

    private StompCommand readCommand(ByteBuf byteBuf) {
        StompCommand stompCommand;
        String readLine = readLine(byteBuf, this.maxLineLength);
        try {
            stompCommand = StompCommand.valueOf(readLine);
        } catch (IllegalArgumentException unused) {
            stompCommand = null;
        }
        if (stompCommand == null) {
            try {
                stompCommand = StompCommand.valueOf(readLine.toUpperCase(Locale.US));
            } catch (IllegalArgumentException unused2) {
            }
        }
        if (stompCommand != null) {
            return stompCommand;
        }
        throw new DecoderException("failed to read command from channel");
    }

    private State readHeaders(ByteBuf byteBuf, StompHeaders stompHeaders) {
        while (true) {
            String readLine = readLine(byteBuf, this.maxLineLength);
            if (readLine.isEmpty()) {
                break;
            }
            String[] split = readLine.split(":");
            if (split.length == 2) {
                stompHeaders.add((StompHeaders) split[0], split[1]);
            }
        }
        if (stompHeaders.contains(StompHeaders.CONTENT_LENGTH)) {
            long contentLength = getContentLength(stompHeaders, 0L);
            this.contentLength = contentLength;
            if (contentLength == 0) {
                return State.FINALIZE_FRAME_READ;
            }
        }
        return State.READ_CONTENT;
    }

    private static String readLine(ByteBuf byteBuf, int i4) {
        AppendableCharSequence appendableCharSequence = new AppendableCharSequence(128);
        int i5 = 0;
        while (true) {
            byte readByte = byteBuf.readByte();
            if (readByte == 13) {
                if (byteBuf.readByte() == 10) {
                    return appendableCharSequence.toString();
                }
            } else if (readByte == 10) {
                return appendableCharSequence.toString();
            } else {
                if (i5 < i4) {
                    i5++;
                    appendableCharSequence.append((char) readByte);
                } else {
                    throw new TooLongFrameException("An STOMP line is larger than " + i4 + " bytes.");
                }
            }
        }
    }

    private void resetDecoder() {
        checkpoint(State.SKIP_CONTROL_CHARACTERS);
        this.contentLength = -1L;
        this.alreadyReadChunkSize = 0;
        this.lastContent = null;
    }

    private static void skipControlCharacters(ByteBuf byteBuf) {
        while (true) {
            byte readByte = byteBuf.readByte();
            if (readByte != 13 && readByte != 10) {
                byteBuf.readerIndex(byteBuf.readerIndex() - 1);
                return;
            }
        }
    }

    private static void skipNullCharacter(ByteBuf byteBuf) {
        byte readByte = byteBuf.readByte();
        if (readByte == 0) {
            return;
        }
        throw new IllegalStateException("unexpected byte in buffer " + ((int) readByte) + " while expecting NULL byte");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056 A[Catch: Exception -> 0x00ff, TryCatch #0 {Exception -> 0x00ff, blocks: (B:15:0x0042, B:45:0x00e2, B:47:0x00e9, B:48:0x00ed, B:20:0x0056, B:23:0x005d, B:26:0x0062, B:28:0x006a, B:31:0x0072, B:33:0x0086, B:34:0x0093, B:36:0x009c, B:38:0x00af, B:40:0x00b7, B:42:0x00c7, B:44:0x00d6, B:49:0x00f6, B:41:0x00be), top: B:61:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e9 A[Catch: Exception -> 0x00ff, TryCatch #0 {Exception -> 0x00ff, blocks: (B:15:0x0042, B:45:0x00e2, B:47:0x00e9, B:48:0x00ed, B:20:0x0056, B:23:0x005d, B:26:0x0062, B:28:0x006a, B:31:0x0072, B:33:0x0086, B:34:0x0093, B:36:0x009c, B:38:0x00af, B:40:0x00b7, B:42:0x00c7, B:44:0x00d6, B:49:0x00f6, B:41:0x00be), top: B:61:0x0042 }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void decode(io.netty.channel.ChannelHandlerContext r7, io.netty.buffer.ByteBuf r8, java.util.List<java.lang.Object> r9) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.stomp.StompSubframeDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public StompSubframeDecoder(int i4, int i5) {
        super(State.SKIP_CONTROL_CHARACTERS);
        this.contentLength = -1L;
        if (i4 <= 0) {
            throw new IllegalArgumentException("maxLineLength must be a positive integer: " + i4);
        } else if (i5 > 0) {
            this.maxChunkSize = i5;
            this.maxLineLength = i4;
        } else {
            throw new IllegalArgumentException("maxChunkSize must be a positive integer: " + i5);
        }
    }
}
