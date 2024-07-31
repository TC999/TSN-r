package com.kwad.sdk.p435h.p436a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.utils.C11053bg;

@KsJson
/* renamed from: com.kwad.sdk.h.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10772b extends C10482a {
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

    /* renamed from: Iu */
    public final long m24880Iu() {
        return this.aIa;
    }

    /* renamed from: az */
    public final void m24879az(long j) {
        this.aIa = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C10772b c10772b = (C10772b) obj;
            if (C11053bg.isEquals(this.aHX, c10772b.aHX) && C11053bg.isEquals(this.ajL, c10772b.ajL) && C11053bg.isEquals(this.version, c10772b.version)) {
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

    @Override // com.kwad.sdk.core.response.p408a.C10482a
    @NonNull
    public String toString() {
        return "PackageInfoBean{packageId='" + this.aHX + "', zipFileName='" + this.aHY + "', zipPath='" + this.aHZ + "', startDownloadTime=" + this.aIa + ", packageUrl='" + this.packageUrl + "', version='" + this.version + "', checksum='" + this.ajL + "', loadType=" + this.loadType + ", packageType=" + this.packageType + ", isPublic=" + this.aIb + '}';
    }
}
