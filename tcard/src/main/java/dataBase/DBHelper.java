package dataBase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper{
        public static final String DBNAME = "Login.db";
        public DBHelper(Context context) {
            super(context, "Login.db", null, 1);
        }


    @Override
        public void onCreate(SQLiteDatabase MyDB) {
            MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
            MyDB.execSQL("drop Table if exists users");
        }

        public Boolean insertData(String username, String password){
            SQLiteDatabase MyDB = this.getWritableDatabase();
            ContentValues contentValues= new ContentValues();
            contentValues.put("username", username);
            contentValues.put("password", password);
            long result = MyDB.insert("users", null, contentValues);
            if(result==-1) return false;
            else
                return true;
        }

        public Boolean checkusername(String username) {
            SQLiteDatabase MyDB = this.getWritableDatabase();
            Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
            if (cursor.getCount() > 0)
                return true;
            else
                return false;
        }

        public Boolean checkusernamepassword(String username, String password){
            SQLiteDatabase MyDB = this.getWritableDatabase();
            Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
            if(cursor.getCount()>0)
                return true;
            else
                return false;
        }
        //TODO update setpassword to access current cell in table and modify value password
        public static void setpassword(String password) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            String title = "MyNewTitle";
            ContentValues values = new ContentValues();
            values.put(FeedEntry.COLUMN_NAME_TITLE, title);
x

            String selection = FeedEntry.COLUMN_NAME_TITLE + " LIKE ?";
            String[] selectionArgs = { "MyOldTitle" };

            int count = db.update(
                    FeedReaderDbHelper.FeedEntry.TABLE_NAME,
                    values,
                    selection,
                    selectionArgs);

        }

}
