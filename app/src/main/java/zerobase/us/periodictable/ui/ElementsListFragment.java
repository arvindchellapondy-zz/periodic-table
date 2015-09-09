package zerobase.us.periodictable.ui;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import zerobase.us.periodictable.PeriodicTableFragment;
import zerobase.us.periodictable.R;
import zerobase.us.periodictable.model.Element;
import zerobase.us.periodictable.model.Elements;

/**
 * Created by arvindchellapondy on 9/5/15.
 */
public class ElementsListFragment extends PeriodicTableFragment {

    @Bind(R.id.elements_list_view)
    ListView elementsListView;

    private View view;
    Parcelable state;
    private ElementsListAdapter elementsListAdapter;
    private Elements elements;
    private Element element;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_elements, container, false);

        ButterKnife.bind(this,view);
        Bundle bundle = getArguments();
        if(bundle!=null){
            elements = bundle.getParcelable("ELEMENTS");
        }
        elementsListAdapter = new ElementsListAdapter(getActivity(),elements);

        getPeriodicTableActivity().setToolbarTitle(getResources().getString(R.string.elements));
        getPeriodicTableActivity().setToolbarColor(getResources().getColor(R.color.toolbar_color));

        elementsListView.setAdapter(elementsListAdapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        setupView();
    }

    public void setupView(){

        elementsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                element = elements.getElements().get(position);
                Bundle bundle = new Bundle();
                bundle.putParcelable("ELEMENT",element);
                getPeriodicTableActivity().switchToFragment(new ElementFragment(),true,bundle);
            }
        });

    }
}
