package cn.jpush.android.z;

import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a extends JPushResponse {

    /* renamed from: a  reason: collision with root package name */
    private int f4554a;

    public a(int i4, long j4, long j5, ByteBuffer byteBuffer) {
        super(i4, j4, j5, byteBuffer);
        parseBody();
    }

    public a(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public int a() {
        return this.f4554a;
    }

    @Override // cn.jpush.android.local.JPushResponse
    protected void parseBody() {
        try {
            this.f4554a = this.body.getShort();
        } catch (Throwable th) {
            Logger.ww("CommonResponse", "parse code failed :" + th.getMessage());
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[CommonResponse] - " + this.f4554a;
    }
}
