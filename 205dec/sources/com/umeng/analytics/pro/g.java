package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UMDBManager.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class g {

    /* renamed from: b  reason: collision with root package name */
    private static SQLiteOpenHelper f52965b;

    /* renamed from: d  reason: collision with root package name */
    private static Context f52966d;

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f52967a;

    /* renamed from: c  reason: collision with root package name */
    private SQLiteDatabase f52968c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: UMDBManager.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final g f52969a = new g();

        private a() {
        }
    }

    public static g a(Context context) {
        if (f52966d == null && context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            f52966d = origApplicationContext;
            f52965b = f.a(origApplicationContext);
        }
        return a.f52969a;
    }

    public synchronized void b() {
        try {
            if (this.f52967a.decrementAndGet() == 0) {
                this.f52968c.close();
            }
        } catch (Throwable unused) {
        }
    }

    private g() {
        this.f52967a = new AtomicInteger();
    }

    public synchronized SQLiteDatabase a() {
        if (this.f52967a.incrementAndGet() == 1) {
            this.f52968c = f52965b.getWritableDatabase();
        }
        return this.f52968c;
    }
}
