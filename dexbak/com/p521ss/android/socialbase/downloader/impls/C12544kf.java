package com.p521ss.android.socialbase.downloader.impls;

import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.model.C12601bl;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12620h;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12634p;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.p521ss.android.socialbase.downloader.p556q.C12717ok;
import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* renamed from: com.ss.android.socialbase.downloader.impls.kf */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12544kf implements InterfaceC12634p {
    @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12634p
    /* renamed from: ok */
    public InterfaceC12620h mo16910ok(String str, List<C12601bl> list) throws IOException {
        OkHttpClient m17744zz = C12490bl.m17744zz();
        if (m17744zz != null) {
            Request.Builder head = new Request.Builder().url(str).head();
            if (list != null && list.size() > 0) {
                for (C12601bl c12601bl : list) {
                    head.addHeader(c12601bl.m16999ok(), C12713kf.m16591h(c12601bl.m17000a()));
                }
            }
            final Call newCall = m17744zz.newCall(head.build());
            final Response execute = newCall.execute();
            if (execute != null) {
                if (C12717ok.m16510ok(2097152)) {
                    execute.close();
                }
                return new InterfaceC12620h() { // from class: com.ss.android.socialbase.downloader.impls.kf.1
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

                    @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12620h
                    /* renamed from: ok */
                    public String mo16912ok(String str2) {
                        return execute.header(str2);
                    }
                };
            }
            throw new IOException("can't get response");
        }
        throw new IOException("can't get httpClient");
    }
}
