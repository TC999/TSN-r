package com.qq.e.comm.plugin.l0;

import com.qq.e.comm.plugin.b.h;
import com.qq.e.comm.plugin.b.m;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f44610a = "imei";

    /* renamed from: b  reason: collision with root package name */
    private static final String f44611b = "index";

    /* renamed from: c  reason: collision with root package name */
    private static final String f44612c = "secLevel";

    /* renamed from: d  reason: collision with root package name */
    private static final String f44613d = "gdtType";

    /* renamed from: e  reason: collision with root package name */
    private static final String f44614e = "trace";

    /* renamed from: f  reason: collision with root package name */
    private static final String f44615f = "dev";

    /* renamed from: g  reason: collision with root package name */
    private static final String f44616g = "plc";

    /* renamed from: h  reason: collision with root package name */
    private static final String f44617h = "biz";

    /* renamed from: i  reason: collision with root package name */
    public static final String f44618i = "https://sdk.e.qq.com";

    /* renamed from: j  reason: collision with root package name */
    public static final String f44619j = "https://sdk.e.qq.com/disp";

    /* renamed from: k  reason: collision with root package name */
    public static final String f44620k = "https://sdk.e.qq.com/click";

    /* renamed from: l  reason: collision with root package name */
    public static final String f44621l = "https://sdk.e.qq.com/msg";

    /* renamed from: m  reason: collision with root package name */
    private static Random f44622m = new Random();

    private static String a(com.qq.e.comm.plugin.g0.e eVar) {
        return (String) pro.getobjresult(486, 1, eVar);
    }

    public static JSONObject a(m mVar) throws JSONException {
        return (JSONObject) pro.getobjresult(487, 1, mVar);
    }

    private static JSONObject a(String str, String str2, Map<String, Object> map) throws JSONException {
        return (JSONObject) pro.getobjresult(488, 1, str, str2, map);
    }

    private static JSONObject a(String str, Map<String, Object> map, h hVar, com.qq.e.comm.plugin.g0.e eVar) throws JSONException {
        return (JSONObject) pro.getobjresult(489, 1, str, map, hVar, eVar);
    }

    public static void a(int i4, JSONObject jSONObject) {
        pro.getVresult(490, 1, Integer.valueOf(i4), jSONObject);
    }

    public static void a(int i4, JSONObject jSONObject, m mVar) {
        pro.getVresult(491, 1, Integer.valueOf(i4), jSONObject, mVar);
    }

    public static void a(int i4, JSONObject jSONObject, m mVar, com.qq.e.comm.plugin.i0.b bVar) {
        pro.getVresult(492, 1, Integer.valueOf(i4), jSONObject, mVar, bVar);
    }

    public static void a(String str, com.qq.e.comm.plugin.g0.e eVar, m mVar, h hVar, Map<String, Object> map) {
        pro.getVresult(493, 1, str, eVar, mVar, hVar, map);
    }

    public static void a(List<String> list, String str, m mVar, Map<String, Object> map, com.qq.e.comm.plugin.i0.b bVar) {
        pro.getVresult(494, 1, list, str, mVar, map, bVar);
    }

    private static void a(JSONObject jSONObject) throws JSONException {
        pro.getVresult(495, 1, jSONObject);
    }
}
