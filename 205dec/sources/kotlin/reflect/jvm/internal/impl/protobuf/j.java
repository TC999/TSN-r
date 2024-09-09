package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* compiled from: LazyFieldLite.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private d f57667a;

    /* renamed from: b  reason: collision with root package name */
    private f f57668b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f57669c;

    /* renamed from: d  reason: collision with root package name */
    protected volatile n f57670d;

    protected void a(n nVar) {
        if (this.f57670d != null) {
            return;
        }
        synchronized (this) {
            if (this.f57670d != null) {
                return;
            }
            try {
                if (this.f57667a != null) {
                    this.f57670d = nVar.getParserForType().b(this.f57667a, this.f57668b);
                } else {
                    this.f57670d = nVar;
                }
            } catch (IOException unused) {
            }
        }
    }

    public int b() {
        if (this.f57669c) {
            return this.f57670d.getSerializedSize();
        }
        return this.f57667a.size();
    }

    public n c(n nVar) {
        a(nVar);
        return this.f57670d;
    }

    public n d(n nVar) {
        n nVar2 = this.f57670d;
        this.f57670d = nVar;
        this.f57667a = null;
        this.f57669c = true;
        return nVar2;
    }
}
