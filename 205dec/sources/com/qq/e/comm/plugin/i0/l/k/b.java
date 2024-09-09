package com.qq.e.comm.plugin.i0.l.k;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.IDN;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class b extends a {

    /* renamed from: e  reason: collision with root package name */
    private final int f44324e;

    /* renamed from: f  reason: collision with root package name */
    private final String f44325f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(short s3, int i4, String str) {
        this(s3, 0, 1, i4, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f44324e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] b() throws IOException {
        String[] split;
        String str = this.f44325f;
        if (str != null && str.length() != 0) {
            int i4 = this.f44321b;
            if (i4 != 0 && i4 != 1 && i4 != 2 && i4 != 5) {
                throw new IOException("opCode is not valid");
            }
            int i5 = this.f44322c;
            if (i5 != 0 && i5 != 1) {
                throw new IOException("rd is not valid");
            }
            int i6 = this.f44324e;
            if (i6 != 1 && i6 != 28 && i6 != 5 && i6 != 16) {
                throw new IOException("recordType is not valid");
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeShort(this.f44320a);
            dataOutputStream.writeByte((this.f44321b << 3) + this.f44322c);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            for (String str2 : this.f44325f.split("[.\u3002\uff0e\uff61]")) {
                if (str2.length() <= 63) {
                    byte[] bytes = IDN.toASCII(str2).getBytes();
                    dataOutputStream.write(bytes.length);
                    dataOutputStream.write(bytes, 0, bytes.length);
                } else {
                    throw new IOException("host part is too long");
                }
            }
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(this.f44324e);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(1);
            return byteArrayOutputStream.toByteArray();
        }
        throw new IOException("host can not empty");
    }

    b(short s3, int i4, int i5, int i6, String str) {
        this.f44320a = s3;
        this.f44321b = i4;
        this.f44322c = i5;
        this.f44324e = i6;
        this.f44325f = str;
    }
}
