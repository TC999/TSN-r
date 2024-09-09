package com.qq.e.comm.plugin.l;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.qq.e.comm.plugin.util.d1;
import java.io.File;
import java.io.IOException;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private String f44580a;

    public a(Context context) {
        this(context, "gdt_database");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        File filesDir = getFilesDir();
        if (filesDir != null) {
            if (this.f44580a != null) {
                File file = new File(filesDir, this.f44580a);
                if (file.exists() || file.mkdir()) {
                    filesDir = file;
                }
            }
            File file2 = new File(filesDir, str);
            if (!file2.exists()) {
                d1.a("create database file", new Object[0]);
                try {
                    if (!file2.createNewFile()) {
                        file2 = super.getDatabasePath(str);
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                    file2 = super.getDatabasePath(str);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getDatabasePath(");
            sb.append(str);
            sb.append(") = ");
            sb.append(file2 != null ? file2.getPath() : null);
            sb.append(", this:");
            sb.append(this);
            d1.a(sb.toString(), new Object[0]);
            return file2;
        }
        File databasePath = super.getDatabasePath(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getDatabasePath(");
        sb2.append(str);
        sb2.append(") = ");
        sb2.append(databasePath != null ? databasePath.getPath() : null);
        d1.a(sb2.toString(), new Object[0]);
        return databasePath;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i4, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        SQLiteDatabase openOrCreateDatabase;
        int i5 = ((i4 & 8) == 0 || Build.VERSION.SDK_INT < 16) ? 268435456 : 805306368;
        if (Build.VERSION.SDK_INT >= 11) {
            File databasePath = getDatabasePath(str);
            openOrCreateDatabase = databasePath != null ? SQLiteDatabase.openDatabase(databasePath.getPath(), cursorFactory, i5, databaseErrorHandler) : null;
        } else {
            openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), cursorFactory);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("openOrCreateDatabase(");
        sb.append(str);
        sb.append(",,) = ");
        sb.append(openOrCreateDatabase != null ? openOrCreateDatabase.getPath() : null);
        d1.a(sb.toString(), new Object[0]);
        return openOrCreateDatabase;
    }

    public a(Context context, String str) {
        super(context);
        this.f44580a = str;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i4, SQLiteDatabase.CursorFactory cursorFactory) {
        return openOrCreateDatabase(str, i4, cursorFactory, null);
    }
}
