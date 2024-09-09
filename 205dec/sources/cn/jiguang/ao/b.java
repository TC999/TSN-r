package cn.jiguang.ao;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final ArrayList<String> f2328a;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f2328a = arrayList;
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        arrayList.add("android.permission.ACCESS_LOCATION_EXTRA_COMMANDS");
        arrayList.add("android.permission.ACCESS_WIFI_STATE");
    }

    public static void a(Context context) {
        Iterator<String> it = f2328a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!cn.jiguang.ag.a.h(context, next)) {
                cn.jiguang.w.a.f("CheckManifestHelper", "We recommend you add the permission - " + next + ", otherwise you can not locate the devices.");
            }
        }
    }
}
