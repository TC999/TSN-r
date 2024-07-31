package com.acse.ottn.animator;

import android.widget.ImageView;
import com.acse.ottn.C1239R;

/* renamed from: com.acse.ottn.animator.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1395g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC1396h f2505a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1395g(RunnableC1396h runnableC1396h) {
        this.f2505a = runnableC1396h;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        ImageView imageView2;
        imageView = this.f2505a.f2506a.f2507a.f2252e;
        if (imageView != null) {
            imageView2 = this.f2505a.f2506a.f2507a.f2252e;
            imageView2.setBackgroundResource(C1239R.mipmap.finger_normal);
        }
        this.f2505a.f2506a.f2507a.m57196e();
    }
}
