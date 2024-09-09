package com.amap.api.col.p0003l;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AmapCell.java */
/* renamed from: com.amap.api.col.3l.ko  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class ko implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f8261a;

    /* renamed from: b  reason: collision with root package name */
    public String f8262b;

    /* renamed from: c  reason: collision with root package name */
    public int f8263c;

    /* renamed from: d  reason: collision with root package name */
    public int f8264d;

    /* renamed from: e  reason: collision with root package name */
    public long f8265e;

    /* renamed from: f  reason: collision with root package name */
    public long f8266f;

    /* renamed from: g  reason: collision with root package name */
    public int f8267g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f8268h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f8269i;

    public ko() {
        this.f8261a = "";
        this.f8262b = "";
        this.f8263c = 99;
        this.f8264d = Integer.MAX_VALUE;
        this.f8265e = 0L;
        this.f8266f = 0L;
        this.f8267g = 0;
        this.f8269i = true;
    }

    private static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e4) {
            n9.a(e4);
            return 0;
        }
    }

    @Override // 
    /* renamed from: a */
    public abstract ko clone();

    public final int b() {
        return a(this.f8261a);
    }

    public final int c() {
        return a(this.f8262b);
    }

    public String toString() {
        return "AmapCell{mcc=" + this.f8261a + ", mnc=" + this.f8262b + ", signalStrength=" + this.f8263c + ", asulevel=" + this.f8264d + ", lastUpdateSystemMills=" + this.f8265e + ", lastUpdateUtcMills=" + this.f8266f + ", age=" + this.f8267g + ", main=" + this.f8268h + ", newapi=" + this.f8269i + '}';
    }

    public final void a(ko koVar) {
        this.f8261a = koVar.f8261a;
        this.f8262b = koVar.f8262b;
        this.f8263c = koVar.f8263c;
        this.f8264d = koVar.f8264d;
        this.f8265e = koVar.f8265e;
        this.f8266f = koVar.f8266f;
        this.f8267g = koVar.f8267g;
        this.f8268h = koVar.f8268h;
        this.f8269i = koVar.f8269i;
    }

    public ko(boolean z3, boolean z4) {
        this.f8261a = "";
        this.f8262b = "";
        this.f8263c = 99;
        this.f8264d = Integer.MAX_VALUE;
        this.f8265e = 0L;
        this.f8266f = 0L;
        this.f8267g = 0;
        this.f8268h = z3;
        this.f8269i = z4;
    }
}
