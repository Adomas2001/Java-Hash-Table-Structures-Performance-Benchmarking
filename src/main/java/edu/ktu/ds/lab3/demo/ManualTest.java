package edu.ktu.ds.lab3.demo;

import edu.ktu.ds.lab3.utils.*;

import java.util.Locale;

import static edu.ktu.ds.lab3.utils.HashMap.DEFAULT_INITIAL_CAPACITY;
import static edu.ktu.ds.lab3.utils.HashMap.DEFAULT_LOAD_FACTOR;

public class ManualTest {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // we standardize number formats
        executeTest();
    }

    public static void executeTest() {
        Car car1 = new Car("Renault", "Laguna", 1997, 50000, 1700);
        Car car2 = new Car("Renault", "Megane", 2001, 20000, 3500);
        Car car3 = new Car("Toyota", "Corolla", 2001, 20000, 8500.8);
        Car car4 = new Car("Renault Laguna 2001 115900 7500");
        Car car5 = new Car.Builder().buildRandom();
        Car car6 = new Car("Honda   Civic  2007  36400 8500.3");
        Car car7 = new Car("Renault Laguna 2001 115900 7500");

        // view key array
        String[] carsIds = {"TA156", "TA102", "TA178", "TA126", "TA105", "TA106", "TA107", "TA108"};
        // An array of view values
        Car[] cars = {car1, car2, car3, car4, car5, car6, car7};

        executeCarMapTests(carsIds, cars);
        executeCarMapOaTests(carsIds, cars);
    }

    private static void executeCarMapTests(String[] carsIds, Car[] cars) {
        ParsableMap<String, Car> carsMap
                = new ParsableHashMap<>(String::new, Car::new, DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, HashManager.HashType.DIVISION);

        for (int id = 0; id < cars.length; id++) {
            carsMap.put(carsIds[id], cars[id]);
        }

        Ks.oun("Arrangement of pairs in the view by keys:");
        carsMap.println("");
        Ks.oun("Is there a pair in the picture?");
        Ks.oun(carsMap.contains(carsIds[6]));
        Ks.oun(carsMap.contains(carsIds[7]));
        Ks.oun("Arrangement of pairs in the view by keys. Only keys are shown:");
        carsMap.println("=");

        Ks.oun("\n" +
                "We are searching for pairs in the view:");
        Ks.oun(carsMap.get(carsIds[2]));
        Ks.oun(carsMap.get(carsIds[7]));
        Ks.oun("We print the view pairs in String:");
        Ks.ounn(carsMap);

        ///method number of collisions
        int numberofcol=carsMap.numberofcollisions();
        Ks.oun("number of colliions in separate chaining " + numberofcol);


        /// Remove method
        Ks.oun("Remove method");
        Car removedcar=carsMap.remove("TA156");
        Ks.oun("removed car" + removedcar);
        Ks.oun("after remove hash Table");
        carsMap.println("");


        ///Replace method
        Ks.oun("Replace method");
        Ks.oun("replace :" + carsMap.replace(carsIds[1],cars[1],cars[2]));
        carsMap.println("");



        ////contains value method
        Ks.oun("contains value method");
        Ks.oun(carsMap.containsValue(cars[3]));




    }

    private static void executeCarMapOaTests(String[] carsIds, Car[] cars) {
        ParsableMap<String, Car> carsMapOa
                = new ParsableHashMapOa<>(String::new, Car::new, DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, HashManager.HashType.DIVISION, HashMapOa.OpenAddressingType.LINEAR);

        for (int id = 0; id < cars.length; id++) {
            carsMapOa.put(carsIds[id], cars[id]);
        }

        Ks.oun("Location of pairs in the open address view by keys:");
        carsMapOa.println("");
        Ks.oun("Is there a pair in the open address view?");
        Ks.oun(carsMapOa.contains(carsIds[6]));
        Ks.oun(carsMapOa.contains(carsIds[7]));
        Ks.oun("Arrangement of pairs in an open addressing view by keys. Only keys are shown:");
        carsMapOa.println("=");

        Ks.oun("We are searching for pairs in the open address view:");
        Ks.oun(carsMapOa.get(carsIds[2]));
        Ks.oun(carsMapOa.get(carsIds[7]));
        Ks.oun("We print the pairs of the open address view in the String line:");
        Ks.ounn(carsMapOa);

        ////Remove method
        Ks.oun("remove method");
        Car removedcar=carsMapOa.remove("TA156");
        Ks.oun("removed car" + removedcar);
        carsMapOa.println("");

        /////Replace method

        Ks.oun("Replace method");
        Ks.oun("replace :" + carsMapOa.replace(carsIds[1],cars[1],cars[2]));
        carsMapOa.println("");

        /////////contains value method
                Ks.oun("contains value method");
                Ks.oun(carsMapOa.containsValue(cars[3]));

                ///replaceALL
        Ks.oun("replace all methoddddd");
        carsMapOa.println("");
        carsMapOa.replaceAll(cars[4],cars[2]);
        carsMapOa.println("");


    }
}
