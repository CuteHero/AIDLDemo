package top.liziyang.aidlservice;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by liziyang on 16/3/15.
 */
public class Person implements Parcelable {

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(Parcel parcel) {
        name = parcel.readString();
        age = parcel.readInt();
    }

    private String name;
    private int age;

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 序列化 封装成Parcel
     *
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }

    /**
     * the class implemented Parcelable interface need provide a CREATOR field.
     */
    public static final Creator<Person> CREATOR = new Creator<Person>() {
        /**
         * 反序列化 返回Person对象
         * @param source
         * @return
         */
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[0];
        }
    };
}
