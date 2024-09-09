package com.tencent.turingfd.sdk.ams.au;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class Bergamot extends Draco implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    public int f51915c = 0;

    /* renamed from: d  reason: collision with root package name */
    public Cpackage f51916d = null;

    /* renamed from: e  reason: collision with root package name */
    public long f51917e = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ boolean f51914g = !Bergamot.class.desiredAssertionStatus();

    /* renamed from: f  reason: collision with root package name */
    public static Cpackage f51913f = new Cpackage();

    @Override // com.tencent.turingfd.sdk.ams.au.Draco
    public void a(Dorado dorado) {
        dorado.a(this.f51915c, 0);
        Cpackage cpackage = this.f51916d;
        if (cpackage != null) {
            dorado.a((Draco) cpackage, 1);
        }
        dorado.a(this.f51917e, 2);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f51914g) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Bergamot bergamot = (Bergamot) obj;
        return Eridanus.a(this.f51915c, bergamot.f51915c) && this.f51916d.equals(bergamot.f51916d) && Eridanus.a(this.f51917e, bergamot.f51917e);
    }

    public int hashCode() {
        try {
            throw new Exception("");
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Draco
    public void a(Cygnus cygnus) {
        this.f51915c = cygnus.a(this.f51915c, 0, true);
        this.f51916d = (Cpackage) cygnus.a((Draco) f51913f, 1, false);
        this.f51917e = cygnus.a(this.f51917e, 2, true);
    }
}
