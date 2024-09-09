package com.bytedance.sdk.component.adexpress.c.c;

import android.content.ContentValues;
import android.database.Cursor;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface w {
    int delete(String str, String str2, String[] strArr);

    void insert(String str, ContentValues contentValues);

    Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5);

    int update(String str, ContentValues contentValues, String str2, String[] strArr);
}
