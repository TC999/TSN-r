package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TIOStreamTransport.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class dc extends de {

    /* renamed from: a  reason: collision with root package name */
    protected InputStream f52883a;

    /* renamed from: b  reason: collision with root package name */
    protected OutputStream f52884b;

    protected dc() {
        this.f52883a = null;
        this.f52884b = null;
    }

    @Override // com.umeng.analytics.pro.de
    public int a(byte[] bArr, int i4, int i5) throws df {
        InputStream inputStream = this.f52883a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i4, i5);
                if (read >= 0) {
                    return read;
                }
                throw new df(4);
            } catch (IOException e4) {
                throw new df(0, e4);
            }
        }
        throw new df(1, "Cannot read from null inputStream");
    }

    @Override // com.umeng.analytics.pro.de
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.de
    public void b() throws df {
    }

    @Override // com.umeng.analytics.pro.de
    public void b(byte[] bArr, int i4, int i5) throws df {
        OutputStream outputStream = this.f52884b;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i4, i5);
                return;
            } catch (IOException e4) {
                throw new df(0, e4);
            }
        }
        throw new df(1, "Cannot write to null outputStream");
    }

    @Override // com.umeng.analytics.pro.de
    public void c() {
        InputStream inputStream = this.f52883a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            this.f52883a = null;
        }
        OutputStream outputStream = this.f52884b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            this.f52884b = null;
        }
    }

    @Override // com.umeng.analytics.pro.de
    public void d() throws df {
        OutputStream outputStream = this.f52884b;
        if (outputStream != null) {
            try {
                outputStream.flush();
                return;
            } catch (IOException e4) {
                throw new df(0, e4);
            }
        }
        throw new df(1, "Cannot flush null outputStream");
    }

    public dc(InputStream inputStream) {
        this.f52884b = null;
        this.f52883a = inputStream;
    }

    public dc(OutputStream outputStream) {
        this.f52883a = null;
        this.f52884b = outputStream;
    }

    public dc(InputStream inputStream, OutputStream outputStream) {
        this.f52883a = inputStream;
        this.f52884b = outputStream;
    }
}
