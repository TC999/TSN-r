package com.mbridge.msdk.optimize;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: SimpleDownload.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x00b6 -> B:63:0x00b9). Please submit an issue!!! */
    public static void a(File file, String str, String str2, b bVar) {
        InputStream inputStream;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file2 = new File(file, str + ".apk");
                if (file2.exists()) {
                    file2.delete();
                }
                if (bVar != null) {
                    bVar.a();
                }
                URLConnection openConnection = new URL(str2).openConnection();
                openConnection.setConnectTimeout(AVMDLDataLoader.KeyIsLiveSetLoaderType);
                int contentLength = openConnection.getContentLength();
                double d4 = contentLength;
                Double.isNaN(d4);
                double d5 = 100.0d / d4;
                inputStream = openConnection.getInputStream();
                try {
                    byte[] bArr = new byte[1024];
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2, true);
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                            i4 += read;
                            double d6 = i4;
                            Double.isNaN(d6);
                            int i6 = (int) (d6 * d5);
                            if (i5 >= 512 || i6 == 100) {
                                if (bVar != null) {
                                    bVar.a(i6);
                                }
                                i5 = 0;
                            }
                            i5++;
                        } catch (Throwable unused) {
                            fileOutputStream = fileOutputStream2;
                            if (bVar != null) {
                                try {
                                    bVar.b();
                                } catch (Throwable th) {
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return;
                        }
                    }
                    if (i4 == contentLength && bVar != null) {
                        bVar.a(file2);
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    inputStream.close();
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                inputStream = null;
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        }
    }
}
