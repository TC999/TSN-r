package com.umeng.commonsdk.statistics.idtracking;

import android.annotation.TargetApi;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.i */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SerialTracker extends AbstractIdTracker {

    /* renamed from: a */
    private static final String f39007a = "serial";

    public SerialTracker() {
        super(f39007a);
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractIdTracker
    @TargetApi(9)
    /* renamed from: f */
    public String mo13690f() {
        return DeviceConfig.getSerial();
    }
}
