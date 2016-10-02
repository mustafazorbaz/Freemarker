<!DOCTYPE
    <html>
<head>
    <title>ASTRON Fatura</title>
</head>
<body>
    <div id="content">
        <#if productsList??>
        <p>Urun Sayisi = ${productsList?size}</p>
        <table border="1" style="margin-top:${ust}px; margin-left:${sol}px;  width:${tabloGenislik}px; height:${tabloYukseklik}px; margin-right:${sag}px; margin-bottom: ${alt}px; ">
            <tr>
                <th>Adet</th>
                <th>Urun</th>
                <th>KDV</th>
                <th>Fiyat</th>
            </tr>
            <#list productsList as product>
            <tr>
                <td>${product.adet}</td>
                <td>${product.urun}</td>
                <td>${product.kdv}</td>
                <td>${product.fiyat}</td>
            </tr>	  	
            </#list>
            <tr>
                <td colspan="4"><center>Toplam</center></td>
            </tr>
        </table>
        <#else>
        No books found
        </#if>
    </div>
</body>
</html>  