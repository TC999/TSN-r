package com.tencent.turingfd.sdk.ams.au;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Casaba {

    /* renamed from: e  reason: collision with root package name */
    public static final String f51947e = Cextends.a(Cextends.N0);

    /* renamed from: f  reason: collision with root package name */
    public static final String f51948f = Cextends.a(Cextends.O0);

    /* renamed from: g  reason: collision with root package name */
    public static final String f51949g = Cextends.a(Cextends.P0);

    /* renamed from: h  reason: collision with root package name */
    public static final String f51950h = Cextends.a(Cextends.Q0);

    /* renamed from: i  reason: collision with root package name */
    public static final String f51951i = Cextends.a(Cextends.R0);

    /* renamed from: a  reason: collision with root package name */
    public long f51952a;

    /* renamed from: b  reason: collision with root package name */
    public int f51953b;

    /* renamed from: c  reason: collision with root package name */
    public String f51954c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<String> f51955d;

    public Casaba(String str, String str2) {
        this.f51952a = -1L;
        this.f51953b = -1;
        this.f51954c = "";
        this.f51955d = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str3 = f51951i;
            if (jSONObject.has(str3)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(str3);
                optJSONArray.length();
                this.f51955d = new ArrayList<>();
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    this.f51955d.add(optJSONArray.getString(i4));
                }
                a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(this.f51955d.get(0).getBytes())));
                jSONObject.put(f51949g, this.f51954c);
                jSONObject.put(f51950h, this.f51953b);
                jSONObject.put(f51948f, this.f51952a);
                jSONObject.toString();
                return;
            }
            this.f51952a = jSONObject.optLong(f51948f);
            this.f51953b = jSONObject.optInt(f51950h);
            this.f51954c = jSONObject.optString(f51949g);
            jSONObject.optString(f51947e);
        } catch (Exception unused) {
        }
    }

    public final void a(X509Certificate x509Certificate) {
        try {
            Ccatch.a(x509Certificate, this);
        } catch (Exception unused) {
        }
    }

    public Casaba(Certificate[] certificateArr) {
        this.f51952a = -1L;
        this.f51953b = -1;
        this.f51954c = "";
        this.f51955d = null;
        if (certificateArr != null) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                JSONArray jSONArray = new JSONArray();
                for (int i4 = 0; i4 < certificateArr.length; i4++) {
                    Certificate certificate = certificateArr[i4];
                    Base64.encodeToString(certificate.getEncoded(), 2);
                    String a4 = Ccatch.a(certificate);
                    if (i4 == 0) {
                        a((X509Certificate) certificate);
                    }
                    jSONArray.put(a4);
                    arrayList.add(a4);
                }
                this.f51955d = arrayList;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(f51951i, jSONArray);
                jSONObject.put(f51949g, this.f51954c);
                jSONObject.put(f51950h, this.f51953b);
                jSONObject.put(f51948f, this.f51952a);
                jSONObject.toString();
            } catch (Exception unused) {
            }
        }
    }
}
