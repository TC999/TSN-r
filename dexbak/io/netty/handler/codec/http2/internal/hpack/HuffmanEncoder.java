package io.netty.handler.codec.http2.internal.hpack;

import io.netty.buffer.ByteBuf;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import kotlin.UByte;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class HuffmanEncoder {
    private final int[] codes;
    private final EncodeProcessor encodeProcessor;
    private final EncodedLengthProcessor encodedLengthProcessor;
    private final byte[] lengths;

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private final class EncodeProcessor implements ByteProcessor {
        private long current;

        /* renamed from: n */
        private int f40239n;
        ByteBuf out;

        private EncodeProcessor() {
        }

        void end() {
            try {
                int i = this.f40239n;
                if (i > 0) {
                    long j = (this.current << (8 - i)) | (255 >>> i);
                    this.current = j;
                    this.out.writeByte((int) j);
                }
            } finally {
                this.out = null;
                this.current = 0L;
                this.f40239n = 0;
            }
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            int i;
            byte b2 = HuffmanEncoder.this.lengths[b & UByte.f41242c];
            long j = this.current << b2;
            this.current = j;
            this.current = j | HuffmanEncoder.this.codes[i];
            this.f40239n += b2;
            while (true) {
                int i2 = this.f40239n;
                if (i2 < 8) {
                    return true;
                }
                int i3 = i2 - 8;
                this.f40239n = i3;
                this.out.writeByte((int) (this.current >> i3));
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private final class EncodedLengthProcessor implements ByteProcessor {
        private long len;

        private EncodedLengthProcessor() {
        }

        int length() {
            return (int) ((this.len + 7) >> 3);
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            this.len += HuffmanEncoder.this.lengths[b & UByte.f41242c];
            return true;
        }

        void reset() {
            this.len = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HuffmanEncoder() {
        this(HpackUtil.HUFFMAN_CODES, HpackUtil.HUFFMAN_CODE_LENGTHS);
    }

    private void encodeSlowPath(ByteBuf byteBuf, CharSequence charSequence) {
        int i = 0;
        long j = 0;
        byte b = 0;
        while (i < charSequence.length()) {
            int charAt = charSequence.charAt(i) & 255;
            int i2 = this.codes[charAt];
            byte b2 = this.lengths[charAt];
            j = (j << b2) | i2;
            int i3 = b + b2;
            while (i3 >= 8) {
                i3 = (i3 == 1 ? 1 : 0) - 8;
                byteBuf.writeByte((int) (j >> i3));
            }
            i++;
            b = i3;
        }
        if (b > 0) {
            byteBuf.writeByte((int) ((255 >>> b) | (j << (8 - b))));
        }
    }

    private int getEncodedLengthSlowPath(CharSequence charSequence) {
        long j = 0;
        for (int i = 0; i < charSequence.length(); i++) {
            j += this.lengths[charSequence.charAt(i) & 255];
        }
        return (int) ((j + 7) >> 3);
    }

    public void encode(ByteBuf byteBuf, CharSequence charSequence) {
        ObjectUtil.checkNotNull(byteBuf, "out");
        if (charSequence instanceof AsciiString) {
            AsciiString asciiString = (AsciiString) charSequence;
            try {
                try {
                    EncodeProcessor encodeProcessor = this.encodeProcessor;
                    encodeProcessor.out = byteBuf;
                    asciiString.forEachByte(encodeProcessor);
                } catch (Exception e) {
                    PlatformDependent.throwException(e);
                }
                return;
            } finally {
                this.encodeProcessor.end();
            }
        }
        encodeSlowPath(byteBuf, charSequence);
    }

    public int getEncodedLength(CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            AsciiString asciiString = (AsciiString) charSequence;
            try {
                this.encodedLengthProcessor.reset();
                asciiString.forEachByte(this.encodedLengthProcessor);
                return this.encodedLengthProcessor.length();
            } catch (Exception e) {
                PlatformDependent.throwException(e);
                return -1;
            }
        }
        return getEncodedLengthSlowPath(charSequence);
    }

    private HuffmanEncoder(int[] iArr, byte[] bArr) {
        this.encodedLengthProcessor = new EncodedLengthProcessor();
        this.encodeProcessor = new EncodeProcessor();
        this.codes = iArr;
        this.lengths = bArr;
    }
}
