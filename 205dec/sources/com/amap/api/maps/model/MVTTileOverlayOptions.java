package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class MVTTileOverlayOptions extends BaseOptions implements Parcelable {
    public static final Parcelable.Creator<MVTTileOverlayOptions> CREATOR = new Parcelable.Creator<MVTTileOverlayOptions>() { // from class: com.amap.api.maps.model.MVTTileOverlayOptions.1
        private static MVTTileOverlayOptions a(Parcel parcel) {
            TileProvider tileProvider = (TileProvider) parcel.readValue(TileProvider.class.getClassLoader());
            MVTTileOverlayOptions mVTTileOverlayOptions = new MVTTileOverlayOptions(parcel.readString(), parcel.readString(), parcel.readString());
            if (tileProvider != null) {
                mVTTileOverlayOptions.setTileProvider(tileProvider);
            }
            return mVTTileOverlayOptions;
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MVTTileOverlayOptions createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MVTTileOverlayOptions[] newArray(int i4) {
            return a(i4);
        }

        private static MVTTileOverlayOptions[] a(int i4) {
            return new MVTTileOverlayOptions[i4];
        }
    };
    @JBindingInclude
    private String layerId;
    private TileProvider tileProvider;
    @JBindingInclude
    private TileProviderInner tileProviderInner;
    @JBindingInclude
    private boolean visible;
    @JBindingInclude
    private float zIndex;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Builder {
        private String id;
        private String key;
        private String url;
        private float zIndex = 0.0f;
        private boolean visible = true;

        public MVTTileOverlayOptions build() {
            MVTTileOverlayOptions mVTTileOverlayOptions = new MVTTileOverlayOptions(this.url, this.key, this.id);
            mVTTileOverlayOptions.setZIndex(this.zIndex);
            mVTTileOverlayOptions.setVisible(this.visible);
            return mVTTileOverlayOptions;
        }

        public Builder id(String str) {
            this.id = str;
            return this;
        }

        public Builder key(String str) {
            this.key = str;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder visible(boolean z3) {
            this.visible = z3;
            return this;
        }

        public Builder zIndex(float f4) {
            this.zIndex = f4;
            return this;
        }
    }

    public MVTTileOverlayOptions(String str, String str2, String str3) {
        this.type = "MVTTileOverlayOptions";
        MVTTileProvider mVTTileProvider = new MVTTileProvider(str, str2, str3);
        this.tileProvider = mVTTileProvider;
        this.tileProviderInner = new TileProviderInner(mVTTileProvider);
        this.layerId = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TileProviderInner getTileProviderInner() {
        return this.tileProviderInner;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public void setTileProvider(TileProvider tileProvider) {
        this.tileProvider = tileProvider;
    }

    public void setVisible(boolean z3) {
        this.visible = z3;
    }

    public void setZIndex(float f4) {
        this.zIndex = f4;
    }

    public boolean visible() {
        return this.visible;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeValue(this.tileProviderInner);
    }
}
