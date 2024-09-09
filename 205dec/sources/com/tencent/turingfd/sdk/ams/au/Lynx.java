package com.tencent.turingfd.sdk.ams.au;

import android.os.Build;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Lynx {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Cdo> f52142a;

    /* renamed from: b  reason: collision with root package name */
    public static Lyra f52143b;

    /* renamed from: c  reason: collision with root package name */
    public static String f52144c;

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Lynx$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class Cdo {

        /* renamed from: a  reason: collision with root package name */
        public Andromeda f52145a;

        /* renamed from: b  reason: collision with root package name */
        public int f52146b = 0;

        public Cdo(Andromeda andromeda) {
            this.f52145a = andromeda;
        }
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f52142a = concurrentHashMap;
        concurrentHashMap.put("C892BA2", new Cdo(new Phoenix()));
        f52142a.put("43780D5", new Cdo(new Phoenix()));
        f52142a.put("7CD3AF2", new Cdo(new Phoenix()));
        f52142a.put("22792AF", new Cdo(new Orion()));
        f52144c = "";
        try {
            f52144c = Hydra.a(Build.MANUFACTURER.toLowerCase().getBytes()).substring(0, 7);
        } catch (Throwable unused) {
        }
    }
}
