package com.qq.e.comm.plugin.e;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class d implements com.qq.e.comm.plugin.e.l.c {
    @Override // com.qq.e.comm.plugin.e.l.c
    public String a(c cVar, int i4) {
        JSONObject jSONObject = new JSONObject();
        int i5 = i4 & 2;
        if (i5 > 0) {
            try {
                jSONObject.putOpt("g", String.valueOf(cVar.f42657a));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        if (i5 > 0) {
            jSONObject.putOpt("sc", String.valueOf(cVar.f42659b));
        }
        if (i5 > 0) {
            jSONObject.putOpt("ec", String.valueOf(cVar.f42661c));
        }
        if (i5 > 0) {
            jSONObject.putOpt("aa", String.valueOf(cVar.f42663d));
        }
        if (i5 > 0) {
            jSONObject.putOpt("ab", String.valueOf(cVar.f42665e));
        }
        if (i5 > 0) {
            jSONObject.putOpt("ba", String.valueOf(cVar.f42667f));
        }
        if (i5 > 0) {
            jSONObject.putOpt("bb", String.valueOf(cVar.f42669g));
        }
        if (i5 > 0) {
            jSONObject.putOpt("d", String.valueOf(cVar.f42671h));
        }
        if (i5 > 0) {
            jSONObject.putOpt("p", String.valueOf(cVar.f42673i));
        }
        if (i5 > 0) {
            jSONObject.putOpt("f", String.valueOf(cVar.f42675j));
        }
        int i6 = i4 & 3;
        if (i6 > 0) {
            jSONObject.putOpt("da", String.valueOf(cVar.f42677k));
        }
        if (i6 > 0) {
            jSONObject.putOpt("db", String.valueOf(cVar.f42679l));
        }
        if (i6 > 0) {
            jSONObject.putOpt("dx", String.valueOf(cVar.f42681m));
        }
        if (i6 > 0) {
            jSONObject.putOpt("dy", String.valueOf(cVar.f42683n));
        }
        if (i6 > 0) {
            jSONObject.putOpt("ra", String.valueOf(cVar.f42685o));
        }
        if (i6 > 0) {
            jSONObject.putOpt("rb", String.valueOf(cVar.f42687p));
        }
        if (i5 > 0) {
            jSONObject.putOpt("tp", String.valueOf(cVar.f42689q));
        }
        if (i5 > 0) {
            jSONObject.putOpt("ts", String.valueOf(cVar.f42691r));
        }
        if (i6 > 0) {
            jSONObject.putOpt("vs", String.valueOf(cVar.f42693s));
        }
        if (i6 > 0) {
            jSONObject.putOpt("dpn", String.valueOf(cVar.f42695t));
        }
        if (i6 > 0) {
            jSONObject.putOpt("cr", String.valueOf(cVar.f42697u));
        }
        if (i6 > 0) {
            jSONObject.putOpt("rt", String.valueOf(cVar.f42699v));
        }
        int i7 = i4 & 7;
        if (i7 > 0) {
            jSONObject.putOpt("pw", String.valueOf(cVar.f42701w));
        }
        if (i7 > 0) {
            jSONObject.putOpt("ph", String.valueOf(cVar.f42703x));
        }
        if (i7 > 0) {
            jSONObject.putOpt("fg", String.valueOf(cVar.f42705y));
        }
        if (i7 > 0) {
            jSONObject.putOpt("co", String.valueOf(cVar.f42707z));
        }
        if (i7 > 0) {
            jSONObject.putOpt("sl", String.valueOf(cVar.A));
        }
        if (i7 > 0) {
            jSONObject.putOpt("xi", String.valueOf(cVar.B));
        }
        if (i7 > 0) {
            jSONObject.putOpt("ic", String.valueOf(cVar.C));
        }
        if (i7 > 0) {
            jSONObject.putOpt("uc", String.valueOf(cVar.D));
        }
        if (i7 > 0) {
            jSONObject.putOpt("id", String.valueOf(cVar.E));
        }
        if (i7 > 0) {
            jSONObject.putOpt("sp", String.valueOf(cVar.F));
        }
        if (i7 > 0) {
            jSONObject.putOpt("pk", String.valueOf(cVar.G));
        }
        if (i7 > 0) {
            jSONObject.putOpt("si", String.valueOf(cVar.H));
        }
        if (i6 > 0) {
            jSONObject.putOpt("ch", String.valueOf(cVar.I));
        }
        if (i7 > 0) {
            jSONObject.putOpt("as", String.valueOf(cVar.J));
        }
        if (i7 > 0) {
            jSONObject.putOpt("cpk", String.valueOf(cVar.K));
        }
        if (i7 > 0) {
            jSONObject.putOpt("csi", String.valueOf(cVar.f42656L));
        }
        if (i7 > 0) {
            jSONObject.putOpt("cas", String.valueOf(cVar.M));
        }
        if (i6 > 0) {
            jSONObject.putOpt("xo", String.valueOf(cVar.N));
        }
        if (i6 > 0) {
            jSONObject.putOpt("yo", String.valueOf(cVar.O));
        }
        if (i5 > 0) {
            jSONObject.putOpt("dp", String.valueOf(cVar.P));
        }
        if (i6 > 0) {
            jSONObject.putOpt("imei", String.valueOf(cVar.Q));
        }
        if (i7 > 0) {
            jSONObject.putOpt("td", String.valueOf(cVar.R));
        }
        if (i7 > 0) {
            jSONObject.putOpt("od", String.valueOf(cVar.S));
        }
        int i8 = i4 & 4;
        if (i8 > 0) {
            jSONObject.putOpt("br", String.valueOf(cVar.T));
        }
        if (i8 > 0) {
            jSONObject.putOpt("mf", String.valueOf(cVar.U));
        }
        if (i8 > 0) {
            jSONObject.putOpt("hw", String.valueOf(cVar.V));
        }
        if (i6 > 0) {
            jSONObject.putOpt("tid", String.valueOf(cVar.W));
        }
        if (i5 > 0) {
            jSONObject.putOpt("tv", String.valueOf(cVar.X));
        }
        if (i5 > 0) {
            jSONObject.putOpt("click_area", String.valueOf(cVar.Y));
        }
        if (i5 > 0) {
            jSONObject.putOpt("compo", String.valueOf(cVar.Z));
        }
        if (i5 > 0) {
            jSONObject.putOpt("csf", String.valueOf(cVar.f42658a0));
        }
        if (i6 > 0) {
            jSONObject.putOpt("sz", String.valueOf(cVar.f42660b0));
        }
        if (i6 > 0) {
            jSONObject.putOpt("vp", String.valueOf(cVar.f42662c0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("x", String.valueOf(cVar.f42664d0));
        }
        if (i6 > 0) {
            jSONObject.putOpt("sg", String.valueOf(cVar.f42666e0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("sld", String.valueOf(cVar.f42668f0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("am", String.valueOf(cVar.f42670g0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("nx", String.valueOf(cVar.f42672h0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("ny", String.valueOf(cVar.f42674i0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("nz", String.valueOf(cVar.f42676j0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("nt", String.valueOf(cVar.f42678k0));
        }
        if (i6 > 0) {
            jSONObject.putOpt("ca", String.valueOf(cVar.f42680l0));
        }
        if (i6 > 0) {
            jSONObject.putOpt("rwd", String.valueOf(cVar.f42682m0));
        }
        if (i7 > 0) {
            jSONObject.putOpt("media_ext", String.valueOf(cVar.f42684n0));
        }
        if (i7 > 0) {
            jSONObject.putOpt("bfn", String.valueOf(cVar.f42686o0));
        }
        if (i7 > 0) {
            jSONObject.putOpt("bfon", String.valueOf(cVar.f42688p0));
        }
        if (i7 > 0) {
            jSONObject.putOpt("sm", String.valueOf(cVar.f42690q0));
        }
        if (i7 > 0) {
            jSONObject.putOpt("in", String.valueOf(cVar.f42692r0));
        }
        if (i7 > 0) {
            jSONObject.putOpt("pcs", String.valueOf(cVar.f42694s0));
        }
        if (i6 > 0) {
            jSONObject.putOpt("se", String.valueOf(cVar.f42696t0));
        }
        if (i7 > 0) {
            jSONObject.putOpt(CampaignUnit.JSON_KEY_DO, String.valueOf(cVar.f42698u0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("ac", String.valueOf(cVar.f42700v0));
        }
        if (i7 > 0) {
            jSONObject.putOpt("ot", String.valueOf(cVar.f42702w0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("dsf", String.valueOf(cVar.f42704x0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("raa", String.valueOf(cVar.f42706y0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("rab", String.valueOf(cVar.f42708z0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("dscn", String.valueOf(cVar.A0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("usf", String.valueOf(cVar.B0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("rba", String.valueOf(cVar.C0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("rbb", String.valueOf(cVar.D0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("uscn", String.valueOf(cVar.E0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("fc", String.valueOf(cVar.F0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("fcc", String.valueOf(cVar.G0));
        }
        if (i6 > 0) {
            jSONObject.putOpt("inex", String.valueOf(cVar.H0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("cvi", String.valueOf(cVar.I0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("uit", String.valueOf(cVar.J0));
        }
        if (i5 > 0) {
            jSONObject.putOpt("cghcl", String.valueOf(cVar.K0));
        }
        if (i7 > 0) {
            jSONObject.putOpt("expid", String.valueOf(cVar.L0));
        }
        if (i7 > 0) {
            jSONObject.putOpt("expvalue", String.valueOf(cVar.M0));
        }
        if (i6 > 0) {
            jSONObject.putOpt("tc", String.valueOf(cVar.N0));
        }
        if (i6 > 0) {
            jSONObject.putOpt("ir", String.valueOf(cVar.O0));
        }
        if (i6 > 0) {
            jSONObject.putOpt("rpt", String.valueOf(cVar.P0));
        }
        return jSONObject.toString();
    }

    @Override // com.qq.e.comm.plugin.e.l.c
    public void a(String str, c cVar, List<String> list) {
        if (str == null || cVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("g");
            if (!TextUtils.isEmpty(optString) && !list.contains("g")) {
                cVar.f42657a = optString;
            }
            String optString2 = jSONObject.optString("sc");
            if (!TextUtils.isEmpty(optString2) && !list.contains("sc")) {
                cVar.f42659b = optString2;
            }
            String optString3 = jSONObject.optString("ec");
            if (!TextUtils.isEmpty(optString3) && !list.contains("ec")) {
                cVar.f42661c = optString3;
            }
            String optString4 = jSONObject.optString("aa");
            if (!TextUtils.isEmpty(optString4) && !list.contains("aa")) {
                cVar.f42663d = optString4;
            }
            String optString5 = jSONObject.optString("ab");
            if (!TextUtils.isEmpty(optString5) && !list.contains("ab")) {
                cVar.f42665e = optString5;
            }
            String optString6 = jSONObject.optString("ba");
            if (!TextUtils.isEmpty(optString6) && !list.contains("ba")) {
                cVar.f42667f = optString6;
            }
            String optString7 = jSONObject.optString("bb");
            if (!TextUtils.isEmpty(optString7) && !list.contains("bb")) {
                cVar.f42669g = optString7;
            }
            String optString8 = jSONObject.optString("d");
            if (!TextUtils.isEmpty(optString8) && !list.contains("d")) {
                cVar.f42671h = optString8;
            }
            String optString9 = jSONObject.optString("p");
            if (!TextUtils.isEmpty(optString9) && !list.contains("p")) {
                cVar.f42673i = optString9;
            }
            String optString10 = jSONObject.optString("f");
            if (!TextUtils.isEmpty(optString10) && !list.contains("f")) {
                cVar.f42675j = optString10;
            }
            String optString11 = jSONObject.optString("da");
            if (!TextUtils.isEmpty(optString11) && !list.contains("da")) {
                cVar.f42677k = optString11;
            }
            String optString12 = jSONObject.optString("db");
            if (!TextUtils.isEmpty(optString12) && !list.contains("db")) {
                cVar.f42679l = optString12;
            }
            String optString13 = jSONObject.optString("dx");
            if (!TextUtils.isEmpty(optString13) && !list.contains("dx")) {
                cVar.f42681m = optString13;
            }
            String optString14 = jSONObject.optString("dy");
            if (!TextUtils.isEmpty(optString14) && !list.contains("dy")) {
                cVar.f42683n = optString14;
            }
            String optString15 = jSONObject.optString("ra");
            if (!TextUtils.isEmpty(optString15) && !list.contains("ra")) {
                cVar.f42685o = optString15;
            }
            String optString16 = jSONObject.optString("rb");
            if (!TextUtils.isEmpty(optString16) && !list.contains("rb")) {
                cVar.f42687p = optString16;
            }
            String optString17 = jSONObject.optString("tp");
            if (!TextUtils.isEmpty(optString17) && !list.contains("tp")) {
                cVar.f42689q = optString17;
            }
            String optString18 = jSONObject.optString("ts");
            if (!TextUtils.isEmpty(optString18) && !list.contains("ts")) {
                cVar.f42691r = optString18;
            }
            String optString19 = jSONObject.optString("vs");
            if (!TextUtils.isEmpty(optString19) && !list.contains("vs")) {
                cVar.f42693s = optString19;
            }
            String optString20 = jSONObject.optString("dpn");
            if (!TextUtils.isEmpty(optString20) && !list.contains("dpn")) {
                cVar.f42695t = optString20;
            }
            String optString21 = jSONObject.optString("cr");
            if (!TextUtils.isEmpty(optString21) && !list.contains("cr")) {
                cVar.f42697u = optString21;
            }
            String optString22 = jSONObject.optString("rt");
            if (!TextUtils.isEmpty(optString22) && !list.contains("rt")) {
                cVar.f42699v = optString22;
            }
            String optString23 = jSONObject.optString("pw");
            if (!TextUtils.isEmpty(optString23) && !list.contains("pw")) {
                cVar.f42701w = optString23;
            }
            String optString24 = jSONObject.optString("ph");
            if (!TextUtils.isEmpty(optString24) && !list.contains("ph")) {
                cVar.f42703x = optString24;
            }
            String optString25 = jSONObject.optString("fg");
            if (!TextUtils.isEmpty(optString25) && !list.contains("fg")) {
                cVar.f42705y = optString25;
            }
            String optString26 = jSONObject.optString("co");
            if (!TextUtils.isEmpty(optString26) && !list.contains("co")) {
                cVar.f42707z = optString26;
            }
            String optString27 = jSONObject.optString("sl");
            if (!TextUtils.isEmpty(optString27) && !list.contains("sl")) {
                cVar.A = optString27;
            }
            String optString28 = jSONObject.optString("xi");
            if (!TextUtils.isEmpty(optString28) && !list.contains("xi")) {
                cVar.B = optString28;
            }
            String optString29 = jSONObject.optString("ic");
            if (!TextUtils.isEmpty(optString29) && !list.contains("ic")) {
                cVar.C = optString29;
            }
            String optString30 = jSONObject.optString("uc");
            if (!TextUtils.isEmpty(optString30) && !list.contains("uc")) {
                cVar.D = optString30;
            }
            String optString31 = jSONObject.optString("id");
            if (!TextUtils.isEmpty(optString31) && !list.contains("id")) {
                cVar.E = optString31;
            }
            String optString32 = jSONObject.optString("sp");
            if (!TextUtils.isEmpty(optString32) && !list.contains("sp")) {
                cVar.F = optString32;
            }
            String optString33 = jSONObject.optString("pk");
            if (!TextUtils.isEmpty(optString33) && !list.contains("pk")) {
                cVar.G = optString33;
            }
            String optString34 = jSONObject.optString("si");
            if (!TextUtils.isEmpty(optString34) && !list.contains("si")) {
                cVar.H = optString34;
            }
            String optString35 = jSONObject.optString("ch");
            if (!TextUtils.isEmpty(optString35) && !list.contains("ch")) {
                cVar.I = optString35;
            }
            String optString36 = jSONObject.optString("as");
            if (!TextUtils.isEmpty(optString36) && !list.contains("as")) {
                cVar.J = optString36;
            }
            String optString37 = jSONObject.optString("cpk");
            if (!TextUtils.isEmpty(optString37) && !list.contains("cpk")) {
                cVar.K = optString37;
            }
            String optString38 = jSONObject.optString("csi");
            if (!TextUtils.isEmpty(optString38) && !list.contains("csi")) {
                cVar.f42656L = optString38;
            }
            String optString39 = jSONObject.optString("cas");
            if (!TextUtils.isEmpty(optString39) && !list.contains("cas")) {
                cVar.M = optString39;
            }
            String optString40 = jSONObject.optString("xo");
            if (!TextUtils.isEmpty(optString40) && !list.contains("xo")) {
                cVar.N = optString40;
            }
            String optString41 = jSONObject.optString("yo");
            if (!TextUtils.isEmpty(optString41) && !list.contains("yo")) {
                cVar.O = optString41;
            }
            String optString42 = jSONObject.optString("dp");
            if (!TextUtils.isEmpty(optString42) && !list.contains("dp")) {
                cVar.P = optString42;
            }
            String optString43 = jSONObject.optString("imei");
            if (!TextUtils.isEmpty(optString43) && !list.contains("imei")) {
                cVar.Q = optString43;
            }
            String optString44 = jSONObject.optString("td");
            if (!TextUtils.isEmpty(optString44) && !list.contains("td")) {
                cVar.R = optString44;
            }
            String optString45 = jSONObject.optString("od");
            if (!TextUtils.isEmpty(optString45) && !list.contains("od")) {
                cVar.S = optString45;
            }
            String optString46 = jSONObject.optString("br");
            if (!TextUtils.isEmpty(optString46) && !list.contains("br")) {
                cVar.T = optString46;
            }
            String optString47 = jSONObject.optString("mf");
            if (!TextUtils.isEmpty(optString47) && !list.contains("mf")) {
                cVar.U = optString47;
            }
            String optString48 = jSONObject.optString("hw");
            if (!TextUtils.isEmpty(optString48) && !list.contains("hw")) {
                cVar.V = optString48;
            }
            String optString49 = jSONObject.optString("tid");
            if (!TextUtils.isEmpty(optString49) && !list.contains("tid")) {
                cVar.W = optString49;
            }
            String optString50 = jSONObject.optString("tv");
            if (!TextUtils.isEmpty(optString50) && !list.contains("tv")) {
                cVar.X = optString50;
            }
            String optString51 = jSONObject.optString("click_area");
            if (!TextUtils.isEmpty(optString51) && !list.contains("click_area")) {
                cVar.Y = optString51;
            }
            String optString52 = jSONObject.optString("compo");
            if (!TextUtils.isEmpty(optString52) && !list.contains("compo")) {
                cVar.Z = optString52;
            }
            String optString53 = jSONObject.optString("csf");
            if (!TextUtils.isEmpty(optString53) && !list.contains("csf")) {
                cVar.f42658a0 = optString53;
            }
            String optString54 = jSONObject.optString("sz");
            if (!TextUtils.isEmpty(optString54) && !list.contains("sz")) {
                cVar.f42660b0 = optString54;
            }
            String optString55 = jSONObject.optString("vp");
            if (!TextUtils.isEmpty(optString55) && !list.contains("vp")) {
                cVar.f42662c0 = optString55;
            }
            String optString56 = jSONObject.optString("x");
            if (!TextUtils.isEmpty(optString56) && !list.contains("x")) {
                cVar.f42664d0 = optString56;
            }
            String optString57 = jSONObject.optString("sg");
            if (!TextUtils.isEmpty(optString57) && !list.contains("sg")) {
                cVar.f42666e0 = optString57;
            }
            String optString58 = jSONObject.optString("sld");
            if (!TextUtils.isEmpty(optString58) && !list.contains("sld")) {
                cVar.f42668f0 = optString58;
            }
            String optString59 = jSONObject.optString("am");
            if (!TextUtils.isEmpty(optString59) && !list.contains("am")) {
                cVar.f42670g0 = optString59;
            }
            String optString60 = jSONObject.optString("nx");
            if (!TextUtils.isEmpty(optString60) && !list.contains("nx")) {
                cVar.f42672h0 = optString60;
            }
            String optString61 = jSONObject.optString("ny");
            if (!TextUtils.isEmpty(optString61) && !list.contains("ny")) {
                cVar.f42674i0 = optString61;
            }
            String optString62 = jSONObject.optString("nz");
            if (!TextUtils.isEmpty(optString62) && !list.contains("nz")) {
                cVar.f42676j0 = optString62;
            }
            String optString63 = jSONObject.optString("nt");
            if (!TextUtils.isEmpty(optString63) && !list.contains("nt")) {
                cVar.f42678k0 = optString63;
            }
            String optString64 = jSONObject.optString("ca");
            if (!TextUtils.isEmpty(optString64) && !list.contains("ca")) {
                cVar.f42680l0 = optString64;
            }
            String optString65 = jSONObject.optString("rwd");
            if (!TextUtils.isEmpty(optString65) && !list.contains("rwd")) {
                cVar.f42682m0 = optString65;
            }
            String optString66 = jSONObject.optString("media_ext");
            if (!TextUtils.isEmpty(optString66) && !list.contains("media_ext")) {
                cVar.f42684n0 = optString66;
            }
            String optString67 = jSONObject.optString("bfn");
            if (!TextUtils.isEmpty(optString67) && !list.contains("bfn")) {
                cVar.f42686o0 = optString67;
            }
            String optString68 = jSONObject.optString("bfon");
            if (!TextUtils.isEmpty(optString68) && !list.contains("bfon")) {
                cVar.f42688p0 = optString68;
            }
            String optString69 = jSONObject.optString("sm");
            if (!TextUtils.isEmpty(optString69) && !list.contains("sm")) {
                cVar.f42690q0 = optString69;
            }
            String optString70 = jSONObject.optString("in");
            if (!TextUtils.isEmpty(optString70) && !list.contains("in")) {
                cVar.f42692r0 = optString70;
            }
            String optString71 = jSONObject.optString("pcs");
            if (!TextUtils.isEmpty(optString71) && !list.contains("pcs")) {
                cVar.f42694s0 = optString71;
            }
            String optString72 = jSONObject.optString("se");
            if (!TextUtils.isEmpty(optString72) && !list.contains("se")) {
                cVar.f42696t0 = optString72;
            }
            String optString73 = jSONObject.optString("_do");
            if (!TextUtils.isEmpty(optString73) && !list.contains("_do")) {
                cVar.f42698u0 = optString73;
            }
            String optString74 = jSONObject.optString("ac");
            if (!TextUtils.isEmpty(optString74) && !list.contains("ac")) {
                cVar.f42700v0 = optString74;
            }
            String optString75 = jSONObject.optString("ot");
            if (!TextUtils.isEmpty(optString75) && !list.contains("ot")) {
                cVar.f42702w0 = optString75;
            }
            String optString76 = jSONObject.optString("dsf");
            if (!TextUtils.isEmpty(optString76) && !list.contains("dsf")) {
                cVar.f42704x0 = optString76;
            }
            String optString77 = jSONObject.optString("raa");
            if (!TextUtils.isEmpty(optString77) && !list.contains("raa")) {
                cVar.f42706y0 = optString77;
            }
            String optString78 = jSONObject.optString("rab");
            if (!TextUtils.isEmpty(optString78) && !list.contains("rab")) {
                cVar.f42708z0 = optString78;
            }
            String optString79 = jSONObject.optString("dscn");
            if (!TextUtils.isEmpty(optString79) && !list.contains("dscn")) {
                cVar.A0 = optString79;
            }
            String optString80 = jSONObject.optString("usf");
            if (!TextUtils.isEmpty(optString80) && !list.contains("usf")) {
                cVar.B0 = optString80;
            }
            String optString81 = jSONObject.optString("rba");
            if (!TextUtils.isEmpty(optString81) && !list.contains("rba")) {
                cVar.C0 = optString81;
            }
            String optString82 = jSONObject.optString("rbb");
            if (!TextUtils.isEmpty(optString82) && !list.contains("rbb")) {
                cVar.D0 = optString82;
            }
            String optString83 = jSONObject.optString("uscn");
            if (!TextUtils.isEmpty(optString83) && !list.contains("uscn")) {
                cVar.E0 = optString83;
            }
            String optString84 = jSONObject.optString("fc");
            if (!TextUtils.isEmpty(optString84) && !list.contains("fc")) {
                cVar.F0 = optString84;
            }
            String optString85 = jSONObject.optString("fcc");
            if (!TextUtils.isEmpty(optString85) && !list.contains("fcc")) {
                cVar.G0 = optString85;
            }
            String optString86 = jSONObject.optString("inex");
            if (!TextUtils.isEmpty(optString86) && !list.contains("inex")) {
                cVar.H0 = optString86;
            }
            String optString87 = jSONObject.optString("cvi");
            if (!TextUtils.isEmpty(optString87) && !list.contains("cvi")) {
                cVar.I0 = optString87;
            }
            String optString88 = jSONObject.optString("uit");
            if (!TextUtils.isEmpty(optString88) && !list.contains("uit")) {
                cVar.J0 = optString88;
            }
            String optString89 = jSONObject.optString("cghcl");
            if (!TextUtils.isEmpty(optString89) && !list.contains("cghcl")) {
                cVar.K0 = optString89;
            }
            String optString90 = jSONObject.optString("expid");
            if (!TextUtils.isEmpty(optString90) && !list.contains("expid")) {
                cVar.L0 = optString90;
            }
            String optString91 = jSONObject.optString("expvalue");
            if (!TextUtils.isEmpty(optString91) && !list.contains("expvalue")) {
                cVar.M0 = optString91;
            }
            String optString92 = jSONObject.optString("tc");
            if (!TextUtils.isEmpty(optString92) && !list.contains("tc")) {
                cVar.N0 = optString92;
            }
            String optString93 = jSONObject.optString("ir");
            if (!TextUtils.isEmpty(optString93) && !list.contains("ir")) {
                cVar.O0 = optString93;
            }
            String optString94 = jSONObject.optString("rpt");
            if (TextUtils.isEmpty(optString94) || list.contains("rpt")) {
                return;
            }
            cVar.P0 = optString94;
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.qq.e.comm.plugin.e.l.c
    public c a(c cVar, c cVar2, String str) {
        if (cVar == null || cVar2 == null) {
            return null;
        }
        String str2 = cVar2.f42657a;
        if (!TextUtils.isEmpty(str2)) {
            cVar.f42657a = str2;
        }
        if (TextUtils.isEmpty(cVar.f42657a)) {
            cVar.f42657a = str;
        }
        String str3 = cVar2.f42659b;
        if (!TextUtils.isEmpty(str3)) {
            cVar.f42659b = str3;
        }
        if (TextUtils.isEmpty(cVar.f42659b)) {
            cVar.f42659b = str;
        }
        String str4 = cVar2.f42661c;
        if (!TextUtils.isEmpty(str4)) {
            cVar.f42661c = str4;
        }
        if (TextUtils.isEmpty(cVar.f42661c)) {
            cVar.f42661c = str;
        }
        String str5 = cVar2.f42663d;
        if (!TextUtils.isEmpty(str5)) {
            cVar.f42663d = str5;
        }
        if (TextUtils.isEmpty(cVar.f42663d)) {
            cVar.f42663d = str;
        }
        String str6 = cVar2.f42665e;
        if (!TextUtils.isEmpty(str6)) {
            cVar.f42665e = str6;
        }
        if (TextUtils.isEmpty(cVar.f42665e)) {
            cVar.f42665e = str;
        }
        String str7 = cVar2.f42667f;
        if (!TextUtils.isEmpty(str7)) {
            cVar.f42667f = str7;
        }
        if (TextUtils.isEmpty(cVar.f42667f)) {
            cVar.f42667f = str;
        }
        String str8 = cVar2.f42669g;
        if (!TextUtils.isEmpty(str8)) {
            cVar.f42669g = str8;
        }
        if (TextUtils.isEmpty(cVar.f42669g)) {
            cVar.f42669g = str;
        }
        String str9 = cVar2.f42671h;
        if (!TextUtils.isEmpty(str9)) {
            cVar.f42671h = str9;
        }
        if (TextUtils.isEmpty(cVar.f42671h)) {
            cVar.f42671h = str;
        }
        String str10 = cVar2.f42673i;
        if (!TextUtils.isEmpty(str10)) {
            cVar.f42673i = str10;
        }
        if (TextUtils.isEmpty(cVar.f42673i)) {
            cVar.f42673i = str;
        }
        String str11 = cVar2.f42675j;
        if (!TextUtils.isEmpty(str11)) {
            cVar.f42675j = str11;
        }
        if (TextUtils.isEmpty(cVar.f42675j)) {
            cVar.f42675j = str;
        }
        String str12 = cVar2.f42677k;
        if (!TextUtils.isEmpty(str12)) {
            cVar.f42677k = str12;
        }
        if (TextUtils.isEmpty(cVar.f42677k)) {
            cVar.f42677k = str;
        }
        String str13 = cVar2.f42679l;
        if (!TextUtils.isEmpty(str13)) {
            cVar.f42679l = str13;
        }
        if (TextUtils.isEmpty(cVar.f42679l)) {
            cVar.f42679l = str;
        }
        String str14 = cVar2.f42681m;
        if (!TextUtils.isEmpty(str14)) {
            cVar.f42681m = str14;
        }
        if (TextUtils.isEmpty(cVar.f42681m)) {
            cVar.f42681m = str;
        }
        String str15 = cVar2.f42683n;
        if (!TextUtils.isEmpty(str15)) {
            cVar.f42683n = str15;
        }
        if (TextUtils.isEmpty(cVar.f42683n)) {
            cVar.f42683n = str;
        }
        String str16 = cVar2.f42685o;
        if (!TextUtils.isEmpty(str16)) {
            cVar.f42685o = str16;
        }
        if (TextUtils.isEmpty(cVar.f42685o)) {
            cVar.f42685o = str;
        }
        String str17 = cVar2.f42687p;
        if (!TextUtils.isEmpty(str17)) {
            cVar.f42687p = str17;
        }
        if (TextUtils.isEmpty(cVar.f42687p)) {
            cVar.f42687p = str;
        }
        String str18 = cVar2.f42689q;
        if (!TextUtils.isEmpty(str18)) {
            cVar.f42689q = str18;
        }
        if (TextUtils.isEmpty(cVar.f42689q)) {
            cVar.f42689q = str;
        }
        String str19 = cVar2.f42691r;
        if (!TextUtils.isEmpty(str19)) {
            cVar.f42691r = str19;
        }
        if (TextUtils.isEmpty(cVar.f42691r)) {
            cVar.f42691r = str;
        }
        String str20 = cVar2.f42693s;
        if (!TextUtils.isEmpty(str20)) {
            cVar.f42693s = str20;
        }
        if (TextUtils.isEmpty(cVar.f42693s)) {
            cVar.f42693s = str;
        }
        String str21 = cVar2.f42695t;
        if (!TextUtils.isEmpty(str21)) {
            cVar.f42695t = str21;
        }
        if (TextUtils.isEmpty(cVar.f42695t)) {
            cVar.f42695t = str;
        }
        String str22 = cVar2.f42697u;
        if (!TextUtils.isEmpty(str22)) {
            cVar.f42697u = str22;
        }
        if (TextUtils.isEmpty(cVar.f42697u)) {
            cVar.f42697u = str;
        }
        String str23 = cVar2.f42699v;
        if (!TextUtils.isEmpty(str23)) {
            cVar.f42699v = str23;
        }
        if (TextUtils.isEmpty(cVar.f42699v)) {
            cVar.f42699v = str;
        }
        String str24 = cVar2.f42701w;
        if (!TextUtils.isEmpty(str24)) {
            cVar.f42701w = str24;
        }
        if (TextUtils.isEmpty(cVar.f42701w)) {
            cVar.f42701w = str;
        }
        String str25 = cVar2.f42703x;
        if (!TextUtils.isEmpty(str25)) {
            cVar.f42703x = str25;
        }
        if (TextUtils.isEmpty(cVar.f42703x)) {
            cVar.f42703x = str;
        }
        String str26 = cVar2.f42705y;
        if (!TextUtils.isEmpty(str26)) {
            cVar.f42705y = str26;
        }
        if (TextUtils.isEmpty(cVar.f42705y)) {
            cVar.f42705y = str;
        }
        String str27 = cVar2.f42707z;
        if (!TextUtils.isEmpty(str27)) {
            cVar.f42707z = str27;
        }
        if (TextUtils.isEmpty(cVar.f42707z)) {
            cVar.f42707z = str;
        }
        String str28 = cVar2.A;
        if (!TextUtils.isEmpty(str28)) {
            cVar.A = str28;
        }
        if (TextUtils.isEmpty(cVar.A)) {
            cVar.A = str;
        }
        String str29 = cVar2.B;
        if (!TextUtils.isEmpty(str29)) {
            cVar.B = str29;
        }
        if (TextUtils.isEmpty(cVar.B)) {
            cVar.B = str;
        }
        String str30 = cVar2.C;
        if (!TextUtils.isEmpty(str30)) {
            cVar.C = str30;
        }
        if (TextUtils.isEmpty(cVar.C)) {
            cVar.C = str;
        }
        String str31 = cVar2.D;
        if (!TextUtils.isEmpty(str31)) {
            cVar.D = str31;
        }
        if (TextUtils.isEmpty(cVar.D)) {
            cVar.D = str;
        }
        String str32 = cVar2.E;
        if (!TextUtils.isEmpty(str32)) {
            cVar.E = str32;
        }
        if (TextUtils.isEmpty(cVar.E)) {
            cVar.E = str;
        }
        String str33 = cVar2.F;
        if (!TextUtils.isEmpty(str33)) {
            cVar.F = str33;
        }
        if (TextUtils.isEmpty(cVar.F)) {
            cVar.F = str;
        }
        String str34 = cVar2.G;
        if (!TextUtils.isEmpty(str34)) {
            cVar.G = str34;
        }
        if (TextUtils.isEmpty(cVar.G)) {
            cVar.G = str;
        }
        String str35 = cVar2.H;
        if (!TextUtils.isEmpty(str35)) {
            cVar.H = str35;
        }
        if (TextUtils.isEmpty(cVar.H)) {
            cVar.H = str;
        }
        String str36 = cVar2.I;
        if (!TextUtils.isEmpty(str36)) {
            cVar.I = str36;
        }
        if (TextUtils.isEmpty(cVar.I)) {
            cVar.I = str;
        }
        String str37 = cVar2.J;
        if (!TextUtils.isEmpty(str37)) {
            cVar.J = str37;
        }
        if (TextUtils.isEmpty(cVar.J)) {
            cVar.J = str;
        }
        String str38 = cVar2.K;
        if (!TextUtils.isEmpty(str38)) {
            cVar.K = str38;
        }
        if (TextUtils.isEmpty(cVar.K)) {
            cVar.K = str;
        }
        String str39 = cVar2.f42656L;
        if (!TextUtils.isEmpty(str39)) {
            cVar.f42656L = str39;
        }
        if (TextUtils.isEmpty(cVar.f42656L)) {
            cVar.f42656L = str;
        }
        String str40 = cVar2.M;
        if (!TextUtils.isEmpty(str40)) {
            cVar.M = str40;
        }
        if (TextUtils.isEmpty(cVar.M)) {
            cVar.M = str;
        }
        String str41 = cVar2.N;
        if (!TextUtils.isEmpty(str41)) {
            cVar.N = str41;
        }
        if (TextUtils.isEmpty(cVar.N)) {
            cVar.N = str;
        }
        String str42 = cVar2.O;
        if (!TextUtils.isEmpty(str42)) {
            cVar.O = str42;
        }
        if (TextUtils.isEmpty(cVar.O)) {
            cVar.O = str;
        }
        String str43 = cVar2.P;
        if (!TextUtils.isEmpty(str43)) {
            cVar.P = str43;
        }
        if (TextUtils.isEmpty(cVar.P)) {
            cVar.P = str;
        }
        String str44 = cVar2.Q;
        if (!TextUtils.isEmpty(str44)) {
            cVar.Q = str44;
        }
        if (TextUtils.isEmpty(cVar.Q)) {
            cVar.Q = str;
        }
        String str45 = cVar2.R;
        if (!TextUtils.isEmpty(str45)) {
            cVar.R = str45;
        }
        if (TextUtils.isEmpty(cVar.R)) {
            cVar.R = str;
        }
        String str46 = cVar2.S;
        if (!TextUtils.isEmpty(str46)) {
            cVar.S = str46;
        }
        if (TextUtils.isEmpty(cVar.S)) {
            cVar.S = str;
        }
        String str47 = cVar2.T;
        if (!TextUtils.isEmpty(str47)) {
            cVar.T = str47;
        }
        if (TextUtils.isEmpty(cVar.T)) {
            cVar.T = str;
        }
        String str48 = cVar2.U;
        if (!TextUtils.isEmpty(str48)) {
            cVar.U = str48;
        }
        if (TextUtils.isEmpty(cVar.U)) {
            cVar.U = str;
        }
        String str49 = cVar2.V;
        if (!TextUtils.isEmpty(str49)) {
            cVar.V = str49;
        }
        if (TextUtils.isEmpty(cVar.V)) {
            cVar.V = str;
        }
        String str50 = cVar2.W;
        if (!TextUtils.isEmpty(str50)) {
            cVar.W = str50;
        }
        if (TextUtils.isEmpty(cVar.W)) {
            cVar.W = str;
        }
        String str51 = cVar2.X;
        if (!TextUtils.isEmpty(str51)) {
            cVar.X = str51;
        }
        if (TextUtils.isEmpty(cVar.X)) {
            cVar.X = str;
        }
        String str52 = cVar2.Y;
        if (!TextUtils.isEmpty(str52)) {
            cVar.Y = str52;
        }
        if (TextUtils.isEmpty(cVar.Y)) {
            cVar.Y = str;
        }
        String str53 = cVar2.Z;
        if (!TextUtils.isEmpty(str53)) {
            cVar.Z = str53;
        }
        if (TextUtils.isEmpty(cVar.Z)) {
            cVar.Z = str;
        }
        String str54 = cVar2.f42658a0;
        if (!TextUtils.isEmpty(str54)) {
            cVar.f42658a0 = str54;
        }
        if (TextUtils.isEmpty(cVar.f42658a0)) {
            cVar.f42658a0 = str;
        }
        String str55 = cVar2.f42660b0;
        if (!TextUtils.isEmpty(str55)) {
            cVar.f42660b0 = str55;
        }
        if (TextUtils.isEmpty(cVar.f42660b0)) {
            cVar.f42660b0 = str;
        }
        String str56 = cVar2.f42662c0;
        if (!TextUtils.isEmpty(str56)) {
            cVar.f42662c0 = str56;
        }
        if (TextUtils.isEmpty(cVar.f42662c0)) {
            cVar.f42662c0 = str;
        }
        String str57 = cVar2.f42664d0;
        if (!TextUtils.isEmpty(str57)) {
            cVar.f42664d0 = str57;
        }
        if (TextUtils.isEmpty(cVar.f42664d0)) {
            cVar.f42664d0 = str;
        }
        String str58 = cVar2.f42666e0;
        if (!TextUtils.isEmpty(str58)) {
            cVar.f42666e0 = str58;
        }
        if (TextUtils.isEmpty(cVar.f42666e0)) {
            cVar.f42666e0 = str;
        }
        String str59 = cVar2.f42668f0;
        if (!TextUtils.isEmpty(str59)) {
            cVar.f42668f0 = str59;
        }
        if (TextUtils.isEmpty(cVar.f42668f0)) {
            cVar.f42668f0 = str;
        }
        String str60 = cVar2.f42670g0;
        if (!TextUtils.isEmpty(str60)) {
            cVar.f42670g0 = str60;
        }
        if (TextUtils.isEmpty(cVar.f42670g0)) {
            cVar.f42670g0 = str;
        }
        String str61 = cVar2.f42672h0;
        if (!TextUtils.isEmpty(str61)) {
            cVar.f42672h0 = str61;
        }
        if (TextUtils.isEmpty(cVar.f42672h0)) {
            cVar.f42672h0 = str;
        }
        String str62 = cVar2.f42674i0;
        if (!TextUtils.isEmpty(str62)) {
            cVar.f42674i0 = str62;
        }
        if (TextUtils.isEmpty(cVar.f42674i0)) {
            cVar.f42674i0 = str;
        }
        String str63 = cVar2.f42676j0;
        if (!TextUtils.isEmpty(str63)) {
            cVar.f42676j0 = str63;
        }
        if (TextUtils.isEmpty(cVar.f42676j0)) {
            cVar.f42676j0 = str;
        }
        String str64 = cVar2.f42678k0;
        if (!TextUtils.isEmpty(str64)) {
            cVar.f42678k0 = str64;
        }
        if (TextUtils.isEmpty(cVar.f42678k0)) {
            cVar.f42678k0 = str;
        }
        String str65 = cVar2.f42680l0;
        if (!TextUtils.isEmpty(str65)) {
            cVar.f42680l0 = str65;
        }
        if (TextUtils.isEmpty(cVar.f42680l0)) {
            cVar.f42680l0 = str;
        }
        String str66 = cVar2.f42682m0;
        if (!TextUtils.isEmpty(str66)) {
            cVar.f42682m0 = str66;
        }
        if (TextUtils.isEmpty(cVar.f42682m0)) {
            cVar.f42682m0 = str;
        }
        String str67 = cVar2.f42684n0;
        if (!TextUtils.isEmpty(str67)) {
            cVar.f42684n0 = str67;
        }
        if (TextUtils.isEmpty(cVar.f42684n0)) {
            cVar.f42684n0 = str;
        }
        String str68 = cVar2.f42686o0;
        if (!TextUtils.isEmpty(str68)) {
            cVar.f42686o0 = str68;
        }
        if (TextUtils.isEmpty(cVar.f42686o0)) {
            cVar.f42686o0 = str;
        }
        String str69 = cVar2.f42688p0;
        if (!TextUtils.isEmpty(str69)) {
            cVar.f42688p0 = str69;
        }
        if (TextUtils.isEmpty(cVar.f42688p0)) {
            cVar.f42688p0 = str;
        }
        String str70 = cVar2.f42690q0;
        if (!TextUtils.isEmpty(str70)) {
            cVar.f42690q0 = str70;
        }
        if (TextUtils.isEmpty(cVar.f42690q0)) {
            cVar.f42690q0 = str;
        }
        String str71 = cVar2.f42692r0;
        if (!TextUtils.isEmpty(str71)) {
            cVar.f42692r0 = str71;
        }
        if (TextUtils.isEmpty(cVar.f42692r0)) {
            cVar.f42692r0 = str;
        }
        String str72 = cVar2.f42694s0;
        if (!TextUtils.isEmpty(str72)) {
            cVar.f42694s0 = str72;
        }
        if (TextUtils.isEmpty(cVar.f42694s0)) {
            cVar.f42694s0 = str;
        }
        String str73 = cVar2.f42696t0;
        if (!TextUtils.isEmpty(str73)) {
            cVar.f42696t0 = str73;
        }
        if (TextUtils.isEmpty(cVar.f42696t0)) {
            cVar.f42696t0 = str;
        }
        String str74 = cVar2.f42698u0;
        if (!TextUtils.isEmpty(str74)) {
            cVar.f42698u0 = str74;
        }
        if (TextUtils.isEmpty(cVar.f42698u0)) {
            cVar.f42698u0 = str;
        }
        String str75 = cVar2.f42700v0;
        if (!TextUtils.isEmpty(str75)) {
            cVar.f42700v0 = str75;
        }
        if (TextUtils.isEmpty(cVar.f42700v0)) {
            cVar.f42700v0 = str;
        }
        String str76 = cVar2.f42702w0;
        if (!TextUtils.isEmpty(str76)) {
            cVar.f42702w0 = str76;
        }
        if (TextUtils.isEmpty(cVar.f42702w0)) {
            cVar.f42702w0 = str;
        }
        String str77 = cVar2.f42704x0;
        if (!TextUtils.isEmpty(str77)) {
            cVar.f42704x0 = str77;
        }
        if (TextUtils.isEmpty(cVar.f42704x0)) {
            cVar.f42704x0 = str;
        }
        String str78 = cVar2.f42706y0;
        if (!TextUtils.isEmpty(str78)) {
            cVar.f42706y0 = str78;
        }
        if (TextUtils.isEmpty(cVar.f42706y0)) {
            cVar.f42706y0 = str;
        }
        String str79 = cVar2.f42708z0;
        if (!TextUtils.isEmpty(str79)) {
            cVar.f42708z0 = str79;
        }
        if (TextUtils.isEmpty(cVar.f42708z0)) {
            cVar.f42708z0 = str;
        }
        String str80 = cVar2.A0;
        if (!TextUtils.isEmpty(str80)) {
            cVar.A0 = str80;
        }
        if (TextUtils.isEmpty(cVar.A0)) {
            cVar.A0 = str;
        }
        String str81 = cVar2.B0;
        if (!TextUtils.isEmpty(str81)) {
            cVar.B0 = str81;
        }
        if (TextUtils.isEmpty(cVar.B0)) {
            cVar.B0 = str;
        }
        String str82 = cVar2.C0;
        if (!TextUtils.isEmpty(str82)) {
            cVar.C0 = str82;
        }
        if (TextUtils.isEmpty(cVar.C0)) {
            cVar.C0 = str;
        }
        String str83 = cVar2.D0;
        if (!TextUtils.isEmpty(str83)) {
            cVar.D0 = str83;
        }
        if (TextUtils.isEmpty(cVar.D0)) {
            cVar.D0 = str;
        }
        String str84 = cVar2.E0;
        if (!TextUtils.isEmpty(str84)) {
            cVar.E0 = str84;
        }
        if (TextUtils.isEmpty(cVar.E0)) {
            cVar.E0 = str;
        }
        String str85 = cVar2.F0;
        if (!TextUtils.isEmpty(str85)) {
            cVar.F0 = str85;
        }
        if (TextUtils.isEmpty(cVar.F0)) {
            cVar.F0 = str;
        }
        String str86 = cVar2.G0;
        if (!TextUtils.isEmpty(str86)) {
            cVar.G0 = str86;
        }
        if (TextUtils.isEmpty(cVar.G0)) {
            cVar.G0 = str;
        }
        String str87 = cVar2.H0;
        if (!TextUtils.isEmpty(str87)) {
            cVar.H0 = str87;
        }
        if (TextUtils.isEmpty(cVar.H0)) {
            cVar.H0 = str;
        }
        String str88 = cVar2.I0;
        if (!TextUtils.isEmpty(str88)) {
            cVar.I0 = str88;
        }
        if (TextUtils.isEmpty(cVar.I0)) {
            cVar.I0 = str;
        }
        String str89 = cVar2.J0;
        if (!TextUtils.isEmpty(str89)) {
            cVar.J0 = str89;
        }
        if (TextUtils.isEmpty(cVar.J0)) {
            cVar.J0 = str;
        }
        String str90 = cVar2.K0;
        if (!TextUtils.isEmpty(str90)) {
            cVar.K0 = str90;
        }
        if (TextUtils.isEmpty(cVar.K0)) {
            cVar.K0 = str;
        }
        String str91 = cVar2.L0;
        if (!TextUtils.isEmpty(str91)) {
            cVar.L0 = str91;
        }
        if (TextUtils.isEmpty(cVar.L0)) {
            cVar.L0 = str;
        }
        String str92 = cVar2.M0;
        if (!TextUtils.isEmpty(str92)) {
            cVar.M0 = str92;
        }
        if (TextUtils.isEmpty(cVar.M0)) {
            cVar.M0 = str;
        }
        String str93 = cVar2.N0;
        if (!TextUtils.isEmpty(str93)) {
            cVar.N0 = str93;
        }
        if (TextUtils.isEmpty(cVar.N0)) {
            cVar.N0 = str;
        }
        String str94 = cVar2.O0;
        if (!TextUtils.isEmpty(str94)) {
            cVar.O0 = str94;
        }
        if (TextUtils.isEmpty(cVar.O0)) {
            cVar.O0 = str;
        }
        String str95 = cVar2.P0;
        if (!TextUtils.isEmpty(str95)) {
            cVar.P0 = str95;
        }
        if (TextUtils.isEmpty(cVar.P0)) {
            cVar.P0 = str;
        }
        return cVar;
    }
}
