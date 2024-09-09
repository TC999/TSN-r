package com.kwad.framework.filedownloader;

import android.os.IBinder;
import android.os.RemoteException;
import com.kwad.framework.filedownloader.c.a;
import com.kwad.framework.filedownloader.c.b;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class p extends com.kwad.framework.filedownloader.services.a<a, com.kwad.framework.filedownloader.c.b> {

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a extends a.AbstractBinderC0669a {
        protected a() {
        }

        @Override // com.kwad.framework.filedownloader.c.a
        public final void q(MessageSnapshot messageSnapshot) {
            com.kwad.framework.filedownloader.message.e.wf().s(messageSnapshot);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Class<?> cls) {
        super(cls);
    }

    private static a uQ() {
        return new a();
    }

    @Override // com.kwad.framework.filedownloader.services.a
    public final /* bridge */ /* synthetic */ void a(com.kwad.framework.filedownloader.c.b bVar, a aVar) {
        a2(bVar, aVar);
    }

    @Override // com.kwad.framework.filedownloader.services.a
    public final /* synthetic */ com.kwad.framework.filedownloader.c.b b(IBinder iBinder) {
        return a(iBinder);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bd(int i4) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.bd(i4);
        }
        try {
            return wq().bd(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte be(int i4) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.be(i4);
        }
        try {
            return wq().be(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return (byte) 0;
        }
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bf(int i4) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.bf(i4);
        }
        try {
            return wq().bf(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.kwad.framework.filedownloader.services.a
    public final /* synthetic */ a uR() {
        return uQ();
    }

    private static com.kwad.framework.filedownloader.c.b a(IBinder iBinder) {
        return b.a.a(iBinder);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.framework.filedownloader.c.b bVar, a aVar) {
        bVar.a(aVar);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z3, int i4, int i5, int i6, boolean z4, com.kwad.framework.filedownloader.d.b bVar, boolean z5) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.h(str, str2, z3);
        }
        try {
            wq().b(str, str2, z3, i4, i5, i6, z4, bVar, z5);
            return true;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }
}
