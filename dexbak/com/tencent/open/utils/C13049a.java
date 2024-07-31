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

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13049a {

    /* renamed from: a */
    private KeyStore f37408a;

    /* renamed from: b */
    private SharedPreferences f37409b;

    public C13049a(Context context) {
        try {
            this.f37409b = context.getSharedPreferences("KEYSTORE_SETTING", 0);
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            this.f37408a = keyStore;
            keyStore.load(null);
            if (this.f37408a.containsAlias("KEYSTORE_AES")) {
                return;
            }
            m15054c("");
            m15059a(context);
            m15060a();
        } catch (Exception e) {
            SLog.m15130d("KEYSTORE", "Exception", e);
        }
    }

    /* renamed from: a */
    private void m15059a(Context context) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("Build.VERSION.SDK_INT=");
        int i = Build.VERSION.SDK_INT;
        sb.append(i);
        SLog.m15131d("KEYSTORE", sb.toString());
        if (i >= 23) {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder("KEYSTORE_AES", 3).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("PKCS1Padding").build());
            keyPairGenerator.generateKeyPair();
        } else if (i >= 18) {
            KeyPairGenerator keyPairGenerator2 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 30);
            keyPairGenerator2.initialize(new KeyPairGeneratorSpec.Builder(context).setAlias("KEYSTORE_AES").setSubject(new X500Principal("CN=KEYSTORE_AES")).setSerialNumber(BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build());
            keyPairGenerator2.generateKeyPair();
        }
    }

    /* renamed from: c */
    private void m15054c(String str) {
        this.f37409b.edit().putString("PREF_KEY_IV", str).apply();
    }

    /* renamed from: d */
    private void m15053d(String str) {
        this.f37409b.edit().putString("PREF_KEY_AES", str).apply();
    }

    /* renamed from: b */
    public String m15056b(String str) {
        try {
            byte[] decode = Base64.decode(str.getBytes(), 0);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, m15055c(), new IvParameterSpec(m15057b()));
            return new String(cipher.doFinal(decode));
        } catch (Exception e) {
            SLog.m15128e("KEYSTORE", "Exception", e);
            return "";
        }
    }

    /* renamed from: c */
    private SecretKeySpec m15055c() throws Exception {
        String string = this.f37409b.getString("PREF_KEY_AES", "");
        if (Build.VERSION.SDK_INT >= 18) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, (PrivateKey) this.f37408a.getKey("KEYSTORE_AES", null));
            return new SecretKeySpec(cipher.doFinal(Base64.decode(string, 0)), "AES/GCM/NoPadding");
        }
        return new SecretKeySpec(Base64.decode(string, 0), "AES/GCM/NoPadding");
    }

    /* renamed from: b */
    private byte[] m15057b() {
        return Base64.decode(this.f37409b.getString("PREF_KEY_IV", ""), 0);
    }

    /* renamed from: a */
    public String m15058a(String str) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, m15055c(), new IvParameterSpec(m15057b()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
        } catch (Exception e) {
            SLog.m15128e("KEYSTORE", "Exception", e);
            return "";
        }
    }

    /* renamed from: a */
    private void m15060a() throws Exception {
        byte[] bArr = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(bArr);
        m15054c(Base64.encodeToString(secureRandom.generateSeed(12), 0));
        if (Build.VERSION.SDK_INT >= 18) {
            PublicKey publicKey = this.f37408a.getCertificate("KEYSTORE_AES").getPublicKey();
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKey);
            m15053d(Base64.encodeToString(cipher.doFinal(bArr), 0));
            return;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bArr);
        m15053d(Base64.encodeToString(messageDigest.digest(), 0));
    }
}
