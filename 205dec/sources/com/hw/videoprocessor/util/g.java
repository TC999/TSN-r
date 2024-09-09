package com.hw.videoprocessor.util;

import android.media.AudioRecord;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: PcmToWavUtil.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private int f37639a;

    /* renamed from: b  reason: collision with root package name */
    private int f37640b;

    /* renamed from: c  reason: collision with root package name */
    private int f37641c;

    /* renamed from: d  reason: collision with root package name */
    private int f37642d;

    /* renamed from: e  reason: collision with root package name */
    private int f37643e;

    public g() {
        this.f37640b = AVMDLDataLoader.KeyIsLiveSetLoaderType;
        this.f37641c = 12;
        this.f37642d = 2;
        this.f37643e = 2;
        this.f37639a = AudioRecord.getMinBufferSize(AVMDLDataLoader.KeyIsLiveSetLoaderType, 12, 2);
    }

    private void b(FileOutputStream fileOutputStream, long j4, long j5, long j6, int i4, long j7) throws IOException {
        fileOutputStream.write(new byte[]{82, 73, 70, 70, (byte) (j5 & 255), (byte) ((j5 >> 8) & 255), (byte) ((j5 >> 16) & 255), (byte) ((j5 >> 24) & 255), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte) i4, 0, (byte) (j6 & 255), (byte) ((j6 >> 8) & 255), (byte) ((j6 >> 16) & 255), (byte) ((j6 >> 24) & 255), (byte) (j7 & 255), (byte) ((j7 >> 8) & 255), (byte) ((j7 >> 16) & 255), (byte) ((j7 >> 24) & 255), 4, 0, 16, 0, 100, 97, 116, 97, (byte) (j4 & 255), (byte) ((j4 >> 8) & 255), (byte) ((j4 >> 16) & 255), (byte) (255 & (j4 >> 24))}, 0, 44);
    }

    public void a(String str, String str2) {
        int i4 = this.f37640b;
        long j4 = i4;
        int i5 = this.f37642d;
        long j5 = ((i4 * 16) * i5) / 8;
        byte[] bArr = new byte[this.f37639a];
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            long size = fileInputStream.getChannel().size();
            b(fileOutputStream, size, size + 36, j4, i5, j5);
            while (fileInputStream.read(bArr) != -1) {
                fileOutputStream.write(bArr);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    public g(int i4, int i5, int i6, int i7) {
        this.f37640b = i4;
        this.f37641c = i5;
        this.f37642d = i6;
        this.f37643e = i7;
        this.f37639a = AudioRecord.getMinBufferSize(i4, i5, i7);
    }
}
