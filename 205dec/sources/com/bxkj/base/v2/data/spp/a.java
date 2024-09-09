package com.bxkj.base.v2.data.spp;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: PreferencesProviderUtils.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a {
    private static Uri a(Context context, int i4, String str, String str2, Object obj) {
        String j4 = b.j(context, PreferencesProvider.f18699k, PreferencesProvider.f18698j);
        switch (i4) {
            case 100:
                return Uri.parse("content://" + j4 + "/string/" + str + TTPathConst.sSeparator + str2 + TTPathConst.sSeparator + obj);
            case 101:
                return Uri.parse("content://" + j4 + "/integer/" + str + TTPathConst.sSeparator + str2 + TTPathConst.sSeparator + obj);
            case 102:
                return Uri.parse("content://" + j4 + "/long/" + str + TTPathConst.sSeparator + str2 + TTPathConst.sSeparator + obj);
            case 103:
            default:
                return null;
            case 104:
                return Uri.parse("content://" + j4 + "/float/" + str + TTPathConst.sSeparator + str2 + TTPathConst.sSeparator + obj);
            case 105:
                return Uri.parse("content://" + j4 + "/boolean/" + str + TTPathConst.sSeparator + str2 + TTPathConst.sSeparator + obj);
            case 106:
                return Uri.parse("content://" + j4 + "/delete/" + str + TTPathConst.sSeparator + str2);
            case 107:
                return Uri.parse("content://" + j4 + "/puts");
        }
    }

    public static boolean b(Context context, String str, String str2) {
        return c(context, str, str2, false);
    }

    public static boolean c(Context context, String str, String str2, boolean z3) {
        Cursor query = context.getContentResolver().query(a(context, 105, str, str2, Boolean.valueOf(z3)), null, null, null, null);
        return (query != null && query.moveToNext()) ? Boolean.valueOf(query.getString(query.getColumnIndex(PreferencesProvider.f18697i))).booleanValue() : z3;
    }

    public static float d(Context context, String str, String str2) {
        return e(context, str, str2, -1.0f);
    }

    public static float e(Context context, String str, String str2, float f4) {
        Cursor query = context.getContentResolver().query(a(context, 104, str, str2, Float.valueOf(f4)), null, null, null, null);
        return (query != null && query.moveToNext()) ? query.getFloat(query.getColumnIndex(PreferencesProvider.f18697i)) : f4;
    }

    public static int f(Context context, String str, String str2) {
        return g(context, str, str2, -1);
    }

    public static int g(Context context, String str, String str2, int i4) {
        Cursor query = context.getContentResolver().query(a(context, 101, str, str2, Integer.valueOf(i4)), null, null, null, null);
        return (query != null && query.moveToNext()) ? query.getInt(query.getColumnIndex(PreferencesProvider.f18697i)) : i4;
    }

    public static long h(Context context, String str, String str2) {
        return i(context, str, str2, -1L);
    }

    public static long i(Context context, String str, String str2, long j4) {
        Cursor query = context.getContentResolver().query(a(context, 102, str, str2, Long.valueOf(j4)), null, null, null, null);
        return (query != null && query.moveToNext()) ? query.getLong(query.getColumnIndex(PreferencesProvider.f18697i)) : j4;
    }

    public static String j(Context context, String str, String str2) {
        return k(context, str, str2, "");
    }

    public static String k(Context context, String str, String str2, String str3) {
        Cursor query = context.getContentResolver().query(a(context, 100, str, str2, str3), null, null, null, null);
        return (query != null && query.moveToNext()) ? query.getString(query.getColumnIndex(PreferencesProvider.f18697i)) : str3;
    }

    public static boolean l(Context context, String str, ContentValues contentValues) {
        try {
            context.getContentResolver().insert(a(context, 107, str, null, null), contentValues);
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean m(Context context, String str, String str2, boolean z3) {
        Uri a4 = a(context, 105, str, str2, Boolean.valueOf(z3));
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, Boolean.valueOf(z3));
            contentResolver.insert(a4, contentValues);
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean n(Context context, String str, String str2, float f4) {
        Uri a4 = a(context, 104, str, str2, Float.valueOf(f4));
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, Float.valueOf(f4));
            contentResolver.insert(a4, contentValues);
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean o(Context context, String str, String str2, int i4) {
        Uri a4 = a(context, 101, str, str2, Integer.valueOf(i4));
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, Integer.valueOf(i4));
            contentResolver.insert(a4, contentValues);
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean p(Context context, String str, String str2, long j4) {
        Uri a4 = a(context, 102, str, str2, Long.valueOf(j4));
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, Long.valueOf(j4));
            contentResolver.insert(a4, contentValues);
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean q(Context context, String str, String str2, String str3) {
        Uri a4 = a(context, 100, str, str2, str3);
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, str3);
            contentResolver.insert(a4, contentValues);
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean r(Context context, String str, String str2) {
        try {
            context.getContentResolver().delete(a(context, 106, str, str2, null), null, null);
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }
}
