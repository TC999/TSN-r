package com.beizi.fusion.sm.b.a;

import android.annotation.SuppressLint;
import android.content.Context;
import java.lang.reflect.InvocationTargetException;

/* compiled from: XiaomiImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class q implements com.beizi.fusion.sm.b.c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15104a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f15105b;

    /* renamed from: c  reason: collision with root package name */
    private Object f15106c;

    @SuppressLint({"PrivateApi"})
    public q(Context context) {
        this.f15104a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f15105b = cls;
            this.f15106c = cls.newInstance();
        } catch (Exception e4) {
            com.beizi.fusion.sm.b.e.a(e4);
        }
    }

    private String b() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) this.f15105b.getMethod("getOAID", Context.class).invoke(this.f15106c, this.f15104a);
    }

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        return this.f15106c != null;
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f15104a == null || bVar == null) {
            return;
        }
        if (this.f15105b != null && this.f15106c != null) {
            try {
                String b4 = b();
                if (b4 != null && b4.length() != 0) {
                    com.beizi.fusion.sm.b.e.a("OAID query success: " + b4);
                    bVar.a(b4);
                    return;
                }
                throw new com.beizi.fusion.sm.b.d("OAID query failed");
            } catch (Exception e4) {
                com.beizi.fusion.sm.b.e.a(e4);
                bVar.a(e4);
                return;
            }
        }
        bVar.a(new com.beizi.fusion.sm.b.d("Xiaomi IdProvider not exists"));
    }
}
