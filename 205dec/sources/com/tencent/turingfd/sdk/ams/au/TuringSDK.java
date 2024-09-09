package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class TuringSDK extends Cumquat {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Context f52180a;

        /* renamed from: t  reason: collision with root package name */
        public ITuringPrivacyPolicy f52199t;

        /* renamed from: u  reason: collision with root package name */
        public ITuringDeviceInfoProvider f52200u;

        /* renamed from: v  reason: collision with root package name */
        public ITuringPkgProvider f52201v;

        /* renamed from: w  reason: collision with root package name */
        public ITuringIoTFeatureMap f52202w;

        /* renamed from: b  reason: collision with root package name */
        public String f52181b = "";

        /* renamed from: c  reason: collision with root package name */
        public int f52182c = 5000;

        /* renamed from: d  reason: collision with root package name */
        public long f52183d = 60000;

        /* renamed from: e  reason: collision with root package name */
        public int f52184e = 3;

        /* renamed from: f  reason: collision with root package name */
        public String f52185f = "";

        /* renamed from: g  reason: collision with root package name */
        public String f52186g = "";

        /* renamed from: h  reason: collision with root package name */
        public int f52187h = 0;

        /* renamed from: i  reason: collision with root package name */
        public String f52188i = "";

        /* renamed from: j  reason: collision with root package name */
        public int f52189j = 0;

        /* renamed from: k  reason: collision with root package name */
        public Map<Integer, String> f52190k = new HashMap();

        /* renamed from: l  reason: collision with root package name */
        public boolean f52191l = true;

        /* renamed from: m  reason: collision with root package name */
        public String f52192m = "";

        /* renamed from: n  reason: collision with root package name */
        public String f52193n = "";

        /* renamed from: o  reason: collision with root package name */
        public boolean f52194o = true;

        /* renamed from: p  reason: collision with root package name */
        public String f52195p = "turingfd.cert";

        /* renamed from: q  reason: collision with root package name */
        public boolean f52196q = true;

        /* renamed from: r  reason: collision with root package name */
        public boolean f52197r = false;

        /* renamed from: s  reason: collision with root package name */
        public boolean f52198s = true;

        /* renamed from: x  reason: collision with root package name */
        public boolean f52203x = false;

        /* renamed from: y  reason: collision with root package name */
        public boolean f52204y = false;

        /* renamed from: z  reason: collision with root package name */
        public boolean f52205z = false;

        public Builder(Context context, ITuringPrivacyPolicy iTuringPrivacyPolicy) {
            this.f52180a = context.getApplicationContext();
            this.f52199t = iTuringPrivacyPolicy;
        }

        public final Builder a(String str) {
            this.f52192m = str;
            return this;
        }

        public final Builder b(boolean z3) {
            this.f52194o = z3;
            return this;
        }

        public final TuringSDK a() {
            return new TuringSDK(this);
        }

        public final Builder a(boolean z3) {
            this.f52191l = z3;
            return this;
        }

        public final Builder a(ITuringDeviceInfoProvider iTuringDeviceInfoProvider) {
            this.f52200u = iTuringDeviceInfoProvider;
            return this;
        }
    }

    public TuringSDK(Builder builder) {
        a(builder.f52180a);
        this.f51987g = builder.f52181b;
        this.f52003w = builder.f52182c;
        long unused = builder.f52183d;
        this.f52004x = builder.f52184e;
        this.f51993m = builder.f52186g;
        this.f51992l = builder.f52185f;
        this.f51994n = builder.f52187h;
        this.f51995o = builder.f52188i;
        this.f51996p = builder.f52190k;
        this.f51986f = builder.f52189j;
        this.f51988h = builder.f52191l;
        this.f51997q = builder.f52192m;
        this.f51991k = builder.f52193n;
        this.f52000t = builder.f52194o;
        String unused2 = builder.f52195p;
        this.f51998r = builder.f52196q;
        this.f51999s = builder.f52197r;
        this.f52001u = builder.f52198s;
        this.f51982b = builder.f52199t;
        this.f51983c = builder.f52200u;
        this.f51984d = builder.f52201v;
        this.f51985e = builder.f52202w;
        this.f52002v = builder.f52203x;
        this.f52006z = builder.f52204y;
        this.A = builder.f52205z;
        a();
    }

    public static Builder a(Context context, ITuringPrivacyPolicy iTuringPrivacyPolicy) {
        return new Builder(context, iTuringPrivacyPolicy);
    }

    public int d() {
        AtomicBoolean atomicBoolean = Kiwifruit.f52104b;
        synchronized (atomicBoolean) {
            if (atomicBoolean.get()) {
                return 0;
            }
            if (Build.VERSION.SDK_INT == 23) {
                String a4 = Cherry.a("M String fixed1".getBytes(), "UTF-8");
                if (a4 == null) {
                    a4 = "M String fixed1 failed";
                }
                Log.i("TuringFdJava", a4);
                String a5 = Cherry.a("M String fixed2".getBytes(), null);
                if (a5 == null) {
                    a5 = "M String fixed2 failed";
                }
                Log.i("TuringFdJava", a5);
            }
            int i4 = this.f51986f;
            if (i4 > 0) {
                Betelnut.f51924a = i4;
            }
            if (Betelnut.f51924a == 0) {
                Log.e("TuringFdJava", "please input valid channel!");
                return -10018;
            }
            Betelnut.f51925b = this.f52006z;
            synchronized (Cumquat.class) {
                Cumquat.B = this;
            }
            Log.i("TuringFdJava", Kiwifruit.b());
            AtomicReference<String> atomicReference = Cthrows.f52365a;
            if (!TextUtils.isEmpty(null)) {
                AtomicReference<String> atomicReference2 = Cthrows.f52365a;
                synchronized (atomicReference2) {
                    atomicReference2.set(null);
                }
            }
            System.currentTimeMillis();
            int b4 = Kiwifruit.b(this);
            if (b4 == 0) {
                b4 = Kiwifruit.c(this);
                if (b4 == 0) {
                    Guava.f52091b.f52092a = this;
                    Kiwifruit.a(this);
                    atomicBoolean.set(true);
                    return 0;
                }
            }
            return b4;
        }
    }
}
