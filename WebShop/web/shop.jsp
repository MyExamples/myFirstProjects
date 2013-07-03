<%@page import="java.util.Iterator"%>
<%@page import="logic.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shop.Basket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script language="JavaScript">
            
        </script>
    </head>
    <body>
       <h1 align="center">wEB SHOP!</h1>
        <form action="formURL.htm" method="post" name="NameFormUsers"> 
           <br/>
        <TABLE style="background: skyblue; margin-top: 5px">
		<TR>
                <TH COLSPAN=4>Laptops</TH>
        </TR>
        <TR>  		
		    <ul>
            <TD COLSPAN=2, style="padding: 5px">
			<li>Asus</li> <TD> <a href="addItem?id=2">Add in basket</a> </TD>
			</TD>
		</TR>

        <TR>  		
		    <TD COLSPAN=2, style="padding: 5px">
            <li>Acer</li> <TD> <a href="addItem?id=3">Add in basket</a> </TD>
			</TD>
		</TR>

        <TR>  		
            <TD COLSPAN=2, style="padding: 5px">
			<li>Apple</li> <TD> <a href="addItem?id=4">Add in basket</a> </TD>
			</TD>
		</TR>
        
        <TR>  		
            <TD COLSPAN=2, style="padding: 5px">
			<li>Dell</li> <TD> <a href="addItem?id=5">Add in basket</a> </TD>
			</TD>
	</TR>
        		
            
        </TABLE>

<!--      Корзина: -->

       <center>
	<TABLE style="background: yellow; margin-top: 5px">
		<TR>
                <TH COLSPAN=4>Basket</TH>
        </TR>
        
        <%
        Object b = session.getAttribute("basket");
        Basket basket = new Basket();
        basket = (Basket)b;
        
        ArrayList<Product> listProducts = new ArrayList<Product>();
        String id = request.getParameter("id");
        
               
      //  if (id != null && id.length() != 0) {
        
               
        if(id == null || id.length() == 0){
            %>
            <TR>  		
	    <ul>
            <TD COLSPAN=2, style="padding: 5px">
		  <li>
                   Empty;
                  </li> 
	 	</TD>
	    </TR>
            <%
        }
        else{
        
            listProducts = basket.getlistProducts();
            
            for (int i=0; i<listProducts.size(); i++){  
                                 
     %>
     
                
        <TR>  		
	<ul>
        <TD COLSPAN=2, style="padding: 5px">
		<li>
                <%
                    Product p = listProducts.get(i);
                    out.println(p.getProductName());//PrintWriter out = response.getWriter();
                %>    
                </li> <TD> <a href="removeFromBasket?id=remove&index=<%= i %>">Remove from basket</a> </TD>
	 	</TD>
                
	</TR>
        
        <%
               }//for
             }//else
        %>
        
        
        
        </TABLE>

</center>

<!-- Output -->
<center>
</br>

<input type="submit" value="out" />

<a href="saveOrder">Save Order</a>

</br>
<!--
<a href="openAllOrder">Open All Order</a>
-->

</center>
        </form>
    </body>
</html>
