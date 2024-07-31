package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import p595g2.LoggerFactoryBinder;

/* renamed from: org.slf4j.impl.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class StaticLoggerBinder implements LoggerFactoryBinder {

    /* renamed from: b */
    private static final StaticLoggerBinder f44368b = new StaticLoggerBinder();

    /* renamed from: c */
    public static String f44369c = "1.6.99";

    /* renamed from: d */
    private static final String f44370d = AndroidLoggerFactory.class.getName();

    /* renamed from: a */
    private final ILoggerFactory f44371a = new AndroidLoggerFactory();

    private StaticLoggerBinder() {
    }

    /* renamed from: c */
    public static StaticLoggerBinder m2552c() {
        return f44368b;
    }

    @Override // p595g2.LoggerFactoryBinder
    /* renamed from: a */
    public ILoggerFactory mo2554a() {
        return this.f44371a;
    }

    @Override // p595g2.LoggerFactoryBinder
    /* renamed from: b */
    public String mo2553b() {
        return f44370d;
    }
}
