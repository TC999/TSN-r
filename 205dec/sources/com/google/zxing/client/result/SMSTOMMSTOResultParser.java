package com.google.zxing.client.result;

import com.google.zxing.Result;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class SMSTOMMSTOResultParser extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public SMSParsedResult parse(Result result) {
        String str;
        String massagedText = ResultParser.getMassagedText(result);
        if (massagedText.startsWith("smsto:") || massagedText.startsWith("SMSTO:") || massagedText.startsWith("mmsto:") || massagedText.startsWith("MMSTO:")) {
            String substring = massagedText.substring(6);
            int indexOf = substring.indexOf(58);
            if (indexOf >= 0) {
                str = substring.substring(indexOf + 1);
                substring = substring.substring(0, indexOf);
            } else {
                str = null;
            }
            return new SMSParsedResult(substring, (String) null, (String) null, str);
        }
        return null;
    }
}
