/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.2.19.v20160908
 * Generated at: 2017-03-09 04:29:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

public final class customer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


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
		
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
    _jspx_imports_classes.add("java.sql.DriverManager");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");

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
		
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("<!-- FILTER QUERY -->\r\n");
      out.write("\t\t");

			if(request.getParameter("btnfilter") != null ){
				out.println("Good");
			}
		
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/template.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"font-awesome/css/font-awesome.min.css\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"main-c\">\r\n");
      out.write("\t\t<div class=\"htitle\"><h2>Customer Management</h2></div>\r\n");
      out.write("\t\t<div class=\"add-cus\"><a href=\"addcustomer.jsp\">Create New</a></div>\r\n");
      out.write("\t\t<div class=\"clr\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<center>\r\n");
      out.write("\t\t<div class=\"tfiltering\"><h3>Search by specific Filtering</h3></div>\r\n");
      out.write("\t\t<div class=\"form_filter\">\r\n");
      out.write("\t\t\t<form name=\"filtering\" action=\"\" method=\"post\">\r\n");
      out.write("\t\t\t\t<strong>Name:</strong> <input type=\"text\" name=\"sname\" />\r\n");
      out.write("\t\t\t\t<strong>Email:</strong> <input type=\"text\" name=\"semail\" />\r\n");
      out.write("\t\t\t\t<strong>Phone Number:</strong> <input type=\"text\" name=\"sphone\" />\r\n");
      out.write("\t\t\t\t<input type=\"submit\" name=\"btnfilter\" value=\"Filter\" />\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<form name=\"frm\"> \r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"iPagNo\" value=\"");
      out.print(iPagNo);
      out.write("\"> \r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"cPagNo\" value=\"");
      out.print(cPagNo);
      out.write("\"> \r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"iSwRws\" value=\"");
      out.print(iSwRws);
      out.write("\"> \r\n");
      out.write("\t\t\t<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" > \r\n");
      out.write("\t\t\t<tr class=\"tableheader\">\r\n");
      out.write("\t\t\t\t<th><div class=\"thhead\">ID</div></th> \r\n");
      out.write("\t\t\t\t<th><div class=\"thhead\">Name</div></th> \r\n");
      out.write("\t\t\t\t<th><div class=\"thhead\">Gender</div></th>\r\n");
      out.write("\t\t\t\t<th><div class=\"thhead\">Email</div></th>\r\n");
      out.write("\t\t\t\t<th><div class=\"thhead\">Date of Birth</div></th>\r\n");
      out.write("\t\t\t\t<th><div class=\"thhead\">Address</div></th>\r\n");
      out.write("\t\t\t\t<th><div class=\"thhead\">Phone Number</div></th>\r\n");
      out.write("\t\t\t\t<th><div class=\"thhead\">Action</div></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

				int z = 0;
				String styletr = "";
				while(rsPgin.next())
	  			{
	  			styletr = (z % 2 == 0) ? "trodd" : "treven";
			
      out.write("\r\n");
      out.write("\t\t\t<tr class=\"trdata ");
      out.print(styletr);
      out.write("\">\r\n");
      out.write("\t\t\t<td>");
      out.print("<strong>" + rsPgin.getString("cus_id") + "</strong>");
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(rsPgin.getString("cus_first_name")+" "+rsPgin.getString("cus_last_name"));
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<td>");
      out.print(rsPgin.getString("cus_gender"));
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(rsPgin.getString("cus_email_address"));
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(rsPgin.getString("cus_dob"));
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(rsPgin.getString("cus_address"));
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(rsPgin.getString("cus_phone_number"));
      out.write("</td>\r\n");
      out.write("\t\t\t<td><a class=\"btnedit\" href=\"cusedit.jsp?id = ");
      out.print(rsPgin.getString("cus_id"));
      out.write("\">Edit</a> | \r\n");
      out.write("\t\t\t\t<a class=\"btndelete\" href=\"cusdelete.jsp?id = ");
      out.print(rsPgin.getString("cus_id"));
      out.write("\">Delete</a>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");
 
				z++;
 	 			}
			
      out.write("\r\n");
      out.write("\t\t\t");
 
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
			
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t<div class=\"c-pagination\">\r\n");
      out.write("\t\t\t");
 
				// Create index of pages 
				int i=0; 
				int cPge=0; 
				if(iTotRslts!=0) { 
					cPge=((int)(Math.ceil((double)iEnRsNo/(iTotSrhRcrds*iSwRws)))); 
					int prePageNo=(cPge*iTotSrhRcrds)-((iTotSrhRcrds-1)+iTotSrhRcrds); 
					if((cPge*iTotSrhRcrds)-(iTotSrhRcrds)>0) { 
			
      out.write(" \r\n");
      out.write("\t\t\t<a href=\"customer.jsp?iPagNo=");
      out.print(prePageNo);
      out.write("&cPagNo=");
      out.print(prePageNo);
      out.write("\"><< Previous</a> \r\n");
      out.write("\t\t\t");
 } 
			for(i=((cPge*iTotSrhRcrds)-(iTotSrhRcrds-1));i<=(cPge*iTotSrhRcrds);i++) { 
				if(i==((iPagNo/iSwRws)+1)) { 
      out.write(" \r\n");
      out.write("\t\t\t\t<a class=\"p-active\" href=\"customer.jsp?iPagNo=");
      out.print(i);
      out.write("\"><strong>");
      out.print(i);
      out.write("</strong></a>\r\n");
      out.write("\t\t\t");
 } 
				else if(i<=iTotPags) { 
      out.write(" \r\n");
      out.write("\t\t\t\t<a class=\"p-noactive\" href=\"customer.jsp?iPagNo=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</a> \r\n");
      out.write("\t\t\t");
 } 
			} 
				if(iTotPags>iTotSrhRcrds&& i<iTotPags) { 
      out.write(" \r\n");
      out.write("\t\t\t\t\t<a href=\"customer.jsp?iPagNo=");
      out.print(i);
      out.write("&cPagNo=");
      out.print(i);
      out.write("\">>> Next</a> \r\n");
      out.write("\t\t\t\t");
 } } 
      out.write(" \r\n");
      out.write("\t\t\t\t\t<b>Rows ");
      out.print(iStRsNo);
      out.write(' ');
      out.write('-');
      out.write(' ');
      out.print(iEnRsNo);
      out.write(" Total Result ");
      out.print(iTotRslts);
      out.write("</b> \r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</table> \r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t");
 try{ if(psPgintn!=null){ psPgintn.close(); } if(rsPgin!=null){ rsPgin.close(); }	if(psRwCn!=null){ psRwCn.close(); } if(rsRwCn!=null){ rsRwCn.close(); } if(con!=null){ con.close(); } } catch(Exception e) { e.printStackTrace(); } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</center>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
