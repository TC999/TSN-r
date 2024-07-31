package com.kwad.sdk.crash.report.upload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.AbstractC10436l;
import com.kwad.sdk.core.network.AbstractC10439o;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.utils.C10745g;
import com.kwad.sdk.utils.C11029av;
import com.kwad.sdk.utils.C11122q;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.crash.report.upload.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10731d {
    /* renamed from: a */
    public static void m25016a(@NonNull final File file, boolean z, @Nullable final CountDownLatch countDownLatch) {
        C10331c.m26254d("AdExceptionCollector", "upload()" + Thread.currentThread());
        final C10736f c10736f = new C10736f();
        c10736f.aHH = C11029av.getDeviceId();
        HashMap hashMap = new HashMap();
        hashMap.put("mLogUUID", C10745g.m24964fG(file.getName()));
        c10736f.aHJ = new JSONObject(hashMap).toString();
        c10736f.aHK = C11122q.getExtension(file.getName());
        c10736f.aHM = file;
        new AbstractC10436l<C10730c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10402a
            @NonNull
            /* renamed from: Id */
            public C10730c createRequest() {
                return new C10730c(C11029av.getDeviceId(), C10736f.this.aHF, "zip");
            }

            @NonNull
            /* renamed from: fF */
            private static GetUploadTokenResult m25014fF(String str) {
                JSONObject jSONObject = new JSONObject(str);
                GetUploadTokenResult getUploadTokenResult = new GetUploadTokenResult();
                getUploadTokenResult.parseJson(jSONObject);
                return getUploadTokenResult;
            }

            @Override // com.kwad.sdk.core.network.AbstractC10436l
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.AbstractC10436l
            @NonNull
            public final /* synthetic */ GetUploadTokenResult parseData(String str) {
                return m25014fF(str);
            }
        }.request(new AbstractC10439o<C10730c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onSuccess(@NonNull C10730c c10730c, @NonNull GetUploadTokenResult getUploadTokenResult) {
                C10331c.m26254d("AdExceptionCollector", "onSuccess url=" + c10730c.getUrl() + " ---{" + getUploadTokenResult.uploadToken);
                if (getUploadTokenResult.isResultOk()) {
                    C10736f c10736f2 = C10736f.this;
                    c10736f2.aHL = getUploadTokenResult.uploadToken;
                    C10729b.m25019a(file, c10736f2, new InterfaceC10728a() { // from class: com.kwad.sdk.crash.report.upload.d.2.1
                        @Override // com.kwad.sdk.crash.report.upload.InterfaceC10728a
                        /* renamed from: Ib */
                        public final void mo25011Ib() {
                            CountDownLatch countDownLatch2 = countDownLatch;
                            if (countDownLatch2 != null) {
                                countDownLatch2.countDown();
                            }
                        }

                        @Override // com.kwad.sdk.crash.report.upload.InterfaceC10728a
                        /* renamed from: Ic */
                        public final void mo25010Ic() {
                            C10331c.m26254d("AdExceptionCollector", "uploadLogFile onSuccess " + Thread.currentThread() + " delete file:" + file.getPath());
                            CountDownLatch countDownLatch2 = countDownLatch;
                            if (countDownLatch2 != null) {
                                countDownLatch2.countDown();
                            }
                            C107332 c107332 = C107332.this;
                            if (r4) {
                                C11122q.delete(file.getPath());
                            }
                        }
                    });
                }
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final /* synthetic */ void onError(@NonNull InterfaceC10420f interfaceC10420f, int i, String str) {
                m25013a((C10730c) interfaceC10420f, i, str);
            }

            /* renamed from: a */
            private static void m25013a(@NonNull C10730c c10730c, int i, String str) {
                C10331c.m26254d("AdExceptionCollector", "onError errorCode=" + i + "errorMsg=" + str + "url=" + c10730c.getUrl());
            }
        });
    }
}
