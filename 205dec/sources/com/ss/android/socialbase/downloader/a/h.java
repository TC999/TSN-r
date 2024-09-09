package com.ss.android.socialbase.downloader.a;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.q.q;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final String f49266a;
    private final String[] bl;

    /* renamed from: h  reason: collision with root package name */
    private SQLiteStatement f49267h;
    private SQLiteStatement kf;

    /* renamed from: n  reason: collision with root package name */
    private SQLiteStatement f49268n;
    private final SQLiteDatabase ok;

    /* renamed from: p  reason: collision with root package name */
    private SQLiteStatement f49269p;

    /* renamed from: s  reason: collision with root package name */
    private final String[] f49270s;

    public h(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.ok = sQLiteDatabase;
        this.f49266a = str;
        this.bl = strArr;
        this.f49270s = strArr2;
    }

    public SQLiteStatement a() {
        if (this.f49267h == null) {
            SQLiteStatement compileStatement = this.ok.compileStatement(q.ok(this.f49266a, this.f49270s));
            synchronized (this) {
                if (this.f49267h == null) {
                    this.f49267h = compileStatement;
                }
            }
            if (this.f49267h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f49267h;
    }

    public SQLiteStatement bl() {
        if (this.kf == null) {
            SQLiteStatement compileStatement = this.ok.compileStatement(q.ok(this.f49266a, this.bl, this.f49270s));
            synchronized (this) {
                if (this.kf == null) {
                    this.kf = compileStatement;
                }
            }
            if (this.kf != compileStatement) {
                compileStatement.close();
            }
        }
        return this.kf;
    }

    public SQLiteStatement ok() {
        if (this.f49268n == null) {
            SQLiteStatement compileStatement = this.ok.compileStatement(q.ok("INSERT INTO ", this.f49266a, this.bl));
            synchronized (this) {
                if (this.f49268n == null) {
                    this.f49268n = compileStatement;
                }
            }
            if (this.f49268n != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f49268n;
    }

    public SQLiteStatement s() {
        if (this.f49269p == null) {
            SQLiteStatement compileStatement = this.ok.compileStatement(q.a(this.f49266a, this.bl, this.f49270s));
            synchronized (this) {
                if (this.f49269p == null) {
                    this.f49269p = compileStatement;
                }
            }
            if (this.f49269p != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f49269p;
    }
}
