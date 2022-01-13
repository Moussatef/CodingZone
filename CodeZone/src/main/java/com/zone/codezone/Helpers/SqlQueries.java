package com.zone.codezone.Helpers;

public class SqlQueries {
    static StringBuilder sb;

    public static String getAll(String tableName) {

        String query ="SELECT * FROM "+tableName+" ORDER BY id";
        return query;

    }

    public static String filter(String tableName,String condition) {

        String query ="SELECT * FROM "+tableName+" "+condition ;
        return query;

    }


    public static String getAllWithWhere(String tableName, String condition) {

        String query ="SELECT * FROM "+tableName+" where "+condition;
        return query;

    }


    public static String getColumnData(String tableName, String column) {

        String query ="SELECT "+column+" FROM "+tableName;
        return query;

    }


    public static String getColumnDataWithCondition(String tableName, String column,String condition) {

        String query ="SELECT "+column+" FROM "+tableName+" "+condition;
        return query;

    }


    public static <T>String getById(String tableName,T id) {

        String query ="SELECT * FROM "+tableName+" where id like'"+id+"'";
        return query;

    }


    public static String insert(String tableName,int nbColumn) {

        sb=new StringBuilder();

        sb.append("INSERT INTO "+tableName+" VALUES (");

        if(nbColumn>1) {

            for(int i=1;i<nbColumn;i++) {
                sb.append("?,");
            }
        }

        sb.append("?)");

        return sb.toString();
    }


    public static <T> String update(String tableName, String[] coulumns, T id) {

        sb=new StringBuilder();

        sb.append("UPDATE "+tableName+" SET ");

        for(int i=0;i<coulumns.length;i++) {

            sb.append(coulumns[i]+"=?");

        }
        return sb.toString();
    }


    public static <T> String delete(String tableName,T id) {

        String query ="DELETE FROM "+tableName+" WHERE id="+id;
        return query;
    }
}
