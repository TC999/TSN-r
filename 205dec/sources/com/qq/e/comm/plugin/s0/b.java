package com.qq.e.comm.plugin.s0;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.plugin.g0.k0;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f46025a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f46026b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile Boolean f46027c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile Integer f46028d;

    static {
        f46025a = com.qq.e.comm.plugin.d0.a.d().f().a("iscfwe", 1) == 1;
        f46026b = com.qq.e.comm.plugin.d0.a.d().f().a("gvfwe", 1) == 1;
    }

    private b() {
    }

    public static int a(Context context, String str, String str2) {
        return pro.getIresult(144, 1, context, str, str2);
    }

    private static int a(Context context, String str, String str2, String str3, String str4, int i4) {
        return pro.getIresult(145, 1, context, str, str2, str3, str4, Integer.valueOf(i4));
    }

    private static int a(Context context, String str, String str2, String str3, String str4, boolean z3) {
        return pro.getIresult(146, 1, context, str, str2, str3, str4, Boolean.valueOf(z3));
    }

    private static int a(Context context, String str, String str2, String str3, String str4, byte[] bArr) {
        return pro.getIresult(147, 1, context, str, str2, str3, str4, bArr);
    }

    private static int a(Object obj) {
        return pro.getIresult(148, 1, obj);
    }

    private static int a(Object obj, Object obj2) {
        return pro.getIresult(149, 1, obj, obj2);
    }

    private static int a(Object obj, String str) {
        return pro.getIresult(150, 1, obj, str);
    }

    public static int a(String str, String str2, String str3, String str4, Bitmap bitmap) {
        return pro.getIresult(151, 1, str, str2, str3, str4, bitmap);
    }

    private static int a(JSONObject jSONObject, int i4) {
        return pro.getIresult(152, 1, jSONObject, Integer.valueOf(i4));
    }

    private static Pair<Integer, Object> a(Context context, String str) {
        return (Pair) pro.getobjresult(153, 1, context, str);
    }

    public static Pair<Integer, Boolean> a(JSONObject jSONObject) {
        return (Pair) pro.getobjresult(154, 1, jSONObject);
    }

    private static Object a(String str, String str2, String str3, byte[] bArr) {
        return pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPEN_TIME, 1, str, str2, str3, bArr);
    }

    public static String a() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME, 1, new Object[0]);
    }

    public static JSONObject a(k0 k0Var) {
        return (JSONObject) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME, 1, k0Var);
    }

    public static boolean a(boolean z3) {
        return pro.getZresult(158, 1, Boolean.valueOf(z3));
    }

    public static int b() {
        return pro.getIresult(159, 1, new Object[0]);
    }

    public static int b(JSONObject jSONObject, int i4) {
        return pro.getIresult(160, 1, jSONObject, Integer.valueOf(i4));
    }

    private static Boolean b(boolean z3) {
        return (Boolean) pro.getobjresult(161, 1, Boolean.valueOf(z3));
    }

    public static String c() {
        return (String) pro.getobjresult(162, 1, new Object[0]);
    }

    private static JSONObject d() {
        return (JSONObject) pro.getobjresult(163, 1, new Object[0]);
    }

    public static int e() {
        return pro.getIresult(MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME, 1, new Object[0]);
    }

    private static Integer f() {
        return (Integer) pro.getobjresult(165, 1, new Object[0]);
    }

    public static void g() {
        pro.getVresult(166, 1, new Object[0]);
    }
}
