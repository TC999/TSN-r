package com.baidu.liantian;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.liantian.b.r;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class LiantianProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        return com.baidu.liantian.core.e.a(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), str, bundle);
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
        b.a();
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, final String str2) {
        b.a();
        try {
            if ("p".equals(str)) {
                final Context context = getContext();
                r.a().a(new Runnable() { // from class: com.baidu.liantian.LiantianProvider.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            b.a();
                            Intent intent = new Intent();
                            intent.putExtra("t", "p");
                            intent.putExtra("c", str2);
                            a.a(context, intent);
                        } catch (Throwable unused) {
                            com.baidu.liantian.b.e.a();
                        }
                    }
                });
                return null;
            }
            return null;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
