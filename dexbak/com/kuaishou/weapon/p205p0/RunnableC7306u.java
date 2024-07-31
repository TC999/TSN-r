package com.kuaishou.weapon.p205p0;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.u */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class RunnableC7306u implements Runnable {

    /* renamed from: a */
    public static final int f25076a = 1;

    /* renamed from: b */
    public static final int f25077b = 2;

    /* renamed from: c */
    public static final int f25078c = 4;

    /* renamed from: d */
    public static final int f25079d = 0;

    /* renamed from: e */
    public static final int f25080e = 8;

    /* renamed from: f */
    public static final int f25081f = 1;

    /* renamed from: g */
    public static final int f25082g = 3;

    /* renamed from: h */
    public static final int f25083h = 4;

    /* renamed from: o */
    private static long f25084o;

    /* renamed from: j */
    private Context f25086j;

    /* renamed from: k */
    private C7299q f25087k;

    /* renamed from: l */
    private C7304t f25088l;

    /* renamed from: m */
    private File f25089m;

    /* renamed from: n */
    private C7278dp f25090n;

    /* renamed from: p */
    private int f25091p;

    /* renamed from: r */
    private boolean f25093r;

    /* renamed from: q */
    private int f25092q = 0;

    /* renamed from: i */
    List<Integer> f25085i = new ArrayList();

    /* renamed from: s */
    private Map<Integer, C7307a> f25094s = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kuaishou.weapon.p0.u$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class C7307a {

        /* renamed from: a */
        int f25095a;

        public C7307a(int i) {
            this.f25095a = i;
        }
    }

    public RunnableC7306u(Context context, int i, boolean z) {
        this.f25091p = 0;
        this.f25093r = false;
        this.f25086j = context;
        this.f25087k = C7299q.m33786a(context);
        this.f25088l = C7304t.m33760a(context);
        this.f25090n = C7278dp.m33920a(context);
        this.f25089m = new File(context.getFilesDir(), ".tmp");
        this.f25091p = i;
        this.f25093r = z;
    }

    /* renamed from: a */
    public JSONObject m33746a() {
        try {
            String str = C7239cu.f24730a + C7239cu.f24736g;
            String m34030a = C7240cv.m34030a(this.f25086j);
            if (!TextUtils.isEmpty(m34030a)) {
                str = str + "?" + m34030a;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject m34025c = C7240cv.m34025c(this.f25086j);
            if (m34025c != null) {
                jSONObject.put("data", new C7198bn(this.f25086j).m34153c(m34025c.toString()));
            }
            C7289l m33849a = C7289l.m33849a(this.f25086j);
            C7291m c7291m = new C7291m(str, jSONObject);
            c7291m.m33834a(WeaponHI.cookieData);
            c7291m.m33832b(WeaponHI.encryENV);
            JSONObject jSONObject2 = new JSONObject(m33849a.m33848a(c7291m));
            int optInt = jSONObject2.optInt(CommonNetImpl.RESULT, 0);
            if (optInt != 1) {
                if (optInt == -7) {
                    C7278dp.m33920a(this.f25086j).m33917a(C7278dp.f24924a, 1, false);
                    return null;
                }
                return null;
            }
            String m34157a = new C7198bn(this.f25086j).m34157a(jSONObject2.getString("antispamPluginManageRsp"));
            if (TextUtils.isEmpty(m34157a)) {
                if (this.f25092q == 0) {
                    this.f25092q = 8;
                }
                throw new NetworkErrorException("kuaishou risk pluginloader response is null");
            }
            JSONObject jSONObject3 = new JSONObject(m34157a);
            if (jSONObject3.optInt("status", 0) == 1) {
                return jSONObject3.optJSONObject("plugin");
            }
            C7278dp c7278dp = this.f25090n;
            if (c7278dp != null) {
                c7278dp.m33916a(C7278dp.f24925b, System.currentTimeMillis(), true);
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
        boolean z;
        try {
            try {
                synchronized (RunnableC7306u.class) {
                    int i = this.f25091p;
                    if (i == 1 || i == 2 || i == 4 || this.f25093r || System.currentTimeMillis() - f25084o >= 300000) {
                        this.f25088l.m33748d();
                        f25084o = System.currentTimeMillis();
                        if ((System.currentTimeMillis() - this.f25090n.m33919a(C7278dp.f24925b)) - (this.f25090n.m33918a(C7278dp.f24926c, 6) * C7193bi.f24584s) > 0) {
                            List<C7303s> m33763a = this.f25088l.m33763a();
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList<C7303s> arrayList3 = new ArrayList();
                            ArrayList arrayList4 = new ArrayList();
                            JSONObject m33746a = m33746a();
                            if (m33746a != null) {
                                boolean z2 = false;
                                try {
                                    boolean m33941b = C7269dm.m33941b(this.f25086j);
                                    Iterator<String> keys = m33746a.keys();
                                    HashSet<String> hashSet = new HashSet();
                                    boolean z3 = false;
                                    while (keys.hasNext()) {
                                        String next = keys.next();
                                        if (m33941b && next.endsWith("64")) {
                                            if (next.length() > 3) {
                                                hashSet.add(next.substring(0, next.length() - 3));
                                                hashSet.add(next.substring(0, next.length() - 3) + ".32");
                                                z3 = true;
                                            } else {
                                                z3 = true;
                                            }
                                        } else if (!m33941b && next.endsWith("32")) {
                                            if (next.length() > 3) {
                                                hashSet.add(next.substring(0, next.length() - 3));
                                                hashSet.add(next.substring(0, next.length() - 3) + ".64");
                                                z3 = true;
                                            } else {
                                                z3 = true;
                                            }
                                        } else {
                                            if (m33941b && next.endsWith("v8")) {
                                                if (next.length() > 3) {
                                                    hashSet.add(next.substring(0, next.length() - 3));
                                                    hashSet.add(next.substring(0, next.length() - 3) + ".v7");
                                                    z3 = true;
                                                }
                                            } else if (!m33941b && next.endsWith("v7")) {
                                                if (next.length() > 3) {
                                                    hashSet.add(next.substring(0, next.length() - 3));
                                                    hashSet.add(next.substring(0, next.length() - 3) + ".v8");
                                                }
                                            }
                                            z3 = true;
                                        }
                                    }
                                    if (z3) {
                                        for (String str : hashSet) {
                                            m33746a.remove(str);
                                        }
                                    }
                                    z2 = z3;
                                } catch (Throwable unused) {
                                }
                                Iterator<String> keys2 = m33746a.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    C7303s m33827a = C7295o.m33827a(m33746a.optJSONObject(next2));
                                    if (m33827a != null) {
                                        if (z2 && !m33827a.f25043y && (next2.endsWith("32") || next2.endsWith("64") || next2.endsWith("v7") || next2.endsWith("v8"))) {
                                            m33827a.f25043y = true;
                                        }
                                        if (m33827a.f25040v) {
                                            arrayList4.add(next2);
                                        }
                                        if (!m33827a.f25043y) {
                                            arrayList3.add(m33827a);
                                        }
                                        int indexOf = m33763a.indexOf(m33827a);
                                        if (indexOf >= 0 && m33827a.f25043y) {
                                            C7303s c7303s = m33763a.get(indexOf);
                                            if (C7271dn.m33934b(m33827a.f25022d, c7303s.f25022d)) {
                                                int i2 = m33827a.f25042x;
                                                if (i2 != c7303s.f25042x) {
                                                    this.f25088l.m33749c(m33827a.f25019a, i2);
                                                }
                                                if (!this.f25088l.m33747d(m33827a.f25019a)) {
                                                    arrayList2.add(m33827a);
                                                }
                                                it = keys2;
                                                jSONObject = m33746a;
                                                z = z2;
                                            } else {
                                                jSONObject = m33746a;
                                                z = z2;
                                                it = keys2;
                                                this.f25090n.m33916a(C7278dp.f24925b, System.currentTimeMillis(), true);
                                                int i3 = m33827a.f25042x;
                                                if (i3 != c7303s.f25042x) {
                                                    this.f25088l.m33749c(m33827a.f25019a, i3);
                                                }
                                                arrayList.add(m33827a);
                                            }
                                            m33763a.remove(indexOf);
                                        } else {
                                            it = keys2;
                                            jSONObject = m33746a;
                                            z = z2;
                                            if (m33827a.f25043y) {
                                                arrayList2.add(m33827a);
                                            }
                                        }
                                        m33746a = jSONObject;
                                        z2 = z;
                                        keys2 = it;
                                    }
                                }
                                for (C7303s c7303s2 : m33763a) {
                                    if (!arrayList4.contains(c7303s2.f25021c)) {
                                        List<Integer> list = this.f25085i;
                                        if (list != null) {
                                            list.add(Integer.valueOf(c7303s2.f25019a));
                                        }
                                        this.f25087k.m33783a(c7303s2.f25021c);
                                    }
                                }
                                for (C7303s c7303s3 : arrayList3) {
                                    if (!arrayList4.contains(c7303s3.f25021c)) {
                                        List<Integer> list2 = this.f25085i;
                                        if (list2 != null) {
                                            list2.add(Integer.valueOf(c7303s3.f25019a));
                                        }
                                        this.f25087k.m33783a(c7303s3.f25021c);
                                    }
                                }
                                ArrayList<C7303s> arrayList5 = new ArrayList();
                                if (arrayList2.size() != 0) {
                                    arrayList5.addAll(arrayList2);
                                }
                                if (arrayList.size() != 0) {
                                    arrayList5.addAll(arrayList);
                                }
                                for (C7303s c7303s4 : arrayList5) {
                                    if (c7303s4 != null) {
                                        if (arrayList.contains(c7303s4)) {
                                            this.f25087k.m33788a(c7303s4.f25019a, c7303s4.f25022d, (PackageInfo) null);
                                        } else if (arrayList2.contains(c7303s4)) {
                                            m33745a(c7303s4);
                                        }
                                    }
                                }
                            } else {
                                throw new Exception("pluginJsonObject is null ");
                            }
                        } else {
                            this.f25087k.m33778c();
                            this.f25088l.m33756b();
                        }
                    }
                }
            } catch (Throwable unused2) {
                this.f25087k.m33778c();
                this.f25088l.m33756b();
            }
        } finally {
            WeaponHI.m34448iD();
        }
    }

    /* renamed from: a */
    private void m33745a(C7303s c7303s) {
        try {
            if (!TextUtils.isEmpty(c7303s.f25028j) && c7303s.f25028j.length() >= 10) {
                if (!this.f25089m.exists()) {
                    this.f25089m.mkdir();
                }
                File file = this.f25089m;
                File file2 = new File(file, c7303s.f25019a + "-" + c7303s.f25022d + ".tmp");
                File file3 = this.f25089m;
                File file4 = new File(file3, c7303s.f25019a + "-" + c7303s.f25022d + ".zip");
                boolean m33843a = C7289l.m33849a(this.f25086j).m33843a(c7303s.f25027i, file2);
                if (!m33843a) {
                    m33843a = C7289l.m33849a(this.f25086j).m33843a(c7303s.f25027i, file2);
                }
                if (m33843a) {
                    if (file4.exists()) {
                        file4.delete();
                    }
                    int m34304c = C7183b.m34304c(file2.getAbsolutePath(), file4.getAbsolutePath(), C7212c.m34109a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes("utf-8"), 2));
                    if (m34304c != 0) {
                        if (file4.exists()) {
                            file4.delete();
                        }
                        m33843a = false;
                    }
                    if (m34304c == 0 && file2.exists()) {
                        file2.delete();
                    }
                } else {
                    this.f25094s.put(Integer.valueOf(c7303s.f25019a), new C7307a(3));
                }
                String m33898a = C7281f.m33898a(file4);
                if (m33843a && c7303s.f25028j.equals(m33898a)) {
                    C7271dn.m33937a(file4.getAbsolutePath(), Boolean.TRUE);
                    c7303s.f25023e = file4.getAbsolutePath();
                    if (this.f25087k.m33784a(c7303s, (String) null, (String) null)) {
                        Map<Integer, C7307a> map = this.f25094s;
                        if (map != null && !map.containsKey(Integer.valueOf(c7303s.f25019a))) {
                            this.f25094s.put(Integer.valueOf(c7303s.f25019a), new C7307a(1));
                        }
                        this.f25090n.m33916a(C7278dp.f24925b, System.currentTimeMillis(), true);
                        return;
                    }
                    Map<Integer, C7307a> map2 = this.f25094s;
                    if (map2 != null && !map2.containsKey(Integer.valueOf(c7303s.f25019a))) {
                        this.f25094s.put(Integer.valueOf(c7303s.f25019a), new C7307a(4));
                    }
                    this.f25087k.m33788a(c7303s.f25019a, c7303s.f25022d, (PackageInfo) null);
                    return;
                }
                if (file2.exists()) {
                    file2.length();
                    file2.delete();
                }
                this.f25087k.m33788a(c7303s.f25019a, c7303s.f25022d, (PackageInfo) null);
                return;
            }
            this.f25087k.m33788a(c7303s.f25019a, c7303s.f25022d, (PackageInfo) null);
        } catch (Throwable unused) {
            this.f25087k.m33788a(c7303s.f25019a, c7303s.f25022d, (PackageInfo) null);
        }
    }
}
