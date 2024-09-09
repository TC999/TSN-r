package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.util.Base64;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b extends AsyncTask<Void, Void, a> {

    /* renamed from: a  reason: collision with root package name */
    private String f51587a;

    /* renamed from: b  reason: collision with root package name */
    private String f51588b;

    /* renamed from: c  reason: collision with root package name */
    private String f51589c;

    /* renamed from: d  reason: collision with root package name */
    private String f51590d;

    /* renamed from: e  reason: collision with root package name */
    private String f51591e;

    /* renamed from: f  reason: collision with root package name */
    private OAuthListener f51592f;

    /* renamed from: g  reason: collision with root package name */
    private c f51593g;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        public OAuthErrCode f51594a;

        /* renamed from: b  reason: collision with root package name */
        public String f51595b;

        /* renamed from: c  reason: collision with root package name */
        public String f51596c;

        /* renamed from: d  reason: collision with root package name */
        public String f51597d;

        /* renamed from: e  reason: collision with root package name */
        public byte[] f51598e;

        private a() {
        }

        public static a a(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String format;
            a aVar = new a();
            if (bArr == null || bArr.length == 0) {
                Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
                oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                        int i4 = jSONObject.getInt("errcode");
                        if (i4 != 0) {
                            Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", Integer.valueOf(i4)));
                            aVar.f51594a = OAuthErrCode.WechatAuth_Err_NormalErr;
                            jSONObject.optString("errmsg");
                            return aVar;
                        }
                        String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                        if (string != null && string.length() != 0) {
                            byte[] decode = Base64.decode(string, 0);
                            if (decode != null && decode.length != 0) {
                                aVar.f51594a = OAuthErrCode.WechatAuth_Err_OK;
                                aVar.f51598e = decode;
                                aVar.f51595b = jSONObject.getString("uuid");
                                String string2 = jSONObject.getString("appname");
                                aVar.f51596c = string2;
                                Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", aVar.f51595b, string2, Integer.valueOf(aVar.f51598e.length)));
                                return aVar;
                            }
                            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                            aVar.f51594a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                            return aVar;
                        }
                        Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                        aVar.f51594a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return aVar;
                    } catch (Exception e4) {
                        format = String.format("parse json fail, ex = %s", e4.getMessage());
                        Log.e("MicroMsg.SDK.GetQRCodeResult", format);
                        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.f51594a = oAuthErrCode;
                        return aVar;
                    }
                } catch (Exception e5) {
                    format = String.format("parse fail, build String fail, ex = %s", e5.getMessage());
                }
            }
            aVar.f51594a = oAuthErrCode;
            return aVar;
        }
    }

    public b(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.f51587a = str;
        this.f51588b = str2;
        this.f51589c = str3;
        this.f51590d = str4;
        this.f51591e = str5;
        this.f51592f = oAuthListener;
    }

    public boolean a() {
        Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        c cVar = this.f51593g;
        return cVar == null ? cancel(true) : cVar.cancel(true);
    }

    @Override // android.os.AsyncTask
    protected a doInBackground(Void[] voidArr) {
        Thread.currentThread().setName("OpenSdkGetQRCodeTask");
        Log.i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
        String format = String.format("https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s", this.f51587a, this.f51589c, this.f51590d, this.f51588b, this.f51591e);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] a4 = com.tencent.mm.opensdk.channel.a.a.a(format, 60000);
        Log.d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        return a.a(a4);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(a aVar) {
        a aVar2 = aVar;
        OAuthErrCode oAuthErrCode = aVar2.f51594a;
        if (oAuthErrCode == OAuthErrCode.WechatAuth_Err_OK) {
            Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success imgBufSize = " + aVar2.f51598e.length);
            this.f51592f.onAuthGotQrcode(aVar2.f51597d, aVar2.f51598e);
            c cVar = new c(aVar2.f51595b, this.f51592f);
            this.f51593g = cVar;
            cVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        Log.e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", oAuthErrCode));
        this.f51592f.onAuthFinish(aVar2.f51594a, null);
    }
}
