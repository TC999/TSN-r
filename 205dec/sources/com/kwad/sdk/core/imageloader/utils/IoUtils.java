package com.kwad.sdk.core.imageloader.utils;

import com.kwad.sdk.crash.utils.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class IoUtils {
    public static final int CONTINUE_LOADING_PERCENTAGE = 75;
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final int DEFAULT_IMAGE_TOTAL_SIZE = 512000;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface CopyListener {
        boolean onBytesCopied(int i4, int i5);
    }

    private IoUtils() {
    }

    public static boolean copyStream(InputStream inputStream, OutputStream outputStream, CopyListener copyListener) {
        return copyStream(inputStream, outputStream, copyListener, 32768);
    }

    public static String inputStreamToString(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        char[] cArr = new char[1024];
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputStreamReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            while (true) {
                try {
                    int read = inputStreamReader.read(cArr, 0, 1024);
                    if (read >= 0) {
                        sb.append(cArr, 0, read);
                    } else {
                        b.closeQuietly(inputStreamReader);
                        return sb.toString();
                    }
                } catch (Exception unused) {
                    b.closeQuietly(inputStreamReader);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStreamReader2 = inputStreamReader;
                    b.closeQuietly(inputStreamReader2);
                    throw th;
                }
            }
        } catch (Exception unused2) {
            inputStreamReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void readAndCloseStream(InputStream inputStream) {
        do {
            try {
            } catch (IOException unused) {
                return;
            } finally {
                b.closeQuietly(inputStream);
            }
        } while (inputStream.read(new byte[32768], 0, 32768) != -1);
    }

    private static boolean shouldStopLoading(CopyListener copyListener, int i4, int i5) {
        return (copyListener == null || copyListener.onBytesCopied(i4, i5) || (i4 * 100) / i5 >= 75) ? false : true;
    }

    public static boolean copyStream(InputStream inputStream, OutputStream outputStream, CopyListener copyListener, int i4) {
        int available = inputStream.available();
        if (available <= 0) {
            available = 512000;
        }
        byte[] bArr = new byte[i4];
        if (shouldStopLoading(copyListener, 0, available)) {
            return false;
        }
        int i5 = 0;
        do {
            int read = inputStream.read(bArr, 0, i4);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                i5 += read;
            } else {
                outputStream.flush();
                return true;
            }
        } while (!shouldStopLoading(copyListener, i5, available));
        return false;
    }
}
