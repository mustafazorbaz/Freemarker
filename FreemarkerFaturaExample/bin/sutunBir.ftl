<#if     sutunBir == "adet">${book.adet?right_pad(25," ")}<#rt>
<#elseif sutunBir == "fiyat">${book.fiyat?right_pad(25," ")}<#rt>
<#elseif sutunBir == "urun">${book.urun?right_pad(25," ")}<#rt>
<#elseif sutunBir == "kdv">${book.kdv?right_pad(25," ")}</#if>