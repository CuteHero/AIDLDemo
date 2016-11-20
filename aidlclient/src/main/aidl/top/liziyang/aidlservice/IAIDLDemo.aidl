// IAIDLDemo.aidl
package top.liziyang.aidlservice;

// Declare any non-default types here with import statements
import top.liziyang.aidlservice.Person;

interface IAIDLDemo {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
    int add(int number1, int number2);

    List<Person> getPersonList(in Person person);
}
