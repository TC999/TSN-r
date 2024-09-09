package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.ap;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class d {
    private static final Pattern aBN = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern aBO = Pattern.compile("GET /(.*) HTTP");
    public final long aBP;
    public final boolean aBQ;
    public final String uri;

    private d(String str) {
        ap.gH(str);
        long ey = ey(str);
        this.aBP = Math.max(0L, ey);
        this.aBQ = ey >= 0;
        this.uri = ez(str);
    }

    public static d b(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                sb.append(readLine);
                sb.append('\n');
            } else {
                return new d(sb.toString());
            }
        }
    }

    private static long ey(String str) {
        Matcher matcher = aBN.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private static String ez(String str) {
        Matcher matcher = aBO.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public final String toString() {
        return "GetRequest{rangeOffset=" + this.aBP + ", partial=" + this.aBQ + ", uri='" + this.uri + "'}";
    }
}
