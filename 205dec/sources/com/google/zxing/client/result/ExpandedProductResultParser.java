package com.google.zxing.client.result;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ExpandedProductResultParser extends ResultParser {
    private static String findAIvalue(int i4, String str) {
        if (str.charAt(i4) != '(') {
            return null;
        }
        String substring = str.substring(i4 + 1);
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < substring.length(); i5++) {
            char charAt = substring.charAt(i5);
            if (charAt == ')') {
                return sb.toString();
            }
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    private static String findValue(int i4, String str) {
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(i4);
        for (int i5 = 0; i5 < substring.length(); i5++) {
            char charAt = substring.charAt(i5);
            if (charAt == '(') {
                if (findAIvalue(i5, substring) != null) {
                    break;
                }
                sb.append('(');
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x020b, code lost:
        if (r1.equals("10") == false) goto L12;
     */
    @Override // com.google.zxing.client.result.ResultParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.zxing.client.result.ExpandedProductParsedResult parse(com.google.zxing.Result r24) {
        /*
            Method dump skipped, instructions count: 862
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.ExpandedProductResultParser.parse(com.google.zxing.Result):com.google.zxing.client.result.ExpandedProductParsedResult");
    }
}
