package com.kwad.sdk.p438ip.direct;

/* renamed from: com.kwad.sdk.ip.direct.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10816c implements Comparable<C10816c> {

    /* renamed from: ip */
    private String f29661ip;
    private boolean success;
    private int weight;
    private float aIG = -1.0f;
    private int aIM = 20;
    private int aIL = 3;
    private StringBuffer aIN = new StringBuffer();

    public C10816c(String str) {
        this.f29661ip = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(C10816c c10816c) {
        return (int) (this.aIG - c10816c.aIG);
    }

    /* renamed from: IQ */
    public final int m24757IQ() {
        return this.aIL;
    }

    /* renamed from: IR */
    public final float m24756IR() {
        return this.aIG;
    }

    /* renamed from: bC */
    public final void m24754bC(boolean z) {
        this.success = z;
    }

    /* renamed from: dB */
    public final void m24753dB(int i) {
        this.weight = i;
    }

    public final String getIp() {
        return this.f29661ip;
    }

    public final int getWeight() {
        return this.weight;
    }

    /* renamed from: i */
    public final void m24752i(float f) {
        this.aIG = f;
    }

    public final boolean isSuccess() {
        return this.success;
    }

    public final String toString() {
        return "PingNetEntity{ip='" + this.f29661ip + "', pingCount=" + this.aIL + ", pingWaitTime=" + this.aIM + ", pingTime='" + this.aIG + " ms', success=" + this.success + '}';
    }
}
