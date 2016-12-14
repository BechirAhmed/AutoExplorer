package auto.explorer.parser;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import auto.explorer.model.Car;
import auto.explorer.model.SearchProfile;
import auto.explorer.parser.auto.de.CallableAutoDe;
import auto.explorer.parser.auto.de.DetailPageAutoDe;
import auto.explorer.parser.autoscout24.CallableAutoScout24;
import auto.explorer.parser.autoscout24.DetailPageAutoScout24;
import auto.explorer.parser.mobile.de.CallableMobileDe;
import auto.explorer.parser.mobile.de.DetailPageMobileDe;
import auto.explorer.parser.verivox.CallableVerivox;
import auto.explorer.parser.verivox.DetailPageVerivox;
import auto.explorer.util.Const;

/**
 * Created by Eugene on 19.10.2016
 */
public class RequestParserHelper {

    private static RequestParserHelper instance = new RequestParserHelper();
    private final ExecutorService service;
    private final List<Callable<ArrayList<Car>>> tasks = new ArrayList<>();
    private CanReceiveSearchResult callback;
    private List<Future<ArrayList<Car>>> futureList;
    private final Handler handler;

    public static RequestParserHelper getInstance() {
        return instance;
    }

    private RequestParserHelper() {
        service = Executors.newCachedThreadPool();
        handler = new Handler(Looper.getMainLooper());
    }

    public synchronized void searchCars(@NonNull final SearchProfile p, final int page,
                                        @NonNull final CanReceiveSearchResult c,
                                        @NonNull final TaskCompleteListener listener) {
        this.callback = c;
        service.execute(new Runnable() {
            @Override
            public void run() {
                final ArrayList<Car> cars = new ArrayList<>();
                tasks.clear();
                createTasks(p, page, listener);
                try {
                    futureList = service.invokeAll(tasks);
                    for (Future<ArrayList<Car>> future : futureList) {
                        ArrayList<Car> list = future.get();
                        if (list != null) cars.addAll(list);
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (callback != null) callback.onSearchCompleted(cars);
                    }
                });
            }
        });
    }

    private void createTasks(@NonNull SearchProfile p, int page, @NonNull TaskCompleteListener listener) {
        tasks.add(new CallableAutoScout24(p, String.valueOf(page), listener));
        tasks.add(new CallableMobileDe(p, String.valueOf(page), listener));
//        tasks.add(new CallableAutoDe(p, String.valueOf(page), listener));
//        tasks.add(new CallableVerivox(p, String.valueOf(page), listener));
        Log.i("***", "TASK CREATED: " + tasks.size());
    }

    public synchronized void loadCarDetail(@NonNull final Car car, @NonNull final DetailPageLoadListener listener) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                switch (car.getOrigin()) {
                    case Const.SITE_AUTO_SCOUT_24:
                        DetailPageAutoScout24.parsePage(car, listener);
                        break;
                    case Const.SITE_MOBILE_DE:
                        DetailPageMobileDe.parsePage(car, listener);
                        break;
                    case Const.SITE_AUTO_DE:
                        DetailPageAutoDe.parsePage(car, listener);
                        break;
                    case Const.SITE_VERIVOX:
                        DetailPageVerivox.parsePage(car, listener);
                        break;
                }
            }
        });
    }

    public interface TaskCompleteListener {
        void onTaskComplete();
    }

    public interface DetailPageLoadListener {
        void onCarDetailPageLoad();
    }
}
