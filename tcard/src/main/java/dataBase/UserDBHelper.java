package dataBase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.IOException;
import java.util.ArrayList;

/*
  A User Database Helper class that set up, add, edit, delete the database.
 */
public class UserDBHelper extends SQLiteOpenHelper{
        public ArrayList<String> infolist = new ArrayList<String>();
        public static final String DB_NAME = "User.db";
        public static final String TABLE_NAME = "users";

    /**
     * Create a UserDBHelper
     * @param context the context of the class which calls this constructor
     */
        public UserDBHelper(Context context) {
            super(context, DB_NAME, null, 1);
            this.infolist.add("utorid");
            this.infolist.add("password");
            this.infolist.add("legalnameF");
            this.infolist.add("legalnameL");
            this.infolist.add("status");
            this.infolist.add("idNumber");
            this.infolist.add("email");
            this.infolist.add("yearsinUOFT");
            this.infolist.add("belongto");
        }
        public void initializeDB(){
            FileReader reader = new FileReader();
            try {
                ArrayList<String[]> buildList = reader.reader();
                for (String[] i : buildList) {
                    this.insertData(i);
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }

    /**
     * Create a table when the database is created for the first time
     * @param MyDB the database where we put the table.
     */
        @Override
        public void onCreate(SQLiteDatabase MyDB) {
            MyDB.execSQL("create Table TABLE_NAME(utorid TEXT primary key, password TEXT, legalnameF TEXT, " +
                    "legalnameL TEXT , status TEXT, idNumber TEXT, email TEXT, yearsinUOFT TEXT, belongto TEXT)");
        }

    /**
     * Delete the existing table
     * @param MyDB is the database we are in
     * @param i old version of the database
     * @param i1 new version of the database
     */
        @Override
        public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
            MyDB.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        }


    /**
     * Insert a list of user's information into the table.
     * @param userinfo
     * @return true if the insertion success, false if not.
     */
        public Boolean insertData(String[] userinfo){
            SQLiteDatabase MyDB = this.getWritableDatabase();
            ContentValues contentValues= new ContentValues();
            for (int i=0; i <= userinfo.length; i++){
                    String word = this.infolist.get(i);
                    contentValues.put(word, userinfo[i]);
            }
            long result = MyDB.insert(TABLE_NAME, null, contentValues);
            if(result==-1) return false;
            else
                return true;
        }

        public Boolean insertData(String utroid, String password){
            SQLiteDatabase MyDB = this.getWritableDatabase();
            ContentValues contentValues= new ContentValues();
            contentValues.put("utorid",utroid);
            contentValues.put("password",password);
            for (int i=2; i < this.infolist.size(); i++){
                String word = this.infolist.get(i);
                contentValues.put(word, "null");
            }
            long result = MyDB.insert(TABLE_NAME, null, contentValues);
            if(result==-1) return false;
            else
                return true;
        }

        public Boolean checkutorid(String username) {
            SQLiteDatabase MyDB = this.getWritableDatabase();
            Cursor cursor = MyDB.rawQuery("Select * from users where utorid = ?", new String[]{username});
            if (cursor.getCount() > 0)
                return true;
            else
                return false;
        }

        public Boolean checkusernamepassword(String username, String password){
            SQLiteDatabase MyDB = this.getWritableDatabase();
            Cursor cursor = MyDB.rawQuery("Select * from users where utorid = ? and password = ?",
                    new String[] {username,password});
            if(cursor.getCount()>0)
                return true;
            else
                return false;
        }
    public Boolean changepassword(String utroid, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where utorid = ? and password = ?",
                new String[] {utroid,password});
        for (int i=2; i < this.infolist.size(); i++){
            String word = this.infolist.get(i);
        }
        long result = MyDB.insert(TABLE_NAME, null, contentValues);
        if(result==-1) return false;
        else
            return true;
}
