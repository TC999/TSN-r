package cn.jiguang.af;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {
    public static List<cn.jiguang.ad.c> a(String str, String str2, String str3, int i4) {
        List<cn.jiguang.ad.c> list;
        cn.jiguang.ad.c cVar = new cn.jiguang.ad.c();
        cVar.f2094a = str2;
        cVar.f2095b = str3;
        if (str == null || TextUtils.isEmpty(str)) {
            list = null;
        } else {
            list = c.a(str);
            cn.jiguang.w.a.b("JWakePackageHelper", "cache cmd wakeTargets:" + list);
        }
        if (list != null && !list.isEmpty()) {
            int size = list.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (list.get(size).f2094a.equals(str2) && list.get(size).f2095b.equals(str3)) {
                        list.remove(size);
                        break;
                    }
                    size--;
                } else {
                    break;
                }
            }
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (i4 == 1) {
            list.add(cVar);
        }
        return list;
    }
}
