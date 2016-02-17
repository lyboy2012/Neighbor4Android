package com.cailine.neighbor;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


// TODO: 2016/2/17
/**
* home 首页 展示列表信息
*
* @author liying
* @Data 2016/2/17 14:07
*/
public class HomeActivity extends BaseActivity {
    
    private int tabImages[] = {R.drawable.tab_home, R.drawable.tab_loan,
            R.drawable.tab_borrow, R.drawable.tab_user};// 图标
    private Class fragments[] = {HomeFragment.class, LoanFragment.class,
            BorrowFragment.class, UserFragment.class};

    private FragmentTabHost fragmentTabHost;
    private LayoutInflater layoutInflater;
    private String[] tabTexts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void init() {
        initTabHost();
    }


    private void initTabHost() {


        layoutInflater = LayoutInflater.from(this);

        fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this, getSupportFragmentManager(), R.id.realTabContent);
        fragmentTabHost.getTabWidget().setDividerDrawable(null);//去掉分割线
        int size = fragments.length;
        Resources resources = getResources();
        tabTexts = resources.getStringArray(R.array.tab_text_arr);
        for (int i = 0; i < size; i++) {
            fragmentTabHost.addTab(fragmentTabHost.newTabSpec(tabTexts[i]).setIndicator(getItemView(i)), fragments[i],
                    null);
        }

        // 设置默认显示布局
        fragmentTabHost.setCurrentTab(0);
    }


    private View getItemView(int index) {

        RelativeLayout view = (RelativeLayout) layoutInflater.inflate(R.layout.tab_item,
                null);// tab widget is the parent 不加tabwidget  不显示

        ImageView imageView = (ImageView) view.findViewById(R.id.tabImageView);
        imageView.setImageResource(tabImages[index]);
        TextView textView = (TextView) view.findViewById(R.id.tabTextView);
        // 从资源文件读取tabhost 标签内容
        textView.setText(tabTexts[index]);
        Log.d(TAG, tabTexts[index]);
        return view;
    }


}



