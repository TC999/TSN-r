package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class h extends MessageSnapshot {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a extends b implements com.kwad.framework.filedownloader.message.b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i4, boolean z3, int i5) {
            super(i4, true, i5);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class e extends f {
        /* JADX INFO: Access modifiers changed from: package-private */
        public e(int i4, int i5, int i6) {
            super(i4, i5, i6);
        }

        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
        public final byte tV() {
            return (byte) -2;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class f extends h {
        private final int ahB;
        private final int ahC;

        f(f fVar) {
            this(fVar.getId(), fVar.vY(), fVar.vZ());
        }

        public byte tV() {
            return (byte) 1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int vY() {
            return this.ahC;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int vZ() {
            return this.ahB;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.ahC);
            parcel.writeInt(this.ahB);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(int i4, int i5, int i6) {
            super(i4);
            this.ahC = i5;
            this.ahB = i6;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(Parcel parcel) {
            super(parcel);
            this.ahC = parcel.readInt();
            this.ahB = parcel.readInt();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class i extends j implements com.kwad.framework.filedownloader.message.b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public i(int i4, int i5, int i6) {
            super(i4, i5, i6);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class j extends f implements MessageSnapshot.a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public j(int i4, int i5, int i6) {
            super(i4, i5, i6);
        }

        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
        public final byte tV() {
            return (byte) -4;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot.a
        public final MessageSnapshot we() {
            return new f(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(Parcel parcel) {
            super(parcel);
        }
    }

    h(int i4) {
        super(i4);
        this.ahr = false;
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long wa() {
        return vZ();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long wc() {
        return vY();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class g extends h {
        private final int ahC;

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(int i4, int i5) {
            super(i4);
            this.ahC = i5;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte tV() {
            return (byte) 3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int vY() {
            return this.ahC;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.ahC);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(Parcel parcel) {
            super(parcel);
            this.ahC = parcel.readInt();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.framework.filedownloader.message.h$h  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0675h extends d {
        private final int agU;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0675h(int i4, int i5, Throwable th, int i6) {
            super(i4, i5, th);
            this.agU = i6;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.c
        public final byte tV() {
            return (byte) 5;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int tZ() {
            return this.agU;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.agU);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0675h(Parcel parcel) {
            super(parcel);
            this.agU = parcel.readInt();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b extends h {
        private final int ahB;
        private final boolean ahm;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i4, boolean z3, int i5) {
            super(i4);
            this.ahm = z3;
            this.ahB = i5;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte tV() {
            return (byte) -3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int vZ() {
            return this.ahB;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean wb() {
            return this.ahm;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeByte(this.ahm ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.ahB);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Parcel parcel) {
            super(parcel);
            this.ahm = parcel.readByte() != 0;
            this.ahB = parcel.readInt();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class d extends h {
        private final int ahC;
        private final Throwable ahq;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(int i4, int i5, Throwable th) {
            super(i4);
            this.ahC = i5;
            this.ahq = th;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public byte tV() {
            return (byte) -1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int vY() {
            return this.ahC;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final Throwable wd() {
            return this.ahq;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.ahC);
            parcel.writeSerializable(this.ahq);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(Parcel parcel) {
            super(parcel);
            this.ahC = parcel.readInt();
            this.ahq = (Throwable) parcel.readSerializable();
        }
    }

    h(Parcel parcel) {
        super(parcel);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class c extends h {
        private final String afJ;
        private final int ahB;
        private final boolean ahn;
        private final String aho;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i4, boolean z3, int i5, String str, String str2) {
            super(i4);
            this.ahn = z3;
            this.ahB = i5;
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

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte tV() {
            return (byte) 2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean vQ() {
            return this.ahn;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int vZ() {
            return this.ahB;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeByte(this.ahn ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.ahB);
            parcel.writeString(this.afJ);
            parcel.writeString(this.aho);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(Parcel parcel) {
            super(parcel);
            this.ahn = parcel.readByte() != 0;
            this.ahB = parcel.readInt();
            this.afJ = parcel.readString();
            this.aho = parcel.readString();
        }
    }
}
