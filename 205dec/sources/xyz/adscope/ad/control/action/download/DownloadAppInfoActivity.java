package xyz.adscope.ad.control.action.download;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.stub.StubApp;
import xyz.adscope.ad.R;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.render.util.UIAdapterUtil;
import xyz.adscope.ad.tool.widget.AdscopeWebView;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class DownloadAppInfoActivity extends Activity {
    private ImageView appInfoBack;
    private TextView appInfoTitle;
    private RelativeLayout containerRl;
    private View introBelowView;
    private TextView introContentTextView;
    private LinearLayout introLayout;
    private ScrollView introScrollView;
    private TextView introTextView;
    private AdscopeWebView introWebView;
    private View permissionBelowView;
    private TextView permissionContentTextView;
    private LinearLayout permissionLayout;
    private ScrollView permissionScrollView;
    private TextView permissionTextView;
    private AdscopeWebView permissionWebView;
    private View privacyBelowView;
    private TextView privacyContentTextView;
    private LinearLayout privacyLayout;
    private ScrollView privacyScrollView;
    private TextView privacyTextView;
    private AdscopeWebView privacyWebView;
    private LinearLayout tabLayout;
    private int fromPosition = 0;
    private String permissionContent = "";
    private String privacyContent = "";
    private String introContent = "";
    private String titleContent = "";

    static {
        StubApp.interface11(40310);
    }

    private void initData() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.privacyContent = extras.getString(Constants.PRIVACY_CONTENT_KEY);
        this.titleContent = extras.getString(Constants.TITLE_CONTENT_KEY);
        this.permissionContent = extras.getString("permission_content_key");
        this.introContent = extras.getString(Constants.INTRO_CONTENT_KEY);
        this.fromPosition = extras.getInt(Constants.FROM_POSITION_KEY);
    }

    private void initView() {
        this.containerRl = (RelativeLayout) findViewById(R.id.asnp_download_appinfo_container_rl);
        this.tabLayout = (LinearLayout) findViewById(R.id.asnp_download_appinfo_tablayout);
        this.appInfoBack = (ImageView) findViewById(R.id.asnp_download_appinfo_back);
        this.appInfoTitle = (TextView) findViewById(R.id.asnp_download_appinfo_title);
        this.permissionLayout = (LinearLayout) findViewById(R.id.asnp_appinfo_permission_layout);
        this.permissionTextView = (TextView) findViewById(R.id.asnp_appinfo_permission_textview);
        this.permissionBelowView = findViewById(R.id.asnp_appinfo_permission_below_line);
        this.privacyLayout = (LinearLayout) findViewById(R.id.asnp_appinfo_privacy_layout);
        this.privacyTextView = (TextView) findViewById(R.id.asnp_appinfo_privacy_textview);
        this.privacyBelowView = findViewById(R.id.asnp_appinfo_privacy_below_line);
        this.introLayout = (LinearLayout) findViewById(R.id.asnp_appinfo_intro_layout);
        this.introTextView = (TextView) findViewById(R.id.asnp_appinfo_intro_textview);
        this.introBelowView = findViewById(R.id.asnp_appinfo_intro_below_line);
        this.permissionScrollView = (ScrollView) findViewById(R.id.asnp_download_appinfo_persmission_content_scrollview);
        this.permissionContentTextView = (TextView) findViewById(R.id.asnp_download_appinfo_persmission_content_textview);
        this.permissionWebView = (AdscopeWebView) findViewById(R.id.asnp_download_appinfo_persmission_content_webview);
        this.privacyScrollView = (ScrollView) findViewById(R.id.asnp_download_appinfo_privacy_content_scrollview);
        this.privacyContentTextView = (TextView) findViewById(R.id.asnp_download_appinfo_privacy_content_textview);
        this.privacyWebView = (AdscopeWebView) findViewById(R.id.asnp_download_appinfo_privacy_content_webview);
        this.introScrollView = (ScrollView) findViewById(R.id.asnp_download_appinfo_intro_content_scrollview);
        this.introContentTextView = (TextView) findViewById(R.id.asnp_download_appinfo_intro_content_textview);
        this.introWebView = (AdscopeWebView) findViewById(R.id.asnp_download_appinfo_intro_content_webview);
        try {
            this.containerRl.setBackgroundColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#FFFFFF")));
            this.appInfoTitle.setTextColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#000000")));
            this.appInfoBack.setImageTintList(ColorStateList.valueOf(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#000000"))));
            this.tabLayout.setBackgroundColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#FFFFFF")));
            this.permissionContentTextView.setTextColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#000000")));
            this.privacyContentTextView.setTextColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#000000")));
            this.introContentTextView.setTextColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#000000")));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void restViewStatus() {
        TextView textView = this.introTextView;
        int i4 = R.color.adscope_appinfo_tab_unselected_color;
        textView.setTextColor(ContextCompat.getColor(this, i4));
        this.introBelowView.setVisibility(4);
        this.permissionTextView.setTextColor(ContextCompat.getColor(this, i4));
        this.permissionBelowView.setVisibility(4);
        this.privacyTextView.setTextColor(ContextCompat.getColor(this, i4));
        this.privacyBelowView.setVisibility(4);
        this.introScrollView.setVisibility(8);
        this.introWebView.setVisibility(8);
        this.introContentTextView.setVisibility(8);
        this.permissionScrollView.setVisibility(8);
        this.permissionContentTextView.setVisibility(8);
        this.permissionWebView.setVisibility(8);
        this.privacyScrollView.setVisibility(8);
        this.privacyContentTextView.setVisibility(8);
        this.privacyWebView.setVisibility(8);
    }

    private void setOnClickEvent() {
        if (!TextUtils.isEmpty(this.titleContent)) {
            this.appInfoTitle.setText(this.titleContent);
        }
        this.appInfoBack.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.control.action.download.DownloadAppInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadAppInfoActivity.this.finish();
            }
        });
        this.permissionLayout.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.control.action.download.DownloadAppInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadAppInfoActivity.this.showTab(0);
            }
        });
        this.privacyLayout.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.control.action.download.DownloadAppInfoActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadAppInfoActivity.this.showTab(1);
            }
        });
        this.introLayout.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.control.action.download.DownloadAppInfoActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadAppInfoActivity.this.showTab(2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTab(int i4) {
        if (i4 == 2) {
            restViewStatus();
            showTabView(this.introTextView, this.introBelowView, this.introContent, this.introContentTextView, this.introScrollView, this.introWebView);
        } else if (i4 == 1) {
            restViewStatus();
            showTabView(this.privacyTextView, this.privacyBelowView, this.privacyContent, this.privacyContentTextView, this.privacyScrollView, this.privacyWebView);
        } else {
            restViewStatus();
            showTabView(this.permissionTextView, this.permissionBelowView, this.permissionContent, this.permissionContentTextView, this.permissionScrollView, this.permissionWebView);
        }
    }

    private void showTabView(TextView textView, View view, String str, TextView textView2, ScrollView scrollView, WebView webView) {
        int i4 = R.color.adscope_appinfo_tab_selected_color;
        textView.setTextColor(ContextCompat.getColor(this, i4));
        view.setBackgroundColor(ContextCompat.getColor(this, i4));
        view.setVisibility(0);
        if (str.startsWith("http")) {
            textView2.setText("");
            scrollView.setVisibility(8);
            webView.setVisibility(0);
            webView.loadUrl(str);
            return;
        }
        textView2.setText(str);
        textView2.setVisibility(0);
        scrollView.setVisibility(0);
        webView.setVisibility(8);
    }

    @Override // android.app.Activity
    public native void onCreate(@Nullable Bundle bundle);
}
