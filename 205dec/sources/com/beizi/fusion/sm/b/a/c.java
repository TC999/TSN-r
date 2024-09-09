package com.beizi.fusion.sm.b.a;

import android.app.KeyguardManager;
import android.content.Context;

/* compiled from: CooseaImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c implements com.beizi.fusion.sm.b.c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15079a;

    /* renamed from: b  reason: collision with root package name */
    private final KeyguardManager f15080b;

    public c(Context context) {
        this.f15079a = context;
        this.f15080b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.f15079a == null || (keyguardManager = this.f15080b) == null) {
            return false;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.f15080b, new Object[0]);
            invoke.getClass();
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e4) {
            com.beizi.fusion.sm.b.e.a(e4);
            return false;
        }
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f15079a == null || bVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.f15080b;
        if (keyguardManager == null) {
            bVar.a(new com.beizi.fusion.sm.b.d("KeyguardManager not found"));
            return;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.f15080b, new Object[0]);
            if (invoke != null) {
                String obj = invoke.toString();
                com.beizi.fusion.sm.b.e.a("OAID obtain success: " + obj);
                bVar.a(obj);
                return;
            }
            throw new com.beizi.fusion.sm.b.d("OAID obtain failed");
        } catch (Exception e4) {
            com.beizi.fusion.sm.b.e.a(e4);
        }
    }
}
