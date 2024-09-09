package com.danikula.videocache;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: GetRequest.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
class g {

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f36748d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f36749e = Pattern.compile("GET /(.*) HTTP");

    /* renamed from: a  reason: collision with root package name */
    public final String f36750a;

    /* renamed from: b  reason: collision with root package name */
    public final long f36751b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f36752c;

    public g(String str) {
        n.d(str);
        long a4 = a(str);
        this.f36751b = Math.max(0L, a4);
        this.f36752c = a4 >= 0;
        this.f36750a = b(str);
    }

    private long a(String str) {
        Matcher matcher = f36748d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private String b(String str) {
        Matcher matcher = f36749e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public static g c(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                sb.append(readLine);
                sb.append('\n');
            } else {
                return new g(sb.toString());
            }
        }
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f36751b + ", partial=" + this.f36752c + ", uri='" + this.f36750a + "'}";
    }
}
