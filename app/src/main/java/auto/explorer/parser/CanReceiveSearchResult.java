package auto.explorer.parser;

import java.util.ArrayList;

import auto.explorer.model.Car;

/**
 * Created by Eugene on 19.10.2016
 */

public interface CanReceiveSearchResult {
    void onSearchCompleted(ArrayList<Car> cars);
}
