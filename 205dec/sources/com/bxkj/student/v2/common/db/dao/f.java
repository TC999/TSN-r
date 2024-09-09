package com.bxkj.student.v2.common.db.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.f1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: SportsDao_Impl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class f implements com.bxkj.student.v2.common.db.dao.e {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f23242a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<c0.c> f23243b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f23244c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f23245d;

    /* renamed from: e  reason: collision with root package name */
    private final SharedSQLiteStatement f23246e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedSQLiteStatement f23247f;

    /* renamed from: g  reason: collision with root package name */
    private final SharedSQLiteStatement f23248g;

    /* renamed from: h  reason: collision with root package name */
    private final SharedSQLiteStatement f23249h;

    /* renamed from: i  reason: collision with root package name */
    private final SharedSQLiteStatement f23250i;

    /* renamed from: j  reason: collision with root package name */
    private final SharedSQLiteStatement f23251j;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class a implements Callable<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c0.c[] f23252a;

        a(final c0.c[] val$project) {
            this.f23252a = val$project;
        }

        @Override // java.util.concurrent.Callable
        public f1 call() throws Exception {
            f.this.f23242a.beginTransaction();
            try {
                f.this.f23243b.insert((Object[]) this.f23252a);
                f.this.f23242a.setTransactionSuccessful();
                return f1.f55527a;
            } finally {
                f.this.f23242a.endTransaction();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class b implements Callable<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23254a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f23255b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f23256c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f23257d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f23258e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f23259f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f23260g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f23261h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f23262i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ String f23263j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ String f23264k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ String f23265l;

        b(final String val$countTime, final String val$distance, final String val$gpsDistance, final String val$latLngList, final String val$stepList, final String val$passLatLngList, final String val$isFaceOut, final String val$faceDetectCount, final String val$faceCheckingDistance, final String val$pauseLatLng, final String val$isOpenDevelop, final String val$identify) {
            this.f23254a = val$countTime;
            this.f23255b = val$distance;
            this.f23256c = val$gpsDistance;
            this.f23257d = val$latLngList;
            this.f23258e = val$stepList;
            this.f23259f = val$passLatLngList;
            this.f23260g = val$isFaceOut;
            this.f23261h = val$faceDetectCount;
            this.f23262i = val$faceCheckingDistance;
            this.f23263j = val$pauseLatLng;
            this.f23264k = val$isOpenDevelop;
            this.f23265l = val$identify;
        }

        @Override // java.util.concurrent.Callable
        public f1 call() throws Exception {
            SupportSQLiteStatement acquire = f.this.f23244c.acquire();
            String str = this.f23254a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            String str2 = this.f23255b;
            if (str2 == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindString(2, str2);
            }
            String str3 = this.f23256c;
            if (str3 == null) {
                acquire.bindNull(3);
            } else {
                acquire.bindString(3, str3);
            }
            String str4 = this.f23257d;
            if (str4 == null) {
                acquire.bindNull(4);
            } else {
                acquire.bindString(4, str4);
            }
            String str5 = this.f23258e;
            if (str5 == null) {
                acquire.bindNull(5);
            } else {
                acquire.bindString(5, str5);
            }
            String str6 = this.f23259f;
            if (str6 == null) {
                acquire.bindNull(6);
            } else {
                acquire.bindString(6, str6);
            }
            String str7 = this.f23260g;
            if (str7 == null) {
                acquire.bindNull(7);
            } else {
                acquire.bindString(7, str7);
            }
            String str8 = this.f23261h;
            if (str8 == null) {
                acquire.bindNull(8);
            } else {
                acquire.bindString(8, str8);
            }
            String str9 = this.f23262i;
            if (str9 == null) {
                acquire.bindNull(9);
            } else {
                acquire.bindString(9, str9);
            }
            String str10 = this.f23263j;
            if (str10 == null) {
                acquire.bindNull(10);
            } else {
                acquire.bindString(10, str10);
            }
            String str11 = this.f23264k;
            if (str11 == null) {
                acquire.bindNull(11);
            } else {
                acquire.bindString(11, str11);
            }
            String str12 = this.f23265l;
            if (str12 == null) {
                acquire.bindNull(12);
            } else {
                acquire.bindString(12, str12);
            }
            f.this.f23242a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                f.this.f23242a.setTransactionSuccessful();
                return f1.f55527a;
            } finally {
                f.this.f23242a.endTransaction();
                f.this.f23244c.release(acquire);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class c implements Callable<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23267a;

        c(final String val$identify) {
            this.f23267a = val$identify;
        }

        @Override // java.util.concurrent.Callable
        public f1 call() throws Exception {
            SupportSQLiteStatement acquire = f.this.f23245d.acquire();
            String str = this.f23267a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            f.this.f23242a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                f.this.f23242a.setTransactionSuccessful();
                return f1.f55527a;
            } finally {
                f.this.f23242a.endTransaction();
                f.this.f23245d.release(acquire);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class d implements Callable<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23269a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f23270b;

        d(final String val$uploadType, final String val$identify) {
            this.f23269a = val$uploadType;
            this.f23270b = val$identify;
        }

        @Override // java.util.concurrent.Callable
        public f1 call() throws Exception {
            SupportSQLiteStatement acquire = f.this.f23246e.acquire();
            String str = this.f23269a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            String str2 = this.f23270b;
            if (str2 == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindString(2, str2);
            }
            f.this.f23242a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                f.this.f23242a.setTransactionSuccessful();
                return f1.f55527a;
            } finally {
                f.this.f23242a.endTransaction();
                f.this.f23246e.release(acquire);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class e implements Callable<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23272a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f23273b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f23274c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f23275d;

        e(final String val$isException, final String val$isValid, final String val$endTime, final String val$identify) {
            this.f23272a = val$isException;
            this.f23273b = val$isValid;
            this.f23274c = val$endTime;
            this.f23275d = val$identify;
        }

        @Override // java.util.concurrent.Callable
        public f1 call() throws Exception {
            SupportSQLiteStatement acquire = f.this.f23247f.acquire();
            String str = this.f23272a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            String str2 = this.f23273b;
            if (str2 == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindString(2, str2);
            }
            String str3 = this.f23274c;
            if (str3 == null) {
                acquire.bindNull(3);
            } else {
                acquire.bindString(3, str3);
            }
            String str4 = this.f23275d;
            if (str4 == null) {
                acquire.bindNull(4);
            } else {
                acquire.bindString(4, str4);
            }
            f.this.f23242a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                f.this.f23242a.setTransactionSuccessful();
                return f1.f55527a;
            } finally {
                f.this.f23242a.endTransaction();
                f.this.f23247f.release(acquire);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.f$f  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class CallableC0291f implements Callable<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23277a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f23278b;

        CallableC0291f(final String val$isValid, final String val$identify) {
            this.f23277a = val$isValid;
            this.f23278b = val$identify;
        }

        @Override // java.util.concurrent.Callable
        public f1 call() throws Exception {
            SupportSQLiteStatement acquire = f.this.f23248g.acquire();
            String str = this.f23277a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            String str2 = this.f23278b;
            if (str2 == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindString(2, str2);
            }
            f.this.f23242a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                f.this.f23242a.setTransactionSuccessful();
                return f1.f55527a;
            } finally {
                f.this.f23242a.endTransaction();
                f.this.f23248g.release(acquire);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class g implements Callable<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23280a;

        g(final String val$identify) {
            this.f23280a = val$identify;
        }

        @Override // java.util.concurrent.Callable
        public f1 call() throws Exception {
            SupportSQLiteStatement acquire = f.this.f23249h.acquire();
            String str = this.f23280a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            f.this.f23242a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                f.this.f23242a.setTransactionSuccessful();
                return f1.f55527a;
            } finally {
                f.this.f23242a.endTransaction();
                f.this.f23249h.release(acquire);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class h implements Callable<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23282a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f23283b;

        h(final String val$endTime, final String val$identify) {
            this.f23282a = val$endTime;
            this.f23283b = val$identify;
        }

        @Override // java.util.concurrent.Callable
        public f1 call() throws Exception {
            SupportSQLiteStatement acquire = f.this.f23250i.acquire();
            String str = this.f23282a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            String str2 = this.f23283b;
            if (str2 == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindString(2, str2);
            }
            f.this.f23242a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                f.this.f23242a.setTransactionSuccessful();
                return f1.f55527a;
            } finally {
                f.this.f23242a.endTransaction();
                f.this.f23250i.release(acquire);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class i implements Callable<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23285a;

        i(final String val$identity) {
            this.f23285a = val$identity;
        }

        @Override // java.util.concurrent.Callable
        public f1 call() throws Exception {
            SupportSQLiteStatement acquire = f.this.f23251j.acquire();
            String str = this.f23285a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            f.this.f23242a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                f.this.f23242a.setTransactionSuccessful();
                return f1.f55527a;
            } finally {
                f.this.f23242a.endTransaction();
                f.this.f23251j.release(acquire);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class j implements Callable<List<c0.c>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f23287a;

        j(final RoomSQLiteQuery val$_statement) {
            this.f23287a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<c0.c> call() throws Exception {
            j jVar;
            String string;
            int i4;
            Cursor query = DBUtil.query(f.this.f23242a, this.f23287a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "identify");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "userNumber");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "sportsType");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "sportsSet");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "startTime");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "endTime");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "countTime");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "distance");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "gpsDistance");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "latLngList");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "stepList");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "passLatLngList");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "isFaceOut");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "faceDetectCount");
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
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "confirmCount");
                    int i5 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string2 = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                        String string3 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        String string4 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                        String string5 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                        String string6 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                        String string7 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                        String string8 = query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7);
                        String string9 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                        String string10 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                        String string11 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                        String string12 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                        String string13 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                        if (query.isNull(columnIndexOrThrow13)) {
                            i4 = i5;
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow13);
                            i4 = i5;
                        }
                        String string14 = query.isNull(i4) ? null : query.getString(i4);
                        int i6 = columnIndexOrThrow15;
                        int i7 = columnIndexOrThrow;
                        String string15 = query.isNull(i6) ? null : query.getString(i6);
                        int i8 = columnIndexOrThrow16;
                        String string16 = query.isNull(i8) ? null : query.getString(i8);
                        int i9 = columnIndexOrThrow17;
                        String string17 = query.isNull(i9) ? null : query.getString(i9);
                        int i10 = columnIndexOrThrow18;
                        String string18 = query.isNull(i10) ? null : query.getString(i10);
                        int i11 = columnIndexOrThrow19;
                        String string19 = query.isNull(i11) ? null : query.getString(i11);
                        int i12 = columnIndexOrThrow20;
                        String string20 = query.isNull(i12) ? null : query.getString(i12);
                        int i13 = columnIndexOrThrow21;
                        String string21 = query.isNull(i13) ? null : query.getString(i13);
                        int i14 = columnIndexOrThrow22;
                        String string22 = query.isNull(i14) ? null : query.getString(i14);
                        int i15 = columnIndexOrThrow23;
                        String string23 = query.isNull(i15) ? null : query.getString(i15);
                        int i16 = columnIndexOrThrow24;
                        arrayList.add(new c0.c(string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string, string14, string15, string16, string17, string18, string19, string20, string21, string22, string23, query.getInt(i16)));
                        columnIndexOrThrow = i7;
                        columnIndexOrThrow15 = i6;
                        columnIndexOrThrow16 = i8;
                        columnIndexOrThrow17 = i9;
                        columnIndexOrThrow18 = i10;
                        columnIndexOrThrow19 = i11;
                        columnIndexOrThrow20 = i12;
                        columnIndexOrThrow21 = i13;
                        columnIndexOrThrow22 = i14;
                        columnIndexOrThrow23 = i15;
                        columnIndexOrThrow24 = i16;
                        i5 = i4;
                    }
                    query.close();
                    this.f23287a.release();
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    jVar = this;
                    query.close();
                    jVar.f23287a.release();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                jVar = this;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class k extends EntityInsertionAdapter<c0.c> {
        k(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement stmt, c0.c value) {
            if (value.I() == null) {
                stmt.bindNull(1);
            } else {
                stmt.bindString(1, value.I());
            }
            if (value.T() == null) {
                stmt.bindNull(2);
            } else {
                stmt.bindString(2, value.T());
            }
            if (value.O() == null) {
                stmt.bindNull(3);
            } else {
                stmt.bindString(3, value.O());
            }
            if (value.N() == null) {
                stmt.bindNull(4);
            } else {
                stmt.bindString(4, value.N());
            }
            if (value.Q() == null) {
                stmt.bindNull(5);
            } else {
                stmt.bindString(5, value.Q());
            }
            if (value.E() == null) {
                stmt.bindNull(6);
            } else {
                stmt.bindString(6, value.E());
            }
            if (value.B() == null) {
                stmt.bindNull(7);
            } else {
                stmt.bindString(7, value.B());
            }
            if (value.C() == null) {
                stmt.bindNull(8);
            } else {
                stmt.bindString(8, value.C());
            }
            if (value.H() == null) {
                stmt.bindNull(9);
            } else {
                stmt.bindString(9, value.H());
            }
            if (value.J() == null) {
                stmt.bindNull(10);
            } else {
                stmt.bindString(10, value.J());
            }
            if (value.R() == null) {
                stmt.bindNull(11);
            } else {
                stmt.bindString(11, value.R());
            }
            if (value.L() == null) {
                stmt.bindNull(12);
            } else {
                stmt.bindString(12, value.L());
            }
            if (value.V() == null) {
                stmt.bindNull(13);
            } else {
                stmt.bindString(13, value.V());
            }
            if (value.G() == null) {
                stmt.bindNull(14);
            } else {
                stmt.bindString(14, value.G());
            }
            if (value.S() == null) {
                stmt.bindNull(15);
            } else {
                stmt.bindString(15, value.S());
            }
            if (value.U() == null) {
                stmt.bindNull(16);
            } else {
                stmt.bindString(16, value.U());
            }
            if (value.P() == null) {
                stmt.bindNull(17);
            } else {
                stmt.bindString(17, value.P());
            }
            if (value.K() == null) {
                stmt.bindNull(18);
            } else {
                stmt.bindString(18, value.K());
            }
            if (value.D() == null) {
                stmt.bindNull(19);
            } else {
                stmt.bindString(19, value.D());
            }
            if (value.X() == null) {
                stmt.bindNull(20);
            } else {
                stmt.bindString(20, value.X());
            }
            if (value.F() == null) {
                stmt.bindNull(21);
            } else {
                stmt.bindString(21, value.F());
            }
            if (value.M() == null) {
                stmt.bindNull(22);
            } else {
                stmt.bindString(22, value.M());
            }
            if (value.W() == null) {
                stmt.bindNull(23);
            } else {
                stmt.bindString(23, value.W());
            }
            stmt.bindLong(24, value.A());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `sports` (`identify`,`userNumber`,`sportsType`,`sportsSet`,`startTime`,`endTime`,`countTime`,`distance`,`gpsDistance`,`latLngList`,`stepList`,`passLatLngList`,`isFaceOut`,`faceDetectCount`,`uploadType`,`isException`,`startFace`,`midFace`,`endFace`,`isValid`,`faceCheckingDistance`,`pauseLatLng`,`isOpenDevelop`,`confirmCount`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class l implements Callable<List<c0.c>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f23290a;

        l(final RoomSQLiteQuery val$_statement) {
            this.f23290a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<c0.c> call() throws Exception {
            l lVar;
            String string;
            int i4;
            Cursor query = DBUtil.query(f.this.f23242a, this.f23290a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "identify");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "userNumber");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "sportsType");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "sportsSet");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "startTime");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "endTime");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "countTime");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "distance");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "gpsDistance");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "latLngList");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "stepList");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "passLatLngList");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "isFaceOut");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "faceDetectCount");
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
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "confirmCount");
                    int i5 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string2 = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                        String string3 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        String string4 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                        String string5 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                        String string6 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                        String string7 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                        String string8 = query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7);
                        String string9 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                        String string10 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                        String string11 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                        String string12 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                        String string13 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                        if (query.isNull(columnIndexOrThrow13)) {
                            i4 = i5;
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow13);
                            i4 = i5;
                        }
                        String string14 = query.isNull(i4) ? null : query.getString(i4);
                        int i6 = columnIndexOrThrow15;
                        int i7 = columnIndexOrThrow;
                        String string15 = query.isNull(i6) ? null : query.getString(i6);
                        int i8 = columnIndexOrThrow16;
                        String string16 = query.isNull(i8) ? null : query.getString(i8);
                        int i9 = columnIndexOrThrow17;
                        String string17 = query.isNull(i9) ? null : query.getString(i9);
                        int i10 = columnIndexOrThrow18;
                        String string18 = query.isNull(i10) ? null : query.getString(i10);
                        int i11 = columnIndexOrThrow19;
                        String string19 = query.isNull(i11) ? null : query.getString(i11);
                        int i12 = columnIndexOrThrow20;
                        String string20 = query.isNull(i12) ? null : query.getString(i12);
                        int i13 = columnIndexOrThrow21;
                        String string21 = query.isNull(i13) ? null : query.getString(i13);
                        int i14 = columnIndexOrThrow22;
                        String string22 = query.isNull(i14) ? null : query.getString(i14);
                        int i15 = columnIndexOrThrow23;
                        String string23 = query.isNull(i15) ? null : query.getString(i15);
                        int i16 = columnIndexOrThrow24;
                        arrayList.add(new c0.c(string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string, string14, string15, string16, string17, string18, string19, string20, string21, string22, string23, query.getInt(i16)));
                        columnIndexOrThrow = i7;
                        columnIndexOrThrow15 = i6;
                        columnIndexOrThrow16 = i8;
                        columnIndexOrThrow17 = i9;
                        columnIndexOrThrow18 = i10;
                        columnIndexOrThrow19 = i11;
                        columnIndexOrThrow20 = i12;
                        columnIndexOrThrow21 = i13;
                        columnIndexOrThrow22 = i14;
                        columnIndexOrThrow23 = i15;
                        columnIndexOrThrow24 = i16;
                        i5 = i4;
                    }
                    query.close();
                    this.f23290a.release();
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    lVar = this;
                    query.close();
                    lVar.f23290a.release();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                lVar = this;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class m implements Callable<List<c0.c>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f23292a;

        m(final RoomSQLiteQuery val$_statement) {
            this.f23292a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<c0.c> call() throws Exception {
            m mVar;
            String string;
            int i4;
            Cursor query = DBUtil.query(f.this.f23242a, this.f23292a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "identify");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "userNumber");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "sportsType");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "sportsSet");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "startTime");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "endTime");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "countTime");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "distance");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "gpsDistance");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "latLngList");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "stepList");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "passLatLngList");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "isFaceOut");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "faceDetectCount");
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
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "confirmCount");
                    int i5 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string2 = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                        String string3 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        String string4 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                        String string5 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                        String string6 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                        String string7 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                        String string8 = query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7);
                        String string9 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                        String string10 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                        String string11 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                        String string12 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                        String string13 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                        if (query.isNull(columnIndexOrThrow13)) {
                            i4 = i5;
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow13);
                            i4 = i5;
                        }
                        String string14 = query.isNull(i4) ? null : query.getString(i4);
                        int i6 = columnIndexOrThrow15;
                        int i7 = columnIndexOrThrow;
                        String string15 = query.isNull(i6) ? null : query.getString(i6);
                        int i8 = columnIndexOrThrow16;
                        String string16 = query.isNull(i8) ? null : query.getString(i8);
                        int i9 = columnIndexOrThrow17;
                        String string17 = query.isNull(i9) ? null : query.getString(i9);
                        int i10 = columnIndexOrThrow18;
                        String string18 = query.isNull(i10) ? null : query.getString(i10);
                        int i11 = columnIndexOrThrow19;
                        String string19 = query.isNull(i11) ? null : query.getString(i11);
                        int i12 = columnIndexOrThrow20;
                        String string20 = query.isNull(i12) ? null : query.getString(i12);
                        int i13 = columnIndexOrThrow21;
                        String string21 = query.isNull(i13) ? null : query.getString(i13);
                        int i14 = columnIndexOrThrow22;
                        String string22 = query.isNull(i14) ? null : query.getString(i14);
                        int i15 = columnIndexOrThrow23;
                        String string23 = query.isNull(i15) ? null : query.getString(i15);
                        int i16 = columnIndexOrThrow24;
                        arrayList.add(new c0.c(string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string, string14, string15, string16, string17, string18, string19, string20, string21, string22, string23, query.getInt(i16)));
                        columnIndexOrThrow = i7;
                        columnIndexOrThrow15 = i6;
                        columnIndexOrThrow16 = i8;
                        columnIndexOrThrow17 = i9;
                        columnIndexOrThrow18 = i10;
                        columnIndexOrThrow19 = i11;
                        columnIndexOrThrow20 = i12;
                        columnIndexOrThrow21 = i13;
                        columnIndexOrThrow22 = i14;
                        columnIndexOrThrow23 = i15;
                        columnIndexOrThrow24 = i16;
                        i5 = i4;
                    }
                    query.close();
                    this.f23292a.release();
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    mVar = this;
                    query.close();
                    mVar.f23292a.release();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                mVar = this;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class n implements Callable<List<c0.c>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f23294a;

        n(final RoomSQLiteQuery val$_statement) {
            this.f23294a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<c0.c> call() throws Exception {
            n nVar;
            String string;
            int i4;
            Cursor query = DBUtil.query(f.this.f23242a, this.f23294a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "identify");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "userNumber");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "sportsType");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "sportsSet");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "startTime");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "endTime");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "countTime");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "distance");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "gpsDistance");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "latLngList");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "stepList");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "passLatLngList");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "isFaceOut");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "faceDetectCount");
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
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "confirmCount");
                    int i5 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string2 = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                        String string3 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        String string4 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                        String string5 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                        String string6 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                        String string7 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                        String string8 = query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7);
                        String string9 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                        String string10 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                        String string11 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                        String string12 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                        String string13 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                        if (query.isNull(columnIndexOrThrow13)) {
                            i4 = i5;
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow13);
                            i4 = i5;
                        }
                        String string14 = query.isNull(i4) ? null : query.getString(i4);
                        int i6 = columnIndexOrThrow15;
                        int i7 = columnIndexOrThrow;
                        String string15 = query.isNull(i6) ? null : query.getString(i6);
                        int i8 = columnIndexOrThrow16;
                        String string16 = query.isNull(i8) ? null : query.getString(i8);
                        int i9 = columnIndexOrThrow17;
                        String string17 = query.isNull(i9) ? null : query.getString(i9);
                        int i10 = columnIndexOrThrow18;
                        String string18 = query.isNull(i10) ? null : query.getString(i10);
                        int i11 = columnIndexOrThrow19;
                        String string19 = query.isNull(i11) ? null : query.getString(i11);
                        int i12 = columnIndexOrThrow20;
                        String string20 = query.isNull(i12) ? null : query.getString(i12);
                        int i13 = columnIndexOrThrow21;
                        String string21 = query.isNull(i13) ? null : query.getString(i13);
                        int i14 = columnIndexOrThrow22;
                        String string22 = query.isNull(i14) ? null : query.getString(i14);
                        int i15 = columnIndexOrThrow23;
                        String string23 = query.isNull(i15) ? null : query.getString(i15);
                        int i16 = columnIndexOrThrow24;
                        arrayList.add(new c0.c(string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string, string14, string15, string16, string17, string18, string19, string20, string21, string22, string23, query.getInt(i16)));
                        columnIndexOrThrow = i7;
                        columnIndexOrThrow15 = i6;
                        columnIndexOrThrow16 = i8;
                        columnIndexOrThrow17 = i9;
                        columnIndexOrThrow18 = i10;
                        columnIndexOrThrow19 = i11;
                        columnIndexOrThrow20 = i12;
                        columnIndexOrThrow21 = i13;
                        columnIndexOrThrow22 = i14;
                        columnIndexOrThrow23 = i15;
                        columnIndexOrThrow24 = i16;
                        i5 = i4;
                    }
                    query.close();
                    this.f23294a.release();
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    nVar = this;
                    query.close();
                    nVar.f23294a.release();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                nVar = this;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class o implements Callable<List<b0.b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f23296a;

        o(final RoomSQLiteQuery val$_statement) {
            this.f23296a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<b0.b> call() throws Exception {
            Cursor query = DBUtil.query(f.this.f23242a, this.f23296a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "count");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "distance");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "time");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(new b0.b(query.getLong(columnIndexOrThrow), query.getLong(columnIndexOrThrow2), query.getLong(columnIndexOrThrow3)));
                }
                return arrayList;
            } finally {
                query.close();
                this.f23296a.release();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class p implements Callable<List<c0.c>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f23298a;

        p(final RoomSQLiteQuery val$_statement) {
            this.f23298a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<c0.c> call() throws Exception {
            p pVar;
            String string;
            int i4;
            Cursor query = DBUtil.query(f.this.f23242a, this.f23298a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "identify");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "userNumber");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "sportsType");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "sportsSet");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "startTime");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "endTime");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "countTime");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "distance");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "gpsDistance");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "latLngList");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "stepList");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "passLatLngList");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "isFaceOut");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "faceDetectCount");
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
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "confirmCount");
                    int i5 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string2 = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                        String string3 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        String string4 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                        String string5 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                        String string6 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                        String string7 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                        String string8 = query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7);
                        String string9 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                        String string10 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                        String string11 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                        String string12 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                        String string13 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                        if (query.isNull(columnIndexOrThrow13)) {
                            i4 = i5;
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow13);
                            i4 = i5;
                        }
                        String string14 = query.isNull(i4) ? null : query.getString(i4);
                        int i6 = columnIndexOrThrow15;
                        int i7 = columnIndexOrThrow;
                        String string15 = query.isNull(i6) ? null : query.getString(i6);
                        int i8 = columnIndexOrThrow16;
                        String string16 = query.isNull(i8) ? null : query.getString(i8);
                        int i9 = columnIndexOrThrow17;
                        String string17 = query.isNull(i9) ? null : query.getString(i9);
                        int i10 = columnIndexOrThrow18;
                        String string18 = query.isNull(i10) ? null : query.getString(i10);
                        int i11 = columnIndexOrThrow19;
                        String string19 = query.isNull(i11) ? null : query.getString(i11);
                        int i12 = columnIndexOrThrow20;
                        String string20 = query.isNull(i12) ? null : query.getString(i12);
                        int i13 = columnIndexOrThrow21;
                        String string21 = query.isNull(i13) ? null : query.getString(i13);
                        int i14 = columnIndexOrThrow22;
                        String string22 = query.isNull(i14) ? null : query.getString(i14);
                        int i15 = columnIndexOrThrow23;
                        String string23 = query.isNull(i15) ? null : query.getString(i15);
                        int i16 = columnIndexOrThrow24;
                        arrayList.add(new c0.c(string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string, string14, string15, string16, string17, string18, string19, string20, string21, string22, string23, query.getInt(i16)));
                        columnIndexOrThrow = i7;
                        columnIndexOrThrow15 = i6;
                        columnIndexOrThrow16 = i8;
                        columnIndexOrThrow17 = i9;
                        columnIndexOrThrow18 = i10;
                        columnIndexOrThrow19 = i11;
                        columnIndexOrThrow20 = i12;
                        columnIndexOrThrow21 = i13;
                        columnIndexOrThrow22 = i14;
                        columnIndexOrThrow23 = i15;
                        columnIndexOrThrow24 = i16;
                        i5 = i4;
                    }
                    query.close();
                    this.f23298a.release();
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    pVar = this;
                    query.close();
                    pVar.f23298a.release();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                pVar = this;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class q extends SharedSQLiteStatement {
        q(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE sports SET countTime=?,distance=? ,gpsDistance=?,latLngList=? ,stepList=?,passLatLngList=?,isFaceOut=? ,faceDetectCount=? ,faceCheckingDistance=?,pauseLatLng=? ,isOpenDevelop=? WHERE identify=?";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class r extends SharedSQLiteStatement {
        r(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM sports WHERE identify=?";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class s extends SharedSQLiteStatement {
        s(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE sports SET uploadType=? WHERE identify=?";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class t extends SharedSQLiteStatement {
        t(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE sports SET isException=?,isValid=?, endTime=? WHERE identify=?";
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class u extends SharedSQLiteStatement {
        u(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE sports SET isValid=? WHERE identify=?";
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class v extends SharedSQLiteStatement {
        v(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE sports SET confirmCount=1 WHERE identify=?";
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class w extends SharedSQLiteStatement {
        w(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE sports SET endTime=? WHERE identify=?";
        }
    }

    /* compiled from: SportsDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class x extends SharedSQLiteStatement {
        x(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE sports SET confirmCount=confirmCount+1 WHERE identify=?";
        }
    }

    public f(RoomDatabase __db) {
        this.f23242a = __db;
        this.f23243b = new k(__db);
        this.f23244c = new q(__db);
        this.f23245d = new r(__db);
        this.f23246e = new s(__db);
        this.f23247f = new t(__db);
        this.f23248g = new u(__db);
        this.f23249h = new v(__db);
        this.f23250i = new w(__db);
        this.f23251j = new x(__db);
    }

    public static List<Class<?>> w() {
        return Collections.emptyList();
    }

    @Override // com.bxkj.student.v2.common.db.dao.e
    public Object a(final c0.c[] project, final kotlin.coroutines.c<? super f1> continuation) {
        return CoroutinesRoom.execute(this.f23242a, true, new a(project), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.e
    public Object b(final String isValid, final String identify, final kotlin.coroutines.c<? super f1> continuation) {
        return CoroutinesRoom.execute(this.f23242a, true, new CallableC0291f(isValid, identify), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.e
    public Object c(final String identity, final kotlin.coroutines.c<? super f1> continuation) {
        return CoroutinesRoom.execute(this.f23242a, true, new i(identity), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.e
    public Object d(final String countTime, final String distance, final String gpsDistance, final String latLngList, final String stepList, final String passLatLngList, final String isFaceOut, final String faceDetectCount, final String identify, final String faceCheckingDistance, final String pauseLatLng, final String isOpenDevelop, final kotlin.coroutines.c<? super f1> continuation) {
        return CoroutinesRoom.execute(this.f23242a, true, new b(countTime, distance, gpsDistance, latLngList, stepList, passLatLngList, isFaceOut, faceDetectCount, faceCheckingDistance, pauseLatLng, isOpenDevelop, identify), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.e
    public Object deleteByIdentify(final String identify, final kotlin.coroutines.c<? super f1> continuation) {
        return CoroutinesRoom.execute(this.f23242a, true, new c(identify), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.e
    public Object e(final String userNumber, final long startTime, final long endTime, final kotlin.coroutines.c<? super List<c0.c>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM sports WHERE userNumber = ? AND endTime !='' AND confirmCount==0 AND startTime BETWEEN ? And ?", 3);
        if (userNumber == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, userNumber);
        }
        acquire.bindLong(2, startTime);
        acquire.bindLong(3, endTime);
        return CoroutinesRoom.execute(this.f23242a, false, DBUtil.createCancellationSignal(), new n(acquire), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.e
    public Object f(final String identify, final String endTime, final kotlin.coroutines.c<? super f1> continuation) {
        return CoroutinesRoom.execute(this.f23242a, true, new h(endTime, identify), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.e
    public Object g(final String userNumber, final kotlin.coroutines.c<? super List<c0.c>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM sports WHERE userNumber = ? AND  confirmCount > 0", 1);
        if (userNumber == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, userNumber);
        }
        return CoroutinesRoom.execute(this.f23242a, false, DBUtil.createCancellationSignal(), new p(acquire), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.e
    public Object getExceptionSports(final String userNumber, final kotlin.coroutines.c<? super List<c0.c>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM sports WHERE userNumber = ? AND endTime ==''", 1);
        if (userNumber == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, userNumber);
        }
        return CoroutinesRoom.execute(this.f23242a, false, DBUtil.createCancellationSignal(), new l(acquire), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.e
    public Object getLocalRecordById(final String identify, final kotlin.coroutines.c<? super List<c0.c>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM sports WHERE identify = ?", 1);
        if (identify == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, identify);
        }
        return CoroutinesRoom.execute(this.f23242a, false, DBUtil.createCancellationSignal(), new j(acquire), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.e
    public Object h(final String userNumber, final kotlin.coroutines.c<? super List<c0.c>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM sports WHERE userNumber = ? AND endTime !='' AND confirmCount==0", 1);
        if (userNumber == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, userNumber);
        }
        return CoroutinesRoom.execute(this.f23242a, false, DBUtil.createCancellationSignal(), new m(acquire), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.e
    public Object i(final String userNumber, final long startTime, final long endTime, final kotlin.coroutines.c<? super List<b0.b>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(identify) as count, sum(distance) AS distance,sum(countTime) AS time FROM sports WHERE userNumber = ? AND endTime !='' AND confirmCount==0 AND startTime BETWEEN ? And ?", 3);
        if (userNumber == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, userNumber);
        }
        acquire.bindLong(2, startTime);
        acquire.bindLong(3, endTime);
        return CoroutinesRoom.execute(this.f23242a, false, DBUtil.createCancellationSignal(), new o(acquire), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.e
    public Object j(final String uploadType, final String identify, final kotlin.coroutines.c<? super f1> continuation) {
        return CoroutinesRoom.execute(this.f23242a, true, new d(uploadType, identify), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.e
    public Object k(final String isException, final String isValid, final String endTime, final String identify, final kotlin.coroutines.c<? super f1> continuation) {
        return CoroutinesRoom.execute(this.f23242a, true, new e(isException, isValid, endTime, identify), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.e
    public Object l(final String identify, final kotlin.coroutines.c<? super f1> continuation) {
        return CoroutinesRoom.execute(this.f23242a, true, new g(identify), continuation);
    }
}
