package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.autonavi.base.p048ae.gmap.bean.TileProviderInner;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MVTTileOverlayOptions extends BaseOptions implements Parcelable {
    public static final Parcelable.Creator<MVTTileOverlayOptions> CREATOR = new Parcelable.Creator<MVTTileOverlayOptions>() { // from class: com.amap.api.maps.model.MVTTileOverlayOptions.1
        /* renamed from: a */
        private static MVTTileOverlayOptions m52044a(Parcel parcel) {
            TileProvider tileProvider = (TileProvider) parcel.readValue(TileProvider.class.getClassLoader());
            MVTTileOverlayOptions mVTTileOverlayOptions = new MVTTileOverlayOptions(parcel.readString(), parcel.readString(), parcel.readString());
            if (tileProvider != null) {
                mVTTileOverlayOptions.setTileProvider(tileProvider);
            }
            return mVTTileOverlayOptions;
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MVTTileOverlayOptions createFromParcel(Parcel parcel) {
            return m52044a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MVTTileOverlayOptions[] newArray(int i) {
            return m52045a(i);
        }

        /* renamed from: a */
        private static MVTTileOverlayOptions[] m52045a(int i) {
            return new MVTTileOverlayOptions[i];
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

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class Builder {

        /* renamed from: id */
        private String f7037id;
        private String key;
        private String url;
        private float zIndex = 0.0f;
        private boolean visible = true;

        public MVTTileOverlayOptions build() {
            MVTTileOverlayOptions mVTTileOverlayOptions = new MVTTileOverlayOptions(this.url, this.key, this.f7037id);
            mVTTileOverlayOptions.setZIndex(this.zIndex);
            mVTTileOverlayOptions.setVisible(this.visible);
            return mVTTileOverlayOptions;
        }

        /* renamed from: id */
        public Builder m52043id(String str) {
            this.f7037id = str;
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

        public Builder visible(boolean z) {
            this.visible = z;
            return this;
        }

        public Builder zIndex(float f) {
            this.zIndex = f;
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

    public void setVisible(boolean z) {
        this.visible = z;
    }

    public void setZIndex(float f) {
        this.zIndex = f;
    }

    public boolean visible() {
        return this.visible;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.tileProviderInner);
    }
}
