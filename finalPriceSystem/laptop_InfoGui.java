package finalPriceSystem;

import java.awt.event.*;
import javax.swing.*;

public class laptop_InfoGui extends  JFrame {
	// 先声明变量
	private  JButton Updatajbt;
	private  JButton deletejbt;
	private  JLabel jLabel1;
	private  JLabel jLabel4;
	private  JLabel jLabel5;
	private  JLabel jLabel6;
	private  JLabel jLabel7;
	private  JLabel jLabeluser1;
	private  JLabel jLabeluser2;
	private  JLabel jLabelmoney1;
	private  JLabel jLabelmoney2;
	private  JLabel jLabelnumber1;
	private  JLabel jLabelnumber2;
	private  JScrollPane jScrollPane1;
	private  JScrollPane jScrollPane2;
	private  JTable jTable1;

	private  JButton jbtAdd;
	private  JButton jbtClear;
	private  JButton jbtF5;

	private  JTextField jtfprice;
	private  JTextField jtfgoods;
	private  JTextField jtfnumber;
	private  JTextField jtfname;
	private  JTextField jtfno;
//声明完毕
	
	
	
	// 重构
	public laptop_InfoGui() {
		super("PriceSystem笔记本电脑交易面板");
		initComponents();// 开始初始化组件
		String sql = "select*from sell_info";
		laptop_Info d = new laptop_Info(sql);
		jTable1.setModel(d);
		System.out.println(" 导入出售数据完毕！");
	}
	//重构完毕
	
	// 初始化组件
	private void initComponents() {
		this.setLocationRelativeTo(null);
//当一个容器内放置了许多组件，而容器的显示区域不足以同时显示所有组件时，如果让容器带滚动条，通过移动滚动条的滑块，容器中位置上的组件就能看到。滚动面板JScrollPane能实现这样的要求，JScrollPane是带有滚动条的面板。JScrollPane是Container类的子类，也是一种容器，但是只能添加一个组件。JScrollPane的一般用法是先将一些组件添加到一个JPanel中，然后再把这个JPanel添加到JScrollPane中。这样，从界面上看，在滚动面板上，好像也有多个组件。在Swing中，像JTextArea、JList、JTable等组件都没有自带滚动条，都需要将它们放置于滚动面板，利用滚动面板的滚动条，浏览组件中的内容。
		jScrollPane1 = new  JScrollPane();// 滚动面板
		jScrollPane2 = new  JScrollPane();
		jTable1 = new  JTable();// 表
		jLabel1 = new  JLabel();// 显示
		jLabel4 = new  JLabel();
		jLabel5 = new  JLabel();
		jLabel6 = new  JLabel();// 显示
		jLabel7 = new  JLabel();// 显示
		jLabeluser1 = new  JLabel();// 当前用户为
		jLabeluser2 = new  JLabel();// 用户名，动态
		jLabelmoney1 = new  JLabel();// 当前用户金钱：
		jLabelmoney2 = new  JLabel();
		jLabelnumber1 = new  JLabel();// 当前用户库存：
		jLabelnumber2 = new  JLabel();
		jtfno = new  JTextField();// 号码输入框
		jtfname = new  JTextField();// 名字输入框
		jtfgoods = new  JTextField();// 科室
		jtfnumber = new  JTextField();// 级别
		jtfprice = new  JTextField();// 挂号费
		jbtAdd = new  JButton();// 添加按钮
		Updatajbt = new  JButton();// 修改 改为 购买
		deletejbt = new  JButton();// 删除
		jbtClear = new  JButton();// 清空
		jbtF5 = new  JButton();// f5刷新

		// 设置关闭效果
		setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);

		// 鼠标选中
		jTable1.addMouseListener(new  MouseAdapter() {
			public void mouseClicked( MouseEvent evt) {
				jTable1MouseClicked(evt);
			}
		});

		jLabeluser1.setText("当前用户为："); // 7.1
		jLabeluser2.setText(Login.priceUserName);
		jLabelmoney1.setText("当前金币数量为：");
		laptop_Info dq = new laptop_Info();
		String sql = "select*from user where username='" + Login.priceUserName + "'";
		int userassets = dq.readuserM(sql);
		jLabelmoney2.setText("0");
		jLabelmoney2.setText(String.valueOf(userassets));
		jLabelnumber1.setText("当前库存数量为：");
		int usernumber = dq.readuserN(sql);
		jLabelnumber2.setText("0");
		jLabelnumber2.setText(String.valueOf(usernumber));
		jScrollPane2.setViewportView(jTable1);// 显示滚动表内容
		jScrollPane1.setViewportView(jScrollPane2);// 装载内容
		jLabel1.setText("序号");
		jLabel6.setText("用户");
		jLabel7.setText("商品");
		jLabel4.setText("数量");
		jLabel5.setText("单价");

		jtfno.setText(" ");
		jtfname.setText(" ");
		jtfnumber.setText(" ");
		jtfprice.setText(" ");
		jtfgoods.setText(" ");

		jbtAdd.setText("出售");
		jbtAdd.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent evt) {
				jbtAddActionPerformed(evt);
			}
		});

		jbtF5.setText("刷新"); // 刷新表格
		jbtF5.addActionListener(new  ActionListener() {
			public void actionPerformed( ActionEvent evt) {
				F5AP(evt);
			}
		});

		Updatajbt.setText("购买");
		Updatajbt.addActionListener(new  ActionListener() {
			public void actionPerformed( ActionEvent evt) {
				BuyjbtAP(evt);
			}
		});

		jbtClear.setText("清空");
		jbtClear.addActionListener(new  ActionListener() {
			public void actionPerformed( ActionEvent evt) {
				jbtClearActionPerformed(evt);
			}
		});

		
		
		
		
		
		
		
		
		/**
		 * GroupLayout，分组布局管理器。它将组建按层次分组，以决定它们在 Container 中的位置。 GroupLayout 主要供生成器使用（生成
		 * 并行组 和 串行组）。分组由GroupLayout.Group类的实例来完成， 每个组可以包含任意数量的元素（Group、Component 或
		 * Gap）。
		 */
		 GroupLayout layout = new  GroupLayout(getContentPane());
		getContentPane().setLayout(layout);// 创建

		layout.setHorizontalGroup(// 设置水平组
				layout.createParallelGroup( GroupLayout.Alignment.LEADING)// 设置并行组 对其方式（底部）
						.addGroup(layout.createSequentialGroup()// 设置整体串行组，左右结构

						.addGroup(layout.createParallelGroup/* 创建并行组 */( GroupLayout.Alignment.LEADING)
										/* 创建串行组 头部 */
										.addGroup(layout.createSequentialGroup()
												.addGap(32, 32, 32).addComponent(jLabeluser1).addComponent(jLabeluser2)
												.addGap(32, 32, 32).addComponent(jLabelmoney1)
												.addComponent(jLabelmoney2).addGap(32, 32, 32)
												.addComponent(jLabelnumber1).addComponent(jLabelnumber2)
												.addGap(32, 32, 32).addComponent(jbtF5)
										)
										// 串行了头部区域
										
										/* 创建串行组 主表 */
										.addGroup(layout.createSequentialGroup()
												.addContainerGap() /* 添加一个表示容器边缘和触到容器边框的组件之间首选间隙的元素。 */
												.addComponent(jScrollPane1,  GroupLayout.DEFAULT_SIZE, 515,
														Short.MAX_VALUE)) 
										// 串行了主表
										
										// 此处串行操作区按钮
										.addGroup(layout.createSequentialGroup()/* 创建串行组 */ 
												.addContainerGap()/* 添加一个表示容器边缘和触到容器边框的组件之间首选间隙的元素。 */
												.addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
																.addComponent(jLabel5)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jtfprice,
																		 GroupLayout.PREFERRED_SIZE, 74,
																		 GroupLayout.PREFERRED_SIZE))// 单价
												)// 并行组2.1完毕
												
												.addGroup(layout
														.createParallelGroup( GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup().addGap(32, 32, 32)// 需要调整一下
																.addComponent(jLabel4)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jtfnumber,GroupLayout.PREFERRED_SIZE, 74,GroupLayout.PREFERRED_SIZE))// 数量
												)// 并行组2.2完毕
												
												// 串行内的并行三组
												.addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()// 创建串行组 加点距离
																.addGap(30, 30, 30)
																.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)// 第三个底部

																		.addGroup(layout.createSequentialGroup()// 创建串行组：商品框
																				.addComponent(jLabel7)
																				.addPreferredGap(
																						 LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(jtfgoods,
																						 GroupLayout.PREFERRED_SIZE,
																						74,
																						 GroupLayout.PREFERRED_SIZE))// 商品框串行完毕

																		.addGroup(layout.createSequentialGroup()//// 创建串行组，三个按钮
																				.addComponent(jbtAdd)// 添加
																				.addGap(10, 10, 10)
																				.addComponent(jbtClear)// 清空
																				.addPreferredGap(
																						 LayoutStyle.ComponentPlacement.UNRELATED)// 边框调节
																				.addComponent(Updatajbt)// 更新
																		))// 第三个底部
														)// 加点距离
												)// 并行三组完毕

										)// 操作区串行完毕

								).addContainerGap()// 边界
						).addGroup(layout.createSequentialGroup()// 串行 自闭了
								.addContainerGap()// 边界
								
								.addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)// 间隙

						
						));// 水平设置完毕

		layout.setVerticalGroup(// 设置垂直组
				layout.createParallelGroup( GroupLayout.Alignment.LEADING)// 设置并行组 对其方式（底部）
						.addGroup(layout.createSequentialGroup()// 设置整体串行组，上下结构

								.addGap(17, 17, 17)// 上部空位

								.addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)// 设置头部
										.addComponent(jLabeluser1).addComponent(jLabeluser2).addComponent(jLabelmoney1)
										.addComponent(jLabelmoney2).addComponent(jLabelnumber1)
										.addComponent(jLabelnumber2).addComponent(jbtF5))// 头部三联

								.addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)// 间距

								.addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane1,  GroupLayout.PREFERRED_SIZE, 172,
												 GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
												
										)
										)// 表格

								.addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)// 间距

								.addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)// 底部并行

										.addGroup(layout.createSequentialGroup()// 串行
												.addGroup(layout
														.createParallelGroup( GroupLayout.Alignment.BASELINE)// 第一行
														.addComponent(jLabel5)// 单价
														.addComponent(jtfprice,  GroupLayout.PREFERRED_SIZE,
																 GroupLayout.DEFAULT_SIZE,
																 GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel4)// 数量
														.addComponent(jtfnumber/* 数量 */,
																 GroupLayout.PREFERRED_SIZE,
																 GroupLayout.DEFAULT_SIZE,
																 GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel7/* 商品 */)
														.addComponent(jtfgoods/* 商品 */,
																 GroupLayout.PREFERRED_SIZE,
																 GroupLayout.DEFAULT_SIZE,
																 GroupLayout.PREFERRED_SIZE))// 第一行

												.addGap(8, 8, 8)// 间隔

												.addGroup(layout
														.createParallelGroup( GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel5)// 单价
														.addComponent(jtfprice,  GroupLayout.PREFERRED_SIZE,
																 GroupLayout.DEFAULT_SIZE,
																 GroupLayout.PREFERRED_SIZE)
												)// 第二行

												.addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)// 间距

											
												// 有锁
												.addContainerGap(39, Short.MAX_VALUE)// 底部空间
										)// 串行第一行和第二行

										.addGroup( GroupLayout.Alignment.TRAILING, layout
												.createSequentialGroup()// 串行
												.addGroup(layout
														.createParallelGroup( GroupLayout.Alignment.TRAILING)// 并行
														.addGroup(layout
																.createParallelGroup(
																		 GroupLayout.Alignment.BASELINE)// 并行
																.addComponent(jbtClear).addComponent(Updatajbt))
														.addComponent(jbtAdd,
																 GroupLayout.Alignment.LEADING))
												.addGap(43, 43, 43)))// 底部一堆
						));

		pack();
	}


//GUI设置完毕，下面开始设置具体执行方法
	
	
	
	
	
	
	
	
	
	private void jbtAddActionPerformed( ActionEvent evt) {// 添加出售信息
		/* 砸瓦鲁多 */
		int GUIsellno = laptop_Info.sellNo + 1;
		String no = String.valueOf(GUIsellno);// 自动填写递增出售序号
		String name = Login.priceUserName;// 锁定当前用户
		// 读取信息
		String ks = jtfgoods.getText().trim();// 出售商品
		String level = jtfnumber.getText().trim();// 数量
		String ghf = jtfprice.getText().trim();// 单价

		// 执行添加sql语句，再读取数据 //先检查有没有住够库存
		laptop_Info addprice = new laptop_Info();
		String sql = "select*from user where username='" + name + "'";
		int beforson = addprice.readuserN(sql);
		int selloutnumber = Integer.parseInt(level);
		if (beforson >= selloutnumber) {
			sql = "INSERT INTO sell_info(no,name ,goods,number,price) VALUES('" + no + "','" + name + "',   '" + ks
					+ "',   '" + level + "','" + ghf + "')";
			addprice.Add(sql);
			beforson = beforson - selloutnumber;
			sql = "UPDATE user SET laptop = '" + beforson + "' WHERE username = '" + name + "' ";
			addprice.Update(sql);// 卖方数据修正

		}

		// 重新读取数据
		String sql1 = "select*from sell_info";
		laptop_Info d = new laptop_Info(sql1);
		jTable1.setModel(d);
		jtfno.setText("");
		jtfname.setText("");
		jtfnumber.setText("");
		jtfprice.setText("");
		jtfgoods.setText("");
	}

	
	
	
	
	private void F5AP( ActionEvent evt) { // f5刷新
		// 重新读取数据
		String sql = "select*from sell_info";
		laptop_Info d = new laptop_Info(sql);
		jTable1.setModel(d);

		sql = "select*from user where username='" + Login.priceUserName + "'";
		int userassets = d.readuserM(sql);
		jLabelmoney2.setText(String.valueOf(userassets));
		int usernumber = d.readuserN(sql);
		jLabelnumber2.setText(String.valueOf(usernumber));

	}

	
	
	
	
	
	public void F5AUTO() { // f5刷新
		// 重新读取数据
		String sql = "select*from sell_info";
		laptop_Info d = new laptop_Info(sql);
		jTable1.setModel(d);

		sql = "select*from user where username='" + Login.priceUserName + "'";
		int userassets = d.readuserM(sql);
		jLabelmoney2.setText(String.valueOf(userassets));
		int usernumber = d.readuserN(sql);
		jLabelnumber2.setText(String.valueOf(usernumber));

	}

	


	private void BuyjbtAP( ActionEvent evt) { //  购买2.0
		// 获取当前位置
		// 鼠标点击，自动填入
		String no = jtfno.getText().trim();
		String name = jtfname.getText().trim();
		String goods = jtfgoods.getText().trim();
		String number = jtfnumber.getText().trim();
		String oneprice = jtfprice.getText().trim();
		// 开始♂交易
		int sumPrice, inumber, ioneprice, lessmoney, lessnumber, smoney, snumber;
		inumber = Integer.parseInt(number);
		ioneprice = Integer.parseInt(oneprice);
		sumPrice = inumber * ioneprice;

		String usn = Login.priceUserName;
		System.out.println("test1当前用户为" + usn);
		String sql = "select*from user where username='" + usn + "'";
		laptop_Info buyin = new laptop_Info();

		int userassets = buyin.readuserM(sql);
		lessnumber = buyin.readuserN(sql);

		if (sumPrice <= userassets) {
			lessmoney = userassets - sumPrice;
			lessnumber = inumber + lessnumber;

			// 修改数据库
			sql = "UPDATE user SET assets ='" + lessmoney + "',laptop = '" + lessnumber + "' WHERE username = '" + usn
					+ "' ";
			buyin.Update(sql);// 买方数据修正

			sql = "select*from user where username='" + name + "'";
			smoney = buyin.readuserM(sql);
			snumber = buyin.readuserN(sql);
			smoney = smoney + sumPrice;

			sql = "UPDATE user SET assets ='" + smoney + "' WHERE username = '" + name + "' ";
			buyin.Update(sql);// 卖方数据修正
			System.out.println("交易成功，当前余额" + lessmoney + "当前数量" + lessnumber);
			// 删除记录
			sql = "DELETE from sell_info  WHERE no = '" + no + "' ";
			buyin.delete(sql);
		} else {
			System.out.println("交易失败，你不够钱");
			JOptionPane.showMessageDialog(null, "交易失败，你不够钱", "deal late no more", JOptionPane.ERROR_MESSAGE);
		}

		jtfno.setText("");
		jtfname.setText("");
		jtfnumber.setText("");
		jtfprice.setText("");
		jtfgoods.setText("");

		// 重新读取数据
		String sql1 = "select*from sell_info";
		laptop_Info d = new laptop_Info(sql1);
		jTable1.setModel(d);

	}// 购买区域完毕 。
	
	
	
	// 用于鼠标选中
	private void jTable1MouseClicked( MouseEvent evt) {
		// 获取某一行的具体值，并把它显示在文本框中
		String no = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
		String name = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
		String ks = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
		String level = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
		String ghf = jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
		// 把点击的内容显示在文本框中
		jtfno.setText(no);
		jtfname.setText(name);
		jtfgoods.setText(ks);
		jtfnumber.setText(level);
		jtfprice.setText(ghf);

	}

	

	
	// 清理输入框
	private void jbtClearActionPerformed( ActionEvent evt) { 
		jtfno.setText("");
		jtfname.setText("");
		jtfnumber.setText("");
		jtfprice.setText("");
		jtfgoods.setText("");
	}
	
	
	
	
	

	public static void main(String args[]) {
		 //整体外观设置Nimbuslookandfeel
	       try {
	    	   
	    	   UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	           
	       } catch (Exception e) {
	    	   e.printStackTrace();
	       }
		

		//保存单线性：awt的事件处理线程
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new laptop_InfoGui().setVisible(true);

			}
		}

		);
		

	}// main

}
