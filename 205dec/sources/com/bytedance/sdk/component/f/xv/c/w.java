package com.bytedance.sdk.component.f.xv.c;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    public static boolean c() {
        return com.bytedance.sdk.component.f.xv.getContext() != null;
    }

    public static Context getContext() {
        return com.bytedance.sdk.component.f.xv.getContext();
    }

    private static ContentResolver w() {
        try {
            if (c()) {
                return com.bytedance.sdk.component.f.xv.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String xv() {
        return ux.f29799w + TTPathConst.sSeparator + "t_sp" + TTPathConst.sSeparator;
    }

    public static synchronized void c(String str, String str2, Boolean bool) {
        synchronized (w.class) {
            if (c()) {
                try {
                    ContentResolver w3 = w();
                    if (w3 != null) {
                        Uri parse = Uri.parse(xv("boolean", str2, str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", bool);
                        w3.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private static String xv(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "?sp_file_name=" + str;
    }

    public static String w(String str, String str2, String str3) {
        String type;
        if (c()) {
            try {
                ContentResolver w3 = w();
                if (w3 != null && (type = w3.getType(Uri.parse(xv("string", str2, str)))) != null && !type.equals("null")) {
                    if (!TextUtils.isEmpty(type)) {
                        return type;
                    }
                }
            } catch (Throwable unused) {
            }
            return str3;
        }
        return str3;
    }

    private static String xv(String str, String str2, String str3) {
        return xv() + str + TTPathConst.sSeparator + str2 + xv(str3);
    }

    @TargetApi(11)
    public static Set<String> w(String str, String str2, Set<String> set) {
        String type;
        if (!c()) {
            return set;
        }
        try {
            ContentResolver w3 = w();
            if (w3 == null || (type = w3.getType(Uri.parse(xv("string_set", str2, str)))) == null || type.equals("null") || TextUtils.isEmpty(type) || !type.matches("\\[.*\\]")) {
                return set;
            }
            String[] split = type.substring(1, type.length() - 1).split(", ");
            HashSet hashSet = new HashSet();
            for (String str3 : split) {
                hashSet.add(str3.replace("__COMMA__", ", "));
            }
            return hashSet;
        } catch (Throwable unused) {
        }
        return set;
    }

    public static synchronized void c(String str, String str2, String str3) {
        synchronized (w.class) {
            if (c()) {
                try {
                    ContentResolver w3 = w();
                    if (w3 != null) {
                        Uri parse = Uri.parse(xv("string", str2, str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", str3);
                        w3.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void c(String str, String str2, Integer num) {
        synchronized (w.class) {
            if (c()) {
                try {
                    ContentResolver w3 = w();
                    if (w3 != null) {
                        Uri parse = Uri.parse(xv("int", str2, str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", num);
                        w3.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r9v17, types: [java.util.HashSet, java.util.Set] */
    public static Map<String, ?> w(String str) {
        Cursor cursor;
        String str2;
        if (c()) {
            try {
                ContentResolver w3 = w();
                if (w3 != null) {
                    cursor = w3.query(Uri.parse(xv() + "get_all" + xv(str)), null, null, null, null);
                    try {
                        HashMap hashMap = new HashMap();
                        if (cursor != null && cursor.moveToFirst()) {
                            int columnIndex = cursor.getColumnIndex("cursor_name");
                            int columnIndex2 = cursor.getColumnIndex("cursor_type");
                            int columnIndex3 = cursor.getColumnIndex("cursor_value");
                            do {
                                String string = cursor.getString(columnIndex);
                                String string2 = cursor.getString(columnIndex2);
                                if (string2.equalsIgnoreCase("string")) {
                                    String string3 = cursor.getString(columnIndex3);
                                    boolean contains = string3.contains("__COMMA__");
                                    str2 = string3;
                                    if (contains) {
                                        boolean matches = string3.matches("\\[.*\\]");
                                        str2 = string3;
                                        if (matches) {
                                            String[] split = string3.substring(1, string3.length() - 1).split(", ");
                                            ?? hashSet = new HashSet();
                                            for (String str3 : split) {
                                                hashSet.add(str3.replace("__COMMA__", ", "));
                                            }
                                            str2 = hashSet;
                                        }
                                    }
                                } else if (string2.equalsIgnoreCase("boolean")) {
                                    str2 = cursor.getString(columnIndex3);
                                } else if (string2.equalsIgnoreCase("int")) {
                                    str2 = Integer.valueOf(cursor.getInt(columnIndex3));
                                } else if (string2.equalsIgnoreCase("long")) {
                                    str2 = Long.valueOf(cursor.getLong(columnIndex3));
                                } else if (string2.equalsIgnoreCase("float")) {
                                    str2 = Float.valueOf(cursor.getFloat(columnIndex3));
                                } else {
                                    str2 = string2.equalsIgnoreCase("string_set") ? cursor.getString(columnIndex3) : null;
                                }
                                hashMap.put(string, str2);
                            } while (cursor.moveToNext());
                            if (cursor != null) {
                                cursor.close();
                            }
                            return hashMap;
                        }
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        return hashMap;
                    } catch (Throwable unused) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        return null;
                    }
                }
            } catch (Throwable unused2) {
                cursor = null;
            }
            return null;
        }
        return null;
    }

    public static synchronized void c(String str, String str2, Long l4) {
        synchronized (w.class) {
            if (c()) {
                try {
                    ContentResolver w3 = w();
                    if (w3 != null) {
                        Uri parse = Uri.parse(xv("long", str2, str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", l4);
                        w3.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void c(String str, String str2, Float f4) {
        synchronized (w.class) {
            if (c()) {
                try {
                    ContentResolver w3 = w();
                    if (w3 != null) {
                        Uri parse = Uri.parse(xv("float", str2, str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", f4);
                        w3.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void c(String str, String str2, Set<String> set) {
        synchronized (w.class) {
            if (c()) {
                try {
                    ContentResolver w3 = w();
                    if (w3 != null) {
                        Uri parse = Uri.parse(xv("string_set", str2, str));
                        ContentValues contentValues = new ContentValues();
                        HashSet hashSet = new HashSet();
                        for (String str3 : set) {
                            hashSet.add(str3.replace(",", "__COMMA__"));
                        }
                        contentValues.put("value", hashSet.toString());
                        w3.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static int c(String str, String str2, int i4) {
        String type;
        if (c()) {
            try {
                ContentResolver w3 = w();
                if (w3 != null && (type = w3.getType(Uri.parse(xv("int", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                    return Integer.parseInt(type);
                }
            } catch (Throwable unused) {
            }
            return i4;
        }
        return i4;
    }

    public static float c(String str, String str2, float f4) {
        String type;
        if (c()) {
            try {
                ContentResolver w3 = w();
                if (w3 != null && (type = w3.getType(Uri.parse(xv("float", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                    return Float.parseFloat(type);
                }
            } catch (Throwable unused) {
            }
            return f4;
        }
        return f4;
    }

    public static boolean c(String str, String str2, boolean z3) {
        String type;
        if (c()) {
            try {
                ContentResolver w3 = w();
                if (w3 != null && (type = w3.getType(Uri.parse(xv("boolean", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                    return Boolean.parseBoolean(type);
                }
            } catch (Throwable unused) {
            }
            return z3;
        }
        return z3;
    }

    public static long c(String str, String str2, long j4) {
        String type;
        if (c()) {
            try {
                ContentResolver w3 = w();
                if (w3 != null && (type = w3.getType(Uri.parse(xv("long", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                    return Long.parseLong(type);
                }
            } catch (Throwable unused) {
            }
            return j4;
        }
        return j4;
    }

    public static void c(String str, String str2) {
        if (c()) {
            try {
                ContentResolver w3 = w();
                if (w3 != null) {
                    w3.delete(Uri.parse(xv("long", str2, str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void c(String str) {
        if (c()) {
            try {
                ContentResolver w3 = w();
                if (w3 != null) {
                    w3.delete(Uri.parse(xv() + "clean" + xv(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
