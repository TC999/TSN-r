package cn.jiguang.t;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import cn.jiguang.ag.i;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"MissingPermission"})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f3783a;

    /* renamed from: b  reason: collision with root package name */
    private final TelephonyManager f3784b;

    /* renamed from: c  reason: collision with root package name */
    private cn.jiguang.u.a f3785c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3786d;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    private class a extends PhoneStateListener {
        private a() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            cn.jiguang.u.a aVar;
            int networkId;
            try {
                super.onSignalStrengthsChanged(signalStrength);
                b.this.f3785c.f3806f = signalStrength.getGsmSignalStrength();
                CellLocation cellLocation = b.this.f3784b.getCellLocation();
                if (cellLocation == null) {
                    return;
                }
                if (!(cellLocation instanceof GsmCellLocation)) {
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        b.this.f3785c.f3805e = cdmaCellLocation.getBaseStationId();
                        aVar = b.this.f3785c;
                        networkId = cdmaCellLocation.getNetworkId();
                    }
                    b.this.f3784b.listen(this, 0);
                }
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                b.this.f3785c.f3805e = gsmCellLocation.getCid();
                aVar = b.this.f3785c;
                networkId = gsmCellLocation.getLac();
                aVar.f3804d = networkId;
                b.this.f3784b.listen(this, 0);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, boolean z3) {
        this.f3783a = context;
        this.f3786d = z3;
        this.f3784b = (TelephonyManager) context.getSystemService("phone");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn.jiguang.u.a a() {
        return this.f3785c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f3784b == null) {
            cn.jiguang.w.a.f("JLocationCell", "get telephonyManager failed");
            return;
        }
        cn.jiguang.u.a aVar = new cn.jiguang.u.a();
        this.f3785c = aVar;
        aVar.f3801a = cn.jiguang.ah.d.i(this.f3783a);
        String a4 = i.a(this.f3783a, this.f3786d);
        if (a4.length() > 3) {
            this.f3785c.f3802b = Integer.parseInt(a4.substring(0, 3));
            this.f3785c.f3803c = Integer.parseInt(a4.substring(3));
        }
        this.f3785c.f3809i = i.b(this.f3783a, this.f3786d);
        int c4 = i.c(this.f3783a);
        this.f3785c.f3807g = cn.jiguang.ah.d.a(c4);
        this.f3785c.f3808h = cn.jiguang.ah.d.a(this.f3783a, c4);
        if (Build.VERSION.SDK_INT <= 17) {
            this.f3784b.listen(new a(), 256);
            return;
        }
        List<CellInfo> allCellInfo = this.f3784b.getAllCellInfo();
        if (allCellInfo == null || allCellInfo.size() <= 0) {
            return;
        }
        for (CellInfo cellInfo : allCellInfo) {
            if (cellInfo != null) {
                if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellSignalStrengthLte cellSignalStrength = cellInfoLte.getCellSignalStrength();
                    CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
                    this.f3785c.f3806f = cellSignalStrength.getDbm();
                    this.f3785c.f3805e = cellIdentity.getCi();
                    this.f3785c.f3804d = cellIdentity.getTac();
                    if (this.f3785c.f3805e < 268435455) {
                        return;
                    }
                } else if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellSignalStrengthGsm cellSignalStrength2 = cellInfoGsm.getCellSignalStrength();
                    CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                    this.f3785c.f3806f = cellSignalStrength2.getDbm();
                    this.f3785c.f3805e = cellIdentity2.getCid();
                    this.f3785c.f3804d = cellIdentity2.getLac();
                    if (this.f3785c.f3805e < 65535) {
                        return;
                    }
                } else if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellSignalStrengthCdma cellSignalStrength3 = cellInfoCdma.getCellSignalStrength();
                    CellIdentityCdma cellIdentity3 = cellInfoCdma.getCellIdentity();
                    this.f3785c.f3806f = cellSignalStrength3.getDbm();
                    this.f3785c.f3805e = cellIdentity3.getBasestationId();
                    this.f3785c.f3804d = cellIdentity3.getNetworkId();
                    if (this.f3785c.f3805e < 65535) {
                        return;
                    }
                } else if (cellInfo instanceof CellInfoWcdma) {
                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                    CellSignalStrengthWcdma cellSignalStrength4 = cellInfoWcdma.getCellSignalStrength();
                    CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                    this.f3785c.f3806f = cellSignalStrength4.getDbm();
                    this.f3785c.f3805e = cellIdentity4.getCid();
                    this.f3785c.f3804d = cellIdentity4.getLac();
                    if (this.f3785c.f3805e < 268435455) {
                        return;
                    }
                } else {
                    continue;
                }
            }
        }
    }
}
