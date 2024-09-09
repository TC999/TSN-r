package com.qq.e.comm.plugin.n0;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.Set;
import yaq.pro;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class n extends a<l> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context) {
        super(context);
    }

    @Override // com.qq.e.comm.plugin.n0.a
    public void a(Set<Integer> set) {
        j.a(this.f44725a).a().a(set);
    }

    @Override // com.qq.e.comm.plugin.n0.a
    public List<l> b() {
        return j.a(this.f44725a).a().b();
    }

    @Override // com.qq.e.comm.plugin.n0.a
    public void c(List<l> list) {
        j.a(this.f44725a).a().a(list);
    }

    @Override // com.qq.e.comm.plugin.n0.a
    void d(List<l> list) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_AUDIO_FIRSTSEG_CONNECT_TIME, 0, this, list);
    }

    @Override // com.qq.e.comm.plugin.n0.a
    boolean e() {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME, 0, this);
    }
}
