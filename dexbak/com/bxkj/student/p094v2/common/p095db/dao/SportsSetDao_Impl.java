package com.bxkj.student.p094v2.common.p095db.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.p021db.SupportSQLiteStatement;
import com.bxkj.student.p094v2.common.p095db.dao.SportsSetDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import p027c0.SportsSetDb;

/* renamed from: com.bxkj.student.v2.common.db.dao.h */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SportsSetDao_Impl implements SportsSetDao {

    /* renamed from: a */
    private final RoomDatabase f20065a;

    /* renamed from: b */
    private final EntityInsertionAdapter<SportsSetDb> f20066b;

    /* compiled from: SportsSetDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.h$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5533a extends EntityInsertionAdapter<SportsSetDb> {
        C5533a(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement stmt, SportsSetDb value) {
            if (value.m58055g() == null) {
                stmt.bindNull(1);
            } else {
                stmt.bindString(1, value.m58055g());
            }
            if (value.getType() == null) {
                stmt.bindNull(2);
            } else {
                stmt.bindString(2, value.getType());
            }
            if (value.m58056f() == null) {
                stmt.bindNull(3);
            } else {
                stmt.bindString(3, value.m58056f());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `sports_set` (`userId`,`type`,`content`) VALUES (?,?,?)";
        }
    }

    /* compiled from: SportsSetDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.h$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5534b implements Callable<Unit> {

        /* renamed from: a */
        final /* synthetic */ SportsSetDb f20068a;

        CallableC5534b(final SportsSetDb val$sportsSetDb) {
            this.f20068a = val$sportsSetDb;
        }

        @Override // java.util.concurrent.Callable
        public Unit call() throws Exception {
            SportsSetDao_Impl.this.f20065a.beginTransaction();
            try {
                SportsSetDao_Impl.this.f20066b.insert((EntityInsertionAdapter) this.f20068a);
                SportsSetDao_Impl.this.f20065a.setTransactionSuccessful();
                return Unit.f41048a;
            } finally {
                SportsSetDao_Impl.this.f20065a.endTransaction();
            }
        }
    }

    /* compiled from: SportsSetDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.h$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5535c implements Callable<List<SportsSetDb>> {

        /* renamed from: a */
        final /* synthetic */ RoomSQLiteQuery f20070a;

        CallableC5535c(final RoomSQLiteQuery val$_statement) {
            this.f20070a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<SportsSetDb> call() throws Exception {
            Cursor query = DBUtil.query(SportsSetDao_Impl.this.f20065a, this.f20070a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "userId");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "content");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(new SportsSetDb(query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3)));
                }
                return arrayList;
            } finally {
                query.close();
                this.f20070a.release();
            }
        }
    }

    public SportsSetDao_Impl(RoomDatabase __db) {
        this.f20065a = __db;
        this.f20066b = new C5533a(__db);
    }

    /* renamed from: e */
    public static List<Class<?>> m39156e() {
        return Collections.emptyList();
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.SportsSetDao
    /* renamed from: a */
    public Object mo39160a(final String userId, final String type, final InterfaceC14268c<? super List<SportsSetDb>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM sports_set WHERE userId = ? AND type =?", 2);
        if (userId == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, userId);
        }
        if (type == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, type);
        }
        return CoroutinesRoom.execute(this.f20065a, false, DBUtil.createCancellationSignal(), new CallableC5535c(acquire), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.SportsSetDao
    /* renamed from: b */
    public Object mo39159b(final String type, final InterfaceC14268c<? super String> continuation) {
        return SportsSetDao.C5531a.m39161a(this, type, continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.SportsSetDao
    public Object insert(final SportsSetDb sportsSetDb, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f20065a, true, new CallableC5534b(sportsSetDb), continuation);
    }
}
