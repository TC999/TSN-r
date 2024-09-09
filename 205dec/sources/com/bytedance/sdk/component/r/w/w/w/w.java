package com.bytedance.sdk.component.r.w.w.w;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.sdk.component.r.c.gd;
import com.bytedance.sdk.component.r.c.ux;
import com.bytedance.sdk.component.r.w.c.c.sr;
import com.bytedance.sdk.component.r.w.xv;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    public static xv f30148c;
    private gd sr;

    /* renamed from: w  reason: collision with root package name */
    private String f30149w;
    private ux xv;

    private ux c() {
        if (this.xv == null) {
            this.xv = com.bytedance.sdk.component.r.w.c.xv(this.f30149w).ux();
        }
        return this.xv;
    }

    private static String sr(ux uxVar) {
        String c4 = sr.c(uxVar);
        return c4 + TTPathConst.sSeparator + "ad_log_event" + TTPathConst.sSeparator;
    }

    private gd w() {
        if (this.sr == null) {
            this.sr = com.bytedance.sdk.component.r.w.c.xv(this.f30149w).f();
        }
        return this.sr;
    }

    public static void xv(ux uxVar) {
        if (uxVar == null) {
            return;
        }
        try {
            xv c4 = c(uxVar);
            if (c4 != null) {
                c4.getType(Uri.parse(sr(uxVar) + "adLogStop"));
            }
        } catch (Throwable unused) {
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
        if (r2.equals("adLogStop") == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getType(android.net.Uri r9) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.r.w.w.w.w.getType(android.net.Uri):java.lang.String");
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

    public static xv c(ux uxVar) {
        try {
            com.bytedance.sdk.component.r.w.xv.xv.c("getResolver", uxVar);
            if (f30148c == null) {
                f30148c = uxVar.sr().k();
            }
        } catch (Exception unused) {
        }
        return f30148c;
    }

    public static void w(ux uxVar) {
        com.bytedance.sdk.component.r.w.xv.xv.c("EventProviderImpl#start", uxVar);
        if (uxVar == null) {
            return;
        }
        try {
            xv c4 = c(uxVar);
            if (c4 != null) {
                Uri parse = Uri.parse(sr(uxVar) + "adLogStart");
                com.bytedance.sdk.component.r.w.xv.xv.c("EventProviderImpl#gettype", uxVar);
                c4.getType(parse);
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(com.bytedance.sdk.component.r.c.w wVar, ux uxVar) {
        if (wVar == null || uxVar == null) {
            return;
        }
        try {
            com.bytedance.sdk.component.r.w.xv.xv.c("dispatch event getResolver before", uxVar);
            xv c4 = c(uxVar);
            com.bytedance.sdk.component.r.w.xv.xv.c("dispatch event getResolver end", uxVar);
            if (c4 != null) {
                String c5 = com.bytedance.sdk.component.r.w.c.c.xv.c(wVar.f());
                Uri parse = Uri.parse(sr(uxVar) + "adLogDispatch?event=" + c5);
                com.bytedance.sdk.component.r.w.xv.xv.c("dispatch event getType:", uxVar);
                c4.getType(parse);
                com.bytedance.sdk.component.r.w.xv.xv.c("dispatch event getType end ", uxVar);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.r.w.xv.xv.sr("dispatch event Throwable:" + th.toString(), uxVar);
        }
    }

    public static void c(String str, List<String> list, boolean z3, ux uxVar) {
        if (list != null && !list.isEmpty() && uxVar != null) {
            try {
                StringBuilder sb = new StringBuilder();
                for (String str2 : list) {
                    sb.append(com.bytedance.sdk.component.r.w.c.c.xv.c(str2));
                    sb.append(",");
                }
                String c4 = com.bytedance.sdk.component.r.w.c.c.xv.c(sb.toString());
                String str3 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(c4) + "&replace=" + String.valueOf(z3);
                xv c5 = c(uxVar);
                if (c5 == null) {
                    return;
                }
                c5.getType(Uri.parse(sr(uxVar) + "trackAdUrl" + str3));
            } catch (Throwable unused) {
            }
        }
    }

    public static void c(String str, ux uxVar) {
        if (!TextUtils.isEmpty(str) && uxVar != null) {
            try {
                xv c4 = c(uxVar);
                if (c4 == null) {
                    return;
                }
                c4.getType(Uri.parse(sr(uxVar) + "trackAdFailed?did=" + String.valueOf(str)));
            } catch (Throwable unused) {
            }
        }
    }
}
