package com.kwad.framework.filedownloader.message;

/* renamed from: com.kwad.framework.filedownloader.message.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9532e {
    private volatile C9536g ahs;
    private volatile InterfaceC9534b aht;

    /* renamed from: com.kwad.framework.filedownloader.message.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9533a {
        private static final C9532e ahu = new C9532e();
    }

    /* renamed from: com.kwad.framework.filedownloader.message.e$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9534b {
        /* renamed from: r */
        void mo28390r(MessageSnapshot messageSnapshot);
    }

    /* renamed from: wf */
    public static C9532e m28463wf() {
        return C9533a.ahu;
    }

    /* renamed from: a */
    public final void m28465a(InterfaceC9534b interfaceC9534b) {
        this.aht = interfaceC9534b;
        if (interfaceC9534b == null) {
            this.ahs = null;
        } else {
            this.ahs = new C9536g(5, interfaceC9534b);
        }
    }

    /* renamed from: s */
    public final void m28464s(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof InterfaceC9519b) {
            if (this.aht != null) {
                this.aht.mo28390r(messageSnapshot);
            }
        } else if (this.ahs != null) {
            this.ahs.m28454u(messageSnapshot);
        }
    }
}
