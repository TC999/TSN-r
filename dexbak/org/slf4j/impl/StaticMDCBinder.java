package org.slf4j.impl;

import org.slf4j.helpers.NOPMDCAdapter;
import p595g2.MDCAdapter;

/* renamed from: org.slf4j.impl.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class StaticMDCBinder {

    /* renamed from: a */
    public static final StaticMDCBinder f44372a = new StaticMDCBinder();

    private StaticMDCBinder() {
    }

    /* renamed from: c */
    public static final StaticMDCBinder m2549c() {
        return f44372a;
    }

    /* renamed from: a */
    public MDCAdapter m2551a() {
        return new NOPMDCAdapter();
    }

    /* renamed from: b */
    public String m2550b() {
        return NOPMDCAdapter.class.getName();
    }
}
