package com.bytedance.msdk.f;

import android.text.TextUtils;
import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class fz {
    public static boolean c() {
        Map<String, Object> wv = com.bytedance.msdk.core.w.k().wv();
        Map<String, Object> me = com.bytedance.msdk.core.w.k().me();
        if (wv != null) {
            try {
                if (wv.get("eefo") instanceof Boolean) {
                    return ((Boolean) wv.get("eefo")).booleanValue();
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (me == null || !(me.get("eefo") instanceof Boolean)) {
            return false;
        }
        return ((Boolean) me.get("eefo")).booleanValue();
    }

    private static String w(String str, String str2) {
        try {
            return c.c(str.getBytes(StandardCharsets.UTF_8), str2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(com.bytedance.msdk.api.xv xvVar) {
        if (xvVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adn_name", xvVar.ev());
            jSONObject.put("custom_adn_name", xvVar.gd());
            jSONObject.put("slot_id", xvVar.p());
            jSONObject.put("level_tag", xvVar.bk());
            jSONObject.put("ecpm", xvVar.a());
            jSONObject.put("bidding_type", xvVar.t());
            jSONObject.put("error_msg", xvVar.ys());
            jSONObject.put(ConstantAd.KEY_CACHE_AD, xvVar.fp());
            jSONObject.put("ad_rit_type", xvVar.w());
            jSONObject.put("segment_id", xvVar.xv());
            jSONObject.put("abtest_id", xvVar.f());
            jSONObject.put("channel", xvVar.sr());
            jSONObject.put("sub_channel", xvVar.ux());
            jSONObject.put("scenario_id", xvVar.r());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return null;
        }
        try {
            String c4 = c(16);
            String w3 = w(jSONObject2, c4);
            String c5 = c(c4, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7aAsZzOAmVVuIl0EZtpY\nPkJGdr82VIOzPBDYNEOBK0tfk/oSWyY8yZDpeYuhNuSPySmhaN8Apn3HGfL1Eq6t\nSE3OdAovRJjnilU/5ugSM/nr5yMy6WRvJUskvQ9F3PF9MLez8ZJxVDb4tgUXjq2S\n1QKSP+NwAKdY+P/H8SD5evamqCpvzO1IwpqznNI2HGAo/Kdm5OQ+Yq47A31dDUSH\nVF/TTzTfae8j6lanqgz9DmFs+kqoy253aXlz8H0z8J3VpmOGvnOUiS00Hg5SILV0\nsoXtS9JKK/V3gXmbXWyFvZhuIvLqk3C8AdyZuDdy1GAI3GjI4wjtiMd11zSTECrV\ntQIDAQAB");
            String format = String.format("%04d", Integer.valueOf(c5.length()));
            return format + c5 + w3;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String c(String str, String str2) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 0)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(1, generatePublic);
            return Base64.encodeToString(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String c(int i4) {
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i5 = 0; i5 < i4; i5++) {
            int nextInt = secureRandom.nextInt(3);
            if (nextInt == 0) {
                sb.append(secureRandom.nextInt(10));
            } else if (nextInt == 1) {
                sb.append((char) (secureRandom.nextInt(25) + 65));
            } else if (nextInt == 2) {
                sb.append((char) (secureRandom.nextInt(25) + 97));
            }
        }
        return sb.toString();
    }
}
