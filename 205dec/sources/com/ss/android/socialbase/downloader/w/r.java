package com.ss.android.socialbase.downloader.w;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.gd.gd;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class r {

    /* renamed from: c  reason: collision with root package name */
    private final SQLiteDatabase f50199c;
    private SQLiteStatement ev;

    /* renamed from: f  reason: collision with root package name */
    private SQLiteStatement f50200f;

    /* renamed from: r  reason: collision with root package name */
    private SQLiteStatement f50201r;
    private final String[] sr;
    private SQLiteStatement ux;

    /* renamed from: w  reason: collision with root package name */
    private final String f50202w;
    private final String[] xv;

    public r(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f50199c = sQLiteDatabase;
        this.f50202w = str;
        this.xv = strArr;
        this.sr = strArr2;
    }

    public SQLiteStatement c() {
        if (this.ux == null) {
            SQLiteStatement compileStatement = this.f50199c.compileStatement(gd.c("INSERT INTO ", this.f50202w, this.xv));
            synchronized (this) {
                if (this.ux == null) {
                    this.ux = compileStatement;
                }
            }
            if (this.ux != compileStatement) {
                compileStatement.close();
            }
        }
        return this.ux;
    }

    public SQLiteStatement sr() {
        if (this.ev == null) {
            SQLiteStatement compileStatement = this.f50199c.compileStatement(gd.w(this.f50202w, this.xv, this.sr));
            synchronized (this) {
                if (this.ev == null) {
                    this.ev = compileStatement;
                }
            }
            if (this.ev != compileStatement) {
                compileStatement.close();
            }
        }
        return this.ev;
    }

    public SQLiteStatement w() {
        if (this.f50201r == null) {
            SQLiteStatement compileStatement = this.f50199c.compileStatement(gd.c(this.f50202w, this.sr));
            synchronized (this) {
                if (this.f50201r == null) {
                    this.f50201r = compileStatement;
                }
            }
            if (this.f50201r != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f50201r;
    }

    public SQLiteStatement xv() {
        if (this.f50200f == null) {
            SQLiteStatement compileStatement = this.f50199c.compileStatement(gd.c(this.f50202w, this.xv, this.sr));
            synchronized (this) {
                if (this.f50200f == null) {
                    this.f50200f = compileStatement;
                }
            }
            if (this.f50200f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f50200f;
    }
}
