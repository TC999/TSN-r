package io.netty.handler.ssl.util;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Date;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class BouncyCastleSelfSignedCertGenerator {
    private static final Provider PROVIDER = new BouncyCastleProvider();

    private BouncyCastleSelfSignedCertGenerator() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] generate(String str, KeyPair keyPair, SecureRandom secureRandom, Date date, Date date2) throws Exception {
        PrivateKey privateKey = keyPair.getPrivate();
        X500Name x500Name = new X500Name("CN=" + str);
        X509Certificate certificate = new JcaX509CertificateConverter().setProvider(PROVIDER).getCertificate(new JcaX509v3CertificateBuilder(x500Name, new BigInteger(64, secureRandom), date, date2, x500Name, keyPair.getPublic()).build(new JcaContentSignerBuilder("SHA256WithRSAEncryption").build(privateKey)));
        certificate.verify(keyPair.getPublic());
        return SelfSignedCertificate.newSelfSignedCertificate(str, privateKey, certificate);
    }
}
