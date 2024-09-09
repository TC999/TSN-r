package com.qq.e.comm.plugin.l0;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.plugin.b.m;
import com.qq.e.comm.plugin.util.a1;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f44583a = Pattern.compile("^http\\://v\\.gdt\\.qq\\.com/gdt_stats\\.fcg\\?viewid=([^&]*).*");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f44584b = Pattern.compile(".*[?&]viewid=([^&]*).*");

    /* renamed from: c  reason: collision with root package name */
    private static final Set<String> f44585c = new HashSet();

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface a {
        void a();

        void a(int i4, Exception exc);
    }

    private static String a() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_CLIP_HEAACV2_FIRSTPTS_PACKET, 1, new Object[0]);
    }

    private static String a(String str) {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_TIMESTAMP_MONOTONIC, 1, str);
    }

    public static void a(int i4, int i5, int i6, int i7, int i8, int i9, com.qq.e.comm.plugin.g0.e eVar, a aVar) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_FEED_PACKET_UNTIL_EMPTY, 1, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), eVar, aVar);
    }

    private static void a(com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.n0.c cVar) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ, 1, eVar, cVar);
    }

    private static void a(com.qq.e.comm.plugin.i0.n.f fVar, com.qq.e.comm.plugin.g0.e eVar) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_THREAD_PRIORITY, 1, fVar, eVar);
    }

    public static void a(String str, com.qq.e.comm.plugin.g0.e eVar, String str2, int i4, a aVar) {
        pro.getVresult(562, 1, str, eVar, str2, Integer.valueOf(i4), aVar);
    }

    private static void a(String str, String str2, com.qq.e.comm.plugin.g0.e eVar, String str3, int i4, a aVar) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AUDIOTRACK_SMOOTH_CLOCK, 1, str, str2, eVar, str3, Integer.valueOf(i4), aVar);
    }

    @Deprecated
    private static void a(String str, List<String> list, com.qq.e.comm.plugin.g0.e eVar, a aVar) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_SPILT_VOICE_WRITE, 1, str, list, eVar, aVar);
    }

    private static boolean a(com.qq.e.comm.plugin.g0.e eVar) {
        return pro.getZresult(MediaPlayer.MEIDA_PLAYER_OPTION_NATIVE_RENDER_ROTATION_ADAPT, 1, eVar);
    }

    private static String b(String str) {
        return (String) pro.getobjresult(MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING, 1, str);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class b implements com.qq.e.comm.plugin.i0.b {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f44586a;

        /* renamed from: b  reason: collision with root package name */
        private final String f44587b;

        /* renamed from: c  reason: collision with root package name */
        private final m f44588c;

        /* renamed from: d  reason: collision with root package name */
        private final long f44589d;

        /* renamed from: e  reason: collision with root package name */
        private final a f44590e;

        /* renamed from: f  reason: collision with root package name */
        private final com.qq.e.comm.plugin.g0.e f44591f;

        b(List<String> list, com.qq.e.comm.plugin.g0.e eVar, long j4, a aVar) {
            this.f44586a = list;
            this.f44587b = eVar.n();
            this.f44591f = eVar;
            this.f44588c = new m(eVar.q0(), eVar.o(), com.qq.e.comm.plugin.d0.a.d().c().f());
            this.f44589d = j4;
            this.f44590e = aVar;
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, com.qq.e.comm.plugin.i0.n.g gVar) {
            int statusCode = gVar == null ? 0 : gVar.getStatusCode();
            if (statusCode != 200 && statusCode != 204) {
                a(this.f44586a, this.f44587b, "HttpStatus error", this.f44588c, (int) (System.currentTimeMillis() - this.f44589d), statusCode);
                a aVar = this.f44590e;
                if (aVar != null) {
                    aVar.a(statusCode, null);
                    return;
                }
                return;
            }
            a(this.f44586a, this.f44587b, "", this.f44588c, (int) (System.currentTimeMillis() - this.f44589d), statusCode);
            a aVar2 = this.f44590e;
            if (aVar2 != null) {
                aVar2.a();
            }
            if (TextUtils.isEmpty(this.f44591f.E())) {
                return;
            }
            a1.a(this.f44591f.E());
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, Exception exc) {
            a(this.f44586a, this.f44587b, exc.getMessage(), this.f44588c, (int) (System.currentTimeMillis() - this.f44589d), -1);
            a aVar = this.f44590e;
            if (aVar != null) {
                aVar.a(0, exc);
            }
        }

        private void a(List<String> list, String str, String str2, m mVar, int i4, int i5) {
            HashMap hashMap = new HashMap();
            hashMap.put("spam", 0);
            hashMap.put("timecost", Integer.valueOf(i4));
            hashMap.put("httpstatus", Integer.valueOf(i5));
            hashMap.put("msg", str2);
            hashMap.put("tbs", Integer.valueOf(com.qq.e.comm.plugin.q0.d.c() ? 1 : 0));
            g.a(list, str, mVar, hashMap, (com.qq.e.comm.plugin.i0.b) null);
        }
    }
}
