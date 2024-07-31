package com.google.zxing.client.result;

import com.google.zxing.Result;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class BookmarkDoCoMoResultParser extends AbstractDoCoMoResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public URIParsedResult parse(Result result) {
        String text = result.getText();
        if (text.startsWith("MEBKM:")) {
            String matchSingleDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("TITLE:", text, true);
            String[] matchDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("URL:", text, true);
            if (matchDoCoMoPrefixedField == null) {
                return null;
            }
            String str = matchDoCoMoPrefixedField[0];
            if (URIResultParser.isBasicallyValidURI(str)) {
                return new URIParsedResult(str, matchSingleDoCoMoPrefixedField);
            }
            return null;
        }
        return null;
    }
}
