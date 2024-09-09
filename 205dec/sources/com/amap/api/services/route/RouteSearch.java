package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.j4;
import com.amap.api.col.s.t0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearch;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RouteSearch {
    public static final int BUS_COMFORTABLE = 4;
    public static final int BUS_DEFAULT = 0;
    public static final int BUS_LEASE_CHANGE = 2;
    public static final int BUS_LEASE_WALK = 3;
    public static final int BUS_NO_SUBWAY = 5;
    public static final int BUS_SAVE_MONEY = 1;
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_CHOICE_HIGHWAY = 9;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_FASTEST_SAVE_MONEY = 11;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_NO_HIGHWAY = 4;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_SAVE_MONEY = 6;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_SAVE_MONEY_NO_HIGHWAY = 7;
    public static final int DRIVEING_PLAN_CHOICE_HIGHWAY = 8;
    public static final int DRIVEING_PLAN_DEFAULT = 1;
    public static final int DRIVEING_PLAN_FASTEST_SHORTEST = 10;
    public static final int DRIVEING_PLAN_NO_HIGHWAY = 2;
    public static final int DRIVEING_PLAN_SAVE_MONEY = 3;
    public static final int DRIVEING_PLAN_SAVE_MONEY_NO_HIGHWAY = 5;
    public static final String DRIVING_EXCLUDE_FERRY = "ferry";
    public static final String DRIVING_EXCLUDE_MOTORWAY = "motorway";
    public static final String DRIVING_EXCLUDE_TOLL = "toll";
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION = 12;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_NO_HIGHWAY = 15;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_NO_HIGHWAY_SAVE_MONEY = 18;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_SAVE_MONEY = 17;
    public static final int DRIVING_MULTI_CHOICE_HIGHWAY = 19;
    public static final int DRIVING_MULTI_CHOICE_HIGHWAY_AVOID_CONGESTION = 20;
    public static final int DRIVING_MULTI_CHOICE_NO_HIGHWAY = 13;
    public static final int DRIVING_MULTI_CHOICE_SAVE_MONEY = 14;
    public static final int DRIVING_MULTI_CHOICE_SAVE_MONEY_NO_HIGHWAY = 16;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SAVE_MONEY_SHORTEST = 5;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST = 11;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST_AVOID_CONGESTION = 10;
    public static final int DRIVING_NORMAL_CAR = 0;
    public static final int DRIVING_PLUGIN_HYBRID_CAR = 2;
    public static final int DRIVING_PURE_ELECTRIC_VEHICLE = 1;
    public static final int DRIVING_SINGLE_AVOID_CONGESTION = 4;
    public static final int DRIVING_SINGLE_DEFAULT = 0;
    public static final int DRIVING_SINGLE_NO_EXPRESSWAYS = 3;
    public static final int DRIVING_SINGLE_NO_HIGHWAY = 6;
    public static final int DRIVING_SINGLE_NO_HIGHWAY_SAVE_MONEY = 7;
    public static final int DRIVING_SINGLE_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 9;
    public static final int DRIVING_SINGLE_SAVE_MONEY = 1;
    public static final int DRIVING_SINGLE_SAVE_MONEY_AVOID_CONGESTION = 8;
    public static final int DRIVING_SINGLE_SHORTEST = 2;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingMultiStrategy = 5;
    public static final int DrivingNoExpressways = 3;
    public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
    public static final int DrivingNoHighWay = 6;
    public static final int DrivingNoHighWaySaveMoney = 7;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 8;
    public static final int DrivingShortDistance = 2;
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";
    public static final int RIDING_DEFAULT = 0;
    public static final int RIDING_FAST = 2;
    public static final int RIDING_RECOMMEND = 1;
    public static final int RidingDefault = 0;
    public static final int RidingFast = 2;
    public static final int RidingRecommend = 1;
    public static final int TRUCK_AVOID_CONGESTION = 1;
    public static final int TRUCK_AVOID_CONGESTION_CHOICE_HIGHWAY = 9;
    public static final int TRUCK_AVOID_CONGESTION_NO_HIGHWAY = 4;
    public static final int TRUCK_AVOID_CONGESTION__SAVE_MONEY = 6;
    public static final int TRUCK_AVOID_CONGESTION__SAVE_MONEY_NO_HIGHWAY = 7;
    public static final int TRUCK_CHOICE_HIGHWAY = 8;
    public static final int TRUCK_NO_HIGHWAY = 2;
    public static final int TRUCK_SAVE_MONEY = 3;
    public static final int TRUCK_SAVE_MONEY_NO_HIGHWAY = 5;
    public static final int TRUCK_SIZE_HEAVY = 4;
    public static final int TRUCK_SIZE_LIGHT = 2;
    public static final int TRUCK_SIZE_MEDIUM = 3;
    public static final int TRUCK_SIZE_MINI = 1;
    public static final int WALK_DEFAULT = 0;
    public static final int WALK_MULTI_PATH = 1;
    public static final int WalkDefault = 0;
    public static final int WalkMultipath = 1;

    /* renamed from: a  reason: collision with root package name */
    private IRouteSearch f11411a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class BusRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<BusRouteQuery> CREATOR = new Parcelable.Creator<BusRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.BusRouteQuery.1
            private static BusRouteQuery a(Parcel parcel) {
                return new BusRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BusRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BusRouteQuery[] newArray(int i4) {
                return a(i4);
            }

            private static BusRouteQuery[] a(int i4) {
                return new BusRouteQuery[i4];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private FromAndTo f11412a;

        /* renamed from: b  reason: collision with root package name */
        private int f11413b;

        /* renamed from: c  reason: collision with root package name */
        private String f11414c;

        /* renamed from: d  reason: collision with root package name */
        private String f11415d;

        /* renamed from: e  reason: collision with root package name */
        private int f11416e;

        /* renamed from: f  reason: collision with root package name */
        private String f11417f;

        public BusRouteQuery(FromAndTo fromAndTo, int i4, String str, int i5) {
            this.f11417f = "base";
            this.f11412a = fromAndTo;
            this.f11413b = i4;
            this.f11414c = str;
            this.f11416e = i5;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                BusRouteQuery busRouteQuery = (BusRouteQuery) obj;
                String str = this.f11414c;
                if (str == null) {
                    if (busRouteQuery.f11414c != null) {
                        return false;
                    }
                } else if (!str.equals(busRouteQuery.f11414c)) {
                    return false;
                }
                String str2 = this.f11415d;
                if (str2 == null) {
                    if (busRouteQuery.f11415d != null) {
                        return false;
                    }
                } else if (!str2.equals(busRouteQuery.f11415d)) {
                    return false;
                }
                String str3 = this.f11417f;
                if (str3 == null) {
                    if (busRouteQuery.f11417f != null) {
                        return false;
                    }
                } else if (!str3.equals(busRouteQuery.f11417f)) {
                    return false;
                }
                FromAndTo fromAndTo = this.f11412a;
                if (fromAndTo == null) {
                    if (busRouteQuery.f11412a != null) {
                        return false;
                    }
                } else if (!fromAndTo.equals(busRouteQuery.f11412a)) {
                    return false;
                }
                return this.f11413b == busRouteQuery.f11413b && this.f11416e == busRouteQuery.f11416e;
            }
            return false;
        }

        public String getCity() {
            return this.f11414c;
        }

        public String getCityd() {
            return this.f11415d;
        }

        public String getExtensions() {
            return this.f11417f;
        }

        public FromAndTo getFromAndTo() {
            return this.f11412a;
        }

        public int getMode() {
            return this.f11413b;
        }

        public int getNightFlag() {
            return this.f11416e;
        }

        public int hashCode() {
            String str = this.f11414c;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            FromAndTo fromAndTo = this.f11412a;
            int hashCode2 = (((((hashCode + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.f11413b) * 31) + this.f11416e) * 31;
            String str2 = this.f11415d;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public void setCityd(String str) {
            this.f11415d = str;
        }

        public void setExtensions(String str) {
            this.f11417f = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeParcelable(this.f11412a, i4);
            parcel.writeInt(this.f11413b);
            parcel.writeString(this.f11414c);
            parcel.writeInt(this.f11416e);
            parcel.writeString(this.f11415d);
            parcel.writeString(this.f11417f);
        }

        /* renamed from: clone */
        public BusRouteQuery m41clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                j4.i(e4, "RouteSearch", "BusRouteQueryclone");
            }
            BusRouteQuery busRouteQuery = new BusRouteQuery(this.f11412a, this.f11413b, this.f11414c, this.f11416e);
            busRouteQuery.setCityd(this.f11415d);
            busRouteQuery.setExtensions(this.f11417f);
            return busRouteQuery;
        }

        public BusRouteQuery(Parcel parcel) {
            this.f11417f = "base";
            this.f11412a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f11413b = parcel.readInt();
            this.f11414c = parcel.readString();
            this.f11416e = parcel.readInt();
            this.f11415d = parcel.readString();
            this.f11417f = parcel.readString();
        }

        public BusRouteQuery() {
            this.f11417f = "base";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class DrivePlanQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DrivePlanQuery> CREATOR = new Parcelable.Creator<DrivePlanQuery>() { // from class: com.amap.api.services.route.RouteSearch.DrivePlanQuery.1
            private static DrivePlanQuery a(Parcel parcel) {
                return new DrivePlanQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DrivePlanQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DrivePlanQuery[] newArray(int i4) {
                return a(i4);
            }

            private static DrivePlanQuery[] a(int i4) {
                return new DrivePlanQuery[i4];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private FromAndTo f11418a;

        /* renamed from: b  reason: collision with root package name */
        private String f11419b;

        /* renamed from: c  reason: collision with root package name */
        private int f11420c;

        /* renamed from: d  reason: collision with root package name */
        private int f11421d;

        /* renamed from: e  reason: collision with root package name */
        private int f11422e;

        /* renamed from: f  reason: collision with root package name */
        private int f11423f;

        /* renamed from: g  reason: collision with root package name */
        private int f11424g;

        public DrivePlanQuery(FromAndTo fromAndTo, int i4, int i5, int i6) {
            this.f11420c = 1;
            this.f11421d = 0;
            this.f11418a = fromAndTo;
            this.f11422e = i4;
            this.f11423f = i5;
            this.f11424g = i6;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                DrivePlanQuery drivePlanQuery = (DrivePlanQuery) obj;
                FromAndTo fromAndTo = this.f11418a;
                if (fromAndTo == null) {
                    if (drivePlanQuery.f11418a != null) {
                        return false;
                    }
                } else if (!fromAndTo.equals(drivePlanQuery.f11418a)) {
                    return false;
                }
                String str = this.f11419b;
                if (str == null) {
                    if (drivePlanQuery.f11419b != null) {
                        return false;
                    }
                } else if (!str.equals(drivePlanQuery.f11419b)) {
                    return false;
                }
                return this.f11420c == drivePlanQuery.f11420c && this.f11421d == drivePlanQuery.f11421d && this.f11422e == drivePlanQuery.f11422e && this.f11423f == drivePlanQuery.f11423f && this.f11424g == drivePlanQuery.f11424g;
            }
            return false;
        }

        public int getCarType() {
            return this.f11421d;
        }

        public int getCount() {
            return this.f11424g;
        }

        public String getDestParentPoiID() {
            return this.f11419b;
        }

        public int getFirstTime() {
            return this.f11422e;
        }

        public FromAndTo getFromAndTo() {
            return this.f11418a;
        }

        public int getInterval() {
            return this.f11423f;
        }

        public int getMode() {
            return this.f11420c;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f11418a;
            int hashCode = ((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31;
            String str = this.f11419b;
            return ((((((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f11420c) * 31) + this.f11421d) * 31) + this.f11422e) * 31) + this.f11423f) * 31) + this.f11424g;
        }

        public void setCarType(int i4) {
            this.f11421d = i4;
        }

        public void setDestParentPoiID(String str) {
            this.f11419b = str;
        }

        public void setMode(int i4) {
            this.f11420c = i4;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeParcelable(this.f11418a, i4);
            parcel.writeString(this.f11419b);
            parcel.writeInt(this.f11420c);
            parcel.writeInt(this.f11421d);
            parcel.writeInt(this.f11422e);
            parcel.writeInt(this.f11423f);
            parcel.writeInt(this.f11424g);
        }

        /* renamed from: clone */
        public DrivePlanQuery m42clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                j4.i(e4, "RouteSearch", "DriveRouteQueryclone");
            }
            DrivePlanQuery drivePlanQuery = new DrivePlanQuery(this.f11418a, this.f11422e, this.f11423f, this.f11424g);
            drivePlanQuery.setDestParentPoiID(this.f11419b);
            drivePlanQuery.setMode(this.f11420c);
            drivePlanQuery.setCarType(this.f11421d);
            return drivePlanQuery;
        }

        public DrivePlanQuery() {
            this.f11420c = 1;
            this.f11421d = 0;
            this.f11422e = 0;
            this.f11423f = 0;
            this.f11424g = 48;
        }

        protected DrivePlanQuery(Parcel parcel) {
            this.f11420c = 1;
            this.f11421d = 0;
            this.f11422e = 0;
            this.f11423f = 0;
            this.f11424g = 48;
            this.f11418a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f11419b = parcel.readString();
            this.f11420c = parcel.readInt();
            this.f11421d = parcel.readInt();
            this.f11422e = parcel.readInt();
            this.f11423f = parcel.readInt();
            this.f11424g = parcel.readInt();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DriveRouteQuery> CREATOR = new Parcelable.Creator<DriveRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.DriveRouteQuery.1
            private static DriveRouteQuery a(Parcel parcel) {
                return new DriveRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DriveRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DriveRouteQuery[] newArray(int i4) {
                return a(i4);
            }

            private static DriveRouteQuery[] a(int i4) {
                return new DriveRouteQuery[i4];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private FromAndTo f11425a;

        /* renamed from: b  reason: collision with root package name */
        private int f11426b;

        /* renamed from: c  reason: collision with root package name */
        private List<LatLonPoint> f11427c;

        /* renamed from: d  reason: collision with root package name */
        private List<List<LatLonPoint>> f11428d;

        /* renamed from: e  reason: collision with root package name */
        private String f11429e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f11430f;

        /* renamed from: g  reason: collision with root package name */
        private int f11431g;

        /* renamed from: h  reason: collision with root package name */
        private String f11432h;

        /* renamed from: i  reason: collision with root package name */
        private String f11433i;

        public DriveRouteQuery(FromAndTo fromAndTo, int i4, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.f11430f = true;
            this.f11431g = 0;
            this.f11432h = null;
            this.f11433i = "base";
            this.f11425a = fromAndTo;
            this.f11426b = i4;
            this.f11427c = list;
            this.f11428d = list2;
            this.f11429e = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                DriveRouteQuery driveRouteQuery = (DriveRouteQuery) obj;
                String str = this.f11429e;
                if (str == null) {
                    if (driveRouteQuery.f11429e != null) {
                        return false;
                    }
                } else if (!str.equals(driveRouteQuery.f11429e)) {
                    return false;
                }
                List<List<LatLonPoint>> list = this.f11428d;
                if (list == null) {
                    if (driveRouteQuery.f11428d != null) {
                        return false;
                    }
                } else if (!list.equals(driveRouteQuery.f11428d)) {
                    return false;
                }
                FromAndTo fromAndTo = this.f11425a;
                if (fromAndTo == null) {
                    if (driveRouteQuery.f11425a != null) {
                        return false;
                    }
                } else if (!fromAndTo.equals(driveRouteQuery.f11425a)) {
                    return false;
                }
                if (this.f11426b != driveRouteQuery.f11426b) {
                    return false;
                }
                List<LatLonPoint> list2 = this.f11427c;
                if (list2 == null) {
                    if (driveRouteQuery.f11427c != null) {
                        return false;
                    }
                } else if (!list2.equals(driveRouteQuery.f11427c) || this.f11430f != driveRouteQuery.isUseFerry() || this.f11431g != driveRouteQuery.f11431g) {
                    return false;
                }
                String str2 = this.f11433i;
                if (str2 == null) {
                    if (driveRouteQuery.f11433i != null) {
                        return false;
                    }
                } else if (!str2.equals(driveRouteQuery.f11433i)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public String getAvoidRoad() {
            return this.f11429e;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.f11428d;
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<List<LatLonPoint>> list = this.f11428d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i4 = 0; i4 < this.f11428d.size(); i4++) {
                List<LatLonPoint> list2 = this.f11428d.get(i4);
                for (int i5 = 0; i5 < list2.size(); i5++) {
                    LatLonPoint latLonPoint = list2.get(i5);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(",");
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i5 < list2.size() - 1) {
                        stringBuffer.append(";");
                    }
                }
                if (i4 < this.f11428d.size() - 1) {
                    stringBuffer.append("|");
                }
            }
            return stringBuffer.toString();
        }

        public int getCarType() {
            return this.f11431g;
        }

        public String getExclude() {
            return this.f11432h;
        }

        public String getExtensions() {
            return this.f11433i;
        }

        public FromAndTo getFromAndTo() {
            return this.f11425a;
        }

        public int getMode() {
            return this.f11426b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f11427c;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.f11427c;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i4 = 0; i4 < this.f11427c.size(); i4++) {
                LatLonPoint latLonPoint = this.f11427c.get(i4);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i4 < this.f11427c.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public boolean hasAvoidRoad() {
            return !j4.j(getAvoidRoad());
        }

        public boolean hasAvoidpolygons() {
            return !j4.j(getAvoidpolygonsStr());
        }

        public boolean hasPassPoint() {
            return !j4.j(getPassedPointStr());
        }

        public int hashCode() {
            String str = this.f11429e;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            List<List<LatLonPoint>> list = this.f11428d;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            FromAndTo fromAndTo = this.f11425a;
            int hashCode3 = (((hashCode2 + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.f11426b) * 31;
            List<LatLonPoint> list2 = this.f11427c;
            return ((hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.f11431g;
        }

        public boolean isUseFerry() {
            return this.f11430f;
        }

        public void setCarType(int i4) {
            this.f11431g = i4;
        }

        public void setExclude(String str) {
            this.f11432h = str;
        }

        public void setExtensions(String str) {
            this.f11433i = str;
        }

        public void setUseFerry(boolean z3) {
            this.f11430f = z3;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeParcelable(this.f11425a, i4);
            parcel.writeInt(this.f11426b);
            parcel.writeTypedList(this.f11427c);
            List<List<LatLonPoint>> list = this.f11428d;
            if (list == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(list.size());
                for (List<LatLonPoint> list2 : this.f11428d) {
                    parcel.writeTypedList(list2);
                }
            }
            parcel.writeString(this.f11429e);
            parcel.writeInt(this.f11430f ? 1 : 0);
            parcel.writeInt(this.f11431g);
            parcel.writeString(this.f11432h);
            parcel.writeString(this.f11433i);
        }

        /* renamed from: clone */
        public DriveRouteQuery m43clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                j4.i(e4, "RouteSearch", "DriveRouteQueryclone");
            }
            DriveRouteQuery driveRouteQuery = new DriveRouteQuery(this.f11425a, this.f11426b, this.f11427c, this.f11428d, this.f11429e);
            driveRouteQuery.setUseFerry(this.f11430f);
            driveRouteQuery.setCarType(this.f11431g);
            driveRouteQuery.setExclude(this.f11432h);
            driveRouteQuery.setExtensions(this.f11433i);
            return driveRouteQuery;
        }

        public DriveRouteQuery(Parcel parcel) {
            this.f11430f = true;
            this.f11431g = 0;
            this.f11432h = null;
            this.f11433i = "base";
            this.f11425a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f11426b = parcel.readInt();
            this.f11427c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.f11428d = null;
            } else {
                this.f11428d = new ArrayList();
            }
            for (int i4 = 0; i4 < readInt; i4++) {
                this.f11428d.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.f11429e = parcel.readString();
            this.f11430f = parcel.readInt() == 1;
            this.f11431g = parcel.readInt();
            this.f11432h = parcel.readString();
            this.f11433i = parcel.readString();
        }

        public DriveRouteQuery() {
            this.f11430f = true;
            this.f11431g = 0;
            this.f11432h = null;
            this.f11433i = "base";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class FromAndTo implements Parcelable, Cloneable {
        public static final Parcelable.Creator<FromAndTo> CREATOR = new Parcelable.Creator<FromAndTo>() { // from class: com.amap.api.services.route.RouteSearch.FromAndTo.1
            private static FromAndTo a(Parcel parcel) {
                return new FromAndTo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FromAndTo createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FromAndTo[] newArray(int i4) {
                return a(i4);
            }

            private static FromAndTo[] a(int i4) {
                return new FromAndTo[i4];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private LatLonPoint f11434a;

        /* renamed from: b  reason: collision with root package name */
        private LatLonPoint f11435b;

        /* renamed from: c  reason: collision with root package name */
        private String f11436c;

        /* renamed from: d  reason: collision with root package name */
        private String f11437d;

        /* renamed from: e  reason: collision with root package name */
        private String f11438e;

        /* renamed from: f  reason: collision with root package name */
        private String f11439f;

        /* renamed from: g  reason: collision with root package name */
        private String f11440g;

        /* renamed from: h  reason: collision with root package name */
        private String f11441h;

        public FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f11434a = latLonPoint;
            this.f11435b = latLonPoint2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                FromAndTo fromAndTo = (FromAndTo) obj;
                String str = this.f11437d;
                if (str == null) {
                    if (fromAndTo.f11437d != null) {
                        return false;
                    }
                } else if (!str.equals(fromAndTo.f11437d)) {
                    return false;
                }
                LatLonPoint latLonPoint = this.f11434a;
                if (latLonPoint == null) {
                    if (fromAndTo.f11434a != null) {
                        return false;
                    }
                } else if (!latLonPoint.equals(fromAndTo.f11434a)) {
                    return false;
                }
                String str2 = this.f11436c;
                if (str2 == null) {
                    if (fromAndTo.f11436c != null) {
                        return false;
                    }
                } else if (!str2.equals(fromAndTo.f11436c)) {
                    return false;
                }
                LatLonPoint latLonPoint2 = this.f11435b;
                if (latLonPoint2 == null) {
                    if (fromAndTo.f11435b != null) {
                        return false;
                    }
                } else if (!latLonPoint2.equals(fromAndTo.f11435b)) {
                    return false;
                }
                String str3 = this.f11438e;
                if (str3 == null) {
                    if (fromAndTo.f11438e != null) {
                        return false;
                    }
                } else if (!str3.equals(fromAndTo.f11438e)) {
                    return false;
                }
                String str4 = this.f11439f;
                if (str4 == null) {
                    if (fromAndTo.f11439f != null) {
                        return false;
                    }
                } else if (!str4.equals(fromAndTo.f11439f)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public String getDestinationPoiID() {
            return this.f11437d;
        }

        public String getDestinationType() {
            return this.f11439f;
        }

        public LatLonPoint getFrom() {
            return this.f11434a;
        }

        public String getOriginType() {
            return this.f11438e;
        }

        public String getPlateNumber() {
            return this.f11441h;
        }

        public String getPlateProvince() {
            return this.f11440g;
        }

        public String getStartPoiID() {
            return this.f11436c;
        }

        public LatLonPoint getTo() {
            return this.f11435b;
        }

        public int hashCode() {
            String str = this.f11437d;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint = this.f11434a;
            int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
            String str2 = this.f11436c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            LatLonPoint latLonPoint2 = this.f11435b;
            int hashCode4 = (hashCode3 + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            String str3 = this.f11438e;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f11439f;
            return hashCode5 + (str4 != null ? str4.hashCode() : 0);
        }

        public void setDestinationPoiID(String str) {
            this.f11437d = str;
        }

        public void setDestinationType(String str) {
            this.f11439f = str;
        }

        public void setOriginType(String str) {
            this.f11438e = str;
        }

        public void setPlateNumber(String str) {
            this.f11441h = str;
        }

        public void setPlateProvince(String str) {
            this.f11440g = str;
        }

        public void setStartPoiID(String str) {
            this.f11436c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeParcelable(this.f11434a, i4);
            parcel.writeParcelable(this.f11435b, i4);
            parcel.writeString(this.f11436c);
            parcel.writeString(this.f11437d);
            parcel.writeString(this.f11438e);
            parcel.writeString(this.f11439f);
        }

        /* renamed from: clone */
        public FromAndTo m44clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                j4.i(e4, "RouteSearch", "FromAndToclone");
            }
            FromAndTo fromAndTo = new FromAndTo(this.f11434a, this.f11435b);
            fromAndTo.setStartPoiID(this.f11436c);
            fromAndTo.setDestinationPoiID(this.f11437d);
            fromAndTo.setOriginType(this.f11438e);
            fromAndTo.setDestinationType(this.f11439f);
            return fromAndTo;
        }

        public FromAndTo(Parcel parcel) {
            this.f11434a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f11435b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f11436c = parcel.readString();
            this.f11437d = parcel.readString();
            this.f11438e = parcel.readString();
            this.f11439f = parcel.readString();
        }

        public FromAndTo() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnRoutePlanSearchListener {
        void onDriveRoutePlanSearched(DriveRoutePlanResult driveRoutePlanResult, int i4);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnRouteSearchListener {
        void onBusRouteSearched(BusRouteResult busRouteResult, int i4);

        void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i4);

        void onRideRouteSearched(RideRouteResult rideRouteResult, int i4);

        void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i4);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnTruckRouteSearchListener {
        void onTruckRouteSearched(TruckRouteRestult truckRouteRestult, int i4);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class RideRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<RideRouteQuery> CREATOR = new Parcelable.Creator<RideRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.RideRouteQuery.1
            private static RideRouteQuery a(Parcel parcel) {
                return new RideRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RideRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RideRouteQuery[] newArray(int i4) {
                return a(i4);
            }

            private static RideRouteQuery[] a(int i4) {
                return new RideRouteQuery[i4];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private FromAndTo f11442a;

        /* renamed from: b  reason: collision with root package name */
        private int f11443b;

        /* renamed from: c  reason: collision with root package name */
        private String f11444c;

        public RideRouteQuery(FromAndTo fromAndTo, int i4) {
            this.f11444c = "base";
            this.f11442a = fromAndTo;
            this.f11443b = i4;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                RideRouteQuery rideRouteQuery = (RideRouteQuery) obj;
                FromAndTo fromAndTo = this.f11442a;
                if (fromAndTo == null) {
                    if (rideRouteQuery.f11442a != null) {
                        return false;
                    }
                } else if (!fromAndTo.equals(rideRouteQuery.f11442a)) {
                    return false;
                }
                return this.f11443b == rideRouteQuery.f11443b;
            }
            return false;
        }

        public String getExtensions() {
            return this.f11444c;
        }

        public FromAndTo getFromAndTo() {
            return this.f11442a;
        }

        public int getMode() {
            return this.f11443b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f11442a;
            return (((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.f11443b;
        }

        public void setExtensions(String str) {
            this.f11444c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeParcelable(this.f11442a, i4);
            parcel.writeInt(this.f11443b);
            parcel.writeString(this.f11444c);
        }

        /* renamed from: clone */
        public RideRouteQuery m45clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                j4.i(e4, "RouteSearch", "RideRouteQueryclone");
            }
            RideRouteQuery rideRouteQuery = new RideRouteQuery(this.f11442a);
            rideRouteQuery.setExtensions(this.f11444c);
            return rideRouteQuery;
        }

        public RideRouteQuery(FromAndTo fromAndTo) {
            this.f11444c = "base";
            this.f11442a = fromAndTo;
        }

        public RideRouteQuery(Parcel parcel) {
            this.f11444c = "base";
            this.f11442a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f11443b = parcel.readInt();
            this.f11444c = parcel.readString();
        }

        public RideRouteQuery() {
            this.f11444c = "base";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class TruckRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<TruckRouteQuery> CREATOR = new Parcelable.Creator<TruckRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.TruckRouteQuery.1
            private static TruckRouteQuery a(Parcel parcel) {
                return new TruckRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TruckRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TruckRouteQuery[] newArray(int i4) {
                return a(i4);
            }

            private static TruckRouteQuery[] a(int i4) {
                return new TruckRouteQuery[i4];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private FromAndTo f11445a;

        /* renamed from: b  reason: collision with root package name */
        private int f11446b;

        /* renamed from: c  reason: collision with root package name */
        private int f11447c;

        /* renamed from: d  reason: collision with root package name */
        private List<LatLonPoint> f11448d;

        /* renamed from: e  reason: collision with root package name */
        private float f11449e;

        /* renamed from: f  reason: collision with root package name */
        private float f11450f;

        /* renamed from: g  reason: collision with root package name */
        private float f11451g;

        /* renamed from: h  reason: collision with root package name */
        private float f11452h;

        /* renamed from: i  reason: collision with root package name */
        private float f11453i;

        /* renamed from: j  reason: collision with root package name */
        private String f11454j;

        public TruckRouteQuery(FromAndTo fromAndTo, int i4, List<LatLonPoint> list, int i5) {
            this.f11454j = "base";
            this.f11445a = fromAndTo;
            this.f11447c = i4;
            this.f11448d = list;
            this.f11446b = i5;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getExtensions() {
            return this.f11454j;
        }

        public FromAndTo getFromAndTo() {
            return this.f11445a;
        }

        public int getMode() {
            return this.f11447c;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f11448d;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.f11448d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i4 = 0; i4 < this.f11448d.size(); i4++) {
                LatLonPoint latLonPoint = this.f11448d.get(i4);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i4 < this.f11448d.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public float getTruckAxis() {
            return this.f11453i;
        }

        public float getTruckHeight() {
            return this.f11449e;
        }

        public float getTruckLoad() {
            return this.f11451g;
        }

        public int getTruckSize() {
            return this.f11446b;
        }

        public float getTruckWeight() {
            return this.f11452h;
        }

        public float getTruckWidth() {
            return this.f11450f;
        }

        public boolean hasPassPoint() {
            return !j4.j(getPassedPointStr());
        }

        public void setExtensions(String str) {
            this.f11454j = str;
        }

        public void setMode(int i4) {
            this.f11447c = i4;
        }

        public void setTruckAxis(float f4) {
            this.f11453i = f4;
        }

        public void setTruckHeight(float f4) {
            this.f11449e = f4;
        }

        public void setTruckLoad(float f4) {
            this.f11451g = f4;
        }

        public void setTruckSize(int i4) {
            this.f11446b = i4;
        }

        public void setTruckWeight(float f4) {
            this.f11452h = f4;
        }

        public void setTruckWidth(float f4) {
            this.f11450f = f4;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeParcelable(this.f11445a, i4);
            parcel.writeInt(this.f11446b);
            parcel.writeInt(this.f11447c);
            parcel.writeTypedList(this.f11448d);
            parcel.writeFloat(this.f11449e);
            parcel.writeFloat(this.f11450f);
            parcel.writeFloat(this.f11451g);
            parcel.writeFloat(this.f11452h);
            parcel.writeFloat(this.f11453i);
            parcel.writeString(this.f11454j);
        }

        /* renamed from: clone */
        public TruckRouteQuery m46clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                j4.i(e4, "RouteSearch", "TruckRouteQueryclone");
            }
            TruckRouteQuery truckRouteQuery = new TruckRouteQuery(this.f11445a, this.f11447c, this.f11448d, this.f11446b);
            truckRouteQuery.setExtensions(this.f11454j);
            return truckRouteQuery;
        }

        protected TruckRouteQuery(Parcel parcel) {
            this.f11446b = 2;
            this.f11454j = "base";
            this.f11445a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f11446b = parcel.readInt();
            this.f11447c = parcel.readInt();
            this.f11448d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            this.f11449e = parcel.readFloat();
            this.f11450f = parcel.readFloat();
            this.f11451g = parcel.readFloat();
            this.f11452h = parcel.readFloat();
            this.f11453i = parcel.readFloat();
            this.f11454j = parcel.readString();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<WalkRouteQuery> CREATOR = new Parcelable.Creator<WalkRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.WalkRouteQuery.1
            private static WalkRouteQuery a(Parcel parcel) {
                return new WalkRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WalkRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WalkRouteQuery[] newArray(int i4) {
                return a(i4);
            }

            private static WalkRouteQuery[] a(int i4) {
                return new WalkRouteQuery[i4];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private FromAndTo f11455a;

        /* renamed from: b  reason: collision with root package name */
        private int f11456b;

        /* renamed from: c  reason: collision with root package name */
        private String f11457c;

        public WalkRouteQuery(FromAndTo fromAndTo, int i4) {
            this.f11457c = "base";
            this.f11455a = fromAndTo;
            this.f11456b = i4;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                WalkRouteQuery walkRouteQuery = (WalkRouteQuery) obj;
                FromAndTo fromAndTo = this.f11455a;
                if (fromAndTo == null) {
                    if (walkRouteQuery.f11455a != null) {
                        return false;
                    }
                } else if (!fromAndTo.equals(walkRouteQuery.f11455a)) {
                    return false;
                }
                String str = this.f11457c;
                if (str == null) {
                    if (walkRouteQuery.f11457c != null) {
                        return false;
                    }
                } else if (!str.equals(walkRouteQuery.f11457c)) {
                    return false;
                }
                return this.f11456b == walkRouteQuery.f11456b;
            }
            return false;
        }

        public String getExtensions() {
            return this.f11457c;
        }

        public FromAndTo getFromAndTo() {
            return this.f11455a;
        }

        public int getMode() {
            return this.f11456b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f11455a;
            return (((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.f11456b;
        }

        public void setExtensions(String str) {
            this.f11457c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeParcelable(this.f11455a, i4);
            parcel.writeInt(this.f11456b);
            parcel.writeString(this.f11457c);
        }

        /* renamed from: clone */
        public WalkRouteQuery m47clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                j4.i(e4, "RouteSearch", "WalkRouteQueryclone");
            }
            WalkRouteQuery walkRouteQuery = new WalkRouteQuery(this.f11455a);
            walkRouteQuery.setExtensions(this.f11457c);
            return walkRouteQuery;
        }

        public WalkRouteQuery(FromAndTo fromAndTo) {
            this.f11457c = "base";
            this.f11455a = fromAndTo;
        }

        public WalkRouteQuery(Parcel parcel) {
            this.f11457c = "base";
            this.f11455a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f11456b = parcel.readInt();
            this.f11457c = parcel.readString();
        }

        public WalkRouteQuery() {
            this.f11457c = "base";
        }
    }

    public RouteSearch(Context context) throws AMapException {
        if (this.f11411a == null) {
            try {
                this.f11411a = new t0(context);
            } catch (Exception e4) {
                e4.printStackTrace();
                if (e4 instanceof AMapException) {
                    throw ((AMapException) e4);
                }
            }
        }
    }

    public BusRouteResult calculateBusRoute(BusRouteQuery busRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f11411a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateBusRoute(busRouteQuery);
        }
        return null;
    }

    public void calculateBusRouteAsyn(BusRouteQuery busRouteQuery) {
        IRouteSearch iRouteSearch = this.f11411a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateBusRouteAsyn(busRouteQuery);
        }
    }

    public DriveRoutePlanResult calculateDrivePlan(DrivePlanQuery drivePlanQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f11411a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateDrivePlan(drivePlanQuery);
        }
        return null;
    }

    public void calculateDrivePlanAsyn(DrivePlanQuery drivePlanQuery) {
        IRouteSearch iRouteSearch = this.f11411a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateDrivePlanAsyn(drivePlanQuery);
        }
    }

    public DriveRouteResult calculateDriveRoute(DriveRouteQuery driveRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f11411a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateDriveRoute(driveRouteQuery);
        }
        return null;
    }

    public void calculateDriveRouteAsyn(DriveRouteQuery driveRouteQuery) {
        IRouteSearch iRouteSearch = this.f11411a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateDriveRouteAsyn(driveRouteQuery);
        }
    }

    public RideRouteResult calculateRideRoute(RideRouteQuery rideRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f11411a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateRideRoute(rideRouteQuery);
        }
        return null;
    }

    public void calculateRideRouteAsyn(RideRouteQuery rideRouteQuery) {
        IRouteSearch iRouteSearch = this.f11411a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateRideRouteAsyn(rideRouteQuery);
        }
    }

    public TruckRouteRestult calculateTruckRoute(TruckRouteQuery truckRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f11411a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateTruckRoute(truckRouteQuery);
        }
        return null;
    }

    public void calculateTruckRouteAsyn(TruckRouteQuery truckRouteQuery) {
        IRouteSearch iRouteSearch = this.f11411a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateTruckRouteAsyn(truckRouteQuery);
        }
    }

    public WalkRouteResult calculateWalkRoute(WalkRouteQuery walkRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f11411a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateWalkRoute(walkRouteQuery);
        }
        return null;
    }

    public void calculateWalkRouteAsyn(WalkRouteQuery walkRouteQuery) {
        IRouteSearch iRouteSearch = this.f11411a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateWalkRouteAsyn(walkRouteQuery);
        }
    }

    public void setOnRoutePlanSearchListener(OnRoutePlanSearchListener onRoutePlanSearchListener) {
        IRouteSearch iRouteSearch = this.f11411a;
        if (iRouteSearch != null) {
            iRouteSearch.setOnRoutePlanSearchListener(onRoutePlanSearchListener);
        }
    }

    public void setOnTruckRouteSearchListener(OnTruckRouteSearchListener onTruckRouteSearchListener) {
        IRouteSearch iRouteSearch = this.f11411a;
        if (iRouteSearch != null) {
            iRouteSearch.setOnTruckRouteSearchListener(onTruckRouteSearchListener);
        }
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        IRouteSearch iRouteSearch = this.f11411a;
        if (iRouteSearch != null) {
            iRouteSearch.setRouteSearchListener(onRouteSearchListener);
        }
    }
}
