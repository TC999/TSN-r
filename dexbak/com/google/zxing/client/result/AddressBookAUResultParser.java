package com.google.zxing.client.result;

import com.google.zxing.Result;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class AddressBookAUResultParser extends ResultParser {
    private static String[] matchMultipleValuePrefix(String str, int i, String str2, boolean z) {
        ArrayList arrayList = null;
        for (int i2 = 1; i2 <= i; i2++) {
            String matchSinglePrefixedField = ResultParser.matchSinglePrefixedField(str + i2 + ':', str2, StringUtil.CARRIAGE_RETURN, z);
            if (matchSinglePrefixedField == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList(i);
            }
            arrayList.add(matchSinglePrefixedField);
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        if (massagedText.contains("MEMORY") && massagedText.contains("\r\n")) {
            String matchSinglePrefixedField = ResultParser.matchSinglePrefixedField("NAME1:", massagedText, StringUtil.CARRIAGE_RETURN, true);
            String matchSinglePrefixedField2 = ResultParser.matchSinglePrefixedField("NAME2:", massagedText, StringUtil.CARRIAGE_RETURN, true);
            String[] matchMultipleValuePrefix = matchMultipleValuePrefix("TEL", 3, massagedText, true);
            String[] matchMultipleValuePrefix2 = matchMultipleValuePrefix("MAIL", 3, massagedText, true);
            String matchSinglePrefixedField3 = ResultParser.matchSinglePrefixedField("MEMORY:", massagedText, StringUtil.CARRIAGE_RETURN, false);
            String matchSinglePrefixedField4 = ResultParser.matchSinglePrefixedField("ADD:", massagedText, StringUtil.CARRIAGE_RETURN, true);
            return new AddressBookParsedResult(ResultParser.maybeWrap(matchSinglePrefixedField), null, matchSinglePrefixedField2, matchMultipleValuePrefix, null, matchMultipleValuePrefix2, null, null, matchSinglePrefixedField3, matchSinglePrefixedField4 != null ? new String[]{matchSinglePrefixedField4} : null, null, null, null, null, null, null);
        }
        return null;
    }
}
