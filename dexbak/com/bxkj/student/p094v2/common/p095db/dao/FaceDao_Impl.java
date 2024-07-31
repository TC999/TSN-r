package com.bxkj.student.p094v2.common.p095db.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.p021db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import p027c0.FaceDb;

/* renamed from: com.bxkj.student.v2.common.db.dao.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class FaceDao_Impl implements FaceDao {

    /* renamed from: a */
    private final RoomDatabase f19952a;

    /* renamed from: b */
    private final EntityInsertionAdapter<FaceDb> f19953b;

    /* renamed from: c */
    private final SharedSQLiteStatement f19954c;

    /* renamed from: d */
    private final SharedSQLiteStatement f19955d;

    /* compiled from: FaceDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.b$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5486a extends EntityInsertionAdapter<FaceDb> {
        C5486a(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement stmt, FaceDb value) {
            stmt.bindLong(1, value.m58178h());
            if (value.m58177i() == null) {
                stmt.bindNull(2);
            } else {
                stmt.bindString(2, value.m58177i());
            }
            if (value.getType() == null) {
                stmt.bindNull(3);
            } else {
                stmt.bindString(3, value.getType());
            }
            if (value.m58179g() == null) {
                stmt.bindNull(4);
            } else {
                stmt.bindString(4, value.m58179g());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `face` (`id`,`identify`,`type`,`facePath`) VALUES (nullif(?, 0),?,?,?)";
        }
    }

    /* compiled from: FaceDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.b$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5487b extends SharedSQLiteStatement {
        C5487b(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM face WHERE identify=?";
        }
    }

    /* compiled from: FaceDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.b$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5488c extends SharedSQLiteStatement {
        C5488c(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM face";
        }
    }

    /* compiled from: FaceDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.b$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5489d implements Callable<Unit> {

        /* renamed from: a */
        final /* synthetic */ FaceDb f19959a;

        CallableC5489d(final FaceDb val$faceDb) {
            this.f19959a = val$faceDb;
        }

        @Override // java.util.concurrent.Callable
        public Unit call() throws Exception {
            FaceDao_Impl.this.f19952a.beginTransaction();
            try {
                FaceDao_Impl.this.f19953b.insert((EntityInsertionAdapter) this.f19959a);
                FaceDao_Impl.this.f19952a.setTransactionSuccessful();
                return Unit.f41048a;
            } finally {
                FaceDao_Impl.this.f19952a.endTransaction();
            }
        }
    }

    /* compiled from: FaceDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.b$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5490e implements Callable<Unit> {

        /* renamed from: a */
        final /* synthetic */ String f19961a;

        CallableC5490e(final String val$identify) {
            this.f19961a = val$identify;
        }

        @Override // java.util.concurrent.Callable
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = FaceDao_Impl.this.f19954c.acquire();
            String str = this.f19961a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            FaceDao_Impl.this.f19952a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                FaceDao_Impl.this.f19952a.setTransactionSuccessful();
                return Unit.f41048a;
            } finally {
                FaceDao_Impl.this.f19952a.endTransaction();
                FaceDao_Impl.this.f19954c.release(acquire);
            }
        }
    }

    /* compiled from: FaceDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.b$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5491f implements Callable<Unit> {
        CallableC5491f() {
        }

        @Override // java.util.concurrent.Callable
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = FaceDao_Impl.this.f19955d.acquire();
            FaceDao_Impl.this.f19952a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                FaceDao_Impl.this.f19952a.setTransactionSuccessful();
                return Unit.f41048a;
            } finally {
                FaceDao_Impl.this.f19952a.endTransaction();
                FaceDao_Impl.this.f19955d.release(acquire);
            }
        }
    }

    /* compiled from: FaceDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.b$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5492g implements Callable<List<FaceDb>> {

        /* renamed from: a */
        final /* synthetic */ RoomSQLiteQuery f19964a;

        CallableC5492g(final RoomSQLiteQuery val$_statement) {
            this.f19964a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<FaceDb> call() throws Exception {
            Cursor query = DBUtil.query(FaceDao_Impl.this.f19952a, this.f19964a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "identify");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "facePath");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(new FaceDb(query.getLong(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4)));
                }
                return arrayList;
            } finally {
                query.close();
                this.f19964a.release();
            }
        }
    }

    public FaceDao_Impl(RoomDatabase __db) {
        this.f19952a = __db;
        this.f19953b = new C5486a(__db);
        this.f19954c = new C5487b(__db);
        this.f19955d = new C5488c(__db);
    }

    /* renamed from: g */
    public static List<Class<?>> m39206g() {
        return Collections.emptyList();
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.FaceDao
    /* renamed from: a */
    public Object mo39212a(final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f19952a, true, new CallableC5491f(), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.FaceDao
    /* renamed from: b */
    public Object mo39211b(final String identify, final InterfaceC14268c<? super List<FaceDb>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM face WHERE identify=?", 1);
        if (identify == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, identify);
        }
        return CoroutinesRoom.execute(this.f19952a, false, DBUtil.createCancellationSignal(), new CallableC5492g(acquire), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.FaceDao
    public Object deleteByIdentify(final String identify, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f19952a, true, new CallableC5490e(identify), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.FaceDao
    public Object insert(final FaceDb faceDb, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f19952a, true, new CallableC5489d(faceDb), continuation);
    }
}
