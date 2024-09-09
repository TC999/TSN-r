package com.mbridge.msdk.foundation.same.net.g;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.x;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: CommonRequestParams.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f39594a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static String f39595b = "d";

    /* renamed from: c  reason: collision with root package name */
    public static String f39596c = "e";

    /* renamed from: d  reason: collision with root package name */
    public static String f39597d = "f";

    /* renamed from: e  reason: collision with root package name */
    public static String f39598e = "g";

    /* renamed from: f  reason: collision with root package name */
    public static String f39599f = "h";

    /* renamed from: g  reason: collision with root package name */
    public static String f39600g = "i";

    /* renamed from: h  reason: collision with root package name */
    private static final String f39601h = "d";

    /* renamed from: i  reason: collision with root package name */
    private Map<String, String> f39602i = new LinkedHashMap();

    /* renamed from: j  reason: collision with root package name */
    private Map<String, com.mbridge.msdk.foundation.same.net.c.a> f39603j = new LinkedHashMap();

    public final void a(String str, String str2) {
        if (str2 == null) {
            x.d(f39601h, "add() value is null!");
        }
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.f39602i.put(str, str2);
    }

    public final Map<String, String> b() {
        return this.f39602i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(28);
        try {
            for (Map.Entry<String, String> entry : this.f39602i.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
            for (Map.Entry<String, com.mbridge.msdk.foundation.same.net.c.a> entry2 : this.f39603j.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode(entry2.getKey(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode("FILE_NAME_" + entry2.getValue().a().getName(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e4) {
            x.d(f39601h, e4.getMessage());
        }
        return sb.toString();
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : this.f39602i.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return sb.toString();
    }

    public final void a(String str) {
        this.f39602i.remove(str);
        this.f39603j.remove(str);
    }
}
