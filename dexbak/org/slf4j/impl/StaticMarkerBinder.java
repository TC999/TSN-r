package org.slf4j.impl;

import org.slf4j.IMarkerFactory;
import org.slf4j.helpers.BasicMarkerFactory;
import p595g2.MarkerFactoryBinder;

/* renamed from: org.slf4j.impl.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class StaticMarkerBinder implements MarkerFactoryBinder {

    /* renamed from: b */
    public static final StaticMarkerBinder f44373b = new StaticMarkerBinder();

    /* renamed from: a */
    final IMarkerFactory f44374a = new BasicMarkerFactory();

    private StaticMarkerBinder() {
    }

    /* renamed from: c */
    public static StaticMarkerBinder m2546c() {
        return f44373b;
    }

    @Override // p595g2.MarkerFactoryBinder
    /* renamed from: a */
    public IMarkerFactory mo2548a() {
        return this.f44374a;
    }

    @Override // p595g2.MarkerFactoryBinder
    /* renamed from: b */
    public String mo2547b() {
        return BasicMarkerFactory.class.getName();
    }
}
