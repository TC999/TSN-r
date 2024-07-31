package com.amap.api.services.auto;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Classify implements Parcelable {
    public static final Parcelable.Creator<Classify> CREATOR = new Parcelable.Creator<Classify>() { // from class: com.amap.api.services.auto.Classify.1
        /* renamed from: a */
        private static Classify m51954a(Parcel parcel) {
            return new Classify(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Classify createFromParcel(Parcel parcel) {
            return m51954a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Classify[] newArray(int i) {
            return m51955a(i);
        }

        /* renamed from: a */
        private static Classify[] m51955a(int i) {
            return new Classify[i];
        }
    };
    public ItermData itermData;
    public RetainState retainState;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class Category implements Parcelable {
        public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() { // from class: com.amap.api.services.auto.Classify.Category.1
            /* renamed from: a */
            private static Category m51952a(Parcel parcel) {
                return new Category(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Category createFromParcel(Parcel parcel) {
                return m51952a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Category[] newArray(int i) {
                return m51953a(i);
            }

            /* renamed from: a */
            private static Category[] m51953a(int i) {
                return new Category[i];
            }
        };
        public int checked;
        public String classifyItemType;
        public String componentType;
        public int defaultValue;
        public String img;
        public String name;
        public String params;
        public String showType;
        public String value;

        public Category() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.checked);
            parcel.writeString(this.componentType);
            parcel.writeInt(this.defaultValue);
            parcel.writeString(this.name);
            parcel.writeString(this.params);
            parcel.writeString(this.value);
            parcel.writeString(this.classifyItemType);
            parcel.writeString(this.img);
            parcel.writeString(this.showType);
        }

        protected Category(Parcel parcel) {
            this.checked = parcel.readInt();
            this.componentType = parcel.readString();
            this.defaultValue = parcel.readInt();
            this.name = parcel.readString();
            this.params = parcel.readString();
            this.value = parcel.readString();
            this.classifyItemType = parcel.readString();
            this.img = parcel.readString();
            this.showType = parcel.readString();
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class CheckedNode implements Parcelable {
        public static final Parcelable.Creator<CheckedNode> CREATOR = new Parcelable.Creator<CheckedNode>() { // from class: com.amap.api.services.auto.Classify.CheckedNode.1
            /* renamed from: a */
            private static CheckedNode m51950a(Parcel parcel) {
                return new CheckedNode(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CheckedNode createFromParcel(Parcel parcel) {
                return m51950a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CheckedNode[] newArray(int i) {
                return m51951a(i);
            }

            /* renamed from: a */
            private static CheckedNode[] m51951a(int i) {
                return new CheckedNode[i];
            }
        };

        /* renamed from: id */
        public String f7183id;
        public String name;
        public String value;

        public CheckedNode() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f7183id);
            parcel.writeString(this.value);
            parcel.writeString(this.name);
        }

        protected CheckedNode(Parcel parcel) {
            this.f7183id = parcel.readString();
            this.value = parcel.readString();
            this.name = parcel.readString();
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class CheckedValue implements Parcelable {
        public static final Parcelable.Creator<CheckedValue> CREATOR = new Parcelable.Creator<CheckedValue>() { // from class: com.amap.api.services.auto.Classify.CheckedValue.1
            /* renamed from: a */
            private static CheckedValue m51948a(Parcel parcel) {
                return new CheckedValue(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CheckedValue createFromParcel(Parcel parcel) {
                return m51948a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CheckedValue[] newArray(int i) {
                return m51949a(i);
            }

            /* renamed from: a */
            private static CheckedValue[] m51949a(int i) {
                return new CheckedValue[i];
            }
        };
        public String classifyV2Data;
        public String classifyV2Level2Data;
        public String classifyV2Level3Data;

        public CheckedValue() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.classifyV2Data);
            parcel.writeString(this.classifyV2Level2Data);
            parcel.writeString(this.classifyV2Level3Data);
        }

        protected CheckedValue(Parcel parcel) {
            this.classifyV2Data = parcel.readString();
            this.classifyV2Level2Data = parcel.readString();
            this.classifyV2Level3Data = parcel.readString();
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class Data implements Parcelable {
        public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() { // from class: com.amap.api.services.auto.Classify.Data.1
            /* renamed from: a */
            private static Data m51946a(Parcel parcel) {
                return new Data(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Data createFromParcel(Parcel parcel) {
                return m51946a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Data[] newArray(int i) {
                return m51947a(i);
            }

            /* renamed from: a */
            private static Data[] m51947a(int i) {
                return new Data[i];
            }
        };
        public List<DataCategory> categories;
        public int checked;
        public String classifyItemType;
        public int isCancelDefaultSelect;
        public int isNoBtn;
        public int multiSelect;
        public String name;
        public String params;
        public String separator;
        public String type;
        public int useCommonlyUsedConfig;
        public int useLocalConfig;
        public int useRemoteConfig;

        public Data() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(this.categories);
            parcel.writeInt(this.checked);
            parcel.writeString(this.classifyItemType);
            parcel.writeInt(this.isCancelDefaultSelect);
            parcel.writeInt(this.isNoBtn);
            parcel.writeString(this.name);
            parcel.writeString(this.params);
            parcel.writeString(this.separator);
            parcel.writeString(this.type);
            parcel.writeInt(this.useCommonlyUsedConfig);
            parcel.writeInt(this.useLocalConfig);
            parcel.writeInt(this.useRemoteConfig);
            parcel.writeInt(this.multiSelect);
        }

        protected Data(Parcel parcel) {
            this.categories = parcel.createTypedArrayList(DataCategory.CREATOR);
            this.checked = parcel.readInt();
            this.classifyItemType = parcel.readString();
            this.isCancelDefaultSelect = parcel.readInt();
            this.isNoBtn = parcel.readInt();
            this.name = parcel.readString();
            this.params = parcel.readString();
            this.separator = parcel.readString();
            this.type = parcel.readString();
            this.useCommonlyUsedConfig = parcel.readInt();
            this.useLocalConfig = parcel.readInt();
            this.useRemoteConfig = parcel.readInt();
            this.multiSelect = parcel.readInt();
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class DataCategory implements Parcelable {
        public static final Parcelable.Creator<DataCategory> CREATOR = new Parcelable.Creator<DataCategory>() { // from class: com.amap.api.services.auto.Classify.DataCategory.1
            /* renamed from: a */
            private static DataCategory m51944a(Parcel parcel) {
                return new DataCategory(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DataCategory createFromParcel(Parcel parcel) {
                return m51944a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DataCategory[] newArray(int i) {
                return m51945a(i);
            }

            /* renamed from: a */
            private static DataCategory[] m51945a(int i) {
                return new DataCategory[i];
            }
        };
        public int areaSubwayMark;
        public List<Category> categories;
        public int checked;
        public String classifyItemType;
        public String componentType;
        public int defaultValue;
        public int hideTitle;
        public String img;
        public int maxShowNum;
        public int maxShowNumRow;
        public int multiSelect;
        public String name;
        public String params;
        public String showType;
        public String value;

        public DataCategory() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(this.categories);
            parcel.writeInt(this.checked);
            parcel.writeInt(this.defaultValue);
            parcel.writeString(this.componentType);
            parcel.writeString(this.name);
            parcel.writeString(this.params);
            parcel.writeInt(this.areaSubwayMark);
            parcel.writeInt(this.hideTitle);
            parcel.writeInt(this.maxShowNum);
            parcel.writeInt(this.maxShowNumRow);
            parcel.writeInt(this.multiSelect);
            parcel.writeString(this.img);
            parcel.writeString(this.showType);
            parcel.writeString(this.value);
            parcel.writeString(this.classifyItemType);
        }

        protected DataCategory(Parcel parcel) {
            this.categories = parcel.createTypedArrayList(Category.CREATOR);
            this.checked = parcel.readInt();
            this.defaultValue = parcel.readInt();
            this.componentType = parcel.readString();
            this.name = parcel.readString();
            this.params = parcel.readString();
            this.areaSubwayMark = parcel.readInt();
            this.hideTitle = parcel.readInt();
            this.maxShowNum = parcel.readInt();
            this.maxShowNumRow = parcel.readInt();
            this.multiSelect = parcel.readInt();
            this.img = parcel.readString();
            this.showType = parcel.readString();
            this.value = parcel.readString();
            this.classifyItemType = parcel.readString();
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class ItermData implements Parcelable {
        public static final Parcelable.Creator<ItermData> CREATOR = new Parcelable.Creator<ItermData>() { // from class: com.amap.api.services.auto.Classify.ItermData.1
            /* renamed from: a */
            private static ItermData m51942a(Parcel parcel) {
                return new ItermData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ItermData createFromParcel(Parcel parcel) {
                return m51942a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ItermData[] newArray(int i) {
                return m51943a(i);
            }

            /* renamed from: a */
            private static ItermData[] m51943a(int i) {
                return new ItermData[i];
            }
        };
        public List<CheckedNode> checkedNodes;
        public CheckedValue checkedValue;
        public List<Data> datas;
        public List<Data> defaultPositionDatas;
        public List<Data> level2Datas;

        public ItermData() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(this.checkedNodes);
            parcel.writeParcelable(this.checkedValue, i);
            parcel.writeTypedList(this.datas);
            parcel.writeTypedList(this.defaultPositionDatas);
            parcel.writeTypedList(this.level2Datas);
        }

        protected ItermData(Parcel parcel) {
            this.checkedNodes = parcel.createTypedArrayList(CheckedNode.CREATOR);
            this.checkedValue = (CheckedValue) parcel.readParcelable(CheckedValue.class.getClassLoader());
            Parcelable.Creator<Data> creator = Data.CREATOR;
            this.datas = parcel.createTypedArrayList(creator);
            this.defaultPositionDatas = parcel.createTypedArrayList(creator);
            this.level2Datas = parcel.createTypedArrayList(creator);
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class RetainState implements Parcelable {
        public static final Parcelable.Creator<RetainState> CREATOR = new Parcelable.Creator<RetainState>() { // from class: com.amap.api.services.auto.Classify.RetainState.1
            /* renamed from: a */
            private static RetainState m51940a(Parcel parcel) {
                return new RetainState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RetainState createFromParcel(Parcel parcel) {
                return m51940a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RetainState[] newArray(int i) {
                return m51941a(i);
            }

            /* renamed from: a */
            private static RetainState[] m51941a(int i) {
                return new RetainState[i];
            }
        };
        public String classifyBusinessType;
        public String classifyConf;
        public String classifyRetainLevel2;
        public String level2All;
        public String newClassifyCityadcode;
        public String newClassifyFlag;

        public RetainState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.classifyBusinessType);
            parcel.writeString(this.classifyConf);
            parcel.writeString(this.classifyRetainLevel2);
            parcel.writeString(this.level2All);
            parcel.writeString(this.newClassifyCityadcode);
            parcel.writeString(this.newClassifyFlag);
        }

        protected RetainState(Parcel parcel) {
            this.classifyBusinessType = parcel.readString();
            this.classifyConf = parcel.readString();
            this.classifyRetainLevel2 = parcel.readString();
            this.level2All = parcel.readString();
            this.newClassifyCityadcode = parcel.readString();
            this.newClassifyFlag = parcel.readString();
        }
    }

    public Classify() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.itermData, i);
        parcel.writeParcelable(this.retainState, i);
    }

    protected Classify(Parcel parcel) {
        this.itermData = (ItermData) parcel.readParcelable(ItermData.class.getClassLoader());
        this.retainState = (RetainState) parcel.readParcelable(RetainState.class.getClassLoader());
    }
}
