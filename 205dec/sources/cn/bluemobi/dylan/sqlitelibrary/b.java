package cn.bluemobi.dylan.sqlitelibrary;

import android.os.Parcelable;
import com.acse.ottn.f3;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: JavaReflectUtil.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {
    public static List<Map<String, Object>> a(Object obj) {
        if (obj == null) {
            return null;
        }
        String[] b4 = b(obj.getClass());
        Class[] c4 = c(obj.getClass());
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < b4.length; i4++) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", b4[i4]);
            hashMap.put("type", c4[i4]);
            hashMap.put("value", e(obj, b4[i4]));
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    public static String[] b(Class cls) {
        if (cls == null) {
            return null;
        }
        Field[] fieldArr = new Field[0];
        try {
            fieldArr = cls.getDeclaredFields();
        } catch (SecurityException e4) {
            e4.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < fieldArr.length; i4++) {
            if (!fieldArr[i4].isSynthetic() && !fieldArr[i4].getName().equals("serialVersionUID")) {
                try {
                    if (fieldArr[i4].getType().equals(Class.forName(Parcelable.Creator.class.getName()))) {
                    }
                } catch (ClassNotFoundException unused) {
                }
                arrayList.add(fieldArr[i4].getName());
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static Class[] c(Class cls) {
        if (cls == null) {
            return null;
        }
        Field[] fieldArr = new Field[0];
        try {
            fieldArr = cls.getDeclaredFields();
        } catch (SecurityException e4) {
            e4.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < fieldArr.length; i4++) {
            if (!fieldArr[i4].isSynthetic() && !fieldArr[i4].getName().equals("serialVersionUID")) {
                try {
                    if (fieldArr[i4].getType().equals(Class.forName(Parcelable.Creator.class.getName()))) {
                    }
                } catch (ClassNotFoundException unused) {
                }
                arrayList.add(fieldArr[i4].getType());
            }
        }
        return (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }

    public static String d(Class cls) {
        if (cls == null) {
            return null;
        }
        return cls.getSimpleName();
    }

    public static Object e(Object obj, String str) {
        if (obj != null && str != null && !str.isEmpty()) {
            try {
                return obj.getClass().getMethod(f3.f5657f + str.substring(0, 1).toUpperCase() + str.substring(1), new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
            } catch (NoSuchMethodException unused) {
                try {
                    return obj.getClass().getMethod("is" + str.substring(0, 1).toUpperCase() + str.substring(1), new Class[0]).invoke(obj, new Object[0]);
                } catch (IllegalAccessException e5) {
                    e5.printStackTrace();
                } catch (NoSuchMethodException e6) {
                    e6.printStackTrace();
                } catch (InvocationTargetException e7) {
                    e7.printStackTrace();
                }
            } catch (InvocationTargetException e8) {
                e8.printStackTrace();
            } catch (Exception e9) {
                e9.printStackTrace();
            }
        }
        return null;
    }
}
