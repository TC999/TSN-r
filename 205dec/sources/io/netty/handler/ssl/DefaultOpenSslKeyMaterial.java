package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import java.security.cert.X509Certificate;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
final class DefaultOpenSslKeyMaterial extends AbstractReferenceCounted implements OpenSslKeyMaterial {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ResourceLeakDetector<DefaultOpenSslKeyMaterial> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(DefaultOpenSslKeyMaterial.class);
    private long chain;
    private final ResourceLeakTracker<DefaultOpenSslKeyMaterial> leak = leakDetector.track(this);
    private long privateKey;
    private final X509Certificate[] x509CertificateChain;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultOpenSslKeyMaterial(long j4, long j5, X509Certificate[] x509CertificateArr) {
        this.chain = j4;
        this.privateKey = j5;
        this.x509CertificateChain = x509CertificateArr;
    }

    @Override // io.netty.handler.ssl.OpenSslKeyMaterial
    public X509Certificate[] certificateChain() {
        return (X509Certificate[]) this.x509CertificateChain.clone();
    }

    @Override // io.netty.handler.ssl.OpenSslKeyMaterial
    public long certificateChainAddress() {
        if (refCnt() > 0) {
            return this.chain;
        }
        throw new IllegalReferenceCountException();
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        SSL.freeX509Chain(this.chain);
        this.chain = 0L;
        SSL.freePrivateKey(this.privateKey);
        this.privateKey = 0L;
        ResourceLeakTracker<DefaultOpenSslKeyMaterial> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.close(this);
        }
    }

    @Override // io.netty.handler.ssl.OpenSslKeyMaterial
    public long privateKeyAddress() {
        if (refCnt() > 0) {
            return this.privateKey;
        }
        throw new IllegalReferenceCountException();
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public boolean release() {
        ResourceLeakTracker<DefaultOpenSslKeyMaterial> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record();
        }
        return super.release();
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public boolean release(int i4) {
        ResourceLeakTracker<DefaultOpenSslKeyMaterial> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record();
        }
        return super.release(i4);
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DefaultOpenSslKeyMaterial retain() {
        ResourceLeakTracker<DefaultOpenSslKeyMaterial> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record();
        }
        super.retain();
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DefaultOpenSslKeyMaterial touch() {
        ResourceLeakTracker<DefaultOpenSslKeyMaterial> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record();
        }
        super.touch();
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DefaultOpenSslKeyMaterial retain(int i4) {
        ResourceLeakTracker<DefaultOpenSslKeyMaterial> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record();
        }
        super.retain(i4);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public DefaultOpenSslKeyMaterial touch(Object obj) {
        ResourceLeakTracker<DefaultOpenSslKeyMaterial> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record(obj);
        }
        return this;
    }
}
