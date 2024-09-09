package com.qq.e.comm.plugin.i;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class k implements o {
    k() {
    }

    private void a(int i4, h hVar) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER, 0, this, Integer.valueOf(i4), hVar);
    }

    private boolean b(h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_200, 0, this, hVar, bVar);
    }

    private boolean c(h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, 0, this, hVar, bVar);
    }

    private boolean d(h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, 0, this, hVar, bVar);
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_500, 0, this, hVar);
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500, 0, this, hVar, bVar);
    }
}
