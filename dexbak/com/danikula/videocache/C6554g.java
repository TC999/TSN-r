package com.danikula.videocache;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: GetRequest.java */
/* renamed from: com.danikula.videocache.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
class C6554g {

    /* renamed from: d */
    private static final Pattern f23081d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* renamed from: e */
    private static final Pattern f23082e = Pattern.compile("GET /(.*) HTTP");

    /* renamed from: a */
    public final String f23083a;

    /* renamed from: b */
    public final long f23084b;

    /* renamed from: c */
    public final boolean f23085c;

    public C6554g(String str) {
        C6567n.m35858d(str);
        long m35924a = m35924a(str);
        this.f23084b = Math.max(0L, m35924a);
        this.f23085c = m35924a >= 0;
        this.f23083a = m35923b(str);
    }

    /* renamed from: a */
    private long m35924a(String str) {
        Matcher matcher = f23081d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    /* renamed from: b */
    private String m35923b(String str) {
        Matcher matcher = f23082e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    /* renamed from: c */
    public static C6554g m35922c(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                sb.append(readLine);
                sb.append('\n');
            } else {
                return new C6554g(sb.toString());
            }
        }
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f23084b + ", partial=" + this.f23085c + ", uri='" + this.f23083a + "'}";
    }
}
