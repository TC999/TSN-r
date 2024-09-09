package cn.jiguang.api;

import cn.jiguang.api.utils.ProtocolUtil;
import cn.jiguang.cl.c;
import cn.jiguang.cl.d;
import cn.jiguang.cl.f;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class JProtocol {
    public static final int DEFAULT_RESP_CODE = 0;
    public static final int DEFAULT_RID = 0;
    public static final int DEFAULT_SID = 0;
    public static final int NO_JUID = -1;
    public static final int NO_RESP_CODE = -1;
    public static final int NO_SID = -1;
    private static final int PACKET_SIZE = 7168;
    private static final String TAG = "JProtocol";
    protected ByteBuffer body;
    protected c head;
    private boolean isRequest;

    public JProtocol(boolean z3, int i4, int i5, long j4) {
        this.isRequest = z3;
        this.head = new c(z3, i4, i5, j4);
        this.body = ByteBuffer.allocate(PACKET_SIZE);
    }

    public JProtocol(boolean z3, int i4, int i5, long j4, int i6, long j5) {
        this.isRequest = z3;
        this.head = new c(z3, 0, i4, i5, j4, i6, j5);
        this.body = ByteBuffer.allocate(PACKET_SIZE);
    }

    public JProtocol(boolean z3, Object obj, ByteBuffer byteBuffer) {
        this.isRequest = z3;
        this.head = (c) obj;
        if (byteBuffer == null) {
            d.c(TAG, "No body to parse.");
            return;
        }
        this.body = byteBuffer;
        parseBody();
    }

    public JProtocol(boolean z3, ByteBuffer byteBuffer, byte[] bArr) {
        this.isRequest = z3;
        try {
            this.head = new c(z3, bArr);
        } catch (Exception e4) {
            d.c(TAG, "create JHead failed:" + e4.getMessage());
        }
        if (byteBuffer == null) {
            d.c(TAG, "No body to parse.");
            return;
        }
        this.body = byteBuffer;
        parseBody();
    }

    public static byte[] parseHead(Object obj) {
        String str;
        if (obj == null) {
            str = "object was null";
        } else if (obj instanceof c) {
            return ((c) obj).f();
        } else {
            str = "unknow Object";
        }
        d.c(TAG, str);
        return null;
    }

    private final byte[] toBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = ProtocolUtil.getBytes(this.body);
        if (bytes == null) {
            d.c(TAG, "toBytes bodyBytes  is  null");
            return null;
        }
        this.head.a((this.isRequest ? 24 : 20) + bytes.length);
        try {
            byteArrayOutputStream.write(this.head.f());
            byteArrayOutputStream.write(bytes);
        } catch (Exception unused) {
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        d.b(TAG, "Final - len:" + byteArray.length + ", bytes: " + f.a(byteArray));
        return byteArray;
    }

    public ByteBuffer getBody() {
        return this.body;
    }

    public int getCommand() {
        return this.head.a();
    }

    public c getHead() {
        return this.head;
    }

    public long getJuid() {
        return this.head.c();
    }

    public abstract String getName();

    public Long getRid() {
        return this.head.b();
    }

    public int getSid() {
        return this.head.d();
    }

    public int getVersion() {
        return this.head.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isNeedParseeErrorMsg();

    protected abstract void parseBody();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.isRequest ? "[Request]" : "[Response]");
        sb.append(" - ");
        sb.append(this.head.toString());
        return sb.toString();
    }

    protected abstract void writeBody();

    public final byte[] writeBodyAndToBytes() {
        this.body.clear();
        writeBody();
        this.body.flip();
        return toBytes();
    }

    protected void writeBytes(byte[] bArr) {
        this.body.put(bArr);
    }

    protected void writeInt1(int i4) {
        this.body.put((byte) i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeInt2(int i4) {
        this.body.putShort((short) i4);
    }

    protected void writeInt4(int i4) {
        this.body.putInt(i4);
    }

    protected void writeLong8(long j4) {
        this.body.putLong(j4);
    }

    protected void writeTlv2(String str) {
        this.body.put(ProtocolUtil.tlv2ToByteArray(str));
    }
}
