package com.bytedance.sdk.component.w.c;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class f {

    /* renamed from: c  reason: collision with root package name */
    private final String[] f30405c;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        final List<String> f30406c = new ArrayList(20);

        private void xv(String str, String str2) {
            if (str != null) {
                if (!str.isEmpty()) {
                    int length = str.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        char charAt = str.charAt(i4);
                        if (charAt <= ' ' || charAt >= '\u007f') {
                            throw new IllegalArgumentException(com.bytedance.sdk.component.w.c.w.p.c("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i4), str));
                        }
                    }
                    if (str2 != null) {
                        int length2 = str2.length();
                        for (int i5 = 0; i5 < length2; i5++) {
                            char charAt2 = str2.charAt(i5);
                            if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= '\u007f') {
                                throw new IllegalArgumentException(com.bytedance.sdk.component.w.c.w.p.c("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i5), str, str2));
                            }
                        }
                        return;
                    }
                    throw new NullPointerException("value for name " + str + " == null");
                }
                throw new IllegalArgumentException("name is empty");
            }
            throw new NullPointerException("name == null");
        }

        public f c() {
            return new f(this);
        }

        public c w(String str, String str2) {
            try {
                xv(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i4 = 0; i4 < length; i4++) {
                            char charAt = str2.charAt(i4);
                            if ((charAt <= 31 && charAt != '\t') || charAt >= '\u007f') {
                                sb.append(URLEncoder.encode(String.valueOf(charAt), "UTF-8"));
                            } else {
                                sb.append(charAt);
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException e4) {
                        e4.printStackTrace();
                        return this;
                    }
                }
                return this;
            }
            return c(str, str2);
        }

        c c(String str, String str2) {
            this.f30406c.add(str);
            this.f30406c.add(str2.trim());
            return this;
        }
    }

    public f(String[] strArr) {
        this.f30405c = strArr;
    }

    public int c() {
        return this.f30405c.length / 2;
    }

    public String w(int i4) {
        return this.f30405c[(i4 * 2) + 1];
    }

    public String c(int i4) {
        return this.f30405c[i4 * 2];
    }

    public Map<String, List<String>> w() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int c4 = c();
        for (int i4 = 0; i4 < c4; i4++) {
            String lowerCase = c(i4).toLowerCase(Locale.US);
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(w(i4));
        }
        return treeMap;
    }

    f(c cVar) {
        List<String> list = cVar.f30406c;
        this.f30405c = (String[]) list.toArray(new String[list.size()]);
    }
}
