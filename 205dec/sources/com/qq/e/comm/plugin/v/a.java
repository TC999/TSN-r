package com.qq.e.comm.plugin.v;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.i0.c;
import com.qq.e.comm.plugin.i0.n.c;
import com.qq.e.comm.plugin.i0.n.f;
import com.qq.e.comm.plugin.i0.n.g;
import com.qq.e.comm.plugin.n0.d;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.j2;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.util.o1;
import com.qq.e.comm.plugin.util.s0;
import com.qq.e.comm.plugin.util.t2;
import com.qq.e.comm.plugin.util.u1;
import com.qq.e.comm.plugin.util.w1;
import com.qq.e.comm.plugin.util.x1;
import com.qq.e.comm.plugin.w.b;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: m  reason: collision with root package name */
    private static final String f46769m = x1.a("bGlicGluZS5zbw");

    /* renamed from: n  reason: collision with root package name */
    private static volatile a f46770n;

    /* renamed from: a  reason: collision with root package name */
    private final File f46771a = b1.g();

    /* renamed from: b  reason: collision with root package name */
    private int f46772b;

    /* renamed from: c  reason: collision with root package name */
    private int f46773c;

    /* renamed from: d  reason: collision with root package name */
    private String f46774d;

    /* renamed from: e  reason: collision with root package name */
    private File f46775e;

    /* renamed from: f  reason: collision with root package name */
    private File f46776f;

    /* renamed from: g  reason: collision with root package name */
    private String f46777g;

    /* renamed from: h  reason: collision with root package name */
    private String f46778h;

    /* renamed from: i  reason: collision with root package name */
    private String f46779i;

    /* renamed from: j  reason: collision with root package name */
    private String f46780j;

    /* renamed from: k  reason: collision with root package name */
    private Class f46781k;

    /* renamed from: l  reason: collision with root package name */
    private b f46782l;

    private a() {
    }

    private void b() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_ASYNC, 0, this);
    }

    private boolean c() {
        return this.f46772b >= this.f46773c;
    }

    private boolean d() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 19 || i4 > 33) {
            return true;
        }
        return i4 == 23 && !w1.c();
    }

    private boolean e() throws Throwable {
        String optString;
        int length;
        if (d()) {
            return false;
        }
        String b4 = o.a() ? o1.b(GlobalSetting.getExtraUserData().get("debug_log")) : null;
        if (TextUtils.isEmpty(b4)) {
            b4 = com.qq.e.comm.plugin.d0.a.d().f().c("ecigs");
        }
        if (TextUtils.isEmpty(b4)) {
            return false;
        }
        JSONObject jSONObject = new JSONObject(b4);
        if (jSONObject.optLong("dl") <= System.currentTimeMillis()) {
            return false;
        }
        this.f46780j = b4;
        this.f46777g = jSONObject.optString("up");
        this.f46778h = jSONObject.optString("sgp");
        if (!TextUtils.isEmpty(this.f46777g) && !TextUtils.isEmpty(this.f46778h)) {
            String[] split = this.f46777g.split("_");
            if (split.length < 2) {
                return false;
            }
            String str = split[split.length - 1];
            this.f46774d = str;
            this.f46772b = u1.a(str, 0);
            this.f46773c = jSONObject.optInt("dgs", 3);
            if (c()) {
                return false;
            }
            String str2 = this.f46774d + "_uce";
            if (u1.a(str2, false)) {
                d a4 = a((Throwable) null);
                u1.a(str2);
                a(101, this.f46773c, a4);
                return false;
            }
            int pluginVersion = SDKStatus.getPluginVersion();
            int optInt = jSONObject.optInt("psv");
            int optInt2 = jSONObject.optInt("pev");
            if (pluginVersion >= optInt && pluginVersion <= optInt2) {
                String optString2 = jSONObject.optString("man");
                this.f46779i = optString2;
                if (TextUtils.isEmpty(optString2) || (length = (optString = jSONObject.optString("is")).length()) == 0) {
                    return false;
                }
                if (length == 1 && optString.charAt(0) == '*') {
                    return true;
                }
                int optInt3 = jSONObject.optInt("it");
                if (optInt3 == 0) {
                    return false;
                }
                HashSet hashSet = new HashSet(Arrays.asList(optString.split(",")));
                Context a5 = com.qq.e.comm.plugin.d0.a.d().a();
                if ((optInt3 & 1) == 1) {
                    String b5 = com.qq.e.comm.plugin.m.b.f44640f.b().b(a5);
                    if (!TextUtils.isEmpty(b5) && hashSet.contains(b5)) {
                        return true;
                    }
                }
                if ((optInt3 & 2) == 2) {
                    try {
                        String string = Settings.Secure.getString(a5.getContentResolver(), x1.a("Ymx1ZXRvb3RoX25hbWU="));
                        if (!TextUtils.isEmpty(string)) {
                            if (hashSet.contains(s0.a(string))) {
                                return true;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return false;
    }

    public static a a() {
        if (f46770n == null) {
            synchronized (a.class) {
                if (f46770n == null) {
                    f46770n = new a();
                }
            }
        }
        return f46770n;
    }

    public void a(Context context) {
        try {
            if (e()) {
                this.f46775e = new File(this.f46771a, this.f46774d);
                File file = this.f46771a;
                StringBuilder sb = new StringBuilder();
                sb.append(x1.a("am5p"));
                sb.append(File.separator);
                sb.append(w1.c() ? w1.f46681b : w1.f46683d);
                this.f46776f = new File(file, sb.toString());
                if (this.f46775e.exists() && j2.a().a(this.f46778h, this.f46775e)) {
                    if (!new File(this.f46776f, f46769m).exists()) {
                        a(true);
                        return;
                    } else {
                        b();
                        return;
                    }
                }
                b1.a(this.f46771a);
                a(this.f46777g, this.f46778h);
            }
        } catch (Throwable th) {
            v.b(9800000, null, 10, a(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.v.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class C0910a implements com.qq.e.comm.plugin.i0.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f46783a;

        C0910a(String str) {
            this.f46783a = str;
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(f fVar, g gVar) {
            try {
                if (gVar.getStatusCode() == 200) {
                    v.b(9800000, null, 0);
                    if (!j2.a().a(this.f46783a, b1.a(gVar, a.this.f46775e))) {
                        b1.a(a.this.f46771a);
                        v.b(9800001, null, 1, a.this.a((Throwable) null));
                    } else {
                        v.b(9800001, null, 0);
                        a.this.a(false);
                    }
                } else {
                    v.b(9800000, null, Integer.valueOf(gVar.getStatusCode()));
                }
            } catch (Exception e4) {
                v.b(9800002, null, 2, a.this.a(e4));
            }
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(f fVar, Exception exc) {
            v.b(9800000, null, 1, a.this.a(exc));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z3) {
        if (t2.a(this.f46775e.getAbsolutePath(), this.f46771a.getAbsolutePath())) {
            b();
            return;
        }
        v.b(9800002, null, 1);
        if (z3) {
            b1.a(this.f46771a);
            a(this.f46777g, this.f46778h);
        }
    }

    private void a(String str, String str2) {
        com.qq.e.comm.plugin.i0.d.a().a(new c(str, f.a.GET, (byte[]) null), c.a.f44221d, new C0910a(str2));
    }

    private void a(int i4, int i5, d dVar) {
        int i6 = this.f46772b + i5;
        this.f46772b = i6;
        u1.b(this.f46774d, i6);
        v.b(9800002, null, Integer.valueOf(i4), dVar);
    }

    private void a(d dVar) {
        v.b(9800003, null, null, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d a(Throwable th) {
        d dVar = new d();
        String str = this.f46774d;
        if (str != null) {
            dVar.a("ver", str);
        }
        if (th != null) {
            dVar.a("ot", x1.a(th));
        }
        return dVar;
    }
}
