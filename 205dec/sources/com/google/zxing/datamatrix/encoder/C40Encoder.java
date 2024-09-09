package com.google.zxing.datamatrix.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class C40Encoder implements Encoder {
    private int backtrackOneCharacter(EncoderContext encoderContext, StringBuilder sb, StringBuilder sb2, int i4) {
        int length = sb.length();
        sb.delete(length - i4, length);
        encoderContext.pos--;
        int encodeChar = encodeChar(encoderContext.getCurrentChar(), sb2);
        encoderContext.resetSymbolInfo();
        return encodeChar;
    }

    private static String encodeToCodewords(CharSequence charSequence, int i4) {
        int charAt = (charSequence.charAt(i4) * '\u0640') + (charSequence.charAt(i4 + 1) * '(') + charSequence.charAt(i4 + 2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeNextTriplet(EncoderContext encoderContext, StringBuilder sb) {
        encoderContext.writeCodewords(encodeToCodewords(sb, 0));
        sb.delete(0, 3);
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        int lookAheadTest;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            char currentChar = encoderContext.getCurrentChar();
            encoderContext.pos++;
            int encodeChar = encodeChar(currentChar, sb);
            int codewordCount = encoderContext.getCodewordCount() + ((sb.length() / 3) << 1);
            encoderContext.updateSymbolInfo(codewordCount);
            int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount;
            if (!encoderContext.hasMoreCharacters()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (dataCapacity < 2 || dataCapacity > 2)) {
                    encodeChar = backtrackOneCharacter(encoderContext, sb, sb2, encodeChar);
                }
                while (sb.length() % 3 == 1 && ((encodeChar <= 3 && dataCapacity != 1) || encodeChar > 3)) {
                    encodeChar = backtrackOneCharacter(encoderContext, sb, sb2, encodeChar);
                }
            } else if (sb.length() % 3 == 0 && (lookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode())) != getEncodingMode()) {
                encoderContext.signalEncoderChange(lookAheadTest);
                break;
            }
        }
        handleEOD(encoderContext, sb);
    }

    int encodeChar(char c4, StringBuilder sb) {
        if (c4 == ' ') {
            sb.append((char) 3);
            return 1;
        } else if (c4 >= '0' && c4 <= '9') {
            sb.append((char) ((c4 - '0') + 4));
            return 1;
        } else if (c4 >= 'A' && c4 <= 'Z') {
            sb.append((char) ((c4 - 'A') + 14));
            return 1;
        } else if (c4 >= 0 && c4 <= 31) {
            sb.append((char) 0);
            sb.append(c4);
            return 2;
        } else if (c4 >= '!' && c4 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c4 - '!'));
            return 2;
        } else if (c4 >= ':' && c4 <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c4 - ':') + 15));
            return 2;
        } else if (c4 >= '[' && c4 <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c4 - '[') + 22));
            return 2;
        } else if (c4 >= '`' && c4 <= '\u007f') {
            sb.append((char) 2);
            sb.append((char) (c4 - '`'));
            return 2;
        } else if (c4 >= '\u0080') {
            sb.append("\u0001\u001e");
            return encodeChar((char) (c4 - '\u0080'), sb) + 2;
        } else {
            throw new IllegalArgumentException("Illegal character: " + c4);
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 1;
    }

    void handleEOD(EncoderContext encoderContext, StringBuilder sb) {
        int length = sb.length() % 3;
        int codewordCount = encoderContext.getCodewordCount() + ((sb.length() / 3) << 1);
        encoderContext.updateSymbolInfo(codewordCount);
        int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount;
        if (length == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword('\u00fe');
            }
        } else if (dataCapacity == 1 && length == 1) {
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword('\u00fe');
            }
            encoderContext.pos--;
        } else if (length == 0) {
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (dataCapacity > 0 || encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword('\u00fe');
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        encoderContext.signalEncoderChange(0);
    }
}
