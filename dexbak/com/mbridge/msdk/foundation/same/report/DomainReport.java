package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.p457c.Setting;
import org.json.JSONArray;

/* renamed from: com.mbridge.msdk.foundation.same.report.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DomainReport {

    /* renamed from: a */
    private static String f30896a = "DomainReport";

    /* renamed from: a */
    public static boolean m22149a(Setting setting, String str) {
        boolean z = false;
        if (setting != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    int m23393aE = setting.m23393aE();
                    JSONArray m23303k = setting.m23303k();
                    JSONArray m23301l = setting.m23301l();
                    if (m23301l != null) {
                        for (int i = 0; i < m23301l.length(); i++) {
                            if (str.contains(m23301l.getString(i))) {
                                return false;
                            }
                        }
                    }
                    if (m23393aE == 2) {
                        if (m23303k != null) {
                            for (int i2 = 0; i2 < m23303k.length(); i2++) {
                                if (str.contains(m23303k.getString(i2))) {
                                    return true;
                                }
                            }
                        }
                        return z;
                    }
                }
            } catch (Exception e) {
                SameLogTool.m21733d(f30896a, e.getMessage());
                return true;
            }
        }
        z = true;
        return z;
    }
}
