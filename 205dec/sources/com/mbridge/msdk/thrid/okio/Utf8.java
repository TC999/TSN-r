package com.mbridge.msdk.thrid.okio;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class Utf8 {
    private Utf8() {
    }

    public static long size(String str) {
        return size(str, 0, str.length());
    }

    public static long size(String str, int i4, int i5) {
        long j4;
        if (str != null) {
            if (i4 < 0) {
                throw new IllegalArgumentException("beginIndex < 0: " + i4);
            } else if (i5 >= i4) {
                if (i5 > str.length()) {
                    throw new IllegalArgumentException("endIndex > string.length: " + i5 + " > " + str.length());
                }
                long j5 = 0;
                while (i4 < i5) {
                    char charAt = str.charAt(i4);
                    if (charAt < '\u0080') {
                        j5++;
                    } else {
                        if (charAt < '\u0800') {
                            j4 = 2;
                        } else if (charAt < '\ud800' || charAt > '\udfff') {
                            j4 = 3;
                        } else {
                            int i6 = i4 + 1;
                            char charAt2 = i6 < i5 ? str.charAt(i6) : (char) 0;
                            if (charAt > '\udbff' || charAt2 < '\udc00' || charAt2 > '\udfff') {
                                j5++;
                                i4 = i6;
                            } else {
                                j5 += 4;
                                i4 += 2;
                            }
                        }
                        j5 += j4;
                    }
                    i4++;
                }
                return j5;
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i5 + " < " + i4);
            }
        }
        throw new IllegalArgumentException("string == null");
    }
}
