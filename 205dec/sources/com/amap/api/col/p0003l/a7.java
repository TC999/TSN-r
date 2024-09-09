package com.amap.api.col.p0003l;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: URIRestrictManager.java */
/* renamed from: com.amap.api.col.3l.a7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a7 {

    /* renamed from: d  reason: collision with root package name */
    private static a7 f7111d = null;

    /* renamed from: e  reason: collision with root package name */
    static final /* synthetic */ boolean f7112e = true;

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Map<String, List<String>>> f7113a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<String>> f7114b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f7115c = new ArrayList();

    private static a a(a aVar) {
        if (aVar == null) {
            return null;
        }
        String str = aVar.f7118c;
        if (str == null || str.length() == 0) {
            return aVar;
        }
        while (true) {
            String str2 = aVar.f7118c;
            if (str2.charAt(str2.length() - 1) != '/') {
                break;
            }
            String str3 = aVar.f7118c;
            aVar.f7118c = str3.substring(0, str3.length() - 1);
        }
        while (aVar.f7118c.charAt(0) == '/') {
            aVar.f7118c = aVar.f7118c.substring(1);
        }
        return aVar;
    }

    public static synchronized a7 b() {
        a7 a7Var;
        synchronized (a7.class) {
            if (f7111d == null) {
                f7111d = new a7();
            }
            a7Var = f7111d;
        }
        return a7Var;
    }

    private static boolean d(String str, String str2) {
        String[] split = str.split(TTPathConst.sSeparator);
        String[] split2 = str2.split(TTPathConst.sSeparator);
        if (split2.length < split.length) {
            return false;
        }
        for (int i4 = 0; i4 < split.length; i4++) {
            if (!split[i4].equals("*") && !split[i4].equals(split2[i4])) {
                return false;
            }
        }
        return true;
    }

    private static a e(String str) {
        try {
            return new a(new URL(str));
        } catch (MalformedURLException unused) {
            String str2 = null;
            if (str.contains("://")) {
                return null;
            }
            while (str.startsWith(TTPathConst.sSeparator)) {
                str = str.substring(1);
            }
            String[] split = str.split(TTPathConst.sSeparator);
            int i4 = 0;
            if (split[0].contains(".")) {
                str2 = split[0];
                i4 = 1;
            }
            StringBuilder sb = new StringBuilder();
            while (i4 < split.length) {
                if (sb.length() > 0) {
                    sb.append(TTPathConst.sSeparator);
                }
                sb.append(split[i4]);
                i4++;
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '/') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return new a(str2, sb.toString());
        }
    }

    private synchronized boolean f(a aVar) {
        if (aVar != null) {
            if (aVar.f7118c.length() != 0) {
                Map<String, List<String>> map = this.f7114b;
                String str = aVar.f7116a;
                if (str != null && this.f7113a.containsKey(str)) {
                    map = this.f7113a.get(aVar.f7116a);
                }
                List<String> list = this.f7115c;
                boolean z3 = f7112e;
                if (!z3 && map == null) {
                    throw new AssertionError();
                }
                String str2 = aVar.f7117b;
                if (str2 != null && map.containsKey(str2)) {
                    list = map.get(aVar.f7117b);
                }
                if (!z3 && list == null) {
                    throw new AssertionError();
                }
                for (String str3 : list) {
                    if (d(str3, aVar.f7118c)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public final boolean c(String str) {
        a a4;
        if (str == null || str.length() == 0 || (a4 = a(e(str))) == null) {
            return false;
        }
        return f(a4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: URIRestrictManager.java */
    /* renamed from: com.amap.api.col.3l.a7$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f7116a;

        /* renamed from: b  reason: collision with root package name */
        public String f7117b;

        /* renamed from: c  reason: collision with root package name */
        public String f7118c;

        public a(URL url) {
            this.f7116a = url.getProtocol();
            this.f7117b = url.getHost();
            this.f7118c = url.getPath();
        }

        public a(String str, String str2) {
            this.f7116a = null;
            this.f7117b = str;
            this.f7118c = str2;
        }
    }
}
