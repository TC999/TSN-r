package com.mbridge.msdk.optimize;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: com.mbridge.msdk.optimize.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SimpleDownload {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x00b6 -> B:63:0x00b9). Please submit an issue!!! */
    /* renamed from: a */
    public static void m21369a(File file, String str, String str2, SimpleDownloadCallback simpleDownloadCallback) {
        InputStream inputStream;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file2 = new File(file, str + ".apk");
                if (file2.exists()) {
                    file2.delete();
                }
                if (simpleDownloadCallback != null) {
                    simpleDownloadCallback.mo21334a();
                }
                URLConnection openConnection = new URL(str2).openConnection();
                openConnection.setConnectTimeout(8000);
                int contentLength = openConnection.getContentLength();
                double d = contentLength;
                Double.isNaN(d);
                double d2 = 100.0d / d;
                inputStream = openConnection.getInputStream();
                try {
                    byte[] bArr = new byte[1024];
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2, true);
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                            i += read;
                            double d3 = i;
                            Double.isNaN(d3);
                            int i3 = (int) (d3 * d2);
                            if (i2 >= 512 || i3 == 100) {
                                if (simpleDownloadCallback != null) {
                                    simpleDownloadCallback.mo21333a(i3);
                                }
                                i2 = 0;
                            }
                            i2++;
                        } catch (Throwable unused) {
                            fileOutputStream = fileOutputStream2;
                            if (simpleDownloadCallback != null) {
                                try {
                                    simpleDownloadCallback.mo21331b();
                                } catch (Throwable th) {
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return;
                        }
                    }
                    if (i == contentLength && simpleDownloadCallback != null) {
                        simpleDownloadCallback.mo21332a(file2);
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    inputStream.close();
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                inputStream = null;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }
}
