package cn.bluemobi.dylan.sqlitelibrary;

import android.os.Parcelable;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: cn.bluemobi.dylan.sqlitelibrary.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class JavaReflectUtil {
    /* renamed from: a */
    public static List<Map<String, Object>> m57486a(Object obj) {
        if (obj == null) {
            return null;
        }
        String[] m57485b = m57485b(obj.getClass());
        Class[] m57484c = m57484c(obj.getClass());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < m57485b.length; i++) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", m57485b[i]);
            hashMap.put("type", m57484c[i]);
            hashMap.put(DomainCampaignEx.LOOPBACK_VALUE, m57482e(obj, m57485b[i]));
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    /* renamed from: b */
    public static String[] m57485b(Class cls) {
        if (cls == null) {
            return null;
        }
        Field[] fieldArr = new Field[0];
        try {
            fieldArr = cls.getDeclaredFields();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < fieldArr.length; i++) {
            if (!fieldArr[i].isSynthetic() && !fieldArr[i].getName().equals("serialVersionUID")) {
                try {
                    if (fieldArr[i].getType().equals(Class.forName(Parcelable.Creator.class.getName()))) {
                    }
                } catch (ClassNotFoundException unused) {
                }
                arrayList.add(fieldArr[i].getName());
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: c */
    public static Class[] m57484c(Class cls) {
        if (cls == null) {
            return null;
        }
        Field[] fieldArr = new Field[0];
        try {
            fieldArr = cls.getDeclaredFields();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < fieldArr.length; i++) {
            if (!fieldArr[i].isSynthetic() && !fieldArr[i].getName().equals("serialVersionUID")) {
                try {
                    if (fieldArr[i].getType().equals(Class.forName(Parcelable.Creator.class.getName()))) {
                    }
                } catch (ClassNotFoundException unused) {
                }
                arrayList.add(fieldArr[i].getType());
            }
        }
        return (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }

    /* renamed from: d */
    public static String m57483d(Class cls) {
        if (cls == null) {
            return null;
        }
        return cls.getSimpleName();
    }

    /* renamed from: e */
    public static Object m57482e(Object obj, String str) {
        if (obj != null && str != null && !str.isEmpty()) {
            try {
                return obj.getClass().getMethod("get" + str.substring(0, 1).toUpperCase() + str.substring(1), new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException unused) {
                try {
                    return obj.getClass().getMethod(UMCommonContent.f37801ae + str.substring(0, 1).toUpperCase() + str.substring(1), new Class[0]).invoke(obj, new Object[0]);
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (NoSuchMethodException e3) {
                    e3.printStackTrace();
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                }
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }
}
