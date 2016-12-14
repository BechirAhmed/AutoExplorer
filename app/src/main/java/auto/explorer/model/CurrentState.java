package auto.explorer.model;

import java.util.ArrayList;

/**
 * Created by Eugene on 19.10.2016
 */
public class CurrentState {

    private static CurrentState instance = new CurrentState();
    private final ArrayList<Car> carList = new ArrayList<>();
    private int totalFound;
    private int currentPage;
    private boolean advSearchCollapsed = true;
    private boolean advSearchColorViewCollapsed = true;
    private boolean advSearchCarTypeCollapsed = true;
    private boolean advSearchEquipCollapsed = true;
    private final ArrayList<Car> favList = new ArrayList<>();
    private final ArrayList<SearchProfile> profilesList = new ArrayList<>();
    private final SearchProfile searchProfile = new SearchProfile();
    private Settings settings;

    public static CurrentState getInstance() {
        return instance;
    }

    private CurrentState() {
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }

    public int getTotalFound() {
        return totalFound;
    }

    public void setTotalFound(int totalFound) {
        this.totalFound = totalFound;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean isAdvSearchCollapsed() {
        return advSearchCollapsed;
    }

    public void setAdvSearchCollapsed(boolean advSearchCollapsed) {
        this.advSearchCollapsed = advSearchCollapsed;
    }

    public boolean isAdvSearchColorViewCollapsed() {
        return advSearchColorViewCollapsed;
    }

    public void setAdvSearchColorViewCollapsed(boolean advSearchColorViewCollapsed) {
        this.advSearchColorViewCollapsed = advSearchColorViewCollapsed;
    }

    public boolean isAdvSearchCarTypeCollapsed() {
        return advSearchCarTypeCollapsed;
    }

    public void setAdvSearchCarTypeCollapsed(boolean advSearchCarTypeCollapsed) {
        this.advSearchCarTypeCollapsed = advSearchCarTypeCollapsed;
    }

    public boolean isAdvSearchEquipCollapsed() {
        return advSearchEquipCollapsed;
    }

    public void setAdvSearchEquipCollapsed(boolean advSearchEquipCollapsed) {
        this.advSearchEquipCollapsed = advSearchEquipCollapsed;
    }

    public ArrayList<Car> getFavList() {
        return favList;
    }

    public ArrayList<SearchProfile> getProfilesList() {
        return profilesList;
    }

    public SearchProfile getSearchProfile() {
        return searchProfile;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }
}
