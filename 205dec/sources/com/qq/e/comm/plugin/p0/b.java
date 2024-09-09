package com.qq.e.comm.plugin.p0;

import android.text.TextUtils;
import com.qq.e.comm.plugin.util.d1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class b {

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f45310f = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f45311g = Pattern.compile("GET /(.*)%26sdk_ad_type%3D");

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f45312h = Pattern.compile("%26sdk_ad_type%3D(\\d+)%26video_view_hashcode%3D");

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f45313i = Pattern.compile("%26video_view_hashcode%3D(\\d+)");

    /* renamed from: a  reason: collision with root package name */
    public final String f45314a;

    /* renamed from: b  reason: collision with root package name */
    final long f45315b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f45316c;

    /* renamed from: d  reason: collision with root package name */
    public final int f45317d;

    /* renamed from: e  reason: collision with root package name */
    public final String f45318e;

    private b(String str) throws k {
        d1.a("VideoCache", "GetRequest->: " + str);
        i.a(str);
        long b4 = b(str);
        this.f45315b = Math.max(0L, b4);
        this.f45316c = b4 >= 0;
        this.f45314a = c(str);
        this.f45317d = a(str);
        this.f45318e = d(str);
    }

    public static b a(InputStream inputStream) throws IOException, k {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, com.qq.e.comm.plugin.k.a.f44515a));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                sb.append(readLine);
                sb.append('\n');
            } else {
                return new b(sb.toString());
            }
        }
    }

    private long b(String str) {
        Matcher matcher = f45310f.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private String c(String str) {
        Matcher matcher = f45311g.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    private String d(String str) {
        Matcher matcher = f45313i.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: Video hashcode not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f45315b + ", partial=" + this.f45316c + ", uri=" + this.f45314a + ", videoViewHashcode=" + this.f45318e + ", adType='" + this.f45317d + "'}";
    }

    private int a(String str) {
        Matcher matcher = f45312h.matcher(str);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: ad type not found!");
    }
}
