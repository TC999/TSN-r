package xyz.adscope.ad.tool.request;

import android.telephony.mbms.FileInfo;
import java.io.File;
import xyz.adscope.ad.tool.request.inter.BaseHttpRequest;
import xyz.adscope.ad.tool.request.inter.DownloadProgress;
import xyz.adscope.ad.tool.request.inter.IHttpResponseCallback;
import xyz.adscope.common.network.FileBody;
import xyz.adscope.common.network.FormBody;
import xyz.adscope.common.network.JsonBody;
import xyz.adscope.common.network.Kalle;
import xyz.adscope.common.network.ProgressBar;
import xyz.adscope.common.network.download.Callback;
import xyz.adscope.common.network.download.Download;
import xyz.adscope.common.network.simple.SimpleBodyRequest;
import xyz.adscope.common.network.simple.SimpleCallback;
import xyz.adscope.common.network.simple.SimpleResponse;
import xyz.adscope.common.tool.security.AesUtil;
import xyz.adscope.common.tool.security.GzipUtil;
import xyz.adscope.common.tool.security.KeyGenerator;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeHttpRequest extends BaseHttpRequest {
    private String acceptEncrypt = "101,1001";

    @Override // xyz.adscope.ad.tool.request.inter.IHttpRequest
    public void doRequestWithJson(String str, String str2, IHttpResponseCallback iHttpResponseCallback) {
        try {
            Kalle.post(str).body(new JsonBody(AesUtil.encrypt(KeyGenerator.generateAesKey(), GzipUtil.compressForGzip(str2)))).perform(iHttpResponseCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // xyz.adscope.ad.tool.request.inter.IDownloadRequest
    public void downloadFile(String str, String str2, String str3, final DownloadProgress downloadProgress) {
        Kalle.Download.get(str).directory(str2).fileName(str3).onProgress(new Download.ProgressBar() { // from class: xyz.adscope.ad.tool.request.AdScopeHttpRequest.2
            @Override // xyz.adscope.common.network.download.Download.ProgressBar
            public void onProgress(int i4, long j4, long j5) {
                DownloadProgress downloadProgress2 = downloadProgress;
                if (downloadProgress2 != null) {
                    downloadProgress2.onProgress(i4, j4, j5);
                }
            }
        }).perform(new Callback() { // from class: xyz.adscope.ad.tool.request.AdScopeHttpRequest.1
            @Override // xyz.adscope.common.network.download.Callback
            public void onCancel() {
            }

            @Override // xyz.adscope.common.network.download.Callback
            public void onEnd() {
            }

            @Override // xyz.adscope.common.network.download.Callback
            public void onException(Exception exc) {
                DownloadProgress downloadProgress2 = downloadProgress;
                if (downloadProgress2 != null) {
                    downloadProgress2.onException(exc);
                }
            }

            @Override // xyz.adscope.common.network.download.Callback
            public void onFinish(String str4) {
                DownloadProgress downloadProgress2 = downloadProgress;
                if (downloadProgress2 != null) {
                    downloadProgress2.onFinish(str4);
                }
            }

            @Override // xyz.adscope.common.network.download.Callback
            public void onStart() {
                DownloadProgress downloadProgress2 = downloadProgress;
                if (downloadProgress2 != null) {
                    downloadProgress2.onStart();
                }
            }
        });
    }

    @Override // xyz.adscope.ad.tool.request.inter.IHttpRequest
    public void requestWithGetMethod(String str, IHttpResponseCallback iHttpResponseCallback) {
        try {
            Kalle.get(str).perform(iHttpResponseCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // xyz.adscope.ad.tool.request.inter.IHttpRequest
    public void requestWithPostMethod(String str, String str2, IHttpResponseCallback iHttpResponseCallback) {
        try {
            Kalle.post(str).body(new JsonBody(ASNPSecurityUtil.processCompressEncrypt(str2, this.acceptEncrypt))).perform(iHttpResponseCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAcceptEncrypt(String str) {
        this.acceptEncrypt = str;
    }

    public void uploadFile(String str, String str2, IHttpResponseCallback iHttpResponseCallback) {
        ((SimpleBodyRequest.Api) Kalle.post(str).body(new FileBody(new File(str2))).tag(this)).perform(iHttpResponseCallback);
    }

    public void uploadFile(String str, String str2, String str3, IHttpResponseCallback iHttpResponseCallback) {
        FormBody build = FormBody.newBuilder().file(str2, new File(str3)).build();
        build.onProgress(new ProgressBar<FormBody>() { // from class: xyz.adscope.ad.tool.request.AdScopeHttpRequest.3
            @Override // xyz.adscope.common.network.ProgressBar
            public void progress(FormBody formBody, int i4) {
            }
        });
        ((SimpleBodyRequest.Api) Kalle.post(str).body(build).tag(this)).perform(new SimpleCallback<FileInfo>() { // from class: xyz.adscope.ad.tool.request.AdScopeHttpRequest.4
            @Override // xyz.adscope.common.network.simple.Callback
            public void onResponse(SimpleResponse<FileInfo, String> simpleResponse) {
                simpleResponse.isSucceed();
            }
        });
    }
}
