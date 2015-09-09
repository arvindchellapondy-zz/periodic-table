package zerobase.us.periodictable.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import zerobase.us.periodictable.R;
import zerobase.us.periodictable.model.Element;

/**
 * Created by arvindchellapondy on 9/6/15.
 */
public class ElementInfoListAdapter extends BaseAdapter {

    private Context context;
    private Element element;

    public ElementInfoListAdapter(Context context, Element element){
        this.context = context;
        this.element =element;
    }

    @Override
    public int getCount() {
        return 18;
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
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.info_list_item, null);
            viewHolder = new ListViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ListViewHolder) convertView.getTag();
        }



        viewHolder.infoLabel.setText(getLabel(position));
        viewHolder.infoValue.setText(getValue(position));

        return convertView;
    }

    private String getLabel(int position){
        String label = "";

        switch(position){
            case 0:
                label = "Atomic Number";
                break;
            case 1:
                label = "Name";
                break;
            case 2:
                label = "Symbol";
                break;
            case 3:
                label = "Atomic Mass";
                break;
            case 4:
                label = "Electronic Configuration";
                break;
            case 5:
                label = "Electronegativity";
                break;
            case 6:
                label = "Atomic Radius";
                break;
            case 7:
                label = "Van der Waals Radius";
                break;
            case 8:
                label = "Ionization Energy";
                break;
            case 9:
                label = "Electron Affinity";
                break;
            case 10:
                label = "Oxidation States";
                break;
            case 11:
                label = "Standard State";
                break;
            case 12:
                label = "Bonding Type";
                break;
            case 13:
                label = "Melting Point";
                break;
            case 14:
                label = "Boiling Point";
                break;
            case 15:
                label = "Density";
                break;
            case 16:
                label = "Group Block";
                break;
            case 17:
                label = "Year Discovered";
                break;


        }
        return label;
    }

    private String getValue(int position){
        String value = "";

        switch(position){
            case 0:
                value = Integer.toString(element.getAtomicNumber());
                break;
            case 1:
                value = element.getElementName();
                break;
            case 2:
                value = element.getSymbol();
                break;
            case 3:
                value = element.getAtomicMass();
                break;
            case 4:
                value = element.getElectronicConfiguration();
                break;
            case 5:
                if(element.getElectronegativity()!=0){
                    value = Float.toString(element.getElectronegativity());
                }else{
                    value = "-";
                }

                break;
            case 6:
                if(element.getAtomicRadius()!=0){
                    value = Integer.toString(element.getAtomicRadius());
                }else{
                    value = "-";
                }

                break;
            case 7:
                if(element.getVanDerWaalsRadius()!=0){
                    value = Integer.toString(element.getVanDerWaalsRadius());
                }else{
                    value = "-";
                }
                break;
            case 8:
                if(element.getIonizationEnergy()!=0){
                    value = Integer.toString(element.getIonizationEnergy());
                }else {
                    value = "-";
                }
                break;
            case 9:
                if(element.getElectronAffinity()!=0){
                    value = Integer.toString(element.getElectronAffinity());
                }else{
                    value = "-";
                }
                break;
            case 10:
                value = element.getOxidationStates();
                break;
            case 11:
                value = element.getStandardState();
                break;
            case 12:
                value = element.getBondingType();
                break;
            case 13:
                if(element.getMeltingPoint()!=0){
                    value = Integer.toString(element.getMeltingPoint());
                }else{
                    value = "-";
                }

                break;
            case 14:
                if(element.getBoilingPoint()!=0){
                    value = Integer.toString(element.getBoilingPoint());
                }else{
                    value = "-";
                }
                break;
            case 15:
                if(element.getDensity()!=0){
                    value = Double.toString(element.getDensity());
                }else{
                    value = "-";
                }
                break;
            case 16:
                value = element.getGroupBlock();
                break;
            case 17:
                if(element.getYearDiscovered()!=-1){
                    value = Integer.toString(element.getYearDiscovered());
                }else{
                    value = "Ancient";
                }
                break;


        }
        return value;
    }


    static class ListViewHolder {

        @Bind(R.id.label)
        TextView infoLabel;

        @Bind(R.id.value)
        TextView infoValue;


        ListViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }
}
