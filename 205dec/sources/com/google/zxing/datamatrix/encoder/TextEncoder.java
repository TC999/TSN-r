package com.google.zxing.datamatrix.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class TextEncoder extends C40Encoder {
    @Override // com.google.zxing.datamatrix.encoder.C40Encoder
    int encodeChar(char c4, StringBuilder sb) {
        if (c4 == ' ') {
            sb.append((char) 3);
            return 1;
        } else if (c4 >= '0' && c4 <= '9') {
            sb.append((char) ((c4 - '0') + 4));
            return 1;
        } else if (c4 >= 'a' && c4 <= 'z') {
            sb.append((char) ((c4 - 'a') + 14));
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
        } else if (c4 == '`') {
            sb.append((char) 2);
            sb.append((char) (c4 - '`'));
            return 2;
        } else if (c4 >= 'A' && c4 <= 'Z') {
            sb.append((char) 2);
            sb.append((char) ((c4 - 'A') + 1));
            return 2;
        } else if (c4 >= '{' && c4 <= '\u007f') {
            sb.append((char) 2);
            sb.append((char) ((c4 - '{') + 27));
            return 2;
        } else if (c4 >= '\u0080') {
            sb.append("\u0001\u001e");
            return encodeChar((char) (c4 - '\u0080'), sb) + 2;
        } else {
            HighLevelEncoder.illegalCharacter(c4);
            return -1;
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder, com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 2;
    }
}
