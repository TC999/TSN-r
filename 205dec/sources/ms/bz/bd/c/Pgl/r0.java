package ms.bz.bd.c.Pgl;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
class r0 implements Comparator<Object> {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int abs = Math.abs(((ScanResult) obj).level);
        int abs2 = Math.abs(((ScanResult) obj2).level);
        if (abs > abs2) {
            return 1;
        }
        return abs == abs2 ? 0 : -1;
    }
}
