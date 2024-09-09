package com.qq.e.comm.plugin.z;

import android.content.Context;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.g0.q;
import com.qq.e.comm.plugin.u.f;
import com.qq.e.comm.plugin.u.h;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends com.qq.e.comm.plugin.u.a {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ADListener f46794a;

        b(a aVar, ADListener aDListener) {
            this.f46794a = aDListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            ADListener aDListener = this.f46794a;
            if (aDListener != null) {
                aDListener.onADEvent(aDEvent);
            }
        }
    }

    public a(Context context, q qVar, int i4) {
        super(context, qVar, i4);
    }

    @Override // com.qq.e.comm.plugin.u.a
    protected f a(Context context, q qVar, VideoOption videoOption, f.a aVar, com.qq.e.comm.plugin.n0.c cVar) {
        return new com.qq.e.comm.plugin.z.b(context, qVar, videoOption, new C0911a(this, aVar), cVar);
    }

    @Override // com.qq.e.comm.plugin.u.a, com.qq.e.comm.adevent.ADEventListener
    public void setAdListener(ADListener aDListener) {
        super.setAdListener(new b(this, aDListener));
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.z.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class C0911a implements f.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f.a f46793a;

        C0911a(a aVar, f.a aVar2) {
            this.f46793a = aVar2;
        }

        @Override // com.qq.e.comm.plugin.u.f.a
        public void a(h hVar) {
            f.a aVar = this.f46793a;
            if (aVar != null) {
                aVar.a(hVar);
            }
        }

        @Override // com.qq.e.comm.plugin.u.f.a
        public void a(int i4) {
            f.a aVar = this.f46793a;
            if (aVar != null) {
                aVar.a(i4);
            }
        }
    }
}
