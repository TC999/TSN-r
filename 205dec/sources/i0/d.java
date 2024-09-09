package i0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.stub.StubApp;

/* compiled from: NetworkUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final int f54754a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f54755b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f54756c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f54757d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f54758e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final int f54759f = -1;

    public static int a(Context context) {
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
