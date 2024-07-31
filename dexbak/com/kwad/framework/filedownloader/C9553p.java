package com.kwad.framework.filedownloader;

import android.os.IBinder;
import android.os.RemoteException;
import com.kwad.framework.filedownloader.message.C9532e;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.p350c.InterfaceC9453a;
import com.kwad.framework.filedownloader.p350c.InterfaceC9456b;
import com.kwad.framework.filedownloader.p351d.C9462b;
import com.kwad.framework.filedownloader.p353f.C9489a;
import com.kwad.framework.filedownloader.services.AbstractServiceConnectionC9564a;

/* renamed from: com.kwad.framework.filedownloader.p */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C9553p extends AbstractServiceConnectionC9564a<BinderC9554a, InterfaceC9456b> {

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.kwad.framework.filedownloader.p$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class BinderC9554a extends InterfaceC9453a.AbstractBinderC9454a {
        protected BinderC9554a() {
        }

        @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9453a
        /* renamed from: q */
        public final void mo28432q(MessageSnapshot messageSnapshot) {
            C9532e.m28463wf().m28464s(messageSnapshot);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C9553p(Class<?> cls) {
        super(cls);
    }

    /* renamed from: uQ */
    private static BinderC9554a m28433uQ() {
        return new BinderC9554a();
    }

    @Override // com.kwad.framework.filedownloader.services.AbstractServiceConnectionC9564a
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo28411a(InterfaceC9456b interfaceC9456b, BinderC9554a binderC9554a) {
        m28434a(interfaceC9456b, binderC9554a);
    }

    @Override // com.kwad.framework.filedownloader.services.AbstractServiceConnectionC9564a
    /* renamed from: b */
    public final /* synthetic */ InterfaceC9456b mo28410b(IBinder iBinder) {
        return m28435a(iBinder);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9577u
    /* renamed from: bd */
    public final boolean mo28337bd(int i) {
        if (!isConnected()) {
            return C9489a.m28558bd(i);
        }
        try {
            return m28407wq().mo28385bd(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9577u
    /* renamed from: be */
    public final byte mo28336be(int i) {
        if (!isConnected()) {
            return C9489a.m28557be(i);
        }
        try {
            return m28407wq().mo28384be(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return (byte) 0;
        }
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9577u
    /* renamed from: bf */
    public final boolean mo28335bf(int i) {
        if (!isConnected()) {
            return C9489a.m28556bf(i);
        }
        try {
            return m28407wq().mo28383bf(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.kwad.framework.filedownloader.services.AbstractServiceConnectionC9564a
    /* renamed from: uR */
    public final /* synthetic */ BinderC9554a mo28408uR() {
        return m28433uQ();
    }

    /* renamed from: a */
    private static InterfaceC9456b m28435a(IBinder iBinder) {
        return InterfaceC9456b.AbstractBinderC9457a.m28717a(iBinder);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m28434a(InterfaceC9456b interfaceC9456b, BinderC9554a binderC9554a) {
        interfaceC9456b.mo28388a(binderC9554a);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9577u
    /* renamed from: a */
    public final boolean mo28339a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, C9462b c9462b, boolean z3) {
        if (!isConnected()) {
            return C9489a.m28555h(str, str2, z);
        }
        try {
            m28407wq().mo28386b(str, str2, z, i, i2, i3, z2, c9462b, z3);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
