package zerobase.us.periodictable.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by arvindchellapondy on 9/6/15.
 */
public class Elements implements Parcelable {

    @SerializedName("elements")
    ArrayList<Element> elements;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(elements);
    }

    public Elements() {
    }

    protected Elements(Parcel in) {
        this.elements = in.createTypedArrayList(Element.CREATOR);
    }

    public static final Parcelable.Creator<Elements> CREATOR = new Parcelable.Creator<Elements>() {
        public Elements createFromParcel(Parcel source) {
            return new Elements(source);
        }

        public Elements[] newArray(int size) {
            return new Elements[size];
        }
    };

    public ArrayList<Element> getElements() {
        return elements;
    }
}
