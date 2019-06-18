package com.hx.dao;

import com.hx.annotation.Column;
import com.hx.annotation.Id;
import com.hx.utils.DBUtil;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BaseDao<T> {

    private Class<T> clazz;
    private Field[] fields;
    public BaseDao() {
        ParameterizedType c= (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz= (Class<T>) c.getActualTypeArguments()[0];
        fields=clazz.getDeclaredFields();
    }

    /**
     * 插入 insert into 表名  values(?,?,?,....)
     * @param o
     * @return
     */
    public int insert(T o){
        StringBuffer sb=new StringBuffer("insert into ");
        Object[] params=new Object[fields.length];
        sb.append(clazz.getSimpleName())
                .append(" values(");
        for(int i=0;i<fields.length;i++){
            sb.append("?");
            if(i<fields.length-1){
                sb.append(",");
            }
            else {
                sb.append(")");
            }
            fields[i].setAccessible(true);
            try {
                params[i]=fields[i].get(o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sb.toString());
        return DBUtil.save(sb.toString(),params);
    }

    /**
     * delete from 表  where id=?
     * @param id
     * @return
     */
    public int delete(Object id){
        StringBuffer sb=new StringBuffer("delete from ");
        sb.append(clazz.getSimpleName())
                .append(" where ");
        String pkName=fields[0].getName();
        Id  aid=null;
        Object[] param={id};
        for (Field f:fields){
            aid=f.getAnnotation(Id.class);
            if(aid!=null){
                pkName=aid.name();
            }
        }
        sb.append(pkName)
                .append("=?");
        System.out.println(sb.toString());
        return DBUtil.save(sb.toString(),param);
    }

    public List<T> findAll(){
        StringBuffer sb=new StringBuffer("select * from ");
        sb.append(clazz.getSimpleName());
        System.out.println(sb.toString());
        ResultSet rs= DBUtil.query(sb.toString());
        return resultSetToList(rs);
    }

    /**
     * 结果集转List
     * @param rs
     * @return
     */
    protected List<T> resultSetToList(ResultSet rs) {
        List<T> list=new ArrayList<>();

        if(rs!=null){
            try{
                while (rs.next()){
                    T t=clazz.newInstance();
                    for(Field f:fields){
                        String fieldName=f.getName();
                        Column col=f.getAnnotation(Column.class);
                        if(col!=null){
                            fieldName=col.name();
                        }
                        Object val=rs.getObject(fieldName);
                        if(val instanceof BigDecimal){
                            BigDecimal v= (BigDecimal) val;
                            if(f.getType().getSimpleName().equals("Integer"))
                                val=v.intValue();
                            else if(f.getType().getSimpleName().equals("Double"))
                                val=v.doubleValue();
                        }
                        else if(val instanceof Timestamp){
                            Timestamp tt= (Timestamp) val;
                            val=tt.toLocalDateTime();
                        }
                        f.setAccessible(true);
                        f.set(t,val);
                    }
                    list.add(t);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        return list;
    }
}
