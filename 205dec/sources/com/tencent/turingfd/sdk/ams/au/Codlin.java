package com.tencent.turingfd.sdk.ams.au;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class Codlin extends Draco {

    /* renamed from: g  reason: collision with root package name */
    public static ArrayList<Core> f51971g;

    /* renamed from: c  reason: collision with root package name */
    public long f51972c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f51973d = 0;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Core> f51974e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f51975f = 0;

    @Override // com.tencent.turingfd.sdk.ams.au.Draco
    public void a(Dorado dorado) {
        dorado.a(this.f51972c, 0);
        dorado.a(this.f51973d, 1);
        dorado.a((Collection) this.f51974e, 2);
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Draco
    public void a(Cygnus cygnus) {
        this.f51972c = cygnus.a(this.f51972c, 0, true);
        this.f51973d = cygnus.a(this.f51973d, 1, true);
        if (f51971g == null) {
            ArrayList<Core> arrayList = new ArrayList<>();
            f51971g = arrayList;
            arrayList.add(new Core());
        }
        this.f51974e = (ArrayList) cygnus.a((Cygnus) f51971g, 2, true);
    }
}
