package io.netty.handler.ssl;

import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.internal.tcnative.SSL;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509KeyManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class OpenSslKeyMaterialProvider {
    private final X509KeyManager keyManager;
    private final String password;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSslKeyMaterialProvider(X509KeyManager x509KeyManager, String str) {
        this.keyManager = x509KeyManager;
        this.password = str;
    }

    static void validateKeyMaterialSupported(X509Certificate[] x509CertificateArr, PrivateKey privateKey, String str) throws SSLException {
        validateSupported(x509CertificateArr);
        validateSupported(privateKey, str);
    }

    private static void validateSupported(PrivateKey privateKey, String str) throws SSLException {
        if (privateKey == null) {
            return;
        }
        long j4 = 0;
        try {
            try {
                long bio = ReferenceCountedOpenSslContext.toBIO(UnpooledByteBufAllocator.DEFAULT, privateKey);
                try {
                    long parsePrivateKey = SSL.parsePrivateKey(bio, str);
                    SSL.freeBIO(bio);
                    if (parsePrivateKey != 0) {
                        SSL.freePrivateKey(parsePrivateKey);
                    }
                } catch (Exception e4) {
                    e = e4;
                    throw new SSLException("PrivateKey type not supported " + privateKey.getFormat(), e);
                } catch (Throwable th) {
                    th = th;
                    j4 = bio;
                    SSL.freeBIO(j4);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.netty.handler.ssl.OpenSslKeyMaterial chooseKeyMaterial(io.netty.buffer.ByteBufAllocator r21, java.lang.String r22) throws java.lang.Exception {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            javax.net.ssl.X509KeyManager r3 = r1.keyManager
            java.security.cert.X509Certificate[] r9 = r3.getCertificateChain(r2)
            if (r9 == 0) goto L94
            int r3 = r9.length
            if (r3 != 0) goto L13
            goto L94
        L13:
            javax.net.ssl.X509KeyManager r3 = r1.keyManager
            java.security.PrivateKey r2 = r3.getPrivateKey(r2)
            r3 = 1
            io.netty.handler.ssl.PemEncoded r3 = io.netty.handler.ssl.PemX509Certificate.toPEM(r0, r3, r9)
            r10 = 0
            io.netty.handler.ssl.PemEncoded r4 = r3.retain()     // Catch: java.lang.Throwable -> L76
            long r12 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.toBIO(r0, r4)     // Catch: java.lang.Throwable -> L76
            long r14 = io.netty.internal.tcnative.SSL.parseX509Chain(r12)     // Catch: java.lang.Throwable -> L72
            boolean r4 = r2 instanceof io.netty.handler.ssl.OpenSslPrivateKey     // Catch: java.lang.Throwable -> L6d
            if (r4 == 0) goto L37
            io.netty.handler.ssl.OpenSslPrivateKey r2 = (io.netty.handler.ssl.OpenSslPrivateKey) r2     // Catch: java.lang.Throwable -> L6d
            io.netty.handler.ssl.OpenSslKeyMaterial r0 = r2.newKeyMaterial(r14, r9)     // Catch: java.lang.Throwable -> L6d
            goto L55
        L37:
            long r7 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.toBIO(r0, r2)     // Catch: java.lang.Throwable -> L6d
            if (r2 != 0) goto L40
            r16 = r10
            goto L48
        L40:
            java.lang.String r0 = r1.password     // Catch: java.lang.Throwable -> L67
            long r4 = io.netty.internal.tcnative.SSL.parsePrivateKey(r7, r0)     // Catch: java.lang.Throwable -> L67
            r16 = r4
        L48:
            io.netty.handler.ssl.DefaultOpenSslKeyMaterial r0 = new io.netty.handler.ssl.DefaultOpenSslKeyMaterial     // Catch: java.lang.Throwable -> L63
            r4 = r0
            r5 = r14
            r18 = r7
            r7 = r16
            r4.<init>(r5, r7, r9)     // Catch: java.lang.Throwable -> L5f
            r10 = r18
        L55:
            io.netty.internal.tcnative.SSL.freeBIO(r12)
            io.netty.internal.tcnative.SSL.freeBIO(r10)
            r3.release()
            return r0
        L5f:
            r0 = move-exception
            r7 = r18
            goto L7c
        L63:
            r0 = move-exception
            r18 = r7
            goto L7c
        L67:
            r0 = move-exception
            r18 = r7
            r16 = r10
            goto L7c
        L6d:
            r0 = move-exception
            r7 = r10
            r16 = r7
            goto L7c
        L72:
            r0 = move-exception
            r7 = r10
            r14 = r7
            goto L7a
        L76:
            r0 = move-exception
            r7 = r10
            r12 = r7
            r14 = r12
        L7a:
            r16 = r14
        L7c:
            io.netty.internal.tcnative.SSL.freeBIO(r12)
            io.netty.internal.tcnative.SSL.freeBIO(r7)
            int r2 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r2 == 0) goto L89
            io.netty.internal.tcnative.SSL.freeX509Chain(r14)
        L89:
            int r2 = (r16 > r10 ? 1 : (r16 == r10 ? 0 : -1))
            if (r2 == 0) goto L90
            io.netty.internal.tcnative.SSL.freePrivateKey(r16)
        L90:
            r3.release()
            throw r0
        L94:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.OpenSslKeyMaterialProvider.chooseKeyMaterial(io.netty.buffer.ByteBufAllocator, java.lang.String):io.netty.handler.ssl.OpenSslKeyMaterial");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
    }

    X509KeyManager keyManager() {
        return this.keyManager;
    }

    private static void validateSupported(X509Certificate[] x509CertificateArr) throws SSLException {
        if (x509CertificateArr == null || x509CertificateArr.length == 0) {
            return;
        }
        PemEncoded pemEncoded = null;
        long j4 = 0;
        try {
            try {
                UnpooledByteBufAllocator unpooledByteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
                pemEncoded = PemX509Certificate.toPEM(unpooledByteBufAllocator, true, x509CertificateArr);
                long bio = ReferenceCountedOpenSslContext.toBIO(unpooledByteBufAllocator, pemEncoded.retain());
                try {
                    long parseX509Chain = SSL.parseX509Chain(bio);
                    SSL.freeBIO(bio);
                    if (parseX509Chain != 0) {
                        SSL.freeX509Chain(parseX509Chain);
                    }
                    pemEncoded.release();
                } catch (Exception e4) {
                    e = e4;
                    throw new SSLException("Certificate type not supported", e);
                } catch (Throwable th) {
                    th = th;
                    j4 = bio;
                    SSL.freeBIO(j4);
                    if (pemEncoded != null) {
                        pemEncoded.release();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
