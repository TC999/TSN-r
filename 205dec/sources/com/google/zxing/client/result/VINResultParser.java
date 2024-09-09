package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class VINResultParser extends ResultParser {
    private static final Pattern IOQ = Pattern.compile("[IOQ]");
    private static final Pattern AZ09 = Pattern.compile("[A-Z0-9]{17}");

    private static char checkChar(int i4) {
        if (i4 < 10) {
            return (char) (i4 + 48);
        }
        if (i4 == 10) {
            return 'X';
        }
        throw new IllegalArgumentException();
    }

    private static boolean checkChecksum(CharSequence charSequence) {
        int i4 = 0;
        int i5 = 0;
        while (i4 < charSequence.length()) {
            int i6 = i4 + 1;
            i5 += vinPositionWeight(i6) * vinCharValue(charSequence.charAt(i4));
            i4 = i6;
        }
        return charSequence.charAt(8) == checkChar(i5 % 11);
    }

    private static String countryCode(CharSequence charSequence) {
        char charAt = charSequence.charAt(0);
        char charAt2 = charSequence.charAt(1);
        if (charAt == '9') {
            if (charAt2 < 'A' || charAt2 > 'E') {
                if (charAt2 < '3' || charAt2 > '9') {
                    return null;
                }
                return "BR";
            }
            return "BR";
        } else if (charAt == 'S') {
            if (charAt2 < 'A' || charAt2 > 'M') {
                if (charAt2 < 'N' || charAt2 > 'T') {
                    return null;
                }
                return "DE";
            }
            return "UK";
        } else if (charAt == 'Z') {
            if (charAt2 < 'A' || charAt2 > 'R') {
                return null;
            }
            return "IT";
        } else {
            switch (charAt) {
                case '1':
                case '4':
                case '5':
                    return "US";
                case '2':
                    return "CA";
                case '3':
                    if (charAt2 < 'A' || charAt2 > 'W') {
                        return null;
                    }
                    return "MX";
                default:
                    switch (charAt) {
                        case 'J':
                            if (charAt2 < 'A' || charAt2 > 'T') {
                                return null;
                            }
                            return "JP";
                        case 'K':
                            if (charAt2 < 'L' || charAt2 > 'R') {
                                return null;
                            }
                            return "KO";
                        case 'L':
                            return "CN";
                        case 'M':
                            if (charAt2 < 'A' || charAt2 > 'E') {
                                return null;
                            }
                            return "IN";
                        default:
                            switch (charAt) {
                                case 'V':
                                    if (charAt2 < 'F' || charAt2 > 'R') {
                                        if (charAt2 < 'S' || charAt2 > 'W') {
                                            return null;
                                        }
                                        return "ES";
                                    }
                                    return "FR";
                                case 'W':
                                    return "DE";
                                case 'X':
                                    if (charAt2 != '0') {
                                        if (charAt2 < '3' || charAt2 > '9') {
                                            return null;
                                        }
                                        return "RU";
                                    }
                                    return "RU";
                                default:
                                    return null;
                            }
                    }
            }
        }
    }

    private static int modelYear(char c4) {
        if (c4 < 'E' || c4 > 'H') {
            if (c4 < 'J' || c4 > 'N') {
                if (c4 == 'P') {
                    return 1993;
                }
                if (c4 < 'R' || c4 > 'T') {
                    if (c4 < 'V' || c4 > 'Y') {
                        if (c4 < '1' || c4 > '9') {
                            if (c4 < 'A' || c4 > 'D') {
                                throw new IllegalArgumentException();
                            }
                            return (c4 - 'A') + 2010;
                        }
                        return (c4 - '1') + 2001;
                    }
                    return (c4 - 'V') + 1997;
                }
                return (c4 - 'R') + 1994;
            }
            return (c4 - 'J') + 1988;
        }
        return (c4 - 'E') + 1984;
    }

    private static int vinCharValue(char c4) {
        if (c4 < 'A' || c4 > 'I') {
            if (c4 < 'J' || c4 > 'R') {
                if (c4 < 'S' || c4 > 'Z') {
                    if (c4 < '0' || c4 > '9') {
                        throw new IllegalArgumentException();
                    }
                    return c4 - '0';
                }
                return (c4 - 'S') + 2;
            }
            return (c4 - 'J') + 1;
        }
        return (c4 - 'A') + 1;
    }

    private static int vinPositionWeight(int i4) {
        if (i4 <= 0 || i4 > 7) {
            if (i4 == 8) {
                return 10;
            }
            if (i4 == 9) {
                return 0;
            }
            if (i4 < 10 || i4 > 17) {
                throw new IllegalArgumentException();
            }
            return 19 - i4;
        }
        return 9 - i4;
    }

    @Override // com.google.zxing.client.result.ResultParser
    public VINParsedResult parse(Result result) {
        if (result.getBarcodeFormat() != BarcodeFormat.CODE_39) {
            return null;
        }
        String trim = IOQ.matcher(result.getText()).replaceAll("").trim();
        if (AZ09.matcher(trim).matches()) {
            try {
                if (checkChecksum(trim)) {
                    String substring = trim.substring(0, 3);
                    return new VINParsedResult(trim, substring, trim.substring(3, 9), trim.substring(9, 17), countryCode(substring), trim.substring(3, 8), modelYear(trim.charAt(9)), trim.charAt(10), trim.substring(11));
                }
                return null;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return null;
    }
}
