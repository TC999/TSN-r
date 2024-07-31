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
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import p027c0.MenuDb;

/* renamed from: com.bxkj.student.v2.common.db.dao.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class MenuDao_Impl implements MenuDao {

    /* renamed from: a */
    private final RoomDatabase f19966a;

    /* renamed from: b */
    private final EntityInsertionAdapter<MenuDb> f19967b;

    /* renamed from: c */
    private final EntityDeletionOrUpdateAdapter<MenuDb> f19968c;

    /* renamed from: d */
    private final SharedSQLiteStatement f19969d;

    /* renamed from: e */
    private final SharedSQLiteStatement f19970e;

    /* renamed from: f */
    private final SharedSQLiteStatement f19971f;

    /* renamed from: g */
    private final SharedSQLiteStatement f19972g;

    /* renamed from: h */
    private final SharedSQLiteStatement f19973h;

    /* compiled from: MenuDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.d$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5493a implements Callable<Unit> {

        /* renamed from: a */
        final /* synthetic */ String f19974a;

        CallableC5493a(final String val$mkey) {
            this.f19974a = val$mkey;
        }

        @Override // java.util.concurrent.Callable
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = MenuDao_Impl.this.f19969d.acquire();
            String str = this.f19974a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            MenuDao_Impl.this.f19966a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                MenuDao_Impl.this.f19966a.setTransactionSuccessful();
                return Unit.f41048a;
            } finally {
                MenuDao_Impl.this.f19966a.endTransaction();
                MenuDao_Impl.this.f19969d.release(acquire);
            }
        }
    }

    /* compiled from: MenuDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.d$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5494b implements Callable<Unit> {

        /* renamed from: a */
        final /* synthetic */ String f19976a;

        /* renamed from: b */
        final /* synthetic */ String f19977b;

        CallableC5494b(final String val$icon, final String val$mkey) {
            this.f19976a = val$icon;
            this.f19977b = val$mkey;
        }

        @Override // java.util.concurrent.Callable
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = MenuDao_Impl.this.f19970e.acquire();
            String str = this.f19976a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            String str2 = this.f19977b;
            if (str2 == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindString(2, str2);
            }
            MenuDao_Impl.this.f19966a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                MenuDao_Impl.this.f19966a.setTransactionSuccessful();
                return Unit.f41048a;
            } finally {
                MenuDao_Impl.this.f19966a.endTransaction();
                MenuDao_Impl.this.f19970e.release(acquire);
            }
        }
    }

    /* compiled from: MenuDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.d$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5495c implements Callable<Unit> {

        /* renamed from: a */
        final /* synthetic */ String f19979a;

        /* renamed from: b */
        final /* synthetic */ String f19980b;

        CallableC5495c(final String val$type, final String val$mkey) {
            this.f19979a = val$type;
            this.f19980b = val$mkey;
        }

        @Override // java.util.concurrent.Callable
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = MenuDao_Impl.this.f19971f.acquire();
            String str = this.f19979a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            String str2 = this.f19980b;
            if (str2 == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindString(2, str2);
            }
            MenuDao_Impl.this.f19966a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                MenuDao_Impl.this.f19966a.setTransactionSuccessful();
                return Unit.f41048a;
            } finally {
                MenuDao_Impl.this.f19966a.endTransaction();
                MenuDao_Impl.this.f19971f.release(acquire);
            }
        }
    }

    /* compiled from: MenuDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.d$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5496d implements Callable<Unit> {

        /* renamed from: a */
        final /* synthetic */ String f19982a;

        /* renamed from: b */
        final /* synthetic */ String f19983b;

        CallableC5496d(final String val$iconS, final String val$mkey) {
            this.f19982a = val$iconS;
            this.f19983b = val$mkey;
        }

        @Override // java.util.concurrent.Callable
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = MenuDao_Impl.this.f19972g.acquire();
            String str = this.f19982a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            String str2 = this.f19983b;
            if (str2 == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindString(2, str2);
            }
            MenuDao_Impl.this.f19966a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                MenuDao_Impl.this.f19966a.setTransactionSuccessful();
                return Unit.f41048a;
            } finally {
                MenuDao_Impl.this.f19966a.endTransaction();
                MenuDao_Impl.this.f19972g.release(acquire);
            }
        }
    }

    /* compiled from: MenuDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.d$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5497e implements Callable<Integer> {

        /* renamed from: a */
        final /* synthetic */ int f19985a;

        CallableC5497e(final int val$menuType) {
            this.f19985a = val$menuType;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            SupportSQLiteStatement acquire = MenuDao_Impl.this.f19973h.acquire();
            acquire.bindLong(1, this.f19985a);
            MenuDao_Impl.this.f19966a.beginTransaction();
            try {
                Integer valueOf = Integer.valueOf(acquire.executeUpdateDelete());
                MenuDao_Impl.this.f19966a.setTransactionSuccessful();
                return valueOf;
            } finally {
                MenuDao_Impl.this.f19966a.endTransaction();
                MenuDao_Impl.this.f19973h.release(acquire);
            }
        }
    }

    /* compiled from: MenuDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.d$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5498f implements Callable<List<MenuDb>> {

        /* renamed from: a */
        final /* synthetic */ RoomSQLiteQuery f19987a;

        CallableC5498f(final RoomSQLiteQuery val$_statement) {
            this.f19987a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<MenuDb> call() throws Exception {
            CallableC5498f callableC5498f = this;
            Cursor query = DBUtil.query(MenuDao_Impl.this.f19966a, callableC5498f.f19987a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mkey");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, RewardPlus.ICON);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "iconS");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "isShow");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "isEnabled");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "isLogin");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "linkUrl");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "lastUploadTime");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "sort");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "isShowIndex");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "homeSort");
                try {
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new MenuDb(query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5), query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8), query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9), query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10), query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11), query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12), query.isNull(columnIndexOrThrow13) ? null : query.getString(columnIndexOrThrow13)));
                    }
                    query.close();
                    this.f19987a.release();
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    callableC5498f = this;
                    query.close();
                    callableC5498f.f19987a.release();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* compiled from: MenuDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.d$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5499g implements Callable<List<MenuDb>> {

        /* renamed from: a */
        final /* synthetic */ RoomSQLiteQuery f19989a;

        CallableC5499g(final RoomSQLiteQuery val$_statement) {
            this.f19989a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<MenuDb> call() throws Exception {
            CallableC5499g callableC5499g = this;
            Cursor query = DBUtil.query(MenuDao_Impl.this.f19966a, callableC5499g.f19989a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mkey");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, RewardPlus.ICON);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "iconS");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "isShow");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "isEnabled");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "isLogin");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "linkUrl");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "lastUploadTime");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "sort");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "isShowIndex");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "homeSort");
                try {
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new MenuDb(query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5), query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8), query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9), query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10), query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11), query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12), query.isNull(columnIndexOrThrow13) ? null : query.getString(columnIndexOrThrow13)));
                    }
                    query.close();
                    this.f19989a.release();
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    callableC5499g = this;
                    query.close();
                    callableC5499g.f19989a.release();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* compiled from: MenuDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.d$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5500h implements Callable<List<MenuDb>> {

        /* renamed from: a */
        final /* synthetic */ RoomSQLiteQuery f19991a;

        CallableC5500h(final RoomSQLiteQuery val$_statement) {
            this.f19991a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<MenuDb> call() throws Exception {
            CallableC5500h callableC5500h = this;
            Cursor query = DBUtil.query(MenuDao_Impl.this.f19966a, callableC5500h.f19991a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mkey");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, RewardPlus.ICON);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "iconS");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "isShow");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "isEnabled");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "isLogin");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "linkUrl");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "lastUploadTime");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "sort");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "isShowIndex");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "homeSort");
                try {
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new MenuDb(query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5), query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8), query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9), query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10), query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11), query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12), query.isNull(columnIndexOrThrow13) ? null : query.getString(columnIndexOrThrow13)));
                    }
                    query.close();
                    this.f19991a.release();
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    callableC5500h = this;
                    query.close();
                    callableC5500h.f19991a.release();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* compiled from: MenuDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.d$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5501i implements Callable<List<MenuDb>> {

        /* renamed from: a */
        final /* synthetic */ RoomSQLiteQuery f19993a;

        CallableC5501i(final RoomSQLiteQuery val$_statement) {
            this.f19993a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<MenuDb> call() throws Exception {
            CallableC5501i callableC5501i = this;
            Cursor query = DBUtil.query(MenuDao_Impl.this.f19966a, callableC5501i.f19993a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mkey");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, RewardPlus.ICON);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "iconS");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "isShow");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "isEnabled");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "isLogin");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "linkUrl");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "lastUploadTime");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "sort");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "isShowIndex");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "homeSort");
                try {
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new MenuDb(query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5), query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8), query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9), query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10), query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11), query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12), query.isNull(columnIndexOrThrow13) ? null : query.getString(columnIndexOrThrow13)));
                    }
                    query.close();
                    this.f19993a.release();
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    callableC5501i = this;
                    query.close();
                    callableC5501i.f19993a.release();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* compiled from: MenuDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.d$j */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5502j extends EntityInsertionAdapter<MenuDb> {
        C5502j(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement stmt, MenuDb value) {
            if (value.m58138u() == null) {
                stmt.bindNull(1);
            } else {
                stmt.bindString(1, value.m58138u());
            }
            if (value.m58137v() == null) {
                stmt.bindNull(2);
            } else {
                stmt.bindString(2, value.m58137v());
            }
            if (value.m58142q() == null) {
                stmt.bindNull(3);
            } else {
                stmt.bindString(3, value.m58142q());
            }
            if (value.m58141r() == null) {
                stmt.bindNull(4);
            } else {
                stmt.bindString(4, value.m58141r());
            }
            if (value.m58133z() == null) {
                stmt.bindNull(5);
            } else {
                stmt.bindString(5, value.m58133z());
            }
            if (value.m58135x() == null) {
                stmt.bindNull(6);
            } else {
                stmt.bindString(6, value.m58135x());
            }
            stmt.bindLong(7, value.m58134y());
            if (value.m58139t() == null) {
                stmt.bindNull(8);
            } else {
                stmt.bindString(8, value.m58139t());
            }
            if (value.getType() == null) {
                stmt.bindNull(9);
            } else {
                stmt.bindString(9, value.getType());
            }
            if (value.m58140s() == null) {
                stmt.bindNull(10);
            } else {
                stmt.bindString(10, value.m58140s());
            }
            if (value.m58136w() == null) {
                stmt.bindNull(11);
            } else {
                stmt.bindString(11, value.m58136w());
            }
            if (value.m58172A() == null) {
                stmt.bindNull(12);
            } else {
                stmt.bindString(12, value.m58172A());
            }
            if (value.m58143p() == null) {
                stmt.bindNull(13);
            } else {
                stmt.bindString(13, value.m58143p());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `menu` (`mkey`,`name`,`icon`,`iconS`,`isShow`,`isEnabled`,`isLogin`,`linkUrl`,`type`,`lastUploadTime`,`sort`,`isShowIndex`,`homeSort`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* compiled from: MenuDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.d$k */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5503k extends EntityDeletionOrUpdateAdapter<MenuDb> {
        C5503k(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement stmt, MenuDb value) {
            if (value.m58138u() == null) {
                stmt.bindNull(1);
            } else {
                stmt.bindString(1, value.m58138u());
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `menu` WHERE `mkey` = ?";
        }
    }

    /* compiled from: MenuDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.d$l */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5504l extends SharedSQLiteStatement {
        C5504l(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM menu WHERE mkey=?";
        }
    }

    /* compiled from: MenuDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.d$m */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5505m extends SharedSQLiteStatement {
        C5505m(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE menu SET icon=? WHERE mkey=?";
        }
    }

    /* compiled from: MenuDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.d$n */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5506n extends SharedSQLiteStatement {
        C5506n(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE menu SET type=? WHERE mkey=?";
        }
    }

    /* compiled from: MenuDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.d$o */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5507o extends SharedSQLiteStatement {
        C5507o(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE menu SET iconS=? WHERE mkey=?";
        }
    }

    /* compiled from: MenuDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.d$p */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5508p extends SharedSQLiteStatement {
        C5508p(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE  FROM menu WHERE type=?";
        }
    }

    /* compiled from: MenuDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.d$q */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5509q implements Callable<Unit> {

        /* renamed from: a */
        final /* synthetic */ MenuDb[] f20002a;

        CallableC5509q(final MenuDb[] val$menu) {
            this.f20002a = val$menu;
        }

        @Override // java.util.concurrent.Callable
        public Unit call() throws Exception {
            MenuDao_Impl.this.f19966a.beginTransaction();
            try {
                MenuDao_Impl.this.f19967b.insert((Object[]) this.f20002a);
                MenuDao_Impl.this.f19966a.setTransactionSuccessful();
                return Unit.f41048a;
            } finally {
                MenuDao_Impl.this.f19966a.endTransaction();
            }
        }
    }

    /* compiled from: MenuDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.d$r */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CallableC5510r implements Callable<Unit> {

        /* renamed from: a */
        final /* synthetic */ MenuDb f20004a;

        CallableC5510r(final MenuDb val$menu) {
            this.f20004a = val$menu;
        }

        @Override // java.util.concurrent.Callable
        public Unit call() throws Exception {
            MenuDao_Impl.this.f19966a.beginTransaction();
            try {
                MenuDao_Impl.this.f19968c.handle(this.f20004a);
                MenuDao_Impl.this.f19966a.setTransactionSuccessful();
                return Unit.f41048a;
            } finally {
                MenuDao_Impl.this.f19966a.endTransaction();
            }
        }
    }

    public MenuDao_Impl(RoomDatabase __db) {
        this.f19966a = __db;
        this.f19967b = new C5502j(__db);
        this.f19968c = new C5503k(__db);
        this.f19969d = new C5504l(__db);
        this.f19970e = new C5505m(__db);
        this.f19971f = new C5506n(__db);
        this.f19972g = new C5507o(__db);
        this.f19973h = new C5508p(__db);
    }

    /* renamed from: t */
    public static List<Class<?>> m39185t() {
        return Collections.emptyList();
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.MenuDao
    /* renamed from: a */
    public Object mo39204a(final MenuDb[] menu, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f19966a, true, new CallableC5509q(menu), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.MenuDao
    /* renamed from: b */
    public Object mo39203b(final String icon, final String mkey, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f19966a, true, new CallableC5494b(icon, mkey), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.MenuDao
    /* renamed from: c */
    public Object mo39202c(final String iconS, final String mkey, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f19966a, true, new CallableC5496d(iconS, mkey), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.MenuDao
    /* renamed from: d */
    public Object mo39201d(final String menuType, final InterfaceC14268c<? super List<MenuDb>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM menu WHERE type=? Order By cast(sort as INTEGER)", 1);
        if (menuType == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, menuType);
        }
        return CoroutinesRoom.execute(this.f19966a, false, DBUtil.createCancellationSignal(), new CallableC5499g(acquire), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.MenuDao
    /* renamed from: e */
    public Object mo39200e(final String type, final String mkey, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f19966a, true, new CallableC5495c(type, mkey), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.MenuDao
    /* renamed from: f */
    public Object mo39199f(final MenuDb menu, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f19966a, true, new CallableC5510r(menu), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.MenuDao
    /* renamed from: g */
    public Object mo39198g(final int menuType, final InterfaceC14268c<? super Integer> continuation) {
        return CoroutinesRoom.execute(this.f19966a, true, new CallableC5497e(menuType), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.MenuDao
    /* renamed from: h */
    public Object mo39197h(final InterfaceC14268c<? super List<MenuDb>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM menu WHERE isShowIndex='1' Order By cast(homeSort as INTEGER)", 0);
        return CoroutinesRoom.execute(this.f19966a, false, DBUtil.createCancellationSignal(), new CallableC5500h(acquire), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.MenuDao
    /* renamed from: i */
    public Object mo39196i(final InterfaceC14268c<? super List<MenuDb>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM menu", 0);
        return CoroutinesRoom.execute(this.f19966a, false, DBUtil.createCancellationSignal(), new CallableC5498f(acquire), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.MenuDao
    /* renamed from: j */
    public Object mo39195j(final String mkey, final InterfaceC14268c<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f19966a, true, new CallableC5493a(mkey), continuation);
    }

    @Override // com.bxkj.student.p094v2.common.p095db.dao.MenuDao
    /* renamed from: k */
    public Object mo39194k(final String mkey, final InterfaceC14268c<? super List<MenuDb>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM menu WHERE mkey=?", 1);
        if (mkey == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, mkey);
        }
        return CoroutinesRoom.execute(this.f19966a, false, DBUtil.createCancellationSignal(), new CallableC5501i(acquire), continuation);
    }
}
