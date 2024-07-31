package com.p518qq.p519e.comm.util;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.qq.e.comm.util.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C11832a {

    /* renamed from: a */
    private static final Map<String, Boolean> f32961a = new HashMap();

    /* renamed from: a */
    private static boolean m20302a(Class cls, String str, Class... clsArr) {
        String sb;
        if (cls == null) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append("#");
            sb2.append(str);
            for (Class cls2 : clsArr) {
                sb2.append("_");
                sb2.append(cls2.getName());
            }
            sb = sb2.toString();
        }
        Map<String, Boolean> map = f32961a;
        Boolean bool = map.get(sb);
        if (bool == null) {
            try {
                cls.getDeclaredMethod(str, clsArr);
                map.put(sb, Boolean.TRUE);
                return true;
            } catch (NoSuchMethodException unused) {
                f32961a.put(sb, Boolean.FALSE);
                return false;
            }
        }
        return Boolean.TRUE.equals(bool);
    }

    /* renamed from: a */
    public static boolean m20301a(Object obj) {
        if (obj == null) {
            return false;
        }
        return m20302a(obj.getClass(), "onRenderFail", new Class[0]);
    }

    /* renamed from: b */
    public static boolean m20300b(Object obj) {
        if (obj == null) {
            return false;
        }
        return m20302a(obj.getClass(), "onRenderSuccess", new Class[0]);
    }
}
