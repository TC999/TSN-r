package com.bytedance.pangle;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.view.ContextThemeWrapper;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class f extends ContextThemeWrapper {
    private File mCacheDir;
    private File mCodeCacheDir;
    private File mDataDir;
    private File mExternalCacheDir;
    private File mFilesDir;
    private File mNoBackupFilesDir;
    private File mObbDir;
    private final Object mSync;

    public f() {
        this.mSync = new Object();
    }

    private static File ensurePrivateDirExists(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File makeFilename(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    private String makeSubName(String str) {
        return getPluginDirName() + "_" + str;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        if (getPluginDirName() == null) {
            return super.databaseList();
        }
        String[] databaseList = super.databaseList();
        int length = databaseList.length;
        boolean[] zArr = new boolean[length];
        int i4 = 0;
        for (int i5 = 0; i5 < databaseList.length; i5++) {
            if (databaseList[i5].startsWith(getPluginDirName())) {
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
        if (getPluginDirName() == null) {
            return super.deleteDatabase(str);
        }
        return super.deleteDatabase(makeSubName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        return makeFilename(getFilesDir(), str).delete();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteSharedPreferences(String str) {
        if (getPluginDirName() == null) {
            return super.deleteSharedPreferences(str);
        }
        return super.deleteSharedPreferences(makeSubName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getCacheDir();
        }
        synchronized (this.mSync) {
            if (this.mCacheDir == null) {
                this.mCacheDir = new File(super.getCacheDir(), getPluginDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mCacheDir);
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getCodeCacheDir();
        }
        synchronized (this.mSync) {
            if (this.mCodeCacheDir == null) {
                this.mCodeCacheDir = new File(super.getCodeCacheDir(), getPluginDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mCodeCacheDir);
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getDataDir();
        }
        synchronized (this.mSync) {
            if (this.mDataDir == null) {
                this.mDataDir = new File(getHostDataDir(), getPluginDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mDataDir);
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        if (getPluginDirName() == null) {
            return super.getDatabasePath(str);
        }
        return super.getDatabasePath(makeSubName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i4) {
        if (i4 == 0 && getPluginDirName() != null) {
            return ensurePrivateDirExists(new File(super.getDir(str, i4), getPluginDirName()));
        }
        return super.getDir(str, i4);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getExternalCacheDir();
        }
        synchronized (this.mSync) {
            if (this.mExternalCacheDir == null) {
                this.mExternalCacheDir = new File(super.getExternalCacheDir(), getPluginDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mExternalCacheDir);
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        if (getPluginDirName() == null) {
            return super.getExternalCacheDirs();
        }
        File[] externalCacheDirs = super.getExternalCacheDirs();
        File[] fileArr = new File[externalCacheDirs.length];
        for (int i4 = 0; i4 < externalCacheDirs.length; i4++) {
            fileArr[i4] = ensurePrivateDirExists(new File(externalCacheDirs[i4], getPluginDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        if (getPluginDirName() == null) {
            return super.getExternalFilesDir(str);
        }
        return ensurePrivateDirExists(new File(super.getExternalFilesDir(str), getPluginDirName()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String str) {
        if (getPluginDirName() == null) {
            return super.getExternalFilesDirs(str);
        }
        File[] externalFilesDirs = super.getExternalFilesDirs(str);
        File[] fileArr = new File[externalFilesDirs.length];
        for (int i4 = 0; i4 < externalFilesDirs.length; i4++) {
            fileArr[i4] = ensurePrivateDirExists(new File(externalFilesDirs[i4], getPluginDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        if (getPluginDirName() == null) {
            return super.getExternalMediaDirs();
        }
        File[] externalMediaDirs = super.getExternalMediaDirs();
        File[] fileArr = new File[externalMediaDirs.length];
        for (int i4 = 0; i4 < externalMediaDirs.length; i4++) {
            fileArr[i4] = ensurePrivateDirExists(new File(externalMediaDirs[i4], getPluginDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getFilesDir();
        }
        synchronized (this.mSync) {
            if (this.mFilesDir == null) {
                this.mFilesDir = new File(super.getFilesDir(), getPluginDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mFilesDir);
        }
        return ensurePrivateDirExists;
    }

    public File getHostDataDir() {
        return super.getFilesDir().getParentFile();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getNoBackupFilesDir();
        }
        synchronized (this.mSync) {
            if (this.mNoBackupFilesDir == null) {
                this.mNoBackupFilesDir = new File(super.getNoBackupFilesDir(), getPluginDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mNoBackupFilesDir);
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getObbDir();
        }
        synchronized (this.mSync) {
            if (this.mObbDir == null) {
                this.mObbDir = new File(super.getObbDir(), getPluginDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mObbDir);
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        if (getPluginDirName() == null) {
            return super.getObbDirs();
        }
        File[] obbDirs = super.getObbDirs();
        File[] fileArr = new File[obbDirs.length];
        for (int i4 = 0; i4 < obbDirs.length; i4++) {
            fileArr[i4] = ensurePrivateDirExists(new File(obbDirs[i4], getPluginDirName()));
        }
        return fileArr;
    }

    protected String getPluginDirName() {
        return "pangle_" + getPluginPkg();
    }

    protected String getPluginPkg() {
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i4) {
        if (i4 == 0 && getPluginDirName() != null) {
            return super.getSharedPreferences(makeSubName(str), i4);
        }
        return super.getSharedPreferences(str, i4);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean moveDatabaseFrom(Context context, String str) {
        if (getPluginDirName() == null) {
            return super.moveDatabaseFrom(context, str);
        }
        throw new UnsupportedOperationException("Calling moveDatabaseFrom in plugins is not supported.");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) {
        if (getPluginDirName() == null) {
            return super.openFileInput(str);
        }
        return new FileInputStream(makeFilename(getFilesDir(), str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i4) {
        if (i4 == 0 && getPluginDirName() != null) {
            return new FileOutputStream(makeFilename(getFilesDir(), str), false);
        }
        return super.openFileOutput(str, i4);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i4, SQLiteDatabase.CursorFactory cursorFactory) {
        if (i4 == 0 && getPluginDirName() != null) {
            return super.openOrCreateDatabase(makeSubName(str), i4, cursorFactory);
        }
        return super.openOrCreateDatabase(str, i4, cursorFactory);
    }

    public f(Context context, int i4) {
        super(context, i4);
        this.mSync = new Object();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i4, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        if (i4 == 0 && getPluginDirName() != null) {
            return super.openOrCreateDatabase(makeSubName(str), i4, cursorFactory, databaseErrorHandler);
        }
        return super.openOrCreateDatabase(str, i4, cursorFactory, databaseErrorHandler);
    }

    @RequiresApi(api = 23)
    public f(Context context, Resources.Theme theme) {
        super(context, theme);
        this.mSync = new Object();
    }
}
