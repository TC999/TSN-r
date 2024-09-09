package xyz.adscope.ad.control.action.webview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.stub.StubApp;
import java.util.HashMap;
import xyz.adscope.ad.R;
import xyz.adscope.ad.control.render.util.UIAdapterUtil;
import xyz.adscope.ad.tool.widget.AdscopeWebView;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class WebViewActivity extends Activity {
    private static final String TAG = "WebViewActivity_";
    public static final String URL_KEY = "url";
    private RelativeLayout containerRl;
    private View dividerView;
    private String loadUrl = "";
    private AdscopeWebView wb1;
    private TextView webViewCloseText;

    static {
        StubApp.interface11(40316);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishAdActivity() {
        finish();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getExtras() == null || TextUtils.isEmpty(intent.getExtras().getString("url", ""))) {
            return;
        }
        this.loadUrl = intent.getExtras().getString("url", "");
    }

    private void initView() {
        this.containerRl = (RelativeLayout) findViewById(R.id.webview_container_rl);
        this.dividerView = findViewById(R.id.webview_divider_line_view);
        this.wb1 = (AdscopeWebView) findViewById(R.id.webview_landpage);
        this.webViewCloseText = (TextView) findViewById(R.id.webview_close_textview);
        try {
            this.containerRl.setBackgroundColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#FFFFFF")));
            this.dividerView.setBackgroundColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#FFC1C1C1")));
            this.webViewCloseText.setTextColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#000000")));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void loadUrl(String str) {
        LogUtil.i(TAG, "urlStr : " + str);
        HashMap hashMap = new HashMap();
        hashMap.put("X-Requested-With", "");
        this.wb1.loadUrl(str, hashMap);
    }

    private void setOnClick() {
        this.webViewCloseText.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.control.action.webview.WebViewActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WebViewActivity.this.finishAdActivity();
            }
        });
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);
}
