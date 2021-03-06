package com.funtester.frame.thread;

import com.funtester.base.constaint.ThreadLimitTimesCount;
import com.funtester.base.interfaces.IMySqlBasic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

/**
 * 数据库多线程类，query方法类，区别于updatethread
 */
public class QuerySqlThread extends ThreadLimitTimesCount {

    private static Logger logger = LoggerFactory.getLogger(QuerySqlThread.class);

    String sql;

    IMySqlBasic base;

    public QuerySqlThread(IMySqlBasic base, String sql, int times) {
        this.times = times;
        this.sql = sql;
        this.base = base;
    }

    @Override
    public void before() {
        base.getConnection();
    }

    @Override
    protected void doing() throws SQLException {
        base.executeQuerySql(sql);
    }

    @Override
    protected void after() {
        super.after();
        base.mySqlOver();
    }


}
