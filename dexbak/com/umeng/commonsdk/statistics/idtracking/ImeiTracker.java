package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.f */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ImeiTracker extends AbstractIdTracker {

    /* renamed from: a */
    private static final String f38998a = "imei";

    /* renamed from: b */
    private Context f38999b;

    public ImeiTracker(Context context) {
        super("imei");
        this.f38999b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractIdTracker
    /* renamed from: f */
    public String mo13690f() {
        return DeviceConfig.getImeiNew(this.f38999b);
    }
}
