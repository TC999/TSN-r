package com.beizi.fusion.p073sm.p074a.p075a;

import android.app.KeyguardManager;
import android.content.Context;
import com.beizi.fusion.p073sm.p074a.IGetter;
import com.beizi.fusion.p073sm.p074a.IOAID;
import com.beizi.fusion.p073sm.p074a.OAIDException;
import com.beizi.fusion.p073sm.p074a.OAIDLog;

/* renamed from: com.beizi.fusion.sm.a.a.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CooseaImpl implements IOAID {

    /* renamed from: a */
    private final Context f11492a;

    /* renamed from: b */
    private final KeyguardManager f11493b;

    public CooseaImpl(Context context) {
        this.f11492a = context;
        this.f11493b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    /* renamed from: a */
    public boolean mo48132a() {
        KeyguardManager keyguardManager;
        if (this.f11492a == null || (keyguardManager = this.f11493b) == null) {
            return false;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.f11493b, new Object[0]);
            invoke.getClass();
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e) {
            OAIDLog.m48130a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    /* renamed from: a */
    public void mo48131a(IGetter iGetter) {
        if (this.f11492a == null || iGetter == null) {
            return;
        }
        KeyguardManager keyguardManager = this.f11493b;
        if (keyguardManager == null) {
            iGetter.mo48134a(new OAIDException("KeyguardManager not found"));
            return;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.f11493b, new Object[0]);
            if (invoke != null) {
                String obj = invoke.toString();
                OAIDLog.m48130a("OAID obtain success: " + obj);
                iGetter.mo48133a(obj);
                return;
            }
            throw new OAIDException("OAID obtain failed");
        } catch (Exception e) {
            OAIDLog.m48130a(e);
        }
    }
}
