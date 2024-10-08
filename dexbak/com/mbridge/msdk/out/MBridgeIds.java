package com.mbridge.msdk.out;

import android.text.TextUtils;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class MBridgeIds implements NoProGuard, Serializable {
    private String bidToken = "";
    private String placementId;
    private String unitId;

    public MBridgeIds() {
    }

    public String getBidToken() {
        if (TextUtils.isEmpty(this.bidToken)) {
            this.bidToken = "";
        }
        return this.bidToken;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public String getUnitId() {
        return this.unitId;
    }

    public void setBidToken(String str) {
        this.bidToken = str;
    }

    public void setPlacementId(String str) {
        this.placementId = str;
    }

    public void setUnitId(String str) {
        this.unitId = str;
    }

    public String toString() {
        return "MBridgeIds{placementId='" + this.placementId + "', unitId='" + this.unitId + "', bidToken='" + this.bidToken + "'}";
    }

    public MBridgeIds(String str, String str2) {
        this.placementId = str;
        this.unitId = str2;
    }
}
