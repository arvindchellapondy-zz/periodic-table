package zerobase.us.periodictable.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by arvindchellapondy on 9/6/15.
 */
public class Element implements Parcelable {

    @SerializedName("atomicNumber")
    int atomicNumber;

    @SerializedName("name")
    String elementName;

    @SerializedName("symbol")
    String symbol;

    @SerializedName("atomicMass")
    String atomicMass;

    @SerializedName("electronicConfiguration")
    String electronicConfiguration;

    @SerializedName("electronegativity")
    float electronegativity;

    @SerializedName("atomicRadius")
    int atomicRadius;

    @SerializedName("ionRadius")
    String ionRadius;

    @SerializedName("vanDerWaalsRadius")
    int vanDerWaalsRadius;

    @SerializedName("ionizationEnergy")
    int ionizationEnergy;

    @SerializedName("electronAffinity")
    int electronAffinity;

    @SerializedName("oxidationStates")
    String oxidationStates;

    @SerializedName("standardState")
    String standardState;

    @SerializedName("bondingType")
    String bondingType;

    @SerializedName("meltingPoint")
    int meltingPoint;

    @SerializedName("boilingPoint")
    int boilingPoint;

    @SerializedName("density")
    double density;

    @SerializedName("groupBlock")
    String groupBlock;

    @SerializedName("yearDiscovered")
    int yearDiscovered;

    @SerializedName("description")
    String description;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.atomicNumber);
        dest.writeString(this.elementName);
        dest.writeString(this.symbol);
        dest.writeString(this.atomicMass);
        dest.writeString(this.electronicConfiguration);
        dest.writeFloat(this.electronegativity);
        dest.writeInt(this.atomicRadius);
        dest.writeString(this.ionRadius);
        dest.writeInt(this.vanDerWaalsRadius);
        dest.writeInt(this.ionizationEnergy);
        dest.writeInt(this.electronAffinity);
        dest.writeString(this.oxidationStates);
        dest.writeString(this.standardState);
        dest.writeString(this.bondingType);
        dest.writeInt(this.meltingPoint);
        dest.writeInt(this.boilingPoint);
        dest.writeDouble(this.density);
        dest.writeString(this.groupBlock);
        dest.writeInt(this.yearDiscovered);
        dest.writeString(this.description);
    }

    public Element() {
    }

    protected Element(Parcel in) {
        this.atomicNumber = in.readInt();
        this.elementName = in.readString();
        this.symbol = in.readString();
        this.atomicMass = in.readString();
        this.electronicConfiguration = in.readString();
        this.electronegativity = in.readFloat();
        this.atomicRadius = in.readInt();
        this.ionRadius = in.readString();
        this.vanDerWaalsRadius = in.readInt();
        this.ionizationEnergy = in.readInt();
        this.electronAffinity = in.readInt();
        this.oxidationStates = in.readString();
        this.standardState = in.readString();
        this.bondingType = in.readString();
        this.meltingPoint = in.readInt();
        this.boilingPoint = in.readInt();
        this.density = in.readDouble();
        this.groupBlock = in.readString();
        this.yearDiscovered = in.readInt();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<Element> CREATOR = new Parcelable.Creator<Element>() {
        public Element createFromParcel(Parcel source) {
            return new Element(source);
        }

        public Element[] newArray(int size) {
            return new Element[size];
        }
    };

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public String getElementName() {
        return elementName;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getAtomicMass() {
        return atomicMass;
    }

    public int getAtomicRadius() {
        return atomicRadius;
    }

    public String getElectronicConfiguration() {
        return electronicConfiguration;
    }

    public float getElectronegativity() {
        return electronegativity;
    }

    public int getElectronAffinity() {
        return electronAffinity;
    }

    public double getDensity() {
        return density;
    }

    public int getBoilingPoint() {
        return boilingPoint;
    }

    public int getIonizationEnergy() {
        return ionizationEnergy;
    }

    public int getMeltingPoint() {
        return meltingPoint;
    }

    public int getVanDerWaalsRadius() {
        return vanDerWaalsRadius;
    }

    public int getYearDiscovered() {
        return yearDiscovered;
    }

    public String getBondingType() {
        return bondingType;
    }

    public String getDescription() {
        return description;
    }

    public String getGroupBlock() {
        return groupBlock;
    }

    public String getIonRadius() {
        return ionRadius;
    }

    public String getOxidationStates() {
        return oxidationStates;
    }

    public String getStandardState() {
        return standardState;
    }
}
