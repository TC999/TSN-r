package com.kwad.sdk.h.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bg;

@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public String aHX;
    public String aHY;
    public String aHZ;
    public long aIa;
    public boolean aIb;
    public String ajL;
    public int loadType;
    public int packageType;
    public String packageUrl;
    public String version;

    public final long Iu() {
        return this.aIa;
    }

    public final void az(long j4) {
        this.aIa = j4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (bg.isEquals(this.aHX, bVar.aHX) && bg.isEquals(this.ajL, bVar.ajL) && bg.isEquals(this.version, bVar.version)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.aHX);
        sb.append("_");
        sb.append(this.ajL);
        sb.append("_");
        sb.append(this.version);
        return TextUtils.isEmpty(sb.toString()) ? super.hashCode() : sb.toString().hashCode();
    }

    public final boolean isValid() {
        return (TextUtils.isEmpty(this.aHX) || TextUtils.isEmpty(this.packageUrl) || TextUtils.isEmpty(this.version) || TextUtils.isEmpty(this.aHY)) ? false : true;
    }

    @Override // com.kwad.sdk.core.response.a.a
    @NonNull
    public String toString() {
        return "PackageInfoBean{packageId='" + this.aHX + "', zipFileName='" + this.aHY + "', zipPath='" + this.aHZ + "', startDownloadTime=" + this.aIa + ", packageUrl='" + this.packageUrl + "', version='" + this.version + "', checksum='" + this.ajL + "', loadType=" + this.loadType + ", packageType=" + this.packageType + ", isPublic=" + this.aIb + '}';
    }
}
