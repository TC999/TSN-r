package io.netty.handler.ssl;

import javax.net.ssl.X509ExtendedKeyManager;
import javax.security.auth.x500.X500Principal;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class OpenSslExtendedKeyMaterialManager extends OpenSslKeyMaterialManager {
    private final X509ExtendedKeyManager keyManager;

    OpenSslExtendedKeyMaterialManager(X509ExtendedKeyManager x509ExtendedKeyManager, String str) {
        super(x509ExtendedKeyManager, str);
        this.keyManager = x509ExtendedKeyManager;
    }

    @Override // io.netty.handler.ssl.OpenSslKeyMaterialManager
    protected String chooseClientAlias(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String[] strArr, X500Principal[] x500PrincipalArr) {
        return this.keyManager.chooseEngineClientAlias(strArr, x500PrincipalArr, referenceCountedOpenSslEngine);
    }

    @Override // io.netty.handler.ssl.OpenSslKeyMaterialManager
    protected String chooseServerAlias(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String str) {
        return this.keyManager.chooseEngineServerAlias(str, null, referenceCountedOpenSslEngine);
    }
}
