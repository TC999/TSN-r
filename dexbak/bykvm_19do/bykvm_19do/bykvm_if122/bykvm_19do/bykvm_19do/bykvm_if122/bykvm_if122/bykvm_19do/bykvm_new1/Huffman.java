package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import androidx.core.view.PointerIconCompat;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import kotlin.UByte;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.k */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class Huffman {

    /* renamed from: b */
    private static final int[] f1192b = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 4090, 8185, 21, 248, 2042, PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_ZOOM_OUT, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, PointerIconCompat.TYPE_GRAB, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: c */
    private static final byte[] f1193c = {13, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.GATQ, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.GATQ, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.GATQ, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.TOUCH, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, BinaryMemcacheOpcodes.REPLACEQ, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.PREPENDQ, BinaryMemcacheOpcodes.PREPENDQ, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.REPLACEQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.APPENDQ, BinaryMemcacheOpcodes.PREPENDQ, BinaryMemcacheOpcodes.PREPENDQ, BinaryMemcacheOpcodes.PREPENDQ, 27, 27, BinaryMemcacheOpcodes.PREPENDQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.APPENDQ, BinaryMemcacheOpcodes.REPLACEQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.PREPENDQ, 27, 27, BinaryMemcacheOpcodes.PREPENDQ, 27, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.PREPENDQ, BinaryMemcacheOpcodes.PREPENDQ, BinaryMemcacheOpcodes.TOUCH, 27, 27, 27, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.APPENDQ, BinaryMemcacheOpcodes.APPENDQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.PREPENDQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.PREPENDQ, 27, BinaryMemcacheOpcodes.PREPENDQ, BinaryMemcacheOpcodes.PREPENDQ, 27, 27, 27, 27, 27, BinaryMemcacheOpcodes.TOUCH, 27, 27, 27, 27, 27, BinaryMemcacheOpcodes.PREPENDQ};

    /* renamed from: d */
    private static final Huffman f1194d = new Huffman();

    /* renamed from: a */
    private final C1055a f1195a = new C1055a();

    private Huffman() {
        m58535a();
    }

    /* renamed from: b */
    public static Huffman m58530b() {
        return f1194d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m58532a(ByteString byteString, BufferedSink bufferedSink) throws IOException {
        int i = 0;
        long j = 0;
        byte b = 0;
        while (i < byteString.mo58881e()) {
            int mo58890a = byteString.mo58890a(i) & UByte.f41242c;
            int i2 = f1192b[mo58890a];
            byte b2 = f1193c[mo58890a];
            j = (j << b2) | i2;
            int i3 = b + b2;
            while (i3 >= 8) {
                i3 = (i3 == 1 ? 1 : 0) - 8;
                bufferedSink.writeByte((int) (j >> i3));
            }
            i++;
            b = i3;
        }
        if (b > 0) {
            bufferedSink.writeByte((int) ((255 >>> b) | (j << (8 - b))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Huffman.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.k$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static final class C1055a {

        /* renamed from: a */
        final C1055a[] f1196a;

        /* renamed from: b */
        final int f1197b;

        /* renamed from: c */
        final int f1198c;

        C1055a() {
            this.f1196a = new C1055a[256];
            this.f1197b = 0;
            this.f1198c = 0;
        }

        C1055a(int i, int i2) {
            this.f1196a = null;
            this.f1197b = i;
            int i3 = i2 & 7;
            this.f1198c = i3 == 0 ? 8 : i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m58533a(ByteString byteString) {
        long j = 0;
        for (int i = 0; i < byteString.mo58881e(); i++) {
            j += f1193c[byteString.mo58890a(i) & UByte.f41242c];
        }
        return (int) ((j + 7) >> 3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public byte[] m58531a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C1055a c1055a = this.f1195a;
        int i = 0;
        int i2 = 0;
        for (byte b : bArr) {
            i = (i << 8) | (b & UByte.f41242c);
            i2 += 8;
            while (i2 >= 8) {
                c1055a = c1055a.f1196a[(i >>> (i2 - 8)) & 255];
                if (c1055a.f1196a == null) {
                    byteArrayOutputStream.write(c1055a.f1197b);
                    i2 -= c1055a.f1198c;
                    c1055a = this.f1195a;
                } else {
                    i2 -= 8;
                }
            }
        }
        while (i2 > 0) {
            C1055a c1055a2 = c1055a.f1196a[(i << (8 - i2)) & 255];
            if (c1055a2.f1196a != null || c1055a2.f1198c > i2) {
                break;
            }
            byteArrayOutputStream.write(c1055a2.f1197b);
            i2 -= c1055a2.f1198c;
            c1055a = this.f1195a;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    private void m58535a() {
        int i = 0;
        while (true) {
            byte[] bArr = f1193c;
            if (i >= bArr.length) {
                return;
            }
            m58534a(i, f1192b[i], bArr[i]);
            i++;
        }
    }

    /* renamed from: a */
    private void m58534a(int i, int i2, byte b) {
        C1055a c1055a = new C1055a(i, b);
        C1055a c1055a2 = this.f1195a;
        while (b > 8) {
            b = (byte) (b - 8);
            int i3 = (i2 >>> b) & 255;
            C1055a[] c1055aArr = c1055a2.f1196a;
            if (c1055aArr != null) {
                if (c1055aArr[i3] == null) {
                    c1055aArr[i3] = new C1055a();
                }
                c1055a2 = c1055a2.f1196a[i3];
            } else {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
        }
        int i4 = 8 - b;
        int i5 = (i2 << i4) & 255;
        int i6 = 1 << i4;
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            c1055a2.f1196a[i7] = c1055a;
        }
    }
}
