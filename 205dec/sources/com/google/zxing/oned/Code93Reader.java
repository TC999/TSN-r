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
public final class Code93Reader extends OneDReader {
    private static final char[] ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
    static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
    private static final int ASTERISK_ENCODING;
    static final int[] CHARACTER_ENCODINGS;
    private final StringBuilder decodeRowResult = new StringBuilder(20);
    private final int[] counters = new int[6];

    static {
        int[] iArr = {MediaPlayer.MEDIA_PLAYER_OPTION_POST_PREPARE, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 322, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_AUTO_RANGE_OFFSET, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME, 424, 420, 418, 404, 402, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MIN_RECEIVED_BEFORE_ACK_DECIMATION, 360, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_CERT_VERIFY, 308, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_REOPEN, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_PROBESIZE, 300, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, 436, 434, 428, 422, 406, 410, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, MediaPlayer.MEDIA_PLAYER_OPTION_BUFFERING_END_IGNORE_VIDEO, MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 302, 468, 466, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_MS_GAPS, 430, MediaPlayer.MEDIA_PLAYER_OPTION_DANGER_BUFFER_THRESHOLD, 474, 470, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_PREDELAY, 350};
        CHARACTER_ENCODINGS = iArr;
        ASTERISK_ENCODING = iArr[47];
    }

    private static void checkChecksums(CharSequence charSequence) throws ChecksumException {
        int length = charSequence.length();
        checkOneChecksum(charSequence, length - 2, 20);
        checkOneChecksum(charSequence, length - 1, 15);
    }

    private static void checkOneChecksum(CharSequence charSequence, int i4, int i5) throws ChecksumException {
        int i6 = 0;
        int i7 = 1;
        for (int i8 = i4 - 1; i8 >= 0; i8--) {
            i6 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i8)) * i7;
            i7++;
            if (i7 > i5) {
                i7 = 1;
            }
        }
        if (charSequence.charAt(i4) != ALPHABET[i6 % 47]) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    private static String decodeExtended(CharSequence charSequence) throws FormatException {
        int i4;
        char c4;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i5 = 0;
        while (i5 < length) {
            char charAt = charSequence.charAt(i5);
            if (charAt < 'a' || charAt > 'd') {
                sb.append(charAt);
            } else if (i5 < length - 1) {
                i5++;
                char charAt2 = charSequence.charAt(i5);
                switch (charAt) {
                    case 'a':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i4 = charAt2 - '@';
                            c4 = (char) i4;
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        break;
                    case 'b':
                        if (charAt2 >= 'A' && charAt2 <= 'E') {
                            i4 = charAt2 - '&';
                        } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                            i4 = charAt2 - 11;
                        } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                            i4 = charAt2 + 16;
                        } else if (charAt2 >= 'P' && charAt2 <= 'S') {
                            i4 = charAt2 + '+';
                        } else if (charAt2 >= 'T' && charAt2 <= 'Z') {
                            c4 = '\u007f';
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        c4 = (char) i4;
                        break;
                    case 'c':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            i4 = charAt2 - ' ';
                            c4 = (char) i4;
                            break;
                        } else if (charAt2 == 'Z') {
                            c4 = ':';
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    case 'd':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i4 = charAt2 + ' ';
                            c4 = (char) i4;
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    default:
                        c4 = 0;
                        break;
                }
                sb.append(c4);
            } else {
                throw FormatException.getFormatInstance();
            }
            i5++;
        }
        return sb.toString();
    }

    private int[] findAsteriskPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        Arrays.fill(this.counters, 0);
        int[] iArr = this.counters;
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
                } else if (toPattern(iArr) == ASTERISK_ENCODING) {
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
                    return ALPHABET[i5];
                }
                i5++;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    private static int toPattern(int[] iArr) {
        int i4 = 0;
        for (int i5 : iArr) {
            i4 += i5;
        }
        int length = iArr.length;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int round = Math.round((iArr[i7] * 9.0f) / i4);
            if (round <= 0 || round > 4) {
                return -1;
            }
            if ((i7 & 1) == 0) {
                for (int i8 = 0; i8 < round; i8++) {
                    i6 = (i6 << 1) | 1;
                }
            } else {
                i6 <<= round;
            }
        }
        return i6;
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i4, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] findAsteriskPattern;
        int nextSet = bitArray.getNextSet(findAsteriskPattern(bitArray)[1]);
        int size = bitArray.getSize();
        int[] iArr = this.counters;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.decodeRowResult;
        sb.setLength(0);
        while (true) {
            OneDReader.recordPattern(bitArray, nextSet, iArr);
            int pattern = toPattern(iArr);
            if (pattern >= 0) {
                char patternToChar = patternToChar(pattern);
                sb.append(patternToChar);
                int i5 = nextSet;
                for (int i6 : iArr) {
                    i5 += i6;
                }
                int nextSet2 = bitArray.getNextSet(i5);
                if (patternToChar == '*') {
                    sb.deleteCharAt(sb.length() - 1);
                    int i7 = 0;
                    for (int i8 : iArr) {
                        i7 += i8;
                    }
                    if (nextSet2 != size && bitArray.get(nextSet2)) {
                        if (sb.length() >= 2) {
                            checkChecksums(sb);
                            sb.setLength(sb.length() - 2);
                            float f4 = i4;
                            return new Result(decodeExtended(sb), null, new ResultPoint[]{new ResultPoint((findAsteriskPattern[1] + findAsteriskPattern[0]) / 2.0f, f4), new ResultPoint(nextSet + (i7 / 2.0f), f4)}, BarcodeFormat.CODE_93);
                        }
                        throw NotFoundException.getNotFoundInstance();
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                nextSet = nextSet2;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }
}
