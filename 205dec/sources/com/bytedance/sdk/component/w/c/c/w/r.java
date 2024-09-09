package com.bytedance.sdk.component.w.c.c.w;

import com.bytedance.sdk.component.w.c.ia;
import com.bytedance.sdk.component.w.c.p;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends ia {

    /* renamed from: c  reason: collision with root package name */
    HttpURLConnection f30396c;

    /* renamed from: w  reason: collision with root package name */
    InputStream f30397w;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(HttpURLConnection httpURLConnection) throws IOException {
        this.f30396c = httpURLConnection;
        this.f30397w = new ux(httpURLConnection.getInputStream(), httpURLConnection);
    }

    @Override // com.bytedance.sdk.component.w.c.ia
    public long c() {
        try {
            return this.f30396c.getContentLength();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.component.w.c.ia, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f30397w.close();
            this.f30396c.disconnect();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.w.c.ia
    public byte[] sr() {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            while (true) {
                try {
                    int read = this.f30397w.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream2.write(bArr, 0, read);
                } catch (Exception unused) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return new byte[0];
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th;
                }
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            try {
                byteArrayOutputStream2.close();
            } catch (Throwable unused4) {
            }
            return byteArray;
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.bytedance.sdk.component.w.c.ia
    public p ux() {
        if (this.f30396c.getContentType() != null) {
            return p.c(this.f30396c.getContentType());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.w.c.ia
    public String w() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f30397w));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuffer.append(readLine + "\n");
                } else {
                    String stringBuffer2 = stringBuffer.toString();
                    close();
                    return stringBuffer2;
                }
            }
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.w.c.ia
    public InputStream xv() {
        return this.f30397w;
    }
}
