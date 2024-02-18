package com.alterdekim.rxtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.alterdekim.rxtest.model.Department;
import com.alterdekim.rxtest.model.DepartmentsResponse;
import com.alterdekim.rxtest.model.EmployeeResponse;
import com.alterdekim.rxtest.model.ObjectIdsResponse;
import com.alterdekim.rxtest.network.ApiFactory;
import com.alterdekim.rxtest.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    List<Department> departments;


    private void prepareDepartmentInfo(Department department) {

        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();

        Disposable disposable = apiService.getObjects(department.getDepartmentId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ObjectIdsResponse>() {
                    @Override
                    public void accept(ObjectIdsResponse objectIdsResponse) throws Exception {
                        department.setObjectIDs(objectIdsResponse.getObjectIDs());
                        Log.d("OBSRXTEST", "dddd");
                        //prepareDepartmentInfo();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("OBSRXTEST", "azzzzz");
                        departments = new ArrayList<>();
                    }
                });

        compositeDisposable.add(disposable);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();

//        Observable<DepartmentsResponse> oad = apiService.getDepartments();



        Disposable disposable = apiService.getDepartments()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DepartmentsResponse>() {
                    @Override
                    public void accept(DepartmentsResponse departmentsResponse) throws Exception {
                        Log.d("OBSRXTEST", "dddd");
                        // view.showData(departmentsResponse.getDepartments());
                        departments = departmentsResponse.getDepartments();
                        prepareDepartmentInfo(departments.get(0));

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("OBSRXTEST", "azzzzz");
                        departments = new ArrayList<>();
                    }
                });

        compositeDisposable.add(disposable);




//


//        Observable myObservable = Observable.just("Blue Factory");
//
//        Observer<String> o = new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d("OBSRXTEST", "onSubscribe");
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.d("OBSRXTEST", s);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d("OBSRXTEST", "onError");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d("OBSRXTEST", "onComplete");
//            }
//        };
//
//        myObservable.subscribe((io.reactivex.Observer) o);
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.dispose();
        super.onDestroy();
    }

}