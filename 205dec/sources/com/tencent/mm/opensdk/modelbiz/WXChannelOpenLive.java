package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class WXChannelOpenLive {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.WXChannelOpenLive.Req";
        public String feedID;
        public String nonceID;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String str;
            if (b.b(this.feedID)) {
                str = "feedID is null";
            } else if (b.b(this.nonceID)) {
                str = "nonceID is null";
            } else if (this.feedID.length() > 1024) {
                str = "feedID.length too long!";
            } else if (this.nonceID.length() <= 1024) {
                return true;
            } else {
                str = "nonceID.length too long!";
            }
            Log.e("MicroMsg.SDK.WXChannelOpenLive.Req", str);
            return false;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.feedID = bundle.getString("_wxapi_finder_feedID");
            this.nonceID = bundle.getString("_wxapi_finder_nonceID");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 35;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_finder_feedID", this.feedID);
            bundle.putString("_wxapi_finder_nonceID", this.nonceID);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class Resp extends BaseResp {
        public String extMsg;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_wxapi_finder_extMsg");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 35;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_finder_extMsg", this.extMsg);
        }
    }
}
