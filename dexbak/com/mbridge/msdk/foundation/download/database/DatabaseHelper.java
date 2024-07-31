package com.mbridge.msdk.foundation.download.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import com.mbridge.msdk.foundation.download.core.GlobalComponent;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DatabaseHelper implements IDatabaseHelper {
    private volatile SQLiteDatabase database;
    private IDatabaseOpenHelper databaseOpenHelper;
    private final Handler handler;
    private String tableName = GlobalComponent.getInstance().getDatabaseTableName();

    public DatabaseHelper(Context context, Handler handler, IDatabaseOpenHelper iDatabaseOpenHelper) {
        this.handler = handler;
        this.databaseOpenHelper = iDatabaseOpenHelper;
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void clear() {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.9
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                try {
                    try {
                        try {
                            DatabaseHelper.this.database.beginTransaction();
                            DatabaseHelper.this.database.delete(DatabaseHelper.this.tableName, null, null);
                            DatabaseHelper.this.database.setTransactionSuccessful();
                            DatabaseHelper.this.database.endTransaction();
                        } catch (Throwable th) {
                            try {
                                DatabaseHelper.this.database.endTransaction();
                            } catch (Throwable th2) {
                                SameLogTool.m21733d(IDatabaseHelper.TAG, th2.getMessage());
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        DatabaseHelper.this.database.endTransaction();
                    }
                } catch (Throwable th3) {
                    SameLogTool.m21733d(IDatabaseHelper.TAG, th3.getMessage());
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void find(final String str, final String str2, final IDatabaseHelper.IDatabaseListener iDatabaseListener) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0097  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x009e  */
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r0v1 */
            /* JADX WARN: Type inference failed for: r0v3, types: [android.database.Cursor] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r4 = this;
                    java.lang.String r0 = " = '"
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r1)
                    boolean r1 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r1)
                    if (r1 == 0) goto L1b
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$100(r1)
                    android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$002(r1, r2)
                L1b:
                    r1 = 0
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    r2.<init>()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    java.lang.String r3 = "SELECT * FROM "
                    r2.append(r3)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r3 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    java.lang.String r3 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$200(r3)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    r2.append(r3)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    java.lang.String r3 = " WHERE "
                    r2.append(r3)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    java.lang.String r3 = "download_id"
                    r2.append(r3)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    r2.append(r0)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    java.lang.String r3 = r2     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    r2.append(r3)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    java.lang.String r3 = "' AND "
                    r2.append(r3)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    java.lang.String r3 = "director_path"
                    r2.append(r3)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    r2.append(r0)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    java.lang.String r0 = r3     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    r2.append(r0)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    java.lang.String r0 = "'"
                    r2.append(r0)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    android.database.sqlite.SQLiteDatabase r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    android.database.Cursor r0 = r2.rawQuery(r0, r1)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
                    if (r0 == 0) goto L75
                    boolean r2 = r0.moveToFirst()     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L94
                    if (r2 == 0) goto L75
                    com.mbridge.msdk.foundation.download.database.DownloadModel r1 = com.mbridge.msdk.foundation.download.database.DownloadModel.create(r0)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L94
                    goto L75
                L73:
                    r2 = move-exception
                    goto L84
                L75:
                    if (r0 == 0) goto L7a
                    r0.close()
                L7a:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r4
                    if (r0 == 0) goto L93
                    goto L90
                L7f:
                    r2 = move-exception
                    r0 = r1
                    goto L95
                L82:
                    r2 = move-exception
                    r0 = r1
                L84:
                    r2.printStackTrace()     // Catch: java.lang.Throwable -> L94
                    if (r0 == 0) goto L8c
                    r0.close()
                L8c:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r4
                    if (r0 == 0) goto L93
                L90:
                    r0.onDatabase(r1)
                L93:
                    return
                L94:
                    r2 = move-exception
                L95:
                    if (r0 == 0) goto L9a
                    r0.close()
                L9a:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r4
                    if (r0 == 0) goto La1
                    r0.onDatabase(r1)
                La1:
                    throw r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.database.DatabaseHelper.RunnableC112941.run():void");
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public List<DownloadModel> findAll() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            if (Objects.isNull(this.database)) {
                this.database = this.databaseOpenHelper.getWritableDatabase();
            }
            cursor = rawQuery("SELECT * FROM " + this.tableName, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    arrayList.add(DownloadModel.create(cursor));
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception unused) {
            return arrayList;
        } catch (Throwable unused2) {
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        }
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void findByDownloadUrl(final String str, final IDatabaseHelper.IDatabaseListener iDatabaseListener) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.2
            @Override // java.lang.Runnable
            public void run() {
                Cursor cursor;
                IDatabaseHelper.IDatabaseListener iDatabaseListener2;
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                DownloadModel downloadModel = null;
                try {
                    cursor = DatabaseHelper.this.database.rawQuery("SELECT * FROM " + DatabaseHelper.this.tableName + " WHERE " + DownloadModel.DOWNLOAD_URL + " = '" + str + "'", null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                downloadModel = DownloadModel.create(cursor);
                            }
                        } catch (Exception unused) {
                            if (cursor != null) {
                                cursor.close();
                            }
                            iDatabaseListener2 = iDatabaseListener;
                            if (iDatabaseListener2 == null) {
                                return;
                            }
                            iDatabaseListener2.onDatabase(downloadModel);
                        } catch (Throwable th) {
                            th = th;
                            if (cursor != null) {
                                cursor.close();
                            }
                            IDatabaseHelper.IDatabaseListener iDatabaseListener3 = iDatabaseListener;
                            if (iDatabaseListener3 != null) {
                                iDatabaseListener3.onDatabase(null);
                            }
                            throw th;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    iDatabaseListener2 = iDatabaseListener;
                    if (iDatabaseListener2 == null) {
                        return;
                    }
                } catch (Exception unused2) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                }
                iDatabaseListener2.onDatabase(downloadModel);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x005b, code lost:
        if (r1 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
        if (r1 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0066, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
        return r0;
     */
    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.mbridge.msdk.foundation.download.database.DownloadModel> getUnwantedModels(long r6) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r5.database     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            boolean r2 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r2)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            if (r2 == 0) goto L16
            com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper r2 = r5.databaseOpenHelper     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            r5.database = r2     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
        L16:
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            long r2 = r2 - r6
            android.database.sqlite.SQLiteDatabase r6 = r5.database     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            r7.<init>()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            java.lang.String r4 = "SELECT * FROM "
            r7.append(r4)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            java.lang.String r4 = r5.tableName     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            r7.append(r4)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            java.lang.String r4 = " WHERE "
            r7.append(r4)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            java.lang.String r4 = "last_modified_time"
            r7.append(r4)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            java.lang.String r4 = " <= "
            r7.append(r4)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            r7.append(r2)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            android.database.Cursor r1 = r6.rawQuery(r7, r1)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            if (r1 == 0) goto L5b
            boolean r6 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            if (r6 == 0) goto L5b
        L4e:
            com.mbridge.msdk.foundation.download.database.DownloadModel r6 = com.mbridge.msdk.foundation.download.database.DownloadModel.create(r1)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            r0.add(r6)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            boolean r6 = r1.moveToNext()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            if (r6 != 0) goto L4e
        L5b:
            if (r1 == 0) goto L69
            goto L66
        L5e:
            r6 = move-exception
            goto L6a
        L60:
            r6 = move-exception
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L5e
            if (r1 == 0) goto L69
        L66:
            r1.close()
        L69:
            return r0
        L6a:
            if (r1 == 0) goto L6f
            r1.close()
        L6f:
            goto L71
        L70:
            throw r6
        L71:
            goto L70
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.database.DatabaseHelper.getUnwantedModels(long):java.util.List");
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void insert(final DownloadModel downloadModel) {
        this.handler.postAtFrontOfQueue(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.3
            /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:15:0x005d
                	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1234)
                	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1018)
                	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
                */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x005e -> B:17:0x0065). Please submit an issue!!! */
            @Override // java.lang.Runnable
            public void run() {
                /*
                    r5 = this;
                    java.lang.String r0 = "DatabaseHelper"
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r1)
                    boolean r1 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r1)
                    if (r1 == 0) goto L1b
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$100(r1)
                    android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$002(r1, r2)
                L1b:
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r1)
                    r1.beginTransaction()
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
                    android.database.sqlite.SQLiteDatabase r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r1)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
                    java.lang.String r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$200(r2)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
                    r3 = 0
                    com.mbridge.msdk.foundation.download.database.DownloadModel r4 = r2     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
                    android.content.ContentValues r4 = com.mbridge.msdk.foundation.download.database.DownloadModel.create(r4)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
                    r1.insert(r2, r3, r4)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
                    android.database.sqlite.SQLiteDatabase r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r1)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
                    r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch: java.lang.Throwable -> L5d
                    android.database.sqlite.SQLiteDatabase r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r1)     // Catch: java.lang.Throwable -> L5d
                    r1.endTransaction()     // Catch: java.lang.Throwable -> L5d
                    goto L65
                L4d:
                    r1 = move-exception
                    goto L66
                L4f:
                    r1 = move-exception
                    r1.printStackTrace()     // Catch: java.lang.Throwable -> L4d
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch: java.lang.Throwable -> L5d
                    android.database.sqlite.SQLiteDatabase r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r1)     // Catch: java.lang.Throwable -> L5d
                    r1.endTransaction()     // Catch: java.lang.Throwable -> L5d
                    goto L65
                L5d:
                    r1 = move-exception
                    java.lang.String r1 = r1.getMessage()
                    com.mbridge.msdk.foundation.tools.SameLogTool.m21733d(r0, r1)
                L65:
                    return
                L66:
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch: java.lang.Throwable -> L70
                    android.database.sqlite.SQLiteDatabase r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r2)     // Catch: java.lang.Throwable -> L70
                    r2.endTransaction()     // Catch: java.lang.Throwable -> L70
                    goto L78
                L70:
                    r2 = move-exception
                    java.lang.String r2 = r2.getMessage()
                    com.mbridge.msdk.foundation.tools.SameLogTool.m21733d(r0, r2)
                L78:
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.database.DatabaseHelper.RunnableC112963.run():void");
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public Cursor rawQuery(String str, String[] strArr) {
        try {
            if (Objects.isNull(this.database)) {
                this.database = this.databaseOpenHelper.getWritableDatabase();
            }
            this.database.beginTransaction();
            Cursor rawQuery = this.database.rawQuery(str, strArr);
            this.database.setTransactionSuccessful();
            try {
                this.database.endTransaction();
            } catch (Throwable th) {
                SameLogTool.m21733d(IDatabaseHelper.TAG, th.getMessage());
            }
            return rawQuery;
        } catch (Exception unused) {
            try {
                this.database.endTransaction();
            } catch (Throwable th2) {
                SameLogTool.m21733d(IDatabaseHelper.TAG, th2.getMessage());
            }
            return null;
        } catch (Throwable th3) {
            try {
                this.database.endTransaction();
            } catch (Throwable th4) {
                SameLogTool.m21733d(IDatabaseHelper.TAG, th4.getMessage());
            }
            throw th3;
        }
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void remove(final String str, final String str2) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.6
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                try {
                    SQLiteDatabase sQLiteDatabase = DatabaseHelper.this.database;
                    sQLiteDatabase.execSQL("DELETE FROM " + DatabaseHelper.this.tableName + " WHERE " + DownloadModel.DOWNLOAD_ID + " = '" + str + "' AND " + DownloadModel.DIRECTORY_PATH + " = '" + str2 + "'");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void update(final DownloadModel downloadModel, final String str) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.4
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                try {
                    DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, DownloadModel.create(downloadModel), "download_id = ? AND director_path = ?", new String[]{downloadModel.getDownloadId(), str});
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void updateProgress(final String str, final String str2, final DownloadModel downloadModel) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.5
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                try {
                    DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, DownloadModel.create(downloadModel), "download_id = ? AND director_path = ?", new String[]{str, str2});
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void updateUnzipResource(final String str, String str2, long j) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.8
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(DownloadModel.DOWNLOAD_ID, str);
                SQLiteDatabase sQLiteDatabase = DatabaseHelper.this.database;
                String str3 = DatabaseHelper.this.tableName;
                sQLiteDatabase.update(str3, contentValues, "download_id = '" + str + "'", null);
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void remove(final String str) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.7
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                try {
                    SQLiteDatabase sQLiteDatabase = DatabaseHelper.this.database;
                    sQLiteDatabase.execSQL("DELETE FROM " + DatabaseHelper.this.tableName + " WHERE " + DownloadModel.DOWNLOAD_ID + " = '" + str + "'");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
