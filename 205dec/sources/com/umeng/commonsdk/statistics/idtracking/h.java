package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.config.FieldManager;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: OaidTracking.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class h extends a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f53637a = au.b().b("uso");

    /* renamed from: b  reason: collision with root package name */
    public static final String f53638b = "key_umeng_sp_oaid";

    /* renamed from: c  reason: collision with root package name */
    public static final String f53639c = "key_umeng_sp_oaid_required_time";

    /* renamed from: d  reason: collision with root package name */
    private static final String f53640d = "oaid";

    /* renamed from: e  reason: collision with root package name */
    private Context f53641e;

    public h(Context context) {
        super(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY);
        this.f53641e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        if (FieldManager.allow("header_device_oaid")) {
            try {
                SharedPreferences sharedPreferences = this.f53641e.getSharedPreferences(f53637a, 0);
                if (sharedPreferences != null) {
                    return sharedPreferences.getString("key_umeng_sp_oaid", "");
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }
}
