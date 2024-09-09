package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IDMD5Tracker.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f53619a = "idmd5";

    /* renamed from: b  reason: collision with root package name */
    private Context f53620b;

    public d(Context context) {
        super("idmd5");
        this.f53620b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getDeviceIdUmengMD5(this.f53620b);
    }
}
