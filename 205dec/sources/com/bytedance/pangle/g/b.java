package com.bytedance.pangle.g;

import android.util.ArrayMap;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@RequiresApi(api = 21)
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final X509Certificate[][] f28776a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f28777b;

        public a(X509Certificate[][] x509CertificateArr, byte[] bArr) {
            this.f28776a = x509CertificateArr;
            this.f28777b = bArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(RandomAccessFile randomAccessFile, m mVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer a4 = f.a(mVar.f28798a);
                int i4 = 0;
                while (a4.hasRemaining()) {
                    i4++;
                    try {
                        arrayList.add(a(f.a(a4), arrayMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e4) {
                        throw new SecurityException("Failed to parse/verify signer #" + i4 + " block", e4);
                    }
                }
                if (i4 > 0) {
                    if (!arrayMap.isEmpty()) {
                        f.a(arrayMap, randomAccessFile, mVar);
                        return new a((X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()]), arrayMap.containsKey(3) ? f.a((byte[]) arrayMap.get(3), randomAccessFile.length(), mVar) : null);
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("No signers found");
            } catch (IOException e5) {
                throw new SecurityException("Failed to read list of signers", e5);
            }
        } catch (CertificateException e6) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e6);
        }
    }

    private static X509Certificate[] a(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) {
        int a4;
        ByteBuffer a5 = f.a(byteBuffer);
        ByteBuffer a6 = f.a(byteBuffer);
        byte[] b4 = f.b(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        byte[] bArr2 = null;
        int i4 = -1;
        int i5 = 0;
        while (true) {
            boolean z3 = true;
            if (!a6.hasRemaining()) {
                if (i4 == -1) {
                    if (i5 == 0) {
                        throw new SecurityException("No signatures found");
                    }
                    throw new SecurityException("No supported signatures found");
                }
                String c4 = f.c(i4);
                Pair<String, ? extends AlgorithmParameterSpec> d4 = f.d(i4);
                String str = (String) d4.first;
                AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) d4.second;
                try {
                    PublicKey generatePublic = KeyFactory.getInstance(c4).generatePublic(new X509EncodedKeySpec(b4));
                    Signature signature = Signature.getInstance(str);
                    signature.initVerify(generatePublic);
                    if (algorithmParameterSpec != null) {
                        signature.setParameter(algorithmParameterSpec);
                    }
                    signature.update(a5);
                    if (signature.verify(bArr2)) {
                        a5.clear();
                        ByteBuffer a7 = f.a(a5);
                        ArrayList arrayList2 = new ArrayList();
                        int i6 = 0;
                        while (a7.hasRemaining()) {
                            i6++;
                            try {
                                ByteBuffer a8 = f.a(a7);
                                if (a8.remaining() >= 8) {
                                    int i7 = a8.getInt();
                                    arrayList2.add(Integer.valueOf(i7));
                                    if (i7 == i4) {
                                        bArr = f.b(a8);
                                    }
                                } else {
                                    throw new IOException("Record too short");
                                }
                            } catch (IOException | BufferUnderflowException e4) {
                                throw new IOException("Failed to parse digest record #".concat(String.valueOf(i6)), e4);
                            }
                        }
                        if (arrayList.equals(arrayList2)) {
                            byte[] put = map.put(Integer.valueOf(f.a(i4)), bArr);
                            if (put != null && !MessageDigest.isEqual(put, bArr)) {
                                throw new SecurityException(f.b(a4) + " contents digest does not match the digest specified by a preceding signer");
                            }
                            ByteBuffer a9 = f.a(a5);
                            ArrayList arrayList3 = new ArrayList();
                            int i8 = 0;
                            while (a9.hasRemaining()) {
                                i8++;
                                byte[] b5 = f.b(a9);
                                try {
                                    arrayList3.add(new p((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(b5)), b5));
                                } catch (CertificateException e5) {
                                    throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i8)), e5);
                                }
                            }
                            if (!arrayList3.isEmpty()) {
                                if (Arrays.equals(b4, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                                    a(f.a(a5));
                                    return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                                }
                                throw new SecurityException("Public key mismatch between certificate and signature record");
                            }
                            throw new SecurityException("No certificates listed");
                        }
                        throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                    }
                    throw new SecurityException(str + " signature did not verify");
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e6) {
                    throw new SecurityException("Failed to verify " + str + " signature", e6);
                }
            }
            i5++;
            try {
                ByteBuffer a10 = f.a(a6);
                if (a10.remaining() >= 8) {
                    int i9 = a10.getInt();
                    arrayList.add(Integer.valueOf(i9));
                    if (i9 != 513 && i9 != 514 && i9 != 769 && i9 != 1057 && i9 != 1059 && i9 != 1061) {
                        switch (i9) {
                            case 257:
                            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
                            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
                            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                                break;
                            default:
                                z3 = false;
                                break;
                        }
                    }
                    if (z3 && (i4 == -1 || f.a(i9, i4) > 0)) {
                        bArr2 = f.b(a10);
                        i4 = i9;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e7) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i5)), e7);
            }
        }
    }

    private static void a(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            ByteBuffer a4 = f.a(byteBuffer);
            if (a4.remaining() >= 4) {
                if (a4.getInt() == -1091571699) {
                    if (a4.remaining() >= 4) {
                        if (a4.getInt() == 3) {
                            throw new SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
                        }
                    } else {
                        throw new IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + a4.remaining());
                    }
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + a4.remaining());
            }
        }
    }
}
