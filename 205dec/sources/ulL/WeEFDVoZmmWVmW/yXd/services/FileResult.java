package ulL.WeEFDVoZmmWVmW.yXd.services;

import java.io.InputStream;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class FileResult {
    public final byte[] content;
    public final long mtime;
    public final long size;
    public final InputStream stream;

    public FileResult(long j4, long j5) {
        this.content = null;
        this.stream = null;
        this.size = j4;
        this.mtime = j5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (this.content != null) {
            sb.append("content.length: ");
            sb.append(this.content.length);
            sb.append(", ");
        }
        if (this.stream != null) {
            sb.append("stream: ");
            sb.append(this.stream.toString());
            sb.append(", ");
        }
        sb.append("size: ");
        sb.append(this.size);
        sb.append(", mtime: ");
        sb.append(this.mtime);
        sb.append("}");
        return sb.toString();
    }

    public FileResult(byte[] bArr, long j4, long j5) {
        this.content = bArr;
        this.stream = null;
        this.size = j4;
        this.mtime = j5;
    }

    public FileResult(InputStream inputStream, long j4, long j5) {
        this.content = null;
        this.stream = inputStream;
        this.size = j4;
        this.mtime = j5;
    }
}
