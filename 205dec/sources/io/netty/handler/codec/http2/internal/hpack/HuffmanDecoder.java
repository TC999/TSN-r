package io.netty.handler.codec.http2.internal.hpack;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.Http2Error;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.ThrowableUtil;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class HuffmanDecoder {
    private static final Http2Exception EOS_DECODED;
    private static final Http2Exception INVALID_PADDING;
    private static final Node ROOT;
    private final DecoderProcessor processor;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static final class DecoderProcessor implements ByteProcessor {
        private byte[] bytes;
        private int current;
        private int currentBits;
        private int index;
        private final int initialCapacity;
        private Node node;
        private int symbolBits;

        DecoderProcessor(int i4) {
            this.initialCapacity = ObjectUtil.checkPositive(i4, "initialCapacity");
        }

        private void append(int i4) {
            try {
                this.bytes[this.index] = (byte) i4;
            } catch (IndexOutOfBoundsException unused) {
                byte[] bArr = this.bytes;
                byte[] bArr2 = new byte[bArr.length + this.initialCapacity];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.bytes = bArr2;
                bArr2[this.index] = (byte) i4;
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
            int i4 = this.symbolBits;
            int i5 = (1 << i4) - 1;
            if (i4 <= 7 && (this.current & i5) == i5) {
                return new AsciiString(this.bytes, 0, this.index, false);
            }
            throw HuffmanDecoder.INVALID_PADDING;
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b4) throws Http2Exception {
            this.current = (b4 & 255) | (this.current << 8);
            this.currentBits += 8;
            this.symbolBits += 8;
            do {
                Node[] nodeArr = this.node.children;
                int i4 = this.current;
                int i5 = this.currentBits;
                Node node = nodeArr[(i4 >>> (i5 - 8)) & 255];
                this.node = node;
                this.currentBits = i5 - node.bits;
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
    public HuffmanDecoder(int i4) {
        this.processor = new DecoderProcessor(i4);
    }

    private static Node buildTree(int[] iArr, byte[] bArr) {
        Node node = new Node();
        for (int i4 = 0; i4 < iArr.length; i4++) {
            insert(node, i4, iArr[i4], bArr[i4]);
        }
        return node;
    }

    private static void insert(Node node, int i4, int i5, byte b4) {
        while (b4 > 8) {
            if (!node.isTerminal()) {
                b4 = (byte) (b4 - 8);
                int i6 = (i5 >>> b4) & 255;
                if (node.children[i6] == null) {
                    node.children[i6] = new Node();
                }
                node = node.children[i6];
            } else {
                throw new IllegalStateException("invalid Huffman code: prefix not unique");
            }
        }
        Node node2 = new Node(i4, b4);
        int i7 = 8 - b4;
        int i8 = (i5 << i7) & 255;
        int i9 = 1 << i7;
        for (int i10 = i8; i10 < i8 + i9; i10++) {
            node.children[i10] = node2;
        }
    }

    public AsciiString decode(ByteBuf byteBuf, int i4) throws Http2Exception {
        this.processor.reset();
        byteBuf.forEachByte(byteBuf.readerIndex(), i4, this.processor);
        byteBuf.skipBytes(i4);
        return this.processor.end();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
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

        Node(int i4, int i5) {
            this.symbol = i4;
            this.bits = i5;
            this.children = null;
        }
    }
}
