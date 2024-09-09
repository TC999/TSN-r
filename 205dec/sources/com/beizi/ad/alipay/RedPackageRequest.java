package com.beizi.ad.alipay;

import android.text.TextUtils;
import com.beizi.ad.alipay.RedPackageEnum;
import com.beizi.ad.alipay.inter.Callback;
import com.beizi.ad.alipay.model.AliPayEventBean;
import com.beizi.ad.internal.utilities.GzipUtil;
import com.beizi.ad.internal.utilities.HttpUtil;
import com.beizi.ad.internal.utilities.StringUtil;
import com.beizi.ad.lance.a.a;
import com.beizi.ad.lance.a.k;
import com.beizi.ad.lance.a.l;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\7241516.dex */
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
            l.b(TAG, "url : " + this.url + " , replaceG : " + replaceALiPay);
            String a4 = a.a(k.a(), GzipUtil.compressForGzip(replaceALiPay));
            if (a4 != null) {
                String doPost = HttpUtil.doPost(this.url, a4.getBytes());
                if (!TextUtils.isEmpty(doPost)) {
                    try {
                        JSONObject jSONObject = new JSONObject(doPost);
                        if (jSONObject.optInt("code") == 200 && jSONObject.has("data") && !TextUtils.isEmpty(jSONObject.optString("data"))) {
                            String decompressForGzip = GzipUtil.decompressForGzip(a.b(k.a(), jSONObject.optString("data")));
                            l.b(TAG, "decrypt : " + decompressForGzip);
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
                    } catch (JSONException e4) {
                        Callback callback2 = this.callback;
                        if (callback2 != null) {
                            RedPackageEnum.RedPackageError redPackageError2 = RedPackageEnum.RedPackageError.ERROR_PARSE_EXCEPTION;
                            callback2.failCallback(redPackageError2.getCode(), redPackageError2.getMsg());
                        }
                        l.c(TAG, "e : " + e4);
                        return;
                    }
                }
                Callback callback3 = this.callback;
                if (callback3 != null) {
                    RedPackageEnum.RedPackageError redPackageError3 = RedPackageEnum.RedPackageError.ERROR_REQUEST_PARAM_ERROR;
                    callback3.failCallback(redPackageError3.getCode(), redPackageError3.getMsg());
                }
            }
        } catch (Exception e5) {
            Callback callback4 = this.callback;
            if (callback4 != null) {
                RedPackageEnum.RedPackageError redPackageError4 = RedPackageEnum.RedPackageError.ERROR_REQUEST_EXCEPTION;
                callback4.failCallback(redPackageError4.getCode(), redPackageError4.getMsg());
            }
            l.c(TAG, "e : " + e5);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        doRequest();
    }
}
