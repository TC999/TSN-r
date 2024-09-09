package com.tencent.turingfd.sdk.ams.au;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.turingfd.sdk.ams.au.Csuper;
import com.tencent.turingfd.sdk.ams.au.Foxnut;
import java.util.HashMap;
import java.util.Locale;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Kiwifruit {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f52103a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicBoolean f52104b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public static final Pegasus f52105c = new Pegasus(false);

    /* renamed from: d  reason: collision with root package name */
    public static final Pegasus f52106d = new Pegasus(true);

    public static void a(Cumquat cumquat) {
        Context context;
        Foxnut foxnut = Foxnut.f52052l;
        foxnut.f52055a = cumquat;
        if (!foxnut.f52057c) {
            foxnut.f52057c = true;
            Ctry.a(cumquat.b());
            HandlerThread handlerThread = new HandlerThread("TuringFdCore_89_" + Betelnut.f51924a + "_au", -8);
            handlerThread.start();
            foxnut.f52056b = new Foxnut.Cdo(handlerThread.getLooper(), cumquat.b());
            Ginkgo ginkgo = new Ginkgo(foxnut.f52056b);
            foxnut.f52058d = ginkgo;
            Grape grape = Grape.f52082g;
            grape.f52087d = cumquat;
            grape.f52088e = ginkgo;
            int[] iArr = Cbreak.f52223a;
            if (iArr.length > 0) {
                synchronized (grape.f52084a) {
                    for (int i4 : iArr) {
                        grape.f52084a.add(Integer.valueOf(i4));
                    }
                }
            }
            grape.b();
            new Durian(foxnut).start();
        }
        Banana.f51901b = cumquat;
        GalacticCore<Cconst> galacticCore = Arbutus.f51887a;
        if (Gooseberry.f52078f.a("enable_risk_click", Betelnut.f51925b)) {
            if (Build.VERSION.SDK_INT >= 28 && !Cthis.a()) {
                UrsaMajor.a();
            }
            Log.i("TRCDM", "erc");
            Lichee lichee = Arbutus.f51891e;
            synchronized (Csuper.class) {
                WeakHashMap<Activity, Object> weakHashMap = Csuper.f52357a;
                if (lichee != null) {
                    synchronized (Ctry.class) {
                        context = Ctry.f52366a;
                    }
                    if (context instanceof Application) {
                        Application application = (Application) context;
                        AtomicReference<Csuper.Cdo> atomicReference = Csuper.f52358b;
                        synchronized (atomicReference) {
                            if (atomicReference.get() == null) {
                                HandlerThread handlerThread2 = new HandlerThread("TuringDispatch");
                                handlerThread2.start();
                                Csuper.Cdo cdo = new Csuper.Cdo(new Cclass(handlerThread2.getLooper(), lichee));
                                atomicReference.set(cdo);
                                application.registerActivityLifecycleCallbacks(cdo);
                            }
                        }
                    }
                }
            }
        }
    }

    public static int b(Cumquat cumquat) {
        AtomicBoolean atomicBoolean = f52103a;
        if (atomicBoolean.get()) {
            return 0;
        }
        boolean z3 = true;
        if (cumquat.f51988h) {
            TextUtils.isEmpty(cumquat.f51991k);
            String str = cumquat.f51991k;
            try {
                if (TextUtils.isEmpty(str)) {
                    System.loadLibrary("turingau");
                } else {
                    System.load(str);
                }
            } catch (Throwable th) {
                Log.w("TuringFdJava", th);
                z3 = false;
            }
            f52103a.set(z3);
            if (!z3) {
                Log.e("TuringFdJava", "load so failure");
            }
        } else {
            atomicBoolean.set(true);
        }
        return f52103a.get() ? 0 : -10001;
    }

    public static int c(Cumquat cumquat) {
        Context b4 = cumquat.b();
        HashMap hashMap = new HashMap();
        Gooseberry gooseberry = Gooseberry.f52078f;
        boolean a4 = Sagittarius.a();
        String str = "1";
        hashMap.put("2008", (a4 && gooseberry.a("e_w_d", false)) ? "1" : "0");
        hashMap.put("2009", (a4 && gooseberry.a("e_r_d", true)) ? "1" : "0");
        hashMap.put("2010", (a4 && gooseberry.a("e_w_nd", true)) ? "1" : "0");
        hashMap.put("2011", (a4 && gooseberry.a("e_r_nd", true)) ? "0" : "0");
        hashMap.put("2025", "0");
        try {
            int b5 = Norma.b(TNative$aa.i89_DEE08458D4E8C7EA(new SparseArray(), b4, hashMap, f52105c, f52106d));
            if (b5 != 0) {
                Log.e("TuringFdJava", "native init fail, err: " + b5);
                return -10020;
            }
            return 0;
        } catch (Throwable th) {
            Log.e("TuringFdJava", "native init exception", th);
            return -10020;
        }
    }

    public static String b() {
        Cumquat cumquat;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.SIMPLIFIED_CHINESE, "TuringFD v%d", 89));
        sb.append(" (DEE08458D4E8C7EA");
        sb.append(", au");
        sb.append(", 521532f");
        StringBuilder sb2 = new StringBuilder();
        if (sb2.toString().length() > 0) {
            sb2.append(";");
        }
        sb2.append("rfr");
        if (sb2.toString().length() > 0) {
            sb2.append(";");
        }
        sb2.append("rs");
        String sb3 = sb2.toString();
        if (!TextUtils.isEmpty(sb3)) {
            sb.append(", ");
            sb.append(sb3);
        }
        sb.append(", ");
        StringBuilder sb4 = new StringBuilder();
        if (sb4.toString().length() > 0) {
            sb4.append(";");
        }
        sb4.append("wup");
        if (sb4.toString().length() > 0) {
            sb4.append(";");
        }
        sb4.append("105498");
        sb.append(sb4.toString());
        sb.append(String.format(Locale.SIMPLIFIED_CHINESE, ", compiled %s)", "2024_04_28_15_58_51"));
        synchronized (Cumquat.class) {
            cumquat = Cumquat.B;
        }
        if (cumquat != null) {
            sb.append(" [");
            StringBuilder sb5 = new StringBuilder();
            StringBuilder a4 = Almond.a("url(");
            a4.append(TextUtils.join(",", cumquat.f51989i));
            a4.append(")");
            String sb6 = a4.toString();
            if (sb5.toString().length() > 0) {
                sb5.append(";");
            }
            sb5.append(sb6);
            String str = "c(" + cumquat.f51986f + ")";
            if (sb5.toString().length() > 0) {
                sb5.append(";");
            }
            sb5.append(str);
            if (cumquat.f52005y) {
                if (sb5.toString().length() > 0) {
                    sb5.append(";");
                }
                sb5.append("ext");
            }
            sb.append(sb5.toString());
            sb.append("]");
        }
        return sb.toString();
    }

    public static int a() {
        Cumquat cumquat;
        if (f52103a.get()) {
            if (Betelnut.f51924a == 0) {
                return -10018;
            }
            if (f52104b.get()) {
                synchronized (Cumquat.class) {
                    cumquat = Cumquat.B;
                }
                return !cumquat.c().a() ? -10019 : 0;
            }
            return -10002;
        }
        return -10001;
    }
}
