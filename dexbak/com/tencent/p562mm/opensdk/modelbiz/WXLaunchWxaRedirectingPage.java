package com.tencent.p562mm.opensdk.modelbiz;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.p562mm.opensdk.modelbase.BaseReq;
import com.tencent.p562mm.opensdk.modelbase.BaseResp;

/* renamed from: com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class WXLaunchWxaRedirectingPage {
    public static final String URI_PATH = "launchWxaOpenApiRedirectingPage";

    /* renamed from: com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage$ConstantsWxaRedirectingPage */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    interface ConstantsWxaRedirectingPage {
        public static final String KEY_CALLBACK_ACTIVITY = "_launch_wx_wxa_redirecting_page_callback_activity";
        public static final String KEY_CALLBACK_MSG = "_launch_wx_wxa_redirecting_page_callback_msg";
        public static final String KEY_INVOKE_TICKET = "_launch_wx_wxa_redirecting_page_invoke_ticket";
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage$Req */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXLaunchWxaRedirectingPage.Req";
        public String callbackActivity;
        public String invokeTicket;

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return !TextUtils.isEmpty(this.invokeTicket);
        }

        public void fromArray(String[] strArr) {
            this.invokeTicket = strArr[0];
            this.callbackActivity = strArr[1];
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.invokeTicket = bundle.getString(ConstantsWxaRedirectingPage.KEY_INVOKE_TICKET);
            this.callbackActivity = bundle.getString(ConstantsWxaRedirectingPage.KEY_CALLBACK_ACTIVITY);
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 30;
        }

        public String[] toArray() {
            return new String[]{this.invokeTicket, this.callbackActivity};
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString(ConstantsWxaRedirectingPage.KEY_INVOKE_TICKET, this.invokeTicket);
            bundle.putString(ConstantsWxaRedirectingPage.KEY_CALLBACK_ACTIVITY, this.callbackActivity);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage$Resp */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class Resp extends BaseResp {
        private static final String TAG = "MicroMsg.SDK.WXLaunchWxaFRedirectingPage.Resp";
        public String callbackActivity;
        public String invokeTicket;

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.invokeTicket = bundle.getString(ConstantsWxaRedirectingPage.KEY_INVOKE_TICKET);
            this.callbackActivity = bundle.getString(ConstantsWxaRedirectingPage.KEY_CALLBACK_ACTIVITY);
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 30;
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString(ConstantsWxaRedirectingPage.KEY_INVOKE_TICKET, this.invokeTicket);
            bundle.putString(ConstantsWxaRedirectingPage.KEY_CALLBACK_ACTIVITY, this.callbackActivity);
        }
    }
}
