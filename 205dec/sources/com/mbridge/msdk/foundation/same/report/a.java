package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.x;
import org.json.JSONArray;

/* compiled from: DomainReport.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f39669a = "DomainReport";

    public static boolean a(com.mbridge.msdk.c.a aVar, String str) {
        boolean z3 = false;
        if (aVar != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    int aE = aVar.aE();
                    JSONArray k4 = aVar.k();
                    JSONArray l4 = aVar.l();
                    if (l4 != null) {
                        for (int i4 = 0; i4 < l4.length(); i4++) {
                            if (str.contains(l4.getString(i4))) {
                                return false;
                            }
                        }
                    }
                    if (aE == 2) {
                        if (k4 != null) {
                            for (int i5 = 0; i5 < k4.length(); i5++) {
                                if (str.contains(k4.getString(i5))) {
                                    return true;
                                }
                            }
                        }
                        return z3;
                    }
                }
            } catch (Exception e4) {
                x.d(f39669a, e4.getMessage());
                return true;
            }
        }
        z3 = true;
        return z3;
    }
}
