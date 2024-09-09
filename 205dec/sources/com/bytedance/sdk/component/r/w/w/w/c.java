package com.bytedance.sdk.component.r.w.w.w;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.sdk.component.r.c.gd;
import com.bytedance.sdk.component.r.c.r;
import com.bytedance.sdk.component.r.c.ux;
import com.bytedance.sdk.component.r.w.c.c.sr;
import com.bytedance.sdk.component.r.w.xv.xv;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private String f30146c;
    private gd sr;

    /* renamed from: w  reason: collision with root package name */
    private Context f30147w;
    private ux xv;

    public c(String str) {
        this.f30146c = str;
        r xv = com.bytedance.sdk.component.r.w.c.xv(str);
        this.xv = xv.ux();
        this.sr = xv.f();
    }

    public static void c(ux uxVar) {
        xv.c("start()", uxVar);
        if (uxVar == null) {
            return;
        }
        try {
            ContentResolver xv = xv(uxVar);
            if (xv != null) {
                xv.getType(Uri.parse(sr(uxVar) + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    private gd sr() {
        if (this.sr == null) {
            this.sr = com.bytedance.sdk.component.r.w.c.xv(this.f30146c).f();
        }
        return this.sr;
    }

    public static void w(ux uxVar) {
        if (uxVar == null) {
            return;
        }
        try {
            ContentResolver xv = xv(uxVar);
            if (xv != null) {
                xv.getType(Uri.parse(sr(uxVar) + "adLogStop"));
            }
        } catch (Throwable unused) {
        }
    }

    private ux xv() {
        if (this.xv == null) {
            this.xv = com.bytedance.sdk.component.r.w.c.xv(this.f30146c).ux();
        }
        return this.xv;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
        if (r2.equals("adLogStop") == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getType(android.net.Uri r9) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.r.w.w.w.c.getType(android.net.Uri):java.lang.String");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public void w() {
    }

    private static String sr(ux uxVar) {
        String c4 = sr.c(uxVar);
        StringBuilder sb = new StringBuilder();
        sb.append(c4);
        sb.append(TTPathConst.sSeparator);
        sb.append("csj_mediation".equals(uxVar.ux()) ? "gromore_ad_log_event" : "ad_log_event");
        sb.append(TTPathConst.sSeparator);
        return sb.toString();
    }

    private static ContentResolver xv(ux uxVar) {
        try {
            if (uxVar.getContext() != null) {
                return uxVar.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void c(com.bytedance.sdk.component.r.c.w wVar, ux uxVar) {
        if (wVar == null) {
            return;
        }
        try {
            ContentResolver xv = xv(uxVar);
            if (xv != null) {
                String c4 = com.bytedance.sdk.component.r.w.c.c.xv.c(wVar.f());
                xv.getType(Uri.parse(sr(uxVar) + "adLogDispatch?event=" + c4));
                xv.c("dispatch event getType end ", uxVar);
            }
        } catch (Throwable th) {
            xv.sr("dispatch event Throwable:" + th.toString(), uxVar);
        }
    }

    public static void c(String str, List<String> list, boolean z3, ux uxVar) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder();
                for (String str2 : list) {
                    sb.append(com.bytedance.sdk.component.r.w.c.c.xv.c(str2));
                    sb.append(",");
                }
                String c4 = com.bytedance.sdk.component.r.w.c.c.xv.c(sb.toString());
                String str3 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(c4) + "&replace=" + String.valueOf(z3);
                ContentResolver xv = xv(uxVar);
                if (xv == null) {
                    return;
                }
                xv.getType(Uri.parse(sr(uxVar) + "trackAdUrl" + str3));
            } catch (Throwable unused) {
            }
        }
    }

    public static void c(String str, ux uxVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver xv = xv(uxVar);
            if (xv != null) {
                xv.getType(Uri.parse(sr(uxVar) + "trackAdFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }

    public void c(Context context) {
        this.f30147w = context;
    }

    public String c() {
        return "csj_mediation".equals(this.f30146c) ? "gromore_ad_log_event" : "ad_log_event";
    }
}
