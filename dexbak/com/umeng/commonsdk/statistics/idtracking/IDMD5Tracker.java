package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IDMD5Tracker extends AbstractIdTracker {

    /* renamed from: a */
    private static final String f38984a = "idmd5";

    /* renamed from: b */
    private Context f38985b;

    public IDMD5Tracker(Context context) {
        super("idmd5");
        this.f38985b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractIdTracker
    /* renamed from: f */
    public String mo13690f() {
        return DeviceConfig.getDeviceIdUmengMD5(this.f38985b);
    }
}
