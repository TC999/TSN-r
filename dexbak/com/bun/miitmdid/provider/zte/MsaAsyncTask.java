package com.bun.miitmdid.provider.zte;

import android.os.AsyncTask;
import com.bun.lib.MsaIdInterface;
import com.netease.nis.sdkwrapper.Utils;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MsaAsyncTask extends AsyncTask<Void, Void, Boolean> {
    public MsaServiceConnection _conn;
    public MsaIdInterface msaIdInterface;

    public MsaAsyncTask(MsaIdInterface msaIdInterface, MsaServiceConnection msaServiceConnection) {
        this.msaIdInterface = msaIdInterface;
        this._conn = msaServiceConnection;
    }

    /* renamed from: doInBackground  reason: avoid collision after fix types in other method */
    public Boolean doInBackground2(Void... voidArr) {
        return (Boolean) Utils.m20485rL(new Object[]{this, voidArr, 108, 1606976968580L});
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Boolean, java.lang.Object] */
    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ Boolean doInBackground(Void[] voidArr) {
        return Utils.m20485rL(new Object[]{this, voidArr, 109, 1606976968581L});
    }

    /* renamed from: onPostExecute  reason: avoid collision after fix types in other method */
    public void onPostExecute2(Boolean bool) {
        Utils.m20485rL(new Object[]{this, bool, 110, 1606976968582L});
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(Boolean bool) {
        Utils.m20485rL(new Object[]{this, bool, 111, 1606976968583L});
    }
}
