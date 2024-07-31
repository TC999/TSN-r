package com.acse.ottn.animator;

import android.os.Handler;
import android.widget.ImageView;
import com.acse.ottn.C1239R;
import com.acse.ottn.animator.p031a.AbstractC1334a;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.animator.i */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1397i extends C1316a {

    /* renamed from: a */
    final /* synthetic */ SwitchOnAnimView f2507a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1397i(SwitchOnAnimView switchOnAnimView) {
        this.f2507a = switchOnAnimView;
    }

    @Override // com.acse.ottn.animator.C1316a, com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
    /* renamed from: a */
    public void mo56852a(AbstractC1334a abstractC1334a) {
        ImageView imageView;
        Handler handler;
        ImageView imageView2;
        Handler handler2;
        imageView = this.f2507a.f2252e;
        if (imageView != null) {
            handler = this.f2507a.f2250c;
            if (handler == null) {
                return;
            }
            imageView2 = this.f2507a.f2252e;
            imageView2.setBackgroundResource(C1239R.mipmap.finger_click);
            handler2 = this.f2507a.f2250c;
            handler2.postDelayed(new RunnableC1396h(this), 200L);
        }
    }
}
