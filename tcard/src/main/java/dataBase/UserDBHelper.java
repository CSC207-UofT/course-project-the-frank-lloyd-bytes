package dataBase;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

/*
  A User Database Helper class that set up, add, edit, delete the database.
 */
public class UserDBHelper extends SQLiteOpenHelper{
        public ArrayList<String> infolist = new ArrayList<String>();
        public static final String DB_NAME = "User.db";
        public static final String TABLE_NAME = "users";
        public static final String [] COL_LIST = {"UTROID","PASSWORD","LEGAL_NAME_F","LEGAL_NAME_L","STATUS","ID_NUMBER","EMAIL","YEAR_IN_UOFT","BELONGTO"};



    /**
     * Create a UserDBHelper
     * @param context the context of the class which calls this constructor
     */
        public UserDBHelper(Context context) {
            super(context, DB_NAME, null, 1);
        }


    /**
     * Create a table when the database is created for the first time
     * @param MyDB the database where we put the table.
     */
        @Override
        public void onCreate(SQLiteDatabase MyDB) {
            MyDB.execSQL("create Table "+TABLE_NAME+" (UTROID TEXT primary key,PASSWORD TEXT,LEGAL_NAME_F TEXT," +
                    "LEGAL_NAME_L TEXT ,STATUS TEXT,ID_NUMBER TEXT,EMAIL TEXT,YEAR_IN_UOFT TEXT,BELONGTO TEXT)");
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
            onCreate(MyDB);
        }


        public Boolean insertData(String utroid, String password){
            SQLiteDatabase MyDB = this.getWritableDatabase();
            ContentValues contentValues= new ContentValues();
            contentValues.put(COL_LIST[0],utroid);
            contentValues.put(COL_LIST[1],password);
            long result = MyDB.insert(TABLE_NAME, null, contentValues);
            if(result==-1) return false;
            else
                return true;
        }

        public Boolean checkutorid(String username) {
            SQLiteDatabase MyDB = this.getWritableDatabase();
            @SuppressLint("Recycle") Cursor cursor = MyDB.rawQuery("Select * from users where UTROID = ?", new String[]{username});
            return cursor.getCount() > 0;
        }

        public Boolean checkutroidpassword(String username, String password){
            SQLiteDatabase MyDB = this.getWritableDatabase();
            @SuppressLint("Recycle") Cursor cursor = MyDB.rawQuery("Select * from users where UTROID = ? and PASSWORD = ?",
                    new String[] {username,password});
            return cursor.getCount() > 0;
        }

        public Cursor getData(String utroid){
            SQLiteDatabase MyDB = this.getWritableDatabase();
            Cursor res = MyDB.rawQuery("Select * from "+ TABLE_NAME+ " where UTROID = ? ", new String[] {utroid});
            return res;
        }
}
