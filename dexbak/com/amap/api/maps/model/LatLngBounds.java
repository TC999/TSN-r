package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.col.p0463l.C1732a3;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class LatLngBounds implements Parcelable {
    private static final String CLASSNAME = "LatLngBounds";
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
    private final int mVersionCode;
    public final LatLng northeast;
    public final LatLng southwest;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class Builder {
        private double mSouth = Double.POSITIVE_INFINITY;
        private double mNorth = Double.NEGATIVE_INFINITY;
        private double mWest = Double.NaN;
        private double mEast = Double.NaN;

        /* renamed from: a */
        private boolean m52047a(double d) {
            double d2 = this.mWest;
            double d3 = this.mEast;
            return d2 <= d3 ? d2 <= d && d <= d3 : d2 <= d || d <= d3;
        }

        public final LatLngBounds build() {
            if (Double.isNaN(this.mWest)) {
                Log.w(LatLngBounds.CLASSNAME, "no included points");
                return null;
            }
            double d = this.mWest;
            double d2 = this.mEast;
            if (d > d2) {
                this.mWest = d2;
                this.mEast = d;
            }
            double d3 = this.mSouth;
            double d4 = this.mNorth;
            if (d3 > d4) {
                this.mSouth = d4;
                this.mNorth = d3;
            }
            return new LatLngBounds(new LatLng(this.mSouth, this.mWest, false), new LatLng(this.mNorth, this.mEast, false));
        }

        public final Builder include(LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            this.mSouth = Math.min(this.mSouth, latLng.latitude);
            this.mNorth = Math.max(this.mNorth, latLng.latitude);
            double d = latLng.longitude;
            if (Double.isNaN(this.mWest)) {
                this.mWest = d;
            } else {
                if (!m52047a(d)) {
                    if (LatLngBounds.m52049c(this.mWest, d) < LatLngBounds.m52048d(this.mEast, d)) {
                        this.mWest = d;
                    }
                }
                return this;
            }
            this.mEast = d;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        boolean z;
        try {
        } catch (Throwable th) {
            Log.e(CLASSNAME, "the structure parameters are illegal!");
            th.printStackTrace();
            z = false;
        }
        if (latLng == null) {
            throw new RuntimeRemoteException("null southwest");
        }
        if (latLng2 != null) {
            if (latLng2.latitude < latLng.latitude) {
                throw new RuntimeRemoteException("southern latitude exceeds northern latitude (" + latLng.latitude + " > " + latLng2.latitude + ")");
            }
            z = true;
            this.mVersionCode = z ? i : 0;
            this.southwest = z ? latLng : null;
            this.northeast = z ? latLng2 : null;
            return;
        }
        throw new RuntimeRemoteException("null northeast");
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static double m52049c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static double m52048d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    public final boolean contains(LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        if (this.northeast != null && this.southwest != null) {
            return m52054a(latLng.latitude) && m52051b(latLng.longitude);
        }
        Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
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
        return C1732a3.m55699k(new Object[]{this.southwest, this.northeast});
    }

    public final LatLngBounds including(LatLng latLng) {
        LatLng latLng2;
        double d;
        if (latLng == null) {
            return this;
        }
        if (this.northeast != null && (latLng2 = this.southwest) != null) {
            double min = Math.min(latLng2.latitude, latLng.latitude);
            double max = Math.max(this.northeast.latitude, latLng.latitude);
            double d2 = this.northeast.longitude;
            double d3 = this.southwest.longitude;
            double d4 = latLng.longitude;
            try {
                if (!m52051b(d4)) {
                    if (m52049c(d3, d4) >= m52048d(d2, d4)) {
                        d = d4;
                        return new LatLngBounds(new LatLng(min, d3, false), new LatLng(max, d, false));
                    }
                    d3 = d4;
                }
                return new LatLngBounds(new LatLng(min, d3, false), new LatLng(max, d, false));
            } catch (Throwable th) {
                th.printStackTrace();
                return this;
            }
            d = d2;
        } else {
            Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
            return this;
        }
    }

    public final boolean intersects(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return false;
        }
        if (this.northeast != null && this.southwest != null) {
            return m52052a(latLngBounds) || latLngBounds.m52052a(this);
        }
        Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
        return false;
    }

    public final String toString() {
        return C1732a3.m55744A(C1732a3.m55684z("southwest", this.southwest), C1732a3.m55684z("northeast", this.northeast));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        LatLngBoundsCreator.m52046a(this, parcel, i);
    }

    /* renamed from: b */
    private boolean m52051b(double d) {
        double d2 = this.southwest.longitude;
        double d3 = this.northeast.longitude;
        return d2 <= d3 ? d2 <= d && d <= d3 : d2 <= d || d <= d3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final int m52055a() {
        return this.mVersionCode;
    }

    /* renamed from: a */
    private boolean m52052a(LatLngBounds latLngBounds) {
        LatLng latLng;
        LatLng latLng2;
        if (latLngBounds == null || (latLng = latLngBounds.northeast) == null || (latLng2 = latLngBounds.southwest) == null) {
            return false;
        }
        double d = latLng.longitude;
        double d2 = latLng2.longitude;
        LatLng latLng3 = this.northeast;
        double d3 = latLng3.longitude;
        LatLng latLng4 = this.southwest;
        double d4 = latLng4.longitude;
        double d5 = ((d + d2) - d3) - d4;
        double d6 = latLng.latitude;
        double d7 = latLng2.latitude;
        double d8 = latLng3.latitude;
        double d9 = latLng4.latitude;
        return Math.abs(d5) < ((d3 - d4) + d) - d2 && Math.abs(((d6 + d7) - d8) - d9) < ((d8 - d9) + d6) - d7;
    }

    public final boolean contains(LatLngBounds latLngBounds) {
        return latLngBounds != null && contains(latLngBounds.southwest) && contains(latLngBounds.northeast);
    }

    /* renamed from: a */
    private boolean m52054a(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }
}
