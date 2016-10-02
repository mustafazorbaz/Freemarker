<#if     sutunDort == "adet">${book.adet?right_pad(25," ")}<#rt>
<#elseif sutunDort == "fiyat">${book.fiyat?right_pad(25," ")}<#rt>
<#elseif sutunDort == "urun">${book.urun?right_pad(25," ")}<#rt>
<#elseif sutunDort == "kdv">${book.kdv?right_pad(25," ")}</#if>