package com.qq.e.comm.plugin.l0.h;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.plugin.d0.e.d;
import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.v0;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f44630a = "b";

    /* renamed from: b  reason: collision with root package name */
    private static final int f44631b = com.qq.e.comm.plugin.d0.a.d().f().a("skccerpce", 50);

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicInteger f44632c = new AtomicInteger();

    /* renamed from: d  reason: collision with root package name */
    private static final ConcurrentLinkedQueue<com.qq.e.comm.plugin.l0.h.a> f44633d = new ConcurrentLinkedQueue<>();

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicInteger f44634e = new AtomicInteger();

    /* renamed from: f  reason: collision with root package name */
    private static final Lock f44635f = new ReentrantLock(true);

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicBoolean f44636g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicBoolean f44637h = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    private static final AtomicBoolean f44638i = new AtomicBoolean(false);

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a();
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.l0.h.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class RunnableC0854b implements Runnable {
        RunnableC0854b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.b();
            b.i();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!v0.e()) {
                d1.a(b.c(), "\u89e6\u53d1\u91cd\u8bd5\uff0c\u65e0\u7f51\u7edc");
                return;
            }
            d n4 = com.qq.e.comm.plugin.d0.a.d().c().n();
            d1.a(b.c(), "\u89e6\u53d1\u91cd\u8bd5\uff0c\u7f51\u7edc\u4e3a: %s", n4.b());
            if (n4 == d.WIFI || n4 == d.NET_4G) {
                b.d();
            }
        }
    }

    private static String a(Map<String, String> map) {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_INFOS, 1, map);
    }

    private static Map<String, String> a(String str) {
        return (Map) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_VIDEO_WINDOW_SIZE, 1, str);
    }

    static /* synthetic */ void a() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_AUDIO_WINDOW_SIZE, 1, new Object[0]);
    }

    private static void a(int i4, String str, Map<String, String> map, int i5, int i6) {
        pro.getVresult(524, 1, Integer.valueOf(i4), str, map, Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public static void a(e eVar, String str, Map<String, String> map, int i4) {
        pro.getVresult(525, 1, eVar, str, map, Integer.valueOf(i4));
    }

    private static boolean a(e eVar) {
        return pro.getZresult(526, 1, eVar);
    }

    static /* synthetic */ void b() {
        pro.getVresult(527, 1, new Object[0]);
    }

    public static void b(e eVar, String str, Map<String, String> map, int i4) {
        pro.getVresult(528, 1, eVar, str, map, Integer.valueOf(i4));
    }

    private static boolean b(e eVar) {
        return pro.getZresult(529, 1, eVar);
    }

    static /* synthetic */ String c() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_VIDEO_STACK_SIZE, 1, new Object[0]);
    }

    static /* synthetic */ void d() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_AUDIO_QUEUE_SIZE, 1, new Object[0]);
    }

    private static void e() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LLASH_FAST_OPEN, 1, new Object[0]);
    }

    private static void f() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_CHECK_ENHANCE, 1, new Object[0]);
    }

    private static void g() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_CHECK_INTERVAL, 1, new Object[0]);
    }

    public static void h() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_METHOD, 1, new Object[0]);
    }

    public static void i() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_FIND_STREAM_INFO_PROBE_SIZE, 1, new Object[0]);
    }

    private static void j() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_FIND_STREAM_INFO_PROBE_DURATION, 1, new Object[0]);
    }
}
