package com.qq.e.comm.plugin.util.x2;

import android.os.Build;
import android.util.ArrayMap;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.plugin.util.x2.b;
import com.qq.e.comm.plugin.util.x2.c;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private final RandomAccessFile f46710a;

    /* renamed from: b  reason: collision with root package name */
    private int f46711b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f46712c;

    /* renamed from: d  reason: collision with root package name */
    private int f46713d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.util.x2.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class C0908a extends Exception {
        C0908a(String str) {
            super(str);
        }
    }

    private a(RandomAccessFile randomAccessFile, boolean z3) {
        this.f46710a = randomAccessFile;
    }

    public static c.a a(RandomAccessFile randomAccessFile, boolean z3) throws e, SecurityException, IOException {
        return (c.a) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, 1, randomAccessFile, Boolean.valueOf(z3));
    }

    static byte[] b(ByteBuffer byteBuffer) throws IOException {
        int i4 = byteBuffer.getInt();
        if (i4 >= 0) {
            if (i4 <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i4];
                byteBuffer.get(bArr);
                return bArr;
            }
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i4 + ", available: " + byteBuffer.remaining());
        }
        throw new IOException("Negative length");
    }

    static String c(int i4) {
        if (i4 == 513 || i4 == 514) {
            return "EC";
        }
        if (i4 != 769) {
            if (i4 != 1057) {
                if (i4 != 1059) {
                    if (i4 != 1061) {
                        switch (i4) {
                            case 257:
                            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
                            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
                            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                                return "RSA";
                            default:
                                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i4 & (-1)));
                        }
                    }
                    return "DSA";
                }
                return "EC";
            }
            return "RSA";
        }
        return "DSA";
    }

    static Pair<String, ? extends AlgorithmParameterSpec> d(int i4) {
        if (i4 != 513) {
            if (i4 != 514) {
                if (i4 != 769) {
                    if (i4 != 1057) {
                        if (i4 != 1059) {
                            if (i4 != 1061) {
                                switch (i4) {
                                    case 257:
                                        return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                    case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
                                        return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                    case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
                                        break;
                                    case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                                        return Pair.create("SHA512withRSA", null);
                                    default:
                                        throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i4 & (-1)));
                                }
                            }
                        }
                    }
                    return Pair.create("SHA256withRSA", null);
                }
                return Pair.create("SHA256withDSA", null);
            }
            return Pair.create("SHA512withECDSA", null);
        }
        return Pair.create("SHA256withECDSA", null);
    }

    static boolean e(int i4) {
        if (i4 == 513 || i4 == 514 || i4 == 769 || i4 == 1057 || i4 == 1059 || i4 == 1061) {
            return true;
        }
        switch (i4) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return true;
            default:
                return false;
        }
    }

    static int b(int i4) {
        if (i4 != 513) {
            if (i4 != 514) {
                if (i4 != 769) {
                    if (i4 == 1057 || i4 == 1059 || i4 == 1061) {
                        return 3;
                    }
                    switch (i4) {
                        case 257:
                        case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
                            return 1;
                        case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
                        case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                            return 2;
                        default:
                            throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i4 & (-1)));
                    }
                }
                return 1;
            }
            return 2;
        }
        return 1;
    }

    private static d a(RandomAccessFile randomAccessFile, int i4) throws IOException, e {
        return b.a(randomAccessFile, i4);
    }

    static int b(int i4, int i5) {
        return a(b(i4), b(i5));
    }

    private c.a a(d dVar, int i4) throws SecurityException, IOException, C0908a {
        this.f46713d = i4;
        ArrayMap arrayMap = new ArrayMap();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer a4 = a(dVar.f46719a);
                int i5 = 0;
                Pair<X509Certificate[], b.a> pair = null;
                while (a4.hasRemaining()) {
                    try {
                        pair = a(a(a4), arrayMap, certificateFactory);
                        i5++;
                    } catch (C0908a unused) {
                    } catch (IOException e4) {
                        e = e4;
                        throw new SecurityException("Failed to parse/verify signer #" + i5 + " block", e);
                    } catch (SecurityException e5) {
                        e = e5;
                        throw new SecurityException("Failed to parse/verify signer #" + i5 + " block", e);
                    } catch (BufferUnderflowException e6) {
                        e = e6;
                        throw new SecurityException("Failed to parse/verify signer #" + i5 + " block", e);
                    }
                }
                if (i5 < 1 || pair == null) {
                    if (i4 == -262969152) {
                        throw new SecurityException("No signers found");
                    }
                    throw new C0908a("None of the signers support the current platform version");
                } else if (i5 == 1) {
                    if (!arrayMap.isEmpty()) {
                        return new c.a((X509Certificate[]) pair.first, (b.a) pair.second, arrayMap.containsKey(3) ? b.a(arrayMap.get(3), this.f46710a.getChannel().size(), dVar) : null, arrayMap, i4);
                    }
                    throw new SecurityException("No content digests found");
                } else {
                    throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
                }
            } catch (IOException e7) {
                throw new SecurityException("Failed to read list of signers", e7);
            }
        } catch (CertificateException e8) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e8);
        }
    }

    static ByteBuffer a(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i4 = byteBuffer.getInt();
            if (i4 >= 0) {
                if (i4 <= byteBuffer.remaining()) {
                    return b.b(byteBuffer, i4);
                }
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i4 + ", remaining: " + byteBuffer.remaining());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0066, code lost:
        throw new java.lang.SecurityException("Signature record too short");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.util.Pair<java.security.cert.X509Certificate[], com.qq.e.comm.plugin.util.x2.b.a> a(java.nio.ByteBuffer r17, java.util.Map<java.lang.Integer, byte[]> r18, java.security.cert.CertificateFactory r19) throws java.lang.SecurityException, java.io.IOException, com.qq.e.comm.plugin.util.x2.a.C0908a {
        /*
            Method dump skipped, instructions count: 616
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.util.x2.a.a(java.nio.ByteBuffer, java.util.Map, java.security.cert.CertificateFactory):android.util.Pair");
    }

    private Pair<X509Certificate[], b.a> a(ByteBuffer byteBuffer, List<X509Certificate> list, CertificateFactory certificateFactory) throws IOException, C0908a {
        X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
        b.a aVar = null;
        while (byteBuffer.hasRemaining()) {
            ByteBuffer a4 = a(byteBuffer);
            if (a4.remaining() >= 4) {
                int i4 = a4.getInt();
                if (i4 != -1029262406) {
                    if (i4 != 1000370060) {
                        if (i4 != 1436519170) {
                            continue;
                        } else if (a4.remaining() >= 4) {
                            int i5 = a4.getInt();
                            int i6 = this.f46711b;
                            if (i6 < 0) {
                                throw new SecurityException("Expected a v3.1 signing block targeting SDK version " + i5 + ", but a v3.1 block was not found");
                            } else if (i6 != i5) {
                                throw new SecurityException("Expected a v3.1 signing block targeting SDK version " + i5 + ", but the v3.1 block was targeting " + i6);
                            }
                        } else {
                            throw new IOException("Remaining buffer too short to contain rotation minSdkVersion value. Remaining: " + a4.remaining());
                        }
                    } else if (aVar == null) {
                        aVar = a(a4, certificateFactory);
                        try {
                            if (aVar.f46714a.size() > 0 && !Arrays.equals(aVar.f46714a.get(aVar.f46714a.size() - 1).getEncoded(), x509CertificateArr[0].getEncoded())) {
                                throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                            }
                        } catch (CertificateEncodingException e4) {
                            throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e4);
                        }
                    } else {
                        throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                    }
                } else if (this.f46713d == 462663009 && Build.VERSION.SDK_INT == this.f46712c && "REL".equals(Build.VERSION.CODENAME)) {
                    this.f46711b = this.f46712c;
                    throw new C0908a("The device is running a release version of " + this.f46712c + ", but the signer is targeting a dev release");
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + a4.remaining());
            }
        }
        return Pair.create(x509CertificateArr, aVar);
    }

    private static int a(int i4, int i5) {
        if (i4 == 1) {
            if (i5 != 1) {
                if (i5 == 2 || i5 == 3) {
                    return -1;
                }
                throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i5);
            }
            return 0;
        } else if (i4 == 2) {
            if (i5 != 1) {
                if (i5 == 2) {
                    return 0;
                }
                if (i5 != 3) {
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i5);
                }
            }
            return 1;
        } else if (i4 != 3) {
            throw new IllegalArgumentException("Unknown digestAlgorithm1: " + i4);
        } else if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 3) {
                    return 0;
                }
                throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i5);
            }
            return -1;
        } else {
            return 1;
        }
    }

    static String a(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    return "SHA-256";
                }
                throw new IllegalArgumentException("Unknown content digest algorthm: " + i4);
            }
            return "SHA-512";
        }
        return "SHA-256";
    }

    static b.a a(ByteBuffer byteBuffer, CertificateFactory certificateFactory) throws SecurityException, IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i4 = 0;
        try {
            byteBuffer.getInt();
            HashSet hashSet = new HashSet();
            int i5 = -1;
            f fVar = null;
            while (byteBuffer.hasRemaining()) {
                i4++;
                ByteBuffer a4 = a(byteBuffer);
                ByteBuffer a5 = a(a4);
                int i6 = a4.getInt();
                int i7 = a4.getInt();
                byte[] b4 = b(a4);
                if (fVar != null) {
                    Pair<String, ? extends AlgorithmParameterSpec> d4 = d(i5);
                    PublicKey publicKey = fVar.getPublicKey();
                    Signature signature = Signature.getInstance((String) d4.first);
                    signature.initVerify(publicKey);
                    if (d4.second != null) {
                        signature.setParameter((AlgorithmParameterSpec) d4.second);
                    }
                    signature.update(a5);
                    if (!signature.verify(b4)) {
                        throw new SecurityException("Unable to verify signature of certificate #" + i4 + " using " + ((String) d4.first) + " when verifying Proof-of-rotation record");
                    }
                }
                a5.rewind();
                byte[] b5 = b(a5);
                int i8 = a5.getInt();
                if (fVar != null && i5 != i8) {
                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + i4 + " when verifying Proof-of-rotation record");
                }
                fVar = new f((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(b5)), b5);
                if (!hashSet.contains(fVar)) {
                    hashSet.add(fVar);
                    arrayList.add(fVar);
                    arrayList2.add(Integer.valueOf(i6));
                    i5 = i7;
                } else {
                    throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + i4 + ".  All signing certificates should be unique");
                }
            }
            return new b.a(arrayList, arrayList2);
        } catch (IOException e4) {
            e = e4;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (BufferUnderflowException e5) {
            e = e5;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (InvalidAlgorithmParameterException e6) {
            e = e6;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (InvalidKeyException e7) {
            e = e7;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (NoSuchAlgorithmException e8) {
            e = e8;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (SignatureException e9) {
            e = e9;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (CertificateException e10) {
            throw new SecurityException("Failed to decode certificate #0 when verifying Proof-of-rotation record", e10);
        }
    }
}
