package com.bytedance.sdk.component.r.w.c.c;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.component.r.c.ux;
import com.stub.StubApp;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile c xv;

    /* renamed from: c  reason: collision with root package name */
    private w f30050c;

    /* renamed from: w  reason: collision with root package name */
    private Context f30051w;

    /* renamed from: com.bytedance.sdk.component.r.w.c.c.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class C0451c extends AbstractCursor {
        private C0451c() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i4) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i4) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i4) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i4) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i4) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i4) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i4) {
            return true;
        }
    }

    private c(Context context) {
        try {
            this.f30051w = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (this.f30050c == null) {
                this.f30050c = new w();
            }
        } catch (Throwable unused) {
        }
    }

    public static c c(Context context) {
        if (xv == null) {
            synchronized (c.class) {
                if (xv == null) {
                    xv = new c(context);
                }
            }
        }
        return xv;
    }

    private Context getContext() {
        return this.f30051w;
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class w {
        public w() {
        }

        private SQLiteDatabase c(ux uxVar) {
            boolean w3;
            try {
                SQLiteDatabase c4 = uxVar.w().c(uxVar.getContext());
                if (c4 == null || !c4.isOpen()) {
                    return null;
                }
                c4.setLockingEnabled(false);
                com.bytedance.sdk.component.r.w.xv.xv.c("---------------configManager.getDbCallback().getDatabase  SUCCESS------------", uxVar);
                return c4;
            } finally {
                if (!w3) {
                }
            }
        }

        private boolean w(ux uxVar) {
            SQLiteDatabase c4 = c(uxVar);
            return c4 != null && c4.inTransaction();
        }

        public int delete(ux uxVar, String str, String str2, String[] strArr) {
            try {
                SQLiteDatabase c4 = c(uxVar);
                if (c4 != null) {
                    return c4.delete(str, str2, strArr);
                }
                return 0;
            } catch (Exception e4) {
                e4.printStackTrace();
                if (w(uxVar)) {
                    throw e4;
                }
                return 0;
            }
        }

        public long insert(ux uxVar, String str, String str2, ContentValues contentValues) {
            try {
                SQLiteDatabase c4 = c(uxVar);
                if (c4 != null) {
                    return c4.insert(str, str2, contentValues);
                }
                return -1L;
            } catch (Exception e4) {
                e4.printStackTrace();
                if (w(uxVar)) {
                    throw e4;
                }
                return -1L;
            }
        }

        public Cursor query(ux uxVar, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            C0451c c0451c = new C0451c();
            try {
                SQLiteDatabase c4 = c(uxVar);
                return c4 != null ? c4.query(str, strArr, str2, strArr2, str3, str4, str5) : c0451c;
            } catch (Throwable th) {
                th.printStackTrace();
                C0451c c0451c2 = new C0451c();
                if (w(uxVar)) {
                    throw th;
                }
                return c0451c2;
            }
        }

        public int update(ux uxVar, String str, ContentValues contentValues, String str2, String[] strArr) {
            try {
                SQLiteDatabase c4 = c(uxVar);
                if (c4 != null) {
                    return c4.update(str, contentValues, str2, strArr);
                }
                return 0;
            } catch (Exception e4) {
                e4.printStackTrace();
                if (w(uxVar)) {
                    throw e4;
                }
                return 0;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0091, code lost:
            if (r0 != null) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0093, code lost:
            r0.endTransaction();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00c2, code lost:
            if (r0 != null) goto L27;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public synchronized void insert(com.bytedance.sdk.component.r.c.ux r8, java.lang.String r9, java.lang.String r10, java.util.List<com.bytedance.sdk.component.r.c.w> r11) {
            /*
                r7 = this;
                monitor-enter(r7)
                r0 = 0
                android.database.sqlite.SQLiteDatabase r0 = r7.c(r8)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                if (r0 == 0) goto L91
                r0.beginTransaction()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                android.content.ContentValues r1 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                r1.<init>()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                r2 = 0
                r3 = 0
            L12:
                int r4 = r11.size()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                if (r3 >= r4) goto L71
                java.lang.Object r4 = r11.get(r3)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                com.bytedance.sdk.component.r.c.w r4 = (com.bytedance.sdk.component.r.c.w) r4     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                if (r4 != 0) goto L21
                goto L6e
            L21:
                org.json.JSONObject r5 = r4.r()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                if (r5 != 0) goto L28
                goto L6e
            L28:
                java.lang.String r6 = "id"
                java.lang.String r4 = r4.xv()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                r1.put(r6, r4)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                com.bytedance.sdk.component.r.c.sr r4 = r8.sr()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                java.lang.String r4 = r4.w(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                if (r5 != 0) goto L6b
                java.lang.String r5 = "value"
                r1.put(r5, r4)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                java.lang.String r4 = "gen_time"
                long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                r1.put(r4, r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                java.lang.String r4 = "retry"
                java.lang.Integer r5 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                r1.put(r4, r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                java.lang.String r4 = "encrypt"
                r5 = 1
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                r1.put(r4, r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                r0.insert(r9, r10, r1)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            L6b:
                r1.clear()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            L6e:
                int r3 = r3 + 1
                goto L12
            L71:
                r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                java.lang.String r10 = "DBHelper"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                r1.<init>()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                r1.append(r9)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                java.lang.String r2 = " insert list size="
                r1.append(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                int r2 = r11.size()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                r1.append(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
                com.bytedance.sdk.component.r.w.xv.xv.w(r10, r1, r8)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            L91:
                if (r0 == 0) goto Lc5
            L93:
                r0.endTransaction()     // Catch: java.lang.Throwable -> L97
                goto Lc5
            L97:
                r8 = move-exception
                goto Lce
            L99:
                r8 = move-exception
                goto Lc8
            L9b:
                r10 = move-exception
                java.lang.String r1 = "DBHelper"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
                r2.<init>()     // Catch: java.lang.Throwable -> L99
                r2.append(r9)     // Catch: java.lang.Throwable -> L99
                java.lang.String r9 = " insert list error="
                r2.append(r9)     // Catch: java.lang.Throwable -> L99
                int r9 = r11.size()     // Catch: java.lang.Throwable -> L99
                r2.append(r9)     // Catch: java.lang.Throwable -> L99
                java.lang.String r9 = r2.toString()     // Catch: java.lang.Throwable -> L99
                com.bytedance.sdk.component.r.w.xv.xv.w(r1, r9)     // Catch: java.lang.Throwable -> L99
                r10.printStackTrace()     // Catch: java.lang.Throwable -> L99
                boolean r8 = r7.w(r8)     // Catch: java.lang.Throwable -> L99
                if (r8 != 0) goto Lc7
                if (r0 == 0) goto Lc5
                goto L93
            Lc5:
                monitor-exit(r7)
                return
            Lc7:
                throw r10     // Catch: java.lang.Throwable -> L99
            Lc8:
                if (r0 == 0) goto Lcd
                r0.endTransaction()     // Catch: java.lang.Throwable -> L97
            Lcd:
                throw r8     // Catch: java.lang.Throwable -> L97
            Lce:
                monitor-exit(r7)
                goto Ld1
            Ld0:
                throw r8
            Ld1:
                goto Ld0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.r.w.c.c.c.w.insert(com.bytedance.sdk.component.r.c.ux, java.lang.String, java.lang.String, java.util.List):void");
        }

        public void c(ux uxVar, String str) throws SQLException {
            boolean w3;
            try {
                SQLiteDatabase c4 = c(uxVar);
                if (c4 != null) {
                    c4.execSQL(str);
                }
            } finally {
                if (!w3) {
                }
            }
        }
    }

    public w c() {
        return this.f30050c;
    }
}
