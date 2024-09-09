package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class ae {
    public static bu a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        bu buVar = new bu();
        buVar.f51204a = userInfoBean.f50723e;
        buVar.f51208e = userInfoBean.f50728j;
        buVar.f51207d = userInfoBean.f50721c;
        buVar.f51206c = userInfoBean.f50722d;
        buVar.f51211h = userInfoBean.f50733o == 1;
        int i4 = userInfoBean.f50720b;
        if (i4 == 1) {
            buVar.f51205b = (byte) 1;
        } else if (i4 == 2) {
            buVar.f51205b = (byte) 4;
        } else if (i4 == 3) {
            buVar.f51205b = (byte) 2;
        } else if (i4 == 4) {
            buVar.f51205b = (byte) 3;
        } else if (i4 == 8) {
            buVar.f51205b = (byte) 8;
        } else if (i4 < 10 || i4 >= 20) {
            al.e("unknown uinfo type %d ", Integer.valueOf(i4));
            return null;
        } else {
            buVar.f51205b = (byte) i4;
        }
        HashMap hashMap = new HashMap();
        buVar.f51209f = hashMap;
        if (userInfoBean.f50734p >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(userInfoBean.f50734p);
            hashMap.put("C01", sb.toString());
        }
        if (userInfoBean.f50735q >= 0) {
            Map<String, String> map = buVar.f51209f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(userInfoBean.f50735q);
            map.put("C02", sb2.toString());
        }
        Map<String, String> map2 = userInfoBean.f50736r;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.f50736r.entrySet()) {
                Map<String, String> map3 = buVar.f51209f;
                map3.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map4 = userInfoBean.f50737s;
        if (map4 != null && map4.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.f50737s.entrySet()) {
                Map<String, String> map5 = buVar.f51209f;
                map5.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map6 = buVar.f51209f;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(!userInfoBean.f50730l);
        map6.put("A36", sb3.toString());
        Map<String, String> map7 = buVar.f51209f;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(userInfoBean.f50725g);
        map7.put("F02", sb4.toString());
        Map<String, String> map8 = buVar.f51209f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(userInfoBean.f50726h);
        map8.put("F03", sb5.toString());
        Map<String, String> map9 = buVar.f51209f;
        map9.put("F04", userInfoBean.f50728j);
        Map<String, String> map10 = buVar.f51209f;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(userInfoBean.f50727i);
        map10.put("F05", sb6.toString());
        Map<String, String> map11 = buVar.f51209f;
        map11.put("F06", userInfoBean.f50731m);
        Map<String, String> map12 = buVar.f51209f;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(userInfoBean.f50729k);
        map12.put("F10", sb7.toString());
        al.c("summary type %d vm:%d", Byte.valueOf(buVar.f51205b), Integer.valueOf(buVar.f51209f.size()));
        return buVar;
    }

    public static <T extends m> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                k kVar = new k(bArr);
                kVar.a("utf-8");
                newInstance.a(kVar);
                return newInstance;
            } catch (Throwable th) {
                if (!al.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static bq a(Context context, int i4, byte[] bArr) {
        String str;
        aa b4 = aa.b();
        StrategyBean c4 = ac.a().c();
        if (b4 != null && c4 != null) {
            try {
                bq bqVar = new bq();
                synchronized (b4) {
                    bqVar.f51152a = b4.f50823b;
                    bqVar.f51153b = b4.e();
                    bqVar.f51154c = b4.f50824c;
                    bqVar.f51155d = b4.f50836o;
                    bqVar.f51156e = b4.f50840s;
                    bqVar.f51157f = b4.f50829h;
                    bqVar.f51158g = i4;
                    if (bArr == null) {
                        bArr = "".getBytes();
                    }
                    bqVar.f51159h = bArr;
                    bqVar.f51160i = b4.h();
                    bqVar.f51161j = b4.f50832k;
                    bqVar.f51162k = new HashMap();
                    bqVar.f51163l = b4.d();
                    bqVar.f51164m = c4.f50755o;
                    bqVar.f51166o = b4.g();
                    bqVar.f51167p = ab.c(context);
                    bqVar.f51168q = System.currentTimeMillis();
                    bqVar.f51170s = b4.i();
                    bqVar.f51173v = b4.g();
                    bqVar.f51174w = bqVar.f51167p;
                    bqVar.f51165n = "com.tencent.bugly";
                    Map<String, String> map = bqVar.f51162k;
                    map.put("A26", b4.s());
                    Map<String, String> map2 = bqVar.f51162k;
                    StringBuilder sb = new StringBuilder();
                    sb.append(aa.C());
                    map2.put("A62", sb.toString());
                    Map<String, String> map3 = bqVar.f51162k;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(aa.D());
                    map3.put("A63", sb2.toString());
                    Map<String, String> map4 = bqVar.f51162k;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(b4.J);
                    map4.put("F11", sb3.toString());
                    Map<String, String> map5 = bqVar.f51162k;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(b4.I);
                    map5.put("F12", sb4.toString());
                    Map<String, String> map6 = bqVar.f51162k;
                    map6.put("D3", b4.f50838q);
                    List<o> list = p.f51257b;
                    if (list != null) {
                        for (o oVar : list) {
                            String str2 = oVar.versionKey;
                            if (str2 != null && (str = oVar.version) != null) {
                                bqVar.f51162k.put(str2, str);
                            }
                        }
                    }
                    bqVar.f51162k.put("G15", ap.d("G15", ""));
                    bqVar.f51162k.put("G10", ap.d("G10", ""));
                    bqVar.f51162k.put("D4", ap.d("D4", "0"));
                }
                Map<String, String> x3 = b4.x();
                if (x3 != null) {
                    for (Map.Entry<String, String> entry : x3.entrySet()) {
                        if (!TextUtils.isEmpty(entry.getValue())) {
                            bqVar.f51162k.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                return bqVar;
            } catch (Throwable th) {
                if (!al.b(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        al.e("Can not create request pkg for parameters is invalid.", new Object[0]);
        return null;
    }

    public static byte[] a(Object obj) {
        try {
            e eVar = new e();
            eVar.b();
            eVar.a("utf-8");
            eVar.c();
            eVar.b("RqdServer");
            eVar.c("sync");
            eVar.a("detail", (String) obj);
            return eVar.a();
        } catch (Throwable th) {
            if (al.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static br a(byte[] bArr) {
        if (bArr != null) {
            try {
                e eVar = new e();
                eVar.b();
                eVar.a("utf-8");
                eVar.a(bArr);
                Object b4 = eVar.b("detail", new br());
                if (br.class.isInstance(b4)) {
                    return (br) br.class.cast(b4);
                }
                return null;
            } catch (Throwable th) {
                if (!al.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static byte[] a(m mVar) {
        try {
            l lVar = new l();
            lVar.a("utf-8");
            mVar.a(lVar);
            byte[] bArr = new byte[lVar.f51252a.position()];
            System.arraycopy(lVar.f51252a.array(), 0, bArr, 0, lVar.f51252a.position());
            return bArr;
        } catch (Throwable th) {
            if (al.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
