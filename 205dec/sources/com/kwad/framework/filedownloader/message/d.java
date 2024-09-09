package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class d extends MessageSnapshot {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a extends b implements com.kwad.framework.filedownloader.message.b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i4, boolean z3, long j4) {
            super(i4, true, j4);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class e extends f {
        /* JADX INFO: Access modifiers changed from: package-private */
        public e(int i4, long j4, long j5) {
            super(i4, j4, j5);
        }

        @Override // com.kwad.framework.filedownloader.message.d.f, com.kwad.framework.filedownloader.message.c
        public final byte tV() {
            return (byte) -2;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class f extends d {
        private final long ahp;
        private final long totalBytes;

        f(f fVar) {
            this(fVar.getId(), fVar.wc(), fVar.wa());
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public byte tV() {
            return (byte) 1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long wa() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long wc() {
            return this.ahp;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeLong(this.ahp);
            parcel.writeLong(this.totalBytes);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(int i4, long j4, long j5) {
            super(i4);
            this.ahp = j4;
            this.totalBytes = j5;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(Parcel parcel) {
            super(parcel);
            this.ahp = parcel.readLong();
            this.totalBytes = parcel.readLong();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class i extends j implements com.kwad.framework.filedownloader.message.b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public i(int i4, long j4, long j5) {
            super(i4, j4, j5);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class j extends f implements MessageSnapshot.a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public j(int i4, long j4, long j5) {
            super(i4, j4, j5);
        }

        @Override // com.kwad.framework.filedownloader.message.d.f, com.kwad.framework.filedownloader.message.c
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

    d(int i4) {
        super(i4);
        this.ahr = true;
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final int vY() {
        if (wc() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) wc();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final int vZ() {
        if (wa() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) wa();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class g extends d {
        private final long ahp;

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(int i4, long j4) {
            super(i4);
            this.ahp = j4;
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
        public final long wc() {
            return this.ahp;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeLong(this.ahp);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(Parcel parcel) {
            super(parcel);
            this.ahp = parcel.readLong();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class h extends C0674d {
        private final int agU;

        /* JADX INFO: Access modifiers changed from: package-private */
        public h(int i4, long j4, Throwable th, int i5) {
            super(i4, j4, th);
            this.agU = i5;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0674d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0674d, com.kwad.framework.filedownloader.message.c
        public final byte tV() {
            return (byte) 5;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int tZ() {
            return this.agU;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0674d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.agU);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public h(Parcel parcel) {
            super(parcel);
            this.agU = parcel.readInt();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b extends d {
        private final boolean ahm;
        private final long totalBytes;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i4, boolean z3, long j4) {
            super(i4);
            this.ahm = z3;
            this.totalBytes = j4;
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
        public final long wa() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean wb() {
            return this.ahm;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeByte(this.ahm ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Parcel parcel) {
            super(parcel);
            this.ahm = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.framework.filedownloader.message.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0674d extends d {
        private final long ahp;
        private final Throwable ahq;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0674d(int i4, long j4, Throwable th) {
            super(i4);
            this.ahp = j4;
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
        public final long wc() {
            return this.ahp;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final Throwable wd() {
            return this.ahq;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeLong(this.ahp);
            parcel.writeSerializable(this.ahq);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0674d(Parcel parcel) {
            super(parcel);
            this.ahp = parcel.readLong();
            this.ahq = (Throwable) parcel.readSerializable();
        }
    }

    d(Parcel parcel) {
        super(parcel);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class c extends d {
        private final String afJ;
        private final boolean ahn;
        private final String aho;
        private final long totalBytes;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i4, boolean z3, long j4, String str, String str2) {
            super(i4);
            this.ahn = z3;
            this.totalBytes = j4;
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
        public final long wa() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeByte(this.ahn ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
            parcel.writeString(this.afJ);
            parcel.writeString(this.aho);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(Parcel parcel) {
            super(parcel);
            this.ahn = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
            this.afJ = parcel.readString();
            this.aho = parcel.readString();
        }
    }
}
