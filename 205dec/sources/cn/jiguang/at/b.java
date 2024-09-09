package cn.jiguang.at;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.common.m.f;
import cn.jiguang.common.m.j;
import cn.jiguang.common.n.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private static String f2427a = "/proc/uid_stat";

    /* renamed from: b  reason: collision with root package name */
    private static String f2428b = "tcp_rcv";

    /* renamed from: c  reason: collision with root package name */
    private static String f2429c = "tcp_snd";

    private long a(List<f> list, String str) {
        long j4 = 0;
        if (list != null && !list.isEmpty()) {
            for (f fVar : list) {
                try {
                    if (!TextUtils.isEmpty(fVar.f3516d) && fVar.f3516d.contains(str)) {
                        long j5 = fVar.f3519g;
                        if (j5 > j4) {
                            j4 = j5;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return j4;
    }

    private List<j> b(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        List<f> a4 = e.a(context, 1);
        for (String str : list) {
            long a5 = a(a4, str);
            if (a5 > 0) {
                j jVar = new j();
                jVar.f3538c = str;
                jVar.f3541f = a5;
                arrayList.add(jVar);
            }
        }
        return arrayList;
    }

    @Override // cn.jiguang.at.a
    public HashMap<String, cn.jiguang.common.m.c> a(Context context, List<String> list) {
        List<Integer> list2;
        int i4;
        cn.jiguang.common.m.c cVar;
        HashMap<String, cn.jiguang.common.m.c> hashMap = new HashMap<>();
        if (context != null && list != null) {
            try {
            } catch (Throwable th) {
                cn.jiguang.w.a.f("CollectByTrafficUsage", "get app traffic usage data failed, " + th.getMessage());
            }
            if (!list.isEmpty()) {
                int i5 = Build.VERSION.SDK_INT;
                if (i5 >= 24) {
                    cn.jiguang.w.a.b("CollectByTrafficUsage", "no traffic usage, os_version: " + i5);
                    return hashMap;
                }
                cn.jiguang.w.a.b("CollectByTrafficUsage", "start collect active data by traffic usage, package size: " + list.size());
                List<j> b4 = b(context, list);
                if (b4.isEmpty()) {
                    cn.jiguang.w.a.b("CollectByTrafficUsage", "no traffic usage, os_version: " + i5);
                    return hashMap;
                }
                for (j jVar : b4) {
                    if (!hashMap.containsKey(jVar.f3538c) || (cVar = hashMap.get(jVar.f3538c)) == null || cVar.f3492e.isEmpty() || cVar.f3492e.get(0).longValue() < jVar.f3541f) {
                        if (jVar.f3539d > 0 || jVar.f3540e > 0 || jVar.f3541f > 0) {
                            cn.jiguang.common.m.c cVar2 = new cn.jiguang.common.m.c();
                            cVar2.f3488a = jVar.f3538c;
                            cVar2.f3494g.add(Long.valueOf(jVar.f3539d + jVar.f3540e));
                            cVar2.f3492e.add(Long.valueOf(jVar.f3541f));
                            if (jVar.f3539d <= 0 && jVar.f3540e <= 0) {
                                list2 = cVar2.f3491d;
                                i4 = 4;
                                list2.add(i4);
                                hashMap.put(jVar.f3538c, cVar2);
                            }
                            list2 = cVar2.f3491d;
                            i4 = 2;
                            list2.add(i4);
                            hashMap.put(jVar.f3538c, cVar2);
                        }
                    }
                }
                cn.jiguang.w.a.b("CollectByTrafficUsage", "collect app active data by traffic usage, size: " + hashMap.size());
                return hashMap;
            }
        }
        cn.jiguang.w.a.f("CollectByTrafficUsage", "exception error, null is occur");
        return hashMap;
    }
}
