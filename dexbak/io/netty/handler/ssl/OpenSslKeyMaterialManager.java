package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509KeyManager;
import javax.security.auth.x500.X500Principal;
import org.apache.tomcat.jni.CertificateRequestedCallback;
import org.apache.tomcat.jni.SSL;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class OpenSslKeyMaterialManager {
    private static final Map<String, String> KEY_TYPES;
    static final String KEY_TYPE_DH_RSA = "DH_RSA";
    static final String KEY_TYPE_EC = "EC";
    static final String KEY_TYPE_EC_EC = "EC_EC";
    static final String KEY_TYPE_EC_RSA = "EC_RSA";
    static final String KEY_TYPE_RSA = "RSA";
    private final X509KeyManager keyManager;
    private final String password;

    static {
        HashMap hashMap = new HashMap();
        KEY_TYPES = hashMap;
        hashMap.put(KEY_TYPE_RSA, KEY_TYPE_RSA);
        hashMap.put("DHE_RSA", KEY_TYPE_RSA);
        hashMap.put("ECDHE_RSA", KEY_TYPE_RSA);
        hashMap.put("ECDHE_ECDSA", KEY_TYPE_EC);
        hashMap.put("ECDH_RSA", KEY_TYPE_EC_RSA);
        hashMap.put("ECDH_ECDSA", KEY_TYPE_EC_EC);
        hashMap.put(KEY_TYPE_DH_RSA, KEY_TYPE_DH_RSA);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSslKeyMaterialManager(X509KeyManager x509KeyManager, String str) {
        this.keyManager = x509KeyManager;
        this.password = str;
    }

    protected String chooseClientAlias(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String[] strArr, X500Principal[] x500PrincipalArr) {
        return this.keyManager.chooseClientAlias(strArr, x500PrincipalArr, null);
    }

    protected String chooseServerAlias(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String str) {
        return this.keyManager.chooseServerAlias(str, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CertificateRequestedCallback.KeyMaterial keyMaterial(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String[] strArr, X500Principal[] x500PrincipalArr) throws SSLException {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        CertificateRequestedCallback.KeyMaterial keyMaterial;
        long bio;
        String chooseClientAlias = chooseClientAlias(referenceCountedOpenSslEngine, strArr, x500PrincipalArr);
        long j6 = 0;
        try {
            try {
                X509Certificate[] certificateChain = this.keyManager.getCertificateChain(chooseClientAlias);
                if (certificateChain != null && certificateChain.length != 0) {
                    PrivateKey privateKey = this.keyManager.getPrivateKey(chooseClientAlias);
                    j = ReferenceCountedOpenSslContext.toBIO(certificateChain);
                    try {
                        j2 = SSL.parseX509Chain(j);
                        if (privateKey != null) {
                            try {
                                bio = ReferenceCountedOpenSslContext.toBIO(privateKey);
                            } catch (SSLException e) {
                                e = e;
                                throw e;
                            } catch (Exception e2) {
                                e = e2;
                                throw new SSLException(e);
                            } catch (Throwable th) {
                                th = th;
                                j5 = 0;
                                ReferenceCountedOpenSslContext.freeBio(j6);
                                ReferenceCountedOpenSslContext.freeBio(j);
                                SSL.freePrivateKey(j5);
                                SSL.freeX509Chain(j2);
                                throw th;
                            }
                            try {
                                j5 = SSL.parsePrivateKey(bio, this.password);
                            } catch (SSLException e3) {
                                e = e3;
                                throw e;
                            } catch (Exception e4) {
                                e = e4;
                                throw new SSLException(e);
                            } catch (Throwable th2) {
                                th = th2;
                                j5 = 0;
                                j6 = bio;
                                ReferenceCountedOpenSslContext.freeBio(j6);
                                ReferenceCountedOpenSslContext.freeBio(j);
                                SSL.freePrivateKey(j5);
                                SSL.freeX509Chain(j2);
                                throw th;
                            }
                        } else {
                            bio = 0;
                            j5 = 0;
                        }
                    } catch (SSLException e5) {
                        e = e5;
                        j4 = 0;
                        throw e;
                    } catch (Exception e6) {
                        e = e6;
                        j3 = 0;
                        throw new SSLException(e);
                    } catch (Throwable th3) {
                        th = th3;
                        j2 = 0;
                        j5 = j2;
                        ReferenceCountedOpenSslContext.freeBio(j6);
                        ReferenceCountedOpenSslContext.freeBio(j);
                        SSL.freePrivateKey(j5);
                        SSL.freeX509Chain(j2);
                        throw th;
                    }
                    try {
                        keyMaterial = new CertificateRequestedCallback.KeyMaterial(j2, j5);
                        ReferenceCountedOpenSslContext.freeBio(bio);
                        ReferenceCountedOpenSslContext.freeBio(j);
                        SSL.freePrivateKey(0L);
                        SSL.freeX509Chain(0L);
                        return keyMaterial;
                    } catch (SSLException e7) {
                        e = e7;
                        throw e;
                    } catch (Exception e8) {
                        e = e8;
                        throw new SSLException(e);
                    } catch (Throwable th4) {
                        th = th4;
                        j6 = bio;
                        ReferenceCountedOpenSslContext.freeBio(j6);
                        ReferenceCountedOpenSslContext.freeBio(j);
                        SSL.freePrivateKey(j5);
                        SSL.freeX509Chain(j2);
                        throw th;
                    }
                }
                keyMaterial = null;
                ReferenceCountedOpenSslContext.freeBio(0L);
                ReferenceCountedOpenSslContext.freeBio(0L);
                SSL.freePrivateKey(0L);
                SSL.freeX509Chain(0L);
                return keyMaterial;
            } catch (SSLException e9) {
                e = e9;
                j4 = 0;
            } catch (Exception e10) {
                e = e10;
                j3 = 0;
            } catch (Throwable th5) {
                th = th5;
                j = 0;
                j2 = 0;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setKeyMaterial(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine) throws SSLException {
        String chooseServerAlias;
        long sslPointer = referenceCountedOpenSslEngine.sslPointer();
        String[] authenticationMethods = SSL.authenticationMethods(sslPointer);
        HashSet hashSet = new HashSet(authenticationMethods.length);
        for (String str : authenticationMethods) {
            String str2 = KEY_TYPES.get(str);
            if (str2 != null && (chooseServerAlias = chooseServerAlias(referenceCountedOpenSslEngine, str2)) != null && hashSet.add(chooseServerAlias)) {
                setKeyMaterial(sslPointer, chooseServerAlias);
            }
        }
    }

    private void setKeyMaterial(long j, String str) throws SSLException {
        long j2 = 0;
        try {
            try {
                X509Certificate[] certificateChain = this.keyManager.getCertificateChain(str);
                if (certificateChain != null && certificateChain.length != 0) {
                    try {
                        PrivateKey privateKey = this.keyManager.getPrivateKey(str);
                        ByteBufAllocator byteBufAllocator = ByteBufAllocator.DEFAULT;
                        PemEncoded pem = PemX509Certificate.toPEM(byteBufAllocator, true, certificateChain);
                        try {
                            long bio = ReferenceCountedOpenSslContext.toBIO(byteBufAllocator, pem.retain());
                            try {
                                long bio2 = ReferenceCountedOpenSslContext.toBIO(byteBufAllocator, pem.retain());
                                if (privateKey != null) {
                                    try {
                                        j2 = ReferenceCountedOpenSslContext.toBIO(privateKey);
                                    } catch (Throwable th) {
                                        th = th;
                                        pem.release();
                                        throw th;
                                    }
                                }
                                SSL.setCertificateBio(j, bio, j2, this.password);
                                SSL.setCertificateChainBio(j, bio2, false);
                                pem.release();
                                ReferenceCountedOpenSslContext.freeBio(j2);
                                ReferenceCountedOpenSslContext.freeBio(bio);
                                ReferenceCountedOpenSslContext.freeBio(bio2);
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (SSLException e) {
                        throw e;
                    } catch (Exception e2) {
                        e = e2;
                        throw new SSLException(e);
                    }
                }
                ReferenceCountedOpenSslContext.freeBio(0L);
                ReferenceCountedOpenSslContext.freeBio(0L);
                ReferenceCountedOpenSslContext.freeBio(0L);
            } catch (SSLException e3) {
                throw e3;
            } catch (Exception e4) {
                e = e4;
            } catch (Throwable th4) {
                th = th4;
                ReferenceCountedOpenSslContext.freeBio(0L);
                ReferenceCountedOpenSslContext.freeBio(0L);
                ReferenceCountedOpenSslContext.freeBio(0L);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            ReferenceCountedOpenSslContext.freeBio(0L);
            ReferenceCountedOpenSslContext.freeBio(0L);
            ReferenceCountedOpenSslContext.freeBio(0L);
            throw th;
        }
    }
}
