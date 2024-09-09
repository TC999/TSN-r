package com.bytedance.sdk.component.f.xv.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private Context f29797c;

    private Context getContext() {
        Context context = this.f29797c;
        return context == null ? com.bytedance.sdk.component.f.xv.getContext() : context;
    }

    public String c() {
        return "t_sp";
    }

    public void c(Context context) {
        this.f29797c = context;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        String[] split = uri.getPath().split(TTPathConst.sSeparator);
        if (split[2].equals("clean")) {
            xv.c(getContext(), uri.getQueryParameter("sp_file_name"));
            return 0;
        }
        String str2 = split[3];
        if (xv.c(getContext(), uri.getQueryParameter("sp_file_name"), str2)) {
            xv.w(getContext(), uri.getQueryParameter("sp_file_name"), str2);
        }
        return 0;
    }

    public String getType(Uri uri) {
        String[] split = uri.getPath().split(TTPathConst.sSeparator);
        String str = split[2];
        String str2 = split[3];
        if (str.equals("contain")) {
            return xv.c(com.bytedance.sdk.component.f.xv.getContext(), uri.getQueryParameter("sp_file_name"), str2) + "";
        }
        return "" + xv.c(getContext(), uri.getQueryParameter("sp_file_name"), str2, str);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        String[] split = uri.getPath().split(TTPathConst.sSeparator);
        String str = split[2];
        String str2 = split[3];
        Object obj = contentValues.get("value");
        if (obj != null) {
            xv.c(getContext(), uri.getQueryParameter("sp_file_name"), str2, obj);
        }
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Map<String, ?> w3;
        if (!uri.getPath().split(TTPathConst.sSeparator)[2].equals("get_all") || (w3 = xv.w(getContext(), uri.getQueryParameter("sp_file_name"))) == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
        for (String str3 : w3.keySet()) {
            Object[] objArr = new Object[3];
            objArr[0] = str3;
            objArr[2] = w3.get(str3);
            if (objArr[2] instanceof Boolean) {
                objArr[1] = "boolean";
            } else if (objArr[2] instanceof String) {
                objArr[1] = "string";
            } else if (objArr[2] instanceof Integer) {
                objArr[1] = "int";
            } else if (objArr[2] instanceof Long) {
                objArr[1] = "long";
            } else if (objArr[2] instanceof Float) {
                objArr[1] = "float";
            }
            matrixCursor.addRow(objArr);
        }
        return matrixCursor;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (contentValues == null) {
            return 0;
        }
        insert(uri, contentValues);
        return 0;
    }

    public void w() {
    }
}
