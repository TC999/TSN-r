package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class GeoResultParser extends ResultParser {
    private static final Pattern GEO_URL_PATTERN = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    @Override // com.google.zxing.client.result.ResultParser
    public GeoParsedResult parse(Result result) {
        Matcher matcher = GEO_URL_PATTERN.matcher(ResultParser.getMassagedText(result));
        if (matcher.matches()) {
            String group = matcher.group(4);
            try {
                double parseDouble = Double.parseDouble(matcher.group(1));
                if (parseDouble <= 90.0d && parseDouble >= -90.0d) {
                    double parseDouble2 = Double.parseDouble(matcher.group(2));
                    if (parseDouble2 <= 180.0d && parseDouble2 >= -180.0d) {
                        double d4 = 0.0d;
                        if (matcher.group(3) != null) {
                            double parseDouble3 = Double.parseDouble(matcher.group(3));
                            if (parseDouble3 < 0.0d) {
                                return null;
                            }
                            d4 = parseDouble3;
                        }
                        return new GeoParsedResult(parseDouble, parseDouble2, d4, group);
                    }
                }
            } catch (NumberFormatException unused) {
            }
            return null;
        }
        return null;
    }
}
