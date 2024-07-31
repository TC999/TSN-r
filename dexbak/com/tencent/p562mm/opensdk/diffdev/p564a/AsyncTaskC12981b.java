package com.tencent.p562mm.opensdk.diffdev.p564a;

import android.os.AsyncTask;
import android.util.Base64;
import com.tencent.p562mm.opensdk.channel.p563a.C12976a;
import com.tencent.p562mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p562mm.opensdk.diffdev.OAuthListener;
import com.tencent.p562mm.opensdk.utils.Log;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class AsyncTaskC12981b extends AsyncTask<Void, Void, C12982a> {

    /* renamed from: a */
    private String f37185a;

    /* renamed from: b */
    private String f37186b;

    /* renamed from: c */
    private String f37187c;

    /* renamed from: d */
    private String f37188d;

    /* renamed from: e */
    private String f37189e;

    /* renamed from: f */
    private OAuthListener f37190f;

    /* renamed from: g */
    private AsyncTaskC12983c f37191g;

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.b$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12982a {

        /* renamed from: a */
        public OAuthErrCode f37192a;

        /* renamed from: b */
        public String f37193b;

        /* renamed from: c */
        public String f37194c;

        /* renamed from: d */
        public String f37195d;

        /* renamed from: e */
        public byte[] f37196e;

        private C12982a() {
        }

        /* renamed from: a */
        public static C12982a m15272a(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String format;
            C12982a c12982a = new C12982a();
            if (bArr == null || bArr.length == 0) {
                Log.m15264e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
                oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                        int i = jSONObject.getInt("errcode");
                        if (i != 0) {
                            Log.m15264e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", Integer.valueOf(i)));
                            c12982a.f37192a = OAuthErrCode.WechatAuth_Err_NormalErr;
                            jSONObject.optString("errmsg");
                            return c12982a;
                        }
                        String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                        if (string != null && string.length() != 0) {
                            byte[] decode = Base64.decode(string, 0);
                            if (decode != null && decode.length != 0) {
                                c12982a.f37192a = OAuthErrCode.WechatAuth_Err_OK;
                                c12982a.f37196e = decode;
                                c12982a.f37193b = jSONObject.getString("uuid");
                                String string2 = jSONObject.getString("appname");
                                c12982a.f37194c = string2;
                                Log.m15265d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", c12982a.f37193b, string2, Integer.valueOf(c12982a.f37196e.length)));
                                return c12982a;
                            }
                            Log.m15264e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                            c12982a.f37192a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                            return c12982a;
                        }
                        Log.m15264e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                        c12982a.f37192a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return c12982a;
                    } catch (Exception e) {
                        format = String.format("parse json fail, ex = %s", e.getMessage());
                        Log.m15264e("MicroMsg.SDK.GetQRCodeResult", format);
                        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                        c12982a.f37192a = oAuthErrCode;
                        return c12982a;
                    }
                } catch (Exception e2) {
                    format = String.format("parse fail, build String fail, ex = %s", e2.getMessage());
                }
            }
            c12982a.f37192a = oAuthErrCode;
            return c12982a;
        }
    }

    public AsyncTaskC12981b(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.f37185a = str;
        this.f37186b = str2;
        this.f37187c = str3;
        this.f37188d = str4;
        this.f37189e = str5;
        this.f37190f = oAuthListener;
    }

    /* renamed from: a */
    public boolean m15273a() {
        Log.m15263i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        AsyncTaskC12983c asyncTaskC12983c = this.f37191g;
        return asyncTaskC12983c == null ? cancel(true) : asyncTaskC12983c.cancel(true);
    }

    @Override // android.os.AsyncTask
    protected C12982a doInBackground(Void[] voidArr) {
        Thread.currentThread().setName("OpenSdkGetQRCodeTask");
        Log.m15263i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
        String format = String.format("https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s", this.f37185a, this.f37187c, this.f37188d, this.f37186b, this.f37189e);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] m15278a = C12976a.m15278a(format, 60000);
        Log.m15265d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        return C12982a.m15272a(m15278a);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(C12982a c12982a) {
        C12982a c12982a2 = c12982a;
        OAuthErrCode oAuthErrCode = c12982a2.f37192a;
        if (oAuthErrCode == OAuthErrCode.WechatAuth_Err_OK) {
            Log.m15265d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success imgBufSize = " + c12982a2.f37196e.length);
            this.f37190f.onAuthGotQrcode(c12982a2.f37195d, c12982a2.f37196e);
            AsyncTaskC12983c asyncTaskC12983c = new AsyncTaskC12983c(c12982a2.f37193b, this.f37190f);
            this.f37191g = asyncTaskC12983c;
            asyncTaskC12983c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        Log.m15264e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", oAuthErrCode));
        this.f37190f.onAuthFinish(c12982a2.f37192a, null);
    }
}
