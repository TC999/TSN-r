package com.tencent.turingfd.sdk.ams.au;

import android.util.Base64;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import org.json.JSONObject;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.catch  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Ccatch {

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ boolean f52232e = !Ccatch.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public static final String f52228a = Cextends.a(Cextends.S0);

    /* renamed from: b  reason: collision with root package name */
    public static final String f52229b = Cextends.a(Cextends.O0);

    /* renamed from: c  reason: collision with root package name */
    public static final String f52230c = Cextends.a(Cextends.P0);

    /* renamed from: d  reason: collision with root package name */
    public static final String f52231d = Cextends.a(Cextends.Q0);

    public static String a(Certificate certificate) throws Exception {
        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        bufferedWriter.write("-----BEGIN CERTIFICATE-----");
        bufferedWriter.write("\n");
        byte[] encode = Base64.encode(certificate.getEncoded(), 2);
        char[] cArr = new char[64];
        for (int i4 = 0; i4 < encode.length; i4 += 64) {
            int i5 = 0;
            while (i5 != 64) {
                int i6 = i4 + i5;
                if (i6 >= encode.length) {
                    break;
                }
                cArr[i5] = (char) encode[i6];
                i5++;
            }
            bufferedWriter.write(cArr, 0, i5);
            bufferedWriter.write("\n");
        }
        bufferedWriter.write("-----END CERTIFICATE-----");
        bufferedWriter.write("\n");
        bufferedWriter.close();
        return stringWriter.toString();
    }

    public static void a(X509Certificate x509Certificate, Casaba casaba) throws Exception, IOException {
        byte[] extensionValue = x509Certificate.getExtensionValue(f52228a);
        if (extensionValue != null && extensionValue.length != 0) {
            try {
                byte b4 = "{".getBytes()[0];
                byte b5 = "}".getBytes()[0];
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < extensionValue.length; i6++) {
                    byte b6 = extensionValue[i6];
                    if (b6 == b4) {
                        i4 = i6;
                    } else if (b6 == b5) {
                        i5 = i6;
                    }
                }
                if (i4 <= 0 || i4 >= i5) {
                    return;
                }
                if (!f52232e && extensionValue[i4 - 1] != (i5 - i4) + 1) {
                    throw new AssertionError();
                }
                int i7 = (i5 - i4) + 1;
                byte[] bArr = new byte[i7];
                System.arraycopy(extensionValue, i4, bArr, 0, i7);
                JSONObject jSONObject = new JSONObject(new String(bArr));
                casaba.f51954c = jSONObject.getString(f52230c);
                casaba.f51953b = jSONObject.getInt(f52231d);
                casaba.f51952a = jSONObject.getLong(f52229b);
                return;
            } catch (Exception e4) {
                StringBuilder a4 = Almond.a("C");
                a4.append(e4.getStackTrace());
                throw new Exception(a4.toString());
            }
        }
        throw new Exception("Couldn't find the keystore attestation extension data.");
    }
}
