package com.ilkom.skripsiosm;

import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	MyItemizedOverlay myItemizedOverlay = null;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        MapView mapView = new MapView(this, 256);
        mapView.setClickable(true);
        mapView.setBuiltInZoomControls(true);
        setContentView(mapView);
        mapView.getController().setZoom(15);
        mapView.getController().setCenter(new GeoPoint(-6.918477,107.6093402));
        mapView.setTileSource(TileSourceFactory.MAPQUESTOSM);
        mapView.setUseDataConnection(false);
        
        Drawable marker=getResources().getDrawable(android.R.drawable.star_big_on);
        int markerWidth = marker.getIntrinsicWidth();
        int markerHeight = marker.getIntrinsicHeight();
        marker.setBounds(0, markerHeight, markerWidth, 0);
        
        ResourceProxy resourceProxy = new DefaultResourceProxyImpl(getApplicationContext());
        
        myItemizedOverlay = new MyItemizedOverlay(marker, resourceProxy);
        mapView.getOverlays().add(myItemizedOverlay);
         
        GeoPoint myPoint1 = new GeoPoint(-6.918477, 107.6093402);
        myItemizedOverlay.addItem(myPoint1, "myPoint1", "myPoint1");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
