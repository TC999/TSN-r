package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.C11023ap;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.kwad.sdk.core.videocache.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C10563d {
    private static final Pattern aBN = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern aBO = Pattern.compile("GET /(.*) HTTP");
    public final long aBP;
    public final boolean aBQ;
    public final String uri;

    private C10563d(String str) {
        C11023ap.m24086gH(str);
        long m25465ey = m25465ey(str);
        this.aBP = Math.max(0L, m25465ey);
        this.aBQ = m25465ey >= 0;
        this.uri = m25464ez(str);
    }

    /* renamed from: b */
    public static C10563d m25466b(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                sb.append(readLine);
                sb.append('\n');
            } else {
                return new C10563d(sb.toString());
            }
        }
    }

    /* renamed from: ey */
    private static long m25465ey(String str) {
        Matcher matcher = aBN.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    /* renamed from: ez */
    private static String m25464ez(String str) {
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
