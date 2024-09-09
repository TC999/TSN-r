package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class h implements IDownloadHttpService {
    private final com.ss.android.socialbase.downloader.q.p<String, OkHttpClient> ok = new com.ss.android.socialbase.downloader.q.p<>(4, 8);

    private OkHttpClient ok(String str, final String str2) {
        try {
            final String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + "_" + str2;
                synchronized (this.ok) {
                    OkHttpClient okHttpClient = this.ok.get(str3);
                    if (okHttpClient != null) {
                        return okHttpClient;
                    }
                    OkHttpClient.Builder io2 = com.ss.android.socialbase.downloader.downloader.bl.io();
                    io2.dns(new Dns() { // from class: com.ss.android.socialbase.downloader.impls.h.2
                    });
                    OkHttpClient build = io2.build();
                    synchronized (this.ok) {
                        this.ok.put(str3, build);
                    }
                    return build;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return com.ss.android.socialbase.downloader.downloader.bl.zz();
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
    public com.ss.android.socialbase.downloader.network.q downloadWithConnection(int i4, String str, List<com.ss.android.socialbase.downloader.model.bl> list) throws IOException {
        String str2;
        OkHttpClient zz;
        Request.Builder url = new Request.Builder().url(str);
        if (list == null || list.size() <= 0) {
            str2 = null;
        } else {
            str2 = null;
            for (com.ss.android.socialbase.downloader.model.bl blVar : list) {
                String ok = blVar.ok();
                if (str2 == null && "ss_d_request_host_ip_114".equals(ok)) {
                    str2 = blVar.a();
                } else {
                    url.addHeader(ok, com.ss.android.socialbase.downloader.q.kf.h(blVar.a()));
                }
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            zz = ok(str, str2);
        } else {
            zz = com.ss.android.socialbase.downloader.downloader.bl.zz();
        }
        if (zz != null) {
            final Call newCall = zz.newCall(url.build());
            final Response execute = newCall.execute();
            if (execute != null) {
                final ResponseBody body = execute.body();
                if (body != null) {
                    InputStream byteStream = body.byteStream();
                    String header = execute.header("Content-Encoding");
                    final GZIPInputStream gZIPInputStream = (header == null || !"gzip".equalsIgnoreCase(header) || (byteStream instanceof GZIPInputStream)) ? byteStream : new GZIPInputStream(byteStream);
                    return new com.ss.android.socialbase.downloader.network.n() { // from class: com.ss.android.socialbase.downloader.impls.h.1
                        @Override // com.ss.android.socialbase.downloader.network.h
                        public int a() throws IOException {
                            return execute.code();
                        }

                        @Override // com.ss.android.socialbase.downloader.network.h
                        public void bl() {
                            Call call = newCall;
                            if (call == null || call.isCanceled()) {
                                return;
                            }
                            newCall.cancel();
                        }

                        @Override // com.ss.android.socialbase.downloader.network.ok
                        public String n() {
                            return "";
                        }

                        @Override // com.ss.android.socialbase.downloader.network.q
                        public InputStream ok() throws IOException {
                            return gZIPInputStream;
                        }

                        @Override // com.ss.android.socialbase.downloader.network.q
                        public void s() {
                            try {
                                ResponseBody responseBody = body;
                                if (responseBody != null) {
                                    responseBody.close();
                                }
                                Call call = newCall;
                                if (call == null || call.isCanceled()) {
                                    return;
                                }
                                newCall.cancel();
                            } catch (Throwable unused) {
                            }
                        }

                        @Override // com.ss.android.socialbase.downloader.network.h
                        public String ok(String str3) {
                            return execute.header(str3);
                        }
                    };
                }
                return null;
            }
            throw new IOException("can't get response");
        }
        throw new IOException("can't get httpClient");
    }
}
