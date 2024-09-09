package com.bxkj.base.v2.common.utils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: EncodeUtils.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class f {
    public static String a(String str) {
        String str2;
        String[] split = str.split("\\\\u");
        String str3 = split[0];
        for (int i4 = 1; i4 < split.length; i4++) {
            try {
                String str4 = str3 + ((char) Integer.parseInt(str2.substring(0, 4), 16));
                str3 = split[i4].length() > 4 ? str4 + str2.substring(4, str2.length()) : str4;
            } catch (Exception unused) {
                return str;
            }
        }
        return str3;
    }

    public static String b(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            char charAt = str.charAt(i4);
            if (charAt == '\\') {
                i4 = i5 + 1;
                char charAt2 = str.charAt(i5);
                if (charAt2 == 'u') {
                    int i6 = 0;
                    int i7 = 0;
                    while (i6 < 4) {
                        int i8 = i4 + 1;
                        char charAt3 = str.charAt(i4);
                        switch (charAt3) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                i7 = ((i7 << 4) + charAt3) - 48;
                                break;
                            default:
                                switch (charAt3) {
                                    case 'A':
                                    case 'B':
                                    case 'C':
                                    case 'D':
                                    case 'E':
                                    case 'F':
                                        i7 = (((i7 << 4) + 10) + charAt3) - 65;
                                        break;
                                    default:
                                        switch (charAt3) {
                                            case 'a':
                                            case 'b':
                                            case 'c':
                                            case 'd':
                                            case 'e':
                                            case 'f':
                                                i7 = (((i7 << 4) + 10) + charAt3) - 97;
                                                break;
                                            default:
                                                throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                                        }
                                }
                        }
                        i6++;
                        i4 = i8;
                    }
                    stringBuffer.append((char) i7);
                } else {
                    if (charAt2 == 't') {
                        charAt2 = '\t';
                    } else if (charAt2 == 'r') {
                        charAt2 = '\r';
                    } else if (charAt2 == 'n') {
                        charAt2 = '\n';
                    } else if (charAt2 == 'f') {
                        charAt2 = '\f';
                    }
                    stringBuffer.append(charAt2);
                }
            } else {
                stringBuffer.append(charAt);
                i4 = i5;
            }
        }
        return stringBuffer.toString();
    }
}
