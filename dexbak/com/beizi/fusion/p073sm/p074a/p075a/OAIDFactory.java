package com.beizi.fusion.p073sm.p074a.p075a;

import android.app.Application;
import android.content.Context;
import com.beizi.fusion.p073sm.p074a.IOAID;
import com.beizi.fusion.p073sm.p074a.OAIDLog;
import com.beizi.fusion.p073sm.p074a.OAIDRom;
import com.stub.StubApp;

/* renamed from: com.beizi.fusion.sm.a.a.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class OAIDFactory {

    /* renamed from: a */
    private static IOAID f11507a;

    /* renamed from: a */
    public static IOAID m48145a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        IOAID ioaid = f11507a;
        if (ioaid != null) {
            return ioaid;
        }
        IOAID m48144b = m48144b(context);
        f11507a = m48144b;
        if (m48144b != null && m48144b.mo48132a()) {
            OAIDLog.m48130a("Manufacturer interface has been found: " + f11507a.getClass().getName());
            return f11507a;
        }
        IOAID m48143c = m48143c(context);
        f11507a = m48143c;
        return m48143c;
    }

    /* renamed from: b */
    private static IOAID m48144b(Context context) {
        if (!OAIDRom.m48117k() && !OAIDRom.m48114n()) {
            if (OAIDRom.m48118j()) {
                return new MeizuImpl(context);
            }
            if (OAIDRom.m48116l()) {
                return new NubiaImpl(context);
            }
            if (!OAIDRom.m48123e() && !OAIDRom.m48122f() && !OAIDRom.m48121g()) {
                if (OAIDRom.m48119i()) {
                    return new SamsungImpl(context);
                }
                if (OAIDRom.m48124d()) {
                    return new VivoImpl(context);
                }
                if (OAIDRom.m48115m()) {
                    return new AsusImpl(context);
                }
                if (!OAIDRom.m48129a() && !OAIDRom.m48126b()) {
                    if (!OAIDRom.m48125c() && !OAIDRom.m48120h()) {
                        if (OAIDRom.m48128a(context)) {
                            return new CoolpadImpl(context);
                        }
                        if (OAIDRom.m48112p()) {
                            return new CooseaImpl(context);
                        }
                        if (OAIDRom.m48113o()) {
                            return new FreemeImpl(context);
                        }
                        return null;
                    }
                    return new OppoImpl(context);
                }
                return new HuaweiImpl(context);
            }
            return new XiaomiImpl(context);
        }
        return new LenovoImpl(context);
    }

    /* renamed from: c */
    private static IOAID m48143c(Context context) {
        MsaImpl msaImpl = new MsaImpl(context);
        if (msaImpl.mo48132a()) {
            OAIDLog.m48130a("Mobile Security Alliance has been found: " + MsaImpl.class.getName());
            return msaImpl;
        }
        GmsImpl gmsImpl = new GmsImpl(context);
        if (gmsImpl.mo48132a()) {
            OAIDLog.m48130a("Google Play Service has been found: " + GmsImpl.class.getName());
            return gmsImpl;
        }
        DefaultImpl defaultImpl = new DefaultImpl();
        OAIDLog.m48130a("OAID was not supported: " + DefaultImpl.class.getName());
        return defaultImpl;
    }
}
