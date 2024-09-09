package ms.bz.bd.c.Pgl;

import android.telephony.TelephonyManager;
import com.stub.StubApp;
import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class m extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object b(int i4, long j4, String str, Object obj) throws Throwable {
        Boolean bool = Boolean.FALSE;
        TelephonyManager telephonyManager = (TelephonyManager) StubApp.getOrigApplicationContext(pgla.a().c().getApplicationContext()).getSystemService((String) pblk.a(16777217, 0, 0L, "4bafad", new byte[]{53, 104, 29, 28, 91}));
        return (telephonyManager == null || telephonyManager.getSimState() != 5) ? bool : Boolean.TRUE;
    }
}
