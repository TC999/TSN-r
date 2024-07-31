package com.acse.ottn.p035b;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;
import com.acse.ottn.p035b.C1403C;
import com.acse.ottn.util.C1633I;
import com.acse.ottn.widget.ContinueSlideScrollView;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.b.u */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1437u implements ContinueSlideScrollView.InterfaceC1713a {

    /* renamed from: a */
    final /* synthetic */ TextView f2595a;

    /* renamed from: b */
    final /* synthetic */ C1403C.InterfaceC1404a f2596b;

    /* renamed from: c */
    final /* synthetic */ Activity f2597c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1437u(TextView textView, C1403C.InterfaceC1404a interfaceC1404a, Activity activity) {
        this.f2595a = textView;
        this.f2596b = interfaceC1404a;
        this.f2597c = activity;
    }

    @Override // com.acse.ottn.widget.ContinueSlideScrollView.InterfaceC1713a
    /* renamed from: a */
    public void mo55855a() {
        TimerTask timerTask;
        TimerTask timerTask2;
        timerTask = C1403C.f2516c;
        if (timerTask != null) {
            timerTask2 = C1403C.f2516c;
            timerTask2.cancel();
            this.f2595a.setText("我已知晓并同意");
            this.f2595a.setOnClickListener(new View$OnClickListenerC1436t(this));
            C1633I.m56254a().m56241c(this.f2597c, this.f2595a);
        }
    }

    @Override // com.acse.ottn.widget.ContinueSlideScrollView.InterfaceC1713a
    /* renamed from: b */
    public void mo55854b() {
        Log.d("samon-->", "到顶部了");
    }
}
