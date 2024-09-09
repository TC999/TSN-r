package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.embedapplog.zg;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class qy implements zg {

    /* renamed from: c  reason: collision with root package name */
    private oh<Boolean> f26785c = new oh<Boolean>() { // from class: com.bytedance.embedapplog.qy.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.oh
        /* renamed from: xv */
        public Boolean c(Object... objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Exception unused) {
            }
            return Boolean.FALSE;
        }
    };

    @Override // com.bytedance.embedapplog.zg
    public boolean c(Context context) {
        if (context == null) {
            return false;
        }
        return this.f26785c.w(context).booleanValue();
    }

    @Override // com.bytedance.embedapplog.zg
    public zg.c w(Context context) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY}, null);
            if (cursor == null) {
                return null;
            }
            try {
                zg.c cVar = new zg.c();
                cVar.f26861w = c(cursor);
                return cVar;
            } catch (Throwable th) {
                th = th;
                try {
                    be.c(th);
                    return null;
                } finally {
                    g.c(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private String c(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex >= 0) {
            return cursor.getString(columnIndex);
        }
        return null;
    }
}
