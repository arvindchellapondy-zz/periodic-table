package zerobase.us.periodictable.ui;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import zerobase.us.periodictable.R;
import zerobase.us.periodictable.model.Element;
import zerobase.us.periodictable.model.Elements;

/**
 * Created by arvindchellapondy on 9/6/15.
 */
public class ElementsListAdapter extends BaseAdapter {

    private Context context;
    private Elements elements;
    private int lastPosition = -1;
    String[] groupNames;
    int[] groupColors;

    public ElementsListAdapter(Context context, Elements elements){
        this.context = context;
        this.elements = elements;
        groupNames = context.getResources().getStringArray(R.array.group_name);
        groupColors = context.getResources().getIntArray(R.array.group_colors);
    }

    @Override
    public int getCount() {
        return elements.getElements().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewHolder viewHolder;
        int color = R.color.white;
        Element element = elements.getElements().get(position);
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.elements_list_item, null);
            viewHolder = new ListViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ListViewHolder) convertView.getTag();
        }

        Animation animation = AnimationUtils.loadAnimation(context, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        convertView.startAnimation(animation);
        lastPosition = position;

        for(int i=0;i<groupNames.length;i++){
            if(element.getGroupBlock().equalsIgnoreCase(groupNames[i])){
                color = groupColors[i];
            }
        }

        TextDrawable drawable = TextDrawable.builder()
                .buildRect(element.getSymbol(), color);

        viewHolder.imageView.setImageDrawable(drawable);
        viewHolder.textView.setText(element.getElementName());

        return convertView;
    }

    static class ListViewHolder {

        @Bind(R.id.elements_list_image_view)
        ImageView imageView;

        @Bind(R.id.elements_list_text_view)
        TextView textView;


        ListViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }


}
