package com.qq.e.comm.plugin.i;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class l implements o {

    /* renamed from: a  reason: collision with root package name */
    private boolean f44173a = false;

    l() {
    }

    private void a(h hVar, int i4) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 0, this, hVar, Integer.valueOf(i4));
    }

    private String b(h hVar) {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_QUERY, 0, this, hVar);
    }

    private void b(h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY, 0, this, hVar, bVar);
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AUDIO_DEVICE_TYPE, 0, this, hVar);
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL, 0, this, hVar, bVar);
    }
}
