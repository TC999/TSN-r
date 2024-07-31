package com.tencent.p562mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.p562mm.opensdk.modelbase.BaseReq;
import com.tencent.p562mm.opensdk.modelbase.BaseResp;

/* renamed from: com.tencent.mm.opensdk.modelbiz.WXOpenCustomerServiceChat */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class WXOpenCustomerServiceChat {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.WXOpenCustomerServiceChat$Req */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class Req extends BaseReq {
        public String corpId = "";
        public String url = "";

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 37;
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_open_customer_service_chat_corpId", this.corpId);
            bundle.putString("_open_customer_service_chat_url", this.url);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.WXOpenCustomerServiceChat$Resp */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class Resp extends BaseResp {
        public Resp() {
        }

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
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 37;
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }
}
