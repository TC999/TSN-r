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
/* compiled from: FaceDao_Impl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b implements com.bxkj.student.v2.common.db.dao.a {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f23188a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<c0.a> f23189b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f23190c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f23191d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FaceDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class a extends EntityInsertionAdapter<c0.a> {
        a(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement stmt, c0.a value) {
            stmt.bindLong(1, value.h());
            if (value.i() == null) {
                stmt.bindNull(2);
            } else {
                stmt.bindString(2, value.i());
            }
            if (value.getType() == null) {
                stmt.bindNull(3);
            } else {
                stmt.bindString(3, value.getType());
            }
            if (value.g() == null) {
                stmt.bindNull(4);
            } else {
                stmt.bindString(4, value.g());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `face` (`id`,`identify`,`type`,`facePath`) VALUES (nullif(?, 0),?,?,?)";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FaceDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class C0289b extends SharedSQLiteStatement {
        C0289b(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM face WHERE identify=?";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FaceDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class c extends SharedSQLiteStatement {
        c(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM face";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FaceDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class d implements Callable<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c0.a f23195a;

        d(final c0.a val$faceDb) {
            this.f23195a = val$faceDb;
        }

        @Override // java.util.concurrent.Callable
        public f1 call() throws Exception {
            b.this.f23188a.beginTransaction();
            try {
                b.this.f23189b.insert((EntityInsertionAdapter) this.f23195a);
                b.this.f23188a.setTransactionSuccessful();
                return f1.f55527a;
            } finally {
                b.this.f23188a.endTransaction();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FaceDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class e implements Callable<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23197a;

        e(final String val$identify) {
            this.f23197a = val$identify;
        }

        @Override // java.util.concurrent.Callable
        public f1 call() throws Exception {
            SupportSQLiteStatement acquire = b.this.f23190c.acquire();
            String str = this.f23197a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            b.this.f23188a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                b.this.f23188a.setTransactionSuccessful();
                return f1.f55527a;
            } finally {
                b.this.f23188a.endTransaction();
                b.this.f23190c.release(acquire);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FaceDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class f implements Callable<f1> {
        f() {
        }

        @Override // java.util.concurrent.Callable
        public f1 call() throws Exception {
            SupportSQLiteStatement acquire = b.this.f23191d.acquire();
            b.this.f23188a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                b.this.f23188a.setTransactionSuccessful();
                return f1.f55527a;
            } finally {
                b.this.f23188a.endTransaction();
                b.this.f23191d.release(acquire);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FaceDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class g implements Callable<List<c0.a>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f23200a;

        g(final RoomSQLiteQuery val$_statement) {
            this.f23200a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<c0.a> call() throws Exception {
            Cursor query = DBUtil.query(b.this.f23188a, this.f23200a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "identify");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "facePath");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(new c0.a(query.getLong(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4)));
                }
                return arrayList;
            } finally {
                query.close();
                this.f23200a.release();
            }
        }
    }

    public b(RoomDatabase __db) {
        this.f23188a = __db;
        this.f23189b = new a(__db);
        this.f23190c = new C0289b(__db);
        this.f23191d = new c(__db);
    }

    public static List<Class<?>> g() {
        return Collections.emptyList();
    }

    @Override // com.bxkj.student.v2.common.db.dao.a
    public Object a(final kotlin.coroutines.c<? super f1> continuation) {
        return CoroutinesRoom.execute(this.f23188a, true, new f(), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.a
    public Object b(final String identify, final kotlin.coroutines.c<? super List<c0.a>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM face WHERE identify=?", 1);
        if (identify == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, identify);
        }
        return CoroutinesRoom.execute(this.f23188a, false, DBUtil.createCancellationSignal(), new g(acquire), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.a
    public Object deleteByIdentify(final String identify, final kotlin.coroutines.c<? super f1> continuation) {
        return CoroutinesRoom.execute(this.f23188a, true, new e(identify), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.a
    public Object insert(final c0.a faceDb, final kotlin.coroutines.c<? super f1> continuation) {
        return CoroutinesRoom.execute(this.f23188a, true, new d(faceDb), continuation);
    }
}
