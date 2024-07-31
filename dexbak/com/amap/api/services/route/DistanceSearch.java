package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p047s.C2082j4;
import com.amap.api.col.p047s.DistanceSearchCore;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IDistanceSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DistanceSearch {
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";
    public static final int TYPE_DISTANCE = 0;
    public static final int TYPE_DRIVING_DISTANCE = 1;
    public static final int TYPE_WALK_DISTANCE = 3;

    /* renamed from: a */
    private IDistanceSearch f7599a;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class DistanceQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DistanceQuery> CREATOR = new Parcelable.Creator<DistanceQuery>() { // from class: com.amap.api.services.route.DistanceSearch.DistanceQuery.1
            /* renamed from: a */
            private static DistanceQuery m51828a(Parcel parcel) {
                return new DistanceQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistanceQuery createFromParcel(Parcel parcel) {
                return m51828a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistanceQuery[] newArray(int i) {
                return m51829a(i);
            }

            /* renamed from: a */
            private static DistanceQuery[] m51829a(int i) {
                return new DistanceQuery[i];
            }
        };

        /* renamed from: a */
        private int f7600a;

        /* renamed from: b */
        private List<LatLonPoint> f7601b;

        /* renamed from: c */
        private LatLonPoint f7602c;

        /* renamed from: d */
        private String f7603d;

        /* renamed from: e */
        private int f7604e;

        public DistanceQuery() {
            this.f7600a = 1;
            this.f7601b = new ArrayList();
            this.f7603d = "base";
            this.f7604e = 4;
        }

        public void addOrigins(LatLonPoint... latLonPointArr) {
            for (LatLonPoint latLonPoint : latLonPointArr) {
                if (latLonPoint != null) {
                    this.f7601b.add(latLonPoint);
                }
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public LatLonPoint getDestination() {
            return this.f7602c;
        }

        public String getExtensions() {
            return this.f7603d;
        }

        public int getMode() {
            return this.f7604e;
        }

        public List<LatLonPoint> getOrigins() {
            return this.f7601b;
        }

        public int getType() {
            return this.f7600a;
        }

        public void setDestination(LatLonPoint latLonPoint) {
            this.f7602c = latLonPoint;
        }

        public void setExtensions(String str) {
            this.f7603d = str;
        }

        public void setMode(int i) {
            this.f7604e = i;
        }

        public void setOrigins(List<LatLonPoint> list) {
            if (list != null) {
                this.f7601b = list;
            }
        }

        public void setType(int i) {
            this.f7600a = i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f7600a);
            parcel.writeTypedList(this.f7601b);
            parcel.writeParcelable(this.f7602c, i);
            parcel.writeString(this.f7603d);
            parcel.writeInt(this.f7604e);
        }

        /* renamed from: clone */
        public DistanceQuery m60119clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C2082j4.m52825i(e, "DistanceSearch", "DistanceQueryclone");
            }
            DistanceQuery distanceQuery = new DistanceQuery();
            distanceQuery.setType(this.f7600a);
            distanceQuery.setOrigins(this.f7601b);
            distanceQuery.setDestination(this.f7602c);
            distanceQuery.setExtensions(this.f7603d);
            distanceQuery.setMode(this.f7604e);
            return distanceQuery;
        }

        protected DistanceQuery(Parcel parcel) {
            this.f7600a = 1;
            this.f7601b = new ArrayList();
            this.f7603d = "base";
            this.f7604e = 4;
            this.f7600a = parcel.readInt();
            this.f7601b = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            this.f7602c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f7603d = parcel.readString();
            this.f7604e = parcel.readInt();
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnDistanceSearchListener {
        void onDistanceSearched(DistanceResult distanceResult, int i);
    }

    public DistanceSearch(Context context) throws AMapException {
        if (this.f7599a == null) {
            try {
                this.f7599a = new DistanceSearchCore(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    public DistanceResult calculateRouteDistance(DistanceQuery distanceQuery) throws AMapException {
        IDistanceSearch iDistanceSearch = this.f7599a;
        if (iDistanceSearch != null) {
            return iDistanceSearch.calculateRouteDistance(distanceQuery);
        }
        return null;
    }

    public void calculateRouteDistanceAsyn(DistanceQuery distanceQuery) {
        IDistanceSearch iDistanceSearch = this.f7599a;
        if (iDistanceSearch != null) {
            iDistanceSearch.calculateRouteDistanceAsyn(distanceQuery);
        }
    }

    public void setDistanceSearchListener(OnDistanceSearchListener onDistanceSearchListener) {
        IDistanceSearch iDistanceSearch = this.f7599a;
        if (iDistanceSearch != null) {
            iDistanceSearch.setDistanceSearchListener(onDistanceSearchListener);
        }
    }
}
