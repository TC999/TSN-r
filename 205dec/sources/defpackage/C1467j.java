package defpackage;

import UkJkysonJaAT.ySJi.jKGV.o.BridgeService;
import android.os.IBinder;
import android.util.Log;

/* renamed from: j  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C1467j implements IBinder.DeathRecipient {
    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        BridgeService.f62a.unlinkToDeath(this, 0);
        BridgeService.f62a = null;
        BridgeService.f63b = null;
        Log.e("LSPosed Bridge", "service is dead");
    }
}
