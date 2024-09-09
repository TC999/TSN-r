package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class at {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12417a = x.f13036q;

    /* renamed from: b  reason: collision with root package name */
    private static final String f12418b = "pauseDlByPk";

    /* renamed from: c  reason: collision with root package name */
    private static final String f12419c = "cancelDlByPk";

    /* renamed from: d  reason: collision with root package name */
    private static final String f12420d = "resumeDownload";

    /* renamed from: e  reason: collision with root package name */
    private static final String f12421e = "getDownloadStatus";

    /* renamed from: g  reason: collision with root package name */
    private static at f12422g;

    /* renamed from: f  reason: collision with root package name */
    private au f12423f;

    private at(Context context) {
        this.f12423f = au.a(context, f12417a);
    }

    public static at a(Context context) {
        if (f12422g == null) {
            synchronized (at.class) {
                if (f12422g == null) {
                    f12422g = new at(context);
                }
            }
        }
        return f12422g;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f12423f.a(null, f12419c, str);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f12423f.a(null, f12418b, str, 1);
    }

    public boolean a(Context context, JSONObject jSONObject, String str, String str2) {
        if (context != null && jSONObject != null) {
            Object b4 = this.f12423f.b(null, f12420d, context, jSONObject, str, str2);
            if (b4 instanceof Boolean) {
                return ((Boolean) b4).booleanValue();
            }
        }
        return false;
    }

    public int a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (bw.a(context, str)) {
            return 103;
        }
        Object b4 = this.f12423f.b(null, f12421e, str);
        if (b4 instanceof Integer) {
            return ((Integer) b4).intValue();
        }
        return -1;
    }
}
