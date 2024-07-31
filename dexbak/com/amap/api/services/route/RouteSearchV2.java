package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p047s.C2082j4;
import com.amap.api.col.p047s.RouteSearchCoreV2;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearchV2;
import com.amap.api.services.route.RouteSearch;
import com.beizi.fusion.widget.ScrollClickView;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RouteSearchV2 {

    /* renamed from: a */
    private IRouteSearchV2 f7765a;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class AlternativeRoute {
        public static final int ALTERNATIVE_ROUTE_ONE = 1;
        public static final int ALTERNATIVE_ROUTE_THREE = 3;
        public static final int ALTERNATIVE_ROUTE_TWO = 2;

        public AlternativeRoute() {
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
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

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class BusRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<BusRouteQuery> CREATOR = new Parcelable.Creator<BusRouteQuery>() { // from class: com.amap.api.services.route.RouteSearchV2.BusRouteQuery.1
            /* renamed from: a */
            private static BusRouteQuery m51775a(Parcel parcel) {
                return new BusRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BusRouteQuery createFromParcel(Parcel parcel) {
                return m51775a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BusRouteQuery[] newArray(int i) {
                return m51776a(i);
            }

            /* renamed from: a */
            private static BusRouteQuery[] m51776a(int i) {
                return new BusRouteQuery[i];
            }
        };

        /* renamed from: a */
        private FromAndTo f7767a;

        /* renamed from: b */
        private int f7768b;

        /* renamed from: c */
        private String f7769c;

        /* renamed from: d */
        private String f7770d;

        /* renamed from: e */
        private String f7771e;

        /* renamed from: f */
        private String f7772f;

        /* renamed from: g */
        private int f7773g;

        /* renamed from: h */
        private String f7774h;

        /* renamed from: i */
        private String f7775i;

        /* renamed from: j */
        private String f7776j;

        /* renamed from: k */
        private String f7777k;

        /* renamed from: l */
        private int f7778l;

        /* renamed from: m */
        private int f7779m;

        /* renamed from: n */
        private int f7780n;

        /* renamed from: o */
        private int f7781o;

        public BusRouteQuery(FromAndTo fromAndTo, int i, String str, int i2) {
            this.f7778l = 5;
            this.f7779m = 0;
            this.f7780n = 4;
            this.f7781o = 1;
            this.f7767a = fromAndTo;
            this.f7768b = i;
            this.f7769c = str;
            this.f7773g = i2;
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
            if (this.f7768b == busRouteQuery.f7768b && this.f7773g == busRouteQuery.f7773g && this.f7774h.equals(busRouteQuery.f7774h) && this.f7775i.equals(busRouteQuery.f7775i) && this.f7778l == busRouteQuery.f7778l && this.f7779m == busRouteQuery.f7779m && this.f7780n == busRouteQuery.f7780n && this.f7781o == busRouteQuery.f7781o && this.f7767a.equals(busRouteQuery.f7767a) && this.f7769c.equals(busRouteQuery.f7769c) && this.f7770d.equals(busRouteQuery.f7770d) && this.f7771e.equals(busRouteQuery.f7771e) && this.f7772f.equals(busRouteQuery.f7772f) && this.f7776j.equals(busRouteQuery.f7776j)) {
                return this.f7777k.equals(busRouteQuery.f7777k);
            }
            return false;
        }

        public String getAd1() {
            return this.f7776j;
        }

        public String getAd2() {
            return this.f7777k;
        }

        public int getAlternativeRoute() {
            return this.f7778l;
        }

        public String getCity() {
            return this.f7769c;
        }

        public String getCityd() {
            return this.f7770d;
        }

        public String getDate() {
            return this.f7771e;
        }

        public String getDestinationPoiId() {
            return this.f7775i;
        }

        public FromAndTo getFromAndTo() {
            return this.f7767a;
        }

        public int getMaxTrans() {
            return this.f7780n;
        }

        public int getMode() {
            return this.f7768b;
        }

        public int getMultiExport() {
            return this.f7779m;
        }

        public int getNightFlag() {
            return this.f7773g;
        }

        public String getOriginPoiId() {
            return this.f7774h;
        }

        public int getShowFields() {
            return this.f7781o;
        }

        public String getTime() {
            return this.f7772f;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((this.f7767a.hashCode() * 31) + this.f7768b) * 31) + this.f7769c.hashCode()) * 31) + this.f7770d.hashCode()) * 31) + this.f7771e.hashCode()) * 31) + this.f7772f.hashCode()) * 31) + this.f7773g) * 31) + this.f7774h.hashCode()) * 31) + this.f7775i.hashCode()) * 31) + this.f7776j.hashCode()) * 31) + this.f7777k.hashCode()) * 31) + this.f7778l) * 31) + this.f7779m) * 31) + this.f7780n) * 31) + this.f7781o;
        }

        public void setAd1(String str) {
            this.f7776j = str;
        }

        public void setAd2(String str) {
            this.f7777k = str;
        }

        public void setAlternativeRoute(int i) {
            this.f7778l = i;
        }

        public void setCityd(String str) {
            this.f7770d = str;
        }

        public void setDate(String str) {
            this.f7771e = str;
        }

        public void setDestinationPoiId(String str) {
            this.f7775i = str;
        }

        public void setMaxTrans(int i) {
            this.f7780n = i;
        }

        public void setMultiExport(int i) {
            this.f7779m = i;
        }

        public void setOriginPoiId(String str) {
            this.f7774h = str;
        }

        public void setShowFields(int i) {
            this.f7781o = i;
        }

        public void setTime(String str) {
            this.f7772f = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f7767a, i);
            parcel.writeInt(this.f7768b);
            parcel.writeString(this.f7769c);
            parcel.writeInt(this.f7773g);
            parcel.writeString(this.f7770d);
            parcel.writeInt(this.f7781o);
            parcel.writeString(this.f7774h);
            parcel.writeString(this.f7775i);
            parcel.writeString(this.f7776j);
            parcel.writeString(this.f7777k);
            parcel.writeInt(this.f7778l);
            parcel.writeInt(this.f7780n);
            parcel.writeInt(this.f7779m);
            parcel.writeString(this.f7771e);
            parcel.writeString(this.f7772f);
        }

        /* renamed from: clone */
        public BusRouteQuery m60127clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C2082j4.m52825i(e, "RouteSearchV2", "BusRouteQueryclone");
            }
            BusRouteQuery busRouteQuery = new BusRouteQuery(this.f7767a, this.f7768b, this.f7769c, this.f7773g);
            busRouteQuery.setCityd(this.f7770d);
            busRouteQuery.setShowFields(this.f7781o);
            busRouteQuery.setDate(this.f7771e);
            busRouteQuery.setTime(this.f7772f);
            busRouteQuery.setAd1(this.f7776j);
            busRouteQuery.setAd2(this.f7777k);
            busRouteQuery.setOriginPoiId(this.f7774h);
            busRouteQuery.setDestinationPoiId(this.f7775i);
            busRouteQuery.setMaxTrans(this.f7780n);
            busRouteQuery.setMultiExport(this.f7779m);
            busRouteQuery.setAlternativeRoute(this.f7778l);
            return busRouteQuery;
        }

        public BusRouteQuery(Parcel parcel) {
            this.f7768b = 0;
            this.f7773g = 0;
            this.f7778l = 5;
            this.f7779m = 0;
            this.f7780n = 4;
            this.f7781o = 1;
            this.f7767a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f7768b = parcel.readInt();
            this.f7769c = parcel.readString();
            this.f7773g = parcel.readInt();
            this.f7770d = parcel.readString();
            this.f7781o = parcel.readInt();
            this.f7774h = parcel.readString();
            this.f7775i = parcel.readString();
            this.f7771e = parcel.readString();
            this.f7772f = parcel.readString();
            this.f7780n = parcel.readInt();
            this.f7779m = parcel.readInt();
            this.f7778l = parcel.readInt();
            this.f7776j = parcel.readString();
            this.f7777k = parcel.readString();
        }

        public BusRouteQuery() {
            this.f7768b = 0;
            this.f7773g = 0;
            this.f7778l = 5;
            this.f7779m = 0;
            this.f7780n = 4;
            this.f7781o = 1;
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class CurveCost {

        /* renamed from: a */
        private float f7782a;

        /* renamed from: b */
        private float f7783b;

        public float getAccess() {
            return this.f7782a;
        }

        public float getValue() {
            return this.f7783b;
        }

        public void setAccess(float f) {
            this.f7782a = f;
        }

        public void setValue(float f) {
            this.f7783b = f;
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class CustomCostMode {

        /* renamed from: a */
        private List<SpeedCost> f7784a;

        /* renamed from: b */
        private CurveCost f7785b;

        /* renamed from: c */
        private SlopeCost f7786c;

        /* renamed from: d */
        private float f7787d;

        /* renamed from: e */
        private TransCost f7788e;

        /* renamed from: f */
        private float f7789f;

        /* renamed from: g */
        private PowerTrainLoss f7790g;

        public float getAuxCost() {
            return this.f7787d;
        }

        public CurveCost getCurveCost() {
            return this.f7785b;
        }

        public float getFerryCost() {
            return this.f7789f;
        }

        public PowerTrainLoss getPowerTrainLosses() {
            return this.f7790g;
        }

        public SlopeCost getSlopeCost() {
            return this.f7786c;
        }

        public List<SpeedCost> getSpeedCosts() {
            return this.f7784a;
        }

        public TransCost getTransCost() {
            return this.f7788e;
        }

        public void setAuxCost(float f) {
            this.f7787d = f;
        }

        public void setCurveCost(CurveCost curveCost) {
            this.f7785b = curveCost;
        }

        public void setFerryCost(float f) {
            this.f7789f = f;
        }

        public void setPowerTrainLosses(PowerTrainLoss powerTrainLoss) {
            this.f7790g = powerTrainLoss;
        }

        public void setSlopeCost(SlopeCost slopeCost) {
            this.f7786c = slopeCost;
        }

        public void setSpeedCosts(List<SpeedCost> list) {
            this.f7784a = list;
        }

        public void setTransCost(TransCost transCost) {
            this.f7788e = transCost;
        }

        public String toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                List<SpeedCost> list = this.f7784a;
                if (list != null) {
                    for (SpeedCost speedCost : list) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("speed", speedCost.getSpeed());
                        jSONObject2.put(DomainCampaignEx.LOOPBACK_VALUE, speedCost.getValue());
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("speed_cost", jSONArray);
                }
                if (this.f7785b != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(UMCommonContent.f37760Q, this.f7785b.getAccess());
                    jSONObject3.put(DomainCampaignEx.LOOPBACK_VALUE, this.f7785b.getValue());
                    jSONObject.put("curve_cost", jSONObject3);
                }
                if (this.f7786c != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("up", this.f7786c.getUp());
                    jSONObject4.put(ScrollClickView.DIR_DOWN, this.f7786c.getDown());
                    jSONObject.put("slope_cost", jSONObject4);
                }
                jSONObject.put("aux_cost", this.f7787d);
                if (this.f7788e != null) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put(UMCommonContent.f37760Q, this.f7788e.getAccess());
                    jSONObject5.put("decess", this.f7788e.getDecess());
                    jSONObject.put("trans_cost", jSONObject5);
                }
                jSONObject.put("ferry_cost", this.f7789f);
                if (this.f7790g != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("powerdemand", this.f7790g.getPowerDemand());
                    jSONObject6.put(DomainCampaignEx.LOOPBACK_VALUE, this.f7790g.getPowerDemandValue());
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("speed", this.f7790g.getSpeed());
                    jSONObject7.put(DomainCampaignEx.LOOPBACK_VALUE, this.f7790g.getSpeedValue());
                    jSONArray2.put(jSONObject6);
                    jSONArray2.put(jSONObject7);
                    jSONObject.put("powertrain_loss", jSONArray2);
                }
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DriveRouteQuery> CREATOR = new Parcelable.Creator<DriveRouteQuery>() { // from class: com.amap.api.services.route.RouteSearchV2.DriveRouteQuery.1
            /* renamed from: a */
            private static DriveRouteQuery m51773a(Parcel parcel) {
                return new DriveRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DriveRouteQuery createFromParcel(Parcel parcel) {
                return m51773a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DriveRouteQuery[] newArray(int i) {
                return m51774a(i);
            }

            /* renamed from: a */
            private static DriveRouteQuery[] m51774a(int i) {
                return new DriveRouteQuery[i];
            }
        };

        /* renamed from: a */
        private FromAndTo f7791a;

        /* renamed from: b */
        private NewEnergy f7792b;

        /* renamed from: c */
        private int f7793c;

        /* renamed from: d */
        private List<LatLonPoint> f7794d;

        /* renamed from: e */
        private List<List<LatLonPoint>> f7795e;

        /* renamed from: f */
        private String f7796f;

        /* renamed from: g */
        private boolean f7797g;

        /* renamed from: h */
        private int f7798h;

        /* renamed from: i */
        private String f7799i;

        /* renamed from: j */
        private int f7800j;

        public DriveRouteQuery(FromAndTo fromAndTo, DrivingStrategy drivingStrategy, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.f7793c = DrivingStrategy.DEFAULT.getValue();
            this.f7797g = true;
            this.f7798h = 0;
            this.f7799i = null;
            this.f7800j = 1;
            this.f7791a = fromAndTo;
            this.f7793c = drivingStrategy.getValue();
            this.f7794d = list;
            this.f7795e = list2;
            this.f7796f = str;
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
                String str = this.f7796f;
                if (str == null) {
                    if (driveRouteQuery.f7796f != null) {
                        return false;
                    }
                } else if (!str.equals(driveRouteQuery.f7796f)) {
                    return false;
                }
                List<List<LatLonPoint>> list = this.f7795e;
                if (list == null) {
                    if (driveRouteQuery.f7795e != null) {
                        return false;
                    }
                } else if (!list.equals(driveRouteQuery.f7795e)) {
                    return false;
                }
                FromAndTo fromAndTo = this.f7791a;
                if (fromAndTo == null) {
                    if (driveRouteQuery.f7791a != null) {
                        return false;
                    }
                } else if (!fromAndTo.equals(driveRouteQuery.f7791a)) {
                    return false;
                }
                if (this.f7793c != driveRouteQuery.f7793c) {
                    return false;
                }
                List<LatLonPoint> list2 = this.f7794d;
                if (list2 == null) {
                    if (driveRouteQuery.f7794d != null) {
                        return false;
                    }
                } else if (!list2.equals(driveRouteQuery.f7794d) || this.f7797g != driveRouteQuery.isUseFerry() || this.f7798h != driveRouteQuery.f7798h || this.f7800j != driveRouteQuery.f7800j) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public String getAvoidRoad() {
            return this.f7796f;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.f7795e;
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<List<LatLonPoint>> list = this.f7795e;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i = 0; i < this.f7795e.size(); i++) {
                List<LatLonPoint> list2 = this.f7795e.get(i);
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    LatLonPoint latLonPoint = list2.get(i2);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(",");
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i2 < list2.size() - 1) {
                        stringBuffer.append(";");
                    }
                }
                if (i < this.f7795e.size() - 1) {
                    stringBuffer.append("|");
                }
            }
            return stringBuffer.toString();
        }

        public int getCarType() {
            return this.f7798h;
        }

        public String getExclude() {
            return this.f7799i;
        }

        public FromAndTo getFromAndTo() {
            return this.f7791a;
        }

        public DrivingStrategy getMode() {
            return DrivingStrategy.fromValue(this.f7793c);
        }

        public NewEnergy getNewEnergy() {
            return this.f7792b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f7794d;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.f7794d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i = 0; i < this.f7794d.size(); i++) {
                LatLonPoint latLonPoint = this.f7794d.get(i);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i < this.f7794d.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public int getShowFields() {
            return this.f7800j;
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
            String str = this.f7796f;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            List<List<LatLonPoint>> list = this.f7795e;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            FromAndTo fromAndTo = this.f7791a;
            int hashCode3 = (((hashCode2 + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.f7793c) * 31;
            List<LatLonPoint> list2 = this.f7794d;
            return ((hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.f7798h;
        }

        public boolean isUseFerry() {
            return this.f7797g;
        }

        public void setCarType(int i) {
            this.f7798h = i;
        }

        public void setExclude(String str) {
            this.f7799i = str;
        }

        public void setNewEnergy(NewEnergy newEnergy) {
            this.f7792b = newEnergy;
        }

        public void setShowFields(int i) {
            this.f7800j = i;
        }

        public void setUseFerry(boolean z) {
            this.f7797g = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f7791a, i);
            parcel.writeInt(this.f7793c);
            parcel.writeTypedList(this.f7794d);
            List<List<LatLonPoint>> list = this.f7795e;
            if (list == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(list.size());
                for (List<LatLonPoint> list2 : this.f7795e) {
                    parcel.writeTypedList(list2);
                }
            }
            parcel.writeString(this.f7796f);
            parcel.writeInt(this.f7797g ? 1 : 0);
            parcel.writeInt(this.f7798h);
            parcel.writeString(this.f7799i);
            parcel.writeInt(this.f7800j);
        }

        /* renamed from: clone */
        public DriveRouteQuery m60128clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C2082j4.m52825i(e, "RouteSearchV2", "DriveRouteQueryclone");
            }
            DriveRouteQuery driveRouteQuery = new DriveRouteQuery(this.f7791a, DrivingStrategy.fromValue(this.f7793c), this.f7794d, this.f7795e, this.f7796f);
            driveRouteQuery.setUseFerry(this.f7797g);
            driveRouteQuery.setCarType(this.f7798h);
            driveRouteQuery.setExclude(this.f7799i);
            driveRouteQuery.setShowFields(this.f7800j);
            driveRouteQuery.setNewEnergy(this.f7792b);
            return driveRouteQuery;
        }

        public DriveRouteQuery(Parcel parcel) {
            this.f7793c = DrivingStrategy.DEFAULT.getValue();
            this.f7797g = true;
            this.f7798h = 0;
            this.f7799i = null;
            this.f7800j = 1;
            this.f7791a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f7793c = parcel.readInt();
            this.f7794d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.f7795e = null;
            } else {
                this.f7795e = new ArrayList();
            }
            for (int i = 0; i < readInt; i++) {
                this.f7795e.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.f7796f = parcel.readString();
            this.f7797g = parcel.readInt() == 1;
            this.f7798h = parcel.readInt();
            this.f7799i = parcel.readString();
            this.f7800j = parcel.readInt();
        }

        public DriveRouteQuery() {
            this.f7793c = DrivingStrategy.DEFAULT.getValue();
            this.f7797g = true;
            this.f7798h = 0;
            this.f7799i = null;
            this.f7800j = 1;
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
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
        

        /* renamed from: a */
        int f7802a;

        DrivingStrategy(int i) {
            this.f7802a = i;
        }

        public static DrivingStrategy fromValue(int i) {
            return values()[i - 32];
        }

        public final int getValue() {
            return this.f7802a;
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class FromAndTo implements Parcelable, Cloneable {
        public static final Parcelable.Creator<FromAndTo> CREATOR = new Parcelable.Creator<FromAndTo>() { // from class: com.amap.api.services.route.RouteSearchV2.FromAndTo.1
            /* renamed from: a */
            private static FromAndTo m51771a(Parcel parcel) {
                return new FromAndTo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FromAndTo createFromParcel(Parcel parcel) {
                return m51771a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FromAndTo[] newArray(int i) {
                return m51772a(i);
            }

            /* renamed from: a */
            private static FromAndTo[] m51772a(int i) {
                return new FromAndTo[i];
            }
        };

        /* renamed from: a */
        private LatLonPoint f7803a;

        /* renamed from: b */
        private LatLonPoint f7804b;

        /* renamed from: c */
        private String f7805c;

        /* renamed from: d */
        private String f7806d;

        /* renamed from: e */
        private String f7807e;

        /* renamed from: f */
        private String f7808f;

        /* renamed from: g */
        private String f7809g;

        public FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f7803a = latLonPoint;
            this.f7804b = latLonPoint2;
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
                String str = this.f7806d;
                if (str == null) {
                    if (fromAndTo.f7806d != null) {
                        return false;
                    }
                } else if (!str.equals(fromAndTo.f7806d)) {
                    return false;
                }
                LatLonPoint latLonPoint = this.f7803a;
                if (latLonPoint == null) {
                    if (fromAndTo.f7803a != null) {
                        return false;
                    }
                } else if (!latLonPoint.equals(fromAndTo.f7803a)) {
                    return false;
                }
                String str2 = this.f7805c;
                if (str2 == null) {
                    if (fromAndTo.f7805c != null) {
                        return false;
                    }
                } else if (!str2.equals(fromAndTo.f7805c)) {
                    return false;
                }
                LatLonPoint latLonPoint2 = this.f7804b;
                if (latLonPoint2 == null) {
                    if (fromAndTo.f7804b != null) {
                        return false;
                    }
                } else if (!latLonPoint2.equals(fromAndTo.f7804b)) {
                    return false;
                }
                String str3 = this.f7807e;
                if (str3 == null) {
                    if (fromAndTo.f7807e != null) {
                        return false;
                    }
                } else if (!str3.equals(fromAndTo.f7807e)) {
                    return false;
                }
                String str4 = this.f7808f;
                if (str4 == null) {
                    if (fromAndTo.f7808f != null) {
                        return false;
                    }
                } else if (!str4.equals(fromAndTo.f7808f)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public String getDestinationPoiID() {
            return this.f7806d;
        }

        public String getDestinationType() {
            return this.f7808f;
        }

        public LatLonPoint getFrom() {
            return this.f7803a;
        }

        public String getOriginType() {
            return this.f7807e;
        }

        public String getPlateNumber() {
            return this.f7809g;
        }

        public String getStartPoiID() {
            return this.f7805c;
        }

        public LatLonPoint getTo() {
            return this.f7804b;
        }

        public int hashCode() {
            String str = this.f7806d;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint = this.f7803a;
            int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
            String str2 = this.f7805c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            LatLonPoint latLonPoint2 = this.f7804b;
            int hashCode4 = (hashCode3 + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            String str3 = this.f7807e;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f7808f;
            return hashCode5 + (str4 != null ? str4.hashCode() : 0);
        }

        public void setDestinationPoiID(String str) {
            this.f7806d = str;
        }

        public void setDestinationType(String str) {
            this.f7808f = str;
        }

        public void setOriginType(String str) {
            this.f7807e = str;
        }

        public void setPlateNumber(String str) {
            this.f7809g = str;
        }

        public void setStartPoiID(String str) {
            this.f7805c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f7803a, i);
            parcel.writeParcelable(this.f7804b, i);
            parcel.writeString(this.f7805c);
            parcel.writeString(this.f7806d);
            parcel.writeString(this.f7807e);
            parcel.writeString(this.f7808f);
        }

        /* renamed from: clone */
        public FromAndTo m60129clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C2082j4.m52825i(e, "RouteSearchV2", "FromAndToclone");
            }
            FromAndTo fromAndTo = new FromAndTo(this.f7803a, this.f7804b);
            fromAndTo.setStartPoiID(this.f7805c);
            fromAndTo.setDestinationPoiID(this.f7806d);
            fromAndTo.setOriginType(this.f7807e);
            fromAndTo.setDestinationType(this.f7808f);
            return fromAndTo;
        }

        public FromAndTo(Parcel parcel) {
            this.f7803a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f7804b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f7805c = parcel.readString();
            this.f7806d = parcel.readString();
            this.f7807e = parcel.readString();
            this.f7808f = parcel.readString();
        }

        public FromAndTo() {
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class NewEnergy {

        /* renamed from: a */
        private String f7810a;

        /* renamed from: b */
        private CustomCostMode f7811b;

        /* renamed from: h */
        private String f7817h;

        /* renamed from: c */
        private float f7812c = -1.0f;

        /* renamed from: d */
        private float f7813d = -1.0f;

        /* renamed from: e */
        private float f7814e = 1.5f;

        /* renamed from: f */
        private float f7815f = 100.0f;

        /* renamed from: g */
        private float f7816g = 0.0f;

        /* renamed from: i */
        private int f7818i = 0;

        public String buildParam() {
            StringBuilder sb = new StringBuilder();
            if (this.f7810a != null) {
                sb.append("&key=");
                sb.append(this.f7810a);
            }
            if (this.f7811b != null) {
                sb.append("&custom_cost_mode=");
                sb.append(this.f7811b.toJson());
            }
            if (this.f7812c > 0.0f) {
                sb.append("&max_vehicle_charge=");
                sb.append(this.f7812c);
            }
            if (this.f7813d > 0.0f) {
                sb.append("&vehicle_charge=");
                sb.append(this.f7813d);
            }
            sb.append("&load=");
            sb.append(this.f7814e);
            sb.append("&leaving_percent=");
            sb.append(this.f7815f);
            sb.append("&arriving_percent=");
            sb.append(this.f7816g);
            if (this.f7817h != null) {
                sb.append("&custom_charging_arguments=");
                sb.append(this.f7817h);
            }
            if (this.f7818i > 0) {
                sb.append("&waypoints_arriving_percent=");
                sb.append(this.f7818i);
            }
            return sb.toString();
        }

        public float getArrivingPercent() {
            return this.f7816g;
        }

        public String getCustomChargingArguments() {
            return this.f7817h;
        }

        public CustomCostMode getCustomCostMode() {
            return this.f7811b;
        }

        public String getKey() {
            return this.f7810a;
        }

        public float getLeavingPercent() {
            return this.f7815f;
        }

        public float getLoad() {
            return this.f7814e;
        }

        public float getMaxVehicleCharge() {
            return this.f7812c;
        }

        public float getVehicleCharge() {
            return this.f7813d;
        }

        public int getWaypointsArrivingPercent() {
            return this.f7818i;
        }

        public void setArrivingPercent(float f) {
            this.f7816g = f;
        }

        public void setCustomChargingArguments(String str) {
            this.f7817h = str;
        }

        public void setCustomCostMode(CustomCostMode customCostMode) {
            this.f7811b = customCostMode;
        }

        public void setKey(String str) {
            this.f7810a = str;
        }

        public void setLeavingPercent(float f) {
            this.f7815f = f;
        }

        public void setLoad(float f) {
            this.f7814e = f;
        }

        public void setMaxVehicleCharge(float f) {
            this.f7812c = f;
        }

        public void setVehicleCharge(float f) {
            this.f7813d = f;
        }

        public void setWaypointsArrivingPercent(int i) {
            this.f7818i = i;
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnRoutePlanSearchListener {
        void onDriveRoutePlanSearched(DriveRoutePlanResult driveRoutePlanResult, int i);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnRouteSearchListener {
        void onBusRouteSearched(BusRouteResultV2 busRouteResultV2, int i);

        void onDriveRouteSearched(DriveRouteResultV2 driveRouteResultV2, int i);

        void onRideRouteSearched(RideRouteResultV2 rideRouteResultV2, int i);

        void onWalkRouteSearched(WalkRouteResultV2 walkRouteResultV2, int i);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnTruckRouteSearchListener {
        void onTruckRouteSearched(TruckRouteRestult truckRouteRestult, int i);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class PowerTrainLoss {

        /* renamed from: a */
        private int f7819a;

        /* renamed from: b */
        private float f7820b;

        /* renamed from: c */
        private int f7821c;

        /* renamed from: d */
        private int f7822d;

        public int getPowerDemand() {
            return this.f7819a;
        }

        public float getPowerDemandValue() {
            return this.f7820b;
        }

        public int getSpeed() {
            return this.f7821c;
        }

        public int getSpeedValue() {
            return this.f7822d;
        }

        public void setPowerDemand(int i) {
            this.f7819a = i;
        }

        public void setPowerDemandValue(float f) {
            this.f7820b = f;
        }

        public void setSpeed(int i) {
            this.f7821c = i;
        }

        public void setSpeedValue(int i) {
            this.f7822d = i;
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class RideRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<RideRouteQuery> CREATOR = new Parcelable.Creator<RideRouteQuery>() { // from class: com.amap.api.services.route.RouteSearchV2.RideRouteQuery.1
            /* renamed from: a */
            private static RideRouteQuery m51769a(Parcel parcel) {
                return new RideRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RideRouteQuery createFromParcel(Parcel parcel) {
                return m51769a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RideRouteQuery[] newArray(int i) {
                return m51770a(i);
            }

            /* renamed from: a */
            private static RideRouteQuery[] m51770a(int i) {
                return new RideRouteQuery[i];
            }
        };

        /* renamed from: a */
        private FromAndTo f7823a;

        /* renamed from: b */
        private int f7824b;

        /* renamed from: c */
        private int f7825c;

        public RideRouteQuery(FromAndTo fromAndTo) {
            this.f7824b = 1;
            this.f7825c = 1;
            this.f7823a = fromAndTo;
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
                FromAndTo fromAndTo = this.f7823a;
                if (fromAndTo == null) {
                    if (rideRouteQuery.f7823a != null) {
                        return false;
                    }
                } else if (!fromAndTo.equals(rideRouteQuery.f7823a)) {
                    return false;
                }
                return this.f7824b == rideRouteQuery.f7824b && this.f7825c == rideRouteQuery.f7825c;
            }
            return false;
        }

        public int getAlternativeRoute() {
            return this.f7825c;
        }

        public FromAndTo getFromAndTo() {
            return this.f7823a;
        }

        public int getShowFields() {
            return this.f7824b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f7823a;
            return (((((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.f7824b) * 31) + this.f7825c;
        }

        public void setAlternativeRoute(int i) {
            this.f7825c = i;
        }

        public void setShowFields(int i) {
            this.f7824b = i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f7823a, i);
            parcel.writeInt(this.f7825c);
            parcel.writeInt(this.f7824b);
        }

        /* renamed from: clone */
        public RideRouteQuery m60130clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C2082j4.m52825i(e, "RouteSearchV2", "RideRouteQueryclone");
            }
            RideRouteQuery rideRouteQuery = new RideRouteQuery(this.f7823a);
            rideRouteQuery.setShowFields(this.f7824b);
            rideRouteQuery.setAlternativeRoute(this.f7825c);
            return rideRouteQuery;
        }

        public RideRouteQuery(Parcel parcel) {
            this.f7824b = 1;
            this.f7825c = 1;
            this.f7823a = (FromAndTo) parcel.readParcelable(RouteSearch.FromAndTo.class.getClassLoader());
            this.f7825c = parcel.readInt();
            this.f7824b = parcel.readInt();
        }

        public RideRouteQuery() {
            this.f7824b = 1;
            this.f7825c = 1;
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
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

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class SlopeCost {

        /* renamed from: a */
        private float f7826a;

        /* renamed from: b */
        private float f7827b;

        public float getDown() {
            return this.f7827b;
        }

        public float getUp() {
            return this.f7826a;
        }

        public void setDown(float f) {
            this.f7827b = f;
        }

        public void setUp(float f) {
            this.f7826a = f;
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class SpeedCost {

        /* renamed from: a */
        private int f7828a;

        /* renamed from: b */
        private float f7829b;

        public int getSpeed() {
            return this.f7828a;
        }

        public float getValue() {
            return this.f7829b;
        }

        public void setSpeed(int i) {
            this.f7828a = i;
        }

        public void setValue(float f) {
            this.f7829b = f;
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class TransCost {

        /* renamed from: a */
        private float f7830a;

        /* renamed from: b */
        private float f7831b;

        public float getAccess() {
            return this.f7830a;
        }

        public float getDecess() {
            return this.f7831b;
        }

        public void setAccess(float f) {
            this.f7830a = f;
        }

        public void setDecess(float f) {
            this.f7831b = f;
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<WalkRouteQuery> CREATOR = new Parcelable.Creator<WalkRouteQuery>() { // from class: com.amap.api.services.route.RouteSearchV2.WalkRouteQuery.1
            /* renamed from: a */
            private static WalkRouteQuery m51767a(Parcel parcel) {
                return new WalkRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WalkRouteQuery createFromParcel(Parcel parcel) {
                return m51767a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WalkRouteQuery[] newArray(int i) {
                return m51768a(i);
            }

            /* renamed from: a */
            private static WalkRouteQuery[] m51768a(int i) {
                return new WalkRouteQuery[i];
            }
        };

        /* renamed from: a */
        private FromAndTo f7832a;

        /* renamed from: b */
        private int f7833b;

        /* renamed from: c */
        private boolean f7834c;

        /* renamed from: d */
        private int f7835d;

        public WalkRouteQuery(FromAndTo fromAndTo) {
            this.f7833b = 1;
            this.f7834c = false;
            this.f7835d = 1;
            this.f7832a = fromAndTo;
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
            if (this.f7833b == walkRouteQuery.f7833b && this.f7834c == walkRouteQuery.f7834c && this.f7835d == walkRouteQuery.f7835d) {
                return this.f7832a.equals(walkRouteQuery.f7832a);
            }
            return false;
        }

        public int getAlternativeRoute() {
            return this.f7835d;
        }

        public FromAndTo getFromAndTo() {
            return this.f7832a;
        }

        public int getShowFields() {
            return this.f7833b;
        }

        public int hashCode() {
            return (((((this.f7832a.hashCode() * 31) + this.f7833b) * 31) + (this.f7834c ? 1 : 0)) * 31) + this.f7835d;
        }

        public boolean isIndoor() {
            return this.f7834c;
        }

        public void setAlternativeRoute(int i) {
            this.f7835d = i;
        }

        public void setIndoor(boolean z) {
            this.f7834c = z;
        }

        public void setShowFields(int i) {
            this.f7833b = i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f7832a, i);
            parcel.writeBooleanArray(new boolean[]{this.f7834c});
            parcel.writeInt(this.f7835d);
            parcel.writeInt(this.f7833b);
        }

        /* renamed from: clone */
        public WalkRouteQuery m60131clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C2082j4.m52825i(e, "RouteSearchV2", "WalkRouteQueryclone");
            }
            WalkRouteQuery walkRouteQuery = new WalkRouteQuery(this.f7832a);
            walkRouteQuery.setShowFields(this.f7833b);
            walkRouteQuery.setIndoor(this.f7834c);
            walkRouteQuery.setAlternativeRoute(this.f7835d);
            return walkRouteQuery;
        }

        public WalkRouteQuery(Parcel parcel) {
            this.f7833b = 1;
            this.f7834c = false;
            this.f7835d = 1;
            this.f7832a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            boolean[] zArr = new boolean[1];
            parcel.readBooleanArray(zArr);
            this.f7834c = zArr[0];
            this.f7835d = parcel.readInt();
            this.f7833b = parcel.readInt();
        }

        public WalkRouteQuery() {
            this.f7833b = 1;
            this.f7834c = false;
            this.f7835d = 1;
        }
    }

    public RouteSearchV2(Context context) throws AMapException {
        if (this.f7765a == null) {
            try {
                this.f7765a = new RouteSearchCoreV2(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    public BusRouteResultV2 calculateBusRoute(BusRouteQuery busRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f7765a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateBusRoute(busRouteQuery);
        }
        return null;
    }

    public void calculateBusRouteAsyn(BusRouteQuery busRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f7765a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateBusRouteAsyn(busRouteQuery);
        }
    }

    public DriveRouteResultV2 calculateDriveRoute(DriveRouteQuery driveRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f7765a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateDriveRoute(driveRouteQuery);
        }
        return null;
    }

    public void calculateDriveRouteAsyn(DriveRouteQuery driveRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f7765a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateDriveRouteAsyn(driveRouteQuery);
        }
    }

    public RideRouteResultV2 calculateRideRoute(RideRouteQuery rideRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f7765a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateRideRoute(rideRouteQuery);
        }
        return null;
    }

    public void calculateRideRouteAsyn(RideRouteQuery rideRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f7765a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateRideRouteAsyn(rideRouteQuery);
        }
    }

    public WalkRouteResultV2 calculateWalkRoute(WalkRouteQuery walkRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f7765a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateWalkRoute(walkRouteQuery);
        }
        return null;
    }

    public void calculateWalkRouteAsyn(WalkRouteQuery walkRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f7765a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateWalkRouteAsyn(walkRouteQuery);
        }
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        IRouteSearchV2 iRouteSearchV2 = this.f7765a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.setRouteSearchListener(onRouteSearchListener);
        }
    }
}
