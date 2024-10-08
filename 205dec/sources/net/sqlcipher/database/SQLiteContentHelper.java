package net.sqlcipher.database;

import android.content.res.AssetFileDescriptor;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import net.sqlcipher.Cursor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class SQLiteContentHelper {
    public static AssetFileDescriptor getBlobColumnAsAssetFile(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) throws FileNotFoundException {
        ParcelFileDescriptor parcelFileDescriptor;
        try {
            MemoryFile simpleQueryForBlobMemoryFile = simpleQueryForBlobMemoryFile(sQLiteDatabase, str, strArr);
            if (simpleQueryForBlobMemoryFile != null) {
                try {
                    Method declaredMethod = simpleQueryForBlobMemoryFile.getClass().getDeclaredMethod("getParcelFileDescriptor", new Class[0]);
                    declaredMethod.setAccessible(true);
                    parcelFileDescriptor = (ParcelFileDescriptor) declaredMethod.invoke(simpleQueryForBlobMemoryFile, new Object[0]);
                } catch (Exception e4) {
                    Log.i("SQLiteContentHelper", "SQLiteCursor.java: " + e4);
                    parcelFileDescriptor = null;
                }
                return new AssetFileDescriptor(parcelFileDescriptor, 0L, simpleQueryForBlobMemoryFile.length());
            }
            throw new FileNotFoundException("No results.");
        } catch (IOException e5) {
            throw new FileNotFoundException(e5.toString());
        }
    }

    private static MemoryFile simpleQueryForBlobMemoryFile(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) throws IOException {
        Cursor rawQuery = sQLiteDatabase.rawQuery(str, strArr);
        if (rawQuery == null) {
            return null;
        }
        try {
            if (rawQuery.moveToFirst()) {
                byte[] blob = rawQuery.getBlob(0);
                if (blob == null) {
                    return null;
                }
                MemoryFile memoryFile = new MemoryFile(null, blob.length);
                memoryFile.writeBytes(blob, 0, 0, blob.length);
                return memoryFile;
            }
            return null;
        } finally {
            rawQuery.close();
        }
    }
}
