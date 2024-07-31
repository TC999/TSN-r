package com.p521ss.android.socialbase.downloader.p548a;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.p521ss.android.socialbase.downloader.p556q.C12719q;

/* renamed from: com.ss.android.socialbase.downloader.a.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12387h {

    /* renamed from: a */
    private final String f34894a;

    /* renamed from: bl */
    private final String[] f34895bl;

    /* renamed from: h */
    private SQLiteStatement f34896h;

    /* renamed from: kf */
    private SQLiteStatement f34897kf;

    /* renamed from: n */
    private SQLiteStatement f34898n;

    /* renamed from: ok */
    private final SQLiteDatabase f34899ok;

    /* renamed from: p */
    private SQLiteStatement f34900p;

    /* renamed from: s */
    private final String[] f34901s;

    public C12387h(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f34899ok = sQLiteDatabase;
        this.f34894a = str;
        this.f34895bl = strArr;
        this.f34901s = strArr2;
    }

    /* renamed from: a */
    public SQLiteStatement m17996a() {
        if (this.f34896h == null) {
            SQLiteStatement compileStatement = this.f34899ok.compileStatement(C12719q.m16505ok(this.f34894a, this.f34901s));
            synchronized (this) {
                if (this.f34896h == null) {
                    this.f34896h = compileStatement;
                }
            }
            if (this.f34896h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f34896h;
    }

    /* renamed from: bl */
    public SQLiteStatement m17995bl() {
        if (this.f34897kf == null) {
            SQLiteStatement compileStatement = this.f34899ok.compileStatement(C12719q.m16504ok(this.f34894a, this.f34895bl, this.f34901s));
            synchronized (this) {
                if (this.f34897kf == null) {
                    this.f34897kf = compileStatement;
                }
            }
            if (this.f34897kf != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f34897kf;
    }

    /* renamed from: ok */
    public SQLiteStatement m17994ok() {
        if (this.f34898n == null) {
            SQLiteStatement compileStatement = this.f34899ok.compileStatement(C12719q.m16506ok("INSERT INTO ", this.f34894a, this.f34895bl));
            synchronized (this) {
                if (this.f34898n == null) {
                    this.f34898n = compileStatement;
                }
            }
            if (this.f34898n != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f34898n;
    }

    /* renamed from: s */
    public SQLiteStatement m17993s() {
        if (this.f34900p == null) {
            SQLiteStatement compileStatement = this.f34899ok.compileStatement(C12719q.m16508a(this.f34894a, this.f34895bl, this.f34901s));
            synchronized (this) {
                if (this.f34900p == null) {
                    this.f34900p = compileStatement;
                }
            }
            if (this.f34900p != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f34900p;
    }
}
