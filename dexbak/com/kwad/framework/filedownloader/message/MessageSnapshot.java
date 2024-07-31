package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.framework.filedownloader.p353f.C9501f;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class MessageSnapshot implements Parcelable, InterfaceC9520c {
    public static final Parcelable.Creator<MessageSnapshot> CREATOR = new Parcelable.Creator<MessageSnapshot>() { // from class: com.kwad.framework.filedownloader.message.MessageSnapshot.1
        /* JADX WARN: Removed duplicated region for block: B:46:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0097  */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static com.kwad.framework.filedownloader.message.MessageSnapshot m28468a(android.os.Parcel r4) {
            /*
                byte r0 = r4.readByte()
                r1 = 1
                if (r0 != r1) goto L9
                r0 = 1
                goto La
            L9:
                r0 = 0
            La:
                byte r2 = r4.readByte()
                r3 = -4
                if (r2 == r3) goto L84
                r3 = -3
                if (r2 == r3) goto L76
                r3 = -1
                if (r2 == r3) goto L68
                if (r2 == r1) goto L5a
                r1 = 2
                if (r2 == r1) goto L4c
                r1 = 3
                if (r2 == r1) goto L3e
                r1 = 5
                if (r2 == r1) goto L30
                r1 = 6
                if (r2 == r1) goto L28
                r4 = 0
                goto L92
            L28:
                com.kwad.framework.filedownloader.message.MessageSnapshot$b r1 = new com.kwad.framework.filedownloader.message.MessageSnapshot$b
                r1.<init>(r4)
            L2d:
                r4 = r1
                goto L92
            L30:
                if (r0 == 0) goto L38
                com.kwad.framework.filedownloader.message.d$h r1 = new com.kwad.framework.filedownloader.message.d$h
                r1.<init>(r4)
                goto L2d
            L38:
                com.kwad.framework.filedownloader.message.h$h r1 = new com.kwad.framework.filedownloader.message.h$h
                r1.<init>(r4)
                goto L2d
            L3e:
                if (r0 == 0) goto L46
                com.kwad.framework.filedownloader.message.d$g r1 = new com.kwad.framework.filedownloader.message.d$g
                r1.<init>(r4)
                goto L2d
            L46:
                com.kwad.framework.filedownloader.message.h$g r1 = new com.kwad.framework.filedownloader.message.h$g
                r1.<init>(r4)
                goto L2d
            L4c:
                if (r0 == 0) goto L54
                com.kwad.framework.filedownloader.message.d$c r1 = new com.kwad.framework.filedownloader.message.d$c
                r1.<init>(r4)
                goto L2d
            L54:
                com.kwad.framework.filedownloader.message.h$c r1 = new com.kwad.framework.filedownloader.message.h$c
                r1.<init>(r4)
                goto L2d
            L5a:
                if (r0 == 0) goto L62
                com.kwad.framework.filedownloader.message.d$f r1 = new com.kwad.framework.filedownloader.message.d$f
                r1.<init>(r4)
                goto L2d
            L62:
                com.kwad.framework.filedownloader.message.h$f r1 = new com.kwad.framework.filedownloader.message.h$f
                r1.<init>(r4)
                goto L2d
            L68:
                if (r0 == 0) goto L70
                com.kwad.framework.filedownloader.message.d$d r1 = new com.kwad.framework.filedownloader.message.d$d
                r1.<init>(r4)
                goto L2d
            L70:
                com.kwad.framework.filedownloader.message.h$d r1 = new com.kwad.framework.filedownloader.message.h$d
                r1.<init>(r4)
                goto L2d
            L76:
                if (r0 == 0) goto L7e
                com.kwad.framework.filedownloader.message.d$b r1 = new com.kwad.framework.filedownloader.message.d$b
                r1.<init>(r4)
                goto L2d
            L7e:
                com.kwad.framework.filedownloader.message.h$b r1 = new com.kwad.framework.filedownloader.message.h$b
                r1.<init>(r4)
                goto L2d
            L84:
                if (r0 == 0) goto L8c
                com.kwad.framework.filedownloader.message.d$j r1 = new com.kwad.framework.filedownloader.message.d$j
                r1.<init>(r4)
                goto L2d
            L8c:
                com.kwad.framework.filedownloader.message.h$j r1 = new com.kwad.framework.filedownloader.message.h$j
                r1.<init>(r4)
                goto L2d
            L92:
                if (r4 == 0) goto L97
                r4.ahr = r0
                return r4
            L97:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "Can't restore the snapshot because unknown status: "
                r0.<init>(r1)
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                r4.<init>(r0)
                goto Lac
            Lab:
                throw r4
            Lac:
                goto Lab
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.message.MessageSnapshot.C95141.m28468a(android.os.Parcel):com.kwad.framework.filedownloader.message.MessageSnapshot");
        }

        /* renamed from: bA */
        private static MessageSnapshot[] m28467bA(int i) {
            return new MessageSnapshot[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MessageSnapshot createFromParcel(Parcel parcel) {
            return m28468a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MessageSnapshot[] newArray(int i) {
            return m28467bA(i);
        }
    };
    protected boolean ahr;

    /* renamed from: id */
    private final int f29486id;

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class NoFieldException extends IllegalStateException {
        NoFieldException(String str, MessageSnapshot messageSnapshot) {
            super(C9501f.m28515b("There isn't a field for '%s' in this message %d %d %s", str, Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.mo28442tV()), messageSnapshot.getClass().getName()));
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.MessageSnapshot$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9515a {
        /* renamed from: we */
        MessageSnapshot mo28441we();
    }

    /* renamed from: com.kwad.framework.filedownloader.message.MessageSnapshot$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9516b extends MessageSnapshot {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C9516b(int i) {
            super(i);
        }

        @Override // com.kwad.framework.filedownloader.message.InterfaceC9520c
        /* renamed from: tV */
        public final byte mo28442tV() {
            return (byte) 6;
        }

        C9516b(Parcel parcel) {
            super(parcel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageSnapshot(int i) {
        this.f29486id = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getEtag() {
        throw new NoFieldException("getEtag", this);
    }

    public String getFileName() {
        throw new NoFieldException("getFileName", this);
    }

    public final int getId() {
        return this.f29486id;
    }

    /* renamed from: tZ */
    public int mo28443tZ() {
        throw new NoFieldException("getRetryingTimes", this);
    }

    /* renamed from: ub */
    public final boolean m28469ub() {
        return this.ahr;
    }

    /* renamed from: vQ */
    public boolean mo28447vQ() {
        throw new NoFieldException("isResuming", this);
    }

    /* renamed from: vY */
    public int mo28444vY() {
        throw new NoFieldException("getSmallSofarBytes", this);
    }

    /* renamed from: vZ */
    public int mo28445vZ() {
        throw new NoFieldException("getSmallTotalBytes", this);
    }

    /* renamed from: wa */
    public long mo28450wa() {
        throw new NoFieldException("getLargeTotalBytes", this);
    }

    /* renamed from: wb */
    public boolean mo28448wb() {
        throw new NoFieldException("isReusedDownloadedFile", this);
    }

    /* renamed from: wc */
    public long mo28449wc() {
        throw new NoFieldException("getLargeSofarBytes", this);
    }

    /* renamed from: wd */
    public Throwable mo28446wd() {
        throw new NoFieldException("getThrowable", this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.ahr ? (byte) 1 : (byte) 0);
        parcel.writeByte(mo28442tV());
        parcel.writeInt(this.f29486id);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageSnapshot(Parcel parcel) {
        this.f29486id = parcel.readInt();
    }
}
