package cn.jiguang.api;

import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class JRequest extends JProtocol {
    public JRequest(int i4, int i5, long j4) {
        super(true, i4, i5, j4);
    }

    public JRequest(Object obj, ByteBuffer byteBuffer) {
        super(true, obj, byteBuffer);
    }

    public void setJuid(long j4) {
        this.head.a(j4);
    }

    public void setSid(int i4) {
        this.head.b(i4);
    }
}
