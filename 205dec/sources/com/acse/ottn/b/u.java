package com.acse.ottn.b;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;
import com.acse.ottn.b.C;
import com.acse.ottn.widget.ContinueSlideScrollView;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class u implements ContinueSlideScrollView.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TextView f5155a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C.a f5156b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Activity f5157c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TextView textView, C.a aVar, Activity activity) {
        this.f5155a = textView;
        this.f5156b = aVar;
        this.f5157c = activity;
    }

    @Override // com.acse.ottn.widget.ContinueSlideScrollView.a
    public void a() {
        TimerTask timerTask;
        TimerTask timerTask2;
        timerTask = C.f5067c;
        if (timerTask != null) {
            timerTask2 = C.f5067c;
            timerTask2.cancel();
            this.f5155a.setText("\u6211\u5df2\u77e5\u6653\u5e76\u540c\u610f");
            this.f5155a.setOnClickListener(new t(this));
            com.acse.ottn.util.I.a().c(this.f5157c, this.f5155a);
        }
    }

    @Override // com.acse.ottn.widget.ContinueSlideScrollView.a
    public void b() {
        Log.d("samon-->", "\u5230\u9876\u90e8\u4e86");
    }
}
