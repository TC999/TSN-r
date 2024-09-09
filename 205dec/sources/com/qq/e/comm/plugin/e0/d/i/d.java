package com.qq.e.comm.plugin.e0.d.i;

import com.qq.e.comm.plugin.e0.e.e;
import com.qq.e.comm.plugin.util.a1;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.mediation.interfaces.INoticeUrlProvider;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {
    public static void a(e eVar, com.qq.e.comm.plugin.e0.e.d dVar, boolean z3, boolean z4, String str) {
        INoticeUrlProvider a4;
        if (eVar == null || (a4 = a(dVar)) == null) {
            return;
        }
        if (z3) {
            a1.a(a4.getAssembledWinNoticeUrl(eVar.h(), str, z4));
        } else {
            a1.a(a4.getAssembledLossNoticeUrl(eVar.e(), str, z4));
        }
        if (z4) {
            return;
        }
        List<String> d4 = eVar.d();
        for (int i4 = 0; i4 < d4.size(); i4++) {
            a1.a(a4.getOtherAssembledLossNoticeUrl(d4.get(i4), str));
        }
    }

    private static INoticeUrlProvider a(com.qq.e.comm.plugin.e0.e.d dVar) {
        if (dVar == null) {
            return null;
        }
        try {
            String e4 = dVar.e();
            String[] split = e4.split("(\\w+\\.){2}");
            String str = e4.split(split[split.length - 1])[0];
            return (INoticeUrlProvider) Class.forName(str + "util.NoticeUrlProviderImpl").asSubclass(INoticeUrlProvider.class).newInstance();
        } catch (Exception e5) {
            d1.b("getNoticeUrlProvider", e5.toString());
            return null;
        }
    }
}
