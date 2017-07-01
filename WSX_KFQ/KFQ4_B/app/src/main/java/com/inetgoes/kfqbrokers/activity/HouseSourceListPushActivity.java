package com.inetgoes.kfqbrokers.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.inetgoes.kfqbrokers.Constants;
import com.inetgoes.kfqbrokers.FangApplication;
import com.inetgoes.kfqbrokers.IM_Util.XmppUtil;
import com.inetgoes.kfqbrokers.R;
import com.inetgoes.kfqbrokers.asynctast.HttpAsy;
import com.inetgoes.kfqbrokers.asynctast.PostExecute;
import com.inetgoes.kfqbrokers.manager.AppSharePrefManager;
import com.inetgoes.kfqbrokers.model.HouseInfo_BrokerIntroduce;
import com.inetgoes.kfqbrokers.model.KfqMessage;
import com.inetgoes.kfqbrokers.model.KfqMessage_Send;
import com.inetgoes.kfqbrokers.utils.JacksonMapper;
import com.inetgoes.kfqbrokers.utils.L;
import com.inetgoes.kfqbrokers.view.CustomTitleBar;
import com.inetgoes.kfqbrokers.view.RightDeal;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 我的所有房源
 */
public class HouseSourceListPushActivity extends Activity {
    private String brokertype = "新房";   //字符串, 代理类型: 值有: 新房、二手房、出租房   （必写）
    private int userid;
    private int startindex = 0;
    private int pagenum = 10;
    private String sessionid;
    private int touserid;

    private RadioGroup layoutTap;
    private RadioButton newHouse;
    private RadioButton secondHandHouse;
    private RadioButton rentHouse;
    private FrameLayout flHouseList;
    private PullToRefreshListView lvMyHouseSource;
    private MyHouseSourceListAdapter adapter;


    private List<HouseInfo_BrokerIntroduce> houses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomTitleBar.getTitleBar(this, "我的房源", true, false);
        setContentView(R.layout.activity_housesource_push);

        userid = AppSharePrefManager.getInstance(this).getLastest_login_id();
        sessionid = getIntent().getStringExtra("sessionid");
        touserid = getIntent().getIntExtra("requserid", 0);

        initView();

        requestData(brokertype, startindex, pagenum, false);

    }

    private void initView() {
        layoutTap = (RadioGroup) findViewById(R.id.layout_tap);
        newHouse = (RadioButton) findViewById(R.id.new_house);
        secondHandHouse = (RadioButton) findViewById(R.id.second_hand_house);
        rentHouse = (RadioButton) findViewById(R.id.rent_house);
        // flHouseList = (FrameLayout) findViewById(R.id.fl_house_list);

        lvMyHouseSource = (PullToRefreshListView) findViewById(R.id.lv_myhousesource);//房源列表

        adapter = new MyHouseSourceListAdapter();
        lvMyHouseSource.setAdapter(adapter);
        lvMyHouseSource.setMode(PullToRefreshBase.Mode.PULL_FROM_END);

    }


    private void requestData(String brokertype, int startIndex, int pagenum, final boolean isColse) {
        Map<String, Object> map = new HashMap<>();
        map.put("startindex", startIndex);
        map.put("pagenum", pagenum);
        map.put("brokerid", userid);
        map.put("brokertype", brokertype);

        try {
            L.LogE(JacksonMapper.getObjectMapper().writeValueAsString(map));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        new HttpAsy(new PostExecute() {
            @Override
            public void onPostExecute(String result) {
                L.LogE("requestData result -- " + result);
                if (!TextUtils.isEmpty(result)) {
                    JavaType javaType = JacksonMapper.getCollectionType(ArrayList.class, HouseInfo_BrokerIntroduce.class);
                    List<HouseInfo_BrokerIntroduce> temps = null;
                    try {
                        temps = JacksonMapper.getObjectMapper().readValue(result, javaType);
                        houses.addAll(temps);
                        if (isColse) {
                            lvMyHouseSource.onRefreshComplete();
                        }
                        adapter.notifyDataSetChanged();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).execute(Constants.showHouseSourceUrl, map);
    }


    private class MyHouseSourceListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return houses.size();
        }

        @Override
        public Object getItem(int position) {
            return houses.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            final ViewHolder viewHolder;
            if (null == convertView) {
                viewHolder = new ViewHolder();

                convertView = View.inflate(HouseSourceListPushActivity.this, R.layout.item_myhousesource, null);

                viewHolder.fangyuan_image = (ImageView) convertView.findViewById(R.id.item_iv_fangyuan);
                viewHolder.fangyuan_Name = (TextView) convertView.findViewById(R.id.item_tv_fangyuan1);
                viewHolder.fangyuan_cishu = (TextView) convertView.findViewById(R.id.item_tv_fangyuan2);
                viewHolder.fangyuan_SuccessNum = (TextView) convertView.findViewById(R.id.item_tv_fangyuan3);
                viewHolder.fangyuan_prices = (TextView) convertView.findViewById(R.id.item_tv_fangyuan4);
                viewHolder.fangyuan_position = (TextView) convertView.findViewById(R.id.item_tv_fangyuan5);

                convertView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();

            }
            final HouseInfo_BrokerIntroduce hbi = houses.get(position);

            if (hbi != null) {

                //加载图片
                String imageurl = hbi.getLoupan_image_url();
                if (!TextUtils.isEmpty(imageurl)) {
                    ImageLoader.getInstance().displayImage(imageurl, viewHolder.fangyuan_image, FangApplication.options, FangApplication.animateFirstListener);
                }
                viewHolder.fangyuan_Name.setText(hbi.getLoupanname());
                viewHolder.fangyuan_cishu.setText("看房次数：" + hbi.getKanfang_time().toString());
                viewHolder.fangyuan_SuccessNum.setText("成交量：" + hbi.getTran_success_num().toString());
                viewHolder.fangyuan_prices.setText(hbi.getPricedesc());
                viewHolder.fangyuan_position.setText(hbi.getStrict());
            }

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(HouseSourceListPushActivity.this, SelectHuxingActivity.class);
                    i.putExtra("sessionid",sessionid);
                    i.putExtra("requserid",touserid);
                    i.putExtra("newcode",hbi.getNewcode());
                    i.putExtra("title",hbi.getLoupanname());
                    startActivity(i);

                }
            });

            return convertView;
        }

        /**
         * 房源的holder
         */
        class ViewHolder {
            ImageView fangyuan_image;
            TextView fangyuan_Name;
            TextView fangyuan_cishu;
            TextView fangyuan_SuccessNum;
            TextView fangyuan_prices;
            TextView fangyuan_position;

        }
    }

}
