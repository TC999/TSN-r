package com.google.zxing.client.result;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
abstract class AbstractDoCoMoResultParser extends ResultParser {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] matchDoCoMoPrefixedField(String str, String str2, boolean z3) {
        return ResultParser.matchPrefixedField(str, str2, ';', z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String matchSingleDoCoMoPrefixedField(String str, String str2, boolean z3) {
        return ResultParser.matchSinglePrefixedField(str, str2, ';', z3);
    }
}
