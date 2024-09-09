package com.bytedance.sdk.component.xv.w;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class s {

    /* renamed from: c  reason: collision with root package name */
    public final String[] f31096c;

    s(c cVar) {
        List<String> list = cVar.f31097c;
        this.f31096c = (String[]) list.toArray(new String[list.size()]);
    }

    public String c(String str) {
        return c(this.f31096c, str);
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && Arrays.equals(((s) obj).f31096c, this.f31096c);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f31096c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int c4 = c();
        for (int i4 = 0; i4 < c4; i4++) {
            sb.append(c(i4));
            sb.append(": ");
            sb.append(w(i4));
            sb.append("\n");
        }
        return sb.toString();
    }

    public String w(int i4) {
        return this.f31096c[(i4 * 2) + 1];
    }

    public Map<String, List<String>> xv() {
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

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        final List<String> f31097c = new ArrayList(20);

        private void sr(String str, String str2) {
            if (str != null) {
                if (!str.isEmpty()) {
                    int length = str.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        char charAt = str.charAt(i4);
                        if (charAt <= ' ' || charAt >= '\u007f') {
                            throw new IllegalArgumentException(com.bytedance.sdk.component.xv.w.c.xv.c("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i4), str));
                        }
                    }
                    if (str2 != null) {
                        int length2 = str2.length();
                        for (int i5 = 0; i5 < length2; i5++) {
                            char charAt2 = str2.charAt(i5);
                            if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= '\u007f') {
                                throw new IllegalArgumentException(com.bytedance.sdk.component.xv.w.c.xv.c("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i5), str, str2));
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

        /* JADX INFO: Access modifiers changed from: package-private */
        public c c(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return w(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return w("", str.substring(1));
            }
            return w("", str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c w(String str, String str2) {
            this.f31097c.add(str);
            this.f31097c.add(str2.trim());
            return this;
        }

        public c xv(String str, String str2) {
            try {
                sr(str, str2);
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
            w(str);
            w(str, str2);
            return this;
        }

        public c w(String str) {
            int i4 = 0;
            while (i4 < this.f31097c.size()) {
                if (str.equalsIgnoreCase(this.f31097c.get(i4))) {
                    this.f31097c.remove(i4);
                    this.f31097c.remove(i4);
                    i4 -= 2;
                }
                i4 += 2;
            }
            return this;
        }

        public c c(String str, String str2) {
            try {
                sr(str, str2);
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
            return w(str, str2);
        }

        public s c() {
            return new s(this);
        }
    }

    public int c() {
        return this.f31096c.length / 2;
    }

    public List<String> w(String str) {
        int c4 = c();
        ArrayList arrayList = null;
        for (int i4 = 0; i4 < c4; i4++) {
            if (str.equalsIgnoreCase(c(i4))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(w(i4));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    private s(String[] strArr) {
        this.f31096c = strArr;
    }

    public String c(int i4) {
        return this.f31096c[i4 * 2];
    }

    private static String c(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static s c(String... strArr) {
        if (strArr != null) {
            if (strArr.length % 2 == 0) {
                String[] strArr2 = (String[]) strArr.clone();
                for (int i4 = 0; i4 < strArr2.length; i4++) {
                    if (strArr2[i4] != null) {
                        strArr2[i4] = strArr2[i4].trim();
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null");
                    }
                }
                for (int i5 = 0; i5 < strArr2.length; i5 += 2) {
                    String str = strArr2[i5];
                    String str2 = strArr2[i5 + 1];
                    if (str.length() == 0 || str.indexOf(0) != -1 || str2.indexOf(0) != -1) {
                        throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
                    }
                }
                return new s(strArr2);
            }
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        throw new NullPointerException("namesAndValues == null");
    }

    public c w() {
        c cVar = new c();
        Collections.addAll(cVar.f31097c, this.f31096c);
        return cVar;
    }
}
