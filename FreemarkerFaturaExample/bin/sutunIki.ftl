<#if     sutunIki == "adet">${book.adet?right_pad(25," ")}<#rt>
<#elseif sutunIki == "fiyat">${book.fiyat?right_pad(25," ")}<#rt>
<#elseif sutunIki == "urun">${book.urun?right_pad(25," ")}<#rt>
<#elseif sutunIki == "kdv">${book.kdv?right_pad(25," ")}</#if>