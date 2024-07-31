package com.bxkj.student.run.app.ready;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RunRoleSetBean implements Parcelable {
    public static final Parcelable.Creator<RunRoleSetBean> CREATOR = new Parcelable.Creator<RunRoleSetBean>() { // from class: com.bxkj.student.run.app.ready.RunRoleSetBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RunRoleSetBean createFromParcel(Parcel source) {
            return new RunRoleSetBean(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RunRoleSetBean[] newArray(int size) {
            return new RunRoleSetBean[size];
        }
    };
    private DataBean data;
    private String returnCode;
    private String returnMsg;

    public RunRoleSetBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DataBean getData() {
        return this.data;
    }

    public String getReturnCode() {
        return this.returnCode;
    }

    public Object getReturnMsg() {
        return this.returnMsg;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.data, flags);
        dest.writeString(this.returnCode);
    }

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class DataBean implements Parcelable {
        public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() { // from class: com.bxkj.student.run.app.ready.RunRoleSetBean.DataBean.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
        private String context;
        private double faceDistanceOut;
        private int faceTimeout;
        private List<List<GeofenceBean>> geofence;
        private String identify;
        private int isClock;
        private int isEndFace;
        private int isQuestion;
        private int isStartFace;
        private List<ListBean> list;
        private List<Double> middleFaces;
        private int pattern;
        private int runType;
        private int surplusNum;
        private double totalRange;

        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static class GeofenceBean implements Parcelable {
            public static final Parcelable.Creator<GeofenceBean> CREATOR = new Parcelable.Creator<GeofenceBean>() { // from class: com.bxkj.student.run.app.ready.RunRoleSetBean.DataBean.GeofenceBean.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public GeofenceBean createFromParcel(Parcel source) {
                    return new GeofenceBean(source);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public GeofenceBean[] newArray(int size) {
                    return new GeofenceBean[size];
                }
            };
            private String lat;
            private String lng;

            public GeofenceBean() {
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String getLat() {
                return this.lat;
            }

            public String getLng() {
                return this.lng;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.lng);
                dest.writeString(this.lat);
            }

            protected GeofenceBean(Parcel in) {
                this.lng = in.readString();
                this.lat = in.readString();
            }
        }

        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static class ListBean implements Parcelable {
            public static final Parcelable.Creator<ListBean> CREATOR = new Parcelable.Creator<ListBean>() { // from class: com.bxkj.student.run.app.ready.RunRoleSetBean.DataBean.ListBean.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public ListBean createFromParcel(Parcel source) {
                    return new ListBean(source);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public ListBean[] newArray(int size) {
                    return new ListBean[size];
                }
            };
            private String content;

            /* renamed from: id */
            private int f19263id;
            private int isMustPoint;
            private String latitude;
            private String longitude;
            private int okRadius;

            public ListBean() {
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String getContent() {
                return this.content;
            }

            public int getId() {
                return this.f19263id;
            }

            public int getIsMustPoint() {
                return this.isMustPoint;
            }

            public String getLatitude() {
                return this.latitude;
            }

            public String getLongitude() {
                return this.longitude;
            }

            public int getOkRadius() {
                return this.okRadius;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public void setId(int id) {
                this.f19263id = id;
            }

            public void setIsMustPoint(int isMustPoint) {
                this.isMustPoint = isMustPoint;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public void setOkRadius(int okRadius) {
                this.okRadius = okRadius;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.f19263id);
                dest.writeString(this.latitude);
                dest.writeString(this.longitude);
                dest.writeString(this.content);
                dest.writeInt(this.okRadius);
                dest.writeInt(this.isMustPoint);
            }

            protected ListBean(Parcel in) {
                this.f19263id = in.readInt();
                this.latitude = in.readString();
                this.longitude = in.readString();
                this.content = in.readString();
                this.okRadius = in.readInt();
                this.isMustPoint = in.readInt();
            }
        }

        public DataBean() {
            this.isQuestion = 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getContext() {
            return this.context;
        }

        public double getFaceDistanceOut() {
            return this.faceDistanceOut;
        }

        public int getFaceTimeout() {
            return this.faceTimeout;
        }

        public List<List<GeofenceBean>> getGeofence() {
            return this.geofence;
        }

        public String getIdentify() {
            return this.identify;
        }

        public int getIsClock() {
            return this.isClock;
        }

        public int getIsEndFace() {
            return this.isEndFace;
        }

        public int getIsQuestion() {
            return this.isQuestion;
        }

        public int getIsStartFace() {
            return this.isStartFace;
        }

        public List<ListBean> getList() {
            return this.list;
        }

        public List<Double> getMiddleFaces() {
            return this.middleFaces;
        }

        public int getPattern() {
            return this.pattern;
        }

        public int getRunType() {
            return this.runType;
        }

        public int getSurplusNum() {
            return this.surplusNum;
        }

        public double getTotalRange() {
            return this.totalRange;
        }

        public void setContext(String context) {
            this.context = context;
        }

        public void setFaceDistanceOut(double faceDistanceOut) {
            this.faceDistanceOut = faceDistanceOut;
        }

        public void setFaceTimeout(int faceTimeout) {
            this.faceTimeout = faceTimeout;
        }

        public void setGeofence(List<List<GeofenceBean>> geofence) {
            this.geofence = geofence;
        }

        public void setIdentify(String identify) {
            this.identify = identify;
        }

        public void setIsClock(int isClock) {
            this.isClock = isClock;
        }

        public void setIsEndFace(int isEndFace) {
            this.isEndFace = isEndFace;
        }

        public DataBean setIsQuestion(int isQuestion) {
            this.isQuestion = isQuestion;
            return this;
        }

        public void setIsStartFace(int isStartFace) {
            this.isStartFace = isStartFace;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public void setMiddleFaces(List<Double> middleFaces) {
            this.middleFaces = middleFaces;
        }

        public void setPattern(int pattern) {
            this.pattern = pattern;
        }

        public void setRunType(int runType) {
            this.runType = runType;
        }

        public void setSurplusNum(int surplusNum) {
            this.surplusNum = surplusNum;
        }

        public void setTotalRange(double totalRange) {
            this.totalRange = totalRange;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.runType);
            dest.writeInt(this.isStartFace);
            dest.writeInt(this.isEndFace);
            dest.writeInt(this.isQuestion);
            dest.writeInt(this.isClock);
            dest.writeDouble(this.totalRange);
            dest.writeString(this.identify);
            dest.writeInt(this.faceTimeout);
            dest.writeDouble(this.faceDistanceOut);
            dest.writeInt(this.pattern);
            dest.writeString(this.context);
            dest.writeInt(this.surplusNum);
            dest.writeList(this.middleFaces);
            dest.writeList(this.list);
            dest.writeList(this.geofence);
        }

        protected DataBean(Parcel in) {
            this.isQuestion = 0;
            this.runType = in.readInt();
            this.isStartFace = in.readInt();
            this.isEndFace = in.readInt();
            this.isQuestion = in.readInt();
            this.isClock = in.readInt();
            this.totalRange = in.readDouble();
            this.identify = in.readString();
            this.faceTimeout = in.readInt();
            this.faceDistanceOut = in.readDouble();
            this.pattern = in.readInt();
            this.context = in.readString();
            this.surplusNum = in.readInt();
            ArrayList arrayList = new ArrayList();
            this.middleFaces = arrayList;
            in.readList(arrayList, Double.class.getClassLoader());
            ArrayList arrayList2 = new ArrayList();
            this.list = arrayList2;
            in.readList(arrayList2, ListBean.class.getClassLoader());
            ArrayList arrayList3 = new ArrayList();
            this.geofence = arrayList3;
            in.readList(arrayList3, GeofenceBean.class.getClassLoader());
        }
    }

    protected RunRoleSetBean(Parcel in) {
        this.data = (DataBean) in.readParcelable(DataBean.class.getClassLoader());
        this.returnCode = in.readString();
        this.returnMsg = (String) in.readParcelable(Object.class.getClassLoader());
    }
}
