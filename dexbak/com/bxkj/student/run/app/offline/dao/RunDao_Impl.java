package com.bxkj.student.run.app.offline.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.p021db.SupportSQLiteStatement;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.umeng.analytics.AnalyticsConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class RunDao_Impl implements RunDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<RunDb> __deletionAdapterOfRunDb;
    private final EntityInsertionAdapter<RunDb> __insertionAdapterOfRunDb;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByIdentify;
    private final SharedSQLiteStatement __preparedStmtOfUpdateSports;

    public RunDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfRunDb = new EntityInsertionAdapter<RunDb>(__db) { // from class: com.bxkj.student.run.app.offline.dao.RunDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `runDb` (`identify`,`userNumber`,`sportsType`,`sportsSet`,`startTime`,`endTime`,`countTime`,`distance`,`latLngList`,`stepList`,`passLatLngList`,`points`,`isFaceOut`,`faceDetectCount`,`uploadType`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, RunDb value) {
                if (value.getIdentify() == null) {
                    stmt.bindNull(1);
                } else {
                    stmt.bindString(1, value.getIdentify());
                }
                if (value.getUserNumber() == null) {
                    stmt.bindNull(2);
                } else {
                    stmt.bindString(2, value.getUserNumber());
                }
                if (value.getSportsType() == null) {
                    stmt.bindNull(3);
                } else {
                    stmt.bindString(3, value.getSportsType());
                }
                if (value.getSportsSet() == null) {
                    stmt.bindNull(4);
                } else {
                    stmt.bindString(4, value.getSportsSet());
                }
                if (value.getStartTime() == null) {
                    stmt.bindNull(5);
                } else {
                    stmt.bindString(5, value.getStartTime());
                }
                if (value.getEndTime() == null) {
                    stmt.bindNull(6);
                } else {
                    stmt.bindString(6, value.getEndTime());
                }
                if (value.getCountTime() == null) {
                    stmt.bindNull(7);
                } else {
                    stmt.bindString(7, value.getCountTime());
                }
                if (value.getDistance() == null) {
                    stmt.bindNull(8);
                } else {
                    stmt.bindString(8, value.getDistance());
                }
                if (value.getLatLngList() == null) {
                    stmt.bindNull(9);
                } else {
                    stmt.bindString(9, value.getLatLngList());
                }
                if (value.getStepList() == null) {
                    stmt.bindNull(10);
                } else {
                    stmt.bindString(10, value.getStepList());
                }
                if (value.getPassLatLngList() == null) {
                    stmt.bindNull(11);
                } else {
                    stmt.bindString(11, value.getPassLatLngList());
                }
                if (value.getUserPassPointList() == null) {
                    stmt.bindNull(12);
                } else {
                    stmt.bindString(12, value.getUserPassPointList());
                }
                if (value.isFaceOut() == null) {
                    stmt.bindNull(13);
                } else {
                    stmt.bindString(13, value.isFaceOut());
                }
                if (value.getFaceDetectCount() == null) {
                    stmt.bindNull(14);
                } else {
                    stmt.bindString(14, value.getFaceDetectCount());
                }
                if (value.getUploadType() == null) {
                    stmt.bindNull(15);
                } else {
                    stmt.bindString(15, value.getUploadType());
                }
            }
        };
        this.__deletionAdapterOfRunDb = new EntityDeletionOrUpdateAdapter<RunDb>(__db) { // from class: com.bxkj.student.run.app.offline.dao.RunDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `runDb` WHERE `identify` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement stmt, RunDb value) {
                if (value.getIdentify() == null) {
                    stmt.bindNull(1);
                } else {
                    stmt.bindString(1, value.getIdentify());
                }
            }
        };
        this.__preparedStmtOfDeleteByIdentify = new SharedSQLiteStatement(__db) { // from class: com.bxkj.student.run.app.offline.dao.RunDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM runDb WHERE identify=?";
            }
        };
        this.__preparedStmtOfUpdateSports = new SharedSQLiteStatement(__db) { // from class: com.bxkj.student.run.app.offline.dao.RunDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE runDb SET endTime=?,uploadType=? WHERE identify=?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.bxkj.student.run.app.offline.dao.RunDao
    public Object deleteByIdentify(final String identify, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bxkj.student.run.app.offline.dao.RunDao_Impl.7
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = RunDao_Impl.this.__preparedStmtOfDeleteByIdentify.acquire();
                String str = identify;
                if (str == null) {
                    acquire.bindNull(1);
                } else {
                    acquire.bindString(1, str);
                }
                RunDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    RunDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.f41048a;
                } finally {
                    RunDao_Impl.this.__db.endTransaction();
                    RunDao_Impl.this.__preparedStmtOfDeleteByIdentify.release(acquire);
                }
            }
        }, continuation);
    }

    @Override // com.bxkj.student.run.app.offline.dao.RunDao
    public Object deleteSports(final RunDb runDb, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bxkj.student.run.app.offline.dao.RunDao_Impl.6
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                RunDao_Impl.this.__db.beginTransaction();
                try {
                    RunDao_Impl.this.__deletionAdapterOfRunDb.handle(runDb);
                    RunDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.f41048a;
                } finally {
                    RunDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.bxkj.student.run.app.offline.dao.RunDao
    public Object getExceptionSports(final String userNumber, final InterfaceC14268c<? super List<RunDb>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM runDb WHERE userNumber = ? AND uploadType =='-1'", 1);
        if (userNumber == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, userNumber);
        }
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<RunDb>>() { // from class: com.bxkj.student.run.app.offline.dao.RunDao_Impl.10
            @Override // java.util.concurrent.Callable
            public List<RunDb> call() throws Exception {
                CallableC528710 callableC528710;
                int columnIndexOrThrow;
                int columnIndexOrThrow2;
                int columnIndexOrThrow3;
                int columnIndexOrThrow4;
                int columnIndexOrThrow5;
                int columnIndexOrThrow6;
                int columnIndexOrThrow7;
                int columnIndexOrThrow8;
                int columnIndexOrThrow9;
                int columnIndexOrThrow10;
                int columnIndexOrThrow11;
                int columnIndexOrThrow12;
                int columnIndexOrThrow13;
                int columnIndexOrThrow14;
                String string;
                int i;
                String string2;
                int i2;
                Cursor query = DBUtil.query(RunDao_Impl.this.__db, acquire, false, null);
                try {
                    columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "identify");
                    columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "userNumber");
                    columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "sportsType");
                    columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "sportsSet");
                    columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, AnalyticsConfig.RTD_START_TIME);
                    columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "endTime");
                    columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "countTime");
                    columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "distance");
                    columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "latLngList");
                    columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "stepList");
                    columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "passLatLngList");
                    columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "points");
                    columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "isFaceOut");
                    columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "faceDetectCount");
                } catch (Throwable th) {
                    th = th;
                    callableC528710 = this;
                }
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "uploadType");
                    int i3 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string3 = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                        String string4 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        String string5 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                        String string6 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                        String string7 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                        String string8 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                        String string9 = query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7);
                        String string10 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                        String string11 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                        String string12 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                        String string13 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                        String string14 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                        if (query.isNull(columnIndexOrThrow13)) {
                            i = i3;
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow13);
                            i = i3;
                        }
                        String string15 = query.isNull(i) ? null : query.getString(i);
                        int i4 = columnIndexOrThrow15;
                        int i5 = columnIndexOrThrow;
                        if (query.isNull(i4)) {
                            i2 = i4;
                            string2 = null;
                        } else {
                            string2 = query.getString(i4);
                            i2 = i4;
                        }
                        arrayList.add(new RunDb(string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string, string15, string2));
                        columnIndexOrThrow = i5;
                        columnIndexOrThrow15 = i2;
                        i3 = i;
                    }
                    query.close();
                    acquire.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    callableC528710 = this;
                    query.close();
                    acquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    @Override // com.bxkj.student.run.app.offline.dao.RunDao
    public Object getLocalRecordById(final String identify, final InterfaceC14268c<? super List<RunDb>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM runDb WHERE identify = ?", 1);
        if (identify == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, identify);
        }
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<RunDb>>() { // from class: com.bxkj.student.run.app.offline.dao.RunDao_Impl.9
            @Override // java.util.concurrent.Callable
            public List<RunDb> call() throws Exception {
                CallableC52979 callableC52979;
                int columnIndexOrThrow;
                int columnIndexOrThrow2;
                int columnIndexOrThrow3;
                int columnIndexOrThrow4;
                int columnIndexOrThrow5;
                int columnIndexOrThrow6;
                int columnIndexOrThrow7;
                int columnIndexOrThrow8;
                int columnIndexOrThrow9;
                int columnIndexOrThrow10;
                int columnIndexOrThrow11;
                int columnIndexOrThrow12;
                int columnIndexOrThrow13;
                int columnIndexOrThrow14;
                String string;
                int i;
                String string2;
                int i2;
                Cursor query = DBUtil.query(RunDao_Impl.this.__db, acquire, false, null);
                try {
                    columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "identify");
                    columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "userNumber");
                    columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "sportsType");
                    columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "sportsSet");
                    columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, AnalyticsConfig.RTD_START_TIME);
                    columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "endTime");
                    columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "countTime");
                    columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "distance");
                    columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "latLngList");
                    columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "stepList");
                    columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "passLatLngList");
                    columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "points");
                    columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "isFaceOut");
                    columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "faceDetectCount");
                } catch (Throwable th) {
                    th = th;
                    callableC52979 = this;
                }
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "uploadType");
                    int i3 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string3 = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                        String string4 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        String string5 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                        String string6 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                        String string7 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                        String string8 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                        String string9 = query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7);
                        String string10 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                        String string11 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                        String string12 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                        String string13 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                        String string14 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                        if (query.isNull(columnIndexOrThrow13)) {
                            i = i3;
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow13);
                            i = i3;
                        }
                        String string15 = query.isNull(i) ? null : query.getString(i);
                        int i4 = columnIndexOrThrow15;
                        int i5 = columnIndexOrThrow;
                        if (query.isNull(i4)) {
                            i2 = i4;
                            string2 = null;
                        } else {
                            string2 = query.getString(i4);
                            i2 = i4;
                        }
                        arrayList.add(new RunDb(string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string, string15, string2));
                        columnIndexOrThrow = i5;
                        columnIndexOrThrow15 = i2;
                        i3 = i;
                    }
                    query.close();
                    acquire.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    callableC52979 = this;
                    query.close();
                    acquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    @Override // com.bxkj.student.run.app.offline.dao.RunDao
    public Object getUploadFailSports(final String userNumber, final InterfaceC14268c<? super List<RunDb>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM runDb WHERE userNumber = ? AND uploadType !='-1'", 1);
        if (userNumber == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, userNumber);
        }
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<RunDb>>() { // from class: com.bxkj.student.run.app.offline.dao.RunDao_Impl.11
            @Override // java.util.concurrent.Callable
            public List<RunDb> call() throws Exception {
                CallableC528811 callableC528811;
                int columnIndexOrThrow;
                int columnIndexOrThrow2;
                int columnIndexOrThrow3;
                int columnIndexOrThrow4;
                int columnIndexOrThrow5;
                int columnIndexOrThrow6;
                int columnIndexOrThrow7;
                int columnIndexOrThrow8;
                int columnIndexOrThrow9;
                int columnIndexOrThrow10;
                int columnIndexOrThrow11;
                int columnIndexOrThrow12;
                int columnIndexOrThrow13;
                int columnIndexOrThrow14;
                String string;
                int i;
                String string2;
                int i2;
                Cursor query = DBUtil.query(RunDao_Impl.this.__db, acquire, false, null);
                try {
                    columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "identify");
                    columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "userNumber");
                    columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "sportsType");
                    columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "sportsSet");
                    columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, AnalyticsConfig.RTD_START_TIME);
                    columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "endTime");
                    columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "countTime");
                    columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "distance");
                    columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "latLngList");
                    columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "stepList");
                    columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "passLatLngList");
                    columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "points");
                    columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "isFaceOut");
                    columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "faceDetectCount");
                } catch (Throwable th) {
                    th = th;
                    callableC528811 = this;
                }
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "uploadType");
                    int i3 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string3 = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                        String string4 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        String string5 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                        String string6 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                        String string7 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                        String string8 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                        String string9 = query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7);
                        String string10 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                        String string11 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                        String string12 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                        String string13 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                        String string14 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                        if (query.isNull(columnIndexOrThrow13)) {
                            i = i3;
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow13);
                            i = i3;
                        }
                        String string15 = query.isNull(i) ? null : query.getString(i);
                        int i4 = columnIndexOrThrow15;
                        int i5 = columnIndexOrThrow;
                        if (query.isNull(i4)) {
                            i2 = i4;
                            string2 = null;
                        } else {
                            string2 = query.getString(i4);
                            i2 = i4;
                        }
                        arrayList.add(new RunDb(string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string, string15, string2));
                        columnIndexOrThrow = i5;
                        columnIndexOrThrow15 = i2;
                        i3 = i;
                    }
                    query.close();
                    acquire.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    callableC528811 = this;
                    query.close();
                    acquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    @Override // com.bxkj.student.run.app.offline.dao.RunDao
    public Object getUploadFailSportsByType(final String userNumber, final int sportsType, final InterfaceC14268c<? super List<RunDb>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM runDb WHERE userNumber = ? AND uploadType !='-1' AND sportsType=?", 2);
        if (userNumber == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, userNumber);
        }
        acquire.bindLong(2, sportsType);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<RunDb>>() { // from class: com.bxkj.student.run.app.offline.dao.RunDao_Impl.12
            @Override // java.util.concurrent.Callable
            public List<RunDb> call() throws Exception {
                CallableC528912 callableC528912;
                int columnIndexOrThrow;
                int columnIndexOrThrow2;
                int columnIndexOrThrow3;
                int columnIndexOrThrow4;
                int columnIndexOrThrow5;
                int columnIndexOrThrow6;
                int columnIndexOrThrow7;
                int columnIndexOrThrow8;
                int columnIndexOrThrow9;
                int columnIndexOrThrow10;
                int columnIndexOrThrow11;
                int columnIndexOrThrow12;
                int columnIndexOrThrow13;
                int columnIndexOrThrow14;
                String string;
                int i;
                String string2;
                int i2;
                Cursor query = DBUtil.query(RunDao_Impl.this.__db, acquire, false, null);
                try {
                    columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "identify");
                    columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "userNumber");
                    columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "sportsType");
                    columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "sportsSet");
                    columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, AnalyticsConfig.RTD_START_TIME);
                    columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "endTime");
                    columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "countTime");
                    columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "distance");
                    columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "latLngList");
                    columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "stepList");
                    columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "passLatLngList");
                    columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "points");
                    columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "isFaceOut");
                    columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "faceDetectCount");
                } catch (Throwable th) {
                    th = th;
                    callableC528912 = this;
                }
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "uploadType");
                    int i3 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string3 = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                        String string4 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        String string5 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                        String string6 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                        String string7 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                        String string8 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                        String string9 = query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7);
                        String string10 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                        String string11 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                        String string12 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                        String string13 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                        String string14 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                        if (query.isNull(columnIndexOrThrow13)) {
                            i = i3;
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow13);
                            i = i3;
                        }
                        String string15 = query.isNull(i) ? null : query.getString(i);
                        int i4 = columnIndexOrThrow15;
                        int i5 = columnIndexOrThrow;
                        if (query.isNull(i4)) {
                            i2 = i4;
                            string2 = null;
                        } else {
                            string2 = query.getString(i4);
                            i2 = i4;
                        }
                        arrayList.add(new RunDb(string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string, string15, string2));
                        columnIndexOrThrow = i5;
                        columnIndexOrThrow15 = i2;
                        i3 = i;
                    }
                    query.close();
                    acquire.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    callableC528912 = this;
                    query.close();
                    acquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    @Override // com.bxkj.student.run.app.offline.dao.RunDao
    public Object insertRun(final RunDb[] runDb, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bxkj.student.run.app.offline.dao.RunDao_Impl.5
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                RunDao_Impl.this.__db.beginTransaction();
                try {
                    RunDao_Impl.this.__insertionAdapterOfRunDb.insert((Object[]) runDb);
                    RunDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.f41048a;
                } finally {
                    RunDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.bxkj.student.run.app.offline.dao.RunDao
    public Object updateSports(final String endTime, final String uploadType, final String identify, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bxkj.student.run.app.offline.dao.RunDao_Impl.8
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = RunDao_Impl.this.__preparedStmtOfUpdateSports.acquire();
                String str = endTime;
                if (str == null) {
                    acquire.bindNull(1);
                } else {
                    acquire.bindString(1, str);
                }
                String str2 = uploadType;
                if (str2 == null) {
                    acquire.bindNull(2);
                } else {
                    acquire.bindString(2, str2);
                }
                String str3 = identify;
                if (str3 == null) {
                    acquire.bindNull(3);
                } else {
                    acquire.bindString(3, str3);
                }
                RunDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    RunDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.f41048a;
                } finally {
                    RunDao_Impl.this.__db.endTransaction();
                    RunDao_Impl.this.__preparedStmtOfUpdateSports.release(acquire);
                }
            }
        }, continuation);
    }
}
