package cn.jiguang.push.asus;

import android.content.Context;
import android.content.Intent;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3766a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Intent f3767b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ PushMessageReceiver f3768c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PushMessageReceiver pushMessageReceiver, Context context, Intent intent) {
        this.f3768c = pushMessageReceiver;
        this.f3766a = context;
        this.f3767b = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3768c.a(this.f3766a, this.f3767b);
    }
}
