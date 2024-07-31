package com.bytedance.pangle.fragment;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import androidx.annotation.Keep;
import com.bytedance.pangle.Zeus;

@Keep
@SuppressLint({"NewApi"})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ReportBaseFragment extends Fragment {
    Application.ActivityLifecycleCallbacks callbacks = new C6127c(this);

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(this.callbacks);
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this.callbacks);
    }
}
