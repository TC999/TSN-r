package com.tencent.p562mm.opensdk.modelpay;

import android.os.Bundle;

/* renamed from: com.tencent.mm.opensdk.modelpay.WXJointPay */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class WXJointPay {

    /* renamed from: com.tencent.mm.opensdk.modelpay.WXJointPay$JointPayReq */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class JointPayReq extends PayReq {
        @Override // com.tencent.p562mm.opensdk.modelpay.PayReq, com.tencent.p562mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return super.checkArgs();
        }

        @Override // com.tencent.p562mm.opensdk.modelpay.PayReq, com.tencent.p562mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.tencent.p562mm.opensdk.modelpay.PayReq, com.tencent.p562mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 27;
        }

        @Override // com.tencent.p562mm.opensdk.modelpay.PayReq, com.tencent.p562mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelpay.WXJointPay$JointPayResp */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class JointPayResp extends PayResp {
        public JointPayResp() {
        }

        public JointPayResp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.p562mm.opensdk.modelpay.PayResp, com.tencent.p562mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return super.checkArgs();
        }

        @Override // com.tencent.p562mm.opensdk.modelpay.PayResp, com.tencent.p562mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.tencent.p562mm.opensdk.modelpay.PayResp, com.tencent.p562mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 27;
        }

        @Override // com.tencent.p562mm.opensdk.modelpay.PayResp, com.tencent.p562mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }
}
