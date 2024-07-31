package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.room.RoomMasterTable;
import com.autonavi.base.p048ae.gmap.glyph.FontStyle;
import com.kuaishou.weapon.p205p0.jni.C7286A;
import com.kuaishou.weapon.p205p0.jni.Engine;
import com.kwad.sdk.p433f.C10758b;
import com.stub.StubApp;
import com.tencent.connect.common.Constants;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.cl */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7228cl {

    /* renamed from: a */
    private Context f24695a;

    /* renamed from: b */
    private int f24696b;

    /* renamed from: c */
    private int f24697c;

    public C7228cl(Context context, int i, int i2) {
        this.f24695a = context;
        this.f24696b = i;
        this.f24697c = i2;
    }

    /* renamed from: a */
    public JSONObject m34084a() {
        String str;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            C7283h m33888a = C7283h.m33888a(this.f24695a, "re_po_rt");
            boolean m33867e = m33888a.m33867e("a1_p_s_p_s");
            boolean m33867e2 = m33888a.m33867e("a1_p_s_p_s_c_b");
            C7166aj c7166aj = new C7166aj(this.f24695a);
            jSONObject.put("0", c7166aj.m34407d());
            jSONObject.put("1", c7166aj.m34412a());
            jSONObject.put("2", c7166aj.m34408c());
            jSONObject.put("3", c7166aj.m34405f());
            jSONObject.put(Constants.VIA_REPORT_TYPE_CHAT_AIO, c7166aj.m34406e());
            jSONObject.put("35", C7158ab.m34440b() ? 1 : 0);
            jSONObject.put("36", C7158ab.m34441a(this.f24695a) ? 1 : 0);
            JSONObject m34413a = C7165ai.m34413a(this.f24695a);
            if (m34413a != null) {
                jSONObject.put("4", m34413a);
            }
            C7325z c7325z = new C7325z();
            JSONArray m33478a = c7325z.m33478a(this.f24695a);
            jSONObject.put("49", m33478a);
            jSONObject.put("146", c7325z.m33474e());
            jSONObject.put("154", c7325z.m33479a());
            jSONObject.put("168", C7266dj.m33955b(m33478a));
            jSONObject.put("169", C7266dj.m33958a(m33478a));
            jSONObject.put("185", c7325z.m33475d());
            jSONObject.put("191", c7325z.m33476c());
            if (c7325z.m33477b() != null) {
                jSONObject.put("161", c7325z.m33477b());
            }
            jSONObject.put(Constants.VIA_REPORT_TYPE_DATALINE, C7158ab.m34442a());
            C7159ac c7159ac = new C7159ac();
            jSONObject.put("7", c7159ac.m34438a() ? 1 : 0);
            boolean m34436a = c7159ac.m34436a(this.f24695a);
            jSONObject.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, m34436a ? 1 : 0);
            if (m34436a) {
                jSONObject.put("61", c7159ac.m34435b(this.f24695a));
            }
            jSONObject.put("181", c7159ac.m34431f(this.f24695a) ? 1 : 0);
            jSONObject.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, c7159ac.m34433d(this.f24695a));
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, c7159ac.m34432e(this.f24695a));
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, c7159ac.m34434c(this.f24695a));
            C7161ae c7161ae = new C7161ae();
            jSONObject.put(Constants.VIA_REPORT_TYPE_CHAT_VIDEO, c7161ae.m34426a("cpuinfo") ? 1 : 0);
            jSONObject.put("27", c7161ae.m34426a("meminfo") ? 1 : 0);
            jSONObject.put(Constants.VIA_ACT_TYPE_TWENTY_EIGHT, c7161ae.m34423b("/proc/cpuinfo") ? 1 : 0);
            jSONObject.put("29", c7161ae.m34423b("/proc/meminfo") ? 1 : 0);
            jSONObject.put("96", c7161ae.m34427a());
            jSONObject.put("134", c7161ae.m34424b());
            C7170an c7170an = new C7170an();
            Set<String> m34360b = c7170an.m34360b();
            Set<String> m34358c = c7170an.m34358c();
            if (m34358c != null) {
                str = "45";
                jSONObject.put("30", 1);
                jSONObject.put("32", new JSONArray((Collection) m34358c));
            } else {
                str = "45";
                jSONObject.put("30", 0);
            }
            if (m34360b != null) {
                jSONObject.put("31", 1);
                jSONObject.put("33", new JSONArray((Collection) m34360b));
            } else {
                jSONObject.put("31", 0);
            }
            Set<String> m34367a = c7170an.m34367a();
            if (m34367a != null) {
                jSONObject.put("34", m34367a);
                if (m34360b != null || m34358c != null) {
                    HashSet hashSet = new HashSet();
                    if (m34360b != null) {
                        hashSet.add(m34360b);
                    }
                    if (m34358c != null) {
                        hashSet.add(m34358c);
                    }
                    jSONObject.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, c7170an.m34366a(this.f24695a, 13, hashSet));
                    jSONObject.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, c7170an.m34366a(this.f24695a, 14, hashSet));
                    jSONObject.put(Constants.VIA_REPORT_TYPE_WPA_STATE, c7170an.m34366a(this.f24695a, 15, hashSet));
                    jSONObject.put(Constants.VIA_REPORT_TYPE_START_WAP, c7170an.m34366a(this.f24695a, 16, hashSet));
                    jSONObject.put(Constants.VIA_REPORT_TYPE_START_GROUP, c7170an.m34366a(this.f24695a, 17, hashSet));
                    jSONObject.put("18", c7170an.m34366a(this.f24695a, 18, hashSet));
                    jSONObject.put(Constants.VIA_ACT_TYPE_NINETEEN, c7170an.m34366a(this.f24695a, 19, hashSet));
                    jSONObject.put("20", c7170an.m34366a(this.f24695a, 20, hashSet));
                    jSONObject.put("21", c7170an.m34366a(this.f24695a, 21, hashSet));
                    jSONObject.put("130", c7170an.m34359b(hashSet));
                }
            }
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
            jSONObject.put("103", new C7160ad().m34430a() ? 1 : 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("03007", C7207bv.m34127a(this.f24695a));
            jSONObject2.put("03014", C7191bh.m34246g(this.f24695a));
            jSONObject2.put("03020", C7207bv.m34126b(this.f24695a));
            jSONObject2.put("03030", C7190bg.m34274d(this.f24695a));
            jSONObject.put("51", jSONObject2);
            C7170an c7170an2 = new C7170an();
            jSONObject.put("107", c7170an2.m34357d());
            jSONObject.put("155", c7170an2.m34356e());
            jSONObject.put("170", c7170an2.m34354g());
            jSONObject.put("190", c7170an2.m34355f());
            C7164ah c7164ah = new C7164ah();
            jSONObject.put("131", c7164ah.m34420a());
            jSONObject.put("145", c7164ah.m34419a(this.f24695a));
            jSONObject.put("132", C7267dk.m33954a());
            jSONObject.put("133", new C7166aj(this.f24695a).m34404g());
            if (m33888a.m33878b(C7262df.f24855an, 1) == 1) {
                jSONObject.put("139", C7268dl.m33945c(this.f24695a));
                jSONObject.put("140", C7268dl.m33944d(this.f24695a));
                jSONObject.put("147", C7268dl.m33952a());
                jSONObject.put("148", C7265di.m33963b());
                jSONObject.put("149", C7265di.m33961c());
                jSONObject.put("151", C7267dk.m33953b());
            }
            if (m33888a.m33878b(C7262df.f24844ac, 0) == 1) {
                jSONObject.put("128", C7160ad.m34428b() ? 1 : 0);
            }
            if (Engine.loadSuccess) {
                C7175as c7175as = new C7175as(this.f24695a, 100);
                jSONObject.put("6", c7175as.m34338a("6"));
                JSONArray m33973a = c7175as.m33973a(c7175as.m34340a(), "41");
                if (m33973a != null && m33973a.length() > 0) {
                    JSONArray m33971c = c7175as.m33971c(c7175as.m34340a(), "41");
                    JSONArray m33972b = c7175as.m33972b(c7175as.m34340a(), "41");
                    jSONObject.put(RoomMasterTable.DEFAULT_ID, m33971c);
                    jSONObject.put("43", m33972b);
                    jSONObject.put("41", c7175as.m33974a(c7175as.m33974a(m33973a, m33971c), m33972b));
                }
                jSONObject.put("47", c7175as.m34338a("47"));
                jSONObject.put("48", c7175as.m34338a("48"));
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, c7175as.m34338a(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR));
                jSONObject.put("37", c7175as.m34338a("37"));
                jSONObject.put("38", c7175as.m34338a("38"));
                jSONObject.put("40", c7175as.m34337b("40"));
                String str2 = str;
                jSONObject.put(str2, c7175as.m34337b(str2));
                jSONObject.put("46", c7175as.m34334e("46"));
                jSONObject.put("91", c7175as.m34338a("91"));
                jSONObject.put("62", c7175as.m34336c("62"));
                jSONObject.put("63", c7175as.m34336c("63"));
                jSONObject.put("64", c7175as.m34336c("64"));
                jSONObject.put("85", c7175as.m34335d("85"));
                jSONObject.put("50", c7175as.m34338a("50"));
                jSONObject.put("70", c7175as.m34336c("70"));
                jSONObject.put("39", c7175as.m34338a("39"));
                jSONObject.put("52", c7175as.m34338a("52"));
                jSONObject.put("53", c7175as.m34338a("53"));
                jSONObject.put("54", c7175as.m34338a("54"));
                jSONObject.put("55", c7175as.m34338a("55"));
                jSONObject.put("73", c7175as.m34338a("73"));
                jSONObject.put("74", c7175as.m34338a("74"));
                jSONObject.put("104", c7175as.m34338a("104"));
                if (m33888a.m33878b(C7262df.f24812X, 1) == 1 && Build.VERSION.SDK_INT < 23) {
                    C7174ar c7174ar = new C7174ar(this.f24695a);
                    String m34341a = c7174ar.m34341a("57");
                    if (!TextUtils.isEmpty(m34341a)) {
                        jSONObject.put("57", m34341a);
                        jSONObject.put("56", c7174ar.m34341a("56"));
                    }
                }
                jSONObject.put("77", c7175as.m34338a("77"));
                jSONObject.put("78", c7175as.m34338a("78"));
                jSONObject.put("79", c7175as.m34338a("79"));
                jSONObject.put("84", c7175as.m34338a("84"));
                jSONObject.put("80", c7175as.m34338a("80"));
                jSONObject.put("81", c7175as.m34338a("81"));
                jSONObject.put("82", c7175as.m34338a("82"));
                jSONObject.put("83", c7175as.m34338a("83"));
                jSONObject.put("87", c7175as.m34338a("87"));
                jSONObject.put("89", c7175as.m34338a("89"));
                jSONObject.put("90", c7175as.m34335d("90"));
                jSONObject.put("75", c7175as.m34338a("75"));
                jSONObject.put("88", c7175as.m34338a("88"));
                jSONObject.put("92", c7175as.m34338a("92"));
                jSONObject.put("93", c7175as.m34338a("93"));
                jSONObject.put("94", c7175as.m34338a("94"));
                jSONObject.put("95", c7175as.m34338a("95"));
                jSONObject.put("98", c7175as.m34338a("98"));
                jSONObject.put("100", c7175as.m34338a("100"));
                jSONObject.put("105", c7175as.m34338a("105"));
                if (m33888a.m33878b(C7262df.f24814Z, 1) == 1) {
                    C7173aq c7173aq = new C7173aq(this.f24695a, 0);
                    jSONObject.put("108", c7173aq.m34343a("108"));
                    jSONObject.put("109", c7173aq.m34343a("109"));
                    jSONObject.put("111", c7173aq.m34343a("111"));
                }
                if (m33888a.m33878b(C7262df.f24843ab, 1) == 1) {
                    C7173aq c7173aq2 = new C7173aq(this.f24695a, 1);
                    jSONObject.put("112", c7173aq2.m34342b("112"));
                    jSONObject.put("113", c7173aq2.m34343a("113"));
                    jSONObject.put("114", c7173aq2.m34343a("114"));
                    jSONObject.put("115", c7173aq2.m34343a("115"));
                    jSONObject.put("116", c7173aq2.m34343a("116"));
                    jSONObject.put("117", c7173aq2.m34343a("117"));
                    jSONObject.put("120", c7173aq2.m34343a("120"));
                    C7173aq c7173aq3 = new C7173aq(this.f24695a, 4);
                    jSONObject.put("124", c7173aq3.m34343a("124"));
                    jSONObject.put("125", c7173aq3.m34343a("125"));
                    jSONObject.put("126", c7173aq3.m34343a("126"));
                    jSONObject.put("127", c7173aq3.m34343a("127"));
                }
                if (m33888a.m33878b(C7262df.f24851aj, 0) == 1) {
                    C7178av c7178av = new C7178av(this.f24695a, 100);
                    jSONObject.put("97", c7178av.m34322a("97"));
                    jSONObject.put("118", c7178av.m34322a("118"));
                    jSONObject.put("119", c7178av.m34322a("119"));
                    jSONObject.put("135", c7178av.m34322a("135"));
                    jSONObject.put("174", c7178av.m34322a("174"));
                    C7178av c7178av2 = new C7178av(this.f24695a, 200);
                    jSONObject.put("173", c7178av2.m34322a("173"));
                    jSONObject.put("182", c7178av2.m34322a("182"));
                }
                if (m33888a.m33878b(C7262df.f24813Y, 1) == 1) {
                    jSONObject.put("129", new C7188be(this.f24695a, 4).m34286a("129"));
                    C7188be c7188be = new C7188be(this.f24695a, 1);
                    jSONObject.put("121", c7188be.m33973a(c7188be.m34287a(), "121"));
                    C7188be c7188be2 = new C7188be(this.f24695a, 2);
                    jSONObject.put("137", c7188be2.m34286a("137"));
                    jSONObject.put("138", c7188be2.m34286a("138"));
                    jSONObject.put("141", c7188be2.m34286a("141"));
                    jSONObject.put("142", c7188be2.m34286a("142"));
                    C7189bf c7189bf = new C7189bf(this.f24695a, 3);
                    JSONArray m34280b = c7189bf.m34280b("150");
                    jSONObject.put("150", m34280b);
                    if (m34280b != null) {
                        jSONObject.put("188", c7189bf.m34281a(m34280b));
                    }
                }
                if (m33888a.m33878b(C7262df.f24809U, 1) == 1) {
                    C7184ba c7184ba = new C7184ba(this.f24695a, 100);
                    jSONObject.put("152", c7184ba.m34303a("152"));
                    jSONObject.put("153", c7184ba.m34303a("153"));
                    jSONObject.put("156", c7184ba.m34303a("156"));
                    jSONObject.put("157", c7184ba.m34303a("157"));
                    jSONObject.put("163", c7184ba.m34303a("163"));
                    jSONObject.put("171", c7184ba.m34302a("171", true));
                    jSONObject.put("172", c7184ba.m34298b("172"));
                    jSONObject.put("177", new C7184ba(this.f24695a, 500).m34296d("177"));
                }
                if ((m33867e || m33867e2) && m33888a.m33878b(C7262df.f24811W, 0) == 1) {
                    jSONObject.put("158", new C7184ba(this.f24695a, 300).m34298b("158"));
                }
                if (m33888a.m33878b(C7262df.f24854am, 0) == 1) {
                    C7187bd c7187bd = new C7187bd(this.f24695a);
                    jSONObject.put("162", c7187bd.m34290a("162"));
                    jSONObject.put("160", c7187bd.m33973a(c7187bd.m34291a(), "160"));
                    C7184ba c7184ba2 = new C7184ba(this.f24695a, FontStyle.WEIGHT_NORMAL);
                    jSONObject.put("164", c7184ba2.m34303a("164"));
                    jSONObject.put("165", c7184ba2.m34303a("165"));
                    jSONObject.put("166", c7184ba2.m34297c("166"));
                    jSONObject.put("167", c7184ba2.m34303a("167"));
                }
                if (m33888a.m33878b(C7262df.f24852ak, 1) == 1) {
                    C7181ay c7181ay = new C7181ay(this.f24695a, 600);
                    jSONObject.put("179", c7181ay.m34310a("179"));
                    jSONObject.put("186", c7181ay.m34310a("186"));
                    jSONObject.put("189", c7181ay.m34310a("189"));
                }
            }
            jSONObject.put("60", C7158ab.m34439b(this.f24695a) ? 1 : 0);
            jSONObject.put("11000", Engine.loadSuccess ? 1 : 0);
            jSONObject.put("11002", Engine.soVersion);
            jSONObject.put("11008", m33888a.m33876b(C7262df.f24895g, C7202bq.f24602e));
            jSONObject.put("11009", C7204bs.m34142a(StubApp.getOrigApplicationContext(this.f24695a.getApplicationContext())));
            try {
                jSONObject.put("11301", C7191bh.m34254c(C10758b.m24900Is().mo23999Ir()));
                jSONObject.put("11302", C7191bh.m34254c(C10758b.m24900Is().getSdkVersion()));
                jSONObject.put("11303", C7191bh.m34254c(C10758b.m24900Is().getAppId()));
            } catch (Throwable unused) {
            }
            String m33875b = m33888a.m33875b(C7262df.f24901m, "", true);
            if (!TextUtils.isEmpty(m33875b)) {
                jSONObject.put("183", m33875b);
                m33888a.m33871c(C7262df.f24901m, "");
            }
            jSONObject.put("187", C7168al.m34377a(this.f24695a) ? 1 : 0);
            int m34374c = C7168al.m34374c();
            if (m34374c > 0) {
                jSONObject.put("212", m34374c);
            }
            jSONObject.put("11006", m33867e ? 1 : 0);
            jSONObject.put("11029", m33867e2 ? 1 : 0);
            jSONObject.put("11028", WeaponHI.sKSSdkver);
            jSONObject.put("20000", this.f24696b);
            jSONObject.put("20001", this.f24697c);
            try {
                jSONObject.put("02078", C7286A.getE("W_S_V"));
                jSONObject.put("02079", C7286A.getE("W_S_S_V"));
            } catch (Throwable unused2) {
            }
            jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
            jSONObject.put("11017", jSONObject.toString().length());
            return jSONObject;
        } catch (Throwable unused3) {
            return null;
        }
    }

    /* renamed from: a */
    public String m34083a(String str) {
        JSONObject m34084a;
        try {
            JSONObject m34081a = new C7229cm(str, C7227ck.f24680l).m34081a(this.f24695a);
            if (m34081a == null || (m34084a = m34084a()) == null) {
                return null;
            }
            m34081a.put("module_section", m34084a);
            return m34081a.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
