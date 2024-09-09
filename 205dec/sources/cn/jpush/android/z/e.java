package cn.jpush.android.z;

import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e extends JPushResponse {

    /* renamed from: a  reason: collision with root package name */
    public int f4562a;

    /* renamed from: b  reason: collision with root package name */
    String f4563b;

    public e(int i4, long j4, long j5, ByteBuffer byteBuffer) {
        super(i4, j4, j5, byteBuffer);
        parseBody();
    }

    public e(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public String a() {
        return this.f4563b;
    }

    @Override // cn.jpush.android.local.JPushResponse
    protected void parseBody() {
        try {
            int i4 = this.cmd;
            if (i4 == 10 || i4 == 38) {
                this.f4562a = this.body.getShort();
            }
            if (this.cmd == 38 || this.f4562a <= 0) {
                byte[] bArr = new byte[this.body.getShort()];
                this.body.get(bArr);
                this.f4563b = new String(bArr, "UTF-8");
                return;
            }
            Logger.e("TagaliasResponse", "Response error - code:" + this.f4562a);
        } catch (Throwable th) {
            Logger.ww("TagaliasResponse", "parse failed:" + th.getMessage());
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[TagaliasResponse] - action:" + this.f4563b + " - " + super.toString();
    }
}
