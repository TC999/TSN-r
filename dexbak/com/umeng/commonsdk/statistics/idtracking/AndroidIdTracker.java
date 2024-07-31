package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class AndroidIdTracker extends AbstractIdTracker {

    /* renamed from: a */
    private static final String f38980a = "android_id";

    /* renamed from: b */
    private Context f38981b;

    public AndroidIdTracker(Context context) {
        super("android_id");
        this.f38981b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractIdTracker
    /* renamed from: f */
    public String mo13690f() {
        return DeviceConfig.getAndroidId(this.f38981b);
    }
}
