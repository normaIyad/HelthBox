package com.example.myapp1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public static final String name ="HealthCare.db";
    public static final int version = 79;
    private static final String TABLE_DOCTOR = "Doctors";
    private static final String TABLE_TEST = "test";
    private static final String TABLE_TESTS_PACKAGES ="TESTS_PACKAGES";
    private static final String COLUMN_ID = "_id";
    private static final String TESTS_ID = "TEST_ID";
    private static final String COLUMN_NAME = "contactName";
    private static final String COLUMN_DEC ="description";
    private static final String COLUMN_NO = "phoneNumber";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_CITY = "city";
    private static final String COLUMN_specialty = "specialty";
    private static final String TABLE_TEST_FILE = "test_file";
    private static final String COLUMN_FILE_NAME = "file_name";
    private static final String COLUMN_FILE_ID = "file_id";
    private static final String COLUMN_FILE_DATE = "file_date";
    private static final String COLUMN_FILE_USER_ID = "user_id";
    private static final String COLUMN_FILE_COMPONY_ID = "compony_id";
    private static final String taple = "test_file";
    public static final String  id = "user_id";
    private static String table_test_pac = "test_pac";
    public Database(@Nullable Context context ) {
        super(context, name, null, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE USERS (username text ,email text , password text , phone int not null primary key  )";
       db.execSQL(query);
        String query2 ="CREATE TABLE appointment ( ID INTEGER , username  TEXT, id_number INTEGER, address  TEXT, compony_name  TEXT, doctor_name  TEXT ,date  DATE,phone_number INTEGER,appointment_type  TEXT,test_name  TEXT,test_paceg  TEXT)";
        db.execSQL(query2);
        String CREATE_CONTACTS_TABLE = "CREATE TABLE "
                + TABLE_DOCTOR + "(" + COLUMN_ID
                + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_NO + " INTEGER,"
                + COLUMN_ADDRESS + " TEXT,"
                +COLUMN_CITY + " TEXT,"
                +COLUMN_specialty +" TEXT"+")";

        db.execSQL(CREATE_CONTACTS_TABLE);
        String CREATE_TEST_TABLE = "CREATE TABLE "
                + TABLE_TEST + "(" + COLUMN_ID
                + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_DEC + " TEXT"+")";
        db.execSQL(CREATE_TEST_TABLE);
        String test_pac = "CREATE TABLE "+table_test_pac +" (id INTEGER PRIMARY KEY , name STRING , des STRING )";
        db.execSQL(test_pac);
        String query5 = "CREATE TABLE "+ taple +" (name text , id int not null primary key , date string , user_id int  , company_id int )";
        db.execSQL(query5);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS USERS");
        db.execSQL("DROP TABLE IF EXISTS appointment ");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DOCTOR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEST);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_TESTS_PACKAGES);
        db.execSQL("DROP TABLE IF EXISTS " + taple);
        db.execSQL("DROP TABLE IF EXISTS "+ table_test_pac);
        onCreate(db);
    }
    public void register(User user){
        ContentValues cv = new ContentValues();
        cv.put("username" ,user.getName());
        cv.put("email",user.getEmail());
        cv.put("password",user.getPassword1());
        cv.put("phone",user.getNumber());
        SQLiteDatabase db = getWritableDatabase();
        db.insert("USERS" ,null,cv);
        db.close();
    }
    public void meeting(meeting m  ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", m.getUsername());
        values.put("id_number", m.getId_number());
        values.put("address", m.getAddress());
        values.put("compony_name", m.getCompony_name());
        values.put("doctor_name", m.getDoctor_name());
        values.put("date", m.getDate()); // Store date as a Unix timestamp
        values.put("phone_number", m.getPhone_number());
        values.put("appointment_type", m.getAppointment_type());
        values.put("test_name", m.getTest_name());
        values.put("test_paceg", m.getTest_paceg());
        db.insert("meetings", null, values);
        db.close();
    }
    public int log_in(String email , String password){
        int result =0;
        String str[]=new String[2];
        str[0]=email;
        str[1]=password;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM USERS WHERE email=? and password=? " , str);
        if (c.moveToFirst()){
            result =1;
        }
        return result;
    }

    ArrayList<Doctor> listContacts() {
        String sql = "select * from " + TABLE_DOCTOR;
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Doctor> storeDoctors = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String phno = cursor.getString(2);
                String add = cursor.getString(3);
                String cit = cursor.getString(4);
                String sp = cursor.getString(5);
                storeDoctors.add(new Doctor(id, name, phno , add , cit , sp));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return storeDoctors;
    }
    ArrayList<Doctor> listContacts_Found(String val) {
        String sql = "select * from " + TABLE_DOCTOR +" WHERE "+ COLUMN_NAME +" LIKE'%"+ val +"%'";
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Doctor> storeDoctors = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String phno = cursor.getString(2);
                String add = cursor.getString(3);
                String ci = cursor.getString(4);
                String sp = cursor.getString(5);
                storeDoctors.add(new Doctor(id, name, phno , add , ci , sp ));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return storeDoctors;
    }
    void addContacts(Doctor doctor) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, doctor.getName());
        values.put(COLUMN_NO, doctor.getPhoneNumber());
        values.put(COLUMN_ADDRESS ,doctor.getAddress());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_DOCTOR, null, values);
    }
    void addContacts_Test(Test test) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,test.getName());
        values.put(COLUMN_DEC, test.getDescription());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_TEST, null, values);
    }
    ArrayList<Test> listTest() {
        String sql = "select * from " + TABLE_TEST;
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Test> storeDoctors = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String dec = cursor.getString(2);
                storeDoctors.add(new Test(id, name, dec));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return storeDoctors;
    }
    ArrayList<Test> listContacts_Found_Test(String val) {
        String sql = "select * from " + TABLE_DOCTOR +" WHERE "+ COLUMN_NAME +" LIKE ?";
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Test> storeDoctors = new ArrayList<>();
        String[] selectionArgs = new String[]{"%" + val + "%"};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String dec = cursor.getString(2);
                storeDoctors.add(new Test(id, name, dec));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return storeDoctors;
    }

    public void  addfile (TestResult t ){
        ContentValues c = new ContentValues();
        c.put("name",t.getName());
        c.put("id",t.getId());
        c.put("date", t.getDate());
        c.put("user_id", t.getUser_id());
        c.put("company_id", t.getCompony_id());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(taple , null , c);
        db.close();
    }
    ArrayList<TestResult> listContacts_file(int ids) {
        String sql = " select * from "+ taple +" WHERE "+id +"="+ ids;
        //" WHERE user_id ="+ids
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<TestResult> storeDoctors = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(0);
                int id = Integer.parseInt(cursor.getString(1));
                String date = cursor.getString(2);
                int user_id = Integer.parseInt(cursor.getString(3));
                int compony_id = Integer.parseInt(cursor.getString(4));
                storeDoctors.add(new TestResult(name , id , date , user_id , compony_id));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return storeDoctors;
    }
    public void add_test_pac(test_pac t){
        ContentValues v = new ContentValues();
        v.put("name" ,t.getName());
        v.put("des",t.getDrs());
        SQLiteDatabase d = getWritableDatabase();
        d.insert(table_test_pac ,null, v);
    }
    ArrayList<test_pac> listTest_pac() {
        String sql = "select * from " + table_test_pac;
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<test_pac> storeDoctors = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String dec = cursor.getString(2);
                storeDoctors.add(new test_pac(id, name, dec));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return storeDoctors;
    }
    ArrayList<test_pac> listTest_pac_search(String v ) {
        String sql = "select * from " + table_test_pac + " WHERE name LIKE ?";
        SQLiteDatabase db = this.getReadableDatabase();
        String  [] val = new String[]{"%" + v + "%"};
        ArrayList<test_pac> storeDoctors = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql,val );

        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String dec = cursor.getString(2);
                storeDoctors.add(new test_pac(id, name, dec));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return storeDoctors;
    }
}
