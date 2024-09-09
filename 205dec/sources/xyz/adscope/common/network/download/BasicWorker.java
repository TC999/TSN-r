package xyz.adscope.common.network.download;

import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.Kalle;
import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.Url;
import xyz.adscope.common.network.download.Download;
import xyz.adscope.common.network.exception.DownloadError;
import xyz.adscope.common.network.util.IOUtils;
import xyz.adscope.common.network.util.UrlUtils;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class BasicWorker<T extends Download> implements Callable<String> {

    /* renamed from: a  reason: collision with root package name */
    public final T f64916a;

    /* renamed from: b  reason: collision with root package name */
    public String f64917b;

    /* renamed from: c  reason: collision with root package name */
    public String f64918c;

    /* renamed from: d  reason: collision with root package name */
    public Download.ProgressBar f64919d;

    /* renamed from: e  reason: collision with root package name */
    public Download.Policy f64920e;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class AsyncProgressBar implements Download.ProgressBar {

        /* renamed from: a  reason: collision with root package name */
        public final Download.ProgressBar f64921a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f64922b = Kalle.getConfig().getMainExecutor();

        public AsyncProgressBar(Download.ProgressBar progressBar) {
            this.f64921a = progressBar;
        }

        @Override // xyz.adscope.common.network.download.Download.ProgressBar
        public void onProgress(final int i4, final long j4, final long j5) {
            this.f64922b.execute(new Runnable() { // from class: xyz.adscope.common.network.download.BasicWorker.AsyncProgressBar.1
                @Override // java.lang.Runnable
                public void run() {
                    AsyncProgressBar.this.f64921a.onProgress(i4, j4, j5);
                }
            });
        }
    }

    public BasicWorker(T t3) {
        this.f64916a = t3;
        this.f64917b = t3.directory();
        this.f64918c = t3.fileName();
        this.f64919d = new AsyncProgressBar(t3.progressBar());
        this.f64920e = t3.policy();
    }

    public final String a(Headers headers) {
        String contentDisposition = headers.getContentDisposition();
        String str = null;
        if (!TextUtils.isEmpty(contentDisposition)) {
            str = Headers.parseSubValue(contentDisposition, "filename", null);
            if (!TextUtils.isEmpty(str)) {
                str = UrlUtils.urlDecode(str, "utf-8");
                if (str.startsWith("\"") && str.endsWith("\"")) {
                    str = str.substring(1, str.length() - 1);
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            Url url = this.f64916a.url();
            String path = url.getPath();
            if (TextUtils.isEmpty(path)) {
                return Integer.toString(url.toString().hashCode());
            }
            String[] split = path.split(TTPathConst.sSeparator);
            return split[split.length - 1];
        }
        return str;
    }

    public abstract Response a(T t3);

    @Override // java.util.concurrent.Callable
    public String call() {
        File file;
        Response a4;
        int code;
        Headers headers;
        long contentLength;
        long j4;
        int i4;
        if (TextUtils.isEmpty(this.f64917b)) {
            throw new IOException("Please specify the directory.");
        }
        IOUtils.createFolder(new File(this.f64917b));
        try {
            if (TextUtils.isEmpty(this.f64918c)) {
                a4 = a((BasicWorker<T>) this.f64916a);
                code = a4.code();
                headers = a4.headers();
                this.f64918c = a(headers);
                file = new File(this.f64917b, this.f64918c + ".kalle");
            } else {
                file = new File(this.f64917b, this.f64918c + ".kalle");
                if (this.f64920e.isRange() && file.exists()) {
                    this.f64916a.headers().set("Range", "bytes=" + file.length() + "-");
                    a4 = a((BasicWorker<T>) this.f64916a);
                    code = a4.code();
                    headers = a4.headers();
                } else {
                    a4 = a((BasicWorker<T>) this.f64916a);
                    code = a4.code();
                    headers = a4.headers();
                    IOUtils.delFileOrFolder(file);
                }
            }
            if (!this.f64920e.allowDownload(code, headers)) {
                throw new DownloadError(code, headers, "The download policy prohibits the program from continuing to download.");
            }
            File file2 = new File(this.f64917b, this.f64918c);
            if (file2.exists()) {
                String absolutePath = file2.getAbsolutePath();
                if (this.f64920e.oldAvailable(absolutePath, code, headers)) {
                    this.f64919d.onProgress(100, file2.length(), 0L);
                    IOUtils.closeQuietly(a4);
                    return absolutePath;
                }
                IOUtils.delFileOrFolder(file2);
            }
            if (code == 206) {
                String contentRange = headers.getContentRange();
                contentLength = Long.parseLong(contentRange.substring(contentRange.indexOf(47) + 1));
            } else {
                IOUtils.createNewFile(file);
                contentLength = headers.getContentLength();
            }
            long length = file.length();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rws");
            randomAccessFile.seek(length);
            byte[] bArr = new byte[8096];
            long currentTimeMillis = System.currentTimeMillis();
            InputStream stream = a4.body().stream();
            int i5 = 0;
            long j5 = length;
            long j6 = 0;
            long j7 = 0;
            int i6 = 0;
            while (true) {
                int read = stream.read(bArr);
                if (read == -1) {
                    this.f64919d.onProgress(100, j5, j6);
                    file.renameTo(file2);
                    String absolutePath2 = file2.getAbsolutePath();
                    IOUtils.closeQuietly(a4);
                    return absolutePath2;
                }
                randomAccessFile.write(bArr, i5, read);
                long j8 = read;
                j5 += j8;
                j7 += j8;
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 < 400) {
                    i4 = i6;
                } else {
                    long j9 = (1000 * j7) / currentTimeMillis2;
                    if (contentLength != 0) {
                        j4 = j9;
                        int i7 = (int) ((100 * j5) / contentLength);
                        i4 = i6;
                        if (i7 != i4 || j4 != j6) {
                            long currentTimeMillis3 = System.currentTimeMillis();
                            this.f64919d.onProgress(i7, j5, j4);
                            currentTimeMillis = currentTimeMillis3;
                            i6 = i7;
                            j7 = 0;
                            j6 = j4;
                        }
                    } else {
                        j4 = j9;
                        i4 = i6;
                        if (j6 != j4) {
                            long currentTimeMillis4 = System.currentTimeMillis();
                            this.f64919d.onProgress(0, j5, j4);
                            currentTimeMillis = currentTimeMillis4;
                            i6 = i4;
                            j7 = 0;
                            j6 = j4;
                        } else {
                            this.f64919d.onProgress(0, j5, j6);
                        }
                    }
                    i5 = 0;
                }
                i6 = i4;
                i5 = 0;
            }
        } catch (Throwable th) {
            IOUtils.closeQuietly(null);
            throw th;
        }
    }

    public abstract void cancel();
}
