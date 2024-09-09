package ms.bz.bd.c.Pgl;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import com.stub.StubApp;
import ms.bz.bd.c.Pgl.pblb;
import org.json.JSONArray;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class k extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object b(int i4, long j4, String str, Object obj) throws Throwable {
        JSONArray jSONArray = new JSONArray();
        try {
            DhcpInfo dhcpInfo = ((WifiManager) StubApp.getOrigApplicationContext(pgla.a().c().getApplicationContext()).getSystemService((String) pblk.a(16777217, 0, 0L, "e42d12", new byte[]{99, 63, 71, 25}))).getDhcpInfo();
            StringBuilder sb = new StringBuilder();
            sb.append(dhcpInfo.dns1 & 255);
            sb.append((String) pblk.a(16777217, 0, 0L, "35d80f", new byte[]{108}));
            sb.append((dhcpInfo.dns1 >> 8) & 255);
            sb.append((String) pblk.a(16777217, 0, 0L, "30f71c", new byte[]{108}));
            sb.append((dhcpInfo.dns1 >> 16) & 255);
            sb.append((String) pblk.a(16777217, 0, 0L, "2808bb", new byte[]{109}));
            sb.append((dhcpInfo.dns1 >> 24) & 255);
            jSONArray.put(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(dhcpInfo.dns2 & 255);
            sb2.append((String) pblk.a(16777217, 0, 0L, "e09201", new byte[]{58}));
            sb2.append((dhcpInfo.dns2 >> 8) & 255);
            sb2.append((String) pblk.a(16777217, 0, 0L, "8066d1", new byte[]{103}));
            sb2.append((dhcpInfo.dns2 >> 16) & 255);
            sb2.append((String) pblk.a(16777217, 0, 0L, "a56a13", new byte[]{62}));
            sb2.append((dhcpInfo.dns2 >> 24) & 255);
            jSONArray.put(sb2.toString());
        } catch (Throwable unused) {
            String str2 = (String) pblk.a(16777217, 0, 0L, "757e15", new byte[]{43, 62, 76, 46, 10, 46});
        }
        return jSONArray.toString();
    }
}
