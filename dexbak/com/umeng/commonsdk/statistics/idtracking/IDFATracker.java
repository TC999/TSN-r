package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IDFATracker extends AbstractIdTracker {

    /* renamed from: a */
    private static final String f38982a = "idfa";

    /* renamed from: b */
    private Context f38983b;

    public IDFATracker(Context context) {
        super(f38982a);
        this.f38983b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractIdTracker
    /* renamed from: f */
    public String mo13690f() {
        return DeviceConfig.getIdfa(this.f38983b);
    }
}
