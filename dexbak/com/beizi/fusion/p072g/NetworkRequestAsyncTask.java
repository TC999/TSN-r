package com.beizi.fusion.p072g;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.beizi.fusion.g.ah */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NetworkRequestAsyncTask extends AsyncTask<String, Void, String> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        String str = strArr[0];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Log.d("NetworkRequestAsyncTask", "开始请求应用信息:" + str);
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
        } catch (IOException e) {
            Log.e("NetworkRequestAsyncTask", "请求应用信息错误", e);
            return null;
        }
    }
}
