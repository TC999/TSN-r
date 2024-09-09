package ms.bz.bd.c.Pgl;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.stub.StubApp;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class z extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    protected Object b(int i4, long j4, String str, Object obj) throws Throwable {
        String str2;
        try {
            WifiInfo connectionInfo = ((WifiManager) StubApp.getOrigApplicationContext(pgla.a().c().getApplicationContext()).getSystemService((String) pblk.a(16777217, 0, 0L, "bca795", new byte[]{100, 104, 20, 74}))).getConnectionInfo();
            Method declaredMethod = connectionInfo.getClass().getDeclaredMethod(new String(pbly.d((String) pblk.a(16777217, 0, 0L, "edb459", new byte[]{34, 49, 71, 21, 93, 122, 50, 28, 100, 52, 32, 55, 71, 20, 92, 122, 49, 23, 101, 49, 35, 53, 70, 19}))), new Class[0]);
            declaredMethod.setAccessible(true);
            str2 = Integer.toString(((Integer) declaredMethod.invoke(connectionInfo, new Object[0])).intValue());
        } catch (Throwable unused) {
            str2 = null;
        }
        return TextUtils.isEmpty(str2) ? (String) pblk.a(16777217, 0, 0L, "7f2f1b", new byte[]{118}) : str2.trim();
    }
}
