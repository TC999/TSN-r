package com.amap.api.services.auto;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.h0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IAutoTSearch;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AutoTSearch {

    /* renamed from: a  reason: collision with root package name */
    private IAutoTSearch f10859a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class FilterBox implements Parcelable, Cloneable {
        public static final Parcelable.Creator<FilterBox> CREATOR = new Parcelable.Creator<FilterBox>() { // from class: com.amap.api.services.auto.AutoTSearch.FilterBox.1
            private static FilterBox a(Parcel parcel) {
                return new FilterBox(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FilterBox createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FilterBox[] newArray(int i4) {
                return a(i4);
            }

            private static FilterBox[] a(int i4) {
                return new FilterBox[i4];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private String f10860a;

        /* renamed from: b  reason: collision with root package name */
        private String f10861b;

        /* renamed from: c  reason: collision with root package name */
        private String f10862c;

        /* renamed from: d  reason: collision with root package name */
        private String f10863d;

        /* renamed from: e  reason: collision with root package name */
        private String f10864e;

        public FilterBox() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getCheckedLevel() {
            return this.f10861b;
        }

        public String getClassifyV2Data() {
            return this.f10862c;
        }

        public String getClassifyV2Level2Data() {
            return this.f10863d;
        }

        public String getClassifyV2Level3Data() {
            return this.f10864e;
        }

        public String getRetainState() {
            return this.f10860a;
        }

        public void setCheckedLevel(String str) {
            this.f10861b = str;
        }

        public void setClassifyV2Data(String str) {
            this.f10862c = str;
        }

        public void setClassifyV2Level2Data(String str) {
            this.f10863d = str;
        }

        public void setClassifyV2Level3Data(String str) {
            this.f10864e = str;
        }

        public void setRetainState(String str) {
            this.f10860a = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeString(this.f10860a);
            parcel.writeString(this.f10861b);
            parcel.writeString(this.f10862c);
            parcel.writeString(this.f10863d);
            parcel.writeString(this.f10864e);
        }

        protected FilterBox(Parcel parcel) {
            this.f10860a = parcel.readString();
            this.f10861b = parcel.readString();
            this.f10862c = parcel.readString();
            this.f10863d = parcel.readString();
            this.f10864e = parcel.readString();
        }

        /* renamed from: clone */
        public FilterBox m29clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                e4.printStackTrace();
            }
            FilterBox filterBox = new FilterBox();
            filterBox.setRetainState(this.f10860a);
            filterBox.setCheckedLevel(this.f10861b);
            filterBox.setClassifyV2Data(this.f10862c);
            filterBox.setClassifyV2Level2Data(this.f10863d);
            filterBox.setClassifyV2Level3Data(this.f10864e);
            return filterBox;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnChargeStationListener {
        void onChargeStationSearched(AutoTChargeStationResult autoTChargeStationResult, int i4);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Query implements Parcelable, Cloneable {
        public static final Parcelable.Creator<Query> CREATOR = new Parcelable.Creator<Query>() { // from class: com.amap.api.services.auto.AutoTSearch.Query.1
            private static Query a(Parcel parcel) {
                return new Query(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Query createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Query[] newArray(int i4) {
                return a(i4);
            }

            private static Query[] a(int i4) {
                return new Query[i4];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private String f10865a;

        /* renamed from: b  reason: collision with root package name */
        private String f10866b;

        /* renamed from: c  reason: collision with root package name */
        private String f10867c;

        /* renamed from: d  reason: collision with root package name */
        private String f10868d;

        /* renamed from: e  reason: collision with root package name */
        private String f10869e;

        /* renamed from: f  reason: collision with root package name */
        private int f10870f;

        /* renamed from: g  reason: collision with root package name */
        private int f10871g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f10872h;

        /* renamed from: i  reason: collision with root package name */
        private String f10873i;

        /* renamed from: j  reason: collision with root package name */
        private int f10874j;

        /* renamed from: k  reason: collision with root package name */
        private LatLonPoint f10875k;

        /* renamed from: l  reason: collision with root package name */
        private String f10876l;

        /* renamed from: m  reason: collision with root package name */
        private String f10877m;

        /* renamed from: n  reason: collision with root package name */
        private FilterBox f10878n;

        /* renamed from: o  reason: collision with root package name */
        private String f10879o;

        /* renamed from: p  reason: collision with root package name */
        private String f10880p;

        public Query() {
            this.f10872h = false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAccessKey() {
            return this.f10879o;
        }

        public String getAdCode() {
            return this.f10865a;
        }

        public String getCity() {
            return this.f10866b;
        }

        public String getDataType() {
            return this.f10867c;
        }

        public FilterBox getFilterBox() {
            return this.f10878n;
        }

        public String getGeoObj() {
            return this.f10868d;
        }

        public String getKeywords() {
            return this.f10869e;
        }

        public LatLonPoint getLatLonPoint() {
            return this.f10875k;
        }

        public int getPageNum() {
            return this.f10870f;
        }

        public int getPageSize() {
            return this.f10871g;
        }

        public String getQueryType() {
            return this.f10873i;
        }

        public int getRange() {
            return this.f10874j;
        }

        public String getSecretKey() {
            return this.f10880p;
        }

        public String getUserCity() {
            return this.f10877m;
        }

        public String getUserLoc() {
            return this.f10876l;
        }

        public boolean isQii() {
            return this.f10872h;
        }

        public void setAccessKey(String str) {
            this.f10879o = str;
        }

        public void setAdCode(String str) {
            this.f10865a = str;
        }

        public void setCity(String str) {
            this.f10866b = str;
        }

        public void setDataType(String str) {
            this.f10867c = str;
        }

        public void setFilterBox(FilterBox filterBox) {
            this.f10878n = filterBox;
        }

        public void setGeoObj(String str) {
            this.f10868d = str;
        }

        public void setKeywords(String str) {
            this.f10869e = str;
        }

        public void setLatLonPoint(LatLonPoint latLonPoint) {
            this.f10875k = latLonPoint;
        }

        public void setPageNum(int i4) {
            this.f10870f = i4;
        }

        public void setPageSize(int i4) {
            this.f10871g = i4;
        }

        public void setQii(boolean z3) {
            this.f10872h = z3;
        }

        public void setQueryType(String str) {
            this.f10873i = str;
        }

        public void setRange(int i4) {
            this.f10874j = i4;
        }

        public void setSecretKey(String str) {
            this.f10880p = str;
        }

        public void setUserCity(String str) {
            this.f10877m = str;
        }

        public void setUserLoc(String str) {
            this.f10876l = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeString(this.f10865a);
            parcel.writeString(this.f10866b);
            parcel.writeString(this.f10867c);
            parcel.writeString(this.f10868d);
            parcel.writeString(this.f10869e);
            parcel.writeInt(this.f10870f);
            parcel.writeInt(this.f10871g);
            parcel.writeByte(this.f10872h ? (byte) 1 : (byte) 0);
            parcel.writeString(this.f10873i);
            parcel.writeInt(this.f10874j);
            parcel.writeParcelable(this.f10875k, i4);
            parcel.writeString(this.f10876l);
            parcel.writeString(this.f10877m);
            parcel.writeParcelable(this.f10878n, i4);
            parcel.writeString(this.f10879o);
            parcel.writeString(this.f10880p);
        }

        /* renamed from: clone */
        public Query m30clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                e4.printStackTrace();
            }
            Query query = new Query();
            query.setAdCode(this.f10865a);
            query.setCity(this.f10866b);
            query.setDataType(this.f10867c);
            query.setGeoObj(this.f10868d);
            query.setKeywords(this.f10869e);
            query.setPageNum(this.f10870f);
            query.setPageSize(this.f10871g);
            query.setQii(this.f10872h);
            query.setQueryType(this.f10873i);
            query.setRange(this.f10874j);
            query.setLatLonPoint(this.f10875k);
            query.setUserLoc(this.f10876l);
            query.setUserCity(this.f10877m);
            query.setAccessKey(this.f10879o);
            query.setSecretKey(this.f10880p);
            query.setFilterBox(this.f10878n);
            return query;
        }

        protected Query(Parcel parcel) {
            this.f10872h = false;
            this.f10865a = parcel.readString();
            this.f10866b = parcel.readString();
            this.f10867c = parcel.readString();
            this.f10868d = parcel.readString();
            this.f10869e = parcel.readString();
            this.f10870f = parcel.readInt();
            this.f10871g = parcel.readInt();
            this.f10872h = parcel.readByte() != 0;
            this.f10873i = parcel.readString();
            this.f10874j = parcel.readInt();
            this.f10875k = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f10876l = parcel.readString();
            this.f10877m = parcel.readString();
            this.f10878n = (FilterBox) parcel.readParcelable(FilterBox.class.getClassLoader());
            this.f10879o = parcel.readString();
            this.f10880p = parcel.readString();
        }
    }

    public AutoTSearch(Context context) throws AMapException {
        if (this.f10859a == null) {
            try {
                this.f10859a = new h0(context);
            } catch (Exception e4) {
                e4.printStackTrace();
                if (e4 instanceof AMapException) {
                    throw ((AMapException) e4);
                }
            }
        }
    }

    public AutoTChargeStationResult searchChargeStation() throws AMapException {
        IAutoTSearch iAutoTSearch = this.f10859a;
        if (iAutoTSearch == null) {
            return null;
        }
        return iAutoTSearch.searchChargeStation();
    }

    public void searchChargeStationAsync() throws AMapException {
        IAutoTSearch iAutoTSearch = this.f10859a;
        if (iAutoTSearch == null) {
            return;
        }
        iAutoTSearch.searchChargeStationAsync();
    }

    public void setChargeStationListener(OnChargeStationListener onChargeStationListener) {
        IAutoTSearch iAutoTSearch = this.f10859a;
        if (iAutoTSearch == null || onChargeStationListener == null) {
            return;
        }
        iAutoTSearch.setChargeStationListener(onChargeStationListener);
    }

    public void setQuery(Query query) {
        IAutoTSearch iAutoTSearch = this.f10859a;
        if (iAutoTSearch == null) {
            return;
        }
        iAutoTSearch.setQuery(query);
    }
}
