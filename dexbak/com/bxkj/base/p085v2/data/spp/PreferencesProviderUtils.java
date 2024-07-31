package com.bxkj.base.p085v2.data.spp;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* renamed from: com.bxkj.base.v2.data.spp.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PreferencesProviderUtils {
    /* renamed from: a */
    private static Uri m43583a(Context context, int i, String str, String str2, Object obj) {
        String m43556j = PreferencesUtils.m43556j(context, PreferencesProvider.f15202k, PreferencesProvider.f15201j);
        switch (i) {
            case 100:
                return Uri.parse("content://" + m43556j + "/string/" + str + "/" + str2 + "/" + obj);
            case 101:
                return Uri.parse("content://" + m43556j + "/integer/" + str + "/" + str2 + "/" + obj);
            case 102:
                return Uri.parse("content://" + m43556j + "/long/" + str + "/" + str2 + "/" + obj);
            case 103:
            default:
                return null;
            case 104:
                return Uri.parse("content://" + m43556j + "/float/" + str + "/" + str2 + "/" + obj);
            case 105:
                return Uri.parse("content://" + m43556j + "/boolean/" + str + "/" + str2 + "/" + obj);
            case 106:
                return Uri.parse("content://" + m43556j + "/delete/" + str + "/" + str2);
            case 107:
                return Uri.parse("content://" + m43556j + "/puts");
        }
    }

    /* renamed from: b */
    public static boolean m43582b(Context context, String str, String str2) {
        return m43581c(context, str, str2, false);
    }

    /* renamed from: c */
    public static boolean m43581c(Context context, String str, String str2, boolean z) {
        Cursor query = context.getContentResolver().query(m43583a(context, 105, str, str2, Boolean.valueOf(z)), null, null, null, null);
        return (query != null && query.moveToNext()) ? Boolean.valueOf(query.getString(query.getColumnIndex(PreferencesProvider.f15200i))).booleanValue() : z;
    }

    /* renamed from: d */
    public static float m43580d(Context context, String str, String str2) {
        return m43579e(context, str, str2, -1.0f);
    }

    /* renamed from: e */
    public static float m43579e(Context context, String str, String str2, float f) {
        Cursor query = context.getContentResolver().query(m43583a(context, 104, str, str2, Float.valueOf(f)), null, null, null, null);
        return (query != null && query.moveToNext()) ? query.getFloat(query.getColumnIndex(PreferencesProvider.f15200i)) : f;
    }

    /* renamed from: f */
    public static int m43578f(Context context, String str, String str2) {
        return m43577g(context, str, str2, -1);
    }

    /* renamed from: g */
    public static int m43577g(Context context, String str, String str2, int i) {
        Cursor query = context.getContentResolver().query(m43583a(context, 101, str, str2, Integer.valueOf(i)), null, null, null, null);
        return (query != null && query.moveToNext()) ? query.getInt(query.getColumnIndex(PreferencesProvider.f15200i)) : i;
    }

    /* renamed from: h */
    public static long m43576h(Context context, String str, String str2) {
        return m43575i(context, str, str2, -1L);
    }

    /* renamed from: i */
    public static long m43575i(Context context, String str, String str2, long j) {
        Cursor query = context.getContentResolver().query(m43583a(context, 102, str, str2, Long.valueOf(j)), null, null, null, null);
        return (query != null && query.moveToNext()) ? query.getLong(query.getColumnIndex(PreferencesProvider.f15200i)) : j;
    }

    /* renamed from: j */
    public static String m43574j(Context context, String str, String str2) {
        return m43573k(context, str, str2, "");
    }

    /* renamed from: k */
    public static String m43573k(Context context, String str, String str2, String str3) {
        Cursor query = context.getContentResolver().query(m43583a(context, 100, str, str2, str3), null, null, null, null);
        return (query != null && query.moveToNext()) ? query.getString(query.getColumnIndex(PreferencesProvider.f15200i)) : str3;
    }

    /* renamed from: l */
    public static boolean m43572l(Context context, String str, ContentValues contentValues) {
        try {
            context.getContentResolver().insert(m43583a(context, 107, str, null, null), contentValues);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: m */
    public static boolean m43571m(Context context, String str, String str2, boolean z) {
        Uri m43583a = m43583a(context, 105, str, str2, Boolean.valueOf(z));
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, Boolean.valueOf(z));
            contentResolver.insert(m43583a, contentValues);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: n */
    public static boolean m43570n(Context context, String str, String str2, float f) {
        Uri m43583a = m43583a(context, 104, str, str2, Float.valueOf(f));
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, Float.valueOf(f));
            contentResolver.insert(m43583a, contentValues);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: o */
    public static boolean m43569o(Context context, String str, String str2, int i) {
        Uri m43583a = m43583a(context, 101, str, str2, Integer.valueOf(i));
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, Integer.valueOf(i));
            contentResolver.insert(m43583a, contentValues);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: p */
    public static boolean m43568p(Context context, String str, String str2, long j) {
        Uri m43583a = m43583a(context, 102, str, str2, Long.valueOf(j));
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, Long.valueOf(j));
            contentResolver.insert(m43583a, contentValues);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: q */
    public static boolean m43567q(Context context, String str, String str2, String str3) {
        Uri m43583a = m43583a(context, 100, str, str2, str3);
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, str3);
            contentResolver.insert(m43583a, contentValues);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: r */
    public static boolean m43566r(Context context, String str, String str2) {
        try {
            context.getContentResolver().delete(m43583a(context, 106, str, str2, null), null, null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
