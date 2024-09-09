package com.bytedance.sdk.component.adexpress.dynamic.xv;

import java.util.Arrays;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd {

    /* renamed from: c  reason: collision with root package name */
    public float f29369c;

    /* renamed from: w  reason: collision with root package name */
    public float f29370w;

    public gd(float f4, float f5) {
        this.f29369c = f4;
        this.f29370w = f5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        gd gdVar = (gd) obj;
        return Float.compare(gdVar.f29369c, this.f29369c) == 0 && Float.compare(gdVar.f29370w, this.f29370w) == 0;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f29369c), Float.valueOf(this.f29370w)});
    }
}
