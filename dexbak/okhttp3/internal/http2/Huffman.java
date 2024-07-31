package okhttp3.internal.http2;

import androidx.core.view.PointerIconCompat;
import com.tencent.open.SocialConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.collections._ArraysJvm;
import kotlin.jvm.internal.C14342f0;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Huffman.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bJ\u001e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, m12616d2 = {"Lokhttp3/internal/http2/Huffman;", "", "", "symbol", "code", "codeBitCount", "Lkotlin/f1;", "addCode", "Lokio/ByteString;", SocialConstants.PARAM_SOURCE, "Lokio/BufferedSink;", "sink", "encode", "bytes", "encodedLength", "Lokio/BufferedSource;", "", "byteCount", "decode", "", "CODES", "[I", "", "CODE_BIT_COUNTS", "[B", "Lokhttp3/internal/http2/Huffman$Node;", "root", "Lokhttp3/internal/http2/Huffman$Node;", "<init>", "()V", "Node", "okhttp"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Huffman {
    private static final int[] CODES;
    private static final byte[] CODE_BIT_COUNTS;
    public static final Huffman INSTANCE;
    private static final Node root;

    static {
        Huffman huffman = new Huffman();
        INSTANCE = huffman;
        CODES = new int[]{8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 4090, 8185, 21, 248, 2042, PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_ZOOM_OUT, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, PointerIconCompat.TYPE_GRAB, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
        byte[] bArr = {13, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.GATQ, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.GATQ, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.GATQ, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, BinaryMemcacheOpcodes.REPLACEQ, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.PREPENDQ, BinaryMemcacheOpcodes.PREPENDQ, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.REPLACEQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.APPENDQ, BinaryMemcacheOpcodes.PREPENDQ, BinaryMemcacheOpcodes.PREPENDQ, BinaryMemcacheOpcodes.PREPENDQ, 27, 27, BinaryMemcacheOpcodes.PREPENDQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.APPENDQ, BinaryMemcacheOpcodes.REPLACEQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.PREPENDQ, 27, 27, BinaryMemcacheOpcodes.PREPENDQ, 27, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.PREPENDQ, BinaryMemcacheOpcodes.PREPENDQ, BinaryMemcacheOpcodes.TOUCH, 27, 27, 27, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.APPENDQ, BinaryMemcacheOpcodes.APPENDQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.PREPENDQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.PREPENDQ, 27, BinaryMemcacheOpcodes.PREPENDQ, BinaryMemcacheOpcodes.PREPENDQ, 27, 27, 27, 27, 27, BinaryMemcacheOpcodes.TOUCH, 27, 27, 27, 27, 27, BinaryMemcacheOpcodes.PREPENDQ};
        CODE_BIT_COUNTS = bArr;
        root = new Node();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            huffman.addCode(i, CODES[i], CODE_BIT_COUNTS[i]);
        }
    }

    private Huffman() {
    }

    private final void addCode(int i, int i2, int i3) {
        Node node = new Node(i, i3);
        Node node2 = root;
        while (i3 > 8) {
            i3 -= 8;
            int i4 = (i2 >>> i3) & 255;
            Node[] children = node2.getChildren();
            C14342f0.m8187m(children);
            Node node3 = children[i4];
            if (node3 == null) {
                node3 = new Node();
                children[i4] = node3;
            }
            node2 = node3;
        }
        int i5 = 8 - i3;
        int i6 = (i2 << i5) & 255;
        Node[] children2 = node2.getChildren();
        C14342f0.m8187m(children2);
        _ArraysJvm.m11568n2(children2, node, i6, (1 << i5) + i6);
    }

    public final void decode(@NotNull BufferedSource source, long j, @NotNull BufferedSink sink) {
        C14342f0.m8184p(source, "source");
        C14342f0.m8184p(sink, "sink");
        Node node = root;
        int i = 0;
        int i2 = 0;
        for (long j2 = 0; j2 < j; j2++) {
            i = (i << 8) | Util.and(source.readByte(), 255);
            i2 += 8;
            while (i2 >= 8) {
                int i3 = i2 - 8;
                Node[] children = node.getChildren();
                C14342f0.m8187m(children);
                node = children[(i >>> i3) & 255];
                C14342f0.m8187m(node);
                if (node.getChildren() == null) {
                    sink.writeByte(node.getSymbol());
                    i2 -= node.getTerminalBitCount();
                    node = root;
                } else {
                    i2 = i3;
                }
            }
        }
        while (i2 > 0) {
            Node[] children2 = node.getChildren();
            C14342f0.m8187m(children2);
            Node node2 = children2[(i << (8 - i2)) & 255];
            C14342f0.m8187m(node2);
            if (node2.getChildren() != null || node2.getTerminalBitCount() > i2) {
                return;
            }
            sink.writeByte(node2.getSymbol());
            i2 -= node2.getTerminalBitCount();
            node = root;
        }
    }

    public final void encode(@NotNull ByteString source, @NotNull BufferedSink sink) throws IOException {
        C14342f0.m8184p(source, "source");
        C14342f0.m8184p(sink, "sink");
        int size = source.size();
        long j = 0;
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int and = Util.and(source.getByte(i2), 255);
            int i3 = CODES[and];
            byte b = CODE_BIT_COUNTS[and];
            j = (j << b) | i3;
            i += b;
            while (i >= 8) {
                i = (i == true ? 1 : 0) - 8;
                sink.writeByte((int) (j >> i));
            }
        }
        if (i > 0) {
            sink.writeByte((int) ((j << (8 - i)) | (255 >>> i)));
        }
    }

    public final int encodedLength(@NotNull ByteString bytes) {
        C14342f0.m8184p(bytes, "bytes");
        int size = bytes.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            j += CODE_BIT_COUNTS[Util.and(bytes.getByte(i), 255)];
        }
        return (int) ((j + 7) >> 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Huffman.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u001d\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, m12616d2 = {"Lokhttp3/internal/http2/Huffman$Node;", "", "()V", "symbol", "", "bits", "(II)V", "children", "", "getChildren", "()[Lokhttp3/internal/http2/Huffman$Node;", "[Lokhttp3/internal/http2/Huffman$Node;", "getSymbol", "()I", "terminalBitCount", "getTerminalBitCount", "okhttp"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class Node {
        @Nullable
        private final Node[] children;
        private final int symbol;
        private final int terminalBitCount;

        public Node() {
            this.children = new Node[256];
            this.symbol = 0;
            this.terminalBitCount = 0;
        }

        @Nullable
        public final Node[] getChildren() {
            return this.children;
        }

        public final int getSymbol() {
            return this.symbol;
        }

        public final int getTerminalBitCount() {
            return this.terminalBitCount;
        }

        public Node(int i, int i2) {
            this.children = null;
            this.symbol = i;
            int i3 = i2 & 7;
            this.terminalBitCount = i3 == 0 ? 8 : i3;
        }
    }
}
