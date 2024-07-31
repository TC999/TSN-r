package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.aq */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2601aq {

    /* renamed from: a */
    private static final String f8601a = C2736x.f9318p;

    /* renamed from: b */
    private static final String f8602b = "pauseDlByPk";

    /* renamed from: c */
    private static final String f8603c = "cancelDlByPk";

    /* renamed from: d */
    private static final String f8604d = "resumeDownload";

    /* renamed from: e */
    private static final String f8605e = "getDownloadStatus";

    /* renamed from: g */
    private static C2601aq f8606g;

    /* renamed from: f */
    private C2602ar f8607f;

    private C2601aq(Context context) {
        this.f8607f = C2602ar.m50968a(context, f8601a);
    }

    /* renamed from: a */
    public static C2601aq m50973a(Context context) {
        if (f8606g == null) {
            synchronized (C2601aq.class) {
                if (f8606g == null) {
                    f8606g = new C2601aq(context);
                }
            }
        }
        return f8606g;
    }

    /* renamed from: b */
    public void m50969b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f8607f.m50967a(null, f8603c, str);
    }

    /* renamed from: a */
    public void m50970a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f8607f.m50967a(null, f8602b, str, 1);
    }

    /* renamed from: a */
    public boolean m50971a(Context context, JSONObject jSONObject, String str, String str2) {
        if (context != null && jSONObject != null) {
            Object m50964b = this.f8607f.m50964b(null, f8604d, context, jSONObject, str, str2);
            if (m50964b instanceof Boolean) {
                return ((Boolean) m50964b).booleanValue();
            }
        }
        return false;
    }

    /* renamed from: a */
    public int m50972a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (C2635bt.m50723a(context, str)) {
            return 103;
        }
        Object m50964b = this.f8607f.m50964b(null, f8605e, str);
        if (m50964b instanceof Integer) {
            return ((Integer) m50964b).intValue();
        }
        return -1;
    }
}
