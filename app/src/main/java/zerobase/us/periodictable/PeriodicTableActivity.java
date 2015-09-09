package zerobase.us.periodictable;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import butterknife.Bind;
import butterknife.ButterKnife;
import zerobase.us.periodictable.model.Elements;
import zerobase.us.periodictable.ui.ElementFragment;
import zerobase.us.periodictable.ui.ElementsListFragment;
import zerobase.us.periodictable.util.SwitchFragmentInterface;

public class PeriodicTableActivity extends AppCompatActivity implements SwitchFragmentInterface {

    Elements elements;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodic_table);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (toolbar != null) {
            toolbar.setTitle(R.string.elements);
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            setSupportActionBar(toolbar);

           // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        getData();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ELEMENTS", elements);
        switchToFragment(new ElementsListFragment(), false, bundle);
    }

    private void getData(){
        Gson gson = new Gson();
        String elementsData = loadJSONFromAsset(this.getResources().openRawResource(R.raw.periodic_table));
        elements = gson.fromJson(elementsData, Elements.class);

    }

    public String loadJSONFromAsset(InputStream is) {
        String json = null;
        try {

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_periodic_table, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();
        if (count > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void switchToFragment(Fragment targetFragment) {
        switchToFragment(targetFragment, false);
    }

    @Override
    public void switchToFragment(Fragment targetFragment, boolean addToBackstack) {
        switchToFragment(targetFragment, addToBackstack, null);
    }

    @Override
    public void switchToFragment(Fragment targetFragment, boolean addToBackStack, Bundle bundle) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        if (bundle != null) {
            targetFragment.setArguments(bundle);
        } else {
            if (targetFragment.getArguments() != null) {
                targetFragment.getArguments().clear();
            }
            targetFragment.setArguments(null);
        }
        fragmentTransaction.replace(R.id.fragment_container, targetFragment);

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }

    public void setToolbarTitle(String title){
        toolbar.setTitle(title);
    }

    public void setToolbarColor(int color){
        toolbar.setBackgroundColor(color);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setStatusBarColor(int color){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Window window = this.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.red));
        }


    }
}
