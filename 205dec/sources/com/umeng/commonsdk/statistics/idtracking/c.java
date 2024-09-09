package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IDFATracker.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f53617a = "idfa";

    /* renamed from: b  reason: collision with root package name */
    private Context f53618b;

    public c(Context context) {
        super(AdRequestConstant.AD_REQUEST_DEVICE_EXT_IDFA_KEY);
        this.f53618b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getIdfa(this.f53618b);
    }
}
