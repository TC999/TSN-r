package com.qq.e.comm.util;

import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Boolean> f46818a = new HashMap();

    private static boolean a(Class cls, String str, Class... clsArr) {
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
        Map<String, Boolean> map = f46818a;
        Boolean bool = map.get(sb);
        if (bool == null) {
            try {
                cls.getDeclaredMethod(str, clsArr);
                map.put(sb, Boolean.TRUE);
                return true;
            } catch (NoSuchMethodException unused) {
                f46818a.put(sb, Boolean.FALSE);
                return false;
            }
        }
        return Boolean.TRUE.equals(bool);
    }

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        return a(obj.getClass(), "onRenderFail", new Class[0]);
    }

    public static boolean b(Object obj) {
        if (obj == null) {
            return false;
        }
        return a(obj.getClass(), "onRenderSuccess", new Class[0]);
    }
}
