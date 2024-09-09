package com.qq.e.comm.plugin.i;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.plugin.util.p;
import yaq.pro;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class q implements o, com.qq.e.comm.plugin.i.d0.c {

    /* renamed from: a  reason: collision with root package name */
    private h f44176a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.i.d0.b f44177b;

    /* renamed from: c  reason: collision with root package name */
    private Intent f44178c;

    /* renamed from: d  reason: collision with root package name */
    private com.qq.e.comm.plugin.n0.w.d f44179d;

    /* renamed from: e  reason: collision with root package name */
    private long f44180e;

    /* renamed from: f  reason: collision with root package name */
    private int f44181f = -1;

    /* renamed from: g  reason: collision with root package name */
    private boolean f44182g = false;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements p.i {
        a() {
        }

        @Override // com.qq.e.comm.plugin.util.p.i
        public void a() {
            int i4;
            if (com.qq.e.comm.plugin.util.y.d(q.a(q.this).f44151x)) {
                i4 = 1;
            } else {
                i4 = 0;
                c();
            }
            com.qq.e.comm.plugin.n0.v.a(9130007, q.b(q.this), Integer.valueOf(i4), 1, null);
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean b() {
            return true;
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean c() {
            if (q.c(q.this) > 0) {
                q.b(q.this).a(System.currentTimeMillis() - q.c(q.this));
            }
            com.qq.e.comm.plugin.n0.v.a(4002013, q.b(q.this));
            return true;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f44184c;

        b(boolean z3) {
            this.f44184c = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = q.a(q.this).a().f43573b;
            int a4 = com.qq.e.comm.plugin.rewardvideo.l.a(q.a(q.this).C);
            com.qq.e.comm.plugin.l0.a.b(str, a4);
            if (q.a(q.this).f44135h) {
                com.qq.e.comm.plugin.l0.a.a(q.d(q.this), str, a4);
            }
            if (this.f44184c) {
                com.qq.e.comm.plugin.l0.a.a(str, a4);
            }
        }
    }

    q() {
    }

    static /* synthetic */ h a(q qVar) {
        return (h) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_PRE_STALL_500, 1, qVar);
    }

    private String a() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_POST_STALL_500, 0, this);
    }

    private String a(PackageManager packageManager, ResolveInfo resolveInfo) {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, 0, this, packageManager, resolveInfo);
    }

    private void a(PackageManager packageManager, ResolveInfo resolveInfo, com.qq.e.comm.plugin.i.d0.b bVar) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSIONS, 0, this, packageManager, resolveInfo, bVar);
    }

    private void a(Boolean bool, int i4) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSION_TIME_MS, 0, this, bool, Integer.valueOf(i4));
    }

    static /* synthetic */ com.qq.e.comm.plugin.n0.w.d b(q qVar) {
        return (com.qq.e.comm.plugin.n0.w.d) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSIONS, 1, qVar);
    }

    static /* synthetic */ long c(q qVar) {
        return pro.getJresult(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSION_TIME_MS, 1, qVar);
    }

    private void c(boolean z3) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_ACK_DELAY, 0, this, Boolean.valueOf(z3));
    }

    static /* synthetic */ String d(q qVar) {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MIN_RECEIVED_BEFORE_ACK_DECIMATION, 1, qVar);
    }

    @Override // com.qq.e.comm.plugin.i.d0.c
    public void a(boolean z3) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO, 0, this, Boolean.valueOf(z3));
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_UNRELIABLE, 0, this, hVar);
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        return pro.getZresult(397, 0, this, hVar, bVar);
    }

    @Override // com.qq.e.comm.plugin.i.d0.c
    public void b(boolean z3) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, 0, this, Boolean.valueOf(z3));
    }

    @Override // com.qq.e.comm.plugin.i.d0.c
    public void onCancel() {
        pro.getVresult(399, 0, this);
    }

    @Override // com.qq.e.comm.plugin.i.d0.c
    public boolean onConfirm() {
        return pro.getZresult(400, 0, this);
    }
}
