package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class RedisDecoder extends ByteToMessageDecoder {
    private final int maxInlineMessageLength;
    private final RedisMessagePool messagePool;
    private int remainingBulkLength;
    private State state;
    private final ToPositiveLongProcessor toPositiveLongProcessor;
    private RedisMessageType type;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: io.netty.handler.codec.redis.RedisDecoder$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$redis$RedisMessageType;

        static {
            int[] iArr = new int[RedisMessageType.values().length];
            $SwitchMap$io$netty$handler$codec$redis$RedisMessageType = iArr;
            try {
                iArr[RedisMessageType.ARRAY_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisMessageType[RedisMessageType.BULK_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisMessageType[RedisMessageType.SIMPLE_STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisMessageType[RedisMessageType.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisMessageType[RedisMessageType.INTEGER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State = iArr2;
            try {
                iArr2[State.DECODE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State[State.DECODE_INLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State[State.DECODE_LENGTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State[State.DECODE_BULK_STRING_EOL.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State[State.DECODE_BULK_STRING_CONTENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum State {
        DECODE_TYPE,
        DECODE_INLINE,
        DECODE_LENGTH,
        DECODE_BULK_STRING_EOL,
        DECODE_BULK_STRING_CONTENT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class ToPositiveLongProcessor implements ByteProcessor {
        private long result;

        private ToPositiveLongProcessor() {
        }

        public long content() {
            return this.result;
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b4) throws Exception {
            if (b4 >= 48 && b4 <= 57) {
                this.result = (this.result * 10) + (b4 - 48);
                return true;
            }
            throw new RedisCodecException("bad byte in number: " + ((int) b4));
        }

        public void reset() {
            this.result = 0L;
        }

        /* synthetic */ ToPositiveLongProcessor(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public RedisDecoder() {
        this(65536, FixedRedisMessagePool.INSTANCE);
    }

    private boolean decodeBulkString(ByteBuf byteBuf, List<Object> list) throws Exception {
        int i4 = this.remainingBulkLength;
        if (i4 == -1) {
            list.add(FullBulkStringRedisMessage.NULL_INSTANCE);
            resetDecoder();
            return true;
        } else if (i4 != 0) {
            list.add(new BulkStringHeaderRedisMessage(i4));
            this.state = State.DECODE_BULK_STRING_CONTENT;
            return decodeBulkStringContent(byteBuf, list);
        } else {
            this.state = State.DECODE_BULK_STRING_EOL;
            return decodeBulkStringEndOfLine(byteBuf, list);
        }
    }

    private boolean decodeBulkStringContent(ByteBuf byteBuf, List<Object> list) throws Exception {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            return false;
        }
        int i4 = this.remainingBulkLength;
        if (readableBytes >= i4 + 2) {
            ByteBuf readSlice = byteBuf.readSlice(i4);
            readEndOfLine(byteBuf);
            list.add(new DefaultLastBulkStringRedisContent(readSlice.retain()));
            resetDecoder();
            return true;
        }
        int min = Math.min(i4, readableBytes);
        this.remainingBulkLength -= min;
        list.add(new DefaultBulkStringRedisContent(byteBuf.readSlice(min).retain()));
        return true;
    }

    private boolean decodeBulkStringEndOfLine(ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() < 2) {
            return false;
        }
        readEndOfLine(byteBuf);
        list.add(FullBulkStringRedisMessage.EMPTY_INSTANCE);
        resetDecoder();
        return true;
    }

    private boolean decodeInline(ByteBuf byteBuf, List<Object> list) throws Exception {
        ByteBuf readLine = readLine(byteBuf);
        if (readLine == null) {
            if (byteBuf.readableBytes() <= this.maxInlineMessageLength) {
                return false;
            }
            throw new RedisCodecException("length: " + byteBuf.readableBytes() + " (expected: <= " + this.maxInlineMessageLength + ")");
        }
        list.add(newInlineRedisMessage(this.type, readLine));
        resetDecoder();
        return true;
    }

    private boolean decodeLength(ByteBuf byteBuf, List<Object> list) throws Exception {
        ByteBuf readLine = readLine(byteBuf);
        if (readLine == null) {
            return false;
        }
        long parseRedisNumber = parseRedisNumber(readLine);
        if (parseRedisNumber >= -1) {
            int i4 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$redis$RedisMessageType[this.type.ordinal()];
            if (i4 == 1) {
                list.add(new ArrayHeaderRedisMessage(parseRedisNumber));
                resetDecoder();
                return true;
            } else if (i4 != 2) {
                throw new RedisCodecException("bad type: " + this.type);
            } else if (parseRedisNumber <= 536870912) {
                this.remainingBulkLength = (int) parseRedisNumber;
                return decodeBulkString(byteBuf, list);
            } else {
                throw new RedisCodecException("length: " + parseRedisNumber + " (expected: <= 536870912)");
            }
        }
        throw new RedisCodecException("length: " + parseRedisNumber + " (expected: >= -1)");
    }

    private boolean decodeType(ByteBuf byteBuf) throws Exception {
        if (byteBuf.isReadable()) {
            RedisMessageType valueOf = RedisMessageType.valueOf(byteBuf.readByte());
            this.type = valueOf;
            this.state = valueOf.isInline() ? State.DECODE_INLINE : State.DECODE_LENGTH;
            return true;
        }
        return false;
    }

    private RedisMessage newInlineRedisMessage(RedisMessageType redisMessageType, ByteBuf byteBuf) {
        int i4 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$redis$RedisMessageType[redisMessageType.ordinal()];
        if (i4 == 3) {
            SimpleStringRedisMessage simpleString = this.messagePool.getSimpleString(byteBuf);
            return simpleString != null ? simpleString : new SimpleStringRedisMessage(byteBuf.toString(CharsetUtil.UTF_8));
        } else if (i4 == 4) {
            ErrorRedisMessage error = this.messagePool.getError(byteBuf);
            return error != null ? error : new ErrorRedisMessage(byteBuf.toString(CharsetUtil.UTF_8));
        } else if (i4 == 5) {
            IntegerRedisMessage integer = this.messagePool.getInteger(byteBuf);
            return integer != null ? integer : new IntegerRedisMessage(parseRedisNumber(byteBuf));
        } else {
            throw new RedisCodecException("bad type: " + redisMessageType);
        }
    }

    private long parsePositiveNumber(ByteBuf byteBuf) {
        this.toPositiveLongProcessor.reset();
        byteBuf.forEachByte(this.toPositiveLongProcessor);
        return this.toPositiveLongProcessor.content();
    }

    private long parseRedisNumber(ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        int i4 = (readableBytes <= 0 || byteBuf.getByte(byteBuf.readerIndex()) != 45) ? 0 : 1;
        if (readableBytes <= i4) {
            throw new RedisCodecException("no number to parse: " + byteBuf.toString(CharsetUtil.US_ASCII));
        } else if (readableBytes <= i4 + 19) {
            if (i4 != 0) {
                return -parsePositiveNumber(byteBuf.skipBytes(i4));
            }
            return parsePositiveNumber(byteBuf);
        } else {
            throw new RedisCodecException("too many characters to be a valid RESP Integer: " + byteBuf.toString(CharsetUtil.US_ASCII));
        }
    }

    private static void readEndOfLine(ByteBuf byteBuf) {
        short readShort = byteBuf.readShort();
        if (RedisConstants.EOL_SHORT == readShort) {
            return;
        }
        byte[] shortToBytes = RedisCodecUtil.shortToBytes(readShort);
        throw new RedisCodecException("delimiter: [" + ((int) shortToBytes[0]) + "," + ((int) shortToBytes[1]) + "] (expected: \\r\\n)");
    }

    private static ByteBuf readLine(ByteBuf byteBuf) {
        int forEachByte;
        if (byteBuf.isReadable(2) && (forEachByte = byteBuf.forEachByte(ByteProcessor.FIND_LF)) >= 0) {
            ByteBuf readSlice = byteBuf.readSlice((forEachByte - byteBuf.readerIndex()) - 1);
            readEndOfLine(byteBuf);
            return readSlice;
        }
        return null;
    }

    private void resetDecoder() {
        this.state = State.DECODE_TYPE;
        this.remainingBulkLength = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
        throw new io.netty.handler.codec.redis.RedisCodecException("Unknown state: " + r1.state);
     */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void decode(io.netty.channel.ChannelHandlerContext r2, io.netty.buffer.ByteBuf r3, java.util.List<java.lang.Object> r4) throws java.lang.Exception {
        /*
            r1 = this;
        L0:
            int[] r2 = io.netty.handler.codec.redis.RedisDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State     // Catch: java.lang.Exception -> L55 io.netty.handler.codec.redis.RedisCodecException -> L5f
            io.netty.handler.codec.redis.RedisDecoder$State r0 = r1.state     // Catch: java.lang.Exception -> L55 io.netty.handler.codec.redis.RedisCodecException -> L5f
            int r0 = r0.ordinal()     // Catch: java.lang.Exception -> L55 io.netty.handler.codec.redis.RedisCodecException -> L5f
            r2 = r2[r0]     // Catch: java.lang.Exception -> L55 io.netty.handler.codec.redis.RedisCodecException -> L5f
            r0 = 1
            if (r2 == r0) goto L4e
            r0 = 2
            if (r2 == r0) goto L47
            r0 = 3
            if (r2 == r0) goto L40
            r0 = 4
            if (r2 == r0) goto L39
            r0 = 5
            if (r2 != r0) goto L20
            boolean r2 = r1.decodeBulkStringContent(r3, r4)     // Catch: java.lang.Exception -> L55 io.netty.handler.codec.redis.RedisCodecException -> L5f
            if (r2 != 0) goto L0
            return
        L20:
            io.netty.handler.codec.redis.RedisCodecException r2 = new io.netty.handler.codec.redis.RedisCodecException     // Catch: java.lang.Exception -> L55 io.netty.handler.codec.redis.RedisCodecException -> L5f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L55 io.netty.handler.codec.redis.RedisCodecException -> L5f
            r3.<init>()     // Catch: java.lang.Exception -> L55 io.netty.handler.codec.redis.RedisCodecException -> L5f
            java.lang.String r4 = "Unknown state: "
            r3.append(r4)     // Catch: java.lang.Exception -> L55 io.netty.handler.codec.redis.RedisCodecException -> L5f
            io.netty.handler.codec.redis.RedisDecoder$State r4 = r1.state     // Catch: java.lang.Exception -> L55 io.netty.handler.codec.redis.RedisCodecException -> L5f
            r3.append(r4)     // Catch: java.lang.Exception -> L55 io.netty.handler.codec.redis.RedisCodecException -> L5f
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L55 io.netty.handler.codec.redis.RedisCodecException -> L5f
            r2.<init>(r3)     // Catch: java.lang.Exception -> L55 io.netty.handler.codec.redis.RedisCodecException -> L5f
            throw r2     // Catch: java.lang.Exception -> L55 io.netty.handler.codec.redis.RedisCodecException -> L5f
        L39:
            boolean r2 = r1.decodeBulkStringEndOfLine(r3, r4)     // Catch: java.lang.Exception -> L55 io.netty.handler.codec.redis.RedisCodecException -> L5f
            if (r2 != 0) goto L0
            return
        L40:
            boolean r2 = r1.decodeLength(r3, r4)     // Catch: java.lang.Exception -> L55 io.netty.handler.codec.redis.RedisCodecException -> L5f
            if (r2 != 0) goto L0
            return
        L47:
            boolean r2 = r1.decodeInline(r3, r4)     // Catch: java.lang.Exception -> L55 io.netty.handler.codec.redis.RedisCodecException -> L5f
            if (r2 != 0) goto L0
            return
        L4e:
            boolean r2 = r1.decodeType(r3)     // Catch: java.lang.Exception -> L55 io.netty.handler.codec.redis.RedisCodecException -> L5f
            if (r2 != 0) goto L0
            return
        L55:
            r2 = move-exception
            r1.resetDecoder()
            io.netty.handler.codec.redis.RedisCodecException r3 = new io.netty.handler.codec.redis.RedisCodecException
            r3.<init>(r2)
            throw r3
        L5f:
            r2 = move-exception
            r1.resetDecoder()
            goto L65
        L64:
            throw r2
        L65:
            goto L64
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.redis.RedisDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public RedisDecoder(int i4, RedisMessagePool redisMessagePool) {
        this.toPositiveLongProcessor = new ToPositiveLongProcessor(null);
        this.state = State.DECODE_TYPE;
        if (i4 > 0 && i4 <= 536870912) {
            this.maxInlineMessageLength = i4;
            this.messagePool = redisMessagePool;
            return;
        }
        throw new RedisCodecException("maxInlineMessageLength: " + i4 + " (expected: <= 536870912)");
    }
}
