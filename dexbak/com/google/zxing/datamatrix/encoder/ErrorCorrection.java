package com.google.zxing.datamatrix.encoder;

import cn.bluemobi.dylan.http.BuildConfig;
import com.alibaba.fastjson.asm.Opcodes;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.p518qq.p519e.comm.adevent.AdEventType;
import io.netty.handler.codec.dns.DnsRecord;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ErrorCorrection {
    private static final int MODULO_VALUE = 301;
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 92, DnsRecord.CLASS_NONE}, new int[]{28, 24, Opcodes.INVOKEINTERFACE, 166, 223, 248, 116, 255, 110, 61}, new int[]{175, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, AdEventType.VIDEO_STOP, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, Opcodes.IFLE, 91, 61, 42, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, AdEventType.VIDEO_PRELOAD_ERROR, 97, Opcodes.GETSTATIC, 100, BuildConfig.VERSION_CODE}, new int[]{156, 97, Opcodes.CHECKCAST, 252, 95, 9, 157, 119, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, 45, 18, 186, 83, Opcodes.INVOKEINTERFACE}, new int[]{83, 195, 100, 39, Opcodes.NEWARRAY, 75, 66, 61, 241, AdEventType.VIDEO_PRELOAD_ERROR, 109, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXTRA, 94, DnsRecord.CLASS_NONE, 225, 48, 90, Opcodes.NEWARRAY}, new int[]{15, 195, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 9, 233, 71, 168, 2, Opcodes.NEWARRAY, 160, 153, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_NOTIFICATION, 253, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, AdEventType.VIDEO_STOP, 109, 39, Opcodes.ARETURN, 21, 155, 197, 251, 223, 155, 21, 5, 172, DnsRecord.CLASS_NONE, 124, 12, 181, Opcodes.INVOKESTATIC, 96, 50, Opcodes.INSTANCEOF}, new int[]{AdEventType.VIDEO_LOADING, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, 110, AdEventType.VIDEO_PRELOAD_ERROR, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 120, 151, 233, 168, 93, 255}, new int[]{245, 127, BuildConfig.VERSION_CODE, 218, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_START_TOAST, 250, Opcodes.IF_ICMPGE, 181, 102, 120, 84, 179, 220, 251, 80, Opcodes.INVOKEVIRTUAL, 229, 18, 2, 4, 68, 33, 101, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON, 95, 119, 115, 44, 175, Opcodes.INVOKESTATIC, 59, 25, 225, 98, 81, 112}, new int[]{77, Opcodes.INSTANCEOF, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD, BuildConfig.VERSION_CODE, 8, 175, 95, 100, 9, Opcodes.GOTO, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME, Opcodes.RETURN, 226, 5, 9, 5}, new int[]{245, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, 172, 223, 96, 32, 117, 22, 238, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD, 238, 231, AdEventType.VIDEO_STOP, Opcodes.NEWARRAY, 237, 87, 191, 106, 16, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME, 118, 23, 37, 90, 170, AdEventType.VIDEO_STOP, 131, 88, 120, 100, 66, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, 186, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 82, 44, Opcodes.ARETURN, 87, 187, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME, 160, 175, 69, AdEventType.VIDEO_PRELOAD_ERROR, 92, 253, 225, 19}, new int[]{175, 9, 223, 238, 12, 17, 220, AdEventType.VIDEO_CLICKED, 100, 29, 175, 170, 230, Opcodes.CHECKCAST, 215, 235, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME, Opcodes.IF_ICMPEQ, 36, 223, 38, 200, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, 54, 228, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_PATH, 218, 234, 117, 203, 29, 232, 144, 238, 22, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME, 201, 117, 62, AdEventType.VIDEO_ERROR, 164, 13, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON, 245, 127, 67, 247, 28, 155, 43, 203, 107, 233, 53, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE, 46}, new int[]{BuildConfig.VERSION_CODE, 93, Opcodes.RET, 50, 144, AdEventType.VIDEO_READY, 39, 118, 202, Opcodes.NEWARRAY, 201, 189, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE, 108, 196, 37, Opcodes.INVOKEINTERFACE, 112, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, 230, 245, 63, 197, 190, 250, 106, Opcodes.INVOKEINTERFACE, 221, 175, 64, 114, 71, Opcodes.IF_ICMPLT, 44, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME, 6, 27, 218, 51, 63, 87, 10, 40, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_START_TOAST, Opcodes.NEWARRAY, 17, Opcodes.IF_ICMPGT, 31, Opcodes.ARETURN, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, AdEventType.VIDEO_PAUSE}, new int[]{220, 228, 173, 89, 251, 149, Opcodes.IF_ICMPEQ, 56, 89, 33, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, Opcodes.IFNE, 36, 73, 127, AdEventType.VIDEO_PRELOAD_ERROR, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 248, 180, 234, 197, Opcodes.IFLE, Opcodes.RETURN, 68, 122, 93, AdEventType.VIDEO_PRELOAD_ERROR, 15, 160, 227, 236, 66, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_CLICK_TRACK_URL, 153, Opcodes.INVOKEINTERFACE, 202, Opcodes.GOTO, 179, 25, 220, 232, 96, AdEventType.VIDEO_READY, 231, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 223, 239, 181, 241, 59, 52, 172, 25, 49, 232, AdEventType.VIDEO_LOADING, 189, 64, 54, 108, 153, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, 63, 96, 103, 82, 186}};
    private static final int[] LOG = new int[256];
    private static final int[] ALOG = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    private static String createECCBlock(CharSequence charSequence, int i) {
        return createECCBlock(charSequence, 0, charSequence.length(), i);
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
                int i = 0;
                while (i < interleavedBlockCount) {
                    int i2 = i + 1;
                    iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i2);
                    iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i2);
                    iArr3[i] = 0;
                    if (i > 0) {
                        iArr3[i] = iArr3[i - 1] + iArr[i];
                    }
                    i = i2;
                }
                for (int i3 = 0; i3 < interleavedBlockCount; i3++) {
                    StringBuilder sb2 = new StringBuilder(iArr[i3]);
                    for (int i4 = i3; i4 < symbolInfo.getDataCapacity(); i4 += interleavedBlockCount) {
                        sb2.append(str.charAt(i4));
                    }
                    String createECCBlock = createECCBlock(sb2.toString(), iArr2[i3]);
                    int i5 = i3;
                    int i6 = 0;
                    while (i5 < iArr2[i3] * interleavedBlockCount) {
                        sb.setCharAt(symbolInfo.getDataCapacity() + i5, createECCBlock.charAt(i6));
                        i5 += interleavedBlockCount;
                        i6++;
                    }
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
    }

    private static String createECCBlock(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i4 >= iArr.length) {
                i4 = -1;
                break;
            } else if (iArr[i4] == i3) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 >= 0) {
            int[] iArr2 = FACTORS[i4];
            char[] cArr = new char[i3];
            for (int i5 = 0; i5 < i3; i5++) {
                cArr[i5] = 0;
            }
            for (int i6 = i; i6 < i + i2; i6++) {
                int i7 = i3 - 1;
                int charAt = cArr[i7] ^ charSequence.charAt(i6);
                while (i7 > 0) {
                    if (charAt != 0 && iArr2[i7] != 0) {
                        char c = cArr[i7 - 1];
                        int[] iArr3 = ALOG;
                        int[] iArr4 = LOG;
                        cArr[i7] = (char) (c ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i7]]) % 255]);
                    } else {
                        cArr[i7] = cArr[i7 - 1];
                    }
                    i7--;
                }
                if (charAt != 0 && iArr2[0] != 0) {
                    int[] iArr5 = ALOG;
                    int[] iArr6 = LOG;
                    cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[iArr2[0]]) % 255];
                } else {
                    cArr[0] = 0;
                }
            }
            char[] cArr2 = new char[i3];
            for (int i8 = 0; i8 < i3; i8++) {
                cArr2[i8] = cArr[(i3 - i8) - 1];
            }
            return String.valueOf(cArr2);
        }
        throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i3);
    }
}
