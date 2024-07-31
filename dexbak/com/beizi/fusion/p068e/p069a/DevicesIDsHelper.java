package com.beizi.fusion.p068e.p069a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.beizi.fusion.p072g.C3116af;

/* renamed from: com.beizi.fusion.e.a.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DevicesIDsHelper {

    /* renamed from: a */
    private InterfaceC3094a f11172a;

    /* compiled from: DevicesIDsHelper.java */
    /* renamed from: com.beizi.fusion.e.a.b$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3094a {
        /* renamed from: a */
        void mo48445a(String str);
    }

    public DevicesIDsHelper(InterfaceC3094a interfaceC3094a) {
        this.f11172a = interfaceC3094a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public String m48562e() {
        return Build.MANUFACTURER.toUpperCase();
    }

    /* renamed from: c */
    public boolean m48564c() {
        String m48569a = m48569a("ro.build.freeme.label");
        return !TextUtils.isEmpty(m48569a) && m48569a.equalsIgnoreCase("FREEMEOS");
    }

    /* renamed from: d */
    public boolean m48563d() {
        String m48569a = m48569a("ro.ssui.product");
        return (TextUtils.isEmpty(m48569a) || m48569a.equalsIgnoreCase("unknown")) ? false : true;
    }

    /* renamed from: b */
    public static boolean m48567b() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("HUAWEI") && !str.equalsIgnoreCase("HONOR")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void m48571a(Context context) {
        String str = null;
        try {
            C3116af.m48494c("BeiZis", "init oaid " + m48562e());
            if ("ASUS".equals(m48562e().toUpperCase())) {
                m48566b(context);
            } else if (m48567b()) {
                m48566b(context);
            } else if ("LENOVO".equals(m48562e().toUpperCase())) {
                new LenovoDeviceIDHelper(context).m48560a(this.f11172a);
            } else if ("MOTOLORA".equals(m48562e().toUpperCase())) {
                new LenovoDeviceIDHelper(context).m48560a(this.f11172a);
            } else if ("MEIZU".equals(m48562e().toUpperCase())) {
                new MeizuDeviceIDHelper(context).m48558a(this.f11172a);
            } else if ("NUBIA".equals(m48562e().toUpperCase())) {
                str = new NubiaDeviceIDHelper(context).m48557a();
            } else if (m48572a()) {
                m48566b(context);
            } else if ("SAMSUNG".equals(m48562e().toUpperCase())) {
                m48566b(context);
            } else if ("VIVO".equals(m48562e().toUpperCase())) {
                str = new VivoDeviceIDHelper(context).m48551a();
            } else if ("XIAOMI".equals(m48562e().toUpperCase())) {
                str = new XiaomiDeviceIDHelper(context).m48550a();
            } else if ("BLACKSHARK".equals(m48562e().toUpperCase())) {
                str = new XiaomiDeviceIDHelper(context).m48550a();
            } else if ("ONEPLUS".equals(m48562e().toUpperCase())) {
                m48566b(context);
            } else if ("ZTE".equals(m48562e().toUpperCase())) {
                m48566b(context);
            } else {
                if (!"FERRMEOS".equals(m48562e().toUpperCase()) && !m48564c()) {
                    if ("SSUI".equals(m48562e().toUpperCase()) || m48563d()) {
                        m48566b(context);
                    }
                }
                m48566b(context);
            }
            InterfaceC3094a interfaceC3094a = this.f11172a;
            if (interfaceC3094a == null || str == null) {
                return;
            }
            interfaceC3094a.mo48445a(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m48566b(final Context context) {
        new Thread(new Runnable() { // from class: com.beizi.fusion.e.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (context == null) {
                    return;
                }
                try {
                    if ("ASUS".equals(DevicesIDsHelper.this.m48562e().toUpperCase())) {
                        new ASUSDeviceIDHelper(context).m48573a(DevicesIDsHelper.this.f11172a);
                    } else if (DevicesIDsHelper.m48567b()) {
                        new HWDeviceIDHelper(context).m48561a(DevicesIDsHelper.this.f11172a);
                    } else if (DevicesIDsHelper.m48572a()) {
                        new OppoDeviceIDHelper(context).m48554a(DevicesIDsHelper.this.f11172a);
                    } else if ("ONEPLUS".equals(DevicesIDsHelper.this.m48562e().toUpperCase())) {
                        new OnePlusDeviceIDHelper(context).m48556a(DevicesIDsHelper.this.f11172a);
                    } else if ("ZTE".equals(DevicesIDsHelper.this.m48562e().toUpperCase())) {
                        new ZTEDeviceIDHelper(context).m48547a(DevicesIDsHelper.this.f11172a);
                    } else {
                        if (!"FERRMEOS".equals(DevicesIDsHelper.this.m48562e().toUpperCase()) && !DevicesIDsHelper.this.m48564c()) {
                            if (!"SSUI".equals(DevicesIDsHelper.this.m48562e().toUpperCase()) && !DevicesIDsHelper.this.m48563d()) {
                                if ("SAMSUNG".equals(DevicesIDsHelper.this.m48562e().toUpperCase())) {
                                    new SamsungDeviceIDHelper(context).m48552a(DevicesIDsHelper.this.f11172a);
                                }
                            }
                            new ZTEDeviceIDHelper(context).m48547a(DevicesIDsHelper.this.f11172a);
                        }
                        new ZTEDeviceIDHelper(context).m48547a(DevicesIDsHelper.this.f11172a);
                    }
                } catch (Throwable unused) {
                    C3116af.m48494c("BeiZis", "getIDFromNewThead exception");
                }
            }
        }).start();
    }

    /* renamed from: a */
    public static boolean m48572a() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("OPPO")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("OPPO") && !str.equalsIgnoreCase("REALME") && TextUtils.isEmpty(m48568a("ro.build.version.opporom", ""))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static String m48568a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            C3116af.m48494c("BeiZis", "System property invoke error: " + e);
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    /* renamed from: a */
    private String m48569a(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception unused) {
            return null;
        }
    }
}
