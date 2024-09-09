package com.beizi.fusion.g;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: NetworkRequestAsyncTask.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ah extends AsyncTask<String, Void, String> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        String str = strArr[0];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Log.d("NetworkRequestAsyncTask", "\u5f00\u59cb\u8bf7\u6c42\u5e94\u7528\u4fe1\u606f:" + str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.connect();
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    inputStreamReader.close();
                    return sb.toString();
                }
            }
        } catch (IOException e4) {
            Log.e("NetworkRequestAsyncTask", "\u8bf7\u6c42\u5e94\u7528\u4fe1\u606f\u9519\u8bef", e4);
            return null;
        }
    }
}
