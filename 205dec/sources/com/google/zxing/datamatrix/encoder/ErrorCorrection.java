package com.google.zxing.datamatrix.encoder;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ErrorCorrection {
    private static final int MODULO_VALUE = 301;
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, 254}, new int[]{28, 24, 185, 166, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 116, 255, 110, 61}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 138, 205, 12, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 168, 39, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME, 97, 192, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 95, 9, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME, 119, 138, 45, 18, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 83, 185}, new int[]{83, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 100, 39, 188, 75, 66, 61, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 213, 109, 129, 94, 254, 225, 48, 90, 188}, new int[]{15, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 244, 9, 233, 71, 168, 2, 188, 160, 153, 145, MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT, 79, 108, 82, 27, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DASH_ABR}, new int[]{52, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, 88, 205, 109, 39, 176, 21, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPEN_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPEN_TIME, 21, 5, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DASH_ABR, 254, 124, 12, 181, 184, 96, 50, 193}, new int[]{211, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, 43, 97, 71, 96, 103, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 37, 151, 170, 53, 75, 34, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, 121, 17, 138, 110, 213, 141, 136, 120, 151, 233, 168, 93, 255}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 127, 242, 218, 130, 250, 162, 181, 102, 120, 84, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 184, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 105, 122, 2, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 133, 242, 8, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT, 57, 54, 101, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 202, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 132, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DASH_ABR, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 96, 32, 117, 22, 238, 133, 238, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, 205, 188, 237, 87, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 240, 82, 44, 176, 87, 187, 147, 160, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 69, 213, 92, MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT, 225, 19}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 9, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 238, 12, 17, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, 208, 100, 29, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 170, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 192, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 235, 150, 159, 36, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 38, 200, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, 207, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME, 13, 137, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 127, 67, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 28, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPEN_TIME, 43, 203, 107, 233, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SHARP, 143, 108, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 37, 185, 112, 134, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 63, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, 250, 106, 185, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, 228, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 89, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, 213, 136, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 180, 234, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 25, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, 232, 96, 210, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, 136, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 239, 181, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 59, 52, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DASH_ABR, 25, 49, 232, 211, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SHARP, 64, 54, 108, 153, 132, 63, 96, 103, 82, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS}};
    private static final int[] LOG = new int[256];
    private static final int[] ALOG = new int[255];

    static {
        int i4 = 1;
        for (int i5 = 0; i5 < 255; i5++) {
            ALOG[i5] = i4;
            LOG[i4] = i5;
            i4 <<= 1;
            if (i4 >= 256) {
                i4 ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    private static String createECCBlock(CharSequence charSequence, int i4) {
        return createECCBlock(charSequence, 0, charSequence.length(), i4);
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() == symbolInfo.getDataCapacity()) {
            StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
            sb.append(str);
            int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
            if (interleavedBlockCount == 1) {
                sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
            } else {
                sb.setLength(sb.capacity());
                int[] iArr = new int[interleavedBlockCount];
                int[] iArr2 = new int[interleavedBlockCount];
                int[] iArr3 = new int[interleavedBlockCount];
                int i4 = 0;
                while (i4 < interleavedBlockCount) {
                    int i5 = i4 + 1;
                    iArr[i4] = symbolInfo.getDataLengthForInterleavedBlock(i5);
                    iArr2[i4] = symbolInfo.getErrorLengthForInterleavedBlock(i5);
                    iArr3[i4] = 0;
                    if (i4 > 0) {
                        iArr3[i4] = iArr3[i4 - 1] + iArr[i4];
                    }
                    i4 = i5;
                }
                for (int i6 = 0; i6 < interleavedBlockCount; i6++) {
                    StringBuilder sb2 = new StringBuilder(iArr[i6]);
                    for (int i7 = i6; i7 < symbolInfo.getDataCapacity(); i7 += interleavedBlockCount) {
                        sb2.append(str.charAt(i7));
                    }
                    String createECCBlock = createECCBlock(sb2.toString(), iArr2[i6]);
                    int i8 = i6;
                    int i9 = 0;
                    while (i8 < iArr2[i6] * interleavedBlockCount) {
                        sb.setCharAt(symbolInfo.getDataCapacity() + i8, createECCBlock.charAt(i9));
                        i8 += interleavedBlockCount;
                        i9++;
                    }
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
    }

    private static String createECCBlock(CharSequence charSequence, int i4, int i5, int i6) {
        int i7 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i7 >= iArr.length) {
                i7 = -1;
                break;
            } else if (iArr[i7] == i6) {
                break;
            } else {
                i7++;
            }
        }
        if (i7 >= 0) {
            int[] iArr2 = FACTORS[i7];
            char[] cArr = new char[i6];
            for (int i8 = 0; i8 < i6; i8++) {
                cArr[i8] = 0;
            }
            for (int i9 = i4; i9 < i4 + i5; i9++) {
                int i10 = i6 - 1;
                int charAt = cArr[i10] ^ charSequence.charAt(i9);
                while (i10 > 0) {
                    if (charAt != 0 && iArr2[i10] != 0) {
                        char c4 = cArr[i10 - 1];
                        int[] iArr3 = ALOG;
                        int[] iArr4 = LOG;
                        cArr[i10] = (char) (c4 ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i10]]) % 255]);
                    } else {
                        cArr[i10] = cArr[i10 - 1];
                    }
                    i10--;
                }
                if (charAt != 0 && iArr2[0] != 0) {
                    int[] iArr5 = ALOG;
                    int[] iArr6 = LOG;
                    cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[iArr2[0]]) % 255];
                } else {
                    cArr[0] = 0;
                }
            }
            char[] cArr2 = new char[i6];
            for (int i11 = 0; i11 < i6; i11++) {
                cArr2[i11] = cArr[(i6 - i11) - 1];
            }
            return String.valueOf(cArr2);
        }
        throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i6);
    }
}
