package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.tencent.open.log.SLog;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private KeyStore f51808a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f51809b;

    public a(Context context) {
        try {
            this.f51809b = context.getSharedPreferences("KEYSTORE_SETTING", 0);
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            this.f51808a = keyStore;
            keyStore.load(null);
            if (this.f51808a.containsAlias("KEYSTORE_AES")) {
                return;
            }
            c("");
            a(context);
            a();
        } catch (Exception e4) {
            SLog.d("KEYSTORE", "Exception", e4);
        }
    }

    private void a(Context context) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("Build.VERSION.SDK_INT=");
        int i4 = Build.VERSION.SDK_INT;
        sb.append(i4);
        SLog.d("KEYSTORE", sb.toString());
        if (i4 >= 23) {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder("KEYSTORE_AES", 3).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("PKCS1Padding").build());
            keyPairGenerator.generateKeyPair();
        } else if (i4 >= 18) {
            KeyPairGenerator keyPairGenerator2 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 30);
            keyPairGenerator2.initialize(new KeyPairGeneratorSpec.Builder(context).setAlias("KEYSTORE_AES").setSubject(new X500Principal("CN=KEYSTORE_AES")).setSerialNumber(BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build());
            keyPairGenerator2.generateKeyPair();
        }
    }

    private void c(String str) {
        this.f51809b.edit().putString("PREF_KEY_IV", str).apply();
    }

    private void d(String str) {
        this.f51809b.edit().putString("PREF_KEY_AES", str).apply();
    }

    public String b(String str) {
        try {
            byte[] decode = Base64.decode(str.getBytes(), 0);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, c(), new IvParameterSpec(b()));
            return new String(cipher.doFinal(decode));
        } catch (Exception e4) {
            SLog.e("KEYSTORE", "Exception", e4);
            return "";
        }
    }

    private SecretKeySpec c() throws Exception {
        String string = this.f51809b.getString("PREF_KEY_AES", "");
        if (Build.VERSION.SDK_INT >= 18) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, (PrivateKey) this.f51808a.getKey("KEYSTORE_AES", null));
            return new SecretKeySpec(cipher.doFinal(Base64.decode(string, 0)), "AES/GCM/NoPadding");
        }
        return new SecretKeySpec(Base64.decode(string, 0), "AES/GCM/NoPadding");
    }

    private byte[] b() {
        return Base64.decode(this.f51809b.getString("PREF_KEY_IV", ""), 0);
    }

    public String a(String str) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, c(), new IvParameterSpec(b()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
        } catch (Exception e4) {
            SLog.e("KEYSTORE", "Exception", e4);
            return "";
        }
    }

    private void a() throws Exception {
        byte[] bArr = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(bArr);
        c(Base64.encodeToString(secureRandom.generateSeed(12), 0));
        if (Build.VERSION.SDK_INT >= 18) {
            PublicKey publicKey = this.f51808a.getCertificate("KEYSTORE_AES").getPublicKey();
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKey);
            d(Base64.encodeToString(cipher.doFinal(bArr), 0));
            return;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bArr);
        d(Base64.encodeToString(messageDigest.digest(), 0));
    }
}
