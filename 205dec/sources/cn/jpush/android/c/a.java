package cn.jpush.android.c;

import android.os.Bundle;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f4101a;

    /* renamed from: b  reason: collision with root package name */
    private int f4102b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f4103c;

    public a(String str, int i4) {
        this.f4101a = str;
        this.f4102b = i4;
    }

    public int a() {
        return this.f4102b;
    }

    public void a(Bundle bundle) {
        this.f4103c = bundle;
    }

    public String toString() {
        return "CmdMessage{cmd='" + this.f4101a + "', errorCode=" + this.f4102b + ", extra=" + this.f4103c + '}';
    }
}
