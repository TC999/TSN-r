package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.j4;
import com.amap.api.col.s.l0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IDistanceSearch;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DistanceSearch {
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";
    public static final int TYPE_DISTANCE = 0;
    public static final int TYPE_DRIVING_DISTANCE = 1;
    public static final int TYPE_WALK_DISTANCE = 3;

    /* renamed from: a  reason: collision with root package name */
    private IDistanceSearch f11293a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class DistanceQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DistanceQuery> CREATOR = new Parcelable.Creator<DistanceQuery>() { // from class: com.amap.api.services.route.DistanceSearch.DistanceQuery.1
            private static DistanceQuery a(Parcel parcel) {
                return new DistanceQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistanceQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistanceQuery[] newArray(int i4) {
                return a(i4);
            }

            private static DistanceQuery[] a(int i4) {
                return new DistanceQuery[i4];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private int f11294a;

        /* renamed from: b  reason: collision with root package name */
        private List<LatLonPoint> f11295b;

        /* renamed from: c  reason: collision with root package name */
        private LatLonPoint f11296c;

        /* renamed from: d  reason: collision with root package name */
        private String f11297d;

        /* renamed from: e  reason: collision with root package name */
        private int f11298e;

        public DistanceQuery() {
            this.f11294a = 1;
            this.f11295b = new ArrayList();
            this.f11297d = "base";
            this.f11298e = 4;
        }

        public void addOrigins(LatLonPoint... latLonPointArr) {
            for (LatLonPoint latLonPoint : latLonPointArr) {
                if (latLonPoint != null) {
                    this.f11295b.add(latLonPoint);
                }
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public LatLonPoint getDestination() {
            return this.f11296c;
        }

        public String getExtensions() {
            return this.f11297d;
        }

        public int getMode() {
            return this.f11298e;
        }

        public List<LatLonPoint> getOrigins() {
            return this.f11295b;
        }

        public int getType() {
            return this.f11294a;
        }

        public void setDestination(LatLonPoint latLonPoint) {
            this.f11296c = latLonPoint;
        }

        public void setExtensions(String str) {
            this.f11297d = str;
        }

        public void setMode(int i4) {
            this.f11298e = i4;
        }

        public void setOrigins(List<LatLonPoint> list) {
            if (list != null) {
                this.f11295b = list;
            }
        }

        public void setType(int i4) {
            this.f11294a = i4;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeInt(this.f11294a);
            parcel.writeTypedList(this.f11295b);
            parcel.writeParcelable(this.f11296c, i4);
            parcel.writeString(this.f11297d);
            parcel.writeInt(this.f11298e);
        }

        /* renamed from: clone */
        public DistanceQuery m40clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                j4.i(e4, "DistanceSearch", "DistanceQueryclone");
            }
            DistanceQuery distanceQuery = new DistanceQuery();
            distanceQuery.setType(this.f11294a);
            distanceQuery.setOrigins(this.f11295b);
            distanceQuery.setDestination(this.f11296c);
            distanceQuery.setExtensions(this.f11297d);
            distanceQuery.setMode(this.f11298e);
            return distanceQuery;
        }

        protected DistanceQuery(Parcel parcel) {
            this.f11294a = 1;
            this.f11295b = new ArrayList();
            this.f11297d = "base";
            this.f11298e = 4;
            this.f11294a = parcel.readInt();
            this.f11295b = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            this.f11296c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f11297d = parcel.readString();
            this.f11298e = parcel.readInt();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnDistanceSearchListener {
        void onDistanceSearched(DistanceResult distanceResult, int i4);
    }

    public DistanceSearch(Context context) throws AMapException {
        if (this.f11293a == null) {
            try {
                this.f11293a = new l0(context);
            } catch (Exception e4) {
                e4.printStackTrace();
                if (e4 instanceof AMapException) {
                    throw ((AMapException) e4);
                }
            }
        }
    }

    public DistanceResult calculateRouteDistance(DistanceQuery distanceQuery) throws AMapException {
        IDistanceSearch iDistanceSearch = this.f11293a;
        if (iDistanceSearch != null) {
            return iDistanceSearch.calculateRouteDistance(distanceQuery);
        }
        return null;
    }

    public void calculateRouteDistanceAsyn(DistanceQuery distanceQuery) {
        IDistanceSearch iDistanceSearch = this.f11293a;
        if (iDistanceSearch != null) {
            iDistanceSearch.calculateRouteDistanceAsyn(distanceQuery);
        }
    }

    public void setDistanceSearchListener(OnDistanceSearchListener onDistanceSearchListener) {
        IDistanceSearch iDistanceSearch = this.f11293a;
        if (iDistanceSearch != null) {
            iDistanceSearch.setDistanceSearchListener(onDistanceSearchListener);
        }
    }
}
