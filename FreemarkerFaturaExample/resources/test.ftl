<#if bookList??>
No of books = ${bookList?size}
<#assign posicion=0>   
<#list bookList as book>
<#list sutunlar as sutun><#if     sutun == "adet">${book.adet?right_pad(25," ")}<#elseif sutun == "fiyat">${book.fiyat?right_pad(25," ")}<#elseif sutun == "urun">${book.urun?right_pad(25," ")}<#elseif sutun == "kdv">${book.kdv?right_pad(25," ")}</#if></#list>
<#assign posicion=posicion+1> 
<#if (posicion%sayfadakiKayitAdeti)==0 >
${araToplamlar[0]}
</#if>
</#list>
<#else>
       No books found
</#if>  


