package cn.jpush.android.n;

import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b extends JPushResponse {

    /* renamed from: a  reason: collision with root package name */
    private int f4252a;

    public b(int i4, long j4, long j5, ByteBuffer byteBuffer) {
        super(i4, j4, j5, byteBuffer);
        this.f4252a = 0;
        parseBody();
    }

    public b(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public int a() {
        return this.f4252a;
    }

    @Override // cn.jpush.android.local.JPushResponse
    protected void parseBody() {
        try {
            ByteBuffer byteBuffer = this.body;
            if (byteBuffer != null) {
                this.f4252a = byteBuffer.get();
                Logger.ww("GeoControl", "control type:" + this.f4252a);
            }
        } catch (Throwable unused) {
            Logger.ww("GeoControl", "parse geoContorl failed");
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[GeoControl] - type:" + this.f4252a + " - " + super.toString();
    }
}
