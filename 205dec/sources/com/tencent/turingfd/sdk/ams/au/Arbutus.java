package com.tencent.turingfd.sdk.ams.au;

/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Arbutus {

    /* renamed from: a  reason: collision with root package name */
    public static final GalacticCore<Cconst> f51887a = new GalacticCore<>(3);

    /* renamed from: b  reason: collision with root package name */
    public static final GalacticCore<Cconst> f51888b = new GalacticCore<>(3);

    /* renamed from: c  reason: collision with root package name */
    public static final Cconst[] f51889c = new Cconst[0];

    /* renamed from: d  reason: collision with root package name */
    public static long f51890d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static final Lichee f51891e = new Cdo();

    /* renamed from: com.tencent.turingfd.sdk.ams.au.Arbutus$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class Cdo implements Lichee {
        public void a(Cconst cconst) {
            int i4 = cconst.f52236b;
            if (i4 != 2 && i4 != 3) {
                Codlin codlin = cconst.f52237c;
                if (codlin != null) {
                    long abs = Math.abs(codlin.f51972c - Arbutus.f51890d);
                    Arbutus.f51890d = System.currentTimeMillis();
                    if (abs < 1000) {
                        return;
                    }
                    GalacticCore<Cconst> galacticCore = Arbutus.f51887a;
                    synchronized (galacticCore) {
                        galacticCore.a(cconst);
                    }
                    return;
                }
                return;
            }
            GalacticCore<Cconst> galacticCore2 = Arbutus.f51888b;
            synchronized (galacticCore2) {
                galacticCore2.a(cconst);
            }
        }
    }
}
