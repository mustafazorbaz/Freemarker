
<html>
<head>
  <title>ASTRON Fatura</title>
</head>
<body>
  <div id="content">
    <table class="datatable">
      <tr>
        <th>Adet</th>
        <th>Ürün</th>
         <th>KDV</th>
        <th>Fiyat</th>
      </tr>
	<#list countries as country>
  	<tr>
  		<td>${country}</td>
  		<td>${country}</td>
  		<td>${country}</td>
  		<td>${country}</td>
  	</tr>
    </#list>	  
    </table>
  </div>
</body>
</html>