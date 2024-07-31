package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ae */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12806ae {
    /* renamed from: a */
    public static C12888bu m15933a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        C12888bu c12888bu = new C12888bu();
        c12888bu.f36837a = userInfoBean.f36273e;
        c12888bu.f36841e = userInfoBean.f36278j;
        c12888bu.f36840d = userInfoBean.f36271c;
        c12888bu.f36839c = userInfoBean.f36272d;
        c12888bu.f36844h = userInfoBean.f36283o == 1;
        int i = userInfoBean.f36270b;
        if (i == 1) {
            c12888bu.f36838b = (byte) 1;
        } else if (i == 2) {
            c12888bu.f36838b = (byte) 4;
        } else if (i == 3) {
            c12888bu.f36838b = (byte) 2;
        } else if (i == 4) {
            c12888bu.f36838b = (byte) 3;
        } else if (i == 8) {
            c12888bu.f36838b = (byte) 8;
        } else if (i < 10 || i >= 20) {
            C12820al.m15872e("unknown uinfo type %d ", Integer.valueOf(i));
            return null;
        } else {
            c12888bu.f36838b = (byte) i;
        }
        HashMap hashMap = new HashMap();
        c12888bu.f36842f = hashMap;
        if (userInfoBean.f36284p >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(userInfoBean.f36284p);
            hashMap.put("C01", sb.toString());
        }
        if (userInfoBean.f36285q >= 0) {
            Map<String, String> map = c12888bu.f36842f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(userInfoBean.f36285q);
            map.put("C02", sb2.toString());
        }
        Map<String, String> map2 = userInfoBean.f36286r;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.f36286r.entrySet()) {
                Map<String, String> map3 = c12888bu.f36842f;
                map3.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map4 = userInfoBean.f36287s;
        if (map4 != null && map4.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.f36287s.entrySet()) {
                Map<String, String> map5 = c12888bu.f36842f;
                map5.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map6 = c12888bu.f36842f;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(!userInfoBean.f36280l);
        map6.put("A36", sb3.toString());
        Map<String, String> map7 = c12888bu.f36842f;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(userInfoBean.f36275g);
        map7.put("F02", sb4.toString());
        Map<String, String> map8 = c12888bu.f36842f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(userInfoBean.f36276h);
        map8.put("F03", sb5.toString());
        Map<String, String> map9 = c12888bu.f36842f;
        map9.put("F04", userInfoBean.f36278j);
        Map<String, String> map10 = c12888bu.f36842f;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(userInfoBean.f36277i);
        map10.put("F05", sb6.toString());
        Map<String, String> map11 = c12888bu.f36842f;
        map11.put("F06", userInfoBean.f36281m);
        Map<String, String> map12 = c12888bu.f36842f;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(userInfoBean.f36279k);
        map12.put("F10", sb7.toString());
        C12820al.m15874c("summary type %d vm:%d", Byte.valueOf(c12888bu.f36838b), Integer.valueOf(c12888bu.f36842f.size()));
        return c12888bu;
    }

    /* renamed from: a */
    public static <T extends AbstractC12901m> T m15929a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                C12898k c12898k = new C12898k(bArr);
                c12898k.m15620a("utf-8");
                newInstance.mo15579a(c12898k);
                return newInstance;
            } catch (Throwable th) {
                if (!C12820al.m15875b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C12884bq m15934a(Context context, int i, byte[] bArr) {
        String str;
        C12786aa m16005b = C12786aa.m16005b();
        StrategyBean m15941c = C12803ac.m15950a().m15941c();
        if (m16005b != null && m15941c != null) {
            try {
                C12884bq c12884bq = new C12884bq();
                synchronized (m16005b) {
                    c12884bq.f36785a = m16005b.f36449b;
                    c12884bq.f36786b = m16005b.m15998e();
                    c12884bq.f36787c = m16005b.f36450c;
                    c12884bq.f36788d = m16005b.f36462o;
                    c12884bq.f36789e = m16005b.f36466s;
                    c12884bq.f36790f = m16005b.f36455h;
                    c12884bq.f36791g = i;
                    if (bArr == null) {
                        bArr = "".getBytes();
                    }
                    c12884bq.f36792h = bArr;
                    c12884bq.f36793i = m16005b.m15992h();
                    c12884bq.f36794j = m16005b.f36458k;
                    c12884bq.f36795k = new HashMap();
                    c12884bq.f36796l = m16005b.m16000d();
                    c12884bq.f36797m = m15941c.f36305o;
                    c12884bq.f36799o = m16005b.m15994g();
                    c12884bq.f36800p = C12787ab.m15968c(context);
                    c12884bq.f36801q = System.currentTimeMillis();
                    c12884bq.f36803s = m16005b.m15991i();
                    c12884bq.f36806v = m16005b.m15994g();
                    c12884bq.f36807w = c12884bq.f36800p;
                    c12884bq.f36798n = "com.tencent.bugly";
                    Map<String, String> map = c12884bq.f36795k;
                    map.put("A26", m16005b.m15981s());
                    Map<String, String> map2 = c12884bq.f36795k;
                    StringBuilder sb = new StringBuilder();
                    sb.append(C12786aa.m16016C());
                    map2.put("A62", sb.toString());
                    Map<String, String> map3 = c12884bq.f36795k;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(C12786aa.m16015D());
                    map3.put("A63", sb2.toString());
                    Map<String, String> map4 = c12884bq.f36795k;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(m16005b.f36408J);
                    map4.put("F11", sb3.toString());
                    Map<String, String> map5 = c12884bq.f36795k;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(m16005b.f36407I);
                    map5.put("F12", sb4.toString());
                    Map<String, String> map6 = c12884bq.f36795k;
                    map6.put("D3", m16005b.f36464q);
                    List<AbstractC12903o> list = C12904p.f36891b;
                    if (list != null) {
                        for (AbstractC12903o abstractC12903o : list) {
                            String str2 = abstractC12903o.versionKey;
                            if (str2 != null && (str = abstractC12903o.version) != null) {
                                c12884bq.f36795k.put(str2, str);
                            }
                        }
                    }
                    c12884bq.f36795k.put("G15", C12828ap.m15808d("G15", ""));
                    c12884bq.f36795k.put("G10", C12828ap.m15808d("G10", ""));
                    c12884bq.f36795k.put("D4", C12828ap.m15808d("D4", "0"));
                }
                Map<String, String> m15976x = m16005b.m15976x();
                if (m15976x != null) {
                    for (Map.Entry<String, String> entry : m15976x.entrySet()) {
                        if (!TextUtils.isEmpty(entry.getValue())) {
                            c12884bq.f36795k.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                return c12884bq;
            } catch (Throwable th) {
                if (!C12820al.m15875b(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        C12820al.m15872e("Can not create request pkg for parameters is invalid.", new Object[0]);
        return null;
    }

    /* renamed from: a */
    public static byte[] m15931a(Object obj) {
        try {
            C12892e c12892e = new C12892e();
            c12892e.mo15659b();
            c12892e.mo15665a("utf-8");
            c12892e.m15657c();
            c12892e.m15658b("RqdServer");
            c12892e.m15656c("sync");
            c12892e.mo15661a("detail", (String) obj);
            return c12892e.mo15662a();
        } catch (Throwable th) {
            if (C12820al.m15875b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static C12885br m15930a(byte[] bArr) {
        if (bArr != null) {
            try {
                C12892e c12892e = new C12892e();
                c12892e.mo15659b();
                c12892e.mo15665a("utf-8");
                c12892e.mo15660a(bArr);
                Object m15664b = c12892e.m15664b("detail", new C12885br());
                if (C12885br.class.isInstance(m15664b)) {
                    return (C12885br) C12885br.class.cast(m15664b);
                }
                return null;
            } catch (Throwable th) {
                if (!C12820al.m15875b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static byte[] m15932a(AbstractC12901m abstractC12901m) {
        try {
            C12900l c12900l = new C12900l();
            c12900l.m15594a("utf-8");
            abstractC12901m.mo15578a(c12900l);
            byte[] bArr = new byte[c12900l.f36885a.position()];
            System.arraycopy(c12900l.f36885a.array(), 0, bArr, 0, c12900l.f36885a.position());
            return bArr;
        } catch (Throwable th) {
            if (C12820al.m15875b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
