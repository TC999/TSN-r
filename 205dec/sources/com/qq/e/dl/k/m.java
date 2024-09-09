package com.qq.e.dl.k;

import java.util.List;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static a f47028a;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface a {
        Object a(JSONObject jSONObject, List<f> list);
    }

    public static void a(a aVar) {
        f47028a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(JSONObject jSONObject, List<f> list) {
        a aVar = f47028a;
        if (aVar == null) {
            return null;
        }
        return aVar.a(jSONObject, list);
    }
}
