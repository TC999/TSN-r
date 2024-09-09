package com.qq.e.comm.plugin.i;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicInteger;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f44121a = new AtomicInteger();

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h f44122c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ p f44123d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.i.d0.b f44124e;

        a(h hVar, p pVar, com.qq.e.comm.plugin.i.d0.b bVar) {
            this.f44122c = hVar;
            this.f44123d = pVar;
            this.f44124e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.a().incrementAndGet();
            h hVar = this.f44122c;
            if (hVar.f44135h) {
                com.qq.e.comm.plugin.n0.w.b.a(com.qq.e.comm.plugin.apkmanager.w.d.f(hVar.f44136i) ? 4001019 : 4001020, this.f44122c.f44153z);
            }
            this.f44123d.a(this.f44122c, this.f44124e);
            h hVar2 = this.f44122c;
            j.a(2300007, hVar2.f44128a, hVar2);
            g.a().decrementAndGet();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ p f44125c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ h f44126d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.i.d0.b f44127e;

        b(p pVar, h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
            this.f44125c = pVar;
            this.f44126d = hVar;
            this.f44127e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.a().incrementAndGet();
            this.f44125c.a(this.f44126d, this.f44127e);
            g.a().decrementAndGet();
        }
    }

    static /* synthetic */ AtomicInteger a() {
        return (AtomicInteger) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME, 1, new Object[0]);
    }

    public static void a(h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME, 1, hVar, bVar);
    }

    private static boolean a(h hVar) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME, 1, hVar);
    }

    public static void b(h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION, 1, hVar, bVar);
    }
}
