package xyz.adscope.ad.tool.widget.dialog.download;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.stub.StubApp;
import java.util.ArrayList;
import xyz.adscope.ad.R;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.action.download.DownloadUtil;
import xyz.adscope.ad.control.render.util.UIAdapterUtil;
import xyz.adscope.ad.model.http.response.ad.DwinfoModel;
import xyz.adscope.ad.tool.download.DownloadManager;
import xyz.adscope.ad.tool.imageloader.AdScopeImageLoader;
import xyz.adscope.common.imageloader.inter.IImageLoaderCallback;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdscopeDownloadDialog extends Activity {
    private ImageView closeIv;
    private TextView developerTv;
    private LinearLayout dialogTotalLayout;
    private View dividerView;
    private String downLoadUrl;
    private LinearLayout downloadLL;
    private DwinfoModel dwinfoModel;
    private ExpandableListView expandLv;
    private ImageView iconIv;
    private int lastExpandItem = -1;
    private TextView nameTv;
    private TextView versionTv;

    static {
        StubApp.interface11(40691);
    }

    private void initData() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.dwinfoModel = (DwinfoModel) extras.getSerializable(Constants.DOWNLOAD_INFO_KEY);
        this.downLoadUrl = extras.getString(Constants.DOWNLOAD_URL_KEY);
    }

    private void initView() {
        this.dialogTotalLayout = (LinearLayout) findViewById(R.id.adscope_download_dialog_total_layout);
        this.dividerView = findViewById(R.id.adscope_download_dialog_divider_view);
        this.closeIv = (ImageView) findViewById(R.id.adscope_download_dialog_close_iv);
        this.iconIv = (ImageView) findViewById(R.id.adscope_download_dialog_icon_iv);
        this.nameTv = (TextView) findViewById(R.id.adscope_download_dialog_name_tv);
        this.versionTv = (TextView) findViewById(R.id.adscope_download_dialog_version_tv);
        this.developerTv = (TextView) findViewById(R.id.adscope_download_dialog_developer_tv);
        this.expandLv = (ExpandableListView) findViewById(R.id.adscope_download_dialog_expand_lv);
        this.downloadLL = (LinearLayout) findViewById(R.id.adscope_download_dialog_download_ll);
        this.expandLv.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() { // from class: xyz.adscope.ad.tool.widget.dialog.download.AdscopeDownloadDialog.1
            @Override // android.widget.ExpandableListView.OnGroupExpandListener
            public void onGroupExpand(int i4) {
                if (AdscopeDownloadDialog.this.lastExpandItem != -1) {
                    AdscopeDownloadDialog.this.expandLv.collapseGroup(AdscopeDownloadDialog.this.lastExpandItem);
                }
                AdscopeDownloadDialog.this.lastExpandItem = i4;
            }
        });
        try {
            this.dialogTotalLayout.setBackgroundColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#FFFFFF")));
            this.dividerView.setBackgroundColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#CCCCCC")));
            this.closeIv.setImageTintList(ColorStateList.valueOf(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#000000"))));
            this.nameTv.setTextColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#000000")));
            this.versionTv.setTextColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#8C8C8C")));
            this.developerTv.setTextColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#8C8C8C")));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClickEvent$0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClickEvent$1(View view) {
        finish();
        new DownloadManager().startDownload(this, this.downLoadUrl);
    }

    private void setClickEvent() {
        this.closeIv.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.tool.widget.dialog.download.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdscopeDownloadDialog.this.lambda$setClickEvent$0(view);
            }
        });
        this.downloadLL.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.tool.widget.dialog.download.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdscopeDownloadDialog.this.lambda$setClickEvent$1(view);
            }
        });
        DwinfoModel dwinfoModel = this.dwinfoModel;
        if (dwinfoModel == null) {
            return;
        }
        if (this.iconIv != null && !TextUtils.isEmpty(dwinfoModel.getIconUrl())) {
            try {
                new AdScopeImageLoader();
                AdScopeImageLoader.loadImage(this, this.dwinfoModel.getIconUrl(), new IImageLoaderCallback() { // from class: xyz.adscope.ad.tool.widget.dialog.download.AdscopeDownloadDialog.2
                    @Override // xyz.adscope.common.imageloader.inter.IImageLoaderCallback
                    public void failCallback(String str) {
                    }

                    @Override // xyz.adscope.common.imageloader.inter.IImageLoaderCallback
                    public void successCallback(Bitmap bitmap) {
                        AdscopeDownloadDialog.this.iconIv.setImageBitmap(bitmap);
                    }
                });
            } catch (Exception e4) {
                String str = Constants.TAG;
                LogUtil.e(str, "e : " + e4);
            }
        }
        if (this.nameTv != null && !TextUtils.isEmpty(this.dwinfoModel.getName())) {
            this.nameTv.setText(this.dwinfoModel.getName());
        }
        if (this.versionTv != null && !TextUtils.isEmpty(this.dwinfoModel.getVersion())) {
            TextView textView = this.versionTv;
            textView.setText(getString(R.string.adscope_version_code) + this.dwinfoModel.getVersion());
        }
        if (this.developerTv != null && !TextUtils.isEmpty(this.dwinfoModel.getDeveloper())) {
            TextView textView2 = this.developerTv;
            textView2.setText(getString(R.string.adscope_developer) + this.dwinfoModel.getDeveloper());
        }
        ArrayList arrayList = new ArrayList();
        ExpandableGroupBean expandableGroupBean = new ExpandableGroupBean();
        expandableGroupBean.setGroupName(getString(R.string.adscope_app_permission));
        String permissionContent = DownloadUtil.getPermissionContent(this.dwinfoModel);
        if (!TextUtils.isEmpty(permissionContent)) {
            if (permissionContent.startsWith("http")) {
                expandableGroupBean.setChildType("h5");
            } else {
                expandableGroupBean.setChildType("text");
            }
            expandableGroupBean.setChildContent(permissionContent);
        }
        arrayList.add(expandableGroupBean);
        ExpandableGroupBean expandableGroupBean2 = new ExpandableGroupBean();
        expandableGroupBean2.setGroupName(getString(R.string.adscope_app_privacy_policy));
        String policyContent = DownloadUtil.getPolicyContent(this.dwinfoModel);
        if (!TextUtils.isEmpty(policyContent)) {
            if (policyContent.startsWith("http")) {
                expandableGroupBean2.setChildType("h5");
            } else {
                expandableGroupBean2.setChildType("text");
            }
            expandableGroupBean2.setChildContent(policyContent);
        }
        arrayList.add(expandableGroupBean2);
        ExpandableGroupBean expandableGroupBean3 = new ExpandableGroupBean();
        expandableGroupBean3.setGroupName(getString(R.string.adscope_app_intro_info));
        String appIntroContent = DownloadUtil.getAppIntroContent(this.dwinfoModel);
        if (!TextUtils.isEmpty(appIntroContent)) {
            if (appIntroContent.startsWith("http")) {
                expandableGroupBean3.setChildType("h5");
            } else {
                expandableGroupBean3.setChildType("text");
            }
            expandableGroupBean3.setChildContent(appIntroContent);
        }
        arrayList.add(expandableGroupBean3);
        this.expandLv.setAdapter(new ExpandableListviewAdapter(this, arrayList));
    }

    private void setViewWidthHeight() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        Point point = new Point();
        getWindow().getWindowManager().getDefaultDisplay().getSize(point);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = point.x;
        double d4 = point.y;
        Double.isNaN(d4);
        attributes.height = (int) (d4 * 0.45d);
        attributes.gravity = 80;
        window.setAttributes(attributes);
        layoutParams.width = point.x;
        double d5 = point.y;
        Double.isNaN(d5);
        layoutParams.height = (int) (d5 * 0.45d);
        layoutParams.gravity = 80;
        this.dialogTotalLayout.setLayoutParams(layoutParams);
        this.dialogTotalLayout.requestLayout();
    }

    @Override // android.app.Activity
    public native void onCreate(@Nullable Bundle bundle);
}
