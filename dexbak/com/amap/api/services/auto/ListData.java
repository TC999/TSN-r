package com.amap.api.services.auto;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ListData implements Parcelable {
    public static final Parcelable.Creator<ListData> CREATOR = new Parcelable.Creator<ListData>() { // from class: com.amap.api.services.auto.ListData.1
        /* renamed from: a */
        private static ListData m51938a(Parcel parcel) {
            return new ListData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ListData createFromParcel(Parcel parcel) {
            return m51938a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ListData[] newArray(int i) {
            return m51939a(i);
        }

        /* renamed from: a */
        private static ListData[] m51939a(int i) {
            return new ListData[i];
        }
    };
    public List<Content> content;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class BasicInfo implements Parcelable {
        public static final Parcelable.Creator<BasicInfo> CREATOR = new Parcelable.Creator<BasicInfo>() { // from class: com.amap.api.services.auto.ListData.BasicInfo.1
            /* renamed from: a */
            private static BasicInfo m51936a(Parcel parcel) {
                return new BasicInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BasicInfo createFromParcel(Parcel parcel) {
                return m51936a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BasicInfo[] newArray(int i) {
                return m51937a(i);
            }

            /* renamed from: a */
            private static BasicInfo[] m51937a(int i) {
                return new BasicInfo[i];
            }
        };
        public String adcode;
        public String address;
        public String averagecost;
        public String buildingStatus;
        public String businessArea;
        public String category;
        public String childShortname;
        public String childShortnameEn;
        public String childtype;
        public String citycode;
        public String cname;
        public String dispName;
        public String distance;
        public String dname;
        public String eaddress;
        public String endPoiExtension;
        public String fNona;
        public String hisMark;
        public String hotText;

        /* renamed from: id */
        public String f7184id;
        public String industry;
        public String latitude;
        public String longitude;
        public String name;
        public NaviVisited naviVisited;
        public String numSpaceW;
        public String numSpaceWF;
        public String opentime2;
        public String opentimeText;
        public String parent;
        public String parentName;
        public String picInfo;
        public String rating;
        public String recommendFlag;
        public String reviewTotal;
        public String sell;
        public ShortReview shortReview;
        public String tel;
        public String towardsAngle;
        public String typeCode;
        public String updateFlag;
        public String xEntr;
        public String yEntr;

        public BasicInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.adcode);
            parcel.writeString(this.address);
            parcel.writeString(this.averagecost);
            parcel.writeString(this.buildingStatus);
            parcel.writeString(this.businessArea);
            parcel.writeString(this.childShortname);
            parcel.writeString(this.childShortnameEn);
            parcel.writeString(this.childtype);
            parcel.writeString(this.citycode);
            parcel.writeString(this.cname);
            parcel.writeString(this.dispName);
            parcel.writeString(this.distance);
            parcel.writeString(this.dname);
            parcel.writeString(this.eaddress);
            parcel.writeString(this.endPoiExtension);
            parcel.writeString(this.fNona);
            parcel.writeString(this.hisMark);
            parcel.writeString(this.hotText);
            parcel.writeString(this.f7184id);
            parcel.writeString(this.industry);
            parcel.writeString(this.latitude);
            parcel.writeString(this.longitude);
            parcel.writeString(this.name);
            parcel.writeParcelable(this.naviVisited, i);
            parcel.writeString(this.numSpaceW);
            parcel.writeString(this.numSpaceWF);
            parcel.writeString(this.opentime2);
            parcel.writeString(this.opentimeText);
            parcel.writeString(this.parent);
            parcel.writeString(this.parentName);
            parcel.writeString(this.picInfo);
            parcel.writeString(this.rating);
            parcel.writeString(this.recommendFlag);
            parcel.writeString(this.reviewTotal);
            parcel.writeString(this.sell);
            parcel.writeString(this.tel);
            parcel.writeString(this.towardsAngle);
            parcel.writeString(this.typeCode);
            parcel.writeString(this.updateFlag);
            parcel.writeString(this.xEntr);
            parcel.writeString(this.yEntr);
            parcel.writeString(this.category);
        }

        protected BasicInfo(Parcel parcel) {
            this.adcode = parcel.readString();
            this.address = parcel.readString();
            this.averagecost = parcel.readString();
            this.buildingStatus = parcel.readString();
            this.businessArea = parcel.readString();
            this.childShortname = parcel.readString();
            this.childShortnameEn = parcel.readString();
            this.childtype = parcel.readString();
            this.citycode = parcel.readString();
            this.cname = parcel.readString();
            this.dispName = parcel.readString();
            this.distance = parcel.readString();
            this.dname = parcel.readString();
            this.eaddress = parcel.readString();
            this.endPoiExtension = parcel.readString();
            this.fNona = parcel.readString();
            this.hisMark = parcel.readString();
            this.hotText = parcel.readString();
            this.f7184id = parcel.readString();
            this.industry = parcel.readString();
            this.latitude = parcel.readString();
            this.longitude = parcel.readString();
            this.name = parcel.readString();
            this.naviVisited = (NaviVisited) parcel.readParcelable(NaviVisited.class.getClassLoader());
            this.numSpaceW = parcel.readString();
            this.numSpaceWF = parcel.readString();
            this.opentime2 = parcel.readString();
            this.opentimeText = parcel.readString();
            this.parent = parcel.readString();
            this.parentName = parcel.readString();
            this.picInfo = parcel.readString();
            this.rating = parcel.readString();
            this.recommendFlag = parcel.readString();
            this.reviewTotal = parcel.readString();
            this.sell = parcel.readString();
            this.tel = parcel.readString();
            this.towardsAngle = parcel.readString();
            this.typeCode = parcel.readString();
            this.updateFlag = parcel.readString();
            this.xEntr = parcel.readString();
            this.yEntr = parcel.readString();
            this.category = parcel.readString();
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class ChargeInfo implements Parcelable {
        public static final Parcelable.Creator<ChargeInfo> CREATOR = new Parcelable.Creator<ChargeInfo>() { // from class: com.amap.api.services.auto.ListData.ChargeInfo.1
            /* renamed from: a */
            private static ChargeInfo m51934a(Parcel parcel) {
                return new ChargeInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ChargeInfo createFromParcel(Parcel parcel) {
                return m51934a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ChargeInfo[] newArray(int i) {
                return m51935a(i);
            }

            /* renamed from: a */
            private static ChargeInfo[] m51935a(int i) {
                return new ChargeInfo[i];
            }
        };
        public List<PlugsInfo> plugsInfos;
        public String plugsType;

        public ChargeInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.plugsType);
            parcel.writeTypedList(this.plugsInfos);
        }

        protected ChargeInfo(Parcel parcel) {
            this.plugsType = parcel.readString();
            this.plugsInfos = parcel.createTypedArrayList(PlugsInfo.CREATOR);
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class ChargingInfo implements Parcelable {
        public static final Parcelable.Creator<ChargingInfo> CREATOR = new Parcelable.Creator<ChargingInfo>() { // from class: com.amap.api.services.auto.ListData.ChargingInfo.1
            /* renamed from: a */
            private static ChargingInfo m51932a(Parcel parcel) {
                return new ChargingInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ChargingInfo createFromParcel(Parcel parcel) {
                return m51932a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ChargingInfo[] newArray(int i) {
                return m51933a(i);
            }

            /* renamed from: a */
            private static ChargingInfo[] m51933a(int i) {
                return new ChargingInfo[i];
            }
        };
        public String brandDesc;
        public List<ChargeInfo> chargeInfo;
        public String chargingRatingFlagTerm;
        public String creditZhima;
        public String cscf;
        public String currentElePrice;
        public String currentSerPrice;
        public String deepRightsTag;
        public HashMap<String, String> idDictionary;
        public String latestCharge;
        public String numFast;
        public String numSlow;
        public String parkCategory;
        public PriceChargingPark priceChargingPark;
        public String priceParkingStd;

        public ChargingInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.brandDesc);
            parcel.writeTypedList(this.chargeInfo);
            parcel.writeString(this.chargingRatingFlagTerm);
            parcel.writeString(this.creditZhima);
            parcel.writeString(this.cscf);
            parcel.writeString(this.currentElePrice);
            parcel.writeString(this.currentSerPrice);
            parcel.writeString(this.deepRightsTag);
            parcel.writeString(this.latestCharge);
            parcel.writeString(this.numFast);
            parcel.writeString(this.numSlow);
            parcel.writeString(this.parkCategory);
            parcel.writeParcelable(this.priceChargingPark, i);
            parcel.writeString(this.priceParkingStd);
            parcel.writeMap(this.idDictionary);
        }

        protected ChargingInfo(Parcel parcel) {
            this.brandDesc = parcel.readString();
            this.chargeInfo = parcel.createTypedArrayList(ChargeInfo.CREATOR);
            this.chargingRatingFlagTerm = parcel.readString();
            this.creditZhima = parcel.readString();
            this.cscf = parcel.readString();
            this.currentElePrice = parcel.readString();
            this.currentSerPrice = parcel.readString();
            this.deepRightsTag = parcel.readString();
            this.latestCharge = parcel.readString();
            this.numFast = parcel.readString();
            this.numSlow = parcel.readString();
            this.parkCategory = parcel.readString();
            this.priceChargingPark = (PriceChargingPark) parcel.readParcelable(PriceChargingPark.class.getClassLoader());
            this.priceParkingStd = parcel.readString();
            HashMap<String, String> hashMap = new HashMap<>();
            this.idDictionary = hashMap;
            parcel.readMap(hashMap, HashMap.class.getClassLoader());
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class Content implements Parcelable {
        public static final Parcelable.Creator<Content> CREATOR = new Parcelable.Creator<Content>() { // from class: com.amap.api.services.auto.ListData.Content.1
            /* renamed from: a */
            private static Content m51930a(Parcel parcel) {
                return new Content(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Content createFromParcel(Parcel parcel) {
                return m51930a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Content[] newArray(int i) {
                return m51931a(i);
            }

            /* renamed from: a */
            private static Content[] m51931a(int i) {
                return new Content[i];
            }
        };
        public Data data;
        public String itemType;

        public Content() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.data, i);
            parcel.writeString(this.itemType);
        }

        protected Content(Parcel parcel) {
            this.data = (Data) parcel.readParcelable(Data.class.getClassLoader());
            this.itemType = parcel.readString();
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class Data implements Parcelable {
        public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() { // from class: com.amap.api.services.auto.ListData.Data.1
            /* renamed from: a */
            private static Data m51928a(Parcel parcel) {
                return new Data(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Data createFromParcel(Parcel parcel) {
                return m51928a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Data[] newArray(int i) {
                return m51929a(i);
            }

            /* renamed from: a */
            private static Data[] m51929a(int i) {
                return new Data[i];
            }
        };
        public BasicInfo basicInfo;
        public ChargingInfo chargingInfo;

        public Data() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.basicInfo, i);
            parcel.writeParcelable(this.chargingInfo, i);
        }

        protected Data(Parcel parcel) {
            this.basicInfo = (BasicInfo) parcel.readParcelable(BasicInfo.class.getClassLoader());
            this.chargingInfo = (ChargingInfo) parcel.readParcelable(ChargingInfo.class.getClassLoader());
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class NaviVisited implements Parcelable {
        public static final Parcelable.Creator<NaviVisited> CREATOR = new Parcelable.Creator<NaviVisited>() { // from class: com.amap.api.services.auto.ListData.NaviVisited.1
            /* renamed from: a */
            private static NaviVisited m51926a(Parcel parcel) {
                return new NaviVisited(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ NaviVisited createFromParcel(Parcel parcel) {
                return m51926a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ NaviVisited[] newArray(int i) {
                return m51927a(i);
            }

            /* renamed from: a */
            private static NaviVisited[] m51927a(int i) {
                return new NaviVisited[i];
            }
        };
        public String randUnionMonthUv;

        public NaviVisited() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.randUnionMonthUv);
        }

        protected NaviVisited(Parcel parcel) {
            this.randUnionMonthUv = parcel.readString();
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class Park implements Parcelable {
        public static final Parcelable.Creator<Park> CREATOR = new Parcelable.Creator<Park>() { // from class: com.amap.api.services.auto.ListData.Park.1
            /* renamed from: a */
            private static Park m51924a(Parcel parcel) {
                return new Park(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Park createFromParcel(Parcel parcel) {
                return m51924a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Park[] newArray(int i) {
                return m51925a(i);
            }

            /* renamed from: a */
            private static Park[] m51925a(int i) {
                return new Park[i];
            }
        };
        public List<PriceCharging> priceChargings;
        public String srcType;

        public Park() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(this.priceChargings);
            parcel.writeString(this.srcType);
        }

        protected Park(Parcel parcel) {
            this.priceChargings = parcel.createTypedArrayList(PriceCharging.CREATOR);
            this.srcType = parcel.readString();
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class PlugsInfo implements Parcelable {
        public static final Parcelable.Creator<PlugsInfo> CREATOR = new Parcelable.Creator<PlugsInfo>() { // from class: com.amap.api.services.auto.ListData.PlugsInfo.1
            /* renamed from: a */
            private static PlugsInfo m51922a(Parcel parcel) {
                return new PlugsInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PlugsInfo createFromParcel(Parcel parcel) {
                return m51922a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PlugsInfo[] newArray(int i) {
                return m51923a(i);
            }

            /* renamed from: a */
            private static PlugsInfo[] m51923a(int i) {
                return new PlugsInfo[i];
            }
        };
        public String brandDesc;
        public String fastcur;
        public String fastpower;
        public String fastvol;

        public PlugsInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.brandDesc);
            parcel.writeString(this.fastcur);
            parcel.writeString(this.fastpower);
            parcel.writeString(this.fastvol);
        }

        protected PlugsInfo(Parcel parcel) {
            this.brandDesc = parcel.readString();
            this.fastcur = parcel.readString();
            this.fastpower = parcel.readString();
            this.fastvol = parcel.readString();
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class PriceCharging implements Parcelable {
        public static final Parcelable.Creator<PriceCharging> CREATOR = new Parcelable.Creator<PriceCharging>() { // from class: com.amap.api.services.auto.ListData.PriceCharging.1
            /* renamed from: a */
            private static PriceCharging m51920a(Parcel parcel) {
                return new PriceCharging(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PriceCharging createFromParcel(Parcel parcel) {
                return m51920a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PriceCharging[] newArray(int i) {
                return m51921a(i);
            }

            /* renamed from: a */
            private static PriceCharging[] m51921a(int i) {
                return new PriceCharging[i];
            }
        };
        public String elePrice;
        public String serPrice;
        public String time;
        public int updatetime;

        public PriceCharging() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.elePrice);
            parcel.writeString(this.serPrice);
            parcel.writeString(this.time);
            parcel.writeInt(this.updatetime);
        }

        protected PriceCharging(Parcel parcel) {
            this.elePrice = parcel.readString();
            this.serPrice = parcel.readString();
            this.time = parcel.readString();
            this.updatetime = parcel.readInt();
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class PriceChargingPark implements Parcelable {
        public static final Parcelable.Creator<PriceChargingPark> CREATOR = new Parcelable.Creator<PriceChargingPark>() { // from class: com.amap.api.services.auto.ListData.PriceChargingPark.1
            /* renamed from: a */
            private static PriceChargingPark m51918a(Parcel parcel) {
                return new PriceChargingPark(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PriceChargingPark createFromParcel(Parcel parcel) {
                return m51918a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PriceChargingPark[] newArray(int i) {
                return m51919a(i);
            }

            /* renamed from: a */
            private static PriceChargingPark[] m51919a(int i) {
                return new PriceChargingPark[i];
            }
        };
        public List<Park> parks;

        public PriceChargingPark() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(this.parks);
        }

        protected PriceChargingPark(Parcel parcel) {
            this.parks = parcel.createTypedArrayList(Park.CREATOR);
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class ShortReview {
    }

    public ListData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.content);
    }

    protected ListData(Parcel parcel) {
        this.content = parcel.createTypedArrayList(Content.CREATOR);
    }
}
