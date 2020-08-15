package finalPriceSystem;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class laptop_Info extends AbstractTableModel  {
	//标准sql语句传送方法
       Connection con=null;//链接数据库
       PreparedStatement ps=null;//传送sql语句
       ResultSet rs=null;//接收返回的数据
       Vector<Serializable> rowData,columnName;//
       public static int sellNo = 0;
       
       public laptop_Info(String sql){//重构
          init( sql) ;
       }

       public laptop_Info(){//重构

        }
       public void init(String sql){//有sql语句的初始化

                //columnName保存表头信息
               columnName=new Vector<Serializable>();//赋予生命
               columnName.add("交易单号");
               columnName.add("出售用户");
               columnName.add("出售商品");
               columnName.add("出售数量");
               columnName.add("单价");//5个


            //rowData向量保存每一行的信息
       String lastSellNo = null;//接收最后一个序号
            rowData=new Vector<Serializable>();//赋予生命
           try {
            con = DBConnection.getConnection();//链接数据库
             ps=(PreparedStatement)con.prepareStatement(sql);
             rs=ps.executeQuery();//接收     
            while(rs.next()){//滚动填入
                   Vector bang=new Vector();
                   bang.add(rs.getString(1) );//这里可以接触到最后一个序号
                   lastSellNo=rs.getString(1);                 
                   bang.add(rs.getString(2) );
                   bang.add(rs.getString(3) );
                   bang.add(rs.getString(4) );
                   bang.add(rs.getString(5) );

                   //将读取的每一行数据添加到bang中，然后再把bang添加到rowData向量中
                    rowData.add(bang);
            }System.out.println("最后的序号为"+lastSellNo);
            try {//string转化为int
            	sellNo = Integer.parseInt(lastSellNo);
            }catch (NumberFormatException e) {
            	e.printStackTrace();
            }
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            if(con!=null&&ps!=null&rs!=null){
                try {
                    con.close();
                    ps.close();
                    rs.close();
                } catch (SQLException e) {

                    e.printStackTrace();
                }

            }
        }//finally
  }//初始化完毕
       
       
    public void chushihua(String sql){//初始化，读作初始化，写作干活人
         Connection con=null;
         PreparedStatement ps=null;
        int rs;

        try {
            con = DBConnection.getConnection();//链接数据库
             ps=(PreparedStatement) con.prepareStatement( sql);//传送sql语句
             rs=ps.executeUpdate();//接收返回结果

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }  
    
    public int readuserM(String sql) { 
    	String name = null;
    	String passw = null;
    	String utype = null;
    	String assets = null;
    	String laptop = null;
    	//rowData=new Vector<Serializable>();//赋予生命
        try {
         con = DBConnection.getConnection();//链接数据库
          ps=(PreparedStatement)con.prepareStatement(sql);
          rs=ps.executeQuery();//接收     
         while(rs.next()){//滚动填入
        	 name = rs.getString(1) ;
        	 passw = rs.getString(2) ; 
        	 utype = rs.getString(3) ;
        	 assets = rs.getString(4) ;
        	 laptop = rs.getString(5) ;
        	 
        	System.out.println("要返回钱数目了"+ Integer.parseInt(assets)) ;
        	 return Integer.parseInt(assets);
         }
   } catch (ClassNotFoundException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
   } catch (SQLException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
   }finally {
       if(con!=null&&ps!=null&rs!=null){
           try {
               con.close();
               ps.close();
               rs.close();
           } catch (SQLException e) {

               e.printStackTrace();
           }

       }
   }//finally
		return Integer.parseInt(assets);
    }
    public int readuserN(String sql) { 
    	String name = null;
    	String passw = null;
    	String utype = null;
    	String assets = null;
    	String laptop = null;
    	//rowData=new Vector<Serializable>();//赋予生命
        try {
         con = DBConnection.getConnection();//链接数据库
          ps=(PreparedStatement)con.prepareStatement(sql);
          rs=ps.executeQuery();//接收     
         while(rs.next()){//滚动填入
        	 name = rs.getString(1) ;
        	 passw = rs.getString(2) ; 
        	 utype = rs.getString(3) ;
        	 assets = rs.getString(4) ;
        	 laptop = rs.getString(5) ;
        	 
        	System.out.println("要返商品数目了"+ Integer.parseInt(laptop)) ;
        	 return Integer.parseInt(laptop);
         }
   } catch (ClassNotFoundException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
   } catch (SQLException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
   }finally {
       if(con!=null&&ps!=null&rs!=null){
           try {
               con.close();
               ps.close();
               rs.close();
           } catch (SQLException e) {

               e.printStackTrace();
           }

       }
   }//finally
		return Integer.parseInt(laptop);
    }
    
    
    
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void delete(String sql){//打工的
        chushihua( sql);

    }
    public void Add(String sql){
        chushihua( sql);

    }
    public void Update(String sql){
        chushihua( sql);

    }

  

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   public int getRowCount() {
        return this.rowData.size();
   }

   public int getColumnCount() {
      return this.columnName.size();
   }

   public Object getValueAt(int  row, int column) {
        return  ((Vector ) this.rowData.get(row)).get(column);
   }
   public String getColumnName(int column) {

        return   (String) this.columnName.get(column);
    }


   
   
   
  }

