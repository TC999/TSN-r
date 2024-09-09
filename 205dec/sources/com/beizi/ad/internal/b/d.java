package com.beizi.ad.internal.b;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: GetRequest.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class d {

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f13689d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f13690e = Pattern.compile("GET /(.*) HTTP");

    /* renamed from: a  reason: collision with root package name */
    public final String f13691a;

    /* renamed from: b  reason: collision with root package name */
    public final long f13692b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f13693c;

    public d(String str) {
        k.a(str);
        long a4 = a(str);
        this.f13692b = Math.max(0L, a4);
        this.f13693c = a4 >= 0;
        this.f13691a = b(str);
    }

    public static d a(InputStream inputStream) throws IOException {
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

    private String b(String str) {
        Matcher matcher = f13690e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f13692b + ", partial=" + this.f13693c + ", uri='" + this.f13691a + "'}";
    }

    private long a(String str) {
        Matcher matcher = f13689d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }
}
