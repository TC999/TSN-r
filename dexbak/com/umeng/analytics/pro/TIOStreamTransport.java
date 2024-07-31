package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.umeng.analytics.pro.dc */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TIOStreamTransport extends TTransport {

    /* renamed from: a */
    protected InputStream f38162a;

    /* renamed from: b */
    protected OutputStream f38163b;

    protected TIOStreamTransport() {
        this.f38162a = null;
        this.f38163b = null;
    }

    @Override // com.umeng.analytics.pro.TTransport
    /* renamed from: a */
    public int mo14383a(byte[] bArr, int i, int i2) throws TTransportException {
        InputStream inputStream = this.f38162a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i, i2);
                if (read >= 0) {
                    return read;
                }
                throw new TTransportException(4);
            } catch (IOException e) {
                throw new TTransportException(0, e);
            }
        }
        throw new TTransportException(1, "Cannot read from null inputStream");
    }

    @Override // com.umeng.analytics.pro.TTransport
    /* renamed from: a */
    public boolean mo14385a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.TTransport
    /* renamed from: b */
    public void mo14382b() throws TTransportException {
    }

    @Override // com.umeng.analytics.pro.TTransport
    /* renamed from: b */
    public void mo14380b(byte[] bArr, int i, int i2) throws TTransportException {
        OutputStream outputStream = this.f38163b;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i, i2);
                return;
            } catch (IOException e) {
                throw new TTransportException(0, e);
            }
        }
        throw new TTransportException(1, "Cannot write to null outputStream");
    }

    @Override // com.umeng.analytics.pro.TTransport
    /* renamed from: c */
    public void mo14379c() {
        InputStream inputStream = this.f38162a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f38162a = null;
        }
        OutputStream outputStream = this.f38163b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f38163b = null;
        }
    }

    @Override // com.umeng.analytics.pro.TTransport
    /* renamed from: d */
    public void mo14378d() throws TTransportException {
        OutputStream outputStream = this.f38163b;
        if (outputStream != null) {
            try {
                outputStream.flush();
                return;
            } catch (IOException e) {
                throw new TTransportException(0, e);
            }
        }
        throw new TTransportException(1, "Cannot flush null outputStream");
    }

    public TIOStreamTransport(InputStream inputStream) {
        this.f38163b = null;
        this.f38162a = inputStream;
    }

    public TIOStreamTransport(OutputStream outputStream) {
        this.f38162a = null;
        this.f38163b = outputStream;
    }

    public TIOStreamTransport(InputStream inputStream, OutputStream outputStream) {
        this.f38162a = inputStream;
        this.f38163b = outputStream;
    }
}
