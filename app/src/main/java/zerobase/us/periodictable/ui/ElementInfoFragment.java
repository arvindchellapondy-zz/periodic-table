package zerobase.us.periodictable.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import zerobase.us.periodictable.PeriodicTableFragment;
import zerobase.us.periodictable.R;
import zerobase.us.periodictable.model.Element;
import zerobase.us.periodictable.util.NonScrollableListView;

/**
 * Created by arvindchellapondy on 9/5/15.
 */
public class ElementInfoFragment extends PeriodicTableFragment {

    @Bind(R.id.element_card_relative_layout)
    RelativeLayout elementCard;

    @Bind(R.id.symbol_text_view)
    TextView symbolTextView;

    @Bind(R.id.atomic_number_text_view)
    TextView atomicNumberTextView;

    @Bind(R.id.list_view)
    NonScrollableListView elementInfoListView;

    private ElementInfoListAdapter elementInfoListAdapter;
    private Element element;
    String[] groupNames;
    int[] groupColors;
    private int color;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_element_info, container, false);
        ButterKnife.bind(this,view);
        Bundle args = getArguments();
        groupNames = getPeriodicTableActivity().getResources().getStringArray(R.array.group_name);
        groupColors = getPeriodicTableActivity().getResources().getIntArray(R.array.group_colors);
        if(args!=null){
            element = args.getParcelable("ELEMENT");
        }
        elementInfoListAdapter = new ElementInfoListAdapter(getActivity(),element);
        elementInfoListView.setAdapter(elementInfoListAdapter);

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();


        setupView();
    }

    private void setupView(){
        for(int i=0;i<groupNames.length;i++){
            if(element.getGroupBlock().equalsIgnoreCase(groupNames[i])){
                color = groupColors[i];
            }
        }
        elementCard.setBackgroundColor(color);
        symbolTextView.setText(element.getSymbol());

        atomicNumberTextView.setText(Integer.toString(element.getAtomicNumber()));
    }

//    public static ElementInfoFragment newInstance(Element element) {
//        ElementInfoFragment fragment = new ElementInfoFragment();
//
//        Bundle args = new Bundle();
//        args.putParcelable("ELEMENTS", element);
//        fragment.setArguments(args);
//
//        return fragment;
//    }
}
