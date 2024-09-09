package com.bytedance.msdk.f.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private static volatile xv f28310c;

    /* renamed from: w  reason: collision with root package name */
    private Uri f28311w;

    private xv() {
        if (com.bytedance.msdk.core.c.getContext() != null) {
            this.f28311w = Uri.parse("content://" + com.bytedance.msdk.core.c.getContext().getPackageName() + ".TTMultiProvider/gromore_prime_rit_adn_perform");
        }
    }

    public static xv c() {
        if (f28310c == null) {
            synchronized (xv.class) {
                if (f28310c == null) {
                    f28310c = new xv();
                }
            }
        }
        return f28310c;
    }

    public void insert(String str, String str2, String str3, String str4) {
        if (com.bytedance.msdk.core.c.getContext() == null || this.f28311w == null) {
            return;
        }
        ContentResolver contentResolver = com.bytedance.msdk.core.c.getContext().getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("adn_name", str);
        contentValues.put("prime_rit", str2);
        contentValues.put("adn_rit", str3);
        contentValues.put("ad_action", str4);
        contentValues.put("time_stamp", Long.valueOf(System.currentTimeMillis()));
        contentResolver.insert(this.f28311w, contentValues);
    }

    public List<w> query(String str, String str2, long j4, long j5) {
        String str3;
        String[] strArr;
        if (com.bytedance.msdk.core.c.getContext() == null || this.f28311w == null) {
            return null;
        }
        ContentResolver contentResolver = com.bytedance.msdk.core.c.getContext().getContentResolver();
        String[] strArr2 = {str, str2, j4 + "", j5 + ""};
        if (TextUtils.isEmpty(str)) {
            strArr = new String[]{str2, j4 + "", j5 + ""};
            str3 = "prime_rit=? AND time_stamp>=? AND time_stamp<?";
        } else {
            str3 = "adn_name=? AND prime_rit=? AND time_stamp>=? AND time_stamp<?";
            strArr = strArr2;
        }
        Cursor query = contentResolver.query(this.f28311w, null, str3, strArr, null);
        if (query != null) {
            LinkedList linkedList = new LinkedList();
            while (query.moveToNext()) {
                try {
                    String string = query.getString(query.getColumnIndex("adn_name"));
                    String string2 = query.getString(query.getColumnIndex("prime_rit"));
                    String string3 = query.getString(query.getColumnIndex("adn_rit"));
                    String string4 = query.getString(query.getColumnIndex("ad_action"));
                    long j6 = query.getLong(query.getColumnIndex("time_stamp"));
                    w wVar = new w();
                    wVar.xv(string);
                    wVar.c(string2);
                    wVar.w(string3);
                    wVar.sr(string4);
                    wVar.c(j6);
                    linkedList.add(wVar);
                } finally {
                    query.close();
                }
            }
            return linkedList;
        }
        return null;
    }

    public void c(String str, long j4) {
        if (com.bytedance.msdk.core.c.getContext() == null || this.f28311w == null || j4 <= 0) {
            return;
        }
        ContentResolver contentResolver = com.bytedance.msdk.core.c.getContext().getContentResolver();
        contentResolver.delete(this.f28311w, "prime_rit=? AND time_stamp<?", new String[]{str, j4 + ""});
    }
}
