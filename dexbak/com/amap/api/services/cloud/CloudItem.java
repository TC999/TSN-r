package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CloudItem implements Parcelable {
    public static final Parcelable.Creator<CloudItem> CREATOR = new Parcelable.Creator<CloudItem>() { // from class: com.amap.api.services.cloud.CloudItem.1
        /* renamed from: a */
        private static CloudItem m51904a(Parcel parcel) {
            return new CloudItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudItem createFromParcel(Parcel parcel) {
            return m51904a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudItem[] newArray(int i) {
            return m51905a(i);
        }

        /* renamed from: a */
        private static CloudItem[] m51905a(int i) {
            return new CloudItem[i];
        }
    };

    /* renamed from: a */
    private String f7232a;

    /* renamed from: b */
    private int f7233b;

    /* renamed from: c */
    private String f7234c;

    /* renamed from: d */
    private String f7235d;

    /* renamed from: e */
    private HashMap<String, String> f7236e;

    /* renamed from: f */
    private List<CloudImage> f7237f;
    protected final LatLonPoint mPoint;
    protected final String mSnippet;
    protected final String mTitle;

    public CloudItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f7233b = -1;
        this.f7232a = str;
        this.mPoint = latLonPoint;
        this.mTitle = str2;
        this.mSnippet = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof CloudItem)) {
            CloudItem cloudItem = (CloudItem) obj;
            String str = this.f7232a;
            if (str == null) {
                if (cloudItem.f7232a != null) {
                    return false;
                }
            } else if (!str.equals(cloudItem.f7232a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public List<CloudImage> getCloudImage() {
        return this.f7237f;
    }

    public String getCreatetime() {
        return this.f7234c;
    }

    public HashMap<String, String> getCustomfield() {
        return this.f7236e;
    }

    public int getDistance() {
        return this.f7233b;
    }

    public String getID() {
        return this.f7232a;
    }

    public LatLonPoint getLatLonPoint() {
        return this.mPoint;
    }

    public String getSnippet() {
        return this.mSnippet;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getUpdatetime() {
        return this.f7235d;
    }

    public int hashCode() {
        String str = this.f7232a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setCreatetime(String str) {
        this.f7234c = str;
    }

    public void setCustomfield(HashMap<String, String> hashMap) {
        this.f7236e = hashMap;
    }

    public void setDistance(int i) {
        this.f7233b = i;
    }

    public void setUpdatetime(String str) {
        this.f7235d = str;
    }

    public void setmCloudImage(List<CloudImage> list) {
        this.f7237f = list;
    }

    public String toString() {
        return this.mTitle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7232a);
        parcel.writeInt(this.f7233b);
        parcel.writeValue(this.mPoint);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mSnippet);
        parcel.writeString(this.f7234c);
        parcel.writeString(this.f7235d);
        parcel.writeMap(this.f7236e);
        parcel.writeList(this.f7237f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CloudItem(Parcel parcel) {
        this.f7233b = -1;
        this.f7232a = parcel.readString();
        this.f7233b = parcel.readInt();
        this.mPoint = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.mTitle = parcel.readString();
        this.mSnippet = parcel.readString();
        this.f7234c = parcel.readString();
        this.f7235d = parcel.readString();
        HashMap<String, String> hashMap = new HashMap<>();
        this.f7236e = hashMap;
        parcel.readMap(hashMap, HashMap.class.getClassLoader());
        List arrayList = new ArrayList();
        this.f7237f = arrayList;
        parcel.readList(arrayList, getClass().getClassLoader());
    }
}
