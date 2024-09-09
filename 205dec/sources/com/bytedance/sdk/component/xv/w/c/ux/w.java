package com.bytedance.sdk.component.xv.w.c.ux;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public enum w {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    

    /* renamed from: r  reason: collision with root package name */
    public final int f30904r;

    w(int i4) {
        this.f30904r = i4;
    }

    public static w c(int i4) {
        w[] values;
        try {
            for (w wVar : values()) {
                if (wVar.f30904r == i4) {
                    return wVar;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
