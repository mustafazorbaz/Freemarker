<#if     sutunUc == "adet">${book.adet?right_pad(25," ")}<#rt>
<#elseif sutunUc == "fiyat">${book.fiyat?right_pad(25," ")}<#rt>
<#elseif sutunUc == "urun">${book.urun?right_pad(25," ")}<#rt>
<#elseif sutunUc == "kdv">${book.kdv?right_pad(25," ")}</#if>