package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class j extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object b(int i4, long j4, String str, Object obj) throws Throwable {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    String name = nextElement.getName();
                    if (!TextUtils.isEmpty(name) && !nextElement2.isLoopbackAddress() && (nextElement2 instanceof Inet4Address) && name.startsWith((String) pblk.a(16777217, 0, 0L, "705bc3", new byte[]{52, 63, 72, 19, 72}))) {
                        String str2 = (String) pblk.a(16777217, 0, 0L, "07ed10", new byte[]{40, 59, 19, 4, 47, 35, 55, 4, 49, 39, 50, 117, 24, 17, 3, 34, 105});
                        nextElement.getName();
                        return nextElement.getName();
                    }
                }
            }
            return "";
        } catch (SocketException e4) {
            String str3 = (String) pblk.a(16777217, 0, 0L, "73ee0c", new byte[]{33, 52, 2, 81, 38, 100, 21, 22, 48, 39, 35, 34, 5, 81, 9, 117, 61, 30, 110});
            e4.toString();
            return "";
        }
    }
}
