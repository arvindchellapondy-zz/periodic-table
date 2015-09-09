package zerobase.us.periodictable.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import zerobase.us.periodictable.PeriodicTableFragment;
import zerobase.us.periodictable.R;
import zerobase.us.periodictable.model.Element;

/**
 * Created by arvindchellapondy on 9/5/15.
 */
public class ElementDetailsFragment extends PeriodicTableFragment {

    @Bind(R.id.element_description_text_view)
    TextView description;

    private Element element;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_element_details, container, false);
        ButterKnife.bind(this,view);
        Bundle args = getArguments();
        if(args!=null){
            element = args.getParcelable("ELEMENT");
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if(!TextUtils.isEmpty(element.getDescription())){
            description.setText(element.getDescription());
        }


    }

}
