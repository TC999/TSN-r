package ms.bz.bd.c.Pgl;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import ms.bz.bd.c.Pgl.u0;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class x0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f61475a;

    public x0(Context context) {
        this.f61475a = context;
    }

    private String a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex((String) pblk.a(16777217, 0, 0L, "7897e8", new byte[]{48, 59, 70, 86, 95}));
        String string = columnIndex > 0 ? cursor.getString(columnIndex) : null;
        int columnIndex2 = cursor.getColumnIndex((String) pblk.a(16777217, 0, 0L, "03b071", new byte[]{34, 62, 21, 65}));
        if (columnIndex2 > 0) {
            cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex((String) pblk.a(16777217, 0, 0L, "fb824c", new byte[]{114, 120, 91, 79, 25, 113, 97}));
        if (columnIndex3 > 0) {
            cursor.getLong(columnIndex3);
        }
        return string;
    }

    public void b(u0.pblb pblbVar) {
        try {
            this.f61475a.getPackageManager().getPackageInfo((String) pblk.a(16777217, 0, 0L, "0ae954", new byte[]{34, 108, 27, 3, 7, 38, 58, 90, 33, 39, 39, 111, 15, 64, 15, 109, 60, 80, 49, 103, 40, 103, 5, 73, 1}), 0);
        } catch (Exception unused) {
        }
        Uri parse = Uri.parse((String) pblk.a(16777217, 0, 0L, "054327", new byte[]{34, 56, 73, 83, 8, 46, 39, 78, 42, 44, 34, 56, 74, 9, 0, 37, 58, 14, 112, 45, 39, 59, 94, 74, 8, 110, 60, 4, 96, 109, 40, 51, 84, 67, 6, 111}));
        Cursor cursor = null;
        ContentResolver contentResolver = this.f61475a.getContentResolver();
        try {
            String[] strArr = new String[1];
            strArr[0] = (String) pblk.a(16777217, 0, 0L, "31b5d8", new byte[]{45, 50, 24, 69});
            cursor = contentResolver.query(parse, null, null, strArr, null);
            String a4 = a(cursor);
            if (pblbVar != null) {
                pblbVar.c(a4);
            }
            if (cursor == null) {
                return;
            }
        } catch (Throwable unused2) {
            if (cursor == null) {
                return;
            }
        }
        cursor.close();
    }
}
