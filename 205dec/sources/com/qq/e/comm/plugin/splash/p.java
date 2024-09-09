package com.qq.e.comm.plugin.splash;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import yaq.pro;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private final h f46159a;

    /* renamed from: b  reason: collision with root package name */
    private final com.qq.e.comm.plugin.o0.h.f f46160b;

    public p(h hVar, com.qq.e.comm.plugin.o0.h.f fVar) {
        this.f46159a = hVar;
        this.f46160b = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i4, int i5) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME, 0, this, Integer.valueOf(i4), Integer.valueOf(i5));
    }
}
