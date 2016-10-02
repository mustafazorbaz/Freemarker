<#list 1..5 as n>
 ${enter}  
</#list>
${ad?left_pad(20," ")}${soyad?left_pad(10," ")}
${adres?left_pad(60," ")}
${il?left_pad(15," ")}/${ulke?left_pad(0," ")}${tarih?left_pad(120," ")}
${ad?left_pad(25," ")} ${soyad?left_pad(5," ")}  adina teslim alinmistir.
${musVD?left_pad(25," ")}${memurKodu?left_pad(60," ")}${musteriKodu?left_pad(30," ")}${kayitNo?left_pad(30," ")}
${no?left_pad(30," ")}
<#if kayitlarList??>
<#assign posicion=0>  <#assign i=0> <#assign diziUzunluk=0> 
<#assign diziUzunluk=araToplamlar?size>
<#list 1..3 as n>
 ${enter}  
</#list>
<#list kayitlarList as fatura>
${fatura.mamulCinsi?left_pad(35," ")}<#rt>
${fatura.yuklemeBirimi?left_pad(10," ")}<#rt>
${fatura.kdv?left_pad(10," ")}<#rt>
${fatura.br?left_pad(10," ")}<#rt>
${fatura.miktar?left_pad(10," ")}<#rt>
${fatura.fiyat?left_pad(10," ")}<#rt>
${fatura.brutTutar?left_pad(10," ")}<#rt>
${fatura.iskontoBir?left_pad(10," ")}<#rt>
${fatura.iskontoIki?left_pad(10," ")}<#rt>
${fatura.iskontoUc?left_pad(10," ")}<#rt>
${fatura.iskontolarTutar?left_pad(10," ")}<#rt>
${fatura.netTutar?left_pad(10," ")}<#rt>

</#list>
<#else>
       No books found
</#if>  
${("Yalniz DortYuzSeksenTL  "?left_pad(30," "))}${("GENEL TOPLAM : "?left_pad(90," "))}${genelToplam?left_pad(25," ")}
