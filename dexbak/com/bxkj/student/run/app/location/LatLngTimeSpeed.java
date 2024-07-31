package com.bxkj.student.run.app.location;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LatLngTimeSpeed implements Parcelable {
    public static final Parcelable.Creator<LatLngTimeSpeed> CREATOR = new Parcelable.Creator<LatLngTimeSpeed>() { // from class: com.bxkj.student.run.app.location.LatLngTimeSpeed.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LatLngTimeSpeed createFromParcel(Parcel source) {
            return new LatLngTimeSpeed(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LatLngTimeSpeed[] newArray(int size) {
            return new LatLngTimeSpeed[size];
        }
    };
    private long countTime;
    private boolean isPuase;
    private double latitude;
    private int locationType;
    private double longitude;
    private float speed;
    private long time;

    public LatLngTimeSpeed() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getCountTime() {
        return this.countTime;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public int getLocationType() {
        return this.locationType;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public float getSpeed() {
        return this.speed;
    }

    public long getTime() {
        return this.time;
    }

    public boolean isPuase() {
        return this.isPuase;
    }

    public LatLngTimeSpeed setCountTime(long countTime) {
        this.countTime = countTime;
        return this;
    }

    public LatLngTimeSpeed setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public void setLocationType(int locationType) {
        this.locationType = locationType;
    }

    public LatLngTimeSpeed setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    public LatLngTimeSpeed setPuase(boolean puase) {
        this.isPuase = puase;
        return this;
    }

    public LatLngTimeSpeed setSpeed(float speed) {
        this.speed = speed;
        return this;
    }

    public LatLngTimeSpeed setTime(long time) {
        this.time = time;
        return this;
    }

    public String toString() {
        return "LatLngTimeSpeed{latitude=" + this.latitude + ", longitude=" + this.longitude + ", time=" + this.time + ", speed=" + this.speed + ", isPuase=" + this.isPuase + ", locationType=" + this.locationType + ", countTime=" + this.countTime + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
        dest.writeLong(this.time);
        dest.writeLong(this.countTime);
        dest.writeFloat(this.speed);
        dest.writeInt(this.locationType);
        dest.writeByte(this.isPuase ? (byte) 1 : (byte) 0);
    }

    public LatLngTimeSpeed(double latitude, double longitude, long time, float speed, boolean isPuase, int locationType, long countTime) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
        this.speed = speed;
        this.isPuase = isPuase;
        this.locationType = locationType;
        this.countTime = countTime;
    }

    public LatLngTimeSpeed(double latitude, double longitude, long time, float speed, boolean isPuase, int locationType) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
        this.speed = speed;
        this.isPuase = isPuase;
        this.locationType = locationType;
    }

    protected LatLngTimeSpeed(Parcel in) {
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
        this.time = in.readLong();
        this.countTime = in.readLong();
        this.speed = in.readFloat();
        this.locationType = in.readInt();
        this.isPuase = in.readByte() != 0;
    }
}
