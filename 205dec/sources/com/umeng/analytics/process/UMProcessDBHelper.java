package com.umeng.analytics.process;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.analytics.process.DBFileTraversalUtil;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UMProcessDBHelper {
    private static UMProcessDBHelper mInstance;
    private Context mContext;
    private FileLockUtil mFileLock = new FileLockUtil();
    private InsertEventCallback ekvCallBack = new InsertEventCallback();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class InsertEventCallback implements FileLockCallback {
        private InsertEventCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i4) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String str2 = com.umeng.analytics.process.a.f53178c;
            if (str.startsWith(str2)) {
                str = str.replaceFirst(str2, "");
            }
            UMProcessDBHelper.this.insertEvents(str.replace(".db", ""), (JSONArray) obj);
            return true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private class ProcessToMainCallback implements FileLockCallback {
        private ProcessToMainCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i4) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String str2 = com.umeng.analytics.process.a.f53178c;
            if (str.startsWith(str2)) {
                str = str.replaceFirst(str2, "");
            }
            UMProcessDBHelper.this.processToMain(str.replace(".db", ""));
            return true;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        int f53167a;

        /* renamed from: b  reason: collision with root package name */
        String f53168b;

        /* renamed from: c  reason: collision with root package name */
        String f53169c;

        /* renamed from: d  reason: collision with root package name */
        String f53170d;

        /* renamed from: e  reason: collision with root package name */
        int f53171e;

        /* renamed from: f  reason: collision with root package name */
        String f53172f;

        /* renamed from: g  reason: collision with root package name */
        String f53173g;

        /* renamed from: h  reason: collision with root package name */
        String f53174h;

        private a() {
        }
    }

    private UMProcessDBHelper() {
    }

    private List<a> datasAdapter(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                a aVar = new a();
                aVar.f53169c = jSONObject.optString("id");
                aVar.f53173g = UMUtils.getAppVersionName(this.mContext);
                aVar.f53174h = UMUtils.getAppVersionCode(this.mContext);
                aVar.f53168b = jSONObject.optString("__i");
                aVar.f53171e = jSONObject.optInt("__t");
                aVar.f53172f = str;
                if (jSONObject.has("ds")) {
                    jSONObject.remove("ds");
                }
                jSONObject.put("ds", getDataSource());
                jSONObject.remove("__i");
                jSONObject.remove("__t");
                aVar.f53170d = com.umeng.common.a.a().a(jSONObject.toString());
                jSONObject.remove("ds");
                arrayList.add(aVar);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private boolean dbIsExists(String str) {
        try {
            return new File(b.b(this.mContext, str)).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    private int getDataSource() {
        return 0;
    }

    public static UMProcessDBHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UMProcessDBHelper.class) {
                if (mInstance == null) {
                    mInstance = new UMProcessDBHelper(context);
                }
            }
        }
        UMProcessDBHelper uMProcessDBHelper = mInstance;
        uMProcessDBHelper.mContext = context;
        return uMProcessDBHelper;
    }

    private boolean insertEvents_(String str, List<a> list) {
        SQLiteDatabase a4;
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return true;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            a4 = c.a(this.mContext).a(str);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                a4.beginTransaction();
                for (a aVar : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("__i", aVar.f53168b);
                        contentValues.put("__e", aVar.f53169c);
                        contentValues.put("__t", Integer.valueOf(aVar.f53171e));
                        contentValues.put("__pn", aVar.f53172f);
                        contentValues.put("__av", aVar.f53173g);
                        contentValues.put("__vc", aVar.f53174h);
                        contentValues.put("__s", aVar.f53170d);
                        a4.insert("__et_p", null, contentValues);
                    } catch (Exception unused2) {
                    }
                }
                a4.setTransactionSuccessful();
                try {
                    a4.endTransaction();
                } catch (Throwable unused3) {
                }
                c.a(this.mContext).b(str);
                return true;
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = a4;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused4) {
                    }
                }
                c.a(this.mContext).b(str);
                throw th;
            }
        } catch (Exception unused5) {
            sQLiteDatabase = a4;
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused6) {
                }
            }
            c.a(this.mContext).b(str);
            return false;
        }
    }

    private boolean processIsService(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, this.mContext.getClass()), 0) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processToMain(String str) {
        if (dbIsExists(str)) {
            List<a> readEventByProcess = readEventByProcess(str);
            if (!readEventByProcess.isEmpty() && insertEvents_("_main_", readEventByProcess)) {
                deleteEventDatas(str, null, readEventByProcess);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00aa, code lost:
        if (r2 != null) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c2 A[Catch: Exception -> 0x00c5, TRY_LEAVE, TryCatch #6 {Exception -> 0x00c5, blocks: (B:33:0x00bd, B:35:0x00c2), top: B:46:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> readEventByProcess(java.lang.String r13) {
        /*
            r12 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.content.Context r2 = r12.mContext     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9e
            com.umeng.analytics.process.c r2 = com.umeng.analytics.process.c.a(r2)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9e
            android.database.sqlite.SQLiteDatabase r2 = r2.a(r13)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9e
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
            java.lang.String r4 = "__et_p"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r2
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
            if (r3 == 0) goto L8e
        L22:
            boolean r4 = r3.moveToNext()     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            if (r4 == 0) goto L8e
            com.umeng.analytics.process.UMProcessDBHelper$a r4 = new com.umeng.analytics.process.UMProcessDBHelper$a     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            r4.<init>()     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            r5 = 0
            int r5 = r3.getInt(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            r4.f53167a = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            java.lang.String r5 = "__i"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            r4.f53168b = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            java.lang.String r5 = "__e"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            r4.f53169c = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            java.lang.String r5 = "__s"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            r4.f53170d = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            java.lang.String r5 = "__t"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            int r5 = r3.getInt(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            r4.f53171e = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            java.lang.String r5 = "__pn"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            r4.f53172f = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            java.lang.String r5 = "__av"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            r4.f53173g = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            java.lang.String r5 = "__vc"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            r4.f53174h = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            r0.add(r4)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lb9
            goto L22
        L8c:
            r1 = move-exception
            goto La2
        L8e:
            if (r3 == 0) goto Lac
            r3.close()     // Catch: java.lang.Exception -> Laf
            goto Lac
        L94:
            r0 = move-exception
            goto Lbb
        L96:
            r3 = move-exception
            r11 = r3
            r3 = r1
            r1 = r11
            goto La2
        L9b:
            r0 = move-exception
            r2 = r1
            goto Lbb
        L9e:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
        La2:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> Lb9
            if (r3 == 0) goto Laa
            r3.close()     // Catch: java.lang.Exception -> Laf
        Laa:
            if (r2 == 0) goto Laf
        Lac:
            r2.endTransaction()     // Catch: java.lang.Exception -> Laf
        Laf:
            android.content.Context r1 = r12.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.c.a(r1)
            r1.b(r13)
            return r0
        Lb9:
            r0 = move-exception
            r1 = r3
        Lbb:
            if (r1 == 0) goto Lc0
            r1.close()     // Catch: java.lang.Exception -> Lc5
        Lc0:
            if (r2 == 0) goto Lc5
            r2.endTransaction()     // Catch: java.lang.Exception -> Lc5
        Lc5:
            android.content.Context r1 = r12.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.c.a(r1)
            r1.b(r13)
            goto Ld0
        Lcf:
            throw r0
        Ld0:
            goto Lcf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readEventByProcess(java.lang.String):java.util.List");
    }

    public void createDBByProcess(String str) {
        try {
            c.a(this.mContext).a(str);
            c.a(this.mContext).b(str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void deleteEventDatas(String str, String str2, List<a> list) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a(str);
            try {
                sQLiteDatabase.beginTransaction();
                int size = list.size();
                if (size > 0) {
                    for (int i4 = 0; i4 < size; i4++) {
                        sQLiteDatabase.execSQL("delete from __et_p where rowid=" + list.get(i4).f53167a);
                    }
                } else {
                    sQLiteDatabase.delete("__et_p", null, null);
                }
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
            } catch (Exception unused) {
                sQLiteDatabase2 = sQLiteDatabase;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.endTransaction();
                }
                c.a(this.mContext).b(str);
            } catch (Throwable th2) {
                th = th2;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                c.a(this.mContext).b(str);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            sQLiteDatabase = null;
            th = th3;
        }
        c.a(this.mContext).b(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        if (r1 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void deleteMainProcessEventDatasByIds(java.util.List<java.lang.Integer> r8) {
        /*
            r7 = this;
            java.lang.String r0 = "_main_"
            r1 = 0
            android.content.Context r2 = r7.mContext     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L46
            com.umeng.analytics.process.c r2 = com.umeng.analytics.process.c.a(r2)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L46
            android.database.sqlite.SQLiteDatabase r1 = r2.a(r0)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L46
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L46
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L46
        L14:
            boolean r2 = r8.hasNext()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L46
            if (r2 == 0) goto L32
            java.lang.Object r2 = r8.next()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L46
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L46
            java.lang.String r3 = "__et_p"
            java.lang.String r4 = "id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L46
            r6 = 0
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L46
            r5[r6] = r2     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L46
            r1.delete(r3, r4, r5)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L46
            goto L14
        L32:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L46
            goto L49
        L36:
            r8 = move-exception
            if (r1 == 0) goto L3c
            r1.endTransaction()
        L3c:
            android.content.Context r1 = r7.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.c.a(r1)
            r1.b(r0)
            throw r8
        L46:
            if (r1 == 0) goto L4c
        L49:
            r1.endTransaction()
        L4c:
            android.content.Context r8 = r7.mContext
            com.umeng.analytics.process.c r8 = com.umeng.analytics.process.c.a(r8)
            r8.b(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.deleteMainProcessEventDatasByIds(java.util.List):void");
    }

    public void insertEvents(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            insertEvents_(str, datasAdapter(str, jSONArray));
        }
    }

    public void insertEventsInSubProcess(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            File file = new File(b.b(this.mContext, str));
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this.ekvCallBack, jSONArray);
            } else {
                insertEvents(str, jSONArray);
            }
        }
    }

    public void processDBToMain() {
        try {
            DBFileTraversalUtil.traverseDBFiles(b.a(this.mContext), new ProcessToMainCallback(), new DBFileTraversalUtil.a() { // from class: com.umeng.analytics.process.UMProcessDBHelper.1
                @Override // com.umeng.analytics.process.DBFileTraversalUtil.a
                public void a() {
                    if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                        UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, 36946, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), null);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0187 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject readMainEvents(long r20, java.util.List<java.lang.Integer> r22) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readMainEvents(long, java.util.List):org.json.JSONObject");
    }

    public JSONObject readVersionInfoFromColumId(Integer num) {
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        Cursor cursor = null;
        r3 = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        cursor = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a("_main_");
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    Cursor query = sQLiteDatabase.query("__et_p", null, "rowid=?", new String[]{String.valueOf(num)}, null, null, null);
                    if (query != null) {
                        try {
                            try {
                                if (query.moveToNext()) {
                                    jSONObject = new JSONObject();
                                    try {
                                        String string = query.getString(query.getColumnIndex("__av"));
                                        String string2 = query.getString(query.getColumnIndex("__vc"));
                                        if (!TextUtils.isEmpty(string)) {
                                            jSONObject.put("__av", string);
                                        }
                                        if (!TextUtils.isEmpty(string2)) {
                                            jSONObject.put("__vc", string2);
                                        }
                                        jSONObject2 = jSONObject;
                                    } catch (Exception e4) {
                                        e = e4;
                                        cursor = query;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception unused) {
                                                c.a(this.mContext).b("_main_");
                                                return jSONObject;
                                            }
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                        c.a(this.mContext).b("_main_");
                                        return jSONObject;
                                    }
                                }
                            } catch (Exception e5) {
                                e = e5;
                                jSONObject = null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = query;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception unused2) {
                                    c.a(this.mContext).b("_main_");
                                    throw th;
                                }
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            c.a(this.mContext).b("_main_");
                            throw th;
                        }
                    }
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Exception unused3) {
                        }
                    }
                    sQLiteDatabase.endTransaction();
                    c.a(this.mContext).b("_main_");
                    return jSONObject2;
                } catch (Exception e6) {
                    e = e6;
                    jSONObject = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e7) {
            e = e7;
            sQLiteDatabase = null;
            jSONObject = null;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
    }

    private UMProcessDBHelper(Context context) {
        com.umeng.common.a.a().a(context);
    }
}
