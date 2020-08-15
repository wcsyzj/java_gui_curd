package finalPriceSystem;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class Login extends javax.swing.JFrame { //登陆页面窗体
	// 先声明变量
         
	   private javax.swing.JButton JButton1;
	   private javax.swing.JButton JButton2;
	   private javax.swing.JLabel jLabel1;
	   private javax.swing.JLabel jLabel2;
	   private javax.swing.JLabel jLabel3;
	   private javax.swing.JPasswordField jPasswordField1;
	   private javax.swing.JTextField jTextField2;
	   private javax.swing.JTextField jTextField3;

	   public static String priceUserName = null ;//传递用户名，用于传递给面板控制端


   public Login() { //本体：构造方法
	   super("PriceSystem登陆");
       initComponents();//由构造跳转到【启动机制】
   }
   @SuppressWarnings("unchecked")  //忽略报错信息
   private void initComponents() { //启动机制
	   this.setLocationRelativeTo(null);
       jLabel1 = new javax.swing.JLabel(); //设置一个空的jLabel	   																						// JLabel 对象可以显示文本、图像或同时显示二者。可以通过设置垂直和水平对齐方式， 
       jLabel2 = new javax.swing.JLabel(); //设置第二个空的jLabel
       jLabel3 = new javax.swing.JLabel(); //设置前置选择       										
/**
 * JTextField 是一个轻量级组件，它允许编辑单行文本。 JTextField 应与 
 * java.awt.TextField 具有源代码兼容性，理应如此。此组件具有 java.awt.TextField 类中没有的功能。
 */
       jTextField2 = new javax.swing.JTextField();//设置一个空的单行输入，没有1？
       jTextField3 = new javax.swing.JTextField();//前置选择
/**
 * JPasswordField 是一个轻量级组件，允许编辑一个单行文本，其视图指示键入内容，但不显示原始字符。
 */
       jPasswordField1 = new javax.swing.JPasswordField(); //一个密码框
/**
 * JButton类是按钮的实现。该组件具有标签，并在按下时生成事件。它也可以有一个图像
 */
       JButton1 = new javax.swing.JButton();
       JButton2 = new javax.swing.JButton();
       //关闭窗口，用户单击窗口的关闭按钮时程序执行的操作
       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       jLabel1.setText("账号"); //把第一个jLabel内容填入“账号”，居中方式默认
       jLabel2.setText("密码"); //把第二个jLabel内容填入“密码”，居中方式默认
       jLabel3.setText("版块");
       jTextField2.setText(" ");// 构造使用指定文本【一个空格】字符串初始化的新TextField。
       jTextField3.setText(" ");
       JButton1.setText("登录");//将登陆两个字塞进按钮里
/**
 * 给这个按钮添加一个监听者，一旦有事件发生（比如鼠标点击），监听者都可以得到这个事件，
 * 并可以把事件信息（例如事件源）传给事件处理函数。
 */
       JButton1.addActionListener(new java.awt.event.ActionListener() 
       {
           public void actionPerformed(java.awt.event.ActionEvent evt) //执行操作
           {
               System.out.println("'登陆' 按钮被按下");
        	   JButton1ActionPerformed(evt);//跳转到登陆按钮执行程序
           }
       }
    );

       JButton2.setText("退出");//将退出两个个字塞进按钮里
       JButton2.addActionListener(new java.awt.event.ActionListener() 
       {
           public void actionPerformed(java.awt.event.ActionEvent evt) //执行操作
           {
        	   System.out.println("'退出'  按钮被按下");
               JButton2ActionPerformed(evt);//跳转到退出按钮执行程序
           }
       });
       
       
       
       
       
       
       
       
       
       
       
       
       
       

/**
 * GroupLayout，分组布局管理器。它将组建按层次分组，以决定它们在 Container 中的位置。
 * GroupLayout 主要供生成器使用（生成 并行组 和 串行组）。分组由GroupLayout.Group类的实例来完成，
 * 每个组可以包含任意数量的元素（Group、Component 或 Gap）。
 */
       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());//先创建分组布局，并关联容器
       getContentPane().setLayout(layout);
       
       
       layout.setHorizontalGroup( //设置水平组
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)//设置并行组对其方式（底部）
           .addGroup(layout.createSequentialGroup()//设置整体串行组，左右结构
               .addGap(90, 90, 90)//左框边距大小 默认103              
               //并行指按x轴排列，将垂直项目归为一组
               .addGroup/*添加组元素*/(layout.createParallelGroup/*创建并行组*/(javax.swing.GroupLayout.Alignment.TRAILING)
               //public static final grouplayout.alignment trailing
               //指示元素应该向区域底端对齐。对于从左到右的水平轴，这表示向右端对齐。对于垂直轴，trailing 表示向底端对齐。
            		.addComponent(jLabel3)
                   .addComponent(jLabel2)//“账号”
                   .addComponent(jLabel1)//“密码”
               )//并行完毕： 将账号、密码并行
               
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
/**
 * addpreferredgap(layoutstyle.componentplacement type,int pref,int max)
 * 添加一个表示两个距离最近的组件之间首选间隙的元素。在布局过程中，找到相邻元素，并根据相邻组件之间的首选间隙大小来设置此间隙的最小大小。
 * 如果找不到相邻组件，则最小大小被设置为 0。                  * 参数：
type - 间隙的类型；layoutstyle.componentplacement.related 或 layoutstyle.componentplacement.unrelated组件放置不相关
pref - 间隙的首选大小；default_size 或大于等于 0 的值
max - 间隙的最大大小；default_size、preferred_size 或大于等于 0 的值
 */         
               .addGroup(layout.createParallelGroup/*创建并行组*/(javax.swing.GroupLayout.Alignment.TRAILING, false)/*添加组元素，创建并行组*/
                   .addGroup(layout.createSequentialGroup() //创建串行组
                       .addComponent(JButton1)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                       .addComponent(JButton2))//串行完毕： 将登陆、退出按钮串行
                   
                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)//创建并行组
                		.addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                       .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                       .addComponent(jPasswordField1))//并行完毕：将输入框、密码框并行
                   )//并行完毕：将输入组和按钮组并行
               .addContainerGap(114, Short.MAX_VALUE))//右边的边框，默认114
/**
 * 添加一个表示容器边缘和触到容器边框的组件之间首选间隙的元素。如果添加的间隙没有触到父容器的边缘，则此方法没有任何效果。
 * 创建用来表示间隙的元素是不可调整大小的。
 */
           
       );//水平组完毕
       
       
       layout.setVerticalGroup( //设置垂直组
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)//设置并行组对其方式（底部）
           .addGroup(layout.createSequentialGroup()//设置整体串行组，应该是 上下结构
        		   
               .addGap(69, 69, 69)//上面的边框
               
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)//设置并行组
                       .addComponent(jLabel3)
                       .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                       )//并行完毕
               
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
               
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)//设置并行组
                   .addComponent(jLabel1)//账号
                   .addComponent(jTextField2/*账号输入框*/, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   )//并行完毕： 将账号和账号输入框并行
               
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)//设置并行组
                   .addComponent(jLabel2/*密码*/, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)//指示组件或间隙的首选大小应该用于特定的范围值，限制上下最大显示范围
                   .addComponent(jPasswordField1/*密码框*/, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   )//并行完毕：将密码和密码框并行
               
               .addGap(18, 18, 18)//和按钮的距离
               
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)//并行组
                   .addComponent(JButton1)
                   .addComponent(JButton2)
                   )//并行完毕，两个按钮
               
               .addContainerGap(49, Short.MAX_VALUE))//设置底部边框
       );//垂直组设置完毕
       

       
       
       pack();//依据你放置的组件设定窗口的大小 使之正好能容纳你放置的所有组件
   }                  

   
   
   
   
   
   
   
   
   
   
   
   //退出按钮
   private void JButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       System.exit(0);
   }                                        

   
   //  登陆按钮执行程序 
   private void JButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                       
       try {
           Connection con = DBConnection.getConnection();//指向数据库链接
           Statement stmt = con.createStatement();//？
           String sql="select *from user";//SQL筛选
           ResultSet rs = stmt.executeQuery(sql);
           
           String usename=jTextField2.getText().trim();//新建字符串读取用户名，
           String plate  =jTextField3.getText().trim();//7.1new
           //getText().trim() 在获得的文本中除去空格。
           
           char[] p=jPasswordField1.getPassword();//新建字符数组读取密码
           String pwd=new String(p);//转换为字符串
           
           String   name = null;//新建两个对比字符串
           String pass = null;
           while(rs.next()){
                name=rs.getString(1);
                pass=rs.getString(2);//读取数据库内账号密码
                
                if(usename.equals(name)&&pwd.equals(pass)){
                    System.out.println("登录成功！！deal late no more!!!!");
                    priceUserName = usename ;//将登陆用户名传递给传递用户名
                    System.out.println("当前用户为："+priceUserName);
                    //分板块激活
                    if(plate.equals("laptop"))
                    {
                    	new laptop_InfoGui().setVisible(true);//跳转到操作框，操作框可见
                    	this.dispose(); //关闭当前登陆窗口
                    }
                    
                    
                    else
                    {
                    	JOptionPane.showMessageDialog(null, "请输入正确板块名", "deal late no more", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    
                    
                    

             }    
                } 



       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       }
   }                                        

   
   
  
   
   public static void main(String args[]) {
     //整体外观设置Nimbuslookandfeel
       try {
    	   
    	   UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
           
       } catch (Exception e) {
    	   e.printStackTrace();
       }
       

     //保存单线性：awt的事件处理线程
       java.awt.EventQueue.invokeLater(new Runnable() 
       {
           public void run() 
           {
               new Login().setVisible(true);//打开登陆窗体
           }
       });
   }

                      
}
