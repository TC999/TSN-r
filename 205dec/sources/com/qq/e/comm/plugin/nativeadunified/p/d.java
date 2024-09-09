package com.qq.e.comm.plugin.nativeadunified.p;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.comm.plugin.gdtnativead.p.a;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.nativeadunified.g;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.util.n2;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d extends com.qq.e.comm.plugin.nativeadunified.p.a {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qq.e.comm.plugin.gdtnativead.p.a aVar = d.this.f44994c;
            if (aVar != null) {
                aVar.a(3000, true);
            }
        }
    }

    public d(Context context, g gVar, VideoOption videoOption, a.d dVar, f.p pVar, com.qq.e.comm.plugin.nativeadunified.e eVar, View.OnTouchListener onTouchListener, MediaView mediaView) {
        super(context, gVar, videoOption, dVar, pVar, eVar, onTouchListener, mediaView);
        p();
    }

    private void p() {
        this.f44994c = o();
        try {
            com.qq.e.comm.plugin.o0.h.f fVar = new com.qq.e.comm.plugin.o0.h.f(this.f44992a.getApplicationContext());
            this.f44993b = fVar;
            a(fVar);
        } catch (Exception e4) {
            com.qq.e.comm.plugin.n0.c a4 = com.qq.e.comm.plugin.n0.c.a(this.f44996e);
            com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
            dVar.a("msg", Log.getStackTraceString(e4));
            v.a(1060030, a4, 0, 0, dVar);
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.a, com.qq.e.comm.plugin.nativeadunified.p.b
    public void a(MediaView mediaView) {
        super.a(mediaView);
        n2.a(this.f44994c);
        n2.a(this.f44993b);
        this.f44995d.addView(this.f44993b);
        this.f44995d.addView(this.f44994c);
        com.qq.e.comm.plugin.o0.h.a.a(this.f44995d, this.f44996e.X(), this.f44993b);
        com.qq.e.comm.plugin.o0.h.g.a(false);
        this.f44995d.setOnClickListener(this.f45000i);
        View.OnTouchListener onTouchListener = this.f45001j;
        if (onTouchListener != null) {
            this.f44995d.setOnTouchListener(onTouchListener);
        }
        this.f44995d.post(new a());
        n();
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void j() {
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.a
    public boolean m() {
        return false;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.a
    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        this.f44995d.addView(view, layoutParams);
    }
}
