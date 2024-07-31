package com.p521ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.model.C12601bl;
import com.p521ss.android.socialbase.downloader.network.AbstractC12624n;
import com.p521ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12635q;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.p521ss.android.socialbase.downloader.p556q.C12718p;
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

/* renamed from: com.ss.android.socialbase.downloader.impls.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12538h implements IDownloadHttpService {

    /* renamed from: ok */
    private final C12718p<String, OkHttpClient> f35204ok = new C12718p<>(4, 8);

    /* renamed from: ok */
    private OkHttpClient m17585ok(String str, final String str2) {
        try {
            final String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + "_" + str2;
                synchronized (this.f35204ok) {
                    OkHttpClient okHttpClient = this.f35204ok.get(str3);
                    if (okHttpClient != null) {
                        return okHttpClient;
                    }
                    OkHttpClient.Builder m17813io = C12490bl.m17813io();
                    m17813io.dns(new Dns() { // from class: com.ss.android.socialbase.downloader.impls.h.2
                    });
                    OkHttpClient build = m17813io.build();
                    synchronized (this.f35204ok) {
                        this.f35204ok.put(str3, build);
                    }
                    return build;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return C12490bl.m17744zz();
    }

    @Override // com.p521ss.android.socialbase.downloader.network.IDownloadHttpService
    public InterfaceC12635q downloadWithConnection(int i, String str, List<C12601bl> list) throws IOException {
        String str2;
        OkHttpClient m17744zz;
        Request.Builder url = new Request.Builder().url(str);
        if (list == null || list.size() <= 0) {
            str2 = null;
        } else {
            str2 = null;
            for (C12601bl c12601bl : list) {
                String m16999ok = c12601bl.m16999ok();
                if (str2 == null && "ss_d_request_host_ip_114".equals(m16999ok)) {
                    str2 = c12601bl.m17000a();
                } else {
                    url.addHeader(m16999ok, C12713kf.m16591h(c12601bl.m17000a()));
                }
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            m17744zz = m17585ok(str, str2);
        } else {
            m17744zz = C12490bl.m17744zz();
        }
        if (m17744zz != null) {
            final Call newCall = m17744zz.newCall(url.build());
            final Response execute = newCall.execute();
            if (execute != null) {
                final ResponseBody body = execute.body();
                if (body != null) {
                    InputStream byteStream = body.byteStream();
                    String header = execute.header("Content-Encoding");
                    final GZIPInputStream gZIPInputStream = (header == null || !"gzip".equalsIgnoreCase(header) || (byteStream instanceof GZIPInputStream)) ? byteStream : new GZIPInputStream(byteStream);
                    return new AbstractC12624n() { // from class: com.ss.android.socialbase.downloader.impls.h.1
                        @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12620h
                        /* renamed from: a */
                        public int mo16918a() throws IOException {
                            return execute.code();
                        }

                        @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12620h
                        /* renamed from: bl */
                        public void mo16917bl() {
                            Call call = newCall;
                            if (call == null || call.isCanceled()) {
                                return;
                            }
                            newCall.cancel();
                        }

                        @Override // com.p521ss.android.socialbase.downloader.network.AbstractC12625ok
                        /* renamed from: n */
                        public String mo16943n() {
                            return "";
                        }

                        @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12635q
                        /* renamed from: ok */
                        public InputStream mo16909ok() throws IOException {
                            return gZIPInputStream;
                        }

                        @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12635q
                        /* renamed from: s */
                        public void mo16908s() {
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

                        @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12620h
                        /* renamed from: ok */
                        public String mo16912ok(String str3) {
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
