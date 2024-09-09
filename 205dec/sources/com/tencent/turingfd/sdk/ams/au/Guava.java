package com.tencent.turingfd.sdk.ams.au;

import com.tencent.turingfd.sdk.ams.au.Canesatici;
import com.tencent.turingfd.sdk.ams.au.Cinstanceof;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Guava {

    /* renamed from: b  reason: collision with root package name */
    public static final Guava f52091b = new Guava();

    /* renamed from: a  reason: collision with root package name */
    public Cumquat f52092a;

    public Herbaceous a(int i4, byte[] bArr, int i5, int i6, CanisMinor canisMinor) {
        Herbaceous a4;
        Canesatici canesatici = this.f52092a.f51981a;
        if (canesatici == null) {
            return Herbaceous.a(-20000);
        }
        try {
            System.currentTimeMillis();
            Canesatici.Cdo a5 = ((Cinstanceof.Cdo) canesatici).a(bArr);
            int i7 = a5.f51940a;
            if (i7 != 0) {
                a4 = Herbaceous.a(i7 - 20000);
            } else {
                a4 = Herbaceous.a(a5.f51941b);
            }
            return a4;
        } catch (Throwable unused) {
            return Herbaceous.a(-20000);
        }
    }
}
