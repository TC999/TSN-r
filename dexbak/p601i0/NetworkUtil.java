package p601i0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.stub.StubApp;

/* renamed from: i0.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class NetworkUtil {

    /* renamed from: a */
    public static final int f40170a = 0;

    /* renamed from: b */
    public static final int f40171b = 1;

    /* renamed from: c */
    public static final int f40172c = 2;

    /* renamed from: d */
    public static final int f40173d = 3;

    /* renamed from: e */
    public static final int f40174e = 4;

    /* renamed from: f */
    public static final int f40175f = -1;

    /* renamed from: a */
    public static int m12716a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return 0;
        }
        if (activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 9) {
                return 2;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 3;
            }
            if (activeNetworkInfo.getType() == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        return 4;
                    default:
                        return -1;
                }
            }
            return -1;
        }
        return 1;
    }
}
