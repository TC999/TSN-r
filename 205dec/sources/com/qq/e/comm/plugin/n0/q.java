package com.qq.e.comm.plugin.n0;

import com.qq.e.comm.plugin.util.j0;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import yaq.pro;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f44783a = new AtomicInteger(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p a(h hVar) {
        return (p) pro.getobjresult(462, 1, hVar);
    }

    static JSONObject a(List<p> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i4 = 0; i4 < list.size(); i4++) {
            jSONArray.put(new j0(list.get(i4).getContent()).a());
        }
        j0 b4 = k.b();
        b4.a("perfs", jSONArray);
        return b4.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p a(int i4, String str) {
        return new p(i4, str);
    }
}
