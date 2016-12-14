package auto.explorer.util;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;

import auto.explorer.model.Car;
import auto.explorer.model.CurrentState;

import static android.text.TextUtils.isEmpty;
import static auto.explorer.util.Const.NOT_EXIST;

/**
 * Created by Eugene on 21.10.2016
 */

public final class Util {

    private static final AlphaNumComparator comparator = new AlphaNumComparator();

    private Util() {
    }

    public static void sort(ArrayList list) {
        Collections.sort(list, comparator);
    }

    public static int isFavoriteExist(@NonNull Car car) {
        final ArrayList<Car> fav = CurrentState.getInstance().getFavList();
        if (isEmpty(car.getLinkToDetails()) || isEmpty(car.getTitle())) return NOT_EXIST;
        final String link = getUrl(car.getLinkToDetails());
        final String title = car.getTitle();
        for (int i = 0; i < fav.size(); i++) {
            Car c = fav.get(i);
            final String fl = c.getLinkToDetails();
            final String ft = c.getTitle();
            if (isEmpty(fl) || isEmpty(ft)) continue;
            if (getUrl(fl).equals(link) || ft.equals(title)) {
                return i;
            }
        }
        return NOT_EXIST;
    }

    private static String getUrl(String s) {
        int i = s.indexOf("?");
        return i == -1 ? s : s.substring(0, i);
    }

    @NonNull
    public static String diff(@NonNull String def, @NonNull String str) {
        return str.equals(def) ? "" : str;
    }
}
