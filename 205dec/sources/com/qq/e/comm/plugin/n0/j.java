package com.qq.e.comm.plugin.n0;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.qq.e.comm.plugin.n0.u;
import com.qq.e.comm.plugin.util.d1;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class j extends SQLiteOpenHelper {

    /* renamed from: d  reason: collision with root package name */
    private static volatile j f44772d;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, u> f44773c;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements u.a<l> {
        a() {
        }

        @Override // com.qq.e.comm.plugin.n0.u.a
        /* renamed from: b */
        public l a(int i4, String str) {
            return m.a(i4, str);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements u.a<p> {
        b() {
        }

        @Override // com.qq.e.comm.plugin.n0.u.a
        /* renamed from: b */
        public p a(int i4, String str) {
            return q.a(i4, str);
        }
    }

    private j(Context context) {
        super(new com.qq.e.comm.plugin.l.a(context), "gdt_stat.db", (SQLiteDatabase.CursorFactory) null, 2);
        HashMap hashMap = new HashMap(5);
        this.f44773c = hashMap;
        hashMap.put("event", new u("event", new a()));
        this.f44773c.put("performance", new u("performance", new b()));
    }

    public static j a(Context context) {
        if (f44772d == null) {
            synchronized (j.class) {
                if (f44772d == null) {
                    f44772d = new j(context);
                }
            }
        }
        return f44772d;
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            d1.a("No stat db!");
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
            for (u uVar : this.f44773c.values()) {
                uVar.b(sQLiteDatabase);
            }
            sQLiteDatabase.setTransactionSuccessful();
            d1.a("Drop stat db success", new Object[0]);
        } finally {
            try {
            } finally {
            }
        }
    }

    public void c() {
        for (u uVar : this.f44773c.values()) {
            uVar.a(this);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        b(sQLiteDatabase);
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        b(sQLiteDatabase);
        a(sQLiteDatabase);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            d1.a("No stat db!");
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
            for (u uVar : this.f44773c.values()) {
                uVar.a(sQLiteDatabase);
            }
            sQLiteDatabase.setTransactionSuccessful();
            d1.a("Create stat db success", new Object[0]);
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u b() {
        return this.f44773c.get("performance");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u a() {
        return this.f44773c.get("event");
    }
}
