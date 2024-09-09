package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import com.tencent.turingfd.sdk.ams.au.Cinstanceof;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cumquat {
    public static Cumquat B;
    public static final CanisMajor C = new Cdo();

    /* renamed from: a  reason: collision with root package name */
    public Canesatici f51981a;

    /* renamed from: b  reason: collision with root package name */
    public CanisMajor f51982b;

    /* renamed from: c  reason: collision with root package name */
    public ITuringDeviceInfoProvider f51983c;

    /* renamed from: d  reason: collision with root package name */
    public ITuringPkgProvider f51984d;

    /* renamed from: e  reason: collision with root package name */
    public ITuringIoTFeatureMap f51985e;

    /* renamed from: f  reason: collision with root package name */
    public int f51986f = 0;

    /* renamed from: g  reason: collision with root package name */
    public String f51987g = "";

    /* renamed from: h  reason: collision with root package name */
    public boolean f51988h = true;

    /* renamed from: i  reason: collision with root package name */
    public String[] f51989i = null;

    /* renamed from: j  reason: collision with root package name */
    public int f51990j = 10000;

    /* renamed from: k  reason: collision with root package name */
    public String f51991k = "";

    /* renamed from: l  reason: collision with root package name */
    public String f51992l = "";

    /* renamed from: m  reason: collision with root package name */
    public String f51993m = "";

    /* renamed from: n  reason: collision with root package name */
    public int f51994n = 0;

    /* renamed from: o  reason: collision with root package name */
    public String f51995o = "";

    /* renamed from: p  reason: collision with root package name */
    public Map<Integer, String> f51996p = new HashMap();

    /* renamed from: q  reason: collision with root package name */
    public String f51997q = "";

    /* renamed from: r  reason: collision with root package name */
    public boolean f51998r = true;

    /* renamed from: s  reason: collision with root package name */
    public boolean f51999s = false;

    /* renamed from: t  reason: collision with root package name */
    public boolean f52000t = true;

    /* renamed from: u  reason: collision with root package name */
    public boolean f52001u = true;

    /* renamed from: v  reason: collision with root package name */
    public boolean f52002v = false;

    /* renamed from: w  reason: collision with root package name */
    public long f52003w = 5000;

    /* renamed from: x  reason: collision with root package name */
    public int f52004x = 3;

    /* renamed from: y  reason: collision with root package name */
    public boolean f52005y = false;

    /* renamed from: z  reason: collision with root package name */
    public boolean f52006z = false;
    public boolean A = false;

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Cumquat$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class Cdo implements CanisMajor {
        @Override // com.tencent.turingfd.sdk.ams.au.CanisMajor
        public boolean a() {
            return false;
        }
    }

    public final void a() {
        String[] strArr;
        String[] strArr2 = this.f51989i;
        if (strArr2 != null) {
            if (strArr2.length == 0) {
                this.f51989i = null;
            } else {
                ArrayList arrayList = new ArrayList();
                for (String str : this.f51989i) {
                    if (str != null && !str.isEmpty()) {
                        arrayList.add(str);
                    }
                }
                this.f51989i = arrayList.isEmpty() ? null : (String[]) arrayList.toArray(new String[0]);
            }
        }
        if (this.f51989i == null) {
            this.f51989i = new String[]{"https://tdid.m.qq.com?mc=2"};
        }
        if (this.f51981a == null) {
            if (this.f51990j < 1000) {
                this.f51990j = 10000;
            }
            String[] strArr3 = this.f51989i;
            int i4 = this.f51990j;
            Cinstanceof.Cdo cdo = new Cinstanceof.Cdo(strArr3);
            if (strArr3.length > 1) {
                Cfinally.f52315a.submit(new Cimplements(cdo, i4));
            }
            this.f51981a = cdo;
            return;
        }
        this.f52005y = true;
    }

    public final Context b() {
        Context context;
        synchronized (Ctry.class) {
            context = Ctry.f52366a;
        }
        return context;
    }

    public CanisMajor c() {
        CanisMajor canisMajor = this.f51982b;
        return canisMajor == null ? C : canisMajor;
    }

    public final void a(Context context) {
        Ctry.a(context);
    }
}
