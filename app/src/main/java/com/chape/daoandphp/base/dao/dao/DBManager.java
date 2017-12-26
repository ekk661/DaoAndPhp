package com.chape.daoandphp.base.dao.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by Administrator on 2017/10/7.
 */

public class DBManager {
    private final static String dbName = "test_db";
    private static DBManager mInstance;
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;

    public DBManager(Context context) {
        this.context = context;
        openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
    }

    /**
     * 获取单例引用
     *
     * @param context
     * @return
     */
    public static DBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }
    /**
     * 获取可写数据库
     */
    private SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }
    /**
     * 插入一条记录
     *
     * @param
     */
    public void insertUser(Picurl picurl) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        PicurlDao picurlDao = daoSession.getPicurlDao();
        picurlDao.insert(picurl);
    }

    /**
     * 插入用户集合
     *
     * @param
     */
    public void insertUserList(List<Picurl> picurlList) {
        if (picurlList == null ||picurlList.isEmpty()) {
            return;
        }
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        PicurlDao picurlDao = daoSession.getPicurlDao();
        picurlDao.insertInTx(picurlList);
    }
    /**
     * 删除一条记录
     *
     * @param picurl
     */
    public void deleteUser(Picurl picurl) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        PicurlDao picurlDao = daoSession.getPicurlDao();
       picurlDao.delete(picurl);
    }
    /**
     * 更新一条记录
     *
     * @param
     */
    public void updateUser(Picurl picurl) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        PicurlDao picurlDao = daoSession.getPicurlDao();
        picurlDao.update(picurl);
    }
    /**
     * 查询用户列表
     */
    public List<Picurl> queryUserList() {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        PicurlDao picurlDao = daoSession.getPicurlDao();
        QueryBuilder<Picurl> qb = picurlDao.queryBuilder();
        List<Picurl> list = qb.list();
        return list;
    }

    /**
     * 查询用户列表
     */
    /*public List<Picurl> queryUserList(int age) {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        QueryBuilder<User> qb = userDao.queryBuilder();
        qb.where(UserDao.Properties.Age.gt(age)).orderAsc(UserDao.Properties.Age);
        List<User> list = qb.list();
        return list;
    }*/
}
