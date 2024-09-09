package com.google.zxing.oned;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class Code39Reader extends OneDReader {
    static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";
    static final int ASTERISK_ENCODING;
    static final int[] CHARACTER_ENCODINGS;
    private static final String CHECK_DIGIT_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
    private final int[] counters;
    private final StringBuilder decodeRowResult;
    private final boolean extendedMode;
    private final boolean usingCheckDigit;

    static {
        int[] iArr = {52, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 97, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CHLO_COUNT, 49, 304, 112, 37, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP, 100, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 73, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE, 25, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, 88, 13, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME, 76, 28, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 67, 322, 19, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME, 82, 7, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_ASYNC, 70, 22, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500, 193, 448, 145, 400, 208, 133, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 148, 168, 162, 138, 42};
        CHARACTER_ENCODINGS = iArr;
        ASTERISK_ENCODING = iArr[39];
    }

    public Code39Reader() {
        this(false);
    }

    private static String decodeExtended(CharSequence charSequence) throws FormatException {
        int i4;
        char c4;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i5 = 0;
        while (i5 < length) {
            char charAt = charSequence.charAt(i5);
            if (charAt != '+' && charAt != '$' && charAt != '%' && charAt != '/') {
                sb.append(charAt);
            } else {
                i5++;
                char charAt2 = charSequence.charAt(i5);
                if (charAt != '$') {
                    if (charAt != '%') {
                        if (charAt != '+') {
                            if (charAt != '/') {
                                c4 = 0;
                            } else if (charAt2 >= 'A' && charAt2 <= 'O') {
                                i4 = charAt2 - ' ';
                            } else if (charAt2 != 'Z') {
                                throw FormatException.getFormatInstance();
                            } else {
                                c4 = ':';
                            }
                            sb.append(c4);
                        } else if (charAt2 < 'A' || charAt2 > 'Z') {
                            throw FormatException.getFormatInstance();
                        } else {
                            i4 = charAt2 + ' ';
                        }
                    } else if (charAt2 >= 'A' && charAt2 <= 'E') {
                        i4 = charAt2 - '&';
                    } else if (charAt2 < 'F' || charAt2 > 'W') {
                        throw FormatException.getFormatInstance();
                    } else {
                        i4 = charAt2 - 11;
                    }
                } else if (charAt2 < 'A' || charAt2 > 'Z') {
                    throw FormatException.getFormatInstance();
                } else {
                    i4 = charAt2 - '@';
                }
                c4 = (char) i4;
                sb.append(c4);
            }
            i5++;
        }
        return sb.toString();
    }

    private static int[] findAsteriskPattern(BitArray bitArray, int[] iArr) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int length = iArr.length;
        int i4 = nextSet;
        boolean z3 = false;
        int i5 = 0;
        while (nextSet < size) {
            if (bitArray.get(nextSet) ^ z3) {
                iArr[i5] = iArr[i5] + 1;
            } else {
                int i6 = length - 1;
                if (i5 != i6) {
                    i5++;
                } else if (toNarrowWidePattern(iArr) == ASTERISK_ENCODING && bitArray.isRange(Math.max(0, i4 - ((nextSet - i4) / 2)), i4, false)) {
                    return new int[]{i4, nextSet};
                } else {
                    i4 += iArr[0] + iArr[1];
                    int i7 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i7);
                    iArr[i7] = 0;
                    iArr[i6] = 0;
                    i5--;
                }
                iArr[i5] = 1;
                z3 = !z3;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static char patternToChar(int i4) throws NotFoundException {
        int i5 = 0;
        while (true) {
            int[] iArr = CHARACTER_ENCODINGS;
            if (i5 < iArr.length) {
                if (iArr[i5] == i4) {
                    return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".charAt(i5);
                }
                i5++;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    private static int toNarrowWidePattern(int[] iArr) {
        int length = iArr.length;
        int i4 = 0;
        while (true) {
            int i5 = Integer.MAX_VALUE;
            for (int i6 : iArr) {
                if (i6 < i5 && i6 > i4) {
                    i5 = i6;
                }
            }
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = iArr[i10];
                if (i11 > i5) {
                    i8 |= 1 << ((length - 1) - i10);
                    i7++;
                    i9 += i11;
                }
            }
            if (i7 == 3) {
                for (int i12 = 0; i12 < length && i7 > 0; i12++) {
                    int i13 = iArr[i12];
                    if (i13 > i5) {
                        i7--;
                        if ((i13 << 1) >= i9) {
                            return -1;
                        }
                    }
                }
                return i8;
            } else if (i7 <= 3) {
                return -1;
            } else {
                i4 = i5;
            }
        }
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i4, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] findAsteriskPattern;
        String sb;
        int[] iArr = this.counters;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.decodeRowResult;
        sb2.setLength(0);
        int nextSet = bitArray.getNextSet(findAsteriskPattern(bitArray, iArr)[1]);
        int size = bitArray.getSize();
        while (true) {
            OneDReader.recordPattern(bitArray, nextSet, iArr);
            int narrowWidePattern = toNarrowWidePattern(iArr);
            if (narrowWidePattern >= 0) {
                char patternToChar = patternToChar(narrowWidePattern);
                sb2.append(patternToChar);
                int i5 = nextSet;
                for (int i6 : iArr) {
                    i5 += i6;
                }
                int nextSet2 = bitArray.getNextSet(i5);
                if (patternToChar == '*') {
                    sb2.setLength(sb2.length() - 1);
                    int i7 = 0;
                    for (int i8 : iArr) {
                        i7 += i8;
                    }
                    int i9 = (nextSet2 - nextSet) - i7;
                    if (nextSet2 != size && (i9 << 1) < i7) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    if (this.usingCheckDigit) {
                        int length = sb2.length() - 1;
                        int i10 = 0;
                        for (int i11 = 0; i11 < length; i11++) {
                            i10 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.decodeRowResult.charAt(i11));
                        }
                        if (sb2.charAt(length) == "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i10 % 43)) {
                            sb2.setLength(length);
                        } else {
                            throw ChecksumException.getChecksumInstance();
                        }
                    }
                    if (sb2.length() != 0) {
                        if (this.extendedMode) {
                            sb = decodeExtended(sb2);
                        } else {
                            sb = sb2.toString();
                        }
                        float f4 = i4;
                        return new Result(sb, null, new ResultPoint[]{new ResultPoint((findAsteriskPattern[1] + findAsteriskPattern[0]) / 2.0f, f4), new ResultPoint(nextSet + (i7 / 2.0f), f4)}, BarcodeFormat.CODE_39);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                nextSet = nextSet2;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public Code39Reader(boolean z3) {
        this(z3, false);
    }

    public Code39Reader(boolean z3, boolean z4) {
        this.usingCheckDigit = z3;
        this.extendedMode = z4;
        this.decodeRowResult = new StringBuilder(20);
        this.counters = new int[9];
    }
}
