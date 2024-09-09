package com.umeng.commonsdk.config;

import android.content.Context;
import android.util.Pair;
import com.umeng.commonsdk.config.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class FieldManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f53292a = "cfgfd";

    /* renamed from: b  reason: collision with root package name */
    private static b f53293b = b.b();

    /* renamed from: c  reason: collision with root package name */
    private static boolean f53294c = false;

    /* renamed from: d  reason: collision with root package name */
    private static Object f53295d = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final FieldManager f53296a = new FieldManager();

        private a() {
        }
    }

    public static FieldManager a() {
        return a.f53296a;
    }

    public static boolean allow(String str) {
        synchronized (f53295d) {
            if (f53294c) {
                return b.a(str);
            }
            return false;
        }
    }

    public static boolean b() {
        boolean z3;
        synchronized (f53295d) {
            z3 = f53294c;
        }
        return z3;
    }

    private FieldManager() {
    }

    public void a(Context context) {
        String str;
        String str2 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC1057d.class.getName()};
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "cfgfd", "1001@3749699455,2130669566,262139,1983");
        synchronized (f53295d) {
            Pair<Long, String> a4 = a(imprintProperty);
            if (((Long) a4.first).longValue() > 1000 && (str = (String) a4.second) != null && str.length() > 0) {
                str2 = str;
            }
            String[] split = str2.split(",");
            int length = split.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                g gVar = new g();
                for (int i4 = 0; i4 < length; i4++) {
                    arrayList.add(gVar);
                    ((e) arrayList.get(i4)).a(split[i4], f53293b, d.b(strArr[i4]));
                }
            }
            f53294c = true;
        }
    }

    public void a(Context context, String str) {
        String str2;
        String str3 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC1057d.class.getName()};
        synchronized (f53295d) {
            f53293b.a();
            if (str != null) {
                Pair<Long, String> a4 = a(str);
                if (((Long) a4.first).longValue() > 1000 && (str2 = (String) a4.second) != null && str2.length() > 0) {
                    str3 = str2;
                }
            }
            String[] split = str3.split(",");
            int length = split.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                g gVar = new g();
                for (int i4 = 0; i4 < length; i4++) {
                    arrayList.add(gVar);
                    ((e) arrayList.get(i4)).a(split[i4], f53293b, d.b(strArr[i4]));
                }
            }
            f53294c = true;
        }
    }

    private static Pair<Long, String> a(String str) {
        Pair<Long, String> pair = new Pair<>(-1L, null);
        if (str != null && str.length() >= 2) {
            String[] split = str.split("@");
            if (split.length < 2) {
                return pair;
            }
            try {
                long parseLong = Long.parseLong(split[0]);
                return new Pair<>(Long.valueOf(parseLong), split[1]);
            } catch (Throwable unused) {
            }
        }
        return pair;
    }
}
