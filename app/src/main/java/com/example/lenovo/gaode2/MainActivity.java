package com.example.lenovo.gaode2;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PointF;
import android.opengl.EGLConfig;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;

import javax.microedition.khronos.opengles.GL10;


public class MainActivity extends AppCompatActivity {
    private MapView mapView;
    private AMap aMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);//设置对应的XML布局文件

        mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        aMap = mapView.getMap();
//        aMap.setTrafficEnabled(true);

        //****添加标记
        MarkerOptions markerOption = new MarkerOptions();
        markerOption.position(new LatLng(39.906901,116.397972));
        markerOption.icon(BitmapDescriptorFactory.fromResource( R.drawable.ic_launcher));
        markerOption.draggable(true);
        Marker marker =aMap.addMarker(markerOption);

        //****添加折线
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.add(new LatLng(39.91667,116.41667),new LatLng(31.120000,121.260000));
        polylineOptions.color(Color.BLUE);
        polylineOptions.width(10);
        polylineOptions.setDottedLine(true);
        aMap.addPolyline(polylineOptions);

        //*****汇圆
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(new LatLng(39.906901,116.397972));
        circleOptions.radius(10000);
        circleOptions.fillColor(Color.GREEN);
        aMap.addCircle(circleOptions);





        /*//**************** 自定义点标记
        LatLng XIAN = new LatLng(34.341568, 108.940174);//第一个参数是纬度：latitude，第二个参数是经度longitude
        markerOption.position(XIAN).title("西安市").snippet("西安市：34.341568, 108.940174");
        markerOption.draggable(true);
        markerOption.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));
        // 将Marker设置为贴地显示，可以双指下拉看效果
        Marker marker =aMap.addMarker(markerOption);
        markerOption.setFlat(true);*/

        /*
         //*****************点标记支持的事件
         AMap.OnMarkerClickListener listener1 = new AMap.OnMarkerClickListener() {
        @Override public boolean onMarkerClick(Marker arg0) {
        // TODO Auto-generated method stub
        return false;
        }
        };
         AMap.setOnMarkerClickListener(listener1);   //绑定标注点击事件

         AMap.OnMarkerDragListener listener2 = new AMap.OnMarkerDragListener() {
        @Override public void onMarkerDragStart(Marker arg0) {
        // TODO Auto-generated method stub

        }

        @Override public void onMarkerDragEnd(Marker arg0) {
        // TODO Auto-generated method stub
        }

        @Override public void onMarkerDrag(Marker arg0) {
        // TODO Auto-generated method stub
        }
        };
         AMap.setOnMarkerDragListener(listener2);     //绑定标记拖拽事件
         */
    }



    @Override
    protected void onResume() {
        super.onResume();
        // 必须回调MapView的onResume()方法
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 必须回调MapView的onPause()方法
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

}




