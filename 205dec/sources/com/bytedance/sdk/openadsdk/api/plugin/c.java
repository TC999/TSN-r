package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends ContextWrapper {

    /* renamed from: c  reason: collision with root package name */
    private final Object f31448c;
    private File ev;

    /* renamed from: f  reason: collision with root package name */
    private File f31449f;

    /* renamed from: r  reason: collision with root package name */
    private File f31450r;
    private File sr;
    private File ux;

    /* renamed from: w  reason: collision with root package name */
    private File f31451w;
    private File xv;

    public c(Context context) {
        super(context);
        this.f31448c = new Object();
    }

    private String c(String str) {
        return c() + "_" + str;
    }

    protected String c() {
        return "pangle_com.byted.pangle";
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        if (c() == null) {
            return super.databaseList();
        }
        String[] databaseList = super.databaseList();
        int length = databaseList.length;
        boolean[] zArr = new boolean[length];
        int i4 = 0;
        for (int i5 = 0; i5 < databaseList.length; i5++) {
            if (databaseList[i5].startsWith(c())) {
                zArr[i5] = true;
                i4++;
            } else {
                zArr[i5] = false;
            }
        }
        String[] strArr = new String[i4];
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            if (zArr[i7]) {
                strArr[i6] = databaseList[i7];
                i6++;
            }
        }
        return strArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        if (c() == null) {
            return super.deleteDatabase(str);
        }
        return super.deleteDatabase(c(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        return c(getFilesDir(), str).delete();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteSharedPreferences(String str) {
        if (c() == null) {
            return super.deleteSharedPreferences(str);
        }
        return super.deleteSharedPreferences(c(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        File c4;
        if (c() == null) {
            return super.getCacheDir();
        }
        synchronized (this.f31448c) {
            if (this.f31449f == null) {
                this.f31449f = new File(super.getCacheDir(), c());
            }
            c4 = c(this.f31449f);
        }
        return c4;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        File c4;
        if (c() == null) {
            return super.getCodeCacheDir();
        }
        synchronized (this.f31448c) {
            if (this.f31450r == null) {
                this.f31450r = new File(super.getCodeCacheDir(), c());
            }
            c4 = c(this.f31450r);
        }
        return c4;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        File c4;
        if (c() == null) {
            return super.getDataDir();
        }
        synchronized (this.f31448c) {
            if (this.f31451w == null) {
                this.f31451w = new File(w(), c());
            }
            c4 = c(this.f31451w);
        }
        return c4;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        if (c() == null) {
            return super.getDatabasePath(str);
        }
        return super.getDatabasePath(c(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i4) {
        if (i4 == 0 && c() != null) {
            return c(new File(super.getDir(str, i4), c()));
        }
        return super.getDir(str, i4);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        File c4;
        if (c() == null) {
            return super.getExternalCacheDir();
        }
        synchronized (this.f31448c) {
            if (this.ev == null) {
                this.ev = new File(super.getExternalCacheDir(), c());
            }
            c4 = c(this.ev);
        }
        return c4;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        if (c() == null) {
            return super.getExternalCacheDirs();
        }
        File[] externalCacheDirs = super.getExternalCacheDirs();
        File[] fileArr = new File[externalCacheDirs.length];
        for (int i4 = 0; i4 < externalCacheDirs.length; i4++) {
            fileArr[i4] = c(new File(externalCacheDirs[i4], c()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        if (c() == null) {
            return super.getExternalFilesDir(str);
        }
        return c(new File(super.getExternalFilesDir(str), c()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String str) {
        if (c() == null) {
            return super.getExternalFilesDirs(str);
        }
        File[] externalFilesDirs = super.getExternalFilesDirs(str);
        File[] fileArr = new File[externalFilesDirs.length];
        for (int i4 = 0; i4 < externalFilesDirs.length; i4++) {
            fileArr[i4] = c(new File(externalFilesDirs[i4], c()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        if (c() == null) {
            return super.getExternalMediaDirs();
        }
        File[] externalMediaDirs = super.getExternalMediaDirs();
        File[] fileArr = new File[externalMediaDirs.length];
        for (int i4 = 0; i4 < externalMediaDirs.length; i4++) {
            fileArr[i4] = c(new File(externalMediaDirs[i4], c()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        File c4;
        if (c() == null) {
            return super.getFilesDir();
        }
        synchronized (this.f31448c) {
            if (this.xv == null) {
                this.xv = new File(super.getFilesDir(), c());
            }
            c4 = c(this.xv);
        }
        return c4;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        File c4;
        if (c() == null) {
            return super.getNoBackupFilesDir();
        }
        synchronized (this.f31448c) {
            if (this.sr == null) {
                this.sr = new File(super.getNoBackupFilesDir(), c());
            }
            c4 = c(this.sr);
        }
        return c4;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        File c4;
        if (c() == null) {
            return super.getObbDir();
        }
        synchronized (this.f31448c) {
            if (this.ux == null) {
                this.ux = new File(super.getObbDir(), c());
            }
            c4 = c(this.ux);
        }
        return c4;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        if (c() == null) {
            return super.getObbDirs();
        }
        File[] obbDirs = super.getObbDirs();
        File[] fileArr = new File[obbDirs.length];
        for (int i4 = 0; i4 < obbDirs.length; i4++) {
            fileArr[i4] = c(new File(obbDirs[i4], c()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i4) {
        if (i4 == 0 && c() != null) {
            return super.getSharedPreferences(c(str), i4);
        }
        return super.getSharedPreferences(str, i4);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean moveDatabaseFrom(Context context, String str) {
        if (c() == null) {
            return super.moveDatabaseFrom(context, str);
        }
        throw new UnsupportedOperationException("Calling moveDatabaseFrom in plugins is not supported.");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        if (c() == null) {
            return super.openFileInput(str);
        }
        return new FileInputStream(c(getFilesDir(), str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i4) throws FileNotFoundException {
        if (i4 == 0 && c() != null) {
            return new FileOutputStream(c(getFilesDir(), str), false);
        }
        return super.openFileOutput(str, i4);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i4, SQLiteDatabase.CursorFactory cursorFactory) {
        if (i4 == 0 && c() != null) {
            return super.openOrCreateDatabase(c(str), i4, cursorFactory);
        }
        return super.openOrCreateDatabase(str, i4, cursorFactory);
    }

    public File w() {
        return super.getFilesDir().getParentFile();
    }

    private static File c(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File c(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i4, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        if (i4 == 0 && c() != null) {
            return super.openOrCreateDatabase(c(str), i4, cursorFactory, databaseErrorHandler);
        }
        return super.openOrCreateDatabase(str, i4, cursorFactory, databaseErrorHandler);
    }
}
