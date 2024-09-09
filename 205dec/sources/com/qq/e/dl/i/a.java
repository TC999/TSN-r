package com.qq.e.dl.i;

import org.json.JSONArray;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: o  reason: collision with root package name */
    public static final String f46907o = null;

    /* renamed from: a  reason: collision with root package name */
    public final int f46908a;

    /* renamed from: b  reason: collision with root package name */
    public final String f46909b;

    /* renamed from: c  reason: collision with root package name */
    public final JSONArray f46910c;

    /* renamed from: d  reason: collision with root package name */
    public final int f46911d;

    /* renamed from: e  reason: collision with root package name */
    public final int f46912e;

    /* renamed from: f  reason: collision with root package name */
    public final int f46913f;

    /* renamed from: g  reason: collision with root package name */
    public final int f46914g;

    /* renamed from: h  reason: collision with root package name */
    public final int f46915h;

    /* renamed from: i  reason: collision with root package name */
    public final int f46916i;

    /* renamed from: j  reason: collision with root package name */
    public final JSONArray f46917j;

    /* renamed from: k  reason: collision with root package name */
    public final int f46918k;

    /* renamed from: l  reason: collision with root package name */
    public final int f46919l;

    /* renamed from: m  reason: collision with root package name */
    public final int f46920m;

    /* renamed from: n  reason: collision with root package name */
    private final String f46921n;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f46922a;

        /* renamed from: b  reason: collision with root package name */
        public String f46923b;

        /* renamed from: c  reason: collision with root package name */
        public JSONArray f46924c;

        /* renamed from: d  reason: collision with root package name */
        public int f46925d;

        /* renamed from: e  reason: collision with root package name */
        public int f46926e;

        /* renamed from: f  reason: collision with root package name */
        public int f46927f;

        /* renamed from: g  reason: collision with root package name */
        public int f46928g;

        /* renamed from: h  reason: collision with root package name */
        public int f46929h = 1;

        /* renamed from: i  reason: collision with root package name */
        public int f46930i;

        /* renamed from: j  reason: collision with root package name */
        public JSONArray f46931j;

        public a a() {
            return new a(this);
        }
    }

    public String a() {
        return this.f46921n;
    }

    public final boolean b() {
        return this.f46915h == 1;
    }

    public final boolean c() {
        return this.f46915h == 2;
    }

    private a(b bVar) {
        this.f46908a = bVar.f46922a;
        this.f46909b = bVar.f46923b;
        JSONArray jSONArray = bVar.f46924c;
        this.f46910c = jSONArray;
        if (jSONArray != null) {
            this.f46921n = jSONArray.toString();
        } else {
            this.f46921n = null;
        }
        int i4 = bVar.f46925d;
        this.f46911d = i4;
        int i5 = bVar.f46926e;
        this.f46912e = i5;
        int i6 = bVar.f46927f;
        this.f46913f = i6;
        int i7 = bVar.f46928g;
        this.f46914g = i7;
        this.f46915h = bVar.f46929h;
        this.f46916i = bVar.f46930i;
        this.f46917j = bVar.f46931j;
        this.f46918k = i7 < 0 ? -1 : i4 + i5 + (i7 * (i6 + i5));
        int i8 = this.f46911d;
        int i9 = this.f46912e;
        this.f46919l = i8 + i9;
        this.f46920m = this.f46913f + i9;
    }
}
