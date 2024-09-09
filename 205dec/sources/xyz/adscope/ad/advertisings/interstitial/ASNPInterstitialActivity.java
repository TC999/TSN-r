package xyz.adscope.ad.advertisings.interstitial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.stub.StubApp;
import xyz.adscope.ad.R;
import xyz.adscope.ad.control.interaction.view.AdTotalView;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ASNPInterstitialActivity extends Activity {
    private AdTotalView adTotalView;
    private RelativeLayout interstitialTotalLayout;

    static {
        StubApp.interface11(40242);
    }

    private void initView() {
        this.interstitialTotalLayout = (RelativeLayout) findViewById(R.id.asnp_interstital_total);
        View interstitialAdView = InterstitialAdViewSingleton.getInstance().getInterstitialAdView();
        if (interstitialAdView instanceof AdTotalView) {
            this.adTotalView = (AdTotalView) interstitialAdView;
        }
        this.interstitialTotalLayout.addView(interstitialAdView);
    }

    @Override // android.app.Activity
    public native void onCreate(@Nullable Bundle bundle);

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.adTotalView = null;
        this.interstitialTotalLayout = null;
        InterstitialAdViewSingleton.getInstance().clear();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
