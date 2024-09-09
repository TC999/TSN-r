package com.bxkj.student.v2.common.db.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.f1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: MenuDao_Impl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d implements com.bxkj.student.v2.common.db.dao.c {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f23202a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<c0.b> f23203b;

    /* renamed from: c  reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<c0.b> f23204c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f23205d;

    /* renamed from: e  reason: collision with root package name */
    private final SharedSQLiteStatement f23206e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedSQLiteStatement f23207f;

    /* renamed from: g  reason: collision with root package name */
    private final SharedSQLiteStatement f23208g;

    /* renamed from: h  reason: collision with root package name */
    private final SharedSQLiteStatement f23209h;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class a implements Callable<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23210a;

        a(final String val$mkey) {
            this.f23210a = val$mkey;
        }

        @Override // java.util.concurrent.Callable
        public f1 call() throws Exception {
            SupportSQLiteStatement acquire = d.this.f23205d.acquire();
            String str = this.f23210a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            d.this.f23202a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                d.this.f23202a.setTransactionSuccessful();
                return f1.f55527a;
            } finally {
                d.this.f23202a.endTransaction();
                d.this.f23205d.release(acquire);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class b implements Callable<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23212a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f23213b;

        b(final String val$icon, final String val$mkey) {
            this.f23212a = val$icon;
            this.f23213b = val$mkey;
        }

        @Override // java.util.concurrent.Callable
        public f1 call() throws Exception {
            SupportSQLiteStatement acquire = d.this.f23206e.acquire();
            String str = this.f23212a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            String str2 = this.f23213b;
            if (str2 == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindString(2, str2);
            }
            d.this.f23202a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                d.this.f23202a.setTransactionSuccessful();
                return f1.f55527a;
            } finally {
                d.this.f23202a.endTransaction();
                d.this.f23206e.release(acquire);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class c implements Callable<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23215a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f23216b;

        c(final String val$type, final String val$mkey) {
            this.f23215a = val$type;
            this.f23216b = val$mkey;
        }

        @Override // java.util.concurrent.Callable
        public f1 call() throws Exception {
            SupportSQLiteStatement acquire = d.this.f23207f.acquire();
            String str = this.f23215a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            String str2 = this.f23216b;
            if (str2 == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindString(2, str2);
            }
            d.this.f23202a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                d.this.f23202a.setTransactionSuccessful();
                return f1.f55527a;
            } finally {
                d.this.f23202a.endTransaction();
                d.this.f23207f.release(acquire);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuDao_Impl.java */
    /* renamed from: com.bxkj.student.v2.common.db.dao.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class CallableC0290d implements Callable<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23218a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f23219b;

        CallableC0290d(final String val$iconS, final String val$mkey) {
            this.f23218a = val$iconS;
            this.f23219b = val$mkey;
        }

        @Override // java.util.concurrent.Callable
        public f1 call() throws Exception {
            SupportSQLiteStatement acquire = d.this.f23208g.acquire();
            String str = this.f23218a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            String str2 = this.f23219b;
            if (str2 == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindString(2, str2);
            }
            d.this.f23202a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                d.this.f23202a.setTransactionSuccessful();
                return f1.f55527a;
            } finally {
                d.this.f23202a.endTransaction();
                d.this.f23208g.release(acquire);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class e implements Callable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f23221a;

        e(final int val$menuType) {
            this.f23221a = val$menuType;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            SupportSQLiteStatement acquire = d.this.f23209h.acquire();
            acquire.bindLong(1, this.f23221a);
            d.this.f23202a.beginTransaction();
            try {
                Integer valueOf = Integer.valueOf(acquire.executeUpdateDelete());
                d.this.f23202a.setTransactionSuccessful();
                return valueOf;
            } finally {
                d.this.f23202a.endTransaction();
                d.this.f23209h.release(acquire);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class f implements Callable<List<c0.b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f23223a;

        f(final RoomSQLiteQuery val$_statement) {
            this.f23223a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<c0.b> call() throws Exception {
            f fVar;
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
            String string;
            int i4;
            String string2;
            int i5;
            Cursor query = DBUtil.query(d.this.f23202a, this.f23223a, false, null);
            try {
                columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mkey");
                columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
                columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, RewardPlus.ICON);
                columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "iconS");
                columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "isShow");
                columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "isEnabled");
                columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "isLogin");
                columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "linkUrl");
                columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "type");
                columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "lastUploadTime");
                columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "sort");
                columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "isShowIndex");
                columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "homeSort");
            } catch (Throwable th) {
                th = th;
                fVar = this;
            }
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "isShowH5Title");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string3 = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                    String string4 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                    String string5 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                    String string6 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                    String string7 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                    String string8 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                    int i6 = query.getInt(columnIndexOrThrow7);
                    String string9 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                    String string10 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                    String string11 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                    String string12 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                    String string13 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                    if (query.isNull(columnIndexOrThrow13)) {
                        i4 = columnIndexOrThrow14;
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow13);
                        i4 = columnIndexOrThrow14;
                    }
                    if (query.isNull(i4)) {
                        i5 = columnIndexOrThrow;
                        string2 = null;
                    } else {
                        string2 = query.getString(i4);
                        i5 = columnIndexOrThrow;
                    }
                    arrayList.add(new c0.b(string3, string4, string5, string6, string7, string8, i6, string9, string10, string11, string12, string13, string, string2));
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow14 = i4;
                }
                query.close();
                this.f23223a.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                fVar = this;
                query.close();
                fVar.f23223a.release();
                throw th;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class g implements Callable<List<c0.b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f23225a;

        g(final RoomSQLiteQuery val$_statement) {
            this.f23225a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<c0.b> call() throws Exception {
            g gVar;
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
            String string;
            int i4;
            String string2;
            int i5;
            Cursor query = DBUtil.query(d.this.f23202a, this.f23225a, false, null);
            try {
                columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mkey");
                columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
                columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, RewardPlus.ICON);
                columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "iconS");
                columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "isShow");
                columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "isEnabled");
                columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "isLogin");
                columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "linkUrl");
                columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "type");
                columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "lastUploadTime");
                columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "sort");
                columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "isShowIndex");
                columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "homeSort");
            } catch (Throwable th) {
                th = th;
                gVar = this;
            }
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "isShowH5Title");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string3 = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                    String string4 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                    String string5 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                    String string6 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                    String string7 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                    String string8 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                    int i6 = query.getInt(columnIndexOrThrow7);
                    String string9 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                    String string10 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                    String string11 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                    String string12 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                    String string13 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                    if (query.isNull(columnIndexOrThrow13)) {
                        i4 = columnIndexOrThrow14;
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow13);
                        i4 = columnIndexOrThrow14;
                    }
                    if (query.isNull(i4)) {
                        i5 = columnIndexOrThrow;
                        string2 = null;
                    } else {
                        string2 = query.getString(i4);
                        i5 = columnIndexOrThrow;
                    }
                    arrayList.add(new c0.b(string3, string4, string5, string6, string7, string8, i6, string9, string10, string11, string12, string13, string, string2));
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow14 = i4;
                }
                query.close();
                this.f23225a.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                gVar = this;
                query.close();
                gVar.f23225a.release();
                throw th;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class h implements Callable<List<c0.b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f23227a;

        h(final RoomSQLiteQuery val$_statement) {
            this.f23227a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<c0.b> call() throws Exception {
            h hVar;
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
            String string;
            int i4;
            String string2;
            int i5;
            Cursor query = DBUtil.query(d.this.f23202a, this.f23227a, false, null);
            try {
                columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mkey");
                columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
                columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, RewardPlus.ICON);
                columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "iconS");
                columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "isShow");
                columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "isEnabled");
                columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "isLogin");
                columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "linkUrl");
                columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "type");
                columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "lastUploadTime");
                columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "sort");
                columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "isShowIndex");
                columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "homeSort");
            } catch (Throwable th) {
                th = th;
                hVar = this;
            }
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "isShowH5Title");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string3 = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                    String string4 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                    String string5 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                    String string6 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                    String string7 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                    String string8 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                    int i6 = query.getInt(columnIndexOrThrow7);
                    String string9 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                    String string10 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                    String string11 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                    String string12 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                    String string13 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                    if (query.isNull(columnIndexOrThrow13)) {
                        i4 = columnIndexOrThrow14;
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow13);
                        i4 = columnIndexOrThrow14;
                    }
                    if (query.isNull(i4)) {
                        i5 = columnIndexOrThrow;
                        string2 = null;
                    } else {
                        string2 = query.getString(i4);
                        i5 = columnIndexOrThrow;
                    }
                    arrayList.add(new c0.b(string3, string4, string5, string6, string7, string8, i6, string9, string10, string11, string12, string13, string, string2));
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow14 = i4;
                }
                query.close();
                this.f23227a.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                hVar = this;
                query.close();
                hVar.f23227a.release();
                throw th;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class i implements Callable<List<c0.b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f23229a;

        i(final RoomSQLiteQuery val$_statement) {
            this.f23229a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        public List<c0.b> call() throws Exception {
            i iVar;
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
            String string;
            int i4;
            String string2;
            int i5;
            Cursor query = DBUtil.query(d.this.f23202a, this.f23229a, false, null);
            try {
                columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mkey");
                columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
                columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, RewardPlus.ICON);
                columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "iconS");
                columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "isShow");
                columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "isEnabled");
                columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "isLogin");
                columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "linkUrl");
                columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "type");
                columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "lastUploadTime");
                columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "sort");
                columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "isShowIndex");
                columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "homeSort");
            } catch (Throwable th) {
                th = th;
                iVar = this;
            }
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "isShowH5Title");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string3 = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                    String string4 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                    String string5 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                    String string6 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                    String string7 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                    String string8 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                    int i6 = query.getInt(columnIndexOrThrow7);
                    String string9 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                    String string10 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                    String string11 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                    String string12 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                    String string13 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                    if (query.isNull(columnIndexOrThrow13)) {
                        i4 = columnIndexOrThrow14;
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow13);
                        i4 = columnIndexOrThrow14;
                    }
                    if (query.isNull(i4)) {
                        i5 = columnIndexOrThrow;
                        string2 = null;
                    } else {
                        string2 = query.getString(i4);
                        i5 = columnIndexOrThrow;
                    }
                    arrayList.add(new c0.b(string3, string4, string5, string6, string7, string8, i6, string9, string10, string11, string12, string13, string, string2));
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow14 = i4;
                }
                query.close();
                this.f23229a.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                iVar = this;
                query.close();
                iVar.f23229a.release();
                throw th;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class j extends EntityInsertionAdapter<c0.b> {
        j(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement stmt, c0.b value) {
            if (value.v() == null) {
                stmt.bindNull(1);
            } else {
                stmt.bindString(1, value.v());
            }
            if (value.w() == null) {
                stmt.bindNull(2);
            } else {
                stmt.bindString(2, value.w());
            }
            if (value.r() == null) {
                stmt.bindNull(3);
            } else {
                stmt.bindString(3, value.r());
            }
            if (value.s() == null) {
                stmt.bindNull(4);
            } else {
                stmt.bindString(4, value.s());
            }
            if (value.A() == null) {
                stmt.bindNull(5);
            } else {
                stmt.bindString(5, value.A());
            }
            if (value.y() == null) {
                stmt.bindNull(6);
            } else {
                stmt.bindString(6, value.y());
            }
            stmt.bindLong(7, value.z());
            if (value.u() == null) {
                stmt.bindNull(8);
            } else {
                stmt.bindString(8, value.u());
            }
            if (value.getType() == null) {
                stmt.bindNull(9);
            } else {
                stmt.bindString(9, value.getType());
            }
            if (value.t() == null) {
                stmt.bindNull(10);
            } else {
                stmt.bindString(10, value.t());
            }
            if (value.x() == null) {
                stmt.bindNull(11);
            } else {
                stmt.bindString(11, value.x());
            }
            if (value.C() == null) {
                stmt.bindNull(12);
            } else {
                stmt.bindString(12, value.C());
            }
            if (value.q() == null) {
                stmt.bindNull(13);
            } else {
                stmt.bindString(13, value.q());
            }
            if (value.B() == null) {
                stmt.bindNull(14);
            } else {
                stmt.bindString(14, value.B());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `menu` (`mkey`,`name`,`icon`,`iconS`,`isShow`,`isEnabled`,`isLogin`,`linkUrl`,`type`,`lastUploadTime`,`sort`,`isShowIndex`,`homeSort`,`isShowH5Title`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class k extends EntityDeletionOrUpdateAdapter<c0.b> {
        k(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement stmt, c0.b value) {
            if (value.v() == null) {
                stmt.bindNull(1);
            } else {
                stmt.bindString(1, value.v());
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `menu` WHERE `mkey` = ?";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class l extends SharedSQLiteStatement {
        l(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM menu WHERE mkey=?";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class m extends SharedSQLiteStatement {
        m(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE menu SET icon=? WHERE mkey=?";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class n extends SharedSQLiteStatement {
        n(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE menu SET type=? WHERE mkey=?";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class o extends SharedSQLiteStatement {
        o(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE menu SET iconS=? WHERE mkey=?";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class p extends SharedSQLiteStatement {
        p(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE  FROM menu WHERE type=?";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class q implements Callable<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c0.b[] f23238a;

        q(final c0.b[] val$menu) {
            this.f23238a = val$menu;
        }

        @Override // java.util.concurrent.Callable
        public f1 call() throws Exception {
            d.this.f23202a.beginTransaction();
            try {
                d.this.f23203b.insert((Object[]) this.f23238a);
                d.this.f23202a.setTransactionSuccessful();
                return f1.f55527a;
            } finally {
                d.this.f23202a.endTransaction();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuDao_Impl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class r implements Callable<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c0.b f23240a;

        r(final c0.b val$menu) {
            this.f23240a = val$menu;
        }

        @Override // java.util.concurrent.Callable
        public f1 call() throws Exception {
            d.this.f23202a.beginTransaction();
            try {
                d.this.f23204c.handle(this.f23240a);
                d.this.f23202a.setTransactionSuccessful();
                return f1.f55527a;
            } finally {
                d.this.f23202a.endTransaction();
            }
        }
    }

    public d(RoomDatabase __db) {
        this.f23202a = __db;
        this.f23203b = new j(__db);
        this.f23204c = new k(__db);
        this.f23205d = new l(__db);
        this.f23206e = new m(__db);
        this.f23207f = new n(__db);
        this.f23208g = new o(__db);
        this.f23209h = new p(__db);
    }

    public static List<Class<?>> t() {
        return Collections.emptyList();
    }

    @Override // com.bxkj.student.v2.common.db.dao.c
    public Object a(final c0.b[] menu, final kotlin.coroutines.c<? super f1> continuation) {
        return CoroutinesRoom.execute(this.f23202a, true, new q(menu), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.c
    public Object b(final String icon, final String mkey, final kotlin.coroutines.c<? super f1> continuation) {
        return CoroutinesRoom.execute(this.f23202a, true, new b(icon, mkey), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.c
    public Object c(final String iconS, final String mkey, final kotlin.coroutines.c<? super f1> continuation) {
        return CoroutinesRoom.execute(this.f23202a, true, new CallableC0290d(iconS, mkey), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.c
    public Object d(final String menuType, final kotlin.coroutines.c<? super List<c0.b>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM menu WHERE type=? Order By cast(sort as INTEGER)", 1);
        if (menuType == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, menuType);
        }
        return CoroutinesRoom.execute(this.f23202a, false, DBUtil.createCancellationSignal(), new g(acquire), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.c
    public Object e(final String type, final String mkey, final kotlin.coroutines.c<? super f1> continuation) {
        return CoroutinesRoom.execute(this.f23202a, true, new c(type, mkey), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.c
    public Object f(final c0.b menu, final kotlin.coroutines.c<? super f1> continuation) {
        return CoroutinesRoom.execute(this.f23202a, true, new r(menu), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.c
    public Object g(final int menuType, final kotlin.coroutines.c<? super Integer> continuation) {
        return CoroutinesRoom.execute(this.f23202a, true, new e(menuType), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.c
    public Object h(final kotlin.coroutines.c<? super List<c0.b>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM menu WHERE isShowIndex='1' Order By cast(homeSort as INTEGER)", 0);
        return CoroutinesRoom.execute(this.f23202a, false, DBUtil.createCancellationSignal(), new h(acquire), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.c
    public Object i(final kotlin.coroutines.c<? super List<c0.b>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM menu", 0);
        return CoroutinesRoom.execute(this.f23202a, false, DBUtil.createCancellationSignal(), new f(acquire), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.c
    public Object j(final String mkey, final kotlin.coroutines.c<? super f1> continuation) {
        return CoroutinesRoom.execute(this.f23202a, true, new a(mkey), continuation);
    }

    @Override // com.bxkj.student.v2.common.db.dao.c
    public Object k(final String mkey, final kotlin.coroutines.c<? super List<c0.b>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM menu WHERE mkey=?", 1);
        if (mkey == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, mkey);
        }
        return CoroutinesRoom.execute(this.f23202a, false, DBUtil.createCancellationSignal(), new i(acquire), continuation);
    }
}
