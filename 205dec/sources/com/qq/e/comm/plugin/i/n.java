package com.qq.e.comm.plugin.i;

import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class n implements o {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h f44174c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f44175d;

        a(n nVar, h hVar, boolean z3) {
            this.f44174c = hVar;
            this.f44175d = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qq.e.comm.plugin.l0.a.a(this.f44174c.f44137j.booleanValue(), this.f44175d, this.f44174c.a().f43573b, com.qq.e.comm.plugin.rewardvideo.l.a(this.f44174c.C));
        }
    }

    n() {
    }

    private void a(int i4, h hVar) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_ALWAYS_DO_AV_SYNC, 0, this, Integer.valueOf(i4), hVar);
    }

    private void a(Pair<Integer, Boolean> pair, h hVar) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 0, this, pair, hVar);
    }

    private void a(h hVar, boolean z3) {
        pro.getVresult(350, 0, this, hVar, Boolean.valueOf(z3));
    }

    private void a(Boolean bool, Integer num, h hVar) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_CACHED, 0, this, bool, num, hVar);
    }

    private boolean b(h hVar) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CHLO_COUNT, 0, this, hVar);
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SCFG_ADDRESS, 0, this, hVar);
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_CERT_VERIFY, 0, this, hVar, bVar);
    }
}
