package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.j4;
import com.amap.api.col.s.u0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearchV2;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RouteSearchV2 {

    /* renamed from: a  reason: collision with root package name */
    private IRouteSearchV2 f11459a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class AlternativeRoute {
        public static final int ALTERNATIVE_ROUTE_ONE = 1;
        public static final int ALTERNATIVE_ROUTE_THREE = 3;
        public static final int ALTERNATIVE_ROUTE_TWO = 2;

        public AlternativeRoute() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class BusMode {
        public static final int BUS_COMFORTABLE = 4;
        public static final int BUS_DEFAULT = 0;
        public static final int BUS_LEASE_CHANGE = 2;
        public static final int BUS_LEASE_WALK = 3;
        public static final int BUS_NO_SUBWAY = 5;
        public static final int BUS_SAVE_MONEY = 1;
        public static final int BUS_SUBWAY = 6;
        public static final int BUS_SUBWAY_FIRST = 7;
        public static final int BUS_WASTE_LESS = 8;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class BusRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<BusRouteQuery> CREATOR = new Parcelable.Creator<BusRouteQuery>() { // from class: com.amap.api.services.route.RouteSearchV2.BusRouteQuery.1
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
        private FromAndTo f11461a;

        /* renamed from: b  reason: collision with root package name */
        private int f11462b;

        /* renamed from: c  reason: collision with root package name */
        private String f11463c;

        /* renamed from: d  reason: collision with root package name */
        private String f11464d;

        /* renamed from: e  reason: collision with root package name */
        private String f11465e;

        /* renamed from: f  reason: collision with root package name */
        private String f11466f;

        /* renamed from: g  reason: collision with root package name */
        private int f11467g;

        /* renamed from: h  reason: collision with root package name */
        private String f11468h;

        /* renamed from: i  reason: collision with root package name */
        private String f11469i;

        /* renamed from: j  reason: collision with root package name */
        private String f11470j;

        /* renamed from: k  reason: collision with root package name */
        private String f11471k;

        /* renamed from: l  reason: collision with root package name */
        private int f11472l;

        /* renamed from: m  reason: collision with root package name */
        private int f11473m;

        /* renamed from: n  reason: collision with root package name */
        private int f11474n;

        /* renamed from: o  reason: collision with root package name */
        private int f11475o;

        public BusRouteQuery(FromAndTo fromAndTo, int i4, String str, int i5) {
            this.f11472l = 5;
            this.f11473m = 0;
            this.f11474n = 4;
            this.f11475o = 1;
            this.f11461a = fromAndTo;
            this.f11462b = i4;
            this.f11463c = str;
            this.f11467g = i5;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            BusRouteQuery busRouteQuery = (BusRouteQuery) obj;
            if (this.f11462b == busRouteQuery.f11462b && this.f11467g == busRouteQuery.f11467g && this.f11468h.equals(busRouteQuery.f11468h) && this.f11469i.equals(busRouteQuery.f11469i) && this.f11472l == busRouteQuery.f11472l && this.f11473m == busRouteQuery.f11473m && this.f11474n == busRouteQuery.f11474n && this.f11475o == busRouteQuery.f11475o && this.f11461a.equals(busRouteQuery.f11461a) && this.f11463c.equals(busRouteQuery.f11463c) && this.f11464d.equals(busRouteQuery.f11464d) && this.f11465e.equals(busRouteQuery.f11465e) && this.f11466f.equals(busRouteQuery.f11466f) && this.f11470j.equals(busRouteQuery.f11470j)) {
                return this.f11471k.equals(busRouteQuery.f11471k);
            }
            return false;
        }

        public String getAd1() {
            return this.f11470j;
        }

        public String getAd2() {
            return this.f11471k;
        }

        public int getAlternativeRoute() {
            return this.f11472l;
        }

        public String getCity() {
            return this.f11463c;
        }

        public String getCityd() {
            return this.f11464d;
        }

        public String getDate() {
            return this.f11465e;
        }

        public String getDestinationPoiId() {
            return this.f11469i;
        }

        public FromAndTo getFromAndTo() {
            return this.f11461a;
        }

        public int getMaxTrans() {
            return this.f11474n;
        }

        public int getMode() {
            return this.f11462b;
        }

        public int getMultiExport() {
            return this.f11473m;
        }

        public int getNightFlag() {
            return this.f11467g;
        }

        public String getOriginPoiId() {
            return this.f11468h;
        }

        public int getShowFields() {
            return this.f11475o;
        }

        public String getTime() {
            return this.f11466f;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((this.f11461a.hashCode() * 31) + this.f11462b) * 31) + this.f11463c.hashCode()) * 31) + this.f11464d.hashCode()) * 31) + this.f11465e.hashCode()) * 31) + this.f11466f.hashCode()) * 31) + this.f11467g) * 31) + this.f11468h.hashCode()) * 31) + this.f11469i.hashCode()) * 31) + this.f11470j.hashCode()) * 31) + this.f11471k.hashCode()) * 31) + this.f11472l) * 31) + this.f11473m) * 31) + this.f11474n) * 31) + this.f11475o;
        }

        public void setAd1(String str) {
            this.f11470j = str;
        }

        public void setAd2(String str) {
            this.f11471k = str;
        }

        public void setAlternativeRoute(int i4) {
            this.f11472l = i4;
        }

        public void setCityd(String str) {
            this.f11464d = str;
        }

        public void setDate(String str) {
            this.f11465e = str;
        }

        public void setDestinationPoiId(String str) {
            this.f11469i = str;
        }

        public void setMaxTrans(int i4) {
            this.f11474n = i4;
        }

        public void setMultiExport(int i4) {
            this.f11473m = i4;
        }

        public void setOriginPoiId(String str) {
            this.f11468h = str;
        }

        public void setShowFields(int i4) {
            this.f11475o = i4;
        }

        public void setTime(String str) {
            this.f11466f = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeParcelable(this.f11461a, i4);
            parcel.writeInt(this.f11462b);
            parcel.writeString(this.f11463c);
            parcel.writeInt(this.f11467g);
            parcel.writeString(this.f11464d);
            parcel.writeInt(this.f11475o);
            parcel.writeString(this.f11468h);
            parcel.writeString(this.f11469i);
            parcel.writeString(this.f11470j);
            parcel.writeString(this.f11471k);
            parcel.writeInt(this.f11472l);
            parcel.writeInt(this.f11474n);
            parcel.writeInt(this.f11473m);
            parcel.writeString(this.f11465e);
            parcel.writeString(this.f11466f);
        }

        /* renamed from: clone */
        public BusRouteQuery m48clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                j4.i(e4, "RouteSearchV2", "BusRouteQueryclone");
            }
            BusRouteQuery busRouteQuery = new BusRouteQuery(this.f11461a, this.f11462b, this.f11463c, this.f11467g);
            busRouteQuery.setCityd(this.f11464d);
            busRouteQuery.setShowFields(this.f11475o);
            busRouteQuery.setDate(this.f11465e);
            busRouteQuery.setTime(this.f11466f);
            busRouteQuery.setAd1(this.f11470j);
            busRouteQuery.setAd2(this.f11471k);
            busRouteQuery.setOriginPoiId(this.f11468h);
            busRouteQuery.setDestinationPoiId(this.f11469i);
            busRouteQuery.setMaxTrans(this.f11474n);
            busRouteQuery.setMultiExport(this.f11473m);
            busRouteQuery.setAlternativeRoute(this.f11472l);
            return busRouteQuery;
        }

        public BusRouteQuery(Parcel parcel) {
            this.f11462b = 0;
            this.f11467g = 0;
            this.f11472l = 5;
            this.f11473m = 0;
            this.f11474n = 4;
            this.f11475o = 1;
            this.f11461a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f11462b = parcel.readInt();
            this.f11463c = parcel.readString();
            this.f11467g = parcel.readInt();
            this.f11464d = parcel.readString();
            this.f11475o = parcel.readInt();
            this.f11468h = parcel.readString();
            this.f11469i = parcel.readString();
            this.f11465e = parcel.readString();
            this.f11466f = parcel.readString();
            this.f11474n = parcel.readInt();
            this.f11473m = parcel.readInt();
            this.f11472l = parcel.readInt();
            this.f11470j = parcel.readString();
            this.f11471k = parcel.readString();
        }

        public BusRouteQuery() {
            this.f11462b = 0;
            this.f11467g = 0;
            this.f11472l = 5;
            this.f11473m = 0;
            this.f11474n = 4;
            this.f11475o = 1;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class CurveCost {

        /* renamed from: a  reason: collision with root package name */
        private float f11476a;

        /* renamed from: b  reason: collision with root package name */
        private float f11477b;

        public float getAccess() {
            return this.f11476a;
        }

        public float getValue() {
            return this.f11477b;
        }

        public void setAccess(float f4) {
            this.f11476a = f4;
        }

        public void setValue(float f4) {
            this.f11477b = f4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class CustomCostMode {

        /* renamed from: a  reason: collision with root package name */
        private List<SpeedCost> f11478a;

        /* renamed from: b  reason: collision with root package name */
        private CurveCost f11479b;

        /* renamed from: c  reason: collision with root package name */
        private SlopeCost f11480c;

        /* renamed from: d  reason: collision with root package name */
        private float f11481d;

        /* renamed from: e  reason: collision with root package name */
        private TransCost f11482e;

        /* renamed from: f  reason: collision with root package name */
        private float f11483f;

        /* renamed from: g  reason: collision with root package name */
        private PowerTrainLoss f11484g;

        public float getAuxCost() {
            return this.f11481d;
        }

        public CurveCost getCurveCost() {
            return this.f11479b;
        }

        public float getFerryCost() {
            return this.f11483f;
        }

        public PowerTrainLoss getPowerTrainLosses() {
            return this.f11484g;
        }

        public SlopeCost getSlopeCost() {
            return this.f11480c;
        }

        public List<SpeedCost> getSpeedCosts() {
            return this.f11478a;
        }

        public TransCost getTransCost() {
            return this.f11482e;
        }

        public void setAuxCost(float f4) {
            this.f11481d = f4;
        }

        public void setCurveCost(CurveCost curveCost) {
            this.f11479b = curveCost;
        }

        public void setFerryCost(float f4) {
            this.f11483f = f4;
        }

        public void setPowerTrainLosses(PowerTrainLoss powerTrainLoss) {
            this.f11484g = powerTrainLoss;
        }

        public void setSlopeCost(SlopeCost slopeCost) {
            this.f11480c = slopeCost;
        }

        public void setSpeedCosts(List<SpeedCost> list) {
            this.f11478a = list;
        }

        public void setTransCost(TransCost transCost) {
            this.f11482e = transCost;
        }

        public String toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                List<SpeedCost> list = this.f11478a;
                if (list != null) {
                    for (SpeedCost speedCost : list) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("speed", speedCost.getSpeed());
                        jSONObject2.put("value", speedCost.getValue());
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("speed_cost", jSONArray);
                }
                if (this.f11479b != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("access", this.f11479b.getAccess());
                    jSONObject3.put("value", this.f11479b.getValue());
                    jSONObject.put("curve_cost", jSONObject3);
                }
                if (this.f11480c != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("up", this.f11480c.getUp());
                    jSONObject4.put("down", this.f11480c.getDown());
                    jSONObject.put("slope_cost", jSONObject4);
                }
                jSONObject.put("aux_cost", this.f11481d);
                if (this.f11482e != null) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("access", this.f11482e.getAccess());
                    jSONObject5.put("decess", this.f11482e.getDecess());
                    jSONObject.put("trans_cost", jSONObject5);
                }
                jSONObject.put("ferry_cost", this.f11483f);
                if (this.f11484g != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("powerdemand", this.f11484g.getPowerDemand());
                    jSONObject6.put("value", this.f11484g.getPowerDemandValue());
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("speed", this.f11484g.getSpeed());
                    jSONObject7.put("value", this.f11484g.getSpeedValue());
                    jSONArray2.put(jSONObject6);
                    jSONArray2.put(jSONObject7);
                    jSONObject.put("powertrain_loss", jSONArray2);
                }
                return jSONObject.toString();
            } catch (JSONException e4) {
                e4.printStackTrace();
                return null;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DriveRouteQuery> CREATOR = new Parcelable.Creator<DriveRouteQuery>() { // from class: com.amap.api.services.route.RouteSearchV2.DriveRouteQuery.1
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
        private FromAndTo f11485a;

        /* renamed from: b  reason: collision with root package name */
        private NewEnergy f11486b;

        /* renamed from: c  reason: collision with root package name */
        private int f11487c;

        /* renamed from: d  reason: collision with root package name */
        private List<LatLonPoint> f11488d;

        /* renamed from: e  reason: collision with root package name */
        private List<List<LatLonPoint>> f11489e;

        /* renamed from: f  reason: collision with root package name */
        private String f11490f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f11491g;

        /* renamed from: h  reason: collision with root package name */
        private int f11492h;

        /* renamed from: i  reason: collision with root package name */
        private String f11493i;

        /* renamed from: j  reason: collision with root package name */
        private int f11494j;

        public DriveRouteQuery(FromAndTo fromAndTo, DrivingStrategy drivingStrategy, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.f11487c = DrivingStrategy.DEFAULT.getValue();
            this.f11491g = true;
            this.f11492h = 0;
            this.f11493i = null;
            this.f11494j = 1;
            this.f11485a = fromAndTo;
            this.f11487c = drivingStrategy.getValue();
            this.f11488d = list;
            this.f11489e = list2;
            this.f11490f = str;
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
                String str = this.f11490f;
                if (str == null) {
                    if (driveRouteQuery.f11490f != null) {
                        return false;
                    }
                } else if (!str.equals(driveRouteQuery.f11490f)) {
                    return false;
                }
                List<List<LatLonPoint>> list = this.f11489e;
                if (list == null) {
                    if (driveRouteQuery.f11489e != null) {
                        return false;
                    }
                } else if (!list.equals(driveRouteQuery.f11489e)) {
                    return false;
                }
                FromAndTo fromAndTo = this.f11485a;
                if (fromAndTo == null) {
                    if (driveRouteQuery.f11485a != null) {
                        return false;
                    }
                } else if (!fromAndTo.equals(driveRouteQuery.f11485a)) {
                    return false;
                }
                if (this.f11487c != driveRouteQuery.f11487c) {
                    return false;
                }
                List<LatLonPoint> list2 = this.f11488d;
                if (list2 == null) {
                    if (driveRouteQuery.f11488d != null) {
                        return false;
                    }
                } else if (!list2.equals(driveRouteQuery.f11488d) || this.f11491g != driveRouteQuery.isUseFerry() || this.f11492h != driveRouteQuery.f11492h || this.f11494j != driveRouteQuery.f11494j) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public String getAvoidRoad() {
            return this.f11490f;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.f11489e;
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<List<LatLonPoint>> list = this.f11489e;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i4 = 0; i4 < this.f11489e.size(); i4++) {
                List<LatLonPoint> list2 = this.f11489e.get(i4);
                for (int i5 = 0; i5 < list2.size(); i5++) {
                    LatLonPoint latLonPoint = list2.get(i5);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(",");
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i5 < list2.size() - 1) {
                        stringBuffer.append(";");
                    }
                }
                if (i4 < this.f11489e.size() - 1) {
                    stringBuffer.append("|");
                }
            }
            return stringBuffer.toString();
        }

        public int getCarType() {
            return this.f11492h;
        }

        public String getExclude() {
            return this.f11493i;
        }

        public FromAndTo getFromAndTo() {
            return this.f11485a;
        }

        public DrivingStrategy getMode() {
            return DrivingStrategy.fromValue(this.f11487c);
        }

        public NewEnergy getNewEnergy() {
            return this.f11486b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f11488d;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.f11488d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i4 = 0; i4 < this.f11488d.size(); i4++) {
                LatLonPoint latLonPoint = this.f11488d.get(i4);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i4 < this.f11488d.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public int getShowFields() {
            return this.f11494j;
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
            String str = this.f11490f;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            List<List<LatLonPoint>> list = this.f11489e;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            FromAndTo fromAndTo = this.f11485a;
            int hashCode3 = (((hashCode2 + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.f11487c) * 31;
            List<LatLonPoint> list2 = this.f11488d;
            return ((hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.f11492h;
        }

        public boolean isUseFerry() {
            return this.f11491g;
        }

        public void setCarType(int i4) {
            this.f11492h = i4;
        }

        public void setExclude(String str) {
            this.f11493i = str;
        }

        public void setNewEnergy(NewEnergy newEnergy) {
            this.f11486b = newEnergy;
        }

        public void setShowFields(int i4) {
            this.f11494j = i4;
        }

        public void setUseFerry(boolean z3) {
            this.f11491g = z3;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeParcelable(this.f11485a, i4);
            parcel.writeInt(this.f11487c);
            parcel.writeTypedList(this.f11488d);
            List<List<LatLonPoint>> list = this.f11489e;
            if (list == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(list.size());
                for (List<LatLonPoint> list2 : this.f11489e) {
                    parcel.writeTypedList(list2);
                }
            }
            parcel.writeString(this.f11490f);
            parcel.writeInt(this.f11491g ? 1 : 0);
            parcel.writeInt(this.f11492h);
            parcel.writeString(this.f11493i);
            parcel.writeInt(this.f11494j);
        }

        /* renamed from: clone */
        public DriveRouteQuery m49clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                j4.i(e4, "RouteSearchV2", "DriveRouteQueryclone");
            }
            DriveRouteQuery driveRouteQuery = new DriveRouteQuery(this.f11485a, DrivingStrategy.fromValue(this.f11487c), this.f11488d, this.f11489e, this.f11490f);
            driveRouteQuery.setUseFerry(this.f11491g);
            driveRouteQuery.setCarType(this.f11492h);
            driveRouteQuery.setExclude(this.f11493i);
            driveRouteQuery.setShowFields(this.f11494j);
            driveRouteQuery.setNewEnergy(this.f11486b);
            return driveRouteQuery;
        }

        public DriveRouteQuery(Parcel parcel) {
            this.f11487c = DrivingStrategy.DEFAULT.getValue();
            this.f11491g = true;
            this.f11492h = 0;
            this.f11493i = null;
            this.f11494j = 1;
            this.f11485a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f11487c = parcel.readInt();
            this.f11488d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.f11489e = null;
            } else {
                this.f11489e = new ArrayList();
            }
            for (int i4 = 0; i4 < readInt; i4++) {
                this.f11489e.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.f11490f = parcel.readString();
            this.f11491g = parcel.readInt() == 1;
            this.f11492h = parcel.readInt();
            this.f11493i = parcel.readString();
            this.f11494j = parcel.readInt();
        }

        public DriveRouteQuery() {
            this.f11487c = DrivingStrategy.DEFAULT.getValue();
            this.f11491g = true;
            this.f11492h = 0;
            this.f11493i = null;
            this.f11494j = 1;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum DrivingStrategy {
        DEFAULT(32),
        AVOID_CONGESTION(33),
        HIGHWAY_PRIORITY(34),
        AVOID_HIGHWAY(35),
        LESS_CHARGE(36),
        ROAD_PRIORITY(37),
        SPEED_PRIORITY(38),
        AVOID_CONGESTION_HIGHWAY_PRIORITY(39),
        AVOID_CONGESTION_AVOID_HIGHWAY(40),
        AVOID_CONGESTION_LESS_CHARGE(41),
        LESS_CHARGE_AVOID_HIGHWAY(42),
        AVOID_CONGESTION_LESS_CHARGE_AVOID_HIGHWAY(43),
        AVOID_CONGESTION_ROAD_PRIORITY(44),
        AVOID_CONGESTION_SPEED_PRIORITY(45);
        

        /* renamed from: a  reason: collision with root package name */
        int f11496a;

        DrivingStrategy(int i4) {
            this.f11496a = i4;
        }

        public static DrivingStrategy fromValue(int i4) {
            return values()[i4 - 32];
        }

        public final int getValue() {
            return this.f11496a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class FromAndTo implements Parcelable, Cloneable {
        public static final Parcelable.Creator<FromAndTo> CREATOR = new Parcelable.Creator<FromAndTo>() { // from class: com.amap.api.services.route.RouteSearchV2.FromAndTo.1
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
        private LatLonPoint f11497a;

        /* renamed from: b  reason: collision with root package name */
        private LatLonPoint f11498b;

        /* renamed from: c  reason: collision with root package name */
        private String f11499c;

        /* renamed from: d  reason: collision with root package name */
        private String f11500d;

        /* renamed from: e  reason: collision with root package name */
        private String f11501e;

        /* renamed from: f  reason: collision with root package name */
        private String f11502f;

        /* renamed from: g  reason: collision with root package name */
        private String f11503g;

        public FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f11497a = latLonPoint;
            this.f11498b = latLonPoint2;
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
                String str = this.f11500d;
                if (str == null) {
                    if (fromAndTo.f11500d != null) {
                        return false;
                    }
                } else if (!str.equals(fromAndTo.f11500d)) {
                    return false;
                }
                LatLonPoint latLonPoint = this.f11497a;
                if (latLonPoint == null) {
                    if (fromAndTo.f11497a != null) {
                        return false;
                    }
                } else if (!latLonPoint.equals(fromAndTo.f11497a)) {
                    return false;
                }
                String str2 = this.f11499c;
                if (str2 == null) {
                    if (fromAndTo.f11499c != null) {
                        return false;
                    }
                } else if (!str2.equals(fromAndTo.f11499c)) {
                    return false;
                }
                LatLonPoint latLonPoint2 = this.f11498b;
                if (latLonPoint2 == null) {
                    if (fromAndTo.f11498b != null) {
                        return false;
                    }
                } else if (!latLonPoint2.equals(fromAndTo.f11498b)) {
                    return false;
                }
                String str3 = this.f11501e;
                if (str3 == null) {
                    if (fromAndTo.f11501e != null) {
                        return false;
                    }
                } else if (!str3.equals(fromAndTo.f11501e)) {
                    return false;
                }
                String str4 = this.f11502f;
                if (str4 == null) {
                    if (fromAndTo.f11502f != null) {
                        return false;
                    }
                } else if (!str4.equals(fromAndTo.f11502f)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public String getDestinationPoiID() {
            return this.f11500d;
        }

        public String getDestinationType() {
            return this.f11502f;
        }

        public LatLonPoint getFrom() {
            return this.f11497a;
        }

        public String getOriginType() {
            return this.f11501e;
        }

        public String getPlateNumber() {
            return this.f11503g;
        }

        public String getStartPoiID() {
            return this.f11499c;
        }

        public LatLonPoint getTo() {
            return this.f11498b;
        }

        public int hashCode() {
            String str = this.f11500d;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint = this.f11497a;
            int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
            String str2 = this.f11499c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            LatLonPoint latLonPoint2 = this.f11498b;
            int hashCode4 = (hashCode3 + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            String str3 = this.f11501e;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f11502f;
            return hashCode5 + (str4 != null ? str4.hashCode() : 0);
        }

        public void setDestinationPoiID(String str) {
            this.f11500d = str;
        }

        public void setDestinationType(String str) {
            this.f11502f = str;
        }

        public void setOriginType(String str) {
            this.f11501e = str;
        }

        public void setPlateNumber(String str) {
            this.f11503g = str;
        }

        public void setStartPoiID(String str) {
            this.f11499c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeParcelable(this.f11497a, i4);
            parcel.writeParcelable(this.f11498b, i4);
            parcel.writeString(this.f11499c);
            parcel.writeString(this.f11500d);
            parcel.writeString(this.f11501e);
            parcel.writeString(this.f11502f);
        }

        /* renamed from: clone */
        public FromAndTo m50clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                j4.i(e4, "RouteSearchV2", "FromAndToclone");
            }
            FromAndTo fromAndTo = new FromAndTo(this.f11497a, this.f11498b);
            fromAndTo.setStartPoiID(this.f11499c);
            fromAndTo.setDestinationPoiID(this.f11500d);
            fromAndTo.setOriginType(this.f11501e);
            fromAndTo.setDestinationType(this.f11502f);
            return fromAndTo;
        }

        public FromAndTo(Parcel parcel) {
            this.f11497a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f11498b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f11499c = parcel.readString();
            this.f11500d = parcel.readString();
            this.f11501e = parcel.readString();
            this.f11502f = parcel.readString();
        }

        public FromAndTo() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class NewEnergy {

        /* renamed from: a  reason: collision with root package name */
        private String f11504a;

        /* renamed from: b  reason: collision with root package name */
        private CustomCostMode f11505b;

        /* renamed from: h  reason: collision with root package name */
        private String f11511h;

        /* renamed from: c  reason: collision with root package name */
        private float f11506c = -1.0f;

        /* renamed from: d  reason: collision with root package name */
        private float f11507d = -1.0f;

        /* renamed from: e  reason: collision with root package name */
        private float f11508e = 1.5f;

        /* renamed from: f  reason: collision with root package name */
        private float f11509f = 100.0f;

        /* renamed from: g  reason: collision with root package name */
        private float f11510g = 0.0f;

        /* renamed from: i  reason: collision with root package name */
        private int f11512i = 0;

        public String buildParam() {
            StringBuilder sb = new StringBuilder();
            if (this.f11504a != null) {
                sb.append("&key=");
                sb.append(this.f11504a);
            }
            if (this.f11505b != null) {
                sb.append("&custom_cost_mode=");
                sb.append(this.f11505b.toJson());
            }
            if (this.f11506c > 0.0f) {
                sb.append("&max_vehicle_charge=");
                sb.append(this.f11506c);
            }
            if (this.f11507d > 0.0f) {
                sb.append("&vehicle_charge=");
                sb.append(this.f11507d);
            }
            sb.append("&load=");
            sb.append(this.f11508e);
            sb.append("&leaving_percent=");
            sb.append(this.f11509f);
            sb.append("&arriving_percent=");
            sb.append(this.f11510g);
            if (this.f11511h != null) {
                sb.append("&custom_charging_arguments=");
                sb.append(this.f11511h);
            }
            if (this.f11512i > 0) {
                sb.append("&waypoints_arriving_percent=");
                sb.append(this.f11512i);
            }
            return sb.toString();
        }

        public float getArrivingPercent() {
            return this.f11510g;
        }

        public String getCustomChargingArguments() {
            return this.f11511h;
        }

        public CustomCostMode getCustomCostMode() {
            return this.f11505b;
        }

        public String getKey() {
            return this.f11504a;
        }

        public float getLeavingPercent() {
            return this.f11509f;
        }

        public float getLoad() {
            return this.f11508e;
        }

        public float getMaxVehicleCharge() {
            return this.f11506c;
        }

        public float getVehicleCharge() {
            return this.f11507d;
        }

        public int getWaypointsArrivingPercent() {
            return this.f11512i;
        }

        public void setArrivingPercent(float f4) {
            this.f11510g = f4;
        }

        public void setCustomChargingArguments(String str) {
            this.f11511h = str;
        }

        public void setCustomCostMode(CustomCostMode customCostMode) {
            this.f11505b = customCostMode;
        }

        public void setKey(String str) {
            this.f11504a = str;
        }

        public void setLeavingPercent(float f4) {
            this.f11509f = f4;
        }

        public void setLoad(float f4) {
            this.f11508e = f4;
        }

        public void setMaxVehicleCharge(float f4) {
            this.f11506c = f4;
        }

        public void setVehicleCharge(float f4) {
            this.f11507d = f4;
        }

        public void setWaypointsArrivingPercent(int i4) {
            this.f11512i = i4;
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
        void onBusRouteSearched(BusRouteResultV2 busRouteResultV2, int i4);

        void onDriveRouteSearched(DriveRouteResultV2 driveRouteResultV2, int i4);

        void onRideRouteSearched(RideRouteResultV2 rideRouteResultV2, int i4);

        void onWalkRouteSearched(WalkRouteResultV2 walkRouteResultV2, int i4);
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
    public static class PowerTrainLoss {

        /* renamed from: a  reason: collision with root package name */
        private int f11513a;

        /* renamed from: b  reason: collision with root package name */
        private float f11514b;

        /* renamed from: c  reason: collision with root package name */
        private int f11515c;

        /* renamed from: d  reason: collision with root package name */
        private int f11516d;

        public int getPowerDemand() {
            return this.f11513a;
        }

        public float getPowerDemandValue() {
            return this.f11514b;
        }

        public int getSpeed() {
            return this.f11515c;
        }

        public int getSpeedValue() {
            return this.f11516d;
        }

        public void setPowerDemand(int i4) {
            this.f11513a = i4;
        }

        public void setPowerDemandValue(float f4) {
            this.f11514b = f4;
        }

        public void setSpeed(int i4) {
            this.f11515c = i4;
        }

        public void setSpeedValue(int i4) {
            this.f11516d = i4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class RideRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<RideRouteQuery> CREATOR = new Parcelable.Creator<RideRouteQuery>() { // from class: com.amap.api.services.route.RouteSearchV2.RideRouteQuery.1
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
        private FromAndTo f11517a;

        /* renamed from: b  reason: collision with root package name */
        private int f11518b;

        /* renamed from: c  reason: collision with root package name */
        private int f11519c;

        public RideRouteQuery(FromAndTo fromAndTo) {
            this.f11518b = 1;
            this.f11519c = 1;
            this.f11517a = fromAndTo;
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
                FromAndTo fromAndTo = this.f11517a;
                if (fromAndTo == null) {
                    if (rideRouteQuery.f11517a != null) {
                        return false;
                    }
                } else if (!fromAndTo.equals(rideRouteQuery.f11517a)) {
                    return false;
                }
                return this.f11518b == rideRouteQuery.f11518b && this.f11519c == rideRouteQuery.f11519c;
            }
            return false;
        }

        public int getAlternativeRoute() {
            return this.f11519c;
        }

        public FromAndTo getFromAndTo() {
            return this.f11517a;
        }

        public int getShowFields() {
            return this.f11518b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f11517a;
            return (((((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.f11518b) * 31) + this.f11519c;
        }

        public void setAlternativeRoute(int i4) {
            this.f11519c = i4;
        }

        public void setShowFields(int i4) {
            this.f11518b = i4;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeParcelable(this.f11517a, i4);
            parcel.writeInt(this.f11519c);
            parcel.writeInt(this.f11518b);
        }

        /* renamed from: clone */
        public RideRouteQuery m51clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                j4.i(e4, "RouteSearchV2", "RideRouteQueryclone");
            }
            RideRouteQuery rideRouteQuery = new RideRouteQuery(this.f11517a);
            rideRouteQuery.setShowFields(this.f11518b);
            rideRouteQuery.setAlternativeRoute(this.f11519c);
            return rideRouteQuery;
        }

        public RideRouteQuery(Parcel parcel) {
            this.f11518b = 1;
            this.f11519c = 1;
            this.f11517a = (FromAndTo) parcel.readParcelable(RouteSearch.FromAndTo.class.getClassLoader());
            this.f11519c = parcel.readInt();
            this.f11518b = parcel.readInt();
        }

        public RideRouteQuery() {
            this.f11518b = 1;
            this.f11519c = 1;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class ShowFields {
        public static final int ALL = -1;
        public static final int CHARGE_STATION_INFO = 64;
        public static final int CITIES = 8;
        public static final int COST = 1;
        public static final int ELEC_COSUME_INFO = 32;
        public static final int NAVI = 4;
        public static final int POLINE = 16;
        public static final int TMCS = 2;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class SlopeCost {

        /* renamed from: a  reason: collision with root package name */
        private float f11520a;

        /* renamed from: b  reason: collision with root package name */
        private float f11521b;

        public float getDown() {
            return this.f11521b;
        }

        public float getUp() {
            return this.f11520a;
        }

        public void setDown(float f4) {
            this.f11521b = f4;
        }

        public void setUp(float f4) {
            this.f11520a = f4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class SpeedCost {

        /* renamed from: a  reason: collision with root package name */
        private int f11522a;

        /* renamed from: b  reason: collision with root package name */
        private float f11523b;

        public int getSpeed() {
            return this.f11522a;
        }

        public float getValue() {
            return this.f11523b;
        }

        public void setSpeed(int i4) {
            this.f11522a = i4;
        }

        public void setValue(float f4) {
            this.f11523b = f4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class TransCost {

        /* renamed from: a  reason: collision with root package name */
        private float f11524a;

        /* renamed from: b  reason: collision with root package name */
        private float f11525b;

        public float getAccess() {
            return this.f11524a;
        }

        public float getDecess() {
            return this.f11525b;
        }

        public void setAccess(float f4) {
            this.f11524a = f4;
        }

        public void setDecess(float f4) {
            this.f11525b = f4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<WalkRouteQuery> CREATOR = new Parcelable.Creator<WalkRouteQuery>() { // from class: com.amap.api.services.route.RouteSearchV2.WalkRouteQuery.1
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
        private FromAndTo f11526a;

        /* renamed from: b  reason: collision with root package name */
        private int f11527b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f11528c;

        /* renamed from: d  reason: collision with root package name */
        private int f11529d;

        public WalkRouteQuery(FromAndTo fromAndTo) {
            this.f11527b = 1;
            this.f11528c = false;
            this.f11529d = 1;
            this.f11526a = fromAndTo;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WalkRouteQuery walkRouteQuery = (WalkRouteQuery) obj;
            if (this.f11527b == walkRouteQuery.f11527b && this.f11528c == walkRouteQuery.f11528c && this.f11529d == walkRouteQuery.f11529d) {
                return this.f11526a.equals(walkRouteQuery.f11526a);
            }
            return false;
        }

        public int getAlternativeRoute() {
            return this.f11529d;
        }

        public FromAndTo getFromAndTo() {
            return this.f11526a;
        }

        public int getShowFields() {
            return this.f11527b;
        }

        public int hashCode() {
            return (((((this.f11526a.hashCode() * 31) + this.f11527b) * 31) + (this.f11528c ? 1 : 0)) * 31) + this.f11529d;
        }

        public boolean isIndoor() {
            return this.f11528c;
        }

        public void setAlternativeRoute(int i4) {
            this.f11529d = i4;
        }

        public void setIndoor(boolean z3) {
            this.f11528c = z3;
        }

        public void setShowFields(int i4) {
            this.f11527b = i4;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeParcelable(this.f11526a, i4);
            parcel.writeBooleanArray(new boolean[]{this.f11528c});
            parcel.writeInt(this.f11529d);
            parcel.writeInt(this.f11527b);
        }

        /* renamed from: clone */
        public WalkRouteQuery m52clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                j4.i(e4, "RouteSearchV2", "WalkRouteQueryclone");
            }
            WalkRouteQuery walkRouteQuery = new WalkRouteQuery(this.f11526a);
            walkRouteQuery.setShowFields(this.f11527b);
            walkRouteQuery.setIndoor(this.f11528c);
            walkRouteQuery.setAlternativeRoute(this.f11529d);
            return walkRouteQuery;
        }

        public WalkRouteQuery(Parcel parcel) {
            this.f11527b = 1;
            this.f11528c = false;
            this.f11529d = 1;
            this.f11526a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            boolean[] zArr = new boolean[1];
            parcel.readBooleanArray(zArr);
            this.f11528c = zArr[0];
            this.f11529d = parcel.readInt();
            this.f11527b = parcel.readInt();
        }

        public WalkRouteQuery() {
            this.f11527b = 1;
            this.f11528c = false;
            this.f11529d = 1;
        }
    }

    public RouteSearchV2(Context context) throws AMapException {
        if (this.f11459a == null) {
            try {
                this.f11459a = new u0(context);
            } catch (Exception e4) {
                e4.printStackTrace();
                if (e4 instanceof AMapException) {
                    throw ((AMapException) e4);
                }
            }
        }
    }

    public BusRouteResultV2 calculateBusRoute(BusRouteQuery busRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f11459a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateBusRoute(busRouteQuery);
        }
        return null;
    }

    public void calculateBusRouteAsyn(BusRouteQuery busRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f11459a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateBusRouteAsyn(busRouteQuery);
        }
    }

    public DriveRouteResultV2 calculateDriveRoute(DriveRouteQuery driveRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f11459a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateDriveRoute(driveRouteQuery);
        }
        return null;
    }

    public void calculateDriveRouteAsyn(DriveRouteQuery driveRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f11459a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateDriveRouteAsyn(driveRouteQuery);
        }
    }

    public RideRouteResultV2 calculateRideRoute(RideRouteQuery rideRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f11459a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateRideRoute(rideRouteQuery);
        }
        return null;
    }

    public void calculateRideRouteAsyn(RideRouteQuery rideRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f11459a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateRideRouteAsyn(rideRouteQuery);
        }
    }

    public WalkRouteResultV2 calculateWalkRoute(WalkRouteQuery walkRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f11459a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateWalkRoute(walkRouteQuery);
        }
        return null;
    }

    public void calculateWalkRouteAsyn(WalkRouteQuery walkRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f11459a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateWalkRouteAsyn(walkRouteQuery);
        }
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        IRouteSearchV2 iRouteSearchV2 = this.f11459a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.setRouteSearchListener(onRouteSearchListener);
        }
    }
}
