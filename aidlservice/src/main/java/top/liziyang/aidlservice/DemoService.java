package top.liziyang.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.ArrayList;
import java.util.List;

public class DemoService extends Service {

    List<Person> personList;

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    IBinder iBinder = new IAIDLDemo.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
            //
        }

        @Override
        public int add(int number1, int number2) throws RemoteException {
            return number1 + number2;
        }

        @Override
        public List<Person> getPersonList(Person person) throws RemoteException {
            personList = new ArrayList<>();
            personList.add(person);
            personList.add(new Person("小白", 24));
            return personList;
        }
    };
}
