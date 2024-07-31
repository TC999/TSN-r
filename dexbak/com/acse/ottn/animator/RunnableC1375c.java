package com.acse.ottn.animator;

import android.os.Handler;
import android.widget.ImageView;
import com.acse.ottn.C1239R;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.animator.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class RunnableC1375c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1392d f2415a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1375c(C1392d c1392d) {
        this.f2415a = c1392d;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        Handler handler;
        ImageView imageView2;
        Handler handler2;
        imageView = this.f2415a.f2502a.f2243d;
        if (imageView != null) {
            handler = this.f2415a.f2502a.f2242c;
            if (handler == null) {
                return;
            }
            imageView2 = this.f2415a.f2502a.f2243d;
            imageView2.setBackgroundResource(C1239R.mipmap.switch_on_circle_point);
            this.f2415a.f2502a.m57210d();
            handler2 = this.f2415a.f2502a.f2242c;
            handler2.postDelayed(new RunnableC1369b(this), 100L);
        }
    }
}
