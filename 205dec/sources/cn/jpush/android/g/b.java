package cn.jpush.android.g;

import android.content.Intent;
import android.text.TextUtils;
import cn.asus.push.DataBuffer;
import cn.asus.push.IAIDLCallback;
import cn.jiguang.push.asus.PushMessageReceiver;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class b extends IAIDLCallback.Stub {
    @Override // cn.asus.push.IAIDLCallback
    public final void call(DataBuffer dataBuffer) {
        try {
            cn.jpush.android.i.b.a("ClientAIDLCallBack", "[call] data:" + String.valueOf(dataBuffer) + ",cmd:" + dataBuffer.f1517a);
            String str = dataBuffer.f1517a;
            long j4 = dataBuffer.f1518b.getLong("message_rid", -1L);
            String string = dataBuffer.f1518b.getString("message_content");
            String b4 = cn.jpush.android.f.c.b(cn.jpush.android.f.c.f4184a);
            if (TextUtils.isEmpty(b4)) {
                Intent intent = new Intent();
                dataBuffer.f1518b.putString("message_cmd", dataBuffer.f1517a);
                intent.putExtras(dataBuffer.f1518b);
                intent.setAction("com.ups.push.PUSH_RESPONSE");
                intent.setPackage(cn.jpush.android.f.c.f4186c);
                cn.jpush.android.f.c.f4184a.sendBroadcast(intent);
            } else {
                ((PushMessageReceiver) Class.forName(b4).newInstance()).a(cn.jpush.android.f.c.f4184a, j4, str, string);
            }
        } catch (Throwable unused) {
        }
    }
}
