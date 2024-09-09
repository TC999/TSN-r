package com.qq.e.comm.plugin.i;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class s implements o {

    /* renamed from: a  reason: collision with root package name */
    private String f44187a;

    s() {
    }

    private void a(int i4, h hVar, int i5) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD, 0, this, Integer.valueOf(i4), hVar, Integer.valueOf(i5));
    }

    private void a(h hVar, int i4) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT, 0, this, hVar, Integer.valueOf(i4));
    }

    private String b(h hVar) {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_PRIMING_WORK_AROUND, 0, this, hVar);
    }

    private void c(h hVar) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_MULTI_SEI, 0, this, hVar);
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_SWITCH, 0, this, hVar);
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_MS_GAPS, 0, this, hVar, bVar);
    }
}
