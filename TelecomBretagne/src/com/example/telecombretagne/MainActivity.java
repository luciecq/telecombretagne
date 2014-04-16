package com.example.telecombretagne;

import java.util.List;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends ActionBarActivity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        
       
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.gerer_notifications) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
    
    public void fig (View view){
    	Intent intent = new Intent(this, FigPage.class);
    	//TODO : manque peut etre des trucs : cf tuto
    	startActivity(intent);
    }
    
    public void lienLexians (View view) {
    	 Uri webpage = Uri.parse("http://http://www.telecom-bretagne.eu/lexians/");
         Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

         // Verify it resolves
         PackageManager packageManager = getPackageManager();
         List<ResolveInfo> activities = packageManager.queryIntentActivities(webIntent, 0);
         boolean isIntentSafe = activities.size() > 0;

         // Start an activity if it's safe
         if (isIntentSafe) {
         	startActivity(webIntent);
         }
    }
    
    public void lienCampuschannel (View view) {
   	 Uri webpage = Uri.parse("http://www.campus-channel.com/telecom-bretagne-programme-ingenieur-prepas.html");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

        // Verify it resolves
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(webIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

        // Start an activity if it's safe
        if (isIntentSafe) {
        	startActivity(webIntent);
        }
   }

}
