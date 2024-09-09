package com.baidu.liantian.b;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.liantian.ac.F;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* compiled from: EncryptConnUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class h {
    public static String a(Context context, String str, String str2, boolean z3) {
        return a(context, str, str2, z3, false);
    }

    public static String a(Context context, String str, String str2) {
        return a(context, str, str2, false, false);
    }

    public static String a(Context context, String str, String str2, boolean z3, boolean z4) {
        byte[] bytes;
        String[] g4 = e.g(context);
        String str3 = g4[0];
        String str4 = g4[1];
        String valueOf = String.valueOf(new Date().getTime() / 1000);
        String a4 = o.a(str3 + valueOf + str4);
        byte[] a5 = com.baidu.liantian.core.i.a();
        new String(a5);
        com.baidu.liantian.b.a();
        String str5 = "";
        if (!TextUtils.isEmpty(str2)) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str2.getBytes());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            j.a(byteArrayInputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            byteArrayInputStream.close();
            int length = byteArray.length;
            com.baidu.liantian.b.a();
            bytes = F.getInstance().ae(byteArray, a5);
        } else {
            bytes = "".getBytes();
        }
        int length2 = bytes.length;
        new String(bytes);
        com.baidu.liantian.b.a();
        byte[] bytes2 = o.a(g.a(context)).getBytes();
        new String(bytes2);
        com.baidu.liantian.b.a();
        byte[] re = F.getInstance().re(a5, bytes2);
        int length3 = re.length;
        com.baidu.liantian.b.a();
        String encodeToString = Base64.encodeToString(re, 0);
        com.baidu.liantian.b.a();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("/150/");
        sb.append(str3);
        sb.append(TTPathConst.sSeparator);
        sb.append(valueOf);
        sb.append(TTPathConst.sSeparator);
        sb.append(a4);
        if (!TextUtils.isEmpty(encodeToString)) {
            sb.append("?skey=");
            sb.append(URLEncoder.encode(encodeToString, "utf-8"));
        }
        com.baidu.liantian.b.a();
        try {
            if (z4) {
                str5 = new m(context).a(sb.toString());
            } else {
                str5 = new m(context).a(sb.toString(), bytes);
            }
        } catch (Throwable unused) {
            e.a();
        }
        com.baidu.liantian.b.a();
        if (z3 && TextUtils.isEmpty(str5)) {
            try {
                com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
                long currentTimeMillis = System.currentTimeMillis();
                long j4 = eVar.f12228a.getLong("pu_cl_fd", 0L);
                if (j4 == 0) {
                    j4 = System.currentTimeMillis();
                    eVar.j();
                }
                if (currentTimeMillis - j4 > 86400000) {
                    HashMap hashMap = new HashMap();
                    if (e.e(context)) {
                        hashMap.put("0", Integer.valueOf(eVar.l() + 1));
                        hashMap.put("1", Integer.valueOf(eVar.m()));
                    } else {
                        hashMap.put("0", Integer.valueOf(eVar.l()));
                        hashMap.put("1", Integer.valueOf(eVar.m() + 1));
                    }
                    eVar.f12230c.putInt("mo_fa_pu_cl", 0);
                    eVar.f12230c.commit();
                    eVar.f12230c.putInt("wi_fa_pu_cl", 0);
                    eVar.f12230c.commit();
                    eVar.j();
                    e.a(context, "1003112", hashMap);
                } else if (e.e(context)) {
                    eVar.a(eVar.l() + 1);
                } else {
                    eVar.b(eVar.m() + 1);
                }
            } catch (Throwable unused2) {
                e.a();
            }
            throw new NetworkErrorException("response is empty");
        }
        JSONObject jSONObject = new JSONObject(str5);
        String optString = jSONObject.optString("skey");
        com.baidu.liantian.b.a();
        byte[] decode = Base64.decode(optString, 0);
        int length4 = decode.length;
        com.baidu.liantian.b.a();
        byte[] rd = F.getInstance().rd(decode, bytes2);
        new String(rd);
        com.baidu.liantian.b.a();
        String optString2 = jSONObject.optString("response");
        jSONObject.optString(ConstantAd.KEY_CACHE_AD);
        com.baidu.liantian.b.a();
        com.baidu.liantian.b.a();
        byte[] decode2 = Base64.decode(optString2, 0);
        int length5 = decode2.length;
        com.baidu.liantian.b.a();
        byte[] ad = F.getInstance().ad(decode2, rd);
        if (decode2.length > 0 && (ad == null || ad.length == 0)) {
            e.k(context);
            throw new NetworkErrorException("aes is fail");
        }
        return new String(ad);
    }

    public static boolean a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            jSONObject.put("pkg", packageName);
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 64);
            if (packageInfo != null) {
                PublicKey a4 = e.a(packageInfo, packageInfo.applicationInfo.sourceDir);
                if (a4 != null) {
                    byte[] encoded = a4.getEncoded();
                    if (encoded != null) {
                        e.a(context, encoded);
                        jSONObject.put("sign", o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", "")));
                        com.baidu.liantian.b.a();
                    }
                } else {
                    jSONObject.put("sign", "");
                }
                jSONObject.put("app", e.e(packageInfo.applicationInfo.loadLabel(packageManager).toString()));
            } else {
                jSONObject.put("sign", "");
                jSONObject.put("app", "");
            }
            String jSONObject2 = jSONObject.toString();
            com.baidu.liantian.b.a();
            String a5 = a(context, e.b() + "p/1/auh", jSONObject2, false);
            com.baidu.liantian.b.a();
            JSONObject jSONObject3 = new JSONObject(a5);
            if (jSONObject3.length() > 0) {
                int optInt = jSONObject3.optInt("code");
                com.baidu.liantian.b.a();
                if (optInt == 200) {
                    String optString = jSONObject3.optString("ak");
                    String optString2 = jSONObject3.optString("sk");
                    if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                        return false;
                    }
                    com.baidu.liantian.core.d a6 = com.baidu.liantian.core.d.a(context);
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && (!e.f12116d.equals(optString) || !e.f12117e.equals(optString2))) {
                        e.a(optString, optString2);
                        com.baidu.liantian.e eVar = a6.f12179a;
                        SharedPreferences.Editor editor = eVar.f12230c;
                        editor.putString("svi_n", optString + "-" + optString2);
                        eVar.f12230c.commit();
                    }
                    return true;
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            th.toString();
            com.baidu.liantian.b.a();
            e.a();
            return false;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[256];
        for (int i4 = 0; i4 < 256; i4++) {
            bArr3[i4] = (byte) i4;
        }
        if (bArr2 == null || bArr2.length == 0) {
            bArr3 = null;
        } else {
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < 256; i7++) {
                i6 = ((bArr2[i5] & 255) + (bArr3[i7] & 255) + i6) & 255;
                byte b4 = bArr3[i7];
                bArr3[i7] = bArr3[i6];
                bArr3[i6] = b4;
                i5 = (i5 + 1) % bArr2.length;
            }
        }
        byte[] bArr4 = new byte[bArr.length];
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < bArr.length; i10++) {
            i8 = (i8 + 1) & 255;
            i9 = ((bArr3[i8] & 255) + i9) & 255;
            byte b5 = bArr3[i8];
            bArr3[i8] = bArr3[i9];
            bArr3[i9] = b5;
            bArr4[i10] = (byte) (bArr3[((bArr3[i8] & 255) + (bArr3[i9] & 255)) & 255] ^ bArr[i10]);
            bArr4[i10] = (byte) (bArr4[i10] ^ 42);
        }
        return bArr4;
    }
}
