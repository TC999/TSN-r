package com.bxkj.student.v2.common.db.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bxkj.student.v2.common.db.dao.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.f1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: SportsSetDao_Impl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class h implements g {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f23310a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<c0.d> f23311b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsSetDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class a extends EntityInsertionAdapter<c0.d> {
        a(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement stmt, c0.d value) {
            if (value.g() == null) {
                stmt.bindNull(1);
            } else {
                stmt.bindString(1, value.g());
            }
            if (value.getType() == null) {
                stmt.bindNull(2);
            } else {
                stmt.bindString(2, value.getType());
            }
            if (value.f() == null) {
                stmt.bindNull(3);
            } else {
                stmt.bindString(3, value.f());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `sports_set` (`userId`,`type`,`content`) VALUES (?,?,?)";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsSetDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class b implements Callable<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c0.d f23313a;

        b(final c0.d val$sportsSetDb) {
            this.f23313a = val$sportsSetDb;
        }

        @Override // java.util.concurrent.Callable
        public f1 call() throws Exception {
            h.this.f23310a.beginTransaction();
            try {
                h.this.f23311b.insert((EntityInsertionAdapter) this.f23313a);
                h.this.f23310a.setTransactionSuccessful();
                return f1.f55527a;
            } finally {
                h.this.f23310a.endTransaction();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsSetDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class c implements Callable<List<c0.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f23315a;

        c(final RoomSQLiteQuery val$_statement) {
            this.f23315a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<c0.d> call() throws Exception {
            Cursor query = DBUtil.query(h.this.f23310a, this.f23315a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "userId");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "content");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(new c0.d(query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3)));
                }
                return arrayList;
            } finally {
                query.close();
                this.f23315a.release();
            }
        }
    }

    public h(RoomDatabase __db) {
        this.f23310a = __db;
        this.f23311b = new a(__db);
    }

    public static List<Class<?>> e() {
        return Collections.emptyList();
    }

    @Override // com.bxkj.student.v2.common.db.dao.g
    public Object a(final String userId, final String type, final kotlin.coroutines.c<? super List<c0.d>> continuation) {
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
        return CoroutinesRoom.execute(this.f23310a, false, DBUtil.createCancellationSignal(), new c(acquire), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.g
    public Object b(final String type, final kotlin.coroutines.c<? super String> continuation) {
        return g.a.a(this, type, continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.g
    public Object insert(final c0.d sportsSetDb, final kotlin.coroutines.c<? super f1> continuation) {
        return CoroutinesRoom.execute(this.f23310a, true, new b(sportsSetDb), continuation);
    }
}
