package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class Snappy {
    private static final int COPY_1_BYTE_OFFSET = 1;
    private static final int COPY_2_BYTE_OFFSET = 2;
    private static final int COPY_4_BYTE_OFFSET = 3;
    private static final int LITERAL = 0;
    private static final int MAX_HT_SIZE = 16384;
    private static final int MIN_COMPRESSIBLE_BYTES = 15;
    private static final int NOT_ENOUGH_INPUT = -1;
    private static final int PREAMBLE_NOT_FULL = -1;
    private State state = State.READY;
    private byte tag;
    private int written;

    /* renamed from: io.netty.handler.codec.compression.Snappy$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C137941 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$Snappy$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$Snappy$State = iArr;
            try {
                iArr[State.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_PREAMBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_TAG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_LITERAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_COPY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private enum State {
        READY,
        READING_PREAMBLE,
        READING_TAG,
        READING_LITERAL,
        READING_COPY
    }

    private static int bitsToEncode(int i) {
        int highestOneBit = Integer.highestOneBit(i);
        int i2 = 0;
        while (true) {
            highestOneBit >>= 1;
            if (highestOneBit == 0) {
                return i2;
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int calculateChecksum(ByteBuf byteBuf) {
        return calculateChecksum(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    private static int decodeCopyWith1ByteOffset(byte b, ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        if (byteBuf.isReadable()) {
            int writerIndex = byteBuf2.writerIndex();
            int i2 = ((b & 28) >> 2) + 4;
            int readUnsignedByte = (((b & 224) << 8) >> 5) | byteBuf.readUnsignedByte();
            validateOffset(readUnsignedByte, i);
            byteBuf2.markReaderIndex();
            if (readUnsignedByte < i2) {
                for (int i3 = i2 / readUnsignedByte; i3 > 0; i3--) {
                    byteBuf2.readerIndex(writerIndex - readUnsignedByte);
                    byteBuf2.readBytes(byteBuf2, readUnsignedByte);
                }
                int i4 = i2 % readUnsignedByte;
                if (i4 != 0) {
                    byteBuf2.readerIndex(writerIndex - readUnsignedByte);
                    byteBuf2.readBytes(byteBuf2, i4);
                }
            } else {
                byteBuf2.readerIndex(writerIndex - readUnsignedByte);
                byteBuf2.readBytes(byteBuf2, i2);
            }
            byteBuf2.resetReaderIndex();
            return i2;
        }
        return -1;
    }

    private static int decodeCopyWith2ByteOffset(byte b, ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        if (byteBuf.readableBytes() < 2) {
            return -1;
        }
        int writerIndex = byteBuf2.writerIndex();
        int i2 = ((b >> 2) & 63) + 1;
        short readShortLE = byteBuf.readShortLE();
        validateOffset(readShortLE, i);
        byteBuf2.markReaderIndex();
        if (readShortLE < i2) {
            for (int i3 = i2 / readShortLE; i3 > 0; i3--) {
                byteBuf2.readerIndex(writerIndex - readShortLE);
                byteBuf2.readBytes(byteBuf2, readShortLE);
            }
            int i4 = i2 % readShortLE;
            if (i4 != 0) {
                byteBuf2.readerIndex(writerIndex - readShortLE);
                byteBuf2.readBytes(byteBuf2, i4);
            }
        } else {
            byteBuf2.readerIndex(writerIndex - readShortLE);
            byteBuf2.readBytes(byteBuf2, i2);
        }
        byteBuf2.resetReaderIndex();
        return i2;
    }

    private static int decodeCopyWith4ByteOffset(byte b, ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        if (byteBuf.readableBytes() < 4) {
            return -1;
        }
        int writerIndex = byteBuf2.writerIndex();
        int i2 = ((b >> 2) & 63) + 1;
        int readIntLE = byteBuf.readIntLE();
        validateOffset(readIntLE, i);
        byteBuf2.markReaderIndex();
        if (readIntLE < i2) {
            for (int i3 = i2 / readIntLE; i3 > 0; i3--) {
                byteBuf2.readerIndex(writerIndex - readIntLE);
                byteBuf2.readBytes(byteBuf2, readIntLE);
            }
            int i4 = i2 % readIntLE;
            if (i4 != 0) {
                byteBuf2.readerIndex(writerIndex - readIntLE);
                byteBuf2.readBytes(byteBuf2, i4);
            }
        } else {
            byteBuf2.readerIndex(writerIndex - readIntLE);
            byteBuf2.readBytes(byteBuf2, i2);
        }
        byteBuf2.resetReaderIndex();
        return i2;
    }

    static int decodeLiteral(byte b, ByteBuf byteBuf, ByteBuf byteBuf2) {
        byteBuf.markReaderIndex();
        int i = (b >> 2) & 63;
        switch (i) {
            case 60:
                if (byteBuf.isReadable()) {
                    i = byteBuf.readUnsignedByte();
                    break;
                } else {
                    return -1;
                }
            case 61:
                if (byteBuf.readableBytes() >= 2) {
                    i = byteBuf.readShortLE();
                    break;
                } else {
                    return -1;
                }
            case 62:
                if (byteBuf.readableBytes() >= 3) {
                    i = byteBuf.readUnsignedMediumLE();
                    break;
                } else {
                    return -1;
                }
            case 63:
                if (byteBuf.readableBytes() >= 4) {
                    i = byteBuf.readIntLE();
                    break;
                } else {
                    return -1;
                }
        }
        int i2 = i + 1;
        if (byteBuf.readableBytes() < i2) {
            byteBuf.resetReaderIndex();
            return -1;
        }
        byteBuf2.writeBytes(byteBuf, i2);
        return i2;
    }

    private static void encodeCopy(ByteBuf byteBuf, int i, int i2) {
        while (i2 >= 68) {
            encodeCopyWithOffset(byteBuf, i, 64);
            i2 -= 64;
        }
        if (i2 > 64) {
            encodeCopyWithOffset(byteBuf, i, 60);
            i2 -= 60;
        }
        encodeCopyWithOffset(byteBuf, i, i2);
    }

    private static void encodeCopyWithOffset(ByteBuf byteBuf, int i, int i2) {
        if (i2 < 12 && i < 2048) {
            byteBuf.writeByte(((i2 - 4) << 2) | 1 | ((i >> 8) << 5));
            byteBuf.writeByte(i & 255);
            return;
        }
        byteBuf.writeByte(((i2 - 1) << 2) | 2);
        byteBuf.writeByte(i & 255);
        byteBuf.writeByte((i >> 8) & 255);
    }

    static void encodeLiteral(ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        if (i < 61) {
            byteBuf2.writeByte((i - 1) << 2);
        } else {
            int i2 = i - 1;
            int bitsToEncode = (bitsToEncode(i2) / 8) + 1;
            byteBuf2.writeByte((bitsToEncode + 59) << 2);
            for (int i3 = 0; i3 < bitsToEncode; i3++) {
                byteBuf2.writeByte((i2 >> (i3 * 8)) & 255);
            }
        }
        byteBuf2.writeBytes(byteBuf, i);
    }

    private static int findMatchingLength(ByteBuf byteBuf, int i, int i2, int i3) {
        int i4 = 0;
        while (i2 <= i3 - 4 && byteBuf.getInt(i2) == byteBuf.getInt(i + i4)) {
            i2 += 4;
            i4 += 4;
        }
        while (i2 < i3 && byteBuf.getByte(i + i4) == byteBuf.getByte(i2)) {
            i2++;
            i4++;
        }
        return i4;
    }

    private static short[] getHashTable(int i) {
        int i2 = 256;
        while (i2 < 16384 && i2 < i) {
            i2 <<= 1;
        }
        return i2 <= 256 ? new short[256] : new short[16384];
    }

    private static int hash(ByteBuf byteBuf, int i, int i2) {
        return (byteBuf.getInt(i) + 506832829) >>> i2;
    }

    static int maskChecksum(int i) {
        return ((i << 17) | (i >> 15)) - 1568478504;
    }

    private static int readPreamble(ByteBuf byteBuf) {
        int i = 0;
        int i2 = 0;
        while (byteBuf.isReadable()) {
            short readUnsignedByte = byteBuf.readUnsignedByte();
            int i3 = i2 + 1;
            i |= (readUnsignedByte & 127) << (i2 * 7);
            if ((readUnsignedByte & 128) == 0) {
                return i;
            }
            if (i3 >= 4) {
                throw new DecompressionException("Preamble is greater than 4 bytes");
            }
            i2 = i3;
        }
        return 0;
    }

    static void validateChecksum(int i, ByteBuf byteBuf) {
        validateChecksum(i, byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    private static void validateOffset(int i, int i2) {
        if (i > 32767) {
            throw new DecompressionException("Offset exceeds maximum permissible value");
        }
        if (i <= 0) {
            throw new DecompressionException("Offset is less than minimum permissible value");
        }
        if (i > i2) {
            throw new DecompressionException("Offset exceeds size of chunk");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0097 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void decode(io.netty.buffer.ByteBuf r7, io.netty.buffer.ByteBuf r8) {
        /*
            r6 = this;
        L0:
            boolean r0 = r7.isReadable()
            if (r0 == 0) goto Lb5
            int[] r0 = io.netty.handler.codec.compression.Snappy.C137941.$SwitchMap$io$netty$handler$codec$compression$Snappy$State
            io.netty.handler.codec.compression.Snappy$State r1 = r6.state
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 1
            r3 = -1
            r4 = 3
            if (r0 == r2) goto L78
            if (r0 == r1) goto L7c
            if (r0 == r4) goto L91
            r5 = 4
            if (r0 == r5) goto L65
            r5 = 5
            if (r0 == r5) goto L21
            goto L0
        L21:
            byte r0 = r6.tag
            r5 = r0 & 3
            if (r5 == r2) goto L52
            if (r5 == r1) goto L3f
            if (r5 == r4) goto L2c
            goto L0
        L2c:
            int r1 = r6.written
            int r0 = decodeCopyWith4ByteOffset(r0, r7, r8, r1)
            if (r0 == r3) goto L3e
            io.netty.handler.codec.compression.Snappy$State r1 = io.netty.handler.codec.compression.Snappy.State.READING_TAG
            r6.state = r1
            int r1 = r6.written
            int r1 = r1 + r0
            r6.written = r1
            goto L0
        L3e:
            return
        L3f:
            int r1 = r6.written
            int r0 = decodeCopyWith2ByteOffset(r0, r7, r8, r1)
            if (r0 == r3) goto L51
            io.netty.handler.codec.compression.Snappy$State r1 = io.netty.handler.codec.compression.Snappy.State.READING_TAG
            r6.state = r1
            int r1 = r6.written
            int r1 = r1 + r0
            r6.written = r1
            goto L0
        L51:
            return
        L52:
            int r1 = r6.written
            int r0 = decodeCopyWith1ByteOffset(r0, r7, r8, r1)
            if (r0 == r3) goto L64
            io.netty.handler.codec.compression.Snappy$State r1 = io.netty.handler.codec.compression.Snappy.State.READING_TAG
            r6.state = r1
            int r1 = r6.written
            int r1 = r1 + r0
            r6.written = r1
            goto L0
        L64:
            return
        L65:
            byte r0 = r6.tag
            int r0 = decodeLiteral(r0, r7, r8)
            if (r0 == r3) goto L77
            io.netty.handler.codec.compression.Snappy$State r1 = io.netty.handler.codec.compression.Snappy.State.READING_TAG
            r6.state = r1
            int r1 = r6.written
            int r1 = r1 + r0
            r6.written = r1
            goto L0
        L77:
            return
        L78:
            io.netty.handler.codec.compression.Snappy$State r0 = io.netty.handler.codec.compression.Snappy.State.READING_PREAMBLE
            r6.state = r0
        L7c:
            int r0 = readPreamble(r7)
            if (r0 != r3) goto L83
            return
        L83:
            if (r0 != 0) goto L8a
            io.netty.handler.codec.compression.Snappy$State r7 = io.netty.handler.codec.compression.Snappy.State.READY
            r6.state = r7
            return
        L8a:
            r8.ensureWritable(r0)
            io.netty.handler.codec.compression.Snappy$State r0 = io.netty.handler.codec.compression.Snappy.State.READING_TAG
            r6.state = r0
        L91:
            boolean r0 = r7.isReadable()
            if (r0 != 0) goto L98
            return
        L98:
            byte r0 = r7.readByte()
            r6.tag = r0
            r0 = r0 & r4
            if (r0 == 0) goto Laf
            if (r0 == r2) goto La9
            if (r0 == r1) goto La9
            if (r0 == r4) goto La9
            goto L0
        La9:
            io.netty.handler.codec.compression.Snappy$State r0 = io.netty.handler.codec.compression.Snappy.State.READING_COPY
            r6.state = r0
            goto L0
        Laf:
            io.netty.handler.codec.compression.Snappy$State r0 = io.netty.handler.codec.compression.Snappy.State.READING_LITERAL
            r6.state = r0
            goto L0
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Snappy.decode(io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006a, code lost:
        encodeLiteral(r17, r18, r7 - r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006f, code lost:
        r8 = findMatchingLength(r17, r14 + 4, r7 + 4, r19) + 4;
        r9 = r7 + r8;
        encodeCopy(r18, r7 - r14, r8);
        r17.readerIndex(r17.readerIndex() + r8);
        r7 = r9 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0089, code lost:
        if (r9 < r12) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008c, code lost:
        r10 = r9 - r3;
        r4[hash(r17, r7, r5)] = (short) (r10 - 1);
        r8 = r7 + 1;
        r11 = hash(r17, r8, r5);
        r14 = r3 + r4[r11];
        r4[r11] = (short) r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ac, code lost:
        if (r17.getInt(r8) == r17.getInt(r14)) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b7, code lost:
        r7 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void encode(io.netty.buffer.ByteBuf r17, io.netty.buffer.ByteBuf r18, int r19) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = 0
        L7:
            int r4 = r3 * 7
            int r4 = r2 >>> r4
            r5 = r4 & (-128(0xffffffffffffff80, float:NaN))
            if (r5 == 0) goto L19
            r4 = r4 & 127(0x7f, float:1.78E-43)
            r4 = r4 | 128(0x80, float:1.8E-43)
            r1.writeByte(r4)
            int r3 = r3 + 1
            goto L7
        L19:
            r1.writeByte(r4)
            int r3 = r17.readerIndex()
            short[] r4 = getHashTable(r19)
            int r5 = r4.length
            double r5 = (double) r5
            double r5 = java.lang.Math.log(r5)
            r7 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r7 = java.lang.Math.log(r7)
            double r5 = r5 / r7
            double r5 = java.lang.Math.floor(r5)
            int r5 = (int) r5
            r6 = 32
            int r5 = 32 - r5
            int r7 = r2 - r3
            r8 = 15
            if (r7 < r8) goto Lbd
            int r7 = r3 + 1
            int r8 = hash(r0, r7, r5)
            r9 = r3
        L47:
            r10 = 32
        L49:
            int r11 = r10 + 1
            int r10 = r10 >> 5
            int r10 = r10 + r7
            int r12 = r2 + (-4)
            if (r10 <= r12) goto L54
        L52:
            r3 = r9
            goto Lbd
        L54:
            int r13 = hash(r0, r10, r5)
            short r14 = r4[r8]
            int r14 = r14 + r3
            int r15 = r7 - r3
            short r15 = (short) r15
            r4[r8] = r15
            int r8 = r0.getInt(r7)
            int r15 = r0.getInt(r14)
            if (r8 != r15) goto Lb9
            int r8 = r7 - r9
            encodeLiteral(r0, r1, r8)
        L6f:
            int r8 = r14 + 4
            int r9 = r7 + 4
            int r8 = findMatchingLength(r0, r8, r9, r2)
            int r8 = r8 + 4
            int r9 = r7 + r8
            int r7 = r7 - r14
            encodeCopy(r1, r7, r8)
            int r7 = r17.readerIndex()
            int r7 = r7 + r8
            r0.readerIndex(r7)
            int r7 = r9 + (-1)
            if (r9 < r12) goto L8c
            goto L52
        L8c:
            int r8 = hash(r0, r7, r5)
            int r10 = r9 - r3
            int r11 = r10 + (-1)
            short r11 = (short) r11
            r4[r8] = r11
            int r8 = r7 + 1
            int r11 = hash(r0, r8, r5)
            short r13 = r4[r11]
            int r14 = r3 + r13
            short r10 = (short) r10
            r4[r11] = r10
            int r8 = r0.getInt(r8)
            int r10 = r0.getInt(r14)
            if (r8 == r10) goto Lb7
            int r7 = r7 + 2
            int r8 = hash(r0, r7, r5)
            int r7 = r9 + 1
            goto L47
        Lb7:
            r7 = r9
            goto L6f
        Lb9:
            r7 = r10
            r10 = r11
            r8 = r13
            goto L49
        Lbd:
            if (r3 >= r2) goto Lc3
            int r2 = r2 - r3
            encodeLiteral(r0, r1, r2)
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Snappy.encode(io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf, int):void");
    }

    public void reset() {
        this.state = State.READY;
        this.tag = (byte) 0;
        this.written = 0;
    }

    static int calculateChecksum(ByteBuf byteBuf, int i, int i2) {
        Crc32c crc32c = new Crc32c();
        try {
            crc32c.update(byteBuf, i, i2);
            return maskChecksum((int) crc32c.getValue());
        } finally {
            crc32c.reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void validateChecksum(int i, ByteBuf byteBuf, int i2, int i3) {
        int calculateChecksum = calculateChecksum(byteBuf, i2, i3);
        if (calculateChecksum == i) {
            return;
        }
        throw new DecompressionException("mismatching checksum: " + Integer.toHexString(calculateChecksum) + " (expected: " + Integer.toHexString(i) + ')');
    }
}
