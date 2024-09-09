package com.google.zxing.qrcode.decoder;

import com.google.zxing.common.BitMatrix;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
enum DataMask {
    DATA_MASK_000 { // from class: com.google.zxing.qrcode.decoder.DataMask.1
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i4, int i5) {
            return ((i4 + i5) & 1) == 0;
        }
    },
    DATA_MASK_001 { // from class: com.google.zxing.qrcode.decoder.DataMask.2
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i4, int i5) {
            return (i4 & 1) == 0;
        }
    },
    DATA_MASK_010 { // from class: com.google.zxing.qrcode.decoder.DataMask.3
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i4, int i5) {
            return i5 % 3 == 0;
        }
    },
    DATA_MASK_011 { // from class: com.google.zxing.qrcode.decoder.DataMask.4
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i4, int i5) {
            return (i4 + i5) % 3 == 0;
        }
    },
    DATA_MASK_100 { // from class: com.google.zxing.qrcode.decoder.DataMask.5
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i4, int i5) {
            return (((i4 / 2) + (i5 / 3)) & 1) == 0;
        }
    },
    DATA_MASK_101 { // from class: com.google.zxing.qrcode.decoder.DataMask.6
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i4, int i5) {
            return (i4 * i5) % 6 == 0;
        }
    },
    DATA_MASK_110 { // from class: com.google.zxing.qrcode.decoder.DataMask.7
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i4, int i5) {
            return (i4 * i5) % 6 < 3;
        }
    },
    DATA_MASK_111 { // from class: com.google.zxing.qrcode.decoder.DataMask.8
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i4, int i5) {
            return (((i4 + i5) + ((i4 * i5) % 3)) & 1) == 0;
        }
    };

    abstract boolean isMasked(int i4, int i5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void unmaskBitMatrix(BitMatrix bitMatrix, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            for (int i6 = 0; i6 < i4; i6++) {
                if (isMasked(i5, i6)) {
                    bitMatrix.flip(i6, i5);
                }
            }
        }
    }
}
