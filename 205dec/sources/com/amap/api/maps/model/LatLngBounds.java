package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.col.p0003l.a3;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class LatLngBounds implements Parcelable {
    private static final String CLASSNAME = "LatLngBounds";
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
    private final int mVersionCode;
    public final LatLng northeast;
    public final LatLng southwest;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class Builder {
        private double mSouth = Double.POSITIVE_INFINITY;
        private double mNorth = Double.NEGATIVE_INFINITY;
        private double mWest = Double.NaN;
        private double mEast = Double.NaN;

        private boolean a(double d4) {
            double d5 = this.mWest;
            double d6 = this.mEast;
            return d5 <= d6 ? d5 <= d4 && d4 <= d6 : d5 <= d4 || d4 <= d6;
        }

        public final LatLngBounds build() {
            if (Double.isNaN(this.mWest)) {
                Log.w("LatLngBounds", "no included points");
                return null;
            }
            double d4 = this.mWest;
            double d5 = this.mEast;
            if (d4 > d5) {
                this.mWest = d5;
                this.mEast = d4;
            }
            double d6 = this.mSouth;
            double d7 = this.mNorth;
            if (d6 > d7) {
                this.mSouth = d7;
                this.mNorth = d6;
            }
            return new LatLngBounds(new LatLng(this.mSouth, this.mWest, false), new LatLng(this.mNorth, this.mEast, false));
        }

        public final Builder include(LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            this.mSouth = Math.min(this.mSouth, latLng.latitude);
            this.mNorth = Math.max(this.mNorth, latLng.latitude);
            double d4 = latLng.longitude;
            if (Double.isNaN(this.mWest)) {
                this.mWest = d4;
            } else {
                if (!a(d4)) {
                    if (LatLngBounds.c(this.mWest, d4) < LatLngBounds.d(this.mEast, d4)) {
                        this.mWest = d4;
                    }
                }
                return this;
            }
            this.mEast = d4;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LatLngBounds(int i4, LatLng latLng, LatLng latLng2) {
        boolean z3;
        try {
        } catch (Throwable th) {
            Log.e("LatLngBounds", "the structure parameters are illegal!");
            th.printStackTrace();
            z3 = false;
        }
        if (latLng == null) {
            throw new RuntimeRemoteException("null southwest");
        }
        if (latLng2 != null) {
            if (latLng2.latitude < latLng.latitude) {
                throw new RuntimeRemoteException("southern latitude exceeds northern latitude (" + latLng.latitude + " > " + latLng2.latitude + ")");
            }
            z3 = true;
            this.mVersionCode = z3 ? i4 : 0;
            this.southwest = z3 ? latLng : null;
            this.northeast = z3 ? latLng2 : null;
            return;
        }
        throw new RuntimeRemoteException("null northeast");
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double c(double d4, double d5) {
        return ((d4 - d5) + 360.0d) % 360.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double d(double d4, double d5) {
        return ((d5 - d4) + 360.0d) % 360.0d;
    }

    public final boolean contains(LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        if (this.northeast != null && this.southwest != null) {
            return a(latLng.latitude) && b(latLng.longitude);
        }
        Log.e("LatLngBounds", "current LatLngBounds is invalid, please check the structure parameters are legal");
        return false;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LatLngBounds) {
            LatLngBounds latLngBounds = (LatLngBounds) obj;
            return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
        }
        return false;
    }

    public final int hashCode() {
        return a3.k(new Object[]{this.southwest, this.northeast});
    }

    public final LatLngBounds including(LatLng latLng) {
        LatLng latLng2;
        double d4;
        if (latLng == null) {
            return this;
        }
        if (this.northeast != null && (latLng2 = this.southwest) != null) {
            double min = Math.min(latLng2.latitude, latLng.latitude);
            double max = Math.max(this.northeast.latitude, latLng.latitude);
            double d5 = this.northeast.longitude;
            double d6 = this.southwest.longitude;
            double d7 = latLng.longitude;
            try {
                if (!b(d7)) {
                    if (c(d6, d7) >= d(d5, d7)) {
                        d4 = d7;
                        return new LatLngBounds(new LatLng(min, d6, false), new LatLng(max, d4, false));
                    }
                    d6 = d7;
                }
                return new LatLngBounds(new LatLng(min, d6, false), new LatLng(max, d4, false));
            } catch (Throwable th) {
                th.printStackTrace();
                return this;
            }
            d4 = d5;
        } else {
            Log.e("LatLngBounds", "current LatLngBounds is invalid, please check the structure parameters are legal");
            return this;
        }
    }

    public final boolean intersects(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return false;
        }
        if (this.northeast != null && this.southwest != null) {
            return a(latLngBounds) || latLngBounds.a(this);
        }
        Log.e("LatLngBounds", "current LatLngBounds is invalid, please check the structure parameters are legal");
        return false;
    }

    public final String toString() {
        return a3.A(a3.z("southwest", this.southwest), a3.z("northeast", this.northeast));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        LatLngBoundsCreator.a(this, parcel, i4);
    }

    private boolean b(double d4) {
        double d5 = this.southwest.longitude;
        double d6 = this.northeast.longitude;
        return d5 <= d6 ? d5 <= d4 && d4 <= d6 : d5 <= d4 || d4 <= d6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        return this.mVersionCode;
    }

    private boolean a(LatLngBounds latLngBounds) {
        LatLng latLng;
        LatLng latLng2;
        if (latLngBounds == null || (latLng = latLngBounds.northeast) == null || (latLng2 = latLngBounds.southwest) == null) {
            return false;
        }
        double d4 = latLng.longitude;
        double d5 = latLng2.longitude;
        LatLng latLng3 = this.northeast;
        double d6 = latLng3.longitude;
        LatLng latLng4 = this.southwest;
        double d7 = latLng4.longitude;
        double d8 = ((d4 + d5) - d6) - d7;
        double d9 = latLng.latitude;
        double d10 = latLng2.latitude;
        double d11 = latLng3.latitude;
        double d12 = latLng4.latitude;
        return Math.abs(d8) < ((d6 - d7) + d4) - d5 && Math.abs(((d9 + d10) - d11) - d12) < ((d11 - d12) + d9) - d10;
    }

    public final boolean contains(LatLngBounds latLngBounds) {
        return latLngBounds != null && contains(latLngBounds.southwest) && contains(latLngBounds.northeast);
    }

    private boolean a(double d4) {
        return this.southwest.latitude <= d4 && d4 <= this.northeast.latitude;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }
}
