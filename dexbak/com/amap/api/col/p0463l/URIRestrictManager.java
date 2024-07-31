package com.amap.api.col.p0463l;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.z6 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class URIRestrictManager {

    /* renamed from: d */
    private static URIRestrictManager f5825d = null;

    /* renamed from: e */
    static final /* synthetic */ boolean f5826e = true;

    /* renamed from: a */
    private final Map<String, Map<String, List<String>>> f5827a = new HashMap();

    /* renamed from: b */
    private final Map<String, List<String>> f5828b = new HashMap();

    /* renamed from: c */
    private final List<String> f5829c = new ArrayList();

    /* renamed from: a */
    private static C2011a m53319a(C2011a c2011a) {
        if (c2011a == null) {
            return null;
        }
        String str = c2011a.f5832c;
        if (str == null || str.length() == 0) {
            return c2011a;
        }
        while (true) {
            String str2 = c2011a.f5832c;
            if (str2.charAt(str2.length() - 1) != '/') {
                break;
            }
            String str3 = c2011a.f5832c;
            c2011a.f5832c = str3.substring(0, str3.length() - 1);
        }
        while (c2011a.f5832c.charAt(0) == '/') {
            c2011a.f5832c = c2011a.f5832c.substring(1);
        }
        return c2011a;
    }

    /* renamed from: b */
    public static synchronized URIRestrictManager m53318b() {
        URIRestrictManager uRIRestrictManager;
        synchronized (URIRestrictManager.class) {
            if (f5825d == null) {
                f5825d = new URIRestrictManager();
            }
            uRIRestrictManager = f5825d;
        }
        return uRIRestrictManager;
    }

    /* renamed from: d */
    private static boolean m53316d(String str, String str2) {
        String[] split = str.split("/");
        String[] split2 = str2.split("/");
        if (split2.length < split.length) {
            return false;
        }
        for (int i = 0; i < split.length; i++) {
            if (!split[i].equals("*") && !split[i].equals(split2[i])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    private static C2011a m53315e(String str) {
        try {
            return new C2011a(new URL(str));
        } catch (MalformedURLException unused) {
            String str2 = null;
            if (str.contains("://")) {
                return null;
            }
            while (str.startsWith("/")) {
                str = str.substring(1);
            }
            String[] split = str.split("/");
            int i = 0;
            if (split[0].contains(".")) {
                str2 = split[0];
                i = 1;
            }
            StringBuilder sb = new StringBuilder();
            while (i < split.length) {
                if (sb.length() > 0) {
                    sb.append("/");
                }
                sb.append(split[i]);
                i++;
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '/') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return new C2011a(str2, sb.toString());
        }
    }

    /* renamed from: f */
    private synchronized boolean m53314f(C2011a c2011a) {
        if (c2011a != null) {
            if (c2011a.f5832c.length() != 0) {
                Map<String, List<String>> map = this.f5828b;
                String str = c2011a.f5830a;
                if (str != null && this.f5827a.containsKey(str)) {
                    map = this.f5827a.get(c2011a.f5830a);
                }
                List<String> list = this.f5829c;
                boolean z = f5826e;
                if (!z && map == null) {
                    throw new AssertionError();
                }
                String str2 = c2011a.f5831b;
                if (str2 != null && map.containsKey(str2)) {
                    list = map.get(c2011a.f5831b);
                }
                if (!z && list == null) {
                    throw new AssertionError();
                }
                for (String str3 : list) {
                    if (m53316d(str3, c2011a.f5832c)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    /* renamed from: c */
    public final boolean m53317c(String str) {
        C2011a m53319a;
        if (str == null || str.length() == 0 || (m53319a = m53319a(m53315e(str))) == null) {
            return false;
        }
        return m53314f(m53319a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: URIRestrictManager.java */
    /* renamed from: com.amap.api.col.3l.z6$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2011a {

        /* renamed from: a */
        public String f5830a;

        /* renamed from: b */
        public String f5831b;

        /* renamed from: c */
        public String f5832c;

        public C2011a(URL url) {
            this.f5830a = url.getProtocol();
            this.f5831b = url.getHost();
            this.f5832c = url.getPath();
        }

        public C2011a(String str, String str2) {
            this.f5830a = null;
            this.f5831b = str;
            this.f5832c = str2;
        }
    }
}
