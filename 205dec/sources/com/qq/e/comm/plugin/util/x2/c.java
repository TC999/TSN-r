package com.qq.e.comm.plugin.util.x2;

import android.content.pm.Signature;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.plugin.util.x2.b;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Map;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f46715a = "com.qq.e.comm.plugin.util.x2.c";

    /* renamed from: b  reason: collision with root package name */
    private static volatile String f46716b;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        public final X509Certificate[] f46717a;

        /* renamed from: b  reason: collision with root package name */
        public final b.a f46718b;

        public a(X509Certificate[] x509CertificateArr, b.a aVar, byte[] bArr, Map<Integer, byte[]> map, int i4) {
            this.f46717a = x509CertificateArr;
            this.f46718b = aVar;
        }
    }

    public static String a() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_AV_NO_SYNC_THRESHOLD, 1, new Object[0]);
    }

    private static Signature[] a(Certificate[][] certificateArr) throws CertificateEncodingException {
        Signature[] signatureArr = new Signature[certificateArr.length];
        for (int i4 = 0; i4 < certificateArr.length; i4++) {
            signatureArr[i4] = new Signature(certificateArr[i4][0].getEncoded());
        }
        return signatureArr;
    }
}
