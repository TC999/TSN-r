package cn.jpush.android.g;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import cn.asus.push.DataBuffer;
import cn.asus.push.IAIDLInvoke;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class d extends a {

    /* renamed from: b */
    private IAIDLInvoke f4205b = null;

    public static /* synthetic */ IAIDLInvoke a(d dVar, IAIDLInvoke iAIDLInvoke) {
        dVar.f4205b = null;
        return null;
    }

    @Override // cn.jpush.android.g.a
    public final void a(String str, String str2) {
        String str3;
        if (this.f4205b != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("JPUSH_CONTENT", str2);
                this.f4205b.a(new DataBuffer(str, bundle), new b());
                return;
            } catch (Throwable th) {
                str3 = "send data fail:" + th;
            }
        } else {
            str3 = "send data fail, please init first.";
        }
        cn.jpush.android.i.b.g("ServiceConnection", str3);
    }

    @Override // cn.jpush.android.g.a
    public final boolean a() {
        if (a.f4204a.get()) {
            cn.jpush.android.i.b.b("ServiceConnection", "already connecting.");
            return false;
        }
        a.f4204a.set(true);
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(cn.jpush.android.f.c.f4188e, "cn.jpush.android.service.PushManagerService"));
            e eVar = new e(this, (byte) 0);
            boolean bindService = cn.jpush.android.f.c.f4184a.bindService(intent, eVar, 1);
            cn.jpush.android.i.b.b("ServiceConnection", "connect--" + bindService);
            if (bindService) {
                this.f4205b = IAIDLInvoke.Stub.c(eVar.f4206a.take());
            } else {
                a.f4204a.set(false);
            }
            return bindService;
        } catch (Throwable th) {
            cn.jpush.android.i.b.g("ServiceConnection", "init fail:" + th);
            a.f4204a.set(false);
            return false;
        }
    }

    @Override // cn.jpush.android.g.a
    public final boolean b() {
        IAIDLInvoke iAIDLInvoke = this.f4205b;
        if (iAIDLInvoke == null) {
            return false;
        }
        return iAIDLInvoke.asBinder().isBinderAlive();
    }
}
