<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.PreparedStatement"  %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%!
			public int Converter(String str)
			{ 
				int convrtr=0;
				if(str==null)
		    	{
					str="0";
		    	}
				else if((str.trim()).equals("null"))
		    	{
					str="0";
		    	}
				else if(str.equals(""))
		    	{
					str="0";
		    	}
				
				try{
					convrtr=Integer.parseInt(str);
		    	}
				catch(Exception e)
		    	{
					e.printStackTrace();
		    	}
				
				return convrtr;
			}
		%>
		
		<%
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_managment","root", "092522087");
			ResultSet rsPgin = null;
			ResultSet rsRwCn = null;
			PreparedStatement psPgintn=null;
			PreparedStatement psRwCn=null;
			
			// Number of records displayed on each page		
			int iSwRws=5;
			// Number of pages index displayed
			int iTotSrhRcrds=10;
			int iTotRslts=Converter(request.getParameter("iTotRslts"));
			int iTotPags=Converter(request.getParameter("iTotPags"));
			int iPagNo=Converter(request.getParameter("iPagNo"));
			int cPagNo=Converter(request.getParameter("cPagNo"));
			int iStRsNo=0;
			int iEnRsNo=0;
			if(iPagNo==0){
				iPagNo=0;
			}
			else{
				iPagNo=Math.abs((iPagNo-1)*iSwRws);
			}
			
			String sqlPgintn="SELECT SQL_CALC_FOUND_ROWS * FROM tb_customer limit "+iPagNo+","+iSwRws+"";
			psPgintn=con.prepareStatement(sqlPgintn);
			rsPgin=psPgintn.executeQuery();
			String sqlRwCnt="SELECT FOUND_ROWS() as cnt";
			psRwCn=con.prepareStatement(sqlRwCnt);
			rsRwCn=psRwCn.executeQuery();
			if(rsRwCn.next()){
				iTotRslts=rsRwCn.getInt("cnt");	
			}			
		%>
		
<!-- FILTER QUERY -->
		<%
			if(request.getParameter("btnfilter") != null ){
				out.println("Good");
			}
		%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="css/template.css" />
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<title>Insert title here</title>
</head>
<body>
	<div class="main-c">
		<div class="htitle"><h2>Customer Management</h2></div>
		<div class="add-cus"><a href="addcustomer.jsp">Create New</a></div>
		<div class="clr"></div>
	</div>
	<center>
		<div class="tfiltering"><h3>Search by specific Filtering</h3></div>
		<div class="form_filter">
			<form name="filtering" action="" method="post">
				<strong>Name:</strong> <input type="text" name="sname" />
				<strong>Email:</strong> <input type="text" name="semail" />
				<strong>Phone Number:</strong> <input type="text" name="sphone" />
				<input type="submit" name="btnfilter" value="Filter" />
			</form>
		</div>
		
		<form name="frm"> 
			<input type="hidden" name="iPagNo" value="<%=iPagNo%>"> 
			<input type="hidden" name="cPagNo" value="<%=cPagNo%>"> 
			<input type="hidden" name="iSwRws" value="<%=iSwRws%>"> 
			<table width="100%" cellpadding="0" cellspacing="0" border="0" > 
			<tr class="tableheader">
				<th><div class="thhead">ID</div></th> 
				<th><div class="thhead">Name</div></th> 
				<th><div class="thhead">Gender</div></th>
				<th><div class="thhead">Email</div></th>
				<th><div class="thhead">Date of Birth</div></th>
				<th><div class="thhead">Address</div></th>
				<th><div class="thhead">Phone Number</div></th>
				<th><div class="thhead">Action</div></th>
			</tr>

			<%
				int z = 0;
				String styletr = "";
				while(rsPgin.next())
	  			{
	  			styletr = (z % 2 == 0) ? "trodd" : "treven";
			%>
			<tr class="trdata <%=styletr%>">
			<td><%="<strong>" + rsPgin.getString("cus_id") + "</strong>"%></td>
			<td><%=rsPgin.getString("cus_first_name")+" "+rsPgin.getString("cus_last_name")%></td>

			<td><%=rsPgin.getString("cus_gender")%></td>
			<td><%=rsPgin.getString("cus_email_address")%></td>
			<td><%=rsPgin.getString("cus_dob")%></td>
			<td><%=rsPgin.getString("cus_address")%></td>
			<td><%=rsPgin.getString("cus_phone_number")%></td>
			<td><a class="btnedit" href="cusedit.jsp?id = <%=rsPgin.getString("cus_id")%>">Edit</a> | 
				<a class="btndelete" href="cusdelete.jsp?id = <%=rsPgin.getString("cus_id")%>">Delete</a>
			</td>
			</tr>
			<% 
				z++;
 	 			}
			%>
			<% 
				// Calculate next record start and end position 
				try{ 
					if(iTotRslts<(iPagNo+iSwRws)){ 
						iEnRsNo=iTotRslts; 
					} 
					else { 
						iEnRsNo=(iPagNo+iSwRws); 
					} 
					iStRsNo=(iPagNo+1); 
					iTotPags=((int)(Math.ceil((double)iTotRslts/iSwRws))); 
				} catch(Exception e) { 
					e.printStackTrace(); 
				}
			%>
			<tr>
				<td colspan="3">
				<div class="c-pagination">
			<% 
				// Create index of pages 
				int i=0; 
				int cPge=0; 
				if(iTotRslts!=0) { 
					cPge=((int)(Math.ceil((double)iEnRsNo/(iTotSrhRcrds*iSwRws)))); 
					int prePageNo=(cPge*iTotSrhRcrds)-((iTotSrhRcrds-1)+iTotSrhRcrds); 
					if((cPge*iTotSrhRcrds)-(iTotSrhRcrds)>0) { 
			%> 
			<a href="customer.jsp?iPagNo=<%=prePageNo%>&cPagNo=<%=prePageNo%>"><< Previous</a> 
			<% } 
			for(i=((cPge*iTotSrhRcrds)-(iTotSrhRcrds-1));i<=(cPge*iTotSrhRcrds);i++) { 
				if(i==((iPagNo/iSwRws)+1)) { %> 
				<a class="p-active" href="customer.jsp?iPagNo=<%=i%>"><strong><%=i%></strong></a>
			<% } 
				else if(i<=iTotPags) { %> 
				<a class="p-noactive" href="customer.jsp?iPagNo=<%=i%>"><%=i%></a> 
			<% } 
			} 
				if(iTotPags>iTotSrhRcrds&& i<iTotPags) { %> 
					<a href="customer.jsp?iPagNo=<%=i%>&cPagNo=<%=i%>">>> Next</a> 
				<% } } %> 
					<b>Rows <%=iStRsNo%> - <%=iEnRsNo%> Total Result <%=iTotRslts%></b> 
				</div>
				</td>
			</tr>
			</table> 
			</form>
			<% try{ if(psPgintn!=null){ psPgintn.close(); } if(rsPgin!=null){ rsPgin.close(); }	if(psRwCn!=null){ psRwCn.close(); } if(rsRwCn!=null){ rsRwCn.close(); } if(con!=null){ con.close(); } } catch(Exception e) { e.printStackTrace(); } %>


	</center>
</body>
</html>