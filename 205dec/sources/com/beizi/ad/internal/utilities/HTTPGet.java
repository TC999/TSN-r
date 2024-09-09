package com.beizi.ad.internal.utilities;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import com.beizi.ad.internal.h;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class HTTPGet extends AsyncTask<Void, Void, HTTPResponse> {
    private static String TAG = "HTTPGet";
    private boolean isReturnResponse;
    private boolean mBinaryStream;

    public HTTPGet(boolean z3, boolean z4) {
        this.mBinaryStream = z3;
        this.isReturnResponse = z4;
    }

    private HttpURLConnection createConnection(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("GET");
        return httpURLConnection;
    }

    private void setConnectionParams(HttpURLConnection httpURLConnection) throws ProtocolException {
        httpURLConnection.setRequestProperty("User-Agent", h.a().f13806e);
    }

    protected abstract String getUrl();

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.AsyncTask
    public abstract void onPostExecute(HTTPResponse hTTPResponse);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e0, code lost:
        if (0 == 0) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0062 A[Catch: all -> 0x009f, Exception -> 0x00a1, IOException -> 0x00b7, MalformedURLException -> 0x00cd, TryCatch #3 {MalformedURLException -> 0x00cd, IOException -> 0x00b7, Exception -> 0x00a1, blocks: (B:3:0x0009, B:5:0x0018, B:7:0x0026, B:13:0x005d, B:15:0x0062, B:16:0x006e, B:18:0x0072, B:19:0x007f, B:21:0x0086, B:22:0x008a, B:24:0x0091, B:25:0x009b), top: B:44:0x0009, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0072 A[Catch: all -> 0x009f, Exception -> 0x00a1, IOException -> 0x00b7, MalformedURLException -> 0x00cd, TryCatch #3 {MalformedURLException -> 0x00cd, IOException -> 0x00b7, Exception -> 0x00a1, blocks: (B:3:0x0009, B:5:0x0018, B:7:0x0026, B:13:0x005d, B:15:0x0062, B:16:0x006e, B:18:0x0072, B:19:0x007f, B:21:0x0086, B:22:0x008a, B:24:0x0091, B:25:0x009b), top: B:44:0x0009, outer: #3 }] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.beizi.ad.internal.utilities.HTTPResponse doInBackground(java.lang.Void... r8) {
        /*
            r7 = this;
            java.lang.String r8 = "An HTTP request with an invalid URL was attempted."
            com.beizi.ad.internal.utilities.HTTPResponse r0 = new com.beizi.ad.internal.utilities.HTTPResponse
            r0.<init>()
            r1 = 0
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            java.lang.String r4 = r7.getUrl()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            java.lang.String r4 = r3.getHost()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            if (r4 != 0) goto L26
            java.lang.String r3 = com.beizi.ad.internal.utilities.HaoboLog.httpReqLogTag     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            r4.<init>(r8)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            com.beizi.ad.internal.utilities.HaoboLog.w(r3, r8, r4)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            r0.setSucceeded(r1)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            return r0
        L26:
            java.net.HttpURLConnection r2 = r7.createConnection(r3)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            r7.setConnectionParams(r2)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            r2.connect()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            int r8 = r2.getResponseCode()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            java.lang.String r3 = com.beizi.ad.internal.utilities.HTTPGet.TAG     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            r4.<init>()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            java.lang.String r5 = "HTTPGet code:"
            r4.append(r5)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            r4.append(r8)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            com.beizi.ad.lance.a.l.a(r3, r4)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            java.util.Map r3 = r2.getHeaderFields()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            r0.setHeaders(r3)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 302(0x12e, float:4.23E-43)
            if (r8 == r3) goto L5c
            if (r8 != r4) goto L5a
            goto L5c
        L5a:
            r3 = 0
            goto L5d
        L5c:
            r3 = 1
        L5d:
            r0.setSucceeded(r3)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            if (r8 != r4) goto L6e
            r0.setCode(r8)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            java.lang.String r8 = "Location"
            java.lang.String r8 = r2.getHeaderField(r8)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            r0.setLocationUrl(r8)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
        L6e:
            boolean r8 = r7.isReturnResponse     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            if (r8 == 0) goto Le2
            java.io.InputStream r8 = r2.getInputStream()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            r3.<init>()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
        L7f:
            int r5 = r8.read(r4)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            r6 = -1
            if (r5 == r6) goto L8a
            r3.write(r4, r1, r5)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            goto L7f
        L8a:
            r8.close()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            boolean r8 = r7.mBinaryStream     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            if (r8 != 0) goto L9b
            java.lang.String r8 = "UTF-8"
            java.lang.String r8 = r3.toString(r8)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            r0.setResponseBody(r8)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            goto Le2
        L9b:
            r0.setResponseBinaryBody(r3)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1 java.io.IOException -> Lb7 java.net.MalformedURLException -> Lcd
            goto Le2
        L9f:
            r8 = move-exception
            goto Le6
        La1:
            r0.setSucceeded(r1)     // Catch: java.lang.Throwable -> L9f
            com.beizi.ad.internal.utilities.HttpErrorCode r8 = com.beizi.ad.internal.utilities.HttpErrorCode.TRANSPORT_ERROR     // Catch: java.lang.Throwable -> L9f
            r0.setErrorCode(r8)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r8 = com.beizi.ad.internal.utilities.HaoboLog.httpReqLogTag     // Catch: java.lang.Throwable -> L9f
            int r1 = com.beizi.ad.R.string.http_io     // Catch: java.lang.Throwable -> L9f
            java.lang.String r1 = com.beizi.ad.internal.utilities.HaoboLog.getString(r1)     // Catch: java.lang.Throwable -> L9f
            com.beizi.ad.internal.utilities.HaoboLog.e(r8, r1)     // Catch: java.lang.Throwable -> L9f
            if (r2 == 0) goto Le5
            goto Le2
        Lb7:
            r0.setSucceeded(r1)     // Catch: java.lang.Throwable -> L9f
            com.beizi.ad.internal.utilities.HttpErrorCode r8 = com.beizi.ad.internal.utilities.HttpErrorCode.TRANSPORT_ERROR     // Catch: java.lang.Throwable -> L9f
            r0.setErrorCode(r8)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r8 = com.beizi.ad.internal.utilities.HaoboLog.httpReqLogTag     // Catch: java.lang.Throwable -> L9f
            int r1 = com.beizi.ad.R.string.http_io     // Catch: java.lang.Throwable -> L9f
            java.lang.String r1 = com.beizi.ad.internal.utilities.HaoboLog.getString(r1)     // Catch: java.lang.Throwable -> L9f
            com.beizi.ad.internal.utilities.HaoboLog.e(r8, r1)     // Catch: java.lang.Throwable -> L9f
            if (r2 == 0) goto Le5
            goto Le2
        Lcd:
            r0.setSucceeded(r1)     // Catch: java.lang.Throwable -> L9f
            com.beizi.ad.internal.utilities.HttpErrorCode r8 = com.beizi.ad.internal.utilities.HttpErrorCode.URL_FORMAT_ERROR     // Catch: java.lang.Throwable -> L9f
            r0.setErrorCode(r8)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r8 = com.beizi.ad.internal.utilities.HaoboLog.httpReqLogTag     // Catch: java.lang.Throwable -> L9f
            int r1 = com.beizi.ad.R.string.http_url_malformed     // Catch: java.lang.Throwable -> L9f
            java.lang.String r1 = com.beizi.ad.internal.utilities.HaoboLog.getString(r1)     // Catch: java.lang.Throwable -> L9f
            com.beizi.ad.internal.utilities.HaoboLog.e(r8, r1)     // Catch: java.lang.Throwable -> L9f
            if (r2 == 0) goto Le5
        Le2:
            r2.disconnect()
        Le5:
            return r0
        Le6:
            if (r2 == 0) goto Leb
            r2.disconnect()
        Leb:
            goto Led
        Lec:
            throw r8
        Led:
            goto Lec
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.internal.utilities.HTTPGet.doInBackground(java.lang.Void[]):com.beizi.ad.internal.utilities.HTTPResponse");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @TargetApi(11)
    public void onCancelled(HTTPResponse hTTPResponse) {
        super.onCancelled((HTTPGet) null);
    }
}
