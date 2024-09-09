package com.baidu.idl.face.platform.utils;

import java.io.UnsupportedEncodingException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Base64Utils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static abstract class Coder {
        public int op;
        public byte[] output;

        Coder() {
        }

        public abstract int maxOutputSize(int i4);

        public abstract boolean process(byte[] bArr, int i4, int i5, boolean z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Decoder extends Coder {
        private static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] DECODE_WEBSAFE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        public Decoder(int i4, byte[] bArr) {
            this.output = bArr;
            this.alphabet = (i4 & 8) == 0 ? DECODE : DECODE_WEBSAFE;
            this.state = 0;
            this.value = 0;
        }

        @Override // com.baidu.idl.face.platform.utils.Base64Utils.Coder
        public int maxOutputSize(int i4) {
            return ((i4 * 3) / 4) + 10;
        }

        @Override // com.baidu.idl.face.platform.utils.Base64Utils.Coder
        public boolean process(byte[] bArr, int i4, int i5, boolean z3) {
            int i6 = this.state;
            if (i6 == 6) {
                return false;
            }
            int i7 = i5 + i4;
            int i8 = this.value;
            byte[] bArr2 = this.output;
            int[] iArr = this.alphabet;
            int i9 = i8;
            int i10 = 0;
            int i11 = i6;
            int i12 = i4;
            while (i12 < i7) {
                if (i11 == 0) {
                    while (true) {
                        int i13 = i12 + 4;
                        if (i13 > i7 || (i9 = (iArr[bArr[i12] & 255] << 18) | (iArr[bArr[i12 + 1] & 255] << 12) | (iArr[bArr[i12 + 2] & 255] << 6) | iArr[bArr[i12 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i10 + 2] = (byte) i9;
                        bArr2[i10 + 1] = (byte) (i9 >> 8);
                        bArr2[i10] = (byte) (i9 >> 16);
                        i10 += 3;
                        i12 = i13;
                    }
                    if (i12 >= i7) {
                        break;
                    }
                }
                int i14 = i12 + 1;
                int i15 = iArr[bArr[i12] & 255];
                if (i11 != 0) {
                    if (i11 == 1) {
                        if (i15 < 0) {
                            if (i15 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i15 |= i9 << 6;
                    } else if (i11 == 2) {
                        if (i15 < 0) {
                            if (i15 == -2) {
                                bArr2[i10] = (byte) (i9 >> 4);
                                i10++;
                                i11 = 4;
                            } else if (i15 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i15 |= i9 << 6;
                    } else if (i11 != 3) {
                        if (i11 != 4) {
                            if (i11 == 5 && i15 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i15 == -2) {
                            i11++;
                        } else if (i15 != -1) {
                            this.state = 6;
                            return false;
                        }
                    } else if (i15 >= 0) {
                        int i16 = i15 | (i9 << 6);
                        bArr2[i10 + 2] = (byte) i16;
                        bArr2[i10 + 1] = (byte) (i16 >> 8);
                        bArr2[i10] = (byte) (i16 >> 16);
                        i10 += 3;
                        i9 = i16;
                        i11 = 0;
                    } else if (i15 == -2) {
                        bArr2[i10 + 1] = (byte) (i9 >> 2);
                        bArr2[i10] = (byte) (i9 >> 10);
                        i10 += 2;
                        i11 = 5;
                    } else if (i15 != -1) {
                        this.state = 6;
                        return false;
                    }
                    i11++;
                    i9 = i15;
                } else {
                    if (i15 < 0) {
                        if (i15 != -1) {
                            this.state = 6;
                            return false;
                        }
                    }
                    i11++;
                    i9 = i15;
                }
                i12 = i14;
            }
            if (!z3) {
                this.state = i11;
                this.value = i9;
                this.op = i10;
                return true;
            } else if (i11 != 1) {
                if (i11 == 2) {
                    bArr2[i10] = (byte) (i9 >> 4);
                    i10++;
                } else if (i11 == 3) {
                    int i17 = i10 + 1;
                    bArr2[i10] = (byte) (i9 >> 10);
                    i10 = i17 + 1;
                    bArr2[i17] = (byte) (i9 >> 2);
                } else if (i11 == 4) {
                    this.state = 6;
                    return false;
                }
                this.state = i11;
                this.op = i10;
                return true;
            } else {
                this.state = 6;
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Encoder extends Coder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final byte[] ENCODE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] ENCODE_WEBSAFE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        private final byte[] tail;
        int tailLen;

        public Encoder(int i4, byte[] bArr) {
            this.output = bArr;
            this.do_padding = (i4 & 1) == 0;
            boolean z3 = (i4 & 2) == 0;
            this.do_newline = z3;
            this.do_cr = (i4 & 4) != 0;
            this.alphabet = (i4 & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = z3 ? 19 : -1;
        }

        @Override // com.baidu.idl.face.platform.utils.Base64Utils.Coder
        public int maxOutputSize(int i4) {
            return ((i4 * 8) / 5) + 10;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x00e6 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00dd -> B:22:0x008a). Please submit an issue!!! */
        @Override // com.baidu.idl.face.platform.utils.Base64Utils.Coder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean process(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 477
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.face.platform.utils.Base64Utils.Encoder.process(byte[], int, int, boolean):boolean");
        }
    }

    private Base64Utils() {
    }

    public static byte[] decode(String str, int i4) throws IllegalArgumentException {
        return decode(str.getBytes(), i4);
    }

    public static byte[] encode(byte[] bArr, int i4) {
        return encode(bArr, 0, bArr.length, i4);
    }

    public static String encodeToString(byte[] bArr, int i4) {
        try {
            return new String(encode(bArr, i4), "US-ASCII");
        } catch (UnsupportedEncodingException e4) {
            throw new AssertionError(e4);
        }
    }

    public static byte[] decode(byte[] bArr, int i4) throws IllegalArgumentException {
        return decode(bArr, 0, bArr.length, i4);
    }

    public static byte[] encode(byte[] bArr, int i4, int i5, int i6) {
        Encoder encoder = new Encoder(i6, null);
        int i7 = (i5 / 3) * 4;
        if (encoder.do_padding) {
            if (i5 % 3 > 0) {
                i7 += 4;
            }
        } else {
            int i8 = i5 % 3;
            if (i8 == 1) {
                i7 += 2;
            } else if (i8 == 2) {
                i7 += 3;
            }
        }
        if (encoder.do_newline && i5 > 0) {
            i7 += (((i5 - 1) / 57) + 1) * (encoder.do_cr ? 2 : 1);
        }
        encoder.output = new byte[i7];
        encoder.process(bArr, i4, i5, true);
        return encoder.output;
    }

    public static byte[] decode(byte[] bArr, int i4, int i5, int i6) throws IllegalArgumentException {
        Decoder decoder = new Decoder(i6, new byte[(i5 * 3) / 4]);
        if (decoder.process(bArr, i4, i5, true)) {
            int i7 = decoder.op;
            byte[] bArr2 = decoder.output;
            if (i7 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i7];
            System.arraycopy(bArr2, 0, bArr3, 0, i7);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static String encodeToString(byte[] bArr, int i4, int i5, int i6) {
        try {
            return new String(encode(bArr, i4, i5, i6), "US-ASCII");
        } catch (UnsupportedEncodingException e4) {
            throw new AssertionError(e4);
        }
    }
}
