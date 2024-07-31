package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* renamed from: com.kwad.framework.filedownloader.message.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC9521d extends MessageSnapshot {

    /* renamed from: com.kwad.framework.filedownloader.message.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9522a extends C9523b implements InterfaceC9519b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C9522a(int i, boolean z, long j) {
            super(i, true, j);
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.d$e */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9526e extends C9527f {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C9526e(int i, long j, long j2) {
            super(i, j, j2);
        }

        @Override // com.kwad.framework.filedownloader.message.AbstractC9521d.C9527f, com.kwad.framework.filedownloader.message.InterfaceC9520c
        /* renamed from: tV */
        public final byte mo28442tV() {
            return (byte) -2;
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.d$f */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9527f extends AbstractC9521d {
        private final long ahp;
        private final long totalBytes;

        C9527f(C9527f c9527f) {
            this(c9527f.getId(), c9527f.mo28449wc(), c9527f.mo28450wa());
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* renamed from: tV */
        public byte mo28442tV() {
            return (byte) 1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        /* renamed from: wa */
        public final long mo28450wa() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        /* renamed from: wc */
        public final long mo28449wc() {
            return this.ahp;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.ahp);
            parcel.writeLong(this.totalBytes);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9527f(int i, long j, long j2) {
            super(i);
            this.ahp = j;
            this.totalBytes = j2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9527f(Parcel parcel) {
            super(parcel);
            this.ahp = parcel.readLong();
            this.totalBytes = parcel.readLong();
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.d$i */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9530i extends C9531j implements InterfaceC9519b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C9530i(int i, long j, long j2) {
            super(i, j, j2);
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.d$j */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9531j extends C9527f implements MessageSnapshot.InterfaceC9515a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C9531j(int i, long j, long j2) {
            super(i, j, j2);
        }

        @Override // com.kwad.framework.filedownloader.message.AbstractC9521d.C9527f, com.kwad.framework.filedownloader.message.InterfaceC9520c
        /* renamed from: tV */
        public final byte mo28442tV() {
            return (byte) -4;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot.InterfaceC9515a
        /* renamed from: we */
        public final MessageSnapshot mo28441we() {
            return new C9527f(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9531j(Parcel parcel) {
            super(parcel);
        }
    }

    AbstractC9521d(int i) {
        super(i);
        this.ahr = true;
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    /* renamed from: vY */
    public final int mo28444vY() {
        if (mo28449wc() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) mo28449wc();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    /* renamed from: vZ */
    public final int mo28445vZ() {
        if (mo28450wa() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) mo28450wa();
    }

    /* renamed from: com.kwad.framework.filedownloader.message.d$g */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9528g extends AbstractC9521d {
        private final long ahp;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9528g(int i, long j) {
            super(i);
            this.ahp = j;
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
        /* renamed from: wc */
        public final long mo28449wc() {
            return this.ahp;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.ahp);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9528g(Parcel parcel) {
            super(parcel);
            this.ahp = parcel.readLong();
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.d$h */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9529h extends C9525d {
        private final int agU;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9529h(int i, long j, Throwable th, int i2) {
            super(i, j, th);
            this.agU = i2;
        }

        @Override // com.kwad.framework.filedownloader.message.AbstractC9521d.C9525d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.AbstractC9521d.C9525d, com.kwad.framework.filedownloader.message.InterfaceC9520c
        /* renamed from: tV */
        public final byte mo28442tV() {
            return (byte) 5;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        /* renamed from: tZ */
        public final int mo28443tZ() {
            return this.agU;
        }

        @Override // com.kwad.framework.filedownloader.message.AbstractC9521d.C9525d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.agU);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9529h(Parcel parcel) {
            super(parcel);
            this.agU = parcel.readInt();
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.d$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9523b extends AbstractC9521d {
        private final boolean ahm;
        private final long totalBytes;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9523b(int i, boolean z, long j) {
            super(i);
            this.ahm = z;
            this.totalBytes = j;
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
        /* renamed from: wa */
        public final long mo28450wa() {
            return this.totalBytes;
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
            parcel.writeLong(this.totalBytes);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9523b(Parcel parcel) {
            super(parcel);
            this.ahm = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.d$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9525d extends AbstractC9521d {
        private final long ahp;
        private final Throwable ahq;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9525d(int i, long j, Throwable th) {
            super(i);
            this.ahp = j;
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
        /* renamed from: wc */
        public final long mo28449wc() {
            return this.ahp;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        /* renamed from: wd */
        public final Throwable mo28446wd() {
            return this.ahq;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.ahp);
            parcel.writeSerializable(this.ahq);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9525d(Parcel parcel) {
            super(parcel);
            this.ahp = parcel.readLong();
            this.ahq = (Throwable) parcel.readSerializable();
        }
    }

    AbstractC9521d(Parcel parcel) {
        super(parcel);
    }

    /* renamed from: com.kwad.framework.filedownloader.message.d$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9524c extends AbstractC9521d {
        private final String afJ;
        private final boolean ahn;
        private final String aho;
        private final long totalBytes;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9524c(int i, boolean z, long j, String str, String str2) {
            super(i);
            this.ahn = z;
            this.totalBytes = j;
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
        /* renamed from: wa */
        public final long mo28450wa() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.ahn ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
            parcel.writeString(this.afJ);
            parcel.writeString(this.aho);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C9524c(Parcel parcel) {
            super(parcel);
            this.ahn = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
            this.afJ = parcel.readString();
            this.aho = parcel.readString();
        }
    }
}
