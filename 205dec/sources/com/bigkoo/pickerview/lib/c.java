package com.bigkoo.pickerview.lib;

import android.os.Handler;
import android.os.Message;
import com.bigkoo.pickerview.lib.WheelView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MessageHandler.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
final class c extends Handler {

    /* renamed from: b  reason: collision with root package name */
    public static final int f16304b = 1000;

    /* renamed from: c  reason: collision with root package name */
    public static final int f16305c = 2000;

    /* renamed from: d  reason: collision with root package name */
    public static final int f16306d = 3000;

    /* renamed from: a  reason: collision with root package name */
    final WheelView f16307a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WheelView wheelView) {
        this.f16307a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i4 = message.what;
        if (i4 == 1000) {
            this.f16307a.invalidate();
        } else if (i4 == 2000) {
            this.f16307a.o(WheelView.ACTION.FLING);
        } else if (i4 != 3000) {
        } else {
            this.f16307a.k();
        }
    }
}
