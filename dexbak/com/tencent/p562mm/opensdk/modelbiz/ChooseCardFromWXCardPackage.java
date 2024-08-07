package com.tencent.p562mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.p562mm.opensdk.modelbase.BaseReq;
import com.tencent.p562mm.opensdk.modelbase.BaseResp;
import com.tencent.p562mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ChooseCardFromWXCardPackage {
    private static final String TAG = "MicroMsg.ChooseCardFromWXCardPackage";

    /* renamed from: com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage$Req */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class Req extends BaseReq {
        public String appId;
        public String canMultiSelect;
        public String cardId;
        public String cardSign;
        public String cardType;
        public String locationId;
        public String nonceStr;
        public String signType;
        public String timeStamp;

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String str;
            String str2;
            String str3 = this.appId;
            return str3 != null && str3.length() > 0 && (str = this.signType) != null && str.length() > 0 && (str2 = this.cardSign) != null && str2.length() > 0;
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 16;
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_choose_card_from_wx_card_app_id", this.appId);
            bundle.putString("_wxapi_choose_card_from_wx_card_location_id", this.locationId);
            bundle.putString("_wxapi_choose_card_from_wx_card_sign_type", this.signType);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_sign", this.cardSign);
            bundle.putString("_wxapi_choose_card_from_wx_card_time_stamp", this.timeStamp);
            bundle.putString("_wxapi_choose_card_from_wx_card_nonce_str", this.nonceStr);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_id", this.cardId);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_type", this.cardType);
            bundle.putString("_wxapi_choose_card_from_wx_card_can_multi_select", this.canMultiSelect);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage$Resp */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class Resp extends BaseResp {
        public String cardItemList;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            String str = this.cardItemList;
            return (str == null || str.length() == 0) ? false : true;
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            String string = bundle.getString("_wxapi_choose_card_from_wx_card_list");
            if (string == null || string.length() <= 0) {
                Log.m15263i(ChooseCardFromWXCardPackage.TAG, "cardItemList is empty!");
            } else {
                this.cardItemList = string;
            }
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 16;
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_choose_card_from_wx_card_list", this.cardItemList);
        }
    }
}
