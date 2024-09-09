package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CloudItem implements Parcelable {
    public static final Parcelable.Creator<CloudItem> CREATOR = new Parcelable.Creator<CloudItem>() { // from class: com.amap.api.services.cloud.CloudItem.1
        private static CloudItem a(Parcel parcel) {
            return new CloudItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudItem[] newArray(int i4) {
            return a(i4);
        }

        private static CloudItem[] a(int i4) {
            return new CloudItem[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f10928a;

    /* renamed from: b  reason: collision with root package name */
    private int f10929b;

    /* renamed from: c  reason: collision with root package name */
    private String f10930c;

    /* renamed from: d  reason: collision with root package name */
    private String f10931d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, String> f10932e;

    /* renamed from: f  reason: collision with root package name */
    private List<CloudImage> f10933f;
    protected final LatLonPoint mPoint;
    protected final String mSnippet;
    protected final String mTitle;

    public CloudItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f10929b = -1;
        this.f10928a = str;
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
            String str = this.f10928a;
            if (str == null) {
                if (cloudItem.f10928a != null) {
                    return false;
                }
            } else if (!str.equals(cloudItem.f10928a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public List<CloudImage> getCloudImage() {
        return this.f10933f;
    }

    public String getCreatetime() {
        return this.f10930c;
    }

    public HashMap<String, String> getCustomfield() {
        return this.f10932e;
    }

    public int getDistance() {
        return this.f10929b;
    }

    public String getID() {
        return this.f10928a;
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
        return this.f10931d;
    }

    public int hashCode() {
        String str = this.f10928a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setCreatetime(String str) {
        this.f10930c = str;
    }

    public void setCustomfield(HashMap<String, String> hashMap) {
        this.f10932e = hashMap;
    }

    public void setDistance(int i4) {
        this.f10929b = i4;
    }

    public void setUpdatetime(String str) {
        this.f10931d = str;
    }

    public void setmCloudImage(List<CloudImage> list) {
        this.f10933f = list;
    }

    public String toString() {
        return this.mTitle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f10928a);
        parcel.writeInt(this.f10929b);
        parcel.writeValue(this.mPoint);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mSnippet);
        parcel.writeString(this.f10930c);
        parcel.writeString(this.f10931d);
        parcel.writeMap(this.f10932e);
        parcel.writeList(this.f10933f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CloudItem(Parcel parcel) {
        this.f10929b = -1;
        this.f10928a = parcel.readString();
        this.f10929b = parcel.readInt();
        this.mPoint = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.mTitle = parcel.readString();
        this.mSnippet = parcel.readString();
        this.f10930c = parcel.readString();
        this.f10931d = parcel.readString();
        HashMap<String, String> hashMap = new HashMap<>();
        this.f10932e = hashMap;
        parcel.readMap(hashMap, HashMap.class.getClassLoader());
        List arrayList = new ArrayList();
        this.f10933f = arrayList;
        parcel.readList(arrayList, getClass().getClassLoader());
    }
}
