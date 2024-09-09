package com.umeng.socialize.net.utils;

import android.text.TextUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UClient {
    private static final String END = "\r\n";
    private static final String TAG = "UClient";

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ResponseObj {
        public int httpResponseCode;
        public JSONObject jsonObject;

        protected ResponseObj() {
        }
    }

    private void addBodyParams(URequest uRequest, OutputStream outputStream, String str) throws IOException {
        boolean z3;
        StringBuilder sb = new StringBuilder();
        Map<String, Object> bodyPair = uRequest.getBodyPair();
        for (String str2 : bodyPair.keySet()) {
            if (bodyPair.get(str2) != null) {
                addFormField(sb, str2, bodyPair.get(str2).toString(), str);
            }
        }
        if (sb.length() > 0) {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.write(sb.toString().getBytes());
            outputStream = dataOutputStream;
            z3 = true;
        } else {
            z3 = false;
        }
        Map<String, URequest.FilePair> filePair = uRequest.getFilePair();
        if (filePair != null && filePair.size() > 0) {
            for (String str3 : filePair.keySet()) {
                URequest.FilePair filePair2 = filePair.get(str3);
                byte[] bArr = filePair2.mBinaryData;
                if (bArr != null && bArr.length >= 1) {
                    addFilePart(filePair2.mFileName, bArr, str, outputStream);
                    z3 = true;
                }
            }
        }
        if (z3) {
            finishWrite(outputStream, str);
        }
    }

    private void addFilePart(String str, byte[] bArr, String str2, OutputStream outputStream) throws IOException {
        outputStream.write(("--" + str2 + "\r\nContent-Disposition: form-data; name=\"pic\"; filename=\"" + str + "\"\r\nContent-Type: application/octet-stream\r\nContent-Transfer-Encoding: binary\r\n\r\n").getBytes());
        outputStream.write(bArr);
        outputStream.write("\r\n".getBytes());
    }

    private void addFormField(StringBuilder sb, String str, String str2, String str3) {
        sb.append("--");
        sb.append(str3);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"");
        sb.append("\r\n");
        sb.append("Content-Type: text/plain; charset=");
        sb.append("UTF-8");
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append(str2);
        sb.append("\r\n");
    }

    private JSONObject decryptData(URequest uRequest, String str) {
        try {
            return new JSONObject(uRequest.getDecryptString(str));
        } catch (Throwable th) {
            SLog.error(UmengText.NET.CREATE, th);
            return null;
        }
    }

    private void finishWrite(OutputStream outputStream, String str) throws IOException {
        outputStream.write("\r\n".getBytes());
        outputStream.write(("--" + str + "--").getBytes());
        outputStream.write("\r\n".getBytes());
        outputStream.flush();
        outputStream.close();
    }

    private ResponseObj httpGetRequest(URequest uRequest) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        try {
            httpURLConnection = openUrlConnection(uRequest);
            if (httpURLConnection == null) {
                closeQuietly(null);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            }
            try {
                int responseCode = httpURLConnection.getResponseCode();
                ResponseObj responseObj = new ResponseObj();
                responseObj.httpResponseCode = responseCode;
                if (responseCode == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        responseObj.jsonObject = parseResult(uRequest, httpURLConnection.getRequestMethod(), httpURLConnection.getContentEncoding(), inputStream);
                        SLog.debug(UmengText.NET.JSONRESULT);
                        closeQuietly(inputStream);
                        httpURLConnection.disconnect();
                        return responseObj;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            SLog.error(UmengText.NET.PARSEERROR, th);
                            return null;
                        } finally {
                            closeQuietly(inputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        }
                    }
                }
                closeQuietly(null);
                httpURLConnection.disconnect();
                return null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            inputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01af A[DONT_GENERATE] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.io.OutputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.umeng.socialize.net.utils.UClient] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.umeng.socialize.net.utils.UClient.ResponseObj httpPostRequest(com.umeng.socialize.net.utils.URequest r10) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.utils.UClient.httpPostRequest(com.umeng.socialize.net.utils.URequest):com.umeng.socialize.net.utils.UClient$ResponseObj");
    }

    private HttpURLConnection openUrlConnection(URequest uRequest) throws IOException {
        String str;
        HttpURLConnection httpURLConnection;
        String trim = uRequest.getHttpMethod().trim();
        if (URequest.GET.equals(trim)) {
            str = uRequest.toGetUrl();
        } else {
            str = URequest.POST.equals(trim) ? uRequest.mBaseUrl : null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        URL url = new URL(str);
        if ("https".equals(url.getProtocol())) {
            httpURLConnection = (HttpsURLConnection) url.openConnection();
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setConnectTimeout(Config.connectionTimeOut);
        httpURLConnection.setReadTimeout(Config.readSocketTimeOut);
        httpURLConnection.setRequestMethod(trim);
        if (URequest.GET.equals(trim)) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            Map<String, String> map = uRequest.mHeaders;
            if (map != null && map.size() > 0) {
                for (String str2 : uRequest.mHeaders.keySet()) {
                    httpURLConnection.setRequestProperty(str2, uRequest.mHeaders.get(str2));
                }
            }
        } else if (URequest.POST.equals(trim)) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
        }
        return httpURLConnection;
    }

    private void verifyMethod(String str) {
        if (TextUtils.isEmpty(str) || URequest.GET.equals(str.trim()) == URequest.POST.equals(str.trim())) {
            throw new RuntimeException(UmengText.netMethodError(str));
        }
    }

    protected void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                SLog.error(UmengText.NET.CLOSE, th);
            }
        }
    }

    protected String convertStreamToString(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader, 512);
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine + "\n");
                } else {
                    closeQuietly(inputStreamReader);
                    closeQuietly(bufferedReader);
                    return sb.toString();
                }
            } catch (Throwable th) {
                try {
                    SLog.error(UmengText.NET.TOOL, th);
                    return null;
                } finally {
                    closeQuietly(inputStreamReader);
                    closeQuietly(bufferedReader);
                }
            }
        }
    }

    protected <T extends UResponse> T createResponse(ResponseObj responseObj, Class<T> cls) {
        if (responseObj == null) {
            return null;
        }
        try {
            return cls.getConstructor(Integer.class, JSONObject.class).newInstance(Integer.valueOf(responseObj.httpResponseCode), responseObj.jsonObject);
        } catch (Throwable th) {
            SLog.error(UmengText.NET.CREATE, th);
            return null;
        }
    }

    public <T extends UResponse> T execute(URequest uRequest, Class<T> cls) {
        ResponseObj httpPostRequest;
        uRequest.onPrepareRequest();
        String trim = uRequest.getHttpMethod().trim();
        verifyMethod(trim);
        if (URequest.GET.equals(trim)) {
            httpPostRequest = httpGetRequest(uRequest);
        } else {
            httpPostRequest = URequest.POST.equals(trim) ? httpPostRequest(uRequest) : null;
        }
        return (T) createResponse(httpPostRequest, cls);
    }

    protected JSONObject parseResult(URequest uRequest, String str, String str2, InputStream inputStream) {
        InputStream inputStream2;
        String convertStreamToString;
        try {
            inputStream2 = wrapStream(str2, inputStream);
            try {
                convertStreamToString = convertStreamToString(inputStream2);
            } catch (Throwable th) {
                th = th;
                try {
                    SLog.error(UmengText.NET.PARSEERROR, th);
                    return null;
                } finally {
                    closeQuietly(inputStream2);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = null;
        }
        if ("POST".equals(str)) {
            return new JSONObject(convertStreamToString);
        }
        if ("GET".equals(str)) {
            if (TextUtils.isEmpty(convertStreamToString)) {
                return null;
            }
            return decryptData(uRequest, convertStreamToString);
        }
        return null;
    }

    protected InputStream wrapStream(String str, InputStream inputStream) throws IOException {
        if (str == null || "identity".equalsIgnoreCase(str)) {
            return inputStream;
        }
        if ("gzip".equalsIgnoreCase(str)) {
            return new GZIPInputStream(inputStream);
        }
        if ("deflate".equalsIgnoreCase(str)) {
            return new InflaterInputStream(inputStream, new Inflater(false), 512);
        }
        throw new RuntimeException("unsupported content-encoding: " + str);
    }
}
