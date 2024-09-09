package com.qq.e.comm.plugin.d.g;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.v0;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f implements d, Callable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private b f42197a;

    @Override // com.qq.e.comm.plugin.d.g.d
    public boolean a(b bVar) {
        if (TextUtils.isEmpty(com.qq.e.comm.plugin.d.a.f())) {
            a(-1, null);
            return false;
        }
        byte[] bArr = bVar.f42196k;
        if (bArr != null && bArr.length != 0) {
            com.qq.e.comm.plugin.d0.e.d b4 = v0.b();
            if (b4 != com.qq.e.comm.plugin.d0.e.d.WIFI && b4 != com.qq.e.comm.plugin.d0.e.d.NET_4G) {
                return false;
            }
            this.f42197a = bVar;
            FutureTask futureTask = new FutureTask(this);
            if (bVar.f42195j) {
                com.qq.e.comm.plugin.d.b.a().postAtFrontOfQueue(futureTask);
            } else {
                futureTask.run();
            }
            try {
                Boolean bool = (Boolean) futureTask.get();
                if (bool == null || !bool.booleanValue()) {
                    return false;
                }
                if (bVar.f42193h != null) {
                    bVar.f42193h.delete();
                    return true;
                }
                return true;
            } catch (InterruptedException e4) {
                a(-998, Log.getStackTraceString(e4));
            } catch (ExecutionException e5) {
                a(-999, Log.getStackTraceString(e5.getCause()));
            } catch (Throwable th) {
                a(-1000, Log.getStackTraceString(th));
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public Boolean call() throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(com.qq.e.comm.plugin.d.a.f()).openConnection();
        httpURLConnection.setConnectTimeout(this.f42197a.f42195j ? 2000 : 4000);
        httpURLConnection.setReadTimeout(this.f42197a.f42195j ? 2000 : 4000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), com.qq.e.comm.plugin.k.a.f44515a));
        bufferedWriter.write("msg=");
        bufferedWriter.write(Base64.encodeToString(this.f42197a.f42196k, 11));
        bufferedWriter.flush();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != 200) {
            a(responseCode, null);
            return Boolean.FALSE;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            sb.append(readLine);
        }
        JSONObject jSONObject = new JSONObject(sb.toString());
        int optInt = jSONObject.optInt("code");
        if (optInt != 0) {
            a(optInt, jSONObject.optString("msg"));
        }
        return Boolean.valueOf(optInt == 0);
    }

    private void a(int i4, String str) {
        com.qq.e.comm.plugin.n0.e eVar = new com.qq.e.comm.plugin.n0.e(9801001);
        eVar.d(i4);
        if (!TextUtils.isEmpty(str)) {
            com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
            dVar.a("msg", str);
            eVar.a(dVar);
        }
        v.a(eVar);
    }
}
