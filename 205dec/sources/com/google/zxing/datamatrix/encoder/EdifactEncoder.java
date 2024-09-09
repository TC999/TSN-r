package com.google.zxing.datamatrix.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class EdifactEncoder implements Encoder {
    private static void encodeChar(char c4, StringBuilder sb) {
        if (c4 >= ' ' && c4 <= '?') {
            sb.append(c4);
        } else if (c4 >= '@' && c4 <= '^') {
            sb.append((char) (c4 - '@'));
        } else {
            HighLevelEncoder.illegalCharacter(c4);
        }
    }

    private static String encodeToCodewords(CharSequence charSequence, int i4) {
        int length = charSequence.length() - i4;
        if (length != 0) {
            int charAt = (charSequence.charAt(i4) << 18) + ((length >= 2 ? charSequence.charAt(i4 + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i4 + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i4 + 3) : (char) 0);
            char c4 = (char) ((charAt >> 8) & 255);
            char c5 = (char) (charAt & 255);
            StringBuilder sb = new StringBuilder(3);
            sb.append((char) ((charAt >> 16) & 255));
            if (length >= 2) {
                sb.append(c4);
            }
            if (length >= 3) {
                sb.append(c5);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }

    private static void handleEOD(EncoderContext encoderContext, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z3 = true;
            if (length == 1) {
                encoderContext.updateSymbolInfo();
                int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
                if (encoderContext.getRemainingCharacters() == 0 && dataCapacity <= 2) {
                    return;
                }
            }
            if (length <= 4) {
                int i4 = length - 1;
                String encodeToCodewords = encodeToCodewords(charSequence, 0);
                if (!(!encoderContext.hasMoreCharacters()) || i4 > 2) {
                    z3 = false;
                }
                if (i4 <= 2) {
                    encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + i4);
                    if (encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount() >= 3) {
                        encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + encodeToCodewords.length());
                        z3 = false;
                    }
                }
                if (z3) {
                    encoderContext.resetSymbolInfo();
                    encoderContext.pos -= i4;
                } else {
                    encoderContext.writeCodewords(encodeToCodewords);
                }
                return;
            }
            throw new IllegalStateException("Count must not exceed 4");
        } finally {
            encoderContext.signalEncoderChange(0);
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            encodeChar(encoderContext.getCurrentChar(), sb);
            encoderContext.pos++;
            if (sb.length() >= 4) {
                encoderContext.writeCodewords(encodeToCodewords(sb, 0));
                sb.delete(0, 4);
                if (HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                    encoderContext.signalEncoderChange(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        handleEOD(encoderContext, sb);
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 4;
    }
}
