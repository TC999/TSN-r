package cn.jpush.android.z;

import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c extends JPushResponse {

    /* renamed from: a  reason: collision with root package name */
    int f4555a;

    /* renamed from: b  reason: collision with root package name */
    long f4556b;

    /* renamed from: c  reason: collision with root package name */
    String f4557c;

    public c(int i4, long j4, long j5, ByteBuffer byteBuffer) {
        super(i4, j4, j5, byteBuffer);
        parseBody();
    }

    public c(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public int a() {
        return this.f4555a;
    }

    public long b() {
        return this.f4556b;
    }

    public String c() {
        return this.f4557c;
    }

    @Override // cn.jpush.android.local.JPushResponse
    protected void parseBody() {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(this.body.array());
            this.f4555a = wrap.get();
            this.f4556b = wrap.getLong();
            byte[] bArr = new byte[wrap.getShort()];
            wrap.get(bArr);
            this.f4557c = new String(bArr, "UTF-8");
        } catch (Throwable th) {
            Logger.ww("MessagePush", "parse msg content failed, e: " + th.getMessage());
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[MessagePush] - msgType:" + this.f4555a + ", msgId:" + this.f4556b + ", msgContent:" + this.f4557c + " - " + super.toString();
    }
}
