package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p047s.C2082j4;
import com.amap.api.col.p047s.RouteSearchCore;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
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

    /* renamed from: a */
    private IRouteSearch f7717a;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class BusRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<BusRouteQuery> CREATOR = new Parcelable.Creator<BusRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.BusRouteQuery.1
            /* renamed from: a */
            private static BusRouteQuery m51790a(Parcel parcel) {
                return new BusRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BusRouteQuery createFromParcel(Parcel parcel) {
                return m51790a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BusRouteQuery[] newArray(int i) {
                return m51791a(i);
            }

            /* renamed from: a */
            private static BusRouteQuery[] m51791a(int i) {
                return new BusRouteQuery[i];
            }
        };

        /* renamed from: a */
        private FromAndTo f7718a;

        /* renamed from: b */
        private int f7719b;

        /* renamed from: c */
        private String f7720c;

        /* renamed from: d */
        private String f7721d;

        /* renamed from: e */
        private int f7722e;

        /* renamed from: f */
        private String f7723f;

        public BusRouteQuery(FromAndTo fromAndTo, int i, String str, int i2) {
            this.f7723f = "base";
            this.f7718a = fromAndTo;
            this.f7719b = i;
            this.f7720c = str;
            this.f7722e = i2;
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
                String str = this.f7720c;
                if (str == null) {
                    if (busRouteQuery.f7720c != null) {
                        return false;
                    }
                } else if (!str.equals(busRouteQuery.f7720c)) {
                    return false;
                }
                String str2 = this.f7721d;
                if (str2 == null) {
                    if (busRouteQuery.f7721d != null) {
                        return false;
                    }
                } else if (!str2.equals(busRouteQuery.f7721d)) {
                    return false;
                }
                String str3 = this.f7723f;
                if (str3 == null) {
                    if (busRouteQuery.f7723f != null) {
                        return false;
                    }
                } else if (!str3.equals(busRouteQuery.f7723f)) {
                    return false;
                }
                FromAndTo fromAndTo = this.f7718a;
                if (fromAndTo == null) {
                    if (busRouteQuery.f7718a != null) {
                        return false;
                    }
                } else if (!fromAndTo.equals(busRouteQuery.f7718a)) {
                    return false;
                }
                return this.f7719b == busRouteQuery.f7719b && this.f7722e == busRouteQuery.f7722e;
            }
            return false;
        }

        public String getCity() {
            return this.f7720c;
        }

        public String getCityd() {
            return this.f7721d;
        }

        public String getExtensions() {
            return this.f7723f;
        }

        public FromAndTo getFromAndTo() {
            return this.f7718a;
        }

        public int getMode() {
            return this.f7719b;
        }

        public int getNightFlag() {
            return this.f7722e;
        }

        public int hashCode() {
            String str = this.f7720c;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            FromAndTo fromAndTo = this.f7718a;
            int hashCode2 = (((((hashCode + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.f7719b) * 31) + this.f7722e) * 31;
            String str2 = this.f7721d;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public void setCityd(String str) {
            this.f7721d = str;
        }

        public void setExtensions(String str) {
            this.f7723f = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f7718a, i);
            parcel.writeInt(this.f7719b);
            parcel.writeString(this.f7720c);
            parcel.writeInt(this.f7722e);
            parcel.writeString(this.f7721d);
            parcel.writeString(this.f7723f);
        }

        /* renamed from: clone */
        public BusRouteQuery m60120clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C2082j4.m52825i(e, "RouteSearch", "BusRouteQueryclone");
            }
            BusRouteQuery busRouteQuery = new BusRouteQuery(this.f7718a, this.f7719b, this.f7720c, this.f7722e);
            busRouteQuery.setCityd(this.f7721d);
            busRouteQuery.setExtensions(this.f7723f);
            return busRouteQuery;
        }

        public BusRouteQuery(Parcel parcel) {
            this.f7723f = "base";
            this.f7718a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f7719b = parcel.readInt();
            this.f7720c = parcel.readString();
            this.f7722e = parcel.readInt();
            this.f7721d = parcel.readString();
            this.f7723f = parcel.readString();
        }

        public BusRouteQuery() {
            this.f7723f = "base";
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class DrivePlanQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DrivePlanQuery> CREATOR = new Parcelable.Creator<DrivePlanQuery>() { // from class: com.amap.api.services.route.RouteSearch.DrivePlanQuery.1
            /* renamed from: a */
            private static DrivePlanQuery m51788a(Parcel parcel) {
                return new DrivePlanQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DrivePlanQuery createFromParcel(Parcel parcel) {
                return m51788a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DrivePlanQuery[] newArray(int i) {
                return m51789a(i);
            }

            /* renamed from: a */
            private static DrivePlanQuery[] m51789a(int i) {
                return new DrivePlanQuery[i];
            }
        };

        /* renamed from: a */
        private FromAndTo f7724a;

        /* renamed from: b */
        private String f7725b;

        /* renamed from: c */
        private int f7726c;

        /* renamed from: d */
        private int f7727d;

        /* renamed from: e */
        private int f7728e;

        /* renamed from: f */
        private int f7729f;

        /* renamed from: g */
        private int f7730g;

        public DrivePlanQuery(FromAndTo fromAndTo, int i, int i2, int i3) {
            this.f7726c = 1;
            this.f7727d = 0;
            this.f7724a = fromAndTo;
            this.f7728e = i;
            this.f7729f = i2;
            this.f7730g = i3;
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
                FromAndTo fromAndTo = this.f7724a;
                if (fromAndTo == null) {
                    if (drivePlanQuery.f7724a != null) {
                        return false;
                    }
                } else if (!fromAndTo.equals(drivePlanQuery.f7724a)) {
                    return false;
                }
                String str = this.f7725b;
                if (str == null) {
                    if (drivePlanQuery.f7725b != null) {
                        return false;
                    }
                } else if (!str.equals(drivePlanQuery.f7725b)) {
                    return false;
                }
                return this.f7726c == drivePlanQuery.f7726c && this.f7727d == drivePlanQuery.f7727d && this.f7728e == drivePlanQuery.f7728e && this.f7729f == drivePlanQuery.f7729f && this.f7730g == drivePlanQuery.f7730g;
            }
            return false;
        }

        public int getCarType() {
            return this.f7727d;
        }

        public int getCount() {
            return this.f7730g;
        }

        public String getDestParentPoiID() {
            return this.f7725b;
        }

        public int getFirstTime() {
            return this.f7728e;
        }

        public FromAndTo getFromAndTo() {
            return this.f7724a;
        }

        public int getInterval() {
            return this.f7729f;
        }

        public int getMode() {
            return this.f7726c;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f7724a;
            int hashCode = ((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31;
            String str = this.f7725b;
            return ((((((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f7726c) * 31) + this.f7727d) * 31) + this.f7728e) * 31) + this.f7729f) * 31) + this.f7730g;
        }

        public void setCarType(int i) {
            this.f7727d = i;
        }

        public void setDestParentPoiID(String str) {
            this.f7725b = str;
        }

        public void setMode(int i) {
            this.f7726c = i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f7724a, i);
            parcel.writeString(this.f7725b);
            parcel.writeInt(this.f7726c);
            parcel.writeInt(this.f7727d);
            parcel.writeInt(this.f7728e);
            parcel.writeInt(this.f7729f);
            parcel.writeInt(this.f7730g);
        }

        /* renamed from: clone */
        public DrivePlanQuery m60121clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C2082j4.m52825i(e, "RouteSearch", "DriveRouteQueryclone");
            }
            DrivePlanQuery drivePlanQuery = new DrivePlanQuery(this.f7724a, this.f7728e, this.f7729f, this.f7730g);
            drivePlanQuery.setDestParentPoiID(this.f7725b);
            drivePlanQuery.setMode(this.f7726c);
            drivePlanQuery.setCarType(this.f7727d);
            return drivePlanQuery;
        }

        public DrivePlanQuery() {
            this.f7726c = 1;
            this.f7727d = 0;
            this.f7728e = 0;
            this.f7729f = 0;
            this.f7730g = 48;
        }

        protected DrivePlanQuery(Parcel parcel) {
            this.f7726c = 1;
            this.f7727d = 0;
            this.f7728e = 0;
            this.f7729f = 0;
            this.f7730g = 48;
            this.f7724a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f7725b = parcel.readString();
            this.f7726c = parcel.readInt();
            this.f7727d = parcel.readInt();
            this.f7728e = parcel.readInt();
            this.f7729f = parcel.readInt();
            this.f7730g = parcel.readInt();
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DriveRouteQuery> CREATOR = new Parcelable.Creator<DriveRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.DriveRouteQuery.1
            /* renamed from: a */
            private static DriveRouteQuery m51786a(Parcel parcel) {
                return new DriveRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DriveRouteQuery createFromParcel(Parcel parcel) {
                return m51786a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DriveRouteQuery[] newArray(int i) {
                return m51787a(i);
            }

            /* renamed from: a */
            private static DriveRouteQuery[] m51787a(int i) {
                return new DriveRouteQuery[i];
            }
        };

        /* renamed from: a */
        private FromAndTo f7731a;

        /* renamed from: b */
        private int f7732b;

        /* renamed from: c */
        private List<LatLonPoint> f7733c;

        /* renamed from: d */
        private List<List<LatLonPoint>> f7734d;

        /* renamed from: e */
        private String f7735e;

        /* renamed from: f */
        private boolean f7736f;

        /* renamed from: g */
        private int f7737g;

        /* renamed from: h */
        private String f7738h;

        /* renamed from: i */
        private String f7739i;

        public DriveRouteQuery(FromAndTo fromAndTo, int i, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.f7736f = true;
            this.f7737g = 0;
            this.f7738h = null;
            this.f7739i = "base";
            this.f7731a = fromAndTo;
            this.f7732b = i;
            this.f7733c = list;
            this.f7734d = list2;
            this.f7735e = str;
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
                String str = this.f7735e;
                if (str == null) {
                    if (driveRouteQuery.f7735e != null) {
                        return false;
                    }
                } else if (!str.equals(driveRouteQuery.f7735e)) {
                    return false;
                }
                List<List<LatLonPoint>> list = this.f7734d;
                if (list == null) {
                    if (driveRouteQuery.f7734d != null) {
                        return false;
                    }
                } else if (!list.equals(driveRouteQuery.f7734d)) {
                    return false;
                }
                FromAndTo fromAndTo = this.f7731a;
                if (fromAndTo == null) {
                    if (driveRouteQuery.f7731a != null) {
                        return false;
                    }
                } else if (!fromAndTo.equals(driveRouteQuery.f7731a)) {
                    return false;
                }
                if (this.f7732b != driveRouteQuery.f7732b) {
                    return false;
                }
                List<LatLonPoint> list2 = this.f7733c;
                if (list2 == null) {
                    if (driveRouteQuery.f7733c != null) {
                        return false;
                    }
                } else if (!list2.equals(driveRouteQuery.f7733c) || this.f7736f != driveRouteQuery.isUseFerry() || this.f7737g != driveRouteQuery.f7737g) {
                    return false;
                }
                String str2 = this.f7739i;
                if (str2 == null) {
                    if (driveRouteQuery.f7739i != null) {
                        return false;
                    }
                } else if (!str2.equals(driveRouteQuery.f7739i)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public String getAvoidRoad() {
            return this.f7735e;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.f7734d;
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<List<LatLonPoint>> list = this.f7734d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i = 0; i < this.f7734d.size(); i++) {
                List<LatLonPoint> list2 = this.f7734d.get(i);
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    LatLonPoint latLonPoint = list2.get(i2);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(",");
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i2 < list2.size() - 1) {
                        stringBuffer.append(";");
                    }
                }
                if (i < this.f7734d.size() - 1) {
                    stringBuffer.append("|");
                }
            }
            return stringBuffer.toString();
        }

        public int getCarType() {
            return this.f7737g;
        }

        public String getExclude() {
            return this.f7738h;
        }

        public String getExtensions() {
            return this.f7739i;
        }

        public FromAndTo getFromAndTo() {
            return this.f7731a;
        }

        public int getMode() {
            return this.f7732b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f7733c;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.f7733c;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i = 0; i < this.f7733c.size(); i++) {
                LatLonPoint latLonPoint = this.f7733c.get(i);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i < this.f7733c.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public boolean hasAvoidRoad() {
            return !C2082j4.m52824j(getAvoidRoad());
        }

        public boolean hasAvoidpolygons() {
            return !C2082j4.m52824j(getAvoidpolygonsStr());
        }

        public boolean hasPassPoint() {
            return !C2082j4.m52824j(getPassedPointStr());
        }

        public int hashCode() {
            String str = this.f7735e;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            List<List<LatLonPoint>> list = this.f7734d;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            FromAndTo fromAndTo = this.f7731a;
            int hashCode3 = (((hashCode2 + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.f7732b) * 31;
            List<LatLonPoint> list2 = this.f7733c;
            return ((hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.f7737g;
        }

        public boolean isUseFerry() {
            return this.f7736f;
        }

        public void setCarType(int i) {
            this.f7737g = i;
        }

        public void setExclude(String str) {
            this.f7738h = str;
        }

        public void setExtensions(String str) {
            this.f7739i = str;
        }

        public void setUseFerry(boolean z) {
            this.f7736f = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f7731a, i);
            parcel.writeInt(this.f7732b);
            parcel.writeTypedList(this.f7733c);
            List<List<LatLonPoint>> list = this.f7734d;
            if (list == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(list.size());
                for (List<LatLonPoint> list2 : this.f7734d) {
                    parcel.writeTypedList(list2);
                }
            }
            parcel.writeString(this.f7735e);
            parcel.writeInt(this.f7736f ? 1 : 0);
            parcel.writeInt(this.f7737g);
            parcel.writeString(this.f7738h);
            parcel.writeString(this.f7739i);
        }

        /* renamed from: clone */
        public DriveRouteQuery m60122clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C2082j4.m52825i(e, "RouteSearch", "DriveRouteQueryclone");
            }
            DriveRouteQuery driveRouteQuery = new DriveRouteQuery(this.f7731a, this.f7732b, this.f7733c, this.f7734d, this.f7735e);
            driveRouteQuery.setUseFerry(this.f7736f);
            driveRouteQuery.setCarType(this.f7737g);
            driveRouteQuery.setExclude(this.f7738h);
            driveRouteQuery.setExtensions(this.f7739i);
            return driveRouteQuery;
        }

        public DriveRouteQuery(Parcel parcel) {
            this.f7736f = true;
            this.f7737g = 0;
            this.f7738h = null;
            this.f7739i = "base";
            this.f7731a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f7732b = parcel.readInt();
            this.f7733c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.f7734d = null;
            } else {
                this.f7734d = new ArrayList();
            }
            for (int i = 0; i < readInt; i++) {
                this.f7734d.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.f7735e = parcel.readString();
            this.f7736f = parcel.readInt() == 1;
            this.f7737g = parcel.readInt();
            this.f7738h = parcel.readString();
            this.f7739i = parcel.readString();
        }

        public DriveRouteQuery() {
            this.f7736f = true;
            this.f7737g = 0;
            this.f7738h = null;
            this.f7739i = "base";
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class FromAndTo implements Parcelable, Cloneable {
        public static final Parcelable.Creator<FromAndTo> CREATOR = new Parcelable.Creator<FromAndTo>() { // from class: com.amap.api.services.route.RouteSearch.FromAndTo.1
            /* renamed from: a */
            private static FromAndTo m51784a(Parcel parcel) {
                return new FromAndTo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FromAndTo createFromParcel(Parcel parcel) {
                return m51784a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FromAndTo[] newArray(int i) {
                return m51785a(i);
            }

            /* renamed from: a */
            private static FromAndTo[] m51785a(int i) {
                return new FromAndTo[i];
            }
        };

        /* renamed from: a */
        private LatLonPoint f7740a;

        /* renamed from: b */
        private LatLonPoint f7741b;

        /* renamed from: c */
        private String f7742c;

        /* renamed from: d */
        private String f7743d;

        /* renamed from: e */
        private String f7744e;

        /* renamed from: f */
        private String f7745f;

        /* renamed from: g */
        private String f7746g;

        /* renamed from: h */
        private String f7747h;

        public FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f7740a = latLonPoint;
            this.f7741b = latLonPoint2;
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
                String str = this.f7743d;
                if (str == null) {
                    if (fromAndTo.f7743d != null) {
                        return false;
                    }
                } else if (!str.equals(fromAndTo.f7743d)) {
                    return false;
                }
                LatLonPoint latLonPoint = this.f7740a;
                if (latLonPoint == null) {
                    if (fromAndTo.f7740a != null) {
                        return false;
                    }
                } else if (!latLonPoint.equals(fromAndTo.f7740a)) {
                    return false;
                }
                String str2 = this.f7742c;
                if (str2 == null) {
                    if (fromAndTo.f7742c != null) {
                        return false;
                    }
                } else if (!str2.equals(fromAndTo.f7742c)) {
                    return false;
                }
                LatLonPoint latLonPoint2 = this.f7741b;
                if (latLonPoint2 == null) {
                    if (fromAndTo.f7741b != null) {
                        return false;
                    }
                } else if (!latLonPoint2.equals(fromAndTo.f7741b)) {
                    return false;
                }
                String str3 = this.f7744e;
                if (str3 == null) {
                    if (fromAndTo.f7744e != null) {
                        return false;
                    }
                } else if (!str3.equals(fromAndTo.f7744e)) {
                    return false;
                }
                String str4 = this.f7745f;
                if (str4 == null) {
                    if (fromAndTo.f7745f != null) {
                        return false;
                    }
                } else if (!str4.equals(fromAndTo.f7745f)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public String getDestinationPoiID() {
            return this.f7743d;
        }

        public String getDestinationType() {
            return this.f7745f;
        }

        public LatLonPoint getFrom() {
            return this.f7740a;
        }

        public String getOriginType() {
            return this.f7744e;
        }

        public String getPlateNumber() {
            return this.f7747h;
        }

        public String getPlateProvince() {
            return this.f7746g;
        }

        public String getStartPoiID() {
            return this.f7742c;
        }

        public LatLonPoint getTo() {
            return this.f7741b;
        }

        public int hashCode() {
            String str = this.f7743d;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint = this.f7740a;
            int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
            String str2 = this.f7742c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            LatLonPoint latLonPoint2 = this.f7741b;
            int hashCode4 = (hashCode3 + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            String str3 = this.f7744e;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f7745f;
            return hashCode5 + (str4 != null ? str4.hashCode() : 0);
        }

        public void setDestinationPoiID(String str) {
            this.f7743d = str;
        }

        public void setDestinationType(String str) {
            this.f7745f = str;
        }

        public void setOriginType(String str) {
            this.f7744e = str;
        }

        public void setPlateNumber(String str) {
            this.f7747h = str;
        }

        public void setPlateProvince(String str) {
            this.f7746g = str;
        }

        public void setStartPoiID(String str) {
            this.f7742c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f7740a, i);
            parcel.writeParcelable(this.f7741b, i);
            parcel.writeString(this.f7742c);
            parcel.writeString(this.f7743d);
            parcel.writeString(this.f7744e);
            parcel.writeString(this.f7745f);
        }

        /* renamed from: clone */
        public FromAndTo m60123clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C2082j4.m52825i(e, "RouteSearch", "FromAndToclone");
            }
            FromAndTo fromAndTo = new FromAndTo(this.f7740a, this.f7741b);
            fromAndTo.setStartPoiID(this.f7742c);
            fromAndTo.setDestinationPoiID(this.f7743d);
            fromAndTo.setOriginType(this.f7744e);
            fromAndTo.setDestinationType(this.f7745f);
            return fromAndTo;
        }

        public FromAndTo(Parcel parcel) {
            this.f7740a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f7741b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f7742c = parcel.readString();
            this.f7743d = parcel.readString();
            this.f7744e = parcel.readString();
            this.f7745f = parcel.readString();
        }

        public FromAndTo() {
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnRoutePlanSearchListener {
        void onDriveRoutePlanSearched(DriveRoutePlanResult driveRoutePlanResult, int i);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnRouteSearchListener {
        void onBusRouteSearched(BusRouteResult busRouteResult, int i);

        void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i);

        void onRideRouteSearched(RideRouteResult rideRouteResult, int i);

        void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnTruckRouteSearchListener {
        void onTruckRouteSearched(TruckRouteRestult truckRouteRestult, int i);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class RideRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<RideRouteQuery> CREATOR = new Parcelable.Creator<RideRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.RideRouteQuery.1
            /* renamed from: a */
            private static RideRouteQuery m51782a(Parcel parcel) {
                return new RideRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RideRouteQuery createFromParcel(Parcel parcel) {
                return m51782a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RideRouteQuery[] newArray(int i) {
                return m51783a(i);
            }

            /* renamed from: a */
            private static RideRouteQuery[] m51783a(int i) {
                return new RideRouteQuery[i];
            }
        };

        /* renamed from: a */
        private FromAndTo f7748a;

        /* renamed from: b */
        private int f7749b;

        /* renamed from: c */
        private String f7750c;

        public RideRouteQuery(FromAndTo fromAndTo, int i) {
            this.f7750c = "base";
            this.f7748a = fromAndTo;
            this.f7749b = i;
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
                FromAndTo fromAndTo = this.f7748a;
                if (fromAndTo == null) {
                    if (rideRouteQuery.f7748a != null) {
                        return false;
                    }
                } else if (!fromAndTo.equals(rideRouteQuery.f7748a)) {
                    return false;
                }
                return this.f7749b == rideRouteQuery.f7749b;
            }
            return false;
        }

        public String getExtensions() {
            return this.f7750c;
        }

        public FromAndTo getFromAndTo() {
            return this.f7748a;
        }

        public int getMode() {
            return this.f7749b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f7748a;
            return (((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.f7749b;
        }

        public void setExtensions(String str) {
            this.f7750c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f7748a, i);
            parcel.writeInt(this.f7749b);
            parcel.writeString(this.f7750c);
        }

        /* renamed from: clone */
        public RideRouteQuery m60124clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C2082j4.m52825i(e, "RouteSearch", "RideRouteQueryclone");
            }
            RideRouteQuery rideRouteQuery = new RideRouteQuery(this.f7748a);
            rideRouteQuery.setExtensions(this.f7750c);
            return rideRouteQuery;
        }

        public RideRouteQuery(FromAndTo fromAndTo) {
            this.f7750c = "base";
            this.f7748a = fromAndTo;
        }

        public RideRouteQuery(Parcel parcel) {
            this.f7750c = "base";
            this.f7748a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f7749b = parcel.readInt();
            this.f7750c = parcel.readString();
        }

        public RideRouteQuery() {
            this.f7750c = "base";
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class TruckRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<TruckRouteQuery> CREATOR = new Parcelable.Creator<TruckRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.TruckRouteQuery.1
            /* renamed from: a */
            private static TruckRouteQuery m51780a(Parcel parcel) {
                return new TruckRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TruckRouteQuery createFromParcel(Parcel parcel) {
                return m51780a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TruckRouteQuery[] newArray(int i) {
                return m51781a(i);
            }

            /* renamed from: a */
            private static TruckRouteQuery[] m51781a(int i) {
                return new TruckRouteQuery[i];
            }
        };

        /* renamed from: a */
        private FromAndTo f7751a;

        /* renamed from: b */
        private int f7752b;

        /* renamed from: c */
        private int f7753c;

        /* renamed from: d */
        private List<LatLonPoint> f7754d;

        /* renamed from: e */
        private float f7755e;

        /* renamed from: f */
        private float f7756f;

        /* renamed from: g */
        private float f7757g;

        /* renamed from: h */
        private float f7758h;

        /* renamed from: i */
        private float f7759i;

        /* renamed from: j */
        private String f7760j;

        public TruckRouteQuery(FromAndTo fromAndTo, int i, List<LatLonPoint> list, int i2) {
            this.f7760j = "base";
            this.f7751a = fromAndTo;
            this.f7753c = i;
            this.f7754d = list;
            this.f7752b = i2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getExtensions() {
            return this.f7760j;
        }

        public FromAndTo getFromAndTo() {
            return this.f7751a;
        }

        public int getMode() {
            return this.f7753c;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f7754d;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.f7754d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i = 0; i < this.f7754d.size(); i++) {
                LatLonPoint latLonPoint = this.f7754d.get(i);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i < this.f7754d.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public float getTruckAxis() {
            return this.f7759i;
        }

        public float getTruckHeight() {
            return this.f7755e;
        }

        public float getTruckLoad() {
            return this.f7757g;
        }

        public int getTruckSize() {
            return this.f7752b;
        }

        public float getTruckWeight() {
            return this.f7758h;
        }

        public float getTruckWidth() {
            return this.f7756f;
        }

        public boolean hasPassPoint() {
            return !C2082j4.m52824j(getPassedPointStr());
        }

        public void setExtensions(String str) {
            this.f7760j = str;
        }

        public void setMode(int i) {
            this.f7753c = i;
        }

        public void setTruckAxis(float f) {
            this.f7759i = f;
        }

        public void setTruckHeight(float f) {
            this.f7755e = f;
        }

        public void setTruckLoad(float f) {
            this.f7757g = f;
        }

        public void setTruckSize(int i) {
            this.f7752b = i;
        }

        public void setTruckWeight(float f) {
            this.f7758h = f;
        }

        public void setTruckWidth(float f) {
            this.f7756f = f;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f7751a, i);
            parcel.writeInt(this.f7752b);
            parcel.writeInt(this.f7753c);
            parcel.writeTypedList(this.f7754d);
            parcel.writeFloat(this.f7755e);
            parcel.writeFloat(this.f7756f);
            parcel.writeFloat(this.f7757g);
            parcel.writeFloat(this.f7758h);
            parcel.writeFloat(this.f7759i);
            parcel.writeString(this.f7760j);
        }

        /* renamed from: clone */
        public TruckRouteQuery m60125clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C2082j4.m52825i(e, "RouteSearch", "TruckRouteQueryclone");
            }
            TruckRouteQuery truckRouteQuery = new TruckRouteQuery(this.f7751a, this.f7753c, this.f7754d, this.f7752b);
            truckRouteQuery.setExtensions(this.f7760j);
            return truckRouteQuery;
        }

        protected TruckRouteQuery(Parcel parcel) {
            this.f7752b = 2;
            this.f7760j = "base";
            this.f7751a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f7752b = parcel.readInt();
            this.f7753c = parcel.readInt();
            this.f7754d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            this.f7755e = parcel.readFloat();
            this.f7756f = parcel.readFloat();
            this.f7757g = parcel.readFloat();
            this.f7758h = parcel.readFloat();
            this.f7759i = parcel.readFloat();
            this.f7760j = parcel.readString();
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<WalkRouteQuery> CREATOR = new Parcelable.Creator<WalkRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.WalkRouteQuery.1
            /* renamed from: a */
            private static WalkRouteQuery m51778a(Parcel parcel) {
                return new WalkRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WalkRouteQuery createFromParcel(Parcel parcel) {
                return m51778a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WalkRouteQuery[] newArray(int i) {
                return m51779a(i);
            }

            /* renamed from: a */
            private static WalkRouteQuery[] m51779a(int i) {
                return new WalkRouteQuery[i];
            }
        };

        /* renamed from: a */
        private FromAndTo f7761a;

        /* renamed from: b */
        private int f7762b;

        /* renamed from: c */
        private String f7763c;

        public WalkRouteQuery(FromAndTo fromAndTo, int i) {
            this.f7763c = "base";
            this.f7761a = fromAndTo;
            this.f7762b = i;
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
                FromAndTo fromAndTo = this.f7761a;
                if (fromAndTo == null) {
                    if (walkRouteQuery.f7761a != null) {
                        return false;
                    }
                } else if (!fromAndTo.equals(walkRouteQuery.f7761a)) {
                    return false;
                }
                String str = this.f7763c;
                if (str == null) {
                    if (walkRouteQuery.f7763c != null) {
                        return false;
                    }
                } else if (!str.equals(walkRouteQuery.f7763c)) {
                    return false;
                }
                return this.f7762b == walkRouteQuery.f7762b;
            }
            return false;
        }

        public String getExtensions() {
            return this.f7763c;
        }

        public FromAndTo getFromAndTo() {
            return this.f7761a;
        }

        public int getMode() {
            return this.f7762b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f7761a;
            return (((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.f7762b;
        }

        public void setExtensions(String str) {
            this.f7763c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f7761a, i);
            parcel.writeInt(this.f7762b);
            parcel.writeString(this.f7763c);
        }

        /* renamed from: clone */
        public WalkRouteQuery m60126clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C2082j4.m52825i(e, "RouteSearch", "WalkRouteQueryclone");
            }
            WalkRouteQuery walkRouteQuery = new WalkRouteQuery(this.f7761a);
            walkRouteQuery.setExtensions(this.f7763c);
            return walkRouteQuery;
        }

        public WalkRouteQuery(FromAndTo fromAndTo) {
            this.f7763c = "base";
            this.f7761a = fromAndTo;
        }

        public WalkRouteQuery(Parcel parcel) {
            this.f7763c = "base";
            this.f7761a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f7762b = parcel.readInt();
            this.f7763c = parcel.readString();
        }

        public WalkRouteQuery() {
            this.f7763c = "base";
        }
    }

    public RouteSearch(Context context) throws AMapException {
        if (this.f7717a == null) {
            try {
                this.f7717a = new RouteSearchCore(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    public BusRouteResult calculateBusRoute(BusRouteQuery busRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f7717a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateBusRoute(busRouteQuery);
        }
        return null;
    }

    public void calculateBusRouteAsyn(BusRouteQuery busRouteQuery) {
        IRouteSearch iRouteSearch = this.f7717a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateBusRouteAsyn(busRouteQuery);
        }
    }

    public DriveRoutePlanResult calculateDrivePlan(DrivePlanQuery drivePlanQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f7717a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateDrivePlan(drivePlanQuery);
        }
        return null;
    }

    public void calculateDrivePlanAsyn(DrivePlanQuery drivePlanQuery) {
        IRouteSearch iRouteSearch = this.f7717a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateDrivePlanAsyn(drivePlanQuery);
        }
    }

    public DriveRouteResult calculateDriveRoute(DriveRouteQuery driveRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f7717a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateDriveRoute(driveRouteQuery);
        }
        return null;
    }

    public void calculateDriveRouteAsyn(DriveRouteQuery driveRouteQuery) {
        IRouteSearch iRouteSearch = this.f7717a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateDriveRouteAsyn(driveRouteQuery);
        }
    }

    public RideRouteResult calculateRideRoute(RideRouteQuery rideRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f7717a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateRideRoute(rideRouteQuery);
        }
        return null;
    }

    public void calculateRideRouteAsyn(RideRouteQuery rideRouteQuery) {
        IRouteSearch iRouteSearch = this.f7717a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateRideRouteAsyn(rideRouteQuery);
        }
    }

    public TruckRouteRestult calculateTruckRoute(TruckRouteQuery truckRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f7717a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateTruckRoute(truckRouteQuery);
        }
        return null;
    }

    public void calculateTruckRouteAsyn(TruckRouteQuery truckRouteQuery) {
        IRouteSearch iRouteSearch = this.f7717a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateTruckRouteAsyn(truckRouteQuery);
        }
    }

    public WalkRouteResult calculateWalkRoute(WalkRouteQuery walkRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f7717a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateWalkRoute(walkRouteQuery);
        }
        return null;
    }

    public void calculateWalkRouteAsyn(WalkRouteQuery walkRouteQuery) {
        IRouteSearch iRouteSearch = this.f7717a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateWalkRouteAsyn(walkRouteQuery);
        }
    }

    public void setOnRoutePlanSearchListener(OnRoutePlanSearchListener onRoutePlanSearchListener) {
        IRouteSearch iRouteSearch = this.f7717a;
        if (iRouteSearch != null) {
            iRouteSearch.setOnRoutePlanSearchListener(onRoutePlanSearchListener);
        }
    }

    public void setOnTruckRouteSearchListener(OnTruckRouteSearchListener onTruckRouteSearchListener) {
        IRouteSearch iRouteSearch = this.f7717a;
        if (iRouteSearch != null) {
            iRouteSearch.setOnTruckRouteSearchListener(onTruckRouteSearchListener);
        }
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        IRouteSearch iRouteSearch = this.f7717a;
        if (iRouteSearch != null) {
            iRouteSearch.setRouteSearchListener(onRouteSearchListener);
        }
    }
}
