package cn.jiguang.api;

import cn.jiguang.api.utils.ByteBufferUtils;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class JResponse extends JProtocol {
    public int code;

    public JResponse(int i4, int i5, long j4, long j5, int i6, String str) {
        super(false, i4, i5, j4, -1, j5);
        this.code = i6;
    }

    public JResponse(Object obj, ByteBuffer byteBuffer) {
        super(false, obj, byteBuffer);
    }

    public JResponse(ByteBuffer byteBuffer, byte[] bArr) {
        super(false, byteBuffer, bArr);
    }

    @Override // cn.jiguang.api.JProtocol
    protected void parseBody() {
        if (isNeedParseeErrorMsg()) {
            this.code = ByteBufferUtils.getShort(this.body, this);
        }
    }

    @Override // cn.jiguang.api.JProtocol
    public String toString() {
        return "JResponse{code=" + this.code + '}';
    }

    @Override // cn.jiguang.api.JProtocol
    protected void writeBody() {
        int i4 = this.code;
        if (i4 >= 0) {
            writeInt2(i4);
        }
    }
}
