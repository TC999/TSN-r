package com.qq.e.comm.plugin.gdtnativead;

import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.plugin.o0.h.f;
import java.lang.ref.WeakReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class o implements AdData.VideoPlayer {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<com.qq.e.comm.plugin.o0.h.f> f43925a;

    public o(com.qq.e.comm.plugin.o0.h.f fVar) {
        this.f43925a = new WeakReference<>(fVar);
    }

    @Override // com.qq.e.comm.pi.AdData.VideoPlayer
    public int getCurrentPosition() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f43925a.get();
        if (fVar != null) {
            return fVar.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.qq.e.comm.pi.AdData.VideoPlayer
    public int getDuration() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f43925a.get();
        if (fVar != null) {
            return fVar.getDuration();
        }
        return 0;
    }

    @Override // com.qq.e.comm.pi.AdData.VideoPlayer
    public int getVideoState() {
        f.t videoState;
        com.qq.e.comm.plugin.o0.h.f fVar = this.f43925a.get();
        if (fVar == null) {
            videoState = f.t.ERROR;
        } else {
            videoState = fVar.getVideoState();
        }
        return videoState.ordinal();
    }
}
