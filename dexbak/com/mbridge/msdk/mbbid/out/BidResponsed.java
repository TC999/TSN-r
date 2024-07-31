package com.mbridge.msdk.mbbid.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.click.CommonClickControl;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.system.NoProGuard;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class BidResponsed implements NoProGuard {
    public static final String KEY_BID_ID = "bid";
    public static final String KEY_CUR = "cur";
    public static final String KEY_LN = "ln";
    public static final String KEY_PRICE = "price";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_WN = "wn";
    private String bidId;
    private String bidToken;
    private String cur;

    /* renamed from: ln */
    protected String f31244ln;
    private String price;

    /* renamed from: wn */
    protected String f31245wn;

    public String getBidId() {
        return this.bidId;
    }

    public String getBidToken() {
        return this.bidToken;
    }

    public String getCur() {
        return this.cur;
    }

    public String getLn() {
        return this.f31244ln;
    }

    public String getPrice() {
        return this.price;
    }

    public String getWn() {
        return this.f31245wn;
    }

    public void sendLossNotice(Context context, BidLossCode bidLossCode) {
        if (TextUtils.isEmpty(this.f31244ln) || context == null || bidLossCode == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(this.f31244ln);
        if (this.f31244ln.contains("?")) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append("reason=");
        sb.append(bidLossCode.getCurrentCode());
        CommonClickControl.m23128a(context, (CampaignEx) null, "", sb.toString(), false, false);
    }

    public void sendWinNotice(Context context) {
        if (TextUtils.isEmpty(this.f31245wn) || context == null) {
            return;
        }
        CommonClickControl.m23128a(context, (CampaignEx) null, "", this.f31245wn, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setBidId(String str) {
        this.bidId = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setBidToken(String str) {
        this.bidToken = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCur(String str) {
        this.cur = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrice(String str) {
        this.price = str;
    }
}
