package cn.bluemobi.dylan.base.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import cn.bluemobi.dylan.base.utils.Tools;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class SelectPopupWindow extends PopupWindow {
    private Context context;
    private ListAdapter listAdapter;
    private ListView listView;
    private FrameLayout outsideView;
    private PopupWindow popupWindow;
    private View showAsDropDownView;

    public SelectPopupWindow(View view, ListAdapter listAdapter, FrameLayout frameLayout) {
        this.showAsDropDownView = view;
        this.context = view.getContext();
        this.listAdapter = listAdapter;
        this.outsideView = frameLayout;
        init();
    }

    private void init() {
        this.popupWindow = new PopupWindow(-1, -2);
        ListView listView = new ListView(this.context);
        this.listView = listView;
        listView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.listView.setDivider(new ColorDrawable(this.context.getResources().getColor(17170432)));
        this.listView.setDividerHeight(Tools.m57620a(1.0f, this.context));
        this.listView.setBackgroundColor(-1);
        this.listView.setAdapter(this.listAdapter);
        setOnItemClickListener(null);
        this.popupWindow.setContentView(this.listView);
        this.popupWindow.setBackgroundDrawable(new BitmapDrawable());
        this.popupWindow.setOutsideTouchable(true);
        this.popupWindow.setFocusable(true);
        this.popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: cn.bluemobi.dylan.base.view.SelectPopupWindow.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (SelectPopupWindow.this.outsideView != null) {
                    SelectPopupWindow.this.outsideView.setForeground(new ColorDrawable(0));
                }
            }
        });
    }

    public ListView getListView() {
        return this.listView;
    }

    public SelectPopupWindow setOnItemClickListener(final AdapterView.OnItemClickListener onItemClickListener) {
        ListView listView;
        if (this.popupWindow == null || (listView = this.listView) == null) {
            return this;
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: cn.bluemobi.dylan.base.view.SelectPopupWindow.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                SelectPopupWindow.this.popupWindow.dismiss();
                AdapterView.OnItemClickListener onItemClickListener2 = onItemClickListener;
                if (onItemClickListener2 != null) {
                    onItemClickListener2.onItemClick(adapterView, view, i, j);
                }
            }
        });
        return this;
    }

    public SelectPopupWindow show() {
        if (this.popupWindow == null) {
            init();
        }
        if (!this.popupWindow.isShowing()) {
            this.popupWindow.showAsDropDown(this.showAsDropDownView);
            FrameLayout frameLayout = this.outsideView;
            if (frameLayout != null) {
                frameLayout.setForeground(new ColorDrawable(Color.parseColor("#7F4c4c4c")));
            }
        }
        return this;
    }
}
