package com.bytedance.sdk.openadsdk.core.multipro.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.multipro.ux;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    private static ContentResolver c(Context context) {
        if (context == null) {
            try {
                context = ls.getContext();
            } catch (Throwable unused) {
                return null;
            }
        }
        return context.getContentResolver();
    }

    public static int delete(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            ContentResolver c4 = c(context);
            if (c4 != null) {
                return c4.delete(Uri.parse(c() + str), str2, strArr);
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static void insert(Context context, String str, ContentValues contentValues) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                ContentResolver c4 = c(context);
                if (c4 == null) {
                    return;
                }
                c4.insert(Uri.parse(c() + str), contentValues);
            } catch (Throwable unused) {
            }
        }
    }

    public static Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ContentResolver c4 = c(context);
            if (c4 != null) {
                return c4.query(Uri.parse(c() + str), strArr, str2, strArr2, str5);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                ContentResolver c4 = c(context);
                if (c4 != null) {
                    return c4.update(Uri.parse(c() + str), contentValues, str2, strArr);
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    private static String c() {
        return ux.f33973w + TTPathConst.sSeparator + "t_db" + TTPathConst.sSeparator + "ttopensdk.db" + TTPathConst.sSeparator;
    }

    public static void c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver c4 = c(context);
            if (c4 != null) {
                c4.getType(Uri.parse(c() + "unknown" + TTPathConst.sSeparator + "execSQL?sql=" + Uri.encode(str)));
            }
        } catch (Throwable unused) {
        }
    }
}
