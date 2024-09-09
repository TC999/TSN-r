package com.acse.ottn.util;

import android.os.Handler;
import android.os.Looper;
import com.acse.ottn.util.S;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.q  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1446q implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ A f6865a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1446q(A a4) {
        this.f6865a = a4;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        try {
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC1445p(this), 0L);
        } catch (Exception unused) {
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        String str;
        str = A.f6686e;
        ra.a(str, "\u7ed3\u675f\u4e86");
        TimerTask timerTask = A.f6684c;
        if (timerTask != null) {
            timerTask.cancel();
            A.f6684c = null;
        }
    }
}
