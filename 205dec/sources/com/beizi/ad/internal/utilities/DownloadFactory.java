package com.beizi.ad.internal.utilities;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import xyz.adscope.common.network.Headers;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DownloadFactory {
    private static final int BUFFER_SIZE = 8192;
    private static final String TAG = "download";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface Download {
        @UiThread
        void cancel();

        @UiThread
        void destroy();

        @UiThread
        void pause();

        @UiThread
        void register(DownloadDelegate downloadDelegate);

        @UiThread
        void resume();

        @UiThread
        void start(Request request);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface DownloadCode {
        public static final int CHECK_ERROR = 4;
        public static final int NET_ERROR = 2;
        public static final int NO_SPACE = 3;
        public static final int UNKNOWN_ERROR = 5;
        public static final int USER_CANCEL = 1;
        public static final int USER_PAUSE = 6;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface DownloadDelegate {
        @WorkerThread
        boolean onCheck(File file);

        @UiThread
        void onFail(int i4);

        @UiThread
        void onProgress(long j4, long j5);

        @UiThread
        void onSuccess(File file);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class DownloadImpl implements Download, Runnable {
        @Nullable
        private DownloadDelegate mDelegate;
        @Nullable
        private HandlerThread mHandlerThread;
        private Handler mMainHandler = new Handler(Looper.getMainLooper());
        private Request mRequest;
        @Nullable
        private Handler mThreadHandler;

        public DownloadImpl() {
            HandlerThread handlerThread = new HandlerThread("download");
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.mThreadHandler = new Handler(this.mHandlerThread.getLooper());
        }

        private boolean onCheck(File file) {
            DownloadDelegate downloadDelegate = this.mDelegate;
            return downloadDelegate != null && downloadDelegate.onCheck(file);
        }

        private void onFail(final int i4) {
            this.mMainHandler.post(new Runnable() { // from class: com.beizi.ad.internal.utilities.DownloadFactory.DownloadImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    if (DownloadImpl.this.mDelegate != null) {
                        DownloadImpl.this.mDelegate.onFail(i4);
                    }
                }
            });
        }

        private void onProgress(final long j4, final long j5) {
            this.mMainHandler.post(new Runnable() { // from class: com.beizi.ad.internal.utilities.DownloadFactory.DownloadImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DownloadImpl.this.mDelegate != null) {
                        DownloadImpl.this.mDelegate.onProgress(j4, j5);
                    }
                }
            });
        }

        private void onSuccess(final File file) {
            this.mMainHandler.post(new Runnable() { // from class: com.beizi.ad.internal.utilities.DownloadFactory.DownloadImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    if (DownloadImpl.this.mDelegate != null) {
                        DownloadImpl.this.mDelegate.onSuccess(file);
                    }
                }
            });
        }

        @Override // com.beizi.ad.internal.utilities.DownloadFactory.Download
        public void cancel() {
            Request request = this.mRequest;
            if (request != null) {
                request.mUserCancel = true;
            }
        }

        @Override // com.beizi.ad.internal.utilities.DownloadFactory.Download
        public void destroy() {
            HandlerThread handlerThread = this.mHandlerThread;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.mThreadHandler = null;
            this.mHandlerThread = null;
        }

        @Override // com.beizi.ad.internal.utilities.DownloadFactory.Download
        public void pause() {
            Request request = this.mRequest;
            if (request != null) {
                request.mUserPause = true;
            }
        }

        @Override // com.beizi.ad.internal.utilities.DownloadFactory.Download
        public void register(DownloadDelegate downloadDelegate) {
            this.mDelegate = downloadDelegate;
        }

        @Override // com.beizi.ad.internal.utilities.DownloadFactory.Download
        public void resume() {
            Request request = this.mRequest;
            if (request == null) {
                Log.e("download", "Nothing to resume,skip this request!");
            } else if (request.mUserPause) {
                this.mRequest.mUserPause = false;
                Handler handler = this.mThreadHandler;
                if (handler != null) {
                    handler.post(this);
                }
            } else {
                start(new Request(this.mRequest));
            }
        }

        @Override // java.lang.Runnable
        @WorkerThread
        public void run() {
            HttpURLConnection httpURLConnection;
            InputStream inputStream;
            long contentLength;
            Request request = this.mRequest;
            request.mDownloading = true;
            File file = new File(request.mPath);
            if (!file.exists() && !file.mkdirs()) {
                onFail(3);
                return;
            }
            String str = request.mPath + File.separator + request.mName;
            File file2 = new File(str);
            RandomAccessFile randomAccessFile = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL(request.mUrl).openConnection();
                try {
                    if (request.mPosition != 0) {
                        httpURLConnection.setRequestProperty("Range", "bytes=" + request.mPosition + "-");
                    }
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 200 && responseCode != 206) {
                        request.mDownloading = false;
                        onFail(2);
                        inputStream = null;
                    } else {
                        String headerField = httpURLConnection.getHeaderField(Headers.KEY_CONTENT_DISPOSITION);
                        String contentType = httpURLConnection.getContentType();
                        if (Build.VERSION.SDK_INT >= 24) {
                            contentLength = httpURLConnection.getContentLengthLong();
                        } else {
                            contentLength = httpURLConnection.getContentLength();
                        }
                        if (responseCode == 200) {
                            request.mPosition = 0L;
                            request.mTotal = contentLength;
                        }
                        Log.d("download", headerField + contentType);
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            try {
                                byte[] bArr = new byte[8192];
                                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "rw");
                                try {
                                    randomAccessFile2.seek(request.mPosition);
                                    int i4 = 0;
                                    while (true) {
                                        int read = inputStream.read(bArr);
                                        if (read != -1) {
                                            i4++;
                                            randomAccessFile2.write(bArr, 0, read);
                                            Request.access$314(request, read);
                                            if (i4 % 64 == 0) {
                                                if (request.mUserCancel) {
                                                    request.mDownloading = false;
                                                    onFail(1);
                                                    try {
                                                        randomAccessFile2.getFD().sync();
                                                    } catch (IOException unused) {
                                                    }
                                                    try {
                                                        randomAccessFile2.close();
                                                    } catch (IOException unused2) {
                                                    }
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException unused3) {
                                                    }
                                                    httpURLConnection.disconnect();
                                                    return;
                                                } else if (request.mUserPause) {
                                                    request.mDownloading = false;
                                                    onFail(6);
                                                    try {
                                                        randomAccessFile2.getFD().sync();
                                                    } catch (IOException unused4) {
                                                    }
                                                    try {
                                                        randomAccessFile2.close();
                                                    } catch (IOException unused5) {
                                                    }
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException unused6) {
                                                    }
                                                    httpURLConnection.disconnect();
                                                    return;
                                                } else if (i4 % 16 == 0) {
                                                    onProgress(request.mPosition, request.mTotal);
                                                }
                                            }
                                        } else {
                                            randomAccessFile2.getFD().sync();
                                            if (!onCheck(file2)) {
                                                request.mDownloading = false;
                                                onFail(4);
                                            } else {
                                                request.mDownloading = false;
                                                onSuccess(file2);
                                            }
                                            randomAccessFile = randomAccessFile2;
                                        }
                                    }
                                } catch (IOException e4) {
                                    e = e4;
                                    randomAccessFile = randomAccessFile2;
                                    e.printStackTrace();
                                    request.mDownloading = false;
                                    onFail(5);
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.getFD().sync();
                                        } catch (IOException unused7) {
                                        }
                                    }
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (IOException unused8) {
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException unused9) {
                                        }
                                    }
                                    if (httpURLConnection == null) {
                                        return;
                                    }
                                    httpURLConnection.disconnect();
                                } catch (Throwable th) {
                                    th = th;
                                    randomAccessFile = randomAccessFile2;
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.getFD().sync();
                                        } catch (IOException unused10) {
                                        }
                                    }
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (IOException unused11) {
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException unused12) {
                                        }
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (IOException e5) {
                            e = e5;
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.getFD().sync();
                        } catch (IOException unused13) {
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused14) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused15) {
                        }
                    }
                } catch (IOException e6) {
                    e = e6;
                    inputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                }
            } catch (IOException e7) {
                e = e7;
                httpURLConnection = null;
                inputStream = null;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = null;
                inputStream = null;
            }
            httpURLConnection.disconnect();
        }

        @Override // com.beizi.ad.internal.utilities.DownloadFactory.Download
        public void start(Request request) {
            if (!request.mDownloading) {
                Request request2 = this.mRequest;
                if (request2 != null && !request.equals(request2)) {
                    this.mRequest.mUserCancel = true;
                }
                this.mRequest = request;
                request.reset();
                Handler handler = this.mThreadHandler;
                if (handler != null) {
                    handler.post(this);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Invalid request,it's downloading");
        }
    }

    public static Download create() {
        return new DownloadImpl();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class Request {
        public volatile boolean mDownloading;
        private String mName;
        private String mPath;
        private volatile long mPosition;
        private volatile long mTotal;
        private String mUrl;
        public volatile boolean mUserCancel;
        public volatile boolean mUserPause;

        public Request(String str, String str2, String str3) {
            this.mUrl = str;
            this.mPath = str2;
            this.mName = str3;
            reset();
        }

        static /* synthetic */ long access$314(Request request, long j4) {
            long j5 = request.mPosition + j4;
            request.mPosition = j5;
            return j5;
        }

        public void reset() {
            this.mTotal = 0L;
            this.mPosition = 0L;
            this.mUserCancel = false;
            this.mUserPause = false;
            this.mDownloading = false;
        }

        public Request(Request request) {
            this.mUrl = request.mUrl;
            this.mPath = request.mPath;
            this.mName = request.mName;
            reset();
        }
    }
}
