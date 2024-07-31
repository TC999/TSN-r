package com.bytedance.pangle.p123g;

import android.util.ArrayMap;
import android.util.Pair;
import androidx.annotation.RequiresApi;
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

@RequiresApi(api = 21)
/* renamed from: com.bytedance.pangle.g.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6132b {

    /* renamed from: com.bytedance.pangle.g.b$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6133a {

        /* renamed from: a */
        public final X509Certificate[][] f22015a;

        /* renamed from: b */
        public final byte[] f22016b;

        public C6133a(X509Certificate[][] x509CertificateArr, byte[] bArr) {
            this.f22015a = x509CertificateArr;
            this.f22016b = bArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C6133a m37137a(RandomAccessFile randomAccessFile, C6151m c6151m) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer m37123a = C6140f.m37123a(c6151m.f22037a);
                int i = 0;
                while (m37123a.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(m37135a(C6140f.m37123a(m37123a), arrayMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i > 0) {
                    if (!arrayMap.isEmpty()) {
                        C6140f.m37120a(arrayMap, randomAccessFile, c6151m);
                        return new C6133a((X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()]), arrayMap.containsKey(3) ? C6140f.m37119a((byte[]) arrayMap.get(3), randomAccessFile.length(), c6151m) : null);
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("No signers found");
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }

    /* renamed from: a */
    private static X509Certificate[] m37135a(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) {
        int m37127a;
        ByteBuffer m37123a = C6140f.m37123a(byteBuffer);
        ByteBuffer m37123a2 = C6140f.m37123a(byteBuffer);
        byte[] m37116b = C6140f.m37116b(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        byte[] bArr2 = null;
        int i = -1;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (!m37123a2.hasRemaining()) {
                if (i == -1) {
                    if (i2 == 0) {
                        throw new SecurityException("No signatures found");
                    }
                    throw new SecurityException("No supported signatures found");
                }
                String m37114c = C6140f.m37114c(i);
                Pair<String, ? extends AlgorithmParameterSpec> m37113d = C6140f.m37113d(i);
                String str = (String) m37113d.first;
                AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) m37113d.second;
                try {
                    PublicKey generatePublic = KeyFactory.getInstance(m37114c).generatePublic(new X509EncodedKeySpec(m37116b));
                    Signature signature = Signature.getInstance(str);
                    signature.initVerify(generatePublic);
                    if (algorithmParameterSpec != null) {
                        signature.setParameter(algorithmParameterSpec);
                    }
                    signature.update(m37123a);
                    if (signature.verify(bArr2)) {
                        m37123a.clear();
                        ByteBuffer m37123a3 = C6140f.m37123a(m37123a);
                        ArrayList arrayList2 = new ArrayList();
                        int i3 = 0;
                        while (m37123a3.hasRemaining()) {
                            i3++;
                            try {
                                ByteBuffer m37123a4 = C6140f.m37123a(m37123a3);
                                if (m37123a4.remaining() >= 8) {
                                    int i4 = m37123a4.getInt();
                                    arrayList2.add(Integer.valueOf(i4));
                                    if (i4 == i) {
                                        bArr = C6140f.m37116b(m37123a4);
                                    }
                                } else {
                                    throw new IOException("Record too short");
                                }
                            } catch (IOException | BufferUnderflowException e) {
                                throw new IOException("Failed to parse digest record #".concat(String.valueOf(i3)), e);
                            }
                        }
                        if (arrayList.equals(arrayList2)) {
                            byte[] put = map.put(Integer.valueOf(C6140f.m37127a(i)), bArr);
                            if (put != null && !MessageDigest.isEqual(put, bArr)) {
                                throw new SecurityException(C6140f.m37117b(m37127a) + " contents digest does not match the digest specified by a preceding signer");
                            }
                            ByteBuffer m37123a5 = C6140f.m37123a(m37123a);
                            ArrayList arrayList3 = new ArrayList();
                            int i5 = 0;
                            while (m37123a5.hasRemaining()) {
                                i5++;
                                byte[] m37116b2 = C6140f.m37116b(m37123a5);
                                try {
                                    arrayList3.add(new C6154p((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(m37116b2)), m37116b2));
                                } catch (CertificateException e2) {
                                    throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i5)), e2);
                                }
                            }
                            if (!arrayList3.isEmpty()) {
                                if (Arrays.equals(m37116b, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                                    m37136a(C6140f.m37123a(m37123a));
                                    return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                                }
                                throw new SecurityException("Public key mismatch between certificate and signature record");
                            }
                            throw new SecurityException("No certificates listed");
                        }
                        throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                    }
                    throw new SecurityException(str + " signature did not verify");
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e3) {
                    throw new SecurityException("Failed to verify " + str + " signature", e3);
                }
            }
            i2++;
            try {
                ByteBuffer m37123a6 = C6140f.m37123a(m37123a2);
                if (m37123a6.remaining() >= 8) {
                    int i6 = m37123a6.getInt();
                    arrayList.add(Integer.valueOf(i6));
                    if (i6 != 513 && i6 != 514 && i6 != 769 && i6 != 1057 && i6 != 1059 && i6 != 1061) {
                        switch (i6) {
                            case 257:
                            case 258:
                            case 259:
                            case 260:
                                break;
                            default:
                                z = false;
                                break;
                        }
                    }
                    if (z && (i == -1 || C6140f.m37126a(i6, i) > 0)) {
                        bArr2 = C6140f.m37116b(m37123a6);
                        i = i6;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e4) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i2)), e4);
            }
        }
    }

    /* renamed from: a */
    private static void m37136a(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            ByteBuffer m37123a = C6140f.m37123a(byteBuffer);
            if (m37123a.remaining() >= 4) {
                if (m37123a.getInt() == -1091571699) {
                    if (m37123a.remaining() >= 4) {
                        if (m37123a.getInt() == 3) {
                            throw new SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
                        }
                    } else {
                        throw new IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + m37123a.remaining());
                    }
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + m37123a.remaining());
            }
        }
    }
}
