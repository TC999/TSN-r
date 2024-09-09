package com.beizi.fusion.sm.a.a;

import android.app.KeyguardManager;
import android.content.Context;

/* compiled from: CooseaImpl.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class c implements com.beizi.fusion.sm.a.d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15042a;

    /* renamed from: b  reason: collision with root package name */
    private final KeyguardManager f15043b;

    public c(Context context) {
        this.f15042a = context;
        this.f15043b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.beizi.fusion.sm.a.d
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.f15042a == null || (keyguardManager = this.f15043b) == null) {
            return false;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.f15043b, new Object[0]);
            invoke.getClass();
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e4) {
            com.beizi.fusion.sm.a.f.a(e4);
            return false;
        }
    }

    @Override // com.beizi.fusion.sm.a.d
    public void a(com.beizi.fusion.sm.a.c cVar) {
        if (this.f15042a == null || cVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.f15043b;
        if (keyguardManager == null) {
            cVar.a(new com.beizi.fusion.sm.a.e("KeyguardManager not found"));
            return;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.f15043b, new Object[0]);
            if (invoke != null) {
                String obj = invoke.toString();
                com.beizi.fusion.sm.a.f.a("OAID obtain success: " + obj);
                cVar.a(obj);
                return;
            }
            throw new com.beizi.fusion.sm.a.e("OAID obtain failed");
        } catch (Exception e4) {
            com.beizi.fusion.sm.a.f.a(e4);
        }
    }
}
