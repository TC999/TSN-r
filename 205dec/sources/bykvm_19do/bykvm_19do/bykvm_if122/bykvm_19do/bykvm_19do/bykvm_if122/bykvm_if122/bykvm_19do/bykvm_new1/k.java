package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: Huffman.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class k {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1185b = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 2042, 1018, 1019, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 115, MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f1186c = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};

    /* renamed from: d  reason: collision with root package name */
    private static final k f1187d = new k();

    /* renamed from: a  reason: collision with root package name */
    private final a f1188a = new a();

    private k() {
        a();
    }

    public static k b() {
        return f1187d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar) throws IOException {
        int i4 = 0;
        long j4 = 0;
        byte b4 = 0;
        while (i4 < fVar.e()) {
            int a4 = fVar.a(i4) & 255;
            int i5 = f1185b[a4];
            byte b5 = f1186c[a4];
            j4 = (j4 << b5) | i5;
            int i6 = b4 + b5;
            while (i6 >= 8) {
                i6 = (i6 == 1 ? 1 : 0) - 8;
                dVar.writeByte((int) (j4 >> i6));
            }
            i4++;
            b4 = i6;
        }
        if (b4 > 0) {
            dVar.writeByte((int) ((255 >>> b4) | (j4 << (8 - b4))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Huffman.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final a[] f1189a;

        /* renamed from: b  reason: collision with root package name */
        final int f1190b;

        /* renamed from: c  reason: collision with root package name */
        final int f1191c;

        a() {
            this.f1189a = new a[256];
            this.f1190b = 0;
            this.f1191c = 0;
        }

        a(int i4, int i5) {
            this.f1189a = null;
            this.f1190b = i4;
            int i6 = i5 & 7;
            this.f1191c = i6 == 0 ? 8 : i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar) {
        long j4 = 0;
        for (int i4 = 0; i4 < fVar.e(); i4++) {
            j4 += f1186c[fVar.a(i4) & 255];
        }
        return (int) ((j4 + 7) >> 3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a aVar = this.f1188a;
        int i4 = 0;
        int i5 = 0;
        for (byte b4 : bArr) {
            i4 = (i4 << 8) | (b4 & 255);
            i5 += 8;
            while (i5 >= 8) {
                aVar = aVar.f1189a[(i4 >>> (i5 - 8)) & 255];
                if (aVar.f1189a == null) {
                    byteArrayOutputStream.write(aVar.f1190b);
                    i5 -= aVar.f1191c;
                    aVar = this.f1188a;
                } else {
                    i5 -= 8;
                }
            }
        }
        while (i5 > 0) {
            a aVar2 = aVar.f1189a[(i4 << (8 - i5)) & 255];
            if (aVar2.f1189a != null || aVar2.f1191c > i5) {
                break;
            }
            byteArrayOutputStream.write(aVar2.f1190b);
            i5 -= aVar2.f1191c;
            aVar = this.f1188a;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void a() {
        int i4 = 0;
        while (true) {
            byte[] bArr = f1186c;
            if (i4 >= bArr.length) {
                return;
            }
            a(i4, f1185b[i4], bArr[i4]);
            i4++;
        }
    }

    private void a(int i4, int i5, byte b4) {
        a aVar = new a(i4, b4);
        a aVar2 = this.f1188a;
        while (b4 > 8) {
            b4 = (byte) (b4 - 8);
            int i6 = (i5 >>> b4) & 255;
            a[] aVarArr = aVar2.f1189a;
            if (aVarArr != null) {
                if (aVarArr[i6] == null) {
                    aVarArr[i6] = new a();
                }
                aVar2 = aVar2.f1189a[i6];
            } else {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
        }
        int i7 = 8 - b4;
        int i8 = (i5 << i7) & 255;
        int i9 = 1 << i7;
        for (int i10 = i8; i10 < i8 + i9; i10++) {
            aVar2.f1189a[i10] = aVar;
        }
    }
}
