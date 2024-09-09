package xyz.adscope.amps.tool.request;

import android.telephony.mbms.FileInfo;
import java.io.File;
import xyz.adscope.amps.manager.AMPSSDKManager;
import xyz.adscope.amps.model.AMPSGlobalModel;
import xyz.adscope.amps.tool.AMPSSecurityUtil;
import xyz.adscope.amps.tool.request.inter.BaseHttpRequest;
import xyz.adscope.amps.tool.request.inter.IHttpResponseCallback;
import xyz.adscope.common.network.FileBody;
import xyz.adscope.common.network.FormBody;
import xyz.adscope.common.network.JsonBody;
import xyz.adscope.common.network.Kalle;
import xyz.adscope.common.network.ProgressBar;
import xyz.adscope.common.network.simple.SimpleBodyRequest;
import xyz.adscope.common.network.simple.SimpleCallback;
import xyz.adscope.common.network.simple.SimpleResponse;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSHttpRequest extends BaseHttpRequest {
    @Override // xyz.adscope.amps.tool.request.inter.IHttpRequest
    public void doRequestWithJson(String str, String str2, IHttpResponseCallback iHttpResponseCallback) {
        requestWithPostMethod(str, str2, iHttpResponseCallback);
    }

    @Override // xyz.adscope.amps.tool.request.inter.IHttpRequest
    public void requestWithGetMethod(String str, IHttpResponseCallback iHttpResponseCallback) {
        try {
            Kalle.get(str).perform(iHttpResponseCallback);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.tool.request.inter.IHttpRequest
    public void requestWithPostMethod(String str, String str2, IHttpResponseCallback iHttpResponseCallback) {
        try {
            AMPSGlobalModel globalModel = AMPSSDKManager.getInstance().getIAMPSInitInterface().getGlobalModel();
            Kalle.post(str).body(new JsonBody(AMPSSecurityUtil.processCompressEncrypt(str2, globalModel != null ? globalModel.getAcceptEncrypt() : "101,1001"))).perform(iHttpResponseCallback);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void uploadFile(String str, String str2, IHttpResponseCallback iHttpResponseCallback) {
        ((SimpleBodyRequest.Api) Kalle.post(str).body(new FileBody(new File(str2))).tag(this)).perform(iHttpResponseCallback);
    }

    public void uploadFile(String str, String str2, String str3, IHttpResponseCallback iHttpResponseCallback) {
        FormBody build = FormBody.newBuilder().file(str2, new File(str3)).build();
        build.onProgress(new ProgressBar<FormBody>() { // from class: xyz.adscope.amps.tool.request.AMPSHttpRequest.1
            @Override // xyz.adscope.common.network.ProgressBar
            public void progress(FormBody formBody, int i4) {
            }
        });
        ((SimpleBodyRequest.Api) Kalle.post(str).body(build).tag(this)).perform(new SimpleCallback<FileInfo>() { // from class: xyz.adscope.amps.tool.request.AMPSHttpRequest.2
            @Override // xyz.adscope.common.network.simple.Callback
            public void onResponse(SimpleResponse<FileInfo, String> simpleResponse) {
                simpleResponse.isSucceed();
            }
        });
    }
}
