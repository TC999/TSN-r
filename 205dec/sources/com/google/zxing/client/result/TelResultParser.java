package com.google.zxing.client.result;

import com.google.zxing.Result;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class TelResultParser extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public TelParsedResult parse(Result result) {
        String str;
        String massagedText = ResultParser.getMassagedText(result);
        if (massagedText.startsWith("tel:") || massagedText.startsWith("TEL:")) {
            if (massagedText.startsWith("TEL:")) {
                str = "tel:" + massagedText.substring(4);
            } else {
                str = massagedText;
            }
            int indexOf = massagedText.indexOf(63, 4);
            return new TelParsedResult(indexOf < 0 ? massagedText.substring(4) : massagedText.substring(4, indexOf), str, null);
        }
        return null;
    }
}
