package com.acse.ottn.animator;

import android.os.Handler;
import android.widget.ImageView;
import com.acse.ottn.C1239R;
import com.acse.ottn.animator.p031a.AbstractC1334a;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.animator.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1392d extends C1316a {

    /* renamed from: a */
    final /* synthetic */ SwitchOnAnimSmallView f2502a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1392d(SwitchOnAnimSmallView switchOnAnimSmallView) {
        this.f2502a = switchOnAnimSmallView;
    }

    @Override // com.acse.ottn.animator.C1316a, com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
    /* renamed from: a */
    public void mo56852a(AbstractC1334a abstractC1334a) {
        ImageView imageView;
        Handler handler;
        ImageView imageView2;
        Handler handler2;
        imageView = this.f2502a.f2244e;
        if (imageView != null) {
            handler = this.f2502a.f2242c;
            if (handler == null) {
                return;
            }
            imageView2 = this.f2502a.f2244e;
            imageView2.setBackgroundResource(C1239R.mipmap.finger_click);
            handler2 = this.f2502a.f2242c;
            handler2.postDelayed(new RunnableC1375c(this), 200L);
        }
    }
}
