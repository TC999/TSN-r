package com.amap.api.services.auto;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p047s.AutoTSearchCore;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IAutoTSearch;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AutoTSearch {

    /* renamed from: a */
    private IAutoTSearch f7161a;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class FilterBox implements Parcelable, Cloneable {
        public static final Parcelable.Creator<FilterBox> CREATOR = new Parcelable.Creator<FilterBox>() { // from class: com.amap.api.services.auto.AutoTSearch.FilterBox.1
            /* renamed from: a */
            private static FilterBox m51958a(Parcel parcel) {
                return new FilterBox(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FilterBox createFromParcel(Parcel parcel) {
                return m51958a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FilterBox[] newArray(int i) {
                return m51959a(i);
            }

            /* renamed from: a */
            private static FilterBox[] m51959a(int i) {
                return new FilterBox[i];
            }
        };

        /* renamed from: a */
        private String f7162a;

        /* renamed from: b */
        private String f7163b;

        /* renamed from: c */
        private String f7164c;

        /* renamed from: d */
        private String f7165d;

        /* renamed from: e */
        private String f7166e;

        public FilterBox() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getCheckedLevel() {
            return this.f7163b;
        }

        public String getClassifyV2Data() {
            return this.f7164c;
        }

        public String getClassifyV2Level2Data() {
            return this.f7165d;
        }

        public String getClassifyV2Level3Data() {
            return this.f7166e;
        }

        public String getRetainState() {
            return this.f7162a;
        }

        public void setCheckedLevel(String str) {
            this.f7163b = str;
        }

        public void setClassifyV2Data(String str) {
            this.f7164c = str;
        }

        public void setClassifyV2Level2Data(String str) {
            this.f7165d = str;
        }

        public void setClassifyV2Level3Data(String str) {
            this.f7166e = str;
        }

        public void setRetainState(String str) {
            this.f7162a = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f7162a);
            parcel.writeString(this.f7163b);
            parcel.writeString(this.f7164c);
            parcel.writeString(this.f7165d);
            parcel.writeString(this.f7166e);
        }

        protected FilterBox(Parcel parcel) {
            this.f7162a = parcel.readString();
            this.f7163b = parcel.readString();
            this.f7164c = parcel.readString();
            this.f7165d = parcel.readString();
            this.f7166e = parcel.readString();
        }

        /* renamed from: clone */
        public FilterBox m60108clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            FilterBox filterBox = new FilterBox();
            filterBox.setRetainState(this.f7162a);
            filterBox.setCheckedLevel(this.f7163b);
            filterBox.setClassifyV2Data(this.f7164c);
            filterBox.setClassifyV2Level2Data(this.f7165d);
            filterBox.setClassifyV2Level3Data(this.f7166e);
            return filterBox;
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnChargeStationListener {
        void onChargeStationSearched(AutoTChargeStationResult autoTChargeStationResult, int i);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class Query implements Parcelable, Cloneable {
        public static final Parcelable.Creator<Query> CREATOR = new Parcelable.Creator<Query>() { // from class: com.amap.api.services.auto.AutoTSearch.Query.1
            /* renamed from: a */
            private static Query m51956a(Parcel parcel) {
                return new Query(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Query createFromParcel(Parcel parcel) {
                return m51956a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Query[] newArray(int i) {
                return m51957a(i);
            }

            /* renamed from: a */
            private static Query[] m51957a(int i) {
                return new Query[i];
            }
        };

        /* renamed from: a */
        private String f7167a;

        /* renamed from: b */
        private String f7168b;

        /* renamed from: c */
        private String f7169c;

        /* renamed from: d */
        private String f7170d;

        /* renamed from: e */
        private String f7171e;

        /* renamed from: f */
        private int f7172f;

        /* renamed from: g */
        private int f7173g;

        /* renamed from: h */
        private boolean f7174h;

        /* renamed from: i */
        private String f7175i;

        /* renamed from: j */
        private int f7176j;

        /* renamed from: k */
        private LatLonPoint f7177k;

        /* renamed from: l */
        private String f7178l;

        /* renamed from: m */
        private String f7179m;

        /* renamed from: n */
        private FilterBox f7180n;

        /* renamed from: o */
        private String f7181o;

        /* renamed from: p */
        private String f7182p;

        public Query() {
            this.f7174h = false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAccessKey() {
            return this.f7181o;
        }

        public String getAdCode() {
            return this.f7167a;
        }

        public String getCity() {
            return this.f7168b;
        }

        public String getDataType() {
            return this.f7169c;
        }

        public FilterBox getFilterBox() {
            return this.f7180n;
        }

        public String getGeoObj() {
            return this.f7170d;
        }

        public String getKeywords() {
            return this.f7171e;
        }

        public LatLonPoint getLatLonPoint() {
            return this.f7177k;
        }

        public int getPageNum() {
            return this.f7172f;
        }

        public int getPageSize() {
            return this.f7173g;
        }

        public String getQueryType() {
            return this.f7175i;
        }

        public int getRange() {
            return this.f7176j;
        }

        public String getSecretKey() {
            return this.f7182p;
        }

        public String getUserCity() {
            return this.f7179m;
        }

        public String getUserLoc() {
            return this.f7178l;
        }

        public boolean isQii() {
            return this.f7174h;
        }

        public void setAccessKey(String str) {
            this.f7181o = str;
        }

        public void setAdCode(String str) {
            this.f7167a = str;
        }

        public void setCity(String str) {
            this.f7168b = str;
        }

        public void setDataType(String str) {
            this.f7169c = str;
        }

        public void setFilterBox(FilterBox filterBox) {
            this.f7180n = filterBox;
        }

        public void setGeoObj(String str) {
            this.f7170d = str;
        }

        public void setKeywords(String str) {
            this.f7171e = str;
        }

        public void setLatLonPoint(LatLonPoint latLonPoint) {
            this.f7177k = latLonPoint;
        }

        public void setPageNum(int i) {
            this.f7172f = i;
        }

        public void setPageSize(int i) {
            this.f7173g = i;
        }

        public void setQii(boolean z) {
            this.f7174h = z;
        }

        public void setQueryType(String str) {
            this.f7175i = str;
        }

        public void setRange(int i) {
            this.f7176j = i;
        }

        public void setSecretKey(String str) {
            this.f7182p = str;
        }

        public void setUserCity(String str) {
            this.f7179m = str;
        }

        public void setUserLoc(String str) {
            this.f7178l = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f7167a);
            parcel.writeString(this.f7168b);
            parcel.writeString(this.f7169c);
            parcel.writeString(this.f7170d);
            parcel.writeString(this.f7171e);
            parcel.writeInt(this.f7172f);
            parcel.writeInt(this.f7173g);
            parcel.writeByte(this.f7174h ? (byte) 1 : (byte) 0);
            parcel.writeString(this.f7175i);
            parcel.writeInt(this.f7176j);
            parcel.writeParcelable(this.f7177k, i);
            parcel.writeString(this.f7178l);
            parcel.writeString(this.f7179m);
            parcel.writeParcelable(this.f7180n, i);
            parcel.writeString(this.f7181o);
            parcel.writeString(this.f7182p);
        }

        /* renamed from: clone */
        public Query m60109clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            Query query = new Query();
            query.setAdCode(this.f7167a);
            query.setCity(this.f7168b);
            query.setDataType(this.f7169c);
            query.setGeoObj(this.f7170d);
            query.setKeywords(this.f7171e);
            query.setPageNum(this.f7172f);
            query.setPageSize(this.f7173g);
            query.setQii(this.f7174h);
            query.setQueryType(this.f7175i);
            query.setRange(this.f7176j);
            query.setLatLonPoint(this.f7177k);
            query.setUserLoc(this.f7178l);
            query.setUserCity(this.f7179m);
            query.setAccessKey(this.f7181o);
            query.setSecretKey(this.f7182p);
            query.setFilterBox(this.f7180n);
            return query;
        }

        protected Query(Parcel parcel) {
            this.f7174h = false;
            this.f7167a = parcel.readString();
            this.f7168b = parcel.readString();
            this.f7169c = parcel.readString();
            this.f7170d = parcel.readString();
            this.f7171e = parcel.readString();
            this.f7172f = parcel.readInt();
            this.f7173g = parcel.readInt();
            this.f7174h = parcel.readByte() != 0;
            this.f7175i = parcel.readString();
            this.f7176j = parcel.readInt();
            this.f7177k = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f7178l = parcel.readString();
            this.f7179m = parcel.readString();
            this.f7180n = (FilterBox) parcel.readParcelable(FilterBox.class.getClassLoader());
            this.f7181o = parcel.readString();
            this.f7182p = parcel.readString();
        }
    }

    public AutoTSearch(Context context) throws AMapException {
        if (this.f7161a == null) {
            try {
                this.f7161a = new AutoTSearchCore(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    public AutoTChargeStationResult searchChargeStation() throws AMapException {
        IAutoTSearch iAutoTSearch = this.f7161a;
        if (iAutoTSearch == null) {
            return null;
        }
        return iAutoTSearch.searchChargeStation();
    }

    public void searchChargeStationAsync() throws AMapException {
        IAutoTSearch iAutoTSearch = this.f7161a;
        if (iAutoTSearch == null) {
            return;
        }
        iAutoTSearch.searchChargeStationAsync();
    }

    public void setChargeStationListener(OnChargeStationListener onChargeStationListener) {
        IAutoTSearch iAutoTSearch = this.f7161a;
        if (iAutoTSearch == null || onChargeStationListener == null) {
            return;
        }
        iAutoTSearch.setChargeStationListener(onChargeStationListener);
    }

    public void setQuery(Query query) {
        IAutoTSearch iAutoTSearch = this.f7161a;
        if (iAutoTSearch == null) {
            return;
        }
        iAutoTSearch.setQuery(query);
    }
}
