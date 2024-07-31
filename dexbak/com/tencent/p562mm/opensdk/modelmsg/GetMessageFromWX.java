package com.tencent.p562mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.p562mm.opensdk.modelbase.BaseReq;
import com.tencent.p562mm.opensdk.modelbase.BaseResp;
import com.tencent.p562mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p562mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelmsg.GetMessageFromWX */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class GetMessageFromWX {

    /* renamed from: com.tencent.mm.opensdk.modelmsg.GetMessageFromWX$Req */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class Req extends BaseReq {
        public String country;
        public String lang;
        public String username;

        public Req() {
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.lang = bundle.getString("_wxapi_getmessage_req_lang");
            this.country = bundle.getString("_wxapi_getmessage_req_country");
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 3;
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_getmessage_req_lang", this.lang);
            bundle.putString("_wxapi_getmessage_req_country", this.country);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelmsg.GetMessageFromWX$Resp */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class Resp extends BaseResp {
        private static final String TAG = "MicroMsg.SDK.GetMessageFromWX.Resp";
        public WXMediaMessage message;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            WXMediaMessage wXMediaMessage = this.message;
            if (wXMediaMessage == null) {
                Log.m15264e(TAG, "checkArgs fail, message is null");
                return false;
            }
            return wXMediaMessage.checkArgs();
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.message = WXMediaMessage.Builder.fromBundle(bundle);
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 3;
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
        }
    }

    private GetMessageFromWX() {
    }
}
