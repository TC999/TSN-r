package com.tencent.turingfd.sdk.ams.au;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Vulpecula {

    /* renamed from: a  reason: collision with root package name */
    public final URL f52210a;

    /* renamed from: b  reason: collision with root package name */
    public final String f52211b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f52212c;

    /* renamed from: d  reason: collision with root package name */
    public final int f52213d;

    /* renamed from: e  reason: collision with root package name */
    public final int f52214e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f52215f;

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Vulpecula$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class Cdo {

        /* renamed from: a  reason: collision with root package name */
        public final String f52216a;

        /* renamed from: b  reason: collision with root package name */
        public final URL f52217b;

        /* renamed from: c  reason: collision with root package name */
        public final HashMap<String, String> f52218c;

        /* renamed from: d  reason: collision with root package name */
        public int f52219d;

        /* renamed from: e  reason: collision with root package name */
        public int f52220e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f52221f;

        public Cdo(String str) throws MalformedURLException {
            HashMap<String, String> hashMap = new HashMap<>();
            this.f52218c = hashMap;
            this.f52219d = 10000;
            this.f52220e = 10000;
            this.f52221f = true;
            this.f52216a = str;
            this.f52217b = new URL(str);
            hashMap.put("Content-Type", "application/json; charset=utf-8");
        }
    }

    public Vulpecula(Cdo cdo) {
        String unused = cdo.f52216a;
        this.f52210a = cdo.f52217b;
        this.f52211b = "GET";
        this.f52212c = cdo.f52218c;
        this.f52213d = cdo.f52219d;
        this.f52214e = cdo.f52220e;
        this.f52215f = cdo.f52221f;
    }
}
