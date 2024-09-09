package com.kuaishou.weapon.p0;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static final int f38467a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f38468b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f38469c = 4;

    /* renamed from: d  reason: collision with root package name */
    public static final int f38470d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static final int f38471e = 8;

    /* renamed from: f  reason: collision with root package name */
    public static final int f38472f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final int f38473g = 3;

    /* renamed from: h  reason: collision with root package name */
    public static final int f38474h = 4;

    /* renamed from: o  reason: collision with root package name */
    private static long f38475o;

    /* renamed from: j  reason: collision with root package name */
    private Context f38477j;

    /* renamed from: k  reason: collision with root package name */
    private q f38478k;

    /* renamed from: l  reason: collision with root package name */
    private t f38479l;

    /* renamed from: m  reason: collision with root package name */
    private File f38480m;

    /* renamed from: n  reason: collision with root package name */
    private dp f38481n;

    /* renamed from: p  reason: collision with root package name */
    private int f38482p;

    /* renamed from: r  reason: collision with root package name */
    private boolean f38484r;

    /* renamed from: q  reason: collision with root package name */
    private int f38483q = 0;

    /* renamed from: i  reason: collision with root package name */
    List<Integer> f38476i = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    private Map<Integer, a> f38485s = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        int f38486a;

        public a(int i4) {
            this.f38486a = i4;
        }
    }

    public u(Context context, int i4, boolean z3) {
        this.f38482p = 0;
        this.f38484r = false;
        this.f38477j = context;
        this.f38478k = q.a(context);
        this.f38479l = t.a(context);
        this.f38481n = dp.a(context);
        this.f38480m = new File(context.getFilesDir(), ".tmp");
        this.f38482p = i4;
        this.f38484r = z3;
    }

    public JSONObject a() {
        try {
            String str = cu.f38226a + cu.f38232g;
            String a4 = cv.a(this.f38477j);
            if (!TextUtils.isEmpty(a4)) {
                str = str + "?" + a4;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject c4 = cv.c(this.f38477j);
            if (c4 != null) {
                jSONObject.put("data", new bn(this.f38477j).c(c4.toString()));
            }
            l a5 = l.a(this.f38477j);
            m mVar = new m(str, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            JSONObject jSONObject2 = new JSONObject(a5.a(mVar));
            int optInt = jSONObject2.optInt("result", 0);
            if (optInt != 1) {
                if (optInt == -7) {
                    dp.a(this.f38477j).a("plc001_t_re", 1, false);
                    return null;
                }
                return null;
            }
            String a6 = new bn(this.f38477j).a(jSONObject2.getString("antispamPluginManageRsp"));
            if (TextUtils.isEmpty(a6)) {
                if (this.f38483q == 0) {
                    this.f38483q = 8;
                }
                throw new NetworkErrorException("kuaishou risk pluginloader response is null");
            }
            JSONObject jSONObject3 = new JSONObject(a6);
            if (jSONObject3.optInt("status", 0) == 1) {
                return jSONObject3.optJSONObject("plugin");
            }
            dp dpVar = this.f38481n;
            if (dpVar != null) {
                dpVar.a("wlpauct2", System.currentTimeMillis(), true);
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<String> it;
        JSONObject jSONObject;
        boolean z3;
        try {
            try {
                synchronized (u.class) {
                    int i4 = this.f38482p;
                    if (i4 == 1 || i4 == 2 || i4 == 4 || this.f38484r || System.currentTimeMillis() - f38475o >= 300000) {
                        this.f38479l.d();
                        f38475o = System.currentTimeMillis();
                        if ((System.currentTimeMillis() - this.f38481n.a("wlpauct2")) - (this.f38481n.a("plc001_pd_ptip_pi", 6) * 3600000) > 0) {
                            List<s> a4 = this.f38479l.a();
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList<s> arrayList3 = new ArrayList();
                            ArrayList arrayList4 = new ArrayList();
                            JSONObject a5 = a();
                            if (a5 != null) {
                                boolean z4 = false;
                                try {
                                    boolean b4 = dm.b(this.f38477j);
                                    Iterator<String> keys = a5.keys();
                                    HashSet<String> hashSet = new HashSet();
                                    boolean z5 = false;
                                    while (keys.hasNext()) {
                                        String next = keys.next();
                                        if (b4 && next.endsWith("64")) {
                                            if (next.length() > 3) {
                                                hashSet.add(next.substring(0, next.length() - 3));
                                                hashSet.add(next.substring(0, next.length() - 3) + ".32");
                                                z5 = true;
                                            } else {
                                                z5 = true;
                                            }
                                        } else if (!b4 && next.endsWith("32")) {
                                            if (next.length() > 3) {
                                                hashSet.add(next.substring(0, next.length() - 3));
                                                hashSet.add(next.substring(0, next.length() - 3) + ".64");
                                                z5 = true;
                                            } else {
                                                z5 = true;
                                            }
                                        } else {
                                            if (b4 && next.endsWith("v8")) {
                                                if (next.length() > 3) {
                                                    hashSet.add(next.substring(0, next.length() - 3));
                                                    hashSet.add(next.substring(0, next.length() - 3) + ".v7");
                                                    z5 = true;
                                                }
                                            } else if (!b4 && next.endsWith("v7")) {
                                                if (next.length() > 3) {
                                                    hashSet.add(next.substring(0, next.length() - 3));
                                                    hashSet.add(next.substring(0, next.length() - 3) + ".v8");
                                                }
                                            }
                                            z5 = true;
                                        }
                                    }
                                    if (z5) {
                                        for (String str : hashSet) {
                                            a5.remove(str);
                                        }
                                    }
                                    z4 = z5;
                                } catch (Throwable unused) {
                                }
                                Iterator<String> keys2 = a5.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    s a6 = o.a(a5.optJSONObject(next2));
                                    if (a6 != null) {
                                        if (z4 && !a6.f38439y && (next2.endsWith("32") || next2.endsWith("64") || next2.endsWith("v7") || next2.endsWith("v8"))) {
                                            a6.f38439y = true;
                                        }
                                        if (a6.f38436v) {
                                            arrayList4.add(next2);
                                        }
                                        if (!a6.f38439y) {
                                            arrayList3.add(a6);
                                        }
                                        int indexOf = a4.indexOf(a6);
                                        if (indexOf >= 0 && a6.f38439y) {
                                            s sVar = a4.get(indexOf);
                                            if (dn.b(a6.f38418d, sVar.f38418d)) {
                                                int i5 = a6.f38438x;
                                                if (i5 != sVar.f38438x) {
                                                    this.f38479l.c(a6.f38415a, i5);
                                                }
                                                if (!this.f38479l.d(a6.f38415a)) {
                                                    arrayList2.add(a6);
                                                }
                                                it = keys2;
                                                jSONObject = a5;
                                                z3 = z4;
                                            } else {
                                                jSONObject = a5;
                                                z3 = z4;
                                                it = keys2;
                                                this.f38481n.a("wlpauct2", System.currentTimeMillis(), true);
                                                int i6 = a6.f38438x;
                                                if (i6 != sVar.f38438x) {
                                                    this.f38479l.c(a6.f38415a, i6);
                                                }
                                                arrayList.add(a6);
                                            }
                                            a4.remove(indexOf);
                                        } else {
                                            it = keys2;
                                            jSONObject = a5;
                                            z3 = z4;
                                            if (a6.f38439y) {
                                                arrayList2.add(a6);
                                            }
                                        }
                                        a5 = jSONObject;
                                        z4 = z3;
                                        keys2 = it;
                                    }
                                }
                                for (s sVar2 : a4) {
                                    if (!arrayList4.contains(sVar2.f38417c)) {
                                        List<Integer> list = this.f38476i;
                                        if (list != null) {
                                            list.add(Integer.valueOf(sVar2.f38415a));
                                        }
                                        this.f38478k.a(sVar2.f38417c);
                                    }
                                }
                                for (s sVar3 : arrayList3) {
                                    if (!arrayList4.contains(sVar3.f38417c)) {
                                        List<Integer> list2 = this.f38476i;
                                        if (list2 != null) {
                                            list2.add(Integer.valueOf(sVar3.f38415a));
                                        }
                                        this.f38478k.a(sVar3.f38417c);
                                    }
                                }
                                ArrayList<s> arrayList5 = new ArrayList();
                                if (arrayList2.size() != 0) {
                                    arrayList5.addAll(arrayList2);
                                }
                                if (arrayList.size() != 0) {
                                    arrayList5.addAll(arrayList);
                                }
                                for (s sVar4 : arrayList5) {
                                    if (sVar4 != null) {
                                        if (arrayList.contains(sVar4)) {
                                            this.f38478k.a(sVar4.f38415a, sVar4.f38418d, (PackageInfo) null);
                                        } else if (arrayList2.contains(sVar4)) {
                                            a(sVar4);
                                        }
                                    }
                                }
                            } else {
                                throw new Exception("pluginJsonObject is null ");
                            }
                        } else {
                            this.f38478k.c();
                            this.f38479l.b();
                        }
                    }
                }
            } catch (Throwable unused2) {
                this.f38478k.c();
                this.f38479l.b();
            }
        } finally {
            WeaponHI.iD();
        }
    }

    private void a(s sVar) {
        try {
            if (!TextUtils.isEmpty(sVar.f38424j) && sVar.f38424j.length() >= 10) {
                if (!this.f38480m.exists()) {
                    this.f38480m.mkdir();
                }
                File file = this.f38480m;
                File file2 = new File(file, sVar.f38415a + "-" + sVar.f38418d + ".tmp");
                File file3 = this.f38480m;
                File file4 = new File(file3, sVar.f38415a + "-" + sVar.f38418d + ".zip");
                boolean a4 = l.a(this.f38477j).a(sVar.f38423i, file2);
                if (!a4) {
                    a4 = l.a(this.f38477j).a(sVar.f38423i, file2);
                }
                if (a4) {
                    if (file4.exists()) {
                        file4.delete();
                    }
                    int c4 = b.c(file2.getAbsolutePath(), file4.getAbsolutePath(), c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes("utf-8"), 2));
                    if (c4 != 0) {
                        if (file4.exists()) {
                            file4.delete();
                        }
                        a4 = false;
                    }
                    if (c4 == 0 && file2.exists()) {
                        file2.delete();
                    }
                } else {
                    this.f38485s.put(Integer.valueOf(sVar.f38415a), new a(3));
                }
                String a5 = f.a(file4);
                if (a4 && sVar.f38424j.equals(a5)) {
                    dn.a(file4.getAbsolutePath(), Boolean.TRUE);
                    sVar.f38419e = file4.getAbsolutePath();
                    if (this.f38478k.a(sVar, (String) null, (String) null)) {
                        Map<Integer, a> map = this.f38485s;
                        if (map != null && !map.containsKey(Integer.valueOf(sVar.f38415a))) {
                            this.f38485s.put(Integer.valueOf(sVar.f38415a), new a(1));
                        }
                        this.f38481n.a("wlpauct2", System.currentTimeMillis(), true);
                        return;
                    }
                    Map<Integer, a> map2 = this.f38485s;
                    if (map2 != null && !map2.containsKey(Integer.valueOf(sVar.f38415a))) {
                        this.f38485s.put(Integer.valueOf(sVar.f38415a), new a(4));
                    }
                    this.f38478k.a(sVar.f38415a, sVar.f38418d, (PackageInfo) null);
                    return;
                }
                if (file2.exists()) {
                    file2.length();
                    file2.delete();
                }
                this.f38478k.a(sVar.f38415a, sVar.f38418d, (PackageInfo) null);
                return;
            }
            this.f38478k.a(sVar.f38415a, sVar.f38418d, (PackageInfo) null);
        } catch (Throwable unused) {
            this.f38478k.a(sVar.f38415a, sVar.f38418d, (PackageInfo) null);
        }
    }
}
