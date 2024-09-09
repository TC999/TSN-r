package cn.jiguang.ae;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.jiguang.af.f;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2115a;

    public a(Context context, Looper looper) {
        super(looper);
        this.f2115a = context;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            f.a().a(this.f2115a, message.what, message.obj);
        } catch (Throwable unused) {
        }
    }
}
