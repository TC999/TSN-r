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
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@RequiresApi(api = 21)
/* renamed from: com.bytedance.pangle.g.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6134c {

    /* renamed from: com.bytedance.pangle.g.c$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static class C6135a extends Exception {
    }

    /* renamed from: com.bytedance.pangle.g.c$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6136b {

        /* renamed from: a */
        public final List<X509Certificate> f22017a;

        /* renamed from: b */
        public final List<Integer> f22018b;

        public C6136b(List<X509Certificate> list, List<Integer> list2) {
            this.f22017a = list;
            this.f22018b = list2;
        }
    }

    /* renamed from: com.bytedance.pangle.g.c$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6137c {

        /* renamed from: a */
        public final X509Certificate[] f22019a;

        /* renamed from: b */
        public final C6136b f22020b;

        /* renamed from: c */
        public byte[] f22021c;

        public C6137c(X509Certificate[] x509CertificateArr, C6136b c6136b) {
            this.f22019a = x509CertificateArr;
            this.f22020b = c6136b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C6137c m37134a(RandomAccessFile randomAccessFile, C6151m c6151m) {
        ArrayMap arrayMap = new ArrayMap();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer m37123a = C6140f.m37123a(c6151m.f22037a);
                int i = 0;
                C6137c c6137c = null;
                while (m37123a.hasRemaining()) {
                    try {
                        c6137c = m37131a(C6140f.m37123a(m37123a), arrayMap, certificateFactory);
                        i++;
                    } catch (C6135a unused) {
                    } catch (IOException e) {
                        e = e;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (SecurityException e2) {
                        e = e2;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (BufferUnderflowException e3) {
                        e = e3;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i <= 0 || c6137c == null) {
                    throw new SecurityException("No signers found");
                }
                if (i == 1) {
                    if (!arrayMap.isEmpty()) {
                        C6140f.m37120a(arrayMap, randomAccessFile, c6151m);
                        if (arrayMap.containsKey(3)) {
                            c6137c.f22021c = C6140f.m37119a((byte[]) arrayMap.get(3), randomAccessFile.length(), c6151m);
                        }
                        return c6137c;
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
            } catch (IOException e4) {
                throw new SecurityException("Failed to read list of signers", e4);
            }
        } catch (CertificateException e5) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e5);
        }
    }

    /* renamed from: a */
    private static C6137c m37131a(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) {
        ByteBuffer m37123a = C6140f.m37123a(byteBuffer);
        int i = byteBuffer.getInt();
        int i2 = byteBuffer.getInt();
        ByteBuffer m37123a2 = C6140f.m37123a(byteBuffer);
        byte[] m37116b = C6140f.m37116b(byteBuffer);
        ArrayList arrayList = new ArrayList();
        int i3 = -1;
        int i4 = 0;
        byte[] bArr = null;
        while (true) {
            int i5 = 8;
            boolean z = true;
            if (!m37123a2.hasRemaining()) {
                if (i3 == -1) {
                    if (i4 == 0) {
                        throw new SecurityException("No signatures found");
                    }
                    throw new SecurityException("No supported signatures found");
                }
                String m37114c = C6140f.m37114c(i3);
                Pair<String, ? extends AlgorithmParameterSpec> m37113d = C6140f.m37113d(i3);
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
                    if (signature.verify(bArr)) {
                        m37123a.clear();
                        ByteBuffer m37123a3 = C6140f.m37123a(m37123a);
                        ArrayList arrayList2 = new ArrayList();
                        byte[] bArr2 = null;
                        int i6 = 0;
                        while (m37123a3.hasRemaining()) {
                            i6++;
                            try {
                                ByteBuffer m37123a4 = C6140f.m37123a(m37123a3);
                                if (m37123a4.remaining() >= i5) {
                                    int i7 = m37123a4.getInt();
                                    arrayList2.add(Integer.valueOf(i7));
                                    if (i7 == i3) {
                                        bArr2 = C6140f.m37116b(m37123a4);
                                    }
                                    i5 = 8;
                                } else {
                                    throw new IOException("Record too short");
                                }
                            } catch (IOException | BufferUnderflowException e) {
                                throw new IOException("Failed to parse digest record #".concat(String.valueOf(i6)), e);
                            }
                        }
                        if (arrayList.equals(arrayList2)) {
                            int m37127a = C6140f.m37127a(i3);
                            byte[] put = map.put(Integer.valueOf(m37127a), bArr2);
                            if (put != null && !MessageDigest.isEqual(put, bArr2)) {
                                throw new SecurityException(C6140f.m37117b(m37127a) + " contents digest does not match the digest specified by a preceding signer");
                            }
                            ByteBuffer m37123a5 = C6140f.m37123a(m37123a);
                            ArrayList arrayList3 = new ArrayList();
                            int i8 = 0;
                            while (m37123a5.hasRemaining()) {
                                i8++;
                                byte[] m37116b2 = C6140f.m37116b(m37123a5);
                                try {
                                    arrayList3.add(new C6154p((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(m37116b2)), m37116b2));
                                } catch (CertificateException e2) {
                                    throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i8)), e2);
                                }
                            }
                            if (!arrayList3.isEmpty()) {
                                if (Arrays.equals(m37116b, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                                    if (m37123a.getInt() == i) {
                                        if (m37123a.getInt() == i2) {
                                            return m37132a(C6140f.m37123a(m37123a), arrayList3, certificateFactory);
                                        }
                                        throw new SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
                                    }
                                    throw new SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
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
            i4++;
            try {
                ByteBuffer m37123a6 = C6140f.m37123a(m37123a2);
                if (m37123a6.remaining() >= 8) {
                    int i9 = m37123a6.getInt();
                    arrayList.add(Integer.valueOf(i9));
                    if (i9 != 513 && i9 != 514 && i9 != 769 && i9 != 1057 && i9 != 1059 && i9 != 1061) {
                        switch (i9) {
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
                    if (z && (i3 == -1 || C6140f.m37126a(i9, i3) > 0)) {
                        bArr = C6140f.m37116b(m37123a6);
                        i3 = i9;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e4) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i4)), e4);
            }
        }
    }

    /* renamed from: a */
    private static C6137c m37132a(ByteBuffer byteBuffer, List<X509Certificate> list, CertificateFactory certificateFactory) {
        X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
        C6136b c6136b = null;
        while (byteBuffer.hasRemaining()) {
            ByteBuffer m37123a = C6140f.m37123a(byteBuffer);
            if (m37123a.remaining() >= 4) {
                if (m37123a.getInt() == 1000370060) {
                    if (c6136b == null) {
                        c6136b = m37133a(m37123a, certificateFactory);
                        try {
                            if (c6136b.f22017a.size() > 0) {
                                List<X509Certificate> list2 = c6136b.f22017a;
                                if (!Arrays.equals(list2.get(list2.size() - 1).getEncoded(), x509CertificateArr[0].getEncoded())) {
                                    throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                                }
                            } else {
                                continue;
                            }
                        } catch (CertificateEncodingException e) {
                            throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e);
                        }
                    } else {
                        throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                    }
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + m37123a.remaining());
            }
        }
        return new C6137c(x509CertificateArr, c6136b);
    }

    /* renamed from: a */
    private static C6136b m37133a(ByteBuffer byteBuffer, CertificateFactory certificateFactory) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        try {
            byteBuffer.getInt();
            HashSet hashSet = new HashSet();
            int i2 = -1;
            C6154p c6154p = null;
            while (byteBuffer.hasRemaining()) {
                i++;
                ByteBuffer m37123a = C6140f.m37123a(byteBuffer);
                ByteBuffer m37123a2 = C6140f.m37123a(m37123a);
                int i3 = m37123a.getInt();
                int i4 = m37123a.getInt();
                byte[] m37116b = C6140f.m37116b(m37123a);
                if (c6154p != null) {
                    Pair<String, ? extends AlgorithmParameterSpec> m37113d = C6140f.m37113d(i2);
                    PublicKey publicKey = c6154p.getPublicKey();
                    Signature signature = Signature.getInstance((String) m37113d.first);
                    signature.initVerify(publicKey);
                    Object obj = m37113d.second;
                    if (obj != null) {
                        signature.setParameter((AlgorithmParameterSpec) obj);
                    }
                    signature.update(m37123a2);
                    if (!signature.verify(m37116b)) {
                        throw new SecurityException("Unable to verify signature of certificate #" + i + " using " + ((String) m37113d.first) + " when verifying Proof-of-rotation record");
                    }
                }
                m37123a2.rewind();
                byte[] m37116b2 = C6140f.m37116b(m37123a2);
                int i5 = m37123a2.getInt();
                if (c6154p != null && i2 != i5) {
                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + i + " when verifying Proof-of-rotation record");
                }
                c6154p = new C6154p((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(m37116b2)), m37116b2);
                if (!hashSet.contains(c6154p)) {
                    hashSet.add(c6154p);
                    arrayList.add(c6154p);
                    arrayList2.add(Integer.valueOf(i3));
                    i2 = i4;
                } else {
                    throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + i + ".  All signing certificates should be unique");
                }
            }
            return new C6136b(arrayList, arrayList2);
        } catch (IOException e) {
            e = e;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (BufferUnderflowException e2) {
            e = e2;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (InvalidAlgorithmParameterException e3) {
            e = e3;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (InvalidKeyException e4) {
            e = e4;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (NoSuchAlgorithmException e5) {
            e = e5;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (SignatureException e6) {
            e = e6;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (CertificateException e7) {
            throw new SecurityException("Failed to decode certificate #0 when verifying Proof-of-rotation record", e7);
        }
    }
}
