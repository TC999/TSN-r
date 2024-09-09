package com.beizi.fusion.sm.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import java.lang.reflect.InvocationTargetException;

/* compiled from: XiaomiImpl.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class q implements com.beizi.fusion.sm.a.d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15067a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f15068b;

    /* renamed from: c  reason: collision with root package name */
    private Object f15069c;

    @SuppressLint({"PrivateApi"})
    public q(Context context) {
        this.f15067a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f15068b = cls;
            this.f15069c = cls.newInstance();
        } catch (Exception e4) {
            com.beizi.fusion.sm.a.f.a(e4);
        }
    }

    private String b() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) this.f15068b.getMethod("getOAID", Context.class).invoke(this.f15069c, this.f15067a);
    }

    @Override // com.beizi.fusion.sm.a.d
    public boolean a() {
        return this.f15069c != null;
    }

    @Override // com.beizi.fusion.sm.a.d
    public void a(com.beizi.fusion.sm.a.c cVar) {
        if (this.f15067a == null || cVar == null) {
            return;
        }
        if (this.f15068b != null && this.f15069c != null) {
            try {
                String b4 = b();
                if (b4 != null && b4.length() != 0) {
                    com.beizi.fusion.sm.a.f.a("OAID query success: " + b4);
                    cVar.a(b4);
                    return;
                }
                throw new com.beizi.fusion.sm.a.e("OAID query failed");
            } catch (Exception e4) {
                com.beizi.fusion.sm.a.f.a(e4);
                cVar.a(e4);
                return;
            }
        }
        cVar.a(new com.beizi.fusion.sm.a.e("Xiaomi IdProvider not exists"));
    }
}
