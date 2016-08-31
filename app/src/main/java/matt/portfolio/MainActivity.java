package matt.portfolio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public ArrayAdapter mListAdapter; //Due to the simplicity of this app, a default ArrayAdapter will do fine for now.
    private ListView mListView;        //This ListView will have the main of the app listview assigned to it.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); //Sets up the default toolbar at the top of the app.
        setSupportActionBar(toolbar);

        //Todo: Replace dummy data
        final String Dummydata[]={"Popular Movies","Stock Hawk","Build it Bigger","Make Your App Material","Go Ubiquitous","Capstone"}; //this dummy data will be in place for testing
        mListView = (ListView) findViewById(R.id.main_listview);    //assigns the main listview in the layout to mListView
        mListAdapter =                  //Defines the ArrayAdapter using:
                new ArrayAdapter(this, // The current context (this activity)
                        R.layout.list_item, // The name of the layout ID.
                        R.id.textdisplay, // The ID of the textview to populate in each layout.
                        Dummydata);
        mListView.setAdapter(mListAdapter); //Sets the adapter for the main listview to the array adapter defined above

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> l, View view, int position, long id) {
                // This code was derived primarily from the example provided by Google at https://developer.android.com/guide/topics/ui/notifiers/toasts.html
                Context context = getApplicationContext();
                CharSequence text = Dummydata[position];
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
