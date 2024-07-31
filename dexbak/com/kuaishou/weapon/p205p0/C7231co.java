package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import com.kwad.sdk.p433f.C10758b;
import com.tencent.connect.common.Constants;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* renamed from: com.kuaishou.weapon.p0.co */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7231co {

    /* renamed from: a */
    private Context f24712a;

    public C7231co(Context context) {
        this.f24712a = context;
    }

    /* renamed from: a */
    public String m34051a(String str) {
        JSONObject m34081a;
        JSONObject m34052a;
        try {
            C7229cm c7229cm = new C7229cm(str, C7227ck.f24680l);
            String m33948a = C7268dl.m33948a(C7239cu.f24730a);
            String m34050b = m34050b(m33948a);
            if (TextUtils.isEmpty(m34050b) || (m34081a = c7229cm.m34081a(this.f24712a)) == null) {
                return null;
            }
            String str2 = C7239cu.f24737h + "?" + C7240cv.m34030a(this.f24712a);
            if (C7239cu.m34032a() && C7239cu.f24730a.contains("api")) {
                str2 = "/api" + str2;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, m34050b);
            jSONObject.put("host", m33948a);
            jSONObject.put("path", str2);
            String str3 = WeaponHI.cookieData;
            if (!TextUtils.isEmpty(str3) && str3.length() > 10) {
                jSONObject.put("cookie", str3);
            }
            jSONObject.put("head", m34081a);
            StringBuilder sb = new StringBuilder();
            sb.append("sdk=" + Build.VERSION.SDK_INT);
            jSONObject.put("parame", sb.toString());
            if (str.equals(C7227ck.f24676h) && (m34052a = m34052a()) != null) {
                jSONObject.put("sjd", m34052a);
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    public String m34050b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String hostAddress = InetAddress.getByName(C7268dl.m33948a(str)).getHostAddress();
            try {
                if (!TextUtils.isEmpty(hostAddress)) {
                    if (hostAddress.contains(".")) {
                        return hostAddress;
                    }
                }
                return "";
            } catch (UnknownHostException unused) {
                return hostAddress;
            }
        } catch (UnknownHostException unused2) {
            return "";
        }
    }

    /* renamed from: a */
    private JSONObject m34052a() {
        try {
            System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            C7283h m33888a = C7283h.m33888a(this.f24712a, "re_po_rt");
            m33888a.m33867e("a1_p_s_p_s");
            m33888a.m33867e("a1_p_s_p_s_c_b");
            C7166aj c7166aj = new C7166aj(this.f24712a);
            jSONObject.put("0", c7166aj.m34407d());
            jSONObject.put("1", c7166aj.m34412a());
            jSONObject.put("2", c7166aj.m34408c());
            jSONObject.put("3", c7166aj.m34405f());
            jSONObject.put(Constants.VIA_REPORT_TYPE_CHAT_AIO, c7166aj.m34406e());
            int i = 1;
            jSONObject.put("35", C7158ab.m34440b() ? 1 : 0);
            jSONObject.put("36", C7158ab.m34441a(this.f24712a) ? 1 : 0);
            JSONObject m34413a = C7165ai.m34413a(this.f24712a);
            if (m34413a != null) {
                jSONObject.put("4", m34413a);
            }
            m33888a.m33878b(C7262df.f24844ac, 0);
            C7159ac c7159ac = new C7159ac();
            jSONObject.put("7", c7159ac.m34438a() ? 1 : 0);
            boolean m34436a = c7159ac.m34436a(this.f24712a);
            jSONObject.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, m34436a ? 1 : 0);
            if (m34436a) {
                jSONObject.put("61", c7159ac.m34435b(this.f24712a));
            }
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, c7159ac.m34432e(this.f24712a));
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, c7159ac.m34434c(this.f24712a));
            C7161ae c7161ae = new C7161ae();
            jSONObject.put(Constants.VIA_REPORT_TYPE_CHAT_VIDEO, c7161ae.m34426a("cpuinfo") ? 1 : 0);
            jSONObject.put("27", c7161ae.m34426a("meminfo") ? 1 : 0);
            C7171ao c7171ao = new C7171ao();
            jSONObject.put("65", c7171ao.m34349d() ? 1 : 0);
            boolean m34351b = c7171ao.m34351b();
            jSONObject.put("66", m34351b ? 1 : 0);
            if (m34351b) {
                jSONObject.put("67", c7171ao.m34353a() ? 1 : 0);
            }
            jSONObject.put("68", c7171ao.m34347f() ? 1 : 0);
            jSONObject.put("69", c7171ao.m34348e());
            jSONObject.put("101", c7171ao.m34350c() ? 1 : 0);
            jSONObject.put("102", c7171ao.m34346g() ? 1 : 0);
            jSONObject.put("99", new C7162af().m34422a());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("03007", C7207bv.m34127a(this.f24712a));
            jSONObject2.put("03014", C7191bh.m34246g(this.f24712a));
            jSONObject2.put("03020", C7207bv.m34126b(this.f24712a));
            jSONObject2.put("03030", C7190bg.m34274d(this.f24712a));
            jSONObject.put("51", jSONObject2);
            jSONObject.put("107", new C7170an().m34357d());
            if (!C7158ab.m34439b(this.f24712a)) {
                i = 0;
            }
            jSONObject.put("60", i);
            try {
                jSONObject.put("11028", WeaponHI.sKSSdkver);
                jSONObject.put("11301", C7191bh.m34254c(C10758b.m24900Is().mo23999Ir()));
                jSONObject.put("11302", C7191bh.m34254c(C10758b.m24900Is().getSdkVersion()));
                jSONObject.put("11303", C7191bh.m34254c(C10758b.m24900Is().getAppId()));
                jSONObject.put("11002", Engine.soVersion);
            } catch (Throwable unused) {
            }
            return jSONObject;
        } catch (Throwable unused2) {
            return null;
        }
    }
}
