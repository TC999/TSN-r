package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class mt {

    /* renamed from: f  reason: collision with root package name */
    private static final up[] f26766f;
    static final w[] xv;

    /* renamed from: r  reason: collision with root package name */
    private String f26768r;
    private final ys sr;
    private final c ux;

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f26765c = {1};

    /* renamed from: w  reason: collision with root package name */
    static final HashMap<String, up> f26767w = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c extends SQLiteOpenHelper {
        c(@Nullable Context context, @Nullable String str, @Nullable SQLiteDatabase.CursorFactory cursorFactory, int i4) {
            super(new com.bytedance.sdk.openadsdk.api.plugin.c(context), str, cursorFactory, i4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.beginTransaction();
                for (up upVar : mt.f26767w.values()) {
                    String xv = upVar.xv();
                    if (xv != null) {
                        sQLiteDatabase.execSQL(xv);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                try {
                } finally {
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
            onUpgrade(sQLiteDatabase, i4, i5);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
            be.sr("onUpgrade, " + i4 + ", " + i5, null);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<up> it = mt.f26767w.values().iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next().sr());
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                try {
                    g.c(sQLiteDatabase);
                    onCreate(sQLiteDatabase);
                } catch (Throwable th) {
                }
            }
            g.c(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w {

        /* renamed from: c  reason: collision with root package name */
        String f26769c;

        /* renamed from: w  reason: collision with root package name */
        int f26770w;
        int xv;

        w() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void w() {
            w[] wVarArr;
            for (w wVar : mt.xv) {
                wVar.f26769c = "";
                wVar.f26770w = 0;
                wVar.xv = 0;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(this.xv);
            sb.append("-");
            sb.append(this.f26769c);
            sb.append("-");
            sb.append(this.f26770w);
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(up upVar) {
            String gd = upVar.gd();
            if (gd == null || gd.length() <= this.f26770w) {
                return;
            }
            this.f26769c = upVar.ev();
            this.f26770w = gd.length();
        }
    }

    static {
        c(new wo());
        c(new bm(true));
        c(new ox());
        c(new b());
        up[] upVarArr = {new oo(), new bj(null, false, null), new au("", new JSONObject())};
        f26766f = upVarArr;
        for (up upVar : upVarArr) {
            c(upVar);
        }
        xv = new w[]{new w(), new w(), new w()};
    }

    public mt(ys ysVar) {
        this.ux = new c(ysVar.w(), "bd_embed_tea_agent.db", null, 30);
        this.sr = ysVar;
    }

    private String c(String str, boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM page WHERE session_id");
        sb.append(z3 ? "='" : "!='");
        sb.append(str);
        sb.append("' ORDER BY ");
        sb.append(z3 ? "session_id," : "");
        sb.append("duration");
        sb.append(" DESC LIMIT 500");
        return sb.toString();
    }

    private String w(String str, boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM page WHERE session_id");
        sb.append(z3 ? "='" : "!='");
        sb.append(str);
        sb.append("'");
        return sb.toString();
    }

    private String c(up upVar, String str, boolean z3, int i4, int i5) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(upVar.sr());
        sb.append(" WHERE ");
        sb.append("session_id");
        sb.append(z3 ? "='" : "!='");
        sb.append(str);
        sb.append("' AND ");
        sb.append("event_type");
        sb.append("='");
        sb.append(i5);
        sb.append("' ORDER BY ");
        sb.append("_id");
        sb.append(" LIMIT ");
        sb.append(i4);
        return sb.toString();
    }

    private String c(String str, int i4, String str2, boolean z3, long j4) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(str);
        sb.append(" WHERE ");
        sb.append("session_id");
        sb.append(z3 ? "='" : "!='");
        sb.append(str2);
        sb.append("' AND ");
        sb.append("event_type");
        sb.append("='");
        sb.append(i4);
        sb.append("' AND ");
        sb.append("_id");
        sb.append("<=");
        sb.append(j4);
        return sb.toString();
    }

    private String c(long j4, int i4) {
        return "UPDATE pack SET _fail=" + i4 + " WHERE _id=" + j4;
    }

    private static void c(up upVar) {
        f26767w.put(upVar.sr(), upVar);
    }

    private boolean c(String str) {
        be.c("needLaunch, " + this.f26768r + ", " + str);
        if (TextUtils.equals(str, this.f26768r)) {
            return false;
        }
        this.f26768r = str;
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:3|4|5|(3:6|7|(4:8|9|11|12))|(9:13|14|(6:16|17|(7:(1:20)|21|22|23|24|25|26)(7:45|46|47|(1:49)|50|(1:52)|53)|27|28|29)(1:60)|30|31|32|(1:34)|35|36)|61|(1:65)|67|68|(2:70|(7:72|73|74|75|76|77|36))|82|75|76|77|36) */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0145, code lost:
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:76:0x015b A[Catch: all -> 0x015f, TRY_ENTER, TRY_LEAVE, TryCatch #12 {, blocks: (B:4:0x0003, B:81:0x0164, B:60:0x013f, B:74:0x0156, B:55:0x0136, B:76:0x015b), top: B:109:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.ArrayList<com.bytedance.embedapplog.b> c(org.json.JSONObject r31) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.mt.c(org.json.JSONObject):java.util.ArrayList");
    }

    private void c(JSONObject jSONObject, boolean z3, b bVar, SQLiteDatabase sQLiteDatabase) {
        int[] iArr = f26765c;
        int length = iArr.length;
        int i4 = 0;
        while (i4 < length) {
            int i5 = iArr[i4];
            JSONArray[] jSONArrayArr = new JSONArray[3];
            long[] jArr = new long[3];
            int c4 = c(0, sQLiteDatabase, bVar.sr, z3, i5, jSONArrayArr, jArr);
            if (c(jArr)) {
                long[] jArr2 = jArr;
                bVar.c(jSONObject, null, null, null, jSONArrayArr, jArr, i5);
                c(bVar, z3, sQLiteDatabase, true);
                int i6 = c4;
                while (i6 < f26766f.length) {
                    int[] iArr2 = iArr;
                    long[] jArr3 = jArr2;
                    int c5 = c(i6, sQLiteDatabase, bVar.sr, z3, i5, jSONArrayArr, jArr3);
                    if (c(jArr3)) {
                        jArr2 = jArr3;
                        bVar.c(jSONObject, null, null, null, jSONArrayArr, jArr3, i5);
                        c(bVar, z3, sQLiteDatabase, true);
                    } else {
                        jArr2 = jArr3;
                    }
                    iArr = iArr2;
                    i6 = c5;
                }
            }
            i4++;
            iArr = iArr;
        }
    }

    private JSONObject c(bm bmVar, JSONObject jSONObject) {
        if (TextUtils.equals(bmVar.bk, this.sr.ux().xv()) && bmVar.f26707a == this.sr.ux().w()) {
            return jSONObject;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            g.w(jSONObject2, jSONObject);
            jSONObject2.put("app_version", bmVar.bk);
            jSONObject2.put("version_code", bmVar.f26707a);
            return jSONObject2;
        } catch (JSONException e4) {
            be.w(e4);
            return jSONObject;
        }
    }

    private void c(JSONObject jSONObject, bm bmVar, b bVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr, ArrayList<b> arrayList) {
        boolean z3;
        be.c("packCurrentData, " + bmVar.sr);
        boolean c4 = c(bmVar.sr);
        int c5 = c(0, sQLiteDatabase, bmVar.sr, true, 0, jSONArrayArr, jArr);
        if (c4 || c(jArr)) {
            z3 = true;
            bVar.c(jSONObject, c4 ? bmVar : null, null, null, jSONArrayArr, jArr, 0);
            if (c5 >= f26766f.length) {
                b bVar2 = (b) bVar.clone();
                bVar2.p();
                arrayList.add(bVar2);
            } else {
                c(bVar, true, sQLiteDatabase, true);
            }
        } else {
            z3 = true;
        }
        int i4 = c5;
        while (i4 < f26766f.length) {
            int c6 = c(i4, sQLiteDatabase, bmVar.sr, true, 0, jSONArrayArr, jArr);
            if (c(jArr)) {
                bVar.c(jSONObject, c(bmVar.sr) ? bmVar : null, null, null, jSONArrayArr, jArr, 0);
                c(bVar, z3, sQLiteDatabase, z3);
            }
            i4 = c6;
        }
    }

    private void c(JSONObject jSONObject, bm bmVar, b bVar, wo woVar, ox oxVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr) {
        be.c("packHistoryData, " + bmVar.sr);
        JSONArray c4 = c(bmVar, true, oxVar, woVar, sQLiteDatabase);
        bmVar.f26709t = c4.length() == 0;
        int c5 = c(0, sQLiteDatabase, bmVar.sr, true, 0, jSONArrayArr, jArr);
        if (bmVar.f26709t) {
            bVar.c(jSONObject, c(bmVar.sr) ? bmVar : null, null, null, jSONArrayArr, jArr, 0);
        } else {
            bVar.c(jSONObject, null, oxVar, c4, jSONArrayArr, jArr, 0);
        }
        c(bVar, true, sQLiteDatabase, true);
        int i4 = c5;
        while (i4 < f26766f.length) {
            int c6 = c(i4, sQLiteDatabase, bmVar.sr, true, 0, jSONArrayArr, jArr);
            if (c(jArr)) {
                bVar.c(jSONObject, null, null, null, jSONArrayArr, jArr, 0);
                c(bVar, true, sQLiteDatabase, true);
            }
            i4 = c6;
        }
    }

    private void c(JSONObject jSONObject, bm bmVar, ox oxVar, wo woVar, b bVar, SQLiteDatabase sQLiteDatabase, String str, JSONArray[] jSONArrayArr, long[] jArr) {
        boolean z3;
        be.c("packLostData, " + str);
        bmVar.sr = str;
        bmVar.f26710u = false;
        bVar.sr = str;
        JSONArray c4 = c(bmVar, false, oxVar, woVar, sQLiteDatabase);
        int c5 = c(0, sQLiteDatabase, str, false, 0, jSONArrayArr, jArr);
        bmVar.f26709t = c4.length() == 0;
        if (c(jArr) || !bmVar.f26709t) {
            boolean z4 = bmVar.f26709t;
            ox oxVar2 = !z4 ? oxVar : null;
            JSONArray jSONArray = !z4 ? c4 : null;
            z3 = true;
            bVar.c(jSONObject, null, oxVar2, jSONArray, jSONArrayArr, jArr, 0);
            c(bVar, false, sQLiteDatabase, true);
        } else {
            z3 = true;
        }
        int i4 = c5;
        while (i4 < f26766f.length) {
            int c6 = c(i4, sQLiteDatabase, str, false, 0, jSONArrayArr, jArr);
            if (c(jArr)) {
                bVar.c(jSONObject, null, null, null, jSONArrayArr, jArr, 0);
                c(bVar, false, sQLiteDatabase, z3);
            }
            i4 = c6;
        }
    }

    private boolean c(long[] jArr) {
        return jArr[0] > 0 || jArr[1] > 0 || jArr[2] > 0;
    }

    public void c(b bVar, boolean z3, SQLiteDatabase sQLiteDatabase, boolean z4) {
        boolean z5;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = this.ux.getWritableDatabase();
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            try {
                sQLiteDatabase.beginTransaction();
            } catch (Throwable th) {
                try {
                    be.w(th);
                    if (!z5) {
                        return;
                    }
                } finally {
                    if (z5) {
                        g.c(sQLiteDatabase);
                    }
                }
            }
        }
        if (z4 && sQLiteDatabase.insert("pack", null, bVar.w((ContentValues) null)) < 0) {
            if (bVar.fz != null) {
                c((String) null);
            }
            if (z5) {
                return;
            }
            return;
        }
        long j4 = bVar.fp;
        if (j4 > 0) {
            sQLiteDatabase.execSQL(c("event", bVar.f26812p, bVar.sr, z3, j4));
        }
        long j5 = bVar.f26697s;
        if (j5 > 0) {
            sQLiteDatabase.execSQL(c("eventv3", bVar.f26812p, bVar.sr, z3, j5));
        }
        long j6 = bVar.f26694i;
        if (j6 > 0) {
            sQLiteDatabase.execSQL(c("event_misc", bVar.f26812p, bVar.sr, z3, j6));
        }
        if (z5) {
            sQLiteDatabase.setTransactionSuccessful();
        }
        if (!z5) {
            return;
        }
        g.c(sQLiteDatabase);
    }

    private int c(int i4, SQLiteDatabase sQLiteDatabase, String str, boolean z3, int i5, JSONArray[] jSONArrayArr, long[] jArr) {
        w.w();
        int i6 = 0;
        while (i6 < i4) {
            jSONArrayArr[i6] = null;
            jArr[i6] = 0;
            i6++;
        }
        int i7 = i6;
        int i8 = 200;
        while (i8 > 0 && i7 < f26766f.length) {
            c(sQLiteDatabase, str, i8, i7, z3, jSONArrayArr, jArr, i5);
            int length = jSONArrayArr[i7].length();
            i8 -= length;
            xv[i7].xv = length;
            if (i8 > 0) {
                i7++;
            }
        }
        for (int i9 = i7 + 1; i9 < jSONArrayArr.length; i9++) {
            jSONArrayArr[i9] = null;
            jArr[i9] = 0;
        }
        return i7;
    }

    private void c(SQLiteDatabase sQLiteDatabase, String str, int i4, int i5, boolean z3, JSONArray[] jSONArrayArr, long[] jArr, int i6) {
        up upVar = f26766f[i5];
        JSONArray jSONArray = new JSONArray();
        Cursor cursor = null;
        long j4 = 0;
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery(c(upVar, str, z3, i4, i6), null);
            for (int i7 = 0; rawQuery.moveToNext() && i7 <= 200; i7++) {
                try {
                    upVar.c(rawQuery);
                    xv[i5].c(upVar);
                    if (be.f26702w) {
                        be.c("queryEvent, " + upVar, null);
                    }
                    jSONArray.put(upVar.f());
                    long j5 = upVar.f26809c;
                    if (j5 > j4) {
                        j4 = j5;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = rawQuery;
                    try {
                        be.w(th);
                        if (cursor != null) {
                            cursor.close();
                        }
                        jSONArrayArr[i5] = jSONArray;
                        jArr[i5] = j4;
                    } catch (Throwable th2) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th2;
                    }
                }
            }
            rawQuery.close();
        } catch (Throwable th3) {
            th = th3;
        }
        jSONArrayArr[i5] = jSONArray;
        jArr[i5] = j4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00dd, code lost:
        if (r12 != null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONArray c(com.bytedance.embedapplog.bm r22, boolean r23, com.bytedance.embedapplog.ox r24, com.bytedance.embedapplog.wo r25, android.database.sqlite.SQLiteDatabase r26) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.mt.c(com.bytedance.embedapplog.bm, boolean, com.bytedance.embedapplog.ox, com.bytedance.embedapplog.wo, android.database.sqlite.SQLiteDatabase):org.json.JSONArray");
    }

    @NonNull
    public ArrayList<b> c() {
        Cursor cursor;
        ArrayList<b> arrayList = new ArrayList<>();
        b bVar = (b) f26767w.get("pack");
        try {
            cursor = this.ux.getWritableDatabase().rawQuery("SELECT * FROM pack ORDER BY _id DESC LIMIT 8", null);
            while (cursor.moveToNext()) {
                try {
                    bVar = (b) bVar.clone();
                    bVar.c(cursor);
                    arrayList.add(bVar);
                } catch (Throwable th) {
                    th = th;
                    try {
                        be.w(th);
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        be.c("queryPack, " + arrayList, null);
        return arrayList;
    }

    public void c(ArrayList<b> arrayList, ArrayList<b> arrayList2, ArrayList<b> arrayList3) {
        SQLiteDatabase writableDatabase;
        SQLiteDatabase sQLiteDatabase = null;
        be.c("setResult, " + arrayList + ", " + arrayList2, null);
        Iterator<b> it = arrayList2.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (!arrayList3.contains(next) && Math.abs(System.currentTimeMillis() - next.f26814w) > 864000000) {
                arrayList.add(next);
                it.remove();
            }
        }
        try {
            writableDatabase = this.ux.getWritableDatabase();
        } catch (Throwable th) {
            th = th;
        }
        try {
            writableDatabase.beginTransaction();
            Iterator<b> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                b next2 = it2.next();
                if (arrayList3.contains(next2)) {
                    c(next2, true, writableDatabase, false);
                } else {
                    writableDatabase.execSQL("DELETE FROM pack WHERE _id=?", new String[]{String.valueOf(next2.f26809c)});
                }
            }
            Iterator<b> it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                b next3 = it3.next();
                if (next3.fz != null) {
                    c((String) null);
                }
                if (!arrayList3.contains(next3)) {
                    long j4 = next3.f26809c;
                    int i4 = next3.bk + 1;
                    next3.bk = i4;
                    writableDatabase.execSQL(c(j4, i4));
                }
            }
            writableDatabase.setTransactionSuccessful();
            g.c(writableDatabase);
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = writableDatabase;
            try {
                be.w(th);
            } finally {
                g.c(sQLiteDatabase);
            }
        }
    }

    public void c(@NonNull ArrayList<up> arrayList) {
        SQLiteDatabase writableDatabase;
        ArrayList arrayList2 = new ArrayList(4);
        ArrayList arrayList3 = new ArrayList(4);
        SQLiteDatabase sQLiteDatabase = null;
        try {
            writableDatabase = this.ux.getWritableDatabase();
        } catch (Throwable th) {
            th = th;
        }
        try {
            writableDatabase.beginTransaction();
            Iterator<up> it = arrayList.iterator();
            ContentValues contentValues = null;
            while (it.hasNext()) {
                up next = it.next();
                String sr = next.sr();
                contentValues = next.w(contentValues);
                next.f26809c = writableDatabase.insert(sr, null, contentValues);
                if ("event".equals(next.sr())) {
                    arrayList3.add(next);
                } else if ("eventv3".equals(next.sr())) {
                    arrayList3.add(next);
                } else if (next instanceof bm) {
                    arrayList2.add((bm) next);
                }
            }
            writableDatabase.setTransactionSuccessful();
            g.c(writableDatabase);
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = writableDatabase;
            try {
                be.w(th);
            } finally {
                g.c(sQLiteDatabase);
            }
        }
    }
}
