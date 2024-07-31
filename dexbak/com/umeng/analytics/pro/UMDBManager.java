package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.umeng.analytics.pro.g */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class UMDBManager {

    /* renamed from: b */
    private static SQLiteOpenHelper f38244b;

    /* renamed from: d */
    private static Context f38245d;

    /* renamed from: a */
    private AtomicInteger f38246a;

    /* renamed from: c */
    private SQLiteDatabase f38247c;

    /* compiled from: UMDBManager.java */
    /* renamed from: com.umeng.analytics.pro.g$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13159a {

        /* renamed from: a */
        private static final UMDBManager f38248a = new UMDBManager();

        private C13159a() {
        }
    }

    /* renamed from: a */
    public static UMDBManager m14358a(Context context) {
        if (f38245d == null && context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            f38245d = origApplicationContext;
            f38244b = C13155f.m14369a(origApplicationContext);
        }
        return C13159a.f38248a;
    }

    /* renamed from: b */
    public synchronized void m14357b() {
        try {
            if (this.f38246a.decrementAndGet() == 0) {
                this.f38247c.close();
            }
        } catch (Throwable unused) {
        }
    }

    private UMDBManager() {
        this.f38246a = new AtomicInteger();
    }

    /* renamed from: a */
    public synchronized SQLiteDatabase m14359a() {
        if (this.f38246a.incrementAndGet() == 1) {
            this.f38247c = f38244b.getWritableDatabase();
        }
        return this.f38247c;
    }
}
