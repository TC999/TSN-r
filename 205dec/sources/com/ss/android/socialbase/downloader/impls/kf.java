package com.ss.android.socialbase.downloader.impls;

import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class kf implements com.ss.android.socialbase.downloader.network.p {
    @Override // com.ss.android.socialbase.downloader.network.p
    public com.ss.android.socialbase.downloader.network.h ok(String str, List<com.ss.android.socialbase.downloader.model.bl> list) throws IOException {
        OkHttpClient zz = com.ss.android.socialbase.downloader.downloader.bl.zz();
        if (zz != null) {
            Request.Builder head = new Request.Builder().url(str).head();
            if (list != null && list.size() > 0) {
                for (com.ss.android.socialbase.downloader.model.bl blVar : list) {
                    head.addHeader(blVar.ok(), com.ss.android.socialbase.downloader.q.kf.h(blVar.a()));
                }
            }
            final Call newCall = zz.newCall(head.build());
            final Response execute = newCall.execute();
            if (execute != null) {
                if (com.ss.android.socialbase.downloader.q.ok.ok(2097152)) {
                    execute.close();
                }
                return new com.ss.android.socialbase.downloader.network.h() { // from class: com.ss.android.socialbase.downloader.impls.kf.1
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

                    @Override // com.ss.android.socialbase.downloader.network.h
                    public String ok(String str2) {
                        return execute.header(str2);
                    }
                };
            }
            throw new IOException("can't get response");
        }
        throw new IOException("can't get httpClient");
    }
}
