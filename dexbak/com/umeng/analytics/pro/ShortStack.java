package com.umeng.analytics.pro;

/* renamed from: com.umeng.analytics.pro.bp */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ShortStack {

    /* renamed from: a */
    private short[] f37937a;

    /* renamed from: b */
    private int f37938b = -1;

    public ShortStack(int i) {
        this.f37937a = new short[i];
    }

    /* renamed from: d */
    private void m14548d() {
        short[] sArr = this.f37937a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.f37937a = sArr2;
    }

    /* renamed from: a */
    public short m14552a() {
        short[] sArr = this.f37937a;
        int i = this.f37938b;
        this.f37938b = i - 1;
        return sArr[i];
    }

    /* renamed from: b */
    public short m14550b() {
        return this.f37937a[this.f37938b];
    }

    /* renamed from: c */
    public void m14549c() {
        this.f37938b = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        for (int i = 0; i < this.f37937a.length; i++) {
            if (i != 0) {
                sb.append(" ");
            }
            if (i == this.f37938b) {
                sb.append(">>");
            }
            sb.append((int) this.f37937a[i]);
            if (i == this.f37938b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }

    /* renamed from: a */
    public void m14551a(short s) {
        if (this.f37937a.length == this.f37938b + 1) {
            m14548d();
        }
        short[] sArr = this.f37937a;
        int i = this.f37938b + 1;
        this.f37938b = i;
        sArr[i] = s;
    }
}
