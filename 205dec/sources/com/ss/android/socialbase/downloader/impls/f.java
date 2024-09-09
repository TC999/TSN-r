package com.ss.android.socialbase.downloader.impls;

import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class f implements com.ss.android.socialbase.downloader.network.ev {
    @Override // com.ss.android.socialbase.downloader.network.ev
    public com.ss.android.socialbase.downloader.network.r c(String str, List<com.ss.android.socialbase.downloader.model.xv> list) throws IOException {
        OkHttpClient fz = com.ss.android.socialbase.downloader.downloader.xv.fz();
        if (fz != null) {
            Request.Builder head = new Request.Builder().url(str).head();
            if (list != null && list.size() > 0) {
                for (com.ss.android.socialbase.downloader.model.xv xvVar : list) {
                    head.addHeader(xvVar.c(), com.ss.android.socialbase.downloader.gd.f.r(xvVar.w()));
                }
            }
            final Call newCall = fz.newCall(head.build());
            final Response execute = newCall.execute();
            if (execute != null) {
                if (com.ss.android.socialbase.downloader.gd.c.c(2097152)) {
                    execute.close();
                }
                return new com.ss.android.socialbase.downloader.network.r() { // from class: com.ss.android.socialbase.downloader.impls.f.1
                    public String c(String str2) {
                        return execute.header(str2);
                    }

                    public int w() throws IOException {
                        return execute.code();
                    }

                    public void xv() {
                        Call call = newCall;
                        if (call == null || call.isCanceled()) {
                            return;
                        }
                        newCall.cancel();
                    }
                };
            }
            throw new IOException("can't get response");
        }
        throw new IOException("can't get httpClient");
    }
}
