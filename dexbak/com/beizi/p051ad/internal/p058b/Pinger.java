package com.beizi.p051ad.internal.p058b;

import android.text.TextUtils;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.lance.p062a.C3019b;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.beizi.ad.internal.b.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Pinger {

    /* renamed from: a */
    private final ExecutorService f10048a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    private final String f10049b;

    /* renamed from: c */
    private final int f10050c;

    /* compiled from: Pinger.java */
    /* renamed from: com.beizi.ad.internal.b.j$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private class CallableC2872a implements Callable<Boolean> {
        private CallableC2872a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            return Boolean.valueOf(Pinger.this.m49579a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pinger(String str, int i) {
        this.f10049b = (String) Preconditions.m49572a(str);
        this.f10050c = i;
    }

    /* renamed from: b */
    private String m49574b() {
        String m49089a = C3019b.m49089a("aHR0cDovLyVzOiVkLyVz");
        if (TextUtils.isEmpty(m49089a)) {
            return null;
        }
        return String.format(Locale.US, m49089a, this.f10049b, Integer.valueOf(this.f10050c), "ping");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m49578a(int i, int i2) {
        Preconditions.m49570a(i >= 1);
        Preconditions.m49570a(i2 > 0);
        int i3 = 0;
        while (i3 < i) {
            try {
            } catch (InterruptedException e) {
                e = e;
                HaoboLog.m49289e(HaoboLog.pingerLogTag, "Error pinging server due to unexpected error", e);
            } catch (ExecutionException e2) {
                e = e2;
                HaoboLog.m49289e(HaoboLog.pingerLogTag, "Error pinging server due to unexpected error", e);
            } catch (TimeoutException unused) {
                String str = HaoboLog.pingerLogTag;
                HaoboLog.m49284w(str, "Error pinging server (attempt: " + i3 + ", timeout: " + i2 + "). ");
            }
            if (((Boolean) this.f10048a.submit(new CallableC2872a()).get(i2, TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            i3++;
            i2 *= 2;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m49576a(String str) {
        return "ping".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m49575a(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m49579a() throws ProxyCacheException {
        HttpUrlSource httpUrlSource = new HttpUrlSource(m49574b());
        try {
            byte[] bytes = "ping ok".getBytes();
            httpUrlSource.mo49544a(0);
            byte[] bArr = new byte[bytes.length];
            httpUrlSource.mo49543a(bArr);
            boolean equals = Arrays.equals(bytes, bArr);
            String str = HaoboLog.pingerLogTag;
            HaoboLog.m49288i(str, "Ping response: `" + new String(bArr) + "`, pinged? " + equals);
            return equals;
        } catch (ProxyCacheException e) {
            HaoboLog.m49289e(HaoboLog.pingerLogTag, "Error reading ping response", e);
            return false;
        } finally {
            httpUrlSource.mo49542b();
        }
    }
}
