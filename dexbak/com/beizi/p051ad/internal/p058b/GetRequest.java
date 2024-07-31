package com.beizi.p051ad.internal.p058b;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.beizi.ad.internal.b.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class GetRequest {

    /* renamed from: d */
    private static final Pattern f10012d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* renamed from: e */
    private static final Pattern f10013e = Pattern.compile("GET /(.*) HTTP");

    /* renamed from: a */
    public final String f10014a;

    /* renamed from: b */
    public final long f10015b;

    /* renamed from: c */
    public final boolean f10016c;

    public GetRequest(String str) {
        Preconditions.m49572a(str);
        long m49619a = m49619a(str);
        this.f10015b = Math.max(0L, m49619a);
        this.f10016c = m49619a >= 0;
        this.f10014a = m49618b(str);
    }

    /* renamed from: a */
    public static GetRequest m49620a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                sb.append(readLine);
                sb.append('\n');
            } else {
                return new GetRequest(sb.toString());
            }
        }
    }

    /* renamed from: b */
    private String m49618b(String str) {
        Matcher matcher = f10013e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f10015b + ", partial=" + this.f10016c + ", uri='" + this.f10014a + "'}";
    }

    /* renamed from: a */
    private long m49619a(String str) {
        Matcher matcher = f10012d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }
}
