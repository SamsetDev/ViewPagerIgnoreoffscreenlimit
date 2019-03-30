package com.samset.viewpager.sample.observe;

/**
 * Copyright (C) ViewpaggerIgnorePagelimit - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited Proprietary and confidential.
 * <p>
 * Created by samset on 30/03/19 at 12:58 PM for ViewpaggerIgnorePagelimit .
 */


public interface MyObservable {

    void addObserver(MyObserver maddObserver);
    void removeObserver(MyObserver rmObserver);
    void notifyObservers1(String data);
    void notifyObservers2(String data);
    void notifyObservers3(String data);
    void notifyObservers4(String data);
}
