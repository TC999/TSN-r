package io.netty.handler.codec.http2.internal.hpack;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.Http2Error;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.ThrowableUtil;
import kotlin.UByte;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class HuffmanDecoder {
    private static final Http2Exception EOS_DECODED;
    private static final Http2Exception INVALID_PADDING;
    private static final Node ROOT;
    private final DecoderProcessor processor;

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static final class DecoderProcessor implements ByteProcessor {
        private byte[] bytes;
        private int current;
        private int currentBits;
        private int index;
        private final int initialCapacity;
        private Node node;
        private int symbolBits;

        DecoderProcessor(int i) {
            this.initialCapacity = ObjectUtil.checkPositive(i, "initialCapacity");
        }

        private void append(int i) {
            try {
                this.bytes[this.index] = (byte) i;
            } catch (IndexOutOfBoundsException unused) {
                byte[] bArr = this.bytes;
                byte[] bArr2 = new byte[bArr.length + this.initialCapacity];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.bytes = bArr2;
                bArr2[this.index] = (byte) i;
            }
            this.index++;
        }

        AsciiString end() throws Http2Exception {
            while (this.currentBits > 0) {
                Node node = this.node.children[(this.current << (8 - this.currentBits)) & 255];
                this.node = node;
                if (!node.isTerminal() || this.node.bits > this.currentBits) {
                    break;
                } else if (this.node.symbol != 256) {
                    this.currentBits -= this.node.bits;
                    append(this.node.symbol);
                    this.node = HuffmanDecoder.ROOT;
                    this.symbolBits = this.currentBits;
                } else {
                    throw HuffmanDecoder.EOS_DECODED;
                }
            }
            int i = this.symbolBits;
            int i2 = (1 << i) - 1;
            if (i <= 7 && (this.current & i2) == i2) {
                return new AsciiString(this.bytes, 0, this.index, false);
            }
            throw HuffmanDecoder.INVALID_PADDING;
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b) throws Http2Exception {
            this.current = (b & UByte.f41242c) | (this.current << 8);
            this.currentBits += 8;
            this.symbolBits += 8;
            do {
                Node[] nodeArr = this.node.children;
                int i = this.current;
                int i2 = this.currentBits;
                Node node = nodeArr[(i >>> (i2 - 8)) & 255];
                this.node = node;
                this.currentBits = i2 - node.bits;
                if (this.node.isTerminal()) {
                    if (this.node.symbol != 256) {
                        append(this.node.symbol);
                        this.node = HuffmanDecoder.ROOT;
                        this.symbolBits = this.currentBits;
                    } else {
                        throw HuffmanDecoder.EOS_DECODED;
                    }
                }
            } while (this.currentBits >= 8);
            return true;
        }

        void reset() {
            this.node = HuffmanDecoder.ROOT;
            this.current = 0;
            this.currentBits = 0;
            this.symbolBits = 0;
            this.bytes = new byte[this.initialCapacity];
            this.index = 0;
        }
    }

    static {
        Http2Error http2Error = Http2Error.COMPRESSION_ERROR;
        EOS_DECODED = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.connectionError(http2Error, "HPACK - EOS Decoded", new Object[0]), HuffmanDecoder.class, "decode(...)");
        INVALID_PADDING = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.connectionError(http2Error, "HPACK - Invalid Padding", new Object[0]), HuffmanDecoder.class, "decode(...)");
        ROOT = buildTree(HpackUtil.HUFFMAN_CODES, HpackUtil.HUFFMAN_CODE_LENGTHS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HuffmanDecoder(int i) {
        this.processor = new DecoderProcessor(i);
    }

    private static Node buildTree(int[] iArr, byte[] bArr) {
        Node node = new Node();
        for (int i = 0; i < iArr.length; i++) {
            insert(node, i, iArr[i], bArr[i]);
        }
        return node;
    }

    private static void insert(Node node, int i, int i2, byte b) {
        while (b > 8) {
            if (!node.isTerminal()) {
                b = (byte) (b - 8);
                int i3 = (i2 >>> b) & 255;
                if (node.children[i3] == null) {
                    node.children[i3] = new Node();
                }
                node = node.children[i3];
            } else {
                throw new IllegalStateException("invalid Huffman code: prefix not unique");
            }
        }
        Node node2 = new Node(i, b);
        int i4 = 8 - b;
        int i5 = (i2 << i4) & 255;
        int i6 = 1 << i4;
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            node.children[i7] = node2;
        }
    }

    public AsciiString decode(ByteBuf byteBuf, int i) throws Http2Exception {
        this.processor.reset();
        byteBuf.forEachByte(byteBuf.readerIndex(), i, this.processor);
        byteBuf.skipBytes(i);
        return this.processor.end();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class Node {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final int bits;
        private final Node[] children;
        private final int symbol;

        Node() {
            this.symbol = 0;
            this.bits = 8;
            this.children = new Node[256];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isTerminal() {
            return this.children == null;
        }

        Node(int i, int i2) {
            this.symbol = i;
            this.bits = i2;
            this.children = null;
        }
    }
}
