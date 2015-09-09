package zerobase.us.periodictable.ui;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import zerobase.us.periodictable.PeriodicTableFragment;
import zerobase.us.periodictable.R;
import zerobase.us.periodictable.model.Element;
import zerobase.us.periodictable.model.Elements;

/**
 * Created by arvindchellapondy on 9/5/15.
 */
public class ElementFragment extends PeriodicTableFragment {


    @Bind(R.id.element_viewpager)
    ViewPager viewPager;

    @Bind(R.id.smart_tab_layout)
    SmartTabLayout smartTabLayout;

    ElementPagerAdapter pagerAdapter;

    private View view;

    private Element element;

    String[] groupNames;
    int[] groupColors;
    private int color;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_element, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        groupNames = getPeriodicTableActivity().getResources().getStringArray(R.array.group_name);
        groupColors = getPeriodicTableActivity().getResources().getIntArray(R.array.group_colors);
        if(bundle!=null){
            element = bundle.getParcelable("ELEMENT");
        }

        pagerAdapter = new ElementPagerAdapter(getFragmentManager());
        pagerAdapter.notifyDataSetChanged();
        viewPager.setAdapter(pagerAdapter);

        smartTabLayout.setViewPager(viewPager);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        setupView();
    }

    public void setupView(){
        for(int i=0;i<groupNames.length;i++){
            if(element.getGroupBlock().equalsIgnoreCase(groupNames[i])){
                color = groupColors[i];
            }
        }

        getPeriodicTableActivity().setToolbarTitle(element.getElementName());
        getPeriodicTableActivity().setToolbarColor(color);
        smartTabLayout.setBackgroundColor(color);

    }

    class ElementPagerAdapter extends FragmentStatePagerAdapter {

        public ElementPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment;
            Bundle args = new Bundle();
            args.putParcelable("ELEMENT", element);


            if(i==0){
                fragment = new ElementInfoFragment();
                fragment.setArguments(args);
                return fragment;
            }else{
                fragment = new ElementDetailsFragment();
                fragment.setArguments(args);
                return fragment;
            }


        }
        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch(position){
                case 1 :
                    return "Description";
                default:
                    return "Properties";
            }
        }
    }
}
