package com.p201hw.videoprocessor.util;

import android.media.AudioRecord;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.hw.videoprocessor.util.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class PcmToWavUtil {

    /* renamed from: a */
    private int f24157a;

    /* renamed from: b */
    private int f24158b;

    /* renamed from: c */
    private int f24159c;

    /* renamed from: d */
    private int f24160d;

    /* renamed from: e */
    private int f24161e;

    public PcmToWavUtil() {
        this.f24158b = 8000;
        this.f24159c = 12;
        this.f24160d = 2;
        this.f24161e = 2;
        this.f24157a = AudioRecord.getMinBufferSize(8000, 12, 2);
    }

    /* renamed from: b */
    private void m34858b(FileOutputStream fileOutputStream, long j, long j2, long j3, int i, long j4) throws IOException {
        fileOutputStream.write(new byte[]{82, 73, 70, 70, (byte) (j2 & 255), (byte) ((j2 >> 8) & 255), (byte) ((j2 >> 16) & 255), (byte) ((j2 >> 24) & 255), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte) i, 0, (byte) (j3 & 255), (byte) ((j3 >> 8) & 255), (byte) ((j3 >> 16) & 255), (byte) ((j3 >> 24) & 255), (byte) (j4 & 255), (byte) ((j4 >> 8) & 255), (byte) ((j4 >> 16) & 255), (byte) ((j4 >> 24) & 255), 4, 0, 16, 0, 100, 97, 116, 97, (byte) (j & 255), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) (255 & (j >> 24))}, 0, 44);
    }

    /* renamed from: a */
    public void m34859a(String str, String str2) {
        int i = this.f24158b;
        long j = i;
        int i2 = this.f24160d;
        long j2 = ((i * 16) * i2) / 8;
        byte[] bArr = new byte[this.f24157a];
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            long size = fileInputStream.getChannel().size();
            m34858b(fileOutputStream, size, size + 36, j, i2, j2);
            while (fileInputStream.read(bArr) != -1) {
                fileOutputStream.write(bArr);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PcmToWavUtil(int i, int i2, int i3, int i4) {
        this.f24158b = i;
        this.f24159c = i2;
        this.f24160d = i3;
        this.f24161e = i4;
        this.f24157a = AudioRecord.getMinBufferSize(i, i2, i4);
    }
}
