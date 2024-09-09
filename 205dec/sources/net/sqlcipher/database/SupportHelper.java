package net.sqlcipher.database;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class SupportHelper implements SupportSQLiteOpenHelper {
    private final boolean clearPassphrase;
    private byte[] passphrase;
    private SQLiteOpenHelper standardHelper;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SupportHelper(final SupportSQLiteOpenHelper.Configuration configuration, byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z3) {
        SQLiteDatabase.loadLibs(configuration.context);
        this.passphrase = bArr;
        this.clearPassphrase = z3;
        this.standardHelper = new SQLiteOpenHelper(configuration.context, configuration.name, null, configuration.callback.version, sQLiteDatabaseHook) { // from class: net.sqlcipher.database.SupportHelper.1
            @Override // net.sqlcipher.database.SQLiteOpenHelper
            public void onConfigure(SQLiteDatabase sQLiteDatabase) {
                configuration.callback.onConfigure(sQLiteDatabase);
            }

            @Override // net.sqlcipher.database.SQLiteOpenHelper
            public void onCreate(SQLiteDatabase sQLiteDatabase) {
                configuration.callback.onCreate(sQLiteDatabase);
            }

            @Override // net.sqlcipher.database.SQLiteOpenHelper
            public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
                configuration.callback.onDowngrade(sQLiteDatabase, i4, i5);
            }

            @Override // net.sqlcipher.database.SQLiteOpenHelper
            public void onOpen(SQLiteDatabase sQLiteDatabase) {
                configuration.callback.onOpen(sQLiteDatabase);
            }

            @Override // net.sqlcipher.database.SQLiteOpenHelper
            public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
                configuration.callback.onUpgrade(sQLiteDatabase, i4, i5);
            }
        };
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.standardHelper.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.standardHelper.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return getWritableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        try {
            SQLiteDatabase writableDatabase = this.standardHelper.getWritableDatabase(this.passphrase);
            if (this.clearPassphrase && this.passphrase != null) {
                int i4 = 0;
                while (true) {
                    byte[] bArr = this.passphrase;
                    if (i4 >= bArr.length) {
                        break;
                    }
                    bArr[i4] = 0;
                    i4++;
                }
            }
            return writableDatabase;
        } catch (SQLiteException e4) {
            byte[] bArr2 = this.passphrase;
            if (bArr2 != null) {
                boolean z3 = true;
                for (byte b4 : bArr2) {
                    z3 = z3 && b4 == 0;
                }
                if (z3) {
                    throw new IllegalStateException("The passphrase appears to be cleared. This happens by default the first time you use the factory to open a database, so we can remove the cleartext passphrase from memory. If you close the database yourself, please use a fresh SupportFactory to reopen it. If something else (e.g., Room) closed the database, and you cannot control that, use SupportFactory boolean constructor option to opt out of the automatic password clearing step. See the project README for more information.", e4);
                }
            }
            throw e4;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z3) {
        this.standardHelper.setWriteAheadLoggingEnabled(z3);
    }
}
