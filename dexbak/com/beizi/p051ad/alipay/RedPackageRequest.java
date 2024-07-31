package com.beizi.p051ad.alipay;

import android.text.TextUtils;
import com.beizi.p051ad.alipay.RedPackageEnum;
import com.beizi.p051ad.alipay.inter.Callback;
import com.beizi.p051ad.alipay.model.AliPayEventBean;
import com.beizi.p051ad.internal.utilities.GzipUtil;
import com.beizi.p051ad.internal.utilities.HttpUtil;
import com.beizi.p051ad.internal.utilities.StringUtil;
import com.beizi.p051ad.lance.p062a.AesUtil;
import com.beizi.p051ad.lance.p062a.KeyGenerator;
import com.beizi.p051ad.lance.p062a.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.beizi.ad.alipay.RedPackageRequest */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RedPackageRequest implements Runnable {
    private static final String TAG = "RedPackageRequest";
    private AliPayEventBean aliPayEventBean;
    private Callback callback;
    private String macroStr;
    private String url;

    public RedPackageRequest(String str, String str2, AliPayEventBean aliPayEventBean, Callback callback) {
        this.url = str;
        this.aliPayEventBean = aliPayEventBean;
        this.callback = callback;
        this.macroStr = str2;
    }

    private void doRequest() {
        try {
            if (TextUtils.isEmpty(this.url)) {
                return;
            }
            String replaceALiPay = StringUtil.replaceALiPay(this.macroStr, this.aliPayEventBean);
            LogUtil.m49045b(TAG, "url : " + this.url + " , replaceG : " + replaceALiPay);
            String m49091a = AesUtil.m49091a(KeyGenerator.m49047a(), GzipUtil.compressForGzip(replaceALiPay));
            if (m49091a != null) {
                String doPost = HttpUtil.doPost(this.url, m49091a.getBytes());
                if (!TextUtils.isEmpty(doPost)) {
                    try {
                        JSONObject jSONObject = new JSONObject(doPost);
                        if (jSONObject.optInt("code") == 200 && jSONObject.has("data") && !TextUtils.isEmpty(jSONObject.optString("data"))) {
                            String decompressForGzip = GzipUtil.decompressForGzip(AesUtil.m49090b(KeyGenerator.m49047a(), jSONObject.optString("data")));
                            LogUtil.m49045b(TAG, "decrypt : " + decompressForGzip);
                            if (this.callback != null && !TextUtils.isEmpty(decompressForGzip)) {
                                this.callback.successCallback(new JSONObject(decompressForGzip));
                            }
                        } else {
                            Callback callback = this.callback;
                            if (callback != null) {
                                RedPackageEnum.RedPackageError redPackageError = RedPackageEnum.RedPackageError.ERROR_PARSE_EXCEPTION;
                                callback.failCallback(redPackageError.getCode(), redPackageError.getMsg());
                            }
                        }
                        return;
                    } catch (JSONException e) {
                        Callback callback2 = this.callback;
                        if (callback2 != null) {
                            RedPackageEnum.RedPackageError redPackageError2 = RedPackageEnum.RedPackageError.ERROR_PARSE_EXCEPTION;
                            callback2.failCallback(redPackageError2.getCode(), redPackageError2.getMsg());
                        }
                        LogUtil.m49044c(TAG, "e : " + e);
                        return;
                    }
                }
                Callback callback3 = this.callback;
                if (callback3 != null) {
                    RedPackageEnum.RedPackageError redPackageError3 = RedPackageEnum.RedPackageError.ERROR_REQUEST_PARAM_ERROR;
                    callback3.failCallback(redPackageError3.getCode(), redPackageError3.getMsg());
                }
            }
        } catch (Exception e2) {
            Callback callback4 = this.callback;
            if (callback4 != null) {
                RedPackageEnum.RedPackageError redPackageError4 = RedPackageEnum.RedPackageError.ERROR_REQUEST_EXCEPTION;
                callback4.failCallback(redPackageError4.getCode(), redPackageError4.getMsg());
            }
            LogUtil.m49044c(TAG, "e : " + e2);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        doRequest();
    }
}
