package com.acse.ottn.animator;

import android.os.Handler;
import android.widget.ImageView;
import com.acse.ottn.C1239R;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.animator.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class RunnableC1396h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1397i f2506a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1396h(C1397i c1397i) {
        this.f2506a = c1397i;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        Handler handler;
        ImageView imageView2;
        Handler handler2;
        imageView = this.f2506a.f2507a.f2251d;
        if (imageView != null) {
            handler = this.f2506a.f2507a.f2250c;
            if (handler == null) {
                return;
            }
            imageView2 = this.f2506a.f2507a.f2251d;
            imageView2.setBackgroundResource(C1239R.mipmap.switch_on_circle_point);
            this.f2506a.f2507a.m57198d();
            handler2 = this.f2506a.f2507a.f2250c;
            handler2.postDelayed(new RunnableC1395g(this), 100L);
        }
    }
}
