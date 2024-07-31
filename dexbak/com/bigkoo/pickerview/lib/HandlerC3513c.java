package com.bigkoo.pickerview.lib;

import android.os.Handler;
import android.os.Message;
import com.bigkoo.pickerview.lib.WheelView;

/* compiled from: MessageHandler.java */
/* renamed from: com.bigkoo.pickerview.lib.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class HandlerC3513c extends Handler {

    /* renamed from: b */
    public static final int f13106b = 1000;

    /* renamed from: c */
    public static final int f13107c = 2000;

    /* renamed from: d */
    public static final int f13108d = 3000;

    /* renamed from: a */
    final WheelView f13109a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC3513c(WheelView wheelView) {
        this.f13109a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.f13109a.invalidate();
        } else if (i == 2000) {
            this.f13109a.m45878o(WheelView.ACTION.FLING);
        } else if (i != 3000) {
        } else {
            this.f13109a.m45882k();
        }
    }
}
