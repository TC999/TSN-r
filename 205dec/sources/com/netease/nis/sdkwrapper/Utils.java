package com.netease.nis.sdkwrapper;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class Utils {
    static {
        System.loadLibrary("secsdk");
    }

    private static String a(String str) {
        if (str.startsWith("[")) {
            return str.replace(".", TTPathConst.sSeparator);
        }
        if (str.equals("int")) {
            return "I";
        }
        if (str.equals("float")) {
            return "F";
        }
        if (str.equals("long")) {
            return "J";
        }
        if (str.equals("double")) {
            return "D";
        }
        if (str.equals("short")) {
            return "S";
        }
        if (str.equals("char")) {
            return "C";
        }
        if (str.equals("boolean")) {
            return "Z";
        }
        if (str.equals("byte")) {
            return "B";
        }
        return ("L" + str + ";").replace(".", TTPathConst.sSeparator);
    }

    private static String b(Class cls, String str, String str2) {
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            Field.setAccessible(declaredFields, true);
            for (Field field : declaredFields) {
                String replace = field.getType().toString().replace("class ", "").replace("interface ", "");
                if (Modifier.isStatic(field.getModifiers()) && field.getName().equals(str) && str2.equals(a(replace))) {
                    return field.getDeclaringClass().getName().replace(".", TTPathConst.sSeparator);
                }
            }
            return "";
        } catch (NoClassDefFoundError unused) {
            return "NoClassDefFoundError";
        }
    }

    public static String getFieldSCDesc(Class cls, String str, String str2) {
        while (cls != null) {
            String b4 = b(cls, str, str2);
            if (b4 != "") {
                return b4;
            }
            cls = cls.getSuperclass();
        }
        return "";
    }

    public static Object getStaticFO(String str, String str2) {
        try {
            Field field = Class.forName(str.replace('/', '.')).getField(str2);
            Class<?> type = field.getType();
            if (type == Integer.TYPE) {
                return Integer.valueOf(field.getInt(null));
            }
            if (type == Float.TYPE) {
                return Float.valueOf(field.getFloat(null));
            }
            if (type == Long.TYPE) {
                return Long.valueOf(field.getLong(null));
            }
            if (type == Double.TYPE) {
                return Double.valueOf(field.getDouble(null));
            }
            if (type == Short.TYPE) {
                return Short.valueOf(field.getShort(null));
            }
            if (type == Character.TYPE) {
                return Character.valueOf(field.getChar(null));
            }
            if (type == Boolean.TYPE) {
                return Boolean.valueOf(field.getBoolean(null));
            }
            if (type == Byte.TYPE) {
                return Byte.valueOf(field.getByte(null));
            }
            return field.get(null);
        } catch (Exception e4) {
            Log.e("Utils", e4.toString());
            return null;
        }
    }

    public static native Object rL(Object[] objArr);

    public static void showRiskMessage(Context context, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Toast.makeText(context, str, 0).show();
            return;
        }
        Looper.prepare();
        Toast.makeText(context, str, 0).show();
        Looper.loop();
    }
}
