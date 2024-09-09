package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tencent.turingfd.sdk.ams.au.ITuringDID;
import com.tencent.turingfd.sdk.ams.au.ITuringDeviceInfoProvider;
import com.tencent.turingfd.sdk.ams.au.ITuringPrivacyPolicy;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a2 {

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f46368d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile int f46369e;

    /* renamed from: h  reason: collision with root package name */
    private static volatile boolean f46372h;

    /* renamed from: i  reason: collision with root package name */
    private static volatile boolean f46373i;

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f46365a = c();

    /* renamed from: b  reason: collision with root package name */
    private static volatile String f46366b = b();

    /* renamed from: c  reason: collision with root package name */
    private static volatile long f46367c = 0;

    /* renamed from: f  reason: collision with root package name */
    private static volatile int f46370f = 1;

    /* renamed from: g  reason: collision with root package name */
    private static volatile boolean f46371g = false;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements ITuringDeviceInfoProvider {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f46374a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f46375b;

        a(boolean z3, Context context) {
            this.f46374a = z3;
            this.f46375b = context;
        }

        @Override // com.tencent.turingfd.sdk.ams.au.ITuringDeviceInfoProvider
        public String a() {
            if (this.f46374a) {
                return com.qq.e.comm.plugin.m.b.f44640f.b().a(this.f46375b);
            }
            return null;
        }

        @Override // com.tencent.turingfd.sdk.ams.au.ITuringDeviceInfoProvider
        public String b() {
            return null;
        }

        @Override // com.tencent.turingfd.sdk.ams.au.ITuringDeviceInfoProvider
        public String c() {
            if (this.f46374a) {
                return com.qq.e.comm.plugin.m.b.f44639e.b().a(this.f46375b);
            }
            return null;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class b implements ITuringPrivacyPolicy {
        b() {
        }

        @Override // com.tencent.turingfd.sdk.ams.au.CanisMajor
        public boolean a() {
            return true;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d1.a("update TuringID in %s: ", Thread.currentThread().getName());
            a2.a(true);
            a2.a();
            a2.a(false);
        }
    }

    static /* synthetic */ void a() {
        pro.getVresult(304, 1, new Object[0]);
    }

    public static void a(Context context) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, 1, context);
    }

    public static void a(j0 j0Var, String str) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_PREDELAY, 1, j0Var, str);
    }

    private static void a(ITuringDID iTuringDID) {
        pro.getVresult(307, 1, iTuringDID);
    }

    private static void a(String str) {
        pro.getVresult(308, 1, str);
    }

    private static void a(String str, String str2) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_START_PLAY_BUFFER_THRES, 1, str, str2);
    }

    public static void a(JSONObject jSONObject, String str) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_BUFFERING_END_IGNORE_VIDEO, 1, jSONObject, str);
    }

    public static void a(boolean z3, JSONObject jSONObject, String str) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_START_DIRECTLLY_AFTER_PREPARED, 1, Boolean.valueOf(z3), jSONObject, str);
    }

    static /* synthetic */ boolean a(boolean z3) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_TIME_BAR_PERCENTAGE, 1, Boolean.valueOf(z3));
    }

    private static String b() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_ADVANCE_CHECK_BUFFERING_END, 1, new Object[0]);
    }

    private static void b(String str) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 1, str);
    }

    private static String c() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT, 1, new Object[0]);
    }

    public static Pair<String, String> d() {
        return (Pair) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, 1, new Object[0]);
    }

    private static boolean e() {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT, 1, new Object[0]);
    }

    private static void f() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME, 1, new Object[0]);
    }

    private static void g() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME, 1, new Object[0]);
    }
}
