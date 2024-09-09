package cn.jpush.android.service;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import cn.jiguang.bq.d;
import cn.jiguang.internal.JCoreInternalHelper;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class DataProvider extends ContentProvider {
    private static final String TAG = "DataProvider";

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        try {
            d.c(TAG, "method:" + str + ", arg=" + str2);
            return JCoreInternalHelper.getInstance().directHandle(getContext(), str, str2, bundle);
        } catch (Throwable th) {
            d.i(TAG, "call e:" + th);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        d.c(TAG, "onCreate");
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
