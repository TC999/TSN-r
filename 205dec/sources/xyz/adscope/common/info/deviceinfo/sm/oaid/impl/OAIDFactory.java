package xyz.adscope.common.info.deviceinfo.sm.oaid.impl;

import android.app.Application;
import android.content.Context;
import com.stub.StubApp;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDLog;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDRom;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public final class OAIDFactory {

    /* renamed from: a  reason: collision with root package name */
    public static IOAID f64742a;

    /* renamed from: b  reason: collision with root package name */
    public static IOAID f64743b;

    public static IOAID a(Context context) {
        GmsImpl gmsImpl = new GmsImpl(context);
        f64743b = gmsImpl;
        if (gmsImpl.supported()) {
            OAIDLog.print("Google Play Service has been found: " + f64743b.getClass().getName());
            return f64743b;
        }
        return f64743b;
    }

    public static IOAID b(Context context) {
        if (OAIDRom.isLenovo() || OAIDRom.isMotolora()) {
            return new LenovoImpl(context);
        }
        if (OAIDRom.isMeizu()) {
            return new MeizuImpl(context);
        }
        if (OAIDRom.isNubia()) {
            return new NubiaImpl(context);
        }
        if (OAIDRom.isXiaomi() || OAIDRom.isMiui() || OAIDRom.isBlackShark()) {
            return new XiaomiImpl(context);
        }
        if (OAIDRom.isSamsung()) {
            return new SamsungImpl(context);
        }
        if (OAIDRom.isVivo()) {
            return new VivoImpl(context);
        }
        if (OAIDRom.isASUS()) {
            return new AsusImpl(context);
        }
        if (OAIDRom.isHuawei() || OAIDRom.isEmui()) {
            return new HuaweiImpl(context);
        }
        if (OAIDRom.isOppo() || OAIDRom.isOnePlus()) {
            return new OppoImpl(context);
        }
        if (OAIDRom.isCoolpad(context)) {
            return new CoolpadImpl(context);
        }
        if (OAIDRom.isCoosea()) {
            return new CooseaImpl(context);
        }
        if (OAIDRom.isFreeme()) {
            return new FreemeImpl(context);
        }
        return null;
    }

    public static IOAID c(Context context) {
        StringBuilder sb;
        Class cls;
        IOAID msaImpl = new MsaImpl(context);
        if (msaImpl.supported()) {
            sb = new StringBuilder();
            sb.append("Mobile Security Alliance has been found: ");
            cls = MsaImpl.class;
        } else {
            msaImpl = new GmsImpl(context);
            if (!msaImpl.supported()) {
                DefaultImpl defaultImpl = new DefaultImpl();
                OAIDLog.print("OAID was not supported: " + DefaultImpl.class.getName());
                return defaultImpl;
            }
            sb = new StringBuilder();
            sb.append("Google Play Service has been found: ");
            cls = GmsImpl.class;
        }
        sb.append(cls.getName());
        OAIDLog.print(sb.toString());
        return msaImpl;
    }

    public static IOAID create(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        IOAID ioaid = f64742a;
        if (ioaid != null) {
            return ioaid;
        }
        IOAID b4 = b(context);
        f64742a = b4;
        if (b4 == null || !b4.supported()) {
            IOAID c4 = c(context);
            f64742a = c4;
            return c4;
        }
        OAIDLog.print("Manufacturer interface has been found: " + f64742a.getClass().getName());
        return f64742a;
    }

    public static IOAID createGaid(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        IOAID ioaid = f64743b;
        if (ioaid != null) {
            return ioaid;
        }
        IOAID a4 = a(context);
        f64743b = a4;
        return a4;
    }
}
