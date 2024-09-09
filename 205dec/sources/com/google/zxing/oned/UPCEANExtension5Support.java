package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class UPCEANExtension5Support {
    private static final int[] CHECK_DIGIT_ENCODINGS = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    private final int[] decodeMiddleCounters = new int[4];
    private final StringBuilder decodeRowStringBuffer = new StringBuilder();

    private int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i4 = iArr[1];
        int i5 = 0;
        for (int i6 = 0; i6 < 5 && i4 < size; i6++) {
            int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i4, UPCEANReader.L_AND_G_PATTERNS);
            sb.append((char) ((decodeDigit % 10) + 48));
            for (int i7 : iArr2) {
                i4 += i7;
            }
            if (decodeDigit >= 10) {
                i5 |= 1 << (4 - i6);
            }
            if (i6 != 4) {
                i4 = bitArray.getNextUnset(bitArray.getNextSet(i4));
            }
        }
        if (sb.length() == 5) {
            if (extensionChecksum(sb.toString()) == determineCheckDigit(i5)) {
                return i4;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int determineCheckDigit(int i4) throws NotFoundException {
        for (int i5 = 0; i5 < 10; i5++) {
            if (i4 == CHECK_DIGIT_ENCODINGS[i5]) {
                return i5;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int extensionChecksum(CharSequence charSequence) {
        int length = charSequence.length();
        int i4 = 0;
        for (int i5 = length - 2; i5 >= 0; i5 -= 2) {
            i4 += charSequence.charAt(i5) - '0';
        }
        int i6 = i4 * 3;
        for (int i7 = length - 1; i7 >= 0; i7 -= 2) {
            i6 += charSequence.charAt(i7) - '0';
        }
        return (i6 * 3) % 10;
    }

    private static String parseExtension5String(String str) {
        String valueOf;
        char charAt = str.charAt(0);
        String str2 = "";
        if (charAt == '0') {
            str2 = "\u00a3";
        } else if (charAt == '5') {
            str2 = "$";
        } else if (charAt == '9') {
            if ("90000".equals(str)) {
                return null;
            }
            if ("99991".equals(str)) {
                return "0.00";
            }
            if ("99990".equals(str)) {
                return "Used";
            }
        }
        int parseInt = Integer.parseInt(str.substring(1));
        String valueOf2 = String.valueOf(parseInt / 100);
        int i4 = parseInt % 100;
        if (i4 < 10) {
            valueOf = "0" + i4;
        } else {
            valueOf = String.valueOf(i4);
        }
        return str2 + valueOf2 + '.' + valueOf;
    }

    private static Map<ResultMetadataType, Object> parseExtensionString(String str) {
        String parseExtension5String;
        if (str.length() == 5 && (parseExtension5String = parseExtension5String(str)) != null) {
            EnumMap enumMap = new EnumMap(ResultMetadataType.class);
            enumMap.put((EnumMap) ResultMetadataType.SUGGESTED_PRICE, (ResultMetadataType) parseExtension5String);
            return enumMap;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Result decodeRow(int i4, BitArray bitArray, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.decodeRowStringBuffer;
        sb.setLength(0);
        int decodeMiddle = decodeMiddle(bitArray, iArr, sb);
        String sb2 = sb.toString();
        Map<ResultMetadataType, Object> parseExtensionString = parseExtensionString(sb2);
        float f4 = i4;
        Result result = new Result(sb2, null, new ResultPoint[]{new ResultPoint((iArr[0] + iArr[1]) / 2.0f, f4), new ResultPoint(decodeMiddle, f4)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (parseExtensionString != null) {
            result.putAllMetadata(parseExtensionString);
        }
        return result;
    }
}
