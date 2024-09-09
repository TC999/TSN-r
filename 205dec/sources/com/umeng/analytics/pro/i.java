package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.stub.StubApp;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UMStoreManager.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final int f52970a = 2049;

    /* renamed from: b  reason: collision with root package name */
    public static final int f52971b = 2050;

    /* renamed from: c  reason: collision with root package name */
    private static final int f52972c = 1000;

    /* renamed from: d  reason: collision with root package name */
    private static Context f52973d = null;

    /* renamed from: e  reason: collision with root package name */
    private static String f52974e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final String f52975f = "umeng+";

    /* renamed from: g  reason: collision with root package name */
    private static final String f52976g = "ek__id";

    /* renamed from: h  reason: collision with root package name */
    private static final String f52977h = "ek_key";

    /* renamed from: i  reason: collision with root package name */
    private List<String> f52978i;

    /* renamed from: j  reason: collision with root package name */
    private List<Integer> f52979j;

    /* renamed from: k  reason: collision with root package name */
    private String f52980k;

    /* renamed from: l  reason: collision with root package name */
    private List<String> f52981l;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: UMStoreManager.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: UMStoreManager.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final i f52989a = new i();

        private b() {
        }
    }

    public static i a(Context context) {
        i iVar = b.f52989a;
        if (f52973d == null && context != null) {
            f52973d = StubApp.getOrigApplicationContext(context.getApplicationContext());
            iVar.k();
        }
        return iVar;
    }

    private void k() {
        synchronized (this) {
            l();
            this.f52978i.clear();
            this.f52981l.clear();
            this.f52979j.clear();
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(f52974e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(f52973d, "ek__id");
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = PreferenceWrapper.getDefault(f52973d).getString("ek__id", null);
                    if (TextUtils.isEmpty(multiProcessSP)) {
                        multiProcessSP = UMUtils.genId();
                    }
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(f52973d, "ek__id", multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String substring = multiProcessSP.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i4 = 0; i4 < substring.length(); i4++) {
                        char charAt = substring.charAt(i4);
                        if (Character.isDigit(charAt)) {
                            if (Integer.parseInt(Character.toString(charAt)) == 0) {
                                sb.append(0);
                            } else {
                                sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                            }
                        } else {
                            sb.append(charAt);
                        }
                    }
                    f52974e = sb.toString();
                }
                if (TextUtils.isEmpty(f52974e)) {
                    return;
                }
                f52974e += new StringBuilder(f52974e).reverse().toString();
                String multiProcessSP2 = UMUtils.getMultiProcessSP(f52973d, "ek_key");
                if (TextUtils.isEmpty(multiProcessSP2)) {
                    UMUtils.setMultiProcessSP(f52973d, "ek_key", c("umeng+"));
                } else if (!"umeng+".equals(d(multiProcessSP2))) {
                    b(true, false);
                    a(true, false);
                    h();
                    i();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        this.f52981l.clear();
    }

    public boolean c() {
        return this.f52981l.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0080, code lost:
        if (r0 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            r7 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            com.umeng.analytics.pro.u r1 = com.umeng.analytics.pro.u.a()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            java.lang.String r1 = r1.c()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            if (r2 == 0) goto L29
            r0.endTransaction()     // Catch: java.lang.Throwable -> L1f
        L1f:
            android.content.Context r0 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            return
        L29:
            r2 = 2
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            java.lang.String r4 = ""
            r5 = 0
            r3[r5] = r4     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            java.lang.String r4 = "-1"
            r6 = 1
            r3[r6] = r4     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
        L36:
            if (r5 >= r2) goto L68
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            r4.<init>()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            java.lang.String r6 = "update __et set __i=\""
            r4.append(r6)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            r4.append(r1)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            java.lang.String r6 = "\" where "
            r4.append(r6)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            java.lang.String r6 = "__i"
            r4.append(r6)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            java.lang.String r6 = "=\""
            r4.append(r6)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            r6 = r3[r5]     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            r4.append(r6)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            java.lang.String r6 = "\""
            r4.append(r6)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            int r5 = r5 + 1
            goto L36
        L68:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            goto L6e
        L6c:
            if (r0 == 0) goto L71
        L6e:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L71
        L71:
            android.content.Context r0 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L83
        L7b:
            android.content.Context r1 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L84
            com.umeng.analytics.pro.h.a(r1)     // Catch: java.lang.Throwable -> L84
            if (r0 == 0) goto L71
            goto L6e
        L83:
            return
        L84:
            r1 = move-exception
            if (r0 == 0) goto L8a
            r0.endTransaction()     // Catch: java.lang.Throwable -> L8a
        L8a:
            android.content.Context r0 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L95
        L94:
            throw r1
        L95:
            goto L94
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.d():void");
    }

    public boolean e() {
        return this.f52978i.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0083, code lost:
        if (r2 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0085, code lost:
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009f, code lost:
        if (r2 != null) goto L29;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject f() {
        /*
            r14 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r14.f52981l
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L93
            com.umeng.analytics.pro.g r2 = com.umeng.analytics.pro.g.a(r2)     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L93
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L93
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.util.List<java.lang.String> r4 = r14.f52981l     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r6 = "__is"
            r7 = 0
            java.lang.String r8 = "__ii=? "
            r9 = 1
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r9[r5] = r4     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r4 = r14
            r5 = r6
            r6 = r2
            android.database.Cursor r4 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            if (r4 == 0) goto L5d
            boolean r5 = r4.moveToNext()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            if (r5 == 0) goto L5d
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r5.<init>()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            int r3 = r4.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r6 = r4.getString(r6)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r5.put(r1, r3)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r3 = r5
        L5d:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            if (r4 == 0) goto L65
            r4.close()
        L65:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L68
        L68:
            android.content.Context r0 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto La2
        L72:
            r5 = r3
        L73:
            r3 = r4
            goto L7e
        L75:
            r5 = r3
        L76:
            r3 = r4
            goto L95
        L78:
            r5 = r3
            goto L7e
        L7a:
            r5 = r3
            goto L95
        L7c:
            r2 = r3
            r5 = r2
        L7e:
            if (r3 == 0) goto L83
            r3.close()
        L83:
            if (r2 == 0) goto L88
        L85:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L88
        L88:
            android.content.Context r0 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            r3 = r5
            goto La2
        L93:
            r2 = r3
            r5 = r2
        L95:
            android.content.Context r0 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> La3
            com.umeng.analytics.pro.h.a(r0)     // Catch: java.lang.Throwable -> La3
            if (r3 == 0) goto L9f
            r3.close()
        L9f:
            if (r2 == 0) goto L88
            goto L85
        La2:
            return r3
        La3:
            r0 = move-exception
            if (r3 == 0) goto La9
            r3.close()
        La9:
            if (r2 == 0) goto Lae
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lae
        Lae:
            android.content.Context r1 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)
            r1.b()
            goto Lb9
        Lb8:
            throw r0
        Lb9:
            goto Lb8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.f():org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0083, code lost:
        if (r2 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0085, code lost:
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009f, code lost:
        if (r2 != null) goto L29;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject g() {
        /*
            r14 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r14.f52978i
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L93
            com.umeng.analytics.pro.g r2 = com.umeng.analytics.pro.g.a(r2)     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L93
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L93
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.util.List<java.lang.String> r4 = r14.f52978i     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r6 = "__sd"
            r7 = 0
            java.lang.String r8 = "__ii=? "
            r9 = 1
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r9[r5] = r4     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r4 = r14
            r5 = r6
            r6 = r2
            android.database.Cursor r4 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            if (r4 == 0) goto L5d
            boolean r5 = r4.moveToNext()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            if (r5 == 0) goto L5d
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r5.<init>()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            int r3 = r4.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r6 = r4.getString(r6)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r5.put(r1, r3)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r3 = r5
        L5d:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            if (r4 == 0) goto L65
            r4.close()
        L65:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L68
        L68:
            android.content.Context r0 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto La2
        L72:
            r5 = r3
        L73:
            r3 = r4
            goto L7e
        L75:
            r5 = r3
        L76:
            r3 = r4
            goto L95
        L78:
            r5 = r3
            goto L7e
        L7a:
            r5 = r3
            goto L95
        L7c:
            r2 = r3
            r5 = r2
        L7e:
            if (r3 == 0) goto L83
            r3.close()
        L83:
            if (r2 == 0) goto L88
        L85:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L88
        L88:
            android.content.Context r0 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            r3 = r5
            goto La2
        L93:
            r2 = r3
            r5 = r2
        L95:
            android.content.Context r0 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> La3
            com.umeng.analytics.pro.h.a(r0)     // Catch: java.lang.Throwable -> La3
            if (r3 == 0) goto L9f
            r3.close()
        L9f:
            if (r2 == 0) goto L88
            goto L85
        La2:
            return r3
        La3:
            r0 = move-exception
            if (r3 == 0) goto La9
            r3.close()
        La9:
            if (r2 == 0) goto Lae
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lae
        Lae:
            android.content.Context r1 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)
            r1.b()
            goto Lb9
        Lb8:
            throw r0
        Lb9:
            goto Lb8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.g():org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0059, code lost:
        if (r0 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.util.List<java.lang.Integer> r1 = r4.f52979j     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            if (r1 <= 0) goto L3c
            r1 = 0
        L17:
            java.util.List<java.lang.Integer> r2 = r4.f52979j     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            if (r1 >= r2) goto L3c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.<init>()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r3 = "delete from __et where rowid="
            r2.append(r3)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.util.List<java.lang.Integer> r3 = r4.f52979j     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.append(r3)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            int r1 = r1 + 1
            goto L17
        L3c:
            java.util.List<java.lang.Integer> r1 = r4.f52979j     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r1.clear()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            goto L47
        L45:
            if (r0 == 0) goto L4a
        L47:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L4a
        L4a:
            android.content.Context r0 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L5c
        L54:
            android.content.Context r1 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L5d
            com.umeng.analytics.pro.h.a(r1)     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L4a
            goto L47
        L5c:
            return
        L5d:
            r1 = move-exception
            if (r0 == 0) goto L63
            r0.endTransaction()     // Catch: java.lang.Throwable -> L63
        L63:
            android.content.Context r0 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L6e
        L6d:
            throw r1
        L6e:
            goto L6d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.h():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:
        if (r0 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i() {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            java.lang.String r1 = "delete from __er"
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            goto L19
        L17:
            if (r0 == 0) goto L1c
        L19:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L1c
        L1c:
            android.content.Context r0 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L2e
        L26:
            android.content.Context r1 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L2f
            com.umeng.analytics.pro.h.a(r1)     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L1c
            goto L19
        L2e:
            return
        L2f:
            r1 = move-exception
            if (r0 == 0) goto L35
            r0.endTransaction()     // Catch: java.lang.Throwable -> L35
        L35:
            android.content.Context r0 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L40
        L3f:
            throw r1
        L40:
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.i():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0064, code lost:
        if (r1 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j() {
        /*
            r5 = this;
            java.lang.String r0 = "\""
            java.lang.String r1 = r5.f52980k
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            if (r1 != 0) goto L77
            android.content.Context r1 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L4e android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L4e android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L4e android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r3.<init>()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r4 = "delete from __er where __i=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r4 = r5.f52980k     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r3.append(r4)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r3.append(r0)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r1.execSQL(r3)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r3.<init>()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r4 = "delete from __et where __i=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r4 = r5.f52980k     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r3.append(r4)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r3.append(r0)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r1.execSQL(r0)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            goto L51
        L4e:
            r1 = r2
        L4f:
            if (r1 == 0) goto L54
        L51:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L54
        L54:
            android.content.Context r0 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L77
        L5e:
            r1 = r2
        L5f:
            android.content.Context r0 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L67
            com.umeng.analytics.pro.h.a(r0)     // Catch: java.lang.Throwable -> L67
            if (r1 == 0) goto L54
            goto L51
        L67:
            r0 = move-exception
            if (r1 == 0) goto L6d
            r1.endTransaction()     // Catch: java.lang.Throwable -> L6d
        L6d:
            android.content.Context r1 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)
            r1.b()
            throw r0
        L77:
            r5.f52980k = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.j():void");
    }

    private i() {
        this.f52978i = new ArrayList();
        this.f52979j = new ArrayList();
        this.f52980k = null;
        this.f52981l = new ArrayList();
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String c4 = (optJSONObject == null || optJSONObject.length() <= 0) ? "" : c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = c(optJSONObject2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(longValue));
            contentValues.put("__sp", c4);
            contentValues.put("__pp", str2);
            contentValues.put("__av", UMGlobalContext.getInstance(f52973d).getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(f52973d));
            sQLiteDatabase.insert("__is", null, contentValues);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(java.lang.String r20, org.json.JSONObject r21, android.database.sqlite.SQLiteDatabase r22) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.c(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase):void");
    }

    private Cursor a(String str, SQLiteDatabase sQLiteDatabase, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (sQLiteDatabase != null) {
            try {
                if (sQLiteDatabase.isOpen()) {
                    return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public void a() {
        this.f52978i.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0098, code lost:
        if (r2 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009a, code lost:
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ac, code lost:
        if (r2 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(org.json.JSONArray r11) {
        /*
            r10 = this;
            java.lang.String r0 = "__t"
            java.lang.String r1 = "__i"
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteDatabaseCorruptException -> La7
            com.umeng.analytics.pro.g r3 = com.umeng.analytics.pro.g.a(r3)     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteDatabaseCorruptException -> La7
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteDatabaseCorruptException -> La7
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            r4 = 0
        L13:
            int r5 = r11.length()     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            if (r4 >= r5) goto L8d
            org.json.JSONObject r5 = r11.getJSONObject(r4)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.<init>()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = r5.optString(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r9 = "-1"
            if (r8 != 0) goto L34
            boolean r8 = r9.equals(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            if (r8 == 0) goto L43
        L34:
            com.umeng.analytics.pro.u r7 = com.umeng.analytics.pro.u.a()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = r7.b()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            if (r8 == 0) goto L43
            r7 = r9
        L43:
            r6.put(r1, r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = "__e"
            java.lang.String r8 = "id"
            java.lang.String r8 = r5.optString(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            int r7 = r5.optInt(r0)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r0, r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r5.remove(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r5.remove(r0)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = "__s"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r5 = r10.c(r5)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r7, r5)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r5 = "__et"
            r3.insert(r5, r2, r6)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
        L8a:
            int r4 = r4 + 1
            goto L13
        L8d:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            r3.endTransaction()     // Catch: java.lang.Throwable -> L9d
            goto L9d
        L94:
            r2 = r3
            goto L98
        L96:
            r2 = r3
            goto La7
        L98:
            if (r2 == 0) goto L9d
        L9a:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L9d
        L9d:
            android.content.Context r11 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r11 = com.umeng.analytics.pro.g.a(r11)
            r11.b()
            goto Laf
        La7:
            android.content.Context r11 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> Lb0
            com.umeng.analytics.pro.h.a(r11)     // Catch: java.lang.Throwable -> Lb0
            if (r2 == 0) goto L9d
            goto L9a
        Laf:
            return
        Lb0:
            r11 = move-exception
            if (r2 == 0) goto Lb6
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lb6
        Lb6:
            android.content.Context r0 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto Lc1
        Lc0:
            throw r11
        Lc1:
            goto Lc0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(org.json.JSONArray):void");
    }

    public String d(String str) {
        try {
            return TextUtils.isEmpty(f52974e) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f52974e.getBytes()));
        } catch (Exception unused) {
            if (Build.VERSION.SDK_INT >= 29 && !TextUtils.isEmpty(str)) {
                try {
                    new JSONObject(str);
                    UMRTLog.e("MobclickRT", "--->>> UMStoreManager decrypt failed, return origin data.");
                    return str;
                } catch (Throwable unused2) {
                    return null;
                }
            }
            return null;
        }
    }

    public JSONObject b(boolean z3) {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, z3);
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0083, code lost:
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0091, code lost:
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00a6: IF  (r1 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:41:0x00ab, block:B:39:0x00a6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(org.json.JSONObject r13, java.lang.String r14) {
        /*
            r12 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L86
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L86
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L86
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            boolean r2 = android.text.TextUtils.isEmpty(r14)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            if (r2 != 0) goto L2a
            java.lang.String r3 = "__er"
            r5 = 0
            java.lang.String r6 = "__i=? "
            r2 = 1
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            r2 = 0
            r7[r2] = r14     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r2 = r12
            r4 = r1
            android.database.Cursor r14 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            goto L39
        L2a:
            java.lang.String r3 = "__er"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r2 = r12
            r4 = r1
            android.database.Cursor r14 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
        L39:
            r0 = r14
            if (r0 == 0) goto L6f
            org.json.JSONArray r14 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            r14.<init>()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
        L41:
            boolean r2 = r0.moveToNext()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            if (r2 == 0) goto L64
            java.lang.String r2 = "__a"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            if (r3 != 0) goto L41
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            java.lang.String r2 = r12.d(r2)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            r14.put(r3)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            goto L41
        L64:
            int r2 = r14.length()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            if (r2 <= 0) goto L6f
            java.lang.String r2 = "error"
            r13.put(r2, r14)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
        L6f:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            if (r0 == 0) goto L93
            r0.close()
            goto L93
        L78:
            r1 = r0
        L79:
            android.content.Context r13 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> La0
            com.umeng.analytics.pro.h.a(r13)     // Catch: java.lang.Throwable -> La0
            if (r0 == 0) goto L83
            r0.close()
        L83:
            if (r1 == 0) goto L96
            goto L93
        L86:
            r1 = r0
        L87:
            android.content.Context r13 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> La0
            com.umeng.analytics.pro.h.a(r13)     // Catch: java.lang.Throwable -> La0
            if (r0 == 0) goto L91
            r0.close()
        L91:
            if (r1 == 0) goto L96
        L93:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L96
        L96:
            android.content.Context r13 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r13 = com.umeng.analytics.pro.g.a(r13)
            r13.b()
            return
        La0:
            r13 = move-exception
            if (r0 == 0) goto La6
            r0.close()
        La6:
            if (r1 == 0) goto Lab
            r1.endTransaction()     // Catch: java.lang.Throwable -> Lab
        Lab:
            android.content.Context r14 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r14 = com.umeng.analytics.pro.g.a(r14)
            r14.b()
            goto Lb6
        Lb5:
            throw r13
        Lb6:
            goto Lb5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(org.json.JSONObject, java.lang.String):void");
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(f52974e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f52974e.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0056, code lost:
        if (r0 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0058, code lost:
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006a, code lost:
        if (r0 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteDatabaseCorruptException -> L65
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteDatabaseCorruptException -> L65
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteDatabaseCorruptException -> L65
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.<init>()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r3 = "__i"
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = r4.c(r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            if (r6 != 0) goto L4b
            java.lang.String r6 = "__a"
            r2.put(r6, r5)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = "__t"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = "__av"
            android.content.Context r6 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = "__vc"
            android.content.Context r6 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = "__er"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
        L4b:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r1.endTransaction()     // Catch: java.lang.Throwable -> L5b
            goto L5b
        L52:
            r0 = r1
            goto L56
        L54:
            r0 = r1
            goto L65
        L56:
            if (r0 == 0) goto L5b
        L58:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L5b
        L5b:
            android.content.Context r5 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r5 = com.umeng.analytics.pro.g.a(r5)
            r5.b()
            goto L6d
        L65:
            android.content.Context r5 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L6f
            com.umeng.analytics.pro.h.a(r5)     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L5b
            goto L58
        L6d:
            r5 = 0
            return r5
        L6f:
            r5 = move-exception
            if (r0 == 0) goto L75
            r0.endTransaction()     // Catch: java.lang.Throwable -> L75
        L75:
            android.content.Context r6 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r6 = com.umeng.analytics.pro.g.a(r6)
            r6.b()
            goto L80
        L7f:
            throw r5
        L80:
            goto L7f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String, java.lang.String, int):boolean");
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            if (optJSONObject != null && optJSONObject.optLong("duration") > 0) {
                jSONArray2.put(optJSONObject);
            }
        }
        return jSONArray2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d5, code lost:
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e4, code lost:
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e6, code lost:
        r1.endTransaction();
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(org.json.JSONObject r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(org.json.JSONObject, boolean):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0085, code lost:
        if (r2 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0099, code lost:
        if (r2 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r7, org.json.JSONObject r8, com.umeng.analytics.pro.i.a r9) {
        /*
            r6 = this;
            java.lang.String r0 = "__e"
            r1 = 0
            if (r8 != 0) goto L6
            return r1
        L6:
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteDatabaseCorruptException -> L94
            com.umeng.analytics.pro.g r3 = com.umeng.analytics.pro.g.a(r3)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteDatabaseCorruptException -> L94
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteDatabaseCorruptException -> L94
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            com.umeng.analytics.pro.i$a r4 = com.umeng.analytics.pro.i.a.BEGIN     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r4) goto L4f
            java.lang.Object r8 = r8.opt(r0)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.Long r8 = (java.lang.Long) r8     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            long r8 = r8.longValue()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r4.<init>()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r5 = "__ii"
            r4.put(r5, r7)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r7 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r4.put(r0, r7)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r7 = "__sd"
            r3.insert(r7, r2, r4)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L4f:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.INSTANTSESSIONBEGIN     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L57
            r6.b(r7, r8, r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L57:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.END     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L5f
            r6.a(r7, r8, r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L5f:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.PAGE     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L69
            java.lang.String r9 = "__a"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L69:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.AUTOPAGE     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L73
            java.lang.String r9 = "__b"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L73:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.NEWSESSION     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L7a
            r6.c(r7, r8, r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
        L7a:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r3.endTransaction()     // Catch: java.lang.Throwable -> L8a
            goto L8a
        L81:
            r2 = r3
            goto L85
        L83:
            r2 = r3
            goto L94
        L85:
            if (r2 == 0) goto L8a
        L87:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L8a
        L8a:
            android.content.Context r7 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r7 = com.umeng.analytics.pro.g.a(r7)
            r7.b()
            goto L9c
        L94:
            android.content.Context r7 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L9d
            com.umeng.analytics.pro.h.a(r7)     // Catch: java.lang.Throwable -> L9d
            if (r2 == 0) goto L8a
            goto L87
        L9c:
            return r1
        L9d:
            r7 = move-exception
            if (r2 == 0) goto La3
            r2.endTransaction()     // Catch: java.lang.Throwable -> La3
        La3:
            android.content.Context r8 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r8 = com.umeng.analytics.pro.g.a(r8)
            r8.b()
            goto Lae
        Lad:
            throw r7
        Lae:
            goto Lad
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String, org.json.JSONObject, com.umeng.analytics.pro.i$a):boolean");
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.opt("__f")).longValue();
            long j4 = 0;
            Object opt = jSONObject.opt("__g");
            if (opt != null && (opt instanceof Long)) {
                j4 = ((Long) opt).longValue();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String c4 = (optJSONObject == null || optJSONObject.length() <= 0) ? "" : c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = c(optJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + longValue + "\", __g=\"" + j4 + "\", __sp=\"" + c4 + "\", __pp=\"" + str2 + "\" where __ii=\"" + str + "\"");
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0065, code lost:
        if (r0 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(boolean r3, boolean r4) {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            if (r4 == 0) goto L18
            if (r3 == 0) goto L4d
            java.lang.String r3 = "delete from __sd"
            r0.execSQL(r3)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            goto L4d
        L18:
            java.util.List<java.lang.String> r3 = r2.f52978i     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            if (r3 <= 0) goto L4d
            r3 = 0
        L21:
            java.util.List<java.lang.String> r4 = r2.f52978i     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            if (r3 >= r4) goto L4d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            r4.<init>()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.String r1 = "delete from __sd where __ii=\""
            r4.append(r1)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.util.List<java.lang.String> r1 = r2.f52978i     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            r4.append(r1)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.String r1 = "\""
            r4.append(r1)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            int r3 = r3 + 1
            goto L21
        L4d:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            goto L53
        L51:
            if (r0 == 0) goto L56
        L53:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L56
        L56:
            android.content.Context r3 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r3 = com.umeng.analytics.pro.g.a(r3)
            r3.b()
            goto L68
        L60:
            android.content.Context r3 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L69
            com.umeng.analytics.pro.h.a(r3)     // Catch: java.lang.Throwable -> L69
            if (r0 == 0) goto L56
            goto L53
        L68:
            return
        L69:
            r3 = move-exception
            if (r0 == 0) goto L6f
            r0.endTransaction()     // Catch: java.lang.Throwable -> L6f
        L6f:
            android.content.Context r4 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r4 = com.umeng.analytics.pro.g.a(r4)
            r4.b()
            goto L7a
        L79:
            throw r3
        L7a:
            goto L79
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(boolean, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:
        if (r4 != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(java.lang.String r16) {
        /*
            r15 = this;
            java.lang.String r0 = "__f"
            r1 = 0
            r2 = 0
            android.content.Context r4 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L56
            com.umeng.analytics.pro.g r4 = com.umeng.analytics.pro.g.a(r4)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L56
            android.database.sqlite.SQLiteDatabase r4 = r4.a()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L56
            r4.beginTransaction()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L57
            r5 = 1
            java.lang.String[] r8 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L57
            r6 = 0
            r8[r6] = r0     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L57
            java.lang.String r7 = "__sd"
            java.lang.String r9 = "__ii=? "
            java.lang.String[] r10 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L57
            r10[r6] = r16     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L57
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r5 = r15
            r6 = r7
            r7 = r4
            android.database.Cursor r1 = r5.a(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L57
            if (r1 == 0) goto L38
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L57
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L57
            long r2 = r1.getLong(r0)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L57
        L38:
            if (r1 == 0) goto L5e
            r1.close()     // Catch: java.lang.Exception -> L61
            goto L5e
        L3e:
            r0 = move-exception
            goto L42
        L40:
            r0 = move-exception
            r4 = r1
        L42:
            if (r1 == 0) goto L47
            r1.close()     // Catch: java.lang.Exception -> L4c
        L47:
            if (r4 == 0) goto L4c
            r4.endTransaction()     // Catch: java.lang.Exception -> L4c
        L4c:
            android.content.Context r1 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)
            r1.b()
            throw r0
        L56:
            r4 = r1
        L57:
            if (r1 == 0) goto L5c
            r1.close()     // Catch: java.lang.Exception -> L61
        L5c:
            if (r4 == 0) goto L61
        L5e:
            r4.endTransaction()     // Catch: java.lang.Exception -> L61
        L61:
            android.content.Context r0 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String):long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0045, code lost:
        if (r0 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            if (r1 != 0) goto L2d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            r1.<init>()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            java.lang.String r2 = "delete from __is where __ii=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            r1.append(r4)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            java.lang.String r4 = "\""
            r1.append(r4)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
        L2d:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            goto L33
        L31:
            if (r0 == 0) goto L36
        L33:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L36
        L36:
            android.content.Context r4 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r4 = com.umeng.analytics.pro.g.a(r4)
            r4.b()
            goto L48
        L40:
            android.content.Context r4 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L49
            com.umeng.analytics.pro.h.a(r4)     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L36
            goto L33
        L48:
            return
        L49:
            r4 = move-exception
            if (r0 == 0) goto L4f
            r0.endTransaction()     // Catch: java.lang.Throwable -> L4f
        L4f:
            android.content.Context r0 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L5a
        L59:
            throw r4
        L5a:
            goto L59
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0077 A[Catch: all -> 0x0069, TryCatch #2 {all -> 0x0069, blocks: (B:22:0x0056, B:24:0x005c, B:26:0x006c, B:28:0x0077, B:29:0x007c, B:36:0x008b, B:38:0x0091, B:40:0x0097, B:42:0x009d, B:44:0x00ab, B:41:0x009a), top: B:56:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0056 A[EXC_TOP_SPLITTER, LOOP:1: B:56:0x0056->B:24:0x005c, LOOP_START, PHI: r14 
      PHI: (r14v2 java.lang.String) = (r14v7 java.lang.String), (r14v3 java.lang.String) binds: [B:21:0x0054, B:24:0x005c] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r18, org.json.JSONObject r19, android.database.sqlite.SQLiteDatabase r20, java.lang.String r21) throws org.json.JSONException {
        /*
            r17 = this;
            r10 = r17
            r11 = r18
            r0 = r19
            r12 = r21
            java.lang.String r13 = "=\""
            java.lang.String r1 = "__b"
            java.lang.String r2 = "__a"
            r14 = 0
            boolean r3 = r2.equals(r12)     // Catch: java.lang.Throwable -> Le2
            if (r3 == 0) goto L25
            org.json.JSONArray r0 = r0.optJSONArray(r2)     // Catch: java.lang.Throwable -> Le2
            if (r0 == 0) goto L24
            int r1 = r0.length()     // Catch: java.lang.Throwable -> Le2
            if (r1 > 0) goto L22
            goto L24
        L22:
            r15 = r0
            goto L39
        L24:
            return
        L25:
            boolean r2 = r1.equals(r12)     // Catch: java.lang.Throwable -> Le2
            if (r2 == 0) goto L38
            org.json.JSONArray r0 = r0.optJSONArray(r1)     // Catch: java.lang.Throwable -> Le2
            if (r0 == 0) goto L37
            int r1 = r0.length()     // Catch: java.lang.Throwable -> Le2
            if (r1 > 0) goto L22
        L37:
            return
        L38:
            r15 = r14
        L39:
            r0 = 1
            java.lang.String[] r3 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> Le2
            r16 = 0
            r3[r16] = r12     // Catch: java.lang.Throwable -> Le2
            java.lang.String r1 = "__sd"
            java.lang.String r4 = "__ii=? "
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> Le2
            r5[r16] = r11     // Catch: java.lang.Throwable -> Le2
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r0 = r17
            r2 = r20
            android.database.Cursor r0 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> Le2
            if (r0 == 0) goto L6c
        L56:
            boolean r1 = r0.moveToNext()     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L6c
            int r1 = r0.getColumnIndex(r12)     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.String r14 = r10.d(r1)     // Catch: java.lang.Throwable -> L69
            goto L56
        L69:
            r14 = r0
            goto Le3
        L6c:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L69
            r1.<init>()     // Catch: java.lang.Throwable -> L69
            boolean r2 = android.text.TextUtils.isEmpty(r14)     // Catch: java.lang.Throwable -> L69
            if (r2 != 0) goto L7c
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L69
            r1.<init>(r14)     // Catch: java.lang.Throwable -> L69
        L7c:
            int r2 = r1.length()     // Catch: java.lang.Throwable -> L69
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 <= r3) goto L8a
            if (r0 == 0) goto L89
            r0.close()
        L89:
            return
        L8a:
            r2 = 0
        L8b:
            int r3 = r15.length()     // Catch: java.lang.Throwable -> L69
            if (r2 >= r3) goto L9d
            org.json.JSONObject r3 = r15.getJSONObject(r2)     // Catch: java.lang.Throwable -> L69 org.json.JSONException -> L9a
            if (r3 == 0) goto L9a
            r1.put(r3)     // Catch: java.lang.Throwable -> L69
        L9a:
            int r2 = r2 + 1
            goto L8b
        L9d:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = r10.c(r1)     // Catch: java.lang.Throwable -> L69
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L69
            if (r2 != 0) goto Ldc
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L69
            r2.<init>()     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = "update __sd set "
            r2.append(r3)     // Catch: java.lang.Throwable -> L69
            r2.append(r12)     // Catch: java.lang.Throwable -> L69
            r2.append(r13)     // Catch: java.lang.Throwable -> L69
            r2.append(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = "\" where "
            r2.append(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = "__ii"
            r2.append(r1)     // Catch: java.lang.Throwable -> L69
            r2.append(r13)     // Catch: java.lang.Throwable -> L69
            r2.append(r11)     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = "\""
            r2.append(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L69
            r2 = r20
            r2.execSQL(r1)     // Catch: java.lang.Throwable -> L69
        Ldc:
            if (r0 == 0) goto Le8
            r0.close()
            goto Le8
        Le2:
        Le3:
            if (r14 == 0) goto Le8
            r14.close()
        Le8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase, java.lang.String):void");
    }

    public JSONObject a(boolean z3) {
        a();
        this.f52979j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z3) {
            a(jSONObject, z3);
            b(jSONObject, (String) null);
            a(jSONObject, (String) null);
        } else {
            String a4 = a(jSONObject, z3);
            if (!TextUtils.isEmpty(a4)) {
                b(jSONObject, a4);
                a(jSONObject, a4);
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0180, code lost:
        if (r1 != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x018e, code lost:
        if (r1 != null) goto L91;
     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x01a3: IF  (r1 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:83:0x01a8, block:B:81:0x01a3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(org.json.JSONObject r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(org.json.JSONObject, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x021e, code lost:
        if (r12 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x022d, code lost:
        if (r12 == null) goto L13;
     */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0242: IF  (r12 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:105:0x0247, block:B:103:0x0242 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x023d: IF  (r14 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:103:0x0242, block:B:101:0x023d */
    /* JADX WARN: Removed duplicated region for block: B:89:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x022a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(org.json.JSONObject r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 595
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(org.json.JSONObject, boolean):java.lang.String");
    }

    public void a(boolean z3, boolean z4) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = g.a(f52973d).a();
                sQLiteDatabase.beginTransaction();
                if (!z4) {
                    int size = this.f52981l.size();
                    int i4 = 0;
                    if (size > 0) {
                        int i5 = 0;
                        while (i4 < size) {
                            String str = this.f52981l.get(i4);
                            if (str == null) {
                                i5 = 1;
                            }
                            sQLiteDatabase.execSQL("delete from __is where __ii=\"" + str + "\"");
                            i4++;
                        }
                        i4 = i5;
                    }
                    if (i4 != 0) {
                        sQLiteDatabase.execSQL("delete from __is where __ii is null");
                    }
                } else if (z3) {
                    sQLiteDatabase.execSQL("delete from __is");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                g.a(f52973d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            h.a(f52973d);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0078, code lost:
        if (r0 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r4 = "\""
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            if (r1 != 0) goto L60
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.<init>()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r2 = "delete from __er where __i=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r5)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r4)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.<init>()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r2 = "delete from __et where __i=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r5)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r4)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.util.List<java.lang.Integer> r1 = r3.f52979j     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.clear()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.<init>()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r2 = "delete from __sd where __ii=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r5)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r4)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
        L60:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            goto L66
        L64:
            if (r0 == 0) goto L69
        L66:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L69
        L69:
            android.content.Context r4 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r4 = com.umeng.analytics.pro.g.a(r4)
            r4.b()
            goto L7b
        L73:
            android.content.Context r4 = com.umeng.analytics.pro.i.f52973d     // Catch: java.lang.Throwable -> L7c
            com.umeng.analytics.pro.h.a(r4)     // Catch: java.lang.Throwable -> L7c
            if (r0 == 0) goto L69
            goto L66
        L7b:
            return
        L7c:
            r4 = move-exception
            if (r0 == 0) goto L82
            r0.endTransaction()     // Catch: java.lang.Throwable -> L82
        L82:
            android.content.Context r5 = com.umeng.analytics.pro.i.f52973d
            com.umeng.analytics.pro.g r5 = com.umeng.analytics.pro.g.a(r5)
            r5.b()
            goto L8d
        L8c:
            throw r4
        L8d:
            goto L8c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(boolean, java.lang.String):void");
    }
}
