package demos.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class LambdasAndMethodReferences {
    public static void main(String[] args) {
        staticMR();
        boundMR();
        unboundMR();
        constructorMR();
    }

    public static void staticMR() {
        List<Integer> nums = new ArrayList<>(Arrays.asList( 1, 2, 7, 4, 5));
        System.out.println("before sorting with lambda" + nums);
        Consumer<List<Integer>> numsConsumer = lst -> Collections.sort(lst);
        numsConsumer.accept(nums);
        System.out.println("after sorting with lambda" + nums);


        List<Integer> nums1 = new ArrayList<>(Arrays.asList( 1, 2, 7, 4, 5));
        System.out.println("before sorting with MR" + nums1);
        //how does Java know which version to call
        // due to context only contains list not list and comparator
        Consumer<List<Integer>> nums1Consumer = Collections::sort;
        nums1Consumer.accept(nums1);
        System.out.println("after sorting with MR" + nums1);


    }
    public static void boundMR() {
        String name = "Mr. Joe Bloggs";
        Predicate<String> stringPredicateLambda = (str) -> name.startsWith(str);
        System.out.println("lambda check starts with : " + stringPredicateLambda.test("Mr."));
        System.out.println("lambda check starts with : " + stringPredicateLambda.test("Ms."));

        Predicate<String> stringPredicateMR = name::startsWith;
        System.out.println("MR check starts with : " + stringPredicateMR.test("Mr."));
        System.out.println("MR check starts with : " + stringPredicateMR.test("Ms."));
    }
    public static void unboundMR() {
        Predicate<String> stringPredicateLambda = (str) -> str.isEmpty();
        System.out.println("lambda check empty : " + stringPredicateLambda.test(""));
        System.out.println("lambda check empty : " + stringPredicateLambda.test("xyz"));

        Predicate<String> stringPredicateMR = String::isEmpty;
        System.out.println("MR check starts with : " + stringPredicateMR.test(""));
        System.out.println("MR check starts with : " + stringPredicateMR.test("xyz"));


        BiPredicate<String, String> biPredicateStringLambda = (str1, str2) -> str1.startsWith(str2);
        System.out.println("lambda check first starts with second : " + biPredicateStringLambda.test("Mr. Joe Bloggs", "Mr."));
        System.out.println("lambda check first starts with second : " + biPredicateStringLambda.test("Mr. Joe Bloggs", "Ms."));

        BiPredicate<String, String> biPredicateStringMR = String::startsWith;
        System.out.println("MR check first starts with second : " + biPredicateStringMR.test("Mr. Joe Bloggs", "Mr."));
        System.out.println("MR check first starts with second : " + biPredicateStringMR.test("Mr. Joe Bloggs", "Ms."));
    }
    public static void constructorMR() {
        Supplier<List<String>> listSupplierLambda = () -> new ArrayList<>();
        List<String> listLambda = listSupplierLambda.get();
        listLambda.add("Lambda");
        System.out.println(listLambda);

        Supplier<List<String>> listSupplierMR = ArrayList::new;
        List<String> listMR = listSupplierMR.get();
        listMR.add("Method Reference");
        System.out.println(listMR);

        Function<Integer, List<String>> listFunctionLambda = (x) -> new ArrayList<>(x);
        List<String> listFunLambda = listFunctionLambda.apply(10);
        listFunLambda.add("Lambda");
        System.out.println(listFunLambda);

        Function<Integer, List<String>> listFunctionMR = ArrayList::new;
        List<String> listFunMR = listFunctionMR.apply(10);
        listFunMR.add("Method Reference");
        System.out.println(listFunMR);
    }

}
