package com.bytedance.sdk.component.r.w.c.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.r.c.ux;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    public static String c(Context context, String str, ux uxVar) {
        if (TextUtils.isEmpty(str)) {
            return "sql is null";
        }
        try {
            c.c(context).c().c(uxVar, Uri.decode(str));
            return "execSql ok";
        } catch (Throwable th) {
            com.bytedance.sdk.component.r.w.xv.xv.c("execSQL ignore", uxVar);
            return "exec sql exception:" + th.getMessage();
        }
    }

    public static int delete(Context context, String str, String str2, String[] strArr, ux uxVar) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            com.bytedance.sdk.component.r.w.xv.xv.c("DBMultiUtils  delete start", uxVar);
            return c.c(context).c().delete(uxVar, str, str2, strArr);
        } catch (Throwable unused) {
            com.bytedance.sdk.component.r.w.xv.xv.c("delete ignore", uxVar);
            return 0;
        }
    }

    public static void insert(Context context, String str, ContentValues contentValues, ux uxVar) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            c.c(context).c().insert(uxVar, str, (String) null, contentValues);
        } catch (Throwable unused) {
            com.bytedance.sdk.component.r.w.xv.xv.c("insert ignore", uxVar);
        }
    }

    public static Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, ux uxVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return c.c(context).c().query(uxVar, str, strArr, str2, strArr2, null, null, str5);
        } catch (Throwable unused) {
            com.bytedance.sdk.component.r.w.xv.xv.c("query ignore", uxVar);
            return null;
        }
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr, ux uxVar) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                return c.c(context).c().update(uxVar, str, contentValues, str2, strArr);
            } catch (Throwable unused) {
                com.bytedance.sdk.component.r.w.xv.xv.c("update ignore", uxVar);
            }
        }
        return 0;
    }

    public static void insert(Context context, String str, List<com.bytedance.sdk.component.r.c.w> list, ux uxVar) {
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            c.c(context).c().insert(uxVar, str, (String) null, list);
        } catch (Throwable unused) {
            com.bytedance.sdk.component.r.w.xv.xv.c("insert ignore", uxVar);
        }
    }
}
