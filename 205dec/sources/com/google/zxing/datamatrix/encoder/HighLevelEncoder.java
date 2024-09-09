package com.google.zxing.datamatrix.encoder;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.Dimension;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class HighLevelEncoder {
    static final int ASCII_ENCODATION = 0;
    static final int BASE256_ENCODATION = 5;
    static final int C40_ENCODATION = 1;
    static final char C40_UNLATCH = '\u00fe';
    static final int EDIFACT_ENCODATION = 4;
    static final char LATCH_TO_ANSIX12 = '\u00ee';
    static final char LATCH_TO_BASE256 = '\u00e7';
    static final char LATCH_TO_C40 = '\u00e6';
    static final char LATCH_TO_EDIFACT = '\u00f0';
    static final char LATCH_TO_TEXT = '\u00ef';
    private static final char MACRO_05 = '\u00ec';
    private static final String MACRO_05_HEADER = "[)>\u001e05\u001d";
    private static final char MACRO_06 = '\u00ed';
    private static final String MACRO_06_HEADER = "[)>\u001e06\u001d";
    private static final String MACRO_TRAILER = "\u001e\u0004";
    private static final char PAD = '\u0081';
    static final int TEXT_ENCODATION = 2;
    static final char UPPER_SHIFT = '\u00eb';
    static final int X12_ENCODATION = 3;
    static final char X12_UNLATCH = '\u00fe';

    private HighLevelEncoder() {
    }

    public static int determineConsecutiveDigitCount(CharSequence charSequence, int i4) {
        int length = charSequence.length();
        int i5 = 0;
        if (i4 < length) {
            char charAt = charSequence.charAt(i4);
            while (isDigit(charAt) && i4 < length) {
                i5++;
                i4++;
                if (i4 < length) {
                    charAt = charSequence.charAt(i4);
                }
            }
        }
        return i5;
    }

    public static String encodeHighLevel(String str) {
        return encodeHighLevel(str, SymbolShapeHint.FORCE_NONE, null, null);
    }

    private static int findMinimums(float[] fArr, int[] iArr, int i4, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i5 = 0; i5 < 6; i5++) {
            iArr[i5] = (int) Math.ceil(fArr[i5]);
            int i6 = iArr[i5];
            if (i4 > i6) {
                Arrays.fill(bArr, (byte) 0);
                i4 = i6;
            }
            if (i4 == i6) {
                bArr[i5] = (byte) (bArr[i5] + 1);
            }
        }
        return i4;
    }

    private static int getMinimumCount(byte[] bArr) {
        int i4 = 0;
        for (int i5 = 0; i5 < 6; i5++) {
            i4 += bArr[i5];
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void illegalCharacter(char c4) {
        String hexString;
        throw new IllegalArgumentException("Illegal character: " + c4 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + Integer.toHexString(c4)) + ')');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isDigit(char c4) {
        return c4 >= '0' && c4 <= '9';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isExtendedASCII(char c4) {
        return c4 >= '\u0080' && c4 <= '\u00ff';
    }

    private static boolean isNativeC40(char c4) {
        if (c4 != ' ') {
            if (c4 < '0' || c4 > '9') {
                return c4 >= 'A' && c4 <= 'Z';
            }
            return true;
        }
        return true;
    }

    private static boolean isNativeEDIFACT(char c4) {
        return c4 >= ' ' && c4 <= '^';
    }

    private static boolean isNativeText(char c4) {
        if (c4 != ' ') {
            if (c4 < '0' || c4 > '9') {
                return c4 >= 'a' && c4 <= 'z';
            }
            return true;
        }
        return true;
    }

    private static boolean isNativeX12(char c4) {
        if (isX12TermSep(c4) || c4 == ' ') {
            return true;
        }
        if (c4 < '0' || c4 > '9') {
            return c4 >= 'A' && c4 <= 'Z';
        }
        return true;
    }

    private static boolean isSpecialB256(char c4) {
        return false;
    }

    private static boolean isX12TermSep(char c4) {
        return c4 == '\r' || c4 == '*' || c4 == '>';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int lookAheadTest(CharSequence charSequence, int i4, int i5) {
        float[] fArr;
        char c4;
        if (i4 >= charSequence.length()) {
            return i5;
        }
        if (i5 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i5] = 0.0f;
        }
        int i6 = 0;
        while (true) {
            int i7 = i4 + i6;
            if (i7 == charSequence.length()) {
                byte[] bArr = new byte[6];
                int[] iArr = new int[6];
                int findMinimums = findMinimums(fArr, iArr, Integer.MAX_VALUE, bArr);
                int minimumCount = getMinimumCount(bArr);
                if (iArr[0] == findMinimums) {
                    return 0;
                }
                if (minimumCount != 1 || bArr[5] <= 0) {
                    if (minimumCount != 1 || bArr[4] <= 0) {
                        if (minimumCount != 1 || bArr[2] <= 0) {
                            return (minimumCount != 1 || bArr[3] <= 0) ? 1 : 3;
                        }
                        return 2;
                    }
                    return 4;
                }
                return 5;
            }
            char charAt = charSequence.charAt(i7);
            i6++;
            if (isDigit(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (isExtendedASCII(charAt)) {
                fArr[0] = (float) Math.ceil(fArr[0]);
                fArr[0] = fArr[0] + 2.0f;
            } else {
                fArr[0] = (float) Math.ceil(fArr[0]);
                fArr[0] = fArr[0] + 1.0f;
            }
            if (isNativeC40(charAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (isExtendedASCII(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (isNativeText(charAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (isExtendedASCII(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (isNativeX12(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (isExtendedASCII(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (isNativeEDIFACT(charAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (isExtendedASCII(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (isSpecialB256(charAt)) {
                c4 = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                c4 = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i6 >= 4) {
                int[] iArr2 = new int[6];
                byte[] bArr2 = new byte[6];
                findMinimums(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                int minimumCount2 = getMinimumCount(bArr2);
                if (iArr2[0] < iArr2[c4] && iArr2[0] < iArr2[1] && iArr2[0] < iArr2[2] && iArr2[0] < iArr2[3] && iArr2[0] < iArr2[4]) {
                    return 0;
                }
                if (iArr2[5] < iArr2[0] || bArr2[1] + bArr2[2] + bArr2[3] + bArr2[4] == 0) {
                    return 5;
                }
                if (minimumCount2 == 1 && bArr2[4] > 0) {
                    return 4;
                }
                if (minimumCount2 == 1 && bArr2[2] > 0) {
                    return 2;
                }
                if (minimumCount2 == 1 && bArr2[3] > 0) {
                    return 3;
                }
                if (iArr2[1] + 1 < iArr2[0] && iArr2[1] + 1 < iArr2[5] && iArr2[1] + 1 < iArr2[4] && iArr2[1] + 1 < iArr2[2]) {
                    if (iArr2[1] < iArr2[3]) {
                        return 1;
                    }
                    if (iArr2[1] == iArr2[3]) {
                        for (int i8 = i4 + i6 + 1; i8 < charSequence.length(); i8++) {
                            char charAt2 = charSequence.charAt(i8);
                            if (isX12TermSep(charAt2)) {
                                return 3;
                            }
                            if (!isNativeX12(charAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            }
        }
    }

    private static char randomize253State(char c4, int i4) {
        int i5 = c4 + ((i4 * 149) % MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT) + 1;
        if (i5 > 254) {
            i5 -= 254;
        }
        return (char) i5;
    }

    public static String encodeHighLevel(String str, SymbolShapeHint symbolShapeHint, Dimension dimension, Dimension dimension2) {
        int i4 = 0;
        Encoder[] encoderArr = {new ASCIIEncoder(), new C40Encoder(), new TextEncoder(), new X12Encoder(), new EdifactEncoder(), new Base256Encoder()};
        EncoderContext encoderContext = new EncoderContext(str);
        encoderContext.setSymbolShape(symbolShapeHint);
        encoderContext.setSizeConstraints(dimension, dimension2);
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            encoderContext.writeCodeword('\u00ec');
            encoderContext.setSkipAtEnd(2);
            encoderContext.pos += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            encoderContext.writeCodeword('\u00ed');
            encoderContext.setSkipAtEnd(2);
            encoderContext.pos += 7;
        }
        while (encoderContext.hasMoreCharacters()) {
            encoderArr[i4].encode(encoderContext);
            if (encoderContext.getNewEncoding() >= 0) {
                i4 = encoderContext.getNewEncoding();
                encoderContext.resetEncoderSignal();
            }
        }
        int codewordCount = encoderContext.getCodewordCount();
        encoderContext.updateSymbolInfo();
        int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity();
        if (codewordCount < dataCapacity && i4 != 0 && i4 != 5) {
            encoderContext.writeCodeword('\u00fe');
        }
        StringBuilder codewords = encoderContext.getCodewords();
        if (codewords.length() < dataCapacity) {
            codewords.append('\u0081');
        }
        while (codewords.length() < dataCapacity) {
            codewords.append(randomize253State('\u0081', codewords.length() + 1));
        }
        return encoderContext.getCodewords().toString();
    }
}
