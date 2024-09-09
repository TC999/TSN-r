package com.qq.e.comm.plugin.d0.e;

import android.content.Context;
import android.os.Build;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.plugin.util.e1;
import com.qq.e.comm.plugin.util.v0;
import com.qq.e.comm.plugin.util.y;
import com.tencent.gatherer.a.a.a.b;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: s  reason: collision with root package name */
    private static Integer f42270s;

    /* renamed from: a  reason: collision with root package name */
    private String f42271a;

    /* renamed from: b  reason: collision with root package name */
    private int f42272b;

    /* renamed from: c  reason: collision with root package name */
    private int f42273c;

    /* renamed from: d  reason: collision with root package name */
    private int f42274d;

    /* renamed from: e  reason: collision with root package name */
    private String f42275e;

    /* renamed from: f  reason: collision with root package name */
    private volatile String f42276f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f42277g;

    /* renamed from: h  reason: collision with root package name */
    private long f42278h;

    /* renamed from: i  reason: collision with root package name */
    private AtomicInteger f42279i;

    /* renamed from: j  reason: collision with root package name */
    public final String f42280j = Build.MODEL;

    /* renamed from: k  reason: collision with root package name */
    private final Context f42281k;

    /* renamed from: l  reason: collision with root package name */
    private int f42282l;

    /* renamed from: m  reason: collision with root package name */
    private volatile String f42283m;

    /* renamed from: n  reason: collision with root package name */
    private volatile String f42284n;

    /* renamed from: o  reason: collision with root package name */
    private volatile String f42285o;

    /* renamed from: p  reason: collision with root package name */
    private volatile String f42286p;

    /* renamed from: q  reason: collision with root package name */
    private volatile String f42287q;

    /* renamed from: r  reason: collision with root package name */
    private volatile String f42288r;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f42289a;

        static {
            int[] iArr = new int[d.values().length];
            f42289a = iArr;
            try {
                iArr[d.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42289a[d.UNKNOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(Context context) {
        this.f42281k = context.getApplicationContext();
    }

    private int a(DisplayMetrics displayMetrics) {
        if (r() > 3) {
            return displayMetrics.densityDpi;
        }
        return 120;
    }

    private int b(DisplayMetrics displayMetrics) {
        if (r() > 3) {
            return a(displayMetrics.density, displayMetrics.heightPixels);
        }
        return displayMetrics.heightPixels;
    }

    private int c(DisplayMetrics displayMetrics) {
        if (r() > 3) {
            return a(displayMetrics.density, displayMetrics.widthPixels);
        }
        return displayMetrics.widthPixels;
    }

    private String m() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, 0, this);
    }

    private int v() {
        if (e1.h() < 460) {
            return 0;
        }
        try {
            int identifier = this.f42281k.getResources().getIdentifier("min_screen_width_bucket", "integer", this.f42281k.getPackageName());
            if (identifier == 0) {
                return 0;
            }
            return this.f42281k.getResources().getInteger(identifier);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static boolean w() {
        return !y.b("device_id") && GlobalSetting.isAgreeReadDeviceId();
    }

    public String d() {
        if (this.f42285o == null) {
            this.f42285o = Build.VERSION.CODENAME;
        }
        return this.f42285o;
    }

    public String e() {
        d b4 = v0.b();
        if (b4 == null) {
            return null;
        }
        int i4 = a.f42289a[b4.ordinal()];
        return i4 != 1 ? i4 != 2 ? "ed" : "unknow" : "wi";
    }

    public int f() {
        return this.f42274d;
    }

    public int g() {
        return this.f42273c;
    }

    public String h() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 0, this);
    }

    public int i() {
        return this.f42272b;
    }

    public Map<String, String> j() {
        return (Map) pro.getobjresult(192, 0, this);
    }

    public String k() {
        if (this.f42271a == null) {
            String lowerCase = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
            this.f42271a = lowerCase;
            if (lowerCase.length() == 0) {
                this.f42271a = "en";
            }
        }
        return this.f42271a;
    }

    public int l() {
        return this.f42282l;
    }

    public d n() {
        return v0.b();
    }

    public String o() {
        return (String) pro.getobjresult(193, 0, this);
    }

    public String p() {
        if (this.f42284n != null) {
            return this.f42284n;
        }
        synchronized (this) {
            if (this.f42284n == null) {
                this.f42284n = Build.VERSION.SDK_INT >= 30 ? Build.VERSION.RELEASE_OR_CODENAME : Build.VERSION.RELEASE;
            }
        }
        return this.f42284n;
    }

    public String q() {
        if (this.f42281k.getResources().getConfiguration().orientation == 2) {
            this.f42275e = "l";
        } else {
            this.f42275e = "p";
        }
        return this.f42275e;
    }

    public int r() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception unused) {
            return 3;
        }
    }

    public String s() {
        return this.f42286p;
    }

    public boolean t() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f42278h < 60000) {
            return this.f42277g;
        }
        this.f42278h = currentTimeMillis;
        boolean z3 = true;
        if (Build.VERSION.SDK_INT < 23) {
            this.f42277g = true;
            return true;
        }
        if (this.f42279i == null) {
            this.f42279i = new AtomicInteger(com.qq.e.comm.plugin.d0.a.d().f().a("rpspc", Integer.MAX_VALUE));
        }
        if (this.f42279i.getAndDecrement() > 0) {
            try {
                if (this.f42281k.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
                    z3 = false;
                }
                this.f42277g = z3;
            } catch (Throwable unused) {
            }
        }
        return this.f42277g;
    }

    public void u() {
        DisplayMetrics a4 = a(this.f42281k);
        this.f42274d = a(a4);
        this.f42272b = c(a4);
        this.f42273c = b(a4);
        this.f42282l = v();
    }

    public boolean x() {
        return "l".equals(q());
    }

    public boolean y() {
        return "p".equals(q());
    }

    private DisplayMetrics a(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    private int a(float f4, int i4) {
        return (this.f42281k.getApplicationInfo().flags & 8192) != 0 ? (int) (i4 / f4) : i4;
    }

    public b b() {
        String o4 = o();
        if (o4 != null) {
            if (!o4.equals("46000") && !o4.equals("46002") && !o4.equals("46007") && !o4.equals("46020")) {
                if (!o4.equals("46001") && !o4.equals("46006")) {
                    if (o4.equals("46003") || o4.equals("46005")) {
                        return b.f42268g;
                    }
                } else {
                    return b.f42267f;
                }
            } else {
                return b.f42266e;
            }
        }
        return b.f42265d;
    }

    public String c() {
        if (this.f42287q != null) {
            return this.f42287q;
        }
        synchronized (this) {
            if (this.f42287q == null) {
                this.f42287q = com.tencent.gatherer.a.a.a.c.a(this.f42281k, new b.C1034b().b(true).a(true).a());
            }
        }
        return this.f42287q;
    }

    private int a(CdmaCellLocation cdmaCellLocation) {
        if (f42270s == null) {
            f42270s = Integer.valueOf(cdmaCellLocation.getBaseStationId());
        }
        return f42270s.intValue();
    }

    private int a(GsmCellLocation gsmCellLocation) {
        if (f42270s == null) {
            f42270s = Integer.valueOf(gsmCellLocation.getCid());
        }
        return f42270s.intValue();
    }

    public String a() {
        if (this.f42283m == null) {
            this.f42283m = Build.ID;
        }
        return this.f42283m;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(this.f42286p)) {
            return;
        }
        int indexOf = str.indexOf("GDTMobSDK");
        if (indexOf > 0) {
            this.f42286p = str.substring(0, indexOf - 1);
        } else {
            this.f42286p = str;
        }
    }
}
