package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* renamed from: com.kwad.framework.filedownloader.message.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC9539h extends MessageSnapshot {

    /* renamed from: com.kwad.framework.filedownloader.message.h$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9540a extends C9541b implements InterfaceC9519b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C9540a(int i, boolean z, int i2) {
            super(i, true, i2);
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.h$e */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9544e extends C9545f {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C9544e(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        @Override // com.kwad.framework.filedownloader.message.AbstractC9539h.C9545f, com.kwad.framework.filedownloader.message.InterfaceC9520c
        /* renamed from: tV */
        public final byte mo28442tV() {
            return (byte) -2;
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.h$f */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9545f extends AbstractC9539h {
        private final int ahB;
        private final int ahC;

        C9545f(C9545f c9545f) {
            this(c9545f.getId(), c9545f.mo28444vY(), c9545f.mo28445vZ());
        }

        /* renamed from: tV */
        public byte mo28442tV() {
            return (byte) 1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        /* renamed from: vY */
        public final int mo28444vY() {
            return this.ahC;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        /* renamed from: vZ */
        public final int mo28445vZ() {
            return this.ahB;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ahC);
            parcel.writeInt(this.ahB);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9545f(int i, int i2, int i3) {
            super(i);
            this.ahC = i2;
            this.ahB = i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9545f(Parcel parcel) {
            super(parcel);
            this.ahC = parcel.readInt();
            this.ahB = parcel.readInt();
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.h$i */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9548i extends C9549j implements InterfaceC9519b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C9548i(int i, int i2, int i3) {
            super(i, i2, i3);
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.h$j */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9549j extends C9545f implements MessageSnapshot.InterfaceC9515a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C9549j(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        @Override // com.kwad.framework.filedownloader.message.AbstractC9539h.C9545f, com.kwad.framework.filedownloader.message.InterfaceC9520c
        /* renamed from: tV */
        public final byte mo28442tV() {
            return (byte) -4;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot.InterfaceC9515a
        /* renamed from: we */
        public final MessageSnapshot mo28441we() {
            return new C9545f(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9549j(Parcel parcel) {
            super(parcel);
        }
    }

    AbstractC9539h(int i) {
        super(i);
        this.ahr = false;
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    /* renamed from: wa */
    public final long mo28450wa() {
        return mo28445vZ();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    /* renamed from: wc */
    public final long mo28449wc() {
        return mo28444vY();
    }

    /* renamed from: com.kwad.framework.filedownloader.message.h$g */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9546g extends AbstractC9539h {
        private final int ahC;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9546g(int i, int i2) {
            super(i);
            this.ahC = i2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.InterfaceC9520c
        /* renamed from: tV */
        public final byte mo28442tV() {
            return (byte) 3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        /* renamed from: vY */
        public final int mo28444vY() {
            return this.ahC;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ahC);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9546g(Parcel parcel) {
            super(parcel);
            this.ahC = parcel.readInt();
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.h$h */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9547h extends C9543d {
        private final int agU;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9547h(int i, int i2, Throwable th, int i3) {
            super(i, i2, th);
            this.agU = i3;
        }

        @Override // com.kwad.framework.filedownloader.message.AbstractC9539h.C9543d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.AbstractC9539h.C9543d, com.kwad.framework.filedownloader.message.InterfaceC9520c
        /* renamed from: tV */
        public final byte mo28442tV() {
            return (byte) 5;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        /* renamed from: tZ */
        public final int mo28443tZ() {
            return this.agU;
        }

        @Override // com.kwad.framework.filedownloader.message.AbstractC9539h.C9543d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.agU);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9547h(Parcel parcel) {
            super(parcel);
            this.agU = parcel.readInt();
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.h$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9541b extends AbstractC9539h {
        private final int ahB;
        private final boolean ahm;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9541b(int i, boolean z, int i2) {
            super(i);
            this.ahm = z;
            this.ahB = i2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.InterfaceC9520c
        /* renamed from: tV */
        public final byte mo28442tV() {
            return (byte) -3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        /* renamed from: vZ */
        public final int mo28445vZ() {
            return this.ahB;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        /* renamed from: wb */
        public final boolean mo28448wb() {
            return this.ahm;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.ahm ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.ahB);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9541b(Parcel parcel) {
            super(parcel);
            this.ahm = parcel.readByte() != 0;
            this.ahB = parcel.readInt();
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.h$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9543d extends AbstractC9539h {
        private final int ahC;
        private final Throwable ahq;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9543d(int i, int i2, Throwable th) {
            super(i);
            this.ahC = i2;
            this.ahq = th;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.InterfaceC9520c
        /* renamed from: tV */
        public byte mo28442tV() {
            return (byte) -1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        /* renamed from: vY */
        public final int mo28444vY() {
            return this.ahC;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        /* renamed from: wd */
        public final Throwable mo28446wd() {
            return this.ahq;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ahC);
            parcel.writeSerializable(this.ahq);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9543d(Parcel parcel) {
            super(parcel);
            this.ahC = parcel.readInt();
            this.ahq = (Throwable) parcel.readSerializable();
        }
    }

    AbstractC9539h(Parcel parcel) {
        super(parcel);
    }

    /* renamed from: com.kwad.framework.filedownloader.message.h$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9542c extends AbstractC9539h {
        private final String afJ;
        private final int ahB;
        private final boolean ahn;
        private final String aho;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9542c(int i, boolean z, int i2, String str, String str2) {
            super(i);
            this.ahn = z;
            this.ahB = i2;
            this.afJ = str;
            this.aho = str2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getEtag() {
            return this.afJ;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getFileName() {
            return this.aho;
        }

        @Override // com.kwad.framework.filedownloader.message.InterfaceC9520c
        /* renamed from: tV */
        public final byte mo28442tV() {
            return (byte) 2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        /* renamed from: vQ */
        public final boolean mo28447vQ() {
            return this.ahn;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        /* renamed from: vZ */
        public final int mo28445vZ() {
            return this.ahB;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.ahn ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.ahB);
            parcel.writeString(this.afJ);
            parcel.writeString(this.aho);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9542c(Parcel parcel) {
            super(parcel);
            this.ahn = parcel.readByte() != 0;
            this.ahB = parcel.readInt();
            this.afJ = parcel.readString();
            this.aho = parcel.readString();
        }
    }
}
