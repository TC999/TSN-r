package cn.jpush.android.local;

import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class JPushResponse {
    public ByteBuffer body;
    public int cmd;
    public long rid;
    public long rquestId;

    public JPushResponse(int i4, long j4, long j5, ByteBuffer byteBuffer) {
        this.cmd = i4;
        this.rid = j4;
        this.body = byteBuffer;
        this.rquestId = j5;
    }

    public ByteBuffer getBody() {
        return this.body;
    }

    public int getCmd() {
        return this.cmd;
    }

    public long getRid() {
        return this.rid;
    }

    public long getRquestId() {
        return this.rquestId;
    }

    protected void parseBody() {
    }

    public void setBody(ByteBuffer byteBuffer) {
        this.body = byteBuffer;
    }

    public void setCmd(int i4) {
        this.cmd = i4;
    }

    public void setRid(long j4) {
        this.rid = j4;
    }

    public void setRquestId(long j4) {
        this.rquestId = j4;
    }

    public String toString() {
        return "JPushResponse{cmd=" + this.cmd + ", rid=" + this.rid + ", rquestId=" + this.rquestId + '}';
    }
}
