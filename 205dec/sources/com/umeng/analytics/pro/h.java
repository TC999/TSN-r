package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UMDBUtils.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class h {
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r1 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String r12, android.database.sqlite.SQLiteDatabase r13) {
        /*
            r0 = 0
            if (r12 != 0) goto L4
            return r0
        L4:
            r1 = 0
            r2 = 1
            java.lang.String[] r5 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3e
            java.lang.String r3 = "count(*)"
            r5[r0] = r3     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3e
            r3 = 2
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3e
            java.lang.String r3 = "table"
            r7[r0] = r3     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3e
            java.lang.String r12 = r12.trim()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3e
            r7[r2] = r12     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3e
            java.lang.String r4 = "sqlite_master"
            java.lang.String r6 = "type=? and name=?"
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r3 = r13
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3e
            boolean r12 = r1.moveToNext()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3e
            if (r12 == 0) goto L33
            int r12 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3e
            if (r12 <= 0) goto L33
            r0 = 1
        L33:
            r1.close()
            goto L42
        L37:
            r12 = move-exception
            if (r1 == 0) goto L3d
            r1.close()
        L3d:
            throw r12
        L3e:
            if (r1 == 0) goto L42
            goto L33
        L42:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
    }

    public static String b(Context context) {
        File databasePath = context.getDatabasePath(e.f52896b);
        return databasePath.getParent() + File.separator;
    }

    public static String c(Context context) {
        return b(context) + "subprocess/";
    }

    public static List<String> b(List<String> list) {
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : list) {
                if (Collections.frequency(arrayList, str) < 1) {
                    arrayList.add(str);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return arrayList;
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            File databasePath = context.getDatabasePath(e.f52896b);
            if (databasePath != null && databasePath.exists()) {
                databasePath.delete();
            }
            f.a(context).a();
        } catch (Throwable unused) {
        }
    }

    public static String a(List<String> list) {
        return TextUtils.join("!", list);
    }

    public static List<String> a(String str) {
        return new ArrayList(Arrays.asList(str.split("!")));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
        if (r9.isClosed() == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
        if (r9.isClosed() == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.database.sqlite.SQLiteDatabase r10, java.lang.String r11, java.lang.String r12) {
        /*
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            java.lang.String r7 = "LIMIT 0"
            r0 = r10
            r1 = r11
            android.database.Cursor r9 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L33
            if (r9 == 0) goto L1a
            int r10 = r9.getColumnIndex(r12)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L33
            r11 = -1
            if (r10 == r11) goto L1a
            r10 = 1
            r8 = 1
        L1a:
            if (r9 == 0) goto L3d
            boolean r10 = r9.isClosed()
            if (r10 != 0) goto L3d
        L22:
            r9.close()
            goto L3d
        L26:
            r10 = move-exception
            if (r9 == 0) goto L32
            boolean r11 = r9.isClosed()
            if (r11 != 0) goto L32
            r9.close()
        L32:
            throw r10
        L33:
            if (r9 == 0) goto L3d
            boolean r10 = r9.isClosed()
            if (r10 != 0) goto L3d
            goto L22
        L3d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.a(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String):boolean");
    }

    public static void a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        sQLiteDatabase.execSQL("alter table " + str + " add " + str2 + " " + str3);
    }
}
