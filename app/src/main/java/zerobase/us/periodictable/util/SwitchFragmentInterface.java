package zerobase.us.periodictable.util;

import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by arvindchellapondy on 9/5/15.
 */
public interface SwitchFragmentInterface {
    public void switchToFragment(Fragment targetFragment);

    public void switchToFragment(Fragment targetFragment, boolean addToBackstack);

    public void switchToFragment(Fragment targetFragment, boolean addToBackStack, Bundle bundle);
}
