package cn.jiguang.bv;

import android.text.TextUtils;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f2943a;

    /* renamed from: b  reason: collision with root package name */
    public int f2944b;

    /* renamed from: c  reason: collision with root package name */
    public transient InetAddress f2945c;

    public g(String str, int i4) {
        this.f2943a = str;
        this.f2944b = i4;
    }

    public g(InetAddress inetAddress, int i4) {
        this.f2943a = inetAddress.getHostAddress();
        this.f2944b = i4;
        this.f2945c = inetAddress;
    }

    public static g a(String str) {
        int lastIndexOf;
        String substring;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(":")) >= 0) {
            try {
                int intValue = Integer.decode(str.substring(lastIndexOf + 1)).intValue();
                if (lastIndexOf == 0) {
                    substring = "";
                } else {
                    int i4 = str.startsWith("[") ? 1 : 0;
                    if (str.charAt(lastIndexOf - 1) == ']') {
                        lastIndexOf--;
                    }
                    substring = str.substring(i4, lastIndexOf);
                }
                return new g(substring, intValue);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static String a(LinkedHashSet<g> linkedHashSet) {
        if (linkedHashSet == null || linkedHashSet.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<g> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static LinkedHashSet<g> a(LinkedHashMap<String, Integer> linkedHashMap) {
        LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            g gVar = new g(entry.getKey(), entry.getValue().intValue());
            if (gVar.a()) {
                linkedHashSet.add(gVar);
            }
        }
        return linkedHashSet;
    }

    private static void a(String str, LinkedHashSet<g> linkedHashSet) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (String str2 : str.split(",")) {
            g a4 = a(str2);
            if (a4 != null && a4.a()) {
                linkedHashSet.add(a4);
            }
        }
    }

    public static boolean a(String str, int i4) {
        return !TextUtils.isEmpty(str) && i4 > 0 && i4 <= 65535;
    }

    public static boolean b(String str) {
        try {
            return Math.abs(System.currentTimeMillis() - Long.valueOf(str).longValue()) > 259200000;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static LinkedHashSet<g> c(String str) {
        String str2;
        cn.jiguang.bq.d.c("IpPort", " string2Set=" + str);
        LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("-sis-");
            cn.jiguang.bq.d.c("IpPort", " string2Set split=" + Arrays.toString(split));
            if (split != null) {
                if (split.length >= 2) {
                    if (b(split[1])) {
                        return linkedHashSet;
                    }
                    str2 = split[0];
                } else if (split.length >= 1) {
                    str2 = split[0];
                }
                a(str2, linkedHashSet);
            }
        }
        cn.jiguang.bq.d.c("IpPort", " string2Set list=" + linkedHashSet);
        return linkedHashSet;
    }

    public boolean a() {
        int i4;
        return !TextUtils.isEmpty(this.f2943a) && (i4 = this.f2944b) > 0 && i4 <= 65535;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f2944b == gVar.f2944b) {
            String str = this.f2943a;
            String str2 = gVar.f2943a;
            if (str != null) {
                if (str.equals(str2)) {
                    return true;
                }
            } else if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f2943a;
        return ((str != null ? str.hashCode() : 0) * 31) + this.f2944b;
    }

    public String toString() {
        StringBuilder sb;
        String str = ":";
        if (this.f2943a.contains(":")) {
            sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f2943a);
            str = "]:";
        } else {
            sb = new StringBuilder();
            sb.append(this.f2943a);
        }
        sb.append(str);
        sb.append(this.f2944b);
        return sb.toString();
    }
}
