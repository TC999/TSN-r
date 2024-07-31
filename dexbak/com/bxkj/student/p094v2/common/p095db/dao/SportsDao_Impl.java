package com.bxkj.student.p094v2.common.p095db.dao;

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
import com.umeng.analytics.AnalyticsConfig;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import p023b0.CountDistanceTime;
import p027c0.SportsDb;

/* renamed from: com.bxkj.student.v2.common.db.dao.f */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SportsDao_Impl implements SportsDao {

    /* renamed from: a */
    private final RoomDatabase f20006a;

    /* renamed from: b */
    private final EntityInsertionAdapter<SportsDb> f20007b;

    /* renamed from: c */
    private final EntityDeletionOrUpdateAdapter<SportsDb> f20008c;

    /* renamed from: d */
    private final SharedSQLiteStatement f20009d;

    /* renamed from: e */
    private final SharedSQLiteStatement f20010e;

    /* renamed from: f */
    private final SharedSQLiteStatement f20011f;

    /* renamed from: g */
    private final SharedSQLiteStatement f20012g;

    /* renamed from: h */
    private final SharedSQLiteStatement f20013h;

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5511a implements Callable<Unit> {

        /* renamed from: a */
        final /* synthetic */ String f20014a;

        /* renamed from: b */
        final /* synthetic */ String f20015b;

        /* renamed from: c */
        final /* synthetic */ String f20016c;

        /* renamed from: d */
        final /* synthetic */ String f20017d;

        /* renamed from: e */
        final /* synthetic */ String f20018e;

        /* renamed from: f */
        final /* synthetic */ String f20019f;

        /* renamed from: g */
        final /* synthetic */ String f20020g;

        /* renamed from: h */
        final /* synthetic */ String f20021h;

        /* renamed from: i */
        final /* synthetic */ String f20022i;

        /* renamed from: j */
        final /* synthetic */ String f20023j;

        /* renamed from: k */
        final /* synthetic */ String f20024k;

        /* renamed from: l */
        final /* synthetic */ String f20025l;

        CallableC5511a(final String val$countTime, final String val$distance, final String val$gpsDistance, final String val$latLngList, final String val$stepList, final String val$passLatLngList, final String val$isFaceOut, final String val$faceDetectCount, final String val$faceCheckingDistance, final String val$pauseLatLng, final String val$isOpenDevelop, final String val$identify) {
            this.f20014a = val$countTime;
            this.f20015b = val$distance;
            this.f20016c = val$gpsDistance;
            this.f20017d = val$latLngList;
            this.f20018e = val$stepList;
            this.f20019f = val$passLatLngList;
            this.f20020g = val$isFaceOut;
            this.f20021h = val$faceDetectCount;
            this.f20022i = val$faceCheckingDistance;
            this.f20023j = val$pauseLatLng;
            this.f20024k = val$isOpenDevelop;
            this.f20025l = val$identify;
        }

        @Override // java.util.concurrent.Callable
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = SportsDao_Impl.this.f20009d.acquire();
            String str = this.f20014a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            String str2 = this.f20015b;
            if (str2 == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindString(2, str2);
            }
            String str3 = this.f20016c;
            if (str3 == null) {
                acquire.bindNull(3);
            } else {
                acquire.bindString(3, str3);
            }
            String str4 = this.f20017d;
            if (str4 == null) {
                acquire.bindNull(4);
            } else {
                acquire.bindString(4, str4);
            }
            String str5 = this.f20018e;
            if (str5 == null) {
                acquire.bindNull(5);
            } else {
                acquire.bindString(5, str5);
            }
            String str6 = this.f20019f;
            if (str6 == null) {
                acquire.bindNull(6);
            } else {
                acquire.bindString(6, str6);
            }
            String str7 = this.f20020g;
            if (str7 == null) {
                acquire.bindNull(7);
            } else {
                acquire.bindString(7, str7);
            }
            String str8 = this.f20021h;
            if (str8 == null) {
                acquire.bindNull(8);
            } else {
                acquire.bindString(8, str8);
            }
            String str9 = this.f20022i;
            if (str9 == null) {
                acquire.bindNull(9);
            } else {
                acquire.bindString(9, str9);
            }
            String str10 = this.f20023j;
            if (str10 == null) {
                acquire.bindNull(10);
            } else {
                acquire.bindString(10, str10);
            }
            String str11 = this.f20024k;
            if (str11 == null) {
                acquire.bindNull(11);
            } else {
                acquire.bindString(11, str11);
            }
            String str12 = this.f20025l;
            if (str12 == null) {
                acquire.bindNull(12);
            } else {
                acquire.bindString(12, str12);
            }
            SportsDao_Impl.this.f20006a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                SportsDao_Impl.this.f20006a.setTransactionSuccessful();
                return Unit.f41048a;
            } finally {
                SportsDao_Impl.this.f20006a.endTransaction();
                SportsDao_Impl.this.f20009d.release(acquire);
            }
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5512b implements Callable<Unit> {

        /* renamed from: a */
        final /* synthetic */ String f20027a;

        CallableC5512b(final String val$identify) {
            this.f20027a = val$identify;
        }

        @Override // java.util.concurrent.Callable
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = SportsDao_Impl.this.f20010e.acquire();
            String str = this.f20027a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            SportsDao_Impl.this.f20006a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                SportsDao_Impl.this.f20006a.setTransactionSuccessful();
                return Unit.f41048a;
            } finally {
                SportsDao_Impl.this.f20006a.endTransaction();
                SportsDao_Impl.this.f20010e.release(acquire);
            }
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5513c implements Callable<Unit> {

        /* renamed from: a */
        final /* synthetic */ String f20029a;

        /* renamed from: b */
        final /* synthetic */ String f20030b;

        CallableC5513c(final String val$uploadType, final String val$identify) {
            this.f20029a = val$uploadType;
            this.f20030b = val$identify;
        }

        @Override // java.util.concurrent.Callable
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = SportsDao_Impl.this.f20011f.acquire();
            String str = this.f20029a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            String str2 = this.f20030b;
            if (str2 == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindString(2, str2);
            }
            SportsDao_Impl.this.f20006a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                SportsDao_Impl.this.f20006a.setTransactionSuccessful();
                return Unit.f41048a;
            } finally {
                SportsDao_Impl.this.f20006a.endTransaction();
                SportsDao_Impl.this.f20011f.release(acquire);
            }
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5514d implements Callable<Unit> {

        /* renamed from: a */
        final /* synthetic */ String f20032a;

        /* renamed from: b */
        final /* synthetic */ String f20033b;

        /* renamed from: c */
        final /* synthetic */ String f20034c;

        /* renamed from: d */
        final /* synthetic */ String f20035d;

        CallableC5514d(final String val$isException, final String val$isValid, final String val$endTime, final String val$identify) {
            this.f20032a = val$isException;
            this.f20033b = val$isValid;
            this.f20034c = val$endTime;
            this.f20035d = val$identify;
        }

        @Override // java.util.concurrent.Callable
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = SportsDao_Impl.this.f20012g.acquire();
            String str = this.f20032a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            String str2 = this.f20033b;
            if (str2 == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindString(2, str2);
            }
            String str3 = this.f20034c;
            if (str3 == null) {
                acquire.bindNull(3);
            } else {
                acquire.bindString(3, str3);
            }
            String str4 = this.f20035d;
            if (str4 == null) {
                acquire.bindNull(4);
            } else {
                acquire.bindString(4, str4);
            }
            SportsDao_Impl.this.f20006a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                SportsDao_Impl.this.f20006a.setTransactionSuccessful();
                return Unit.f41048a;
            } finally {
                SportsDao_Impl.this.f20006a.endTransaction();
                SportsDao_Impl.this.f20012g.release(acquire);
            }
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5515e implements Callable<Unit> {

        /* renamed from: a */
        final /* synthetic */ String f20037a;

        /* renamed from: b */
        final /* synthetic */ String f20038b;

        CallableC5515e(final String val$isValid, final String val$identify) {
            this.f20037a = val$isValid;
            this.f20038b = val$identify;
        }

        @Override // java.util.concurrent.Callable
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = SportsDao_Impl.this.f20013h.acquire();
            String str = this.f20037a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            String str2 = this.f20038b;
            if (str2 == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindString(2, str2);
            }
            SportsDao_Impl.this.f20006a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                SportsDao_Impl.this.f20006a.setTransactionSuccessful();
                return Unit.f41048a;
            } finally {
                SportsDao_Impl.this.f20006a.endTransaction();
                SportsDao_Impl.this.f20013h.release(acquire);
            }
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5516f implements Callable<List<SportsDb>> {

        /* renamed from: a */
        final /* synthetic */ RoomSQLiteQuery f20040a;

        CallableC5516f(final RoomSQLiteQuery val$_statement) {
            this.f20040a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<SportsDb> call() throws Exception {
            CallableC5516f callableC5516f;
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
            Cursor query = DBUtil.query(SportsDao_Impl.this.f20006a, this.f20040a, false, null);
            try {
                columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "identify");
                columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "userNumber");
                columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "sportsType");
                columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "sportsSet");
                columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, AnalyticsConfig.RTD_START_TIME);
                columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "endTime");
                columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "countTime");
                columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "distance");
                columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "gpsDistance");
                columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "latLngList");
                columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "stepList");
                columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "passLatLngList");
                columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "isFaceOut");
                columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "faceDetectCount");
            } catch (Throwable th) {
                th = th;
                callableC5516f = this;
            }
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "uploadType");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "isException");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "startFace");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "midFace");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "endFace");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "isValid");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "faceCheckingDistance");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "pauseLatLng");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "isOpenDevelop");
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
                    String string16 = query.isNull(i4) ? null : query.getString(i4);
                    int i6 = columnIndexOrThrow16;
                    String string17 = query.isNull(i6) ? null : query.getString(i6);
                    int i7 = columnIndexOrThrow17;
                    String string18 = query.isNull(i7) ? null : query.getString(i7);
                    int i8 = columnIndexOrThrow18;
                    String string19 = query.isNull(i8) ? null : query.getString(i8);
                    int i9 = columnIndexOrThrow19;
                    String string20 = query.isNull(i9) ? null : query.getString(i9);
                    int i10 = columnIndexOrThrow20;
                    String string21 = query.isNull(i10) ? null : query.getString(i10);
                    int i11 = columnIndexOrThrow21;
                    String string22 = query.isNull(i11) ? null : query.getString(i11);
                    int i12 = columnIndexOrThrow22;
                    String string23 = query.isNull(i12) ? null : query.getString(i12);
                    int i13 = columnIndexOrThrow23;
                    if (query.isNull(i13)) {
                        i2 = i13;
                        string2 = null;
                    } else {
                        string2 = query.getString(i13);
                        i2 = i13;
                    }
                    arrayList.add(new SportsDb(string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string, string15, string16, string17, string18, string19, string20, string21, string22, string23, string2));
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow15 = i4;
                    columnIndexOrThrow16 = i6;
                    columnIndexOrThrow17 = i7;
                    columnIndexOrThrow18 = i8;
                    columnIndexOrThrow19 = i9;
                    columnIndexOrThrow20 = i10;
                    columnIndexOrThrow21 = i11;
                    columnIndexOrThrow22 = i12;
                    columnIndexOrThrow23 = i2;
                    i3 = i;
                }
                query.close();
                this.f20040a.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                callableC5516f = this;
                query.close();
                callableC5516f.f20040a.release();
                throw th;
            }
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5517g implements Callable<List<SportsDb>> {

        /* renamed from: a */
        final /* synthetic */ RoomSQLiteQuery f20042a;

        CallableC5517g(final RoomSQLiteQuery val$_statement) {
            this.f20042a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<SportsDb> call() throws Exception {
            CallableC5517g callableC5517g;
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
            Cursor query = DBUtil.query(SportsDao_Impl.this.f20006a, this.f20042a, false, null);
            try {
                columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "identify");
                columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "userNumber");
                columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "sportsType");
                columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "sportsSet");
                columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, AnalyticsConfig.RTD_START_TIME);
                columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "endTime");
                columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "countTime");
                columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "distance");
                columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "gpsDistance");
                columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "latLngList");
                columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "stepList");
                columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "passLatLngList");
                columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "isFaceOut");
                columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "faceDetectCount");
            } catch (Throwable th) {
                th = th;
                callableC5517g = this;
            }
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "uploadType");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "isException");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "startFace");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "midFace");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "endFace");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "isValid");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "faceCheckingDistance");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "pauseLatLng");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "isOpenDevelop");
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
                    String string16 = query.isNull(i4) ? null : query.getString(i4);
                    int i6 = columnIndexOrThrow16;
                    String string17 = query.isNull(i6) ? null : query.getString(i6);
                    int i7 = columnIndexOrThrow17;
                    String string18 = query.isNull(i7) ? null : query.getString(i7);
                    int i8 = columnIndexOrThrow18;
                    String string19 = query.isNull(i8) ? null : query.getString(i8);
                    int i9 = columnIndexOrThrow19;
                    String string20 = query.isNull(i9) ? null : query.getString(i9);
                    int i10 = columnIndexOrThrow20;
                    String string21 = query.isNull(i10) ? null : query.getString(i10);
                    int i11 = columnIndexOrThrow21;
                    String string22 = query.isNull(i11) ? null : query.getString(i11);
                    int i12 = columnIndexOrThrow22;
                    String string23 = query.isNull(i12) ? null : query.getString(i12);
                    int i13 = columnIndexOrThrow23;
                    if (query.isNull(i13)) {
                        i2 = i13;
                        string2 = null;
                    } else {
                        string2 = query.getString(i13);
                        i2 = i13;
                    }
                    arrayList.add(new SportsDb(string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string, string15, string16, string17, string18, string19, string20, string21, string22, string23, string2));
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow15 = i4;
                    columnIndexOrThrow16 = i6;
                    columnIndexOrThrow17 = i7;
                    columnIndexOrThrow18 = i8;
                    columnIndexOrThrow19 = i9;
                    columnIndexOrThrow20 = i10;
                    columnIndexOrThrow21 = i11;
                    columnIndexOrThrow22 = i12;
                    columnIndexOrThrow23 = i2;
                    i3 = i;
                }
                query.close();
                this.f20042a.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                callableC5517g = this;
                query.close();
                callableC5517g.f20042a.release();
                throw th;
            }
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5518h implements Callable<List<SportsDb>> {

        /* renamed from: a */
        final /* synthetic */ RoomSQLiteQuery f20044a;

        CallableC5518h(final RoomSQLiteQuery val$_statement) {
            this.f20044a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<SportsDb> call() throws Exception {
            CallableC5518h callableC5518h;
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
            Cursor query = DBUtil.query(SportsDao_Impl.this.f20006a, this.f20044a, false, null);
            try {
                columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "identify");
                columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "userNumber");
                columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "sportsType");
                columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "sportsSet");
                columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, AnalyticsConfig.RTD_START_TIME);
                columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "endTime");
                columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "countTime");
                columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "distance");
                columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "gpsDistance");
                columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "latLngList");
                columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "stepList");
                columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "passLatLngList");
                columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "isFaceOut");
                columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "faceDetectCount");
            } catch (Throwable th) {
                th = th;
                callableC5518h = this;
            }
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "uploadType");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "isException");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "startFace");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "midFace");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "endFace");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "isValid");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "faceCheckingDistance");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "pauseLatLng");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "isOpenDevelop");
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
                    String string16 = query.isNull(i4) ? null : query.getString(i4);
                    int i6 = columnIndexOrThrow16;
                    String string17 = query.isNull(i6) ? null : query.getString(i6);
                    int i7 = columnIndexOrThrow17;
                    String string18 = query.isNull(i7) ? null : query.getString(i7);
                    int i8 = columnIndexOrThrow18;
                    String string19 = query.isNull(i8) ? null : query.getString(i8);
                    int i9 = columnIndexOrThrow19;
                    String string20 = query.isNull(i9) ? null : query.getString(i9);
                    int i10 = columnIndexOrThrow20;
                    String string21 = query.isNull(i10) ? null : query.getString(i10);
                    int i11 = columnIndexOrThrow21;
                    String string22 = query.isNull(i11) ? null : query.getString(i11);
                    int i12 = columnIndexOrThrow22;
                    String string23 = query.isNull(i12) ? null : query.getString(i12);
                    int i13 = columnIndexOrThrow23;
                    if (query.isNull(i13)) {
                        i2 = i13;
                        string2 = null;
                    } else {
                        string2 = query.getString(i13);
                        i2 = i13;
                    }
                    arrayList.add(new SportsDb(string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string, string15, string16, string17, string18, string19, string20, string21, string22, string23, string2));
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow15 = i4;
                    columnIndexOrThrow16 = i6;
                    columnIndexOrThrow17 = i7;
                    columnIndexOrThrow18 = i8;
                    columnIndexOrThrow19 = i9;
                    columnIndexOrThrow20 = i10;
                    columnIndexOrThrow21 = i11;
                    columnIndexOrThrow22 = i12;
                    columnIndexOrThrow23 = i2;
                    i3 = i;
                }
                query.close();
                this.f20044a.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                callableC5518h = this;
                query.close();
                callableC5518h.f20044a.release();
                throw th;
            }
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5519i implements Callable<List<SportsDb>> {

        /* renamed from: a */
        final /* synthetic */ RoomSQLiteQuery f20046a;

        CallableC5519i(final RoomSQLiteQuery val$_statement) {
            this.f20046a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<SportsDb> call() throws Exception {
            CallableC5519i callableC5519i;
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
            Cursor query = DBUtil.query(SportsDao_Impl.this.f20006a, this.f20046a, false, null);
            try {
                columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "identify");
                columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "userNumber");
                columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "sportsType");
                columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "sportsSet");
                columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, AnalyticsConfig.RTD_START_TIME);
                columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "endTime");
                columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "countTime");
                columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "distance");
                columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "gpsDistance");
                columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "latLngList");
                columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "stepList");
                columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "passLatLngList");
                columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "isFaceOut");
                columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "faceDetectCount");
            } catch (Throwable th) {
                th = th;
                callableC5519i = this;
            }
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "uploadType");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "isException");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "startFace");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "midFace");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "endFace");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "isValid");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "faceCheckingDistance");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "pauseLatLng");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "isOpenDevelop");
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
                    String string16 = query.isNull(i4) ? null : query.getString(i4);
                    int i6 = columnIndexOrThrow16;
                    String string17 = query.isNull(i6) ? null : query.getString(i6);
                    int i7 = columnIndexOrThrow17;
                    String string18 = query.isNull(i7) ? null : query.getString(i7);
                    int i8 = columnIndexOrThrow18;
                    String string19 = query.isNull(i8) ? null : query.getString(i8);
                    int i9 = columnIndexOrThrow19;
                    String string20 = query.isNull(i9) ? null : query.getString(i9);
                    int i10 = columnIndexOrThrow20;
                    String string21 = query.isNull(i10) ? null : query.getString(i10);
                    int i11 = columnIndexOrThrow21;
                    String string22 = query.isNull(i11) ? null : query.getString(i11);
                    int i12 = columnIndexOrThrow22;
                    String string23 = query.isNull(i12) ? null : query.getString(i12);
                    int i13 = columnIndexOrThrow23;
                    if (query.isNull(i13)) {
                        i2 = i13;
                        string2 = null;
                    } else {
                        string2 = query.getString(i13);
                        i2 = i13;
                    }
                    arrayList.add(new SportsDb(string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string, string15, string16, string17, string18, string19, string20, string21, string22, string23, string2));
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow15 = i4;
                    columnIndexOrThrow16 = i6;
                    columnIndexOrThrow17 = i7;
                    columnIndexOrThrow18 = i8;
                    columnIndexOrThrow19 = i9;
                    columnIndexOrThrow20 = i10;
                    columnIndexOrThrow21 = i11;
                    columnIndexOrThrow22 = i12;
                    columnIndexOrThrow23 = i2;
                    i3 = i;
                }
                query.close();
                this.f20046a.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                callableC5519i = this;
                query.close();
                callableC5519i.f20046a.release();
                throw th;
            }
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$j */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5520j implements Callable<List<SportsDb>> {

        /* renamed from: a */
        final /* synthetic */ RoomSQLiteQuery f20048a;

        CallableC5520j(final RoomSQLiteQuery val$_statement) {
            this.f20048a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<SportsDb> call() throws Exception {
            CallableC5520j callableC5520j;
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
            Cursor query = DBUtil.query(SportsDao_Impl.this.f20006a, this.f20048a, false, null);
            try {
                columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "identify");
                columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "userNumber");
                columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "sportsType");
                columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "sportsSet");
                columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, AnalyticsConfig.RTD_START_TIME);
                columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "endTime");
                columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "countTime");
                columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "distance");
                columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "gpsDistance");
                columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "latLngList");
                columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "stepList");
                columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "passLatLngList");
                columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "isFaceOut");
                columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "faceDetectCount");
            } catch (Throwable th) {
                th = th;
                callableC5520j = this;
            }
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "uploadType");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "isException");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "startFace");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "midFace");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "endFace");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "isValid");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "faceCheckingDistance");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "pauseLatLng");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "isOpenDevelop");
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
                    String string16 = query.isNull(i4) ? null : query.getString(i4);
                    int i6 = columnIndexOrThrow16;
                    String string17 = query.isNull(i6) ? null : query.getString(i6);
                    int i7 = columnIndexOrThrow17;
                    String string18 = query.isNull(i7) ? null : query.getString(i7);
                    int i8 = columnIndexOrThrow18;
                    String string19 = query.isNull(i8) ? null : query.getString(i8);
                    int i9 = columnIndexOrThrow19;
                    String string20 = query.isNull(i9) ? null : query.getString(i9);
                    int i10 = columnIndexOrThrow20;
                    String string21 = query.isNull(i10) ? null : query.getString(i10);
                    int i11 = columnIndexOrThrow21;
                    String string22 = query.isNull(i11) ? null : query.getString(i11);
                    int i12 = columnIndexOrThrow22;
                    String string23 = query.isNull(i12) ? null : query.getString(i12);
                    int i13 = columnIndexOrThrow23;
                    if (query.isNull(i13)) {
                        i2 = i13;
                        string2 = null;
                    } else {
                        string2 = query.getString(i13);
                        i2 = i13;
                    }
                    arrayList.add(new SportsDb(string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string, string15, string16, string17, string18, string19, string20, string21, string22, string23, string2));
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow15 = i4;
                    columnIndexOrThrow16 = i6;
                    columnIndexOrThrow17 = i7;
                    columnIndexOrThrow18 = i8;
                    columnIndexOrThrow19 = i9;
                    columnIndexOrThrow20 = i10;
                    columnIndexOrThrow21 = i11;
                    columnIndexOrThrow22 = i12;
                    columnIndexOrThrow23 = i2;
                    i3 = i;
                }
                query.close();
                this.f20048a.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                callableC5520j = this;
                query.close();
                callableC5520j.f20048a.release();
                throw th;
            }
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$k */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5521k extends EntityInsertionAdapter<SportsDb> {
        C5521k(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement stmt, SportsDb value) {
            if (value.m58126G() == null) {
                stmt.bindNull(1);
            } else {
                stmt.bindString(1, value.m58126G());
            }
            if (value.m58115R() == null) {
                stmt.bindNull(2);
            } else {
                stmt.bindString(2, value.m58115R());
            }
            if (value.m58120M() == null) {
                stmt.bindNull(3);
            } else {
                stmt.bindString(3, value.m58120M());
            }
            if (value.m58121L() == null) {
                stmt.bindNull(4);
            } else {
                stmt.bindString(4, value.m58121L());
            }
            if (value.m58118O() == null) {
                stmt.bindNull(5);
            } else {
                stmt.bindString(5, value.m58118O());
            }
            if (value.m58130C() == null) {
                stmt.bindNull(6);
            } else {
                stmt.bindString(6, value.m58130C());
            }
            if (value.m58062z() == null) {
                stmt.bindNull(7);
            } else {
                stmt.bindString(7, value.m58062z());
            }
            if (value.m58132A() == null) {
                stmt.bindNull(8);
            } else {
                stmt.bindString(8, value.m58132A());
            }
            if (value.m58127F() == null) {
                stmt.bindNull(9);
            } else {
                stmt.bindString(9, value.m58127F());
            }
            if (value.m58125H() == null) {
                stmt.bindNull(10);
            } else {
                stmt.bindString(10, value.m58125H());
            }
            if (value.m58117P() == null) {
                stmt.bindNull(11);
            } else {
                stmt.bindString(11, value.m58117P());
            }
            if (value.m58123J() == null) {
                stmt.bindNull(12);
            } else {
                stmt.bindString(12, value.m58123J());
            }
            if (value.m58113T() == null) {
                stmt.bindNull(13);
            } else {
                stmt.bindString(13, value.m58113T());
            }
            if (value.m58128E() == null) {
                stmt.bindNull(14);
            } else {
                stmt.bindString(14, value.m58128E());
            }
            if (value.m58116Q() == null) {
                stmt.bindNull(15);
            } else {
                stmt.bindString(15, value.m58116Q());
            }
            if (value.m58114S() == null) {
                stmt.bindNull(16);
            } else {
                stmt.bindString(16, value.m58114S());
            }
            if (value.m58119N() == null) {
                stmt.bindNull(17);
            } else {
                stmt.bindString(17, value.m58119N());
            }
            if (value.m58124I() == null) {
                stmt.bindNull(18);
            } else {
                stmt.bindString(18, value.m58124I());
            }
            if (value.m58131B() == null) {
                stmt.bindNull(19);
            } else {
                stmt.bindString(19, value.m58131B());
            }
            if (value.m58111V() == null) {
                stmt.bindNull(20);
            } else {
                stmt.bindString(20, value.m58111V());
            }
            if (value.m58129D() == null) {
                stmt.bindNull(21);
            } else {
                stmt.bindString(21, value.m58129D());
            }
            if (value.m58122K() == null) {
                stmt.bindNull(22);
            } else {
                stmt.bindString(22, value.m58122K());
            }
            if (value.m58112U() == null) {
                stmt.bindNull(23);
            } else {
                stmt.bindString(23, value.m58112U());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `sports` (`identify`,`userNumber`,`sportsType`,`sportsSet`,`startTime`,`endTime`,`countTime`,`distance`,`gpsDistance`,`latLngList`,`stepList`,`passLatLngList`,`isFaceOut`,`faceDetectCount`,`uploadType`,`isException`,`startFace`,`midFace`,`endFace`,`isValid`,`faceCheckingDistance`,`pauseLatLng`,`isOpenDevelop`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$l */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5522l implements Callable<List<CountDistanceTime>> {

        /* renamed from: a */
        final /* synthetic */ RoomSQLiteQuery f20051a;

        CallableC5522l(final RoomSQLiteQuery val$_statement) {
            this.f20051a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<CountDistanceTime> call() throws Exception {
            Cursor query = DBUtil.query(SportsDao_Impl.this.f20006a, this.f20051a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "count");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "distance");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, RtspHeaders.Values.TIME);
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(new CountDistanceTime(query.getLong(columnIndexOrThrow), query.getLong(columnIndexOrThrow2), query.getLong(columnIndexOrThrow3)));
                }
                return arrayList;
            } finally {
                query.close();
                this.f20051a.release();
            }
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$m */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5523m extends EntityDeletionOrUpdateAdapter<SportsDb> {
        C5523m(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement stmt, SportsDb value) {
            if (value.m58126G() == null) {
                stmt.bindNull(1);
            } else {
                stmt.bindString(1, value.m58126G());
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `sports` WHERE `identify` = ?";
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$n */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5524n extends SharedSQLiteStatement {
        C5524n(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE sports SET countTime=?,distance=? ,gpsDistance=?,latLngList=? ,stepList=?,passLatLngList=?,isFaceOut=? ,faceDetectCount=? ,faceCheckingDistance=?,pauseLatLng=? ,isOpenDevelop=? WHERE identify=?";
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$o */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5525o extends SharedSQLiteStatement {
        C5525o(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM sports WHERE identify=?";
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$p */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5526p extends SharedSQLiteStatement {
        C5526p(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE sports SET uploadType=? WHERE identify=?";
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$q */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5527q extends SharedSQLiteStatement {
        C5527q(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE sports SET isException=?,isValid=?, endTime=? WHERE identify=?";
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$r */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5528r extends SharedSQLiteStatement {
        C5528r(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE sports SET isValid=? WHERE identify=?";
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$s */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5529s implements Callable<Unit> {

        /* renamed from: a */
        final /* synthetic */ SportsDb[] f20059a;

        CallableC5529s(final SportsDb[] val$project) {
            this.f20059a = val$project;
        }

        @Override // java.util.concurrent.Callable
        public Unit call() throws Exception {
            SportsDao_Impl.this.f20006a.beginTransaction();
            try {
                SportsDao_Impl.this.f20007b.insert((Object[]) this.f20059a);
                SportsDao_Impl.this.f20006a.setTransactionSuccessful();
                return Unit.f41048a;
            } finally {
                SportsDao_Impl.this.f20006a.endTransaction();
            }
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$t */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5530t implements Callable<Unit> {

        /* renamed from: a */
        final /* synthetic */ SportsDb f20061a;

        CallableC5530t(final SportsDb val$project) {
            this.f20061a = val$project;
        }

        @Override // java.util.concurrent.Callable
        public Unit call() throws Exception {
            SportsDao_Impl.this.f20006a.beginTransaction();
            try {
                SportsDao_Impl.this.f20008c.handle(this.f20061a);
                SportsDao_Impl.this.f20006a.setTransactionSuccessful();
                return Unit.f41048a;
            } finally {
                SportsDao_Impl.this.f20006a.endTransaction();
            }
        }
    }

    public SportsDao_Impl(RoomDatabase __db) {
        this.f20006a = __db;
        this.f20007b = new C5521k(__db);
        this.f20008c = new C5523m(__db);
        this.f20009d = new C5524n(__db);
        this.f20010e = new C5525o(__db);
        this.f20011f = new C5526p(__db);
        this.f20012g = new C5527q(__db);
        this.f20013h = new C5528r(__db);
    }

    /* renamed from: s */
    public static List<Class<?>> m39164s() {
        return Collections.emptyList();
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.SportsDao
    /* renamed from: a */
    public Object mo39182a(final String userNumber, final InterfaceC14268c<? super List<SportsDb>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM sports WHERE userNumber = ? AND endTime !=''", 1);
        if (userNumber == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, userNumber);
        }
        return CoroutinesRoom.execute(this.f20006a, false, DBUtil.createCancellationSignal(), new CallableC5518h(acquire), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.SportsDao
    /* renamed from: b */
    public Object mo39181b(final SportsDb[] project, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f20006a, true, new CallableC5529s(project), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.SportsDao
    /* renamed from: c */
    public Object mo39180c(final SportsDb project, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f20006a, true, new CallableC5530t(project), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.SportsDao
    /* renamed from: d */
    public Object mo39179d(final String isValid, final String identify, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f20006a, true, new CallableC5515e(isValid, identify), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.SportsDao
    public Object deleteByIdentify(final String identify, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f20006a, true, new CallableC5512b(identify), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.SportsDao
    /* renamed from: e */
    public Object mo39178e(final String countTime, final String distance, final String gpsDistance, final String latLngList, final String stepList, final String passLatLngList, final String isFaceOut, final String faceDetectCount, final String identify, final String faceCheckingDistance, final String pauseLatLng, final String isOpenDevelop, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f20006a, true, new CallableC5511a(countTime, distance, gpsDistance, latLngList, stepList, passLatLngList, isFaceOut, faceDetectCount, faceCheckingDistance, pauseLatLng, isOpenDevelop, identify), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.SportsDao
    /* renamed from: f */
    public Object mo39177f(final String userNumber, final long startTime, final long endTime, final InterfaceC14268c<? super List<SportsDb>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM sports WHERE userNumber = ? AND endTime !='' AND startTime BETWEEN ? And ?", 3);
        if (userNumber == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, userNumber);
        }
        acquire.bindLong(2, startTime);
        acquire.bindLong(3, endTime);
        return CoroutinesRoom.execute(this.f20006a, false, DBUtil.createCancellationSignal(), new CallableC5520j(acquire), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.SportsDao
    /* renamed from: g */
    public Object mo39176g(final String userNumber, final InterfaceC14268c<? super List<SportsDb>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM sports WHERE userNumber = ? AND endTime !=''", 1);
        if (userNumber == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, userNumber);
        }
        return CoroutinesRoom.execute(this.f20006a, false, DBUtil.createCancellationSignal(), new CallableC5519i(acquire), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.SportsDao
    public Object getExceptionSports(final String userNumber, final InterfaceC14268c<? super List<SportsDb>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM sports WHERE userNumber = ? AND endTime ==''", 1);
        if (userNumber == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, userNumber);
        }
        return CoroutinesRoom.execute(this.f20006a, false, DBUtil.createCancellationSignal(), new CallableC5517g(acquire), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.SportsDao
    public Object getLocalRecordById(final String identify, final InterfaceC14268c<? super List<SportsDb>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM sports WHERE identify = ?", 1);
        if (identify == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, identify);
        }
        return CoroutinesRoom.execute(this.f20006a, false, DBUtil.createCancellationSignal(), new CallableC5516f(acquire), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.SportsDao
    /* renamed from: h */
    public Object mo39175h(final String userNumber, final long startTime, final long endTime, final InterfaceC14268c<? super List<CountDistanceTime>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(identify) as count, sum(distance) AS distance,sum(countTime) AS time FROM sports WHERE userNumber = ? AND endTime !='' AND startTime BETWEEN ? And ?", 3);
        if (userNumber == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, userNumber);
        }
        acquire.bindLong(2, startTime);
        acquire.bindLong(3, endTime);
        return CoroutinesRoom.execute(this.f20006a, false, DBUtil.createCancellationSignal(), new CallableC5522l(acquire), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.SportsDao
    /* renamed from: i */
    public Object mo39174i(final String uploadType, final String identify, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f20006a, true, new CallableC5513c(uploadType, identify), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.SportsDao
    /* renamed from: j */
    public Object mo39173j(final String isException, final String isValid, final String endTime, final String identify, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f20006a, true, new CallableC5514d(isException, isValid, endTime, identify), continuation);
    }
}
