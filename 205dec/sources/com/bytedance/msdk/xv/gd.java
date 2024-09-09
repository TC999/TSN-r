package com.bytedance.msdk.xv;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd {

    /* renamed from: c  reason: collision with root package name */
    private static volatile gd f28486c;

    /* renamed from: w  reason: collision with root package name */
    private Key f28487w;
    private Cipher xv;

    private gd() {
        try {
            this.f28487w = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(com.bytedance.msdk.core.c.w().m(), 0)));
            this.xv = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static gd c() {
        if (f28486c == null) {
            synchronized (gd.class) {
                if (f28486c == null) {
                    f28486c = new gd();
                }
            }
        }
        return f28486c;
    }

    public String c(byte[] bArr) throws Exception {
        byte[] doFinal;
        if (bArr == null) {
            return null;
        }
        if (this.xv == null) {
            this.f28487w = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(com.bytedance.msdk.core.c.w().m(), 0)));
            this.xv = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        }
        this.xv.init(1, this.f28487w);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = length - i4;
            if (i6 > 0) {
                if (i6 > 117) {
                    doFinal = this.xv.doFinal(bArr, i4, 117);
                } else {
                    doFinal = this.xv.doFinal(bArr, i4, i6);
                }
                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                i5++;
                i4 = i5 * 117;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return Base64.encodeToString(byteArray, 2);
            }
        }
    }

    public String c(com.bytedance.msdk.c.ux uxVar) {
        if (uxVar == null || "pangle".equals(uxVar.getAdNetWorkName())) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(uxVar.getAdTitle())) {
                jSONObject.putOpt("t", uxVar.getAdTitle());
            }
            if (!TextUtils.isEmpty(uxVar.getAdDescription())) {
                jSONObject.putOpt("d", uxVar.getAdDescription());
            }
            jSONObject.putOpt("e", String.valueOf(uxVar.getCpm()));
            if (!TextUtils.isEmpty(uxVar.getAppName())) {
                jSONObject.putOpt("an", uxVar.getAppName());
            }
            if (!TextUtils.isEmpty(uxVar.getAuthorName())) {
                jSONObject.putOpt("aun", uxVar.getAuthorName());
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        if (jSONObject.length() > 0) {
            try {
                return c(jSONObject.toString().getBytes());
            } catch (Exception e5) {
                e5.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
