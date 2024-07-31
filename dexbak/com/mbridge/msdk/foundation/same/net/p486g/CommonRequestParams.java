package com.mbridge.msdk.foundation.same.net.p486g;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.p482c.FormFile;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.text.Typography;

/* renamed from: com.mbridge.msdk.foundation.same.net.g.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class CommonRequestParams {

    /* renamed from: a */
    public static String f30821a = "a";

    /* renamed from: b */
    public static String f30822b = "d";

    /* renamed from: c */
    public static String f30823c = "e";

    /* renamed from: d */
    public static String f30824d = "f";

    /* renamed from: e */
    public static String f30825e = "g";

    /* renamed from: f */
    public static String f30826f = "h";

    /* renamed from: g */
    public static String f30827g = "i";

    /* renamed from: h */
    private static final String f30828h = "d";

    /* renamed from: i */
    private Map<String, String> f30829i = new LinkedHashMap();

    /* renamed from: j */
    private Map<String, FormFile> f30830j = new LinkedHashMap();

    /* renamed from: a */
    public final void m22222a(String str, String str2) {
        if (str2 == null) {
            SameLogTool.m21733d(f30828h, "add() value is null!");
        }
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.f30829i.put(str, str2);
    }

    /* renamed from: b */
    public final Map<String, String> m22221b() {
        return this.f30829i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(28);
        try {
            for (Map.Entry<String, String> entry : this.f30829i.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(Typography.f41567c);
                }
                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
            for (Map.Entry<String, FormFile> entry2 : this.f30830j.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(Typography.f41567c);
                }
                sb.append(URLEncoder.encode(entry2.getKey(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode("FILE_NAME_" + entry2.getValue().m22292a().getName(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            SameLogTool.m21733d(f30828h, e.getMessage());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public final String m22224a() {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : this.f30829i.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(Typography.f41567c);
                }
                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /* renamed from: a */
    public final void m22223a(String str) {
        this.f30829i.remove(str);
        this.f30830j.remove(str);
    }
}
