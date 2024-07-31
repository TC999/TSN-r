package com.acse.ottn.animator;

import android.widget.ImageView;
import com.acse.ottn.C1239R;

/* renamed from: com.acse.ottn.animator.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1369b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC1375c f2406a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1369b(RunnableC1375c runnableC1375c) {
        this.f2406a = runnableC1375c;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        ImageView imageView2;
        imageView = this.f2406a.f2415a.f2502a.f2244e;
        if (imageView != null) {
            imageView2 = this.f2406a.f2415a.f2502a.f2244e;
            imageView2.setBackgroundResource(C1239R.mipmap.finger_normal);
        }
        this.f2406a.f2415a.f2502a.m57208e();
    }
}
