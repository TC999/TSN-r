package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.col.p0003l.a3;
import com.amap.api.col.p0003l.t2;
import com.amap.api.col.p0003l.u5;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class CameraPosition implements Parcelable {
    private static final String CLASSNAME = "CameraPosition";
    public static final CameraPositionCreator CREATOR = new CameraPositionCreator();
    public final float bearing;
    public final boolean isAbroad;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class Builder {
        private float bearing;
        private LatLng target;
        private float tilt;
        private float zoom;

        public Builder() {
        }

        public final Builder bearing(float f4) {
            this.bearing = f4;
            return this;
        }

        public final CameraPosition build() {
            try {
                if (this.target == null) {
                    Log.w("CameraPosition", "target is null");
                    return null;
                }
                return new CameraPosition(this.target, this.zoom, this.tilt, this.bearing);
            } catch (Throwable th) {
                u5.p(th, "CameraPosition", "build");
                return null;
            }
        }

        public final Builder target(LatLng latLng) {
            this.target = latLng;
            return this;
        }

        public final Builder tilt(float f4) {
            this.tilt = f4;
            return this;
        }

        public final Builder zoom(float f4) {
            this.zoom = f4;
            return this;
        }

        public Builder(CameraPosition cameraPosition) {
            target(cameraPosition.target).bearing(cameraPosition.bearing).tilt(cameraPosition.tilt).zoom(cameraPosition.zoom);
        }
    }

    public CameraPosition(LatLng latLng, float f4, float f5, float f6) {
        if (latLng == null) {
            Log.w("CameraPosition", "\u6784\u5efaCameraPosition\u65f6,\u4f4d\u7f6e(target)\u4e0d\u80fd\u4e3anull");
        }
        this.target = latLng;
        this.zoom = f4;
        this.tilt = f5;
        this.bearing = (((double) f6) <= 0.0d ? (f6 % 360.0f) + 360.0f : f6) % 360.0f;
        if (latLng != null) {
            this.isAbroad = !t2.a(latLng.latitude, latLng.longitude);
        } else {
            this.isAbroad = false;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f4) {
        return new CameraPosition(latLng, f4, 0.0f, 0.0f);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CameraPosition) {
            CameraPosition cameraPosition = (CameraPosition) obj;
            return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
        }
        return false;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return a3.A(a3.z("target", this.target), a3.z("zoom", Float.valueOf(this.zoom)), a3.z("tilt", Float.valueOf(this.tilt)), a3.z("bearing", Float.valueOf(this.bearing)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeFloat(this.bearing);
        parcel.writeFloat((float) this.target.latitude);
        parcel.writeFloat((float) this.target.longitude);
        parcel.writeFloat(this.tilt);
        parcel.writeFloat(this.zoom);
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }
}
