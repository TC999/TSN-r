package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class WXJointPay {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class JointPayReq extends PayReq {
        @Override // com.tencent.mm.opensdk.modelpay.PayReq, com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return super.checkArgs();
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayReq, com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayReq, com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 27;
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayReq, com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class JointPayResp extends PayResp {
        public JointPayResp() {
        }

        public JointPayResp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayResp, com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return super.checkArgs();
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayResp, com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayResp, com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 27;
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayResp, com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }
}
